package com.openai.helpers

import com.google.errorprone.annotations.MustBeClosed
import com.openai.azure.AzureUrlCategory
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.awaitWebSocketFuture
import com.openai.core.prepare
import com.openai.models.live.ClientEvent
import com.openai.models.live.ServerEvent
import java.net.URI
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.concurrent.CompletableFuture

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
                    com.openai.models.live.LiveWebSocketBinding.create(),
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

/** Keeps Live request policy and public behavior outside the shared connection core. */
internal class LiveSocket<C : Any, S : Any>(
    private val clientOptions: ClientOptions,
    private val options: LiveWebSocketOptions,
    requestOptions: RequestOptions,
    private val binding: com.openai.core.http.WebSocketBinding<*, *>,
    eventType: Class<S>,
    validate: (S) -> Unit,
    private val embedEncodedPath: Boolean = false,
) : AutoCloseable {
    private val path = binding.pathSegments

    private val connection =
        com.openai.core.http.WebSocketConnection<C, S>(
            clientOptions,
            requestOptions,
            ::request,
            eventType,
            validate,
            options.maxMessageBytes,
            options.maxQueuedBytes,
            options.maxQueuedEvents,
            "Live",
        )

    fun <T : AutoCloseable> open(
        blocking: Boolean,
        create: (LiveSocket<C, S>) -> T,
    ): CompletableFuture<T> = connection.open(blocking) { create(this) }

    fun receive(): S = connection.receive()

    fun receiveAsync(): CompletableFuture<S> = connection.receiveAsync()

    fun send(event: C, checkCommand: (String) -> Unit = {}) =
        connection.sendChecked(event, checkCommand)

    override fun close() = connection.close()

    companion object {
        fun <T> await(future: CompletableFuture<T>): T = awaitWebSocketFuture(future, "Live")
    }

    private fun request(): HttpRequest {
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
                .prepare(clientOptions, options, binding.security)
                // Live requires unified routing as checked above. Shared request
                // preparation can still classify the original query-bearing base URL as
                // legacy; retain all prepared auth/defaults and this exact Live endpoint.
                .toBuilder()
                .pathSegments(path)
                .apply {
                    if (embedEncodedPath) {
                        // Fork IDs must address the same resource through request.url() and
                        // OkHttp's addPathSegment. Validate the raw path in prepare() above,
                        // then encode once as URL path (not form data) before authentication.
                        // Keep the suffix in the base so neither transport encodes it again.
                        val separator = if (requestBase.endsWith("/")) "" else "/"
                        baseUrl(
                            requestBase +
                                separator +
                                path.joinToString("/") {
                                    URLEncoder.encode(it, "UTF-8").replace("+", "%20")
                                }
                        )
                        pathSegments(emptyList())
                    }
                }
                .build()
        return request
    }
}
