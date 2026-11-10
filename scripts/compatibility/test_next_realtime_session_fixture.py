import json
import os
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from next_realtime_session_fixture import FIXTURE, MODEL, STAGED


POLICY = Path(__file__).with_name("next_realtime_session_fixture.py").resolve()
BEFORE = b"fun ofRealtimeSessionCreateRequest(value: RealtimeSessionCreateRequest)"
AFTER = b"fun ofRealtime(realtime: RealtimeSessionCreateRequest)"
FIXTURE_SOURCE = b"""
        assertThat(event.session()).isEqualTo(
                SessionUpdateEvent.Session.ofRealtimeSessionCreateRequest(
                    RealtimeSessionCreateRequest.builder().instructions("keep").build()
                )
        )
"""


class RealtimeSessionFixtureTest(unittest.TestCase):
    def setUp(self):
        temp = tempfile.TemporaryDirectory()
        self.addCleanup(temp.cleanup)
        self.repo = Path(temp.name)
        self.staged = self.repo / STAGED
        self.proposed = self.repo / "openai-java-core/build/api-compatibility-source/proposed" / FIXTURE
        self.tracked = self.repo / FIXTURE
        self.model = self.repo / MODEL
        for path in (self.staged, self.proposed, self.tracked, self.model):
            path.parent.mkdir(parents=True, exist_ok=True)
        self.tracked.write_bytes(FIXTURE_SOURCE)
        self.model.write_bytes(BEFORE)
        self.git("init", "-q")
        self.commit_base()
        self.staged.write_bytes(FIXTURE_SOURCE)
        self.tracked.write_bytes(b"tracked test")
        self.proposed.write_bytes(b"proposed test")
        self.model.write_bytes(AFTER)

    def git(self, *args):
        subprocess.run(["git", *args], cwd=self.repo, check=True)

    def commit_base(self):
        self.git("add", "--", MODEL, FIXTURE)
        self.git("-c", "user.name=Test", "-c", "user.email=test@example.com", "commit", "-qm", "Base")

    def run_policy(self, event="pull_request", branch="next", queue="main"):
        payload = self.repo / "event.json"
        payload.write_text(json.dumps({"merge_group": {"base_ref": f"refs/heads/{queue}"}}))
        return subprocess.run(
            [sys.executable, "-I", str(POLICY), "HEAD"],
            cwd=self.repo,
            env=dict(os.environ, GITHUB_EVENT_NAME=event, GITHUB_BASE_REF=branch, GITHUB_EVENT_PATH=str(payload)),
            capture_output=True,
        )

    def test_migrates_only_the_archived_call_on_next(self):
        migrated = FIXTURE_SOURCE.replace(b".ofRealtimeSessionCreateRequest(", b".ofRealtime(")
        for event, branch, queue, model, expected in (
            ("pull_request", "next", "main", AFTER, migrated),
            ("merge_group", "main", "next", AFTER, migrated),
            ("pull_request", "main", "next", AFTER, FIXTURE_SOURCE),
            ("merge_group", "next", "main", AFTER, FIXTURE_SOURCE),
            ("push", "next", "next", AFTER, FIXTURE_SOURCE),
            ("pull_request", "next", "main", BEFORE, FIXTURE_SOURCE),
            ("pull_request", "next", "main", BEFORE + AFTER, FIXTURE_SOURCE),
        ):
            with self.subTest(event=event, branch=branch, queue=queue, model=model):
                self.model.write_bytes(model)
                self.staged.write_bytes(FIXTURE_SOURCE)
                self.run_policy(event, branch, queue).check_returncode()
                self.assertEqual(self.staged.read_bytes(), expected)
                self.assertEqual(self.tracked.read_bytes(), b"tracked test")
                self.assertEqual(self.proposed.read_bytes(), b"proposed test")

    def test_does_not_reapply_after_the_base_has_migrated(self):
        self.commit_base()
        self.run_policy().check_returncode()
        self.assertEqual(self.staged.read_bytes(), FIXTURE_SOURCE)

    def test_rejects_changed_or_ambiguous_archived_calls(self):
        for staged, base in ((b"changed", FIXTURE_SOURCE), (b"missing", b"missing"),
                             (FIXTURE_SOURCE * 2, FIXTURE_SOURCE * 2)):
            with self.subTest(staged=staged):
                self.model.write_bytes(BEFORE)
                self.tracked.write_bytes(base)
                if base != FIXTURE_SOURCE:
                    self.commit_base()
                self.model.write_bytes(AFTER)
                self.staged.write_bytes(staged)
                self.assertNotEqual(self.run_policy().returncode, 0)
                self.assertEqual(self.staged.read_bytes(), staged)

    def test_rejects_links_to_other_sources(self):
        self.proposed.write_bytes(FIXTURE_SOURCE)
        for link in (self.staged.symlink_to, self.staged.hardlink_to):
            with self.subTest(link=link):
                self.staged.unlink()
                link(self.proposed)
                self.assertNotEqual(self.run_policy().returncode, 0)
                self.assertEqual(self.proposed.read_bytes(), FIXTURE_SOURCE)


if __name__ == "__main__":
    unittest.main()
