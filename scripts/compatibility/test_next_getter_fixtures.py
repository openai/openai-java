import os
from pathlib import Path
import subprocess
import tempfile
import unittest
from unittest.mock import patch

from next_getter_fixtures import MODEL, NEW, OLD, PATCH, STAGED, migrate


class ArchivedGetterTest(unittest.TestCase):
    def test_trusted_patch_only_adapts_its_archived_input_across_the_transition(self):
        with tempfile.TemporaryDirectory() as directory:
            previous = Path.cwd()
            os.chdir(directory)
            self.addCleanup(os.chdir, previous)
            subprocess.run(["git", "init", "-q"], check=True)
            fixture = Path("openai-java-core/src/test/kotlin/com/openai/models/ModelTest.kt")
            original = 'assertThat(model.id()).isEqualTo("expected")\n'
            migrated = original.replace("id()", "idOrThrow()")
            fixture.parent.mkdir(parents=True)
            fixture.write_text(original)
            MODEL.parent.mkdir(parents=True)
            MODEL.write_text(OLD)
            subprocess.run(["git", "add", "."], check=True)
            fixture.write_text(migrated)
            diff = subprocess.check_output(["git", "diff", "--full-index", "--", str(fixture)])
            fixture.write_text(original)
            policy = Path(PATCH)
            policy.parent.mkdir(parents=True)
            policy.write_bytes(diff)
            subprocess.run(["git", "add", str(policy)], check=True)
            base = subprocess.check_output(["git", "write-tree"], text=True).strip()
            archived = STAGED / fixture
            archived.parent.mkdir(parents=True)
            event = Path("event.json")
            event.write_text('{"merge_group":{"base_ref":"refs/heads/next"}}')
            policy.write_bytes(b"candidate-controlled content")
            for name, branch, model, expected in [
                ("pull_request", "next", NEW, migrated),
                ("merge_group", "", NEW, migrated),
                ("pull_request", "main", NEW, original),
                ("push", "next", NEW, original),
                ("pull_request", "next", OLD, original),
            ]:
                with self.subTest(name=name, branch=branch, model=model), patch.dict(
                    os.environ, GITHUB_EVENT_NAME=name, GITHUB_BASE_REF=branch,
                    GITHUB_EVENT_PATH=str(event),
                ):
                    MODEL.write_text(model)
                    archived.write_text(original)
                    migrate(base)
                    self.assertEqual(archived.read_text(), expected)
                    self.assertEqual(fixture.read_text(), original)
            MODEL.write_text(NEW)
            archived.write_text(original.replace("expected", "wrong"))
            with patch.dict(os.environ, GITHUB_EVENT_NAME="pull_request", GITHUB_BASE_REF="next"):
                with self.assertRaisesRegex(ValueError, "Unexpected archived getter fixture"):
                    migrate(base)
