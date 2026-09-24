# Stream an Agent session turn

Use `sessions().stream(...)` with an existing idle session and a single input
writer. The helper opens the event subscription before posting input, yields the
original `AgentSessionEvent` values, and finishes after the coordinator turn ends
and the session becomes idle (or the session fails). Initial idle events and
subagent completions do not end the stream. An unexpected EOF is an error.
Closing a stream releases its connection and prevents new submissions from being
claimed. A request already claimed may still arrive or finish at the server;
closing is not backend cancellation.

```java
import com.openai.core.http.StreamResponse;
import com.openai.models.beta.agents.AgentSessionEvent;
import com.openai.models.beta.agents.AgentSessionStreamParams;

AgentSessionStreamParams params = AgentSessionStreamParams.builder()
    .sessionId(sessionId)
    .input("Check the weather in Paris")
    .toolHandler("weather", args -> "Sunny")
    .build();

try (StreamResponse<AgentSessionEvent> stream = client.beta().agents().sessions().stream(params)) {
    stream.stream().forEach(event -> event.turnOutputTextDelta()
        .ifPresent(delta -> System.out.print(delta.delta())));
}
```

A handler receives a deep copy of the JSON object arguments and can return a
string, JSON object (`Map`), `List<InputContentParam>`,
`AgentFunctionCallOutputParam`, or `null`. Invalid arguments and handler exceptions
submit the generic error `Tool handler failed.` without exception details. A cancelled
handler stage is also a tool failure; cancel the stream's completion future to stop
the helper.
Unregistered functions remain available for manual handling through the event
API. Callbacks are sequential and occur after their call event is delivered;
continue consuming the stream to execute them.

The async helper uses `AsyncStreamResponse`, the client's configured stream
executor (or the executor passed to `subscribe`), and completion stages. It waits
for each handler's stage before reading more events. Closing the response or
cancelling its completion future stops consumption and closes the connection.

```java
import com.openai.core.http.AsyncStreamResponse;

AgentSessionStreamParams params = AgentSessionStreamParams.builder()
    .sessionId(sessionId)
    .input("Check the weather in Paris")
    .asyncToolHandler("weather", args -> weatherService.lookupAsync(args))
    .build();

AsyncStreamResponse<AgentSessionEvent> stream = client.async().beta().agents().sessions().stream(params);
stream.subscribe(event -> event.turnOutputTextDelta()
    .ifPresent(delta -> System.out.print(delta.delta())));
stream.onCompleteFuture().join();
```

Pass `RequestOptions` as the final argument for timeouts and response validation.
`putAdditionalHeader` on the helper params preserves request context on retrieval,
subscription, input, and every tool result. Each invocation gets a new input
idempotency key; `idempotencyKey` supplies an explicit one, and an
`Idempotency-Key` header overrides it regardless of casing. Every tool result gets
a separate key reused across transport retries and the bounded pending-call race
retry. Tool callbacks are deduplicated by `(turn_id, call_id)` for the invocation;
recent duplicate event IDs use a bounded cache.

For a message already received, concatenate its output text without fetching or
mutating anything:

```java
import com.openai.models.beta.agents.AgentSessionMessages;

String text = AgentSessionMessages.outputText(message);
```

The raw `sessions().events().streamStreaming(...)` API remains available for
following active sessions and advanced orchestration.
