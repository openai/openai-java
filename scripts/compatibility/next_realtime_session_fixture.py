"""Compile the historical Realtime event test across the Java next factory rename."""

import json
import os
import subprocess
import sys
from pathlib import Path


CORE = Path("openai-java-core")
MODEL = CORE / "src/main/kotlin/com/openai/models/realtime/SessionUpdateEvent.kt"
FIXTURE = CORE / "src/test/kotlin/com/openai/models/realtime/SessionUpdateEventTest.kt"
STAGED = CORE / "build/api-compatibility-source" / FIXTURE
OLD_FACTORY = b"fun ofRealtimeSessionCreateRequest("
NEW_FACTORY = b"fun ofRealtime(realtime: RealtimeSessionCreateRequest)"
OLD_CALL = b"\n                SessionUpdateEvent.Session.ofRealtimeSessionCreateRequest(\n"
NEW_CALL = b"\n                SessionUpdateEvent.Session.ofRealtime(\n"


def targets_next():
    event = os.environ.get("GITHUB_EVENT_NAME")
    if event == "pull_request":
        return os.environ.get("GITHUB_BASE_REF") == "next"
    if event == "merge_group":
        payload = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text())
        return payload["merge_group"]["base_ref"] == "refs/heads/next"
    return False


def migrate(base):
    if not targets_next() or not MODEL.is_file():
        return
    current = MODEL.read_bytes()
    if NEW_FACTORY not in current or OLD_FACTORY in current:
        return
    previous = subprocess.check_output(["git", "show", f"{base}:{MODEL}"])
    if OLD_FACTORY not in previous or NEW_FACTORY in previous:
        return

    if STAGED.resolve(strict=True) != Path.cwd() / STAGED or STAGED.stat().st_nlink != 1:
        raise ValueError(f"Expected an unlinked archived fixture: {STAGED}")
    fixture = subprocess.check_output(["git", "show", f"{base}:{FIXTURE}"])
    if STAGED.read_bytes() != fixture or fixture.count(OLD_CALL) != 1:
        raise ValueError(f"Expected the archived fixture with exactly one old factory call: {STAGED}")
    STAGED.write_bytes(fixture.replace(OLD_CALL, NEW_CALL))


if __name__ == "__main__":
    migrate(sys.argv[1])
