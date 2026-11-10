import json
import os
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path


POLICY = Path(__file__).with_name("next_trigger_predicate.py").resolve()
MODEL = Path("openai-java-core/src/main/kotlin/com/openai/models/live/DecisionQuestion.kt")
GENERATED = Path("openai-java-core/src/test/kotlin/com/openai/models/live/SessionConfigTest.kt")
CURATED = Path("openai-java-core/src/apiCompatibility/kotlin/com/openai/models/live/ClientEventCompatibility.kt")
CALL = (
    b"val predicate = DecisionTrigger.Decisions.Question.Predicate.builder()\r\n"
    b'    .instructions("instructions").name("name").build()\r\n'
    b"assertThat(builder.addQuestion(predicate)).isNotNull()\r\n"
    b"val other = OtherDecisionTrigger.Decisions.Question.Predicate.builder()\r\n"
)
MIGRATED = CALL.replace(b"= DecisionTrigger.Decisions.Question.", b"= com.openai.models.live.DecisionQuestion.")


class NextTriggerPredicateTest(unittest.TestCase):
    def check_migration(self, event, pull_base, queue_base, model_present, should_migrate):
        with tempfile.TemporaryDirectory() as directory:
            repo = Path(directory)
            copies = repo / "compiler-inputs"
            unlisted = GENERATED.with_name("UnrelatedTest.kt")
            for root in (repo, copies, copies / "proposed"):
                for relative in (GENERATED, CURATED, unlisted):
                    path = root / relative
                    path.parent.mkdir(parents=True, exist_ok=True)
                    path.write_bytes(CALL)
            if model_present:
                (repo / MODEL).parent.mkdir(parents=True)
                (repo / MODEL).touch()
            payload = repo / "event.json"
            payload.write_text(json.dumps({"merge_group": {"base_ref": f"refs/heads/{queue_base}"}}))
            subprocess.run(
                [sys.executable, str(POLICY), str(copies)],
                cwd=repo,
                env=dict(os.environ, GITHUB_EVENT_NAME=event, GITHUB_BASE_REF=pull_base, GITHUB_EVENT_PATH=str(payload)),
                check=True,
            )
            for root in (repo, copies, copies / "proposed"):
                for relative in (GENERATED, CURATED, unlisted):
                    expected = MIGRATED if should_migrate and root != repo and relative != unlisted else CALL
                    self.assertEqual((root / relative).read_bytes(), expected)

    def test_only_next_with_the_shared_model_migrates(self):
        for event, pull, queue, model, expected in (
            ("pull_request", "next", "main", True, True),
            ("pull_request", "next", "next", False, False),
            ("pull_request", "main", "next", True, False),
            ("merge_group", "main", "next", True, True),
            ("merge_group", "next", "main", True, False),
            ("push", "next", "next", True, False),
        ):
            with self.subTest(event=event, pull=pull, queue=queue, model=model):
                self.check_migration(event, pull, queue, model, expected)
