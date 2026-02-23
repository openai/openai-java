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

/** Server events emitted by the Responses WebSocket server. */
@JsonDeserialize(using = ResponsesServerEvent.Deserializer::class)
@JsonSerialize(using = ResponsesServerEvent.Serializer::class)
class ResponsesServerEvent
private constructor(
    private val responseAudioDelta: ResponseAudioDeltaEvent? = null,
    private val responseAudioDone: ResponseAudioDoneEvent? = null,
    private val responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent? = null,
    private val responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent? = null,
    private val responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent? =
        null,
    private val responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent? =
        null,
    private val responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent? =
        null,
    private val responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent? =
        null,
    private val responseCodeInterpreterCallInterpreting:
        ResponseCodeInterpreterCallInterpretingEvent? =
        null,
    private val responseCompleted: ResponseCompletedEvent? = null,
    private val responseContentPartAdded: ResponseContentPartAddedEvent? = null,
    private val responseContentPartDone: ResponseContentPartDoneEvent? = null,
    private val responseCreated: ResponseCreatedEvent? = null,
    private val error: ResponseErrorEvent? = null,
    private val responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent? = null,
    private val responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent? = null,
    private val responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent? = null,
    private val responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent? = null,
    private val responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent? = null,
    private val responseInProgress: ResponseInProgressEvent? = null,
    private val responseFailed: ResponseFailedEvent? = null,
    private val responseIncomplete: ResponseIncompleteEvent? = null,
    private val responseOutputItemAdded: ResponseOutputItemAddedEvent? = null,
    private val responseOutputItemDone: ResponseOutputItemDoneEvent? = null,
    private val responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent? = null,
    private val responseReasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent? = null,
    private val responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent? = null,
    private val responseReasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent? = null,
    private val responseReasoningTextDelta: ResponseReasoningTextDeltaEvent? = null,
    private val responseReasoningTextDone: ResponseReasoningTextDoneEvent? = null,
    private val responseRefusalDelta: ResponseRefusalDeltaEvent? = null,
    private val responseRefusalDone: ResponseRefusalDoneEvent? = null,
    private val responseOutputTextDelta: ResponseTextDeltaEvent? = null,
    private val responseOutputTextDone: ResponseTextDoneEvent? = null,
    private val responseWebSearchCallCompleted: ResponseWebSearchCallCompletedEvent? = null,
    private val responseWebSearchCallInProgress: ResponseWebSearchCallInProgressEvent? = null,
    private val responseWebSearchCallSearching: ResponseWebSearchCallSearchingEvent? = null,
    private val responseImageGenerationCallCompleted: ResponseImageGenCallCompletedEvent? = null,
    private val responseImageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent? = null,
    private val responseImageGenerationCallInProgress: ResponseImageGenCallInProgressEvent? = null,
    private val responseImageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent? =
        null,
    private val responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent? = null,
    private val responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent? = null,
    private val responseMcpCallCompleted: ResponseMcpCallCompletedEvent? = null,
    private val responseMcpCallFailed: ResponseMcpCallFailedEvent? = null,
    private val responseMcpCallInProgress: ResponseMcpCallInProgressEvent? = null,
    private val responseMcpListToolsCompleted: ResponseMcpListToolsCompletedEvent? = null,
    private val responseMcpListToolsFailed: ResponseMcpListToolsFailedEvent? = null,
    private val responseMcpListToolsInProgress: ResponseMcpListToolsInProgressEvent? = null,
    private val responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent? = null,
    private val responseQueued: ResponseQueuedEvent? = null,
    private val responseCustomToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent? = null,
    private val responseCustomToolCallInputDone: ResponseCustomToolCallInputDoneEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when there is a partial audio response. */
    fun responseAudioDelta(): Optional<ResponseAudioDeltaEvent> =
        Optional.ofNullable(responseAudioDelta)

    /** Emitted when the audio response is complete. */
    fun responseAudioDone(): Optional<ResponseAudioDoneEvent> =
        Optional.ofNullable(responseAudioDone)

    /** Emitted when there is a partial transcript of audio. */
    fun responseAudioTranscriptDelta(): Optional<ResponseAudioTranscriptDeltaEvent> =
        Optional.ofNullable(responseAudioTranscriptDelta)

    /** Emitted when the full audio transcript is completed. */
    fun responseAudioTranscriptDone(): Optional<ResponseAudioTranscriptDoneEvent> =
        Optional.ofNullable(responseAudioTranscriptDone)

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun responseCodeInterpreterCallCodeDelta():
        Optional<ResponseCodeInterpreterCallCodeDeltaEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDelta)

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun responseCodeInterpreterCallCodeDone(): Optional<ResponseCodeInterpreterCallCodeDoneEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDone)

    /** Emitted when the code interpreter call is completed. */
    fun responseCodeInterpreterCallCompleted():
        Optional<ResponseCodeInterpreterCallCompletedEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCompleted)

    /** Emitted when a code interpreter call is in progress. */
    fun responseCodeInterpreterCallInProgress():
        Optional<ResponseCodeInterpreterCallInProgressEvent> =
        Optional.ofNullable(responseCodeInterpreterCallInProgress)

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun responseCodeInterpreterCallInterpreting():
        Optional<ResponseCodeInterpreterCallInterpretingEvent> =
        Optional.ofNullable(responseCodeInterpreterCallInterpreting)

    /** Emitted when the model response is complete. */
    fun responseCompleted(): Optional<ResponseCompletedEvent> =
        Optional.ofNullable(responseCompleted)

    /** Emitted when a new content part is added. */
    fun responseContentPartAdded(): Optional<ResponseContentPartAddedEvent> =
        Optional.ofNullable(responseContentPartAdded)

    /** Emitted when a content part is done. */
    fun responseContentPartDone(): Optional<ResponseContentPartDoneEvent> =
        Optional.ofNullable(responseContentPartDone)

    /** An event that is emitted when a response is created. */
    fun responseCreated(): Optional<ResponseCreatedEvent> = Optional.ofNullable(responseCreated)

    /** Emitted when an error occurs. */
    fun error(): Optional<ResponseErrorEvent> = Optional.ofNullable(error)

    /** Emitted when a file search call is completed (results found). */
    fun responseFileSearchCallCompleted(): Optional<ResponseFileSearchCallCompletedEvent> =
        Optional.ofNullable(responseFileSearchCallCompleted)

    /** Emitted when a file search call is initiated. */
    fun responseFileSearchCallInProgress(): Optional<ResponseFileSearchCallInProgressEvent> =
        Optional.ofNullable(responseFileSearchCallInProgress)

    /** Emitted when a file search is currently searching. */
    fun responseFileSearchCallSearching(): Optional<ResponseFileSearchCallSearchingEvent> =
        Optional.ofNullable(responseFileSearchCallSearching)

    /** Emitted when there is a partial function-call arguments delta. */
    fun responseFunctionCallArgumentsDelta(): Optional<ResponseFunctionCallArgumentsDeltaEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDelta)

    /** Emitted when function-call arguments are finalized. */
    fun responseFunctionCallArgumentsDone(): Optional<ResponseFunctionCallArgumentsDoneEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDone)

    /** Emitted when the response is in progress. */
    fun responseInProgress(): Optional<ResponseInProgressEvent> =
        Optional.ofNullable(responseInProgress)

    /** An event that is emitted when a response fails. */
    fun responseFailed(): Optional<ResponseFailedEvent> = Optional.ofNullable(responseFailed)

    /** An event that is emitted when a response finishes as incomplete. */
    fun responseIncomplete(): Optional<ResponseIncompleteEvent> =
        Optional.ofNullable(responseIncomplete)

    /** Emitted when a new output item is added. */
    fun responseOutputItemAdded(): Optional<ResponseOutputItemAddedEvent> =
        Optional.ofNullable(responseOutputItemAdded)

    /** Emitted when an output item is marked done. */
    fun responseOutputItemDone(): Optional<ResponseOutputItemDoneEvent> =
        Optional.ofNullable(responseOutputItemDone)

    /** Emitted when a new reasoning summary part is added. */
    fun responseReasoningSummaryPartAdded(): Optional<ResponseReasoningSummaryPartAddedEvent> =
        Optional.ofNullable(responseReasoningSummaryPartAdded)

    /** Emitted when a reasoning summary part is completed. */
    fun responseReasoningSummaryPartDone(): Optional<ResponseReasoningSummaryPartDoneEvent> =
        Optional.ofNullable(responseReasoningSummaryPartDone)

    /** Emitted when a delta is added to a reasoning summary text. */
    fun responseReasoningSummaryTextDelta(): Optional<ResponseReasoningSummaryTextDeltaEvent> =
        Optional.ofNullable(responseReasoningSummaryTextDelta)

    /** Emitted when a reasoning summary text is completed. */
    fun responseReasoningSummaryTextDone(): Optional<ResponseReasoningSummaryTextDoneEvent> =
        Optional.ofNullable(responseReasoningSummaryTextDone)

    /** Emitted when a delta is added to a reasoning text. */
    fun responseReasoningTextDelta(): Optional<ResponseReasoningTextDeltaEvent> =
        Optional.ofNullable(responseReasoningTextDelta)

    /** Emitted when a reasoning text is completed. */
    fun responseReasoningTextDone(): Optional<ResponseReasoningTextDoneEvent> =
        Optional.ofNullable(responseReasoningTextDone)

    /** Emitted when there is a partial refusal text. */
    fun responseRefusalDelta(): Optional<ResponseRefusalDeltaEvent> =
        Optional.ofNullable(responseRefusalDelta)

    /** Emitted when refusal text is finalized. */
    fun responseRefusalDone(): Optional<ResponseRefusalDoneEvent> =
        Optional.ofNullable(responseRefusalDone)

    /** Emitted when there is an additional text delta. */
    fun responseOutputTextDelta(): Optional<ResponseTextDeltaEvent> =
        Optional.ofNullable(responseOutputTextDelta)

    /** Emitted when text content is finalized. */
    fun responseOutputTextDone(): Optional<ResponseTextDoneEvent> =
        Optional.ofNullable(responseOutputTextDone)

    /** Emitted when a web search call is completed. */
    fun responseWebSearchCallCompleted(): Optional<ResponseWebSearchCallCompletedEvent> =
        Optional.ofNullable(responseWebSearchCallCompleted)

    /** Emitted when a web search call is initiated. */
    fun responseWebSearchCallInProgress(): Optional<ResponseWebSearchCallInProgressEvent> =
        Optional.ofNullable(responseWebSearchCallInProgress)

    /** Emitted when a web search call is executing. */
    fun responseWebSearchCallSearching(): Optional<ResponseWebSearchCallSearchingEvent> =
        Optional.ofNullable(responseWebSearchCallSearching)

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun responseImageGenerationCallCompleted(): Optional<ResponseImageGenCallCompletedEvent> =
        Optional.ofNullable(responseImageGenerationCallCompleted)

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun responseImageGenerationCallGenerating(): Optional<ResponseImageGenCallGeneratingEvent> =
        Optional.ofNullable(responseImageGenerationCallGenerating)

    /** Emitted when an image generation tool call is in progress. */
    fun responseImageGenerationCallInProgress(): Optional<ResponseImageGenCallInProgressEvent> =
        Optional.ofNullable(responseImageGenerationCallInProgress)

    /** Emitted when a partial image is available during image generation streaming. */
    fun responseImageGenerationCallPartialImage(): Optional<ResponseImageGenCallPartialImageEvent> =
        Optional.ofNullable(responseImageGenerationCallPartialImage)

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun responseMcpCallArgumentsDelta(): Optional<ResponseMcpCallArgumentsDeltaEvent> =
        Optional.ofNullable(responseMcpCallArgumentsDelta)

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun responseMcpCallArgumentsDone(): Optional<ResponseMcpCallArgumentsDoneEvent> =
        Optional.ofNullable(responseMcpCallArgumentsDone)

    /** Emitted when an MCP tool call has completed successfully. */
    fun responseMcpCallCompleted(): Optional<ResponseMcpCallCompletedEvent> =
        Optional.ofNullable(responseMcpCallCompleted)

    /** Emitted when an MCP tool call has failed. */
    fun responseMcpCallFailed(): Optional<ResponseMcpCallFailedEvent> =
        Optional.ofNullable(responseMcpCallFailed)

    /** Emitted when an MCP tool call is in progress. */
    fun responseMcpCallInProgress(): Optional<ResponseMcpCallInProgressEvent> =
        Optional.ofNullable(responseMcpCallInProgress)

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun responseMcpListToolsCompleted(): Optional<ResponseMcpListToolsCompletedEvent> =
        Optional.ofNullable(responseMcpListToolsCompleted)

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun responseMcpListToolsFailed(): Optional<ResponseMcpListToolsFailedEvent> =
        Optional.ofNullable(responseMcpListToolsFailed)

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun responseMcpListToolsInProgress(): Optional<ResponseMcpListToolsInProgressEvent> =
        Optional.ofNullable(responseMcpListToolsInProgress)

    /** Emitted when an annotation is added to output text content. */
    fun responseOutputTextAnnotationAdded(): Optional<ResponseOutputTextAnnotationAddedEvent> =
        Optional.ofNullable(responseOutputTextAnnotationAdded)

    /** Emitted when a response is queued and waiting to be processed. */
    fun responseQueued(): Optional<ResponseQueuedEvent> = Optional.ofNullable(responseQueued)

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun responseCustomToolCallInputDelta(): Optional<ResponseCustomToolCallInputDeltaEvent> =
        Optional.ofNullable(responseCustomToolCallInputDelta)

    /** Event indicating that input for a custom tool call is complete. */
    fun responseCustomToolCallInputDone(): Optional<ResponseCustomToolCallInputDoneEvent> =
        Optional.ofNullable(responseCustomToolCallInputDone)

    fun isResponseAudioDelta(): Boolean = responseAudioDelta != null

    fun isResponseAudioDone(): Boolean = responseAudioDone != null

    fun isResponseAudioTranscriptDelta(): Boolean = responseAudioTranscriptDelta != null

    fun isResponseAudioTranscriptDone(): Boolean = responseAudioTranscriptDone != null

    fun isResponseCodeInterpreterCallCodeDelta(): Boolean =
        responseCodeInterpreterCallCodeDelta != null

    fun isResponseCodeInterpreterCallCodeDone(): Boolean =
        responseCodeInterpreterCallCodeDone != null

    fun isResponseCodeInterpreterCallCompleted(): Boolean =
        responseCodeInterpreterCallCompleted != null

    fun isResponseCodeInterpreterCallInProgress(): Boolean =
        responseCodeInterpreterCallInProgress != null

    fun isResponseCodeInterpreterCallInterpreting(): Boolean =
        responseCodeInterpreterCallInterpreting != null

    fun isResponseCompleted(): Boolean = responseCompleted != null

    fun isResponseContentPartAdded(): Boolean = responseContentPartAdded != null

    fun isResponseContentPartDone(): Boolean = responseContentPartDone != null

    fun isResponseCreated(): Boolean = responseCreated != null

    fun isError(): Boolean = error != null

    fun isResponseFileSearchCallCompleted(): Boolean = responseFileSearchCallCompleted != null

    fun isResponseFileSearchCallInProgress(): Boolean = responseFileSearchCallInProgress != null

    fun isResponseFileSearchCallSearching(): Boolean = responseFileSearchCallSearching != null

    fun isResponseFunctionCallArgumentsDelta(): Boolean = responseFunctionCallArgumentsDelta != null

    fun isResponseFunctionCallArgumentsDone(): Boolean = responseFunctionCallArgumentsDone != null

    fun isResponseInProgress(): Boolean = responseInProgress != null

    fun isResponseFailed(): Boolean = responseFailed != null

    fun isResponseIncomplete(): Boolean = responseIncomplete != null

    fun isResponseOutputItemAdded(): Boolean = responseOutputItemAdded != null

    fun isResponseOutputItemDone(): Boolean = responseOutputItemDone != null

    fun isResponseReasoningSummaryPartAdded(): Boolean = responseReasoningSummaryPartAdded != null

    fun isResponseReasoningSummaryPartDone(): Boolean = responseReasoningSummaryPartDone != null

    fun isResponseReasoningSummaryTextDelta(): Boolean = responseReasoningSummaryTextDelta != null

    fun isResponseReasoningSummaryTextDone(): Boolean = responseReasoningSummaryTextDone != null

    fun isResponseReasoningTextDelta(): Boolean = responseReasoningTextDelta != null

    fun isResponseReasoningTextDone(): Boolean = responseReasoningTextDone != null

    fun isResponseRefusalDelta(): Boolean = responseRefusalDelta != null

    fun isResponseRefusalDone(): Boolean = responseRefusalDone != null

    fun isResponseOutputTextDelta(): Boolean = responseOutputTextDelta != null

    fun isResponseOutputTextDone(): Boolean = responseOutputTextDone != null

    fun isResponseWebSearchCallCompleted(): Boolean = responseWebSearchCallCompleted != null

    fun isResponseWebSearchCallInProgress(): Boolean = responseWebSearchCallInProgress != null

    fun isResponseWebSearchCallSearching(): Boolean = responseWebSearchCallSearching != null

    fun isResponseImageGenerationCallCompleted(): Boolean =
        responseImageGenerationCallCompleted != null

    fun isResponseImageGenerationCallGenerating(): Boolean =
        responseImageGenerationCallGenerating != null

    fun isResponseImageGenerationCallInProgress(): Boolean =
        responseImageGenerationCallInProgress != null

    fun isResponseImageGenerationCallPartialImage(): Boolean =
        responseImageGenerationCallPartialImage != null

    fun isResponseMcpCallArgumentsDelta(): Boolean = responseMcpCallArgumentsDelta != null

    fun isResponseMcpCallArgumentsDone(): Boolean = responseMcpCallArgumentsDone != null

    fun isResponseMcpCallCompleted(): Boolean = responseMcpCallCompleted != null

    fun isResponseMcpCallFailed(): Boolean = responseMcpCallFailed != null

    fun isResponseMcpCallInProgress(): Boolean = responseMcpCallInProgress != null

    fun isResponseMcpListToolsCompleted(): Boolean = responseMcpListToolsCompleted != null

    fun isResponseMcpListToolsFailed(): Boolean = responseMcpListToolsFailed != null

    fun isResponseMcpListToolsInProgress(): Boolean = responseMcpListToolsInProgress != null

    fun isResponseOutputTextAnnotationAdded(): Boolean = responseOutputTextAnnotationAdded != null

    fun isResponseQueued(): Boolean = responseQueued != null

    fun isResponseCustomToolCallInputDelta(): Boolean = responseCustomToolCallInputDelta != null

    fun isResponseCustomToolCallInputDone(): Boolean = responseCustomToolCallInputDone != null

    /** Emitted when there is a partial audio response. */
    fun asResponseAudioDelta(): ResponseAudioDeltaEvent =
        responseAudioDelta.getOrThrow("responseAudioDelta")

    /** Emitted when the audio response is complete. */
    fun asResponseAudioDone(): ResponseAudioDoneEvent =
        responseAudioDone.getOrThrow("responseAudioDone")

    /** Emitted when there is a partial transcript of audio. */
    fun asResponseAudioTranscriptDelta(): ResponseAudioTranscriptDeltaEvent =
        responseAudioTranscriptDelta.getOrThrow("responseAudioTranscriptDelta")

    /** Emitted when the full audio transcript is completed. */
    fun asResponseAudioTranscriptDone(): ResponseAudioTranscriptDoneEvent =
        responseAudioTranscriptDone.getOrThrow("responseAudioTranscriptDone")

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDelta(): ResponseCodeInterpreterCallCodeDeltaEvent =
        responseCodeInterpreterCallCodeDelta.getOrThrow("responseCodeInterpreterCallCodeDelta")

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDone(): ResponseCodeInterpreterCallCodeDoneEvent =
        responseCodeInterpreterCallCodeDone.getOrThrow("responseCodeInterpreterCallCodeDone")

    /** Emitted when the code interpreter call is completed. */
    fun asResponseCodeInterpreterCallCompleted(): ResponseCodeInterpreterCallCompletedEvent =
        responseCodeInterpreterCallCompleted.getOrThrow("responseCodeInterpreterCallCompleted")

    /** Emitted when a code interpreter call is in progress. */
    fun asResponseCodeInterpreterCallInProgress(): ResponseCodeInterpreterCallInProgressEvent =
        responseCodeInterpreterCallInProgress.getOrThrow("responseCodeInterpreterCallInProgress")

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun asResponseCodeInterpreterCallInterpreting(): ResponseCodeInterpreterCallInterpretingEvent =
        responseCodeInterpreterCallInterpreting.getOrThrow(
            "responseCodeInterpreterCallInterpreting"
        )

    /** Emitted when the model response is complete. */
    fun asResponseCompleted(): ResponseCompletedEvent =
        responseCompleted.getOrThrow("responseCompleted")

    /** Emitted when a new content part is added. */
    fun asResponseContentPartAdded(): ResponseContentPartAddedEvent =
        responseContentPartAdded.getOrThrow("responseContentPartAdded")

    /** Emitted when a content part is done. */
    fun asResponseContentPartDone(): ResponseContentPartDoneEvent =
        responseContentPartDone.getOrThrow("responseContentPartDone")

    /** An event that is emitted when a response is created. */
    fun asResponseCreated(): ResponseCreatedEvent = responseCreated.getOrThrow("responseCreated")

    /** Emitted when an error occurs. */
    fun asError(): ResponseErrorEvent = error.getOrThrow("error")

    /** Emitted when a file search call is completed (results found). */
    fun asResponseFileSearchCallCompleted(): ResponseFileSearchCallCompletedEvent =
        responseFileSearchCallCompleted.getOrThrow("responseFileSearchCallCompleted")

    /** Emitted when a file search call is initiated. */
    fun asResponseFileSearchCallInProgress(): ResponseFileSearchCallInProgressEvent =
        responseFileSearchCallInProgress.getOrThrow("responseFileSearchCallInProgress")

    /** Emitted when a file search is currently searching. */
    fun asResponseFileSearchCallSearching(): ResponseFileSearchCallSearchingEvent =
        responseFileSearchCallSearching.getOrThrow("responseFileSearchCallSearching")

    /** Emitted when there is a partial function-call arguments delta. */
    fun asResponseFunctionCallArgumentsDelta(): ResponseFunctionCallArgumentsDeltaEvent =
        responseFunctionCallArgumentsDelta.getOrThrow("responseFunctionCallArgumentsDelta")

    /** Emitted when function-call arguments are finalized. */
    fun asResponseFunctionCallArgumentsDone(): ResponseFunctionCallArgumentsDoneEvent =
        responseFunctionCallArgumentsDone.getOrThrow("responseFunctionCallArgumentsDone")

    /** Emitted when the response is in progress. */
    fun asResponseInProgress(): ResponseInProgressEvent =
        responseInProgress.getOrThrow("responseInProgress")

    /** An event that is emitted when a response fails. */
    fun asResponseFailed(): ResponseFailedEvent = responseFailed.getOrThrow("responseFailed")

    /** An event that is emitted when a response finishes as incomplete. */
    fun asResponseIncomplete(): ResponseIncompleteEvent =
        responseIncomplete.getOrThrow("responseIncomplete")

    /** Emitted when a new output item is added. */
    fun asResponseOutputItemAdded(): ResponseOutputItemAddedEvent =
        responseOutputItemAdded.getOrThrow("responseOutputItemAdded")

    /** Emitted when an output item is marked done. */
    fun asResponseOutputItemDone(): ResponseOutputItemDoneEvent =
        responseOutputItemDone.getOrThrow("responseOutputItemDone")

    /** Emitted when a new reasoning summary part is added. */
    fun asResponseReasoningSummaryPartAdded(): ResponseReasoningSummaryPartAddedEvent =
        responseReasoningSummaryPartAdded.getOrThrow("responseReasoningSummaryPartAdded")

    /** Emitted when a reasoning summary part is completed. */
    fun asResponseReasoningSummaryPartDone(): ResponseReasoningSummaryPartDoneEvent =
        responseReasoningSummaryPartDone.getOrThrow("responseReasoningSummaryPartDone")

    /** Emitted when a delta is added to a reasoning summary text. */
    fun asResponseReasoningSummaryTextDelta(): ResponseReasoningSummaryTextDeltaEvent =
        responseReasoningSummaryTextDelta.getOrThrow("responseReasoningSummaryTextDelta")

    /** Emitted when a reasoning summary text is completed. */
    fun asResponseReasoningSummaryTextDone(): ResponseReasoningSummaryTextDoneEvent =
        responseReasoningSummaryTextDone.getOrThrow("responseReasoningSummaryTextDone")

    /** Emitted when a delta is added to a reasoning text. */
    fun asResponseReasoningTextDelta(): ResponseReasoningTextDeltaEvent =
        responseReasoningTextDelta.getOrThrow("responseReasoningTextDelta")

    /** Emitted when a reasoning text is completed. */
    fun asResponseReasoningTextDone(): ResponseReasoningTextDoneEvent =
        responseReasoningTextDone.getOrThrow("responseReasoningTextDone")

    /** Emitted when there is a partial refusal text. */
    fun asResponseRefusalDelta(): ResponseRefusalDeltaEvent =
        responseRefusalDelta.getOrThrow("responseRefusalDelta")

    /** Emitted when refusal text is finalized. */
    fun asResponseRefusalDone(): ResponseRefusalDoneEvent =
        responseRefusalDone.getOrThrow("responseRefusalDone")

    /** Emitted when there is an additional text delta. */
    fun asResponseOutputTextDelta(): ResponseTextDeltaEvent =
        responseOutputTextDelta.getOrThrow("responseOutputTextDelta")

    /** Emitted when text content is finalized. */
    fun asResponseOutputTextDone(): ResponseTextDoneEvent =
        responseOutputTextDone.getOrThrow("responseOutputTextDone")

    /** Emitted when a web search call is completed. */
    fun asResponseWebSearchCallCompleted(): ResponseWebSearchCallCompletedEvent =
        responseWebSearchCallCompleted.getOrThrow("responseWebSearchCallCompleted")

    /** Emitted when a web search call is initiated. */
    fun asResponseWebSearchCallInProgress(): ResponseWebSearchCallInProgressEvent =
        responseWebSearchCallInProgress.getOrThrow("responseWebSearchCallInProgress")

    /** Emitted when a web search call is executing. */
    fun asResponseWebSearchCallSearching(): ResponseWebSearchCallSearchingEvent =
        responseWebSearchCallSearching.getOrThrow("responseWebSearchCallSearching")

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun asResponseImageGenerationCallCompleted(): ResponseImageGenCallCompletedEvent =
        responseImageGenerationCallCompleted.getOrThrow("responseImageGenerationCallCompleted")

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun asResponseImageGenerationCallGenerating(): ResponseImageGenCallGeneratingEvent =
        responseImageGenerationCallGenerating.getOrThrow("responseImageGenerationCallGenerating")

    /** Emitted when an image generation tool call is in progress. */
    fun asResponseImageGenerationCallInProgress(): ResponseImageGenCallInProgressEvent =
        responseImageGenerationCallInProgress.getOrThrow("responseImageGenerationCallInProgress")

    /** Emitted when a partial image is available during image generation streaming. */
    fun asResponseImageGenerationCallPartialImage(): ResponseImageGenCallPartialImageEvent =
        responseImageGenerationCallPartialImage.getOrThrow(
            "responseImageGenerationCallPartialImage"
        )

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun asResponseMcpCallArgumentsDelta(): ResponseMcpCallArgumentsDeltaEvent =
        responseMcpCallArgumentsDelta.getOrThrow("responseMcpCallArgumentsDelta")

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun asResponseMcpCallArgumentsDone(): ResponseMcpCallArgumentsDoneEvent =
        responseMcpCallArgumentsDone.getOrThrow("responseMcpCallArgumentsDone")

    /** Emitted when an MCP tool call has completed successfully. */
    fun asResponseMcpCallCompleted(): ResponseMcpCallCompletedEvent =
        responseMcpCallCompleted.getOrThrow("responseMcpCallCompleted")

    /** Emitted when an MCP tool call has failed. */
    fun asResponseMcpCallFailed(): ResponseMcpCallFailedEvent =
        responseMcpCallFailed.getOrThrow("responseMcpCallFailed")

    /** Emitted when an MCP tool call is in progress. */
    fun asResponseMcpCallInProgress(): ResponseMcpCallInProgressEvent =
        responseMcpCallInProgress.getOrThrow("responseMcpCallInProgress")

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun asResponseMcpListToolsCompleted(): ResponseMcpListToolsCompletedEvent =
        responseMcpListToolsCompleted.getOrThrow("responseMcpListToolsCompleted")

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun asResponseMcpListToolsFailed(): ResponseMcpListToolsFailedEvent =
        responseMcpListToolsFailed.getOrThrow("responseMcpListToolsFailed")

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun asResponseMcpListToolsInProgress(): ResponseMcpListToolsInProgressEvent =
        responseMcpListToolsInProgress.getOrThrow("responseMcpListToolsInProgress")

    /** Emitted when an annotation is added to output text content. */
    fun asResponseOutputTextAnnotationAdded(): ResponseOutputTextAnnotationAddedEvent =
        responseOutputTextAnnotationAdded.getOrThrow("responseOutputTextAnnotationAdded")

    /** Emitted when a response is queued and waiting to be processed. */
    fun asResponseQueued(): ResponseQueuedEvent = responseQueued.getOrThrow("responseQueued")

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun asResponseCustomToolCallInputDelta(): ResponseCustomToolCallInputDeltaEvent =
        responseCustomToolCallInputDelta.getOrThrow("responseCustomToolCallInputDelta")

    /** Event indicating that input for a custom tool call is complete. */
    fun asResponseCustomToolCallInputDone(): ResponseCustomToolCallInputDoneEvent =
        responseCustomToolCallInputDone.getOrThrow("responseCustomToolCallInputDone")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            responseAudioDelta != null -> visitor.visitResponseAudioDelta(responseAudioDelta)
            responseAudioDone != null -> visitor.visitResponseAudioDone(responseAudioDone)
            responseAudioTranscriptDelta != null ->
                visitor.visitResponseAudioTranscriptDelta(responseAudioTranscriptDelta)
            responseAudioTranscriptDone != null ->
                visitor.visitResponseAudioTranscriptDone(responseAudioTranscriptDone)
            responseCodeInterpreterCallCodeDelta != null ->
                visitor.visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta
                )
            responseCodeInterpreterCallCodeDone != null ->
                visitor.visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone
                )
            responseCodeInterpreterCallCompleted != null ->
                visitor.visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted
                )
            responseCodeInterpreterCallInProgress != null ->
                visitor.visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress
                )
            responseCodeInterpreterCallInterpreting != null ->
                visitor.visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting
                )
            responseCompleted != null -> visitor.visitResponseCompleted(responseCompleted)
            responseContentPartAdded != null ->
                visitor.visitResponseContentPartAdded(responseContentPartAdded)
            responseContentPartDone != null ->
                visitor.visitResponseContentPartDone(responseContentPartDone)
            responseCreated != null -> visitor.visitResponseCreated(responseCreated)
            error != null -> visitor.visitError(error)
            responseFileSearchCallCompleted != null ->
                visitor.visitResponseFileSearchCallCompleted(responseFileSearchCallCompleted)
            responseFileSearchCallInProgress != null ->
                visitor.visitResponseFileSearchCallInProgress(responseFileSearchCallInProgress)
            responseFileSearchCallSearching != null ->
                visitor.visitResponseFileSearchCallSearching(responseFileSearchCallSearching)
            responseFunctionCallArgumentsDelta != null ->
                visitor.visitResponseFunctionCallArgumentsDelta(responseFunctionCallArgumentsDelta)
            responseFunctionCallArgumentsDone != null ->
                visitor.visitResponseFunctionCallArgumentsDone(responseFunctionCallArgumentsDone)
            responseInProgress != null -> visitor.visitResponseInProgress(responseInProgress)
            responseFailed != null -> visitor.visitResponseFailed(responseFailed)
            responseIncomplete != null -> visitor.visitResponseIncomplete(responseIncomplete)
            responseOutputItemAdded != null ->
                visitor.visitResponseOutputItemAdded(responseOutputItemAdded)
            responseOutputItemDone != null ->
                visitor.visitResponseOutputItemDone(responseOutputItemDone)
            responseReasoningSummaryPartAdded != null ->
                visitor.visitResponseReasoningSummaryPartAdded(responseReasoningSummaryPartAdded)
            responseReasoningSummaryPartDone != null ->
                visitor.visitResponseReasoningSummaryPartDone(responseReasoningSummaryPartDone)
            responseReasoningSummaryTextDelta != null ->
                visitor.visitResponseReasoningSummaryTextDelta(responseReasoningSummaryTextDelta)
            responseReasoningSummaryTextDone != null ->
                visitor.visitResponseReasoningSummaryTextDone(responseReasoningSummaryTextDone)
            responseReasoningTextDelta != null ->
                visitor.visitResponseReasoningTextDelta(responseReasoningTextDelta)
            responseReasoningTextDone != null ->
                visitor.visitResponseReasoningTextDone(responseReasoningTextDone)
            responseRefusalDelta != null -> visitor.visitResponseRefusalDelta(responseRefusalDelta)
            responseRefusalDone != null -> visitor.visitResponseRefusalDone(responseRefusalDone)
            responseOutputTextDelta != null ->
                visitor.visitResponseOutputTextDelta(responseOutputTextDelta)
            responseOutputTextDone != null ->
                visitor.visitResponseOutputTextDone(responseOutputTextDone)
            responseWebSearchCallCompleted != null ->
                visitor.visitResponseWebSearchCallCompleted(responseWebSearchCallCompleted)
            responseWebSearchCallInProgress != null ->
                visitor.visitResponseWebSearchCallInProgress(responseWebSearchCallInProgress)
            responseWebSearchCallSearching != null ->
                visitor.visitResponseWebSearchCallSearching(responseWebSearchCallSearching)
            responseImageGenerationCallCompleted != null ->
                visitor.visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted
                )
            responseImageGenerationCallGenerating != null ->
                visitor.visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating
                )
            responseImageGenerationCallInProgress != null ->
                visitor.visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress
                )
            responseImageGenerationCallPartialImage != null ->
                visitor.visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage
                )
            responseMcpCallArgumentsDelta != null ->
                visitor.visitResponseMcpCallArgumentsDelta(responseMcpCallArgumentsDelta)
            responseMcpCallArgumentsDone != null ->
                visitor.visitResponseMcpCallArgumentsDone(responseMcpCallArgumentsDone)
            responseMcpCallCompleted != null ->
                visitor.visitResponseMcpCallCompleted(responseMcpCallCompleted)
            responseMcpCallFailed != null ->
                visitor.visitResponseMcpCallFailed(responseMcpCallFailed)
            responseMcpCallInProgress != null ->
                visitor.visitResponseMcpCallInProgress(responseMcpCallInProgress)
            responseMcpListToolsCompleted != null ->
                visitor.visitResponseMcpListToolsCompleted(responseMcpListToolsCompleted)
            responseMcpListToolsFailed != null ->
                visitor.visitResponseMcpListToolsFailed(responseMcpListToolsFailed)
            responseMcpListToolsInProgress != null ->
                visitor.visitResponseMcpListToolsInProgress(responseMcpListToolsInProgress)
            responseOutputTextAnnotationAdded != null ->
                visitor.visitResponseOutputTextAnnotationAdded(responseOutputTextAnnotationAdded)
            responseQueued != null -> visitor.visitResponseQueued(responseQueued)
            responseCustomToolCallInputDelta != null ->
                visitor.visitResponseCustomToolCallInputDelta(responseCustomToolCallInputDelta)
            responseCustomToolCallInputDone != null ->
                visitor.visitResponseCustomToolCallInputDone(responseCustomToolCallInputDone)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponsesServerEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) {
                    responseAudioDelta.validate()
                }

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) {
                    responseAudioDone.validate()
                }

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) {
                    responseAudioTranscriptDelta.validate()
                }

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) {
                    responseAudioTranscriptDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
                ) {
                    responseCodeInterpreterCallCodeDelta.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
                ) {
                    responseCodeInterpreterCallCodeDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) {
                    responseCodeInterpreterCallCompleted.validate()
                }

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress:
                        ResponseCodeInterpreterCallInProgressEvent
                ) {
                    responseCodeInterpreterCallInProgress.validate()
                }

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        ResponseCodeInterpreterCallInterpretingEvent
                ) {
                    responseCodeInterpreterCallInterpreting.validate()
                }

                override fun visitResponseCompleted(responseCompleted: ResponseCompletedEvent) {
                    responseCompleted.validate()
                }

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartAddedEvent
                ) {
                    responseContentPartAdded.validate()
                }

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartDoneEvent
                ) {
                    responseContentPartDone.validate()
                }

                override fun visitResponseCreated(responseCreated: ResponseCreatedEvent) {
                    responseCreated.validate()
                }

                override fun visitError(error: ResponseErrorEvent) {
                    error.validate()
                }

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) {
                    responseFileSearchCallCompleted.validate()
                }

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) {
                    responseFileSearchCallInProgress.validate()
                }

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) {
                    responseFileSearchCallSearching.validate()
                }

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) {
                    responseFunctionCallArgumentsDelta.validate()
                }

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {
                    responseFunctionCallArgumentsDone.validate()
                }

                override fun visitResponseInProgress(responseInProgress: ResponseInProgressEvent) {
                    responseInProgress.validate()
                }

                override fun visitResponseFailed(responseFailed: ResponseFailedEvent) {
                    responseFailed.validate()
                }

                override fun visitResponseIncomplete(responseIncomplete: ResponseIncompleteEvent) {
                    responseIncomplete.validate()
                }

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemAddedEvent
                ) {
                    responseOutputItemAdded.validate()
                }

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemDoneEvent
                ) {
                    responseOutputItemDone.validate()
                }

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
                ) {
                    responseReasoningSummaryPartAdded.validate()
                }

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
                ) {
                    responseReasoningSummaryPartDone.validate()
                }

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
                ) {
                    responseReasoningSummaryTextDelta.validate()
                }

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
                ) {
                    responseReasoningSummaryTextDone.validate()
                }

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: ResponseReasoningTextDeltaEvent
                ) {
                    responseReasoningTextDelta.validate()
                }

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: ResponseReasoningTextDoneEvent
                ) {
                    responseReasoningTextDone.validate()
                }

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: ResponseRefusalDeltaEvent
                ) {
                    responseRefusalDelta.validate()
                }

                override fun visitResponseRefusalDone(
                    responseRefusalDone: ResponseRefusalDoneEvent
                ) {
                    responseRefusalDone.validate()
                }

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextDeltaEvent
                ) {
                    responseOutputTextDelta.validate()
                }

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextDoneEvent
                ) {
                    responseOutputTextDone.validate()
                }

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) {
                    responseWebSearchCallCompleted.validate()
                }

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) {
                    responseWebSearchCallInProgress.validate()
                }

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) {
                    responseWebSearchCallSearching.validate()
                }

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
                ) {
                    responseImageGenerationCallCompleted.validate()
                }

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
                ) {
                    responseImageGenerationCallGenerating.validate()
                }

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
                ) {
                    responseImageGenerationCallInProgress.validate()
                }

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
                ) {
                    responseImageGenerationCallPartialImage.validate()
                }

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
                ) {
                    responseMcpCallArgumentsDelta.validate()
                }

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
                ) {
                    responseMcpCallArgumentsDone.validate()
                }

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallCompletedEvent
                ) {
                    responseMcpCallCompleted.validate()
                }

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallFailedEvent
                ) {
                    responseMcpCallFailed.validate()
                }

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInProgressEvent
                ) {
                    responseMcpCallInProgress.validate()
                }

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
                ) {
                    responseMcpListToolsCompleted.validate()
                }

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: ResponseMcpListToolsFailedEvent
                ) {
                    responseMcpListToolsFailed.validate()
                }

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
                ) {
                    responseMcpListToolsInProgress.validate()
                }

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
                ) {
                    responseOutputTextAnnotationAdded.validate()
                }

                override fun visitResponseQueued(responseQueued: ResponseQueuedEvent) {
                    responseQueued.validate()
                }

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
                ) {
                    responseCustomToolCallInputDelta.validate()
                }

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) {
                    responseCustomToolCallInputDone.validate()
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
                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) =
                    responseAudioDelta.validity()

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) =
                    responseAudioDone.validity()

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) = responseAudioTranscriptDelta.validity()

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) = responseAudioTranscriptDone.validity()

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
                ) = responseCodeInterpreterCallCodeDelta.validity()

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
                ) = responseCodeInterpreterCallCodeDone.validity()

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
                ) = responseCodeInterpreterCallCompleted.validity()

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress:
                        ResponseCodeInterpreterCallInProgressEvent
                ) = responseCodeInterpreterCallInProgress.validity()

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        ResponseCodeInterpreterCallInterpretingEvent
                ) = responseCodeInterpreterCallInterpreting.validity()

                override fun visitResponseCompleted(responseCompleted: ResponseCompletedEvent) =
                    responseCompleted.validity()

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartAddedEvent
                ) = responseContentPartAdded.validity()

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartDoneEvent
                ) = responseContentPartDone.validity()

                override fun visitResponseCreated(responseCreated: ResponseCreatedEvent) =
                    responseCreated.validity()

                override fun visitError(error: ResponseErrorEvent) = error.validity()

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
                ) = responseFileSearchCallCompleted.validity()

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
                ) = responseFileSearchCallInProgress.validity()

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent
                ) = responseFileSearchCallSearching.validity()

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) = responseFunctionCallArgumentsDelta.validity()

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) = responseFunctionCallArgumentsDone.validity()

                override fun visitResponseInProgress(responseInProgress: ResponseInProgressEvent) =
                    responseInProgress.validity()

                override fun visitResponseFailed(responseFailed: ResponseFailedEvent) =
                    responseFailed.validity()

                override fun visitResponseIncomplete(responseIncomplete: ResponseIncompleteEvent) =
                    responseIncomplete.validity()

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemAddedEvent
                ) = responseOutputItemAdded.validity()

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemDoneEvent
                ) = responseOutputItemDone.validity()

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
                ) = responseReasoningSummaryPartAdded.validity()

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
                ) = responseReasoningSummaryPartDone.validity()

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
                ) = responseReasoningSummaryTextDelta.validity()

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
                ) = responseReasoningSummaryTextDone.validity()

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: ResponseReasoningTextDeltaEvent
                ) = responseReasoningTextDelta.validity()

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: ResponseReasoningTextDoneEvent
                ) = responseReasoningTextDone.validity()

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: ResponseRefusalDeltaEvent
                ) = responseRefusalDelta.validity()

                override fun visitResponseRefusalDone(
                    responseRefusalDone: ResponseRefusalDoneEvent
                ) = responseRefusalDone.validity()

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextDeltaEvent
                ) = responseOutputTextDelta.validity()

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextDoneEvent
                ) = responseOutputTextDone.validity()

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: ResponseWebSearchCallCompletedEvent
                ) = responseWebSearchCallCompleted.validity()

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: ResponseWebSearchCallInProgressEvent
                ) = responseWebSearchCallInProgress.validity()

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: ResponseWebSearchCallSearchingEvent
                ) = responseWebSearchCallSearching.validity()

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
                ) = responseImageGenerationCallCompleted.validity()

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
                ) = responseImageGenerationCallGenerating.validity()

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
                ) = responseImageGenerationCallInProgress.validity()

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
                ) = responseImageGenerationCallPartialImage.validity()

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
                ) = responseMcpCallArgumentsDelta.validity()

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
                ) = responseMcpCallArgumentsDone.validity()

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallCompletedEvent
                ) = responseMcpCallCompleted.validity()

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallFailedEvent
                ) = responseMcpCallFailed.validity()

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInProgressEvent
                ) = responseMcpCallInProgress.validity()

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
                ) = responseMcpListToolsCompleted.validity()

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: ResponseMcpListToolsFailedEvent
                ) = responseMcpListToolsFailed.validity()

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
                ) = responseMcpListToolsInProgress.validity()

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
                ) = responseOutputTextAnnotationAdded.validity()

                override fun visitResponseQueued(responseQueued: ResponseQueuedEvent) =
                    responseQueued.validity()

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
                ) = responseCustomToolCallInputDelta.validity()

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: ResponseCustomToolCallInputDoneEvent
                ) = responseCustomToolCallInputDone.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponsesServerEvent &&
            responseAudioDelta == other.responseAudioDelta &&
            responseAudioDone == other.responseAudioDone &&
            responseAudioTranscriptDelta == other.responseAudioTranscriptDelta &&
            responseAudioTranscriptDone == other.responseAudioTranscriptDone &&
            responseCodeInterpreterCallCodeDelta == other.responseCodeInterpreterCallCodeDelta &&
            responseCodeInterpreterCallCodeDone == other.responseCodeInterpreterCallCodeDone &&
            responseCodeInterpreterCallCompleted == other.responseCodeInterpreterCallCompleted &&
            responseCodeInterpreterCallInProgress == other.responseCodeInterpreterCallInProgress &&
            responseCodeInterpreterCallInterpreting ==
                other.responseCodeInterpreterCallInterpreting &&
            responseCompleted == other.responseCompleted &&
            responseContentPartAdded == other.responseContentPartAdded &&
            responseContentPartDone == other.responseContentPartDone &&
            responseCreated == other.responseCreated &&
            error == other.error &&
            responseFileSearchCallCompleted == other.responseFileSearchCallCompleted &&
            responseFileSearchCallInProgress == other.responseFileSearchCallInProgress &&
            responseFileSearchCallSearching == other.responseFileSearchCallSearching &&
            responseFunctionCallArgumentsDelta == other.responseFunctionCallArgumentsDelta &&
            responseFunctionCallArgumentsDone == other.responseFunctionCallArgumentsDone &&
            responseInProgress == other.responseInProgress &&
            responseFailed == other.responseFailed &&
            responseIncomplete == other.responseIncomplete &&
            responseOutputItemAdded == other.responseOutputItemAdded &&
            responseOutputItemDone == other.responseOutputItemDone &&
            responseReasoningSummaryPartAdded == other.responseReasoningSummaryPartAdded &&
            responseReasoningSummaryPartDone == other.responseReasoningSummaryPartDone &&
            responseReasoningSummaryTextDelta == other.responseReasoningSummaryTextDelta &&
            responseReasoningSummaryTextDone == other.responseReasoningSummaryTextDone &&
            responseReasoningTextDelta == other.responseReasoningTextDelta &&
            responseReasoningTextDone == other.responseReasoningTextDone &&
            responseRefusalDelta == other.responseRefusalDelta &&
            responseRefusalDone == other.responseRefusalDone &&
            responseOutputTextDelta == other.responseOutputTextDelta &&
            responseOutputTextDone == other.responseOutputTextDone &&
            responseWebSearchCallCompleted == other.responseWebSearchCallCompleted &&
            responseWebSearchCallInProgress == other.responseWebSearchCallInProgress &&
            responseWebSearchCallSearching == other.responseWebSearchCallSearching &&
            responseImageGenerationCallCompleted == other.responseImageGenerationCallCompleted &&
            responseImageGenerationCallGenerating == other.responseImageGenerationCallGenerating &&
            responseImageGenerationCallInProgress == other.responseImageGenerationCallInProgress &&
            responseImageGenerationCallPartialImage ==
                other.responseImageGenerationCallPartialImage &&
            responseMcpCallArgumentsDelta == other.responseMcpCallArgumentsDelta &&
            responseMcpCallArgumentsDone == other.responseMcpCallArgumentsDone &&
            responseMcpCallCompleted == other.responseMcpCallCompleted &&
            responseMcpCallFailed == other.responseMcpCallFailed &&
            responseMcpCallInProgress == other.responseMcpCallInProgress &&
            responseMcpListToolsCompleted == other.responseMcpListToolsCompleted &&
            responseMcpListToolsFailed == other.responseMcpListToolsFailed &&
            responseMcpListToolsInProgress == other.responseMcpListToolsInProgress &&
            responseOutputTextAnnotationAdded == other.responseOutputTextAnnotationAdded &&
            responseQueued == other.responseQueued &&
            responseCustomToolCallInputDelta == other.responseCustomToolCallInputDelta &&
            responseCustomToolCallInputDone == other.responseCustomToolCallInputDone
    }

    override fun hashCode(): Int =
        Objects.hash(
            responseAudioDelta,
            responseAudioDone,
            responseAudioTranscriptDelta,
            responseAudioTranscriptDone,
            responseCodeInterpreterCallCodeDelta,
            responseCodeInterpreterCallCodeDone,
            responseCodeInterpreterCallCompleted,
            responseCodeInterpreterCallInProgress,
            responseCodeInterpreterCallInterpreting,
            responseCompleted,
            responseContentPartAdded,
            responseContentPartDone,
            responseCreated,
            error,
            responseFileSearchCallCompleted,
            responseFileSearchCallInProgress,
            responseFileSearchCallSearching,
            responseFunctionCallArgumentsDelta,
            responseFunctionCallArgumentsDone,
            responseInProgress,
            responseFailed,
            responseIncomplete,
            responseOutputItemAdded,
            responseOutputItemDone,
            responseReasoningSummaryPartAdded,
            responseReasoningSummaryPartDone,
            responseReasoningSummaryTextDelta,
            responseReasoningSummaryTextDone,
            responseReasoningTextDelta,
            responseReasoningTextDone,
            responseRefusalDelta,
            responseRefusalDone,
            responseOutputTextDelta,
            responseOutputTextDone,
            responseWebSearchCallCompleted,
            responseWebSearchCallInProgress,
            responseWebSearchCallSearching,
            responseImageGenerationCallCompleted,
            responseImageGenerationCallGenerating,
            responseImageGenerationCallInProgress,
            responseImageGenerationCallPartialImage,
            responseMcpCallArgumentsDelta,
            responseMcpCallArgumentsDone,
            responseMcpCallCompleted,
            responseMcpCallFailed,
            responseMcpCallInProgress,
            responseMcpListToolsCompleted,
            responseMcpListToolsFailed,
            responseMcpListToolsInProgress,
            responseOutputTextAnnotationAdded,
            responseQueued,
            responseCustomToolCallInputDelta,
            responseCustomToolCallInputDone,
        )

    override fun toString(): String =
        when {
            responseAudioDelta != null ->
                "ResponsesServerEvent{responseAudioDelta=$responseAudioDelta}"
            responseAudioDone != null ->
                "ResponsesServerEvent{responseAudioDone=$responseAudioDone}"
            responseAudioTranscriptDelta != null ->
                "ResponsesServerEvent{responseAudioTranscriptDelta=$responseAudioTranscriptDelta}"
            responseAudioTranscriptDone != null ->
                "ResponsesServerEvent{responseAudioTranscriptDone=$responseAudioTranscriptDone}"
            responseCodeInterpreterCallCodeDelta != null ->
                "ResponsesServerEvent{responseCodeInterpreterCallCodeDelta=$responseCodeInterpreterCallCodeDelta}"
            responseCodeInterpreterCallCodeDone != null ->
                "ResponsesServerEvent{responseCodeInterpreterCallCodeDone=$responseCodeInterpreterCallCodeDone}"
            responseCodeInterpreterCallCompleted != null ->
                "ResponsesServerEvent{responseCodeInterpreterCallCompleted=$responseCodeInterpreterCallCompleted}"
            responseCodeInterpreterCallInProgress != null ->
                "ResponsesServerEvent{responseCodeInterpreterCallInProgress=$responseCodeInterpreterCallInProgress}"
            responseCodeInterpreterCallInterpreting != null ->
                "ResponsesServerEvent{responseCodeInterpreterCallInterpreting=$responseCodeInterpreterCallInterpreting}"
            responseCompleted != null ->
                "ResponsesServerEvent{responseCompleted=$responseCompleted}"
            responseContentPartAdded != null ->
                "ResponsesServerEvent{responseContentPartAdded=$responseContentPartAdded}"
            responseContentPartDone != null ->
                "ResponsesServerEvent{responseContentPartDone=$responseContentPartDone}"
            responseCreated != null -> "ResponsesServerEvent{responseCreated=$responseCreated}"
            error != null -> "ResponsesServerEvent{error=$error}"
            responseFileSearchCallCompleted != null ->
                "ResponsesServerEvent{responseFileSearchCallCompleted=$responseFileSearchCallCompleted}"
            responseFileSearchCallInProgress != null ->
                "ResponsesServerEvent{responseFileSearchCallInProgress=$responseFileSearchCallInProgress}"
            responseFileSearchCallSearching != null ->
                "ResponsesServerEvent{responseFileSearchCallSearching=$responseFileSearchCallSearching}"
            responseFunctionCallArgumentsDelta != null ->
                "ResponsesServerEvent{responseFunctionCallArgumentsDelta=$responseFunctionCallArgumentsDelta}"
            responseFunctionCallArgumentsDone != null ->
                "ResponsesServerEvent{responseFunctionCallArgumentsDone=$responseFunctionCallArgumentsDone}"
            responseInProgress != null ->
                "ResponsesServerEvent{responseInProgress=$responseInProgress}"
            responseFailed != null -> "ResponsesServerEvent{responseFailed=$responseFailed}"
            responseIncomplete != null ->
                "ResponsesServerEvent{responseIncomplete=$responseIncomplete}"
            responseOutputItemAdded != null ->
                "ResponsesServerEvent{responseOutputItemAdded=$responseOutputItemAdded}"
            responseOutputItemDone != null ->
                "ResponsesServerEvent{responseOutputItemDone=$responseOutputItemDone}"
            responseReasoningSummaryPartAdded != null ->
                "ResponsesServerEvent{responseReasoningSummaryPartAdded=$responseReasoningSummaryPartAdded}"
            responseReasoningSummaryPartDone != null ->
                "ResponsesServerEvent{responseReasoningSummaryPartDone=$responseReasoningSummaryPartDone}"
            responseReasoningSummaryTextDelta != null ->
                "ResponsesServerEvent{responseReasoningSummaryTextDelta=$responseReasoningSummaryTextDelta}"
            responseReasoningSummaryTextDone != null ->
                "ResponsesServerEvent{responseReasoningSummaryTextDone=$responseReasoningSummaryTextDone}"
            responseReasoningTextDelta != null ->
                "ResponsesServerEvent{responseReasoningTextDelta=$responseReasoningTextDelta}"
            responseReasoningTextDone != null ->
                "ResponsesServerEvent{responseReasoningTextDone=$responseReasoningTextDone}"
            responseRefusalDelta != null ->
                "ResponsesServerEvent{responseRefusalDelta=$responseRefusalDelta}"
            responseRefusalDone != null ->
                "ResponsesServerEvent{responseRefusalDone=$responseRefusalDone}"
            responseOutputTextDelta != null ->
                "ResponsesServerEvent{responseOutputTextDelta=$responseOutputTextDelta}"
            responseOutputTextDone != null ->
                "ResponsesServerEvent{responseOutputTextDone=$responseOutputTextDone}"
            responseWebSearchCallCompleted != null ->
                "ResponsesServerEvent{responseWebSearchCallCompleted=$responseWebSearchCallCompleted}"
            responseWebSearchCallInProgress != null ->
                "ResponsesServerEvent{responseWebSearchCallInProgress=$responseWebSearchCallInProgress}"
            responseWebSearchCallSearching != null ->
                "ResponsesServerEvent{responseWebSearchCallSearching=$responseWebSearchCallSearching}"
            responseImageGenerationCallCompleted != null ->
                "ResponsesServerEvent{responseImageGenerationCallCompleted=$responseImageGenerationCallCompleted}"
            responseImageGenerationCallGenerating != null ->
                "ResponsesServerEvent{responseImageGenerationCallGenerating=$responseImageGenerationCallGenerating}"
            responseImageGenerationCallInProgress != null ->
                "ResponsesServerEvent{responseImageGenerationCallInProgress=$responseImageGenerationCallInProgress}"
            responseImageGenerationCallPartialImage != null ->
                "ResponsesServerEvent{responseImageGenerationCallPartialImage=$responseImageGenerationCallPartialImage}"
            responseMcpCallArgumentsDelta != null ->
                "ResponsesServerEvent{responseMcpCallArgumentsDelta=$responseMcpCallArgumentsDelta}"
            responseMcpCallArgumentsDone != null ->
                "ResponsesServerEvent{responseMcpCallArgumentsDone=$responseMcpCallArgumentsDone}"
            responseMcpCallCompleted != null ->
                "ResponsesServerEvent{responseMcpCallCompleted=$responseMcpCallCompleted}"
            responseMcpCallFailed != null ->
                "ResponsesServerEvent{responseMcpCallFailed=$responseMcpCallFailed}"
            responseMcpCallInProgress != null ->
                "ResponsesServerEvent{responseMcpCallInProgress=$responseMcpCallInProgress}"
            responseMcpListToolsCompleted != null ->
                "ResponsesServerEvent{responseMcpListToolsCompleted=$responseMcpListToolsCompleted}"
            responseMcpListToolsFailed != null ->
                "ResponsesServerEvent{responseMcpListToolsFailed=$responseMcpListToolsFailed}"
            responseMcpListToolsInProgress != null ->
                "ResponsesServerEvent{responseMcpListToolsInProgress=$responseMcpListToolsInProgress}"
            responseOutputTextAnnotationAdded != null ->
                "ResponsesServerEvent{responseOutputTextAnnotationAdded=$responseOutputTextAnnotationAdded}"
            responseQueued != null -> "ResponsesServerEvent{responseQueued=$responseQueued}"
            responseCustomToolCallInputDelta != null ->
                "ResponsesServerEvent{responseCustomToolCallInputDelta=$responseCustomToolCallInputDelta}"
            responseCustomToolCallInputDone != null ->
                "ResponsesServerEvent{responseCustomToolCallInputDone=$responseCustomToolCallInputDone}"
            _json != null -> "ResponsesServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponsesServerEvent")
        }

    companion object {

        /** Emitted when there is a partial audio response. */
        @JvmStatic
        fun ofResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) =
            ResponsesServerEvent(responseAudioDelta = responseAudioDelta)

        /** Emitted when the audio response is complete. */
        @JvmStatic
        fun ofResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) =
            ResponsesServerEvent(responseAudioDone = responseAudioDone)

        /** Emitted when there is a partial transcript of audio. */
        @JvmStatic
        fun ofResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ) = ResponsesServerEvent(responseAudioTranscriptDelta = responseAudioTranscriptDelta)

        /** Emitted when the full audio transcript is completed. */
        @JvmStatic
        fun ofResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
        ) = ResponsesServerEvent(responseAudioTranscriptDone = responseAudioTranscriptDone)

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCodeDelta = responseCodeInterpreterCallCodeDelta
            )

        /** Emitted when the code snippet is finalized by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCodeDone = responseCodeInterpreterCallCodeDone
            )

        /** Emitted when the code interpreter call is completed. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCompleted = responseCodeInterpreterCallCompleted
            )

        /** Emitted when a code interpreter call is in progress. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallInProgress = responseCodeInterpreterCallInProgress
            )

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallInterpreting = responseCodeInterpreterCallInterpreting
            )

        /** Emitted when the model response is complete. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: ResponseCompletedEvent) =
            ResponsesServerEvent(responseCompleted = responseCompleted)

        /** Emitted when a new content part is added. */
        @JvmStatic
        fun ofResponseContentPartAdded(responseContentPartAdded: ResponseContentPartAddedEvent) =
            ResponsesServerEvent(responseContentPartAdded = responseContentPartAdded)

        /** Emitted when a content part is done. */
        @JvmStatic
        fun ofResponseContentPartDone(responseContentPartDone: ResponseContentPartDoneEvent) =
            ResponsesServerEvent(responseContentPartDone = responseContentPartDone)

        /** An event that is emitted when a response is created. */
        @JvmStatic
        fun ofResponseCreated(responseCreated: ResponseCreatedEvent) =
            ResponsesServerEvent(responseCreated = responseCreated)

        /** Emitted when an error occurs. */
        @JvmStatic fun ofError(error: ResponseErrorEvent) = ResponsesServerEvent(error = error)

        /** Emitted when a file search call is completed (results found). */
        @JvmStatic
        fun ofResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
        ) = ResponsesServerEvent(responseFileSearchCallCompleted = responseFileSearchCallCompleted)

        /** Emitted when a file search call is initiated. */
        @JvmStatic
        fun ofResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
        ) =
            ResponsesServerEvent(
                responseFileSearchCallInProgress = responseFileSearchCallInProgress
            )

        /** Emitted when a file search is currently searching. */
        @JvmStatic
        fun ofResponseFileSearchCallSearching(
            responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent
        ) = ResponsesServerEvent(responseFileSearchCallSearching = responseFileSearchCallSearching)

        /** Emitted when there is a partial function-call arguments delta. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ) =
            ResponsesServerEvent(
                responseFunctionCallArgumentsDelta = responseFunctionCallArgumentsDelta
            )

        /** Emitted when function-call arguments are finalized. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ) =
            ResponsesServerEvent(
                responseFunctionCallArgumentsDone = responseFunctionCallArgumentsDone
            )

        /** Emitted when the response is in progress. */
        @JvmStatic
        fun ofResponseInProgress(responseInProgress: ResponseInProgressEvent) =
            ResponsesServerEvent(responseInProgress = responseInProgress)

        /** An event that is emitted when a response fails. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: ResponseFailedEvent) =
            ResponsesServerEvent(responseFailed = responseFailed)

        /** An event that is emitted when a response finishes as incomplete. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: ResponseIncompleteEvent) =
            ResponsesServerEvent(responseIncomplete = responseIncomplete)

        /** Emitted when a new output item is added. */
        @JvmStatic
        fun ofResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemAddedEvent) =
            ResponsesServerEvent(responseOutputItemAdded = responseOutputItemAdded)

        /** Emitted when an output item is marked done. */
        @JvmStatic
        fun ofResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemDoneEvent) =
            ResponsesServerEvent(responseOutputItemDone = responseOutputItemDone)

        /** Emitted when a new reasoning summary part is added. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryPartAdded = responseReasoningSummaryPartAdded
            )

        /** Emitted when a reasoning summary part is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryPartDone = responseReasoningSummaryPartDone
            )

        /** Emitted when a delta is added to a reasoning summary text. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryTextDelta = responseReasoningSummaryTextDelta
            )

        /** Emitted when a reasoning summary text is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryTextDone = responseReasoningSummaryTextDone
            )

        /** Emitted when a delta is added to a reasoning text. */
        @JvmStatic
        fun ofResponseReasoningTextDelta(
            responseReasoningTextDelta: ResponseReasoningTextDeltaEvent
        ) = ResponsesServerEvent(responseReasoningTextDelta = responseReasoningTextDelta)

        /** Emitted when a reasoning text is completed. */
        @JvmStatic
        fun ofResponseReasoningTextDone(responseReasoningTextDone: ResponseReasoningTextDoneEvent) =
            ResponsesServerEvent(responseReasoningTextDone = responseReasoningTextDone)

        /** Emitted when there is a partial refusal text. */
        @JvmStatic
        fun ofResponseRefusalDelta(responseRefusalDelta: ResponseRefusalDeltaEvent) =
            ResponsesServerEvent(responseRefusalDelta = responseRefusalDelta)

        /** Emitted when refusal text is finalized. */
        @JvmStatic
        fun ofResponseRefusalDone(responseRefusalDone: ResponseRefusalDoneEvent) =
            ResponsesServerEvent(responseRefusalDone = responseRefusalDone)

        /** Emitted when there is an additional text delta. */
        @JvmStatic
        fun ofResponseOutputTextDelta(responseOutputTextDelta: ResponseTextDeltaEvent) =
            ResponsesServerEvent(responseOutputTextDelta = responseOutputTextDelta)

        /** Emitted when text content is finalized. */
        @JvmStatic
        fun ofResponseOutputTextDone(responseOutputTextDone: ResponseTextDoneEvent) =
            ResponsesServerEvent(responseOutputTextDone = responseOutputTextDone)

        /** Emitted when a web search call is completed. */
        @JvmStatic
        fun ofResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: ResponseWebSearchCallCompletedEvent
        ) = ResponsesServerEvent(responseWebSearchCallCompleted = responseWebSearchCallCompleted)

        /** Emitted when a web search call is initiated. */
        @JvmStatic
        fun ofResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: ResponseWebSearchCallInProgressEvent
        ) = ResponsesServerEvent(responseWebSearchCallInProgress = responseWebSearchCallInProgress)

        /** Emitted when a web search call is executing. */
        @JvmStatic
        fun ofResponseWebSearchCallSearching(
            responseWebSearchCallSearching: ResponseWebSearchCallSearchingEvent
        ) = ResponsesServerEvent(responseWebSearchCallSearching = responseWebSearchCallSearching)

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        @JvmStatic
        fun ofResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallCompleted = responseImageGenerationCallCompleted
            )

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        @JvmStatic
        fun ofResponseImageGenerationCallGenerating(
            responseImageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallGenerating = responseImageGenerationCallGenerating
            )

        /** Emitted when an image generation tool call is in progress. */
        @JvmStatic
        fun ofResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallInProgress = responseImageGenerationCallInProgress
            )

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallPartialImage = responseImageGenerationCallPartialImage
            )

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
        ) = ResponsesServerEvent(responseMcpCallArgumentsDelta = responseMcpCallArgumentsDelta)

        /** Emitted when the arguments for an MCP tool call are finalized. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
        ) = ResponsesServerEvent(responseMcpCallArgumentsDone = responseMcpCallArgumentsDone)

        /** Emitted when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofResponseMcpCallCompleted(responseMcpCallCompleted: ResponseMcpCallCompletedEvent) =
            ResponsesServerEvent(responseMcpCallCompleted = responseMcpCallCompleted)

        /** Emitted when an MCP tool call has failed. */
        @JvmStatic
        fun ofResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallFailedEvent) =
            ResponsesServerEvent(responseMcpCallFailed = responseMcpCallFailed)

        /** Emitted when an MCP tool call is in progress. */
        @JvmStatic
        fun ofResponseMcpCallInProgress(responseMcpCallInProgress: ResponseMcpCallInProgressEvent) =
            ResponsesServerEvent(responseMcpCallInProgress = responseMcpCallInProgress)

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        @JvmStatic
        fun ofResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
        ) = ResponsesServerEvent(responseMcpListToolsCompleted = responseMcpListToolsCompleted)

        /** Emitted when the attempt to list available MCP tools has failed. */
        @JvmStatic
        fun ofResponseMcpListToolsFailed(
            responseMcpListToolsFailed: ResponseMcpListToolsFailedEvent
        ) = ResponsesServerEvent(responseMcpListToolsFailed = responseMcpListToolsFailed)

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        @JvmStatic
        fun ofResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
        ) = ResponsesServerEvent(responseMcpListToolsInProgress = responseMcpListToolsInProgress)

        /** Emitted when an annotation is added to output text content. */
        @JvmStatic
        fun ofResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
        ) =
            ResponsesServerEvent(
                responseOutputTextAnnotationAdded = responseOutputTextAnnotationAdded
            )

        /** Emitted when a response is queued and waiting to be processed. */
        @JvmStatic
        fun ofResponseQueued(responseQueued: ResponseQueuedEvent) =
            ResponsesServerEvent(responseQueued = responseQueued)

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
        ) =
            ResponsesServerEvent(
                responseCustomToolCallInputDelta = responseCustomToolCallInputDelta
            )

        /** Event indicating that input for a custom tool call is complete. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: ResponseCustomToolCallInputDoneEvent
        ) = ResponsesServerEvent(responseCustomToolCallInputDone = responseCustomToolCallInputDone)
    }

    /**
     * An interface that defines how to map each variant of [ResponsesServerEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Emitted when there is a partial audio response. */
        fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent): T

        /** Emitted when the audio response is complete. */
        fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent): T

        /** Emitted when there is a partial transcript of audio. */
        fun visitResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ): T

        /** Emitted when the full audio transcript is completed. */
        fun visitResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
        ): T

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeDeltaEvent
        ): T

        /** Emitted when the code snippet is finalized by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeDoneEvent
        ): T

        /** Emitted when the code interpreter call is completed. */
        fun visitResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallCompletedEvent
        ): T

        /** Emitted when a code interpreter call is in progress. */
        fun visitResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInProgressEvent
        ): T

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        fun visitResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting: ResponseCodeInterpreterCallInterpretingEvent
        ): T

        /** Emitted when the model response is complete. */
        fun visitResponseCompleted(responseCompleted: ResponseCompletedEvent): T

        /** Emitted when a new content part is added. */
        fun visitResponseContentPartAdded(
            responseContentPartAdded: ResponseContentPartAddedEvent
        ): T

        /** Emitted when a content part is done. */
        fun visitResponseContentPartDone(responseContentPartDone: ResponseContentPartDoneEvent): T

        /** An event that is emitted when a response is created. */
        fun visitResponseCreated(responseCreated: ResponseCreatedEvent): T

        /** Emitted when an error occurs. */
        fun visitError(error: ResponseErrorEvent): T

        /** Emitted when a file search call is completed (results found). */
        fun visitResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent
        ): T

        /** Emitted when a file search call is initiated. */
        fun visitResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent
        ): T

        /** Emitted when a file search is currently searching. */
        fun visitResponseFileSearchCallSearching(
            responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent
        ): T

        /** Emitted when there is a partial function-call arguments delta. */
        fun visitResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ): T

        /** Emitted when function-call arguments are finalized. */
        fun visitResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ): T

        /** Emitted when the response is in progress. */
        fun visitResponseInProgress(responseInProgress: ResponseInProgressEvent): T

        /** An event that is emitted when a response fails. */
        fun visitResponseFailed(responseFailed: ResponseFailedEvent): T

        /** An event that is emitted when a response finishes as incomplete. */
        fun visitResponseIncomplete(responseIncomplete: ResponseIncompleteEvent): T

        /** Emitted when a new output item is added. */
        fun visitResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemAddedEvent): T

        /** Emitted when an output item is marked done. */
        fun visitResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemDoneEvent): T

        /** Emitted when a new reasoning summary part is added. */
        fun visitResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartAddedEvent
        ): T

        /** Emitted when a reasoning summary part is completed. */
        fun visitResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: ResponseReasoningSummaryPartDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning summary text. */
        fun visitResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextDeltaEvent
        ): T

        /** Emitted when a reasoning summary text is completed. */
        fun visitResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: ResponseReasoningSummaryTextDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning text. */
        fun visitResponseReasoningTextDelta(
            responseReasoningTextDelta: ResponseReasoningTextDeltaEvent
        ): T

        /** Emitted when a reasoning text is completed. */
        fun visitResponseReasoningTextDone(
            responseReasoningTextDone: ResponseReasoningTextDoneEvent
        ): T

        /** Emitted when there is a partial refusal text. */
        fun visitResponseRefusalDelta(responseRefusalDelta: ResponseRefusalDeltaEvent): T

        /** Emitted when refusal text is finalized. */
        fun visitResponseRefusalDone(responseRefusalDone: ResponseRefusalDoneEvent): T

        /** Emitted when there is an additional text delta. */
        fun visitResponseOutputTextDelta(responseOutputTextDelta: ResponseTextDeltaEvent): T

        /** Emitted when text content is finalized. */
        fun visitResponseOutputTextDone(responseOutputTextDone: ResponseTextDoneEvent): T

        /** Emitted when a web search call is completed. */
        fun visitResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: ResponseWebSearchCallCompletedEvent
        ): T

        /** Emitted when a web search call is initiated. */
        fun visitResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: ResponseWebSearchCallInProgressEvent
        ): T

        /** Emitted when a web search call is executing. */
        fun visitResponseWebSearchCallSearching(
            responseWebSearchCallSearching: ResponseWebSearchCallSearchingEvent
        ): T

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        fun visitResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: ResponseImageGenCallCompletedEvent
        ): T

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        fun visitResponseImageGenerationCallGenerating(
            responseImageGenerationCallGenerating: ResponseImageGenCallGeneratingEvent
        ): T

        /** Emitted when an image generation tool call is in progress. */
        fun visitResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: ResponseImageGenCallInProgressEvent
        ): T

        /** Emitted when a partial image is available during image generation streaming. */
        fun visitResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: ResponseImageGenCallPartialImageEvent
        ): T

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        fun visitResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDeltaEvent
        ): T

        /** Emitted when the arguments for an MCP tool call are finalized. */
        fun visitResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDoneEvent
        ): T

        /** Emitted when an MCP tool call has completed successfully. */
        fun visitResponseMcpCallCompleted(
            responseMcpCallCompleted: ResponseMcpCallCompletedEvent
        ): T

        /** Emitted when an MCP tool call has failed. */
        fun visitResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallFailedEvent): T

        /** Emitted when an MCP tool call is in progress. */
        fun visitResponseMcpCallInProgress(
            responseMcpCallInProgress: ResponseMcpCallInProgressEvent
        ): T

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        fun visitResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: ResponseMcpListToolsCompletedEvent
        ): T

        /** Emitted when the attempt to list available MCP tools has failed. */
        fun visitResponseMcpListToolsFailed(
            responseMcpListToolsFailed: ResponseMcpListToolsFailedEvent
        ): T

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        fun visitResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: ResponseMcpListToolsInProgressEvent
        ): T

        /** Emitted when an annotation is added to output text content. */
        fun visitResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationAddedEvent
        ): T

        /** Emitted when a response is queued and waiting to be processed. */
        fun visitResponseQueued(responseQueued: ResponseQueuedEvent): T

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        fun visitResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: ResponseCustomToolCallInputDeltaEvent
        ): T

        /** Event indicating that input for a custom tool call is complete. */
        fun visitResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: ResponseCustomToolCallInputDoneEvent
        ): T

        /**
         * Maps an unknown variant of [ResponsesServerEvent] to a value of type [T].
         *
         * An instance of [ResponsesServerEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponsesServerEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponsesServerEvent>(ResponsesServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponsesServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "response.audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDeltaEvent>())?.let {
                        ResponsesServerEvent(responseAudioDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDoneEvent>())?.let {
                        ResponsesServerEvent(responseAudioDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>())
                        ?.let {
                            ResponsesServerEvent(responseAudioTranscriptDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDoneEvent>())
                        ?.let {
                            ResponsesServerEvent(responseAudioTranscriptDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call_code.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallCodeDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call_code.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallCodeDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallCompleted = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallInProgress = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.interpreting" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallInterpretingEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallInterpreting = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCompletedEvent>())?.let {
                        ResponsesServerEvent(responseCompleted = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartAddedEvent>())
                        ?.let { ResponsesServerEvent(responseContentPartAdded = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartDoneEvent>())
                        ?.let { ResponsesServerEvent(responseContentPartDone = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreatedEvent>())?.let {
                        ResponsesServerEvent(responseCreated = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseErrorEvent>())?.let {
                        ResponsesServerEvent(error = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseFileSearchCallCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseFileSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseFileSearchCallSearching = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseFunctionCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.function_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseFunctionCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInProgressEvent>())?.let {
                        ResponsesServerEvent(responseInProgress = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFailedEvent>())?.let {
                        ResponsesServerEvent(responseFailed = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseIncompleteEvent>())?.let {
                        ResponsesServerEvent(responseIncomplete = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemAddedEvent>())
                        ?.let { ResponsesServerEvent(responseOutputItemAdded = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemDoneEvent>())
                        ?.let { ResponsesServerEvent(responseOutputItemDone = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryPartAddedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseReasoningSummaryPartAdded = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryPartDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseReasoningSummaryPartDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryTextDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseReasoningSummaryTextDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryTextDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseReasoningSummaryTextDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextDeltaEvent>())
                        ?.let {
                            ResponsesServerEvent(responseReasoningTextDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextDoneEvent>())
                        ?.let { ResponsesServerEvent(responseReasoningTextDone = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.refusal.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalDeltaEvent>())?.let {
                        ResponsesServerEvent(responseRefusalDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.refusal.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalDoneEvent>())?.let {
                        ResponsesServerEvent(responseRefusalDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDeltaEvent>())?.let {
                        ResponsesServerEvent(responseOutputTextDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDoneEvent>())?.let {
                        ResponsesServerEvent(responseOutputTextDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallInProgress = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseWebSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallSearching = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallCompletedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallCompleted = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.generating" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallGeneratingEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallGenerating = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallInProgressEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallInProgress = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.partial_image" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseImageGenCallPartialImageEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallPartialImage = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseMcpCallArgumentsDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsDoneEvent>())
                        ?.let {
                            ResponsesServerEvent(responseMcpCallArgumentsDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallCompletedEvent>())
                        ?.let { ResponsesServerEvent(responseMcpCallCompleted = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallFailedEvent>())?.let {
                        ResponsesServerEvent(responseMcpCallFailed = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallInProgressEvent>())
                        ?.let { ResponsesServerEvent(responseMcpCallInProgress = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpListToolsCompletedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpListToolsFailedEvent>())
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsFailed = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseMcpListToolsInProgressEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsInProgress = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.annotation.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseOutputTextAnnotationAddedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseOutputTextAnnotationAdded = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseQueuedEvent>())?.let {
                        ResponsesServerEvent(responseQueued = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCustomToolCallInputDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCustomToolCallInputDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCustomToolCallInputDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseCustomToolCallInputDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
            }

            return ResponsesServerEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponsesServerEvent>(ResponsesServerEvent::class) {

        override fun serialize(
            value: ResponsesServerEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.responseAudioDelta != null -> generator.writeObject(value.responseAudioDelta)
                value.responseAudioDone != null -> generator.writeObject(value.responseAudioDone)
                value.responseAudioTranscriptDelta != null ->
                    generator.writeObject(value.responseAudioTranscriptDelta)
                value.responseAudioTranscriptDone != null ->
                    generator.writeObject(value.responseAudioTranscriptDone)
                value.responseCodeInterpreterCallCodeDelta != null ->
                    generator.writeObject(value.responseCodeInterpreterCallCodeDelta)
                value.responseCodeInterpreterCallCodeDone != null ->
                    generator.writeObject(value.responseCodeInterpreterCallCodeDone)
                value.responseCodeInterpreterCallCompleted != null ->
                    generator.writeObject(value.responseCodeInterpreterCallCompleted)
                value.responseCodeInterpreterCallInProgress != null ->
                    generator.writeObject(value.responseCodeInterpreterCallInProgress)
                value.responseCodeInterpreterCallInterpreting != null ->
                    generator.writeObject(value.responseCodeInterpreterCallInterpreting)
                value.responseCompleted != null -> generator.writeObject(value.responseCompleted)
                value.responseContentPartAdded != null ->
                    generator.writeObject(value.responseContentPartAdded)
                value.responseContentPartDone != null ->
                    generator.writeObject(value.responseContentPartDone)
                value.responseCreated != null -> generator.writeObject(value.responseCreated)
                value.error != null -> generator.writeObject(value.error)
                value.responseFileSearchCallCompleted != null ->
                    generator.writeObject(value.responseFileSearchCallCompleted)
                value.responseFileSearchCallInProgress != null ->
                    generator.writeObject(value.responseFileSearchCallInProgress)
                value.responseFileSearchCallSearching != null ->
                    generator.writeObject(value.responseFileSearchCallSearching)
                value.responseFunctionCallArgumentsDelta != null ->
                    generator.writeObject(value.responseFunctionCallArgumentsDelta)
                value.responseFunctionCallArgumentsDone != null ->
                    generator.writeObject(value.responseFunctionCallArgumentsDone)
                value.responseInProgress != null -> generator.writeObject(value.responseInProgress)
                value.responseFailed != null -> generator.writeObject(value.responseFailed)
                value.responseIncomplete != null -> generator.writeObject(value.responseIncomplete)
                value.responseOutputItemAdded != null ->
                    generator.writeObject(value.responseOutputItemAdded)
                value.responseOutputItemDone != null ->
                    generator.writeObject(value.responseOutputItemDone)
                value.responseReasoningSummaryPartAdded != null ->
                    generator.writeObject(value.responseReasoningSummaryPartAdded)
                value.responseReasoningSummaryPartDone != null ->
                    generator.writeObject(value.responseReasoningSummaryPartDone)
                value.responseReasoningSummaryTextDelta != null ->
                    generator.writeObject(value.responseReasoningSummaryTextDelta)
                value.responseReasoningSummaryTextDone != null ->
                    generator.writeObject(value.responseReasoningSummaryTextDone)
                value.responseReasoningTextDelta != null ->
                    generator.writeObject(value.responseReasoningTextDelta)
                value.responseReasoningTextDone != null ->
                    generator.writeObject(value.responseReasoningTextDone)
                value.responseRefusalDelta != null ->
                    generator.writeObject(value.responseRefusalDelta)
                value.responseRefusalDone != null ->
                    generator.writeObject(value.responseRefusalDone)
                value.responseOutputTextDelta != null ->
                    generator.writeObject(value.responseOutputTextDelta)
                value.responseOutputTextDone != null ->
                    generator.writeObject(value.responseOutputTextDone)
                value.responseWebSearchCallCompleted != null ->
                    generator.writeObject(value.responseWebSearchCallCompleted)
                value.responseWebSearchCallInProgress != null ->
                    generator.writeObject(value.responseWebSearchCallInProgress)
                value.responseWebSearchCallSearching != null ->
                    generator.writeObject(value.responseWebSearchCallSearching)
                value.responseImageGenerationCallCompleted != null ->
                    generator.writeObject(value.responseImageGenerationCallCompleted)
                value.responseImageGenerationCallGenerating != null ->
                    generator.writeObject(value.responseImageGenerationCallGenerating)
                value.responseImageGenerationCallInProgress != null ->
                    generator.writeObject(value.responseImageGenerationCallInProgress)
                value.responseImageGenerationCallPartialImage != null ->
                    generator.writeObject(value.responseImageGenerationCallPartialImage)
                value.responseMcpCallArgumentsDelta != null ->
                    generator.writeObject(value.responseMcpCallArgumentsDelta)
                value.responseMcpCallArgumentsDone != null ->
                    generator.writeObject(value.responseMcpCallArgumentsDone)
                value.responseMcpCallCompleted != null ->
                    generator.writeObject(value.responseMcpCallCompleted)
                value.responseMcpCallFailed != null ->
                    generator.writeObject(value.responseMcpCallFailed)
                value.responseMcpCallInProgress != null ->
                    generator.writeObject(value.responseMcpCallInProgress)
                value.responseMcpListToolsCompleted != null ->
                    generator.writeObject(value.responseMcpListToolsCompleted)
                value.responseMcpListToolsFailed != null ->
                    generator.writeObject(value.responseMcpListToolsFailed)
                value.responseMcpListToolsInProgress != null ->
                    generator.writeObject(value.responseMcpListToolsInProgress)
                value.responseOutputTextAnnotationAdded != null ->
                    generator.writeObject(value.responseOutputTextAnnotationAdded)
                value.responseQueued != null -> generator.writeObject(value.responseQueued)
                value.responseCustomToolCallInputDelta != null ->
                    generator.writeObject(value.responseCustomToolCallInputDelta)
                value.responseCustomToolCallInputDone != null ->
                    generator.writeObject(value.responseCustomToolCallInputDone)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponsesServerEvent")
            }
        }
    }
}
