// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
            ResponsesServerEvent.ResponseAudioWsDelta.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

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
                ResponsesServerEvent.ResponseAudioWsDelta.builder()
                    .delta("delta")
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
    fun ofResponseAudioDone() {
        val responseAudioDone =
            ResponsesServerEvent.ResponseAudioWsDone.builder()
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

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
                ResponsesServerEvent.ResponseAudioWsDone.builder()
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
    fun ofResponseAudioTranscriptDelta() {
        val responseAudioTranscriptDelta =
            ResponsesServerEvent.ResponseAudioTranscriptWsDelta.builder()
                .delta("delta")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

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
                ResponsesServerEvent.ResponseAudioTranscriptWsDelta.builder()
                    .delta("delta")
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseAudioTranscriptWsDone.builder()
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

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
                ResponsesServerEvent.ResponseAudioTranscriptWsDone.builder()
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
    fun ofResponseCodeInterpreterCallCodeDelta() {
        val responseCodeInterpreterCallCodeDelta =
            ResponsesServerEvent.ResponseCodeInterpreterCallCodeWsDelta.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCodeInterpreterCallCodeWsDelta.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCodeInterpreterCallCodeWsDone.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCodeInterpreterCallCodeWsDone.builder()
                    .code("code")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCodeInterpreterCallWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCodeInterpreterCallWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCodeInterpreterCallInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCodeInterpreterCallInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCodeInterpreterCallWsInterpreting.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCodeInterpreterCallWsInterpreting.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsCompleted.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsCompleted.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseContentPartWsAdded.builder()
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseContentPartWsAdded.builder()
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseContentPartWsDone.builder()
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseContentPartWsDone.builder()
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsCreated.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsCreated.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsError.builder()
                .code("code")
                .message("message")
                .param("param")
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsError.builder()
                    .code("code")
                    .message("message")
                    .param("param")
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseFileSearchCallWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseFileSearchCallWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseFileSearchCallInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseFileSearchCallInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseFileSearchCallWsSearching.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseFileSearchCallWsSearching.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseFunctionCallArgumentsWsDelta.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseFunctionCallArgumentsWsDelta.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseFunctionCallArgumentsWsDone.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseFunctionCallArgumentsWsDone.builder()
                    .arguments("arguments")
                    .itemId("item_id")
                    .name("name")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseInWsProgress.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseInWsProgress.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsFailed.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsFailed.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsIncomplete.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsIncomplete.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseOutputItemWsAdded.builder()
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
                        .phase(ResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseOutputItemWsAdded.builder()
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
                            .phase(ResponseOutputMessage.Phase.COMMENTARY)
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseOutputItemWsDone.builder()
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
                        .phase(ResponseOutputMessage.Phase.COMMENTARY)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseOutputItemWsDone.builder()
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
                            .phase(ResponseOutputMessage.Phase.COMMENTARY)
                            .build()
                    )
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningSummaryPartWsAdded.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningSummaryPartWsAdded.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build()
                    )
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningSummaryPartWsDone.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .status(ResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningSummaryPartWsDone.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .status(ResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningSummaryTextWsDelta.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningSummaryTextWsDelta.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningSummaryTextWsDone.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningSummaryTextWsDone.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .text("text")
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningTextWsDelta.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningTextWsDelta.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseReasoningTextWsDone.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseReasoningTextWsDone.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .text("text")
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseRefusalWsDelta.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseRefusalWsDelta.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseRefusalWsDone.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseRefusalWsDone.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .refusal("refusal")
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseTextWsDelta.builder()
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseTextWsDelta.builder()
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseTextWsDone.builder()
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseTextWsDone.builder()
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWebSearchCallWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWebSearchCallWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWebSearchCallInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWebSearchCallInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWebSearchCallWsSearching.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWebSearchCallWsSearching.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseImageGenCallWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseImageGenCallWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseImageGenCallWsGenerating.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseImageGenCallWsGenerating.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseImageGenCallInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseImageGenCallInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseImageGenCallPartialWsImage.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseImageGenCallPartialWsImage.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .partialImageB64("partial_image_b64")
                    .partialImageIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpCallArgumentsWsDelta.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpCallArgumentsWsDelta.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpCallArgumentsWsDone.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpCallArgumentsWsDone.builder()
                    .arguments("arguments")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpCallWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpCallWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpCallWsFailed.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpCallWsFailed.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpCallInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpCallInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpListToolsWsCompleted.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpListToolsWsCompleted.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpListToolsWsFailed.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpListToolsWsFailed.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseMcpListToolsInWsProgress.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseMcpListToolsInWsProgress.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseOutputTextAnnotationWsAdded.builder()
                .annotation(JsonValue.from(mapOf<String, Any>()))
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseOutputTextAnnotationWsAdded.builder()
                    .annotation(JsonValue.from(mapOf<String, Any>()))
                    .annotationIndex(0L)
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseWsQueued.builder()
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
                                .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                .deferLoading(true)
                                .description("description")
                                .outputSchema(
                                    FunctionTool.OutputSchema.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .background(true)
                        .completedAt(0.0)
                        .conversation(Response.Conversation.builder().id("id").build())
                        .maxOutputTokens(0L)
                        .maxToolCalls(0L)
                        .moderation(
                            Response.Moderation.builder()
                                .input(
                                    Response.Moderation.Input.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Input.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Input.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .output(
                                    Response.Moderation.Output.ModerationResult.builder()
                                        .categories(
                                            Response.Moderation.Output.ModerationResult.Categories
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(true))
                                                .build()
                                        )
                                        .categoryAppliedInputTypes(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryAppliedInputTypes
                                                .builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(listOf("text")),
                                                )
                                                .build()
                                        )
                                        .categoryScores(
                                            Response.Moderation.Output.ModerationResult
                                                .CategoryScores
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from(0))
                                                .build()
                                        )
                                        .flagged(true)
                                        .model("model")
                                        .build()
                                )
                                .build()
                        )
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
                        .promptCacheOptions(
                            Response.PromptCacheOptions.builder()
                                .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                .ttl(Response.PromptCacheOptions.Ttl._30M)
                                .build()
                        )
                        .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                        .reasoning(
                            Reasoning.builder()
                                .context(Reasoning.Context.AUTO)
                                .effort(ReasoningEffort.NONE)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .mode(Reasoning.Mode.STANDARD)
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
                                        .cacheWriteTokens(0L)
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
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseWsQueued.builder()
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
                                    .phase(ResponseOutputMessage.Phase.COMMENTARY)
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
                                    .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                                    .deferLoading(true)
                                    .description("description")
                                    .outputSchema(
                                        FunctionTool.OutputSchema.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .background(true)
                            .completedAt(0.0)
                            .conversation(Response.Conversation.builder().id("id").build())
                            .maxOutputTokens(0L)
                            .maxToolCalls(0L)
                            .moderation(
                                Response.Moderation.builder()
                                    .input(
                                        Response.Moderation.Input.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Input.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Input.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .output(
                                        Response.Moderation.Output.ModerationResult.builder()
                                            .categories(
                                                Response.Moderation.Output.ModerationResult
                                                    .Categories
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(true),
                                                    )
                                                    .build()
                                            )
                                            .categoryAppliedInputTypes(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryAppliedInputTypes
                                                    .builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from(listOf("text")),
                                                    )
                                                    .build()
                                            )
                                            .categoryScores(
                                                Response.Moderation.Output.ModerationResult
                                                    .CategoryScores
                                                    .builder()
                                                    .putAdditionalProperty("foo", JsonValue.from(0))
                                                    .build()
                                            )
                                            .flagged(true)
                                            .model("model")
                                            .build()
                                    )
                                    .build()
                            )
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
                            .promptCacheOptions(
                                Response.PromptCacheOptions.builder()
                                    .mode(Response.PromptCacheOptions.Mode.IMPLICIT)
                                    .ttl(Response.PromptCacheOptions.Ttl._30M)
                                    .build()
                            )
                            .promptCacheRetention(Response.PromptCacheRetention.IN_MEMORY)
                            .reasoning(
                                Reasoning.builder()
                                    .context(Reasoning.Context.AUTO)
                                    .effort(ReasoningEffort.NONE)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .mode(Reasoning.Mode.STANDARD)
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
                                            .cacheWriteTokens(0L)
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
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCustomToolCallInputWsDelta.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCustomToolCallInputWsDelta.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
            ResponsesServerEvent.ResponseCustomToolCallInputWsDone.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .streamId("stream_id")
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
                ResponsesServerEvent.ResponseCustomToolCallInputWsDone.builder()
                    .input("input")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .streamId("stream_id")
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
