// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

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
    private val responseFileSearchCallCompleted: ResponseFileSearchCallCompletedEvent? = null,
    private val responseFileSearchCallInProgress: ResponseFileSearchCallInProgressEvent? = null,
    private val responseFileSearchCallSearching: ResponseFileSearchCallSearchingEvent? = null,
    private val responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent? = null,
    private val responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent? = null,
    private val responseShellCallCommandAdded: ResponseShellCallCommandAddedEvent? = null,
    private val responseShellCallCommandDelta: ResponseShellCallCommandDeltaEvent? = null,
    private val responseShellCallCommandDone: ResponseShellCallCommandDoneEvent? = null,
    private val responseShellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent? =
        null,
    private val responseShellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent? = null,
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
    private val error: ResponseWsError? = null,
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

    /** A streaming event that indicated a shell command was added to a tool call. */
    fun responseShellCallCommandAdded(): Optional<ResponseShellCallCommandAddedEvent> =
        Optional.ofNullable(responseShellCallCommandAdded)

    /** A streaming event that indicated a shell command was incrementally updated. */
    fun responseShellCallCommandDelta(): Optional<ResponseShellCallCommandDeltaEvent> =
        Optional.ofNullable(responseShellCallCommandDelta)

    /** A streaming event that indicated a shell command was completed. */
    fun responseShellCallCommandDone(): Optional<ResponseShellCallCommandDoneEvent> =
        Optional.ofNullable(responseShellCallCommandDone)

    /** A streaming event that indicated shell call output was incrementally added. */
    fun responseShellCallOutputContentDelta(): Optional<ResponseShellCallOutputContentDeltaEvent> =
        Optional.ofNullable(responseShellCallOutputContentDelta)

    /** A streaming event that indicated shell call output was completed. */
    fun responseShellCallOutputContentDone(): Optional<ResponseShellCallOutputContentDoneEvent> =
        Optional.ofNullable(responseShellCallOutputContentDone)

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

    /** Emitted when an error occurs while processing a Responses WebSocket request. */
    fun error(): Optional<ResponseWsError> = Optional.ofNullable(error)

    /**
     * The WebSocket lane that emitted this event. This field is present when the originating
     * `response.create` event supplied a `stream_id`.
     */
    fun streamId(): Optional<String> {
        val value = streamIdField()
        return if (value.isMissing() || value.isNull()) Optional.empty()
        else Optional.of(value.asStringOrThrow())
    }

    private fun streamIdField(): JsonField<String> =
        _json?.asObject()?.getOrNull()?.get("stream_id")
            ?: when {
                responseAudioDelta != null ->
                    responseAudioDelta._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseAudioDone != null ->
                    responseAudioDone._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseAudioTranscriptDelta != null ->
                    responseAudioTranscriptDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseAudioTranscriptDone != null ->
                    responseAudioTranscriptDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCodeInterpreterCallCodeDelta != null ->
                    responseCodeInterpreterCallCodeDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCodeInterpreterCallCodeDone != null ->
                    responseCodeInterpreterCallCodeDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCodeInterpreterCallCompleted != null ->
                    responseCodeInterpreterCallCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCodeInterpreterCallInProgress != null ->
                    responseCodeInterpreterCallInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCodeInterpreterCallInterpreting != null ->
                    responseCodeInterpreterCallInterpreting._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCompleted != null ->
                    responseCompleted._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseContentPartAdded != null ->
                    responseContentPartAdded._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseContentPartDone != null ->
                    responseContentPartDone._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseCreated != null ->
                    responseCreated._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseFileSearchCallCompleted != null ->
                    responseFileSearchCallCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseFileSearchCallInProgress != null ->
                    responseFileSearchCallInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseFileSearchCallSearching != null ->
                    responseFileSearchCallSearching._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseFunctionCallArgumentsDelta != null ->
                    responseFunctionCallArgumentsDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseFunctionCallArgumentsDone != null ->
                    responseFunctionCallArgumentsDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseShellCallCommandAdded != null ->
                    responseShellCallCommandAdded._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseShellCallCommandDelta != null ->
                    responseShellCallCommandDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseShellCallCommandDone != null ->
                    responseShellCallCommandDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseShellCallOutputContentDelta != null ->
                    responseShellCallOutputContentDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseShellCallOutputContentDone != null ->
                    responseShellCallOutputContentDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseInProgress != null ->
                    responseInProgress._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseFailed != null ->
                    responseFailed._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseIncomplete != null ->
                    responseIncomplete._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseOutputItemAdded != null ->
                    responseOutputItemAdded._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseOutputItemDone != null ->
                    responseOutputItemDone._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseReasoningSummaryPartAdded != null ->
                    responseReasoningSummaryPartAdded._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseReasoningSummaryPartDone != null ->
                    responseReasoningSummaryPartDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseReasoningSummaryTextDelta != null ->
                    responseReasoningSummaryTextDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseReasoningSummaryTextDone != null ->
                    responseReasoningSummaryTextDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseReasoningTextDelta != null ->
                    responseReasoningTextDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseReasoningTextDone != null ->
                    responseReasoningTextDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseRefusalDelta != null ->
                    responseRefusalDelta._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseRefusalDone != null ->
                    responseRefusalDone._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseOutputTextDelta != null ->
                    responseOutputTextDelta._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseOutputTextDone != null ->
                    responseOutputTextDone._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseWebSearchCallCompleted != null ->
                    responseWebSearchCallCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseWebSearchCallInProgress != null ->
                    responseWebSearchCallInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseWebSearchCallSearching != null ->
                    responseWebSearchCallSearching._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseImageGenerationCallCompleted != null ->
                    responseImageGenerationCallCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseImageGenerationCallGenerating != null ->
                    responseImageGenerationCallGenerating._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseImageGenerationCallInProgress != null ->
                    responseImageGenerationCallInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseImageGenerationCallPartialImage != null ->
                    responseImageGenerationCallPartialImage._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpCallArgumentsDelta != null ->
                    responseMcpCallArgumentsDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpCallArgumentsDone != null ->
                    responseMcpCallArgumentsDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpCallCompleted != null ->
                    responseMcpCallCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpCallFailed != null ->
                    responseMcpCallFailed._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseMcpCallInProgress != null ->
                    responseMcpCallInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpListToolsCompleted != null ->
                    responseMcpListToolsCompleted._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpListToolsFailed != null ->
                    responseMcpListToolsFailed._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseMcpListToolsInProgress != null ->
                    responseMcpListToolsInProgress._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseOutputTextAnnotationAdded != null ->
                    responseOutputTextAnnotationAdded._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseQueued != null ->
                    responseQueued._additionalProperties()["stream_id"] ?: JsonMissing.of()

                responseCustomToolCallInputDelta != null ->
                    responseCustomToolCallInputDelta._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                responseCustomToolCallInputDone != null ->
                    responseCustomToolCallInputDone._additionalProperties()["stream_id"]
                        ?: JsonMissing.of()

                error != null -> error._streamId()

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

    fun isResponseFileSearchCallCompleted(): Boolean = responseFileSearchCallCompleted != null

    fun isResponseFileSearchCallInProgress(): Boolean = responseFileSearchCallInProgress != null

    fun isResponseFileSearchCallSearching(): Boolean = responseFileSearchCallSearching != null

    fun isResponseFunctionCallArgumentsDelta(): Boolean = responseFunctionCallArgumentsDelta != null

    fun isResponseFunctionCallArgumentsDone(): Boolean = responseFunctionCallArgumentsDone != null

    fun isResponseShellCallCommandAdded(): Boolean = responseShellCallCommandAdded != null

    fun isResponseShellCallCommandDelta(): Boolean = responseShellCallCommandDelta != null

    fun isResponseShellCallCommandDone(): Boolean = responseShellCallCommandDone != null

    fun isResponseShellCallOutputContentDelta(): Boolean =
        responseShellCallOutputContentDelta != null

    fun isResponseShellCallOutputContentDone(): Boolean = responseShellCallOutputContentDone != null

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

    fun isError(): Boolean = error != null

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

    /** A streaming event that indicated a shell command was added to a tool call. */
    fun asResponseShellCallCommandAdded(): ResponseShellCallCommandAddedEvent =
        responseShellCallCommandAdded.getOrThrow("responseShellCallCommandAdded")

    /** A streaming event that indicated a shell command was incrementally updated. */
    fun asResponseShellCallCommandDelta(): ResponseShellCallCommandDeltaEvent =
        responseShellCallCommandDelta.getOrThrow("responseShellCallCommandDelta")

    /** A streaming event that indicated a shell command was completed. */
    fun asResponseShellCallCommandDone(): ResponseShellCallCommandDoneEvent =
        responseShellCallCommandDone.getOrThrow("responseShellCallCommandDone")

    /** A streaming event that indicated shell call output was incrementally added. */
    fun asResponseShellCallOutputContentDelta(): ResponseShellCallOutputContentDeltaEvent =
        responseShellCallOutputContentDelta.getOrThrow("responseShellCallOutputContentDelta")

    /** A streaming event that indicated shell call output was completed. */
    fun asResponseShellCallOutputContentDone(): ResponseShellCallOutputContentDoneEvent =
        responseShellCallOutputContentDone.getOrThrow("responseShellCallOutputContentDone")

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

    /** Emitted when an error occurs while processing a Responses WebSocket request. */
    fun asError(): ResponseWsError = error.getOrThrow("error")

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
     * Optional<String> result = responsesServerEvent.accept(new ResponsesServerEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitResponseAudioDelta(ResponseAudioDeltaEvent responseAudioDelta) {
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
            responseShellCallCommandAdded != null ->
                visitor.visitResponseShellCallCommandAdded(responseShellCallCommandAdded)
            responseShellCallCommandDelta != null ->
                visitor.visitResponseShellCallCommandDelta(responseShellCallCommandDelta)
            responseShellCallCommandDone != null ->
                visitor.visitResponseShellCallCommandDone(responseShellCallCommandDone)
            responseShellCallOutputContentDelta != null ->
                visitor.visitResponseShellCallOutputContentDelta(
                    responseShellCallOutputContentDelta
                )
            responseShellCallOutputContentDone != null ->
                visitor.visitResponseShellCallOutputContentDone(responseShellCallOutputContentDone)
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
            error != null -> visitor.visitError(error)
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

                override fun visitResponseShellCallCommandAdded(
                    responseShellCallCommandAdded: ResponseShellCallCommandAddedEvent
                ) {
                    responseShellCallCommandAdded.validate()
                }

                override fun visitResponseShellCallCommandDelta(
                    responseShellCallCommandDelta: ResponseShellCallCommandDeltaEvent
                ) {
                    responseShellCallCommandDelta.validate()
                }

                override fun visitResponseShellCallCommandDone(
                    responseShellCallCommandDone: ResponseShellCallCommandDoneEvent
                ) {
                    responseShellCallCommandDone.validate()
                }

                override fun visitResponseShellCallOutputContentDelta(
                    responseShellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent
                ) {
                    responseShellCallOutputContentDelta.validate()
                }

                override fun visitResponseShellCallOutputContentDone(
                    responseShellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent
                ) {
                    responseShellCallOutputContentDone.validate()
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

                override fun visitError(error: ResponseWsError) {
                    error.validate()
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

                override fun visitResponseShellCallCommandAdded(
                    responseShellCallCommandAdded: ResponseShellCallCommandAddedEvent
                ) = responseShellCallCommandAdded.validity()

                override fun visitResponseShellCallCommandDelta(
                    responseShellCallCommandDelta: ResponseShellCallCommandDeltaEvent
                ) = responseShellCallCommandDelta.validity()

                override fun visitResponseShellCallCommandDone(
                    responseShellCallCommandDone: ResponseShellCallCommandDoneEvent
                ) = responseShellCallCommandDone.validity()

                override fun visitResponseShellCallOutputContentDelta(
                    responseShellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent
                ) = responseShellCallOutputContentDelta.validity()

                override fun visitResponseShellCallOutputContentDone(
                    responseShellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent
                ) = responseShellCallOutputContentDone.validity()

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

                override fun visitError(error: ResponseWsError) = error.validity()

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
            responseFileSearchCallCompleted == other.responseFileSearchCallCompleted &&
            responseFileSearchCallInProgress == other.responseFileSearchCallInProgress &&
            responseFileSearchCallSearching == other.responseFileSearchCallSearching &&
            responseFunctionCallArgumentsDelta == other.responseFunctionCallArgumentsDelta &&
            responseFunctionCallArgumentsDone == other.responseFunctionCallArgumentsDone &&
            responseShellCallCommandAdded == other.responseShellCallCommandAdded &&
            responseShellCallCommandDelta == other.responseShellCallCommandDelta &&
            responseShellCallCommandDone == other.responseShellCallCommandDone &&
            responseShellCallOutputContentDelta == other.responseShellCallOutputContentDelta &&
            responseShellCallOutputContentDone == other.responseShellCallOutputContentDone &&
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
            error == other.error
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
            responseFileSearchCallCompleted,
            responseFileSearchCallInProgress,
            responseFileSearchCallSearching,
            responseFunctionCallArgumentsDelta,
            responseFunctionCallArgumentsDone,
            responseShellCallCommandAdded,
            responseShellCallCommandDelta,
            responseShellCallCommandDone,
            responseShellCallOutputContentDelta,
            responseShellCallOutputContentDone,
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
            error,
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
            responseShellCallCommandAdded != null ->
                "ResponsesServerEvent{responseShellCallCommandAdded=$responseShellCallCommandAdded}"
            responseShellCallCommandDelta != null ->
                "ResponsesServerEvent{responseShellCallCommandDelta=$responseShellCallCommandDelta}"
            responseShellCallCommandDone != null ->
                "ResponsesServerEvent{responseShellCallCommandDone=$responseShellCallCommandDone}"
            responseShellCallOutputContentDelta != null ->
                "ResponsesServerEvent{responseShellCallOutputContentDelta=$responseShellCallOutputContentDelta}"
            responseShellCallOutputContentDone != null ->
                "ResponsesServerEvent{responseShellCallOutputContentDone=$responseShellCallOutputContentDone}"
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
            error != null -> "ResponsesServerEvent{error=$error}"
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

        /** A streaming event that indicated a shell command was added to a tool call. */
        @JvmStatic
        fun ofResponseShellCallCommandAdded(
            responseShellCallCommandAdded: ResponseShellCallCommandAddedEvent
        ) = ResponsesServerEvent(responseShellCallCommandAdded = responseShellCallCommandAdded)

        /** A streaming event that indicated a shell command was incrementally updated. */
        @JvmStatic
        fun ofResponseShellCallCommandDelta(
            responseShellCallCommandDelta: ResponseShellCallCommandDeltaEvent
        ) = ResponsesServerEvent(responseShellCallCommandDelta = responseShellCallCommandDelta)

        /** A streaming event that indicated a shell command was completed. */
        @JvmStatic
        fun ofResponseShellCallCommandDone(
            responseShellCallCommandDone: ResponseShellCallCommandDoneEvent
        ) = ResponsesServerEvent(responseShellCallCommandDone = responseShellCallCommandDone)

        /** A streaming event that indicated shell call output was incrementally added. */
        @JvmStatic
        fun ofResponseShellCallOutputContentDelta(
            responseShellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent
        ) =
            ResponsesServerEvent(
                responseShellCallOutputContentDelta = responseShellCallOutputContentDelta
            )

        /** A streaming event that indicated shell call output was completed. */
        @JvmStatic
        fun ofResponseShellCallOutputContentDone(
            responseShellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent
        ) =
            ResponsesServerEvent(
                responseShellCallOutputContentDone = responseShellCallOutputContentDone
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

        /** Emitted when an error occurs while processing a Responses WebSocket request. */
        @JvmStatic fun ofError(error: ResponseWsError) = ResponsesServerEvent(error = error)
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

        /** A streaming event that indicated a shell command was added to a tool call. */
        fun visitResponseShellCallCommandAdded(
            responseShellCallCommandAdded: ResponseShellCallCommandAddedEvent
        ): T

        /** A streaming event that indicated a shell command was incrementally updated. */
        fun visitResponseShellCallCommandDelta(
            responseShellCallCommandDelta: ResponseShellCallCommandDeltaEvent
        ): T

        /** A streaming event that indicated a shell command was completed. */
        fun visitResponseShellCallCommandDone(
            responseShellCallCommandDone: ResponseShellCallCommandDoneEvent
        ): T

        /** A streaming event that indicated shell call output was incrementally added. */
        fun visitResponseShellCallOutputContentDelta(
            responseShellCallOutputContentDelta: ResponseShellCallOutputContentDeltaEvent
        ): T

        /** A streaming event that indicated shell call output was completed. */
        fun visitResponseShellCallOutputContentDone(
            responseShellCallOutputContentDone: ResponseShellCallOutputContentDoneEvent
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

        /** Emitted when an error occurs while processing a Responses WebSocket request. */
        fun visitError(error: ResponseWsError): T

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
                "response.shell_call_command.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseShellCallCommandAddedEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseShellCallCommandAdded = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.shell_call_command.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseShellCallCommandDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(responseShellCallCommandDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.shell_call_command.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseShellCallCommandDoneEvent>())
                        ?.let {
                            ResponsesServerEvent(responseShellCallCommandDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.shell_call_output_content.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseShellCallOutputContentDeltaEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseShellCallOutputContentDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.shell_call_output_content.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseShellCallOutputContentDoneEvent>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseShellCallOutputContentDone = it,
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
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsError>())?.let {
                        ResponsesServerEvent(error = it, _json = json)
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
                value.responseShellCallCommandAdded != null ->
                    generator.writeObject(value.responseShellCallCommandAdded)
                value.responseShellCallCommandDelta != null ->
                    generator.writeObject(value.responseShellCallCommandDelta)
                value.responseShellCallCommandDone != null ->
                    generator.writeObject(value.responseShellCallCommandDone)
                value.responseShellCallOutputContentDelta != null ->
                    generator.writeObject(value.responseShellCallOutputContentDelta)
                value.responseShellCallOutputContentDone != null ->
                    generator.writeObject(value.responseShellCallOutputContentDone)
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
                value.error != null -> generator.writeObject(value.error)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponsesServerEvent")
            }
        }
    }

    /** Emitted when an error occurs while processing a Responses WebSocket request. */
    class ResponseWsError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val error: JsonField<Error>,
        private val type: JsonValue,
        private val sequenceNumber: JsonField<Long>,
        private val status: JsonField<Long>,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(error, type, sequenceNumber, status, streamId, mutableMapOf())

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
             * Returns a mutable builder for constructing an instance of [ResponseWsError].
             *
             * The following fields are required:
             * ```java
             * .error()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsError]. */
        class Builder internal constructor() {

            private var error: JsonField<Error>? = null
            private var type: JsonValue = JsonValue.from("error")
            private var sequenceNumber: JsonField<Long> = JsonMissing.of()
            private var status: JsonField<Long> = JsonMissing.of()
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsError: ResponseWsError) = apply {
                error = responseWsError.error
                type = responseWsError.type
                sequenceNumber = responseWsError.sequenceNumber
                status = responseWsError.status
                streamId = responseWsError.streamId
                additionalProperties = responseWsError.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [ResponseWsError].
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
            fun build(): ResponseWsError =
                ResponseWsError(
                    checkRequired("error", error),
                    type,
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
        fun validate(): ResponseWsError = apply {
            if (validated) {
                return@apply
            }

            error().validate()
            _type().let {
                if (it != JsonValue.from("error")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsError &&
                error == other.error &&
                type == other.type &&
                sequenceNumber == other.sequenceNumber &&
                status == other.status &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(error, type, sequenceNumber, status, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsError{error=$error, type=$type, sequenceNumber=$sequenceNumber, status=$status, streamId=$streamId, additionalProperties=$additionalProperties}"
    }
}
