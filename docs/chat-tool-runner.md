# Automatic Chat tool runner

`ChatCompletionToolRunner` runs a blocking Chat Completions conversation: it sends the
request, converts function arguments into registered Java types, invokes callbacks,
appends their JSON results using the matching tool-call IDs, and requests a final answer.

```java
public static class LookupPrice {
    public String product;
}

ChatCompletionToolRunner runner = ChatCompletionToolRunner.builder()
        .client(client)
        .maxTurns(8)
        .addTool(LookupPrice.class, args -> catalog.lookupPrice(args.product))
        .build();

ChatCompletionToolRunner.Result result = runner.run(ChatCompletionCreateParams.builder()
        .model("gpt-4.1")
        .addUserMessage("What does the blue notebook cost?")
        .build());
result.completion().choices().get(0).message().content().ifPresent(System.out::println);
```

Use the existing function-schema annotations on the argument class. Callback results
use the SDK's structured-output JSON serializer, including strings (quoted as JSON)
and `null` (`"null"` in the tool message). Callback execution is sequential, even if
the model requests several tools in one response. The runner parses all calls in a
turn before invoking any callbacks. Unknown tools, malformed arguments, unsupported
custom or legacy calls, duplicate IDs within the run, and incomplete completions fail.

Register tools on the runner, not in request params. The request must use one choice.
Other settings, including `toolChoice`, headers, model, and temperature, are preserved
on every request. A forced tool choice may prevent a final answer and exhaust the
limit. `maxTurns` counts model requests, including the final answer request; at the
limit, pending callbacks are not executed. `requestOptions` and client configuration
control HTTP timeouts and retries. There is no overall wall-clock deadline, and a
callback can block; interruption is checked between requests and callbacks.

`result.messages()` is an immutable conversation snapshot including the final assistant
message. It can be used as the messages for another run. The runner owns neither the
client nor application resources. It supports blocking, non-streaming Chat Completions;
Responses, streaming events, and asynchronous execution are separate workflows.

## Callback safety and recovery

Register only tools the application authorizes the model to invoke. Typed argument
conversion does not validate business rules or obtain user approval. Callbacks must
enforce authorization, validate arguments, and obtain any required confirmation before
performing external actions. The runner does not retry callbacks.

A `ChatCompletionToolRunner.RunException` exposes the original cause, the last received
completion, the current tool-call ID when applicable, and the partial message history.
Successfully appended tool results remain available if a later callback or request
fails. The failing callback may already have performed an external action, including
when result serialization fails. Do not blindly rerun the conversation: reconcile
external state and any unresolved calls first. These objects may contain sensitive
arguments and results; avoid logging them indiscriminately.

See the runnable [Java example](../openai-java-example/src/main/java/com/openai/example/ChatCompletionToolRunnerExample.java).
