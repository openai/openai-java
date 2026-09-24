package com.openai.core.http

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.node.ObjectNode
import com.openai.azure.AzureUrlCategory
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.prepare
import com.openai.models.responses.Response
import com.openai.models.responses.ResponsesClientEvent
import com.openai.models.responses.ResponsesServerEvent
import java.io.IOException
import java.util.ArrayDeque
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture

/**
 * A managed Responses connection with a single transport reader. Response terminal events leave the
 * connection open. A receive cancellation removes only that waiter. Commands are never replayed.
 * Register lanes before sending their commands; unregistered events are delivered by [receive].
 */
class AsyncResponseConnection
private constructor(
    private val clientOptions: ClientOptions,
    private var options: ResponseWebSocketOptions,
    private val requestOptions: RequestOptions,
) : AutoCloseable {
    private val lock = Any()
    private val writerLock = Any()
    private val eventReader =
        clientOptions.jsonMapper
            .readerFor(ResponsesServerEvent::class.java)
            .with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
    private var socket: WebSocketClient.Connection? = null
    private var openingTransport: CompletableFuture<WebSocketClient.Connection>? = null
    private var epoch = 0L
    private var failure: Throwable? = null
    private var connecting = false
    private var closed = false
    private var queuedBytes = 0L
    private var queuedEvents = 0
    private var pendingSends = 0
    private val channels = mutableMapOf<String?, Channel>(null to Channel())
    private val reservedStreamIds = mutableSetOf<String>()

    private class Item(val event: ResponsesServerEvent, val bytes: Long)

    private class OpenAttempt(val generation: Long, val options: ResponseWebSocketOptions)

    private class Detached(
        val socket: WebSocketClient.Connection?,
        val opening: CompletableFuture<WebSocketClient.Connection>?,
        val waiters: List<CompletableFuture<ResponsesServerEvent>>,
        val error: Throwable,
    )

    private inner class ReadFuture : CompletableFuture<ResponsesServerEvent>() {
        var claimed = false

        var cancellationReserved = false

        // Called under lock. Reserving ownership must not run CompletableFuture callbacks.
        fun reserveCancellation(): Boolean {
            if (claimed) return false
            if (isDone) return isCancelled
            cancellationReserved = true
            return true
        }

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
            if (!synchronized(lock) { reserveCancellation() }) return false
            return super.cancel(mayInterruptIfRunning)
        }
    }

    private inner class Channel {
        val queue = ArrayDeque<Item>()
        var waiter: ReadFuture? = null
    }

    companion object {
        private val STREAM_ID_PATTERN = Regex("[A-Za-z0-9_.-]{1,256}")

        @JvmStatic
        @JvmOverloads
        fun connect(
            clientOptions: ClientOptions,
            options: ResponseWebSocketOptions = ResponseWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<AsyncResponseConnection> {
            val connection = AsyncResponseConnection(clientOptions, options, requestOptions)
            val opening = connection.open()
            val result = CompletableFuture<AsyncResponseConnection>()
            opening.whenComplete { _, error ->
                if (error != null) result.completeExceptionally(error)
                else if (!result.complete(connection)) connection.close()
            }
            result.whenComplete { _, _ ->
                if (result.isCancelled) {
                    opening.cancel(true)
                    connection.close()
                }
            }
            return result
        }
    }

    private fun dispatch(action: () -> Unit) {
        // Do not execute arbitrary user callbacks on the socket reader.
        // An Executor may run inline. The trampoline keeps callbacks off the transport reader
        // and outside connection locks even for direct executors or a rejected executor.
        CompletableFuture.runAsync {
            try {
                clientOptions.streamHandlerExecutor.execute(action)
            } catch (_: java.util.concurrent.RejectedExecutionException) {
                action()
            }
        }
    }

    // Caller holds lock. Reserving the attempt prevents concurrent reconnects.
    private fun reserveOpen(): OpenAttempt {
        check(!connecting) { "A connection attempt is already in progress" }
        connecting = true
        failure = null
        epoch += 1
        return OpenAttempt(epoch, options)
    }

    private fun open(): CompletableFuture<Void> = open(synchronized(lock) { reserveOpen() })

    private fun open(attempt: OpenAttempt): CompletableFuture<Void> {
        val generation = attempt.generation
        val options = attempt.options
        val result = CompletableFuture<Void>()
        try {
            if (synchronized(lock) { generation != epoch || failure != null })
                return failed(CancellationException("Connection closed"))
            if (
                AzureUrlCategory.categorizeBaseUrl(
                    clientOptions.baseUrl(),
                    clientOptions.azureUrlPathMode,
                ) == AzureUrlCategory.AZURE_LEGACY
            ) {
                throw UnsupportedOperationException(
                    "Responses WebSocket connections do not support legacy Azure routing; use unified Azure routing"
                )
            }
            clientOptions.requireWebSocketTransport()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegment("responses")
                    .build()
                    .prepare(
                        clientOptions,
                        options,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val opening =
                clientOptions.connectWebSocket(
                    request,
                    requestOptions,
                    options.maxMessageBytes,
                    object : WebSocketClient.Listener {
                        override fun onMessage(text: String) = accept(generation, text)

                        override fun onClosed(code: Int) =
                            fail(generation, IOException("WebSocket closed (code $code)"))

                        override fun onFailure(error: Throwable) = fail(generation, error)
                    },
                )
            val cancelOpening =
                synchronized(lock) {
                    if (generation == epoch && failure == null) {
                        openingTransport = opening
                        false
                    } else true
                }
            if (cancelOpening) opening.cancel(true)
            opening.whenComplete { connected, error ->
                synchronized(lock) { if (generation == epoch) openingTransport = null }
                if (error != null) {
                    fail(generation, error)
                    dispatch { result.completeExceptionally(error) }
                } else {
                    val rejected =
                        synchronized(lock) {
                            if (generation != epoch || failure != null || result.isCancelled) {
                                failure ?: CancellationException("Connection closed")
                            } else {
                                connecting = false
                                socket = connected
                                null
                            }
                        }
                    if (rejected != null) connected.close()
                    dispatch {
                        // The connection may fail while this completion waits on the executor.
                        // Inspect state under lock, but run user continuations outside it.
                        val completionError =
                            rejected
                                ?: synchronized(lock) {
                                    when {
                                        generation != epoch ->
                                            CancellationException("Connection replaced")
                                        failure != null -> failure
                                        clientOptions.isWebSocketClosed() ->
                                            CancellationException("Client is closed")
                                        else -> null
                                    }
                                }
                        if (completionError != null) result.completeExceptionally(completionError)
                        else result.complete(null)
                    }
                }
            }
            result.whenComplete { _, _ ->
                if (result.isCancelled) {
                    opening.cancel(true)
                    close(generation)
                }
            }
        } catch (error: Exception) {
            fail(generation, error)
            result.completeExceptionally(error)
        }
        return result
    }

    // Validate the wire envelope without materializing a second payload tree. Keep this
    // independent of custom event deserializers, which may not retain the original JSON.
    private fun readStreamId(text: String): String? =
        clientOptions.jsonMapper.factory.createParser(text).use { parser ->
            require(parser.nextToken() == JsonToken.START_OBJECT) { "Invalid WebSocket event" }
            var validType = false
            var validStreamId = true
            var streamId: String? = null
            while (parser.nextToken() == JsonToken.FIELD_NAME) {
                val field = parser.currentName
                val token = parser.nextToken()
                when (field) {
                    "type" -> validType = token == JsonToken.VALUE_STRING
                    "stream_id" -> {
                        validStreamId =
                            token == JsonToken.VALUE_STRING || token == JsonToken.VALUE_NULL
                        streamId = if (token == JsonToken.VALUE_STRING) parser.text else null
                    }
                }
                parser.skipChildren()
            }
            require(
                parser.currentToken() == JsonToken.END_OBJECT &&
                    validType &&
                    parser.nextToken() == null
            ) {
                "Invalid WebSocket event"
            }
            require(validStreamId && (streamId == null || STREAM_ID_PATTERN.matches(streamId))) {
                "Invalid WebSocket stream_id"
            }
            streamId
        }

    private fun accept(generation: Long, text: String) {
        try {
            val streamId = readStreamId(text)
            val bytes = utf8Size(text)
            val event: ResponsesServerEvent = eventReader.readValue(text)
            if (requestOptions.responseValidation ?: clientOptions.responseValidation)
                event.validate()
            var waiter: ReadFuture? = null
            synchronized(lock) {
                if (generation != epoch || failure != null) return
                if (
                    queuedEvents >= options.maxQueuedEvents ||
                        bytes > options.maxQueuedBytes - queuedBytes
                )
                    throw IOException("WebSocket event buffer is full")
                queuedBytes += bytes
                queuedEvents += 1
                val channel = channels[streamId] ?: channels.getValue(null)
                waiter =
                    channel.waiter?.takeUnless {
                        it.claimed || it.cancellationReserved || it.isDone
                    }
                if (waiter == null) channel.queue.add(Item(event, bytes))
                else waiter!!.claimed = true
            }
            waiter?.let { target ->
                dispatch {
                    synchronized(lock) {
                        if (generation == epoch) {
                            queuedBytes -= bytes
                            queuedEvents -= 1
                        }
                    }
                    target.complete(event)
                }
            }
        } catch (error: Exception) {
            fail(generation, error)
        }
    }

    // Match String's UTF-8 encoding, including its one-byte replacement for unpaired surrogates,
    // without allocating a second payload while the parsed event is retained.
    private fun utf8Size(text: String): Long {
        var bytes = 0L
        var index = 0
        while (index < text.length) {
            val char = text[index++]
            bytes +=
                when {
                    char < '\u0080' -> 1
                    char < '\u0800' -> 2
                    char !in '\uD800'..'\uDFFF' -> 3
                    char <= '\uDBFF' &&
                        index < text.length &&
                        text[index] in '\uDC00'..'\uDFFF' -> {
                        index++
                        4
                    }
                    else -> 1
                }
        }
        return bytes
    }

    private fun fail(generation: Long, error: Throwable) {
        val detached =
            synchronized(lock) {
                if (generation != epoch || failure != null) return
                detach(error)
            }
        finish(detached)
    }

    // Caller holds lock. No transport operation or user callback may run here.
    private fun detach(error: Throwable): Detached {
        failure = error
        connecting = false
        // An assigned event belongs to its waiter even if the peer closes immediately.
        val detached =
            Detached(
                socket,
                openingTransport,
                channels.values.mapNotNull {
                    it.waiter?.takeUnless { read -> read.claimed || read.cancellationReserved }
                },
                error,
            )
        socket = null
        openingTransport = null
        channels.values.forEach { it.waiter = null }
        return detached
    }

    private fun finish(detached: Detached) {
        detached.opening?.cancel(true)
        try {
            detached.socket?.close()
        } catch (closeError: Exception) {
            if (closeError !== detached.error) detached.error.addSuppressed(closeError)
        }
        detached.waiters.forEach { dispatch { it.completeExceptionally(detached.error) } }
    }

    /** Receives the next unassigned event; only one outstanding receive per lane is permitted. */
    fun receive(): CompletableFuture<ResponsesServerEvent> = receive(null)

    private fun receive(
        id: String?,
        expected: Channel? = null,
    ): CompletableFuture<ResponsesServerEvent> {
        synchronized(lock) {
            val channel = channels[id] ?: return failed(IllegalStateException("Lane is closed"))
            if (expected != null && channel !== expected)
                return failed(IllegalStateException("Lane is closed"))
            if (channel.waiter?.let { it.isDone || it.cancellationReserved } == true)
                channel.waiter = null
            check(channel.waiter == null) { "A receive is already pending on this lane" }
            if (!channel.queue.isEmpty()) {
                val item = channel.queue.removeFirst()
                queuedBytes -= item.bytes
                queuedEvents -= 1
                return CompletableFuture.completedFuture(item.event)
            }
            failure?.let {
                return failed(it)
            }
            val result = ReadFuture()
            channel.waiter = result
            result.whenComplete { _, _ ->
                synchronized(lock) { if (channel.waiter === result) channel.waiter = null }
            }
            return result
        }
    }

    /**
     * Sends a typed command. Success means accepted for writing, not acknowledged by the server.
     */
    fun send(event: ResponsesClientEvent) = send(event, null)

    private fun send(event: ResponsesClientEvent, id: String?, expected: Channel? = null) {
        val generation: Long
        val maxMessageBytes: Int
        synchronized(lock) {
            checkLane(id, expected)
            check(socket != null) { "WebSocket is not connected" }
            check(pendingSends < options.maxPendingSends) {
                "WebSocket pending send limit reached; command was not sent"
            }
            pendingSends += 1
            generation = epoch
            maxMessageBytes = options.maxMessageBytes
        }
        try {
            val raw = clientOptions.jsonMapper.valueToTree<ObjectNode>(event)
            if (id != null && raw.path("type").asText() == "response.create") {
                raw.put("stream_id", id)
            }
            val text = clientOptions.jsonMapper.writeValueAsString(raw)
            require(utf8Size(text) <= maxMessageBytes) {
                "WebSocket command exceeds maxMessageBytes"
            }
            synchronized(writerLock) {
                val active =
                    synchronized(lock) {
                        checkLane(id, expected)
                        check(generation == epoch) { "Connection replaced; command was not sent" }
                        socket ?: throw IllegalStateException("WebSocket is not connected", failure)
                    }
                active.send(text)
            }
        } finally {
            synchronized(lock) { pendingSends -= 1 }
        }
    }

    private fun checkLane(id: String?, expected: Channel?) {
        check(
            id == null ||
                (channels.containsKey(id) && (expected == null || channels[id] === expected))
        ) {
            "Lane is closed"
        }
    }

    /**
     * Registers an independent stream with an ASCII ID matching `[A-Za-z0-9_.-]{1,256}`. Its ID
     * remains reserved until reconnect, even after closing the lane or receiving a terminal event.
     * Closing a lane never closes the shared connection.
     */
    fun lane(streamId: String): Lane =
        synchronized(lock) {
            check(!closed) { "WebSocket is closed" }
            require(STREAM_ID_PATTERN.matches(streamId)) {
                "Stream ID must match [A-Za-z0-9_.-]{1,256}"
            }
            check(streamId !in reservedStreamIds) { "Lane ID is already reserved until reconnect" }
            check(reservedStreamIds.size < options.maxLanes) { "Maximum lane count exceeded" }
            val channel = Channel()
            reservedStreamIds.add(streamId)
            channels[streamId] = channel
            Lane(streamId)
        }

    inner class Lane internal constructor(private val id: String) : AutoCloseable {
        private val channel = synchronized(lock) { channels.getValue(id) }

        fun receive(): CompletableFuture<ResponsesServerEvent> = receive(id, channel)

        fun send(event: ResponsesClientEvent) = send(event, id, channel)

        /**
         * Consumes this lane through a terminal event and returns its complete response snapshot.
         */
        fun finalResponse(): CompletableFuture<Response> = finalResponse(id, channel)

        override fun close() {
            val waiter =
                synchronized(lock) {
                    if (channels[id] !== channel) return
                    channels.remove(id)
                    queuedEvents -= channel.queue.size
                    queuedBytes -= channel.queue.sumOf { it.bytes }
                    channel.queue.clear()
                    channel.waiter
                        .also { channel.waiter = null }
                        ?.takeUnless { it.claimed || it.cancellationReserved }
                }
            waiter?.let {
                dispatch { it.completeExceptionally(CancellationException("Lane closed")) }
            }
        }
    }

    /** Consumes unassigned events through a terminal event. Other lanes continue independently. */
    fun finalResponse(): CompletableFuture<Response> = finalResponse(null)

    private fun finalResponse(id: String?, expected: Channel? = null): CompletableFuture<Response> {
        val generation = synchronized(lock) { epoch }
        var pending: CompletableFuture<ResponsesServerEvent>? = null
        var cancellationReserved = false
        var interrupted: InterruptedException? = null
        val result =
            object : InterruptibleResponseFuture() {
                override fun interrupt(error: InterruptedException): Boolean {
                    synchronized(lock) { interrupted = error }
                    return cancel(false)
                }

                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    val read =
                        synchronized(lock) {
                            // An assigned event belongs to this helper. Reserve an unassigned read
                            // before publishing cancellation, without invoking callbacks under
                            // lock.
                            val current = pending
                            if (
                                current != null &&
                                    (current !is ReadFuture || !current.reserveCancellation())
                            )
                                return false
                            cancellationReserved = true
                            current
                        }
                    try {
                        return super.cancel(mayInterruptIfRunning)
                    } finally {
                        read?.cancel(mayInterruptIfRunning)
                    }
                }
            }
        fun next() {
            val stop: InterruptedException?
            val read =
                synchronized(lock) {
                    if (cancellationReserved || result.isDone) return
                    // Finish the owned event, but observe interruption before claiming another.
                    stop = interrupted
                    (if (stop == null && generation == epoch) receive(id, expected) else null)
                        .also { pending = it }
                }
            if (read == null) {
                result.completeExceptionally(stop ?: CancellationException("Connection replaced"))
                return
            }
            read.whenComplete { event, error ->
                dispatch {
                    try {
                        if (error != null) result.completeExceptionally(error)
                        else if (!result.isDone) {
                            val type =
                                when {
                                    event.isResponseCompleted() -> "response.completed"
                                    event.isResponseFailed() -> "response.failed"
                                    event.isResponseIncomplete() -> "response.incomplete"
                                    event.isError() -> "error"
                                    // Preserve terminal errors when variant deserialization failed.
                                    else ->
                                        event
                                            ._json()
                                            .orElse(null)
                                            ?.asObject()
                                            ?.orElse(null)
                                            ?.get("type")
                                            ?.asString()
                                            ?.orElse(null)
                                }
                            when (type) {
                                "response.completed",
                                "response.failed",
                                "response.incomplete" -> {
                                    val response =
                                        when (type) {
                                            "response.completed" ->
                                                event.asResponseCompleted().response()
                                            "response.failed" -> event.asResponseFailed().response()
                                            else -> event.asResponseIncomplete().response()
                                        }
                                    result.complete(response)
                                }
                                "error" ->
                                    result.completeExceptionally(ResponseWebSocketException(event))
                                else -> next()
                            }
                        }
                    } catch (failure: Exception) {
                        result.completeExceptionally(failure)
                    }
                }
            }
        }
        next()
        return result
    }

    /**
     * Explicitly replaces the socket. Pending reads fail, buffered events are discarded, and lane
     * registrations for open lanes survive. Closed-lane ID reservations are released. No command or
     * uncertain send is replayed; the caller restores state.
     */
    fun reconnect(): CompletableFuture<Void> = reconnect(synchronized(lock) { options })

    /** Replaces the connection options, including handshake headers, before reconnecting. */
    fun reconnect(options: ResponseWebSocketOptions): CompletableFuture<Void> {
        val (detached, attempt) =
            synchronized(lock) {
                check(!closed) { "WebSocket is closed" }
                check(!connecting) { "A connection attempt is already in progress" }
                require(channels.size - 1 <= options.maxLanes) {
                    "Existing lanes exceed the new maximum"
                }
                val detached =
                    if (failure == null) detach(CancellationException("Connection replaced"))
                    else null
                clearQueues()
                reservedStreamIds.clear()
                reservedStreamIds.addAll(channels.keys.filterNotNull())
                this.options = options
                detached to reserveOpen()
            }
        detached?.let { finish(it) }
        return open(attempt)
    }

    override fun close() = close(null)

    private fun close(expectedGeneration: Long?) {
        val detached =
            synchronized(lock) {
                if (expectedGeneration != null && expectedGeneration != epoch) return
                if (closed) return
                if (expectedGeneration == null) closed = true
                val detached =
                    if (failure == null) detach(CancellationException("Connection closed"))
                    else null
                epoch += 1
                clearQueues()
                detached
            }
        detached?.let { finish(it) }
    }

    // Caller holds lock.
    private fun clearQueues() {
        channels.values.forEach { it.queue.clear() }
        queuedBytes = 0
        queuedEvents = 0
    }

    private fun <T> failed(error: Throwable): CompletableFuture<T> =
        CompletableFuture<T>().also { it.completeExceptionally(error) }
}

/** Internal interruption hook for the blocking view; public future cancellation is unchanged. */
internal abstract class InterruptibleResponseFuture : CompletableFuture<Response>() {
    abstract fun interrupt(error: InterruptedException): Boolean
}
