# Live API migration on next

This describes planned source changes for the next major version. It is not a
release announcement and does not change the current stable release.

## Responses delegation tools and tool choices

The next major removes the nested `Visitor` interface and `accept(Visitor)` method from these types in `com.openai.models.live`:

- `ResponsesDelegationConfig.Tool`
- `ResponsesDelegationConfig.ToolChoice`
- `ResponsesDelegationUpdateConfig.Tool`
- `ResponsesDelegationUpdateConfig.ToolChoice`

Replace each visitor with a handler and recompile callers that reference a removed symbol. A binary compiled against one of the removed interfaces or methods can fail to link on the next major. An existing handler can continue to use `match`.

These examples use `com.openai.models.live.ResponsesDelegationConfig.Tool`. The old visitor also uses `com.openai.models.live.FunctionTool` and `com.openai.core.JsonValue`.

**Before**

```java
static String kind(Tool tool) {
    return tool.accept(new Tool.Visitor<String>() {
        @Override public String visitFunction(FunctionTool function) { return "function"; }
        @Override public String visitWebSearch(JsonValue webSearch) { return "web_search"; }
        @Override public String unknown(JsonValue json) { return "other"; }
    });
}
```

**After**

```java
static String kind(Tool tool) {
    return tool.match(Tool.Handler.<String>builder()
            .onFunction(function -> "function")
            .onWebSearch(webSearch -> "web_search")
            .onDefault(value -> "other")
            .build());
}
```

`onDefault` receives the union for an unregistered or unknown variant. Without an applicable callback, `match` throws `OpenAIInvalidDataException`. For an unknown JSON payload, the fallback can inspect `value._json()`.

Kotlin callers can register callbacks on the same builder. For a shell tool with a container reference:

```kotlin
val containerId = tool.match(
    Tool.Handler.builder<String>()
        .onShell { it.environment().get().asContainerReference().containerId() }
        .build()
)
```

## Decision item messages

`DecisionItemCreateEvent.Item` and `DecisionItemCreatedEvent.Item` become typed
unions. Code using their old `builder()` and nested `Type.MESSAGE` must instead
construct a concrete message, such as `DecisionUserMessage`, and pass it to the
event builder. The event identifiers and surrounding client/server event APIs
remain available. The same change applies when those events are carried through
fork or sideband connections.

## Delegation questions

`DecisionsDelegationUpdateConfig.Question` is replaced by the shared
`DecisionQuestion` type. Construct a `DecisionQuestion.Choice`, `.Predicate`, or
`.Score`, then pass it to `addQuestion`. This lets delegation updates reuse the
same question types as other Decisions requests. The questions list retains its
missing/null/list handling.

## Compatibility coverage

The next branch's compatibility policy records only these intentional source
changes. Curated copies of the nine affected consumer tests preserve their
other API expressions, including event variants, accessors, roundtrip calls,
and omitted-list behavior. Only the replaced constructors use wire-shaped
values in those compile-only fixtures. Current SDK tests continue to exercise
typed construction and runtime behavior.

The ordinary compatibility workflow still reads its policy from the target
branch. This policy must be reviewed and merged separately before the SDK API
change; the SDK candidate cannot approve its own exception. No CI job or
required status is disabled.
