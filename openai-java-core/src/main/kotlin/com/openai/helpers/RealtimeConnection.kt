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
import com.openai.core.prepare
import com.openai.errors.OpenAIIoException
import com.openai.models.realtime.RealtimeClientEvent
import com.openai.models.realtime.RealtimeServerEvent
import java.io.IOException
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

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

    private val queue = ArrayDeque<Item>()
    private var queuedBytes = 0L
    private var socket: WebSocketClient.Connection? = null
    private var opening: CompletableFuture<WebSocketClient.Connection>? = null
    private var waiter: ReadFuture? = null
    private var failure: Throwable? = null
    private var closed = false
    private var sending = false

    // Assign a read without invoking arbitrary CompletableFuture callbacks while holding lock.
    // Once assigned it cannot be canceled and silently discard a server event.
    private inner class ReadFuture : CompletableFuture<RealtimeServerEvent>() {
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

    companion object {
        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            options: RealtimeWebSocketOptions = RealtimeWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): RealtimeConnection = await(connectAsync(clientOptions, options, requestOptions))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            options: RealtimeWebSocketOptions = RealtimeWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<RealtimeConnection> {
            val connection = RealtimeConnection(clientOptions, options, requestOptions)
            val result = CompletableFuture<RealtimeConnection>()
            result.whenComplete { _, _ -> if (result.isCancelled) connection.close() }
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
                        .addPathSegment("realtime")
                        .build()
                        .prepare(
                            clientOptions,
                            options,
                            SecurityOptions.builder().bearerAuth(true).build(),
                        )
                val pending =
                    clientOptions.connectWebSocket(
                        request,
                        requestOptions,
                        options.maxMessageBytes,
                        object : WebSocketClient.Listener {
                            override fun onMessage(text: String) = connection.accept(text)

                            override fun onClosed(code: Int) =
                                connection.fail(
                                    IOException("GA Realtime WebSocket closed (code $code)")
                                )

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
                                connection.failure
                                    ?: CancellationException("Realtime connection closed")
                            else {
                                connection.socket = active
                                null
                            }
                        }
                    if (problem != null) {
                        active?.close()
                        connection.fail(problem)
                        result.completeExceptionally(problem)
                    } else if (!result.complete(connection)) connection.close()
                }
            } catch (error: Exception) {
                connection.fail(error)
                result.completeExceptionally(error)
            }
            return result
        }

        private fun <T> await(future: CompletableFuture<T>): T {
            var interrupted = false
            try {
                while (true) {
                    try {
                        return future.get()
                    } catch (error: InterruptedException) {
                        interrupted = true
                        if (future.cancel(false))
                            throw OpenAIIoException(
                                "Realtime WebSocket operation interrupted",
                                error,
                            )
                    } catch (error: ExecutionException) {
                        val cause = error.cause ?: error
                        throw when (cause) {
                            is RuntimeException -> cause
                            is Error -> cause
                            else -> OpenAIIoException("Realtime WebSocket operation failed", cause)
                        }
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt()
            }
        }
    }

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): RealtimeServerEvent = await(receiveAsync())

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<RealtimeServerEvent> {
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
            return ReadFuture().also { next ->
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
        synchronized(lock) {
            check(!closed && failure == null && socket != null) { "Realtime is not connected" }
            check(!sending) { "A Realtime send is already pending; command was not sent" }
            sending = true
        }
        try {
            val text = clientOptions.jsonMapper.writeValueAsString(event)
            require(text.toByteArray(Charsets.UTF_8).size <= options.maxMessageBytes) {
                "Realtime command exceeds maxMessageBytes"
            }
            val active =
                synchronized(lock) {
                    check(!closed && failure == null) { "Realtime is not connected" }
                    socket ?: throw IllegalStateException("Realtime is not connected")
                }
            try {
                active.send(text)
            } catch (error: Exception) {
                if (error !is WebSocketWriteNotAttempted) fail(error)
                throw error
            }
        } finally {
            synchronized(lock) { sending = false }
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

    private fun accept(text: String) {
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
            val bytes = text.toByteArray(Charsets.UTF_8).size.toLong()
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
                            throw IOException("Realtime event buffer is full")
                        queue.addLast(Item(event, bytes))
                        queuedBytes += bytes
                    } else available.claimed = true
                    available
                }
            if (target != null) dispatch { target.complete(event) }
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
        detached.second?.cancel(true)
        try {
            detached.first?.close()
        } catch (closing: Exception) {
            if (closing !== error) error.addSuppressed(closing)
        }
        detached.third?.let { read -> dispatch { read.completeExceptionally(error) } }
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
