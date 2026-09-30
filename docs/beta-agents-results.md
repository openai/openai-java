# Final answers from beta Agents streams

Use `AgentTurnResults.getFinalResult` to collect a final answer, with optional progress events and access to the turn and final messages.

```java
import com.openai.services.beta.agents.AgentTurnResults;

try (var stream = client.beta().agents().sessions().createStreaming(params)) {
    var result = AgentTurnResults.getFinalResult(stream);
    System.out.println(result.outputText());
}
```

For follow-ups, the same helper consumes events and runs your registered tool handlers.

```java
var params = AgentSessionStreamParams.builder()
    .sessionId(sessionId)
    .input("Explain the second point.")
    .toolHandler("lookup_order", arguments -> lookupOrder(arguments))
    .build();

try (var stream = client.beta().agents().sessions().stream(params)) {
    stream.stream().forEach(event -> showProgress(event));
    var result = AgentTurnResults.getFinalResult(stream);
    System.out.println(result.outputText());
}
```

Async streams return a `CompletableFuture<AgentTurnResult>`; subscribing to progress is optional.

```java
var stream = client.async().beta().agents().sessions().createStreaming(params);
stream.subscribe(event -> showProgress(event)); // Optional.
AgentTurnResults.getFinalResult(stream)
    .thenAccept(result -> System.out.println(result.outputText()));
```
