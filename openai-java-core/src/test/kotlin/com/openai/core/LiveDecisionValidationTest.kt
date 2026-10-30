package com.openai.core

import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.errors.OpenAIInvalidDataException
import com.openai.helpers.LiveConnection
import com.openai.helpers.LiveForkConnection
import com.openai.helpers.LiveSidebandConnection
import com.openai.models.live.DecisionItemCreateEvent
import com.openai.models.live.DecisionItemCreatedEvent
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/** Checks the released Item API at the actual strict WebSocket receive boundary. */
internal class LiveDecisionValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["live", "sideband", "fork"])
    fun strictReceiveAcceptsServiceItemsAndKeepsSocketUsable(family: String) {
        val transport = DecisionTransport()
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .apiKey("fake-live-key")
                .responseValidation(true)
                .build()
        withConnection(family, options) { receive ->
            val inputs =
                listOf(
                    """{"id":"user","type":"message","role":"user","content":"fixture"}""",
                    """{"id":"bad","type":null,"role":"user","content":"fixture"}""",
                    """{"id":"developer","type":"message","role":"developer","content":"fixture"}""",
                    """{"id":"system","type":"message","role":"system","content":"fixture"}""",
                    """{"id":"assistant","type":"message","role":"assistant","content":"fixture"}""",
                    """{"id":"fc","type":"function_call","call_id":"fake-call","name":"fixture","arguments":"{}"}""",
                    """{"id":"fo","type":"function_call_output","call_id":"fake-call","output":"fixture"}""",
                    """{"id":"cc","type":"custom_tool_call","call_id":"fake-call","name":"fixture","input":"fixture"}""",
                    """{"id":"co","type":"custom_tool_call_output","call_id":"fake-call","output":"fixture"}""",
                    """{"id":"json","role":"user","content":[{"type":"input_json","data":{"fixture":[1,true]}}]}""",
                    """{"id":"tail","role":"user","content":"still open"}""",
                ) +
                    listOf("user", "developer", "system", "assistant").map { role ->
                        """{"id":"$role-extra","type":"message","role":"$role","content":"fixture","call_id":"fake-call","name":"fixture","arguments":"{}","namespace":"fixture","status":"completed"}"""
                    }
            for (input in inputs) {
                transport.deliver(input)
                val event = receive()
                assertThat(event.eventId()).isEqualTo("fake-event")
                // A typed, strict receive must preserve every declared and tool-specific field.
                assertThat(
                        options.jsonMapper.readTree(
                            options.jsonMapper.writeValueAsString(event.item())
                        )
                    )
                    .isEqualTo(options.jsonMapper.readTree(input))
            }
            assertThat(transport.closed).isFalse()
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """{"type":"message","role":"user","content":"fixture"}""",
                """{"id":19,"type":"message","role":"user","content":"fixture"}""",
                """{"id":"bad","type":"message","role":"administrator","content":"fixture"}""",
                """{"id":"bad","type":"unknown_type","role":"user","content":"fixture"}""",
                """{"id":"bad","type":"message","role":"user","content":29}""",
                """{"id":"bad","type":"message","role":"user","content":[{"type":"input_json","data":9}]}""",
                """{"id":"bad","type":"function_call","call_id":"fake-call","name":"fixture","arguments":42}""",
                """{"id":"bad","type":"function_call","name":"fixture","arguments":"{}"}""",
                """{"id":"bad","type":"custom_tool_call","call_id":"fake-call","name":"fixture","input":false}""",
                """{"id":"bad","type":"function_call_output","call_id":"fake-call","output":false}""",
                """{"id":"bad","type":"custom_tool_call_output","call_id":"fake-call"}""",
            ]
    )
    fun strictReceiveRejectsKnownInvalidFields(input: String) {
        val transport = DecisionTransport()
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .apiKey("fake-live-key")
                .responseValidation(true)
                .build()
        LiveConnection.connect(options).use { live ->
            transport.deliver(input)
            assertThrows<OpenAIInvalidDataException> { live.receive() }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["developer", "system"])
    fun textContentListValidatesButSingletonObjectDoesNot(role: String) {
        val mapper = jsonMapper()
        val textPart = """{"type":"input_text","text":"fixture"}"""
        for ((content, expectedValid) in
            listOf("[]" to true, "[$textPart]" to true, textPart to false)) {
            val node = mapper.createObjectNode().put("role", role)
            node.set<com.fasterxml.jackson.databind.JsonNode>("content", mapper.readTree(content))
            val input = mapper.treeToValue(node, DecisionItemCreateEvent.Item::class.java)
            val stored =
                mapper.treeToValue(
                    node.put("id", "i_demo"),
                    DecisionItemCreatedEvent.Item::class.java,
                )
            assertThat(input.isValid()).isEqualTo(expectedValid)
            assertThat(stored.isValid()).isEqualTo(expectedValid)
            if (expectedValid) {
                assertThat(input.validate()).isSameAs(input)
                assertThat(stored.validate()).isSameAs(stored)
            } else {
                assertThrows<OpenAIInvalidDataException> { input.validate() }
                assertThrows<OpenAIInvalidDataException> { stored.validate() }
            }
        }
    }

    @Test
    fun releasedBuilderAndGettersStillWorkAndValidationUsesRebuiltValues() {
        val legacy =
            DecisionItemCreatedEvent.Item.builder()
                .id("fake-original")
                .content("fixture")
                .build()
                .validate()
        assertThat(legacy.id()).isEqualTo("fake-original")
        assertThat(legacy.content().asString()).isEqualTo("fixture")
        assertThat(legacy._role()).isEqualTo(JsonValue.from("user"))
        assertThat(legacy.type()).contains(DecisionItemCreatedEvent.Item.Type.MESSAGE)

        val rebuilt =
            legacy.toBuilder().id("fake-updated").role(JsonValue.from("developer")).build()
        assertThat(rebuilt.validate().id()).isEqualTo("fake-updated")
        assertThat(rebuilt._role()).isEqualTo(JsonValue.from("developer"))
        assertThat(legacy._role()).isEqualTo(JsonValue.from("user"))

        val invalidCopies =
            listOf(
                legacy.toBuilder().id(JsonValue.from(42)).build(),
                rebuilt.toBuilder().content(JsonValue.from(false)).build(),
                rebuilt.toBuilder().role(JsonValue.from("administrator")).build(),
            )
        for (invalid in invalidCopies) {
            assertThat(invalid.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { invalid.validate() }
        }
    }

    @Test
    fun validatesStoredStringIdSuppliedThroughAdditionalProperties() {
        val mapper = jsonMapper()
        val withoutId =
            mapper.readValue(
                """{"type":"message","role":"user","content":"fixture"}""",
                DecisionItemCreatedEvent.Item::class.java,
            )
        assertThat(withoutId.isValid()).isFalse()
        assertThrows<OpenAIInvalidDataException> { withoutId.validate() }

        val withId =
            withoutId.toBuilder().putAdditionalProperty("id", JsonValue.from("i_extra")).build()
        assertThat(withId.isValid()).isTrue()
        assertThat(withId.validate()).isSameAs(withId)
        assertThat(mapper.readTree(mapper.writeValueAsString(withId)))
            .isEqualTo(
                mapper.readTree(
                    """{"type":"message","role":"user","content":"fixture","id":"i_extra"}"""
                )
            )
    }

    private fun withConnection(
        family: String,
        options: ClientOptions,
        action: (() -> DecisionItemCreatedEvent) -> Unit,
    ) {
        when (family) {
            "live" ->
                LiveConnection.connect(options).use { live ->
                    action { live.receive().asDecisionItemCreated() }
                }
            "sideband" ->
                LiveSidebandConnection.connect(options, "fake-session").use { sideband ->
                    action { sideband.receive().asDecisionItemCreated() }
                }
            "fork" ->
                LiveForkConnection.connect(options, "fake-session").use { fork ->
                    action { fork.receive().asDecisionItemCreated() }
                }
            else -> error("Unknown family: $family")
        }
    }

    private class DecisionTransport : HttpClient, WebSocketClient {
        lateinit var listener: WebSocketClient.Listener
        var closed = false

        fun deliver(item: String) {
            listener.onMessage(
                """{"type":"decision.item.created","event_id":"fake-event","item":$item}"""
            )
        }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("Unexpected HTTP call")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("Unexpected async HTTP call")

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            this.listener = listener
            return CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {}

                    override fun close() {
                        closed = true
                    }
                }
            )
        }

        override fun close() {}
    }
}
