package com.openai.helpers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonNull
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.jsonMapper
import com.openai.models.ResponsesModel
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCompactionItem
import com.openai.models.responses.ResponseCompletedEvent
import com.openai.models.responses.ResponseCreatedEvent
import com.openai.models.responses.ResponseFailedEvent
import com.openai.models.responses.ResponseInProgressEvent
import com.openai.models.responses.ResponseIncompleteEvent
import com.openai.models.responses.ResponseOutputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseOutputText
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponsesServerEvent
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseAccumulatorTest {

    @Test
    fun snapshotsRequireOptInAndNeverSupplyOmittedServerFields() {
        val mapper = jsonMapper()
        val terminalOnly = ResponseAccumulator.create()
        assertThatThrownBy { terminalOnly.snapshot() }
            .isInstanceOf(IllegalStateException::class.java)
        val accumulator = ResponseAccumulator.createWithSnapshots()
        assertThat(accumulator.snapshot()).isEmpty()
        // The server did not provide output or status. An item at index zero is not permission
        // to turn missing output into a list or turn a created response into a completed response.
        val created =
            mapper.readValue(
                """{"type":"response.created","sequence_number":0,"response":{"id":"resp_partial","provider_metadata":{"trace":"kept"}}}""",
                ResponseStreamEvent::class.java,
            )
        assertThat(accumulator.accumulate(created)).isSameAs(created)
        val partial = accumulator.snapshot().get()
        val added =
            mapper.readValue(
                """{"type":"response.output_item.added","sequence_number":1,"output_index":0,"item":{"id":"msg","type":"message","role":"assistant","status":"in_progress","content":[]}}""",
                ResponseStreamEvent::class.java,
            )
        accumulator.accumulate(added)
        assertThat(accumulator.snapshot().get()).isSameAs(partial)
        assertThat(partial._output().isMissing()).isTrue()
        assertThat(partial._status().isMissing()).isTrue()
        assertThat(
                mapper
                    .valueToTree<com.fasterxml.jackson.databind.JsonNode>(partial)
                    .path("provider_metadata")
                    .path("trace")
                    .asText()
            )
            .isEqualTo("kept")
        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["completed", "failed", "incomplete"])
    fun snapshotUsesOnlyAuthoritativeTerminalResponse(terminal: String) {
        val mapper = jsonMapper()
        val accumulator = ResponseAccumulator.createWithSnapshots()
        val created =
            mapper.readValue(
                """{"type":"response.created","sequence_number":0,"response":{"id":"resp_start","output":[],"status":"in_progress"}}""",
                ResponseStreamEvent::class.java,
            )
        accumulator.accumulate(created)
        val originalPartial = accumulator.snapshot().get()
        val authoritative =
            mapper.readValue(
                """{"type":"response.$terminal","sequence_number":2,"response":{"id":"resp_final","error":{"code":"model_error","message":"authoritative"},"incomplete_details":{"reason":"max_output_tokens"}}}""",
                ResponseStreamEvent::class.java,
            )
        accumulator.accumulate(authoritative)
        val result = accumulator.response()
        assertThat(accumulator.snapshot().get()).isSameAs(result)
        assertThat(result.id()).isEqualTo("resp_final")
        assertThat(result._status().isMissing()).isTrue()
        assertThat(result._output().isMissing()).isTrue()
        assertThat(originalPartial.id()).isEqualTo("resp_start")
        accumulator.accumulate(created)
        assertThat(accumulator.snapshot().get()).isSameAs(result)
    }

    @Test
    fun sseSnapshotsAreImmutableAndKeepTextAndRefusalPartsDistinct() {
        val mapper = jsonMapper()
        val accumulator = ResponseAccumulator.createWithSnapshots()
        val frames =
            listOf(
                """{"type":"response.created","sequence_number":0,"response":{"id":"r","output":[],"status":"in_progress"}}""",
                """{"type":"response.output_item.added","sequence_number":1,"output_index":0,"item":{"id":"m","type":"message","role":"assistant","status":"in_progress","content":[],"from_server":true}}""",
                """{"type":"response.content_part.added","sequence_number":2,"output_index":0,"content_index":0,"item_id":"m","part":{"type":"output_text","text":"","annotations":[],"from_server":17}}""",
                """{"type":"response.output_text.delta","sequence_number":3,"output_index":0,"content_index":0,"item_id":"m","delta":"hello"}""",
                """{"type":"response.content_part.added","sequence_number":4,"output_index":0,"content_index":1,"item_id":"m","part":{"type":"refusal","refusal":""}}""",
                """{"type":"response.refusal.delta","sequence_number":5,"output_index":0,"content_index":1,"item_id":"m","delta":"cannot"}""",
            )
        for (frame in frames) {
            val event = mapper.readValue(frame, ResponseStreamEvent::class.java)
            assertThat(accumulator.accumulate(event)).isSameAs(event)
        }
        val before = accumulator.snapshot().get()
        val content = before.output().single().asMessage().content()
        assertThat(content[0].asOutputText().text()).isEqualTo("hello")
        assertThat(content[1].asRefusal().refusal()).isEqualTo("cannot")
        val next =
            mapper.readValue(
                """{"type":"response.output_text.done","sequence_number":6,"output_index":0,"content_index":0,"item_id":"m","text":"hello final","logprobs":[]}""",
                ResponseStreamEvent::class.java,
            )
        accumulator.accumulate(next)
        val after = accumulator.snapshot().get()
        assertThat(before.output().single().asMessage().content()[0].asOutputText().text())
            .isEqualTo("hello")
        assertThat(after.output().single().asMessage().content()[0].asOutputText().text())
            .isEqualTo("hello final")
        val tree = mapper.valueToTree<com.fasterxml.jackson.databind.JsonNode>(after)
        assertThat(tree.path("output")[0].path("from_server").asBoolean()).isTrue()
        assertThat(tree.path("output")[0].path("content")[0].path("from_server").asInt())
            .isEqualTo(17)
        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun annotationSnapshotsKeepIdentityOrderAndSurviveErrors(websocket: Boolean) {
        val mapper = jsonMapper()
        val accumulator = ResponseAccumulator.createWithSnapshots()
        fun send(frame: String) {
            if (websocket) {
                val event = mapper.readValue(frame, ResponsesServerEvent::class.java)
                assertThat(accumulator.accumulate(event)).isSameAs(event)
            } else {
                val event = mapper.readValue(frame, ResponseStreamEvent::class.java)
                assertThat(accumulator.accumulate(event)).isSameAs(event)
            }
        }
        send(
            """{"type":"response.created","sequence_number":0,"response":{"id":"r","output":[{"id":"m","type":"message","role":"assistant","status":"in_progress","content":[{"type":"output_text","text":"See ","annotations":[]},{"type":"refusal","refusal":""}]}]}}"""
        )
        send(
            """{"type":"response.output_text.delta","sequence_number":1,"output_index":0,"content_index":0,"item_id":"m","delta":"references."}"""
        )
        val before = accumulator.snapshot().get()
        fun annotation(item: String, content: Int, index: Long, title: String) =
            """{"type":"response.output_text.annotation.added","sequence_number":2,"output_index":0,"content_index":$content,"item_id":"$item","annotation_index":$index,"annotation":{"type":"url_citation","url":"https://example.com/citation","title":"$title","start_index":4,"end_index":14,"provider_tag":"kept"}}"""

        send(annotation("m", 0, 0, "original"))
        send(annotation("m", 0, 1, "second"))
        send(annotation("m", 0, 0, "updated"))
        val valid = accumulator.snapshot().get()
        send(annotation("old", 0, 0, "wrong item"))
        send(annotation("m", 1, 0, "wrong part"))
        send(annotation("m", 0, -1, "negative"))
        send(annotation("m", 0, Long.MAX_VALUE, "sparse"))
        send(
            """{"type":"response.error","sequence_number":3,"code":"model_error","message":"offline test","param":null}"""
        )
        val last = accumulator.snapshot().get()
        assertThat(last).isSameAs(valid)
        val text = last.output().single().asMessage().content()[0].asOutputText()
        assertThat(text.text()).isEqualTo("See references.")
        assertThat(text.annotations().map { it.asUrlCitation().title() })
            .containsExactly("updated", "second")
        assertThat(
                text
                    .annotations()[0]
                    .asUrlCitation()
                    ._additionalProperties()["provider_tag"]
                    ?.convert(String::class.java)
            )
            .isEqualTo("kept")
        assertThat(before.output().single().asMessage().content()[0].asOutputText().annotations())
            .isEmpty()
        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun manyFragmentedDeltasPreserveEarlierReadsAndAuthoritativeReplacements() {
        val mapper = jsonMapper()
        val accumulator = ResponseAccumulator.createWithSnapshots()
        fun event(frame: String) = mapper.readValue(frame, ResponseStreamEvent::class.java)
        accumulator.accumulate(
            event(
                """{"type":"response.created","sequence_number":0,"response":{"id":"r","output":[{"id":"m","type":"message","role":"assistant","status":"in_progress","content":[{"type":"output_text","text":"prefix","annotations":[]},{"type":"refusal","refusal":"sorry"}]},{"type":"function_call","id":"f","call_id":"c","name":"tool","arguments":"{"}]}}"""
            )
        )
        val fragment = "x".repeat(128)
        val text =
            event(
                """{"type":"response.output_text.delta","sequence_number":1,"output_index":0,"content_index":0,"item_id":"m","delta":"$fragment"}"""
            )
        val refusal =
            event(
                """{"type":"response.refusal.delta","sequence_number":2,"output_index":0,"content_index":1,"item_id":"m","delta":"$fragment"}"""
            )
        val args =
            event(
                """{"type":"response.function_call_arguments.delta","sequence_number":3,"output_index":1,"item_id":"f","delta":"$fragment"}"""
            )
        accumulator.accumulate(text)
        accumulator.accumulate(refusal)
        accumulator.accumulate(args)
        val before = accumulator.snapshot().get()
        // A real multi-megabyte response fragmented into small events, with no arbitrary API limit.
        repeat(32_768) {
            accumulator.accumulate(text)
            accumulator.accumulate(refusal)
            accumulator.accumulate(args)
        }
        val last = accumulator.snapshot().get()
        assertThat(last.output()[0].asMessage().content()[0].asOutputText().text())
            .isEqualTo("prefix" + fragment.repeat(32_769))
        assertThat(last.output()[0].asMessage().content()[1].asRefusal().refusal())
            .isEqualTo("sorry" + fragment.repeat(32_769))
        assertThat(last.output()[1].asFunctionCall().arguments())
            .isEqualTo("{" + fragment.repeat(32_769))
        assertThat(before.output()[0].asMessage().content()[0].asOutputText().text())
            .isEqualTo("prefix$fragment")
        assertThat(before.output()[0].asMessage().content()[1].asRefusal().refusal())
            .isEqualTo("sorry$fragment")
        assertThat(before.output()[1].asFunctionCall().arguments()).isEqualTo("{$fragment")
        accumulator.accumulate(
            event(
                """{"type":"response.output_item.done","sequence_number":4,"output_index":0,"item":{"id":"replacement","type":"message","role":"assistant","status":"completed","content":[{"type":"output_text","text":"authoritative","annotations":[]}]}}"""
            )
        )
        accumulator.accumulate(text)
        accumulator.accumulate(refusal)
        accumulator.accumulate(
            event(
                """{"type":"response.function_call_arguments.done","sequence_number":5,"output_index":1,"item_id":"f","arguments":"{}"}"""
            )
        )
        val replaced = accumulator.snapshot().get()
        assertThat(replaced.output()[0].asMessage().content().single().asOutputText().text())
            .isEqualTo("authoritative")
        assertThat(replaced.output()[1].asFunctionCall().arguments()).isEqualTo("{}")
        assertThat(last.output()[1].asFunctionCall().arguments()).endsWith(fragment)
    }

    @Test
    fun responseBeforeAccumulation() {
        val accumulator = ResponseAccumulator.create()

        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Completed response is not yet received.")
    }

    @Test
    fun structuredResponseBeforeAccumulation() {
        val accumulator = ResponseAccumulator.create()

        assertThatThrownBy { accumulator.response(String::class.java) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessage("Completed response is not yet received.")
    }

    @Test
    fun responseAfterAccumulation() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        assertThatNoException().isThrownBy { accumulator.response() }
        assertThat(accumulator.response().id()).isEqualTo("response-id")
    }

    @Test
    fun structuredResponseAfterAccumulation() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        // No deserialization is attempted, so the `Class<T>` does not matter. Deserialization is
        // beyond the scope of this test; it is tested elsewhere at a lower level.
        assertThatNoException().isThrownBy { accumulator.response(String::class.java) }
        assertThat(accumulator.response(String::class.java).id()).isEqualTo("response-id")
        assertThat(accumulator.response(String::class.java).responseType)
            .isEqualTo(String::class.java)
    }

    @Test
    fun accumulateAfterCompletedIgnoresPostCompletionEvents() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        assertThatNoException().isThrownBy {
            accumulator.accumulate(responseRateLimitsUpdatedEvent())
        }
        assertThat(accumulator.response().id()).isEqualTo("response-id")
    }

    @Test
    fun responseValidationRejectsUnknownPostCompletionEventBeforeAccumulation() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))
        val streamResponse = streamResponseOf(responseRateLimitsUpdatedEvent())
        val validatedStreamResponse = streamResponse.map { it.validate() }

        // This mirrors the realistic client path when response validation is enabled:
        //
        // OpenAIClient client = OpenAIOkHttpClient.builder()
        //     .fromEnv()
        //     .responseValidation(true)
        //     .build();
        //
        // ResponseCreateParams params = ResponseCreateParams.builder()
        //     .input("example input")
        //     .build();
        //
        // ResponseAccumulator accumulator = ResponseAccumulator.create();
        //
        // try (StreamResponse<ResponseStreamEvent> stream =
        //         client.responses().createStreaming(params)) {
        //     stream.stream().forEach(accumulator::accumulate);
        // }
        //
        // In that client configuration, generated service code validates each streamed event with
        // `streamResponse.map { it.validate() }` before user code receives it. So an unknown
        // post-completion event can throw during validation before `ResponseAccumulator` gets the
        // chance to ignore it.
        assertThatThrownBy {
                validatedStreamResponse.stream().forEach { accumulator.accumulate(it) }
            }
            .hasMessageStartingWith("Unknown ResponseStreamEvent")
    }

    @Test
    fun accumulateUntilCompleted() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofCompleted(responseCompletedEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 2])
    fun compactionProgressPreservesFinalOutput(progressCount: Int) {
        val accumulator = ResponseAccumulator.create()
        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))

        repeat(progressCount) { index ->
            val progress =
                jsonMapper()
                    .readValue(
                        """{"type":"response.compaction.compacting","item_id":"cmp_test","output_index":0,"sequence_number":${index + 2}}""",
                        jacksonTypeRef<ResponseStreamEvent>(),
                    )
                    .validate()
            assertThat(accumulator.accumulate(progress)).isSameAs(progress)
        }
        assertThatThrownBy { accumulator.response() }
            .isExactlyInstanceOf(IllegalStateException::class.java)

        val compaction =
            ResponseCompactionItem.builder()
                .id("cmp_test")
                .encryptedContent("synthetic-encrypted-content")
                .build()
        val completed =
            response()
                .toBuilder()
                .output(listOf(ResponseOutputItem.ofCompaction(compaction)))
                .build()
        accumulator.accumulate(
            ResponseStreamEvent.ofCompleted(
                ResponseCompletedEvent.builder().response(completed).sequenceNumber(4L).build()
            )
        )

        assertThat(accumulator.response()).isSameAs(completed)
        assertThat(accumulator.response().output())
            .containsExactly(ResponseOutputItem.ofCompaction(compaction))
    }

    @Test
    fun accumulateUntilIncomplete() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofIncomplete(responseIncompleteEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    @Test
    fun accumulateUntilFailed() {
        val accumulator = ResponseAccumulator.create()

        accumulator.accumulate(ResponseStreamEvent.ofCreated(responseCreatedEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofInProgress(responseInProgressEvent()))
        accumulator.accumulate(ResponseStreamEvent.ofFailed(responseFailedEvent()))

        val response = accumulator.response()

        assertThat(response.id()).isEqualTo("response-id")
    }

    private fun responseCreatedEvent() =
        ResponseCreatedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseInProgressEvent() =
        ResponseInProgressEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseCompletedEvent() =
        ResponseCompletedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseFailedEvent() =
        ResponseFailedEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseIncompleteEvent() =
        ResponseIncompleteEvent.builder().response(response()).sequenceNumber(1L).build()

    private fun responseRateLimitsUpdatedEvent(): ResponseStreamEvent =
        jsonMapper()
            .readValue(
                """{"type":"response.rate_limits.updated","sequence_number":2,"rate_limits":[]}""",
                jacksonTypeRef<ResponseStreamEvent>(),
            )

    private fun streamResponseOf(event: ResponseStreamEvent): StreamResponse<ResponseStreamEvent> =
        object : StreamResponse<ResponseStreamEvent> {
            override fun stream(): Stream<ResponseStreamEvent> = Stream.of(event)

            override fun close() {}
        }

    private fun response() =
        Response.builder()
            .id("response-id")
            .createdAt(System.currentTimeMillis() / 1_000.0)
            .error(null)
            .incompleteDetails(null)
            .instructions(null)
            .metadata(null)
            .model(ResponsesModel.ResponsesOnlyModel.O1_PRO)
            .addOutput(responseOutputItemOfMessage())
            .parallelToolCalls(false)
            .temperature(null)
            .toolChoice(JsonNull.of())
            .tools(listOf())
            .topP(null)
            .build()

    private fun responseOutputItemOfMessage() =
        ResponseOutputItem.ofMessage(responseOutputMessage())

    private fun responseOutputMessage() =
        ResponseOutputMessage.builder()
            .id("message-id")
            .addContent(ResponseOutputMessage.Content.ofOutputText(responseOutputText()))
            .status(ResponseOutputMessage.Status.COMPLETED)
            .build()

    private fun responseOutputText() =
        ResponseOutputText.builder()
            .text("Hello World")
            .annotations(listOf())
            .logprobs(listOf())
            .build()
}
