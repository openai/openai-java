package com.openai.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.SubjectTokenProvider
import com.openai.auth.SubjectTokenType
import com.openai.auth.WorkloadIdentity
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.ResponseWebSocketOptions
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketHandshakeException
import com.openai.core.http.WebSocketOptions
import com.openai.helpers.LiveConnection
import com.openai.helpers.LiveForkConnection
import com.openai.helpers.LiveSidebandConnection
import com.openai.helpers.LiveWebSocketOptions
import com.openai.helpers.RealtimeConnection
import com.openai.helpers.RealtimeWebSocketOptions
import com.openai.helpers.TranslationConnection
import com.openai.helpers.TranslationWebSocketOptions
import com.openai.services.blocking.ResponseServiceImpl
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WebSocketWorkloadIdentityTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["realtime", "translation", "live", "sideband", "fork", "responses", "beta"]
    )
    fun explicitAuthorizationSkipsWorkloadIdentityExchange(family: String) {
        val transport = RecordingTransport()
        val options = options(transport)

        connect(family, options, "Bearer fake-explicit").use {
            assertThat(transport.requests.single().headers.values("Authorization"))
                .containsExactly("Bearer fake-explicit")
            assertThat(transport.exchanges).isZero()
        }
    }

    @Test
    fun explicitAuthorizationFailureDoesNotInvalidateManagedToken() {
        val transport = RecordingTransport()
        val options = options(transport)
        connect("realtime", options).close()
        assertThat(transport.exchanges).isEqualTo(1)

        // Even the same bytes remain caller-owned when explicitly supplied.
        transport.rejectHandshake = true
        assertThrows<WebSocketHandshakeException> {
            connect("sideband", options, "Bearer fake-managed-1")
        }
        transport.rejectHandshake = false
        connect("realtime", options).close()

        assertThat(transport.exchanges).isEqualTo(1)
        assertThat(transport.requests.last().headers.values("Authorization"))
            .containsExactly("Bearer fake-managed-1")
    }

    @Test
    fun managedAuthorizationFailureStillRefreshesManagedToken() {
        val transport = RecordingTransport()
        val options = options(transport)
        transport.rejectHandshake = true
        assertThrows<WebSocketHandshakeException> { connect("realtime", options) }
        transport.rejectHandshake = false
        connect("realtime", options).close()

        assertThat(transport.exchanges).isEqualTo(2)
        assertThat(transport.requests.last().headers.values("Authorization"))
            .containsExactly("Bearer fake-managed-2")
    }

    private fun options(transport: RecordingTransport): ClientOptions =
        ClientOptions.builder()
            .httpClient(transport)
            .workloadIdentity(
                WorkloadIdentity.builder()
                    .identityProviderId("fake-provider")
                    .serviceAccountId("fake-service-account")
                    .provider(
                        object : SubjectTokenProvider {
                            override fun tokenType() = SubjectTokenType.JWT

                            override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper) =
                                "fake-subject"

                            override fun getTokenAsync(
                                httpClient: HttpClient,
                                jsonMapper: JsonMapper,
                            ) = CompletableFuture.completedFuture("fake-subject")
                        }
                    )
                    .build()
            )
            .build()

    private fun connect(
        family: String,
        options: ClientOptions,
        authorization: String? = null,
    ): AutoCloseable =
        when (family) {
            "realtime" ->
                RealtimeConnection.connect(
                    options,
                    RealtimeWebSocketOptions.builder()
                        .apply { authorization?.let { putHeader("aUtHoRiZaTiOn", it) } }
                        .build(),
                )
            "translation" ->
                TranslationConnection.connect(
                    options,
                    TranslationWebSocketOptions.builder()
                        .apply { authorization?.let { putHeader("aUtHoRiZaTiOn", it) } }
                        .build(),
                )
            "responses" ->
                ResponseServiceImpl(options)
                    .connect(
                        ResponseWebSocketOptions.builder()
                            .apply { authorization?.let { putHeader("aUtHoRiZaTiOn", it) } }
                            .build()
                    )
            "beta" ->
                com.openai.services.blocking.beta
                    .ResponseServiceImpl(options)
                    .connectWebSocket(
                        WebSocketOptions.builder()
                            .apply { authorization?.let { putHeader("aUtHoRiZaTiOn", it) } }
                            .build()
                    )
            else -> {
                val live =
                    LiveWebSocketOptions.builder()
                        .apply { authorization?.let { putHeader("aUtHoRiZaTiOn", it) } }
                        .build()
                when (family) {
                    "live" -> LiveConnection.connect(options, options = live)
                    "fork" -> LiveForkConnection.connect(options, "fake-session", options = live)
                    "sideband" ->
                        LiveSidebandConnection.connect(options, "fake-session", options = live)
                    else -> error("Unknown family: $family")
                }
            }
        }

    private class RecordingTransport : HttpClient, WebSocketClient {
        var exchanges = 0
        var rejectHandshake = false
        val requests = mutableListOf<HttpRequest>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            exchanges++
            val body =
                """{"access_token":"fake-managed-$exchanges","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","token_type":"Bearer","expires_in":3600}"""
            return object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() = Headers.builder().build()

                override fun body() = ByteArrayInputStream(body.toByteArray())

                override fun close() {}
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            requests.add(request)
            if (rejectHandshake) {
                return CompletableFuture<WebSocketClient.Connection>().apply {
                    completeExceptionally(WebSocketHandshakeException(401))
                }
            }
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {}

                    override fun close() {}
                }
            )
        }

        override fun close() {}
    }
}
