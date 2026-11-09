package com.openai.client.okhttp

import com.openai.core.http.ResponseWebSocketOptions
import java.net.Proxy
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.TimeUnit
import java.util.stream.Stream
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class BedrockWebSocketProxyTest {

    @TestFactory
    fun sigV4SurvivesProxyHeaderPreparation(): Stream<DynamicTest> =
        Stream.of(false, true).map { throughHttpProxy ->
            dynamicTest("explicit HTTP proxy=$throughHttpProxy") {
                MockWebServer().use { peer ->
                    repeat(2) {
                        peer.enqueue(
                            MockResponse()
                                .withWebSocketUpgrade(
                                    object : WebSocketListener() {
                                        override fun onClosing(
                                            webSocket: WebSocket,
                                            code: Int,
                                            reason: String,
                                        ) {
                                            webSocket.close(code, reason)
                                        }
                                    }
                                )
                        )
                    }
                    peer.start()
                    val url =
                        if (throughHttpProxy) "http://api.proxy-fixture.invalid/openai/v1/"
                        else peer.url("/openai/v1/").toString()
                    val proxy = if (throughHttpProxy) peer.toProxyAddress() else Proxy.NO_PROXY
                    val sdk =
                        BedrockOpenAIOkHttpClient.builder()
                            .baseUrl(url)
                            .proxy(proxy)
                            .awsRegion("us-east-1")
                            .awsAccessKeyId("fixtureAccessKey")
                            .awsSecretAccessKey("fixtureSecretKey")
                            .clock(
                                Clock.fixed(Instant.parse("2026-01-02T03:04:05Z"), ZoneOffset.UTC)
                            )
                            .disableTelemetry(true)
                            .timeout(Duration.ofSeconds(5))
                            .build()
                    try {
                        val baseline =
                            sdk.responses().connect().use {
                                peer.takeRequest(5, TimeUnit.SECONDS)!!
                            }
                        val withProxyHeader =
                            sdk.responses()
                                .connect(
                                    ResponseWebSocketOptions.builder()
                                        .putHeader(
                                            "pRoXy-AuThOrIzAtIoN",
                                            "Basic Zml4dHVyZTpmaXh0dXJl",
                                        )
                                        .build()
                                )
                                .use { peer.takeRequest(5, TimeUnit.SECONDS)!! }

                        assertThat(baseline.method).isEqualTo("GET")
                        assertThat(withProxyHeader.method).isEqualTo("GET")
                        assertThat(baseline.getHeader("Proxy-Authorization")).isNull()
                        assertThat(baseline.getHeader("Authorization"))
                            .startsWith("AWS4-HMAC-SHA256 ")
                            .contains("SignedHeaders=")
                        assertThat(withProxyHeader.getHeader("Authorization"))
                            .isEqualTo(baseline.getHeader("Authorization"))
                            .doesNotContain("proxy-authorization")
                        if (throughHttpProxy) {
                            assertThat(withProxyHeader.getHeader("Proxy-Authorization"))
                                .isEqualTo("Basic Zml4dHVyZTpmaXh0dXJl")
                        } else {
                            assertThat(withProxyHeader.getHeader("Proxy-Authorization")).isNull()
                        }
                    } finally {
                        sdk.close()
                    }
                }
            }
        }
}
