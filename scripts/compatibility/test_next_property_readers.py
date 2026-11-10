import json
import os
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path


POLICY = Path(__file__).with_name("next_property_readers.py")
READER = "com.openai.models.responses.StructuredResponse#_additionalProperties ()Ljava/util/Map;\n"
COMPLETE = "com.openai.models.responses.StructuredResponse#_allProperties ()Ljava/util/Map;\n"
OTHER = "com.openai.models.responses.Other#_additionalProperties ()Ljava/util/Map;\n"


class NextPropertyReadersTest(unittest.TestCase):
    def test_filters_only_reviewed_signatures_for_next(self):
        with tempfile.TemporaryDirectory() as directory:
            missing = Path(directory, "missing.txt")
            event = Path(directory, "event.json")
            for event_name in ("pull_request", "merge_group"):
                for branch in ("next", "main"):
                    with self.subTest(event=event_name, branch=branch):
                        event.write_text(json.dumps({"merge_group": {"base_ref": "refs/heads/" + branch}}))
                        env = dict(os.environ, GITHUB_EVENT_NAME=event_name, GITHUB_EVENT_PATH=str(event))
                        if event_name == "pull_request":
                            env["GITHUB_BASE_REF"] = branch
                        command = [sys.executable, str(POLICY), str(missing)]
                        missing.write_text(READER)
                        result = subprocess.run(command, env=env, capture_output=True, text=True)
                        self.assertEqual(result.returncode, 0 if branch == "next" else 1)
                        missing.write_text(READER + COMPLETE + OTHER)
                        result = subprocess.run(command, env=env, capture_output=True, text=True)
                        self.assertEqual(result.returncode, 1)
                        self.assertIn(COMPLETE.strip(), result.stderr)
                        self.assertIn(OTHER.strip(), result.stderr)
                        self.assertEqual(READER.strip() in result.stderr, branch != "next")
