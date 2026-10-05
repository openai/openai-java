package com.openai.helpers

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.models.live.CommentaryAppendEvent
import com.openai.models.live.InputAudioMuteEvent
import com.openai.models.live.InputAudioUnmuteEvent
import com.openai.models.live.InstructionsAppendEvent
import com.openai.models.live.ResponseCreateEvent
import com.openai.models.live.ResponseItemCreateEvent
import com.openai.models.live.ServerEvent
import com.openai.models.live.SessionCloseEvent
import com.openai.models.live.SessionUpdateEvent
import com.openai.models.live.ThinkingAppendEvent
import java.util.concurrent.CompletableFuture

/**
 * Attach to an eligible existing Live signaling session with its owner's or bound observer
 * credentials. Configure the intended bearer in ClientOptions or per-connection headers; matching a
 * project alone does not guarantee access. A completed connection is transport-open, not a fresh
 * session.started: the server can replay recent events followed by live delivery. No session.start,
 * reconnect, or audio append is sent by this helper. Send audio over the primary transport.
 *
 * Receive typed Live server events (including reflected audio and signaling events) in wire order.
 * Closing the observer releases its transport without ending the underlying session or its client.
 * Only an explicit send(SessionCloseEvent) requests that the remote session close; keep receiving
 * until session.closed if you need its final output and usage. A failed write is never replayed.
 * <pre>
 * try (LiveSidebandConnection observer =
 *         LiveSidebandConnection.connect(clientOptions, signalingSessionId)) {
 *     ServerEvent event = observer.receive();
 *     // Inspect replayed events, Live errors, and new session events in delivery order.
 * }
 * </pre>
 */
class LiveSidebandConnection
private constructor(
    private val socket: LiveSocket<Any, ServerEvent>,
    private val mapper: ObjectMapper,
) : AutoCloseable {
    companion object {
        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            sessionId: String,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): LiveSidebandConnection =
            LiveSocket.await(open(clientOptions, sessionId, options, requestOptions, true))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            sessionId: String,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<LiveSidebandConnection> =
            open(clientOptions, sessionId, options, requestOptions, false)

        private fun open(
            clientOptions: ClientOptions,
            sessionId: String,
            options: LiveWebSocketOptions,
            requestOptions: RequestOptions,
            blocking: Boolean,
        ): CompletableFuture<LiveSidebandConnection> =
            LiveSocket<Any, ServerEvent>(
                    clientOptions,
                    options,
                    requestOptions,
                    listOf("live", "sessions", sessionId, "attach"),
                    ServerEvent::class.java,
                    { it.validate() },
                    embedEncodedPath = true,
                )
                .open(blocking) { LiveSidebandConnection(it, clientOptions.jsonMapper) }
    }

    fun receive(): ServerEvent = socket.receive()

    /** Canceling an unclaimed receive leaves the next replay or live event available. */
    fun receiveAsync(): CompletableFuture<ServerEvent> = socket.receiveAsync()

    fun send(event: SessionUpdateEvent) = sendCommand(event)

    fun send(event: InputAudioMuteEvent) = sendCommand(event)

    fun send(event: InputAudioUnmuteEvent) = sendCommand(event)

    fun send(event: InstructionsAppendEvent) = sendCommand(event)

    fun send(event: ThinkingAppendEvent) = sendCommand(event)

    fun send(event: CommentaryAppendEvent) = sendCommand(event)

    fun send(event: ResponseItemCreateEvent) = sendCommand(event)

    fun send(event: ResponseCreateEvent) = sendCommand(event)

    fun send(event: SessionCloseEvent) = sendCommand(event)

    private fun sendCommand(event: Any) {
        socket.send(event) { text ->
            // Generated builders and caller mappers can replace an event's type. Never start,
            // reconnect or inject primary audio on an observer, even with such a replacement.
            // Skip payloads without materializing another large JSON tree.
            mapper.factory.createParser(text).use { parser ->
                if (parser.nextToken() == JsonToken.START_OBJECT) {
                    while (parser.nextToken() == JsonToken.FIELD_NAME) {
                        val name = parser.currentName
                        val token = parser.nextToken()
                        if (name == "type" && token == JsonToken.VALUE_STRING) {
                            require(
                                parser.text != "session.start" &&
                                    parser.text != "session.reconnect" &&
                                    parser.text != "session.input_audio.append"
                            ) {
                                "Live sideband cannot start, reconnect or append primary audio"
                            }
                        }
                        parser.skipChildren()
                    }
                }
            }
        }
    }

    override fun close() = socket.close()
}
