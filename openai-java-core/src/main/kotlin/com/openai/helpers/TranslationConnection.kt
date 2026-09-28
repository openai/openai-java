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
import com.openai.models.realtime.RealtimeTranslationClientEvent
import com.openai.models.realtime.RealtimeTranslationServerEvent
import com.openai.models.realtime.RealtimeTranslationSessionCloseEvent
import com.openai.models.realtime.RealtimeTranslationSessionClosedEvent
import java.io.EOFException
import java.io.IOException
import java.net.URI
import java.net.URLDecoder
import java.time.Duration
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Managed Translation connection. Consume typed events synchronously or asynchronously, with one
 * outstanding receive at a time. API error events remain ordinary received events. Valid future
 * event types retain their raw JSON through RealtimeTranslationServerEvent._json(). No event is
 * replayed. As with the SDK's other response APIs, explicitly enabling responseValidation uses
 * strict generated validation, which can reject types newly introduced by the server. Validation is
 * off by default. RequestOptions can override the client setting for this connection.
 *
 * Create ClientOptions using an HTTP client that implements WebSocketClient (such as the SDK's
 * OkHttpClient). Those options retain headers, base URL, credentials and defaults. Closing this
 * connection does not close the HTTP client or other connections. Explicit reconnect returns a
 * fresh connection and refreshes credentials; callers decide which session state to restore.
 * Translation uses /realtime/translations with an optional model query. Azure and Bedrock
 * Translation support is not provided. No beta headers are added.
 *
 * After the last audio send returns, call finish(Duration) to send session.close, await the
 * server's validated session.closed and release the socket. finish does not consume events: keep
 * calling receive() to observe the remaining transcript, audio, and session.closed. It is safe to
 * call finish without a pending receive. An error event, unknown event or disconnection alone never
 * signals successful completion. close() instead aborts immediately and discards the queue.
 *
 * For example, using configured ClientOptions and a PCM16 audio chunk:
 * ```java
 * try (TranslationConnection connection = TranslationConnection.connect(
 *         clientOptions, TranslationWebSocketOptions.builder().model(model).build())) {
 *     connection.send(RealtimeTranslationClientEvent.ofSessionInputAudioBufferAppend(
 *         RealtimeTranslationInputAudioBufferAppendEvent.builder()
 *             .audio(base64Pcm16).build()));
 *     connection.finish(Duration.ofSeconds(30));
 *     while (true) {
 *         RealtimeTranslationServerEvent event = connection.receive();
 *         // Handle output transcript and audio here.
 *         if (event.isSessionClosed()) break;
 *     }
 * }
 * ```
 */
class TranslationConnection
private constructor(
    private val clientOptions: ClientOptions,
    private val options: TranslationWebSocketOptions,
    private val requestOptions: RequestOptions,
) : AutoCloseable {
    private val lock = Object()
    private val reader =
        clientOptions.jsonMapper
            .readerFor(RealtimeTranslationServerEvent::class.java)
            .with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)

    private class Item(val event: RealtimeTranslationServerEvent, val bytes: Long)

    private val queue = ArrayDeque<Item>()
    private var queuedBytes = 0L
    private var socket: WebSocketClient.Connection? = null
    private var opening: CompletableFuture<WebSocketClient.Connection>? = null
    private var waiter: ReadFuture? = null
    private var failure: Throwable? = null
    private var closed = false
    private var sending = false
    private var terminal: RealtimeTranslationSessionClosedEvent? = null
    private var finished = false
    private var finishing: CompletableFuture<RealtimeTranslationSessionClosedEvent>? = null

    // Assign a read without invoking arbitrary CompletableFuture callbacks while holding lock.
    // Once assigned it cannot be canceled and silently discard a server event.
    private inner class ReadFuture : CompletableFuture<RealtimeTranslationServerEvent>() {
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
            options: TranslationWebSocketOptions = TranslationWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): TranslationConnection = await(connectAsync(clientOptions, options, requestOptions))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            options: TranslationWebSocketOptions = TranslationWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<TranslationConnection> {
            val connection = TranslationConnection(clientOptions, options, requestOptions)
            val result = CompletableFuture<TranslationConnection>()
            result.whenComplete { _, _ -> if (result.isCancelled) connection.close() }
            try {
                clientOptions.requireWebSocketTransport()
                require(
                    !AzureUrlCategory.categorizeBaseUrl(
                            clientOptions.baseUrl(),
                            clientOptions.azureUrlPathMode,
                        )
                        .isAzure()
                ) {
                    "Translation WebSockets are not supported on Azure"
                }
                val baseUrl = URI(clientOptions.baseUrl())
                val baseQuery = baseUrl.rawQuery?.split('&').orEmpty()
                val route =
                    if (options._queryParams().values("model").isEmpty()) clientOptions.baseUrl()
                    else {
                        val inherited =
                            baseQuery.filter {
                                URLDecoder.decode(it.substringBefore('='), "UTF-8") != "model"
                            }
                        buildString {
                            append(
                                baseUrl.toASCIIString().substringBefore('#').substringBefore('?')
                            )
                            if (inherited.isNotEmpty())
                                append("?").append(inherited.joinToString("&"))
                            baseUrl.rawFragment?.let { append("#").append(it) }
                        }
                    }
                val request =
                    HttpRequest.builder()
                        .method(HttpMethod.GET)
                        .baseUrl(route)
                        .addPathSegment("realtime")
                        .addPathSegment("translations")
                        .build()
                        .prepare(
                            clientOptions,
                            options,
                            SecurityOptions.builder().bearerAuth(true).build(),
                        )
                require(
                    request.queryParams.values("intent").isEmpty() &&
                        baseQuery.none {
                            URLDecoder.decode(it.substringBefore('='), "UTF-8") == "intent"
                        }
                ) {
                    "Translation does not accept the Realtime intent query parameter"
                }
                val pending =
                    clientOptions.connectWebSocket(
                        request,
                        requestOptions,
                        options.maxMessageBytes,
                        object : WebSocketClient.Listener {
                            override fun onMessage(text: String) = connection.accept(text)

                            override fun onClosed(code: Int) =
                                connection.fail(
                                    IOException("Translation WebSocket closed (code $code)"),
                                    unlessTerminal = true,
                                )

                            override fun onFailure(error: Throwable) =
                                connection.fail(error, unlessTerminal = true)
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
                                    ?: CancellationException("Translation connection closed")
                            else {
                                connection.socket = active
                                null
                            }
                        }
                    if (problem != null) {
                        connection.fail(problem)
                        if (active != null)
                            CompletableFuture.runAsync {
                                try {
                                    active.close()
                                } catch (closing: Exception) {
                                    if (closing !== problem) problem.addSuppressed(closing)
                                }
                            }
                    } else connection.finishTerminal()
                    connection.dispatch {
                        // The owner or socket can close while completion waits on the executor.
                        // Inspect state here, but keep user callbacks outside the lock.
                        val completionError =
                            problem
                                ?: synchronized(connection.lock) {
                                    when {
                                        connection.failure != null -> connection.failure
                                        connection.closed ->
                                            CancellationException("Translation connection closed")
                                        clientOptions.isWebSocketClosed() ->
                                            CancellationException("Client is closed")
                                        else -> null
                                    }
                                }
                        if (completionError != null) {
                            connection.fail(completionError)
                            result.completeExceptionally(completionError)
                        } else if (!result.complete(connection)) connection.close()
                    }
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
                                "Translation WebSocket operation interrupted",
                                error,
                            )
                    } catch (error: ExecutionException) {
                        val cause = error.cause ?: error
                        throw when (cause) {
                            is RuntimeException -> cause
                            is Error -> cause
                            else ->
                                OpenAIIoException("Translation WebSocket operation failed", cause)
                        }
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt()
            }
        }
    }

    /** Returns one event, even if the peer closes immediately after it. */
    fun receive(): RealtimeTranslationServerEvent = await(receiveAsync())

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<RealtimeTranslationServerEvent> {
        synchronized(lock) {
            check(!closed) { "Translation connection is closed" }
            if (waiter?.let { it.isDone || it.cancellationReserved } == true) waiter = null
            check(waiter == null) { "A Translation receive is already pending" }
            if (queue.isNotEmpty()) {
                val item = queue.removeFirst()
                queuedBytes -= item.bytes
                return CompletableFuture.completedFuture(item.event)
            }
            failure?.let {
                return CompletableFuture<RealtimeTranslationServerEvent>().apply {
                    completeExceptionally(it)
                }
            }
            if (terminal != null)
                return CompletableFuture<RealtimeTranslationServerEvent>().apply {
                    completeExceptionally(EOFException("Translation session ended"))
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
    fun send(event: RealtimeTranslationClientEvent) {
        synchronized(lock) {
            check(!closed && failure == null && socket != null) { "Translation is not connected" }
            check(finishing == null && terminal == null) { "Translation is finishing" }
            check(!sending) { "A Translation send is already pending; command was not sent" }
            require(!event.isSessionClose()) {
                "Use finish to close and drain a Translation session"
            }
            sending = true
        }
        try {
            val text = clientOptions.jsonMapper.writeValueAsString(event)
            require(utf8Size(text) <= options.maxMessageBytes) {
                "Translation command exceeds maxMessageBytes"
            }
            val active =
                synchronized(lock) {
                    check(!closed && failure == null) { "Translation is not connected" }
                    socket ?: throw IllegalStateException("Translation is not connected")
                }
            try {
                active.send(text)
            } catch (error: Exception) {
                if (error !is WebSocketWriteNotAttempted) fail(error)
                throw error
            }
        } finally {
            synchronized(lock) {
                sending = false
                lock.notifyAll()
            }
        }
    }

    /**
     * Sends session.close once, waits for session.closed and leaves every event available to
     * receive(). timeout covers both transport admission after the last send and the server drain.
     */
    fun finish(timeout: Duration): RealtimeTranslationSessionClosedEvent =
        await(finishAsync(timeout))

    /**
     * Does not claim a receive or block the socket listener. Further input is rejected immediately.
     * Canceling this future aborts this socket. Concurrent calls return the same finish future.
     */
    fun finishAsync(timeout: Duration): CompletableFuture<RealtimeTranslationSessionClosedEvent> {
        require(!timeout.isZero && !timeout.isNegative) {
            "Translation finish needs a positive timeout"
        }
        val nanos = timeout.toNanos()
        val deadline = System.nanoTime() + nanos
        val result: CompletableFuture<RealtimeTranslationSessionClosedEvent>
        synchronized(lock) {
            finishing?.let {
                return it
            }
            check(!closed) { "Translation connection is closed" }
            result = CompletableFuture()
            finishing = result
        }
        result.whenComplete { _, _ -> if (result.isCancelled) close() }
        CompletableFuture.runAsync {
            try {
                val closeText =
                    clientOptions.jsonMapper.writeValueAsString(
                        RealtimeTranslationClientEvent.ofSessionClose(
                            RealtimeTranslationSessionCloseEvent.builder().build()
                        )
                    )
                require(utf8Size(closeText) <= options.maxMessageBytes) {
                    "Translation close exceeds maxMessageBytes"
                }
                while (true) {
                    val active =
                        synchronized(lock) {
                            while (sending && terminal == null && failure == null) waitUntil(
                                deadline
                            )
                            failure?.let { throw it }
                            if (terminal != null) null
                            else
                                socket
                                    ?: throw IllegalStateException("Translation is not connected")
                        }
                    if (active == null) break
                    try {
                        active.send(closeText)
                        break
                    } catch (busy: WebSocketWriteNotAttempted.Busy) {
                        // Only this marker proves no write was attempted. Never replay on an
                        // arbitrary transport exception; its outcome may already be on the wire.
                        synchronized(lock) {
                            waitUntil(deadline, TimeUnit.MILLISECONDS.toNanos(10))
                        }
                    }
                }
                val end =
                    synchronized(lock) {
                        while (!finished && failure == null) waitUntil(deadline)
                        failure?.let { throw it }
                        checkNotNull(terminal)
                    }
                result.complete(end)
            } catch (error: Throwable) {
                fail(error)
                result.completeExceptionally(error)
            }
        }
        return result
    }

    // Must hold lock. Both calls and transport completion use the same bounded deadline.
    private fun waitUntil(deadline: Long, maximumWait: Long = Long.MAX_VALUE) {
        val remaining = deadline - System.nanoTime()
        if (remaining <= 0L) throw TimeoutException("Translation finish timed out")
        // Independent sessions' waits must not occupy every worker needed for message delivery
        // and terminal cleanup.
        ForkJoinPool.managedBlock(
            object : ForkJoinPool.ManagedBlocker {
                private var waited = false

                override fun isReleasable() = waited

                override fun block(): Boolean {
                    TimeUnit.NANOSECONDS.timedWait(lock, minOf(remaining, maximumWait))
                    waited = true
                    return true
                }
            }
        )
    }

    /** Closes this socket and returns a new session. No input or session updates are replayed. */
    @JvmOverloads
    @MustBeClosed
    fun reconnect(options: TranslationWebSocketOptions = this.options): TranslationConnection {
        close()
        return connect(clientOptions, options, requestOptions)
    }

    /** Opens a fresh socket with current credentials. The caller restores any session settings. */
    @JvmOverloads
    fun reconnectAsync(
        options: TranslationWebSocketOptions = this.options
    ): CompletableFuture<TranslationConnection> {
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
        fail(CancellationException("Translation connection closed"))
    }

    private fun accept(text: String) {
        synchronized(lock) { if (closed || failure != null || terminal != null) return }
        try {
            // Reject malformed envelopes independently of lenient or user-supplied model readers.
            clientOptions.jsonMapper.factory.createParser(text).use { parser ->
                require(parser.nextToken() == JsonToken.START_OBJECT) {
                    "Invalid Translation event"
                }
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
                    "Invalid Translation event"
                }
            }
            val event: RealtimeTranslationServerEvent = reader.readValue(text)
            if (requestOptions.responseValidation ?: clientOptions.responseValidation)
                event.validate()
            // Even in lenient mode, incomplete/malformed terminal events cannot claim success.
            val end = event.sessionClosed().orElse(null)?.validate()
            val bytes = utf8Size(text)
            val target =
                synchronized(lock) {
                    if (closed || failure != null || terminal != null) return
                    val available =
                        waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                    if (available == null) {
                        if (
                            queue.size >= options.maxQueuedEvents ||
                                bytes > options.maxQueuedBytes - queuedBytes
                        )
                            throw IOException("Translation event buffer is full")
                        queue.addLast(Item(event, bytes))
                        queuedBytes += bytes
                    } else available.claimed = true
                    if (end != null) {
                        terminal = end
                        lock.notifyAll()
                    }
                    available
                }
            if (target != null) dispatch { target.complete(event) }
            if (end != null) finishTerminal()
        } catch (error: Exception) {
            fail(error, unlessTerminal = true)
        }
    }

    private fun finishTerminal() {
        // Admission precedes success, including buffer limits. Release off the listener:
        // a custom transport's close may wait for its own reader to return. A terminal event may
        // arrive before connect's future completes; that completion also calls this once attached.
        val active =
            synchronized(lock) {
                if (terminal == null) return
                socket?.also { socket = null } ?: return
            }
        CompletableFuture.runAsync {
            try {
                active.close()
                synchronized(lock) {
                    finished = true
                    lock.notifyAll()
                }
            } catch (error: Exception) {
                fail(error)
            }
        }
    }

    private fun fail(error: Throwable, unlessTerminal: Boolean = false) {
        val detached =
            synchronized(lock) {
                if (failure != null || (unlessTerminal && terminal != null)) return
                failure = error
                lock.notifyAll()
                val unassigned =
                    waiter?.takeUnless { it.claimed || it.cancellationReserved || it.isDone }
                waiter = null
                Triple(socket, opening, unassigned).also {
                    socket = null
                    opening = null
                }
            }
        // Failure can originate on the listener, and custom transports can join that reader
        // during close. Release off-thread before completing the failed pending receive.
        CompletableFuture.runAsync {
            detached.second?.cancel(true)
            try {
                detached.first?.close()
            } catch (closing: Exception) {
                if (closing !== error) error.addSuppressed(closing)
            }
            detached.third?.let { read -> dispatch { read.completeExceptionally(error) } }
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
