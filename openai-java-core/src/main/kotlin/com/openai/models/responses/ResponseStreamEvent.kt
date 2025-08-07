// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when there is a partial audio response. */
@JsonDeserialize(using = ResponseStreamEvent.Deserializer::class)
@JsonSerialize(using = ResponseStreamEvent.Serializer::class)
class ResponseStreamEvent
private constructor(
    private val audioDelta: ResponseAudioDeltaEvent? = null,
    private val audioDone: ResponseAudioDoneEvent? = null,
    private val audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent? = null,
    private val audioTranscriptDone: ResponseAudioTranscriptDoneEvent? = null,
    private val codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent? = null,
    private val codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent? = null,
    private val codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent? = null,
    private val codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent? = null,
    private val codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent? =
        null,
    private val completed: ResponseCompletedEvent? = null,
    private val contentPartAdded: ResponseContentPartAddedEvent? = null,
    private val contentPartDone: ResponseContentPartDoneEvent? = null,
    private val created: ResponseCreatedEvent? = null,
    private val error: ResponseErrorEvent? = null,
    private val fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent? = null,
    private val fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent? = null,
    private val fileSearchCallSearching: ResponseFileSearchCallSearchingEvent? = null,
    private val functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent? = null,
    private val functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent? = null,
    private val inProgress: ResponseInProgressEvent? = null,
    private val failed: ResponseFailedEvent? = null,
    private val incomplete: ResponseIncompleteEvent? = null,
    private val outputItemAdded: ResponseOutputItemAddedEvent? = null,
    private val outputItemDone: ResponseOutputItemDoneEvent? = null,
    private val reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent? = null,
    private val reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent? = null,
    private val reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent? = null,
    private val reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent? = null,
    private val reasoningTextDelta: ResponseReasoningTextDeltaEvent? = null,
    private val reasoningTextDone: ResponseReasoningTextDoneEvent? = null,
    private val refusalDelta: ResponseRefusalDeltaEvent? = null,
    private val refusalDone: ResponseRefusalDoneEvent? = null,
    private val outputTextDelta: ResponseTextDeltaEvent? = null,
    private val outputTextDone: ResponseTextDoneEvent? = null,
    private val webSearchCallCompleted: ResponseWebSearchCallCompletedEvent? = null,
    private val webSearchCallInProgress: ResponseWebSearchCallInProgressEvent? = null,
    private val webSearchCallSearching: ResponseWebSearchCallSearchingEvent? = null,
    private val imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent? = null,
    private val imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent? = null,
    private val imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent? = null,
    private val imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent? = null,
    private val mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent? = null,
    private val mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent? = null,
    private val mcpCallCompleted: ResponseMcpCallCompletedEvent? = null,
    private val mcpCallFailed: ResponseMcpCallFailedEvent? = null,
    private val mcpCallInProgress: ResponseMcpCallInProgressEvent? = null,
    private val mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent? = null,
    private val mcpListToolsFailed: ResponseMcpListToolsFailedEvent? = null,
    private val mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent? = null,
    private val outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent? = null,
    private val queued: ResponseQueuedEvent? = null,
    private val customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent? = null,
    private val customToolCallInputDone: ResponseCustomToolCallInputDoneEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when there is a partial audio response. */
    fun audioDelta(): Optional<ResponseAudioDeltaEvent> = Optional.ofNullable(audioDelta)

    /** Emitted when the audio response is complete. */
    fun audioDone(): Optional<ResponseAudioDoneEvent> = Optional.ofNullable(audioDone)

    /** Emitted when there is a partial transcript of audio. */
    fun audioTranscriptDelta(): Optional<ResponseAudioTranscriptDeltaEvent> =
        Optional.ofNullable(audioTranscriptDelta)

    /** Emitted when the full audio transcript is completed. */
    fun audioTranscriptDone(): Optional<ResponseAudioTranscriptDoneEvent> =
        Optional.ofNullable(audioTranscriptDone)

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun codeInterpreterCallCodeDelta(): Optional<ResponseCodeInterpreterCallCodeDeltaEvent> =
        Optional.ofNullable(codeInterpreterCallCodeDelta)

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun codeInterpreterCallCodeDone(): Optional<ResponseCodeInterpreterCallCodeDoneEvent> =
        Optional.ofNullable(codeInterpreterCallCodeDone)

    /** Emitted when the code interpreter call is completed. */
    fun codeInterpreterCallCompleted(): Optional<ResponseCodeInterpreterCallCompletedEvent> =
        Optional.ofNullable(codeInterpreterCallCompleted)

    /** Emitted when a code interpreter call is in progress. */
    fun codeInterpreterCallInProgress(): Optional<ResponseCodeInterpreterCallInProgressEvent> =
        Optional.ofNullable(codeInterpreterCallInProgress)

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun codeInterpreterCallInterpreting(): Optional<ResponseCodeInterpreterCallInterpretingEvent> =
        Optional.ofNullable(codeInterpreterCallInterpreting)

    /** Emitted when the model response is complete. */
    fun completed(): Optional<ResponseCompletedEvent> = Optional.ofNullable(completed)

    /** Emitted when a new content part is added. */
    fun contentPartAdded(): Optional<ResponseContentPartAddedEvent> =
        Optional.ofNullable(contentPartAdded)

    /** Emitted when a content part is done. */
    fun contentPartDone(): Optional<ResponseContentPartDoneEvent> =
        Optional.ofNullable(contentPartDone)

    /** An event that is emitted when a response is created. */
    fun created(): Optional<ResponseCreatedEvent> = Optional.ofNullable(created)

    /** Emitted when an error occurs. */
    fun error(): Optional<ResponseErrorEvent> = Optional.ofNullable(error)

    /** Emitted when a file search call is completed (results found). */
    fun fileSearchCallCompleted(): Optional<ResponseFileSearchCallCompletedEvent> =
        Optional.ofNullable(fileSearchCallCompleted)

    /** Emitted when a file search call is initiated. */
    fun fileSearchCallInProgress(): Optional<ResponseFileSearchCallInProgressEvent> =
        Optional.ofNullable(fileSearchCallInProgress)

    /** Emitted when a file search is currently searching. */
    fun fileSearchCallSearching(): Optional<ResponseFileSearchCallSearchingEvent> =
        Optional.ofNullable(fileSearchCallSearching)

    /** Emitted when there is a partial function-call arguments delta. */
    fun functionCallArgumentsDelta(): Optional<ResponseFunctionCallArgumentsDeltaEvent> =
        Optional.ofNullable(functionCallArgumentsDelta)

    /** Emitted when function-call arguments are finalized. */
    fun functionCallArgumentsDone(): Optional<ResponseFunctionCallArgumentsDoneEvent> =
        Optional.ofNullable(functionCallArgumentsDone)

    /** Emitted when the response is in progress. */
    fun inProgress(): Optional<ResponseInProgressEvent> = Optional.ofNullable(inProgress)

    /** An event that is emitted when a response fails. */
    fun failed(): Optional<ResponseFailedEvent> = Optional.ofNullable(failed)

    /** An event that is emitted when a response finishes as incomplete. */
    fun incomplete(): Optional<ResponseIncompleteEvent> = Optional.ofNullable(incomplete)

    /** Emitted when a new output item is added. */
    fun outputItemAdded(): Optional<ResponseOutputItemAddedEvent> =
        Optional.ofNullable(outputItemAdded)

    /** Emitted when an output item is marked done. */
    fun outputItemDone(): Optional<ResponseOutputItemDoneEvent> =
        Optional.ofNullable(outputItemDone)

    /** Emitted when a new reasoning summary part is added. */
    fun reasoningSummaryPartAdded(): Optional<ResponseReasoningSummaryPartAddedEvent> =
        Optional.ofNullable(reasoningSummaryPartAdded)

    /** Emitted when a reasoning summary part is completed. */
    fun reasoningSummaryPartDone(): Optional<ResponseReasoningSummaryPartDoneEvent> =
        Optional.ofNullable(reasoningSummaryPartDone)

    /** Emitted when a delta is added to a reasoning summary text. */
    fun reasoningSummaryTextDelta(): Optional<ResponseReasoningSummaryTextDeltaEvent> =
        Optional.ofNullable(reasoningSummaryTextDelta)

    /** Emitted when a reasoning summary text is completed. */
    fun reasoningSummaryTextDone(): Optional<ResponseReasoningSummaryTextDoneEvent> =
        Optional.ofNullable(reasoningSummaryTextDone)

    /** Emitted when a delta is added to a reasoning text. */
    fun reasoningTextDelta(): Optional<ResponseReasoningTextDeltaEvent> =
        Optional.ofNullable(reasoningTextDelta)

    /** Emitted when a reasoning text is completed. */
    fun reasoningTextDone(): Optional<ResponseReasoningTextDoneEvent> =
        Optional.ofNullable(reasoningTextDone)

    /** Emitted when there is a partial refusal text. */
    fun refusalDelta(): Optional<ResponseRefusalDeltaEvent> = Optional.ofNullable(refusalDelta)

    /** Emitted when refusal text is finalized. */
    fun refusalDone(): Optional<ResponseRefusalDoneEvent> = Optional.ofNullable(refusalDone)

    /** Emitted when there is an additional text delta. */
    fun outputTextDelta(): Optional<ResponseTextDeltaEvent> = Optional.ofNullable(outputTextDelta)

    /** Emitted when text content is finalized. */
    fun outputTextDone(): Optional<ResponseTextDoneEvent> = Optional.ofNullable(outputTextDone)

    /** Emitted when a web search call is completed. */
    fun webSearchCallCompleted(): Optional<ResponseWebSearchCallCompletedEvent> =
        Optional.ofNullable(webSearchCallCompleted)

    /** Emitted when a web search call is initiated. */
    fun webSearchCallInProgress(): Optional<ResponseWebSearchCallInProgressEvent> =
        Optional.ofNullable(webSearchCallInProgress)

    /** Emitted when a web search call is executing. */
    fun webSearchCallSearching(): Optional<ResponseWebSearchCallSearchingEvent> =
        Optional.ofNullable(webSearchCallSearching)

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun imageGenerationCallCompleted(): Optional<ResponseImageGenCallCompletedEvent> =
        Optional.ofNullable(imageGenerationCallCompleted)

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun imageGenerationCallGenerating(): Optional<ResponseImageGenCallGeneratingEvent> =
        Optional.ofNullable(imageGenerationCallGenerating)

    /** Emitted when an image generation tool call is in progress. */
    fun imageGenerationCallInProgress(): Optional<ResponseImageGenCallInProgressEvent> =
        Optional.ofNullable(imageGenerationCallInProgress)

    /** Emitted when a partial image is available during image generation streaming. */
    fun imageGenerationCallPartialImage(): Optional<ResponseImageGenCallPartialImageEvent> =
        Optional.ofNullable(imageGenerationCallPartialImage)

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun mcpCallArgumentsDelta(): Optional<ResponseMcpCallArgumentsDeltaEvent> =
        Optional.ofNullable(mcpCallArgumentsDelta)

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun mcpCallArgumentsDone(): Optional<ResponseMcpCallArgumentsDoneEvent> =
        Optional.ofNullable(mcpCallArgumentsDone)

    /** Emitted when an MCP tool call has completed successfully. */
    fun mcpCallCompleted(): Optional<ResponseMcpCallCompletedEvent> =
        Optional.ofNullable(mcpCallCompleted)

    /** Emitted when an MCP tool call has failed. */
    fun mcpCallFailed(): Optional<ResponseMcpCallFailedEvent> = Optional.ofNullable(mcpCallFailed)

    /** Emitted when an MCP tool call is in progress. */
    fun mcpCallInProgress(): Optional<ResponseMcpCallInProgressEvent> =
        Optional.ofNullable(mcpCallInProgress)

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun mcpListToolsCompleted(): Optional<ResponseMcpListToolsCompletedEvent> =
        Optional.ofNullable(mcpListToolsCompleted)

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun mcpListToolsFailed(): Optional<ResponseMcpListToolsFailedEvent> =
        Optional.ofNullable(mcpListToolsFailed)

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun mcpListToolsInProgress(): Optional<ResponseMcpListToolsInProgressEvent> =
        Optional.ofNullable(mcpListToolsInProgress)

    /** Emitted when an annotation is added to output text content. */
    fun outputTextAnnotationAdded(): Optional<ResponseOutputTextAnnotationAddedEvent> =
        Optional.ofNullable(outputTextAnnotationAdded)

    /** Emitted when a response is queued and waiting to be processed. */
    fun queued(): Optional<ResponseQueuedEvent> = Optional.ofNullable(queued)

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun customToolCallInputDelta(): Optional<ResponseCustomToolCallInputDeltaEvent> =
        Optional.ofNullable(customToolCallInputDelta)

    /** Event indicating that input for a custom tool call is complete. */
    fun customToolCallInputDone(): Optional<ResponseCustomToolCallInputDoneEvent> =
        Optional.ofNullable(customToolCallInputDone)

    fun isAudioDelta(): Boolean = audioDelta != null

    fun isAudioDone(): Boolean = audioDone != null

    fun isAudioTranscriptDelta(): Boolean = audioTranscriptDelta != null

    fun isAudioTranscriptDone(): Boolean = audioTranscriptDone != null

    fun isCodeInterpreterCallCodeDelta(): Boolean = codeInterpreterCallCodeDelta != null

    fun isCodeInterpreterCallCodeDone(): Boolean = codeInterpreterCallCodeDone != null

    fun isCodeInterpreterCallCompleted(): Boolean = codeInterpreterCallCompleted != null

    fun isCodeInterpreterCallInProgress(): Boolean = codeInterpreterCallInProgress != null

    fun isCodeInterpreterCallInterpreting(): Boolean = codeInterpreterCallInterpreting != null

    fun isCompleted(): Boolean = completed != null

    fun isContentPartAdded(): Boolean = contentPartAdded != null

    fun isContentPartDone(): Boolean = contentPartDone != null

    fun isCreated(): Boolean = created != null

    fun isError(): Boolean = error != null

    fun isFileSearchCallCompleted(): Boolean = fileSearchCallCompleted != null

    fun isFileSearchCallInProgress(): Boolean = fileSearchCallInProgress != null

    fun isFileSearchCallSearching(): Boolean = fileSearchCallSearching != null

    fun isFunctionCallArgumentsDelta(): Boolean = functionCallArgumentsDelta != null

    fun isFunctionCallArgumentsDone(): Boolean = functionCallArgumentsDone != null

    fun isInProgress(): Boolean = inProgress != null

    fun isFailed(): Boolean = failed != null

    fun isIncomplete(): Boolean = incomplete != null

    fun isOutputItemAdded(): Boolean = outputItemAdded != null

    fun isOutputItemDone(): Boolean = outputItemDone != null

    fun isReasoningSummaryPartAdded(): Boolean = reasoningSummaryPartAdded != null

    fun isReasoningSummaryPartDone(): Boolean = reasoningSummaryPartDone != null

    fun isReasoningSummaryTextDelta(): Boolean = reasoningSummaryTextDelta != null

    fun isReasoningSummaryTextDone(): Boolean = reasoningSummaryTextDone != null

    fun isReasoningTextDelta(): Boolean = reasoningTextDelta != null

    fun isReasoningTextDone(): Boolean = reasoningTextDone != null

    fun isRefusalDelta(): Boolean = refusalDelta != null

    fun isRefusalDone(): Boolean = refusalDone != null

    fun isOutputTextDelta(): Boolean = outputTextDelta != null

    fun isOutputTextDone(): Boolean = outputTextDone != null

    fun isWebSearchCallCompleted(): Boolean = webSearchCallCompleted != null

    fun isWebSearchCallInProgress(): Boolean = webSearchCallInProgress != null

    fun isWebSearchCallSearching(): Boolean = webSearchCallSearching != null

    fun isImageGenerationCallCompleted(): Boolean = imageGenerationCallCompleted != null

    fun isImageGenerationCallGenerating(): Boolean = imageGenerationCallGenerating != null

    fun isImageGenerationCallInProgress(): Boolean = imageGenerationCallInProgress != null

    fun isImageGenerationCallPartialImage(): Boolean = imageGenerationCallPartialImage != null

    fun isMcpCallArgumentsDelta(): Boolean = mcpCallArgumentsDelta != null

    fun isMcpCallArgumentsDone(): Boolean = mcpCallArgumentsDone != null

    fun isMcpCallCompleted(): Boolean = mcpCallCompleted != null

    fun isMcpCallFailed(): Boolean = mcpCallFailed != null

    fun isMcpCallInProgress(): Boolean = mcpCallInProgress != null

    fun isMcpListToolsCompleted(): Boolean = mcpListToolsCompleted != null

    fun isMcpListToolsFailed(): Boolean = mcpListToolsFailed != null

    fun isMcpListToolsInProgress(): Boolean = mcpListToolsInProgress != null

    fun isOutputTextAnnotationAdded(): Boolean = outputTextAnnotationAdded != null

    fun isQueued(): Boolean = queued != null

    fun isCustomToolCallInputDelta(): Boolean = customToolCallInputDelta != null

    fun isCustomToolCallInputDone(): Boolean = customToolCallInputDone != null

    /** Emitted when there is a partial audio response. */
    fun asAudioDelta(): ResponseAudioDeltaEvent = audioDelta.getOrThrow("audioDelta")

    /** Emitted when the audio response is complete. */
    fun asAudioDone(): ResponseAudioDoneEvent = audioDone.getOrThrow("audioDone")

    /** Emitted when there is a partial transcript of audio. */
    fun asAudioTranscriptDelta(): ResponseAudioTranscriptDeltaEvent =
        audioTranscriptDelta.getOrThrow("audioTranscriptDelta")

    /** Emitted when the full audio transcript is completed. */
    fun asAudioTranscriptDone(): ResponseAudioTranscriptDoneEvent =
        audioTranscriptDone.getOrThrow("audioTranscriptDone")

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun asCodeInterpreterCallCodeDelta(): ResponseCodeInterpreterCallCodeDeltaEvent =
        codeInterpreterCallCodeDelta.getOrThrow("codeInterpreterCallCodeDelta")

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun asCodeInterpreterCallCodeDone(): ResponseCodeInterpreterCallCodeDoneEvent =
        codeInterpreterCallCodeDone.getOrThrow("codeInterpreterCallCodeDone")

    /** Emitted when the code interpreter call is completed. */
    fun asCodeInterpreterCallCompleted(): ResponseCodeInterpreterCallCompletedEvent =
        codeInterpreterCallCompleted.getOrThrow("codeInterpreterCallCompleted")

    /** Emitted when a code interpreter call is in progress. */
    fun asCodeInterpreterCallInProgress(): ResponseCodeInterpreterCallInProgressEvent =
        codeInterpreterCallInProgress.getOrThrow("codeInterpreterCallInProgress")

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun asCodeInterpreterCallInterpreting(): ResponseCodeInterpreterCallInterpretingEvent =
        codeInterpreterCallInterpreting.getOrThrow("codeInterpreterCallInterpreting")

    /** Emitted when the model response is complete. */
    fun asCompleted(): ResponseCompletedEvent = completed.getOrThrow("completed")

    /** Emitted when a new content part is added. */
    fun asContentPartAdded(): ResponseContentPartAddedEvent =
        contentPartAdded.getOrThrow("contentPartAdded")

    /** Emitted when a content part is done. */
    fun asContentPartDone(): ResponseContentPartDoneEvent =
        contentPartDone.getOrThrow("contentPartDone")

    /** An event that is emitted when a response is created. */
    fun asCreated(): ResponseCreatedEvent = created.getOrThrow("created")

    /** Emitted when an error occurs. */
    fun asError(): ResponseErrorEvent = error.getOrThrow("error")

    /** Emitted when a file search call is completed (results found). */
    fun asFileSearchCallCompleted(): ResponseFileSearchCallCompletedEvent =
        fileSearchCallCompleted.getOrThrow("fileSearchCallCompleted")

    /** Emitted when a file search call is initiated. */
    fun asFileSearchCallInProgress(): ResponseFileSearchCallInProgressEvent =
        fileSearchCallInProgress.getOrThrow("fileSearchCallInProgress")

    /** Emitted when a file search is currently searching. */
    fun asFileSearchCallSearching(): ResponseFileSearchCallSearchingEvent =
        fileSearchCallSearching.getOrThrow("fileSearchCallSearching")

    /** Emitted when there is a partial function-call arguments delta. */
    fun asFunctionCallArgumentsDelta(): ResponseFunctionCallArgumentsDeltaEvent =
        functionCallArgumentsDelta.getOrThrow("functionCallArgumentsDelta")

    /** Emitted when function-call arguments are finalized. */
    fun asFunctionCallArgumentsDone(): ResponseFunctionCallArgumentsDoneEvent =
        functionCallArgumentsDone.getOrThrow("functionCallArgumentsDone")

    /** Emitted when the response is in progress. */
    fun asInProgress(): ResponseInProgressEvent = inProgress.getOrThrow("inProgress")

    /** An event that is emitted when a response fails. */
    fun asFailed(): ResponseFailedEvent = failed.getOrThrow("failed")

    /** An event that is emitted when a response finishes as incomplete. */
    fun asIncomplete(): ResponseIncompleteEvent = incomplete.getOrThrow("incomplete")

    /** Emitted when a new output item is added. */
    fun asOutputItemAdded(): ResponseOutputItemAddedEvent =
        outputItemAdded.getOrThrow("outputItemAdded")

    /** Emitted when an output item is marked done. */
    fun asOutputItemDone(): ResponseOutputItemDoneEvent =
        outputItemDone.getOrThrow("outputItemDone")

    /** Emitted when a new reasoning summary part is added. */
    fun asReasoningSummaryPartAdded(): ResponseReasoningSummaryPartAddedEvent =
        reasoningSummaryPartAdded.getOrThrow("reasoningSummaryPartAdded")

    /** Emitted when a reasoning summary part is completed. */
    fun asReasoningSummaryPartDone(): ResponseReasoningSummaryPartDoneEvent =
        reasoningSummaryPartDone.getOrThrow("reasoningSummaryPartDone")

    /** Emitted when a delta is added to a reasoning summary text. */
    fun asReasoningSummaryTextDelta(): ResponseReasoningSummaryTextDeltaEvent =
        reasoningSummaryTextDelta.getOrThrow("reasoningSummaryTextDelta")

    /** Emitted when a reasoning summary text is completed. */
    fun asReasoningSummaryTextDone(): ResponseReasoningSummaryTextDoneEvent =
        reasoningSummaryTextDone.getOrThrow("reasoningSummaryTextDone")

    /** Emitted when a delta is added to a reasoning text. */
    fun asReasoningTextDelta(): ResponseReasoningTextDeltaEvent =
        reasoningTextDelta.getOrThrow("reasoningTextDelta")

    /** Emitted when a reasoning text is completed. */
    fun asReasoningTextDone(): ResponseReasoningTextDoneEvent =
        reasoningTextDone.getOrThrow("reasoningTextDone")

    /** Emitted when there is a partial refusal text. */
    fun asRefusalDelta(): ResponseRefusalDeltaEvent = refusalDelta.getOrThrow("refusalDelta")

    /** Emitted when refusal text is finalized. */
    fun asRefusalDone(): ResponseRefusalDoneEvent = refusalDone.getOrThrow("refusalDone")

    /** Emitted when there is an additional text delta. */
    fun asOutputTextDelta(): ResponseTextDeltaEvent = outputTextDelta.getOrThrow("outputTextDelta")

    /** Emitted when text content is finalized. */
    fun asOutputTextDone(): ResponseTextDoneEvent = outputTextDone.getOrThrow("outputTextDone")

    /** Emitted when a web search call is completed. */
    fun asWebSearchCallCompleted(): ResponseWebSearchCallCompletedEvent =
        webSearchCallCompleted.getOrThrow("webSearchCallCompleted")

    /** Emitted when a web search call is initiated. */
    fun asWebSearchCallInProgress(): ResponseWebSearchCallInProgressEvent =
        webSearchCallInProgress.getOrThrow("webSearchCallInProgress")

    /** Emitted when a web search call is executing. */
    fun asWebSearchCallSearching(): ResponseWebSearchCallSearchingEvent =
        webSearchCallSearching.getOrThrow("webSearchCallSearching")

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun asImageGenerationCallCompleted(): ResponseImageGenCallCompletedEvent =
        imageGenerationCallCompleted.getOrThrow("imageGenerationCallCompleted")

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun asImageGenerationCallGenerating(): ResponseImageGenCallGeneratingEvent =
        imageGenerationCallGenerating.getOrThrow("imageGenerationCallGenerating")

    /** Emitted when an image generation tool call is in progress. */
    fun asImageGenerationCallInProgress(): ResponseImageGenCallInProgressEvent =
        imageGenerationCallInProgress.getOrThrow("imageGenerationCallInProgress")

    /** Emitted when a partial image is available during image generation streaming. */
    fun asImageGenerationCallPartialImage(): ResponseImageGenCallPartialImageEvent =
        imageGenerationCallPartialImage.getOrThrow("imageGenerationCallPartialImage")

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun asMcpCallArgumentsDelta(): ResponseMcpCallArgumentsDeltaEvent =
        mcpCallArgumentsDelta.getOrThrow("mcpCallArgumentsDelta")

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun asMcpCallArgumentsDone(): ResponseMcpCallArgumentsDoneEvent =
        mcpCallArgumentsDone.getOrThrow("mcpCallArgumentsDone")

    /** Emitted when an MCP tool call has completed successfully. */
    fun asMcpCallCompleted(): ResponseMcpCallCompletedEvent =
        mcpCallCompleted.getOrThrow("mcpCallCompleted")

    /** Emitted when an MCP tool call has failed. */
    fun asMcpCallFailed(): ResponseMcpCallFailedEvent = mcpCallFailed.getOrThrow("mcpCallFailed")

    /** Emitted when an MCP tool call is in progress. */
    fun asMcpCallInProgress(): ResponseMcpCallInProgressEvent =
        mcpCallInProgress.getOrThrow("mcpCallInProgress")

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun asMcpListToolsCompleted(): ResponseMcpListToolsCompletedEvent =
        mcpListToolsCompleted.getOrThrow("mcpListToolsCompleted")

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun asMcpListToolsFailed(): ResponseMcpListToolsFailedEvent =
        mcpListToolsFailed.getOrThrow("mcpListToolsFailed")

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun asMcpListToolsInProgress(): ResponseMcpListToolsInProgressEvent =
        mcpListToolsInProgress.getOrThrow("mcpListToolsInProgress")

    /** Emitted when an annotation is added to output text content. */
    fun asOutputTextAnnotationAdded(): ResponseOutputTextAnnotationAddedEvent =
        outputTextAnnotationAdded.getOrThrow("outputTextAnnotationAdded")

    /** Emitted when a response is queued and waiting to be processed. */
    fun asQueued(): ResponseQueuedEvent = queued.getOrThrow("queued")

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun asCustomToolCallInputDelta(): ResponseCustomToolCallInputDeltaEvent =
        customToolCallInputDelta.getOrThrow("customToolCallInputDelta")

    /** Event indicating that input for a custom tool call is complete. */
    fun asCustomToolCallInputDone(): ResponseCustomToolCallInputDoneEvent =
        customToolCallInputDone.getOrThrow("customToolCallInputDone")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            audioDelta != null -> visitor.visitAudioDelta(audioDelta)
            audioDone != null -> visitor.visitAudioDone(audioDone)
            audioTranscriptDelta != null -> visitor.visitAudioTranscriptDelta(audioTranscriptDelta)
            audioTranscriptDone != null -> visitor.visitAudioTranscriptDone(audioTranscriptDone)
            codeInterpreterCallCodeDelta != null ->
                visitor.visitCodeInterpreterCallCodeDelta(codeInterpreterCallCodeDelta)
            codeInterpreterCallCodeDone != null ->
                visitor.visitCodeInterpreterCallCodeDone(codeInterpreterCallCodeDone)
            codeInterpreterCallCompleted != null ->
                visitor.visitCodeInterpreterCallCompleted(codeInterpreterCallCompleted)
            codeInterpreterCallInProgress != null ->
                visitor.visitCodeInterpreterCallInProgress(codeInterpreterCallInProgress)
            codeInterpreterCallInterpreting != null ->
                visitor.visitCodeInterpreterCallInterpreting(codeInterpreterCallInterpreting)
            completed != null -> visitor.visitCompleted(completed)
            contentPartAdded != null -> visitor.visitContentPartAdded(contentPartAdded)
            contentPartDone != null -> visitor.visitContentPartDone(contentPartDone)
            created != null -> visitor.visitCreated(created)
            error != null -> visitor.visitError(error)
            fileSearchCallCompleted != null ->
                visitor.visitFileSearchCallCompleted(fileSearchCallCompleted)
            fileSearchCallInProgress != null ->
                visitor.visitFileSearchCallInProgress(fileSearchCallInProgress)
            fileSearchCallSearching != null ->
                visitor.visitFileSearchCallSearching(fileSearchCallSearching)
            functionCallArgumentsDelta != null ->
                visitor.visitFunctionCallArgumentsDelta(functionCallArgumentsDelta)
            functionCallArgumentsDone != null ->
                visitor.visitFunctionCallArgumentsDone(functionCallArgumentsDone)
            inProgress != null -> visitor.visitInProgress(inProgress)
            failed != null -> visitor.visitFailed(failed)
            incomplete != null -> visitor.visitIncomplete(incomplete)
            outputItemAdded != null -> visitor.visitOutputItemAdded(outputItemAdded)
            outputItemDone != null -> visitor.visitOutputItemDone(outputItemDone)
            reasoningSummaryPartAdded != null ->
                visitor.visitReasoningSummaryPartAdded(reasoningSummaryPartAdded)
            reasoningSummaryPartDone != null ->
                visitor.visitReasoningSummaryPartDone(reasoningSummaryPartDone)
            reasoningSummaryTextDelta != null ->
                visitor.visitReasoningSummaryTextDelta(reasoningSummaryTextDelta)
            reasoningSummaryTextDone != null ->
                visitor.visitReasoningSummaryTextDone(reasoningSummaryTextDone)
            reasoningTextDelta != null -> visitor.visitReasoningTextDelta(reasoningTextDelta)
            reasoningTextDone != null -> visitor.visitReasoningTextDone(reasoningTextDone)
            refusalDelta != null -> visitor.visitRefusalDelta(refusalDelta)
            refusalDone != null -> visitor.visitRefusalDone(refusalDone)
            outputTextDelta != null -> visitor.visitOutputTextDelta(outputTextDelta)
            outputTextDone != null -> visitor.visitOutputTextDone(outputTextDone)
            webSearchCallCompleted != null ->
                visitor.visitWebSearchCallCompleted(webSearchCallCompleted)
            webSearchCallInProgress != null ->
                visitor.visitWebSearchCallInProgress(webSearchCallInProgress)
            webSearchCallSearching != null ->
                visitor.visitWebSearchCallSearching(webSearchCallSearching)
            imageGenerationCallCompleted != null ->
                visitor.visitImageGenerationCallCompleted(imageGenerationCallCompleted)
            imageGenerationCallGenerating != null ->
                visitor.visitImageGenerationCallGenerating(imageGenerationCallGenerating)
            imageGenerationCallInProgress != null ->
                visitor.visitImageGenerationCallInProgress(imageGenerationCallInProgress)
            imageGenerationCallPartialImage != null ->
                visitor.visitImageGenerationCallPartialImage(imageGenerationCallPartialImage)
            mcpCallArgumentsDelta != null ->
                visitor.visitMcpCallArgumentsDelta(mcpCallArgumentsDelta)
            mcpCallArgumentsDone != null -> visitor.visitMcpCallArgumentsDone(mcpCallArgumentsDone)
            mcpCallCompleted != null -> visitor.visitMcpCallCompleted(mcpCallCompleted)
            mcpCallFailed != null -> visitor.visitMcpCallFailed(mcpCallFailed)
            mcpCallInProgress != null -> visitor.visitMcpCallInProgress(mcpCallInProgress)
            mcpListToolsCompleted != null ->
                visitor.visitMcpListToolsCompleted(mcpListToolsCompleted)
            mcpListToolsFailed != null -> visitor.visitMcpListToolsFailed(mcpListToolsFailed)
            mcpListToolsInProgress != null ->
                visitor.visitMcpListToolsInProgress(mcpListToolsInProgress)
            outputTextAnnotationAdded != null ->
                visitor.visitOutputTextAnnotationAdded(outputTextAnnotationAdded)
            queued != null -> visitor.visitQueued(queued)
            customToolCallInputDelta != null ->
                visitor.visitCustomToolCallInputDelta(customToolCallInputDelta)
            customToolCallInputDone != null ->
                visitor.visitCustomToolCallInputDone(customToolCallInputDone)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAudioDelta(audioDelta: ResponseAudioDeltaEvent) {
                    audioDelta.validate()
                }

                override fun visitAudioDone(audioDone: ResponseAudioDoneEvent) {
                    audioDone.validate()
                }

                override fun visitAudioTranscriptDelta(
                    audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) {
                    audioTranscriptDelta.validate()
                }

                override fun visitAudioTranscriptDone(
                    audioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) {
                    audioTranscriptDone.validate()
                }

                override fun visitCodeInterpreterCallCodeDelta(
                    codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
                ) {
                    codeInterpreterCallCodeDelta.validate()
                }

                override fun visitCodeInterpreterCallCodeDone(
                    codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
                ) {
                    codeInterpreterCallCodeDone.validate()
                }

                override fun visitCodeInterpreterCallCompleted(
                    codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) {
                    codeInterpreterCallCompleted.validate()
                }

                override fun visitCodeInterpreterCallInProgress(
                    codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
                ) {
                    codeInterpreterCallInProgress.validate()
                }

                override fun visitCodeInterpreterCallInterpreting(
                    codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
                ) {
                    codeInterpreterCallInterpreting.validate()
                }

                override fun visitCompleted(completed: ResponseCompletedEvent) {
                    completed.validate()
                }

                override fun visitContentPartAdded(
                    contentPartAdded: ResponseContentPartAddedEvent
                ) {
                    contentPartAdded.validate()
                }

                override fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent) {
                    contentPartDone.validate()
                }

                override fun visitCreated(created: ResponseCreatedEvent) {
                    created.validate()
                }

                override fun visitError(error: ResponseErrorEvent) {
                    error.validate()
                }

                override fun visitFileSearchCallCompleted(
                    fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) {
                    fileSearchCallCompleted.validate()
                }

                override fun visitFileSearchCallInProgress(
                    fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) {
                    fileSearchCallInProgress.validate()
                }

                override fun visitFileSearchCallSearching(
                    fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) {
                    fileSearchCallSearching.validate()
                }

                override fun visitFunctionCallArgumentsDelta(
                    functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) {
                    functionCallArgumentsDelta.validate()
                }

                override fun visitFunctionCallArgumentsDone(
                    functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {
                    functionCallArgumentsDone.validate()
                }

                override fun visitInProgress(inProgress: ResponseInProgressEvent) {
                    inProgress.validate()
                }

                override fun visitFailed(failed: ResponseFailedEvent) {
                    failed.validate()
                }

                override fun visitIncomplete(incomplete: ResponseIncompleteEvent) {
                    incomplete.validate()
                }

                override fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) {
                    outputItemAdded.validate()
                }

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) {
                    outputItemDone.validate()
                }

                override fun visitReasoningSummaryPartAdded(
                    reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
                ) {
                    reasoningSummaryPartAdded.validate()
                }

                override fun visitReasoningSummaryPartDone(
                    reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
                ) {
                    reasoningSummaryPartDone.validate()
                }

                override fun visitReasoningSummaryTextDelta(
                    reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
                ) {
                    reasoningSummaryTextDelta.validate()
                }

                override fun visitReasoningSummaryTextDone(
                    reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
                ) {
                    reasoningSummaryTextDone.validate()
                }

                override fun visitReasoningTextDelta(
                    reasoningTextDelta: ResponseReasoningTextDeltaEvent
                ) {
                    reasoningTextDelta.validate()
                }

                override fun visitReasoningTextDone(
                    reasoningTextDone: ResponseReasoningTextDoneEvent
                ) {
                    reasoningTextDone.validate()
                }

                override fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) {
                    refusalDelta.validate()
                }

                override fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent) {
                    refusalDone.validate()
                }

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) {
                    outputTextDelta.validate()
                }

                override fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent) {
                    outputTextDone.validate()
                }

                override fun visitWebSearchCallCompleted(
                    webSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) {
                    webSearchCallCompleted.validate()
                }

                override fun visitWebSearchCallInProgress(
                    webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) {
                    webSearchCallInProgress.validate()
                }

                override fun visitWebSearchCallSearching(
                    webSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) {
                    webSearchCallSearching.validate()
                }

                override fun visitImageGenerationCallCompleted(
                    imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
                ) {
                    imageGenerationCallCompleted.validate()
                }

                override fun visitImageGenerationCallGenerating(
                    imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
                ) {
                    imageGenerationCallGenerating.validate()
                }

                override fun visitImageGenerationCallInProgress(
                    imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
                ) {
                    imageGenerationCallInProgress.validate()
                }

                override fun visitImageGenerationCallPartialImage(
                    imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
                ) {
                    imageGenerationCallPartialImage.validate()
                }

                override fun visitMcpCallArgumentsDelta(
                    mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
                ) {
                    mcpCallArgumentsDelta.validate()
                }

                override fun visitMcpCallArgumentsDone(
                    mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
                ) {
                    mcpCallArgumentsDone.validate()
                }

                override fun visitMcpCallCompleted(
                    mcpCallCompleted: ResponseMcpCallCompletedEvent
                ) {
                    mcpCallCompleted.validate()
                }

                override fun visitMcpCallFailed(mcpCallFailed: ResponseMcpCallFailedEvent) {
                    mcpCallFailed.validate()
                }

                override fun visitMcpCallInProgress(
                    mcpCallInProgress: ResponseMcpCallInProgressEvent
                ) {
                    mcpCallInProgress.validate()
                }

                override fun visitMcpListToolsCompleted(
                    mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
                ) {
                    mcpListToolsCompleted.validate()
                }

                override fun visitMcpListToolsFailed(
                    mcpListToolsFailed: ResponseMcpListToolsFailedEvent
                ) {
                    mcpListToolsFailed.validate()
                }

                override fun visitMcpListToolsInProgress(
                    mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
                ) {
                    mcpListToolsInProgress.validate()
                }

                override fun visitOutputTextAnnotationAdded(
                    outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
                ) {
                    outputTextAnnotationAdded.validate()
                }

                override fun visitQueued(queued: ResponseQueuedEvent) {
                    queued.validate()
                }

                override fun visitCustomToolCallInputDelta(
                    customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
                ) {
                    customToolCallInputDelta.validate()
                }

                override fun visitCustomToolCallInputDone(
                    customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) {
                    customToolCallInputDone.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitAudioDelta(audioDelta: ResponseAudioDeltaEvent) =
                    audioDelta.validity()

                override fun visitAudioDone(audioDone: ResponseAudioDoneEvent) =
                    audioDone.validity()

                override fun visitAudioTranscriptDelta(
                    audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) = audioTranscriptDelta.validity()

                override fun visitAudioTranscriptDone(
                    audioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) = audioTranscriptDone.validity()

                override fun visitCodeInterpreterCallCodeDelta(
                    codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
                ) = codeInterpreterCallCodeDelta.validity()

                override fun visitCodeInterpreterCallCodeDone(
                    codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
                ) = codeInterpreterCallCodeDone.validity()

                override fun visitCodeInterpreterCallCompleted(
                    codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) = codeInterpreterCallCompleted.validity()

                override fun visitCodeInterpreterCallInProgress(
                    codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
                ) = codeInterpreterCallInProgress.validity()

                override fun visitCodeInterpreterCallInterpreting(
                    codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
                ) = codeInterpreterCallInterpreting.validity()

                override fun visitCompleted(completed: ResponseCompletedEvent) =
                    completed.validity()

                override fun visitContentPartAdded(
                    contentPartAdded: ResponseContentPartAddedEvent
                ) = contentPartAdded.validity()

                override fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent) =
                    contentPartDone.validity()

                override fun visitCreated(created: ResponseCreatedEvent) = created.validity()

                override fun visitError(error: ResponseErrorEvent) = error.validity()

                override fun visitFileSearchCallCompleted(
                    fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) = fileSearchCallCompleted.validity()

                override fun visitFileSearchCallInProgress(
                    fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) = fileSearchCallInProgress.validity()

                override fun visitFileSearchCallSearching(
                    fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) = fileSearchCallSearching.validity()

                override fun visitFunctionCallArgumentsDelta(
                    functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) = functionCallArgumentsDelta.validity()

                override fun visitFunctionCallArgumentsDone(
                    functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) = functionCallArgumentsDone.validity()

                override fun visitInProgress(inProgress: ResponseInProgressEvent) =
                    inProgress.validity()

                override fun visitFailed(failed: ResponseFailedEvent) = failed.validity()

                override fun visitIncomplete(incomplete: ResponseIncompleteEvent) =
                    incomplete.validity()

                override fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) =
                    outputItemAdded.validity()

                override fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) =
                    outputItemDone.validity()

                override fun visitReasoningSummaryPartAdded(
                    reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
                ) = reasoningSummaryPartAdded.validity()

                override fun visitReasoningSummaryPartDone(
                    reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
                ) = reasoningSummaryPartDone.validity()

                override fun visitReasoningSummaryTextDelta(
                    reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
                ) = reasoningSummaryTextDelta.validity()

                override fun visitReasoningSummaryTextDone(
                    reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
                ) = reasoningSummaryTextDone.validity()

                override fun visitReasoningTextDelta(
                    reasoningTextDelta: ResponseReasoningTextDeltaEvent
                ) = reasoningTextDelta.validity()

                override fun visitReasoningTextDone(
                    reasoningTextDone: ResponseReasoningTextDoneEvent
                ) = reasoningTextDone.validity()

                override fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) =
                    refusalDelta.validity()

                override fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent) =
                    refusalDone.validity()

                override fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) =
                    outputTextDelta.validity()

                override fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent) =
                    outputTextDone.validity()

                override fun visitWebSearchCallCompleted(
                    webSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) = webSearchCallCompleted.validity()

                override fun visitWebSearchCallInProgress(
                    webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) = webSearchCallInProgress.validity()

                override fun visitWebSearchCallSearching(
                    webSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) = webSearchCallSearching.validity()

                override fun visitImageGenerationCallCompleted(
                    imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
                ) = imageGenerationCallCompleted.validity()

                override fun visitImageGenerationCallGenerating(
                    imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
                ) = imageGenerationCallGenerating.validity()

                override fun visitImageGenerationCallInProgress(
                    imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
                ) = imageGenerationCallInProgress.validity()

                override fun visitImageGenerationCallPartialImage(
                    imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
                ) = imageGenerationCallPartialImage.validity()

                override fun visitMcpCallArgumentsDelta(
                    mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
                ) = mcpCallArgumentsDelta.validity()

                override fun visitMcpCallArgumentsDone(
                    mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
                ) = mcpCallArgumentsDone.validity()

                override fun visitMcpCallCompleted(
                    mcpCallCompleted: ResponseMcpCallCompletedEvent
                ) = mcpCallCompleted.validity()

                override fun visitMcpCallFailed(mcpCallFailed: ResponseMcpCallFailedEvent) =
                    mcpCallFailed.validity()

                override fun visitMcpCallInProgress(
                    mcpCallInProgress: ResponseMcpCallInProgressEvent
                ) = mcpCallInProgress.validity()

                override fun visitMcpListToolsCompleted(
                    mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
                ) = mcpListToolsCompleted.validity()

                override fun visitMcpListToolsFailed(
                    mcpListToolsFailed: ResponseMcpListToolsFailedEvent
                ) = mcpListToolsFailed.validity()

                override fun visitMcpListToolsInProgress(
                    mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
                ) = mcpListToolsInProgress.validity()

                override fun visitOutputTextAnnotationAdded(
                    outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
                ) = outputTextAnnotationAdded.validity()

                override fun visitQueued(queued: ResponseQueuedEvent) = queued.validity()

                override fun visitCustomToolCallInputDelta(
                    customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
                ) = customToolCallInputDelta.validity()

                override fun visitCustomToolCallInputDone(
                    customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) = customToolCallInputDone.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseStreamEvent && audioDelta == other.audioDelta && audioDone == other.audioDone && audioTranscriptDelta == other.audioTranscriptDelta && audioTranscriptDone == other.audioTranscriptDone && codeInterpreterCallCodeDelta == other.codeInterpreterCallCodeDelta && codeInterpreterCallCodeDone == other.codeInterpreterCallCodeDone && codeInterpreterCallCompleted == other.codeInterpreterCallCompleted && codeInterpreterCallInProgress == other.codeInterpreterCallInProgress && codeInterpreterCallInterpreting == other.codeInterpreterCallInterpreting && completed == other.completed && contentPartAdded == other.contentPartAdded && contentPartDone == other.contentPartDone && created == other.created && error == other.error && fileSearchCallCompleted == other.fileSearchCallCompleted && fileSearchCallInProgress == other.fileSearchCallInProgress && fileSearchCallSearching == other.fileSearchCallSearching && functionCallArgumentsDelta == other.functionCallArgumentsDelta && functionCallArgumentsDone == other.functionCallArgumentsDone && inProgress == other.inProgress && failed == other.failed && incomplete == other.incomplete && outputItemAdded == other.outputItemAdded && outputItemDone == other.outputItemDone && reasoningSummaryPartAdded == other.reasoningSummaryPartAdded && reasoningSummaryPartDone == other.reasoningSummaryPartDone && reasoningSummaryTextDelta == other.reasoningSummaryTextDelta && reasoningSummaryTextDone == other.reasoningSummaryTextDone && reasoningTextDelta == other.reasoningTextDelta && reasoningTextDone == other.reasoningTextDone && refusalDelta == other.refusalDelta && refusalDone == other.refusalDone && outputTextDelta == other.outputTextDelta && outputTextDone == other.outputTextDone && webSearchCallCompleted == other.webSearchCallCompleted && webSearchCallInProgress == other.webSearchCallInProgress && webSearchCallSearching == other.webSearchCallSearching && imageGenerationCallCompleted == other.imageGenerationCallCompleted && imageGenerationCallGenerating == other.imageGenerationCallGenerating && imageGenerationCallInProgress == other.imageGenerationCallInProgress && imageGenerationCallPartialImage == other.imageGenerationCallPartialImage && mcpCallArgumentsDelta == other.mcpCallArgumentsDelta && mcpCallArgumentsDone == other.mcpCallArgumentsDone && mcpCallCompleted == other.mcpCallCompleted && mcpCallFailed == other.mcpCallFailed && mcpCallInProgress == other.mcpCallInProgress && mcpListToolsCompleted == other.mcpListToolsCompleted && mcpListToolsFailed == other.mcpListToolsFailed && mcpListToolsInProgress == other.mcpListToolsInProgress && outputTextAnnotationAdded == other.outputTextAnnotationAdded && queued == other.queued && customToolCallInputDelta == other.customToolCallInputDelta && customToolCallInputDone == other.customToolCallInputDone /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(audioDelta, audioDone, audioTranscriptDelta, audioTranscriptDone, codeInterpreterCallCodeDelta, codeInterpreterCallCodeDone, codeInterpreterCallCompleted, codeInterpreterCallInProgress, codeInterpreterCallInterpreting, completed, contentPartAdded, contentPartDone, created, error, fileSearchCallCompleted, fileSearchCallInProgress, fileSearchCallSearching, functionCallArgumentsDelta, functionCallArgumentsDone, inProgress, failed, incomplete, outputItemAdded, outputItemDone, reasoningSummaryPartAdded, reasoningSummaryPartDone, reasoningSummaryTextDelta, reasoningSummaryTextDone, reasoningTextDelta, reasoningTextDone, refusalDelta, refusalDone, outputTextDelta, outputTextDone, webSearchCallCompleted, webSearchCallInProgress, webSearchCallSearching, imageGenerationCallCompleted, imageGenerationCallGenerating, imageGenerationCallInProgress, imageGenerationCallPartialImage, mcpCallArgumentsDelta, mcpCallArgumentsDone, mcpCallCompleted, mcpCallFailed, mcpCallInProgress, mcpListToolsCompleted, mcpListToolsFailed, mcpListToolsInProgress, outputTextAnnotationAdded, queued, customToolCallInputDelta, customToolCallInputDone) /* spotless:on */

    override fun toString(): String =
        when {
            audioDelta != null -> "ResponseStreamEvent{audioDelta=$audioDelta}"
            audioDone != null -> "ResponseStreamEvent{audioDone=$audioDone}"
            audioTranscriptDelta != null ->
                "ResponseStreamEvent{audioTranscriptDelta=$audioTranscriptDelta}"
            audioTranscriptDone != null ->
                "ResponseStreamEvent{audioTranscriptDone=$audioTranscriptDone}"
            codeInterpreterCallCodeDelta != null ->
                "ResponseStreamEvent{codeInterpreterCallCodeDelta=$codeInterpreterCallCodeDelta}"
            codeInterpreterCallCodeDone != null ->
                "ResponseStreamEvent{codeInterpreterCallCodeDone=$codeInterpreterCallCodeDone}"
            codeInterpreterCallCompleted != null ->
                "ResponseStreamEvent{codeInterpreterCallCompleted=$codeInterpreterCallCompleted}"
            codeInterpreterCallInProgress != null ->
                "ResponseStreamEvent{codeInterpreterCallInProgress=$codeInterpreterCallInProgress}"
            codeInterpreterCallInterpreting != null ->
                "ResponseStreamEvent{codeInterpreterCallInterpreting=$codeInterpreterCallInterpreting}"
            completed != null -> "ResponseStreamEvent{completed=$completed}"
            contentPartAdded != null -> "ResponseStreamEvent{contentPartAdded=$contentPartAdded}"
            contentPartDone != null -> "ResponseStreamEvent{contentPartDone=$contentPartDone}"
            created != null -> "ResponseStreamEvent{created=$created}"
            error != null -> "ResponseStreamEvent{error=$error}"
            fileSearchCallCompleted != null ->
                "ResponseStreamEvent{fileSearchCallCompleted=$fileSearchCallCompleted}"
            fileSearchCallInProgress != null ->
                "ResponseStreamEvent{fileSearchCallInProgress=$fileSearchCallInProgress}"
            fileSearchCallSearching != null ->
                "ResponseStreamEvent{fileSearchCallSearching=$fileSearchCallSearching}"
            functionCallArgumentsDelta != null ->
                "ResponseStreamEvent{functionCallArgumentsDelta=$functionCallArgumentsDelta}"
            functionCallArgumentsDone != null ->
                "ResponseStreamEvent{functionCallArgumentsDone=$functionCallArgumentsDone}"
            inProgress != null -> "ResponseStreamEvent{inProgress=$inProgress}"
            failed != null -> "ResponseStreamEvent{failed=$failed}"
            incomplete != null -> "ResponseStreamEvent{incomplete=$incomplete}"
            outputItemAdded != null -> "ResponseStreamEvent{outputItemAdded=$outputItemAdded}"
            outputItemDone != null -> "ResponseStreamEvent{outputItemDone=$outputItemDone}"
            reasoningSummaryPartAdded != null ->
                "ResponseStreamEvent{reasoningSummaryPartAdded=$reasoningSummaryPartAdded}"
            reasoningSummaryPartDone != null ->
                "ResponseStreamEvent{reasoningSummaryPartDone=$reasoningSummaryPartDone}"
            reasoningSummaryTextDelta != null ->
                "ResponseStreamEvent{reasoningSummaryTextDelta=$reasoningSummaryTextDelta}"
            reasoningSummaryTextDone != null ->
                "ResponseStreamEvent{reasoningSummaryTextDone=$reasoningSummaryTextDone}"
            reasoningTextDelta != null ->
                "ResponseStreamEvent{reasoningTextDelta=$reasoningTextDelta}"
            reasoningTextDone != null -> "ResponseStreamEvent{reasoningTextDone=$reasoningTextDone}"
            refusalDelta != null -> "ResponseStreamEvent{refusalDelta=$refusalDelta}"
            refusalDone != null -> "ResponseStreamEvent{refusalDone=$refusalDone}"
            outputTextDelta != null -> "ResponseStreamEvent{outputTextDelta=$outputTextDelta}"
            outputTextDone != null -> "ResponseStreamEvent{outputTextDone=$outputTextDone}"
            webSearchCallCompleted != null ->
                "ResponseStreamEvent{webSearchCallCompleted=$webSearchCallCompleted}"
            webSearchCallInProgress != null ->
                "ResponseStreamEvent{webSearchCallInProgress=$webSearchCallInProgress}"
            webSearchCallSearching != null ->
                "ResponseStreamEvent{webSearchCallSearching=$webSearchCallSearching}"
            imageGenerationCallCompleted != null ->
                "ResponseStreamEvent{imageGenerationCallCompleted=$imageGenerationCallCompleted}"
            imageGenerationCallGenerating != null ->
                "ResponseStreamEvent{imageGenerationCallGenerating=$imageGenerationCallGenerating}"
            imageGenerationCallInProgress != null ->
                "ResponseStreamEvent{imageGenerationCallInProgress=$imageGenerationCallInProgress}"
            imageGenerationCallPartialImage != null ->
                "ResponseStreamEvent{imageGenerationCallPartialImage=$imageGenerationCallPartialImage}"
            mcpCallArgumentsDelta != null ->
                "ResponseStreamEvent{mcpCallArgumentsDelta=$mcpCallArgumentsDelta}"
            mcpCallArgumentsDone != null ->
                "ResponseStreamEvent{mcpCallArgumentsDone=$mcpCallArgumentsDone}"
            mcpCallCompleted != null -> "ResponseStreamEvent{mcpCallCompleted=$mcpCallCompleted}"
            mcpCallFailed != null -> "ResponseStreamEvent{mcpCallFailed=$mcpCallFailed}"
            mcpCallInProgress != null -> "ResponseStreamEvent{mcpCallInProgress=$mcpCallInProgress}"
            mcpListToolsCompleted != null ->
                "ResponseStreamEvent{mcpListToolsCompleted=$mcpListToolsCompleted}"
            mcpListToolsFailed != null ->
                "ResponseStreamEvent{mcpListToolsFailed=$mcpListToolsFailed}"
            mcpListToolsInProgress != null ->
                "ResponseStreamEvent{mcpListToolsInProgress=$mcpListToolsInProgress}"
            outputTextAnnotationAdded != null ->
                "ResponseStreamEvent{outputTextAnnotationAdded=$outputTextAnnotationAdded}"
            queued != null -> "ResponseStreamEvent{queued=$queued}"
            customToolCallInputDelta != null ->
                "ResponseStreamEvent{customToolCallInputDelta=$customToolCallInputDelta}"
            customToolCallInputDone != null ->
                "ResponseStreamEvent{customToolCallInputDone=$customToolCallInputDone}"
            _json != null -> "ResponseStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseStreamEvent")
        }

    companion object {

        /** Emitted when there is a partial audio response. */
        @JvmStatic
        fun ofAudioDelta(audioDelta: ResponseAudioDeltaEvent) =
            ResponseStreamEvent(audioDelta = audioDelta)

        /** Emitted when the audio response is complete. */
        @JvmStatic
        fun ofAudioDone(audioDone: ResponseAudioDoneEvent) =
            ResponseStreamEvent(audioDone = audioDone)

        /** Emitted when there is a partial transcript of audio. */
        @JvmStatic
        fun ofAudioTranscriptDelta(audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent) =
            ResponseStreamEvent(audioTranscriptDelta = audioTranscriptDelta)

        /** Emitted when the full audio transcript is completed. */
        @JvmStatic
        fun ofAudioTranscriptDone(audioTranscriptDone: ResponseAudioTranscriptDoneEvent) =
            ResponseStreamEvent(audioTranscriptDone = audioTranscriptDone)

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        @JvmStatic
        fun ofCodeInterpreterCallCodeDelta(
            codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
        ) = ResponseStreamEvent(codeInterpreterCallCodeDelta = codeInterpreterCallCodeDelta)

        /** Emitted when the code snippet is finalized by the code interpreter. */
        @JvmStatic
        fun ofCodeInterpreterCallCodeDone(
            codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
        ) = ResponseStreamEvent(codeInterpreterCallCodeDone = codeInterpreterCallCodeDone)

        /** Emitted when the code interpreter call is completed. */
        @JvmStatic
        fun ofCodeInterpreterCallCompleted(
            codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
        ) = ResponseStreamEvent(codeInterpreterCallCompleted = codeInterpreterCallCompleted)

        /** Emitted when a code interpreter call is in progress. */
        @JvmStatic
        fun ofCodeInterpreterCallInProgress(
            codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
        ) = ResponseStreamEvent(codeInterpreterCallInProgress = codeInterpreterCallInProgress)

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        @JvmStatic
        fun ofCodeInterpreterCallInterpreting(
            codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
        ) = ResponseStreamEvent(codeInterpreterCallInterpreting = codeInterpreterCallInterpreting)

        /** Emitted when the model response is complete. */
        @JvmStatic
        fun ofCompleted(completed: ResponseCompletedEvent) =
            ResponseStreamEvent(completed = completed)

        /** Emitted when a new content part is added. */
        @JvmStatic
        fun ofContentPartAdded(contentPartAdded: ResponseContentPartAddedEvent) =
            ResponseStreamEvent(contentPartAdded = contentPartAdded)

        /** Emitted when a content part is done. */
        @JvmStatic
        fun ofContentPartDone(contentPartDone: ResponseContentPartDoneEvent) =
            ResponseStreamEvent(contentPartDone = contentPartDone)

        /** An event that is emitted when a response is created. */
        @JvmStatic
        fun ofCreated(created: ResponseCreatedEvent) = ResponseStreamEvent(created = created)

        /** Emitted when an error occurs. */
        @JvmStatic fun ofError(error: ResponseErrorEvent) = ResponseStreamEvent(error = error)

        /** Emitted when a file search call is completed (results found). */
        @JvmStatic
        fun ofFileSearchCallCompleted(
            fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
        ) = ResponseStreamEvent(fileSearchCallCompleted = fileSearchCallCompleted)

        /** Emitted when a file search call is initiated. */
        @JvmStatic
        fun ofFileSearchCallInProgress(
            fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
        ) = ResponseStreamEvent(fileSearchCallInProgress = fileSearchCallInProgress)

        /** Emitted when a file search is currently searching. */
        @JvmStatic
        fun ofFileSearchCallSearching(
            fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
        ) = ResponseStreamEvent(fileSearchCallSearching = fileSearchCallSearching)

        /** Emitted when there is a partial function-call arguments delta. */
        @JvmStatic
        fun ofFunctionCallArgumentsDelta(
            functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ) = ResponseStreamEvent(functionCallArgumentsDelta = functionCallArgumentsDelta)

        /** Emitted when function-call arguments are finalized. */
        @JvmStatic
        fun ofFunctionCallArgumentsDone(
            functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ) = ResponseStreamEvent(functionCallArgumentsDone = functionCallArgumentsDone)

        /** Emitted when the response is in progress. */
        @JvmStatic
        fun ofInProgress(inProgress: ResponseInProgressEvent) =
            ResponseStreamEvent(inProgress = inProgress)

        /** An event that is emitted when a response fails. */
        @JvmStatic fun ofFailed(failed: ResponseFailedEvent) = ResponseStreamEvent(failed = failed)

        /** An event that is emitted when a response finishes as incomplete. */
        @JvmStatic
        fun ofIncomplete(incomplete: ResponseIncompleteEvent) =
            ResponseStreamEvent(incomplete = incomplete)

        /** Emitted when a new output item is added. */
        @JvmStatic
        fun ofOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent) =
            ResponseStreamEvent(outputItemAdded = outputItemAdded)

        /** Emitted when an output item is marked done. */
        @JvmStatic
        fun ofOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent) =
            ResponseStreamEvent(outputItemDone = outputItemDone)

        /** Emitted when a new reasoning summary part is added. */
        @JvmStatic
        fun ofReasoningSummaryPartAdded(
            reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
        ) = ResponseStreamEvent(reasoningSummaryPartAdded = reasoningSummaryPartAdded)

        /** Emitted when a reasoning summary part is completed. */
        @JvmStatic
        fun ofReasoningSummaryPartDone(
            reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
        ) = ResponseStreamEvent(reasoningSummaryPartDone = reasoningSummaryPartDone)

        /** Emitted when a delta is added to a reasoning summary text. */
        @JvmStatic
        fun ofReasoningSummaryTextDelta(
            reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
        ) = ResponseStreamEvent(reasoningSummaryTextDelta = reasoningSummaryTextDelta)

        /** Emitted when a reasoning summary text is completed. */
        @JvmStatic
        fun ofReasoningSummaryTextDone(
            reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
        ) = ResponseStreamEvent(reasoningSummaryTextDone = reasoningSummaryTextDone)

        /** Emitted when a delta is added to a reasoning text. */
        @JvmStatic
        fun ofReasoningTextDelta(reasoningTextDelta: ResponseReasoningTextDeltaEvent) =
            ResponseStreamEvent(reasoningTextDelta = reasoningTextDelta)

        /** Emitted when a reasoning text is completed. */
        @JvmStatic
        fun ofReasoningTextDone(reasoningTextDone: ResponseReasoningTextDoneEvent) =
            ResponseStreamEvent(reasoningTextDone = reasoningTextDone)

        /** Emitted when there is a partial refusal text. */
        @JvmStatic
        fun ofRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent) =
            ResponseStreamEvent(refusalDelta = refusalDelta)

        /** Emitted when refusal text is finalized. */
        @JvmStatic
        fun ofRefusalDone(refusalDone: ResponseRefusalDoneEvent) =
            ResponseStreamEvent(refusalDone = refusalDone)

        /** Emitted when there is an additional text delta. */
        @JvmStatic
        fun ofOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent) =
            ResponseStreamEvent(outputTextDelta = outputTextDelta)

        /** Emitted when text content is finalized. */
        @JvmStatic
        fun ofOutputTextDone(outputTextDone: ResponseTextDoneEvent) =
            ResponseStreamEvent(outputTextDone = outputTextDone)

        /** Emitted when a web search call is completed. */
        @JvmStatic
        fun ofWebSearchCallCompleted(webSearchCallCompleted: ResponseWebSearchCallCompletedEvent) =
            ResponseStreamEvent(webSearchCallCompleted = webSearchCallCompleted)

        /** Emitted when a web search call is initiated. */
        @JvmStatic
        fun ofWebSearchCallInProgress(
            webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
        ) = ResponseStreamEvent(webSearchCallInProgress = webSearchCallInProgress)

        /** Emitted when a web search call is executing. */
        @JvmStatic
        fun ofWebSearchCallSearching(webSearchCallSearching: ResponseWebSearchCallSearchingEvent) =
            ResponseStreamEvent(webSearchCallSearching = webSearchCallSearching)

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        @JvmStatic
        fun ofImageGenerationCallCompleted(
            imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
        ) = ResponseStreamEvent(imageGenerationCallCompleted = imageGenerationCallCompleted)

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        @JvmStatic
        fun ofImageGenerationCallGenerating(
            imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
        ) = ResponseStreamEvent(imageGenerationCallGenerating = imageGenerationCallGenerating)

        /** Emitted when an image generation tool call is in progress. */
        @JvmStatic
        fun ofImageGenerationCallInProgress(
            imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
        ) = ResponseStreamEvent(imageGenerationCallInProgress = imageGenerationCallInProgress)

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofImageGenerationCallPartialImage(
            imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
        ) = ResponseStreamEvent(imageGenerationCallPartialImage = imageGenerationCallPartialImage)

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        @JvmStatic
        fun ofMcpCallArgumentsDelta(mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent) =
            ResponseStreamEvent(mcpCallArgumentsDelta = mcpCallArgumentsDelta)

        /** Emitted when the arguments for an MCP tool call are finalized. */
        @JvmStatic
        fun ofMcpCallArgumentsDone(mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent) =
            ResponseStreamEvent(mcpCallArgumentsDone = mcpCallArgumentsDone)

        /** Emitted when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofMcpCallCompleted(mcpCallCompleted: ResponseMcpCallCompletedEvent) =
            ResponseStreamEvent(mcpCallCompleted = mcpCallCompleted)

        /** Emitted when an MCP tool call has failed. */
        @JvmStatic
        fun ofMcpCallFailed(mcpCallFailed: ResponseMcpCallFailedEvent) =
            ResponseStreamEvent(mcpCallFailed = mcpCallFailed)

        /** Emitted when an MCP tool call is in progress. */
        @JvmStatic
        fun ofMcpCallInProgress(mcpCallInProgress: ResponseMcpCallInProgressEvent) =
            ResponseStreamEvent(mcpCallInProgress = mcpCallInProgress)

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        @JvmStatic
        fun ofMcpListToolsCompleted(mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent) =
            ResponseStreamEvent(mcpListToolsCompleted = mcpListToolsCompleted)

        /** Emitted when the attempt to list available MCP tools has failed. */
        @JvmStatic
        fun ofMcpListToolsFailed(mcpListToolsFailed: ResponseMcpListToolsFailedEvent) =
            ResponseStreamEvent(mcpListToolsFailed = mcpListToolsFailed)

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        @JvmStatic
        fun ofMcpListToolsInProgress(mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent) =
            ResponseStreamEvent(mcpListToolsInProgress = mcpListToolsInProgress)

        /** Emitted when an annotation is added to output text content. */
        @JvmStatic
        fun ofOutputTextAnnotationAdded(
            outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
        ) = ResponseStreamEvent(outputTextAnnotationAdded = outputTextAnnotationAdded)

        /** Emitted when a response is queued and waiting to be processed. */
        @JvmStatic fun ofQueued(queued: ResponseQueuedEvent) = ResponseStreamEvent(queued = queued)

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        @JvmStatic
        fun ofCustomToolCallInputDelta(
            customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
        ) = ResponseStreamEvent(customToolCallInputDelta = customToolCallInputDelta)

        /** Event indicating that input for a custom tool call is complete. */
        @JvmStatic
        fun ofCustomToolCallInputDone(
            customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
        ) = ResponseStreamEvent(customToolCallInputDone = customToolCallInputDone)
    }

    /**
     * An interface that defines how to map each variant of [ResponseStreamEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Emitted when there is a partial audio response. */
        fun visitAudioDelta(audioDelta: ResponseAudioDeltaEvent): T

        /** Emitted when the audio response is complete. */
        fun visitAudioDone(audioDone: ResponseAudioDoneEvent): T

        /** Emitted when there is a partial transcript of audio. */
        fun visitAudioTranscriptDelta(audioTranscriptDelta: ResponseAudioTranscriptDeltaEvent): T

        /** Emitted when the full audio transcript is completed. */
        fun visitAudioTranscriptDone(audioTranscriptDone: ResponseAudioTranscriptDoneEvent): T

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        fun visitCodeInterpreterCallCodeDelta(
            codeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
        ): T

        /** Emitted when the code snippet is finalized by the code interpreter. */
        fun visitCodeInterpreterCallCodeDone(
            codeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
        ): T

        /** Emitted when the code interpreter call is completed. */
        fun visitCodeInterpreterCallCompleted(
            codeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
        ): T

        /** Emitted when a code interpreter call is in progress. */
        fun visitCodeInterpreterCallInProgress(
            codeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
        ): T

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        fun visitCodeInterpreterCallInterpreting(
            codeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
        ): T

        /** Emitted when the model response is complete. */
        fun visitCompleted(completed: ResponseCompletedEvent): T

        /** Emitted when a new content part is added. */
        fun visitContentPartAdded(contentPartAdded: ResponseContentPartAddedEvent): T

        /** Emitted when a content part is done. */
        fun visitContentPartDone(contentPartDone: ResponseContentPartDoneEvent): T

        /** An event that is emitted when a response is created. */
        fun visitCreated(created: ResponseCreatedEvent): T

        /** Emitted when an error occurs. */
        fun visitError(error: ResponseErrorEvent): T

        /** Emitted when a file search call is completed (results found). */
        fun visitFileSearchCallCompleted(
            fileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
        ): T

        /** Emitted when a file search call is initiated. */
        fun visitFileSearchCallInProgress(
            fileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
        ): T

        /** Emitted when a file search is currently searching. */
        fun visitFileSearchCallSearching(
            fileSearchCallSearching: ResponseFileSearchCallSearchingEvent
        ): T

        /** Emitted when there is a partial function-call arguments delta. */
        fun visitFunctionCallArgumentsDelta(
            functionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ): T

        /** Emitted when function-call arguments are finalized. */
        fun visitFunctionCallArgumentsDone(
            functionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ): T

        /** Emitted when the response is in progress. */
        fun visitInProgress(inProgress: ResponseInProgressEvent): T

        /** An event that is emitted when a response fails. */
        fun visitFailed(failed: ResponseFailedEvent): T

        /** An event that is emitted when a response finishes as incomplete. */
        fun visitIncomplete(incomplete: ResponseIncompleteEvent): T

        /** Emitted when a new output item is added. */
        fun visitOutputItemAdded(outputItemAdded: ResponseOutputItemAddedEvent): T

        /** Emitted when an output item is marked done. */
        fun visitOutputItemDone(outputItemDone: ResponseOutputItemDoneEvent): T

        /** Emitted when a new reasoning summary part is added. */
        fun visitReasoningSummaryPartAdded(
            reasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
        ): T

        /** Emitted when a reasoning summary part is completed. */
        fun visitReasoningSummaryPartDone(
            reasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning summary text. */
        fun visitReasoningSummaryTextDelta(
            reasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
        ): T

        /** Emitted when a reasoning summary text is completed. */
        fun visitReasoningSummaryTextDone(
            reasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning text. */
        fun visitReasoningTextDelta(reasoningTextDelta: ResponseReasoningTextDeltaEvent): T

        /** Emitted when a reasoning text is completed. */
        fun visitReasoningTextDone(reasoningTextDone: ResponseReasoningTextDoneEvent): T

        /** Emitted when there is a partial refusal text. */
        fun visitRefusalDelta(refusalDelta: ResponseRefusalDeltaEvent): T

        /** Emitted when refusal text is finalized. */
        fun visitRefusalDone(refusalDone: ResponseRefusalDoneEvent): T

        /** Emitted when there is an additional text delta. */
        fun visitOutputTextDelta(outputTextDelta: ResponseTextDeltaEvent): T

        /** Emitted when text content is finalized. */
        fun visitOutputTextDone(outputTextDone: ResponseTextDoneEvent): T

        /** Emitted when a web search call is completed. */
        fun visitWebSearchCallCompleted(
            webSearchCallCompleted: ResponseWebSearchCallCompletedEvent
        ): T

        /** Emitted when a web search call is initiated. */
        fun visitWebSearchCallInProgress(
            webSearchCallInProgress: ResponseWebSearchCallInProgressEvent
        ): T

        /** Emitted when a web search call is executing. */
        fun visitWebSearchCallSearching(
            webSearchCallSearching: ResponseWebSearchCallSearchingEvent
        ): T

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        fun visitImageGenerationCallCompleted(
            imageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
        ): T

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        fun visitImageGenerationCallGenerating(
            imageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
        ): T

        /** Emitted when an image generation tool call is in progress. */
        fun visitImageGenerationCallInProgress(
            imageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
        ): T

        /** Emitted when a partial image is available during image generation streaming. */
        fun visitImageGenerationCallPartialImage(
            imageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
        ): T

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        fun visitMcpCallArgumentsDelta(mcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent): T

        /** Emitted when the arguments for an MCP tool call are finalized. */
        fun visitMcpCallArgumentsDone(mcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent): T

        /** Emitted when an MCP tool call has completed successfully. */
        fun visitMcpCallCompleted(mcpCallCompleted: ResponseMcpCallCompletedEvent): T

        /** Emitted when an MCP tool call has failed. */
        fun visitMcpCallFailed(mcpCallFailed: ResponseMcpCallFailedEvent): T

        /** Emitted when an MCP tool call is in progress. */
        fun visitMcpCallInProgress(mcpCallInProgress: ResponseMcpCallInProgressEvent): T

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        fun visitMcpListToolsCompleted(mcpListToolsCompleted: ResponseMcpListToolsCompletedEvent): T

        /** Emitted when the attempt to list available MCP tools has failed. */
        fun visitMcpListToolsFailed(mcpListToolsFailed: ResponseMcpListToolsFailedEvent): T

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        fun visitMcpListToolsInProgress(
            mcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
        ): T

        /** Emitted when an annotation is added to output text content. */
        fun visitOutputTextAnnotationAdded(
            outputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
        ): T

        /** Emitted when a response is queued and waiting to be processed. */
        fun visitQueued(queued: ResponseQueuedEvent): T

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        fun visitCustomToolCallInputDelta(
            customToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
        ): T

        /** Event indicating that input for a custom tool call is complete. */
        fun visitCustomToolCallInputDone(
            customToolCallInputDone: ResponseCustomToolCallInputDoneEvent
        ): T

        /**
         * Maps an unknown variant of [ResponseStreamEvent] to a value of type [T].
         *
         * An instance of [ResponseStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponseStreamEvent>(ResponseStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "response.audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDeltaEvent>())?.let {
                        ResponseStreamEvent(audioDelta = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDoneEvent>())?.let {
                        ResponseStreamEvent(audioDone = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.audio.transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>())
                        ?.let { ResponseStreamEvent(audioTranscriptDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.audio.transcript.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDoneEvent>())
                        ?.let { ResponseStreamEvent(audioTranscriptDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call_code.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeDeltaEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(codeInterpreterCallCodeDelta = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call_code.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeDoneEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(codeInterpreterCallCodeDone = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(codeInterpreterCallCompleted = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(codeInterpreterCallInProgress = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.interpreting" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallInterpretingEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(codeInterpreterCallInterpreting = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCompletedEvent>())?.let {
                        ResponseStreamEvent(completed = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartAddedEvent>())
                        ?.let { ResponseStreamEvent(contentPartAdded = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartDoneEvent>())
                        ?.let { ResponseStreamEvent(contentPartDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreatedEvent>())?.let {
                        ResponseStreamEvent(created = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseErrorEvent>())?.let {
                        ResponseStreamEvent(error = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.file_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallCompletedEvent>(),
                        )
                        ?.let { ResponseStreamEvent(fileSearchCallCompleted = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.file_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallInProgressEvent>(),
                        )
                        ?.let { ResponseStreamEvent(fileSearchCallInProgress = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.file_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallSearchingEvent>(),
                        )
                        ?.let { ResponseStreamEvent(fileSearchCallSearching = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDeltaEvent>(),
                        )
                        ?.let { ResponseStreamEvent(functionCallArgumentsDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.function_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
                        )
                        ?.let { ResponseStreamEvent(functionCallArgumentsDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInProgressEvent>())?.let {
                        ResponseStreamEvent(inProgress = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFailedEvent>())?.let {
                        ResponseStreamEvent(failed = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseIncompleteEvent>())?.let {
                        ResponseStreamEvent(incomplete = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemAddedEvent>())
                        ?.let { ResponseStreamEvent(outputItemAdded = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemDoneEvent>())
                        ?.let { ResponseStreamEvent(outputItemDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryPartAddedEvent>(),
                        )
                        ?.let { ResponseStreamEvent(reasoningSummaryPartAdded = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryPartDoneEvent>(),
                        )
                        ?.let { ResponseStreamEvent(reasoningSummaryPartDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryTextDeltaEvent>(),
                        )
                        ?.let { ResponseStreamEvent(reasoningSummaryTextDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryTextDoneEvent>(),
                        )
                        ?.let { ResponseStreamEvent(reasoningSummaryTextDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextDeltaEvent>())
                        ?.let { ResponseStreamEvent(reasoningTextDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.reasoning_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextDoneEvent>())
                        ?.let { ResponseStreamEvent(reasoningTextDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.refusal.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalDeltaEvent>())?.let {
                        ResponseStreamEvent(refusalDelta = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.refusal.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalDoneEvent>())?.let {
                        ResponseStreamEvent(refusalDone = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDeltaEvent>())?.let {
                        ResponseStreamEvent(outputTextDelta = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDoneEvent>())?.let {
                        ResponseStreamEvent(outputTextDone = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.web_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallCompletedEvent>(),
                        )
                        ?.let { ResponseStreamEvent(webSearchCallCompleted = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.web_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallInProgressEvent>(),
                        )
                        ?.let { ResponseStreamEvent(webSearchCallInProgress = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.web_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallSearchingEvent>(),
                        )
                        ?.let { ResponseStreamEvent(webSearchCallSearching = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(imageGenerationCallCompleted = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.generating" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallGeneratingEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(imageGenerationCallGenerating = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(imageGenerationCallInProgress = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.partial_image" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallPartialImageEvent>(),
                        )
                        ?.let {
                            ResponseStreamEvent(imageGenerationCallPartialImage = it, _json = json)
                        } ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpCallArgumentsDeltaEvent>(),
                        )
                        ?.let { ResponseStreamEvent(mcpCallArgumentsDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsDoneEvent>())
                        ?.let { ResponseStreamEvent(mcpCallArgumentsDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallCompletedEvent>())
                        ?.let { ResponseStreamEvent(mcpCallCompleted = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallFailedEvent>())?.let {
                        ResponseStreamEvent(mcpCallFailed = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallInProgressEvent>())
                        ?.let { ResponseStreamEvent(mcpCallInProgress = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpListToolsCompletedEvent>(),
                        )
                        ?.let { ResponseStreamEvent(mcpListToolsCompleted = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpListToolsFailedEvent>())
                        ?.let { ResponseStreamEvent(mcpListToolsFailed = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpListToolsInProgressEvent>(),
                        )
                        ?.let { ResponseStreamEvent(mcpListToolsInProgress = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.output_text.annotation.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseOutputTextAnnotationAddedEvent>(),
                        )
                        ?.let { ResponseStreamEvent(outputTextAnnotationAdded = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseQueuedEvent>())?.let {
                        ResponseStreamEvent(queued = it, _json = json)
                    } ?: ResponseStreamEvent(_json = json)
                }
                "response.custom_tool_call_input.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCustomToolCallInputDeltaEvent>(),
                        )
                        ?.let { ResponseStreamEvent(customToolCallInputDelta = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
                "response.custom_tool_call_input.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCustomToolCallInputDoneEvent>(),
                        )
                        ?.let { ResponseStreamEvent(customToolCallInputDone = it, _json = json) }
                        ?: ResponseStreamEvent(_json = json)
                }
            }

            return ResponseStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseStreamEvent>(ResponseStreamEvent::class) {

        override fun serialize(
            value: ResponseStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.audioDelta != null -> generator.writeObject(value.audioDelta)
                value.audioDone != null -> generator.writeObject(value.audioDone)
                value.audioTranscriptDelta != null ->
                    generator.writeObject(value.audioTranscriptDelta)
                value.audioTranscriptDone != null ->
                    generator.writeObject(value.audioTranscriptDone)
                value.codeInterpreterCallCodeDelta != null ->
                    generator.writeObject(value.codeInterpreterCallCodeDelta)
                value.codeInterpreterCallCodeDone != null ->
                    generator.writeObject(value.codeInterpreterCallCodeDone)
                value.codeInterpreterCallCompleted != null ->
                    generator.writeObject(value.codeInterpreterCallCompleted)
                value.codeInterpreterCallInProgress != null ->
                    generator.writeObject(value.codeInterpreterCallInProgress)
                value.codeInterpreterCallInterpreting != null ->
                    generator.writeObject(value.codeInterpreterCallInterpreting)
                value.completed != null -> generator.writeObject(value.completed)
                value.contentPartAdded != null -> generator.writeObject(value.contentPartAdded)
                value.contentPartDone != null -> generator.writeObject(value.contentPartDone)
                value.created != null -> generator.writeObject(value.created)
                value.error != null -> generator.writeObject(value.error)
                value.fileSearchCallCompleted != null ->
                    generator.writeObject(value.fileSearchCallCompleted)
                value.fileSearchCallInProgress != null ->
                    generator.writeObject(value.fileSearchCallInProgress)
                value.fileSearchCallSearching != null ->
                    generator.writeObject(value.fileSearchCallSearching)
                value.functionCallArgumentsDelta != null ->
                    generator.writeObject(value.functionCallArgumentsDelta)
                value.functionCallArgumentsDone != null ->
                    generator.writeObject(value.functionCallArgumentsDone)
                value.inProgress != null -> generator.writeObject(value.inProgress)
                value.failed != null -> generator.writeObject(value.failed)
                value.incomplete != null -> generator.writeObject(value.incomplete)
                value.outputItemAdded != null -> generator.writeObject(value.outputItemAdded)
                value.outputItemDone != null -> generator.writeObject(value.outputItemDone)
                value.reasoningSummaryPartAdded != null ->
                    generator.writeObject(value.reasoningSummaryPartAdded)
                value.reasoningSummaryPartDone != null ->
                    generator.writeObject(value.reasoningSummaryPartDone)
                value.reasoningSummaryTextDelta != null ->
                    generator.writeObject(value.reasoningSummaryTextDelta)
                value.reasoningSummaryTextDone != null ->
                    generator.writeObject(value.reasoningSummaryTextDone)
                value.reasoningTextDelta != null -> generator.writeObject(value.reasoningTextDelta)
                value.reasoningTextDone != null -> generator.writeObject(value.reasoningTextDone)
                value.refusalDelta != null -> generator.writeObject(value.refusalDelta)
                value.refusalDone != null -> generator.writeObject(value.refusalDone)
                value.outputTextDelta != null -> generator.writeObject(value.outputTextDelta)
                value.outputTextDone != null -> generator.writeObject(value.outputTextDone)
                value.webSearchCallCompleted != null ->
                    generator.writeObject(value.webSearchCallCompleted)
                value.webSearchCallInProgress != null ->
                    generator.writeObject(value.webSearchCallInProgress)
                value.webSearchCallSearching != null ->
                    generator.writeObject(value.webSearchCallSearching)
                value.imageGenerationCallCompleted != null ->
                    generator.writeObject(value.imageGenerationCallCompleted)
                value.imageGenerationCallGenerating != null ->
                    generator.writeObject(value.imageGenerationCallGenerating)
                value.imageGenerationCallInProgress != null ->
                    generator.writeObject(value.imageGenerationCallInProgress)
                value.imageGenerationCallPartialImage != null ->
                    generator.writeObject(value.imageGenerationCallPartialImage)
                value.mcpCallArgumentsDelta != null ->
                    generator.writeObject(value.mcpCallArgumentsDelta)
                value.mcpCallArgumentsDone != null ->
                    generator.writeObject(value.mcpCallArgumentsDone)
                value.mcpCallCompleted != null -> generator.writeObject(value.mcpCallCompleted)
                value.mcpCallFailed != null -> generator.writeObject(value.mcpCallFailed)
                value.mcpCallInProgress != null -> generator.writeObject(value.mcpCallInProgress)
                value.mcpListToolsCompleted != null ->
                    generator.writeObject(value.mcpListToolsCompleted)
                value.mcpListToolsFailed != null -> generator.writeObject(value.mcpListToolsFailed)
                value.mcpListToolsInProgress != null ->
                    generator.writeObject(value.mcpListToolsInProgress)
                value.outputTextAnnotationAdded != null ->
                    generator.writeObject(value.outputTextAnnotationAdded)
                value.queued != null -> generator.writeObject(value.queued)
                value.customToolCallInputDelta != null ->
                    generator.writeObject(value.customToolCallInputDelta)
                value.customToolCallInputDone != null ->
                    generator.writeObject(value.customToolCallInputDone)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseStreamEvent")
            }
        }
    }
}
