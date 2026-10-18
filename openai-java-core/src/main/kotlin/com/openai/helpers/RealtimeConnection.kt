package com.openai.helpers

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationFeature
import com.google.errorprone.annotations.MustBeClosed
import com.openai.azure.AzureUrlCategory
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketHandshakeException
import com.openai.core.http.WebSocketReadFuture
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.http.awaitWebSocketFuture
import com.openai.core.http.dispatchWebSocketCallback
import com.openai.core.http.utf8Size
import com.openai.core.prepare
import com.openai.errors.OpenAIIoException
import com.openai.models.realtime.RealtimeClientEvent
import com.openai.models.realtime.RealtimeServerEvent
import java.io.IOException
import java.net.ProtocolException
import java.time.Duration
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLException

/**
 * Managed GA Realtime connection. Consume typed events synchronously or asynchronously, with one
 * outstanding receive at a time. API error events remain ordinary received events. Valid future
 * event types retain their raw JSON through RealtimeServerEvent._json(). No event is replayed. As
 * with the SDK's other response APIs, explicitly enabling responseValidation uses strict generated
 * validation, which can reject types newly introduced by the server. Validation is off by default.
 * RequestOptions can override the client setting for this connection.
 *
 * Create ClientOptions using an HTTP client that implements WebSocketClient (such as the SDK's
 * OkHttpClient). Those options retain headers, base URL, credentials and defaults. Closing this
 * connection does not close the HTTP client or other connections. Explicit reconnect returns a
 * fresh connection and refreshes credentials; callers decide which session state to restore.
 */
class RealtimeConnection
private constructor(
    private val clientOptions: ClientOptions,
    private val options: RealtimeWebSocketOptions,
    private val requestOptions: RequestOptions,
) : AutoCloseable {
    private val lock = Any()
    private val reader =
        clientOptions.jsonMapper
            .readerFor(RealtimeServerEvent::class.java)
            .with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)

    private class Item(val event: RealtimeServerEvent, val bytes: Long)

    private class Write {
        var notAttempted: Boolean? = null
        var disconnected: (() -> Unit)? = null
    }

    private val queue = ArrayDeque<Item>()
    private var queuedBytes = 0L
    private var socket: WebSocketClient.Connection? = null
    private var opening: CompletableFuture<WebSocketClient.Connection>? = null
    private var waiter: WebSocketReadFuture<RealtimeServerEvent>? = null
    private var failure: Throwable? = null
    private var closed = false
    private var sending = false
    private var write: Write? = null
    private var generation = 0L
    private var recovering = false
    private var attempts = 0
    private var retryTimer: ScheduledFuture<*>? = null
    private val pending = ArrayDeque<String>()
    private var pendingBytes = 0L
    private var flushing = false
    private val ownerLifetime = if (options.reconnect) CompletableFuture<Void>() else null

    companion object {
        private val recoveryTimer =
            ScheduledThreadPoolExecutor(1) { task ->
                    Thread(task, "openai-realtime-recovery").apply { isDaemon = true }
                }
                .apply { removeOnCancelPolicy = true }

        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            options: RealtimeWebSocketOptions = RealtimeWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): RealtimeConnection =
            await(connectAsync(clientOptions, options, requestOptions, blocking = true))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            options: RealtimeWebSocketOptions = RealtimeWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<RealtimeConnection> =
            connectAsync(clientOptions, options, requestOptions, blocking = false)

        private fun connectAsync(
            clientOptions: ClientOptions,
            options: RealtimeWebSocketOptions,
            requestOptions: RequestOptions,
            blocking: Boolean,
        ): CompletableFuture<RealtimeConnection> {
            val connection = RealtimeConnection(clientOptions, options, requestOptions)
            val result = CompletableFuture<RealtimeConnection>()
            result.whenComplete { _, _ -> if (result.isCancelled) connection.close() }
            connection.ownerLifetime?.let { lifetime ->
                lifetime.whenComplete { _, _ ->
                    if (lifetime.isCancelled) {
                        val error = CancellationException("Client is closed")
                        connection.fail(error)
                        if (!result.isDone) connection.completeFailure(result, error, blocking)
                    }
                }
                clientOptions.trackWebSocketLifetime(lifetime)
            }
            connection.open(result, blocking)
            return result
        }

        private fun <T> await(future: CompletableFuture<T>): T =
            awaitWebSocketFuture(future, "Realtime")
    }

    private fun open(result: CompletableFuture<RealtimeConnection>, blocking: Boolean) {
        val epoch =
            synchronized(lock) {
                if (closed || failure != null) return
                retryTimer = null
                ++generation
            }
        try {
            clientOptions.requireWebSocketTransport()
            require(
                AzureUrlCategory.categorizeBaseUrl(
                    clientOptions.baseUrl(),
                    clientOptions.azureUrlPathMode,
                ) != AzureUrlCategory.AZURE_LEGACY
            ) {
                "GA Realtime WebSockets require unified Azure routing"
            }
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .pathSegments(
                        com.openai.models.realtime.RealtimeWebSocketBinding.create().pathSegments
                    )
                    .build()
                    .prepare(
                        clientOptions,
                        options,
                        com.openai.models.realtime.RealtimeWebSocketBinding.create().security,
                    )
            if (options.reconnect) {
                val baseQueryKeys =
                    java.net
                        .URI(request.baseUrl)
                        .rawQuery
                        ?.split('&')
                        ?.map { java.net.URLDecoder.decode(it.substringBefore('='), "UTF-8") }
                        .orEmpty()
                require(
                    "intent" !in baseQueryKeys &&
                        "call_id" !in baseQueryKeys &&
                        request.queryParams.values("intent").isEmpty() &&
                        request.queryParams.values("call_id").isEmpty()
                ) {
                    "Automatic Realtime recovery requires a model session"
                }
            }
            if (synchronized(lock) { generation != epoch || closed || failure != null }) return
            val pending =
                clientOptions.connectWebSocket(
                    request,
                    requestOptions,
                    options.maxMessageBytes,
                    object : WebSocketClient.Listener {
                        override fun onMessage(text: String) = accept(text, epoch)

                        override fun onClosed(code: Int) {
                            disconnect(
                                epoch,
                                IOException("GA Realtime WebSocket closed (code $code)"),
                                code in setOf(1006, 1011, 1012, 1013),
                                result,
                                blocking,
                            )
                        }

                        override fun onFailure(error: Throwable) {
                            disconnect(epoch, error, canRetry(error), result, blocking)
                        }
                    },
                )
            val shouldCancel =
                synchronized(lock) {
                    if (closed || failure != null || generation != epoch) true
                    else {
                        this.opening = pending
                        false
                    }
                }
            if (shouldCancel) pending.cancel(true)
            pending.whenComplete { active, error ->
                if (error != null) {
                    if (disconnect(epoch, error, canRetry(error), result, blocking))
                        synchronized(lock) { failure }
                            ?.let { completeFailure(result, it, blocking) }
                    return@whenComplete
                }
                val (stale, problem) =
                    synchronized(lock) {
                        if (generation != epoch) true to failure
                        else {
                            opening = null
                            false to
                                if (closed || failure != null)
                                    failure ?: CancellationException("Realtime connection closed")
                                else {
                                    socket = active
                                    recovering = false
                                    null
                                }
                        }
                    }
                if (stale) {
                    try {
                        active?.close()
                    } catch (closing: Throwable) {
                        if (problem != null && closing !== problem) problem.addSuppressed(closing)
                    } finally {
                        problem?.let { completeFailure(result, it, blocking) }
                    }
                    return@whenComplete
                }
                if (problem != null) {
                    try {
                        active?.close()
                    } catch (closing: Throwable) {
                        if (closing !== problem) problem.addSuppressed(closing)
                    }
                    this.fail(problem)
                }
                val complete: () -> Unit = completion@{
                    if (result.isDone && synchronized(lock) { generation != epoch })
                        return@completion
                    // The owner or socket can close while completion waits on the executor.
                    // Inspect state here, but keep user callbacks outside the lock.
                    val completionError =
                        problem
                            ?: synchronized(lock) {
                                when {
                                    this.failure != null -> this.failure
                                    this.closed ->
                                        CancellationException("Realtime connection closed")
                                    clientOptions.isWebSocketClosed() ->
                                        CancellationException("Client is closed")
                                    else -> null
                                }
                            }
                    if (completionError != null) {
                        this.fail(completionError)
                        result.completeExceptionally(completionError)
                    } else if (!result.isDone) {
                        if (!result.complete(this)) close()
                    } else if (result.isCancelled) close()
                    else {
                        try {
                            options.onReconnected?.accept(this)
                        } catch (callbackError: Exception) {
                            fail(callbackError, callbackEpoch = epoch)
                        }
                    }
                }
                // Blocking futures are private: a caller may already occupy the stream
                // executor. Public async continuations must still leave the transport reader.
                if (blocking && !result.isDone) complete() else this.dispatch(complete)
            }
        } catch (error: Exception) {
            disconnect(epoch, error, canRetry(error), result, blocking)
        }
    }

    private fun canRetry(error: Throwable): Boolean {
        var cause: Throwable? = error
        var root = error
        val seen =
            java.util.Collections.newSetFromMap(java.util.IdentityHashMap<Throwable, Boolean>())
        while (cause != null && seen.add(cause)) {
            if (
                cause is SSLException ||
                    cause is CancellationException ||
                    cause is ProtocolException
            )
                return false
            if (cause === root && (cause is CompletionException || cause is OpenAIIoException))
                root = cause.cause ?: cause
            cause = cause.cause
        }
        return root is IOException ||
            (root is WebSocketHandshakeException &&
                root.statusCode in setOf(408, 429, 500, 502, 503, 504))
    }

    private fun completeFailure(
        result: CompletableFuture<RealtimeConnection>,
        error: Throwable,
        blocking: Boolean,
    ) {
        if (blocking) result.completeExceptionally(error)
        else dispatch { result.completeExceptionally(error) }
    }

    private fun disconnect(
        epoch: Long,
        error: Throwable,
        retryable: Boolean,
        result: CompletableFuture<RealtimeConnection>,
        blocking: Boolean,
    ): Boolean {
        val retired =
            synchronized(lock) {
                if (generation != epoch) return true
                if (
                    !closed &&
                        failure == null &&
                        options.reconnect &&
                        retryable &&
                        (socket != null || recovering) &&
                        attempts < options.maxReconnectAttempts
                ) {
                    val activeWrite = write
                    if (activeWrite != null && activeWrite.notAttempted == null) {
                        if (activeWrite.disconnected == null)
                            activeWrite.disconnected = {
                                disconnect(epoch, error, retryable, result, blocking)
                            }
                        return true
                    }
                    if (activeWrite?.notAttempted == false) return@synchronized null
                    write = null
                    generation++
                    recovering = true
                    attempts++
                    val old = Pair(socket, opening)
                    socket = null
                    opening = null
                    val delay =
                        (options.reconnectDelayMillis * (1L shl minOf(attempts - 1, 14)))
                            .coerceAtMost(8000)
                    retryTimer =
                        recoveryTimer.schedule(
                            { CompletableFuture.runAsync { open(result, blocking) } },
                            delay,
                            TimeUnit.MILLISECONDS,
                        )
                    old
                } else null
            }
        if (retired != null) {
            retired.second?.cancel(true)
            try {
                retired.first?.close()
            } catch (_: Exception) {
                /* Preserve the initiating error. */
            }
            return true
        }
        fail(error)
        completeFailure(result, error, blocking)
        return false
    }

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): RealtimeServerEvent = await(receiveAsync(blocking = true))

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<RealtimeServerEvent> = receiveAsync(blocking = false)

    private fun receiveAsync(blocking: Boolean): CompletableFuture<RealtimeServerEvent> {
        synchronized(lock) {
            check(!closed) { "Realtime connection is closed" }
            if (waiter?.let { it.isDone || it.cancellationReserved } == true) waiter = null
            check(waiter == null) { "A Realtime receive is already pending" }
            if (queue.isNotEmpty()) {
                val item = queue.removeFirst()
                queuedBytes -= item.bytes
                return CompletableFuture.completedFuture(item.event)
            }
            failure?.let {
                return CompletableFuture<RealtimeServerEvent>().apply { completeExceptionally(it) }
            }
            return WebSocketReadFuture<RealtimeServerEvent>(lock, blocking).also { next ->
                waiter = next
                next.whenComplete { _, _ ->
                    synchronized(lock) { if (waiter === next) waiter = null }
                }
            }
        }
    }

    /**
     * Successful send means accepted by the transport, not acknowledged by the server. A failed
     * write makes the connection unusable because the remote outcome is uncertain. Reconnect never
     * resends the command.
     */
    fun send(event: RealtimeClientEvent) {
        val (epoch, admittedDuringRecovery) =
            synchronized(lock) {
                if (closed || failure != null || (socket == null && !recovering))
                    throw WebSocketWriteNotAttempted.Closed("Realtime is not connected")
                if (flushing)
                    throw WebSocketWriteNotAttempted.Busy(
                        "A Realtime flush is already pending; command was not sent"
                    )
                if (sending || write != null)
                    throw WebSocketWriteNotAttempted.Busy(
                        "A Realtime send is already pending; command was not sent"
                    )
                sending = true
                generation to recovering
            }
        var notAttempted = false
        try {
            val text = clientOptions.jsonMapper.writeValueAsString(event)
            val size = utf8Size(text)
            require(size <= options.maxMessageBytes) { "Realtime command exceeds maxMessageBytes" }
            val active =
                synchronized(lock) {
                    if (closed || failure != null)
                        throw WebSocketWriteNotAttempted.Closed("Realtime is not connected")
                    if (admittedDuringRecovery || generation != epoch) {
                        if (size > options.maxPendingBytes - pendingBytes)
                            throw WebSocketWriteNotAttempted.Busy(
                                "Realtime recovery queue is full; command was not sent"
                            )
                        pending.addLast(text)
                        pendingBytes += size
                        return
                    }
                    val active =
                        socket
                            ?: throw WebSocketWriteNotAttempted.Closed("Realtime is not connected")
                    write = Write()
                    active
                }
            try {
                active.send(text)
            } catch (error: Throwable) {
                notAttempted = error is WebSocketWriteNotAttempted
                if (!notAttempted) fail(error)
                throw error
            }
        } finally {
            finishWrite(notAttempted) { sending = false }
        }
    }

    /** Remove retained, never-attempted JSON commands without sending them. */
    fun takePending(): List<String> =
        synchronized(lock) {
            check(!flushing) { "A Realtime flush is pending" }
            pending.toList().also {
                pending.clear()
                pendingBytes = 0
            }
        }

    /** Send retained commands in order after the application restores session state. */
    fun flushPending() {
        synchronized(lock) {
            requireActiveSocket(message = "Realtime cannot flush now")
            if (flushing || sending || write != null)
                throw WebSocketWriteNotAttempted.Busy("Realtime cannot flush now")
            flushing = true
        }
        var notAttempted = false
        try {
            while (true) {
                val next =
                    synchronized(lock) {
                        val active = requireActiveSocket()
                        if (pending.isEmpty()) return
                        Pair(active, pending.first)
                    }
                awaitWritable(next.first)
                synchronized(lock) {
                    requireActiveSocket(next.first)
                    pending.removeFirst()
                    pendingBytes -= utf8Size(next.second)
                    write = Write()
                }
                try {
                    next.first.send(next.second)
                } catch (error: Throwable) {
                    if (error is WebSocketWriteNotAttempted)
                        synchronized(lock) {
                            pending.addFirst(next.second)
                            pendingBytes += utf8Size(next.second)
                            notAttempted = true
                        }
                    else fail(error)
                    throw error
                }
                finishWrite()
            }
        } finally {
            finishWrite(notAttempted) { flushing = false }
        }
    }

    private fun finishWrite(notAttempted: Boolean = false, release: () -> Unit = {}) {
        var disconnected: (() -> Unit)? = null
        val active =
            synchronized(lock) {
                val active = write
                active?.notAttempted = notAttempted
                disconnected = active?.disconnected
                if (disconnected == null) write = null
                release()
                active
            }
        try {
            disconnected?.invoke()
        } finally {
            synchronized(lock) { if (write === active) write = null }
        }
    }

    // Caller holds lock.
    private fun requireActiveSocket(
        expected: WebSocketClient.Connection? = null,
        message: String = "Realtime is not connected",
    ): WebSocketClient.Connection {
        val active = socket
        if (
            closed ||
                failure != null ||
                recovering ||
                active == null ||
                (expected != null && active !== expected)
        )
            throw WebSocketWriteNotAttempted.Closed(message)
        return active
    }

    private fun awaitWritable(active: WebSocketClient.Connection) {
        if (active !is WebSocketClient.WritableConnection) return
        val timeout =
            (requestOptions.timeout?.assign(clientOptions.timeout) ?: clientOptions.timeout).write()
        while (true) {
            try {
                active.awaitWritable(if (timeout.isZero) Duration.ofSeconds(1) else timeout)
                return
            } catch (error: InterruptedException) {
                Thread.currentThread().interrupt()
                throw OpenAIIoException("Realtime WebSocket operation interrupted", error)
            } catch (error: TimeoutException) {
                synchronized(lock) { requireActiveSocket(active) }
                if (!timeout.isZero)
                    throw OpenAIIoException("Realtime WebSocket operation failed", error)
            }
        }
    }

    /** Closes this socket and returns a new session. No input or session updates are replayed. */
    @JvmOverloads
    @MustBeClosed
    fun reconnect(options: RealtimeWebSocketOptions = this.options): RealtimeConnection {
        close()
        return connect(clientOptions, options, requestOptions)
    }

    /** Opens a fresh socket with current credentials. The caller restores any session settings. */
    @JvmOverloads
    fun reconnectAsync(
        options: RealtimeWebSocketOptions = this.options
    ): CompletableFuture<RealtimeConnection> {
        close()
        return connectAsync(clientOptions, options, requestOptions)
    }

    override fun close() {
        synchronized(lock) {
            if (closed) return
            closed = true
            queue.clear()
            queuedBytes = 0
        }
        fail(CancellationException("Realtime connection closed"))
    }

    private fun accept(text: String, epoch: Long) {
        if (synchronized(lock) { epoch != generation }) return
        try {
            // Reject malformed envelopes independently of lenient or user-supplied model readers.
            clientOptions.jsonMapper.factory.createParser(text).use { parser ->
                require(parser.nextToken() == JsonToken.START_OBJECT) { "Invalid Realtime event" }
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
                    "Invalid Realtime event"
                }
            }
            val event: RealtimeServerEvent = reader.readValue(text)
            if (requestOptions.responseValidation ?: clientOptions.responseValidation)
                event.validate()
            val bytes = utf8Size(text)
            val target =
                synchronized(lock) {
                    if (closed || failure != null || epoch != generation) return
                    val available =
                        waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                    if (available == null) {
                        if (
                            queue.size >= options.maxQueuedEvents ||
                                bytes > options.maxQueuedBytes - queuedBytes
                        )
                            throw IOException("Realtime event buffer is full")
                        queue.addLast(Item(event, bytes))
                        queuedBytes += bytes
                    } else available.claimed = true
                    available
                }
            if (target != null) {
                if (target.blocking) target.complete(event) else dispatch { target.complete(event) }
            }
        } catch (error: Exception) {
            if (synchronized(lock) { epoch == generation }) fail(error)
        }
    }

    private fun fail(error: Throwable, callbackEpoch: Long? = null) {
        val detached =
            synchronized(lock) {
                if (failure != null) return
                if (
                    callbackEpoch != null &&
                        error is WebSocketWriteNotAttempted &&
                        generation != callbackEpoch &&
                        !closed
                )
                    return
                failure = error
                write?.disconnected = null
                generation++
                retryTimer?.cancel(false)
                retryTimer = null
                val unassigned =
                    waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                waiter = null
                Triple(socket, opening, unassigned).also {
                    socket = null
                    opening = null
                }
            }
        ownerLifetime?.complete(null)
        detached.second?.cancel(true)
        // Complete the detached read before cleanup: injected close() may depend on the reader
        // having received its failure. Only private blocking futures complete on this thread.
        detached.third?.let { read ->
            if (read.blocking) read.completeExceptionally(error)
            else dispatch { read.completeExceptionally(error) }
        }
        try {
            detached.first?.close()
        } catch (closing: Throwable) {
            if (closing !== error) error.addSuppressed(closing)
        }
    }

    // User completion callbacks never run on the transport reader, including with a direct
    // executor.
    private fun dispatch(action: () -> Unit) = clientOptions.dispatchWebSocketCallback(action)
}
