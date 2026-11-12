package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.http.HttpClient
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockWebServer

internal object LiveWebSocketTestFixture {
    class Peer : WebSocketListener() {
        val socket = CompletableFuture<WebSocket>()
        val messages = LinkedBlockingQueue<String>()
        val closed = CountDownLatch(1)

        override fun onOpen(webSocket: WebSocket, response: Response) {
            socket.complete(webSocket)
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            messages.add(text)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            closed.countDown()
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            closed.countDown()
        }
    }

    fun options(server: MockWebServer, http: HttpClient) =
        ClientOptions.builder()
            .httpClient(http)
            .apiKey("fake-live-key")
            .baseUrl(server.url("/proxy/v1?inherited=one%2Ftwo&x=a%2Bb").toString())
            .build()
}
