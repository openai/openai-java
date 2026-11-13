# Responses compaction in Java 5

A compacted history can contain retained input messages, assistant output and
a compaction record. Read GA compacted output as `List<ResponseItem>` and
beta compacted output as `List<BetaResponseItem>`. An ordinary Responses
create or retrieve call still returns output items.

## Inspect and replay compacted history

**Before**

```java
List<ResponseOutputItem> history = client.responses().compact(params).output();
for (ResponseOutputItem item : history) {
    item.message().ifPresent(message -> inspect(message.content()));
}
```

**After**

```java
List<ResponseItem> history = client.responses().compact(params).outputOrThrow();
for (ResponseItem item : history) {
    item.responseInputMessageItem().ifPresent(message -> inspect(message.contentOrThrow()));
    item.responseOutputMessage().ifPresent(message -> inspect(message.contentOrThrow()));
}
client.responses().create(ResponseCreateParams.builder()
        .model("gpt-4o")
        .input(JsonValue.from(history))
        .build());
```

Use the input-message variant for retained user, system and developer messages.
Use the output-message variant for an assistant message with output content.
The request takes input items. Passing the history through `JsonValue.from`
preserves its JSON fields and item order. For beta, use
`betaResponseInputMessageItem()` and `betaResponseOutputMessage()` on
`BetaResponseItem`.

## Construct and inspect a compaction trigger

**Before**

```kotlin
val raw = JsonValue.from(mapOf("type" to "compaction_trigger", "id" to "cmp_1"))
val item = ResponseInputItem.ofCompactionTrigger(raw)
val id = item.asCompactionTrigger().asObject().get()["id"]?.asString()?.orElse(null)
```

**After**

```kotlin
val trigger = ResponseInputItem.CompactionTrigger.builder().id("cmp_1").build()
val item = ResponseInputItem.ofCompactionTrigger(trigger)
val id = item.asCompactionTrigger().id().orElse(null)
```

`ofCompactionTrigger()` still creates a trigger with an omitted ID.
Use `_id().isMissing()` and `_id().isNull()` when the distinction matters.
`ofCompactionTrigger(JsonValue)` remains available for raw input.
A beta trigger already exposes its ID through `BetaResponseInputItem.CompactionTrigger`.

Conversation builders now take the typed trigger through `addItem(trigger)`.
Use `addItem(ResponseInputItem.ofCompactionTrigger())` in place of
`addItemCompactionTrigger()` when omitting the ID. For a Live
`ResponseItemCreateEvent.Builder`, use `item(trigger)` or
`item(ResponseInputItem.ofCompactionTrigger())` in place of `itemCompactionTrigger()`.

## Source and JVM compatibility

Recompile callers and visitor implementations when upgrading. Java 4’s `output()` has descriptor `()Ljava/util/List;`. In Java 5,
`output()` returns `Optional<List<ResponseItem>>` with descriptor
`()Ljava/util/Optional;`, and `outputOrThrow()` returns the list with descriptor
`()Ljava/util/List;`. Beta uses `BetaResponseItem`. The generic element type changes for `output()`, `_output()`, and
both builder `output(...)` overloads. The builder overload taking one union
item now accepts `ResponseItem`. Nested variant types in its other overloads
also move to the `ResponseItem` family. The function-call and custom-tool-call
overloads take `ResponseFunctionToolCallItem` and `ResponseCustomToolCallItem`
in place of `ResponseFunctionToolCall` and `ResponseCustomToolCall`. Beta uses
the corresponding `BetaResponse…` types. In Kotlin, change
`addOutput(message = value)` to `addOutput(value)`. The new parameter name is
`responseOutputMessage` in GA and `betaResponseOutputMessage` in beta.

On `ResponseInputItem`, `compactionTrigger()` still erases to
`()Ljava/util/Optional;`. Its generic return changes from `Optional<JsonValue>`
to `Optional<ResponseInputItem.CompactionTrigger>`. These JVM descriptors
change for the GA accessor and visitor.

| Method | Java 4 descriptor | Java 5 descriptor |
| --- | --- | --- |
| `ResponseInputItem.asCompactionTrigger()` | `()Lcom/openai/core/JsonValue;` | `()Lcom/openai/models/responses/ResponseInputItem$CompactionTrigger;` |
| `ResponseInputItem.Visitor.visitCompactionTrigger(...)` | `(Lcom/openai/core/JsonValue;)Ljava/lang/Object;` | `(Lcom/openai/models/responses/ResponseInputItem$CompactionTrigger;)Ljava/lang/Object;` |
| `CompactedResponse.Builder.addOutput(...)` (union overload) | `(Lcom/openai/models/responses/ResponseOutputItem;)Lcom/openai/models/responses/CompactedResponse$Builder;` | `(Lcom/openai/models/responses/ResponseItem;)Lcom/openai/models/responses/CompactedResponse$Builder;` |

The GA input union dispatches through `accept(Visitor)`. Implement
`visitCompactionTrigger` with the typed argument. A compacted-history
visitor now accepts the `ResponseItem.Visitor` or `BetaResponseItem.Visitor`
contract, including retained input messages.

For each builder below, the Java 4 shortcut has JVM descriptor `()LOwner;`.
The Java 5 typed overload has descriptor
`(Lcom/openai/models/responses/ResponseInputItem$CompactionTrigger;)LOwner;`.
Substitute the JVM owner name in the table for `Owner`.

| JVM owner | Java 4 shortcut | Java 5 overload |
| --- | --- | --- |
| `com/openai/models/conversations/ConversationCreateParams$Builder` | `addItemCompactionTrigger()` | `addItem(trigger)` |
| `com/openai/models/conversations/ConversationCreateParams$Body$Builder` | `addItemCompactionTrigger()` | `addItem(trigger)` |
| `com/openai/models/conversations/items/ItemCreateParams$Builder` | `addItemCompactionTrigger()` | `addItem(trigger)` |
| `com/openai/models/conversations/items/ItemCreateParams$Body$Builder` | `addItemCompactionTrigger()` | `addItem(trigger)` |
| `com/openai/models/live/ResponseItemCreateEvent$Builder` | `itemCompactionTrigger()` | `item(trigger)` |
