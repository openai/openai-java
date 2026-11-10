import json
import os
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from next_property_readers import check_getter_migration


POLICY = Path(__file__).with_name("next_property_readers.py")
READER = "com.openai.models.responses.StructuredResponse#_additionalProperties ()Ljava/util/Map;\n"
COMPLETE = "com.openai.models.responses.StructuredResponse#_allProperties ()Ljava/util/Map;\n"
OTHER = "com.openai.models.responses.Other#_additionalProperties ()Ljava/util/Map;\n"


class NextPropertyReadersTest(unittest.TestCase):
    def test_filters_only_reviewed_signatures_for_next(self):
        with tempfile.TemporaryDirectory() as directory:
            missing = Path(directory, "missing.txt")
            event = Path(directory, "event.json")
            declarations = Path(directory, "declarations")
            declarations.write_text("")
            profile = POLICY.parents[2] / "openai-java-core/src/apiCompatibility/structured-output-next-getters.json"
            for event_name in ("pull_request", "merge_group"):
                for branch in ("next", "main"):
                    with self.subTest(event=event_name, branch=branch):
                        event.write_text(json.dumps({"merge_group": {"base_ref": "refs/heads/" + branch}}))
                        env = dict(os.environ, GITHUB_EVENT_NAME=event_name, GITHUB_EVENT_PATH=str(event))
                        if event_name == "pull_request":
                            env["GITHUB_BASE_REF"] = branch
                        command = [sys.executable, str(POLICY), str(missing), str(declarations), str(profile)]
                        missing.write_text(READER)
                        result = subprocess.run(command, env=env, capture_output=True, text=True)
                        self.assertEqual(result.returncode, 0 if branch == "next" else 1)
                        missing.write_text(READER + COMPLETE + OTHER)
                        result = subprocess.run(command, env=env, capture_output=True, text=True)
                        self.assertEqual(result.returncode, 1)
                        self.assertIn(COMPLETE.strip(), result.stderr)
                        self.assertIn(OTHER.strip(), result.stderr)
                        self.assertEqual(READER.strip() in result.stderr, branch != "next")

    def test_getter_transition_requires_exact_successors_and_keeps_unrelated_descriptors(self):
        owner = "com.openai.models.chat.completions.StructuredChatCompletion"
        old_id = f"{owner}#id ()Ljava/lang/String;"
        old_object = f"{owner}#_object_ ()Lcom/openai/core/JsonValue;"
        profile = {
            owner: {
                "replaced": ["id ()Ljava/lang/String;", "_object_ ()Lcom/openai/core/JsonValue;"],
                "getters": {"id": "java.lang.String", "object_": "com.openai.core.JsonValue"},
            }
        }
        successors = {
            f"{owner}#public final java.util.Optional<java.lang.String> id(); ()Ljava/util/Optional;",
            f"{owner}#public final java.lang.String idOrThrow(); ()Ljava/lang/String;",
            f"{owner}#public final java.util.Optional<com.openai.core.JsonValue> object_(); ()Ljava/util/Optional;",
            f"{owner}#public final com.openai.core.JsonValue object_OrThrow(); ()Lcom/openai/core/JsonValue;",
            f"{owner}#public final com.openai.core.JsonField<com.openai.core.JsonValue> _object_(); ()Lcom/openai/core/JsonField;",
        }
        unrelated = f"{owner}#_id ()Lcom/openai/core/JsonField;"
        self.assertEqual(check_getter_migration(set(), set(), profile), set())
        self.assertEqual(check_getter_migration({old_id, old_object}, successors, profile), set())
        self.assertEqual(check_getter_migration({old_id, unrelated}, successors, profile), {unrelated})
        for required in successors:
            with self.subTest(required=required):
                wrong = required.replace("java.lang.String", "java.lang.Integer").replace(
                    "com.openai.core.JsonValue", "java.lang.String"
                )
                actual = (successors - {required}) | {wrong}
                self.assertEqual(check_getter_migration({old_id}, actual, profile), {required})
        primary = f"{owner}#public final java.util.Optional<java.lang.String> id(); ()Ljava/util/Optional;"
        wrong_descriptor = primary.replace("()Ljava/util/Optional;", "()Ljava/util/List;")
        actual = (successors - {primary}) | {wrong_descriptor}
        self.assertEqual(check_getter_migration({old_id}, actual, profile), {primary})
