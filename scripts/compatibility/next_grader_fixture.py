"""Migrate archived grader callers across exact Java next transitions."""

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


def migrate_fixture(base, model, old_model, new_model, test, old_test, new_test, patch_path):
    if not model.is_file():
        return
    if git("hash-object", "--no-filters", model).decode().strip() != new_model:
        return
    if git("rev-parse", f"{base}:{model}").decode().strip() != old_model:
        return
    if model.resolve(strict=True) != Path.cwd() / model or model.stat().st_nlink != 1:
        raise ValueError(f"Expected an unlinked grader model: {model}")

    staged = ARCHIVE / test
    if staged.resolve(strict=True) != Path.cwd() / staged or staged.stat().st_nlink != 1:
        raise ValueError(f"Expected an unlinked archived fixture: {staged}")
    if git("rev-parse", f"{base}:{test}").decode().strip() != old_test or (
        git("hash-object", "--no-filters", staged).decode().strip() != old_test
    ):
        raise ValueError(f"Unexpected archived grader fixture: {staged}")
    patch = git("show", f"{base}:{patch_path}")
    subprocess.run(
        ["git", "apply", f"--include={staged}", f"--directory={ARCHIVE}", "-"],
        input=patch,
        check=True,
    )
    if git("hash-object", "--no-filters", staged).decode().strip() != new_test:
        raise ValueError(f"Unexpected migrated grader fixture: {staged}")


def migrate(base):
    if not targets_next():
        return
    migrate_fixture(base, MODEL, OLD_MODEL, NEW_MODEL, TEST, OLD_TEST, NEW_TEST, PATCH)
    package = Path("com/openai/models/graders/gradermodels")
    migrate_fixture(
        base,
        CORE / "src/main/kotlin" / package / "MultiGrader.kt",
        "5a637206a1f9363d3643852ca92a0e5c91b7800d",
        "b05d6b55c8f58d72afc5fbba85741fea6c07df42",
        CORE / "src/test/kotlin" / package / "MultiGraderTest.kt",
        "69678a4e8207401bc0070520a8abb3ac4b502667",
        "0487b66bf309cdcde6ced61f5da204c7dca0236d",
        "scripts/compatibility/next-multi-grader-map.patch",
    )


if __name__ == "__main__":
    migrate(sys.argv[1])
