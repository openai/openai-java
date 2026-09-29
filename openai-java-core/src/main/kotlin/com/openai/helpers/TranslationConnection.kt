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
import com.openai.core.jsonMapper
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
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicBoolean

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
    private val timing: Timing,
) : AutoCloseable {
    // Per-connection dependencies let lifecycle tests control expiry without changing global
    // timers.
    internal class Timing(
        val nanoTime: () -> Long = System::nanoTime,
        val scheduler: ScheduledExecutorService = finishTimer,
        val finishExecutor: Executor = Executor { CompletableFuture.runAsync(it) },
    )

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
    private inner class ReadFuture(val blocking: Boolean) :
        CompletableFuture<RealtimeTranslationServerEvent>() {
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
        private val terminalReader =
            jsonMapper()
                .readerFor(RealtimeTranslationSessionClosedEvent::class.java)
                .with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)

        private val finishTimer =
            ScheduledThreadPoolExecutor(1) { runnable ->
                    Thread(runnable, "openai-translation-timeouts").apply { isDaemon = true }
                }
                .apply { removeOnCancelPolicy = true }

        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            options: TranslationWebSocketOptions = TranslationWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): TranslationConnection =
            await(connectAsync(clientOptions, options, requestOptions, blocking = true))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            options: TranslationWebSocketOptions = TranslationWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<TranslationConnection> =
            connectAsync(clientOptions, options, requestOptions, blocking = false)

        @JvmSynthetic
        internal fun connect(
            clientOptions: ClientOptions,
            options: TranslationWebSocketOptions,
            timing: Timing,
        ): TranslationConnection =
            await(connectAsync(clientOptions, options, RequestOptions.none(), true, timing))

        private fun connectAsync(
            clientOptions: ClientOptions,
            options: TranslationWebSocketOptions,
            requestOptions: RequestOptions,
            blocking: Boolean,
            timing: Timing = Timing(),
        ): CompletableFuture<TranslationConnection> {
            val connection = TranslationConnection(clientOptions, options, requestOptions, timing)
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
                val request =
                    HttpRequest.builder()
                        .method(HttpMethod.GET)
                        .baseUrl(baseUrl.toASCIIString().substringBefore('#').substringBefore('?'))
                        .addPathSegment("realtime")
                        .addPathSegment("translations")
                        .apply {
                            baseQuery
                                .filter { it.isNotEmpty() }
                                .forEach {
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
                require(request.queryParams.values("intent").isEmpty()) {
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
                            if (connection.closed || connection.failure != null)
                                connection.failure
                                    ?: CancellationException("Translation connection closed")
                            else if (error != null) error
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
                                    connection.closeTransport(active)
                                } catch (closing: Exception) {
                                    if (closing !== problem) problem.addSuppressed(closing)
                                }
                            }
                    } else connection.finishTerminal()
                    val complete: () -> Unit = {
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
                    // The blocking path's private future has no user continuations and may
                    // itself be called from the stream executor. Public futures still dispatch.
                    if (blocking) complete() else connection.dispatch(complete)
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
    fun receive(): RealtimeTranslationServerEvent = await(receiveAsync(blocking = true))

    /** Canceling an unassigned read leaves the session open for the next read. */
    fun receiveAsync(): CompletableFuture<RealtimeTranslationServerEvent> =
        receiveAsync(blocking = false)

    /**
     * Observes transport capacity without sending, receiving or reserving a message slot. The
     * standard OkHttp transport supports it. A legacy custom transport can opt in by implementing
     * WebSocketClient.WritableConnection; otherwise this operation is unsupported. send still
     * supports legacy transports and can report Busy after this advisory observation. Timeout and
     * interruption are reported as OpenAIIoException with the cause preserved.
     */
    fun awaitWritable(timeout: Duration) {
        require(!timeout.isZero && !timeout.isNegative) {
            "Translation writable timeout must be positive"
        }
        val active =
            synchronized(lock) {
                check(!closed && failure == null && finishing == null && terminal == null) {
                    "Translation is not writable"
                }
                socket ?: throw IllegalStateException("Translation is not connected")
            }
        val writable =
            active as? WebSocketClient.WritableConnection
                ?: throw UnsupportedOperationException(
                    "Transport cannot observe WebSocket capacity"
                )
        try {
            writable.awaitWritable(timeout)
        } catch (error: InterruptedException) {
            Thread.currentThread().interrupt()
            throw OpenAIIoException("Translation WebSocket operation interrupted", error)
        } catch (error: TimeoutException) {
            throw OpenAIIoException("Translation WebSocket operation failed", error)
        }
    }

    private fun receiveAsync(blocking: Boolean): CompletableFuture<RealtimeTranslationServerEvent> {
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
        val timeout = options.sendTimeout
        if (timeout == null) {
            try {
                write(event, null)
            } finally {
                synchronized(lock) {
                    sending = false
                    lock.notifyAll()
                }
            }
            return
        }
        // This private future has no user callbacks. A blocked custom writer or mapper must
        // not delay delivering its timeout to the caller or block the sole receive listener.
        val result = CompletableFuture<Unit>()
        val decided = AtomicBoolean()
        val deadline = timing.nanoTime() + timeout.toNanos()
        val alarm =
            timing.scheduler.schedule(
                {
                    val error = TimeoutException("Translation send timed out")
                    if (decided.compareAndSet(false, true)) {
                        fail(error)
                        result.completeExceptionally(error)
                    }
                },
                maxOf(0L, deadline - timing.nanoTime()),
                TimeUnit.NANOSECONDS,
            )
        // CompletableFuture.get on a common-pool worker may itself execute unrelated queued
        // async tasks while waiting. Never allow the caller waiting on a deadline to pick up
        // this potentially blocking transport operation.
        Thread(
                {
                    var problem: Throwable? = null
                    try {
                        write(event, deadline)
                    } catch (error: Throwable) {
                        problem = error
                        if (error is TimeoutException) fail(error)
                    } finally {
                        // A returned send permits the next one. Release its admission before waking
                        // either that caller or finish; leave blocked, timed-out writers owned
                        // until done.
                        synchronized(lock) {
                            sending = false
                            lock.notifyAll()
                        }
                    }
                    if (decided.compareAndSet(false, true)) {
                        if (problem == null) result.complete(Unit)
                        else result.completeExceptionally(problem)
                    }
                    alarm.cancel(false)
                },
                "openai-translation-send",
            )
            .apply {
                isDaemon = true
                start()
            }
        try {
            await(result)
        } catch (error: RuntimeException) {
            // Interruption cancels the private wait. A writer may already have attempted I/O.
            if (result.isCancelled) fail(error)
            throw error
        }
    }

    private fun write(event: RealtimeTranslationClientEvent, deadline: Long?) {
        val text = clientOptions.jsonMapper.writeValueAsString(event)
        require(utf8Size(text) <= options.maxMessageBytes) {
            "Translation command exceeds maxMessageBytes"
        }
        while (true) {
            val active =
                synchronized(lock) {
                    check(!closed && failure == null) { "Translation is not connected" }
                    if (deadline != null && deadline - timing.nanoTime() <= 0L)
                        throw TimeoutException("Translation send timed out")
                    socket ?: throw IllegalStateException("Translation is not connected")
                }
            if (deadline != null && active is WebSocketClient.WritableConnection)
                active.awaitWritable(Duration.ofNanos(maxOf(1L, deadline - timing.nanoTime())))
            // A caller's capacity check may block while timeout or close releases the socket.
            synchronized(lock) {
                check(!closed && failure == null && socket === active) {
                    "Translation is not connected"
                }
                if (deadline != null && deadline - timing.nanoTime() <= 0L)
                    throw TimeoutException("Translation send timed out")
            }
            try {
                active.send(text)
                return
            } catch (busy: WebSocketWriteNotAttempted.Busy) {
                if (deadline == null) throw busy
                // Only Busy proves non-admission; a custom legacy transport can be retried on
                // this marker without needing a new interface. It may not implement readiness.
                synchronized(lock) {
                    if (!closed && failure == null) {
                        val remaining = deadline - timing.nanoTime()
                        if (remaining <= 0L) throw TimeoutException("Translation send timed out")
                        TimeUnit.NANOSECONDS.timedWait(
                            lock,
                            minOf(remaining, TimeUnit.MILLISECONDS.toNanos(10)),
                        )
                    }
                }
            } catch (error: Throwable) {
                if (error !is WebSocketWriteNotAttempted) fail(error)
                throw error
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
        val deadline = timing.nanoTime() + nanos
        val result: CompletableFuture<RealtimeTranslationSessionClosedEvent>
        synchronized(lock) {
            finishing?.let {
                return it
            }
            check(!closed) { "Translation connection is closed" }
            result = CompletableFuture()
            finishing = result
            failure?.let {
                // This new future has not escaped the lock and cannot have user callbacks yet.
                result.completeExceptionally(it)
                return result
            }
        }
        val decided = AtomicBoolean()
        val alarm =
            timing.scheduler.schedule(
                {
                    if (decided.compareAndSet(false, true))
                        fail(TimeoutException("Translation finish timed out"))
                },
                maxOf(0L, deadline - timing.nanoTime()),
                TimeUnit.NANOSECONDS,
            )
        result.whenComplete { _, _ ->
            alarm.cancel(false)
            if (result.isCancelled) {
                decided.set(true)
                close()
            }
        }
        timing.finishExecutor.execute {
            try {
                var closeText: String? = null
                while (true) {
                    val active =
                        synchronized(lock) {
                            while (sending && terminal == null && failure == null) waitUntil(
                                deadline
                            )
                            failure?.let { throw it }
                            if (terminal != null) null
                            else {
                                if (deadline - timing.nanoTime() <= 0L)
                                    throw TimeoutException("Translation finish timed out")
                                socket
                                    ?: throw IllegalStateException("Translation is not connected")
                            }
                        }
                    if (active == null) break
                    if (closeText == null) {
                        ForkJoinPool.managedBlock(
                            object : ForkJoinPool.ManagedBlocker {
                                override fun isReleasable() = closeText != null

                                override fun block(): Boolean {
                                    closeText =
                                        clientOptions.jsonMapper.writeValueAsString(
                                            RealtimeTranslationClientEvent.ofSessionClose(
                                                RealtimeTranslationSessionCloseEvent.builder()
                                                    .build()
                                            )
                                        )
                                    return true
                                }
                            }
                        )
                        require(utf8Size(checkNotNull(closeText)) <= options.maxMessageBytes) {
                            "Translation close exceeds maxMessageBytes"
                        }
                        // Serialization can block while the peer ends or the deadline expires.
                        // Recheck before attempting the only write, and reuse on proven Busy.
                        continue
                    }
                    val text = checkNotNull(closeText)
                    try {
                        // A custom write can wait for transport progress that needs another
                        // common-pool worker. Do not occupy its last worker unnoticed.
                        ForkJoinPool.managedBlock(
                            object : ForkJoinPool.ManagedBlocker {
                                private var sent = false

                                override fun isReleasable() = sent

                                override fun block(): Boolean {
                                    active.send(text)
                                    sent = true
                                    return true
                                }
                            }
                        )
                        break
                    } catch (busy: WebSocketWriteNotAttempted.Busy) {
                        // Only this marker proves no write was attempted. Never replay on an
                        // arbitrary transport exception; its outcome may already be on the wire.
                        synchronized(lock) {
                            if (terminal == null && failure == null)
                                waitUntil(deadline, TimeUnit.MILLISECONDS.toNanos(10))
                        }
                    } catch (error: Throwable) {
                        synchronized(lock) {
                            failure?.let { throw it }
                            // Our own cleanup may close the selected socket after a valid wire
                            // terminal. Await that cleanup and deadline; never retry this write.
                            if (terminal == null) throw error
                        }
                        break
                    }
                }
                val end =
                    synchronized(lock) {
                        while (!finished && failure == null) waitUntil(deadline)
                        failure?.let { throw it }
                        if (deadline - timing.nanoTime() <= 0L)
                            throw TimeoutException("Translation finish timed out")
                        checkNotNull(terminal)
                    }
                if (decided.compareAndSet(false, true)) result.complete(end)
            } catch (error: Throwable) {
                if (decided.compareAndSet(false, true)) {
                    fail(error)
                    // A failure may predate this finish; in that case fail already released
                    // the socket and the newly created finish still needs its own completion.
                    result.completeExceptionally(error)
                }
            }
        }
        return result
    }

    // Must hold lock. Both calls and transport completion use the same bounded deadline.
    private fun waitUntil(deadline: Long, maximumWait: Long = Long.MAX_VALUE) {
        val remaining = deadline - timing.nanoTime()
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
        val event: RealtimeTranslationServerEvent
        val end: RealtimeTranslationSessionClosedEvent?
        try {
            // Reject malformed envelopes independently of lenient or user-supplied model readers.
            val wireType =
                clientOptions.jsonMapper.factory.createParser(text).use { parser ->
                    require(parser.nextToken() == JsonToken.START_OBJECT) {
                        "Invalid Translation event"
                    }
                    var type: String? = null
                    while (parser.nextToken() == JsonToken.FIELD_NAME) {
                        val name = parser.currentName
                        val token = parser.nextToken()
                        if (name == "type")
                            type = if (token == JsonToken.VALUE_STRING) parser.text else null
                        parser.skipChildren()
                    }
                    require(
                        parser.currentToken() == JsonToken.END_OBJECT &&
                            type != null &&
                            parser.nextToken() == null
                    ) {
                        "Invalid Translation event"
                    }
                    type
                }
            event = reader.readValue(text)
            if (requestOptions.responseValidation ?: clientOptions.responseValidation)
                event.validate()
            // Even in lenient mode, incomplete/malformed terminal events cannot claim success.
            end =
                if (wireType == "session.closed") {
                    // Use generated validation on what was actually received, independently of
                    // the caller's public event mapping. Preserve that mapping for delivery.
                    terminalReader.readValue<RealtimeTranslationSessionClosedEvent>(text).validate()
                    event.sessionClosed().orElse(null)?.validate()
                } else null
        } catch (error: Throwable) {
            // Only parser/mapper/validation code is covered here, never user continuations.
            fail(error, unlessTerminal = true)
            return
        }
        try {
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
            if (target != null) {
                // A blocking read's private future cannot have user callbacks. Its caller may
                // itself occupy the only stream executor thread, so never queue behind it.
                if (target.blocking) target.complete(event) else dispatch { target.complete(event) }
            }
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
                closeTransport(active)
                synchronized(lock) {
                    finished = true
                    lock.notifyAll()
                }
            } catch (error: Throwable) {
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
        // Read and finish failures must be delivered independently of cleanup: a custom close
        // can itself wait for application teardown after observing an error. Public callbacks
        // still run off the listener/timer. A blocking read's private future has none.
        detached.third?.let { read ->
            if (read.blocking) read.completeExceptionally(error)
            else dispatch { read.completeExceptionally(error) }
        }
        finishing?.let { ending ->
            CompletableFuture.runAsync { ending.completeExceptionally(error) }
        }
        CompletableFuture.runAsync {
            try {
                detached.second?.cancel(true)
                detached.first?.let { closeTransport(it) }
            } catch (closing: Throwable) {
                if (closing !== error) error.addSuppressed(closing)
            }
        }
    }

    // All calls run off the transport reader/caller. Let other connections make progress when
    // a custom transport has a blocking close (for instance, waiting for its own listener).
    private fun closeTransport(active: WebSocketClient.Connection) {
        ForkJoinPool.managedBlock(
            object : ForkJoinPool.ManagedBlocker {
                private var released = false

                override fun isReleasable(): Boolean = released

                override fun block(): Boolean {
                    active.close()
                    released = true
                    return true
                }
            }
        )
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
