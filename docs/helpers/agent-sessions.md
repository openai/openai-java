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

## Typed application tools (beta)

Bind an argument class and application callback once. Jackson's `@JsonTypeName`
and `@JsonClassDescription` set the hosted name and description, as with other
class-based SDK tools.
Unsupported constraint annotations, such as `@Schema(maximum = "10")`, are rejected;
validate those business rules in your callback instead.

```java
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.openai.helpers.beta.agents.AgentFunctionTool;

@JsonTypeName("lookup_order")
@JsonClassDescription("Look up an order.")
class LookupOrder { public String orderId; }

var lookup = AgentFunctionTool.of(LookupOrder.class, args -> orderService.lookup(args.orderId));
// Include lookup.definition() in the agent's tools when configuring the session.
var params = AgentSessionStreamParams.builder()
    .sessionId(sessionId)
    .input("Where is order A123?")
    .toolHandler(lookup.name(), lookup.handler())
    .build();
```

For callbacks returning a `CompletionStage`, use `AgentFunctionTool.ofAsync(...)`
and register with `.asyncToolHandler(tool.name(), tool.handler())`. Attach either
binding to an existing session using its hosted tool name. Application services
and credentials stay in the closure or bound method. Use strings for exact decimal
amounts, as the existing event decoder represents JSON fractions as doubles. See
[`BetaAgentToolsExample`](../../openai-java-example/src/main/java/com/openai/example/BetaAgentToolsExample.java)
for a read-only catalog lookup.
