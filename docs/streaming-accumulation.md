# Streaming accumulation and final results

Use one accumulator per request and feed it every event in order. Accumulators are
not shared between concurrent requests. The existing synchronous and asynchronous
streaming APIs both work with these helpers.

## Chat Completions

```java
ChatCompletionAccumulator accumulator = ChatCompletionAccumulator.create();
try (StreamResponse<ChatCompletionChunk> stream =
        client.chat().completions().createStreaming(params)) {
    stream.stream().forEach(accumulator::accumulate);
}
ChatCompletion result = accumulator.chatCompletion();
```

Consume the whole stream before reading the result: an optional usage chunk can
arrive after the choices finish. The accumulator combines text, refusals, tool
arguments, and legacy `function_call` fragments. It requires finish reasons for
all observed choices, except for the supported terminal audio update that implies
`stop`; EOF by itself does not finish an unfinished choice. The
legacy field is supported for compatibility; use `tool_calls` for new code.

For asynchronous streams, subscribe with `accumulator::accumulate` and wait for
`onCompleteFuture()` to complete successfully before accessing the final result.
Stream errors propagate through that future.

## Responses

```java
ResponseAccumulator accumulator = ResponseAccumulator.createWithSnapshots();
try (StreamResponse<ResponseStreamEvent> stream = client.responses().createStreaming(params)) {
    stream.stream().forEach(event -> {
        accumulator.accumulate(event);
        accumulator.snapshot().ifPresent(snapshot -> {
            // Render supported partial output. This is not a successful final result.
        });
    });
}
Response result = accumulator.response();
```

`create()` retains the terminal response without building progress snapshots.
`createWithSnapshots()` additionally exposes immutable snapshots for supported
output events. Earlier snapshots do not change as more events arrive.

`response()` returns the authoritative terminal response, including a `failed`
or `incomplete` status and its error or incomplete details. Check the status
before treating it as success. EOF without a terminal event does not create a
final response, and `response()` throws in that case.

When snapshots are enabled, `reconstructedResponse()` can recover omitted or null
terminal output from finalized `response.output_item.done` events. It does not
promote unfinished deltas into final output. Explicit terminal output, including
an empty list, wins; terminal status, errors, and usage remain authoritative.

## Closing and coverage

Always close synchronous streams, including when stopping consumption early.
Closing an OkHttp-backed stream from another thread cancels a blocked socket read
before serializing buffer cleanup. Fully consumed responses retain connection
reuse.

The controlled HTTP/SSE contract tests cover synchronous and asynchronous Chat
text, refusals, tools, legacy calls and usage; Responses text/tool snapshots,
completed/failed/incomplete terminal states; truncated streams; split UTF-8/SSE
boundaries; and blocked synchronous close. Existing accumulator, parser and
large-payload regressions supplement these tests. This is offline SDK validation,
not a hosted-model qualification or a statement about published release coverage.
