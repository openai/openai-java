package com.openai.core.http

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationFeature
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import java.io.IOException
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture

/** SDK-owned ordered event connection used by generated bindings and API helpers. */
class WebSocketConnection<C : Any, S : Any>
internal constructor(
    private val clientOptions: ClientOptions,
    private val requestOptions: RequestOptions,
    private val requestFactory: () -> HttpRequest,
    eventType: Class<S>,
    private val validate: (S) -> Unit,
    private val maxMessageBytes: Int,
    private val maxQueuedBytes: Long,
    private val maxQueuedEvents: Int,
    private val api: String,
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
    private var waiter: WebSocketReadFuture<S>? = null
    private var failure: Throwable? = null
    private var closed = false
    private var sending = false

    internal fun <T : AutoCloseable> open(
        blocking: Boolean,
        create: (WebSocketConnection<C, S>) -> T,
    ): CompletableFuture<T> {
        val connection = this
        val result = CompletableFuture<T>()
        result.whenComplete { _, _ -> if (result.isCancelled) connection.close() }
        try {
            clientOptions.requireWebSocketTransport()
            val request = requestFactory()
            val pending =
                clientOptions.connectWebSocket(
                    request,
                    requestOptions,
                    maxMessageBytes,
                    object : WebSocketClient.Listener {
                        override fun onMessage(text: String) = connection.accept(text)

                        override fun onClosed(code: Int) =
                            connection.fail(IOException("$api WebSocket closed (code $code)"))

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
                            connection.failure ?: CancellationException("$api connection closed")
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
                                        CancellationException("$api connection closed")
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

    private fun <T> await(future: CompletableFuture<T>): T = awaitWebSocketFuture(future, api)

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): S = await(receiveFuture(blocking = true))

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<S> = receiveFuture(blocking = false)

    private fun receiveFuture(blocking: Boolean): CompletableFuture<S> {
        synchronized(lock) {
            check(!closed) { "$api connection is closed" }
            if (waiter?.let { it.isDone || it.cancellationReserved } == true) waiter = null
            check(waiter == null) { "A $api receive is already pending" }
            if (queue.isNotEmpty()) {
                val item = queue.removeFirst()
                queuedBytes -= item.bytes
                return CompletableFuture.completedFuture(item.event)
            }
            failure?.let {
                return CompletableFuture<S>().apply { completeExceptionally(it) }
            }
            return WebSocketReadFuture<S>(lock, blocking).also { next ->
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
    fun send(event: C) = sendChecked(event) {}

    internal fun sendChecked(event: C, checkCommand: (String) -> Unit) {
        synchronized(lock) {
            check(!closed && failure == null && socket != null) { "$api is not connected" }
            check(!sending) { "A $api send is already pending; command was not sent" }
            sending = true
        }
        try {
            val text = clientOptions.jsonMapper.writeValueAsString(event)
            checkCommand(text)
            require(utf8Size(text) <= maxMessageBytes) { "$api command exceeds maxMessageBytes" }
            val active =
                synchronized(lock) {
                    check(!closed && failure == null) { "$api is not connected" }
                    socket ?: throw IllegalStateException("$api is not connected")
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
        fail(CancellationException("$api connection closed"))
    }

    private fun accept(text: String) {
        try {
            // Reject malformed envelopes independently of lenient or user-supplied model readers.
            clientOptions.jsonMapper.factory.createParser(text).use { parser ->
                require(parser.nextToken() == JsonToken.START_OBJECT) { "Invalid $api event" }
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
                    "Invalid $api event"
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
                        if (queue.size >= maxQueuedEvents || bytes > maxQueuedBytes - queuedBytes)
                            throw IOException("$api event buffer is full")
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
    private fun dispatch(action: () -> Unit) = clientOptions.dispatchWebSocketCallback(action)
}
