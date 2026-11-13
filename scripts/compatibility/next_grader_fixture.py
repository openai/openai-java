"""Migrate the archived grader caller across the Java next token-usage transition."""

import json
import os
from pathlib import Path
import subprocess
import sys


CORE = Path("openai-java-core")
PACKAGE = Path("com/openai/models/finetuning/alpha/graders")
MODEL = CORE / "src/main/kotlin" / PACKAGE / "GraderRunResponse.kt"
TEST = CORE / "src/test/kotlin" / PACKAGE / "GraderRunResponseTest.kt"
ARCHIVE = CORE / "build/api-compatibility-source"
PATCH = "scripts/compatibility/next-grader-token-usage.patch"
OLD_MODEL = "ade599846c7d6ab6a68a381d8c9a4c23a45065ee"
NEW_MODEL = "2d2f23333596399f6a81c82f5fff43096ab805fa"
OLD_TEST = "121d551ceecec07af8b732c4bb381ada565798af"
NEW_TEST = "e8557403f71729ec0f52548419d1fe4437aeb9ce"


def git(*args):
    return subprocess.check_output(["git", *args])


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
    if git("hash-object", "--no-filters", MODEL).decode().strip() != NEW_MODEL:
        return
    if git("rev-parse", f"{base}:{MODEL}").decode().strip() != OLD_MODEL:
        return

    staged = ARCHIVE / TEST
    if staged.resolve(strict=True) != Path.cwd() / staged or staged.stat().st_nlink != 1:
        raise ValueError(f"Expected an unlinked archived fixture: {staged}")
    if git("rev-parse", f"{base}:{TEST}").decode().strip() != OLD_TEST or (
        git("hash-object", "--no-filters", staged).decode().strip() != OLD_TEST
    ):
        raise ValueError(f"Unexpected archived grader fixture: {staged}")
    patch = git("show", f"{base}:{PATCH}")
    subprocess.run(["git", "apply", f"--directory={ARCHIVE}", "-"], input=patch, check=True)
    if git("hash-object", "--no-filters", staged).decode().strip() != NEW_TEST:
        raise ValueError(f"Unexpected migrated grader fixture: {staged}")


if __name__ == "__main__":
    migrate(sys.argv[1])
