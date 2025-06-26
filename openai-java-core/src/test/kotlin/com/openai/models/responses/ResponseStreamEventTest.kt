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

internal class ResponseStreamEventTest {

    @Test
    fun ofAudioDelta() {
        val audioDelta = ResponseAudioDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofAudioDelta(audioDelta)

        assertThat(responseStreamEvent.audioDelta()).contains(audioDelta)
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioDelta(
                ResponseAudioDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofAudioDone() {
        val audioDone = ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofAudioDone(audioDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).contains(audioDone)
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofAudioDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioDone(
                ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofAudioTranscriptDelta() {
        val audioTranscriptDelta =
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofAudioTranscriptDelta(audioTranscriptDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).contains(audioTranscriptDelta)
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofAudioTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioTranscriptDelta(
                ResponseAudioTranscriptDeltaEvent.builder()
                    .delta("delta")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofAudioTranscriptDone() {
        val audioTranscriptDone =
            ResponseAudioTranscriptDoneEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofAudioTranscriptDone(audioTranscriptDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).contains(audioTranscriptDone)
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofAudioTranscriptDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioTranscriptDone(
                ResponseAudioTranscriptDoneEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCodeInterpreterCallCodeDelta() {
        val codeInterpreterCallCodeDelta =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDelta(codeInterpreterCallCodeDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta())
            .contains(codeInterpreterCallCodeDelta)
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCodeDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDelta(
                ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCodeInterpreterCallCodeDone() {
        val codeInterpreterCallCodeDone =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDone(codeInterpreterCallCodeDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone())
            .contains(codeInterpreterCallCodeDone)
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCodeDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDone(
                ResponseCodeInterpreterCallCodeDoneEvent.builder()
                    .code("code")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCodeInterpreterCallCompleted() {
        val codeInterpreterCallCompleted =
            ResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCompleted(codeInterpreterCallCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted())
            .contains(codeInterpreterCallCompleted)
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCompleted(
                ResponseCodeInterpreterCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCodeInterpreterCallInProgress() {
        val codeInterpreterCallInProgress =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInProgress(codeInterpreterCallInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress())
            .contains(codeInterpreterCallInProgress)
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInProgress(
                ResponseCodeInterpreterCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCodeInterpreterCallInterpreting() {
        val codeInterpreterCallInterpreting =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInterpreting(codeInterpreterCallInterpreting)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting())
            .contains(codeInterpreterCallInterpreting)
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallInterpretingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInterpreting(
                ResponseCodeInterpreterCallInterpretingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCompleted() {
        val completed =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofCompleted(completed)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).contains(completed)
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCompleted(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofContentPartAdded() {
        val contentPartAdded =
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

        val responseStreamEvent = ResponseStreamEvent.ofContentPartAdded(contentPartAdded)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).contains(contentPartAdded)
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofContentPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofContentPartAdded(
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofContentPartDone() {
        val contentPartDone =
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

        val responseStreamEvent = ResponseStreamEvent.ofContentPartDone(contentPartDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).contains(contentPartDone)
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofContentPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofContentPartDone(
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofCreated() {
        val created =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofCreated(created)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).contains(created)
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCreated(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
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

        val responseStreamEvent = ResponseStreamEvent.ofError(error)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).contains(error)
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofError(
                ResponseErrorEvent.builder()
                    .code("code")
                    .message("message")
                    .param("param")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFileSearchCallCompleted() {
        val fileSearchCallCompleted =
            ResponseFileSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallCompleted(fileSearchCallCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).contains(fileSearchCallCompleted)
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFileSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallCompleted(
                ResponseFileSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFileSearchCallInProgress() {
        val fileSearchCallInProgress =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallInProgress(fileSearchCallInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress())
            .contains(fileSearchCallInProgress)
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFileSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallInProgress(
                ResponseFileSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFileSearchCallSearching() {
        val fileSearchCallSearching =
            ResponseFileSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallSearching(fileSearchCallSearching)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).contains(fileSearchCallSearching)
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFileSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallSearching(
                ResponseFileSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFunctionCallArgumentsDelta() {
        val functionCallArgumentsDelta =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofFunctionCallArgumentsDelta(functionCallArgumentsDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta())
            .contains(functionCallArgumentsDelta)
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFunctionCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFunctionCallArgumentsDelta(
                ResponseFunctionCallArgumentsDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFunctionCallArgumentsDone() {
        val functionCallArgumentsDone =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofFunctionCallArgumentsDone(functionCallArgumentsDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone())
            .contains(functionCallArgumentsDone)
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFunctionCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFunctionCallArgumentsDone(
                ResponseFunctionCallArgumentsDoneEvent.builder()
                    .arguments("arguments")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofInProgress() {
        val inProgress =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofInProgress(inProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).contains(inProgress)
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofInProgress(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofFailed() {
        val failed =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofFailed(failed)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).contains(failed)
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFailed(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofIncomplete() {
        val incomplete =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofIncomplete(incomplete)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).contains(incomplete)
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofIncomplete(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofOutputItemAdded() {
        val outputItemAdded =
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

        val responseStreamEvent = ResponseStreamEvent.ofOutputItemAdded(outputItemAdded)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).contains(outputItemAdded)
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofOutputItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputItemAdded(
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofOutputItemDone() {
        val outputItemDone =
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

        val responseStreamEvent = ResponseStreamEvent.ofOutputItemDone(outputItemDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).contains(outputItemDone)
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofOutputItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputItemDone(
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryPartAdded() {
        val reasoningSummaryPartAdded =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryPartAdded(reasoningSummaryPartAdded)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded())
            .contains(reasoningSummaryPartAdded)
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningSummaryPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryPartAdded(
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryPartDone() {
        val reasoningSummaryPartDone =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryPartDone(reasoningSummaryPartDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone())
            .contains(reasoningSummaryPartDone)
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningSummaryPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryPartDone(
                ResponseReasoningSummaryPartDoneEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryTextDelta() {
        val reasoningSummaryTextDelta =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryTextDelta(reasoningSummaryTextDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta())
            .contains(reasoningSummaryTextDelta)
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningSummaryTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryTextDelta(
                ResponseReasoningSummaryTextDeltaEvent.builder()
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryTextDone() {
        val reasoningSummaryTextDone =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryTextDone(reasoningSummaryTextDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone())
            .contains(reasoningSummaryTextDone)
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningSummaryTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryTextDone(
                ResponseReasoningSummaryTextDoneEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofRefusalDelta() {
        val refusalDelta =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofRefusalDelta(refusalDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).contains(refusalDelta)
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofRefusalDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofRefusalDelta(
                ResponseRefusalDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofRefusalDone() {
        val refusalDone =
            ResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofRefusalDone(refusalDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).contains(refusalDone)
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofRefusalDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofRefusalDone(
                ResponseRefusalDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .refusal("refusal")
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofOutputTextDelta() {
        val outputTextDelta =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofOutputTextDelta(outputTextDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).contains(outputTextDelta)
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofOutputTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputTextDelta(
                ResponseTextDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofOutputTextDone() {
        val outputTextDone =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofOutputTextDone(outputTextDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).contains(outputTextDone)
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofOutputTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputTextDone(
                ResponseTextDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofWebSearchCallCompleted() {
        val webSearchCallCompleted =
            ResponseWebSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallCompleted(webSearchCallCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).contains(webSearchCallCompleted)
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofWebSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallCompleted(
                ResponseWebSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofWebSearchCallInProgress() {
        val webSearchCallInProgress =
            ResponseWebSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallInProgress(webSearchCallInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).contains(webSearchCallInProgress)
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofWebSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallInProgress(
                ResponseWebSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofWebSearchCallSearching() {
        val webSearchCallSearching =
            ResponseWebSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallSearching(webSearchCallSearching)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).contains(webSearchCallSearching)
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofWebSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallSearching(
                ResponseWebSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofImageGenerationCallCompleted() {
        val imageGenerationCallCompleted =
            ResponseImageGenCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallCompleted(imageGenerationCallCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted())
            .contains(imageGenerationCallCompleted)
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofImageGenerationCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallCompleted(
                ResponseImageGenCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofImageGenerationCallGenerating() {
        val imageGenerationCallGenerating =
            ResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallGenerating(imageGenerationCallGenerating)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating())
            .contains(imageGenerationCallGenerating)
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofImageGenerationCallGeneratingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallGenerating(
                ResponseImageGenCallGeneratingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofImageGenerationCallInProgress() {
        val imageGenerationCallInProgress =
            ResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallInProgress(imageGenerationCallInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress())
            .contains(imageGenerationCallInProgress)
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofImageGenerationCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallInProgress(
                ResponseImageGenCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofImageGenerationCallPartialImage() {
        val imageGenerationCallPartialImage =
            ResponseImageGenCallPartialImageEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .partialImageB64("partial_image_b64")
                .partialImageIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallPartialImage(imageGenerationCallPartialImage)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage())
            .contains(imageGenerationCallPartialImage)
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofImageGenerationCallPartialImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofImageGenerationCallPartialImage(
                ResponseImageGenCallPartialImageEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .partialImageB64("partial_image_b64")
                    .partialImageIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpCallArgumentsDelta() {
        val mcpCallArgumentsDelta =
            ResponseMcpCallArgumentsDeltaEvent.builder()
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpCallArgumentsDelta(mcpCallArgumentsDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).contains(mcpCallArgumentsDelta)
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpCallArgumentsDelta(
                ResponseMcpCallArgumentsDeltaEvent.builder()
                    .delta(JsonValue.from(mapOf<String, Any>()))
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpCallArgumentsDone() {
        val mcpCallArgumentsDone =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpCallArgumentsDone(mcpCallArgumentsDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).contains(mcpCallArgumentsDone)
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpCallArgumentsDone(
                ResponseMcpCallArgumentsDoneEvent.builder()
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpCallCompleted() {
        val mcpCallCompleted = ResponseMcpCallCompletedEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpCallCompleted(mcpCallCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).contains(mcpCallCompleted)
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpCallCompleted(
                ResponseMcpCallCompletedEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpCallFailed() {
        val mcpCallFailed = ResponseMcpCallFailedEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpCallFailed(mcpCallFailed)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).contains(mcpCallFailed)
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpCallFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpCallFailed(
                ResponseMcpCallFailedEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpCallInProgress() {
        val mcpCallInProgress =
            ResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpCallInProgress(mcpCallInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).contains(mcpCallInProgress)
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpCallInProgress(
                ResponseMcpCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpListToolsCompleted() {
        val mcpListToolsCompleted =
            ResponseMcpListToolsCompletedEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpListToolsCompleted(mcpListToolsCompleted)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).contains(mcpListToolsCompleted)
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpListToolsCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpListToolsCompleted(
                ResponseMcpListToolsCompletedEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpListToolsFailed() {
        val mcpListToolsFailed =
            ResponseMcpListToolsFailedEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent = ResponseStreamEvent.ofMcpListToolsFailed(mcpListToolsFailed)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).contains(mcpListToolsFailed)
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpListToolsFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpListToolsFailed(
                ResponseMcpListToolsFailedEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofMcpListToolsInProgress() {
        val mcpListToolsInProgress =
            ResponseMcpListToolsInProgressEvent.builder().sequenceNumber(0L).build()

        val responseStreamEvent =
            ResponseStreamEvent.ofMcpListToolsInProgress(mcpListToolsInProgress)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).contains(mcpListToolsInProgress)
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofMcpListToolsInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofMcpListToolsInProgress(
                ResponseMcpListToolsInProgressEvent.builder().sequenceNumber(0L).build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofOutputTextAnnotationAdded() {
        val outputTextAnnotationAdded =
            ResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(JsonValue.from(mapOf<String, Any>()))
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent =
            ResponseStreamEvent.ofOutputTextAnnotationAdded(outputTextAnnotationAdded)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded())
            .contains(outputTextAnnotationAdded)
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofOutputTextAnnotationAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputTextAnnotationAdded(
                ResponseOutputTextAnnotationAddedEvent.builder()
                    .annotation(JsonValue.from(mapOf<String, Any>()))
                    .annotationIndex(0L)
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofQueued() {
        val queued =
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
                        .model(ChatModel.GPT_4O)
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
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.AUTO)
                                .summary(Reasoning.Summary.AUTO)
                                .build()
                        )
                        .serviceTier(Response.ServiceTier.AUTO)
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
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

        val responseStreamEvent = ResponseStreamEvent.ofQueued(queued)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).contains(queued)
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofQueuedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofQueued(
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
                            .model(ChatModel.GPT_4O)
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
                            .reasoning(
                                Reasoning.builder()
                                    .effort(ReasoningEffort.LOW)
                                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                                    .summary(Reasoning.Summary.AUTO)
                                    .build()
                            )
                            .serviceTier(Response.ServiceTier.AUTO)
                            .status(ResponseStatus.COMPLETED)
                            .text(
                                ResponseTextConfig.builder()
                                    .format(ResponseFormatText.builder().build())
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

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningDelta() {
        val reasoningDelta =
            ResponseReasoningDeltaEvent.builder()
                .contentIndex(0L)
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofReasoningDelta(reasoningDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).contains(reasoningDelta)
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningDelta(
                ResponseReasoningDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta(JsonValue.from(mapOf<String, Any>()))
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningDone() {
        val reasoningDone =
            ResponseReasoningDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofReasoningDone(reasoningDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).contains(reasoningDone)
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningDone(
                ResponseReasoningDoneEvent.builder()
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryDelta() {
        val reasoningSummaryDelta =
            ResponseReasoningSummaryDeltaEvent.builder()
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofReasoningSummaryDelta(reasoningSummaryDelta)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).contains(reasoningSummaryDelta)
        assertThat(responseStreamEvent.reasoningSummaryDone()).isEmpty
    }

    @Test
    fun ofReasoningSummaryDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryDelta(
                ResponseReasoningSummaryDeltaEvent.builder()
                    .delta(JsonValue.from(mapOf<String, Any>()))
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
    }

    @Test
    fun ofReasoningSummaryDone() {
        val reasoningSummaryDone =
            ResponseReasoningSummaryDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        val responseStreamEvent = ResponseStreamEvent.ofReasoningSummaryDone(reasoningSummaryDone)

        assertThat(responseStreamEvent.audioDelta()).isEmpty
        assertThat(responseStreamEvent.audioDone()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDelta()).isEmpty
        assertThat(responseStreamEvent.audioTranscriptDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDelta()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCodeDone()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallCompleted()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInProgress()).isEmpty
        assertThat(responseStreamEvent.codeInterpreterCallInterpreting()).isEmpty
        assertThat(responseStreamEvent.completed()).isEmpty
        assertThat(responseStreamEvent.contentPartAdded()).isEmpty
        assertThat(responseStreamEvent.contentPartDone()).isEmpty
        assertThat(responseStreamEvent.created()).isEmpty
        assertThat(responseStreamEvent.error()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.fileSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.functionCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.inProgress()).isEmpty
        assertThat(responseStreamEvent.failed()).isEmpty
        assertThat(responseStreamEvent.incomplete()).isEmpty
        assertThat(responseStreamEvent.outputItemAdded()).isEmpty
        assertThat(responseStreamEvent.outputItemDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartAdded()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryPartDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryTextDone()).isEmpty
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallCompleted()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallGenerating()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallInProgress()).isEmpty
        assertThat(responseStreamEvent.imageGenerationCallPartialImage()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDelta()).isEmpty
        assertThat(responseStreamEvent.mcpCallArgumentsDone()).isEmpty
        assertThat(responseStreamEvent.mcpCallCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpCallFailed()).isEmpty
        assertThat(responseStreamEvent.mcpCallInProgress()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsCompleted()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsFailed()).isEmpty
        assertThat(responseStreamEvent.mcpListToolsInProgress()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.queued()).isEmpty
        assertThat(responseStreamEvent.reasoningDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningDone()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDelta()).isEmpty
        assertThat(responseStreamEvent.reasoningSummaryDone()).contains(reasoningSummaryDone)
    }

    @Test
    fun ofReasoningSummaryDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofReasoningSummaryDone(
                ResponseReasoningSummaryDoneEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
                    .sequenceNumber(0L)
                    .summaryIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedResponseStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseStreamEvent),
                jacksonTypeRef<ResponseStreamEvent>(),
            )

        assertThat(roundtrippedResponseStreamEvent).isEqualTo(responseStreamEvent)
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
        val responseStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { responseStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
