package com.openai.helpers

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.models.live.forks.ForkClientEvent
import com.openai.models.live.forks.ForkServerEvent
import java.util.concurrent.CompletableFuture

/**
 * Fork a finalized, stored Live session on the authenticated client's project. A successful
 * connection opens only the transport, not a Live session: the caller must send a fork
 * session.start, then consume session.started or a server error. The model and conversation come
 * from the stored source. Empty fork overrides preserve the stored configuration.
 *
 * Only an eligible, finalized and available recording can be forked. In particular, a
 * session_storage_failed error is not negated by session.closed. This helper cannot establish
 * availability or authorization from a local source session. All fork errors remain typed events.
 *
 * After requesting session.close, receive until session.closed to preserve final output and usage.
 * close() itself releases only the transport; it never sends protocol commands. Forks do not
 * support session.reconnect. Opening another fork creates a new connection, never restoration or
 * replay.
 * <pre>
 * try (LiveForkConnection fork = LiveForkConnection.connect(clientOptions, storedSessionId)) {
 *     fork.send(ForkClientEvent.ofSessionStart(ForkSessionStartEvent.builder()
 *         .session(ForkSessionConfig.builder().build()).build()));
 *     ForkServerEvent event = fork.receive();
 *     // Inspect session.started or errors before sending audio or commands.
 *     fork.send(ForkClientEvent.ofSessionClose(SessionCloseEvent.builder().build()));
 *     while (!fork.receive().isSessionClosed()) { }
 * }
 * </pre>
 */
class LiveForkConnection
private constructor(
    private val socket: LiveSocket<ForkClientEvent, ForkServerEvent>,
    private val mapper: ObjectMapper,
) : AutoCloseable {
    companion object {
        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            storedSessionId: String,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): LiveForkConnection =
            LiveSocket.await(open(clientOptions, storedSessionId, options, requestOptions, true))

        @JvmStatic
        @JvmOverloads
        fun connectAsync(
            clientOptions: ClientOptions,
            storedSessionId: String,
            options: LiveWebSocketOptions = LiveWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<LiveForkConnection> =
            open(clientOptions, storedSessionId, options, requestOptions, false)

        private fun open(
            clientOptions: ClientOptions,
            storedSessionId: String,
            options: LiveWebSocketOptions,
            requestOptions: RequestOptions,
            blocking: Boolean,
        ): CompletableFuture<LiveForkConnection> {
            // Dot segments have no stable representation across URL-normalizing transports.
            require(
                storedSessionId.isNotEmpty() && storedSessionId != "." && storedSessionId != ".."
            ) {
                "storedSessionId must be a non-empty path segment"
            }
            return LiveSocket<ForkClientEvent, ForkServerEvent>(
                    clientOptions,
                    options,
                    requestOptions,
                    listOf("live", "sessions", storedSessionId, "fork"),
                    ForkServerEvent::class.java,
                    { it.validate() },
                    embedEncodedPath = true,
                )
                .open(blocking) { LiveForkConnection(it, clientOptions.jsonMapper) }
        }
    }

    fun receive(): ForkServerEvent = socket.receive()

    /** Cancel an unclaimed receive without losing the next fork event. */
    fun receiveAsync(): CompletableFuture<ForkServerEvent> = socket.receiveAsync()

    /**
     * Writes one fork command. A transport failure with uncertain delivery ends this connection;
     * the helper never replays the command. Unsupported session.reconnect is rejected before
     * writing, including if it came from an undocumented JSON value or a customized mapper.
     */
    fun send(event: ForkClientEvent) {
        socket.send(event) { text ->
            // Check the serialized wire command without constructing a second tree of audio data.
            mapper.factory.createParser(text).use { parser ->
                if (parser.nextToken() == JsonToken.START_OBJECT) {
                    while (parser.nextToken() == JsonToken.FIELD_NAME) {
                        val name = parser.currentName
                        val token = parser.nextToken()
                        require(
                            name != "type" ||
                                token != JsonToken.VALUE_STRING ||
                                parser.text != "session.reconnect"
                        ) {
                            "Live forks do not support session.reconnect"
                        }
                        parser.skipChildren()
                    }
                }
            }
        }
    }

    override fun close() = socket.close()
}
