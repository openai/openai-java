import json
import os
import shutil
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from next_compaction_fixtures import GETTER_PATCH, MODEL, PATCH, STAGED


POLICY = Path(__file__).with_name("next_compaction_fixtures.py")
MODELS = Path("openai-java-core/src/test/kotlin/com/openai/models")
OLD = "fun output(): List<ResponseOutputItem>"
NEW = "fun output(): List<ResponseItem>"


def compact_fixture(prefix, variable):
    return f"""package fixture

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper

        assertThat({variable}.createdAt()).isEqualTo(0L)
        assertThat({variable}.output())
            .containsExactly(
                {prefix}ResponseOutputItem.ofMessage(
                    {prefix}ResponseOutputMessage.builder()
                        .id("expected_id").build()
                )
            )
"""


FIXTURES = {
    MODELS / "responses/CompactedResponseTest.kt": compact_fixture("", "compactedResponse"),
    MODELS / "beta/responses/BetaCompactedResponseTest.kt": compact_fixture("Beta", "betaCompactedResponse"),
    MODELS / "responses/ResponseInputItemTest.kt": """\
        assertThat(responseInputItem.customToolCall()).isEmpty
        assertThat(responseInputItem.compactionTrigger())
            .contains(JsonValue.from(mapOf("type" to "compaction_trigger")))
        assertThat(responseInputItem.itemReference()).isEmpty
""",
}


class NextCompactionFixturesTest(unittest.TestCase):
    def setUp(self):
        temp = tempfile.TemporaryDirectory()
        self.addCleanup(temp.cleanup)
        self.repo = Path(temp.name)
        self.model = self.repo / MODEL
        self.model.parent.mkdir(parents=True)
        self.model.write_text(OLD)
        patch = self.repo / PATCH
        patch.parent.mkdir(parents=True)
        for name in (PATCH, GETTER_PATCH):
            shutil.copyfile(POLICY.with_name(Path(name).name), self.repo / name)
        self.git("init", "-q")
        self.git("add", "--", MODEL, PATCH, GETTER_PATCH)
        self.git("-c", "user.name=Test", "-c", "user.email=test@example.com", "commit", "-qm", "Trusted base")
        self.model.write_text(NEW)
        # A proposed patch must never supply the migration applied to the archived sources.
        patch.write_text("invalid proposed patch")
        for path, text in FIXTURES.items():
            for root in (self.repo, self.repo / STAGED, self.repo / STAGED / "proposed"):
                (root / path).parent.mkdir(parents=True, exist_ok=True)
                (root / path).write_text(text)

    def git(self, *args):
        subprocess.run(["git", *args], cwd=self.repo, check=True)

    def run_policy(self, event="pull_request", branch="next", queue="main"):
        payload = self.repo / "event.json"
        payload.write_text(json.dumps({"merge_group": {"base_ref": f"refs/heads/{queue}"}}))
        env = dict(os.environ, GITHUB_EVENT_NAME=event, GITHUB_BASE_REF=branch, GITHUB_EVENT_PATH=str(payload))
        return subprocess.run(
            [sys.executable, "-I", str(POLICY.resolve()), "HEAD"],
            cwd=self.repo,
            env=env,
            capture_output=True,
            text=True,
        )

    def test_migrates_only_archived_baseline_assertions(self):
        result = self.run_policy("merge_group", "main", "next")
        self.assertEqual(result.returncode, 0, result.stderr)
        for path, original in FIXTURES.items():
            staged = (self.repo / STAGED / path).read_text()
            self.assertIn(".map { JsonValue.from(it) }", staged)
            if "CompactedResponseTest" in path.name:
                self.assertIn('.id("expected_id").build()', staged)
                self.assertIn(".containsExactly(\n                JsonValue.from(", staged)
            else:
                self.assertIn('.contains(JsonValue.from(mapOf("type" to "compaction_trigger")))', staged)
            for root in (self.repo, self.repo / STAGED / "proposed"):
                self.assertEqual((root / path).read_text(), original)

    def test_getter_transition_preserves_all_three_assertions(self):
        self.model.write_text("fun outputOrThrow(): List<ResponseOutputItem>")
        self.git("-c", "user.name=Test", "-c", "user.email=test@example.com", "commit", "-qm", "Getter baseline", "--", MODEL)
        fixtures = self.repo / STAGED
        for path, original in FIXTURES.items():
            (fixtures / path).write_text(
                original.replace("createdAt()).isEqualTo(0L)", "createdAt()).contains(0L)")
                .replace(".output())", ".output().getOrNull())")
            )
        self.assertEqual(self.run_policy().returncode, 0)
        for path in FIXTURES:
            self.assertNotIn(".map { JsonValue.from(it) }", (fixtures / path).read_text())
        self.model.write_text("fun outputOrThrow(): List<ResponseItem>")
        (self.repo / GETTER_PATCH).write_text("invalid proposed patch")
        result = self.run_policy()
        self.assertEqual(result.returncode, 0, result.stderr)
        for path, original in FIXTURES.items():
            staged = (fixtures / path).read_text()
            if "CompactedResponseTest" in path.name:
                self.assertIn(".outputOrThrow().map { JsonValue.from(it) }", staged)
                self.assertIn('.id("expected_id").build()', staged)
                self.assertIn(".containsExactly(\n                JsonValue.from(", staged)
            else:
                self.assertIn("compactionTrigger().map { JsonValue.from(it) }", staged)
                self.assertIn('.contains(JsonValue.from(mapOf("type" to "compaction_trigger")))', staged)
            for root in (self.repo, fixtures / "proposed"):
                self.assertEqual((root / path).read_text(), original)

    def test_skips_other_targets_and_unchanged_sdk(self):
        for event, branch, queue, model in (
            ("pull_request", "main", "next", NEW),
            ("merge_group", "next", "main", NEW),
            ("push", "next", "next", NEW),
            ("pull_request", "next", "main", OLD),
        ):
            with self.subTest(event=event, branch=branch, model=model):
                self.model.write_text(model)
                result = self.run_policy(event, branch, queue)
                self.assertEqual(result.returncode, 0, result.stderr)
                for path, original in FIXTURES.items():
                    self.assertEqual((self.repo / STAGED / path).read_text(), original)

    def test_skips_a_baseline_that_already_has_typed_output(self):
        self.git("add", "--", MODEL)
        self.git("-c", "user.name=Test", "-c", "user.email=test@example.com", "commit", "-qm", "Typed baseline")
        result = self.run_policy()
        self.assertEqual(result.returncode, 0, result.stderr)
        for path, original in FIXTURES.items():
            self.assertEqual((self.repo / STAGED / path).read_text(), original)

    def test_rejects_redirected_fixture_directory(self):
        path = MODELS / "responses"
        shutil.rmtree(self.repo / STAGED / path)
        (self.repo / STAGED / path).symlink_to(self.repo / path, target_is_directory=True)
        self.assertNotEqual(self.run_policy().returncode, 0)
        for path, original in FIXTURES.items():
            self.assertEqual((self.repo / path).read_text(), original)
