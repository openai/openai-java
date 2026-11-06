package com.openai.core

import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.errors.OpenAIInvalidDataException
import com.openai.helpers.LiveConnection
import com.openai.helpers.LiveForkConnection
import com.openai.helpers.LiveSidebandConnection
import com.openai.models.live.ClientEvent
import com.openai.models.live.DecisionItemCreateEvent
import com.openai.models.live.forks.ForkClientEvent
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.SECONDS
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

/** Public input validation and typed sends, separate from stored-item validation. */
internal class LiveDecisionInputValidationTest {
    private val mapper = jsonMapper()

    @ParameterizedTest(name = "{0}")
    @MethodSource("validInputs")
    fun validatesCurrentInputItemsWithAllInputIdStates(label: String, item: String) {
        val event = decode(item)
        assertThat(event.item().isValid()).describedAs(label).isTrue()
        assertThat(event.item().validate()).isSameAs(event.item())
        assertThat(event.isValid()).describedAs(label).isTrue()
        assertThat(event.validate()).isSameAs(event)
        assertThat(mapper.readTree(mapper.writeValueAsString(event.item())))
            .isEqualTo(mapper.readTree(item))
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """{"type":"message","role":"administrator","content":"fixture"}""",
                """{"type":"unknown_type","role":"user","content":"fixture"}""",
                """{"type":"message","role":"user","content":false}""",
                """{"type":"message","role":"user","content":[{"type":"input_text","text":false}]}""",
                """{"type":"message","role":"user","content":[{"type":"unknown_part","text":"fixture"}]}""",
                """{"type":"message","role":"user","content":"fixture","id":37}""",
                """{"type":"function_call","name":"fixture","arguments":"{}"}""",
                """{"type":"function_call","call_id":"fake-call","arguments":"{}"}""",
                """{"type":"function_call","call_id":"fake-call","name":"fixture","arguments":false}""",
                """{"type":"function_call_output","call_id":"fake-call"}""",
                """{"type":"custom_tool_call","call_id":"fake-call","name":"fixture"}""",
                """{"type":"custom_tool_call_output","output":"fixture"}""",
            ]
    )
    fun rejectsMalformedKnownInputFieldsAndDiscriminators(item: String) {
        val event = decode(item)
        assertThat(event.item().isValid()).isFalse()
        assertThrows<OpenAIInvalidDataException> { event.item().validate() }
        assertThat(event.isValid()).isFalse()
        assertThrows<OpenAIInvalidDataException> { event.validate() }
    }

    @Test
    fun releasedMessageBuilderRequiresContentAndRevalidatesCurrentFields() {
        assertThrows<IllegalStateException> { DecisionItemCreateEvent.Item.builder().build() }
        val original =
            DecisionItemCreateEvent.Item.builder().content("fixture").id("first").build().validate()
        assertThat(original.content().asString()).isEqualTo("fixture")
        assertThat(original.id()).contains("first")
        assertThat(original._role()).isEqualTo(JsonValue.from("user"))

        val updated =
            original.toBuilder().id(null as String?).role(JsonValue.from("developer")).build()
        assertThat(updated.isValid()).isTrue()
        assertThat(updated.validate().id()).isEmpty()
        assertThat(original.id()).contains("first")
        for (bad in
            listOf(
                updated.toBuilder().id(JsonValue.from(42)).build(),
                updated.toBuilder().content(JsonValue.from(false)).build(),
                updated.toBuilder().role(JsonValue.from("administrator")).build(),
                updated
                    .toBuilder()
                    .type(DecisionItemCreateEvent.Item.Type.of("unknown_type"))
                    .build(),
            )) {
            val event = DecisionItemCreateEvent.builder().item(bad).build()
            assertThat(bad.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { bad.validate() }
            assertThat(event.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { event.validate() }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["live", "sideband", "fork"])
    fun decodedAndValidatedTypedInputsReachEachSupportedSocket(family: String) {
        val transport = InputTransport()
        val options =
            ClientOptions.builder().httpClient(transport).apiKey("fake-live-input-key").build()
        fun sendInputs(send: (DecisionItemCreateEvent) -> Unit) {
            for ((label, item) in samples()) {
                val event = decode(item).validate()
                send(event)
                assertThat(mapper.readTree(transport.sent.last()).get("item"))
                    .describedAs("$family $label")
                    .isEqualTo(mapper.readTree(item))
            }
            assertThat(transport.sent).hasSize(samples().size)
            assertThat(transport.closed.count).isEqualTo(1L)
        }
        when (family) {
            "live" ->
                LiveConnection.connect(options).use { live ->
                    sendInputs { event -> live.send(ClientEvent.ofDecisionItemCreate(event)) }
                }
            "sideband" ->
                LiveSidebandConnection.connect(options, "fake-session").use { sideband ->
                    sendInputs { event -> sideband.send(event) }
                }
            "fork" ->
                LiveForkConnection.connect(options, "fake-session").use { fork ->
                    sendInputs { event -> fork.send(ForkClientEvent.ofDecisionItemCreate(event)) }
                }
            else -> error("Unexpected Live family: $family")
        }
        assertThat(transport.closed.await(5, SECONDS)).isTrue()
    }

    private fun decode(item: String): DecisionItemCreateEvent =
        mapper.readValue(
            """{"type":"decision.item.create","event_id":"fake-event","item":$item}""",
            DecisionItemCreateEvent::class.java,
        )

    private class InputTransport : HttpClient, WebSocketClient {
        val sent = mutableListOf<String>()
        val closed = CountDownLatch(1)

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("Unexpected HTTP request")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("Unexpected async HTTP request")

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> =
            CompletableFuture.completedFuture(
                object : WebSocketClient.Connection {
                    override fun send(text: String) {
                        sent.add(text)
                    }

                    override fun close() {
                        closed.countDown()
                    }
                }
            )

        override fun close() {}
    }

    companion object {
        private fun samples(): List<Pair<String, String>> {
            val items =
                listOf(
                    "user" to """{"type":"message","role":"user","content":"fixture"}""",
                    "developer" to """{"type":"message","role":"developer","content":"fixture"}""",
                    "system" to """{"type":"message","role":"system","content":"fixture"}""",
                    "assistant" to """{"type":"message","role":"assistant","content":"fixture"}""",
                    "function_call" to
                        """{"type":"function_call","call_id":"fake-call","name":"fixture","arguments":"{}"}""",
                    "function_call_output" to
                        """{"type":"function_call_output","call_id":"fake-call","output":"fixture"}""",
                    "custom_tool_call" to
                        """{"type":"custom_tool_call","call_id":"fake-call","name":"fixture","input":"fixture"}""",
                    "custom_tool_call_output" to
                        """{"type":"custom_tool_call_output","call_id":"fake-call","output":"fixture"}""",
                    "user_json_omitted_type" to
                        """{"role":"user","content":[{"type":"input_json","data":{"fixture":[1,true]}}]}""",
                    "user_text_omitted_type" to """{"role":"user","content":"fixture"}""",
                ) +
                    listOf("user", "developer", "system", "assistant").map { role ->
                        "$role with tool-shaped extensions" to
                            """{"type":"message","role":"$role","content":"fixture","call_id":"fake-call","name":"fixture","arguments":"{}","namespace":"fixture","status":"completed"}"""
                    }
            return items.flatMap { (label, item) ->
                listOf(
                    "$label missing ID" to item,
                    "$label null ID" to """${item.dropLast(1)},"id":null}""",
                    "$label present ID" to """${item.dropLast(1)},"id":"fake-item"}""",
                )
            }
        }

        @JvmStatic
        fun validInputs(): Stream<Arguments> =
            samples().map { (label, item) -> Arguments.of(label, item) }.stream()
    }
}
