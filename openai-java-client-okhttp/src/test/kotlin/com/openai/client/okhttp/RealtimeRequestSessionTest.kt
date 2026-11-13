package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.JsonNull
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.helpers.RealtimeConnection
import com.openai.models.realtime.RealtimeClientEvent
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeTranscriptionSessionCreateRequest
import com.openai.models.realtime.SessionUpdateEvent
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class RealtimeRequestSessionTest {
    private val mapper = jsonMapper()
    private val realtime = """{"type":"realtime","instructions":"speak"}"""
    private val transcription =
        """{"type":"transcription","include":["item.input_audio_transcription.logprobs"]}"""

    @Test
    fun kotlinCallersSendBothRequestTypes() {
        checkWire(realtime) { client, connection ->
            val session = RealtimeSessionCreateRequest.builder().instructions("speak").build()
            val secret =
                client
                    .realtime()
                    .clientSecrets()
                    .create(ClientSecretCreateParams.builder().session(session).build())
            assertThat(secret.sessionOrThrow().isRealtime()).isTrue()
            connection.send(
                RealtimeClientEvent.ofSessionUpdate(
                    SessionUpdateEvent.builder()
                        .session(SessionUpdateEvent.Session.ofRealtime(session))
                        .build()
                )
            )
        }
        checkWire(transcription) { client, connection ->
            val session =
                RealtimeTranscriptionSessionCreateRequest.builder()
                    .addInclude(
                        RealtimeTranscriptionSessionCreateRequest.Include
                            .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    )
                    .build()
            val secret =
                client
                    .realtime()
                    .clientSecrets()
                    .create(ClientSecretCreateParams.builder().session(session).build())
            assertThat(secret.sessionOrThrow().isTranscription()).isTrue()
            connection.send(
                RealtimeClientEvent.ofSessionUpdate(
                    SessionUpdateEvent.builder()
                        .session(SessionUpdateEvent.Session.ofTranscription(session))
                        .build()
                )
            )
        }
    }

    @Test
    fun javaCallersSendBothRequestTypes() {
        checkWire(realtime, JavaRealtimeSessionRequests::sendRealtime)
        checkWire(transcription, JavaRealtimeSessionRequests::sendTranscription)
    }

    private fun checkWire(session: String, send: (OpenAIClient, RealtimeConnection) -> Unit) {
        MockWebServer().use { server ->
            val frame = CompletableFuture<String>()
            server.enqueue(
                MockResponse()
                    .withWebSocketUpgrade(
                        object : WebSocketListener() {
                            override fun onMessage(webSocket: WebSocket, text: String) {
                                frame.complete(text)
                            }
                        }
                    )
            )
            val tag = mapper.readTree(session)["type"].asText()
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody("""{"value":"test","expires_at":1,"session":{"type":"$tag"}}""")
            )
            OkHttpClient.builder().build().use { http ->
                val options =
                    ClientOptions.builder()
                        .httpClient(http)
                        .apiKey("test")
                        .baseUrl(server.url("/v1/").toString())
                        .build()
                RealtimeConnection.connect(options).use { connection ->
                    send(OpenAIClientImpl(options), connection)
                    server.takeRequest(5, TimeUnit.SECONDS)!! // WebSocket upgrade
                    val post = server.takeRequest(5, TimeUnit.SECONDS)!!
                    assertThat(post.method).isEqualTo("POST")
                    assertThat(post.path).isEqualTo("/v1/realtime/client_secrets")
                    assertThat(mapper.readTree(post.body.readUtf8()))
                        .isEqualTo(mapper.readTree("""{"session":$session}"""))
                    val message = frame.get(5, TimeUnit.SECONDS)
                    val decoded =
                        mapper
                            .readValue(message, RealtimeClientEvent::class.java)
                            .asSessionUpdate()
                            .sessionOrThrow()
                    assertThat(decoded.isRealtime()).isEqualTo(tag == "realtime")
                    assertThat(decoded.isTranscription()).isEqualTo(tag == "transcription")
                    assertThat(mapper.readTree(message))
                        .isEqualTo(
                            mapper.readTree("""{"type":"session.update","session":$session}""")
                        )
                }
            }
        }
    }

    @Test
    fun tagSelectsTheSessionEvenWhenMoreFieldsFitTheOtherType() {
        val session =
            """{"type":"transcription","instructions":"keep","parallel_tool_calls":true}"""
        val event =
            mapper.readValue(
                """{"type":"session.update","session":$session}""",
                RealtimeClientEvent::class.java,
            )
        assertThat(event.asSessionUpdate().sessionOrThrow().asTranscription()._allProperties())
            .containsKeys("instructions", "parallel_tool_calls")
        assertThat(mapper.readTree(mapper.writeValueAsBytes(event))["session"])
            .isEqualTo(mapper.readTree(session))
        val body =
            mapper.readValue("""{"session":$session}""", ClientSecretCreateParams.Body::class.java)
        assertThat(body.session().get().isTranscription()).isTrue()
    }

    @Test
    fun unknownOrMissingTagsKeepTheOriginalJson() {
        for (session in
            listOf("""{"type":"future","instructions":"keep"}""", "{}", """{"type":null}""")) {
            val event =
                mapper.readValue(
                    """{"type":"session.update","session":$session}""",
                    RealtimeClientEvent::class.java,
                )
            val value = event.asSessionUpdate().sessionOrThrow()
            assertThat(value.isRealtime() || value.isTranscription()).isFalse()
            assertThat(mapper.readTree(mapper.writeValueAsBytes(event))["session"])
                .isEqualTo(mapper.readTree(session))
            val body =
                mapper.readValue(
                    """{"session":$session}""",
                    ClientSecretCreateParams.Body::class.java,
                )
            assertThat(body.session().get().isRealtime() || body.session().get().isTranscription())
                .isFalse()
            assertThat(mapper.readTree(mapper.writeValueAsBytes(body))["session"])
                .isEqualTo(mapper.readTree(session))
        }
    }

    @Test
    fun secretSessionIsOptionalAndUpdateSessionIsRequired() {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test")
                    .baseUrl(server.url("/v1/").toString())
                    .build()
            try {
                for ((params, expected) in
                    listOf(
                        ClientSecretCreateParams.builder().build() to "{}",
                        ClientSecretCreateParams.builder().session(JsonNull.of()).build() to
                            """{"session":null}""",
                    )) {
                    server.enqueue(
                        MockResponse()
                            .setHeader("Content-Type", "application/json")
                            .setBody(
                                """{"value":"test","expires_at":1,"session":{"type":"realtime"}}"""
                            )
                    )
                    client.realtime().clientSecrets().create(params)
                    val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                    assertThat(mapper.readTree(request.body.readUtf8()))
                        .isEqualTo(mapper.readTree(expected))
                }
            } finally {
                client.close()
            }
        }
        assertThatThrownBy { SessionUpdateEvent.builder().build() }
            .isInstanceOf(IllegalStateException::class.java)
        for (json in
            listOf(
                """{"type":"session.update"}""",
                """{"type":"session.update","session":null}""",
            )) {
            val update = mapper.readValue(json, SessionUpdateEvent::class.java)
            assertThatThrownBy { update.sessionOrThrow() }
                .isInstanceOf(OpenAIInvalidDataException::class.java)
        }
    }
}
