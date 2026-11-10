"""Keep the three historical compaction assertions when Java next changes their types."""

import json
import os
import subprocess
import sys
from pathlib import Path


MODEL = "openai-java-core/src/main/kotlin/com/openai/models/responses/CompactedResponse.kt"
PATCH = "scripts/compatibility/next-compaction-assertions.patch"
GETTER_PATCH = "scripts/compatibility/next-compaction-getter-assertions.patch"
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
    current = Path(MODEL).read_text()
    if "fun output(): List<ResponseItem>" in current:
        accessor, patch_path = "output", PATCH
    elif "fun outputOrThrow(): List<ResponseItem>" in current:
        accessor, patch_path = "outputOrThrow", GETTER_PATCH
    else:
        return
    previous = subprocess.check_output(["git", "show", f"{base}:{MODEL}"], text=True)
    if f"fun {accessor}(): List<ResponseOutputItem>" not in previous:
        return

    if STAGED.resolve(strict=True) != Path.cwd() / STAGED:
        raise ValueError(f"Expected a temporary fixture directory without symlinks: {STAGED}")
    patch = subprocess.check_output(["git", "show", f"{base}:{patch_path}"])
    # git apply rejects symlinks in a patched path and fails if the context changed.
    subprocess.run(["git", "apply", f"--directory={STAGED}", "-"], input=patch, check=True)


if __name__ == "__main__":
    migrate(sys.argv[1])
