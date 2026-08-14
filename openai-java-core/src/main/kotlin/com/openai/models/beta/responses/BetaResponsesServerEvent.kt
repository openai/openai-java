// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

private fun Map<String, JsonValue>.streamId(): JsonField<String> =
    get("stream_id") ?: JsonMissing.of()

private fun JsonField<String>.asStreamId(): Optional<String> =
    if (isMissing() || isNull()) Optional.empty() else Optional.of(asStringOrThrow())

/** Server events emitted by the Responses WebSocket server. */
@JsonDeserialize(using = BetaResponsesServerEvent.Deserializer::class)
@JsonSerialize(using = BetaResponsesServerEvent.Serializer::class)
class BetaResponsesServerEvent
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
    private val error: BetaResponseWsError? = null,
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
    private val responseInjectCreated: BetaResponseInjectCreatedEvent? = null,
    private val responseInjectFailed: BetaResponseInjectFailedEvent? = null,
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
    fun error(): Optional<BetaResponseWsError> = Optional.ofNullable(error)

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

    /**
     * Emitted when all injected input items were validated and committed to the active response.
     */
    fun responseInjectCreated(): Optional<BetaResponseInjectCreatedEvent> =
        Optional.ofNullable(responseInjectCreated)

    /**
     * Emitted when injected input could not be committed to a response. The event returns the
     * uncommitted raw input so the client can retry it in another response when appropriate.
     */
    fun responseInjectFailed(): Optional<BetaResponseInjectFailedEvent> =
        Optional.ofNullable(responseInjectFailed)

    /**
     * The WebSocket lane that emitted this event. This field is present when the originating
     * `response.create` event supplied a `stream_id`.
     */
    fun streamId(): Optional<String> = streamIdField().asStreamId()

    private fun streamIdField(): JsonField<String> =
        _json?.asObject()?.getOrNull()?.get("stream_id")
            ?: when {
                responseAudioDelta != null -> responseAudioDelta._additionalProperties().streamId()
                responseAudioDone != null -> responseAudioDone._additionalProperties().streamId()
                responseAudioTranscriptDelta != null ->
                    responseAudioTranscriptDelta._additionalProperties().streamId()
                responseAudioTranscriptDone != null ->
                    responseAudioTranscriptDone._additionalProperties().streamId()
                responseCodeInterpreterCallCodeDelta != null ->
                    responseCodeInterpreterCallCodeDelta._additionalProperties().streamId()
                responseCodeInterpreterCallCodeDone != null ->
                    responseCodeInterpreterCallCodeDone._additionalProperties().streamId()
                responseCodeInterpreterCallCompleted != null ->
                    responseCodeInterpreterCallCompleted._additionalProperties().streamId()
                responseCodeInterpreterCallInProgress != null ->
                    responseCodeInterpreterCallInProgress._additionalProperties().streamId()
                responseCodeInterpreterCallInterpreting != null ->
                    responseCodeInterpreterCallInterpreting._additionalProperties().streamId()
                responseCompleted != null -> responseCompleted._additionalProperties().streamId()
                responseContentPartAdded != null ->
                    responseContentPartAdded._additionalProperties().streamId()
                responseContentPartDone != null ->
                    responseContentPartDone._additionalProperties().streamId()
                responseCreated != null -> responseCreated._additionalProperties().streamId()
                error != null -> error._additionalProperties().streamId()
                responseFileSearchCallCompleted != null ->
                    responseFileSearchCallCompleted._additionalProperties().streamId()
                responseFileSearchCallInProgress != null ->
                    responseFileSearchCallInProgress._additionalProperties().streamId()
                responseFileSearchCallSearching != null ->
                    responseFileSearchCallSearching._additionalProperties().streamId()
                responseFunctionCallArgumentsDelta != null ->
                    responseFunctionCallArgumentsDelta._additionalProperties().streamId()
                responseFunctionCallArgumentsDone != null ->
                    responseFunctionCallArgumentsDone._additionalProperties().streamId()
                responseInProgress != null -> responseInProgress._additionalProperties().streamId()
                responseFailed != null -> responseFailed._additionalProperties().streamId()
                responseIncomplete != null -> responseIncomplete._additionalProperties().streamId()
                responseOutputItemAdded != null ->
                    responseOutputItemAdded._additionalProperties().streamId()
                responseOutputItemDone != null ->
                    responseOutputItemDone._additionalProperties().streamId()
                responseReasoningSummaryPartAdded != null ->
                    responseReasoningSummaryPartAdded._additionalProperties().streamId()
                responseReasoningSummaryPartDone != null ->
                    responseReasoningSummaryPartDone._additionalProperties().streamId()
                responseReasoningSummaryTextDelta != null ->
                    responseReasoningSummaryTextDelta._additionalProperties().streamId()
                responseReasoningSummaryTextDone != null ->
                    responseReasoningSummaryTextDone._additionalProperties().streamId()
                responseReasoningTextDelta != null ->
                    responseReasoningTextDelta._additionalProperties().streamId()
                responseReasoningTextDone != null ->
                    responseReasoningTextDone._additionalProperties().streamId()
                responseRefusalDelta != null ->
                    responseRefusalDelta._additionalProperties().streamId()
                responseRefusalDone != null ->
                    responseRefusalDone._additionalProperties().streamId()
                responseOutputTextDelta != null ->
                    responseOutputTextDelta._additionalProperties().streamId()
                responseOutputTextDone != null ->
                    responseOutputTextDone._additionalProperties().streamId()
                responseWebSearchCallCompleted != null ->
                    responseWebSearchCallCompleted._additionalProperties().streamId()
                responseWebSearchCallInProgress != null ->
                    responseWebSearchCallInProgress._additionalProperties().streamId()
                responseWebSearchCallSearching != null ->
                    responseWebSearchCallSearching._additionalProperties().streamId()
                responseImageGenerationCallCompleted != null ->
                    responseImageGenerationCallCompleted._additionalProperties().streamId()
                responseImageGenerationCallGenerating != null ->
                    responseImageGenerationCallGenerating._additionalProperties().streamId()
                responseImageGenerationCallInProgress != null ->
                    responseImageGenerationCallInProgress._additionalProperties().streamId()
                responseImageGenerationCallPartialImage != null ->
                    responseImageGenerationCallPartialImage._additionalProperties().streamId()
                responseMcpCallArgumentsDelta != null ->
                    responseMcpCallArgumentsDelta._additionalProperties().streamId()
                responseMcpCallArgumentsDone != null ->
                    responseMcpCallArgumentsDone._additionalProperties().streamId()
                responseMcpCallCompleted != null ->
                    responseMcpCallCompleted._additionalProperties().streamId()
                responseMcpCallFailed != null ->
                    responseMcpCallFailed._additionalProperties().streamId()
                responseMcpCallInProgress != null ->
                    responseMcpCallInProgress._additionalProperties().streamId()
                responseMcpListToolsCompleted != null ->
                    responseMcpListToolsCompleted._additionalProperties().streamId()
                responseMcpListToolsFailed != null ->
                    responseMcpListToolsFailed._additionalProperties().streamId()
                responseMcpListToolsInProgress != null ->
                    responseMcpListToolsInProgress._additionalProperties().streamId()
                responseOutputTextAnnotationAdded != null ->
                    responseOutputTextAnnotationAdded._additionalProperties().streamId()
                responseQueued != null -> responseQueued._additionalProperties().streamId()
                responseCustomToolCallInputDelta != null ->
                    responseCustomToolCallInputDelta._additionalProperties().streamId()
                responseCustomToolCallInputDone != null ->
                    responseCustomToolCallInputDone._additionalProperties().streamId()
                responseInjectCreated != null -> responseInjectCreated._streamId()
                responseInjectFailed != null -> responseInjectFailed._streamId()
                else -> JsonMissing.of()
            }

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

    fun isResponseInjectCreated(): Boolean = responseInjectCreated != null

    fun isResponseInjectFailed(): Boolean = responseInjectFailed != null

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
    fun asError(): BetaResponseWsError = error.getOrThrow("error")

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

    /**
     * Emitted when all injected input items were validated and committed to the active response.
     */
    fun asResponseInjectCreated(): BetaResponseInjectCreatedEvent =
        responseInjectCreated.getOrThrow("responseInjectCreated")

    /**
     * Emitted when injected input could not be committed to a response. The event returns the
     * uncommitted raw input so the client can retry it in another response when appropriate.
     */
    fun asResponseInjectFailed(): BetaResponseInjectFailedEvent =
        responseInjectFailed.getOrThrow("responseInjectFailed")

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
     * Optional<String> result = betaResponsesServerEvent.accept(new BetaResponsesServerEvent.Visitor<Optional<String>>() {
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
            responseInjectCreated != null ->
                visitor.visitResponseInjectCreated(responseInjectCreated)
            responseInjectFailed != null -> visitor.visitResponseInjectFailed(responseInjectFailed)
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
    fun validate(): BetaResponsesServerEvent = apply {
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

                override fun visitError(error: BetaResponseWsError) {
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

                override fun visitResponseInjectCreated(
                    responseInjectCreated: BetaResponseInjectCreatedEvent
                ) {
                    responseInjectCreated.validate()
                }

                override fun visitResponseInjectFailed(
                    responseInjectFailed: BetaResponseInjectFailedEvent
                ) {
                    responseInjectFailed.validate()
                }
            }
        )
        streamId()
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

                override fun visitError(error: BetaResponseWsError) = error.validity()

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

                override fun visitResponseInjectCreated(
                    responseInjectCreated: BetaResponseInjectCreatedEvent
                ) = responseInjectCreated.validity()

                override fun visitResponseInjectFailed(
                    responseInjectFailed: BetaResponseInjectFailedEvent
                ) = responseInjectFailed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponsesServerEvent &&
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
            responseCustomToolCallInputDone == other.responseCustomToolCallInputDone &&
            responseInjectCreated == other.responseInjectCreated &&
            responseInjectFailed == other.responseInjectFailed
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
            responseInjectCreated,
            responseInjectFailed,
        )

    override fun toString(): String =
        when {
            responseAudioDelta != null ->
                "BetaResponsesServerEvent{responseAudioDelta=$responseAudioDelta}"
            responseAudioDone != null ->
                "BetaResponsesServerEvent{responseAudioDone=$responseAudioDone}"
            responseAudioTranscriptDelta != null ->
                "BetaResponsesServerEvent{responseAudioTranscriptDelta=$responseAudioTranscriptDelta}"
            responseAudioTranscriptDone != null ->
                "BetaResponsesServerEvent{responseAudioTranscriptDone=$responseAudioTranscriptDone}"
            responseCodeInterpreterCallCodeDelta != null ->
                "BetaResponsesServerEvent{responseCodeInterpreterCallCodeDelta=$responseCodeInterpreterCallCodeDelta}"
            responseCodeInterpreterCallCodeDone != null ->
                "BetaResponsesServerEvent{responseCodeInterpreterCallCodeDone=$responseCodeInterpreterCallCodeDone}"
            responseCodeInterpreterCallCompleted != null ->
                "BetaResponsesServerEvent{responseCodeInterpreterCallCompleted=$responseCodeInterpreterCallCompleted}"
            responseCodeInterpreterCallInProgress != null ->
                "BetaResponsesServerEvent{responseCodeInterpreterCallInProgress=$responseCodeInterpreterCallInProgress}"
            responseCodeInterpreterCallInterpreting != null ->
                "BetaResponsesServerEvent{responseCodeInterpreterCallInterpreting=$responseCodeInterpreterCallInterpreting}"
            responseCompleted != null ->
                "BetaResponsesServerEvent{responseCompleted=$responseCompleted}"
            responseContentPartAdded != null ->
                "BetaResponsesServerEvent{responseContentPartAdded=$responseContentPartAdded}"
            responseContentPartDone != null ->
                "BetaResponsesServerEvent{responseContentPartDone=$responseContentPartDone}"
            responseCreated != null -> "BetaResponsesServerEvent{responseCreated=$responseCreated}"
            error != null -> "BetaResponsesServerEvent{error=$error}"
            responseFileSearchCallCompleted != null ->
                "BetaResponsesServerEvent{responseFileSearchCallCompleted=$responseFileSearchCallCompleted}"
            responseFileSearchCallInProgress != null ->
                "BetaResponsesServerEvent{responseFileSearchCallInProgress=$responseFileSearchCallInProgress}"
            responseFileSearchCallSearching != null ->
                "BetaResponsesServerEvent{responseFileSearchCallSearching=$responseFileSearchCallSearching}"
            responseFunctionCallArgumentsDelta != null ->
                "BetaResponsesServerEvent{responseFunctionCallArgumentsDelta=$responseFunctionCallArgumentsDelta}"
            responseFunctionCallArgumentsDone != null ->
                "BetaResponsesServerEvent{responseFunctionCallArgumentsDone=$responseFunctionCallArgumentsDone}"
            responseInProgress != null ->
                "BetaResponsesServerEvent{responseInProgress=$responseInProgress}"
            responseFailed != null -> "BetaResponsesServerEvent{responseFailed=$responseFailed}"
            responseIncomplete != null ->
                "BetaResponsesServerEvent{responseIncomplete=$responseIncomplete}"
            responseOutputItemAdded != null ->
                "BetaResponsesServerEvent{responseOutputItemAdded=$responseOutputItemAdded}"
            responseOutputItemDone != null ->
                "BetaResponsesServerEvent{responseOutputItemDone=$responseOutputItemDone}"
            responseReasoningSummaryPartAdded != null ->
                "BetaResponsesServerEvent{responseReasoningSummaryPartAdded=$responseReasoningSummaryPartAdded}"
            responseReasoningSummaryPartDone != null ->
                "BetaResponsesServerEvent{responseReasoningSummaryPartDone=$responseReasoningSummaryPartDone}"
            responseReasoningSummaryTextDelta != null ->
                "BetaResponsesServerEvent{responseReasoningSummaryTextDelta=$responseReasoningSummaryTextDelta}"
            responseReasoningSummaryTextDone != null ->
                "BetaResponsesServerEvent{responseReasoningSummaryTextDone=$responseReasoningSummaryTextDone}"
            responseReasoningTextDelta != null ->
                "BetaResponsesServerEvent{responseReasoningTextDelta=$responseReasoningTextDelta}"
            responseReasoningTextDone != null ->
                "BetaResponsesServerEvent{responseReasoningTextDone=$responseReasoningTextDone}"
            responseRefusalDelta != null ->
                "BetaResponsesServerEvent{responseRefusalDelta=$responseRefusalDelta}"
            responseRefusalDone != null ->
                "BetaResponsesServerEvent{responseRefusalDone=$responseRefusalDone}"
            responseOutputTextDelta != null ->
                "BetaResponsesServerEvent{responseOutputTextDelta=$responseOutputTextDelta}"
            responseOutputTextDone != null ->
                "BetaResponsesServerEvent{responseOutputTextDone=$responseOutputTextDone}"
            responseWebSearchCallCompleted != null ->
                "BetaResponsesServerEvent{responseWebSearchCallCompleted=$responseWebSearchCallCompleted}"
            responseWebSearchCallInProgress != null ->
                "BetaResponsesServerEvent{responseWebSearchCallInProgress=$responseWebSearchCallInProgress}"
            responseWebSearchCallSearching != null ->
                "BetaResponsesServerEvent{responseWebSearchCallSearching=$responseWebSearchCallSearching}"
            responseImageGenerationCallCompleted != null ->
                "BetaResponsesServerEvent{responseImageGenerationCallCompleted=$responseImageGenerationCallCompleted}"
            responseImageGenerationCallGenerating != null ->
                "BetaResponsesServerEvent{responseImageGenerationCallGenerating=$responseImageGenerationCallGenerating}"
            responseImageGenerationCallInProgress != null ->
                "BetaResponsesServerEvent{responseImageGenerationCallInProgress=$responseImageGenerationCallInProgress}"
            responseImageGenerationCallPartialImage != null ->
                "BetaResponsesServerEvent{responseImageGenerationCallPartialImage=$responseImageGenerationCallPartialImage}"
            responseMcpCallArgumentsDelta != null ->
                "BetaResponsesServerEvent{responseMcpCallArgumentsDelta=$responseMcpCallArgumentsDelta}"
            responseMcpCallArgumentsDone != null ->
                "BetaResponsesServerEvent{responseMcpCallArgumentsDone=$responseMcpCallArgumentsDone}"
            responseMcpCallCompleted != null ->
                "BetaResponsesServerEvent{responseMcpCallCompleted=$responseMcpCallCompleted}"
            responseMcpCallFailed != null ->
                "BetaResponsesServerEvent{responseMcpCallFailed=$responseMcpCallFailed}"
            responseMcpCallInProgress != null ->
                "BetaResponsesServerEvent{responseMcpCallInProgress=$responseMcpCallInProgress}"
            responseMcpListToolsCompleted != null ->
                "BetaResponsesServerEvent{responseMcpListToolsCompleted=$responseMcpListToolsCompleted}"
            responseMcpListToolsFailed != null ->
                "BetaResponsesServerEvent{responseMcpListToolsFailed=$responseMcpListToolsFailed}"
            responseMcpListToolsInProgress != null ->
                "BetaResponsesServerEvent{responseMcpListToolsInProgress=$responseMcpListToolsInProgress}"
            responseOutputTextAnnotationAdded != null ->
                "BetaResponsesServerEvent{responseOutputTextAnnotationAdded=$responseOutputTextAnnotationAdded}"
            responseQueued != null -> "BetaResponsesServerEvent{responseQueued=$responseQueued}"
            responseCustomToolCallInputDelta != null ->
                "BetaResponsesServerEvent{responseCustomToolCallInputDelta=$responseCustomToolCallInputDelta}"
            responseCustomToolCallInputDone != null ->
                "BetaResponsesServerEvent{responseCustomToolCallInputDone=$responseCustomToolCallInputDone}"
            responseInjectCreated != null ->
                "BetaResponsesServerEvent{responseInjectCreated=$responseInjectCreated}"
            responseInjectFailed != null ->
                "BetaResponsesServerEvent{responseInjectFailed=$responseInjectFailed}"
            _json != null -> "BetaResponsesServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponsesServerEvent")
        }

    companion object {

        /** Emitted when there is a partial audio response. */
        @JvmStatic
        fun ofResponseAudioDelta(responseAudioDelta: BetaResponseAudioDeltaEvent) =
            BetaResponsesServerEvent(responseAudioDelta = responseAudioDelta)

        /** Emitted when the audio response is complete. */
        @JvmStatic
        fun ofResponseAudioDone(responseAudioDone: BetaResponseAudioDoneEvent) =
            BetaResponsesServerEvent(responseAudioDone = responseAudioDone)

        /** Emitted when there is a partial transcript of audio. */
        @JvmStatic
        fun ofResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: BetaResponseAudioTranscriptDeltaEvent
        ) = BetaResponsesServerEvent(responseAudioTranscriptDelta = responseAudioTranscriptDelta)

        /** Emitted when the full audio transcript is completed. */
        @JvmStatic
        fun ofResponseAudioTranscriptDone(
            responseAudioTranscriptDone: BetaResponseAudioTranscriptDoneEvent
        ) = BetaResponsesServerEvent(responseAudioTranscriptDone = responseAudioTranscriptDone)

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: BetaResponseCodeInterpreterCallCodeDeltaEvent
        ) =
            BetaResponsesServerEvent(
                responseCodeInterpreterCallCodeDelta = responseCodeInterpreterCallCodeDelta
            )

        /** Emitted when the code snippet is finalized by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: BetaResponseCodeInterpreterCallCodeDoneEvent
        ) =
            BetaResponsesServerEvent(
                responseCodeInterpreterCallCodeDone = responseCodeInterpreterCallCodeDone
            )

        /** Emitted when the code interpreter call is completed. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: BetaResponseCodeInterpreterCallCompletedEvent
        ) =
            BetaResponsesServerEvent(
                responseCodeInterpreterCallCompleted = responseCodeInterpreterCallCompleted
            )

        /** Emitted when a code interpreter call is in progress. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: BetaResponseCodeInterpreterCallInProgressEvent
        ) =
            BetaResponsesServerEvent(
                responseCodeInterpreterCallInProgress = responseCodeInterpreterCallInProgress
            )

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting:
                BetaResponseCodeInterpreterCallInterpretingEvent
        ) =
            BetaResponsesServerEvent(
                responseCodeInterpreterCallInterpreting = responseCodeInterpreterCallInterpreting
            )

        /** Emitted when the model response is complete. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: BetaResponseCompletedEvent) =
            BetaResponsesServerEvent(responseCompleted = responseCompleted)

        /** Emitted when a new content part is added. */
        @JvmStatic
        fun ofResponseContentPartAdded(
            responseContentPartAdded: BetaResponseContentPartAddedEvent
        ) = BetaResponsesServerEvent(responseContentPartAdded = responseContentPartAdded)

        /** Emitted when a content part is done. */
        @JvmStatic
        fun ofResponseContentPartDone(responseContentPartDone: BetaResponseContentPartDoneEvent) =
            BetaResponsesServerEvent(responseContentPartDone = responseContentPartDone)

        /** An event that is emitted when a response is created. */
        @JvmStatic
        fun ofResponseCreated(responseCreated: BetaResponseCreatedEvent) =
            BetaResponsesServerEvent(responseCreated = responseCreated)

        /** Emitted when an error occurs. */
        @JvmStatic fun ofError(error: BetaResponseWsError) = BetaResponsesServerEvent(error = error)

        /** Emitted when a file search call is completed (results found). */
        @JvmStatic
        fun ofResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: BetaResponseFileSearchCallCompletedEvent
        ) =
            BetaResponsesServerEvent(
                responseFileSearchCallCompleted = responseFileSearchCallCompleted
            )

        /** Emitted when a file search call is initiated. */
        @JvmStatic
        fun ofResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: BetaResponseFileSearchCallInProgressEvent
        ) =
            BetaResponsesServerEvent(
                responseFileSearchCallInProgress = responseFileSearchCallInProgress
            )

        /** Emitted when a file search is currently searching. */
        @JvmStatic
        fun ofResponseFileSearchCallSearching(
            responseFileSearchCallSearching: BetaResponseFileSearchCallSearchingEvent
        ) =
            BetaResponsesServerEvent(
                responseFileSearchCallSearching = responseFileSearchCallSearching
            )

        /** Emitted when there is a partial function-call arguments delta. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: BetaResponseFunctionCallArgumentsDeltaEvent
        ) =
            BetaResponsesServerEvent(
                responseFunctionCallArgumentsDelta = responseFunctionCallArgumentsDelta
            )

        /** Emitted when function-call arguments are finalized. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: BetaResponseFunctionCallArgumentsDoneEvent
        ) =
            BetaResponsesServerEvent(
                responseFunctionCallArgumentsDone = responseFunctionCallArgumentsDone
            )

        /** Emitted when the response is in progress. */
        @JvmStatic
        fun ofResponseInProgress(responseInProgress: BetaResponseInProgressEvent) =
            BetaResponsesServerEvent(responseInProgress = responseInProgress)

        /** An event that is emitted when a response fails. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: BetaResponseFailedEvent) =
            BetaResponsesServerEvent(responseFailed = responseFailed)

        /** An event that is emitted when a response finishes as incomplete. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: BetaResponseIncompleteEvent) =
            BetaResponsesServerEvent(responseIncomplete = responseIncomplete)

        /** Emitted when a new output item is added. */
        @JvmStatic
        fun ofResponseOutputItemAdded(responseOutputItemAdded: BetaResponseOutputItemAddedEvent) =
            BetaResponsesServerEvent(responseOutputItemAdded = responseOutputItemAdded)

        /** Emitted when an output item is marked done. */
        @JvmStatic
        fun ofResponseOutputItemDone(responseOutputItemDone: BetaResponseOutputItemDoneEvent) =
            BetaResponsesServerEvent(responseOutputItemDone = responseOutputItemDone)

        /** Emitted when a new reasoning summary part is added. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: BetaResponseReasoningSummaryPartAddedEvent
        ) =
            BetaResponsesServerEvent(
                responseReasoningSummaryPartAdded = responseReasoningSummaryPartAdded
            )

        /** Emitted when a reasoning summary part is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: BetaResponseReasoningSummaryPartDoneEvent
        ) =
            BetaResponsesServerEvent(
                responseReasoningSummaryPartDone = responseReasoningSummaryPartDone
            )

        /** Emitted when a delta is added to a reasoning summary text. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: BetaResponseReasoningSummaryTextDeltaEvent
        ) =
            BetaResponsesServerEvent(
                responseReasoningSummaryTextDelta = responseReasoningSummaryTextDelta
            )

        /** Emitted when a reasoning summary text is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: BetaResponseReasoningSummaryTextDoneEvent
        ) =
            BetaResponsesServerEvent(
                responseReasoningSummaryTextDone = responseReasoningSummaryTextDone
            )

        /** Emitted when a delta is added to a reasoning text. */
        @JvmStatic
        fun ofResponseReasoningTextDelta(
            responseReasoningTextDelta: BetaResponseReasoningTextDeltaEvent
        ) = BetaResponsesServerEvent(responseReasoningTextDelta = responseReasoningTextDelta)

        /** Emitted when a reasoning text is completed. */
        @JvmStatic
        fun ofResponseReasoningTextDone(
            responseReasoningTextDone: BetaResponseReasoningTextDoneEvent
        ) = BetaResponsesServerEvent(responseReasoningTextDone = responseReasoningTextDone)

        /** Emitted when there is a partial refusal text. */
        @JvmStatic
        fun ofResponseRefusalDelta(responseRefusalDelta: BetaResponseRefusalDeltaEvent) =
            BetaResponsesServerEvent(responseRefusalDelta = responseRefusalDelta)

        /** Emitted when refusal text is finalized. */
        @JvmStatic
        fun ofResponseRefusalDone(responseRefusalDone: BetaResponseRefusalDoneEvent) =
            BetaResponsesServerEvent(responseRefusalDone = responseRefusalDone)

        /** Emitted when there is an additional text delta. */
        @JvmStatic
        fun ofResponseOutputTextDelta(responseOutputTextDelta: BetaResponseTextDeltaEvent) =
            BetaResponsesServerEvent(responseOutputTextDelta = responseOutputTextDelta)

        /** Emitted when text content is finalized. */
        @JvmStatic
        fun ofResponseOutputTextDone(responseOutputTextDone: BetaResponseTextDoneEvent) =
            BetaResponsesServerEvent(responseOutputTextDone = responseOutputTextDone)

        /** Emitted when a web search call is completed. */
        @JvmStatic
        fun ofResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: BetaResponseWebSearchCallCompletedEvent
        ) =
            BetaResponsesServerEvent(
                responseWebSearchCallCompleted = responseWebSearchCallCompleted
            )

        /** Emitted when a web search call is initiated. */
        @JvmStatic
        fun ofResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: BetaResponseWebSearchCallInProgressEvent
        ) =
            BetaResponsesServerEvent(
                responseWebSearchCallInProgress = responseWebSearchCallInProgress
            )

        /** Emitted when a web search call is executing. */
        @JvmStatic
        fun ofResponseWebSearchCallSearching(
            responseWebSearchCallSearching: BetaResponseWebSearchCallSearchingEvent
        ) =
            BetaResponsesServerEvent(
                responseWebSearchCallSearching = responseWebSearchCallSearching
            )

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        @JvmStatic
        fun ofResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: BetaResponseImageGenCallCompletedEvent
        ) =
            BetaResponsesServerEvent(
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
            BetaResponsesServerEvent(
                responseImageGenerationCallGenerating = responseImageGenerationCallGenerating
            )

        /** Emitted when an image generation tool call is in progress. */
        @JvmStatic
        fun ofResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: BetaResponseImageGenCallInProgressEvent
        ) =
            BetaResponsesServerEvent(
                responseImageGenerationCallInProgress = responseImageGenerationCallInProgress
            )

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: BetaResponseImageGenCallPartialImageEvent
        ) =
            BetaResponsesServerEvent(
                responseImageGenerationCallPartialImage = responseImageGenerationCallPartialImage
            )

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: BetaResponseMcpCallArgumentsDeltaEvent
        ) = BetaResponsesServerEvent(responseMcpCallArgumentsDelta = responseMcpCallArgumentsDelta)

        /** Emitted when the arguments for an MCP tool call are finalized. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: BetaResponseMcpCallArgumentsDoneEvent
        ) = BetaResponsesServerEvent(responseMcpCallArgumentsDone = responseMcpCallArgumentsDone)

        /** Emitted when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofResponseMcpCallCompleted(
            responseMcpCallCompleted: BetaResponseMcpCallCompletedEvent
        ) = BetaResponsesServerEvent(responseMcpCallCompleted = responseMcpCallCompleted)

        /** Emitted when an MCP tool call has failed. */
        @JvmStatic
        fun ofResponseMcpCallFailed(responseMcpCallFailed: BetaResponseMcpCallFailedEvent) =
            BetaResponsesServerEvent(responseMcpCallFailed = responseMcpCallFailed)

        /** Emitted when an MCP tool call is in progress. */
        @JvmStatic
        fun ofResponseMcpCallInProgress(
            responseMcpCallInProgress: BetaResponseMcpCallInProgressEvent
        ) = BetaResponsesServerEvent(responseMcpCallInProgress = responseMcpCallInProgress)

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        @JvmStatic
        fun ofResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: BetaResponseMcpListToolsCompletedEvent
        ) = BetaResponsesServerEvent(responseMcpListToolsCompleted = responseMcpListToolsCompleted)

        /** Emitted when the attempt to list available MCP tools has failed. */
        @JvmStatic
        fun ofResponseMcpListToolsFailed(
            responseMcpListToolsFailed: BetaResponseMcpListToolsFailedEvent
        ) = BetaResponsesServerEvent(responseMcpListToolsFailed = responseMcpListToolsFailed)

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        @JvmStatic
        fun ofResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: BetaResponseMcpListToolsInProgressEvent
        ) =
            BetaResponsesServerEvent(
                responseMcpListToolsInProgress = responseMcpListToolsInProgress
            )

        /** Emitted when an annotation is added to output text content. */
        @JvmStatic
        fun ofResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: BetaResponseOutputTextAnnotationAddedEvent
        ) =
            BetaResponsesServerEvent(
                responseOutputTextAnnotationAdded = responseOutputTextAnnotationAdded
            )

        /** Emitted when a response is queued and waiting to be processed. */
        @JvmStatic
        fun ofResponseQueued(responseQueued: BetaResponseQueuedEvent) =
            BetaResponsesServerEvent(responseQueued = responseQueued)

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: BetaResponseCustomToolCallInputDeltaEvent
        ) =
            BetaResponsesServerEvent(
                responseCustomToolCallInputDelta = responseCustomToolCallInputDelta
            )

        /** Event indicating that input for a custom tool call is complete. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: BetaResponseCustomToolCallInputDoneEvent
        ) =
            BetaResponsesServerEvent(
                responseCustomToolCallInputDone = responseCustomToolCallInputDone
            )

        /**
         * Emitted when all injected input items were validated and committed to the active
         * response.
         */
        @JvmStatic
        fun ofResponseInjectCreated(responseInjectCreated: BetaResponseInjectCreatedEvent) =
            BetaResponsesServerEvent(responseInjectCreated = responseInjectCreated)

        /**
         * Emitted when injected input could not be committed to a response. The event returns the
         * uncommitted raw input so the client can retry it in another response when appropriate.
         */
        @JvmStatic
        fun ofResponseInjectFailed(responseInjectFailed: BetaResponseInjectFailedEvent) =
            BetaResponsesServerEvent(responseInjectFailed = responseInjectFailed)
    }

    /**
     * An interface that defines how to map each variant of [BetaResponsesServerEvent] to a value of
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
        fun visitError(error: BetaResponseWsError): T

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
         * Emitted when all injected input items were validated and committed to the active
         * response.
         */
        fun visitResponseInjectCreated(responseInjectCreated: BetaResponseInjectCreatedEvent): T

        /**
         * Emitted when injected input could not be committed to a response. The event returns the
         * uncommitted raw input so the client can retry it in another response when appropriate.
         */
        fun visitResponseInjectFailed(responseInjectFailed: BetaResponseInjectFailedEvent): T

        /**
         * Maps an unknown variant of [BetaResponsesServerEvent] to a value of type [T].
         *
         * An instance of [BetaResponsesServerEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponsesServerEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BetaResponsesServerEvent>(BetaResponsesServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponsesServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "response.audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseAudioDeltaEvent>())
                        ?.let { BetaResponsesServerEvent(responseAudioDelta = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseAudioDoneEvent>())?.let {
                        BetaResponsesServerEvent(responseAudioDone = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseAudioTranscriptDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseAudioTranscriptDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseAudioTranscriptDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(responseAudioTranscriptDone = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call_code.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCodeInterpreterCallCodeDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call_code.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCodeDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCodeInterpreterCallCodeDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCodeInterpreterCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCodeInterpreterCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call.interpreting" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterCallInterpretingEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCodeInterpreterCallInterpreting = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCompletedEvent>())?.let {
                        BetaResponsesServerEvent(responseCompleted = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseContentPartAddedEvent>())
                        ?.let {
                            BetaResponsesServerEvent(responseContentPartAdded = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseContentPartDoneEvent>())
                        ?.let {
                            BetaResponsesServerEvent(responseContentPartDone = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCreatedEvent>())?.let {
                        BetaResponsesServerEvent(responseCreated = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseWsError>())?.let {
                        BetaResponsesServerEvent(error = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.file_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseFileSearchCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.file_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseFileSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.file_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFileSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseFileSearchCallSearching = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseFunctionCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.function_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseFunctionCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInProgressEvent>())
                        ?.let { BetaResponsesServerEvent(responseInProgress = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFailedEvent>())?.let {
                        BetaResponsesServerEvent(responseFailed = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseIncompleteEvent>())
                        ?.let { BetaResponsesServerEvent(responseIncomplete = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputItemAddedEvent>())
                        ?.let {
                            BetaResponsesServerEvent(responseOutputItemAdded = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputItemDoneEvent>())
                        ?.let {
                            BetaResponsesServerEvent(responseOutputItemDone = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryPartAddedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseReasoningSummaryPartAdded = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_part.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryPartDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseReasoningSummaryPartDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryTextDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseReasoningSummaryTextDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningSummaryTextDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseReasoningSummaryTextDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningTextDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(responseReasoningTextDelta = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseReasoningTextDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(responseReasoningTextDone = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.refusal.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseRefusalDeltaEvent>())
                        ?.let { BetaResponsesServerEvent(responseRefusalDelta = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.refusal.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseRefusalDoneEvent>())
                        ?.let { BetaResponsesServerEvent(responseRefusalDone = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseTextDeltaEvent>())?.let {
                        BetaResponsesServerEvent(responseOutputTextDelta = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseTextDoneEvent>())?.let {
                        BetaResponsesServerEvent(responseOutputTextDone = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.web_search_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseWebSearchCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.web_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseWebSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.web_search_call.searching" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseWebSearchCallSearchingEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseWebSearchCallSearching = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseImageGenerationCallCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.generating" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallGeneratingEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseImageGenerationCallGenerating = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseImageGenerationCallInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.partial_image" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseImageGenCallPartialImageEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseImageGenerationCallPartialImage = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseMcpCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseMcpCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseMcpCallCompletedEvent>())
                        ?.let {
                            BetaResponsesServerEvent(responseMcpCallCompleted = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseMcpCallFailedEvent>())
                        ?.let { BetaResponsesServerEvent(responseMcpCallFailed = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpCallInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(responseMcpCallInProgress = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsCompletedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseMcpListToolsCompleted = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.failed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsFailedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(responseMcpListToolsFailed = it, _json = json)
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseMcpListToolsInProgressEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseMcpListToolsInProgress = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.output_text.annotation.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseOutputTextAnnotationAddedEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseOutputTextAnnotationAdded = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseQueuedEvent>())?.let {
                        BetaResponsesServerEvent(responseQueued = it, _json = json)
                    } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCustomToolCallInputDeltaEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCustomToolCallInputDelta = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCustomToolCallInputDoneEvent>(),
                        )
                        ?.let {
                            BetaResponsesServerEvent(
                                responseCustomToolCallInputDone = it,
                                _json = json,
                            )
                        } ?: BetaResponsesServerEvent(_json = json)
                }
                "response.inject.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInjectCreatedEvent>())
                        ?.let { BetaResponsesServerEvent(responseInjectCreated = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
                "response.inject.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInjectFailedEvent>())
                        ?.let { BetaResponsesServerEvent(responseInjectFailed = it, _json = json) }
                        ?: BetaResponsesServerEvent(_json = json)
                }
            }

            return BetaResponsesServerEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<BetaResponsesServerEvent>(BetaResponsesServerEvent::class) {

        override fun serialize(
            value: BetaResponsesServerEvent,
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
                value.responseInjectCreated != null ->
                    generator.writeObject(value.responseInjectCreated)
                value.responseInjectFailed != null ->
                    generator.writeObject(value.responseInjectFailed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BetaResponsesServerEvent")
            }
        }
    }

    /** Emitted when an error occurs while processing a Responses WebSocket request. */
    class BetaResponseWsError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val error: JsonField<Error>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val sequenceNumber: JsonField<Long>,
        private val status: JsonField<Long>,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(error, type, agent, sequenceNumber, status, streamId, mutableMapOf())

        /**
         * Details about the error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun error(): Error = error.getRequired("error")

        /**
         * The type of the event. Always `error`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("error")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that owns this multi-agent streaming event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * The sequence number of an error emitted by the response stream.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sequenceNumber(): Optional<Long> = sequenceNumber.getOptional("sequence_number")

        /**
         * The HTTP status code associated with a WebSocket protocol error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Long> = status.getOptional("status")

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [sequenceNumber].
         *
         * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sequence_number")
        @ExcludeMissing
        fun _sequenceNumber(): JsonField<Long> = sequenceNumber

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Long> = status

        /**
         * Returns the raw JSON value of [streamId].
         *
         * Unlike [streamId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stream_id") @ExcludeMissing fun _streamId(): JsonField<String> = streamId

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [BetaResponseWsError].
             *
             * The following fields are required:
             * ```java
             * .error()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BetaResponseWsError]. */
        class Builder internal constructor() {

            private var error: JsonField<Error>? = null
            private var type: JsonValue = JsonValue.from("error")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var sequenceNumber: JsonField<Long> = JsonMissing.of()
            private var status: JsonField<Long> = JsonMissing.of()
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaResponseWsError: BetaResponseWsError) = apply {
                error = betaResponseWsError.error
                type = betaResponseWsError.type
                agent = betaResponseWsError.agent
                sequenceNumber = betaResponseWsError.sequenceNumber
                status = betaResponseWsError.status
                streamId = betaResponseWsError.streamId
                additionalProperties = betaResponseWsError.additionalProperties.toMutableMap()
            }

            /** Details about the error. */
            fun error(error: Error) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [Error] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun error(error: JsonField<Error>) = apply { this.error = error }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("error")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that owns this multi-agent streaming event. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /** The sequence number of an error emitted by the response stream. */
            fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

            /**
             * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
                this.sequenceNumber = sequenceNumber
            }

            /** The HTTP status code associated with a WebSocket protocol error. */
            fun status(status: Long) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun status(status: JsonField<Long>) = apply { this.status = status }

            /**
             * The WebSocket lane that emitted this event. This field is present when the
             * originating `response.create` event supplied a `stream_id`.
             */
            fun streamId(streamId: String) = streamId(JsonField.of(streamId))

            /**
             * Sets [Builder.streamId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streamId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun streamId(streamId: JsonField<String>) = apply { this.streamId = streamId }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [BetaResponseWsError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .error()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): BetaResponseWsError =
                BetaResponseWsError(
                    checkRequired("error", error),
                    type,
                    agent,
                    sequenceNumber,
                    status,
                    streamId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): BetaResponseWsError = apply {
            if (validated) {
                return@apply
            }

            error().validate()
            _type().let {
                if (it != JsonValue.from("error")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            sequenceNumber()
            status()
            streamId()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (error.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("error")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (streamId.asKnown().isPresent) 1 else 0)

        /** Details about the error. */
        class Error
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val code: JsonField<String>,
            private val message: JsonField<String>,
            private val param: JsonField<String>,
            private val type: JsonField<String>,
            private val headers: JsonField<Headers>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of(),
                @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("headers")
                @ExcludeMissing
                headers: JsonField<Headers> = JsonMissing.of(),
            ) : this(code, message, param, type, headers, mutableMapOf())

            /**
             * The error code that was emitted, if any.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun code(): Optional<String> = code.getOptional("code")

            /**
             * The human-readable error message that was emitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): String = message.getRequired("message")

            /**
             * The parameter name that was associated with the error, if any.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun param(): Optional<String> = param.getOptional("param")

            /**
             * The error type that was emitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): String = type.getRequired("type")

            /**
             * The response headers that were emitted with the error, if any.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun headers(): Optional<Headers> = headers.getOptional("headers")

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

            /**
             * Returns the raw JSON value of [param].
             *
             * Unlike [param], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [headers].
             *
             * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Error].
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * .param()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Error]. */
            class Builder internal constructor() {

                private var code: JsonField<String>? = null
                private var message: JsonField<String>? = null
                private var param: JsonField<String>? = null
                private var type: JsonField<String>? = null
                private var headers: JsonField<Headers> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(error: Error) = apply {
                    code = error.code
                    message = error.message
                    param = error.param
                    type = error.type
                    headers = error.headers
                    additionalProperties = error.additionalProperties.toMutableMap()
                }

                /** The error code that was emitted, if any. */
                fun code(code: String?) = code(JsonField.ofNullable(code))

                /** Alias for calling [Builder.code] with `code.orElse(null)`. */
                fun code(code: Optional<String>) = code(code.getOrNull())

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<String>) = apply { this.code = code }

                /** The human-readable error message that was emitted. */
                fun message(message: String) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<String>) = apply { this.message = message }

                /** The parameter name that was associated with the error, if any. */
                fun param(param: String?) = param(JsonField.ofNullable(param))

                /** Alias for calling [Builder.param] with `param.orElse(null)`. */
                fun param(param: Optional<String>) = param(param.getOrNull())

                /**
                 * Sets [Builder.param] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.param] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun param(param: JsonField<String>) = apply { this.param = param }

                /** The error type that was emitted. */
                fun type(type: String) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** The response headers that were emitted with the error, if any. */
                fun headers(headers: Headers) = headers(JsonField.of(headers))

                /**
                 * Sets [Builder.headers] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.headers] with a well-typed [Headers] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Error].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * .param()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Error =
                    Error(
                        checkRequired("code", code),
                        checkRequired("message", message),
                        checkRequired("param", param),
                        checkRequired("type", type),
                        headers,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Error = apply {
                if (validated) {
                    return@apply
                }

                code()
                message()
                param()
                type()
                headers().ifPresent { it.validate() }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (code.asKnown().isPresent) 1 else 0) +
                    (if (message.asKnown().isPresent) 1 else 0) +
                    (if (param.asKnown().isPresent) 1 else 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (headers.asKnown().getOrNull()?.validity() ?: 0)

            /** The response headers that were emitted with the error, if any. */
            class Headers
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Headers]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Headers]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(headers: Headers) = apply {
                        additionalProperties = headers.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Headers].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Headers = Headers(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Headers = apply {
                    if (validated) {
                        return@apply
                    }

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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Headers && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Headers{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Error &&
                    code == other.code &&
                    message == other.message &&
                    param == other.param &&
                    type == other.type &&
                    headers == other.headers &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(code, message, param, type, headers, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Error{code=$code, message=$message, param=$param, type=$type, headers=$headers, additionalProperties=$additionalProperties}"
        }

        /** The agent that owns this multi-agent streaming event. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BetaResponseWsError &&
                error == other.error &&
                type == other.type &&
                agent == other.agent &&
                sequenceNumber == other.sequenceNumber &&
                status == other.status &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(error, type, agent, sequenceNumber, status, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaResponseWsError{error=$error, type=$type, agent=$agent, sequenceNumber=$sequenceNumber, status=$status, streamId=$streamId, additionalProperties=$additionalProperties}"
    }
}
