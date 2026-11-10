"""Keep the three historical compaction assertions when Java next changes their types."""

import json
import os
import subprocess
import sys
from pathlib import Path


MODEL = "openai-java-core/src/main/kotlin/com/openai/models/responses/CompactedResponse.kt"
PATCH = "scripts/compatibility/next-compaction-assertions.patch"
STAGED = Path("openai-java-core/build/api-compatibility-source")


def targets_next():
    event = os.environ.get("GITHUB_EVENT_NAME")
    if event == "pull_request":
        return os.environ.get("GITHUB_BASE_REF") == "next"
    if event == "merge_group":
        payload = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text())
        return payload["merge_group"]["base_ref"] == "refs/heads/next"
    return False


def migrate(base):
    if not targets_next() or not Path(MODEL).is_file():
        return
    if "fun output(): List<ResponseItem>" not in Path(MODEL).read_text():
        return
    previous = subprocess.check_output(["git", "show", f"{base}:{MODEL}"])
    if b"fun output(): List<ResponseOutputItem>" not in previous:
        return

    if STAGED.resolve(strict=True) != Path.cwd() / STAGED:
        raise ValueError(f"Expected a temporary fixture directory without symlinks: {STAGED}")
    patch = subprocess.check_output(["git", "show", f"{base}:{PATCH}"])
    # git apply rejects symlinks in a patched path and fails if the context changed.
    subprocess.run(["git", "apply", f"--directory={STAGED}", "-"], input=patch, check=True)


if __name__ == "__main__":
    migrate(sys.argv[1])
