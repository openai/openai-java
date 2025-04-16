// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.ComparisonFilter
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
        val audioDelta = ResponseAudioDeltaEvent.builder().delta("delta").build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioDelta(
                ResponseAudioDeltaEvent.builder().delta("delta").build()
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
        val audioDone = ResponseAudioDoneEvent.builder().build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofAudioDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioDone(ResponseAudioDoneEvent.builder().build())

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
            ResponseAudioTranscriptDeltaEvent.builder().delta("delta").build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofAudioTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioTranscriptDelta(
                ResponseAudioTranscriptDeltaEvent.builder().delta("delta").build()
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
        val audioTranscriptDone = ResponseAudioTranscriptDoneEvent.builder().build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofAudioTranscriptDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofAudioTranscriptDone(
                ResponseAudioTranscriptDoneEvent.builder().build()
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
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCodeDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDelta(
                ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                    .delta("delta")
                    .outputIndex(0L)
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
            ResponseCodeInterpreterCallCodeDoneEvent.builder().code("code").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCodeDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCodeDone(
                ResponseCodeInterpreterCallCodeDoneEvent.builder()
                    .code("code")
                    .outputIndex(0L)
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
                .codeInterpreterCall(
                    ResponseCodeInterpreterToolCall.builder()
                        .id("id")
                        .code("code")
                        .addLogsResult("logs")
                        .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallCompleted(
                ResponseCodeInterpreterCallCompletedEvent.builder()
                    .codeInterpreterCall(
                        ResponseCodeInterpreterToolCall.builder()
                            .id("id")
                            .code("code")
                            .addLogsResult("logs")
                            .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
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
                .codeInterpreterCall(
                    ResponseCodeInterpreterToolCall.builder()
                        .id("id")
                        .code("code")
                        .addLogsResult("logs")
                        .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInProgress(
                ResponseCodeInterpreterCallInProgressEvent.builder()
                    .codeInterpreterCall(
                        ResponseCodeInterpreterToolCall.builder()
                            .id("id")
                            .code("code")
                            .addLogsResult("logs")
                            .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
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
                .codeInterpreterCall(
                    ResponseCodeInterpreterToolCall.builder()
                        .id("id")
                        .code("code")
                        .addLogsResult("logs")
                        .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallInterpretingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofCodeInterpreterCallInterpreting(
                ResponseCodeInterpreterCallInterpretingEvent.builder()
                    .codeInterpreterCall(
                        ResponseCodeInterpreterToolCall.builder()
                            .id("id")
                            .code("code")
                            .addLogsResult("logs")
                            .status(ResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
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
                        .instructions("instructions")
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
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                            .instructions("instructions")
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
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FileSearchTool.builder()
                                    .addVectorStoreId("string")
                                    .filters(
                                        ComparisonFilter.builder()
                                            .key("key")
                                            .type(ComparisonFilter.Type.EQ)
                                            .value("string")
                                            .build()
                                    )
                                    .maxNumResults(0L)
                                    .rankingOptions(
                                        FileSearchTool.RankingOptions.builder()
                                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                            .scoreThreshold(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .maxOutputTokens(0L)
                            .previousResponseId("previous_response_id")
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
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .build()
                )
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
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
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .build()
                )
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
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
                        .instructions("instructions")
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
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                            .instructions("instructions")
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
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FileSearchTool.builder()
                                    .addVectorStoreId("string")
                                    .filters(
                                        ComparisonFilter.builder()
                                            .key("key")
                                            .type(ComparisonFilter.Type.EQ)
                                            .value("string")
                                            .build()
                                    )
                                    .maxNumResults(0L)
                                    .rankingOptions(
                                        FileSearchTool.RankingOptions.builder()
                                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                            .scoreThreshold(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .maxOutputTokens(0L)
                            .previousResponseId("previous_response_id")
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
            ResponseErrorEvent.builder().code("code").message("message").param("param").build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofError(
                ResponseErrorEvent.builder().code("code").message("message").param("param").build()
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
            ResponseFileSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofFileSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallCompleted(
                ResponseFileSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofFileSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallInProgress(
                ResponseFileSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
            ResponseFileSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofFileSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofFileSearchCallSearching(
                ResponseFileSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                        .instructions("instructions")
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
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                            .instructions("instructions")
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
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FileSearchTool.builder()
                                    .addVectorStoreId("string")
                                    .filters(
                                        ComparisonFilter.builder()
                                            .key("key")
                                            .type(ComparisonFilter.Type.EQ)
                                            .value("string")
                                            .build()
                                    )
                                    .maxNumResults(0L)
                                    .rankingOptions(
                                        FileSearchTool.RankingOptions.builder()
                                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                            .scoreThreshold(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .maxOutputTokens(0L)
                            .previousResponseId("previous_response_id")
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
                        .instructions("instructions")
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
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                            .instructions("instructions")
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
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FileSearchTool.builder()
                                    .addVectorStoreId("string")
                                    .filters(
                                        ComparisonFilter.builder()
                                            .key("key")
                                            .type(ComparisonFilter.Type.EQ)
                                            .value("string")
                                            .build()
                                    )
                                    .maxNumResults(0L)
                                    .rankingOptions(
                                        FileSearchTool.RankingOptions.builder()
                                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                            .scoreThreshold(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .maxOutputTokens(0L)
                            .previousResponseId("previous_response_id")
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
                        .instructions("instructions")
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
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                            .instructions("instructions")
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
                                                    .index(0L)
                                                    .build()
                                            )
                                            .text("text")
                                            .build()
                                    )
                                    .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                    .build()
                            )
                            .parallelToolCalls(true)
                            .temperature(1.0)
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                FileSearchTool.builder()
                                    .addVectorStoreId("string")
                                    .filters(
                                        ComparisonFilter.builder()
                                            .key("key")
                                            .type(ComparisonFilter.Type.EQ)
                                            .value("string")
                                            .build()
                                    )
                                    .maxNumResults(0L)
                                    .rankingOptions(
                                        FileSearchTool.RankingOptions.builder()
                                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                            .scoreThreshold(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .topP(1.0)
                            .maxOutputTokens(0L)
                            .previousResponseId("previous_response_id")
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
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                                            .index(0L)
                                            .build()
                                    )
                                    .text("text")
                                    .build()
                            )
                            .status(ResponseOutputMessage.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
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
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
                                            .index(0L)
                                            .build()
                                    )
                                    .text("text")
                                    .build()
                            )
                            .status(ResponseOutputMessage.Status.IN_PROGRESS)
                            .build()
                    )
                    .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).contains(refusalDelta)
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).contains(refusalDone)
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
    fun ofOutputTextAnnotationAdded() {
        val outputTextAnnotationAdded =
            ResponseTextAnnotationDeltaEvent.builder()
                .annotation(
                    ResponseTextAnnotationDeltaEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded())
            .contains(outputTextAnnotationAdded)
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofOutputTextAnnotationAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofOutputTextAnnotationAdded(
                ResponseTextAnnotationDeltaEvent.builder()
                    .annotation(
                        ResponseTextAnnotationDeltaEvent.Annotation.FileCitation.builder()
                            .fileId("file_id")
                            .index(0L)
                            .build()
                    )
                    .annotationIndex(0L)
                    .contentIndex(0L)
                    .itemId("item_id")
                    .outputIndex(0L)
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).contains(outputTextDelta)
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).contains(outputTextDone)
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
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
            ResponseWebSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).contains(webSearchCallCompleted)
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofWebSearchCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallCompleted(
                ResponseWebSearchCallCompletedEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
            ResponseWebSearchCallInProgressEvent.builder().itemId("item_id").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).contains(webSearchCallInProgress)
        assertThat(responseStreamEvent.webSearchCallSearching()).isEmpty
    }

    @Test
    fun ofWebSearchCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallInProgress(
                ResponseWebSearchCallInProgressEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
            ResponseWebSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

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
        assertThat(responseStreamEvent.refusalDelta()).isEmpty
        assertThat(responseStreamEvent.refusalDone()).isEmpty
        assertThat(responseStreamEvent.outputTextAnnotationAdded()).isEmpty
        assertThat(responseStreamEvent.outputTextDelta()).isEmpty
        assertThat(responseStreamEvent.outputTextDone()).isEmpty
        assertThat(responseStreamEvent.webSearchCallCompleted()).isEmpty
        assertThat(responseStreamEvent.webSearchCallInProgress()).isEmpty
        assertThat(responseStreamEvent.webSearchCallSearching()).contains(webSearchCallSearching)
    }

    @Test
    fun ofWebSearchCallSearchingRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseStreamEvent =
            ResponseStreamEvent.ofWebSearchCallSearching(
                ResponseWebSearchCallSearchingEvent.builder()
                    .itemId("item_id")
                    .outputIndex(0L)
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
