package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.credential.BearerTokenCredential
import com.openai.helpers.LiveConnection
import com.openai.helpers.LiveForkConnection
import com.openai.helpers.LiveSidebandConnection
import com.openai.helpers.LiveWebSocketOptions
import com.openai.helpers.RealtimeConnection
import com.openai.helpers.RealtimeWebSocketOptions
import com.openai.helpers.TranslationConnection
import com.openai.helpers.TranslationWebSocketOptions
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(30)
class WebSocketHandshakeTest {
    private fun connect(
        name: String,
        options: ClientOptions,
        explicit: Boolean,
        async: Boolean,
    ): AutoCloseable {
        val realtime =
            RealtimeWebSocketOptions.builder()
                .apply { if (explicit) putHeader("Authorization", "Bearer fake-explicit") }
                .build()
        val translation =
            TranslationWebSocketOptions.builder()
                .apply { if (explicit) putHeader("Authorization", "Bearer fake-explicit") }
                .build()
        val live =
            LiveWebSocketOptions.builder()
                .apply { if (explicit) putHeader("Authorization", "Bearer fake-explicit") }
                .build()
        return when (name) {
            "realtime" ->
                if (async)
                    RealtimeConnection.connectAsync(options, realtime).get(5, TimeUnit.SECONDS)
                else RealtimeConnection.connect(options, realtime)
            "translation" ->
                if (async)
                    TranslationConnection.connectAsync(options, translation)
                        .get(5, TimeUnit.SECONDS)
                else TranslationConnection.connect(options, translation)
            "live" ->
                if (async)
                    LiveConnection.connectAsync(options, options = live).get(5, TimeUnit.SECONDS)
                else LiveConnection.connect(options, options = live)
            "fork" ->
                if (async)
                    LiveForkConnection.connectAsync(options, "synthetic", options = live)
                        .get(5, TimeUnit.SECONDS)
                else LiveForkConnection.connect(options, "synthetic", options = live)
            else ->
                if (async)
                    LiveSidebandConnection.connectAsync(options, "synthetic", options = live)
                        .get(5, TimeUnit.SECONDS)
                else LiveSidebandConnection.connect(options, "synthetic", options = live)
        }
    }

    @Test
    fun publicHelpersRejectCrossOriginRedirects() {
        for (name in listOf("realtime", "translation", "live", "fork", "sideband")) {
            for (async in listOf(false, true)) {
                MockWebServer().use { target ->
                    MockWebServer().use { source ->
                        target.enqueue(MockResponse().setResponseCode(400))
                        source.enqueue(
                            MockResponse()
                                .setResponseCode(307)
                                .addHeader("Location", target.url("/final"))
                        )
                        OkHttpClient.builder().build().use { http ->
                            val options =
                                ClientOptions.builder()
                                    .httpClient(http)
                                    .apiKey("fake-wire-key")
                                    .baseUrl(source.url("/v1/").toString())
                                    .build()
                            var unexpected: AutoCloseable? = null
                            try {
                                assertThatThrownBy {
                                        unexpected = connect(name, options, false, async)
                                    }
                                    .describedAs("%s async=%s", name, async)
                                    .isInstanceOf(Exception::class.java)
                            } finally {
                                unexpected?.close()
                            }
                            val request = source.takeRequest(5, TimeUnit.SECONDS)!!
                            assertThat(request.getHeader("Authorization"))
                                .isEqualTo("Bearer fake-wire-key")
                            assertThat(target.requestCount).isZero()
                            assertThat(source.requestCount).isEqualTo(1)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun publicHelpersRefreshCredentialsAndCloseTheirPeers() {
        for (name in listOf("realtime", "translation", "live", "fork", "sideband")) {
            for (async in listOf(false, true)) {
                MockWebServer().use { server ->
                    OkHttpClient.builder().build().use { http ->
                        val calls = AtomicInteger()
                        val options =
                            ClientOptions.builder()
                                .httpClient(http)
                                .credential(
                                    BearerTokenCredential.create {
                                        "fake-wire-${calls.incrementAndGet()}"
                                    }
                                )
                                .baseUrl(server.url("/v1/").toString())
                                .build()
                        for (attempt in 1..3) {
                            val closed = CountDownLatch(1)
                            val peer =
                                object : WebSocketListener() {
                                    override fun onClosing(
                                        webSocket: WebSocket,
                                        code: Int,
                                        reason: String,
                                    ) {
                                        webSocket.close(code, reason)
                                    }

                                    override fun onClosed(
                                        webSocket: WebSocket,
                                        code: Int,
                                        reason: String,
                                    ) {
                                        closed.countDown()
                                    }

                                    // Some helpers intentionally abort on close instead of waiting
                                    // for a close frame.
                                    override fun onFailure(
                                        webSocket: WebSocket,
                                        t: Throwable,
                                        response: Response?,
                                    ) {
                                        closed.countDown()
                                    }
                                }
                            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
                            connect(name, options, attempt == 3, async).use {
                                val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                                assertThat(request.getHeader("Authorization"))
                                    .describedAs("%s async=%s", name, async)
                                    .isEqualTo(
                                        if (attempt == 3) "Bearer fake-explicit"
                                        else "Bearer fake-wire-$attempt"
                                    )
                            }
                            assertThat(closed.await(5, TimeUnit.SECONDS))
                                .describedAs("%s async=%s", name, async)
                                .isTrue()
                        }
                    }
                }
            }
        }
    }
}
