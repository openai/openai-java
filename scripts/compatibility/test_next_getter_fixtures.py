import os
import next_realtime_session_fixture as realtime
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

    def test_realtime_factory_and_required_getter_migrations_compose(self):
        root = Path(__file__).resolve().parents[2]
        original = (root / realtime.FIXTURE).read_bytes()
        if realtime.OLD_CALL not in original:
            # Retrieve the exact fixture covered by this historical transition.
            original = subprocess.check_output(
                ["git", "-C", str(root), "cat-file", "blob", "98470dd1c7398d82494f52944db8e066909ed022"]
            )
        full_patch = (root / PATCH).read_bytes()
        sections = full_patch.split(b"diff --git ")
        header = f"a/{realtime.FIXTURE} b/{realtime.FIXTURE}\n".encode()
        fixture_patch = b"diff --git " + next(section for section in sections if section.startswith(header))
        with tempfile.TemporaryDirectory() as directory:
            previous = Path.cwd()
            os.chdir(directory)
            self.addCleanup(os.chdir, previous)
            subprocess.run(["git", "init", "-q"], check=True)
            for path, data in [(MODEL, OLD.encode()), (realtime.MODEL, realtime.OLD_FACTORY),
                               (realtime.FIXTURE, original), (Path(PATCH), fixture_patch)]:
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_bytes(data)
            subprocess.run(["git", "add", "."], check=True)
            base = subprocess.check_output(["git", "write-tree"], text=True).strip()
            MODEL.write_text(NEW)
            realtime.MODEL.write_bytes(realtime.NEW_FACTORY)
            realtime.STAGED.parent.mkdir(parents=True)
            realtime.STAGED.write_bytes(original)
            with patch.dict(os.environ, GITHUB_EVENT_NAME="pull_request", GITHUB_BASE_REF="next"):
                realtime.migrate(base)
                migrate(base)
            expected = original.replace(realtime.OLD_CALL, realtime.NEW_CALL).replace(
                b"assertThat(sessionUpdateEvent.session())", b"assertThat(sessionUpdateEvent.sessionOrThrow())"
            )
            self.assertEqual(realtime.STAGED.read_bytes(), expected)
