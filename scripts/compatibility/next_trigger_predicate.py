"""Compile historical next-branch trigger callers against the relocated predicate type."""

import json
import os
import re
import sys
from pathlib import Path


GENERATED = (
    "models/live/LiveCreateParamsTest.kt",
    "models/live/MediaSessionConfigTest.kt",
    "models/live/SessionClosedEventTest.kt",
    "models/live/SessionConfigTest.kt",
    "models/live/SessionResourceTest.kt",
    "models/live/SessionStartEventTest.kt",
    "models/live/SessionStartedEventTest.kt",
    "models/live/SessionUpdateConfigTest.kt",
    "models/live/SessionUpdateEventTest.kt",
    "models/live/SessionUpdatedEventTest.kt",
    "models/live/sessions/SessionAcceptParamsTest.kt",
    "services/async/LiveServiceAsyncTest.kt",
    "services/async/live/SessionServiceAsyncTest.kt",
    "services/blocking/LiveServiceTest.kt",
    "services/blocking/live/SessionServiceTest.kt",
)
CURATED = (
    "models/live/ClientEventCompatibility.kt",
    "models/live/ServerEventCompatibility.kt",
    "models/live/forks/ForkClientEventCompatibility.kt",
    "models/live/forks/ForkServerEventCompatibility.kt",
    "models/live/sideband/SidebandClientEventCompatibility.kt",
    "models/live/sideband/SidebandServerEventCompatibility.kt",
)
PREDICATE = re.compile(rb"(?<![\w.])DecisionTrigger\.Decisions\.Question\.Predicate\b")
SHARED_MODEL = Path("openai-java-core/src/main/kotlin/com/openai/models/live/DecisionQuestion.kt")


def target_branch():
    if os.environ.get("GITHUB_EVENT_NAME") == "merge_group":
        event = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text())
        return event["merge_group"]["base_ref"].removeprefix("refs/heads/")
    if os.environ.get("GITHUB_EVENT_NAME") == "pull_request":
        return os.environ.get("GITHUB_BASE_REF")
    return None


def migrate(root):
    if target_branch() != "next" or not SHARED_MODEL.is_file():
        return
    for tree in (root, root / "proposed"):
        for suite, files in (("test", GENERATED), ("apiCompatibility", CURATED)):
            callers = tree / "openai-java-core/src" / suite / "kotlin/com/openai"
            for name in files:
                fixture = callers / name
                if fixture.is_file():
                    source = fixture.read_bytes()
                    updated = PREDICATE.sub(b"com.openai.models.live.DecisionQuestion.Predicate", source)
                    if updated != source:
                        fixture.write_bytes(updated)


if __name__ == "__main__":
    migrate(Path(sys.argv[1]))
