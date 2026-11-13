# Read local shell output IDs

A returned local shell output carries two required strings. The item’s `id` identifies the output. Its `call_id` identifies the model-generated tool call that produced it.

For GA Responses, read a local shell output from a compacted history or input-item list with `ResponseItem.asLocalShellCallOutput()`. Use `idOrThrow()` and `callIdOrThrow()` for required values. The getters `id()` and `callId()` return `Optional<String>` and the raw accessors `_id()` and `_callId()` preserve the JSON fields.

```java
ResponseItem.LocalShellCallOutput output =
    ResponseItem.LocalShellCallOutput.builder()
        .id("out_1")
        .callId("call_7")
        .output("ok")
        .build();
```

Java and Kotlin builders for returned outputs now require `callId(...)` alongside `id(...)` and `output(...)`. If you previously supplied an extra property with `putAdditionalProperty("call_id", value)`, pass that string to `callId(value.asStringOrThrow())`. This applies to the nested `LocalShellCallOutput` on `ResponseItem`, `ResponseOutputItem`, `BetaResponseItem`, `BetaResponseOutputItem` and `ConversationItem`.

GA and beta compacted histories can contain both compaction records and local shell outputs. To replay the complete history, pass `JsonValue.from(history)` to the create request’s `input(...)`. This preserves both IDs, additional fields and item order.
