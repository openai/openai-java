"""Allow the five approved Structured Outputs reader removals on Java next."""

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


if __name__ == "__main__":
    missing = Path(sys.argv[1]).read_text().splitlines()
    if target_branch() == "next":
        missing = [signature for signature in missing if signature not in RETIRED]
    if missing:
        print("baseline structured-output API is missing:", file=sys.stderr)
        for signature in missing:
            print(f"  {signature}", file=sys.stderr)
        sys.exit(1)
