// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponsesServerEventTest {

    @Test
    fun ofResponseAudioDelta() {
        val responseAudioDelta =
            ResponseAudioDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseAudioDelta(responseAudioDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).contains(responseAudioDelta)
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioDelta(
                ResponseAudioDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseAudioDone() {
        val responseAudioDone = ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseAudioDone(responseAudioDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).contains(responseAudioDone)
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseAudioDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioDone(
                ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseAudioTranscriptDelta() {
        val responseAudioTranscriptDelta =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioTranscriptDelta(responseAudioTranscriptDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta())
            .contains(responseAudioTranscriptDelta)
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseAudioTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioTranscriptDelta(
                ResponseAudioTranscriptDeltaEvent.builder()
                    .delta("delta")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseAudioTranscriptDone() {
        val responseAudioTranscriptDone =
            ResponseAudioTranscriptDoneEvent.builder().sequenceNumber(0L).build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioTranscriptDone(responseAudioTranscriptDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone())
            .contains(responseAudioTranscriptDone)
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseAudioTranscriptDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseAudioTranscriptDone(
                ResponseAudioTranscriptDoneEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCodeInterpreterCallCodeDelta() {
        val responseCodeInterpreterCallCodeDelta =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCodeDelta(
                responseCodeInterpreterCallCodeDelta
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta())
            .contains(responseCodeInterpreterCallCodeDelta)
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCodeInterpreterCallCodeDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCodeDelta(
                ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCodeInterpreterCallCodeDone() {
        val responseCodeInterpreterCallCodeDone =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCodeDone(
                responseCodeInterpreterCallCodeDone
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone())
            .contains(responseCodeInterpreterCallCodeDone)
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCodeInterpreterCallCodeDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCodeDone(
                ResponseCodeInterpreterCallCodeDoneEvent.builder()
                    .code("code")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCodeInterpreterCallCompleted() {
        val responseCodeInterpreterCallCompleted =
            ResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCompleted(
                responseCodeInterpreterCallCompleted
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted())
            .contains(responseCodeInterpreterCallCompleted)
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCodeInterpreterCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallCompleted(
                ResponseCodeInterpreterCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCodeInterpreterCallInProgress() {
        val responseCodeInterpreterCallInProgress =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallInProgress(
                responseCodeInterpreterCallInProgress
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress())
            .contains(responseCodeInterpreterCallInProgress)
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCodeInterpreterCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallInProgress(
                ResponseCodeInterpreterCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCodeInterpreterCallInterpreting() {
        val responseCodeInterpreterCallInterpreting =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallInterpreting(
                responseCodeInterpreterCallInterpreting
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting())
            .contains(responseCodeInterpreterCallInterpreting)
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCodeInterpreterCallInterpretingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCodeInterpreterCallInterpreting(
                ResponseCodeInterpreterCallInterpretingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCompleted() {
        val responseCompleted =
            ResponseCompletedEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseCompleted(responseCompleted)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).contains(responseCompleted)
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCompleted(
                ResponseCompletedEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseContentPartAdded() {
        val responseContentPartAdded =
            ResponseContentPartAddedEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseOutputText.builder()
                        .addAnnotation(
                            ResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            ResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseContentPartAdded(responseContentPartAdded)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded())
            .contains(responseContentPartAdded)
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseContentPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseContentPartAdded(
                ResponseContentPartAddedEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseOutputText.builder()
                            .addAnnotation(
                                ResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .addLogprob(
                                ResponseOutputText.Logprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .addTopLogprob(
                                        ResponseOutputText.Logprob.TopLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseContentPartDone() {
        val responseContentPartDone =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseOutputText.builder()
                        .addAnnotation(
                            ResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            ResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseContentPartDone(responseContentPartDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).contains(responseContentPartDone)
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseContentPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseContentPartDone(
                ResponseContentPartDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseOutputText.builder()
                            .addAnnotation(
                                ResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .addLogprob(
                                ResponseOutputText.Logprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .addTopLogprob(
                                        ResponseOutputText.Logprob.TopLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCreated() {
        val responseCreated =
            ResponseCreatedEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseCreated(responseCreated)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).contains(responseCreated)
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCreated(
                ResponseCreatedEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofError() {
        val error =
            ResponseErrorEvent.builder()
                .code("code")
                .message("message")
                .param("param")
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofError(error)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).contains(error)
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofError(
                ResponseErrorEvent.builder()
                    .code("code")
                    .message("message")
                    .param("param")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFileSearchCallCompleted() {
        val responseFileSearchCallCompleted =
            ResponseFileSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallCompleted(responseFileSearchCallCompleted)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted())
            .contains(responseFileSearchCallCompleted)
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFileSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallCompleted(
                ResponseFileSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFileSearchCallInProgress() {
        val responseFileSearchCallInProgress =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallInProgress(
                responseFileSearchCallInProgress
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress())
            .contains(responseFileSearchCallInProgress)
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFileSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallInProgress(
                ResponseFileSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFileSearchCallSearching() {
        val responseFileSearchCallSearching =
            ResponseFileSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallSearching(responseFileSearchCallSearching)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching())
            .contains(responseFileSearchCallSearching)
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFileSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFileSearchCallSearching(
                ResponseFileSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFunctionCallArgumentsDelta() {
        val responseFunctionCallArgumentsDelta =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFunctionCallArgumentsDelta(
                responseFunctionCallArgumentsDelta
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta())
            .contains(responseFunctionCallArgumentsDelta)
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFunctionCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFunctionCallArgumentsDelta(
                ResponseFunctionCallArgumentsDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFunctionCallArgumentsDone() {
        val responseFunctionCallArgumentsDone =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFunctionCallArgumentsDone(
                responseFunctionCallArgumentsDone
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone())
            .contains(responseFunctionCallArgumentsDone)
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFunctionCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFunctionCallArgumentsDone(
                ResponseFunctionCallArgumentsDoneEvent.builder()
                    .arguments("arguments")
                    .itemId("item_id")
                    .name("name")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseInProgress() {
        val responseInProgress =
            ResponseInProgressEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseInProgress(responseInProgress)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).contains(responseInProgress)
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseInProgress(
                ResponseInProgressEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseFailed() {
        val responseFailed =
            ResponseFailedEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseFailed(responseFailed)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).contains(responseFailed)
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseFailed(
                ResponseFailedEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseIncomplete() {
        val responseIncomplete =
            ResponseIncompleteEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseIncomplete(responseIncomplete)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).contains(responseIncomplete)
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseIncomplete(
                ResponseIncompleteEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseOutputItemAdded() {
        val responseOutputItemAdded =
            ResponseOutputItemAddedEvent.builder()
                .item(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputItemAdded(responseOutputItemAdded)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).contains(responseOutputItemAdded)
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseOutputItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputItemAdded(
                ResponseOutputItemAddedEvent.builder()
                    .item(
                        ResponseOutputMessage.builder()
                            .id("id")
                            .addContent(
                                ResponseOutputText.builder()
                                    .addAnnotation(
                                        ResponseOutputText.Annotation.FileCitation.builder()
                                            .fileId("file_id")
                                            .filename("filename")
                                            .index(0L)
                                            .build()
                                    )
                                    .text("text")
                                    .addLogprob(
                                        ResponseOutputText.Logprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .addTopLogprob(
                                                ResponseOutputText.Logprob.TopLogprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .status(ResponseOutputMessage.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseOutputItemDone() {
        val responseOutputItemDone =
            ResponseOutputItemDoneEvent.builder()
                .item(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputItemDone(responseOutputItemDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).contains(responseOutputItemDone)
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseOutputItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputItemDone(
                ResponseOutputItemDoneEvent.builder()
                    .item(
                        ResponseOutputMessage.builder()
                            .id("id")
                            .addContent(
                                ResponseOutputText.builder()
                                    .addAnnotation(
                                        ResponseOutputText.Annotation.FileCitation.builder()
                                            .fileId("file_id")
                                            .filename("filename")
                                            .index(0L)
                                            .build()
                                    )
                                    .text("text")
                                    .addLogprob(
                                        ResponseOutputText.Logprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .addTopLogprob(
                                                ResponseOutputText.Logprob.TopLogprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .status(ResponseOutputMessage.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningSummaryPartAdded() {
        val responseReasoningSummaryPartAdded =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryPartAdded(
                responseReasoningSummaryPartAdded
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded())
            .contains(responseReasoningSummaryPartAdded)
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningSummaryPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryPartAdded(
                ResponseReasoningSummaryPartAddedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build()
                    )
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningSummaryPartDone() {
        val responseReasoningSummaryPartDone =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryPartDone(
                responseReasoningSummaryPartDone
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone())
            .contains(responseReasoningSummaryPartDone)
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningSummaryPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryPartDone(
                ResponseReasoningSummaryPartDoneEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningSummaryTextDelta() {
        val responseReasoningSummaryTextDelta =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryTextDelta(
                responseReasoningSummaryTextDelta
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta())
            .contains(responseReasoningSummaryTextDelta)
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningSummaryTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryTextDelta(
                ResponseReasoningSummaryTextDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningSummaryTextDone() {
        val responseReasoningSummaryTextDone =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryTextDone(
                responseReasoningSummaryTextDone
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone())
            .contains(responseReasoningSummaryTextDone)
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningSummaryTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningSummaryTextDone(
                ResponseReasoningSummaryTextDoneEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningTextDelta() {
        val responseReasoningTextDelta =
            ResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningTextDelta(responseReasoningTextDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta())
            .contains(responseReasoningTextDelta)
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningTextDelta(
                ResponseReasoningTextDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseReasoningTextDone() {
        val responseReasoningTextDone =
            ResponseReasoningTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningTextDone(responseReasoningTextDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone())
            .contains(responseReasoningTextDone)
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseReasoningTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseReasoningTextDone(
                ResponseReasoningTextDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseRefusalDelta() {
        val responseRefusalDelta =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseRefusalDelta(responseRefusalDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).contains(responseRefusalDelta)
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseRefusalDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseRefusalDelta(
                ResponseRefusalDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseRefusalDone() {
        val responseRefusalDone =
            ResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseRefusalDone(responseRefusalDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).contains(responseRefusalDone)
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseRefusalDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseRefusalDone(
                ResponseRefusalDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .refusal("refusal")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseOutputTextDelta() {
        val responseOutputTextDelta =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .addLogprob(
                    ResponseTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextDelta(responseOutputTextDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).contains(responseOutputTextDelta)
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseOutputTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextDelta(
                ResponseTextDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .addLogprob(
                        ResponseTextDeltaEvent.Logprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .addTopLogprob(
                                ResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                                    .token("token")
                                    .logprob(0.0)
                                    .build()
                            )
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseOutputTextDone() {
        val responseOutputTextDone =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .addLogprob(
                    ResponseTextDoneEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextDone(responseOutputTextDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).contains(responseOutputTextDone)
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseOutputTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextDone(
                ResponseTextDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .addLogprob(
                        ResponseTextDoneEvent.Logprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .addTopLogprob(
                                ResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                    .token("token")
                                    .logprob(0.0)
                                    .build()
                            )
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseWebSearchCallCompleted() {
        val responseWebSearchCallCompleted =
            ResponseWebSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallCompleted(responseWebSearchCallCompleted)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted())
            .contains(responseWebSearchCallCompleted)
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseWebSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallCompleted(
                ResponseWebSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseWebSearchCallInProgress() {
        val responseWebSearchCallInProgress =
            ResponseWebSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallInProgress(responseWebSearchCallInProgress)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress())
            .contains(responseWebSearchCallInProgress)
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseWebSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallInProgress(
                ResponseWebSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseWebSearchCallSearching() {
        val responseWebSearchCallSearching =
            ResponseWebSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallSearching(responseWebSearchCallSearching)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching())
            .contains(responseWebSearchCallSearching)
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseWebSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseWebSearchCallSearching(
                ResponseWebSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseImageGenerationCallCompleted() {
        val responseImageGenerationCallCompleted =
            ResponseImageGenCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallCompleted(
                responseImageGenerationCallCompleted
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted())
            .contains(responseImageGenerationCallCompleted)
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseImageGenerationCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallCompleted(
                ResponseImageGenCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseImageGenerationCallGenerating() {
        val responseImageGenerationCallGenerating =
            ResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallGenerating(
                responseImageGenerationCallGenerating
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating())
            .contains(responseImageGenerationCallGenerating)
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseImageGenerationCallGeneratingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallGenerating(
                ResponseImageGenCallGeneratingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseImageGenerationCallInProgress() {
        val responseImageGenerationCallInProgress =
            ResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallInProgress(
                responseImageGenerationCallInProgress
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress())
            .contains(responseImageGenerationCallInProgress)
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseImageGenerationCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallInProgress(
                ResponseImageGenCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseImageGenerationCallPartialImage() {
        val responseImageGenerationCallPartialImage =
            ResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallPartialImage(
                responseImageGenerationCallPartialImage
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage())
            .contains(responseImageGenerationCallPartialImage)
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseImageGenerationCallPartialImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseImageGenerationCallPartialImage(
                ResponseImageGenCallPartialImageEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .partialImageB64("partial_image_b64")
                    .partialImageIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpCallArgumentsDelta() {
        val responseMcpCallArgumentsDelta =
            ResponseMcpCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallArgumentsDelta(responseMcpCallArgumentsDelta)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta())
            .contains(responseMcpCallArgumentsDelta)
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallArgumentsDelta(
                ResponseMcpCallArgumentsDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpCallArgumentsDone() {
        val responseMcpCallArgumentsDone =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallArgumentsDone(responseMcpCallArgumentsDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone())
            .contains(responseMcpCallArgumentsDone)
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallArgumentsDone(
                ResponseMcpCallArgumentsDoneEvent.builder()
                    .arguments("arguments")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpCallCompleted() {
        val responseMcpCallCompleted =
            ResponseMcpCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallCompleted(responseMcpCallCompleted)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted())
            .contains(responseMcpCallCompleted)
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallCompleted(
                ResponseMcpCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpCallFailed() {
        val responseMcpCallFailed =
            ResponseMcpCallFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallFailed(responseMcpCallFailed)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).contains(responseMcpCallFailed)
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpCallFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallFailed(
                ResponseMcpCallFailedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpCallInProgress() {
        val responseMcpCallInProgress =
            ResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallInProgress(responseMcpCallInProgress)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress())
            .contains(responseMcpCallInProgress)
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpCallInProgress(
                ResponseMcpCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpListToolsCompleted() {
        val responseMcpListToolsCompleted =
            ResponseMcpListToolsCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsCompleted(responseMcpListToolsCompleted)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted())
            .contains(responseMcpListToolsCompleted)
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpListToolsCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsCompleted(
                ResponseMcpListToolsCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpListToolsFailed() {
        val responseMcpListToolsFailed =
            ResponseMcpListToolsFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsFailed(responseMcpListToolsFailed)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed())
            .contains(responseMcpListToolsFailed)
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpListToolsFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsFailed(
                ResponseMcpListToolsFailedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseMcpListToolsInProgress() {
        val responseMcpListToolsInProgress =
            ResponseMcpListToolsInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsInProgress(responseMcpListToolsInProgress)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress())
            .contains(responseMcpListToolsInProgress)
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseMcpListToolsInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseMcpListToolsInProgress(
                ResponseMcpListToolsInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseOutputTextAnnotationAdded() {
        val responseOutputTextAnnotationAdded =
            ResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(JsonValue.from(mapOf<String, Any>()))
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextAnnotationAdded(
                responseOutputTextAnnotationAdded
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded())
            .contains(responseOutputTextAnnotationAdded)
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseOutputTextAnnotationAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseOutputTextAnnotationAdded(
                ResponseOutputTextAnnotationAddedEvent.builder()
                    .annotation(JsonValue.from(mapOf<String, Any>()))
                    .annotationIndex(0L)
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseQueued() {
        val responseQueued =
            ResponseQueuedEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("string")
                        .metadata(
                            Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.GPT_5_1)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .filename("filename")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .addLogprob(
                                            ResponseOutputText.Logprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ResponseOutputText.Logprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FunctionTool.builder()
                                .name("name")
                                .parameters(
                                    FunctionTool.Parameters.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .strict(true)
                                .description("description")
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .previousResponseId("previous_response_id")
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .promptCacheKey("prompt-cache-key-1234")
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .safetyIdentifier("safety-identifier-1234")
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .verbosity(ResponseTextConfig.Verbosity.LOW)
                                .build()
                        )
                        .topLogprobs(0L)
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .inputTokensDetails(
                                    ResponseUsage.InputTokensDetails.builder()
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent = ResponsesServerEvent.ofResponseQueued(responseQueued)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).contains(responseQueued)
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseQueuedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseQueued(
                ResponseQueuedEvent.builder()
                    .response(
                        Response.builder()
                            .id("id")
                            .createdAt(0.0)
                            .error(
                                ResponseError.builder()
                                    .code(ResponseError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .incompleteDetails(
                                Response.IncompleteDetails.builder()
                                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                    .build()
                            )
                            .instructions("string")
                            .metadata(
                                Response.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .model(ChatModel.GPT_5_1)
                            .addOutput(
                                ResponseOutputMessage.builder()
                                    .id("id")
                                    .addContent(
                                        ResponseOutputText.builder()
                                            .addAnnotation(
                                                ResponseOutputText.Annotation.FileCitation.builder()
                                                    .fileId("file_id")
                                                    .filename("filename")
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .addLogprob(
                                                ResponseOutputText.Logprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .addTopLogprob(
                                                        ResponseOutputText.Logprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .addByte(0L)
                                                            .logprob(0.0)
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FunctionTool.builder()
                                    .name("name")
                                    .parameters(
                                        FunctionTool.Parameters.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .strict(true)
                                    .description("description")
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .previousResponseId("previous_response_id")
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .promptCacheKey("prompt-cache-key-1234")
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .safetyIdentifier("safety-identifier-1234")
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
                                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                                    .build()
                            )
                            .topLogprobs(0L)
                            .truncation(Response.Truncation.AUTO)
                            .usage(
                                ResponseUsage.builder()
                                    .inputTokens(0L)
                                    .inputTokensDetails(
                                        ResponseUsage.InputTokensDetails.builder()
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        ResponseUsage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(0L)
                                    .build()
                            )
                            .user("user-1234")
                            .build()
                    )
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCustomToolCallInputDelta() {
        val responseCustomToolCallInputDelta =
            ResponseCustomToolCallInputDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCustomToolCallInputDelta(
                responseCustomToolCallInputDelta
            )

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta())
            .contains(responseCustomToolCallInputDelta)
        assertThat(responsesServerEvent.responseCustomToolCallInputDone()).isEmpty
    }

    @Test
    fun ofResponseCustomToolCallInputDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCustomToolCallInputDelta(
                ResponseCustomToolCallInputDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    @Test
    fun ofResponseCustomToolCallInputDone() {
        val responseCustomToolCallInputDone =
            ResponseCustomToolCallInputDoneEvent.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCustomToolCallInputDone(responseCustomToolCallInputDone)

        assertThat(responsesServerEvent.responseAudioDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioDone()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(responsesServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDelta()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCodeDone()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseCodeInterpreterCallInterpreting()).isEmpty
        assertThat(responsesServerEvent.responseCompleted()).isEmpty
        assertThat(responsesServerEvent.responseContentPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseContentPartDone()).isEmpty
        assertThat(responsesServerEvent.responseCreated()).isEmpty
        assertThat(responsesServerEvent.error()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFileSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseInProgress()).isEmpty
        assertThat(responsesServerEvent.responseFailed()).isEmpty
        assertThat(responsesServerEvent.responseIncomplete()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(responsesServerEvent.responseOutputItemDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartAdded()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryPartDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningSummaryTextDone()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseReasoningTextDone()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDelta()).isEmpty
        assertThat(responsesServerEvent.responseRefusalDone()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextDone()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseWebSearchCallSearching()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallGenerating()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseImageGenerationCallPartialImage()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsCompleted()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsFailed()).isEmpty
        assertThat(responsesServerEvent.responseMcpListToolsInProgress()).isEmpty
        assertThat(responsesServerEvent.responseOutputTextAnnotationAdded()).isEmpty
        assertThat(responsesServerEvent.responseQueued()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDelta()).isEmpty
        assertThat(responsesServerEvent.responseCustomToolCallInputDone())
            .contains(responseCustomToolCallInputDone)
    }

    @Test
    fun ofResponseCustomToolCallInputDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesServerEvent =
            ResponsesServerEvent.ofResponseCustomToolCallInputDone(
                ResponseCustomToolCallInputDoneEvent.builder()
                    .input("input")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponsesServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesServerEvent),
                jacksonTypeRef<ResponsesServerEvent>(),
            )

        assertThat(roundtrippedResponsesServerEvent).isEqualTo(responsesServerEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val responsesServerEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponsesServerEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { responsesServerEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
