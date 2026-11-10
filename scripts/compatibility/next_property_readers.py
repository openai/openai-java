"""Check the approved Structured Outputs reader migrations on Java next."""

import json
import os
import sys
from pathlib import Path


RETIRED = {
    f"com.openai.models.{owner}#_additionalProperties ()Ljava/util/Map;"
    for owner in (
        "chat.completions.StructuredChatCompletion",
        "chat.completions.StructuredChatCompletion$Choice",
        "chat.completions.StructuredChatCompletionMessage",
        "responses.StructuredResponse",
        "responses.StructuredResponseOutputMessage",
    )
}


def target_branch():
    event_name = os.environ.get("GITHUB_EVENT_NAME")
    if event_name == "pull_request":
        return os.environ.get("GITHUB_BASE_REF")
    if event_name == "merge_group":
        payload = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text())
        return payload["merge_group"]["base_ref"].removeprefix("refs/heads/")
    return None


def return_descriptor(java_type):
    primitives = {"long": "J", "double": "D", "boolean": "Z", "T": "Ljava/lang/Object;"}
    erased = java_type.split("<", 1)[0].replace(".", "/")
    return primitives.get(java_type, f"L{erased};")


def declaration(owner, method, java_type):
    return f"{owner}#public final {java_type} {method}(); (){return_descriptor(java_type)}"


def check_getter_migration(missing, declarations, profiles):
    replaced = set()
    required = set()
    boxed = {"long": "java.lang.Long", "double": "java.lang.Double", "boolean": "java.lang.Boolean"}
    for owner, profile in profiles.items():
        for signature in profile["replaced"]:
            replaced.add(f"{owner}#{signature}")
            method = signature.split()[0]
            if method.startswith("_"):
                required.add(declaration(owner, method, "com.openai.core.JsonField<com.openai.core.JsonValue>"))
        for name, value_type in profile["getters"].items():
            optional = f"java.util.Optional<{boxed.get(value_type, value_type)}>"
            required.add(declaration(owner, name, optional))
            required.add(declaration(owner, name + "OrThrow", value_type))

    # Keep the predecessor profile until a listed getter changes. Then require the whole successor profile.
    if missing.isdisjoint(replaced):
        return missing
    return (missing - replaced) | (required - declarations)


if __name__ == "__main__":
    missing = set(Path(sys.argv[1]).read_text().splitlines())
    if target_branch() == "next":
        missing -= RETIRED
        if missing:
            missing = check_getter_migration(
                missing,
                set(Path(sys.argv[2]).read_text().splitlines()),
                json.loads(Path(sys.argv[3]).read_text()),
            )
    if missing:
        print("baseline structured-output API is missing:", file=sys.stderr)
        for signature in sorted(missing):
            print(f"  {signature}", file=sys.stderr)
        sys.exit(1)
