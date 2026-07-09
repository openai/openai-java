// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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
@JsonDeserialize(using = BetaResponseStreamEvent.Deserializer::class)
@JsonSerialize(using = BetaResponseStreamEvent.Serializer::class)
class BetaResponseStreamEvent
private constructor(
    private val responseAudioDelta: BetaResponseAudioDeltaEvent? = null,
    private val responseAudioDone: BetaResponseAudioDoneEvent? = null,
    private val responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent? = null,
    private val responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent? = null,
    private val responseCodeInterpreterCallCodeDelta:
        BetaResponseCodeInterpreterCallCodeDeltaEvent? =
        null,
    private val responseCodeInterpreterCallCodeDone: BetaResponseCodeInterpreterCallCodeDoneEvent? =
        null,
    private val responseCodeInterpreterCallCompleted:
        BetaResponseCodeInterpreterCallCompletedEvent? =
        null,
    private val responseCodeInterpreterCallInProgress:
        BetaResponseCodeInterpreterCallInProgressEvent? =
        null,
    private val responseCodeInterpreterCallInterpreting:
        BetaResponseCodeInterpreterCallInterpretingEvent? =
        null,
    private val responseCompleted: BetaResponseCompletedEvent? = null,
    private val responseContentPartAdded: BetaResponseContentPartAddedEvent? = null,
    private val responseContentPartDone: BetaResponseContentPartDoneEvent? = null,
    private val responseCreated: BetaResponseCreatedEvent? = null,
    private val error: BetaResponseErrorEvent? = null,
    private val responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent? = null,
    private val responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent? = null,
    private val responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent? = null,
    private val responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent? =
        null,
    private val responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent? =
        null,
    private val responseInProgress: BetaResponseInProgressEvent? = null,
    private val responseFailed: BetaResponseFailedEvent? = null,
    private val responseIncomplete: BetaResponseIncompleteEvent? = null,
    private val responseOutputItemAdded: BetaResponseOutputItemAddedEvent? = null,
    private val responseOutputItemDone: BetaResponseOutputItemDoneEvent? = null,
    private val responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent? =
        null,
    private val responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent? = null,
    private val responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent? =
        null,
    private val responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent? = null,
    private val responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent? = null,
    private val responseReasoningTextDone: BetaResponseReasoningTextDoneEvent? = null,
    private val responseRefusalDelta: BetaResponseRefusalDeltaEvent? = null,
    private val responseRefusalDone: BetaResponseRefusalDoneEvent? = null,
    private val responseOutputTextDelta: BetaResponseTextDeltaEvent? = null,
    private val responseOutputTextDone: BetaResponseTextDoneEvent? = null,
    private val responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent? = null,
    private val responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent? = null,
    private val responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent? = null,
    private val responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent? =
        null,
    private val responseImageGenerationCallGenerating: BetaResponseImageGenCallGeneratingEvent? =
        null,
    private val responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent? =
        null,
    private val responseImageGenerationCallPartialImage:
        BetaResponseImageGenCallPartialImageEvent? =
        null,
    private val responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent? = null,
    private val responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent? = null,
    private val responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent? = null,
    private val responseMcpCallFailed: BetaResponseMcpCallFailedEvent? = null,
    private val responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent? = null,
    private val responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent? = null,
    private val responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent? = null,
    private val responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent? = null,
    private val responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent? =
        null,
    private val responseQueued: BetaResponseQueuedEvent? = null,
    private val responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent? = null,
    private val responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when there is a partial audio response. */
    fun responseAudioDelta(): Optional<BetaResponseAudioDeltaEvent> =
        Optional.ofNullable(responseAudioDelta)

    /** Emitted when the audio response is complete. */
    fun responseAudioDone(): Optional<BetaResponseAudioDoneEvent> =
        Optional.ofNullable(responseAudioDone)

    /** Emitted when there is a partial transcript of audio. */
    fun responseAudioTranscriptDelta(): Optional<BetaResponseAudioTranscriptDeltaEvent> =
        Optional.ofNullable(responseAudioTranscriptDelta)

    /** Emitted when the full audio transcript is completed. */
    fun responseAudioTranscriptDone(): Optional<BetaResponseAudioTranscriptDoneEvent> =
        Optional.ofNullable(responseAudioTranscriptDone)

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun responseCodeInterpreterCallCodeDelta():
        Optional<BetaResponseCodeInterpreterCallCodeDeltaEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDelta)

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun responseCodeInterpreterCallCodeDone():
        Optional<BetaResponseCodeInterpreterCallCodeDoneEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDone)

    /** Emitted when the code interpreter call is completed. */
    fun responseCodeInterpreterCallCompleted():
        Optional<BetaResponseCodeInterpreterCallCompletedEvent> =
        Optional.ofNullable(responseCodeInterpreterCallCompleted)

    /** Emitted when a code interpreter call is in progress. */
    fun responseCodeInterpreterCallInProgress():
        Optional<BetaResponseCodeInterpreterCallInProgressEvent> =
        Optional.ofNullable(responseCodeInterpreterCallInProgress)

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun responseCodeInterpreterCallInterpreting():
        Optional<BetaResponseCodeInterpreterCallInterpretingEvent> =
        Optional.ofNullable(responseCodeInterpreterCallInterpreting)

    /** Emitted when the model response is complete. */
    fun responseCompleted(): Optional<BetaResponseCompletedEvent> =
        Optional.ofNullable(responseCompleted)

    /** Emitted when a new content part is added. */
    fun responseContentPartAdded(): Optional<BetaResponseContentPartAddedEvent> =
        Optional.ofNullable(responseContentPartAdded)

    /** Emitted when a content part is done. */
    fun responseContentPartDone(): Optional<BetaResponseContentPartDoneEvent> =
        Optional.ofNullable(responseContentPartDone)

    /** An event that is emitted when a response is created. */
    fun responseCreated(): Optional<BetaResponseCreatedEvent> = Optional.ofNullable(responseCreated)

    /** Emitted when an error occurs. */
    fun error(): Optional<BetaResponseErrorEvent> = Optional.ofNullable(error)

    /** Emitted when a file search call is completed (results found). */
    fun responseFileSearchCallCompleted(): Optional<BetaResponseFileSearchCallCompletedEvent> =
        Optional.ofNullable(responseFileSearchCallCompleted)

    /** Emitted when a file search call is initiated. */
    fun responseFileSearchCallInProgress(): Optional<BetaResponseFileSearchCallInProgressEvent> =
        Optional.ofNullable(responseFileSearchCallInProgress)

    /** Emitted when a file search is currently searching. */
    fun responseFileSearchCallSearching(): Optional<BetaResponseFileSearchCallSearchingEvent> =
        Optional.ofNullable(responseFileSearchCallSearching)

    /** Emitted when there is a partial function-call arguments delta. */
    fun responseFunctionCallArgumentsDelta():
        Optional<BetaResponseFunctionCallArgumentsDeltaEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDelta)

    /** Emitted when function-call arguments are finalized. */
    fun responseFunctionCallArgumentsDone(): Optional<BetaResponseFunctionCallArgumentsDoneEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDone)

    /** Emitted when the response is in progress. */
    fun responseInProgress(): Optional<BetaResponseInProgressEvent> =
        Optional.ofNullable(responseInProgress)

    /** An event that is emitted when a response fails. */
    fun responseFailed(): Optional<BetaResponseFailedEvent> = Optional.ofNullable(responseFailed)

    /** An event that is emitted when a response finishes as incomplete. */
    fun responseIncomplete(): Optional<BetaResponseIncompleteEvent> =
        Optional.ofNullable(responseIncomplete)

    /** Emitted when a new output item is added. */
    fun responseOutputItemAdded(): Optional<BetaResponseOutputItemAddedEvent> =
        Optional.ofNullable(responseOutputItemAdded)

    /** Emitted when an output item is marked done. */
    fun responseOutputItemDone(): Optional<BetaResponseOutputItemDoneEvent> =
        Optional.ofNullable(responseOutputItemDone)

    /** Emitted when a new reasoning summary part is added. */
    fun responseReasoningSummaryPartAdded(): Optional<BetaResponseReasoningSummaryPartAddedEvent> =
        Optional.ofNullable(responseReasoningSummaryPartAdded)

    /** Emitted when a reasoning summary part is completed. */
    fun responseReasoningSummaryPartDone(): Optional<BetaResponseReasoningSummaryPartDoneEvent> =
        Optional.ofNullable(responseReasoningSummaryPartDone)

    /** Emitted when a delta is added to a reasoning summary text. */
    fun responseReasoningSummaryTextDelta(): Optional<BetaResponseReasoningSummaryTextDeltaEvent> =
        Optional.ofNullable(responseReasoningSummaryTextDelta)

    /** Emitted when a reasoning summary text is completed. */
    fun responseReasoningSummaryTextDone(): Optional<BetaResponseReasoningSummaryTextDoneEvent> =
        Optional.ofNullable(responseReasoningSummaryTextDone)

    /** Emitted when a delta is added to a reasoning text. */
    fun responseReasoningTextDelta(): Optional<BetaResponseReasoningTextDeltaEvent> =
        Optional.ofNullable(responseReasoningTextDelta)

    /** Emitted when a reasoning text is completed. */
    fun responseReasoningTextDone(): Optional<BetaResponseReasoningTextDoneEvent> =
        Optional.ofNullable(responseReasoningTextDone)

    /** Emitted when there is a partial refusal text. */
    fun responseRefusalDelta(): Optional<BetaResponseRefusalDeltaEvent> =
        Optional.ofNullable(responseRefusalDelta)

    /** Emitted when refusal text is finalized. */
    fun responseRefusalDone(): Optional<BetaResponseRefusalDoneEvent> =
        Optional.ofNullable(responseRefusalDone)

    /** Emitted when there is an additional text delta. */
    fun responseOutputTextDelta(): Optional<BetaResponseTextDeltaEvent> =
        Optional.ofNullable(responseOutputTextDelta)

    /** Emitted when text content is finalized. */
    fun responseOutputTextDone(): Optional<BetaResponseTextDoneEvent> =
        Optional.ofNullable(responseOutputTextDone)

    /** Emitted when a web search call is completed. */
    fun responseWebSearchCallCompleted(): Optional<BetaResponseWebSearchCallCompletedEvent> =
        Optional.ofNullable(responseWebSearchCallCompleted)

    /** Emitted when a web search call is initiated. */
    fun responseWebSearchCallInProgress(): Optional<BetaResponseWebSearchCallInProgressEvent> =
        Optional.ofNullable(responseWebSearchCallInProgress)

    /** Emitted when a web search call is executing. */
    fun responseWebSearchCallSearching(): Optional<BetaResponseWebSearchCallSearchingEvent> =
        Optional.ofNullable(responseWebSearchCallSearching)

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun responseImageGenerationCallCompleted(): Optional<BetaResponseImageGenCallCompletedEvent> =
        Optional.ofNullable(responseImageGenerationCallCompleted)

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun responseImageGenerationCallGenerating(): Optional<BetaResponseImageGenCallGeneratingEvent> =
        Optional.ofNullable(responseImageGenerationCallGenerating)

    /** Emitted when an image generation tool call is in progress. */
    fun responseImageGenerationCallInProgress(): Optional<BetaResponseImageGenCallInProgressEvent> =
        Optional.ofNullable(responseImageGenerationCallInProgress)

    /** Emitted when a partial image is available during image generation streaming. */
    fun responseImageGenerationCallPartialImage():
        Optional<BetaResponseImageGenCallPartialImageEvent> =
        Optional.ofNullable(responseImageGenerationCallPartialImage)

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun responseMcpCallArgumentsDelta(): Optional<BetaResponseMcpCallArgumentsDeltaEvent> =
        Optional.ofNullable(responseMcpCallArgumentsDelta)

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun responseMcpCallArgumentsDone(): Optional<BetaResponseMcpCallArgumentsDoneEvent> =
        Optional.ofNullable(responseMcpCallArgumentsDone)

    /** Emitted when an MCP tool call has completed successfully. */
    fun responseMcpCallCompleted(): Optional<BetaResponseMcpCallCompletedEvent> =
        Optional.ofNullable(responseMcpCallCompleted)

    /** Emitted when an MCP tool call has failed. */
    fun responseMcpCallFailed(): Optional<BetaResponseMcpCallFailedEvent> =
        Optional.ofNullable(responseMcpCallFailed)

    /** Emitted when an MCP tool call is in progress. */
    fun responseMcpCallInProgress(): Optional<BetaResponseMcpCallInProgressEvent> =
        Optional.ofNullable(responseMcpCallInProgress)

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun responseMcpListToolsCompleted(): Optional<BetaResponseMcpListToolsCompletedEvent> =
        Optional.ofNullable(responseMcpListToolsCompleted)

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun responseMcpListToolsFailed(): Optional<BetaResponseMcpListToolsFailedEvent> =
        Optional.ofNullable(responseMcpListToolsFailed)

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun responseMcpListToolsInProgress(): Optional<BetaResponseMcpListToolsInProgressEvent> =
        Optional.ofNullable(responseMcpListToolsInProgress)

    /** Emitted when an annotation is added to output text content. */
    fun responseOutputTextAnnotationAdded(): Optional<BetaResponseOutputTextAnnotationAddedEvent> =
        Optional.ofNullable(responseOutputTextAnnotationAdded)

    /** Emitted when a response is queued and waiting to be processed. */
    fun responseQueued(): Optional<BetaResponseQueuedEvent> = Optional.ofNullable(responseQueued)

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun responseCustomToolCallInputDelta(): Optional<BetaResponseCustomToolCallInputDeltaEvent> =
        Optional.ofNullable(responseCustomToolCallInputDelta)

    /** Event indicating that input for a custom tool call is complete. */
    fun responseCustomToolCallInputDone(): Optional<BetaResponseCustomToolCallInputDoneEvent> =
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
    fun asResponseAudioDelta(): BetaResponseAudioDeltaEvent =
        responseAudioDelta.getOrThrow("responseAudioDelta")

    /** Emitted when the audio response is complete. */
    fun asResponseAudioDone(): BetaResponseAudioDoneEvent =
        responseAudioDone.getOrThrow("responseAudioDone")

    /** Emitted when there is a partial transcript of audio. */
    fun asResponseAudioTranscriptDelta(): BetaResponseAudioTranscriptDeltaEvent =
        responseAudioTranscriptDelta.getOrThrow("responseAudioTranscriptDelta")

    /** Emitted when the full audio transcript is completed. */
    fun asResponseAudioTranscriptDone(): BetaResponseAudioTranscriptDoneEvent =
        responseAudioTranscriptDone.getOrThrow("responseAudioTranscriptDone")

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDelta(): BetaResponseCodeInterpreterCallCodeDeltaEvent =
        responseCodeInterpreterCallCodeDelta.getOrThrow("responseCodeInterpreterCallCodeDelta")

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDone(): BetaResponseCodeInterpreterCallCodeDoneEvent =
        responseCodeInterpreterCallCodeDone.getOrThrow("responseCodeInterpreterCallCodeDone")

    /** Emitted when the code interpreter call is completed. */
    fun asResponseCodeInterpreterCallCompleted(): BetaResponseCodeInterpreterCallCompletedEvent =
        responseCodeInterpreterCallCompleted.getOrThrow("responseCodeInterpreterCallCompleted")

    /** Emitted when a code interpreter call is in progress. */
    fun asResponseCodeInterpreterCallInProgress(): BetaResponseCodeInterpreterCallInProgressEvent =
        responseCodeInterpreterCallInProgress.getOrThrow("responseCodeInterpreterCallInProgress")

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun asResponseCodeInterpreterCallInterpreting():
        BetaResponseCodeInterpreterCallInterpretingEvent =
        responseCodeInterpreterCallInterpreting.getOrThrow(
            "responseCodeInterpreterCallInterpreting"
        )

    /** Emitted when the model response is complete. */
    fun asResponseCompleted(): BetaResponseCompletedEvent =
        responseCompleted.getOrThrow("responseCompleted")

    /** Emitted when a new content part is added. */
    fun asResponseContentPartAdded(): BetaResponseContentPartAddedEvent =
        responseContentPartAdded.getOrThrow("responseContentPartAdded")

    /** Emitted when a content part is done. */
    fun asResponseContentPartDone(): BetaResponseContentPartDoneEvent =
        responseContentPartDone.getOrThrow("responseContentPartDone")

    /** An event that is emitted when a response is created. */
    fun asResponseCreated(): BetaResponseCreatedEvent =
        responseCreated.getOrThrow("responseCreated")

    /** Emitted when an error occurs. */
    fun asError(): BetaResponseErrorEvent = error.getOrThrow("error")

    /** Emitted when a file search call is completed (results found). */
    fun asResponseFileSearchCallCompleted(): BetaResponseFileSearchCallCompletedEvent =
        responseFileSearchCallCompleted.getOrThrow("responseFileSearchCallCompleted")

    /** Emitted when a file search call is initiated. */
    fun asResponseFileSearchCallInProgress(): BetaResponseFileSearchCallInProgressEvent =
        responseFileSearchCallInProgress.getOrThrow("responseFileSearchCallInProgress")

    /** Emitted when a file search is currently searching. */
    fun asResponseFileSearchCallSearching(): BetaResponseFileSearchCallSearchingEvent =
        responseFileSearchCallSearching.getOrThrow("responseFileSearchCallSearching")

    /** Emitted when there is a partial function-call arguments delta. */
    fun asResponseFunctionCallArgumentsDelta(): BetaResponseFunctionCallArgumentsDeltaEvent =
        responseFunctionCallArgumentsDelta.getOrThrow("responseFunctionCallArgumentsDelta")

    /** Emitted when function-call arguments are finalized. */
    fun asResponseFunctionCallArgumentsDone(): BetaResponseFunctionCallArgumentsDoneEvent =
        responseFunctionCallArgumentsDone.getOrThrow("responseFunctionCallArgumentsDone")

    /** Emitted when the response is in progress. */
    fun asResponseInProgress(): BetaResponseInProgressEvent =
        responseInProgress.getOrThrow("responseInProgress")

    /** An event that is emitted when a response fails. */
    fun asResponseFailed(): BetaResponseFailedEvent = responseFailed.getOrThrow("responseFailed")

    /** An event that is emitted when a response finishes as incomplete. */
    fun asResponseIncomplete(): BetaResponseIncompleteEvent =
        responseIncomplete.getOrThrow("responseIncomplete")

    /** Emitted when a new output item is added. */
    fun asResponseOutputItemAdded(): BetaResponseOutputItemAddedEvent =
        responseOutputItemAdded.getOrThrow("responseOutputItemAdded")

    /** Emitted when an output item is marked done. */
    fun asResponseOutputItemDone(): BetaResponseOutputItemDoneEvent =
        responseOutputItemDone.getOrThrow("responseOutputItemDone")

    /** Emitted when a new reasoning summary part is added. */
    fun asResponseReasoningSummaryPartAdded(): BetaResponseReasoningSummaryPartAddedEvent =
        responseReasoningSummaryPartAdded.getOrThrow("responseReasoningSummaryPartAdded")

    /** Emitted when a reasoning summary part is completed. */
    fun asResponseReasoningSummaryPartDone(): BetaResponseReasoningSummaryPartDoneEvent =
        responseReasoningSummaryPartDone.getOrThrow("responseReasoningSummaryPartDone")

    /** Emitted when a delta is added to a reasoning summary text. */
    fun asResponseReasoningSummaryTextDelta(): BetaResponseReasoningSummaryTextDeltaEvent =
        responseReasoningSummaryTextDelta.getOrThrow("responseReasoningSummaryTextDelta")

    /** Emitted when a reasoning summary text is completed. */
    fun asResponseReasoningSummaryTextDone(): BetaResponseReasoningSummaryTextDoneEvent =
        responseReasoningSummaryTextDone.getOrThrow("responseReasoningSummaryTextDone")

    /** Emitted when a delta is added to a reasoning text. */
    fun asResponseReasoningTextDelta(): BetaResponseReasoningTextDeltaEvent =
        responseReasoningTextDelta.getOrThrow("responseReasoningTextDelta")

    /** Emitted when a reasoning text is completed. */
    fun asResponseReasoningTextDone(): BetaResponseReasoningTextDoneEvent =
        responseReasoningTextDone.getOrThrow("responseReasoningTextDone")

    /** Emitted when there is a partial refusal text. */
    fun asResponseRefusalDelta(): BetaResponseRefusalDeltaEvent =
        responseRefusalDelta.getOrThrow("responseRefusalDelta")

    /** Emitted when refusal text is finalized. */
    fun asResponseRefusalDone(): BetaResponseRefusalDoneEvent =
        responseRefusalDone.getOrThrow("responseRefusalDone")

    /** Emitted when there is an additional text delta. */
    fun asResponseOutputTextDelta(): BetaResponseTextDeltaEvent =
        responseOutputTextDelta.getOrThrow("responseOutputTextDelta")

    /** Emitted when text content is finalized. */
    fun asResponseOutputTextDone(): BetaResponseTextDoneEvent =
        responseOutputTextDone.getOrThrow("responseOutputTextDone")

    /** Emitted when a web search call is completed. */
    fun asResponseWebSearchCallCompleted(): BetaResponseWebSearchCallCompletedEvent =
        responseWebSearchCallCompleted.getOrThrow("responseWebSearchCallCompleted")

    /** Emitted when a web search call is initiated. */
    fun asResponseWebSearchCallInProgress(): BetaResponseWebSearchCallInProgressEvent =
        responseWebSearchCallInProgress.getOrThrow("responseWebSearchCallInProgress")

    /** Emitted when a web search call is executing. */
    fun asResponseWebSearchCallSearching(): BetaResponseWebSearchCallSearchingEvent =
        responseWebSearchCallSearching.getOrThrow("responseWebSearchCallSearching")

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun asResponseImageGenerationCallCompleted(): BetaResponseImageGenCallCompletedEvent =
        responseImageGenerationCallCompleted.getOrThrow("responseImageGenerationCallCompleted")

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun asResponseImageGenerationCallGenerating(): BetaResponseImageGenCallGeneratingEvent =
        responseImageGenerationCallGenerating.getOrThrow("responseImageGenerationCallGenerating")

    /** Emitted when an image generation tool call is in progress. */
    fun asResponseImageGenerationCallInProgress(): BetaResponseImageGenCallInProgressEvent =
        responseImageGenerationCallInProgress.getOrThrow("responseImageGenerationCallInProgress")

    /** Emitted when a partial image is available during image generation streaming. */
    fun asResponseImageGenerationCallPartialImage(): BetaResponseImageGenCallPartialImageEvent =
        responseImageGenerationCallPartialImage.getOrThrow(
            "responseImageGenerationCallPartialImage"
        )

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun asResponseMcpCallArgumentsDelta(): BetaResponseMcpCallArgumentsDeltaEvent =
        responseMcpCallArgumentsDelta.getOrThrow("responseMcpCallArgumentsDelta")

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun asResponseMcpCallArgumentsDone(): BetaResponseMcpCallArgumentsDoneEvent =
        responseMcpCallArgumentsDone.getOrThrow("responseMcpCallArgumentsDone")

    /** Emitted when an MCP tool call has completed successfully. */
    fun asResponseMcpCallCompleted(): BetaResponseMcpCallCompletedEvent =
        responseMcpCallCompleted.getOrThrow("responseMcpCallCompleted")

    /** Emitted when an MCP tool call has failed. */
    fun asResponseMcpCallFailed(): BetaResponseMcpCallFailedEvent =
        responseMcpCallFailed.getOrThrow("responseMcpCallFailed")

    /** Emitted when an MCP tool call is in progress. */
    fun asResponseMcpCallInProgress(): BetaResponseMcpCallInProgressEvent =
        responseMcpCallInProgress.getOrThrow("responseMcpCallInProgress")

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun asResponseMcpListToolsCompleted(): BetaResponseMcpListToolsCompletedEvent =
        responseMcpListToolsCompleted.getOrThrow("responseMcpListToolsCompleted")

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun asResponseMcpListToolsFailed(): BetaResponseMcpListToolsFailedEvent =
        responseMcpListToolsFailed.getOrThrow("responseMcpListToolsFailed")

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun asResponseMcpListToolsInProgress(): BetaResponseMcpListToolsInProgressEvent =
        responseMcpListToolsInProgress.getOrThrow("responseMcpListToolsInProgress")

    /** Emitted when an annotation is added to output text content. */
    fun asResponseOutputTextAnnotationAdded(): BetaResponseOutputTextAnnotationAddedEvent =
        responseOutputTextAnnotationAdded.getOrThrow("responseOutputTextAnnotationAdded")

    /** Emitted when a response is queued and waiting to be processed. */
    fun asResponseQueued(): BetaResponseQueuedEvent = responseQueued.getOrThrow("responseQueued")

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun asResponseCustomToolCallInputDelta(): BetaResponseCustomToolCallInputDeltaEvent =
        responseCustomToolCallInputDelta.getOrThrow("responseCustomToolCallInputDelta")

    /** Event indicating that input for a custom tool call is complete. */
    fun asResponseCustomToolCallInputDone(): BetaResponseCustomToolCallInputDoneEvent =
        responseCustomToolCallInputDone.getOrThrow("responseCustomToolCallInputDone")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = betaResponseStreamEvent.accept(new BetaResponseStreamEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitResponseAudioDelta(BetaResponseAudioDeltaEvent responseAudioDelta) {
     *         return Optional.of(responseAudioDelta.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponseStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitResponseAudioDelta(
                    responseAudioDelta: BetaResponseAudioDeltaEvent
                ) {
                    responseAudioDelta.validate()
                }

                override fun visitResponseAudioDone(responseAudioDone: BetaResponseAudioDoneEvent) {
                    responseAudioDone.validate()
                }

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent
                ) {
                    responseAudioTranscriptDelta.validate()
                }

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent
                ) {
                    responseAudioTranscriptDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta:
                        BetaResponseCodeInterpreterCallCodeDeltaEvent
                ) {
                    responseCodeInterpreterCallCodeDelta.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone:
                        BetaResponseCodeInterpreterCallCodeDoneEvent
                ) {
                    responseCodeInterpreterCallCodeDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted:
                        BetaResponseCodeInterpreterCallCompletedEvent
                ) {
                    responseCodeInterpreterCallCompleted.validate()
                }

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress:
                        BetaResponseCodeInterpreterCallInProgressEvent
                ) {
                    responseCodeInterpreterCallInProgress.validate()
                }

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        BetaResponseCodeInterpreterCallInterpretingEvent
                ) {
                    responseCodeInterpreterCallInterpreting.validate()
                }

                override fun visitResponseCompleted(responseCompleted: BetaResponseCompletedEvent) {
                    responseCompleted.validate()
                }

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: BetaResponseContentPartAddedEvent
                ) {
                    responseContentPartAdded.validate()
                }

                override fun visitResponseContentPartDone(
                    responseContentPartDone: BetaResponseContentPartDoneEvent
                ) {
                    responseContentPartDone.validate()
                }

                override fun visitResponseCreated(responseCreated: BetaResponseCreatedEvent) {
                    responseCreated.validate()
                }

                override fun visitError(error: BetaResponseErrorEvent) {
                    error.validate()
                }

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent
                ) {
                    responseFileSearchCallCompleted.validate()
                }

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent
                ) {
                    responseFileSearchCallInProgress.validate()
                }

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent
                ) {
                    responseFileSearchCallSearching.validate()
                }

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent
                ) {
                    responseFunctionCallArgumentsDelta.validate()
                }

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent
                ) {
                    responseFunctionCallArgumentsDone.validate()
                }

                override fun visitResponseInProgress(
                    responseInProgress: BetaResponseInProgressEvent
                ) {
                    responseInProgress.validate()
                }

                override fun visitResponseFailed(responseFailed: BetaResponseFailedEvent) {
                    responseFailed.validate()
                }

                override fun visitResponseIncomplete(
                    responseIncomplete: BetaResponseIncompleteEvent
                ) {
                    responseIncomplete.validate()
                }

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: BetaResponseOutputItemAddedEvent
                ) {
                    responseOutputItemAdded.validate()
                }

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: BetaResponseOutputItemDoneEvent
                ) {
                    responseOutputItemDone.validate()
                }

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent
                ) {
                    responseReasoningSummaryPartAdded.validate()
                }

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent
                ) {
                    responseReasoningSummaryPartDone.validate()
                }

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent
                ) {
                    responseReasoningSummaryTextDelta.validate()
                }

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent
                ) {
                    responseReasoningSummaryTextDone.validate()
                }

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent
                ) {
                    responseReasoningTextDelta.validate()
                }

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: BetaResponseReasoningTextDoneEvent
                ) {
                    responseReasoningTextDone.validate()
                }

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: BetaResponseRefusalDeltaEvent
                ) {
                    responseRefusalDelta.validate()
                }

                override fun visitResponseRefusalDone(
                    responseRefusalDone: BetaResponseRefusalDoneEvent
                ) {
                    responseRefusalDone.validate()
                }

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: BetaResponseTextDeltaEvent
                ) {
                    responseOutputTextDelta.validate()
                }

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: BetaResponseTextDoneEvent
                ) {
                    responseOutputTextDone.validate()
                }

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent
                ) {
                    responseWebSearchCallCompleted.validate()
                }

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent
                ) {
                    responseWebSearchCallInProgress.validate()
                }

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent
                ) {
                    responseWebSearchCallSearching.validate()
                }

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent
                ) {
                    responseImageGenerationCallCompleted.validate()
                }

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: BetaResponseImageGenCallGeneratingEvent
                ) {
                    responseImageGenerationCallGenerating.validate()
                }

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent
                ) {
                    responseImageGenerationCallInProgress.validate()
                }

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage:
                        BetaResponseImageGenCallPartialImageEvent
                ) {
                    responseImageGenerationCallPartialImage.validate()
                }

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent
                ) {
                    responseMcpCallArgumentsDelta.validate()
                }

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent
                ) {
                    responseMcpCallArgumentsDone.validate()
                }

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent
                ) {
                    responseMcpCallCompleted.validate()
                }

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: BetaResponseMcpCallFailedEvent
                ) {
                    responseMcpCallFailed.validate()
                }

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent
                ) {
                    responseMcpCallInProgress.validate()
                }

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent
                ) {
                    responseMcpListToolsCompleted.validate()
                }

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent
                ) {
                    responseMcpListToolsFailed.validate()
                }

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent
                ) {
                    responseMcpListToolsInProgress.validate()
                }

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent
                ) {
                    responseOutputTextAnnotationAdded.validate()
                }

                override fun visitResponseQueued(responseQueued: BetaResponseQueuedEvent) {
                    responseQueued.validate()
                }

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent
                ) {
                    responseCustomToolCallInputDelta.validate()
                }

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent
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
                override fun visitResponseAudioDelta(
                    responseAudioDelta: BetaResponseAudioDeltaEvent
                ) = responseAudioDelta.validity()

                override fun visitResponseAudioDone(responseAudioDone: BetaResponseAudioDoneEvent) =
                    responseAudioDone.validity()

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent
                ) = responseAudioTranscriptDelta.validity()

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent
                ) = responseAudioTranscriptDone.validity()

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta:
                        BetaResponseCodeInterpreterCallCodeDeltaEvent
                ) = responseCodeInterpreterCallCodeDelta.validity()

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone:
                        BetaResponseCodeInterpreterCallCodeDoneEvent
                ) = responseCodeInterpreterCallCodeDone.validity()

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted:
                        BetaResponseCodeInterpreterCallCompletedEvent
                ) = responseCodeInterpreterCallCompleted.validity()

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress:
                        BetaResponseCodeInterpreterCallInProgressEvent
                ) = responseCodeInterpreterCallInProgress.validity()

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        BetaResponseCodeInterpreterCallInterpretingEvent
                ) = responseCodeInterpreterCallInterpreting.validity()

                override fun visitResponseCompleted(responseCompleted: BetaResponseCompletedEvent) =
                    responseCompleted.validity()

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: BetaResponseContentPartAddedEvent
                ) = responseContentPartAdded.validity()

                override fun visitResponseContentPartDone(
                    responseContentPartDone: BetaResponseContentPartDoneEvent
                ) = responseContentPartDone.validity()

                override fun visitResponseCreated(responseCreated: BetaResponseCreatedEvent) =
                    responseCreated.validity()

                override fun visitError(error: BetaResponseErrorEvent) = error.validity()

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent
                ) = responseFileSearchCallCompleted.validity()

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent
                ) = responseFileSearchCallInProgress.validity()

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent
                ) = responseFileSearchCallSearching.validity()

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent
                ) = responseFunctionCallArgumentsDelta.validity()

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent
                ) = responseFunctionCallArgumentsDone.validity()

                override fun visitResponseInProgress(
                    responseInProgress: BetaResponseInProgressEvent
                ) = responseInProgress.validity()

                override fun visitResponseFailed(responseFailed: BetaResponseFailedEvent) =
                    responseFailed.validity()

                override fun visitResponseIncomplete(
                    responseIncomplete: BetaResponseIncompleteEvent
                ) = responseIncomplete.validity()

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: BetaResponseOutputItemAddedEvent
                ) = responseOutputItemAdded.validity()

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: BetaResponseOutputItemDoneEvent
                ) = responseOutputItemDone.validity()

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent
                ) = responseReasoningSummaryPartAdded.validity()

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent
                ) = responseReasoningSummaryPartDone.validity()

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent
                ) = responseReasoningSummaryTextDelta.validity()

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent
                ) = responseReasoningSummaryTextDone.validity()

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent
                ) = responseReasoningTextDelta.validity()

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: BetaResponseReasoningTextDoneEvent
                ) = responseReasoningTextDone.validity()

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: BetaResponseRefusalDeltaEvent
                ) = responseRefusalDelta.validity()

                override fun visitResponseRefusalDone(
                    responseRefusalDone: BetaResponseRefusalDoneEvent
                ) = responseRefusalDone.validity()

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: BetaResponseTextDeltaEvent
                ) = responseOutputTextDelta.validity()

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: BetaResponseTextDoneEvent
                ) = responseOutputTextDone.validity()

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent
                ) = responseWebSearchCallCompleted.validity()

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent
                ) = responseWebSearchCallInProgress.validity()

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent
                ) = responseWebSearchCallSearching.validity()

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent
                ) = responseImageGenerationCallCompleted.validity()

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: BetaResponseImageGenCallGeneratingEvent
                ) = responseImageGenerationCallGenerating.validity()

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent
                ) = responseImageGenerationCallInProgress.validity()

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage:
                        BetaResponseImageGenCallPartialImageEvent
                ) = responseImageGenerationCallPartialImage.validity()

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent
                ) = responseMcpCallArgumentsDelta.validity()

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent
                ) = responseMcpCallArgumentsDone.validity()

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent
                ) = responseMcpCallCompleted.validity()

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: BetaResponseMcpCallFailedEvent
                ) = responseMcpCallFailed.validity()

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent
                ) = responseMcpCallInProgress.validity()

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent
                ) = responseMcpListToolsCompleted.validity()

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent
                ) = responseMcpListToolsFailed.validity()

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent
                ) = responseMcpListToolsInProgress.validity()

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent
                ) = responseOutputTextAnnotationAdded.validity()

                override fun visitResponseQueued(responseQueued: BetaResponseQueuedEvent) =
                    responseQueued.validity()

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent
                ) = responseCustomToolCallInputDelta.validity()

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent
                ) = responseCustomToolCallInputDone.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseStreamEvent &&
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
                "BetaResponseStreamEvent{responseAudioDelta=$responseAudioDelta}"
            responseAudioDone != null ->
                "BetaResponseStreamEvent{responseAudioDone=$responseAudioDone}"
            responseAudioTranscriptDelta != null ->
                "BetaResponseStreamEvent{responseAudioTranscriptDelta=$responseAudioTranscriptDelta}"
            responseAudioTranscriptDone != null ->
                "BetaResponseStreamEvent{responseAudioTranscriptDone=$responseAudioTranscriptDone}"
            responseCodeInterpreterCallCodeDelta != null ->
                "BetaResponseStreamEvent{responseCodeInterpreterCallCodeDelta=$responseCodeInterpreterCallCodeDelta}"
            responseCodeInterpreterCallCodeDone != null ->
                "BetaResponseStreamEvent{responseCodeInterpreterCallCodeDone=$responseCodeInterpreterCallCodeDone}"
            responseCodeInterpreterCallCompleted != null ->
                "BetaResponseStreamEvent{responseCodeInterpreterCallCompleted=$responseCodeInterpreterCallCompleted}"
            responseCodeInterpreterCallInProgress != null ->
                "BetaResponseStreamEvent{responseCodeInterpreterCallInProgress=$responseCodeInterpreterCallInProgress}"
            responseCodeInterpreterCallInterpreting != null ->
                "BetaResponseStreamEvent{responseCodeInterpreterCallInterpreting=$responseCodeInterpreterCallInterpreting}"
            responseCompleted != null ->
                "BetaResponseStreamEvent{responseCompleted=$responseCompleted}"
            responseContentPartAdded != null ->
                "BetaResponseStreamEvent{responseContentPartAdded=$responseContentPartAdded}"
            responseContentPartDone != null ->
                "BetaResponseStreamEvent{responseContentPartDone=$responseContentPartDone}"
            responseCreated != null -> "BetaResponseStreamEvent{responseCreated=$responseCreated}"
            error != null -> "BetaResponseStreamEvent{error=$error}"
            responseFileSearchCallCompleted != null ->
                "BetaResponseStreamEvent{responseFileSearchCallCompleted=$responseFileSearchCallCompleted}"
            responseFileSearchCallInProgress != null ->
                "BetaResponseStreamEvent{responseFileSearchCallInProgress=$responseFileSearchCallInProgress}"
            responseFileSearchCallSearching != null ->
                "BetaResponseStreamEvent{responseFileSearchCallSearching=$responseFileSearchCallSearching}"
            responseFunctionCallArgumentsDelta != null ->
                "BetaResponseStreamEvent{responseFunctionCallArgumentsDelta=$responseFunctionCallArgumentsDelta}"
            responseFunctionCallArgumentsDone != null ->
                "BetaResponseStreamEvent{responseFunctionCallArgumentsDone=$responseFunctionCallArgumentsDone}"
            responseInProgress != null ->
                "BetaResponseStreamEvent{responseInProgress=$responseInProgress}"
            responseFailed != null -> "BetaResponseStreamEvent{responseFailed=$responseFailed}"
            responseIncomplete != null ->
                "BetaResponseStreamEvent{responseIncomplete=$responseIncomplete}"
            responseOutputItemAdded != null ->
                "BetaResponseStreamEvent{responseOutputItemAdded=$responseOutputItemAdded}"
            responseOutputItemDone != null ->
                "BetaResponseStreamEvent{responseOutputItemDone=$responseOutputItemDone}"
            responseReasoningSummaryPartAdded != null ->
                "BetaResponseStreamEvent{responseReasoningSummaryPartAdded=$responseReasoningSummaryPartAdded}"
            responseReasoningSummaryPartDone != null ->
                "BetaResponseStreamEvent{responseReasoningSummaryPartDone=$responseReasoningSummaryPartDone}"
            responseReasoningSummaryTextDelta != null ->
                "BetaResponseStreamEvent{responseReasoningSummaryTextDelta=$responseReasoningSummaryTextDelta}"
            responseReasoningSummaryTextDone != null ->
                "BetaResponseStreamEvent{responseReasoningSummaryTextDone=$responseReasoningSummaryTextDone}"
            responseReasoningTextDelta != null ->
                "BetaResponseStreamEvent{responseReasoningTextDelta=$responseReasoningTextDelta}"
            responseReasoningTextDone != null ->
                "BetaResponseStreamEvent{responseReasoningTextDone=$responseReasoningTextDone}"
            responseRefusalDelta != null ->
                "BetaResponseStreamEvent{responseRefusalDelta=$responseRefusalDelta}"
            responseRefusalDone != null ->
                "BetaResponseStreamEvent{responseRefusalDone=$responseRefusalDone}"
            responseOutputTextDelta != null ->
                "BetaResponseStreamEvent{responseOutputTextDelta=$responseOutputTextDelta}"
            responseOutputTextDone != null ->
                "BetaResponseStreamEvent{responseOutputTextDone=$responseOutputTextDone}"
            responseWebSearchCallCompleted != null ->
                "BetaResponseStreamEvent{responseWebSearchCallCompleted=$responseWebSearchCallCompleted}"
            responseWebSearchCallInProgress != null ->
                "BetaResponseStreamEvent{responseWebSearchCallInProgress=$responseWebSearchCallInProgress}"
            responseWebSearchCallSearching != null ->
                "BetaResponseStreamEvent{responseWebSearchCallSearching=$responseWebSearchCallSearching}"
            responseImageGenerationCallCompleted != null ->
                "BetaResponseStreamEvent{responseImageGenerationCallCompleted=$responseImageGenerationCallCompleted}"
            responseImageGenerationCallGenerating != null ->
                "BetaResponseStreamEvent{responseImageGenerationCallGenerating=$responseImageGenerationCallGenerating}"
            responseImageGenerationCallInProgress != null ->
                "BetaResponseStreamEvent{responseImageGenerationCallInProgress=$responseImageGenerationCallInProgress}"
            responseImageGenerationCallPartialImage != null ->
                "BetaResponseStreamEvent{responseImageGenerationCallPartialImage=$responseImageGenerationCallPartialImage}"
            responseMcpCallArgumentsDelta != null ->
                "BetaResponseStreamEvent{responseMcpCallArgumentsDelta=$responseMcpCallArgumentsDelta}"
            responseMcpCallArgumentsDone != null ->
                "BetaResponseStreamEvent{responseMcpCallArgumentsDone=$responseMcpCallArgumentsDone}"
            responseMcpCallCompleted != null ->
                "BetaResponseStreamEvent{responseMcpCallCompleted=$responseMcpCallCompleted}"
            responseMcpCallFailed != null ->
                "BetaResponseStreamEvent{responseMcpCallFailed=$responseMcpCallFailed}"
            responseMcpCallInProgress != null ->
                "BetaResponseStreamEvent{responseMcpCallInProgress=$responseMcpCallInProgress}"
            responseMcpListToolsCompleted != null ->
                "BetaResponseStreamEvent{responseMcpListToolsCompleted=$responseMcpListToolsCompleted}"
            responseMcpListToolsFailed != null ->
                "BetaResponseStreamEvent{responseMcpListToolsFailed=$responseMcpListToolsFailed}"
            responseMcpListToolsInProgress != null ->
                "BetaResponseStreamEvent{responseMcpListToolsInProgress=$responseMcpListToolsInProgress}"
            responseOutputTextAnnotationAdded != null ->
                "BetaResponseStreamEvent{responseOutputTextAnnotationAdded=$responseOutputTextAnnotationAdded}"
            responseQueued != null -> "BetaResponseStreamEvent{responseQueued=$responseQueued}"
            responseCustomToolCallInputDelta != null ->
                "BetaResponseStreamEvent{responseCustomToolCallInputDelta=$responseCustomToolCallInputDelta}"
            responseCustomToolCallInputDone != null ->
                "BetaResponseStreamEvent{responseCustomToolCallInputDone=$responseCustomToolCallInputDone}"
            _json != null -> "BetaResponseStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponseStreamEvent")
        }

    companion object {

        /** Emitted when there is a partial audio response. */
        @JvmStatic
        fun ofResponseAudioDelta(responseAudioDelta: BetaResponseAudioDeltaEvent) =
            BetaResponseStreamEvent(responseAudioDelta = responseAudioDelta)

        /** Emitted when the audio response is complete. */
        @JvmStatic
        fun ofResponseAudioDone(responseAudioDone: BetaResponseAudioDoneEvent) =
            BetaResponseStreamEvent(responseAudioDone = responseAudioDone)

        /** Emitted when there is a partial transcript of audio. */
        @JvmStatic
        fun ofResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent
        ) = BetaResponseStreamEvent(responseAudioTranscriptDelta = responseAudioTranscriptDelta)

        /** Emitted when the full audio transcript is completed. */
        @JvmStatic
        fun ofResponseAudioTranscriptDone(
            responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent
        ) = BetaResponseStreamEvent(responseAudioTranscriptDone = responseAudioTranscriptDone)

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: BetaResponseCodeInterpreterCallCodeDeltaEvent
        ) =
            BetaResponseStreamEvent(
                responseCodeInterpreterCallCodeDelta = responseCodeInterpreterCallCodeDelta
            )

        /** Emitted when the code snippet is finalized by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: BetaResponseCodeInterpreterCallCodeDoneEvent
        ) =
            BetaResponseStreamEvent(
                responseCodeInterpreterCallCodeDone = responseCodeInterpreterCallCodeDone
            )

        /** Emitted when the code interpreter call is completed. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: BetaResponseCodeInterpreterCallCompletedEvent
        ) =
            BetaResponseStreamEvent(
                responseCodeInterpreterCallCompleted = responseCodeInterpreterCallCompleted
            )

        /** Emitted when a code interpreter call is in progress. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: BetaResponseCodeInterpreterCallInProgressEvent
        ) =
            BetaResponseStreamEvent(
                responseCodeInterpreterCallInProgress = responseCodeInterpreterCallInProgress
            )

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting:
                BetaResponseCodeInterpreterCallInterpretingEvent
        ) =
            BetaResponseStreamEvent(
                responseCodeInterpreterCallInterpreting = responseCodeInterpreterCallInterpreting
            )

        /** Emitted when the model response is complete. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: BetaResponseCompletedEvent) =
            BetaResponseStreamEvent(responseCompleted = responseCompleted)

        /** Emitted when a new content part is added. */
        @JvmStatic
        fun ofResponseContentPartAdded(
            responseContentPartAdded: BetaResponseContentPartAddedEvent
        ) = BetaResponseStreamEvent(responseContentPartAdded = responseContentPartAdded)

        /** Emitted when a content part is done. */
        @JvmStatic
        fun ofResponseContentPartDone(responseContentPartDone: BetaResponseContentPartDoneEvent) =
            BetaResponseStreamEvent(responseContentPartDone = responseContentPartDone)

        /** An event that is emitted when a response is created. */
        @JvmStatic
        fun ofResponseCreated(responseCreated: BetaResponseCreatedEvent) =
            BetaResponseStreamEvent(responseCreated = responseCreated)

        /** Emitted when an error occurs. */
        @JvmStatic
        fun ofError(error: BetaResponseErrorEvent) = BetaResponseStreamEvent(error = error)

        /** Emitted when a file search call is completed (results found). */
        @JvmStatic
        fun ofResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent
        ) =
            BetaResponseStreamEvent(
                responseFileSearchCallCompleted = responseFileSearchCallCompleted
            )

        /** Emitted when a file search call is initiated. */
        @JvmStatic
        fun ofResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent
        ) =
            BetaResponseStreamEvent(
                responseFileSearchCallInProgress = responseFileSearchCallInProgress
            )

        /** Emitted when a file search is currently searching. */
        @JvmStatic
        fun ofResponseFileSearchCallSearching(
            responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent
        ) =
            BetaResponseStreamEvent(
                responseFileSearchCallSearching = responseFileSearchCallSearching
            )

        /** Emitted when there is a partial function-call arguments delta. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent
        ) =
            BetaResponseStreamEvent(
                responseFunctionCallArgumentsDelta = responseFunctionCallArgumentsDelta
            )

        /** Emitted when function-call arguments are finalized. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent
        ) =
            BetaResponseStreamEvent(
                responseFunctionCallArgumentsDone = responseFunctionCallArgumentsDone
            )

        /** Emitted when the response is in progress. */
        @JvmStatic
        fun ofResponseInProgress(responseInProgress: BetaResponseInProgressEvent) =
            BetaResponseStreamEvent(responseInProgress = responseInProgress)

        /** An event that is emitted when a response fails. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: BetaResponseFailedEvent) =
            BetaResponseStreamEvent(responseFailed = responseFailed)

        /** An event that is emitted when a response finishes as incomplete. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: BetaResponseIncompleteEvent) =
            BetaResponseStreamEvent(responseIncomplete = responseIncomplete)

        /** Emitted when a new output item is added. */
        @JvmStatic
        fun ofResponseOutputItemAdded(responseOutputItemAdded: BetaResponseOutputItemAddedEvent) =
            BetaResponseStreamEvent(responseOutputItemAdded = responseOutputItemAdded)

        /** Emitted when an output item is marked done. */
        @JvmStatic
        fun ofResponseOutputItemDone(responseOutputItemDone: BetaResponseOutputItemDoneEvent) =
            BetaResponseStreamEvent(responseOutputItemDone = responseOutputItemDone)

        /** Emitted when a new reasoning summary part is added. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent
        ) =
            BetaResponseStreamEvent(
                responseReasoningSummaryPartAdded = responseReasoningSummaryPartAdded
            )

        /** Emitted when a reasoning summary part is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent
        ) =
            BetaResponseStreamEvent(
                responseReasoningSummaryPartDone = responseReasoningSummaryPartDone
            )

        /** Emitted when a delta is added to a reasoning summary text. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent
        ) =
            BetaResponseStreamEvent(
                responseReasoningSummaryTextDelta = responseReasoningSummaryTextDelta
            )

        /** Emitted when a reasoning summary text is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent
        ) =
            BetaResponseStreamEvent(
                responseReasoningSummaryTextDone = responseReasoningSummaryTextDone
            )

        /** Emitted when a delta is added to a reasoning text. */
        @JvmStatic
        fun ofResponseReasoningTextDelta(
            responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent
        ) = BetaResponseStreamEvent(responseReasoningTextDelta = responseReasoningTextDelta)

        /** Emitted when a reasoning text is completed. */
        @JvmStatic
        fun ofResponseReasoningTextDone(
            responseReasoningTextDone: BetaResponseReasoningTextDoneEvent
        ) = BetaResponseStreamEvent(responseReasoningTextDone = responseReasoningTextDone)

        /** Emitted when there is a partial refusal text. */
        @JvmStatic
        fun ofResponseRefusalDelta(responseRefusalDelta: BetaResponseRefusalDeltaEvent) =
            BetaResponseStreamEvent(responseRefusalDelta = responseRefusalDelta)

        /** Emitted when refusal text is finalized. */
        @JvmStatic
        fun ofResponseRefusalDone(responseRefusalDone: BetaResponseRefusalDoneEvent) =
            BetaResponseStreamEvent(responseRefusalDone = responseRefusalDone)

        /** Emitted when there is an additional text delta. */
        @JvmStatic
        fun ofResponseOutputTextDelta(responseOutputTextDelta: BetaResponseTextDeltaEvent) =
            BetaResponseStreamEvent(responseOutputTextDelta = responseOutputTextDelta)

        /** Emitted when text content is finalized. */
        @JvmStatic
        fun ofResponseOutputTextDone(responseOutputTextDone: BetaResponseTextDoneEvent) =
            BetaResponseStreamEvent(responseOutputTextDone = responseOutputTextDone)

        /** Emitted when a web search call is completed. */
        @JvmStatic
        fun ofResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent
        ) = BetaResponseStreamEvent(responseWebSearchCallCompleted = responseWebSearchCallCompleted)

        /** Emitted when a web search call is initiated. */
        @JvmStatic
        fun ofResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent
        ) =
            BetaResponseStreamEvent(
                responseWebSearchCallInProgress = responseWebSearchCallInProgress
            )

        /** Emitted when a web search call is executing. */
        @JvmStatic
        fun ofResponseWebSearchCallSearching(
            responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent
        ) = BetaResponseStreamEvent(responseWebSearchCallSearching = responseWebSearchCallSearching)

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        @JvmStatic
        fun ofResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent
        ) =
            BetaResponseStreamEvent(
                responseImageGenerationCallCompleted = responseImageGenerationCallCompleted
            )

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        @JvmStatic
        fun ofResponseImageGenerationCallGenerating(
            responseImageGenerationCallGenerating: BetaResponseImageGenCallGeneratingEvent
        ) =
            BetaResponseStreamEvent(
                responseImageGenerationCallGenerating = responseImageGenerationCallGenerating
            )

        /** Emitted when an image generation tool call is in progress. */
        @JvmStatic
        fun ofResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent
        ) =
            BetaResponseStreamEvent(
                responseImageGenerationCallInProgress = responseImageGenerationCallInProgress
            )

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: BetaResponseImageGenCallPartialImageEvent
        ) =
            BetaResponseStreamEvent(
                responseImageGenerationCallPartialImage = responseImageGenerationCallPartialImage
            )

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent
        ) = BetaResponseStreamEvent(responseMcpCallArgumentsDelta = responseMcpCallArgumentsDelta)

        /** Emitted when the arguments for an MCP tool call are finalized. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent
        ) = BetaResponseStreamEvent(responseMcpCallArgumentsDone = responseMcpCallArgumentsDone)

        /** Emitted when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofResponseMcpCallCompleted(
            responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent
        ) = BetaResponseStreamEvent(responseMcpCallCompleted = responseMcpCallCompleted)

        /** Emitted when an MCP tool call has failed. */
        @JvmStatic
        fun ofResponseMcpCallFailed(responseMcpCallFailed: BetaResponseMcpCallFailedEvent) =
            BetaResponseStreamEvent(responseMcpCallFailed = responseMcpCallFailed)

        /** Emitted when an MCP tool call is in progress. */
        @JvmStatic
        fun ofResponseMcpCallInProgress(
            responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent
        ) = BetaResponseStreamEvent(responseMcpCallInProgress = responseMcpCallInProgress)

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        @JvmStatic
        fun ofResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent
        ) = BetaResponseStreamEvent(responseMcpListToolsCompleted = responseMcpListToolsCompleted)

        /** Emitted when the attempt to list available MCP tools has failed. */
        @JvmStatic
        fun ofResponseMcpListToolsFailed(
            responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent
        ) = BetaResponseStreamEvent(responseMcpListToolsFailed = responseMcpListToolsFailed)

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        @JvmStatic
        fun ofResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent
        ) = BetaResponseStreamEvent(responseMcpListToolsInProgress = responseMcpListToolsInProgress)

        /** Emitted when an annotation is added to output text content. */
        @JvmStatic
        fun ofResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent
        ) =
            BetaResponseStreamEvent(
                responseOutputTextAnnotationAdded = responseOutputTextAnnotationAdded
            )

        /** Emitted when a response is queued and waiting to be processed. */
        @JvmStatic
        fun ofResponseQueued(responseQueued: BetaResponseQueuedEvent) =
            BetaResponseStreamEvent(responseQueued = responseQueued)

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent
        ) =
            BetaResponseStreamEvent(
                responseCustomToolCallInputDelta = responseCustomToolCallInputDelta
            )

        /** Event indicating that input for a custom tool call is complete. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent
        ) =
            BetaResponseStreamEvent(
                responseCustomToolCallInputDone = responseCustomToolCallInputDone
            )
    }

    /**
     * An interface that defines how to map each variant of [BetaResponseStreamEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Emitted when there is a partial audio response. */
        fun visitResponseAudioDelta(responseAudioDelta: BetaResponseAudioDeltaEvent): T

        /** Emitted when the audio response is complete. */
        fun visitResponseAudioDone(responseAudioDone: BetaResponseAudioDoneEvent): T

        /** Emitted when there is a partial transcript of audio. */
        fun visitResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent
        ): T

        /** Emitted when the full audio transcript is completed. */
        fun visitResponseAudioTranscriptDone(
            responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent
        ): T

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: BetaResponseCodeInterpreterCallCodeDeltaEvent
        ): T

        /** Emitted when the code snippet is finalized by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: BetaResponseCodeInterpreterCallCodeDoneEvent
        ): T

        /** Emitted when the code interpreter call is completed. */
        fun visitResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: BetaResponseCodeInterpreterCallCompletedEvent
        ): T

        /** Emitted when a code interpreter call is in progress. */
        fun visitResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: BetaResponseCodeInterpreterCallInProgressEvent
        ): T

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        fun visitResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting:
                BetaResponseCodeInterpreterCallInterpretingEvent
        ): T

        /** Emitted when the model response is complete. */
        fun visitResponseCompleted(responseCompleted: BetaResponseCompletedEvent): T

        /** Emitted when a new content part is added. */
        fun visitResponseContentPartAdded(
            responseContentPartAdded: BetaResponseContentPartAddedEvent
        ): T

        /** Emitted when a content part is done. */
        fun visitResponseContentPartDone(
            responseContentPartDone: BetaResponseContentPartDoneEvent
        ): T

        /** An event that is emitted when a response is created. */
        fun visitResponseCreated(responseCreated: BetaResponseCreatedEvent): T

        /** Emitted when an error occurs. */
        fun visitError(error: BetaResponseErrorEvent): T

        /** Emitted when a file search call is completed (results found). */
        fun visitResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent
        ): T

        /** Emitted when a file search call is initiated. */
        fun visitResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent
        ): T

        /** Emitted when a file search is currently searching. */
        fun visitResponseFileSearchCallSearching(
            responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent
        ): T

        /** Emitted when there is a partial function-call arguments delta. */
        fun visitResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent
        ): T

        /** Emitted when function-call arguments are finalized. */
        fun visitResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent
        ): T

        /** Emitted when the response is in progress. */
        fun visitResponseInProgress(responseInProgress: BetaResponseInProgressEvent): T

        /** An event that is emitted when a response fails. */
        fun visitResponseFailed(responseFailed: BetaResponseFailedEvent): T

        /** An event that is emitted when a response finishes as incomplete. */
        fun visitResponseIncomplete(responseIncomplete: BetaResponseIncompleteEvent): T

        /** Emitted when a new output item is added. */
        fun visitResponseOutputItemAdded(
            responseOutputItemAdded: BetaResponseOutputItemAddedEvent
        ): T

        /** Emitted when an output item is marked done. */
        fun visitResponseOutputItemDone(responseOutputItemDone: BetaResponseOutputItemDoneEvent): T

        /** Emitted when a new reasoning summary part is added. */
        fun visitResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent
        ): T

        /** Emitted when a reasoning summary part is completed. */
        fun visitResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning summary text. */
        fun visitResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent
        ): T

        /** Emitted when a reasoning summary text is completed. */
        fun visitResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent
        ): T

        /** Emitted when a delta is added to a reasoning text. */
        fun visitResponseReasoningTextDelta(
            responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent
        ): T

        /** Emitted when a reasoning text is completed. */
        fun visitResponseReasoningTextDone(
            responseReasoningTextDone: BetaResponseReasoningTextDoneEvent
        ): T

        /** Emitted when there is a partial refusal text. */
        fun visitResponseRefusalDelta(responseRefusalDelta: BetaResponseRefusalDeltaEvent): T

        /** Emitted when refusal text is finalized. */
        fun visitResponseRefusalDone(responseRefusalDone: BetaResponseRefusalDoneEvent): T

        /** Emitted when there is an additional text delta. */
        fun visitResponseOutputTextDelta(responseOutputTextDelta: BetaResponseTextDeltaEvent): T

        /** Emitted when text content is finalized. */
        fun visitResponseOutputTextDone(responseOutputTextDone: BetaResponseTextDoneEvent): T

        /** Emitted when a web search call is completed. */
        fun visitResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent
        ): T

        /** Emitted when a web search call is initiated. */
        fun visitResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent
        ): T

        /** Emitted when a web search call is executing. */
        fun visitResponseWebSearchCallSearching(
            responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent
        ): T

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        fun visitResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent
        ): T

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        fun visitResponseImageGenerationCallGenerating(
            responseImageGenerationCallGenerating: BetaResponseImageGenCallGeneratingEvent
        ): T

        /** Emitted when an image generation tool call is in progress. */
        fun visitResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent
        ): T

        /** Emitted when a partial image is available during image generation streaming. */
        fun visitResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: BetaResponseImageGenCallPartialImageEvent
        ): T

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        fun visitResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent
        ): T

        /** Emitted when the arguments for an MCP tool call are finalized. */
        fun visitResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent
        ): T

        /** Emitted when an MCP tool call has completed successfully. */
        fun visitResponseMcpCallCompleted(
            responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent
        ): T

        /** Emitted when an MCP tool call has failed. */
        fun visitResponseMcpCallFailed(responseMcpCallFailed: BetaResponseMcpCallFailedEvent): T

        /** Emitted when an MCP tool call is in progress. */
        fun visitResponseMcpCallInProgress(
            responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent
        ): T

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        fun visitResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent
        ): T

        /** Emitted when the attempt to list available MCP tools has failed. */
        fun visitResponseMcpListToolsFailed(
            responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent
        ): T

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        fun visitResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent
        ): T

        /** Emitted when an annotation is added to output text content. */
        fun visitResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent
        ): T

        /** Emitted when a response is queued and waiting to be processed. */
        fun visitResponseQueued(responseQueued: BetaResponseQueuedEvent): T

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        fun visitResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent
        ): T

        /** Event indicating that input for a custom tool call is complete. */
        fun visitResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent
        ): T

        /**
         * Maps an unknown variant of [BetaResponseStreamEvent] to a value of type [T].
         *
         * An instance of [BetaResponseStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponseStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BetaResponseStreamEvent>(BetaResponseStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponseStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "response.audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseAudioDeltaEvent>())
                        ?.let { BetaResponseStreamEvent(responseAudioDelta = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseAudioDoneEvent>())?.let {
                        BetaResponseStreamEvent(responseAudioDone = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.audio.transcript.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseAudioTranscriptDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseAudioTranscriptDelta = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.audio.transcript.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseAudioTranscriptDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseAudioTranscriptDone = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call_code.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCodeInterpreterCallCodeDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call_code.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCodeInterpreterCallCodeDone = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCodeInterpreterCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCodeInterpreterCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.code_interpreter_call.interpreting" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallInterpretingEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCodeInterpreterCallInterpreting = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCompletedEvent>())?.let {
                        BetaResponseStreamEvent(responseCompleted = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseContentPartAddedEvent>())
                        ?.let {
                            BetaResponseStreamEvent(responseContentPartAdded = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseContentPartDoneEvent>())
                        ?.let {
                            BetaResponseStreamEvent(responseContentPartDone = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCreatedEvent>())?.let {
                        BetaResponseStreamEvent(responseCreated = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseErrorEvent>())?.let {
                        BetaResponseStreamEvent(error = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.file_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseFileSearchCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.file_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseFileSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.file_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseFileSearchCallSearching = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseFunctionCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.function_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseFunctionCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInProgressEvent>())
                        ?.let { BetaResponseStreamEvent(responseInProgress = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFailedEvent>())?.let {
                        BetaResponseStreamEvent(responseFailed = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseIncompleteEvent>())
                        ?.let { BetaResponseStreamEvent(responseIncomplete = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputItemAddedEvent>())
                        ?.let {
                            BetaResponseStreamEvent(responseOutputItemAdded = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputItemDoneEvent>())
                        ?.let { BetaResponseStreamEvent(responseOutputItemDone = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryPartAddedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseReasoningSummaryPartAdded = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryPartDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseReasoningSummaryPartDone = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryTextDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseReasoningSummaryTextDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_summary_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryTextDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseReasoningSummaryTextDone = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningTextDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseReasoningTextDelta = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.reasoning_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningTextDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseReasoningTextDone = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.refusal.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseRefusalDeltaEvent>())
                        ?.let { BetaResponseStreamEvent(responseRefusalDelta = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.refusal.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseRefusalDoneEvent>())
                        ?.let { BetaResponseStreamEvent(responseRefusalDone = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseTextDeltaEvent>())?.let {
                        BetaResponseStreamEvent(responseOutputTextDelta = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseTextDoneEvent>())?.let {
                        BetaResponseStreamEvent(responseOutputTextDone = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.web_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseWebSearchCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.web_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseWebSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.web_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseWebSearchCallSearching = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseImageGenerationCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.generating" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallGeneratingEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseImageGenerationCallGenerating = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseImageGenerationCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.image_generation_call.partial_image" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallPartialImageEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseImageGenerationCallPartialImage = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseMcpCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseMcpCallArgumentsDone = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseMcpCallCompletedEvent>())
                        ?.let {
                            BetaResponseStreamEvent(responseMcpCallCompleted = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseMcpCallFailedEvent>())
                        ?.let { BetaResponseStreamEvent(responseMcpCallFailed = it, _json = json) }
                        ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseMcpCallInProgress = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseMcpListToolsCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.failed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsFailedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(responseMcpListToolsFailed = it, _json = json)
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.mcp_list_tools.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseMcpListToolsInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.output_text.annotation.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseOutputTextAnnotationAddedEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseOutputTextAnnotationAdded = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseQueuedEvent>())?.let {
                        BetaResponseStreamEvent(responseQueued = it, _json = json)
                    } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.custom_tool_call_input.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCustomToolCallInputDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCustomToolCallInputDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
                "response.custom_tool_call_input.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCustomToolCallInputDoneEvent>(),
                        )
                        ?.let {
                            BetaResponseStreamEvent(
                                responseCustomToolCallInputDone = it,
                                _json = json,
                            )
                        } ?: BetaResponseStreamEvent(_json = json)
                }
            }

            return BetaResponseStreamEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<BetaResponseStreamEvent>(BetaResponseStreamEvent::class) {

        override fun serialize(
            value: BetaResponseStreamEvent,
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
                else -> throw IllegalStateException("Invalid BetaResponseStreamEvent")
            }
        }
    }
}
