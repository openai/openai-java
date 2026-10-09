import hashlib
import importlib.util
import io
import json
import os
from pathlib import Path
import tempfile
import unittest
from unittest.mock import Mock, patch
import urllib.error
import zipfile

spec = importlib.util.spec_from_file_location("publisher", Path(__file__).with_name("publish-maven-central.py"))
publisher = importlib.util.module_from_spec(spec)
spec.loader.exec_module(publisher)
DEPLOYMENT = "11111111-1111-4111-8111-111111111111"
PROXY = "https://proxy.example.invalid"


class PublishingTest(unittest.TestCase):
    def setUp(self):
        self.temp = tempfile.TemporaryDirectory()
        self.addCleanup(self.temp.cleanup)
        self.root = Path(self.temp.name)
        self.staging = self.root / "staging"
        self.base = self.staging / "com/openai/openai-java/1.2.3"
        self.base.mkdir(parents=True)
        self.prefix = self.base / "openai-java-1.2.3"
        for suffix in (".jar", ".pom", "-sources.jar", "-javadoc.jar"):
            Path(str(self.prefix) + suffix).write_bytes(b"synthetic")
            Path(str(self.prefix) + suffix + ".asc").write_bytes(b"fake-signature")
        self.manifest = self.root / "digests"
        self.manifest.write_text(hashlib.sha256(b"synthetic").hexdigest() + "  openai-java/build/libs/openai-java-1.2.3.jar\n")

    def bundle(self, **kwargs):
        output = io.BytesIO()
        publisher.bundle(self.staging, output, kwargs.get("version", "1.2.3"),
                         kwargs.get("artifacts", ["openai-java"]), self.manifest)
        return output

    @patch.object(publisher.subprocess, "run", return_value=Mock(returncode=0))
    def test_bundle_inventory_and_signature_checks(self, verify):
        (self.base.parent / "maven-metadata.xml").write_text("repository metadata")
        archive = self.bundle()
        with zipfile.ZipFile(archive) as z:
            self.assertEqual(8, len(z.namelist()))
            self.assertFalse(any("metadata" in name for name in z.namelist()))
        self.assertEqual(4, verify.call_count)
        self.assertTrue(all(call.args[0][:3] == ["gpg", "--batch", "--verify"] for call in verify.call_args_list))

    @patch.object(publisher.subprocess, "run", return_value=Mock(returncode=0))
    def test_tampered_attested_jar_is_rejected(self, _):
        Path(str(self.prefix) + ".jar").write_bytes(b"different")
        with self.assertRaisesRegex(publisher.PublishError, "attested"):
            self.bundle()

    def test_missing_signature_wrong_version_extra_file_and_symlink(self):
        for case in ("missing", "extra", "symlink", "snapshot", "inventory"):
            with self.subTest(case=case), patch.object(publisher.subprocess, "run", return_value=Mock(returncode=0)):
                changed = self.base / "unexpected"
                if case == "missing":
                    changed = Path(str(self.prefix) + ".pom.asc")
                    changed.unlink()
                elif case == "extra":
                    changed.write_text("unexpected")
                elif case == "symlink":
                    changed.symlink_to(self.manifest)
                try:
                    with self.assertRaises(publisher.PublishError):
                        self.bundle(version="1.2.3-SNAPSHOT" if case == "snapshot" else "1.2.3",
                                    artifacts=["openai-java", "openai-java-core"] if case == "inventory" else ["openai-java"])
                finally:
                    if case == "missing":
                        changed.write_bytes(b"fake-signature")
                    elif changed.exists() or changed.is_symlink():
                        changed.unlink()

    @patch.object(publisher.subprocess, "run", return_value=Mock(returncode=1))
    def test_invalid_signature(self, _):
        with self.assertRaisesRegex(publisher.PublishError, "signature"):
            self.bundle()

    @patch.object(publisher.subprocess, "run", return_value=Mock(returncode=0))
    def test_corrupt_checksum_and_unsigned_module(self, _):
        checksum = Path(str(self.prefix) + ".jar.sha256")
        checksum.write_text("0" * 64)
        with self.assertRaisesRegex(publisher.PublishError, "checksum"):
            self.bundle()
        checksum.unlink()
        Path(str(self.prefix) + ".module").write_text("{}")
        with self.assertRaisesRegex(publisher.PublishError, "signature"):
            self.bundle()

    def test_publish_lifecycle_and_streamed_upload(self):
        states = iter(["VALIDATING", "VALIDATED", "PUBLISHING", "PUBLISHED"])
        calls = []
        def request(url, **kw):
            calls.append(url)
            if "/upload?" in url:
                self.assertIn("USER_MANAGED", url)
                body = kw["data"].read()
                self.assertEqual(kw["length"], len(body))
                self.assertIn(b"ZIP-CONTENT", body)
                return DEPLOYMENT.encode()
            if "/status?" in url:
                return json.dumps({"deploymentState": next(states)}).encode()
            return b""
        with patch.object(publisher, "request", side_effect=request), patch.object(publisher, "receipt") as receipt:
            publisher.publish(PROXY, io.BytesIO(b"ZIP-CONTENT"), lambda: "fake-token", sleep=lambda _: None)
        self.assertEqual(1, sum("/upload?" in c for c in calls))
        self.assertEqual(1, sum("/deployment/" in c for c in calls))
        receipt.assert_any_call("Maven Central deployment ID: " + DEPLOYMENT)

    def test_ambiguous_upload_is_never_retried(self):
        with patch.object(publisher, "request", side_effect=publisher.PublishError("HTTP 502")) as request, patch.object(publisher, "receipt"):
            with self.assertRaisesRegex(publisher.PublishError, "outcome unknown"):
                publisher.publish(PROXY, io.BytesIO(b"fake"), lambda: "fake-token")
        self.assertEqual(1, request.call_count)

    def test_failed_validation_never_publishes(self):
        with patch.object(publisher, "request", side_effect=[DEPLOYMENT.encode(), b'{"deploymentState":"FAILED"}']) as request, patch.object(publisher, "receipt"):
            with self.assertRaisesRegex(publisher.PublishError, "validation failed"):
                publisher.publish(PROXY, io.BytesIO(b"fake"), lambda: "fake-token")
        self.assertEqual(2, request.call_count)

    def test_poll_timeout_preserves_id_without_second_upload(self):
        with patch.object(publisher, "request", return_value=DEPLOYMENT.encode()) as request, patch.object(publisher, "receipt") as receipt:
            with self.assertRaisesRegex(publisher.PublishError, "polling timed out"):
                publisher.publish(PROXY, io.BytesIO(b"fake"), lambda: "fake-token", clock=Mock(side_effect=[0, 901]))
        self.assertEqual(1, request.call_count)
        receipt.assert_any_call("Maven Central deployment ID: " + DEPLOYMENT)

    def test_reject_insecure_and_nonorigin_proxy_urls(self):
        for url in ("http://proxy.invalid", "https://user:pass@proxy.invalid", PROXY + "/path", PROXY + "?query", PROXY + "#fragment"):
            with self.subTest(url=url), patch.object(publisher, "request") as request:
                with self.assertRaises(publisher.PublishError):
                    publisher.publish(url, io.BytesIO(), lambda: "fake")
                request.assert_not_called()

    def test_no_redirect_and_sanitized_http_errors(self):
        self.assertIsNone(publisher.NoRedirect().redirect_request(None, None, 307, "", {}, PROXY))
        opener = Mock()
        opener.open.side_effect = urllib.error.HTTPError(PROXY, 503, "fake-secret", {}, io.BytesIO(b"fake-secret"))
        with patch.object(publisher.urllib.request, "build_opener", return_value=opener):
            with self.assertRaises(publisher.PublishError) as error:
                publisher.request(PROXY, token="fake-secret")
        self.assertNotIn("fake-secret", str(error.exception))

    def test_oidc_exchange_and_refresh(self):
        env = {"MAVEN_CENTRAL_AZURE_TENANT_ID": DEPLOYMENT, "MAVEN_CENTRAL_AZURE_CLIENT_ID": DEPLOYMENT,
               "MAVEN_CENTRAL_AZURE_RESOURCE": "api://fake-resource", "ACTIONS_ID_TOKEN_REQUEST_URL": "https://pipelines.actions.githubusercontent.com/token?audience=old",
               "ACTIONS_ID_TOKEN_REQUEST_TOKEN": "fake-github-token"}
        def response(url, **kw):
            if "actions.githubusercontent.com" in url:
                self.assertIn("audience=api%3A%2F%2FAzureADTokenExchange", url)
                self.assertNotIn("audience=old", url)
                return b'{"value":"fake-assertion"}'
            self.assertEqual("", kw["token"])
            self.assertIn(b"client_assertion=fake-assertion", kw["data"])
            self.assertIn(b"scope=api%3A%2F%2Ffake-resource%2F.default", kw["data"])
            return b'{"access_token":"fake-entra-token","expires_in":3600}'
        with patch.dict(os.environ, env), patch.object(publisher, "request", side_effect=response) as request, patch.object(publisher.time, "monotonic", return_value=100) as clock:
            token = publisher.EntraToken()
            self.assertEqual("fake-entra-token", token())
            token()
            self.assertEqual(2, request.call_count)
            clock.return_value = 3700
            token()
            self.assertEqual(4, request.call_count)

    def test_workflow_keeps_vendor_secrets_out_of_proxy_steps(self):
        workflow = Path(__file__).parents[1].joinpath("workflows/create-releases.yml").read_text()
        legacy = workflow.split("- name: Publish to Maven Central\n")[1].split("- name:")[0]
        proxy = workflow.split("- name: Stage signed Maven artifacts for auth proxy\n")[1].split("- name: Verify attested Maven artifacts")[0]
        self.assertIn("if: vars.MAVEN_CENTRAL_AUTH_PROXY_URL == ''", legacy)
        self.assertEqual(2, proxy.count("if: vars.MAVEN_CENTRAL_AUTH_PROXY_URL != ''"))
        self.assertNotIn("OPENAI_SONATYPE_USERNAME", proxy)
        self.assertNotIn("OPENAI_SONATYPE_PASSWORD", proxy)
        self.assertIn('"${publish_exclusions[@]}"', proxy)
        self.assertIn('sha256sum --check "$RUNNER_TEMP/maven-artifact-provenance.sha256"', proxy)
        self.assertLess(workflow.index('install -m 700 .github/scripts/publish-maven-central.py'), workflow.index('ref: ${{ needs.release.outputs.source_sha }}', workflow.index('- name: Check out workflow scripts')))


if __name__ == "__main__":
    unittest.main()
