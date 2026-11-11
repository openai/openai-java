"""Adapt archived Kotlin callers across the required getter transition on Java next."""

import hashlib
import json
import os
from pathlib import Path
import subprocess
import sys


CORE = Path("openai-java-core")
MODEL = CORE / "src/main/kotlin/com/openai/models/chat/completions/ChatCompletion.kt"
STAGED = CORE / "build/api-compatibility-source"
PATCH = "scripts/compatibility/next-getter-callers.patch"
OLD = 'fun id(): String = id.getRequired("id")'
NEW = 'fun idOrThrow(): String = id.getRequired("id")'


# This exact alternate pair includes the preceding archived Realtime factory rename.
REALTIME_FIXTURE = CORE / "src/test/kotlin/com/openai/models/realtime/SessionUpdateEventTest.kt"
REALTIME_RENAMED = "7e77acab7057c073da87cf5b2aa1e17c6643cf09"
REALTIME_RENAMED_GETTER = "b9385d69159a8762f4b437dd6f615a2d3b3eb271"


def targets_next():
    event = os.environ.get("GITHUB_EVENT_NAME")
    if event == "pull_request":
        return os.environ.get("GITHUB_BASE_REF") == "next"
    if event == "merge_group":
        payload = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text())
        return payload["merge_group"]["base_ref"] == "refs/heads/next"
    return False


def blob_id(data):
    return hashlib.sha1(f"blob {len(data)}\0".encode() + data).hexdigest()


def migrate(base):
    if not targets_next() or not MODEL.is_file():
        return
    current = MODEL.read_text()
    if OLD in current or NEW not in current:
        return
    previous = subprocess.check_output(["git", "show", f"{base}:{MODEL}"], text=True)
    if OLD not in previous or NEW in previous:
        return

    patch = subprocess.check_output(["git", "show", f"{base}:{PATCH}"])
    outputs = {}
    lines = patch.decode().splitlines()
    for i, line in enumerate(lines):
        if line.startswith("diff --git "):
            path = STAGED / line.split()[2][2:]
            old, new = lines[i + 1].split()[1].split("..")
            if path.resolve(strict=True) != Path.cwd() / path or path.stat().st_nlink != 1:
                raise ValueError(f"Unexpected archived getter fixture: {path}")
            actual = blob_id(path.read_bytes())
            if path == STAGED / REALTIME_FIXTURE and actual == REALTIME_RENAMED:
                new = REALTIME_RENAMED_GETTER
            elif actual != old:
                raise ValueError(f"Unexpected archived getter fixture: {path}")
            outputs[path] = new
    subprocess.run(["git", "apply", f"--directory={STAGED}", "-"], input=patch, check=True)
    for path, expected in outputs.items():
        if blob_id(path.read_bytes()) != expected:
            raise ValueError(f"Unexpected migrated getter fixture: {path}")


if __name__ == "__main__":
    migrate(sys.argv[1])
