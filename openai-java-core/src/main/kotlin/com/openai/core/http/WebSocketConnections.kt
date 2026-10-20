package com.openai.core.http

import com.openai.azure.AzureUrlCategory
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.prepare
import java.net.URI
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.concurrent.CompletableFuture

/** Default request policy for APIs that opt into the generic connection. */
internal object WebSocketConnections {
    fun <C : Any, S : Any> connect(
        binding: WebSocketBinding<C, S>,
        clientOptions: ClientOptions,
        options: WebSocketOptions,
        requestOptions: RequestOptions,
    ): WebSocketConnection<C, S> =
        awaitWebSocketFuture(
            open(binding, clientOptions, options, requestOptions, true),
            "WebSocket",
        )

    fun <C : Any, S : Any> connectAsync(
        binding: WebSocketBinding<C, S>,
        clientOptions: ClientOptions,
        options: WebSocketOptions,
        requestOptions: RequestOptions,
    ): CompletableFuture<WebSocketConnection<C, S>> =
        open(binding, clientOptions, options, requestOptions, false)

    private fun <C : Any, S : Any> open(
        binding: WebSocketBinding<C, S>,
        clientOptions: ClientOptions,
        options: WebSocketOptions,
        requestOptions: RequestOptions,
        blocking: Boolean,
    ): CompletableFuture<WebSocketConnection<C, S>> =
        WebSocketConnection<C, S>(
                clientOptions,
                requestOptions,
                { request(binding, clientOptions, options) },
                binding.eventType,
                binding.validate,
                options.maxMessageBytes,
                options.maxQueuedBytes,
                options.maxQueuedEvents,
                "WebSocket",
            )
            .open(blocking) { it }

    private fun request(
        binding: WebSocketBinding<*, *>,
        clientOptions: ClientOptions,
        options: WebSocketOptions,
    ): HttpRequest {
        val baseUrl = URI(clientOptions.baseUrl())
        val requestBase = baseUrl.toASCIIString().substringBefore('#').substringBefore('?')
        require(
            AzureUrlCategory.categorizeBaseUrl(requestBase, clientOptions.azureUrlPathMode) !=
                AzureUrlCategory.AZURE_LEGACY
        ) {
            "WebSockets require unified Azure routing"
        }
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(requestBase)
                .pathSegments(binding.pathSegments)
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
        // Both custom transports and OkHttp must see the same once-encoded path.
        val separator = if (requestBase.endsWith("/")) "" else "/"
        return request
            .toBuilder()
            .baseUrl(
                requestBase +
                    separator +
                    binding.pathSegments.joinToString("/") {
                        URLEncoder.encode(it, "UTF-8").replace("+", "%20")
                    }
            )
            .pathSegments(emptyList())
            .build()
    }
}
