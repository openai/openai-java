#!/usr/bin/env python3
"""Publish signed staging output through an OIDC-authenticated credential proxy."""

import hashlib
import json
import os
from pathlib import Path
import re
import shutil
import subprocess
import tempfile
import time
import urllib.error
import urllib.parse
import urllib.request
import uuid
import zipfile


class PublishError(Exception):
    pass


class NoRedirect(urllib.request.HTTPRedirectHandler):
    def redirect_request(self, req, fp, code, msg, headers, newurl):
        return None


def https_url(url):
    parsed = urllib.parse.urlsplit(url)
    if (parsed.scheme != "https" or not parsed.hostname or parsed.username
            or parsed.password or parsed.fragment):
        raise PublishError("Expected an HTTPS URL without userinfo or fragment")
    return parsed


def request(url, *, token, data=None, content_type=None, length=None):
    https_url(url)
    headers = {"Authorization": "Bearer " + token} if token else {}
    if content_type:
        headers["Content-Type"] = content_type
    if length is not None:
        headers["Content-Length"] = str(length)
    req = urllib.request.Request(url, data=data, headers=headers)
    # A credential-bearing redirect must never be followed. Do not expose raw
    # upstream error bodies: vendor responses can contain sensitive diagnostics.
    opener = urllib.request.build_opener(NoRedirect())
    try:
        with opener.open(req, timeout=120) as response:
            return response.read()
    except urllib.error.HTTPError as error:
        raise PublishError(f"Publishing request returned HTTP {error.code}; body suppressed") from None
    except (OSError, urllib.error.URLError):
        raise PublishError("Publishing transport failed; reconcile before retrying") from None


class EntraToken:
    def __init__(self):
        self.tenant = str(uuid.UUID(os.environ["MAVEN_CENTRAL_AZURE_TENANT_ID"]))
        self.client = str(uuid.UUID(os.environ["MAVEN_CENTRAL_AZURE_CLIENT_ID"]))
        self.resource = os.environ["MAVEN_CENTRAL_AZURE_RESOURCE"]
        if not self.resource or self.resource.endswith("/.default"):
            raise PublishError("Set the Azure resource identifier, without /.default")
        self.value, self.expires = "", 0

    def __call__(self):
        if self.expires > time.monotonic() + 60:
            return self.value
        endpoint = os.environ["ACTIONS_ID_TOKEN_REQUEST_URL"]
        parsed = https_url(endpoint)
        if not parsed.hostname.endswith(".actions.githubusercontent.com"):
            raise PublishError("Unexpected GitHub OIDC endpoint")
        query = urllib.parse.parse_qsl(parsed.query)
        query = [(k, v) for k, v in query if k != "audience"]
        query.append(("audience", "api://AzureADTokenExchange"))
        endpoint = urllib.parse.urlunsplit(parsed._replace(query=urllib.parse.urlencode(query)))
        assertion = json.loads(request(endpoint, token=os.environ["ACTIONS_ID_TOKEN_REQUEST_TOKEN"]))["value"]
        form = urllib.parse.urlencode({
            "client_id": self.client,
            "scope": self.resource.rstrip("/") + "/.default",
            "grant_type": "client_credentials",
            "client_assertion_type": "urn:ietf:params:oauth:client-assertion-type:jwt-bearer",
            "client_assertion": assertion,
        }).encode()
        # Entra authenticates the assertion in the form, not an Authorization header.
        value = json.loads(request(
            f"https://login.microsoftonline.com/{self.tenant}/oauth2/v2.0/token",
            token="", data=form, content_type="application/x-www-form-urlencoded"))
        self.value = value["access_token"]
        lifetime = int(value["expires_in"])
        if not self.value or lifetime <= 0:
            raise PublishError("Entra returned an unusable access token")
        self.expires = time.monotonic() + lifetime
        return self.value


def bundle(staging, output, version, artifacts, provenance):
    """Whitelist release entries and check staged JARs against attested JAR hashes."""
    if staging.is_symlink() or not staging.is_dir():
        raise PublishError("Expected a real staging directory")
    if not re.fullmatch(r"[0-9]+\.[0-9]+\.[0-9]+(?:-[0-9A-Za-z.-]+)?", version) or version.endswith("-SNAPSHOT"):
        raise PublishError("Expected a non-SNAPSHOT release version")
    if not artifacts or len(set(artifacts)) != len(artifacts):
        raise PublishError("Expected distinct release artifacts")
    digests = {}
    for line in provenance.read_text().splitlines():
        digest, path = line.split("  ", 1)
        if not re.fullmatch(r"[0-9a-f]{64}", digest) or path in digests:
            raise PublishError("Invalid provenance digest manifest")
        digests[path] = digest
    required, allowed, jars = set(), set(), {}
    for artifact in artifacts:
        if not re.fullmatch(r"openai-java(?:-[a-z0-9-]+)?", artifact):
            raise PublishError("Unexpected Maven artifact name")
        prefix = f"com/openai/{artifact}/{version}/{artifact}-{version}"
        for suffix in (".jar", ".pom", "-sources.jar", "-javadoc.jar", ".module"):
            name = prefix + suffix
            if suffix != ".module":
                required.update((name, name + ".asc"))
            for signature in ("", ".asc"):
                allowed.add(name + signature)
                allowed.update(name + signature + "." + alg for alg in ("md5", "sha1", "sha256", "sha512"))
        jars[prefix + ".jar"] = f"{artifact}/build/libs/{artifact}-{version}.jar"
    if set(digests) != set(jars.values()):
        raise PublishError("Provenance manifest does not match release artifact inventory")
    files = {}
    for path in staging.rglob("*"):
        if path.is_symlink():
            raise PublishError("Symlinks are not allowed in release staging")
        if path.is_file():
            name = path.relative_to(staging).as_posix()
            if path.name.startswith("maven-metadata.xml"):
                continue
            if name not in allowed or path.stat().st_size == 0:
                raise PublishError("Unexpected or empty staged artifact")
            files[name] = path
    if not required.issubset(files):
        raise PublishError("Missing signed release artifact")
    for name, path in files.items():
        algorithm = path.suffix.removeprefix(".")
        if algorithm in {"md5", "sha1", "sha256", "sha512"}:
            original = path.with_suffix("")
            if not original.is_file():
                raise PublishError("Checksum has no corresponding artifact")
            with original.open("rb") as stream:
                if hashlib.file_digest(stream, algorithm).hexdigest() != path.read_text().strip().lower():
                    raise PublishError("Staged artifact checksum verification failed")
        elif not name.endswith(".asc") and name + ".asc" not in files:
            raise PublishError("Missing artifact signature")
        if name in jars:
            with path.open("rb") as stream:
                if hashlib.file_digest(stream, "sha256").hexdigest() != digests[jars[name]]:
                    raise PublishError("Staged JAR differs from attested JAR")
        if name.endswith(".asc"):
            result = subprocess.run(["gpg", "--batch", "--verify", str(path), str(path.with_suffix(""))],
                                    stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            if result.returncode:
                raise PublishError("Staged artifact signature verification failed")
    with zipfile.ZipFile(output, "w", zipfile.ZIP_DEFLATED, allowZip64=True) as archive:
        for name, path in sorted(files.items()):
            archive.write(path, name)


def receipt(message):
    print(message, flush=True)
    if os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(os.environ["GITHUB_STEP_SUMMARY"], "a") as summary:
            summary.write(message + "\n\n")


def publish(origin, archive, token, *, clock=time.monotonic, sleep=time.sleep):
    parsed = https_url(origin)
    if parsed.path not in ("", "/") or parsed.query:
        raise PublishError("Proxy URL must be an HTTPS origin")
    base = origin.rstrip("/") + "/api/v1/publisher"
    # Streaming multipart from a temporary file avoids keeping release ZIPs in RAM.
    with tempfile.TemporaryFile() as body:
        boundary = uuid.uuid4().hex
        body.write((f'--{boundary}\r\nContent-Disposition: form-data; name="bundle"; filename="bundle.zip"\r\n'
                    'Content-Type: application/octet-stream\r\n\r\n').encode())
        archive.seek(0)
        shutil.copyfileobj(archive, body)
        body.write(f"\r\n--{boundary}--\r\n".encode())
        length = body.tell()
        body.seek(0)
        credential = token()
        receipt("Submitting Maven bundle. If no deployment ID follows, inspect Central Portal before retrying.")
        try:
            raw = request(base + "/upload?publishingType=USER_MANAGED", token=credential,
                          data=body, length=length, content_type="multipart/form-data; boundary=" + boundary)
            deployment = str(uuid.UUID(raw.decode().strip()))
        except (PublishError, ValueError, UnicodeError):
            raise PublishError("Upload outcome unknown. Inspect Central Portal; do not automatically resubmit.") from None
    receipt("Maven Central deployment ID: " + deployment)
    deadline, released = clock() + 15 * 60, False
    while clock() < deadline:
        state = json.loads(request(base + "/status?id=" + deployment, token=token(), data=b""))["deploymentState"]
        if state == "PUBLISHED":
            return
        if state == "VALIDATED" and not released:
            request(base + "/deployment/" + deployment, token=token(), data=b"")
            released = True
        elif state not in {"PENDING", "VALIDATING", "VALIDATED", "PUBLISHING"}:
            raise PublishError("Central validation failed or returned an unknown state; inspect the deployment ID")
        sleep(5)
    raise PublishError("Central polling timed out; inspect the recorded deployment ID before retrying")


def main():
    token = EntraToken()
    with tempfile.TemporaryFile() as archive:
        bundle(Path("build/auth-proxy-staging"), archive, os.environ["RELEASE_TAG"].removeprefix("v"),
               os.environ["MAVEN_ARTIFACTS"].split(), Path(os.environ["RUNNER_TEMP"]) / "maven-artifact-provenance.sha256")
        archive.seek(0)
        receipt("Maven bundle SHA-256: " + hashlib.file_digest(archive, "sha256").hexdigest())
        publish(os.environ["MAVEN_CENTRAL_AUTH_PROXY_URL"], archive, token)


if __name__ == "__main__":
    try:
        main()
    except PublishError as error:
        raise SystemExit("::error::" + str(error)) from None
    except Exception:
        # Never print raw token responses, request objects or exception tracebacks.
        raise SystemExit("::error::Publishing failed. Inspect the deployment receipt and configuration before retrying.") from None
