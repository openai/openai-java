# Responses history normalization

Use `ResponseInputItems` when managing conversation history locally. It converts response output
into typed `ResponseInputItem` values without modifying the original models:

```java
import com.openai.helpers.ResponseInputItems;

history.addAll(ResponseInputItems.toInputItems(response.output()));
var next = client.responses().create(
    ResponseCreateParams.builder()
        .model("gpt-6.2-astra")
        .inputOfResponse(history)
        .store(false)
        .build());
```

Here `history` is a mutable `List<ResponseInputItem>` containing the preceding inputs. Append your
next user message or tool result before creating the next response. See the compiled
[conversation example](../openai-java-example/src/main/java/com/openai/example/ResponsesConversationExample.java).

`normalizeInputItems(history)` applies the same rules to stored input models. The overloaded
`toInputItem(inputItem)` and `toInputItem(outputItem)` methods return `Optional<ResponseInputItem>`:
empty means a known item state is not replayable. For structured responses, use each structured
item's `rawOutputItem()` or the underlying raw response rather than serializing application objects.

The helper preserves order, IDs, encrypted reasoning, assistant phase, tool arguments/results,
and extension properties. It removes root `created_by`, shell chunk `created_by`, assistant
output text/refusal `parsed`, and function-call `parsed_arguments`. It omits non-developer
`additional_tools`, failed computer outputs, and custom-tool outputs with a present status other
than `completed`. A retained custom-tool output has its status removed. Unknown item types throw
`IllegalArgumentException`; they are never silently dropped. The returned list is mutable.

This is local conversion, not a complete-history validator. It does not fetch pages, synthesize
missing tool results, reorder history, or guarantee that an incomplete conversation will be
accepted. Preserve the original reasoning prefix and complete call/result relationships. Known
item extension fields are retained, so normalization does not validate arbitrary extra properties.

The replay rules follow the maintained
[Node helper](https://github.com/openai/openai-node/blob/2442a0ca8a934aa4b41fe1c797717e4713568739/src/lib/responses/ResponseInputItems.ts)
and the [conversation-state guide](https://developers.openai.com/api/docs/guides/conversation-state).
