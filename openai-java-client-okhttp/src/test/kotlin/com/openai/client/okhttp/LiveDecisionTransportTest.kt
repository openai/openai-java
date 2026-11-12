package com.openai.client.okhttp

import com.openai.client.okhttp.LiveWebSocketTestFixture.Peer
import com.openai.client.okhttp.LiveWebSocketTestFixture.options
import com.openai.core.jsonMapper
import com.openai.helpers.LiveConnection
import com.openai.models.live.ClientEvent
import com.openai.models.live.DecisionItemCreateEvent
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(25)
class LiveDecisionTransportTest {
    private val mapper = jsonMapper()

    @Test
    fun decisionItemVariantsSurviveSendAndReceive() {
        val items =
            listOf(
                """{"type":"message","role":"user","content":"text"}""",
                """{"type":"message","role":"developer","content":"text"}""",
                """{"type":"message","role":"system","content":"text"}""",
                """{"type":"message","role":"assistant","content":"text"}""",
                """{"type":"message","role":"assistant","content":[]}""",
                """{"type":"message","role":"assistant","id":null,"content":[{"type":"output_text","text":"ready","extra":1},{"type":"refusal","refusal":"declined"}]}""",
                """{"type":"function_call","call_id":"call","name":"tool","arguments":"{}"}""",
                """{"type":"function_call_output","call_id":"call","output":"result"}""",
                """{"type":"custom_tool_call","call_id":"call","name":"tool","input":"text"}""",
                """{"type":"custom_tool_call_output","call_id":"call","output":"result"}""",
            )
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveConnection.connect(options(server, http)).use { conn ->
                    val socket = peer.socket.get(8, TimeUnit.SECONDS)
                    for (json in items) {
                        val item = mapper.readValue(json, DecisionItemCreateEvent.Item::class.java)
                        val expected = mapper.readTree(json)
                        conn.send(
                            ClientEvent.ofDecisionItemCreate(
                                DecisionItemCreateEvent.builder().item(item.validate()).build()
                            )
                        )
                        val sent = mapper.readTree(peer.messages.poll(8, TimeUnit.SECONDS))
                        assertThat(sent.path("type").asText()).isEqualTo("decision.item.create")
                        assertThat(sent.path("item")).isEqualTo(expected)

                        val stored =
                            (expected as com.fasterxml.jackson.databind.node.ObjectNode)
                                .deepCopy()
                                .put("id", "stored")
                        assertThat(
                                socket.send(
                                    """{"type":"decision.item.created","event_id":"event","item":$stored}"""
                                )
                            )
                            .isTrue()
                        val received =
                            conn.receive().asDecisionItemCreated().itemOrThrow().validate()
                        val variant =
                            when (val type = expected.path("type").asText()) {
                                "message" ->
                                    when (expected.path("role").asText()) {
                                        "user" -> received.isDecisionStoredUserMessage()
                                        "developer" -> received.isDecisionStoredDeveloperMessage()
                                        "system" -> received.isDecisionStoredSystemMessage()
                                        else -> received.isDecisionStoredAssistantMessage()
                                    }
                                "function_call" -> received.isFunctionCall()
                                "function_call_output" -> received.isFunctionCallOutput()
                                "custom_tool_call" -> received.isCustomToolCall()
                                "custom_tool_call_output" -> received.isCustomToolCallOutput()
                                else -> error("Unknown fixture type $type")
                            }
                        assertThat(variant).describedAs(json).isTrue()
                        assertThat(mapper.readTree(mapper.writeValueAsBytes(received)))
                            .isEqualTo(stored)
                    }
                }
            }
        }
    }

    @Test
    fun sessionStartedReceivesStructuredDecisionInstructions() {
        val parts =
            """[{"type":"input_text","text":"Review"},{"type":"input_image","image_url":"https://example.com/image"},{"type":"input_json","data":{}},{"type":"input_json","data":{"future":{"value":7}}},{"type":"input_json","data":[]},{"type":"input_json","data":[{"future":[1]}]}]"""
        MockWebServer().use { server ->
            val peer = Peer()
            server.enqueue(MockResponse().withWebSocketUpgrade(peer))
            OkHttpClient.builder().build().use { http ->
                LiveConnection.connect(options(server, http)).use { conn ->
                    val socket = peer.socket.get(8, TimeUnit.SECONDS)
                    val questions =
                        """[{"type":"predicate","instructions":"Ready?"},{"type":"predicate","instructions":$parts}]"""
                    assertThat(
                            socket.send(
                                """{"type":"session.started","event_id":"event","session":{"id":"session","model":"live-test","delegation":{"type":"decisions","decisions":{"model":"test","questions":$questions}}}}"""
                            )
                        )
                        .isTrue()
                    val received =
                        conn
                            .receive()
                            .asSessionStarted()
                            .sessionOrThrow()
                            .delegation()
                            .get()
                            .asDecisions()
                            .decisionsOrThrow()
                            .questionsOrThrow()
                    assertThat(received.first().asPredicate().instructionsOrThrow().asString())
                        .isEqualTo("Ready?")
                    val decoded = received.last().asPredicate().instructionsOrThrow().asParts()
                    assertThat(decoded[0].asInputText().textOrThrow()).isEqualTo("Review")
                    assertThat(decoded[1].asInputImage().imageUrlOrThrow())
                        .isEqualTo("https://example.com/image")
                    assertThat(
                            decoded[2]
                                .asInputJson()
                                .dataOrThrow()
                                .asDecisionJsonObject()
                                ._allProperties()
                        )
                        .isEmpty()
                    assertThat(
                            decoded[3]
                                .asInputJson()
                                .dataOrThrow()
                                .asDecisionJsonObject()
                                ._allProperties()
                        )
                        .containsKey("future")
                    assertThat(decoded[4].asInputJson().dataOrThrow().asDecisionJsonObjects())
                        .isEmpty()
                    assertThat(
                            decoded[5]
                                .asInputJson()
                                .dataOrThrow()
                                .asDecisionJsonObjects()
                                .single()
                                ._allProperties()
                        )
                        .containsKey("future")
                    assertThat(mapper.readTree(mapper.writeValueAsBytes(decoded)))
                        .isEqualTo(mapper.readTree(parts))
                }
            }
        }
    }
}
