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
        .onShell { it.environment().get().asContainerReference().containerIdOrThrow() }
        .build()
)
```

### Read or send an MCP tool name

In both `ResponsesDelegationConfig` and `ResponsesDelegationUpdateConfig`, the
following nested types now return `Optional<String>` from `name()`:

- `ToolChoice.LiveMcpToolChoiceParam`
- `ToolChoice.LiveAllowedToolsChoiceParam.Tool.Mcp`

Recompile code that calls any of these four getters. Previously compiled calls
look for a method returning `String` and can throw `NoSuchMethodError`.

**Before**

```java
String name = choice.asLiveMcpToolChoiceParam().name();
```

**After**

```java
Optional<String> name = choice.asLiveMcpToolChoiceParam().name();
```

Use `java.util.Optional`. Both an omitted name and JSON null produce an empty
optional. To distinguish them, call `_name().isMissing()` or `_name().isNull()`.
Code that must compile against both Java 4 and Java 5 can use `_name().asString()`.

```java
ResponsesDelegationConfig.ToolChoice.LiveMcpToolChoiceParam.Builder mcp =
    ResponsesDelegationConfig.ToolChoice.LiveMcpToolChoiceParam.builder()
        .serverLabel("calendar");
mcp.build();                       // omits name
mcp.name(Optional.empty()).build(); // sends "name": null
mcp.name("list_events").build();    // sends "name": "list_events"
```

The same builder calls work in both configurations and inside `allowed_tools`.
Each MCP builder accepts `name(String?)` from Kotlin and adds
`name(Optional<String>)` for Java. The existing `name(JsonField<String>)`
overload remains available. In Java, use `Optional.empty()` for explicit null
to avoid an ambiguous `name(null)` call. Both
`ToolChoice.LiveAllowedToolsChoiceParam.Builder` classes also add
`addMcpTool(String serverLabel)` to select a server and omit its tool name.
A function choice still requires a name, and an MCP choice still requires a
server label.

## Decision item messages

`DecisionItemCreateEvent.Item` and `DecisionItemCreatedEvent.Item` become typed
unions. The existing `Item.builder()` and `Item.Type.MESSAGE` still build
user messages. To send a different role or a tool item, build the matching
variant and pass it to the event builder. Inspect the variant before using a
message accessor on received data. The same types apply on primary, fork and
sideband connections.

**Before**

```java
DecisionItemCreateEvent event = DecisionItemCreateEvent.builder()
        .item(DecisionItemCreateEvent.Item.builder().content("Ready?").build())
        .build();
```

**After**

```java
DecisionUserMessage message = DecisionUserMessage.builder().content("Ready?").build();
DecisionItemCreateEvent event = DecisionItemCreateEvent.builder().item(message).build();
String text = event.itemOrThrow().asDecisionUserMessage().contentOrThrow().asString();
```

For received events, use the stored message accessor, for example
`event.itemOrThrow().asDecisionStoredUserMessage()` on a `DecisionItemCreatedEvent`.
Use `isFunctionCall()`, `isCustomToolCall()`, or the corresponding output
predicate before reading a tool item. An unrecognized item retains its JSON in
`_json()`.

### Assistant content and choice options

The create and stored assistant builders accept the same `DecisionAssistantMessageContent`.
Replace either candidate-only `DecisionAssistantMessage.Content` or
`DecisionStoredAssistantMessage.Content` with that type. Replace their respective
nested `DecisionAssistantMessageContentItem` and `DecisionStoredAssistantMessageContentItem`
with `DecisionAssistantMessageContentPart`, including its `OutputText`, `Refusal` and visitor types.
The string shorthand and `contentOfParts(parts)` work on both builders.

```java
DecisionAssistantMessage create =
        DecisionAssistantMessage.builder().content(stored.contentOrThrow()).build();
DecisionStoredAssistantMessage copy =
        DecisionStoredAssistantMessage.builder().id("copy").content(create.contentOrThrow()).build();
```

For Live and Decisions choice builders, import `com.openai.models.decisions.DecisionChoiceOption`.
Code that used the private candidate's `com.openai.models.live.DecisionChoiceOption` can switch that import.

## Live tool outputs

Use `com.openai.models.live.DecisionToolOutput` for both function and custom tool
outputs on `DecisionItemCreateEvent.Item` and `DecisionItemCreatedEvent.Item`.
The four builders accept the same value, and their `outputOrThrow()` accessors return
that type. Stored items still require an ID.

Earlier Java v5 previews nested `Output` under each item. For example, migrate
`DecisionItemCreateEvent.Item.FunctionCallOutput.Output` to `DecisionToolOutput`.
The same replacement applies to `CustomToolCallOutput.Output` and both stored
item types. Replace their list element types as follows.

| Previous type under the item’s nested `Output` | Shared type |
| --- | --- |
| `DecisionItemCreateEventItemFunctionCallOutputOutputItem` | `DecisionToolOutputContentPart` |
| `DecisionItemCreateEventItemCustomToolCallOutputOutputItem` | `DecisionToolOutputContentPart` |
| `DecisionItemCreatedEventItemFunctionCallOutputOutputItem` | `DecisionToolOutputContentPart` |
| `DecisionItemCreatedEventItemCustomToolCallOutputOutputItem` | `DecisionToolOutputContentPart` |

Build image parts with `DecisionToolOutputContentPart.InputImage`. For plain
text, use `DecisionToolOutput.ofString("done")`. For a list of text or image parts,
pass the shared payload to any of the four builders.

```java
DecisionToolOutputContentPart text = DecisionToolOutputContentPart.ofInputText(
        DecisionInputText.builder().text("done").build());
DecisionToolOutput output = DecisionToolOutput.ofParts(Collections.singletonList(text));
DecisionItemCreateEvent.Item.FunctionCallOutput.builder().callId("call").output(output).build();
DecisionItemCreatedEvent.Item.CustomToolCallOutput.builder()
        .id("item").callId("call").output(output).build();
```

```kotlin
val text = DecisionToolOutputContentPart.ofInputText(DecisionInputText.builder().text("done").build())
val output = DecisionToolOutput.ofParts(listOf(text))
val item = DecisionItemCreateEvent.Item.FunctionCallOutput.builder().callId("call").output(output).build()
val parts: List<DecisionToolOutputContentPart> = item.outputOrThrow().asParts()
```

## Delegation questions

Use the shared `DecisionQuestion` type in place of
`DecisionsDelegationConfig.Question`, `DecisionsDelegationUpdateConfig.Question`
and `DecisionTrigger.Decisions.Question`. Construct a `DecisionQuestion.Choice`,
`.Predicate` or `.Score`, then pass it to `addQuestion` on the delegation or
trigger builder. The questions list retains its missing/null/list handling.

Kotlin callers can pass a string to `instructions` or reuse a typed list of
text, image and JSON parts across question kinds.

```kotlin
val parts = listOf(
    DecisionQuestionInputPart.ofInputText(
        DecisionInputText.builder().text("Review this").build()
    )
)
val question = DecisionQuestion.ofPredicate(
    DecisionQuestion.Predicate.builder().instructionsOfParts(parts).build()
)
val update = DecisionsDelegationUpdateConfig.builder().addQuestion(question).build()
val triggerDecisions = DecisionTrigger.Decisions.builder().addQuestion(question).build()
```

For an `input_json` part, `dataOrThrow().asDecisionJsonObject()` returns one object and
`dataOrThrow().asDecisionJsonObjects()` returns a list of objects.

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
