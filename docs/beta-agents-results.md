# Final answers from beta Agents streams

Use `AgentTurnResults.getFinalResult` to collect a final answer, with optional progress events and access to the turn and final messages.

```java
import com.openai.services.beta.agents.AgentTurnResults;

try (var stream = client.beta().agents().sessions().createStreaming(params)) {
    var result = AgentTurnResults.getFinalResult(stream);
    System.out.println(result.outputText());
}
```

For follow-ups, the same helper runs your tool handlers; enable collection before consuming progress.

```java
var params = AgentSessionStreamParams.builder()
    .sessionId(sessionId)
    .input("Explain the second point.")
    .toolHandler("lookup_order", arguments -> lookupOrder(arguments))
    .build();

try (var stream = AgentTurnResults.withResultCollection(
        client.beta().agents().sessions().stream(params))) {
    stream.stream().forEach(event -> showProgress(event));
    var result = AgentTurnResults.getFinalResult(stream);
    System.out.println(result.outputText());
}
```

Async streams return a `CompletableFuture<AgentTurnResult>`; subscribing to progress is optional.

```java
var stream = AgentTurnResults.withResultCollection(
    client.async().beta().agents().sessions().createStreaming(params));
stream.subscribe(event -> showProgress(event)); // Optional.
AgentTurnResults.getFinalResult(stream)
    .thenAccept(result -> System.out.println(result.outputText()));
```

## Typed answers

Use one `AgentOutputType` for the agent's schema and the final-result parser; reuse it for follow-ups with the same schema.

```java
public class Report {
    public String summary;
    public java.util.List<String> findings;
}

var output = AgentOutputType.of(Report.class);
var params = SessionCreateParams.builder()
    .agent(SessionCreateParams.Agent.builder().model("gpt-6-astra")
        .instructions("Write a concise report.").text(output.text()).build())
    .environmentNone().input("Summarize the supplied notes.").build();
try (var stream = client.beta().agents().sessions().createStreaming(params)) {
    var result = AgentTurnResults.getFinalResult(stream, output);
    Report report = result.outputParsed();
    System.out.println(report.summary);
}
```

`Report` is an ordinary Java class, as with Responses structured outputs; parsing errors expose the completed `rawResult()`.
