# Responses WebSocket connections

The blocking and asynchronous Responses services expose `connect()`. Close each connection when finished. A response's `response.completed`, `response.failed`, or `response.incomplete` event ends that response, and leaves the connection available for another request.

```java
ResponseWebSocketOptions options = ResponseWebSocketOptions.builder()
    .putHeader("X-Client-Context", "my-application")
    .build();
try (ResponseConnection connection = client.responses().connect(options)) {
    connection.send(ResponsesClientEvent.ofResponseCreate(
        ResponsesClientEvent.ResponseCreate.builder()
            .model("gpt-4o-mini")
            .input("Hello")
            .build()));
    Response response = connection.finalResponse();
}
```

Custom handshake headers inherit the client's defaults. `Sec-WebSocket-Extensions` is reserved for OkHttp's negotiation and cannot be supplied. Per-connection headers replace same-name client headers case-insensitively; other headers, including SDK authentication, remain present. Use `connection.reconnect(newOptions)` to supply refreshed header values on an explicit reconnect. The no-argument `reconnect()` reuses the current options and refreshes credentials.

Set `.putAdditionalProperty("generate", JsonValue.from(false))` on `ResponsesClientEvent.ResponseCreate.builder()` to warm up request state without model output (`JsonValue` is in `com.openai.core`). After receiving its terminal response, pass its ID to `previousResponseId(...)` on the next request over the same connection.

Import the connection and its options from `com.openai.core.http`, and protocol types from `com.openai.models.responses`. `receive()` returns the next typed `ResponsesServerEvent`, including protocol errors. Unknown event fields and event types retain their JSON representation. `finalResponse()` consumes events until a terminal response snapshot; failed and incomplete responses retain their status and details. A protocol error fails that helper without closing the connection.

Blocking `connect()`, `receive()`, `finalResponse()`, and `reconnect()` report checked failures through the SDK's unchecked `OpenAIException` hierarchy. `WebSocketHandshakeException` retains the HTTP status, and `ResponseWebSocketException` retains the protocol event. Other checked transport failures and interrupted waits become `OpenAIIoException` with the original cause; interruption preserves the thread's interrupt flag.

For raw event processing plus accumulation, pass each received event to `ResponseAccumulator.accumulate(event)`. The overload returns the same typed event, so callers can inspect unknown fields and protocol errors while accumulating the terminal response. Use a separate accumulator for each response or lane.

The asynchronous service returns `CompletableFuture<AsyncResponseConnection>`. Its `receive()` and `finalResponse()` return futures. Canceling an unassigned receive or a response helper stops only that waiter. Once an event is assigned, cancellation returns false and that event remains available on the future. If a blocking reader is interrupted after assignment, it returns the assigned event and preserves the thread interrupt flag. There can be only one pending receive per lane. Callbacks run using the client's stream-handler executor, including for blocking connections; closing a connection does not shut down that shared executor. The default executor uses non-daemon workers. Close the owning client when it is no longer needed to release its resources promptly; closing only a connection can leave those workers alive until their idle timeout. Each socket uses a separate adapter-owned daemon reader dispatcher so an open WebSocket does not occupy the HTTP dispatcher or its executor. Closing the socket, canceling its opening, or a failed opening shuts down that reader dispatcher. A peer-initiated close allows up to one second to send its close reply; if an outstanding write prevents completion, the socket is aborted and pending readers are notified. Explicit local close aborts immediately without waiting for a running listener; terminal notification remains serialized after that listener returns.

Register a lane with `connection.lane("my-stream")` before sending its commands. IDs must match ASCII `[A-Za-z0-9_.-]{1,256}`. For `response.create`, the lane's `send()` attaches its `stream_id`; steering commands keep their original fields and route through `previous_response_id`. The lane's `receive()` and `finalResponse()` see only matching events. Unregistered streams and events without a stream ID remain on the parent connection. Closing a lane releases its queued events and fails its waiter without closing other lanes. Its ID stays reserved for the current socket's lifetime, including after a terminal event, so it cannot be registered to a replacement consumer. Later events for a closed lane reach the parent connection, including delayed events and automatic steering successors. Keep the lane open to reuse that stream for subsequent responses.

`reconnect()` explicitly replaces the socket, retains open lane registrations and handles, and releases closed-lane ID reservations. Open lanes count toward the replacement socket's `maxLanes` budget. Closed handles remain closed even if their IDs are registered again after reconnect. After an explicit `close()`, the connection is terminal and cannot reconnect; recovery remains available after a peer or transport failure. It fails pending reads and discards buffered events. It never replays a command: delivery of a command whose write was interrupted is uncertain, and callers must decide how to restore application state. A successful `send()` means accepted for writing, not acknowledged or completed by the API. A full send buffer rejects a command before enqueueing it. `maxPendingSends` bounds concurrent command serialization and send preparation (one command by default); excess calls fail before serialization and are known not to have been sent. This admission capacity is shared by all lanes and is released when `send()` returns or throws. The writer admits at most one queued or in-flight application message, bounded by `maxMessageBytes` and the native 16 MiB send limit. Pongs use a separate native queue: each received ping can enqueue a pong, and these are not coalesced or bounded by the SDK event and byte budgets. If a peer continues sending pings while application writes are blocked, that control-frame queue can grow until writes resume, an enabled write timeout expires, or the connection is closed.

## Transport and limits

The standard client uses the existing Java 8 compatible OkHttp transport for HTTP and WebSocket connections. When `maxMessageBytes` is below `Integer.MAX_VALUE`, the connection disables extension negotiation and rejects upgrade responses containing extensions before the native reader starts. This prevents compressed-message amplification for those connections. The default (`Integer.MAX_VALUE`) retains OkHttp compression negotiation. OkHttp still assembles each complete message before the SDK checks its size and delivers it, so this receive limit is not a memory-allocation bound: a single oversized uncompressed message can allocate memory before rejection, and default connections may also allocate while decompressing. Queued-event, queued-byte and cumulative response limits remain enforced.

WebSocket liveness probes follow the configured OkHttp `pingInterval`. The standard client uses zero and sends no periodic pings by default. A silent peer can leave a receive pending; cancel or close the connection to enforce an application deadline, or configure the native ping interval when active liveness detection is required.

`ResponseWebSocketOptions` configures optional maximum message and queued-byte sizes, queued event count, reserved named lane IDs per socket (64 by default), and concurrent pending sends (1). `maxLanes` includes both open and closed lane registrations, even lanes that never sent a command; it excludes the default lane. Closing a lane does not refund this budget, and invalid IDs consume no capacity. Incoming message size, queued bytes and queued event count have no additional SDK limit by default beyond their integer representations. OkHttp has a fixed 16 MiB outgoing-message budget; a larger command is rejected before enqueueing, leaving the connection usable. Set explicit byte and event budgets when required by your application. These are application limits, not API payload maxima. Memory also includes parsing, object and framing overhead. Buffer overflow fails the connection visibly; events are never silently dropped. The handshake uses the client's connection timeout, limits HTTP upgrade headers to 256 KiB (matching OkHttp), and does not follow redirects. A rejected workload-identity token is invalidated on HTTP 401, so the next explicit connection attempt refreshes it.

Connections reuse the client's base URL, credentials, custom headers, query parameters and OkHttp transport configuration, including TLS, certificate pinning, DNS, socket factories and direct, SOCKS5 or HTTP proxy routing. SOCKS4 fallback is not supported by the native OkHttp/JDK routing used here; failed proxy connections do not fall back to a direct connection. Per-connection headers and query parameters can be supplied through `ResponseWebSocketOptions`. Redirects and automatic retries for connection failures are disabled for WebSockets. OkHttp can retry the opening handshake once after HTTP 503 with `Retry-After: 0`; this occurs before any Responses command is sent and does not replay application commands. Challenge authenticators and network interceptors remain unsupported and are rejected before opening the connection. Application interceptors run normally; explicitly configured interceptors and logging remain the application's responsibility. HTTP-only custom clients continue working; `connect()` reports that the capability is unavailable. Standard token-based workload identity and `x509WorkloadIdentity(...)` are supported. X.509 connections use the same fixed client certificate for the token exchange and WebSocket TLS handshake, enforce the configured mTLS API origin, and never follow redirects. A rejected X.509 bearer is invalidated only if it is still the cached token; the next explicit connection attempt refreshes it.


For Azure, Responses WebSocket connections require unified routing; `LEGACY` and legacy endpoints detected by `AUTO` are rejected before authentication or dialing.

## Continuation, forks, and cached parents

This is the Responses protocol, separate from Realtime sessions. Each turn uses
`response.create`; leave the HTTP-only `stream` and `background` fields unset.
Continue with `previousResponseId(previous.id())` and only new input items. For
example, return a tool result with its original call ID, optionally followed by a
new message. The application executes tools and retains their results:

```java
List<ResponseInputItem> input = Arrays.asList(
    ResponseInputItem.ofFunctionCallOutput(ResponseInputItem.FunctionCallOutput.builder()
        .callId(callId).output("tool result").build()));
connection.send(ResponsesClientEvent.ofResponseCreate(
    ResponsesClientEvent.ResponseCreate.builder()
        .model("gpt-4o-mini").previousResponseId(previous.id())
        .inputOfResponse(input).build()));
```

`stream_id` controls routing and server FIFO execution; `previous_response_id`
controls lineage. Reusing a lane without a parent ID starts a new chain. Requests
on one lane execute FIFO at the service; other lanes may run concurrently. Keep
consuming the parent/default stream for connection-scoped errors as well as each
registered lane.

For a `store=false`/ZDR fork, register a different lane, send the shared parent ID,
and wait for the fork's `response.in_progress` before advancing the source lane:

```java
try (ResponseConnection.Lane fork = connection.lane("fork")) {
    fork.send(ResponsesClientEvent.ofResponseCreate(
        ResponsesClientEvent.ResponseCreate.builder()
            .model("gpt-4o-mini").store(false).previousResponseId(previous.id())
            .input("Explore another approach.").build()));
    while (true) {
        ResponsesServerEvent event = fork.receive();
        if (event.isError()) throw new ResponseWebSocketException(event);
        if (event.isResponseInProgress()) break;
        if (event.isResponseCompleted() || event.isResponseFailed() || event.isResponseIncomplete())
            throw new IllegalStateException("Fork ended before becoming ready");
    }
    // The source lane may now advance. Continue draining both lanes.
    Response forkResponse = fork.finalResponse();
}
```

The service caches recent parents on the connection. With `store=true`, older IDs
may be hydrated from persisted state. With `store=false` or ZDR, an uncached ID
fails with `previous_response_not_found`. A same-lane continuation returning 4xx/5xx
evicts its referenced parent; an errored cross-lane fork preserves the shared
parent for the source lane. Local lane registration does not preserve server cache.

## Compaction and connection rollover

For server compaction, set `contextManagement` with a `ResponseCreate.ContextManagement`
entry whose `type` is `"compaction"` and `compactThreshold` is your token threshold.
Continue using the latest response ID and only new items.

Standalone `client.responses().compact(...)` returns a compacted input window.
Start a new WebSocket chain with **all** its output items and omit or null
`previousResponseId`; do not use the compaction resource's `id()` as a continuation
ID or prune its output. `JsonValue` preserves the complete output representation:

```java
connection.send(ResponsesClientEvent.ofResponseCreate(
    ResponsesClientEvent.ResponseCreate.builder()
        .model("gpt-4o-mini")
        .input(JsonValue.from(compacted.output()))
        .build()));
```

The [WebSocket mode guide](https://developers.openai.com/api/docs/guides/websocket-mode)
defines the service limits: 16 active responses (additional creates queue), 32
distinct named streams per connection (excluding the default lane), and a
60-minute connection lifetime. These differ from SDK `maxLanes` (local ID reservations)
and `maxPendingSends` (local write admission). Closing a local lane does not remove
a stream from the service's distinct-ID count. Stream IDs are 1–256 ASCII letters,
digits, underscores, hyphens or periods; omit the ID for the default lane, since
an empty ID is invalid.

Handle these nested protocol error codes through `receive()` or the event retained
by `ResponseWebSocketException`: `previous_response_not_found` requires a usable
persisted parent or a new chain with saved full context; `invalid_stream_id`
requires correcting the ID; `websocket_stream_limit_reached` requires reusing a
stream or explicitly opening a new connection; `websocket_connection_limit_reached`
requires a new connection. Named request errors route to their lane; no-ID errors
route to the parent connection.

After explicit reconnect, every lane's server cache is gone even though Java's
open local lane registrations remain. Resume from persisted IDs when available;
otherwise send saved full context on a fresh chain without a parent ID. Retain
tool results to avoid executing tools twice. Recovery and 60-minute rollover are
application-owned: the SDK never automatically replays an interrupted command,
whose delivery may be uncertain.
