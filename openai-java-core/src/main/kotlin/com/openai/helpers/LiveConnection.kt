package com.openai.helpers

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationFeature
import com.google.errorprone.annotations.MustBeClosed
import com.openai.azure.AzureUrlCategory
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.http.utf8Size
import com.openai.core.prepare
import com.openai.errors.OpenAIIoException
import com.openai.models.live.ClientEvent
import com.openai.models.live.ServerEvent
import java.io.IOException
import java.net.URI
import java.net.URLDecoder
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

/**
 * Primary Live WebSocket. The completed connect opens only the transport; it never starts a
 * session. The caller sends ClientEvent.ofSessionStart(...) and consumes events until the server
 * acknowledges with session.started. Send model/session configuration in that command, not in the
 * URL. Fork and sideband sockets use different startup and authorization contracts.
 *
 * Consume typed events synchronously or asynchronously, with at most one pending receive. Unknown
 * events retain their original JSON; error events are ordinary events and never discarded on close.
 * After sending ClientEvent.ofSessionClose(...), keep receiving until session.closed for the final
 * usage and close reason, then release this connection. close() itself only releases the transport;
 * it never creates or replays a protocol command. Canceling a pending receive leaves the next event
 * available, so receiveAsync().get(timeout, unit) can be followed by explicit cancellation on
 * timeout.
 *
 * ClientOptions must use a WebSocketClient, such as the SDK OkHttpClient. Its request preparation
 * supplies configured authorization, headers and query parameters. Closing this connection leaves
 * that shared client open.
 * <pre>
 * try (LiveConnection live = LiveConnection.connect(clientOptions)) {
 *     live.send(ClientEvent.ofSessionStart(SessionStartEvent.builder()
 *         .session(SessionConfig.builder().model("live-test").build()).build()));
 *     ServerEvent event = live.receive();
 *     // Inspect session.started, errors, and other server events before sending audio or commands.
 *     live.send(ClientEvent.ofSessionClose(SessionCloseEvent.builder().build()));
 *     while (!live.receive().isSessionClosed()) { }
 * }
 * </pre>
 */
class LiveConnection private constructor(private val socket: LiveSocket<ClientEvent, ServerEvent>) :
    AutoCloseable {
    companion object {
        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): LiveConnection = LiveSocket.await(open(clientOptions, options, requestOptions, true))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<LiveConnection> = open(clientOptions, options, requestOptions, false)

        private fun open(
            clientOptions: ClientOptions,
            options: LiveWebSocketOptions,
            requestOptions: RequestOptions,
            blocking: Boolean,
        ) =
            LiveSocket<ClientEvent, ServerEvent>(
                    clientOptions,
                    options,
                    requestOptions,
                    listOf("live", "sessions"),
                    ServerEvent::class.java,
                    { it.validate() },
                )
                .open(blocking, ::LiveConnection)
    }

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): ServerEvent = socket.receive()

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<ServerEvent> = socket.receiveAsync()

    /**
     * Successful send means accepted by the transport, not acknowledged by the server. A failed
     * write makes the connection unusable because the remote outcome is uncertain. The caller can
     * explicitly open a fresh connection; no commands are replayed.
     */
    fun send(event: ClientEvent) = socket.send(event)

    override fun close() = socket.close()
}

/** Physical connection ownership for the primary and fork Live event universes. */
internal class LiveSocket<C : Any, S : Any>(
    private val clientOptions: ClientOptions,
    private val options: LiveWebSocketOptions,
    private val requestOptions: RequestOptions,
    private val path: List<String>,
    eventType: Class<S>,
    private val validate: (S) -> Unit,
) : AutoCloseable {
    private val lock = Any()
    private val reader =
        clientOptions.jsonMapper
            .readerFor(eventType)
            .with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)

    private class Item<S>(val event: S, val bytes: Long)

    private val queue = ArrayDeque<Item<S>>()
    private var queuedBytes = 0L
    private var socket: WebSocketClient.Connection? = null
    private var opening: CompletableFuture<WebSocketClient.Connection>? = null
    private var waiter: ReadFuture? = null
    private var failure: Throwable? = null
    private var closed = false
    private var sending = false

    // Assign a read without invoking arbitrary CompletableFuture callbacks while holding lock.
    // Once assigned it cannot be canceled and silently discard a server event.
    private inner class ReadFuture(val blocking: Boolean) : CompletableFuture<S>() {
        var claimed = false
        var cancellationReserved = false

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
            synchronized(lock) {
                if (claimed) return false
                if (isDone) return isCancelled
                cancellationReserved = true
            }
            return super.cancel(mayInterruptIfRunning)
        }
    }

    fun <T : AutoCloseable> open(
        blocking: Boolean,
        create: (LiveSocket<C, S>) -> T,
    ): CompletableFuture<T> {
        val connection = this
        val result = CompletableFuture<T>()
        result.whenComplete { _, _ -> if (result.isCancelled) connection.close() }
        try {
            clientOptions.requireWebSocketTransport()
            val baseUrl = URI(clientOptions.baseUrl())
            val requestBase = baseUrl.toASCIIString().substringBefore('#').substringBefore('?')
            require(
                AzureUrlCategory.categorizeBaseUrl(requestBase, clientOptions.azureUrlPathMode) !=
                    AzureUrlCategory.AZURE_LEGACY
            ) {
                "Live WebSockets require unified Azure routing"
            }
            // HttpRequest.url() appends segments to baseUrl. Canonicalize before both
            // authentication and transport so custom WebSocketClient implementations see
            // the same URL that OkHttp sends.
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(requestBase)
                    .pathSegments(path)
                    .apply {
                        baseUrl.rawQuery
                            ?.split('&')
                            ?.filter { it.isNotEmpty() }
                            ?.forEach {
                                putQueryParam(
                                    URLDecoder.decode(it.substringBefore('='), "UTF-8"),
                                    URLDecoder.decode(it.substringAfter('=', ""), "UTF-8"),
                                )
                            }
                    }
                    .build()
                    .prepare(
                        clientOptions,
                        options,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
                    // Live requires unified routing as checked above. Shared request
                    // preparation can still classify the original query-bearing base URL as
                    // legacy; retain all prepared auth/defaults and this exact Live endpoint.
                    .toBuilder()
                    .pathSegments(path)
                    .build()
            val pending =
                clientOptions.connectWebSocket(
                    request,
                    requestOptions,
                    options.maxMessageBytes,
                    object : WebSocketClient.Listener {
                        override fun onMessage(text: String) = connection.accept(text)

                        override fun onClosed(code: Int) =
                            connection.fail(IOException("Live WebSocket closed (code $code)"))

                        override fun onFailure(error: Throwable) = connection.fail(error)
                    },
                )
            val shouldCancel =
                synchronized(connection.lock) {
                    if (connection.closed || connection.failure != null) true
                    else {
                        connection.opening = pending
                        false
                    }
                }
            if (shouldCancel) pending.cancel(true)
            pending.whenComplete { active, error ->
                val problem =
                    synchronized(connection.lock) {
                        connection.opening = null
                        if (error != null) error
                        else if (connection.closed || connection.failure != null)
                            connection.failure ?: CancellationException("Live connection closed")
                        else {
                            connection.socket = active
                            null
                        }
                    }
                val complete: () -> Unit = {
                    // The owner or socket can close while completion waits on the executor.
                    // Inspect state here, but keep user callbacks outside the lock.
                    val completionError =
                        problem
                            ?: synchronized(connection.lock) {
                                when {
                                    connection.failure != null -> connection.failure
                                    connection.closed ->
                                        CancellationException("Live connection closed")
                                    clientOptions.isWebSocketClosed() ->
                                        CancellationException("Client is closed")
                                    else -> null
                                }
                            }
                    if (completionError != null) {
                        connection.fail(completionError)
                        result.completeExceptionally(completionError)
                    } else if (!result.complete(create(connection))) connection.close()
                }
                if (problem != null) {
                    connection.fail(problem)
                    // The handshake produced a socket after cancellation or an early
                    // listener failure. It was never stored in connection.socket.
                    // Retire it off the completing/transport thread and settle opening even
                    // if the transport's close throws.
                    CompletableFuture.runAsync {
                        try {
                            active?.close()
                        } catch (closing: Throwable) {
                            if (closing !== problem) problem.addSuppressed(closing)
                        } finally {
                            if (blocking) complete() else connection.dispatch(complete)
                        }
                    }
                } else {
                    // A synchronous open uses an unexposed future with no user callbacks.
                    // It must not queue completion behind its blocking caller's executor.
                    if (blocking) complete() else connection.dispatch(complete)
                }
            }
        } catch (error: Exception) {
            connection.fail(error)
            result.completeExceptionally(error)
        }
        return result
    }

    companion object {
        fun <T> await(future: CompletableFuture<T>): T {
            var interrupted = false
            try {
                while (true) {
                    try {
                        return future.get()
                    } catch (error: InterruptedException) {
                        interrupted = true
                        if (future.cancel(false))
                            throw OpenAIIoException("Live WebSocket operation interrupted", error)
                    } catch (error: ExecutionException) {
                        val cause = error.cause ?: error
                        throw when (cause) {
                            is RuntimeException -> cause
                            is Error -> cause
                            else -> OpenAIIoException("Live WebSocket operation failed", cause)
                        }
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt()
            }
        }
    }

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): S = await(receiveFuture(blocking = true))

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<S> = receiveFuture(blocking = false)

    private fun receiveFuture(blocking: Boolean): CompletableFuture<S> {
        synchronized(lock) {
            check(!closed) { "Live connection is closed" }
            if (waiter?.let { it.isDone || it.cancellationReserved } == true) waiter = null
            check(waiter == null) { "A Live receive is already pending" }
            if (queue.isNotEmpty()) {
                val item = queue.removeFirst()
                queuedBytes -= item.bytes
                return CompletableFuture.completedFuture(item.event)
            }
            failure?.let {
                return CompletableFuture<S>().apply { completeExceptionally(it) }
            }
            return ReadFuture(blocking).also { next ->
                waiter = next
                next.whenComplete { _, _ ->
                    synchronized(lock) { if (waiter === next) waiter = null }
                }
            }
        }
    }

    /**
     * Successful send means accepted by the transport, not acknowledged by the server. A failed
     * write makes the connection unusable because the remote outcome is uncertain. The caller can
     * explicitly open a fresh connection; no commands are replayed.
     */
    fun send(event: C, checkCommand: (String) -> Unit = {}) {
        synchronized(lock) {
            check(!closed && failure == null && socket != null) { "Live is not connected" }
            check(!sending) { "A Live send is already pending; command was not sent" }
            sending = true
        }
        try {
            val text = clientOptions.jsonMapper.writeValueAsString(event)
            checkCommand(text)
            require(utf8Size(text) <= options.maxMessageBytes) {
                "Live command exceeds maxMessageBytes"
            }
            val active =
                synchronized(lock) {
                    check(!closed && failure == null) { "Live is not connected" }
                    socket ?: throw IllegalStateException("Live is not connected")
                }
            try {
                active.send(text)
            } catch (error: Throwable) {
                if (error !is WebSocketWriteNotAttempted) fail(error)
                throw error
            }
        } finally {
            synchronized(lock) { sending = false }
        }
    }

    override fun close() {
        synchronized(lock) {
            if (closed) return
            closed = true
            queue.clear()
            queuedBytes = 0
        }
        fail(CancellationException("Live connection closed"))
    }

    private fun accept(text: String) {
        try {
            // Reject malformed envelopes independently of lenient or user-supplied model readers.
            clientOptions.jsonMapper.factory.createParser(text).use { parser ->
                require(parser.nextToken() == JsonToken.START_OBJECT) { "Invalid Live event" }
                var validType = false
                while (parser.nextToken() == JsonToken.FIELD_NAME) {
                    val name = parser.currentName
                    val token = parser.nextToken()
                    if (name == "type") validType = token == JsonToken.VALUE_STRING
                    parser.skipChildren()
                }
                require(
                    parser.currentToken() == JsonToken.END_OBJECT &&
                        validType &&
                        parser.nextToken() == null
                ) {
                    "Invalid Live event"
                }
            }
            val event: S = reader.readValue(text)
            if (requestOptions.responseValidation ?: clientOptions.responseValidation)
                validate(event)
            val bytes = utf8Size(text)
            val target =
                synchronized(lock) {
                    if (closed || failure != null) return
                    val available =
                        waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                    if (available == null) {
                        if (
                            queue.size >= options.maxQueuedEvents ||
                                bytes > options.maxQueuedBytes - queuedBytes
                        )
                            throw IOException("Live event buffer is full")
                        queue.addLast(Item(event, bytes))
                        queuedBytes += bytes
                    } else available.claimed = true
                    available
                }
            if (target != null) {
                // Only our private blocking read may be completed directly. It cannot expose
                // user callbacks on the physical reader or compete for the caller's executor.
                if (target.blocking) target.complete(event) else dispatch { target.complete(event) }
            }
        } catch (error: Exception) {
            fail(error)
        }
    }

    private fun fail(error: Throwable) {
        val detached =
            synchronized(lock) {
                if (failure != null) return
                failure = error
                val unassigned =
                    waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                waiter = null
                Triple(socket, opening, unassigned).also {
                    socket = null
                    opening = null
                }
            }
        // Listener callbacks can run on a custom transport's dedicated reader, and its
        // close() may join that reader. Never cancel an opening or close a socket on that thread.
        CompletableFuture.runAsync {
            try {
                detached.second?.cancel(true)
                detached.first?.close()
            } catch (closing: Throwable) {
                if (closing !== error) error.addSuppressed(closing)
            } finally {
                detached.third?.let { read ->
                    if (read.blocking) read.completeExceptionally(error)
                    else dispatch { read.completeExceptionally(error) }
                }
            }
        }
    }

    // User completion callbacks never run on the transport reader, including with a direct
    // executor.
    private fun dispatch(action: () -> Unit) {
        CompletableFuture.runAsync {
            try {
                clientOptions.streamHandlerExecutor.execute(action)
            } catch (_: java.util.concurrent.RejectedExecutionException) {
                action()
            }
        }
    }
}
