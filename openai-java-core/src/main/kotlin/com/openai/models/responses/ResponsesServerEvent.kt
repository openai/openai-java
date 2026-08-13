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
import com.openai.core.checkKnown
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
    private val responseAudioDelta: ResponseAudioWsDelta? = null,
    private val responseAudioDone: ResponseAudioWsDone? = null,
    private val responseAudioTranscriptDelta: ResponseAudioTranscriptWsDelta? = null,
    private val responseAudioTranscriptDone: ResponseAudioTranscriptWsDone? = null,
    private val responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeWsDelta? =
        null,
    private val responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeWsDone? = null,
    private val responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallWsCompleted? =
        null,
    private val responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInWsProgress? =
        null,
    private val responseCodeInterpreterCallInterpreting:
        ResponseCodeInterpreterCallWsInterpreting? =
        null,
    private val responseCompleted: ResponseWsCompleted? = null,
    private val responseContentPartAdded: ResponseContentPartWsAdded? = null,
    private val responseContentPartDone: ResponseContentPartWsDone? = null,
    private val responseCreated: ResponseWsCreated? = null,
    private val error: ResponseWsError? = null,
    private val responseFileSearchCallCompleted: ResponseFileSearchCallWsCompleted? = null,
    private val responseFileSearchCallInProgress: ResponseFileSearchCallInWsProgress? = null,
    private val responseFileSearchCallSearching: ResponseFileSearchCallWsSearching? = null,
    private val responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsWsDelta? = null,
    private val responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsWsDone? = null,
    private val responseInProgress: ResponseInWsProgress? = null,
    private val responseFailed: ResponseWsFailed? = null,
    private val responseIncomplete: ResponseWsIncomplete? = null,
    private val responseOutputItemAdded: ResponseOutputItemWsAdded? = null,
    private val responseOutputItemDone: ResponseOutputItemWsDone? = null,
    private val responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartWsAdded? = null,
    private val responseReasoningSummaryPartDone: ResponseReasoningSummaryPartWsDone? = null,
    private val responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextWsDelta? = null,
    private val responseReasoningSummaryTextDone: ResponseReasoningSummaryTextWsDone? = null,
    private val responseReasoningTextDelta: ResponseReasoningTextWsDelta? = null,
    private val responseReasoningTextDone: ResponseReasoningTextWsDone? = null,
    private val responseRefusalDelta: ResponseRefusalWsDelta? = null,
    private val responseRefusalDone: ResponseRefusalWsDone? = null,
    private val responseOutputTextDelta: ResponseTextWsDelta? = null,
    private val responseOutputTextDone: ResponseTextWsDone? = null,
    private val responseWebSearchCallCompleted: ResponseWebSearchCallWsCompleted? = null,
    private val responseWebSearchCallInProgress: ResponseWebSearchCallInWsProgress? = null,
    private val responseWebSearchCallSearching: ResponseWebSearchCallWsSearching? = null,
    private val responseImageGenerationCallCompleted: ResponseImageGenCallWsCompleted? = null,
    private val responseImageGenerationCallGenerating: ResponseImageGenCallWsGenerating? = null,
    private val responseImageGenerationCallInProgress: ResponseImageGenCallInWsProgress? = null,
    private val responseImageGenerationCallPartialImage: ResponseImageGenCallPartialWsImage? = null,
    private val responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsWsDelta? = null,
    private val responseMcpCallArgumentsDone: ResponseMcpCallArgumentsWsDone? = null,
    private val responseMcpCallCompleted: ResponseMcpCallWsCompleted? = null,
    private val responseMcpCallFailed: ResponseMcpCallWsFailed? = null,
    private val responseMcpCallInProgress: ResponseMcpCallInWsProgress? = null,
    private val responseMcpListToolsCompleted: ResponseMcpListToolsWsCompleted? = null,
    private val responseMcpListToolsFailed: ResponseMcpListToolsWsFailed? = null,
    private val responseMcpListToolsInProgress: ResponseMcpListToolsInWsProgress? = null,
    private val responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationWsAdded? = null,
    private val responseQueued: ResponseWsQueued? = null,
    private val responseCustomToolCallInputDelta: ResponseCustomToolCallInputWsDelta? = null,
    private val responseCustomToolCallInputDone: ResponseCustomToolCallInputWsDone? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when there is a partial audio response. */
    fun responseAudioDelta(): Optional<ResponseAudioWsDelta> =
        Optional.ofNullable(responseAudioDelta)

    /** Emitted when the audio response is complete. */
    fun responseAudioDone(): Optional<ResponseAudioWsDone> = Optional.ofNullable(responseAudioDone)

    /** Emitted when there is a partial transcript of audio. */
    fun responseAudioTranscriptDelta(): Optional<ResponseAudioTranscriptWsDelta> =
        Optional.ofNullable(responseAudioTranscriptDelta)

    /** Emitted when the full audio transcript is completed. */
    fun responseAudioTranscriptDone(): Optional<ResponseAudioTranscriptWsDone> =
        Optional.ofNullable(responseAudioTranscriptDone)

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun responseCodeInterpreterCallCodeDelta(): Optional<ResponseCodeInterpreterCallCodeWsDelta> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDelta)

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun responseCodeInterpreterCallCodeDone(): Optional<ResponseCodeInterpreterCallCodeWsDone> =
        Optional.ofNullable(responseCodeInterpreterCallCodeDone)

    /** Emitted when the code interpreter call is completed. */
    fun responseCodeInterpreterCallCompleted(): Optional<ResponseCodeInterpreterCallWsCompleted> =
        Optional.ofNullable(responseCodeInterpreterCallCompleted)

    /** Emitted when a code interpreter call is in progress. */
    fun responseCodeInterpreterCallInProgress(): Optional<ResponseCodeInterpreterCallInWsProgress> =
        Optional.ofNullable(responseCodeInterpreterCallInProgress)

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun responseCodeInterpreterCallInterpreting():
        Optional<ResponseCodeInterpreterCallWsInterpreting> =
        Optional.ofNullable(responseCodeInterpreterCallInterpreting)

    /** Emitted when the model response is complete. */
    fun responseCompleted(): Optional<ResponseWsCompleted> = Optional.ofNullable(responseCompleted)

    /** Emitted when a new content part is added. */
    fun responseContentPartAdded(): Optional<ResponseContentPartWsAdded> =
        Optional.ofNullable(responseContentPartAdded)

    /** Emitted when a content part is done. */
    fun responseContentPartDone(): Optional<ResponseContentPartWsDone> =
        Optional.ofNullable(responseContentPartDone)

    /** An event that is emitted when a response is created. */
    fun responseCreated(): Optional<ResponseWsCreated> = Optional.ofNullable(responseCreated)

    /** Emitted when an error occurs. */
    fun error(): Optional<ResponseWsError> = Optional.ofNullable(error)

    /** Emitted when a file search call is completed (results found). */
    fun responseFileSearchCallCompleted(): Optional<ResponseFileSearchCallWsCompleted> =
        Optional.ofNullable(responseFileSearchCallCompleted)

    /** Emitted when a file search call is initiated. */
    fun responseFileSearchCallInProgress(): Optional<ResponseFileSearchCallInWsProgress> =
        Optional.ofNullable(responseFileSearchCallInProgress)

    /** Emitted when a file search is currently searching. */
    fun responseFileSearchCallSearching(): Optional<ResponseFileSearchCallWsSearching> =
        Optional.ofNullable(responseFileSearchCallSearching)

    /** Emitted when there is a partial function-call arguments delta. */
    fun responseFunctionCallArgumentsDelta(): Optional<ResponseFunctionCallArgumentsWsDelta> =
        Optional.ofNullable(responseFunctionCallArgumentsDelta)

    /** Emitted when function-call arguments are finalized. */
    fun responseFunctionCallArgumentsDone(): Optional<ResponseFunctionCallArgumentsWsDone> =
        Optional.ofNullable(responseFunctionCallArgumentsDone)

    /** Emitted when the response is in progress. */
    fun responseInProgress(): Optional<ResponseInWsProgress> =
        Optional.ofNullable(responseInProgress)

    /** An event that is emitted when a response fails. */
    fun responseFailed(): Optional<ResponseWsFailed> = Optional.ofNullable(responseFailed)

    /** An event that is emitted when a response finishes as incomplete. */
    fun responseIncomplete(): Optional<ResponseWsIncomplete> =
        Optional.ofNullable(responseIncomplete)

    /** Emitted when a new output item is added. */
    fun responseOutputItemAdded(): Optional<ResponseOutputItemWsAdded> =
        Optional.ofNullable(responseOutputItemAdded)

    /** Emitted when an output item is marked done. */
    fun responseOutputItemDone(): Optional<ResponseOutputItemWsDone> =
        Optional.ofNullable(responseOutputItemDone)

    /** Emitted when a new reasoning summary part is added. */
    fun responseReasoningSummaryPartAdded(): Optional<ResponseReasoningSummaryPartWsAdded> =
        Optional.ofNullable(responseReasoningSummaryPartAdded)

    /** Emitted when a reasoning summary part is completed. */
    fun responseReasoningSummaryPartDone(): Optional<ResponseReasoningSummaryPartWsDone> =
        Optional.ofNullable(responseReasoningSummaryPartDone)

    /** Emitted when a delta is added to a reasoning summary text. */
    fun responseReasoningSummaryTextDelta(): Optional<ResponseReasoningSummaryTextWsDelta> =
        Optional.ofNullable(responseReasoningSummaryTextDelta)

    /** Emitted when a reasoning summary text is completed. */
    fun responseReasoningSummaryTextDone(): Optional<ResponseReasoningSummaryTextWsDone> =
        Optional.ofNullable(responseReasoningSummaryTextDone)

    /** Emitted when a delta is added to a reasoning text. */
    fun responseReasoningTextDelta(): Optional<ResponseReasoningTextWsDelta> =
        Optional.ofNullable(responseReasoningTextDelta)

    /** Emitted when a reasoning text is completed. */
    fun responseReasoningTextDone(): Optional<ResponseReasoningTextWsDone> =
        Optional.ofNullable(responseReasoningTextDone)

    /** Emitted when there is a partial refusal text. */
    fun responseRefusalDelta(): Optional<ResponseRefusalWsDelta> =
        Optional.ofNullable(responseRefusalDelta)

    /** Emitted when refusal text is finalized. */
    fun responseRefusalDone(): Optional<ResponseRefusalWsDone> =
        Optional.ofNullable(responseRefusalDone)

    /** Emitted when there is an additional text delta. */
    fun responseOutputTextDelta(): Optional<ResponseTextWsDelta> =
        Optional.ofNullable(responseOutputTextDelta)

    /** Emitted when text content is finalized. */
    fun responseOutputTextDone(): Optional<ResponseTextWsDone> =
        Optional.ofNullable(responseOutputTextDone)

    /** Emitted when a web search call is completed. */
    fun responseWebSearchCallCompleted(): Optional<ResponseWebSearchCallWsCompleted> =
        Optional.ofNullable(responseWebSearchCallCompleted)

    /** Emitted when a web search call is initiated. */
    fun responseWebSearchCallInProgress(): Optional<ResponseWebSearchCallInWsProgress> =
        Optional.ofNullable(responseWebSearchCallInProgress)

    /** Emitted when a web search call is executing. */
    fun responseWebSearchCallSearching(): Optional<ResponseWebSearchCallWsSearching> =
        Optional.ofNullable(responseWebSearchCallSearching)

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun responseImageGenerationCallCompleted(): Optional<ResponseImageGenCallWsCompleted> =
        Optional.ofNullable(responseImageGenerationCallCompleted)

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun responseImageGenerationCallGenerating(): Optional<ResponseImageGenCallWsGenerating> =
        Optional.ofNullable(responseImageGenerationCallGenerating)

    /** Emitted when an image generation tool call is in progress. */
    fun responseImageGenerationCallInProgress(): Optional<ResponseImageGenCallInWsProgress> =
        Optional.ofNullable(responseImageGenerationCallInProgress)

    /** Emitted when a partial image is available during image generation streaming. */
    fun responseImageGenerationCallPartialImage(): Optional<ResponseImageGenCallPartialWsImage> =
        Optional.ofNullable(responseImageGenerationCallPartialImage)

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun responseMcpCallArgumentsDelta(): Optional<ResponseMcpCallArgumentsWsDelta> =
        Optional.ofNullable(responseMcpCallArgumentsDelta)

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun responseMcpCallArgumentsDone(): Optional<ResponseMcpCallArgumentsWsDone> =
        Optional.ofNullable(responseMcpCallArgumentsDone)

    /** Emitted when an MCP tool call has completed successfully. */
    fun responseMcpCallCompleted(): Optional<ResponseMcpCallWsCompleted> =
        Optional.ofNullable(responseMcpCallCompleted)

    /** Emitted when an MCP tool call has failed. */
    fun responseMcpCallFailed(): Optional<ResponseMcpCallWsFailed> =
        Optional.ofNullable(responseMcpCallFailed)

    /** Emitted when an MCP tool call is in progress. */
    fun responseMcpCallInProgress(): Optional<ResponseMcpCallInWsProgress> =
        Optional.ofNullable(responseMcpCallInProgress)

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun responseMcpListToolsCompleted(): Optional<ResponseMcpListToolsWsCompleted> =
        Optional.ofNullable(responseMcpListToolsCompleted)

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun responseMcpListToolsFailed(): Optional<ResponseMcpListToolsWsFailed> =
        Optional.ofNullable(responseMcpListToolsFailed)

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun responseMcpListToolsInProgress(): Optional<ResponseMcpListToolsInWsProgress> =
        Optional.ofNullable(responseMcpListToolsInProgress)

    /** Emitted when an annotation is added to output text content. */
    fun responseOutputTextAnnotationAdded(): Optional<ResponseOutputTextAnnotationWsAdded> =
        Optional.ofNullable(responseOutputTextAnnotationAdded)

    /** Emitted when a response is queued and waiting to be processed. */
    fun responseQueued(): Optional<ResponseWsQueued> = Optional.ofNullable(responseQueued)

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun responseCustomToolCallInputDelta(): Optional<ResponseCustomToolCallInputWsDelta> =
        Optional.ofNullable(responseCustomToolCallInputDelta)

    /** Event indicating that input for a custom tool call is complete. */
    fun responseCustomToolCallInputDone(): Optional<ResponseCustomToolCallInputWsDone> =
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
    fun asResponseAudioDelta(): ResponseAudioWsDelta =
        responseAudioDelta.getOrThrow("responseAudioDelta")

    /** Emitted when the audio response is complete. */
    fun asResponseAudioDone(): ResponseAudioWsDone =
        responseAudioDone.getOrThrow("responseAudioDone")

    /** Emitted when there is a partial transcript of audio. */
    fun asResponseAudioTranscriptDelta(): ResponseAudioTranscriptWsDelta =
        responseAudioTranscriptDelta.getOrThrow("responseAudioTranscriptDelta")

    /** Emitted when the full audio transcript is completed. */
    fun asResponseAudioTranscriptDone(): ResponseAudioTranscriptWsDone =
        responseAudioTranscriptDone.getOrThrow("responseAudioTranscriptDone")

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDelta(): ResponseCodeInterpreterCallCodeWsDelta =
        responseCodeInterpreterCallCodeDelta.getOrThrow("responseCodeInterpreterCallCodeDelta")

    /** Emitted when the code snippet is finalized by the code interpreter. */
    fun asResponseCodeInterpreterCallCodeDone(): ResponseCodeInterpreterCallCodeWsDone =
        responseCodeInterpreterCallCodeDone.getOrThrow("responseCodeInterpreterCallCodeDone")

    /** Emitted when the code interpreter call is completed. */
    fun asResponseCodeInterpreterCallCompleted(): ResponseCodeInterpreterCallWsCompleted =
        responseCodeInterpreterCallCompleted.getOrThrow("responseCodeInterpreterCallCompleted")

    /** Emitted when a code interpreter call is in progress. */
    fun asResponseCodeInterpreterCallInProgress(): ResponseCodeInterpreterCallInWsProgress =
        responseCodeInterpreterCallInProgress.getOrThrow("responseCodeInterpreterCallInProgress")

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    fun asResponseCodeInterpreterCallInterpreting(): ResponseCodeInterpreterCallWsInterpreting =
        responseCodeInterpreterCallInterpreting.getOrThrow(
            "responseCodeInterpreterCallInterpreting"
        )

    /** Emitted when the model response is complete. */
    fun asResponseCompleted(): ResponseWsCompleted =
        responseCompleted.getOrThrow("responseCompleted")

    /** Emitted when a new content part is added. */
    fun asResponseContentPartAdded(): ResponseContentPartWsAdded =
        responseContentPartAdded.getOrThrow("responseContentPartAdded")

    /** Emitted when a content part is done. */
    fun asResponseContentPartDone(): ResponseContentPartWsDone =
        responseContentPartDone.getOrThrow("responseContentPartDone")

    /** An event that is emitted when a response is created. */
    fun asResponseCreated(): ResponseWsCreated = responseCreated.getOrThrow("responseCreated")

    /** Emitted when an error occurs. */
    fun asError(): ResponseWsError = error.getOrThrow("error")

    /** Emitted when a file search call is completed (results found). */
    fun asResponseFileSearchCallCompleted(): ResponseFileSearchCallWsCompleted =
        responseFileSearchCallCompleted.getOrThrow("responseFileSearchCallCompleted")

    /** Emitted when a file search call is initiated. */
    fun asResponseFileSearchCallInProgress(): ResponseFileSearchCallInWsProgress =
        responseFileSearchCallInProgress.getOrThrow("responseFileSearchCallInProgress")

    /** Emitted when a file search is currently searching. */
    fun asResponseFileSearchCallSearching(): ResponseFileSearchCallWsSearching =
        responseFileSearchCallSearching.getOrThrow("responseFileSearchCallSearching")

    /** Emitted when there is a partial function-call arguments delta. */
    fun asResponseFunctionCallArgumentsDelta(): ResponseFunctionCallArgumentsWsDelta =
        responseFunctionCallArgumentsDelta.getOrThrow("responseFunctionCallArgumentsDelta")

    /** Emitted when function-call arguments are finalized. */
    fun asResponseFunctionCallArgumentsDone(): ResponseFunctionCallArgumentsWsDone =
        responseFunctionCallArgumentsDone.getOrThrow("responseFunctionCallArgumentsDone")

    /** Emitted when the response is in progress. */
    fun asResponseInProgress(): ResponseInWsProgress =
        responseInProgress.getOrThrow("responseInProgress")

    /** An event that is emitted when a response fails. */
    fun asResponseFailed(): ResponseWsFailed = responseFailed.getOrThrow("responseFailed")

    /** An event that is emitted when a response finishes as incomplete. */
    fun asResponseIncomplete(): ResponseWsIncomplete =
        responseIncomplete.getOrThrow("responseIncomplete")

    /** Emitted when a new output item is added. */
    fun asResponseOutputItemAdded(): ResponseOutputItemWsAdded =
        responseOutputItemAdded.getOrThrow("responseOutputItemAdded")

    /** Emitted when an output item is marked done. */
    fun asResponseOutputItemDone(): ResponseOutputItemWsDone =
        responseOutputItemDone.getOrThrow("responseOutputItemDone")

    /** Emitted when a new reasoning summary part is added. */
    fun asResponseReasoningSummaryPartAdded(): ResponseReasoningSummaryPartWsAdded =
        responseReasoningSummaryPartAdded.getOrThrow("responseReasoningSummaryPartAdded")

    /** Emitted when a reasoning summary part is completed. */
    fun asResponseReasoningSummaryPartDone(): ResponseReasoningSummaryPartWsDone =
        responseReasoningSummaryPartDone.getOrThrow("responseReasoningSummaryPartDone")

    /** Emitted when a delta is added to a reasoning summary text. */
    fun asResponseReasoningSummaryTextDelta(): ResponseReasoningSummaryTextWsDelta =
        responseReasoningSummaryTextDelta.getOrThrow("responseReasoningSummaryTextDelta")

    /** Emitted when a reasoning summary text is completed. */
    fun asResponseReasoningSummaryTextDone(): ResponseReasoningSummaryTextWsDone =
        responseReasoningSummaryTextDone.getOrThrow("responseReasoningSummaryTextDone")

    /** Emitted when a delta is added to a reasoning text. */
    fun asResponseReasoningTextDelta(): ResponseReasoningTextWsDelta =
        responseReasoningTextDelta.getOrThrow("responseReasoningTextDelta")

    /** Emitted when a reasoning text is completed. */
    fun asResponseReasoningTextDone(): ResponseReasoningTextWsDone =
        responseReasoningTextDone.getOrThrow("responseReasoningTextDone")

    /** Emitted when there is a partial refusal text. */
    fun asResponseRefusalDelta(): ResponseRefusalWsDelta =
        responseRefusalDelta.getOrThrow("responseRefusalDelta")

    /** Emitted when refusal text is finalized. */
    fun asResponseRefusalDone(): ResponseRefusalWsDone =
        responseRefusalDone.getOrThrow("responseRefusalDone")

    /** Emitted when there is an additional text delta. */
    fun asResponseOutputTextDelta(): ResponseTextWsDelta =
        responseOutputTextDelta.getOrThrow("responseOutputTextDelta")

    /** Emitted when text content is finalized. */
    fun asResponseOutputTextDone(): ResponseTextWsDone =
        responseOutputTextDone.getOrThrow("responseOutputTextDone")

    /** Emitted when a web search call is completed. */
    fun asResponseWebSearchCallCompleted(): ResponseWebSearchCallWsCompleted =
        responseWebSearchCallCompleted.getOrThrow("responseWebSearchCallCompleted")

    /** Emitted when a web search call is initiated. */
    fun asResponseWebSearchCallInProgress(): ResponseWebSearchCallInWsProgress =
        responseWebSearchCallInProgress.getOrThrow("responseWebSearchCallInProgress")

    /** Emitted when a web search call is executing. */
    fun asResponseWebSearchCallSearching(): ResponseWebSearchCallWsSearching =
        responseWebSearchCallSearching.getOrThrow("responseWebSearchCallSearching")

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    fun asResponseImageGenerationCallCompleted(): ResponseImageGenCallWsCompleted =
        responseImageGenerationCallCompleted.getOrThrow("responseImageGenerationCallCompleted")

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    fun asResponseImageGenerationCallGenerating(): ResponseImageGenCallWsGenerating =
        responseImageGenerationCallGenerating.getOrThrow("responseImageGenerationCallGenerating")

    /** Emitted when an image generation tool call is in progress. */
    fun asResponseImageGenerationCallInProgress(): ResponseImageGenCallInWsProgress =
        responseImageGenerationCallInProgress.getOrThrow("responseImageGenerationCallInProgress")

    /** Emitted when a partial image is available during image generation streaming. */
    fun asResponseImageGenerationCallPartialImage(): ResponseImageGenCallPartialWsImage =
        responseImageGenerationCallPartialImage.getOrThrow(
            "responseImageGenerationCallPartialImage"
        )

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    fun asResponseMcpCallArgumentsDelta(): ResponseMcpCallArgumentsWsDelta =
        responseMcpCallArgumentsDelta.getOrThrow("responseMcpCallArgumentsDelta")

    /** Emitted when the arguments for an MCP tool call are finalized. */
    fun asResponseMcpCallArgumentsDone(): ResponseMcpCallArgumentsWsDone =
        responseMcpCallArgumentsDone.getOrThrow("responseMcpCallArgumentsDone")

    /** Emitted when an MCP tool call has completed successfully. */
    fun asResponseMcpCallCompleted(): ResponseMcpCallWsCompleted =
        responseMcpCallCompleted.getOrThrow("responseMcpCallCompleted")

    /** Emitted when an MCP tool call has failed. */
    fun asResponseMcpCallFailed(): ResponseMcpCallWsFailed =
        responseMcpCallFailed.getOrThrow("responseMcpCallFailed")

    /** Emitted when an MCP tool call is in progress. */
    fun asResponseMcpCallInProgress(): ResponseMcpCallInWsProgress =
        responseMcpCallInProgress.getOrThrow("responseMcpCallInProgress")

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    fun asResponseMcpListToolsCompleted(): ResponseMcpListToolsWsCompleted =
        responseMcpListToolsCompleted.getOrThrow("responseMcpListToolsCompleted")

    /** Emitted when the attempt to list available MCP tools has failed. */
    fun asResponseMcpListToolsFailed(): ResponseMcpListToolsWsFailed =
        responseMcpListToolsFailed.getOrThrow("responseMcpListToolsFailed")

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    fun asResponseMcpListToolsInProgress(): ResponseMcpListToolsInWsProgress =
        responseMcpListToolsInProgress.getOrThrow("responseMcpListToolsInProgress")

    /** Emitted when an annotation is added to output text content. */
    fun asResponseOutputTextAnnotationAdded(): ResponseOutputTextAnnotationWsAdded =
        responseOutputTextAnnotationAdded.getOrThrow("responseOutputTextAnnotationAdded")

    /** Emitted when a response is queued and waiting to be processed. */
    fun asResponseQueued(): ResponseWsQueued = responseQueued.getOrThrow("responseQueued")

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    fun asResponseCustomToolCallInputDelta(): ResponseCustomToolCallInputWsDelta =
        responseCustomToolCallInputDelta.getOrThrow("responseCustomToolCallInputDelta")

    /** Event indicating that input for a custom tool call is complete. */
    fun asResponseCustomToolCallInputDone(): ResponseCustomToolCallInputWsDone =
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
     * Optional<String> result = responsesServerEvent.accept(new ResponsesServerEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitResponseAudioDelta(ResponseAudioWsDelta responseAudioDelta) {
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
    fun validate(): ResponsesServerEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioWsDelta) {
                    responseAudioDelta.validate()
                }

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioWsDone) {
                    responseAudioDone.validate()
                }

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptWsDelta
                ) {
                    responseAudioTranscriptDelta.validate()
                }

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptWsDone
                ) {
                    responseAudioTranscriptDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeWsDelta
                ) {
                    responseCodeInterpreterCallCodeDelta.validate()
                }

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeWsDone
                ) {
                    responseCodeInterpreterCallCodeDone.validate()
                }

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallWsCompleted
                ) {
                    responseCodeInterpreterCallCompleted.validate()
                }

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInWsProgress
                ) {
                    responseCodeInterpreterCallInProgress.validate()
                }

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        ResponseCodeInterpreterCallWsInterpreting
                ) {
                    responseCodeInterpreterCallInterpreting.validate()
                }

                override fun visitResponseCompleted(responseCompleted: ResponseWsCompleted) {
                    responseCompleted.validate()
                }

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartWsAdded
                ) {
                    responseContentPartAdded.validate()
                }

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartWsDone
                ) {
                    responseContentPartDone.validate()
                }

                override fun visitResponseCreated(responseCreated: ResponseWsCreated) {
                    responseCreated.validate()
                }

                override fun visitError(error: ResponseWsError) {
                    error.validate()
                }

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: ResponseFileSearchCallWsCompleted
                ) {
                    responseFileSearchCallCompleted.validate()
                }

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: ResponseFileSearchCallInWsProgress
                ) {
                    responseFileSearchCallInProgress.validate()
                }

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: ResponseFileSearchCallWsSearching
                ) {
                    responseFileSearchCallSearching.validate()
                }

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsWsDelta
                ) {
                    responseFunctionCallArgumentsDelta.validate()
                }

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsWsDone
                ) {
                    responseFunctionCallArgumentsDone.validate()
                }

                override fun visitResponseInProgress(responseInProgress: ResponseInWsProgress) {
                    responseInProgress.validate()
                }

                override fun visitResponseFailed(responseFailed: ResponseWsFailed) {
                    responseFailed.validate()
                }

                override fun visitResponseIncomplete(responseIncomplete: ResponseWsIncomplete) {
                    responseIncomplete.validate()
                }

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemWsAdded
                ) {
                    responseOutputItemAdded.validate()
                }

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemWsDone
                ) {
                    responseOutputItemDone.validate()
                }

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartWsAdded
                ) {
                    responseReasoningSummaryPartAdded.validate()
                }

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: ResponseReasoningSummaryPartWsDone
                ) {
                    responseReasoningSummaryPartDone.validate()
                }

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextWsDelta
                ) {
                    responseReasoningSummaryTextDelta.validate()
                }

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: ResponseReasoningSummaryTextWsDone
                ) {
                    responseReasoningSummaryTextDone.validate()
                }

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: ResponseReasoningTextWsDelta
                ) {
                    responseReasoningTextDelta.validate()
                }

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: ResponseReasoningTextWsDone
                ) {
                    responseReasoningTextDone.validate()
                }

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: ResponseRefusalWsDelta
                ) {
                    responseRefusalDelta.validate()
                }

                override fun visitResponseRefusalDone(responseRefusalDone: ResponseRefusalWsDone) {
                    responseRefusalDone.validate()
                }

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextWsDelta
                ) {
                    responseOutputTextDelta.validate()
                }

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextWsDone
                ) {
                    responseOutputTextDone.validate()
                }

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: ResponseWebSearchCallWsCompleted
                ) {
                    responseWebSearchCallCompleted.validate()
                }

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: ResponseWebSearchCallInWsProgress
                ) {
                    responseWebSearchCallInProgress.validate()
                }

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: ResponseWebSearchCallWsSearching
                ) {
                    responseWebSearchCallSearching.validate()
                }

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: ResponseImageGenCallWsCompleted
                ) {
                    responseImageGenerationCallCompleted.validate()
                }

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: ResponseImageGenCallWsGenerating
                ) {
                    responseImageGenerationCallGenerating.validate()
                }

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: ResponseImageGenCallInWsProgress
                ) {
                    responseImageGenerationCallInProgress.validate()
                }

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage: ResponseImageGenCallPartialWsImage
                ) {
                    responseImageGenerationCallPartialImage.validate()
                }

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsWsDelta
                ) {
                    responseMcpCallArgumentsDelta.validate()
                }

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsWsDone
                ) {
                    responseMcpCallArgumentsDone.validate()
                }

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallWsCompleted
                ) {
                    responseMcpCallCompleted.validate()
                }

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallWsFailed
                ) {
                    responseMcpCallFailed.validate()
                }

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInWsProgress
                ) {
                    responseMcpCallInProgress.validate()
                }

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: ResponseMcpListToolsWsCompleted
                ) {
                    responseMcpListToolsCompleted.validate()
                }

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: ResponseMcpListToolsWsFailed
                ) {
                    responseMcpListToolsFailed.validate()
                }

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: ResponseMcpListToolsInWsProgress
                ) {
                    responseMcpListToolsInProgress.validate()
                }

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationWsAdded
                ) {
                    responseOutputTextAnnotationAdded.validate()
                }

                override fun visitResponseQueued(responseQueued: ResponseWsQueued) {
                    responseQueued.validate()
                }

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: ResponseCustomToolCallInputWsDelta
                ) {
                    responseCustomToolCallInputDelta.validate()
                }

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: ResponseCustomToolCallInputWsDone
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
                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioWsDelta) =
                    responseAudioDelta.validity()

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioWsDone) =
                    responseAudioDone.validity()

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptWsDelta
                ) = responseAudioTranscriptDelta.validity()

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptWsDone
                ) = responseAudioTranscriptDone.validity()

                override fun visitResponseCodeInterpreterCallCodeDelta(
                    responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeWsDelta
                ) = responseCodeInterpreterCallCodeDelta.validity()

                override fun visitResponseCodeInterpreterCallCodeDone(
                    responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeWsDone
                ) = responseCodeInterpreterCallCodeDone.validity()

                override fun visitResponseCodeInterpreterCallCompleted(
                    responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallWsCompleted
                ) = responseCodeInterpreterCallCompleted.validity()

                override fun visitResponseCodeInterpreterCallInProgress(
                    responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInWsProgress
                ) = responseCodeInterpreterCallInProgress.validity()

                override fun visitResponseCodeInterpreterCallInterpreting(
                    responseCodeInterpreterCallInterpreting:
                        ResponseCodeInterpreterCallWsInterpreting
                ) = responseCodeInterpreterCallInterpreting.validity()

                override fun visitResponseCompleted(responseCompleted: ResponseWsCompleted) =
                    responseCompleted.validity()

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartWsAdded
                ) = responseContentPartAdded.validity()

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartWsDone
                ) = responseContentPartDone.validity()

                override fun visitResponseCreated(responseCreated: ResponseWsCreated) =
                    responseCreated.validity()

                override fun visitError(error: ResponseWsError) = error.validity()

                override fun visitResponseFileSearchCallCompleted(
                    responseFileSearchCallCompleted: ResponseFileSearchCallWsCompleted
                ) = responseFileSearchCallCompleted.validity()

                override fun visitResponseFileSearchCallInProgress(
                    responseFileSearchCallInProgress: ResponseFileSearchCallInWsProgress
                ) = responseFileSearchCallInProgress.validity()

                override fun visitResponseFileSearchCallSearching(
                    responseFileSearchCallSearching: ResponseFileSearchCallWsSearching
                ) = responseFileSearchCallSearching.validity()

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsWsDelta
                ) = responseFunctionCallArgumentsDelta.validity()

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsWsDone
                ) = responseFunctionCallArgumentsDone.validity()

                override fun visitResponseInProgress(responseInProgress: ResponseInWsProgress) =
                    responseInProgress.validity()

                override fun visitResponseFailed(responseFailed: ResponseWsFailed) =
                    responseFailed.validity()

                override fun visitResponseIncomplete(responseIncomplete: ResponseWsIncomplete) =
                    responseIncomplete.validity()

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemWsAdded
                ) = responseOutputItemAdded.validity()

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemWsDone
                ) = responseOutputItemDone.validity()

                override fun visitResponseReasoningSummaryPartAdded(
                    responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartWsAdded
                ) = responseReasoningSummaryPartAdded.validity()

                override fun visitResponseReasoningSummaryPartDone(
                    responseReasoningSummaryPartDone: ResponseReasoningSummaryPartWsDone
                ) = responseReasoningSummaryPartDone.validity()

                override fun visitResponseReasoningSummaryTextDelta(
                    responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextWsDelta
                ) = responseReasoningSummaryTextDelta.validity()

                override fun visitResponseReasoningSummaryTextDone(
                    responseReasoningSummaryTextDone: ResponseReasoningSummaryTextWsDone
                ) = responseReasoningSummaryTextDone.validity()

                override fun visitResponseReasoningTextDelta(
                    responseReasoningTextDelta: ResponseReasoningTextWsDelta
                ) = responseReasoningTextDelta.validity()

                override fun visitResponseReasoningTextDone(
                    responseReasoningTextDone: ResponseReasoningTextWsDone
                ) = responseReasoningTextDone.validity()

                override fun visitResponseRefusalDelta(
                    responseRefusalDelta: ResponseRefusalWsDelta
                ) = responseRefusalDelta.validity()

                override fun visitResponseRefusalDone(responseRefusalDone: ResponseRefusalWsDone) =
                    responseRefusalDone.validity()

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextWsDelta
                ) = responseOutputTextDelta.validity()

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextWsDone
                ) = responseOutputTextDone.validity()

                override fun visitResponseWebSearchCallCompleted(
                    responseWebSearchCallCompleted: ResponseWebSearchCallWsCompleted
                ) = responseWebSearchCallCompleted.validity()

                override fun visitResponseWebSearchCallInProgress(
                    responseWebSearchCallInProgress: ResponseWebSearchCallInWsProgress
                ) = responseWebSearchCallInProgress.validity()

                override fun visitResponseWebSearchCallSearching(
                    responseWebSearchCallSearching: ResponseWebSearchCallWsSearching
                ) = responseWebSearchCallSearching.validity()

                override fun visitResponseImageGenerationCallCompleted(
                    responseImageGenerationCallCompleted: ResponseImageGenCallWsCompleted
                ) = responseImageGenerationCallCompleted.validity()

                override fun visitResponseImageGenerationCallGenerating(
                    responseImageGenerationCallGenerating: ResponseImageGenCallWsGenerating
                ) = responseImageGenerationCallGenerating.validity()

                override fun visitResponseImageGenerationCallInProgress(
                    responseImageGenerationCallInProgress: ResponseImageGenCallInWsProgress
                ) = responseImageGenerationCallInProgress.validity()

                override fun visitResponseImageGenerationCallPartialImage(
                    responseImageGenerationCallPartialImage: ResponseImageGenCallPartialWsImage
                ) = responseImageGenerationCallPartialImage.validity()

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsWsDelta
                ) = responseMcpCallArgumentsDelta.validity()

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsWsDone
                ) = responseMcpCallArgumentsDone.validity()

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallWsCompleted
                ) = responseMcpCallCompleted.validity()

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallWsFailed
                ) = responseMcpCallFailed.validity()

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInWsProgress
                ) = responseMcpCallInProgress.validity()

                override fun visitResponseMcpListToolsCompleted(
                    responseMcpListToolsCompleted: ResponseMcpListToolsWsCompleted
                ) = responseMcpListToolsCompleted.validity()

                override fun visitResponseMcpListToolsFailed(
                    responseMcpListToolsFailed: ResponseMcpListToolsWsFailed
                ) = responseMcpListToolsFailed.validity()

                override fun visitResponseMcpListToolsInProgress(
                    responseMcpListToolsInProgress: ResponseMcpListToolsInWsProgress
                ) = responseMcpListToolsInProgress.validity()

                override fun visitResponseOutputTextAnnotationAdded(
                    responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationWsAdded
                ) = responseOutputTextAnnotationAdded.validity()

                override fun visitResponseQueued(responseQueued: ResponseWsQueued) =
                    responseQueued.validity()

                override fun visitResponseCustomToolCallInputDelta(
                    responseCustomToolCallInputDelta: ResponseCustomToolCallInputWsDelta
                ) = responseCustomToolCallInputDelta.validity()

                override fun visitResponseCustomToolCallInputDone(
                    responseCustomToolCallInputDone: ResponseCustomToolCallInputWsDone
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
        fun ofResponseAudioDelta(responseAudioDelta: ResponseAudioWsDelta) =
            ResponsesServerEvent(responseAudioDelta = responseAudioDelta)

        /** Emitted when the audio response is complete. */
        @JvmStatic
        fun ofResponseAudioDone(responseAudioDone: ResponseAudioWsDone) =
            ResponsesServerEvent(responseAudioDone = responseAudioDone)

        /** Emitted when there is a partial transcript of audio. */
        @JvmStatic
        fun ofResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptWsDelta
        ) = ResponsesServerEvent(responseAudioTranscriptDelta = responseAudioTranscriptDelta)

        /** Emitted when the full audio transcript is completed. */
        @JvmStatic
        fun ofResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptWsDone
        ) = ResponsesServerEvent(responseAudioTranscriptDone = responseAudioTranscriptDone)

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeWsDelta
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCodeDelta = responseCodeInterpreterCallCodeDelta
            )

        /** Emitted when the code snippet is finalized by the code interpreter. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeWsDone
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCodeDone = responseCodeInterpreterCallCodeDone
            )

        /** Emitted when the code interpreter call is completed. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallWsCompleted
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallCompleted = responseCodeInterpreterCallCompleted
            )

        /** Emitted when a code interpreter call is in progress. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInWsProgress
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallInProgress = responseCodeInterpreterCallInProgress
            )

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        @JvmStatic
        fun ofResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting: ResponseCodeInterpreterCallWsInterpreting
        ) =
            ResponsesServerEvent(
                responseCodeInterpreterCallInterpreting = responseCodeInterpreterCallInterpreting
            )

        /** Emitted when the model response is complete. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: ResponseWsCompleted) =
            ResponsesServerEvent(responseCompleted = responseCompleted)

        /** Emitted when a new content part is added. */
        @JvmStatic
        fun ofResponseContentPartAdded(responseContentPartAdded: ResponseContentPartWsAdded) =
            ResponsesServerEvent(responseContentPartAdded = responseContentPartAdded)

        /** Emitted when a content part is done. */
        @JvmStatic
        fun ofResponseContentPartDone(responseContentPartDone: ResponseContentPartWsDone) =
            ResponsesServerEvent(responseContentPartDone = responseContentPartDone)

        /** An event that is emitted when a response is created. */
        @JvmStatic
        fun ofResponseCreated(responseCreated: ResponseWsCreated) =
            ResponsesServerEvent(responseCreated = responseCreated)

        /** Emitted when an error occurs. */
        @JvmStatic fun ofError(error: ResponseWsError) = ResponsesServerEvent(error = error)

        /** Emitted when a file search call is completed (results found). */
        @JvmStatic
        fun ofResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: ResponseFileSearchCallWsCompleted
        ) = ResponsesServerEvent(responseFileSearchCallCompleted = responseFileSearchCallCompleted)

        /** Emitted when a file search call is initiated. */
        @JvmStatic
        fun ofResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: ResponseFileSearchCallInWsProgress
        ) =
            ResponsesServerEvent(
                responseFileSearchCallInProgress = responseFileSearchCallInProgress
            )

        /** Emitted when a file search is currently searching. */
        @JvmStatic
        fun ofResponseFileSearchCallSearching(
            responseFileSearchCallSearching: ResponseFileSearchCallWsSearching
        ) = ResponsesServerEvent(responseFileSearchCallSearching = responseFileSearchCallSearching)

        /** Emitted when there is a partial function-call arguments delta. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsWsDelta
        ) =
            ResponsesServerEvent(
                responseFunctionCallArgumentsDelta = responseFunctionCallArgumentsDelta
            )

        /** Emitted when function-call arguments are finalized. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsWsDone
        ) =
            ResponsesServerEvent(
                responseFunctionCallArgumentsDone = responseFunctionCallArgumentsDone
            )

        /** Emitted when the response is in progress. */
        @JvmStatic
        fun ofResponseInProgress(responseInProgress: ResponseInWsProgress) =
            ResponsesServerEvent(responseInProgress = responseInProgress)

        /** An event that is emitted when a response fails. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: ResponseWsFailed) =
            ResponsesServerEvent(responseFailed = responseFailed)

        /** An event that is emitted when a response finishes as incomplete. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: ResponseWsIncomplete) =
            ResponsesServerEvent(responseIncomplete = responseIncomplete)

        /** Emitted when a new output item is added. */
        @JvmStatic
        fun ofResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemWsAdded) =
            ResponsesServerEvent(responseOutputItemAdded = responseOutputItemAdded)

        /** Emitted when an output item is marked done. */
        @JvmStatic
        fun ofResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemWsDone) =
            ResponsesServerEvent(responseOutputItemDone = responseOutputItemDone)

        /** Emitted when a new reasoning summary part is added. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartWsAdded
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryPartAdded = responseReasoningSummaryPartAdded
            )

        /** Emitted when a reasoning summary part is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: ResponseReasoningSummaryPartWsDone
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryPartDone = responseReasoningSummaryPartDone
            )

        /** Emitted when a delta is added to a reasoning summary text. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextWsDelta
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryTextDelta = responseReasoningSummaryTextDelta
            )

        /** Emitted when a reasoning summary text is completed. */
        @JvmStatic
        fun ofResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: ResponseReasoningSummaryTextWsDone
        ) =
            ResponsesServerEvent(
                responseReasoningSummaryTextDone = responseReasoningSummaryTextDone
            )

        /** Emitted when a delta is added to a reasoning text. */
        @JvmStatic
        fun ofResponseReasoningTextDelta(responseReasoningTextDelta: ResponseReasoningTextWsDelta) =
            ResponsesServerEvent(responseReasoningTextDelta = responseReasoningTextDelta)

        /** Emitted when a reasoning text is completed. */
        @JvmStatic
        fun ofResponseReasoningTextDone(responseReasoningTextDone: ResponseReasoningTextWsDone) =
            ResponsesServerEvent(responseReasoningTextDone = responseReasoningTextDone)

        /** Emitted when there is a partial refusal text. */
        @JvmStatic
        fun ofResponseRefusalDelta(responseRefusalDelta: ResponseRefusalWsDelta) =
            ResponsesServerEvent(responseRefusalDelta = responseRefusalDelta)

        /** Emitted when refusal text is finalized. */
        @JvmStatic
        fun ofResponseRefusalDone(responseRefusalDone: ResponseRefusalWsDone) =
            ResponsesServerEvent(responseRefusalDone = responseRefusalDone)

        /** Emitted when there is an additional text delta. */
        @JvmStatic
        fun ofResponseOutputTextDelta(responseOutputTextDelta: ResponseTextWsDelta) =
            ResponsesServerEvent(responseOutputTextDelta = responseOutputTextDelta)

        /** Emitted when text content is finalized. */
        @JvmStatic
        fun ofResponseOutputTextDone(responseOutputTextDone: ResponseTextWsDone) =
            ResponsesServerEvent(responseOutputTextDone = responseOutputTextDone)

        /** Emitted when a web search call is completed. */
        @JvmStatic
        fun ofResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: ResponseWebSearchCallWsCompleted
        ) = ResponsesServerEvent(responseWebSearchCallCompleted = responseWebSearchCallCompleted)

        /** Emitted when a web search call is initiated. */
        @JvmStatic
        fun ofResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: ResponseWebSearchCallInWsProgress
        ) = ResponsesServerEvent(responseWebSearchCallInProgress = responseWebSearchCallInProgress)

        /** Emitted when a web search call is executing. */
        @JvmStatic
        fun ofResponseWebSearchCallSearching(
            responseWebSearchCallSearching: ResponseWebSearchCallWsSearching
        ) = ResponsesServerEvent(responseWebSearchCallSearching = responseWebSearchCallSearching)

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        @JvmStatic
        fun ofResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: ResponseImageGenCallWsCompleted
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
            responseImageGenerationCallGenerating: ResponseImageGenCallWsGenerating
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallGenerating = responseImageGenerationCallGenerating
            )

        /** Emitted when an image generation tool call is in progress. */
        @JvmStatic
        fun ofResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: ResponseImageGenCallInWsProgress
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallInProgress = responseImageGenerationCallInProgress
            )

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: ResponseImageGenCallPartialWsImage
        ) =
            ResponsesServerEvent(
                responseImageGenerationCallPartialImage = responseImageGenerationCallPartialImage
            )

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsWsDelta
        ) = ResponsesServerEvent(responseMcpCallArgumentsDelta = responseMcpCallArgumentsDelta)

        /** Emitted when the arguments for an MCP tool call are finalized. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsWsDone
        ) = ResponsesServerEvent(responseMcpCallArgumentsDone = responseMcpCallArgumentsDone)

        /** Emitted when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofResponseMcpCallCompleted(responseMcpCallCompleted: ResponseMcpCallWsCompleted) =
            ResponsesServerEvent(responseMcpCallCompleted = responseMcpCallCompleted)

        /** Emitted when an MCP tool call has failed. */
        @JvmStatic
        fun ofResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallWsFailed) =
            ResponsesServerEvent(responseMcpCallFailed = responseMcpCallFailed)

        /** Emitted when an MCP tool call is in progress. */
        @JvmStatic
        fun ofResponseMcpCallInProgress(responseMcpCallInProgress: ResponseMcpCallInWsProgress) =
            ResponsesServerEvent(responseMcpCallInProgress = responseMcpCallInProgress)

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        @JvmStatic
        fun ofResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: ResponseMcpListToolsWsCompleted
        ) = ResponsesServerEvent(responseMcpListToolsCompleted = responseMcpListToolsCompleted)

        /** Emitted when the attempt to list available MCP tools has failed. */
        @JvmStatic
        fun ofResponseMcpListToolsFailed(responseMcpListToolsFailed: ResponseMcpListToolsWsFailed) =
            ResponsesServerEvent(responseMcpListToolsFailed = responseMcpListToolsFailed)

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        @JvmStatic
        fun ofResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: ResponseMcpListToolsInWsProgress
        ) = ResponsesServerEvent(responseMcpListToolsInProgress = responseMcpListToolsInProgress)

        /** Emitted when an annotation is added to output text content. */
        @JvmStatic
        fun ofResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationWsAdded
        ) =
            ResponsesServerEvent(
                responseOutputTextAnnotationAdded = responseOutputTextAnnotationAdded
            )

        /** Emitted when a response is queued and waiting to be processed. */
        @JvmStatic
        fun ofResponseQueued(responseQueued: ResponseWsQueued) =
            ResponsesServerEvent(responseQueued = responseQueued)

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: ResponseCustomToolCallInputWsDelta
        ) =
            ResponsesServerEvent(
                responseCustomToolCallInputDelta = responseCustomToolCallInputDelta
            )

        /** Event indicating that input for a custom tool call is complete. */
        @JvmStatic
        fun ofResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: ResponseCustomToolCallInputWsDone
        ) = ResponsesServerEvent(responseCustomToolCallInputDone = responseCustomToolCallInputDone)
    }

    /**
     * An interface that defines how to map each variant of [ResponsesServerEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Emitted when there is a partial audio response. */
        fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioWsDelta): T

        /** Emitted when the audio response is complete. */
        fun visitResponseAudioDone(responseAudioDone: ResponseAudioWsDone): T

        /** Emitted when there is a partial transcript of audio. */
        fun visitResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptWsDelta
        ): T

        /** Emitted when the full audio transcript is completed. */
        fun visitResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptWsDone
        ): T

        /** Emitted when a partial code snippet is streamed by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDelta(
            responseCodeInterpreterCallCodeDelta: ResponseCodeInterpreterCallCodeWsDelta
        ): T

        /** Emitted when the code snippet is finalized by the code interpreter. */
        fun visitResponseCodeInterpreterCallCodeDone(
            responseCodeInterpreterCallCodeDone: ResponseCodeInterpreterCallCodeWsDone
        ): T

        /** Emitted when the code interpreter call is completed. */
        fun visitResponseCodeInterpreterCallCompleted(
            responseCodeInterpreterCallCompleted: ResponseCodeInterpreterCallWsCompleted
        ): T

        /** Emitted when a code interpreter call is in progress. */
        fun visitResponseCodeInterpreterCallInProgress(
            responseCodeInterpreterCallInProgress: ResponseCodeInterpreterCallInWsProgress
        ): T

        /** Emitted when the code interpreter is actively interpreting the code snippet. */
        fun visitResponseCodeInterpreterCallInterpreting(
            responseCodeInterpreterCallInterpreting: ResponseCodeInterpreterCallWsInterpreting
        ): T

        /** Emitted when the model response is complete. */
        fun visitResponseCompleted(responseCompleted: ResponseWsCompleted): T

        /** Emitted when a new content part is added. */
        fun visitResponseContentPartAdded(responseContentPartAdded: ResponseContentPartWsAdded): T

        /** Emitted when a content part is done. */
        fun visitResponseContentPartDone(responseContentPartDone: ResponseContentPartWsDone): T

        /** An event that is emitted when a response is created. */
        fun visitResponseCreated(responseCreated: ResponseWsCreated): T

        /** Emitted when an error occurs. */
        fun visitError(error: ResponseWsError): T

        /** Emitted when a file search call is completed (results found). */
        fun visitResponseFileSearchCallCompleted(
            responseFileSearchCallCompleted: ResponseFileSearchCallWsCompleted
        ): T

        /** Emitted when a file search call is initiated. */
        fun visitResponseFileSearchCallInProgress(
            responseFileSearchCallInProgress: ResponseFileSearchCallInWsProgress
        ): T

        /** Emitted when a file search is currently searching. */
        fun visitResponseFileSearchCallSearching(
            responseFileSearchCallSearching: ResponseFileSearchCallWsSearching
        ): T

        /** Emitted when there is a partial function-call arguments delta. */
        fun visitResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsWsDelta
        ): T

        /** Emitted when function-call arguments are finalized. */
        fun visitResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsWsDone
        ): T

        /** Emitted when the response is in progress. */
        fun visitResponseInProgress(responseInProgress: ResponseInWsProgress): T

        /** An event that is emitted when a response fails. */
        fun visitResponseFailed(responseFailed: ResponseWsFailed): T

        /** An event that is emitted when a response finishes as incomplete. */
        fun visitResponseIncomplete(responseIncomplete: ResponseWsIncomplete): T

        /** Emitted when a new output item is added. */
        fun visitResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemWsAdded): T

        /** Emitted when an output item is marked done. */
        fun visitResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemWsDone): T

        /** Emitted when a new reasoning summary part is added. */
        fun visitResponseReasoningSummaryPartAdded(
            responseReasoningSummaryPartAdded: ResponseReasoningSummaryPartWsAdded
        ): T

        /** Emitted when a reasoning summary part is completed. */
        fun visitResponseReasoningSummaryPartDone(
            responseReasoningSummaryPartDone: ResponseReasoningSummaryPartWsDone
        ): T

        /** Emitted when a delta is added to a reasoning summary text. */
        fun visitResponseReasoningSummaryTextDelta(
            responseReasoningSummaryTextDelta: ResponseReasoningSummaryTextWsDelta
        ): T

        /** Emitted when a reasoning summary text is completed. */
        fun visitResponseReasoningSummaryTextDone(
            responseReasoningSummaryTextDone: ResponseReasoningSummaryTextWsDone
        ): T

        /** Emitted when a delta is added to a reasoning text. */
        fun visitResponseReasoningTextDelta(
            responseReasoningTextDelta: ResponseReasoningTextWsDelta
        ): T

        /** Emitted when a reasoning text is completed. */
        fun visitResponseReasoningTextDone(
            responseReasoningTextDone: ResponseReasoningTextWsDone
        ): T

        /** Emitted when there is a partial refusal text. */
        fun visitResponseRefusalDelta(responseRefusalDelta: ResponseRefusalWsDelta): T

        /** Emitted when refusal text is finalized. */
        fun visitResponseRefusalDone(responseRefusalDone: ResponseRefusalWsDone): T

        /** Emitted when there is an additional text delta. */
        fun visitResponseOutputTextDelta(responseOutputTextDelta: ResponseTextWsDelta): T

        /** Emitted when text content is finalized. */
        fun visitResponseOutputTextDone(responseOutputTextDone: ResponseTextWsDone): T

        /** Emitted when a web search call is completed. */
        fun visitResponseWebSearchCallCompleted(
            responseWebSearchCallCompleted: ResponseWebSearchCallWsCompleted
        ): T

        /** Emitted when a web search call is initiated. */
        fun visitResponseWebSearchCallInProgress(
            responseWebSearchCallInProgress: ResponseWebSearchCallInWsProgress
        ): T

        /** Emitted when a web search call is executing. */
        fun visitResponseWebSearchCallSearching(
            responseWebSearchCallSearching: ResponseWebSearchCallWsSearching
        ): T

        /**
         * Emitted when an image generation tool call has completed and the final image is
         * available.
         */
        fun visitResponseImageGenerationCallCompleted(
            responseImageGenerationCallCompleted: ResponseImageGenCallWsCompleted
        ): T

        /**
         * Emitted when an image generation tool call is actively generating an image (intermediate
         * state).
         */
        fun visitResponseImageGenerationCallGenerating(
            responseImageGenerationCallGenerating: ResponseImageGenCallWsGenerating
        ): T

        /** Emitted when an image generation tool call is in progress. */
        fun visitResponseImageGenerationCallInProgress(
            responseImageGenerationCallInProgress: ResponseImageGenCallInWsProgress
        ): T

        /** Emitted when a partial image is available during image generation streaming. */
        fun visitResponseImageGenerationCallPartialImage(
            responseImageGenerationCallPartialImage: ResponseImageGenCallPartialWsImage
        ): T

        /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
        fun visitResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsWsDelta
        ): T

        /** Emitted when the arguments for an MCP tool call are finalized. */
        fun visitResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsWsDone
        ): T

        /** Emitted when an MCP tool call has completed successfully. */
        fun visitResponseMcpCallCompleted(responseMcpCallCompleted: ResponseMcpCallWsCompleted): T

        /** Emitted when an MCP tool call has failed. */
        fun visitResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallWsFailed): T

        /** Emitted when an MCP tool call is in progress. */
        fun visitResponseMcpCallInProgress(
            responseMcpCallInProgress: ResponseMcpCallInWsProgress
        ): T

        /** Emitted when the list of available MCP tools has been successfully retrieved. */
        fun visitResponseMcpListToolsCompleted(
            responseMcpListToolsCompleted: ResponseMcpListToolsWsCompleted
        ): T

        /** Emitted when the attempt to list available MCP tools has failed. */
        fun visitResponseMcpListToolsFailed(
            responseMcpListToolsFailed: ResponseMcpListToolsWsFailed
        ): T

        /**
         * Emitted when the system is in the process of retrieving the list of available MCP tools.
         */
        fun visitResponseMcpListToolsInProgress(
            responseMcpListToolsInProgress: ResponseMcpListToolsInWsProgress
        ): T

        /** Emitted when an annotation is added to output text content. */
        fun visitResponseOutputTextAnnotationAdded(
            responseOutputTextAnnotationAdded: ResponseOutputTextAnnotationWsAdded
        ): T

        /** Emitted when a response is queued and waiting to be processed. */
        fun visitResponseQueued(responseQueued: ResponseWsQueued): T

        /** Event representing a delta (partial update) to the input of a custom tool call. */
        fun visitResponseCustomToolCallInputDelta(
            responseCustomToolCallInputDelta: ResponseCustomToolCallInputWsDelta
        ): T

        /** Event indicating that input for a custom tool call is complete. */
        fun visitResponseCustomToolCallInputDone(
            responseCustomToolCallInputDone: ResponseCustomToolCallInputWsDone
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
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioWsDelta>())?.let {
                        ResponsesServerEvent(responseAudioDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioWsDone>())?.let {
                        ResponsesServerEvent(responseAudioDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptWsDelta>())
                        ?.let {
                            ResponsesServerEvent(responseAudioTranscriptDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.audio.transcript.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptWsDone>())
                        ?.let {
                            ResponsesServerEvent(responseAudioTranscriptDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.code_interpreter_call_code.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeWsDelta>(),
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
                            jacksonTypeRef<ResponseCodeInterpreterCallCodeWsDone>(),
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
                            jacksonTypeRef<ResponseCodeInterpreterCallWsCompleted>(),
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
                            jacksonTypeRef<ResponseCodeInterpreterCallInWsProgress>(),
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
                            jacksonTypeRef<ResponseCodeInterpreterCallWsInterpreting>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCodeInterpreterCallInterpreting = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsCompleted>())?.let {
                        ResponsesServerEvent(responseCompleted = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartWsAdded>())?.let {
                        ResponsesServerEvent(responseContentPartAdded = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartWsDone>())?.let {
                        ResponsesServerEvent(responseContentPartDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsCreated>())?.let {
                        ResponsesServerEvent(responseCreated = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsError>())?.let {
                        ResponsesServerEvent(error = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFileSearchCallWsCompleted>())
                        ?.let {
                            ResponsesServerEvent(responseFileSearchCallCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFileSearchCallInWsProgress>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseFileSearchCallInProgress = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.file_search_call.searching" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFileSearchCallWsSearching>())
                        ?.let {
                            ResponsesServerEvent(responseFileSearchCallSearching = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsWsDelta>(),
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
                            jacksonTypeRef<ResponseFunctionCallArgumentsWsDone>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseFunctionCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseInWsProgress>())?.let {
                        ResponsesServerEvent(responseInProgress = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsFailed>())?.let {
                        ResponsesServerEvent(responseFailed = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsIncomplete>())?.let {
                        ResponsesServerEvent(responseIncomplete = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemWsAdded>())?.let {
                        ResponsesServerEvent(responseOutputItemAdded = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemWsDone>())?.let {
                        ResponsesServerEvent(responseOutputItemDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_summary_part.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseReasoningSummaryPartWsAdded>(),
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
                            jacksonTypeRef<ResponseReasoningSummaryPartWsDone>(),
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
                            jacksonTypeRef<ResponseReasoningSummaryTextWsDelta>(),
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
                            jacksonTypeRef<ResponseReasoningSummaryTextWsDone>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseReasoningSummaryTextDone = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextWsDelta>())
                        ?.let {
                            ResponsesServerEvent(responseReasoningTextDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.reasoning_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningTextWsDone>())
                        ?.let { ResponsesServerEvent(responseReasoningTextDone = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.refusal.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalWsDelta>())?.let {
                        ResponsesServerEvent(responseRefusalDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.refusal.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseRefusalWsDone>())?.let {
                        ResponsesServerEvent(responseRefusalDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextWsDelta>())?.let {
                        ResponsesServerEvent(responseOutputTextDelta = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextWsDone>())?.let {
                        ResponsesServerEvent(responseOutputTextDone = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWebSearchCallWsCompleted>())
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWebSearchCallInWsProgress>())
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallInProgress = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.web_search_call.searching" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWebSearchCallWsSearching>())
                        ?.let {
                            ResponsesServerEvent(responseWebSearchCallSearching = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseImageGenCallWsCompleted>())
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallCompleted = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.generating" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseImageGenCallWsGenerating>())
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallGenerating = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.image_generation_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseImageGenCallInWsProgress>())
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
                            jacksonTypeRef<ResponseImageGenCallPartialWsImage>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseImageGenerationCallPartialImage = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsWsDelta>())
                        ?.let {
                            ResponsesServerEvent(responseMcpCallArgumentsDelta = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsWsDone>())
                        ?.let {
                            ResponsesServerEvent(responseMcpCallArgumentsDone = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallWsCompleted>())?.let {
                        ResponsesServerEvent(responseMcpCallCompleted = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallWsFailed>())?.let {
                        ResponsesServerEvent(responseMcpCallFailed = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallInWsProgress>())
                        ?.let { ResponsesServerEvent(responseMcpCallInProgress = it, _json = json) }
                        ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpListToolsWsCompleted>())
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsCompleted = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpListToolsWsFailed>())
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsFailed = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.mcp_list_tools.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpListToolsInWsProgress>())
                        ?.let {
                            ResponsesServerEvent(responseMcpListToolsInProgress = it, _json = json)
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.output_text.annotation.added" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseOutputTextAnnotationWsAdded>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseOutputTextAnnotationAdded = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseWsQueued>())?.let {
                        ResponsesServerEvent(responseQueued = it, _json = json)
                    } ?: ResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseCustomToolCallInputWsDelta>(),
                        )
                        ?.let {
                            ResponsesServerEvent(
                                responseCustomToolCallInputDelta = it,
                                _json = json,
                            )
                        } ?: ResponsesServerEvent(_json = json)
                }
                "response.custom_tool_call_input.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCustomToolCallInputWsDone>())
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

    /** Emitted when there is a partial audio response. */
    class ResponseAudioWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseAudioDeltaEvent(): ResponseAudioDeltaEvent =
            ResponseAudioDeltaEvent.builder()
                .delta(delta)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * A chunk of Base64 encoded response audio bytes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * A sequence number for this chunk of the stream response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.audio.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.audio.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

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
             * Returns a mutable builder for constructing an instance of [ResponseAudioWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseAudioWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.audio.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseAudioWsDelta: ResponseAudioWsDelta) = apply {
                delta = responseAudioWsDelta.delta
                sequenceNumber = responseAudioWsDelta.sequenceNumber
                type = responseAudioWsDelta.type
                streamId = responseAudioWsDelta.streamId
                additionalProperties = responseAudioWsDelta.additionalProperties.toMutableMap()
            }

            /** A chunk of Base64 encoded response audio bytes. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** A sequence number for this chunk of the stream response. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.audio.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseAudioWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseAudioWsDelta =
                ResponseAudioWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseAudioWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.audio.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.audio.delta")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseAudioWsDelta &&
                delta == other.delta &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(delta, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseAudioWsDelta{delta=$delta, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the audio response is complete. */
    class ResponseAudioWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseAudioDoneEvent(): ResponseAudioDoneEvent =
            ResponseAudioDoneEvent.builder().sequenceNumber(sequenceNumber).type(type).build()

        /**
         * The sequence number of the delta.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.audio.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.audio.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

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
             * Returns a mutable builder for constructing an instance of [ResponseAudioWsDone].
             *
             * The following fields are required:
             * ```java
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseAudioWsDone]. */
        class Builder internal constructor() {

            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.audio.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseAudioWsDone: ResponseAudioWsDone) = apply {
                sequenceNumber = responseAudioWsDone.sequenceNumber
                type = responseAudioWsDone.type
                streamId = responseAudioWsDone.streamId
                additionalProperties = responseAudioWsDone.additionalProperties.toMutableMap()
            }

            /** The sequence number of the delta. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.audio.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseAudioWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseAudioWsDone =
                ResponseAudioWsDone(
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseAudioWsDone = apply {
            if (validated) {
                return@apply
            }

            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.audio.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.audio.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseAudioWsDone &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseAudioWsDone{sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when there is a partial transcript of audio. */
    class ResponseAudioTranscriptWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseAudioTranscriptDeltaEvent(): ResponseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder()
                .delta(delta)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The partial transcript of the audio response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.audio.transcript.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.audio.transcript.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseAudioTranscriptWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseAudioTranscriptWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.audio.transcript.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseAudioTranscriptWsDelta: ResponseAudioTranscriptWsDelta) =
                apply {
                    delta = responseAudioTranscriptWsDelta.delta
                    sequenceNumber = responseAudioTranscriptWsDelta.sequenceNumber
                    type = responseAudioTranscriptWsDelta.type
                    streamId = responseAudioTranscriptWsDelta.streamId
                    additionalProperties =
                        responseAudioTranscriptWsDelta.additionalProperties.toMutableMap()
                }

            /** The partial transcript of the audio response. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.audio.transcript.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseAudioTranscriptWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseAudioTranscriptWsDelta =
                ResponseAudioTranscriptWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseAudioTranscriptWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.audio.transcript.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.audio.transcript.delta")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseAudioTranscriptWsDelta &&
                delta == other.delta &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(delta, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseAudioTranscriptWsDelta{delta=$delta, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the full audio transcript is completed. */
    class ResponseAudioTranscriptWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseAudioTranscriptDoneEvent(): ResponseAudioTranscriptDoneEvent =
            ResponseAudioTranscriptDoneEvent.builder()
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.audio.transcript.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.audio.transcript.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseAudioTranscriptWsDone].
             *
             * The following fields are required:
             * ```java
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseAudioTranscriptWsDone]. */
        class Builder internal constructor() {

            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.audio.transcript.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseAudioTranscriptWsDone: ResponseAudioTranscriptWsDone) =
                apply {
                    sequenceNumber = responseAudioTranscriptWsDone.sequenceNumber
                    type = responseAudioTranscriptWsDone.type
                    streamId = responseAudioTranscriptWsDone.streamId
                    additionalProperties =
                        responseAudioTranscriptWsDone.additionalProperties.toMutableMap()
                }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.audio.transcript.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseAudioTranscriptWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseAudioTranscriptWsDone =
                ResponseAudioTranscriptWsDone(
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseAudioTranscriptWsDone = apply {
            if (validated) {
                return@apply
            }

            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.audio.transcript.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.audio.transcript.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseAudioTranscriptWsDone &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseAudioTranscriptWsDone{sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a partial code snippet is streamed by the code interpreter. */
    class ResponseCodeInterpreterCallCodeWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCodeInterpreterCallCodeDeltaEvent():
            ResponseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The partial code snippet being streamed by the code interpreter.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The unique identifier of the code interpreter tool call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response for which the code is being streamed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event, used to order streaming events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.code_interpreter_call_code.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.code_interpreter_call_code.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCodeInterpreterCallCodeWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCodeInterpreterCallCodeWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.code_interpreter_call_code.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCodeInterpreterCallCodeWsDelta: ResponseCodeInterpreterCallCodeWsDelta
            ) = apply {
                delta = responseCodeInterpreterCallCodeWsDelta.delta
                itemId = responseCodeInterpreterCallCodeWsDelta.itemId
                outputIndex = responseCodeInterpreterCallCodeWsDelta.outputIndex
                sequenceNumber = responseCodeInterpreterCallCodeWsDelta.sequenceNumber
                type = responseCodeInterpreterCallCodeWsDelta.type
                streamId = responseCodeInterpreterCallCodeWsDelta.streamId
                additionalProperties =
                    responseCodeInterpreterCallCodeWsDelta.additionalProperties.toMutableMap()
            }

            /** The partial code snippet being streamed by the code interpreter. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The unique identifier of the code interpreter tool call item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /**
             * The index of the output item in the response for which the code is being streamed.
             */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event, used to order streaming events. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.code_interpreter_call_code.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCodeInterpreterCallCodeWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCodeInterpreterCallCodeWsDelta =
                ResponseCodeInterpreterCallCodeWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCodeInterpreterCallCodeWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.code_interpreter_call_code.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.code_interpreter_call_code.delta")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCodeInterpreterCallCodeWsDelta &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCodeInterpreterCallCodeWsDelta{delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the code snippet is finalized by the code interpreter. */
    class ResponseCodeInterpreterCallCodeWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(code, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCodeInterpreterCallCodeDoneEvent(): ResponseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code(code)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The final code snippet output by the code interpreter.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): String = code.getRequired("code")

        /**
         * The unique identifier of the code interpreter tool call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response for which the code is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event, used to order streaming events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.code_interpreter_call_code.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.code_interpreter_call_code.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCodeInterpreterCallCodeWsDone].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCodeInterpreterCallCodeWsDone]. */
        class Builder internal constructor() {

            private var code: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.code_interpreter_call_code.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCodeInterpreterCallCodeWsDone: ResponseCodeInterpreterCallCodeWsDone
            ) = apply {
                code = responseCodeInterpreterCallCodeWsDone.code
                itemId = responseCodeInterpreterCallCodeWsDone.itemId
                outputIndex = responseCodeInterpreterCallCodeWsDone.outputIndex
                sequenceNumber = responseCodeInterpreterCallCodeWsDone.sequenceNumber
                type = responseCodeInterpreterCallCodeWsDone.type
                streamId = responseCodeInterpreterCallCodeWsDone.streamId
                additionalProperties =
                    responseCodeInterpreterCallCodeWsDone.additionalProperties.toMutableMap()
            }

            /** The final code snippet output by the code interpreter. */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** The unique identifier of the code interpreter tool call item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response for which the code is finalized. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event, used to order streaming events. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.code_interpreter_call_code.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCodeInterpreterCallCodeWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCodeInterpreterCallCodeWsDone =
                ResponseCodeInterpreterCallCodeWsDone(
                    checkRequired("code", code),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCodeInterpreterCallCodeWsDone = apply {
            if (validated) {
                return@apply
            }

            code()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.code_interpreter_call_code.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.code_interpreter_call_code.done")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCodeInterpreterCallCodeWsDone &&
                code == other.code &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                code,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCodeInterpreterCallCodeWsDone{code=$code, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the code interpreter call is completed. */
    class ResponseCodeInterpreterCallWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCodeInterpreterCallCompletedEvent():
            ResponseCodeInterpreterCallCompletedEvent =
            ResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the code interpreter tool call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response for which the code interpreter call is
         * completed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event, used to order streaming events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.code_interpreter_call.completed`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.code_interpreter_call.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCodeInterpreterCallWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCodeInterpreterCallWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.code_interpreter_call.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCodeInterpreterCallWsCompleted: ResponseCodeInterpreterCallWsCompleted
            ) = apply {
                itemId = responseCodeInterpreterCallWsCompleted.itemId
                outputIndex = responseCodeInterpreterCallWsCompleted.outputIndex
                sequenceNumber = responseCodeInterpreterCallWsCompleted.sequenceNumber
                type = responseCodeInterpreterCallWsCompleted.type
                streamId = responseCodeInterpreterCallWsCompleted.streamId
                additionalProperties =
                    responseCodeInterpreterCallWsCompleted.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the code interpreter tool call item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /**
             * The index of the output item in the response for which the code interpreter call is
             * completed.
             */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event, used to order streaming events. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.code_interpreter_call.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCodeInterpreterCallWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCodeInterpreterCallWsCompleted =
                ResponseCodeInterpreterCallWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCodeInterpreterCallWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.code_interpreter_call.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.code_interpreter_call.completed")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCodeInterpreterCallWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCodeInterpreterCallWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a code interpreter call is in progress. */
    class ResponseCodeInterpreterCallInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCodeInterpreterCallInProgressEvent():
            ResponseCodeInterpreterCallInProgressEvent =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the code interpreter tool call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response for which the code interpreter call is in
         * progress.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event, used to order streaming events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.code_interpreter_call.in_progress`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.code_interpreter_call.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCodeInterpreterCallInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCodeInterpreterCallInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.code_interpreter_call.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCodeInterpreterCallInWsProgress: ResponseCodeInterpreterCallInWsProgress
            ) = apply {
                itemId = responseCodeInterpreterCallInWsProgress.itemId
                outputIndex = responseCodeInterpreterCallInWsProgress.outputIndex
                sequenceNumber = responseCodeInterpreterCallInWsProgress.sequenceNumber
                type = responseCodeInterpreterCallInWsProgress.type
                streamId = responseCodeInterpreterCallInWsProgress.streamId
                additionalProperties =
                    responseCodeInterpreterCallInWsProgress.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the code interpreter tool call item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /**
             * The index of the output item in the response for which the code interpreter call is
             * in progress.
             */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event, used to order streaming events. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.code_interpreter_call.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCodeInterpreterCallInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCodeInterpreterCallInWsProgress =
                ResponseCodeInterpreterCallInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCodeInterpreterCallInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.code_interpreter_call.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.code_interpreter_call.in_progress")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCodeInterpreterCallInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCodeInterpreterCallInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the code interpreter is actively interpreting the code snippet. */
    class ResponseCodeInterpreterCallWsInterpreting
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCodeInterpreterCallInterpretingEvent():
            ResponseCodeInterpreterCallInterpretingEvent =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the code interpreter tool call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response for which the code interpreter is
         * interpreting code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event, used to order streaming events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.code_interpreter_call.interpreting`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.code_interpreter_call.interpreting")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCodeInterpreterCallWsInterpreting].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCodeInterpreterCallWsInterpreting]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.code_interpreter_call.interpreting")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCodeInterpreterCallWsInterpreting: ResponseCodeInterpreterCallWsInterpreting
            ) = apply {
                itemId = responseCodeInterpreterCallWsInterpreting.itemId
                outputIndex = responseCodeInterpreterCallWsInterpreting.outputIndex
                sequenceNumber = responseCodeInterpreterCallWsInterpreting.sequenceNumber
                type = responseCodeInterpreterCallWsInterpreting.type
                streamId = responseCodeInterpreterCallWsInterpreting.streamId
                additionalProperties =
                    responseCodeInterpreterCallWsInterpreting.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the code interpreter tool call item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /**
             * The index of the output item in the response for which the code interpreter is
             * interpreting code.
             */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event, used to order streaming events. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.code_interpreter_call.interpreting")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCodeInterpreterCallWsInterpreting].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCodeInterpreterCallWsInterpreting =
                ResponseCodeInterpreterCallWsInterpreting(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCodeInterpreterCallWsInterpreting = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.code_interpreter_call.interpreting")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.code_interpreter_call.interpreting")) 1
                    else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCodeInterpreterCallWsInterpreting &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCodeInterpreterCallWsInterpreting{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the model response is complete. */
    class ResponseWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCompletedEvent(): ResponseCompletedEvent =
            ResponseCompletedEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * Properties of the completed response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number for this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.completed`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsCompleted]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsCompleted: ResponseWsCompleted) = apply {
                response = responseWsCompleted.response
                sequenceNumber = responseWsCompleted.sequenceNumber
                type = responseWsCompleted.type
                streamId = responseWsCompleted.streamId
                additionalProperties = responseWsCompleted.additionalProperties.toMutableMap()
            }

            /** Properties of the completed response. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number for this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsCompleted =
                ResponseWsCompleted(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWsCompleted = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.completed")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsCompleted &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsCompleted{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a new content part is added. */
    class ResponseContentPartWsAdded
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val part: JsonField<ResponseContentPartAddedEvent.Part>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("part")
            @ExcludeMissing
            part: JsonField<ResponseContentPartAddedEvent.Part> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseContentPartAddedEvent(): ResponseContentPartAddedEvent =
            ResponseContentPartAddedEvent.builder()
                .contentIndex(contentIndex)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .part(part)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the content part that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The ID of the output item that the content part was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the content part was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The content part that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun part(): ResponseContentPartAddedEvent.Part = part.getRequired("part")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.content_part.added`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.content_part.added")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [part].
         *
         * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("part")
        @ExcludeMissing
        fun _part(): JsonField<ResponseContentPartAddedEvent.Part> = part

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseContentPartWsAdded].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseContentPartWsAdded]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var part: JsonField<ResponseContentPartAddedEvent.Part>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.content_part.added")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseContentPartWsAdded: ResponseContentPartWsAdded) = apply {
                contentIndex = responseContentPartWsAdded.contentIndex
                itemId = responseContentPartWsAdded.itemId
                outputIndex = responseContentPartWsAdded.outputIndex
                part = responseContentPartWsAdded.part
                sequenceNumber = responseContentPartWsAdded.sequenceNumber
                type = responseContentPartWsAdded.type
                streamId = responseContentPartWsAdded.streamId
                additionalProperties =
                    responseContentPartWsAdded.additionalProperties.toMutableMap()
            }

            /** The index of the content part that was added. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The ID of the output item that the content part was added to. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the content part was added to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The content part that was added. */
            fun part(part: ResponseContentPartAddedEvent.Part) = part(JsonField.of(part))

            /**
             * Sets [Builder.part] to an arbitrary JSON value.
             *
             * You should usually call [Builder.part] with a well-typed
             * [ResponseContentPartAddedEvent.Part] value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun part(part: JsonField<ResponseContentPartAddedEvent.Part>) = apply {
                this.part = part
            }

            /**
             * Alias for calling [part] with
             * `ResponseContentPartAddedEvent.Part.ofOutputText(outputText)`.
             */
            fun part(outputText: ResponseOutputText) =
                part(ResponseContentPartAddedEvent.Part.ofOutputText(outputText))

            /**
             * Alias for calling [part] with
             * `ResponseContentPartAddedEvent.Part.ofRefusal(refusal)`.
             */
            fun part(refusal: ResponseOutputRefusal) =
                part(ResponseContentPartAddedEvent.Part.ofRefusal(refusal))

            /**
             * Alias for calling [part] with the following:
             * ```java
             * ResponseOutputRefusal.builder()
             *     .refusal(refusal)
             *     .build()
             * ```
             */
            fun refusalPart(refusal: String) =
                part(ResponseOutputRefusal.builder().refusal(refusal).build())

            /**
             * Alias for calling [part] with
             * `ResponseContentPartAddedEvent.Part.ofReasoningText(reasoningText)`.
             */
            fun part(reasoningText: ResponseContentPartAddedEvent.Part.ReasoningText) =
                part(ResponseContentPartAddedEvent.Part.ofReasoningText(reasoningText))

            /**
             * Alias for calling [part] with the following:
             * ```java
             * ResponseContentPartAddedEvent.Part.ReasoningText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun reasoningTextPart(text: String) =
                part(ResponseContentPartAddedEvent.Part.ReasoningText.builder().text(text).build())

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.content_part.added")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseContentPartWsAdded].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseContentPartWsAdded =
                ResponseContentPartWsAdded(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("part", part),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseContentPartWsAdded = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            itemId()
            outputIndex()
            part().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.content_part.added")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (part.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.content_part.added")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseContentPartWsAdded &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                part == other.part &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                itemId,
                outputIndex,
                part,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseContentPartWsAdded{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a content part is done. */
    class ResponseContentPartWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val part: JsonField<ResponseContentPartDoneEvent.Part>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("part")
            @ExcludeMissing
            part: JsonField<ResponseContentPartDoneEvent.Part> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseContentPartDoneEvent(): ResponseContentPartDoneEvent =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(contentIndex)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .part(part)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the content part that is done.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The ID of the output item that the content part was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the content part was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The content part that is done.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun part(): ResponseContentPartDoneEvent.Part = part.getRequired("part")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.content_part.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.content_part.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [part].
         *
         * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("part")
        @ExcludeMissing
        fun _part(): JsonField<ResponseContentPartDoneEvent.Part> = part

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseContentPartWsDone].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseContentPartWsDone]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var part: JsonField<ResponseContentPartDoneEvent.Part>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.content_part.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseContentPartWsDone: ResponseContentPartWsDone) = apply {
                contentIndex = responseContentPartWsDone.contentIndex
                itemId = responseContentPartWsDone.itemId
                outputIndex = responseContentPartWsDone.outputIndex
                part = responseContentPartWsDone.part
                sequenceNumber = responseContentPartWsDone.sequenceNumber
                type = responseContentPartWsDone.type
                streamId = responseContentPartWsDone.streamId
                additionalProperties = responseContentPartWsDone.additionalProperties.toMutableMap()
            }

            /** The index of the content part that is done. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The ID of the output item that the content part was added to. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the content part was added to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The content part that is done. */
            fun part(part: ResponseContentPartDoneEvent.Part) = part(JsonField.of(part))

            /**
             * Sets [Builder.part] to an arbitrary JSON value.
             *
             * You should usually call [Builder.part] with a well-typed
             * [ResponseContentPartDoneEvent.Part] value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun part(part: JsonField<ResponseContentPartDoneEvent.Part>) = apply {
                this.part = part
            }

            /**
             * Alias for calling [part] with
             * `ResponseContentPartDoneEvent.Part.ofOutputText(outputText)`.
             */
            fun part(outputText: ResponseOutputText) =
                part(ResponseContentPartDoneEvent.Part.ofOutputText(outputText))

            /**
             * Alias for calling [part] with `ResponseContentPartDoneEvent.Part.ofRefusal(refusal)`.
             */
            fun part(refusal: ResponseOutputRefusal) =
                part(ResponseContentPartDoneEvent.Part.ofRefusal(refusal))

            /**
             * Alias for calling [part] with the following:
             * ```java
             * ResponseOutputRefusal.builder()
             *     .refusal(refusal)
             *     .build()
             * ```
             */
            fun refusalPart(refusal: String) =
                part(ResponseOutputRefusal.builder().refusal(refusal).build())

            /**
             * Alias for calling [part] with
             * `ResponseContentPartDoneEvent.Part.ofReasoningText(reasoningText)`.
             */
            fun part(reasoningText: ResponseContentPartDoneEvent.Part.ReasoningText) =
                part(ResponseContentPartDoneEvent.Part.ofReasoningText(reasoningText))

            /**
             * Alias for calling [part] with the following:
             * ```java
             * ResponseContentPartDoneEvent.Part.ReasoningText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun reasoningTextPart(text: String) =
                part(ResponseContentPartDoneEvent.Part.ReasoningText.builder().text(text).build())

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.content_part.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseContentPartWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseContentPartWsDone =
                ResponseContentPartWsDone(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("part", part),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseContentPartWsDone = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            itemId()
            outputIndex()
            part().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.content_part.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (part.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.content_part.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseContentPartWsDone &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                part == other.part &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                itemId,
                outputIndex,
                part,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseContentPartWsDone{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** An event that is emitted when a response is created. */
    class ResponseWsCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCreatedEvent(): ResponseCreatedEvent =
            ResponseCreatedEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The response that was created.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number for this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.created`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.created")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseWsCreated].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsCreated]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.created")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsCreated: ResponseWsCreated) = apply {
                response = responseWsCreated.response
                sequenceNumber = responseWsCreated.sequenceNumber
                type = responseWsCreated.type
                streamId = responseWsCreated.streamId
                additionalProperties = responseWsCreated.additionalProperties.toMutableMap()
            }

            /** The response that was created. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number for this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.created")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWsCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsCreated =
                ResponseWsCreated(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWsCreated = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.created")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.created")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsCreated &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsCreated{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an error occurs. */
    class ResponseWsError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val message: JsonField<String>,
        private val param: JsonField<String>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(code, message, param, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseErrorEvent(): ResponseErrorEvent =
            ResponseErrorEvent.builder()
                .code(code)
                .message(message)
                .param(param)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The error code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun code(): Optional<String> = code.getOptional("code")

        /**
         * The error message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * The error parameter.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun param(): Optional<String> = param.getOptional("param")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

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
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

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
         * Returns the raw JSON value of [sequenceNumber].
         *
         * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sequence_number")
        @ExcludeMissing
        fun _sequenceNumber(): JsonField<Long> = sequenceNumber

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
             * .code()
             * .message()
             * .param()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsError]. */
        class Builder internal constructor() {

            private var code: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var param: JsonField<String>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("error")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsError: ResponseWsError) = apply {
                code = responseWsError.code
                message = responseWsError.message
                param = responseWsError.param
                sequenceNumber = responseWsError.sequenceNumber
                type = responseWsError.type
                streamId = responseWsError.streamId
                additionalProperties = responseWsError.additionalProperties.toMutableMap()
            }

            /** The error code. */
            fun code(code: String?) = code(JsonField.ofNullable(code))

            /** Alias for calling [Builder.code] with `code.orElse(null)`. */
            fun code(code: Optional<String>) = code(code.getOrNull())

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** The error message. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /** The error parameter. */
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

            /** The sequence number of this event. */
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
             * .code()
             * .message()
             * .param()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsError =
                ResponseWsError(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    checkRequired("param", param),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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

            code()
            message()
            param()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("error")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                (if (param.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("error")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsError &&
                code == other.code &&
                message == other.message &&
                param == other.param &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, message, param, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsError{code=$code, message=$message, param=$param, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a file search call is completed (results found). */
    class ResponseFileSearchCallWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseFileSearchCallCompletedEvent(): ResponseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the output item that the file search call is initiated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the file search call is initiated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.file_search_call.completed`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.file_search_call.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseFileSearchCallWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseFileSearchCallWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.file_search_call.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseFileSearchCallWsCompleted: ResponseFileSearchCallWsCompleted
            ) = apply {
                itemId = responseFileSearchCallWsCompleted.itemId
                outputIndex = responseFileSearchCallWsCompleted.outputIndex
                sequenceNumber = responseFileSearchCallWsCompleted.sequenceNumber
                type = responseFileSearchCallWsCompleted.type
                streamId = responseFileSearchCallWsCompleted.streamId
                additionalProperties =
                    responseFileSearchCallWsCompleted.additionalProperties.toMutableMap()
            }

            /** The ID of the output item that the file search call is initiated. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the file search call is initiated. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.file_search_call.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseFileSearchCallWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseFileSearchCallWsCompleted =
                ResponseFileSearchCallWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseFileSearchCallWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.file_search_call.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.file_search_call.completed")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFileSearchCallWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseFileSearchCallWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a file search call is initiated. */
    class ResponseFileSearchCallInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseFileSearchCallInProgressEvent(): ResponseFileSearchCallInProgressEvent =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the output item that the file search call is initiated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the file search call is initiated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.file_search_call.in_progress`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.file_search_call.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseFileSearchCallInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseFileSearchCallInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.file_search_call.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseFileSearchCallInWsProgress: ResponseFileSearchCallInWsProgress
            ) = apply {
                itemId = responseFileSearchCallInWsProgress.itemId
                outputIndex = responseFileSearchCallInWsProgress.outputIndex
                sequenceNumber = responseFileSearchCallInWsProgress.sequenceNumber
                type = responseFileSearchCallInWsProgress.type
                streamId = responseFileSearchCallInWsProgress.streamId
                additionalProperties =
                    responseFileSearchCallInWsProgress.additionalProperties.toMutableMap()
            }

            /** The ID of the output item that the file search call is initiated. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the file search call is initiated. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.file_search_call.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseFileSearchCallInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseFileSearchCallInWsProgress =
                ResponseFileSearchCallInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseFileSearchCallInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.file_search_call.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.file_search_call.in_progress")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFileSearchCallInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseFileSearchCallInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a file search is currently searching. */
    class ResponseFileSearchCallWsSearching
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseFileSearchCallSearchingEvent(): ResponseFileSearchCallSearchingEvent =
            ResponseFileSearchCallSearchingEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the output item that the file search call is initiated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the file search call is searching.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.file_search_call.searching`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.file_search_call.searching")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseFileSearchCallWsSearching].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseFileSearchCallWsSearching]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.file_search_call.searching")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseFileSearchCallWsSearching: ResponseFileSearchCallWsSearching
            ) = apply {
                itemId = responseFileSearchCallWsSearching.itemId
                outputIndex = responseFileSearchCallWsSearching.outputIndex
                sequenceNumber = responseFileSearchCallWsSearching.sequenceNumber
                type = responseFileSearchCallWsSearching.type
                streamId = responseFileSearchCallWsSearching.streamId
                additionalProperties =
                    responseFileSearchCallWsSearching.additionalProperties.toMutableMap()
            }

            /** The ID of the output item that the file search call is initiated. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the file search call is searching. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.file_search_call.searching")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseFileSearchCallWsSearching].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseFileSearchCallWsSearching =
                ResponseFileSearchCallWsSearching(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseFileSearchCallWsSearching = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.file_search_call.searching")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.file_search_call.searching")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFileSearchCallWsSearching &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseFileSearchCallWsSearching{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when there is a partial function-call arguments delta. */
    class ResponseFunctionCallArgumentsWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseFunctionCallArgumentsDeltaEvent(): ResponseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The function-call arguments delta that is added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The ID of the output item that the function-call arguments delta is added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the function-call arguments delta is added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.function_call_arguments.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.function_call_arguments.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseFunctionCallArgumentsWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseFunctionCallArgumentsWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.function_call_arguments.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseFunctionCallArgumentsWsDelta: ResponseFunctionCallArgumentsWsDelta
            ) = apply {
                delta = responseFunctionCallArgumentsWsDelta.delta
                itemId = responseFunctionCallArgumentsWsDelta.itemId
                outputIndex = responseFunctionCallArgumentsWsDelta.outputIndex
                sequenceNumber = responseFunctionCallArgumentsWsDelta.sequenceNumber
                type = responseFunctionCallArgumentsWsDelta.type
                streamId = responseFunctionCallArgumentsWsDelta.streamId
                additionalProperties =
                    responseFunctionCallArgumentsWsDelta.additionalProperties.toMutableMap()
            }

            /** The function-call arguments delta that is added. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The ID of the output item that the function-call arguments delta is added to. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the function-call arguments delta is added to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.function_call_arguments.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseFunctionCallArgumentsWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseFunctionCallArgumentsWsDelta =
                ResponseFunctionCallArgumentsWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseFunctionCallArgumentsWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.function_call_arguments.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.function_call_arguments.delta")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFunctionCallArgumentsWsDelta &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseFunctionCallArgumentsWsDelta{delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when function-call arguments are finalized. */
    class ResponseFunctionCallArgumentsWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val arguments: JsonField<String>,
        private val itemId: JsonField<String>,
        private val name: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            arguments,
            itemId,
            name,
            outputIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseFunctionCallArgumentsDoneEvent(): ResponseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments(arguments)
                .itemId(itemId)
                .name(name)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The function-call arguments.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The ID of the item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The name of the function that was called.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The index of the output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.function_call_arguments.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseFunctionCallArgumentsWsDone].
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .itemId()
             * .name()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseFunctionCallArgumentsWsDone]. */
        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.function_call_arguments.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseFunctionCallArgumentsWsDone: ResponseFunctionCallArgumentsWsDone
            ) = apply {
                arguments = responseFunctionCallArgumentsWsDone.arguments
                itemId = responseFunctionCallArgumentsWsDone.itemId
                name = responseFunctionCallArgumentsWsDone.name
                outputIndex = responseFunctionCallArgumentsWsDone.outputIndex
                sequenceNumber = responseFunctionCallArgumentsWsDone.sequenceNumber
                type = responseFunctionCallArgumentsWsDone.type
                streamId = responseFunctionCallArgumentsWsDone.streamId
                additionalProperties =
                    responseFunctionCallArgumentsWsDone.additionalProperties.toMutableMap()
            }

            /** The function-call arguments. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The ID of the item. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The name of the function that was called. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The index of the output item. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.function_call_arguments.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseFunctionCallArgumentsWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .itemId()
             * .name()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseFunctionCallArgumentsWsDone =
                ResponseFunctionCallArgumentsWsDone(
                    checkRequired("arguments", arguments),
                    checkRequired("itemId", itemId),
                    checkRequired("name", name),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseFunctionCallArgumentsWsDone = apply {
            if (validated) {
                return@apply
            }

            arguments()
            itemId()
            name()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.function_call_arguments.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.function_call_arguments.done")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFunctionCallArgumentsWsDone &&
                arguments == other.arguments &&
                itemId == other.itemId &&
                name == other.name &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                arguments,
                itemId,
                name,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseFunctionCallArgumentsWsDone{arguments=$arguments, itemId=$itemId, name=$name, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the response is in progress. */
    class ResponseInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseInProgressEvent(): ResponseInProgressEvent =
            ResponseInProgressEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The response that is in progress.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.in_progress`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseInWsProgress]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseInWsProgress: ResponseInWsProgress) = apply {
                response = responseInWsProgress.response
                sequenceNumber = responseInWsProgress.sequenceNumber
                type = responseInWsProgress.type
                streamId = responseInWsProgress.streamId
                additionalProperties = responseInWsProgress.additionalProperties.toMutableMap()
            }

            /** The response that is in progress. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseInWsProgress =
                ResponseInWsProgress(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseInWsProgress = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.in_progress")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseInWsProgress &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseInWsProgress{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** An event that is emitted when a response fails. */
    class ResponseWsFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseFailedEvent(): ResponseFailedEvent =
            ResponseFailedEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The response that failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.failed`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseWsFailed].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsFailed]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.failed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsFailed: ResponseWsFailed) = apply {
                response = responseWsFailed.response
                sequenceNumber = responseWsFailed.sequenceNumber
                type = responseWsFailed.type
                streamId = responseWsFailed.streamId
                additionalProperties = responseWsFailed.additionalProperties.toMutableMap()
            }

            /** The response that failed. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWsFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsFailed =
                ResponseWsFailed(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWsFailed = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.failed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.failed")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsFailed &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsFailed{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** An event that is emitted when a response finishes as incomplete. */
    class ResponseWsIncomplete
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseIncompleteEvent(): ResponseIncompleteEvent =
            ResponseIncompleteEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The response that was incomplete.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.incomplete`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.incomplete")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseWsIncomplete].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsIncomplete]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.incomplete")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsIncomplete: ResponseWsIncomplete) = apply {
                response = responseWsIncomplete.response
                sequenceNumber = responseWsIncomplete.sequenceNumber
                type = responseWsIncomplete.type
                streamId = responseWsIncomplete.streamId
                additionalProperties = responseWsIncomplete.additionalProperties.toMutableMap()
            }

            /** The response that was incomplete. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.incomplete")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWsIncomplete].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsIncomplete =
                ResponseWsIncomplete(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWsIncomplete = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.incomplete")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.incomplete")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsIncomplete &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsIncomplete{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a new output item is added. */
    class ResponseOutputItemWsAdded
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val item: JsonField<ResponseOutputItem>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item")
            @ExcludeMissing
            item: JsonField<ResponseOutputItem> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(item, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseOutputItemAddedEvent(): ResponseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
                .item(item)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The output item that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun item(): ResponseOutputItem = item.getRequired("item")

        /**
         * The index of the output item that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.output_item.added`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.output_item.added")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [item].
         *
         * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ResponseOutputItem> = item

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseOutputItemWsAdded].
             *
             * The following fields are required:
             * ```java
             * .item()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseOutputItemWsAdded]. */
        class Builder internal constructor() {

            private var item: JsonField<ResponseOutputItem>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.output_item.added")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseOutputItemWsAdded: ResponseOutputItemWsAdded) = apply {
                item = responseOutputItemWsAdded.item
                outputIndex = responseOutputItemWsAdded.outputIndex
                sequenceNumber = responseOutputItemWsAdded.sequenceNumber
                type = responseOutputItemWsAdded.type
                streamId = responseOutputItemWsAdded.streamId
                additionalProperties = responseOutputItemWsAdded.additionalProperties.toMutableMap()
            }

            /** The output item that was added. */
            fun item(item: ResponseOutputItem) = item(JsonField.of(item))

            /**
             * Sets [Builder.item] to an arbitrary JSON value.
             *
             * You should usually call [Builder.item] with a well-typed [ResponseOutputItem] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun item(item: JsonField<ResponseOutputItem>) = apply { this.item = item }

            /** Alias for calling [item] with `ResponseOutputItem.ofMessage(message)`. */
            fun item(message: ResponseOutputMessage) = item(ResponseOutputItem.ofMessage(message))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
             */
            fun item(fileSearchCall: ResponseFileSearchToolCall) =
                item(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofFunctionCall(functionCall)`. */
            fun item(functionCall: ResponseFunctionToolCall) =
                item(ResponseOutputItem.ofFunctionCall(functionCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofFunctionCallOutput(functionCallOutput)`.
             */
            fun item(functionCallOutput: ResponseFunctionToolCallOutputItem) =
                item(ResponseOutputItem.ofFunctionCallOutput(functionCallOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`.
             */
            fun item(webSearchCall: ResponseFunctionWebSearch) =
                item(ResponseOutputItem.ofWebSearchCall(webSearchCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
            fun item(computerCall: ResponseComputerToolCall) =
                item(ResponseOutputItem.ofComputerCall(computerCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofComputerCallOutput(computerCallOutput)`.
             */
            fun item(computerCallOutput: ResponseComputerToolCallOutputItem) =
                item(ResponseOutputItem.ofComputerCallOutput(computerCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofReasoning(reasoning)`. */
            fun item(reasoning: ResponseReasoningItem) =
                item(ResponseOutputItem.ofReasoning(reasoning))

            /** Alias for calling [item] with `ResponseOutputItem.ofProgram(program)`. */
            fun item(program: ResponseOutputItem.Program) =
                item(ResponseOutputItem.ofProgram(program))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofProgramOutput(programOutput)`.
             */
            fun item(programOutput: ResponseOutputItem.ProgramOutput) =
                item(ResponseOutputItem.ofProgramOutput(programOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofToolSearchCall(toolSearchCall)`.
             */
            fun item(toolSearchCall: ResponseToolSearchCall) =
                item(ResponseOutputItem.ofToolSearchCall(toolSearchCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofToolSearchOutput(toolSearchOutput)`.
             */
            fun item(toolSearchOutput: ResponseToolSearchOutputItem) =
                item(ResponseOutputItem.ofToolSearchOutput(toolSearchOutput))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofAdditionalTools(additionalTools)`.
             */
            fun item(additionalTools: ResponseOutputItem.AdditionalTools) =
                item(ResponseOutputItem.ofAdditionalTools(additionalTools))

            /** Alias for calling [item] with `ResponseOutputItem.ofCompaction(compaction)`. */
            fun item(compaction: ResponseCompactionItem) =
                item(ResponseOutputItem.ofCompaction(compaction))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
             */
            fun item(imageGenerationCall: ResponseOutputItem.ImageGenerationCall) =
                item(ResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
             */
            fun item(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
                item(ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofLocalShellCall(localShellCall)`.
             */
            fun item(localShellCall: ResponseOutputItem.LocalShellCall) =
                item(ResponseOutputItem.ofLocalShellCall(localShellCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)`.
             */
            fun item(localShellCallOutput: ResponseOutputItem.LocalShellCallOutput) =
                item(ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofShellCall(shellCall)`. */
            fun item(shellCall: ResponseFunctionShellToolCall) =
                item(ResponseOutputItem.ofShellCall(shellCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofShellCallOutput(shellCallOutput)`.
             */
            fun item(shellCallOutput: ResponseFunctionShellToolCallOutput) =
                item(ResponseOutputItem.ofShellCallOutput(shellCallOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofApplyPatchCall(applyPatchCall)`.
             */
            fun item(applyPatchCall: ResponseApplyPatchToolCall) =
                item(ResponseOutputItem.ofApplyPatchCall(applyPatchCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
             */
            fun item(applyPatchCallOutput: ResponseApplyPatchToolCallOutput) =
                item(ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofMcpCall(mcpCall)`. */
            fun item(mcpCall: ResponseOutputItem.McpCall) =
                item(ResponseOutputItem.ofMcpCall(mcpCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofMcpListTools(mcpListTools)`. */
            fun item(mcpListTools: ResponseOutputItem.McpListTools) =
                item(ResponseOutputItem.ofMcpListTools(mcpListTools))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
             */
            fun item(mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest) =
                item(ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
             */
            fun item(mcpApprovalResponse: ResponseOutputItem.McpApprovalResponse) =
                item(ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofCustomToolCall(customToolCall)`.
             */
            fun item(customToolCall: ResponseCustomToolCall) =
                item(ResponseOutputItem.ofCustomToolCall(customToolCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)`.
             */
            fun item(customToolCallOutput: ResponseCustomToolCallOutputItem) =
                item(ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput))

            /** The index of the output item that was added. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.output_item.added")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseOutputItemWsAdded].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .item()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseOutputItemWsAdded =
                ResponseOutputItemWsAdded(
                    checkRequired("item", item),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseOutputItemWsAdded = apply {
            if (validated) {
                return@apply
            }

            item().validate()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.output_item.added")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (item.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.output_item.added")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseOutputItemWsAdded &&
                item == other.item &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(item, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseOutputItemWsAdded{item=$item, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an output item is marked done. */
    class ResponseOutputItemWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val item: JsonField<ResponseOutputItem>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item")
            @ExcludeMissing
            item: JsonField<ResponseOutputItem> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(item, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseOutputItemDoneEvent(): ResponseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent.builder()
                .item(item)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The output item that was marked done.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun item(): ResponseOutputItem = item.getRequired("item")

        /**
         * The index of the output item that was marked done.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.output_item.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.output_item.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [item].
         *
         * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ResponseOutputItem> = item

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of [ResponseOutputItemWsDone].
             *
             * The following fields are required:
             * ```java
             * .item()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseOutputItemWsDone]. */
        class Builder internal constructor() {

            private var item: JsonField<ResponseOutputItem>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.output_item.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseOutputItemWsDone: ResponseOutputItemWsDone) = apply {
                item = responseOutputItemWsDone.item
                outputIndex = responseOutputItemWsDone.outputIndex
                sequenceNumber = responseOutputItemWsDone.sequenceNumber
                type = responseOutputItemWsDone.type
                streamId = responseOutputItemWsDone.streamId
                additionalProperties = responseOutputItemWsDone.additionalProperties.toMutableMap()
            }

            /** The output item that was marked done. */
            fun item(item: ResponseOutputItem) = item(JsonField.of(item))

            /**
             * Sets [Builder.item] to an arbitrary JSON value.
             *
             * You should usually call [Builder.item] with a well-typed [ResponseOutputItem] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun item(item: JsonField<ResponseOutputItem>) = apply { this.item = item }

            /** Alias for calling [item] with `ResponseOutputItem.ofMessage(message)`. */
            fun item(message: ResponseOutputMessage) = item(ResponseOutputItem.ofMessage(message))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
             */
            fun item(fileSearchCall: ResponseFileSearchToolCall) =
                item(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofFunctionCall(functionCall)`. */
            fun item(functionCall: ResponseFunctionToolCall) =
                item(ResponseOutputItem.ofFunctionCall(functionCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofFunctionCallOutput(functionCallOutput)`.
             */
            fun item(functionCallOutput: ResponseFunctionToolCallOutputItem) =
                item(ResponseOutputItem.ofFunctionCallOutput(functionCallOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`.
             */
            fun item(webSearchCall: ResponseFunctionWebSearch) =
                item(ResponseOutputItem.ofWebSearchCall(webSearchCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
            fun item(computerCall: ResponseComputerToolCall) =
                item(ResponseOutputItem.ofComputerCall(computerCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofComputerCallOutput(computerCallOutput)`.
             */
            fun item(computerCallOutput: ResponseComputerToolCallOutputItem) =
                item(ResponseOutputItem.ofComputerCallOutput(computerCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofReasoning(reasoning)`. */
            fun item(reasoning: ResponseReasoningItem) =
                item(ResponseOutputItem.ofReasoning(reasoning))

            /** Alias for calling [item] with `ResponseOutputItem.ofProgram(program)`. */
            fun item(program: ResponseOutputItem.Program) =
                item(ResponseOutputItem.ofProgram(program))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofProgramOutput(programOutput)`.
             */
            fun item(programOutput: ResponseOutputItem.ProgramOutput) =
                item(ResponseOutputItem.ofProgramOutput(programOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofToolSearchCall(toolSearchCall)`.
             */
            fun item(toolSearchCall: ResponseToolSearchCall) =
                item(ResponseOutputItem.ofToolSearchCall(toolSearchCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofToolSearchOutput(toolSearchOutput)`.
             */
            fun item(toolSearchOutput: ResponseToolSearchOutputItem) =
                item(ResponseOutputItem.ofToolSearchOutput(toolSearchOutput))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofAdditionalTools(additionalTools)`.
             */
            fun item(additionalTools: ResponseOutputItem.AdditionalTools) =
                item(ResponseOutputItem.ofAdditionalTools(additionalTools))

            /** Alias for calling [item] with `ResponseOutputItem.ofCompaction(compaction)`. */
            fun item(compaction: ResponseCompactionItem) =
                item(ResponseOutputItem.ofCompaction(compaction))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
             */
            fun item(imageGenerationCall: ResponseOutputItem.ImageGenerationCall) =
                item(ResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
             */
            fun item(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
                item(ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofLocalShellCall(localShellCall)`.
             */
            fun item(localShellCall: ResponseOutputItem.LocalShellCall) =
                item(ResponseOutputItem.ofLocalShellCall(localShellCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)`.
             */
            fun item(localShellCallOutput: ResponseOutputItem.LocalShellCallOutput) =
                item(ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofShellCall(shellCall)`. */
            fun item(shellCall: ResponseFunctionShellToolCall) =
                item(ResponseOutputItem.ofShellCall(shellCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofShellCallOutput(shellCallOutput)`.
             */
            fun item(shellCallOutput: ResponseFunctionShellToolCallOutput) =
                item(ResponseOutputItem.ofShellCallOutput(shellCallOutput))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofApplyPatchCall(applyPatchCall)`.
             */
            fun item(applyPatchCall: ResponseApplyPatchToolCall) =
                item(ResponseOutputItem.ofApplyPatchCall(applyPatchCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
             */
            fun item(applyPatchCallOutput: ResponseApplyPatchToolCallOutput) =
                item(ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

            /** Alias for calling [item] with `ResponseOutputItem.ofMcpCall(mcpCall)`. */
            fun item(mcpCall: ResponseOutputItem.McpCall) =
                item(ResponseOutputItem.ofMcpCall(mcpCall))

            /** Alias for calling [item] with `ResponseOutputItem.ofMcpListTools(mcpListTools)`. */
            fun item(mcpListTools: ResponseOutputItem.McpListTools) =
                item(ResponseOutputItem.ofMcpListTools(mcpListTools))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
             */
            fun item(mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest) =
                item(ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
             */
            fun item(mcpApprovalResponse: ResponseOutputItem.McpApprovalResponse) =
                item(ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse))

            /**
             * Alias for calling [item] with `ResponseOutputItem.ofCustomToolCall(customToolCall)`.
             */
            fun item(customToolCall: ResponseCustomToolCall) =
                item(ResponseOutputItem.ofCustomToolCall(customToolCall))

            /**
             * Alias for calling [item] with
             * `ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)`.
             */
            fun item(customToolCallOutput: ResponseCustomToolCallOutputItem) =
                item(ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput))

            /** The index of the output item that was marked done. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.output_item.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseOutputItemWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .item()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseOutputItemWsDone =
                ResponseOutputItemWsDone(
                    checkRequired("item", item),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseOutputItemWsDone = apply {
            if (validated) {
                return@apply
            }

            item().validate()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.output_item.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (item.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.output_item.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseOutputItemWsDone &&
                item == other.item &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(item, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseOutputItemWsDone{item=$item, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a new reasoning summary part is added. */
    class ResponseReasoningSummaryPartWsAdded
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val part: JsonField<ResponseReasoningSummaryPartAddedEvent.Part>,
        private val sequenceNumber: JsonField<Long>,
        private val summaryIndex: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("part")
            @ExcludeMissing
            part: JsonField<ResponseReasoningSummaryPartAddedEvent.Part> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("summary_index")
            @ExcludeMissing
            summaryIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            summaryIndex,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningSummaryPartAddedEvent(): ResponseReasoningSummaryPartAddedEvent =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .part(part)
                .sequenceNumber(sequenceNumber)
                .summaryIndex(summaryIndex)
                .type(type)
                .build()

        /**
         * The ID of the item this summary part is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this summary part is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The summary part that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun part(): ResponseReasoningSummaryPartAddedEvent.Part = part.getRequired("part")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The index of the summary part within the reasoning summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun summaryIndex(): Long = summaryIndex.getRequired("summary_index")

        /**
         * The type of the event. Always `response.reasoning_summary_part.added`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_summary_part.added")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [part].
         *
         * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("part")
        @ExcludeMissing
        fun _part(): JsonField<ResponseReasoningSummaryPartAddedEvent.Part> = part

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
         * Returns the raw JSON value of [summaryIndex].
         *
         * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("summary_index")
        @ExcludeMissing
        fun _summaryIndex(): JsonField<Long> = summaryIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningSummaryPartWsAdded].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningSummaryPartWsAdded]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var part: JsonField<ResponseReasoningSummaryPartAddedEvent.Part>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var summaryIndex: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_summary_part.added")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseReasoningSummaryPartWsAdded: ResponseReasoningSummaryPartWsAdded
            ) = apply {
                itemId = responseReasoningSummaryPartWsAdded.itemId
                outputIndex = responseReasoningSummaryPartWsAdded.outputIndex
                part = responseReasoningSummaryPartWsAdded.part
                sequenceNumber = responseReasoningSummaryPartWsAdded.sequenceNumber
                summaryIndex = responseReasoningSummaryPartWsAdded.summaryIndex
                type = responseReasoningSummaryPartWsAdded.type
                streamId = responseReasoningSummaryPartWsAdded.streamId
                additionalProperties =
                    responseReasoningSummaryPartWsAdded.additionalProperties.toMutableMap()
            }

            /** The ID of the item this summary part is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this summary part is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The summary part that was added. */
            fun part(part: ResponseReasoningSummaryPartAddedEvent.Part) = part(JsonField.of(part))

            /**
             * Sets [Builder.part] to an arbitrary JSON value.
             *
             * You should usually call [Builder.part] with a well-typed
             * [ResponseReasoningSummaryPartAddedEvent.Part] value instead. This method is primarily
             * for setting the field to an undocumented or not yet supported value.
             */
            fun part(part: JsonField<ResponseReasoningSummaryPartAddedEvent.Part>) = apply {
                this.part = part
            }

            /** The sequence number of this event. */
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

            /** The index of the summary part within the reasoning summary. */
            fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

            /**
             * Sets [Builder.summaryIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summaryIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summaryIndex(summaryIndex: JsonField<Long>) = apply {
                this.summaryIndex = summaryIndex
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_summary_part.added")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseReasoningSummaryPartWsAdded].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningSummaryPartWsAdded =
                ResponseReasoningSummaryPartWsAdded(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("part", part),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("summaryIndex", summaryIndex),
                    type,
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
        fun validate(): ResponseReasoningSummaryPartWsAdded = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            part().validate()
            sequenceNumber()
            summaryIndex()
            _type().let {
                if (it != JsonValue.from("response.reasoning_summary_part.added")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (part.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (summaryIndex.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.reasoning_summary_part.added")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningSummaryPartWsAdded &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                part == other.part &&
                sequenceNumber == other.sequenceNumber &&
                summaryIndex == other.summaryIndex &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                itemId,
                outputIndex,
                part,
                sequenceNumber,
                summaryIndex,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningSummaryPartWsAdded{itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a reasoning summary part is completed. */
    class ResponseReasoningSummaryPartWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val part: JsonField<ResponseReasoningSummaryPartDoneEvent.Part>,
        private val sequenceNumber: JsonField<Long>,
        private val summaryIndex: JsonField<Long>,
        private val type: JsonValue,
        private val status: JsonField<ResponseReasoningSummaryPartDoneEvent.Status>,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("part")
            @ExcludeMissing
            part: JsonField<ResponseReasoningSummaryPartDoneEvent.Part> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("summary_index")
            @ExcludeMissing
            summaryIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            status: JsonField<ResponseReasoningSummaryPartDoneEvent.Status> = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            summaryIndex,
            type,
            status,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningSummaryPartDoneEvent(): ResponseReasoningSummaryPartDoneEvent =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .part(part)
                .sequenceNumber(sequenceNumber)
                .summaryIndex(summaryIndex)
                .type(type)
                .status(status)
                .build()

        /**
         * The ID of the item this summary part is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this summary part is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The completed summary part.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun part(): ResponseReasoningSummaryPartDoneEvent.Part = part.getRequired("part")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The index of the summary part within the reasoning summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun summaryIndex(): Long = summaryIndex.getRequired("summary_index")

        /**
         * The type of the event. Always `response.reasoning_summary_part.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_summary_part.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The completion status of the summary part. Omitted when the part completed normally and
         * set to `incomplete` when generation was interrupted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<ResponseReasoningSummaryPartDoneEvent.Status> =
            status.getOptional("status")

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [part].
         *
         * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("part")
        @ExcludeMissing
        fun _part(): JsonField<ResponseReasoningSummaryPartDoneEvent.Part> = part

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
         * Returns the raw JSON value of [summaryIndex].
         *
         * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("summary_index")
        @ExcludeMissing
        fun _summaryIndex(): JsonField<Long> = summaryIndex

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun _status(): JsonField<ResponseReasoningSummaryPartDoneEvent.Status> = status

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningSummaryPartWsDone].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningSummaryPartWsDone]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var part: JsonField<ResponseReasoningSummaryPartDoneEvent.Part>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var summaryIndex: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_summary_part.done")
            private var status: JsonField<ResponseReasoningSummaryPartDoneEvent.Status> =
                JsonMissing.of()
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseReasoningSummaryPartWsDone: ResponseReasoningSummaryPartWsDone
            ) = apply {
                itemId = responseReasoningSummaryPartWsDone.itemId
                outputIndex = responseReasoningSummaryPartWsDone.outputIndex
                part = responseReasoningSummaryPartWsDone.part
                sequenceNumber = responseReasoningSummaryPartWsDone.sequenceNumber
                summaryIndex = responseReasoningSummaryPartWsDone.summaryIndex
                type = responseReasoningSummaryPartWsDone.type
                status = responseReasoningSummaryPartWsDone.status
                streamId = responseReasoningSummaryPartWsDone.streamId
                additionalProperties =
                    responseReasoningSummaryPartWsDone.additionalProperties.toMutableMap()
            }

            /** The ID of the item this summary part is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this summary part is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The completed summary part. */
            fun part(part: ResponseReasoningSummaryPartDoneEvent.Part) = part(JsonField.of(part))

            /**
             * Sets [Builder.part] to an arbitrary JSON value.
             *
             * You should usually call [Builder.part] with a well-typed
             * [ResponseReasoningSummaryPartDoneEvent.Part] value instead. This method is primarily
             * for setting the field to an undocumented or not yet supported value.
             */
            fun part(part: JsonField<ResponseReasoningSummaryPartDoneEvent.Part>) = apply {
                this.part = part
            }

            /** The sequence number of this event. */
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

            /** The index of the summary part within the reasoning summary. */
            fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

            /**
             * Sets [Builder.summaryIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summaryIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summaryIndex(summaryIndex: JsonField<Long>) = apply {
                this.summaryIndex = summaryIndex
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_summary_part.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The completion status of the summary part. Omitted when the part completed normally
             * and set to `incomplete` when generation was interrupted.
             */
            fun status(status: ResponseReasoningSummaryPartDoneEvent.Status) =
                status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed
             * [ResponseReasoningSummaryPartDoneEvent.Status] value instead. This method is
             * primarily for setting the field to an undocumented or not yet supported value.
             */
            fun status(status: JsonField<ResponseReasoningSummaryPartDoneEvent.Status>) = apply {
                this.status = status
            }

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
             * Returns an immutable instance of [ResponseReasoningSummaryPartWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .part()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningSummaryPartWsDone =
                ResponseReasoningSummaryPartWsDone(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("part", part),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("summaryIndex", summaryIndex),
                    type,
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
        fun validate(): ResponseReasoningSummaryPartWsDone = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            part().validate()
            sequenceNumber()
            summaryIndex()
            _type().let {
                if (it != JsonValue.from("response.reasoning_summary_part.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            status().ifPresent { it.validate() }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (part.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (summaryIndex.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.reasoning_summary_part.done")) 1 else 0
                } +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningSummaryPartWsDone &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                part == other.part &&
                sequenceNumber == other.sequenceNumber &&
                summaryIndex == other.summaryIndex &&
                type == other.type &&
                status == other.status &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                itemId,
                outputIndex,
                part,
                sequenceNumber,
                summaryIndex,
                type,
                status,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningSummaryPartWsDone{itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, type=$type, status=$status, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a delta is added to a reasoning summary text. */
    class ResponseReasoningSummaryTextWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val summaryIndex: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("summary_index")
            @ExcludeMissing
            summaryIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            delta,
            itemId,
            outputIndex,
            sequenceNumber,
            summaryIndex,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningSummaryTextDeltaEvent(): ResponseReasoningSummaryTextDeltaEvent =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .summaryIndex(summaryIndex)
                .type(type)
                .build()

        /**
         * The text delta that was added to the summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The ID of the item this summary text delta is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this summary text delta is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The index of the summary part within the reasoning summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun summaryIndex(): Long = summaryIndex.getRequired("summary_index")

        /**
         * The type of the event. Always `response.reasoning_summary_text.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_summary_text.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
         * Returns the raw JSON value of [summaryIndex].
         *
         * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("summary_index")
        @ExcludeMissing
        fun _summaryIndex(): JsonField<Long> = summaryIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningSummaryTextWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningSummaryTextWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var summaryIndex: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_summary_text.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseReasoningSummaryTextWsDelta: ResponseReasoningSummaryTextWsDelta
            ) = apply {
                delta = responseReasoningSummaryTextWsDelta.delta
                itemId = responseReasoningSummaryTextWsDelta.itemId
                outputIndex = responseReasoningSummaryTextWsDelta.outputIndex
                sequenceNumber = responseReasoningSummaryTextWsDelta.sequenceNumber
                summaryIndex = responseReasoningSummaryTextWsDelta.summaryIndex
                type = responseReasoningSummaryTextWsDelta.type
                streamId = responseReasoningSummaryTextWsDelta.streamId
                additionalProperties =
                    responseReasoningSummaryTextWsDelta.additionalProperties.toMutableMap()
            }

            /** The text delta that was added to the summary. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The ID of the item this summary text delta is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this summary text delta is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /** The index of the summary part within the reasoning summary. */
            fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

            /**
             * Sets [Builder.summaryIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summaryIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summaryIndex(summaryIndex: JsonField<Long>) = apply {
                this.summaryIndex = summaryIndex
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_summary_text.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseReasoningSummaryTextWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .summaryIndex()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningSummaryTextWsDelta =
                ResponseReasoningSummaryTextWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("summaryIndex", summaryIndex),
                    type,
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
        fun validate(): ResponseReasoningSummaryTextWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            summaryIndex()
            _type().let {
                if (it != JsonValue.from("response.reasoning_summary_text.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (summaryIndex.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.reasoning_summary_text.delta")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningSummaryTextWsDelta &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                summaryIndex == other.summaryIndex &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                summaryIndex,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningSummaryTextWsDelta{delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a reasoning summary text is completed. */
    class ResponseReasoningSummaryTextWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val summaryIndex: JsonField<Long>,
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("summary_index")
            @ExcludeMissing
            summaryIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            itemId,
            outputIndex,
            sequenceNumber,
            summaryIndex,
            text,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningSummaryTextDoneEvent(): ResponseReasoningSummaryTextDoneEvent =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .summaryIndex(summaryIndex)
                .text(text)
                .type(type)
                .build()

        /**
         * The ID of the item this summary text is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this summary text is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The index of the summary part within the reasoning summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun summaryIndex(): Long = summaryIndex.getRequired("summary_index")

        /**
         * The full text of the completed reasoning summary.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the event. Always `response.reasoning_summary_text.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_summary_text.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
         * Returns the raw JSON value of [summaryIndex].
         *
         * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("summary_index")
        @ExcludeMissing
        fun _summaryIndex(): JsonField<Long> = summaryIndex

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningSummaryTextWsDone].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .summaryIndex()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningSummaryTextWsDone]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var summaryIndex: JsonField<Long>? = null
            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_summary_text.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseReasoningSummaryTextWsDone: ResponseReasoningSummaryTextWsDone
            ) = apply {
                itemId = responseReasoningSummaryTextWsDone.itemId
                outputIndex = responseReasoningSummaryTextWsDone.outputIndex
                sequenceNumber = responseReasoningSummaryTextWsDone.sequenceNumber
                summaryIndex = responseReasoningSummaryTextWsDone.summaryIndex
                text = responseReasoningSummaryTextWsDone.text
                type = responseReasoningSummaryTextWsDone.type
                streamId = responseReasoningSummaryTextWsDone.streamId
                additionalProperties =
                    responseReasoningSummaryTextWsDone.additionalProperties.toMutableMap()
            }

            /** The ID of the item this summary text is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this summary text is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /** The index of the summary part within the reasoning summary. */
            fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

            /**
             * Sets [Builder.summaryIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summaryIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summaryIndex(summaryIndex: JsonField<Long>) = apply {
                this.summaryIndex = summaryIndex
            }

            /** The full text of the completed reasoning summary. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_summary_text.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseReasoningSummaryTextWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .summaryIndex()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningSummaryTextWsDone =
                ResponseReasoningSummaryTextWsDone(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("summaryIndex", summaryIndex),
                    checkRequired("text", text),
                    type,
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
        fun validate(): ResponseReasoningSummaryTextWsDone = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            summaryIndex()
            text()
            _type().let {
                if (it != JsonValue.from("response.reasoning_summary_text.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (summaryIndex.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.reasoning_summary_text.done")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningSummaryTextWsDone &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                summaryIndex == other.summaryIndex &&
                text == other.text &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                itemId,
                outputIndex,
                sequenceNumber,
                summaryIndex,
                text,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningSummaryTextWsDone{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, text=$text, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a delta is added to a reasoning text. */
    class ResponseReasoningTextWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            delta,
            itemId,
            outputIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningTextDeltaEvent(): ResponseReasoningTextDeltaEvent =
            ResponseReasoningTextDeltaEvent.builder()
                .contentIndex(contentIndex)
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the reasoning content part this delta is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The text delta that was added to the reasoning content.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The ID of the item this reasoning text delta is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this reasoning text delta is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.reasoning_text.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_text.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningTextWsDelta].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningTextWsDelta]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_text.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseReasoningTextWsDelta: ResponseReasoningTextWsDelta) = apply {
                contentIndex = responseReasoningTextWsDelta.contentIndex
                delta = responseReasoningTextWsDelta.delta
                itemId = responseReasoningTextWsDelta.itemId
                outputIndex = responseReasoningTextWsDelta.outputIndex
                sequenceNumber = responseReasoningTextWsDelta.sequenceNumber
                type = responseReasoningTextWsDelta.type
                streamId = responseReasoningTextWsDelta.streamId
                additionalProperties =
                    responseReasoningTextWsDelta.additionalProperties.toMutableMap()
            }

            /** The index of the reasoning content part this delta is associated with. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The text delta that was added to the reasoning content. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The ID of the item this reasoning text delta is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this reasoning text delta is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_text.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseReasoningTextWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningTextWsDelta =
                ResponseReasoningTextWsDelta(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseReasoningTextWsDelta = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.reasoning_text.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.reasoning_text.delta")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningTextWsDelta &&
                contentIndex == other.contentIndex &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningTextWsDelta{contentIndex=$contentIndex, delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a reasoning text is completed. */
    class ResponseReasoningTextWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            itemId,
            outputIndex,
            sequenceNumber,
            text,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseReasoningTextDoneEvent(): ResponseReasoningTextDoneEvent =
            ResponseReasoningTextDoneEvent.builder()
                .contentIndex(contentIndex)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .text(text)
                .type(type)
                .build()

        /**
         * The index of the reasoning content part.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The ID of the item this reasoning text is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item this reasoning text is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The full text of the completed reasoning content.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the event. Always `response.reasoning_text.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.reasoning_text.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseReasoningTextWsDone].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseReasoningTextWsDone]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("response.reasoning_text.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseReasoningTextWsDone: ResponseReasoningTextWsDone) = apply {
                contentIndex = responseReasoningTextWsDone.contentIndex
                itemId = responseReasoningTextWsDone.itemId
                outputIndex = responseReasoningTextWsDone.outputIndex
                sequenceNumber = responseReasoningTextWsDone.sequenceNumber
                text = responseReasoningTextWsDone.text
                type = responseReasoningTextWsDone.type
                streamId = responseReasoningTextWsDone.streamId
                additionalProperties =
                    responseReasoningTextWsDone.additionalProperties.toMutableMap()
            }

            /** The index of the reasoning content part. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The ID of the item this reasoning text is associated with. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item this reasoning text is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /** The full text of the completed reasoning content. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.reasoning_text.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseReasoningTextWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseReasoningTextWsDone =
                ResponseReasoningTextWsDone(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("text", text),
                    type,
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
        fun validate(): ResponseReasoningTextWsDone = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            itemId()
            outputIndex()
            sequenceNumber()
            text()
            _type().let {
                if (it != JsonValue.from("response.reasoning_text.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.reasoning_text.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseReasoningTextWsDone &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                text == other.text &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                itemId,
                outputIndex,
                sequenceNumber,
                text,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseReasoningTextWsDone{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, text=$text, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when there is a partial refusal text. */
    class ResponseRefusalWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            delta,
            itemId,
            outputIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseRefusalDeltaEvent(): ResponseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(contentIndex)
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the content part that the refusal text is added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The refusal text that is added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The ID of the output item that the refusal text is added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the refusal text is added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.refusal.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.refusal.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of [ResponseRefusalWsDelta].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseRefusalWsDelta]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.refusal.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseRefusalWsDelta: ResponseRefusalWsDelta) = apply {
                contentIndex = responseRefusalWsDelta.contentIndex
                delta = responseRefusalWsDelta.delta
                itemId = responseRefusalWsDelta.itemId
                outputIndex = responseRefusalWsDelta.outputIndex
                sequenceNumber = responseRefusalWsDelta.sequenceNumber
                type = responseRefusalWsDelta.type
                streamId = responseRefusalWsDelta.streamId
                additionalProperties = responseRefusalWsDelta.additionalProperties.toMutableMap()
            }

            /** The index of the content part that the refusal text is added to. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The refusal text that is added. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The ID of the output item that the refusal text is added to. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the refusal text is added to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.refusal.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseRefusalWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseRefusalWsDelta =
                ResponseRefusalWsDelta(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseRefusalWsDelta = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.refusal.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.refusal.delta")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseRefusalWsDelta &&
                contentIndex == other.contentIndex &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseRefusalWsDelta{contentIndex=$contentIndex, delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when refusal text is finalized. */
    class ResponseRefusalWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val refusal: JsonField<String>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("refusal") @ExcludeMissing refusal: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            itemId,
            outputIndex,
            refusal,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseRefusalDoneEvent(): ResponseRefusalDoneEvent =
            ResponseRefusalDoneEvent.builder()
                .contentIndex(contentIndex)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .refusal(refusal)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the content part that the refusal text is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The ID of the output item that the refusal text is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the refusal text is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The refusal text that is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun refusal(): String = refusal.getRequired("refusal")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.refusal.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.refusal.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [refusal].
         *
         * Unlike [refusal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

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
             * Returns a mutable builder for constructing an instance of [ResponseRefusalWsDone].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .refusal()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseRefusalWsDone]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var refusal: JsonField<String>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.refusal.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseRefusalWsDone: ResponseRefusalWsDone) = apply {
                contentIndex = responseRefusalWsDone.contentIndex
                itemId = responseRefusalWsDone.itemId
                outputIndex = responseRefusalWsDone.outputIndex
                refusal = responseRefusalWsDone.refusal
                sequenceNumber = responseRefusalWsDone.sequenceNumber
                type = responseRefusalWsDone.type
                streamId = responseRefusalWsDone.streamId
                additionalProperties = responseRefusalWsDone.additionalProperties.toMutableMap()
            }

            /** The index of the content part that the refusal text is finalized. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The ID of the output item that the refusal text is finalized. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the refusal text is finalized. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The refusal text that is finalized. */
            fun refusal(refusal: String) = refusal(JsonField.of(refusal))

            /**
             * Sets [Builder.refusal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refusal] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.refusal.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseRefusalWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .refusal()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseRefusalWsDone =
                ResponseRefusalWsDone(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("refusal", refusal),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseRefusalWsDone = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            itemId()
            outputIndex()
            refusal()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.refusal.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (refusal.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.refusal.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseRefusalWsDone &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                refusal == other.refusal &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                itemId,
                outputIndex,
                refusal,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseRefusalWsDone{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, refusal=$refusal, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when there is an additional text delta. */
    class ResponseTextWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val logprobs: JsonField<List<ResponseTextDeltaEvent.Logprob>>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logprobs")
            @ExcludeMissing
            logprobs: JsonField<List<ResponseTextDeltaEvent.Logprob>> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            delta,
            itemId,
            logprobs,
            outputIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseTextDeltaEvent(): ResponseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(contentIndex)
                .delta(delta)
                .itemId(itemId)
                .logprobs(logprobs)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The index of the content part that the text delta was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The text delta that was added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The ID of the output item that the text delta was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The log probabilities of the tokens in the delta.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun logprobs(): List<ResponseTextDeltaEvent.Logprob> = logprobs.getRequired("logprobs")

        /**
         * The index of the output item that the text delta was added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number for this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.output_text.delta`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.output_text.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [logprobs].
         *
         * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprobs")
        @ExcludeMissing
        fun _logprobs(): JsonField<List<ResponseTextDeltaEvent.Logprob>> = logprobs

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of [ResponseTextWsDelta].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .logprobs()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseTextWsDelta]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var logprobs: JsonField<MutableList<ResponseTextDeltaEvent.Logprob>>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.output_text.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseTextWsDelta: ResponseTextWsDelta) = apply {
                contentIndex = responseTextWsDelta.contentIndex
                delta = responseTextWsDelta.delta
                itemId = responseTextWsDelta.itemId
                logprobs = responseTextWsDelta.logprobs.map { it.toMutableList() }
                outputIndex = responseTextWsDelta.outputIndex
                sequenceNumber = responseTextWsDelta.sequenceNumber
                type = responseTextWsDelta.type
                streamId = responseTextWsDelta.streamId
                additionalProperties = responseTextWsDelta.additionalProperties.toMutableMap()
            }

            /** The index of the content part that the text delta was added to. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The text delta that was added. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The ID of the output item that the text delta was added to. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The log probabilities of the tokens in the delta. */
            fun logprobs(logprobs: List<ResponseTextDeltaEvent.Logprob>) =
                logprobs(JsonField.of(logprobs))

            /**
             * Sets [Builder.logprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprobs] with a well-typed
             * `List<ResponseTextDeltaEvent.Logprob>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun logprobs(logprobs: JsonField<List<ResponseTextDeltaEvent.Logprob>>) = apply {
                this.logprobs = logprobs.map { it.toMutableList() }
            }

            /**
             * Adds a single [ResponseTextDeltaEvent.Logprob] to [logprobs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLogprob(logprob: ResponseTextDeltaEvent.Logprob) = apply {
                logprobs =
                    (logprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("logprobs", it).add(logprob)
                    }
            }

            /** The index of the output item that the text delta was added to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number for this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.output_text.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseTextWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .delta()
             * .itemId()
             * .logprobs()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseTextWsDelta =
                ResponseTextWsDelta(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("logprobs", logprobs).map { it.toImmutable() },
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseTextWsDelta = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            delta()
            itemId()
            logprobs().forEach { it.validate() }
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.output_text.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.output_text.delta")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseTextWsDelta &&
                contentIndex == other.contentIndex &&
                delta == other.delta &&
                itemId == other.itemId &&
                logprobs == other.logprobs &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                delta,
                itemId,
                logprobs,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseTextWsDelta{contentIndex=$contentIndex, delta=$delta, itemId=$itemId, logprobs=$logprobs, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when text content is finalized. */
    class ResponseTextWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val logprobs: JsonField<List<ResponseTextDoneEvent.Logprob>>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logprobs")
            @ExcludeMissing
            logprobs: JsonField<List<ResponseTextDoneEvent.Logprob>> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            contentIndex,
            itemId,
            logprobs,
            outputIndex,
            sequenceNumber,
            text,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseTextDoneEvent(): ResponseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(contentIndex)
                .itemId(itemId)
                .logprobs(logprobs)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .text(text)
                .type(type)
                .build()

        /**
         * The index of the content part that the text content is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The ID of the output item that the text content is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The log probabilities of the tokens in the delta.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun logprobs(): List<ResponseTextDoneEvent.Logprob> = logprobs.getRequired("logprobs")

        /**
         * The index of the output item that the text content is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number for this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The text content that is finalized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * The type of the event. Always `response.output_text.done`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.output_text.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [logprobs].
         *
         * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprobs")
        @ExcludeMissing
        fun _logprobs(): JsonField<List<ResponseTextDoneEvent.Logprob>> = logprobs

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of [ResponseTextWsDone].
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .logprobs()
             * .outputIndex()
             * .sequenceNumber()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseTextWsDone]. */
        class Builder internal constructor() {

            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var logprobs: JsonField<MutableList<ResponseTextDoneEvent.Logprob>>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("response.output_text.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseTextWsDone: ResponseTextWsDone) = apply {
                contentIndex = responseTextWsDone.contentIndex
                itemId = responseTextWsDone.itemId
                logprobs = responseTextWsDone.logprobs.map { it.toMutableList() }
                outputIndex = responseTextWsDone.outputIndex
                sequenceNumber = responseTextWsDone.sequenceNumber
                text = responseTextWsDone.text
                type = responseTextWsDone.type
                streamId = responseTextWsDone.streamId
                additionalProperties = responseTextWsDone.additionalProperties.toMutableMap()
            }

            /** The index of the content part that the text content is finalized. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The ID of the output item that the text content is finalized. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The log probabilities of the tokens in the delta. */
            fun logprobs(logprobs: List<ResponseTextDoneEvent.Logprob>) =
                logprobs(JsonField.of(logprobs))

            /**
             * Sets [Builder.logprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprobs] with a well-typed
             * `List<ResponseTextDoneEvent.Logprob>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun logprobs(logprobs: JsonField<List<ResponseTextDoneEvent.Logprob>>) = apply {
                this.logprobs = logprobs.map { it.toMutableList() }
            }

            /**
             * Adds a single [ResponseTextDoneEvent.Logprob] to [logprobs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLogprob(logprob: ResponseTextDoneEvent.Logprob) = apply {
                logprobs =
                    (logprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("logprobs", it).add(logprob)
                    }
            }

            /** The index of the output item that the text content is finalized. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number for this event. */
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

            /** The text content that is finalized. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.output_text.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseTextWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentIndex()
             * .itemId()
             * .logprobs()
             * .outputIndex()
             * .sequenceNumber()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseTextWsDone =
                ResponseTextWsDone(
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("logprobs", logprobs).map { it.toImmutable() },
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    checkRequired("text", text),
                    type,
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
        fun validate(): ResponseTextWsDone = apply {
            if (validated) {
                return@apply
            }

            contentIndex()
            itemId()
            logprobs().forEach { it.validate() }
            outputIndex()
            sequenceNumber()
            text()
            _type().let {
                if (it != JsonValue.from("response.output_text.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.output_text.done")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseTextWsDone &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                logprobs == other.logprobs &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                text == other.text &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentIndex,
                itemId,
                logprobs,
                outputIndex,
                sequenceNumber,
                text,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseTextWsDone{contentIndex=$contentIndex, itemId=$itemId, logprobs=$logprobs, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, text=$text, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a web search call is completed. */
    class ResponseWebSearchCallWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseWebSearchCallCompletedEvent(): ResponseWebSearchCallCompletedEvent =
            ResponseWebSearchCallCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * Unique ID for the output item associated with the web search call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the web search call is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of the web search call being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.web_search_call.completed`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.web_search_call.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseWebSearchCallWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWebSearchCallWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.web_search_call.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWebSearchCallWsCompleted: ResponseWebSearchCallWsCompleted) =
                apply {
                    itemId = responseWebSearchCallWsCompleted.itemId
                    outputIndex = responseWebSearchCallWsCompleted.outputIndex
                    sequenceNumber = responseWebSearchCallWsCompleted.sequenceNumber
                    type = responseWebSearchCallWsCompleted.type
                    streamId = responseWebSearchCallWsCompleted.streamId
                    additionalProperties =
                        responseWebSearchCallWsCompleted.additionalProperties.toMutableMap()
                }

            /** Unique ID for the output item associated with the web search call. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the web search call is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of the web search call being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.web_search_call.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWebSearchCallWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWebSearchCallWsCompleted =
                ResponseWebSearchCallWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWebSearchCallWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.web_search_call.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.web_search_call.completed")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWebSearchCallWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWebSearchCallWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a web search call is initiated. */
    class ResponseWebSearchCallInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseWebSearchCallInProgressEvent(): ResponseWebSearchCallInProgressEvent =
            ResponseWebSearchCallInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * Unique ID for the output item associated with the web search call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the web search call is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of the web search call being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.web_search_call.in_progress`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.web_search_call.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseWebSearchCallInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWebSearchCallInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.web_search_call.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseWebSearchCallInWsProgress: ResponseWebSearchCallInWsProgress
            ) = apply {
                itemId = responseWebSearchCallInWsProgress.itemId
                outputIndex = responseWebSearchCallInWsProgress.outputIndex
                sequenceNumber = responseWebSearchCallInWsProgress.sequenceNumber
                type = responseWebSearchCallInWsProgress.type
                streamId = responseWebSearchCallInWsProgress.streamId
                additionalProperties =
                    responseWebSearchCallInWsProgress.additionalProperties.toMutableMap()
            }

            /** Unique ID for the output item associated with the web search call. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the web search call is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of the web search call being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.web_search_call.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWebSearchCallInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWebSearchCallInWsProgress =
                ResponseWebSearchCallInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWebSearchCallInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.web_search_call.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.web_search_call.in_progress")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWebSearchCallInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWebSearchCallInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a web search call is executing. */
    class ResponseWebSearchCallWsSearching
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseWebSearchCallSearchingEvent(): ResponseWebSearchCallSearchingEvent =
            ResponseWebSearchCallSearchingEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * Unique ID for the output item associated with the web search call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that the web search call is associated with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of the web search call being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always `response.web_search_call.searching`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.web_search_call.searching")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseWebSearchCallWsSearching].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWebSearchCallWsSearching]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.web_search_call.searching")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWebSearchCallWsSearching: ResponseWebSearchCallWsSearching) =
                apply {
                    itemId = responseWebSearchCallWsSearching.itemId
                    outputIndex = responseWebSearchCallWsSearching.outputIndex
                    sequenceNumber = responseWebSearchCallWsSearching.sequenceNumber
                    type = responseWebSearchCallWsSearching.type
                    streamId = responseWebSearchCallWsSearching.streamId
                    additionalProperties =
                        responseWebSearchCallWsSearching.additionalProperties.toMutableMap()
                }

            /** Unique ID for the output item associated with the web search call. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that the web search call is associated with. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of the web search call being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.web_search_call.searching")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWebSearchCallWsSearching].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWebSearchCallWsSearching =
                ResponseWebSearchCallWsSearching(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWebSearchCallWsSearching = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.web_search_call.searching")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.web_search_call.searching")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWebSearchCallWsSearching &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWebSearchCallWsSearching{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /**
     * Emitted when an image generation tool call has completed and the final image is available.
     */
    class ResponseImageGenCallWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseImageGenCallCompletedEvent(): ResponseImageGenCallCompletedEvent =
            ResponseImageGenCallCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.image_generation_call.completed'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.image_generation_call.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseImageGenCallWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseImageGenCallWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.image_generation_call.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseImageGenCallWsCompleted: ResponseImageGenCallWsCompleted) =
                apply {
                    itemId = responseImageGenCallWsCompleted.itemId
                    outputIndex = responseImageGenCallWsCompleted.outputIndex
                    sequenceNumber = responseImageGenCallWsCompleted.sequenceNumber
                    type = responseImageGenCallWsCompleted.type
                    streamId = responseImageGenCallWsCompleted.streamId
                    additionalProperties =
                        responseImageGenCallWsCompleted.additionalProperties.toMutableMap()
                }

            /** The unique identifier of the image generation item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.image_generation_call.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseImageGenCallWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseImageGenCallWsCompleted =
                ResponseImageGenCallWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseImageGenCallWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.image_generation_call.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.image_generation_call.completed")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseImageGenCallWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseImageGenCallWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /**
     * Emitted when an image generation tool call is actively generating an image (intermediate
     * state).
     */
    class ResponseImageGenCallWsGenerating
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseImageGenCallGeneratingEvent(): ResponseImageGenCallGeneratingEvent =
            ResponseImageGenCallGeneratingEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.image_generation_call.generating'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.image_generation_call.generating")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseImageGenCallWsGenerating].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseImageGenCallWsGenerating]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.image_generation_call.generating")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseImageGenCallWsGenerating: ResponseImageGenCallWsGenerating) =
                apply {
                    itemId = responseImageGenCallWsGenerating.itemId
                    outputIndex = responseImageGenCallWsGenerating.outputIndex
                    sequenceNumber = responseImageGenCallWsGenerating.sequenceNumber
                    type = responseImageGenCallWsGenerating.type
                    streamId = responseImageGenCallWsGenerating.streamId
                    additionalProperties =
                        responseImageGenCallWsGenerating.additionalProperties.toMutableMap()
                }

            /** The unique identifier of the image generation item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of the image generation item being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.image_generation_call.generating")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseImageGenCallWsGenerating].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseImageGenCallWsGenerating =
                ResponseImageGenCallWsGenerating(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseImageGenCallWsGenerating = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.image_generation_call.generating")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.image_generation_call.generating")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseImageGenCallWsGenerating &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseImageGenCallWsGenerating{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an image generation tool call is in progress. */
    class ResponseImageGenCallInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseImageGenCallInProgressEvent(): ResponseImageGenCallInProgressEvent =
            ResponseImageGenCallInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.image_generation_call.in_progress'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.image_generation_call.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseImageGenCallInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseImageGenCallInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.image_generation_call.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseImageGenCallInWsProgress: ResponseImageGenCallInWsProgress) =
                apply {
                    itemId = responseImageGenCallInWsProgress.itemId
                    outputIndex = responseImageGenCallInWsProgress.outputIndex
                    sequenceNumber = responseImageGenCallInWsProgress.sequenceNumber
                    type = responseImageGenCallInWsProgress.type
                    streamId = responseImageGenCallInWsProgress.streamId
                    additionalProperties =
                        responseImageGenCallInWsProgress.additionalProperties.toMutableMap()
                }

            /** The unique identifier of the image generation item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of the image generation item being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.image_generation_call.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseImageGenCallInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseImageGenCallInWsProgress =
                ResponseImageGenCallInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseImageGenCallInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.image_generation_call.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.image_generation_call.in_progress")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseImageGenCallInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseImageGenCallInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a partial image is available during image generation streaming. */
    class ResponseImageGenCallPartialWsImage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val partialImageB64: JsonField<String>,
        private val partialImageIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("partial_image_b64")
            @ExcludeMissing
            partialImageB64: JsonField<String> = JsonMissing.of(),
            @JsonProperty("partial_image_index")
            @ExcludeMissing
            partialImageIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            itemId,
            outputIndex,
            partialImageB64,
            partialImageIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseImageGenCallPartialImageEvent(): ResponseImageGenCallPartialImageEvent =
            ResponseImageGenCallPartialImageEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .partialImageB64(partialImageB64)
                .partialImageIndex(partialImageIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * Base64-encoded partial image data, suitable for rendering as an image.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun partialImageB64(): String = partialImageB64.getRequired("partial_image_b64")

        /**
         * 0-based index for the partial image (backend is 1-based, but this is 0-based for the
         * user).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun partialImageIndex(): Long = partialImageIndex.getRequired("partial_image_index")

        /**
         * The sequence number of the image generation item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.image_generation_call.partial_image'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.image_generation_call.partial_image")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

        /**
         * Returns the raw JSON value of [partialImageB64].
         *
         * Unlike [partialImageB64], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("partial_image_b64")
        @ExcludeMissing
        fun _partialImageB64(): JsonField<String> = partialImageB64

        /**
         * Returns the raw JSON value of [partialImageIndex].
         *
         * Unlike [partialImageIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("partial_image_index")
        @ExcludeMissing
        fun _partialImageIndex(): JsonField<Long> = partialImageIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseImageGenCallPartialWsImage].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .partialImageB64()
             * .partialImageIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseImageGenCallPartialWsImage]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var partialImageB64: JsonField<String>? = null
            private var partialImageIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue =
                JsonValue.from("response.image_generation_call.partial_image")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseImageGenCallPartialWsImage: ResponseImageGenCallPartialWsImage
            ) = apply {
                itemId = responseImageGenCallPartialWsImage.itemId
                outputIndex = responseImageGenCallPartialWsImage.outputIndex
                partialImageB64 = responseImageGenCallPartialWsImage.partialImageB64
                partialImageIndex = responseImageGenCallPartialWsImage.partialImageIndex
                sequenceNumber = responseImageGenCallPartialWsImage.sequenceNumber
                type = responseImageGenCallPartialWsImage.type
                streamId = responseImageGenCallPartialWsImage.streamId
                additionalProperties =
                    responseImageGenCallPartialWsImage.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the image generation item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** Base64-encoded partial image data, suitable for rendering as an image. */
            fun partialImageB64(partialImageB64: String) =
                partialImageB64(JsonField.of(partialImageB64))

            /**
             * Sets [Builder.partialImageB64] to an arbitrary JSON value.
             *
             * You should usually call [Builder.partialImageB64] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun partialImageB64(partialImageB64: JsonField<String>) = apply {
                this.partialImageB64 = partialImageB64
            }

            /**
             * 0-based index for the partial image (backend is 1-based, but this is 0-based for the
             * user).
             */
            fun partialImageIndex(partialImageIndex: Long) =
                partialImageIndex(JsonField.of(partialImageIndex))

            /**
             * Sets [Builder.partialImageIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.partialImageIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun partialImageIndex(partialImageIndex: JsonField<Long>) = apply {
                this.partialImageIndex = partialImageIndex
            }

            /** The sequence number of the image generation item being processed. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.image_generation_call.partial_image")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseImageGenCallPartialWsImage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .partialImageB64()
             * .partialImageIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseImageGenCallPartialWsImage =
                ResponseImageGenCallPartialWsImage(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("partialImageB64", partialImageB64),
                    checkRequired("partialImageIndex", partialImageIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseImageGenCallPartialWsImage = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            partialImageB64()
            partialImageIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.image_generation_call.partial_image")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (partialImageB64.asKnown().isPresent) 1 else 0) +
                (if (partialImageIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.image_generation_call.partial_image")) 1
                    else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseImageGenCallPartialWsImage &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                partialImageB64 == other.partialImageB64 &&
                partialImageIndex == other.partialImageIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                itemId,
                outputIndex,
                partialImageB64,
                partialImageIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseImageGenCallPartialWsImage{itemId=$itemId, outputIndex=$outputIndex, partialImageB64=$partialImageB64, partialImageIndex=$partialImageIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when there is a delta (partial update) to the arguments of an MCP tool call. */
    class ResponseMcpCallArgumentsWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpCallArgumentsDeltaEvent(): ResponseMcpCallArgumentsDeltaEvent =
            ResponseMcpCallArgumentsDeltaEvent.builder()
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * A JSON string containing the partial update to the arguments for the MCP tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * The unique identifier of the MCP tool call item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_call_arguments.delta'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_call_arguments.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpCallArgumentsWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpCallArgumentsWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_call_arguments.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpCallArgumentsWsDelta: ResponseMcpCallArgumentsWsDelta) =
                apply {
                    delta = responseMcpCallArgumentsWsDelta.delta
                    itemId = responseMcpCallArgumentsWsDelta.itemId
                    outputIndex = responseMcpCallArgumentsWsDelta.outputIndex
                    sequenceNumber = responseMcpCallArgumentsWsDelta.sequenceNumber
                    type = responseMcpCallArgumentsWsDelta.type
                    streamId = responseMcpCallArgumentsWsDelta.streamId
                    additionalProperties =
                        responseMcpCallArgumentsWsDelta.additionalProperties.toMutableMap()
                }

            /**
             * A JSON string containing the partial update to the arguments for the MCP tool call.
             */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** The unique identifier of the MCP tool call item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_call_arguments.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpCallArgumentsWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpCallArgumentsWsDelta =
                ResponseMcpCallArgumentsWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpCallArgumentsWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_call_arguments.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.mcp_call_arguments.delta")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpCallArgumentsWsDelta &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpCallArgumentsWsDelta{delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the arguments for an MCP tool call are finalized. */
    class ResponseMcpCallArgumentsWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val arguments: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(arguments, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpCallArgumentsDoneEvent(): ResponseMcpCallArgumentsDoneEvent =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments(arguments)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * A JSON string containing the finalized arguments for the MCP tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The unique identifier of the MCP tool call item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_call_arguments.done'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_call_arguments.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpCallArgumentsWsDone].
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpCallArgumentsWsDone]. */
        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_call_arguments.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpCallArgumentsWsDone: ResponseMcpCallArgumentsWsDone) =
                apply {
                    arguments = responseMcpCallArgumentsWsDone.arguments
                    itemId = responseMcpCallArgumentsWsDone.itemId
                    outputIndex = responseMcpCallArgumentsWsDone.outputIndex
                    sequenceNumber = responseMcpCallArgumentsWsDone.sequenceNumber
                    type = responseMcpCallArgumentsWsDone.type
                    streamId = responseMcpCallArgumentsWsDone.streamId
                    additionalProperties =
                        responseMcpCallArgumentsWsDone.additionalProperties.toMutableMap()
                }

            /** A JSON string containing the finalized arguments for the MCP tool call. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The unique identifier of the MCP tool call item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_call_arguments.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpCallArgumentsWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpCallArgumentsWsDone =
                ResponseMcpCallArgumentsWsDone(
                    checkRequired("arguments", arguments),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpCallArgumentsWsDone = apply {
            if (validated) {
                return@apply
            }

            arguments()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_call_arguments.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.mcp_call_arguments.done")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpCallArgumentsWsDone &&
                arguments == other.arguments &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                arguments,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpCallArgumentsWsDone{arguments=$arguments, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an MCP tool call has completed successfully. */
    class ResponseMcpCallWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpCallCompletedEvent(): ResponseMcpCallCompletedEvent =
            ResponseMcpCallCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the MCP tool call item that completed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that completed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_call.completed'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_call.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpCallWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpCallWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_call.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpCallWsCompleted: ResponseMcpCallWsCompleted) = apply {
                itemId = responseMcpCallWsCompleted.itemId
                outputIndex = responseMcpCallWsCompleted.outputIndex
                sequenceNumber = responseMcpCallWsCompleted.sequenceNumber
                type = responseMcpCallWsCompleted.type
                streamId = responseMcpCallWsCompleted.streamId
                additionalProperties =
                    responseMcpCallWsCompleted.additionalProperties.toMutableMap()
            }

            /** The ID of the MCP tool call item that completed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that completed. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_call.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpCallWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpCallWsCompleted =
                ResponseMcpCallWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpCallWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_call.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.mcp_call.completed")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpCallWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpCallWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an MCP tool call has failed. */
    class ResponseMcpCallWsFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpCallFailedEvent(): ResponseMcpCallFailedEvent =
            ResponseMcpCallFailedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the MCP tool call item that failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_call.failed'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_call.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of [ResponseMcpCallWsFailed].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpCallWsFailed]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_call.failed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpCallWsFailed: ResponseMcpCallWsFailed) = apply {
                itemId = responseMcpCallWsFailed.itemId
                outputIndex = responseMcpCallWsFailed.outputIndex
                sequenceNumber = responseMcpCallWsFailed.sequenceNumber
                type = responseMcpCallWsFailed.type
                streamId = responseMcpCallWsFailed.streamId
                additionalProperties = responseMcpCallWsFailed.additionalProperties.toMutableMap()
            }

            /** The ID of the MCP tool call item that failed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that failed. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_call.failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpCallWsFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpCallWsFailed =
                ResponseMcpCallWsFailed(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpCallWsFailed = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_call.failed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.mcp_call.failed")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpCallWsFailed &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpCallWsFailed{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an MCP tool call is in progress. */
    class ResponseMcpCallInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpCallInProgressEvent(): ResponseMcpCallInProgressEvent =
            ResponseMcpCallInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The unique identifier of the MCP tool call item being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_call.in_progress'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_call.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpCallInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpCallInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_call.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpCallInWsProgress: ResponseMcpCallInWsProgress) = apply {
                itemId = responseMcpCallInWsProgress.itemId
                outputIndex = responseMcpCallInWsProgress.outputIndex
                sequenceNumber = responseMcpCallInWsProgress.sequenceNumber
                type = responseMcpCallInWsProgress.type
                streamId = responseMcpCallInWsProgress.streamId
                additionalProperties =
                    responseMcpCallInWsProgress.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the MCP tool call item being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_call.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpCallInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpCallInWsProgress =
                ResponseMcpCallInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpCallInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_call.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.mcp_call.in_progress")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpCallInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpCallInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the list of available MCP tools has been successfully retrieved. */
    class ResponseMcpListToolsWsCompleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpListToolsCompletedEvent(): ResponseMcpListToolsCompletedEvent =
            ResponseMcpListToolsCompletedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the MCP tool call item that produced this output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that was processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_list_tools.completed'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_list_tools.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpListToolsWsCompleted].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpListToolsWsCompleted]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_list_tools.completed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpListToolsWsCompleted: ResponseMcpListToolsWsCompleted) =
                apply {
                    itemId = responseMcpListToolsWsCompleted.itemId
                    outputIndex = responseMcpListToolsWsCompleted.outputIndex
                    sequenceNumber = responseMcpListToolsWsCompleted.sequenceNumber
                    type = responseMcpListToolsWsCompleted.type
                    streamId = responseMcpListToolsWsCompleted.streamId
                    additionalProperties =
                        responseMcpListToolsWsCompleted.additionalProperties.toMutableMap()
                }

            /** The ID of the MCP tool call item that produced this output. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that was processed. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_list_tools.completed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpListToolsWsCompleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpListToolsWsCompleted =
                ResponseMcpListToolsWsCompleted(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpListToolsWsCompleted = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_list_tools.completed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.mcp_list_tools.completed")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpListToolsWsCompleted &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpListToolsWsCompleted{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the attempt to list available MCP tools has failed. */
    class ResponseMcpListToolsWsFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpListToolsFailedEvent(): ResponseMcpListToolsFailedEvent =
            ResponseMcpListToolsFailedEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the MCP tool call item that failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_list_tools.failed'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_list_tools.failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpListToolsWsFailed].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpListToolsWsFailed]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_list_tools.failed")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpListToolsWsFailed: ResponseMcpListToolsWsFailed) = apply {
                itemId = responseMcpListToolsWsFailed.itemId
                outputIndex = responseMcpListToolsWsFailed.outputIndex
                sequenceNumber = responseMcpListToolsWsFailed.sequenceNumber
                type = responseMcpListToolsWsFailed.type
                streamId = responseMcpListToolsWsFailed.streamId
                additionalProperties =
                    responseMcpListToolsWsFailed.additionalProperties.toMutableMap()
            }

            /** The ID of the MCP tool call item that failed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that failed. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_list_tools.failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpListToolsWsFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpListToolsWsFailed =
                ResponseMcpListToolsWsFailed(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpListToolsWsFailed = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_list_tools.failed")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.mcp_list_tools.failed")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpListToolsWsFailed &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpListToolsWsFailed{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when the system is in the process of retrieving the list of available MCP tools. */
    class ResponseMcpListToolsInWsProgress
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseMcpListToolsInProgressEvent(): ResponseMcpListToolsInProgressEvent =
            ResponseMcpListToolsInProgressEvent.builder()
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The ID of the MCP tool call item that is being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item that is being processed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.mcp_list_tools.in_progress'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.mcp_list_tools.in_progress")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseMcpListToolsInWsProgress].
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseMcpListToolsInWsProgress]. */
        class Builder internal constructor() {

            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.mcp_list_tools.in_progress")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseMcpListToolsInWsProgress: ResponseMcpListToolsInWsProgress) =
                apply {
                    itemId = responseMcpListToolsInWsProgress.itemId
                    outputIndex = responseMcpListToolsInWsProgress.outputIndex
                    sequenceNumber = responseMcpListToolsInWsProgress.sequenceNumber
                    type = responseMcpListToolsInWsProgress.type
                    streamId = responseMcpListToolsInWsProgress.streamId
                    additionalProperties =
                        responseMcpListToolsInWsProgress.additionalProperties.toMutableMap()
                }

            /** The ID of the MCP tool call item that is being processed. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item that is being processed. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.mcp_list_tools.in_progress")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseMcpListToolsInWsProgress].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseMcpListToolsInWsProgress =
                ResponseMcpListToolsInWsProgress(
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseMcpListToolsInWsProgress = apply {
            if (validated) {
                return@apply
            }

            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.mcp_list_tools.in_progress")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.mcp_list_tools.in_progress")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseMcpListToolsInWsProgress &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(itemId, outputIndex, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseMcpListToolsInWsProgress{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when an annotation is added to output text content. */
    class ResponseOutputTextAnnotationWsAdded
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val annotation: JsonValue,
        private val annotationIndex: JsonField<Long>,
        private val contentIndex: JsonField<Long>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("annotation") @ExcludeMissing annotation: JsonValue = JsonMissing.of(),
            @JsonProperty("annotation_index")
            @ExcludeMissing
            annotationIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("content_index")
            @ExcludeMissing
            contentIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(
            annotation,
            annotationIndex,
            contentIndex,
            itemId,
            outputIndex,
            sequenceNumber,
            type,
            streamId,
            mutableMapOf(),
        )

        fun toResponseOutputTextAnnotationAddedEvent(): ResponseOutputTextAnnotationAddedEvent =
            ResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(annotation)
                .annotationIndex(annotationIndex)
                .contentIndex(contentIndex)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The annotation object being added. (See annotation schema for details.)
         *
         * This arbitrary value can be deserialized into a custom type using the `convert` method:
         * ```java
         * MyClass myObject = responseOutputTextAnnotationWsAdded.annotation().convert(MyClass.class);
         * ```
         */
        @JsonProperty("annotation") @ExcludeMissing fun _annotation(): JsonValue = annotation

        /**
         * The index of the annotation within the content part.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun annotationIndex(): Long = annotationIndex.getRequired("annotation_index")

        /**
         * The index of the content part within the output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contentIndex(): Long = contentIndex.getRequired("content_index")

        /**
         * The unique identifier of the item to which the annotation is being added.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output item in the response's output array.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.output_text.annotation.added'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.output_text.annotation.added")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [annotationIndex].
         *
         * Unlike [annotationIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("annotation_index")
        @ExcludeMissing
        fun _annotationIndex(): JsonField<Long> = annotationIndex

        /**
         * Returns the raw JSON value of [contentIndex].
         *
         * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("content_index")
        @ExcludeMissing
        fun _contentIndex(): JsonField<Long> = contentIndex

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseOutputTextAnnotationWsAdded].
             *
             * The following fields are required:
             * ```java
             * .annotation()
             * .annotationIndex()
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseOutputTextAnnotationWsAdded]. */
        class Builder internal constructor() {

            private var annotation: JsonValue? = null
            private var annotationIndex: JsonField<Long>? = null
            private var contentIndex: JsonField<Long>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.output_text.annotation.added")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseOutputTextAnnotationWsAdded: ResponseOutputTextAnnotationWsAdded
            ) = apply {
                annotation = responseOutputTextAnnotationWsAdded.annotation
                annotationIndex = responseOutputTextAnnotationWsAdded.annotationIndex
                contentIndex = responseOutputTextAnnotationWsAdded.contentIndex
                itemId = responseOutputTextAnnotationWsAdded.itemId
                outputIndex = responseOutputTextAnnotationWsAdded.outputIndex
                sequenceNumber = responseOutputTextAnnotationWsAdded.sequenceNumber
                type = responseOutputTextAnnotationWsAdded.type
                streamId = responseOutputTextAnnotationWsAdded.streamId
                additionalProperties =
                    responseOutputTextAnnotationWsAdded.additionalProperties.toMutableMap()
            }

            /** The annotation object being added. (See annotation schema for details.) */
            fun annotation(annotation: JsonValue) = apply { this.annotation = annotation }

            /** The index of the annotation within the content part. */
            fun annotationIndex(annotationIndex: Long) =
                annotationIndex(JsonField.of(annotationIndex))

            /**
             * Sets [Builder.annotationIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.annotationIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun annotationIndex(annotationIndex: JsonField<Long>) = apply {
                this.annotationIndex = annotationIndex
            }

            /** The index of the content part within the output item. */
            fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

            /**
             * Sets [Builder.contentIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentIndex] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentIndex(contentIndex: JsonField<Long>) = apply {
                this.contentIndex = contentIndex
            }

            /** The unique identifier of the item to which the annotation is being added. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output item in the response's output array. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.output_text.annotation.added")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseOutputTextAnnotationWsAdded].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .annotation()
             * .annotationIndex()
             * .contentIndex()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseOutputTextAnnotationWsAdded =
                ResponseOutputTextAnnotationWsAdded(
                    checkRequired("annotation", annotation),
                    checkRequired("annotationIndex", annotationIndex),
                    checkRequired("contentIndex", contentIndex),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseOutputTextAnnotationWsAdded = apply {
            if (validated) {
                return@apply
            }

            annotationIndex()
            contentIndex()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.output_text.annotation.added")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (annotationIndex.asKnown().isPresent) 1 else 0) +
                (if (contentIndex.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.output_text.annotation.added")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseOutputTextAnnotationWsAdded &&
                annotation == other.annotation &&
                annotationIndex == other.annotationIndex &&
                contentIndex == other.contentIndex &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                annotation,
                annotationIndex,
                contentIndex,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseOutputTextAnnotationWsAdded{annotation=$annotation, annotationIndex=$annotationIndex, contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Emitted when a response is queued and waiting to be processed. */
    class ResponseWsQueued
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val response: JsonField<Response>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(response, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseQueuedEvent(): ResponseQueuedEvent =
            ResponseQueuedEvent.builder()
                .response(response)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The full response object that is queued.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The sequence number for this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The type of the event. Always 'response.queued'.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.queued")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * Returns a mutable builder for constructing an instance of [ResponseWsQueued].
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseWsQueued]. */
        class Builder internal constructor() {

            private var response: JsonField<Response>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.queued")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(responseWsQueued: ResponseWsQueued) = apply {
                response = responseWsQueued.response
                sequenceNumber = responseWsQueued.sequenceNumber
                type = responseWsQueued.type
                streamId = responseWsQueued.streamId
                additionalProperties = responseWsQueued.additionalProperties.toMutableMap()
            }

            /** The full response object that is queued. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** The sequence number for this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.queued")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseWsQueued].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .response()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseWsQueued =
                ResponseWsQueued(
                    checkRequired("response", response),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseWsQueued = apply {
            if (validated) {
                return@apply
            }

            response().validate()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.queued")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("response.queued")) 1 else 0 } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseWsQueued &&
                response == other.response &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(response, sequenceNumber, type, streamId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseWsQueued{response=$response, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Event representing a delta (partial update) to the input of a custom tool call. */
    class ResponseCustomToolCallInputWsDelta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val delta: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(delta, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCustomToolCallInputDeltaEvent(): ResponseCustomToolCallInputDeltaEvent =
            ResponseCustomToolCallInputDeltaEvent.builder()
                .delta(delta)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The incremental input data (delta) for the custom tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delta(): String = delta.getRequired("delta")

        /**
         * Unique identifier for the API item associated with this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output this delta applies to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The event type identifier.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.custom_tool_call_input.delta")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [delta].
         *
         * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCustomToolCallInputWsDelta].
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCustomToolCallInputWsDelta]. */
        class Builder internal constructor() {

            private var delta: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.custom_tool_call_input.delta")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCustomToolCallInputWsDelta: ResponseCustomToolCallInputWsDelta
            ) = apply {
                delta = responseCustomToolCallInputWsDelta.delta
                itemId = responseCustomToolCallInputWsDelta.itemId
                outputIndex = responseCustomToolCallInputWsDelta.outputIndex
                sequenceNumber = responseCustomToolCallInputWsDelta.sequenceNumber
                type = responseCustomToolCallInputWsDelta.type
                streamId = responseCustomToolCallInputWsDelta.streamId
                additionalProperties =
                    responseCustomToolCallInputWsDelta.additionalProperties.toMutableMap()
            }

            /** The incremental input data (delta) for the custom tool call. */
            fun delta(delta: String) = delta(JsonField.of(delta))

            /**
             * Sets [Builder.delta] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delta] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delta(delta: JsonField<String>) = apply { this.delta = delta }

            /** Unique identifier for the API item associated with this event. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output this delta applies to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.custom_tool_call_input.delta")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCustomToolCallInputWsDelta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .delta()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCustomToolCallInputWsDelta =
                ResponseCustomToolCallInputWsDelta(
                    checkRequired("delta", delta),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCustomToolCallInputWsDelta = apply {
            if (validated) {
                return@apply
            }

            delta()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.custom_tool_call_input.delta")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (delta.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.custom_tool_call_input.delta")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCustomToolCallInputWsDelta &&
                delta == other.delta &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                delta,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCustomToolCallInputWsDelta{delta=$delta, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }

    /** Event indicating that input for a custom tool call is complete. */
    class ResponseCustomToolCallInputWsDone
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<String>,
        private val itemId: JsonField<String>,
        private val outputIndex: JsonField<Long>,
        private val sequenceNumber: JsonField<Long>,
        private val type: JsonValue,
        private val streamId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output_index")
            @ExcludeMissing
            outputIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sequence_number")
            @ExcludeMissing
            sequenceNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("stream_id")
            @ExcludeMissing
            streamId: JsonField<String> = JsonMissing.of(),
        ) : this(input, itemId, outputIndex, sequenceNumber, type, streamId, mutableMapOf())

        fun toResponseCustomToolCallInputDoneEvent(): ResponseCustomToolCallInputDoneEvent =
            ResponseCustomToolCallInputDoneEvent.builder()
                .input(input)
                .itemId(itemId)
                .outputIndex(outputIndex)
                .sequenceNumber(sequenceNumber)
                .type(type)
                .build()

        /**
         * The complete input data for the custom tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): String = input.getRequired("input")

        /**
         * Unique identifier for the API item associated with this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun itemId(): String = itemId.getRequired("item_id")

        /**
         * The index of the output this event applies to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputIndex(): Long = outputIndex.getRequired("output_index")

        /**
         * The sequence number of this event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

        /**
         * The event type identifier.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("response.custom_tool_call_input.done")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The WebSocket lane that emitted this event. This field is present when the originating
         * `response.create` event supplied a `stream_id`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamId(): Optional<String> = streamId.getOptional("stream_id")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

        /**
         * Returns the raw JSON value of [itemId].
         *
         * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

        /**
         * Returns the raw JSON value of [outputIndex].
         *
         * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output_index")
        @ExcludeMissing
        fun _outputIndex(): JsonField<Long> = outputIndex

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
             * Returns a mutable builder for constructing an instance of
             * [ResponseCustomToolCallInputWsDone].
             *
             * The following fields are required:
             * ```java
             * .input()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResponseCustomToolCallInputWsDone]. */
        class Builder internal constructor() {

            private var input: JsonField<String>? = null
            private var itemId: JsonField<String>? = null
            private var outputIndex: JsonField<Long>? = null
            private var sequenceNumber: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("response.custom_tool_call_input.done")
            private var streamId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                responseCustomToolCallInputWsDone: ResponseCustomToolCallInputWsDone
            ) = apply {
                input = responseCustomToolCallInputWsDone.input
                itemId = responseCustomToolCallInputWsDone.itemId
                outputIndex = responseCustomToolCallInputWsDone.outputIndex
                sequenceNumber = responseCustomToolCallInputWsDone.sequenceNumber
                type = responseCustomToolCallInputWsDone.type
                streamId = responseCustomToolCallInputWsDone.streamId
                additionalProperties =
                    responseCustomToolCallInputWsDone.additionalProperties.toMutableMap()
            }

            /** The complete input data for the custom tool call. */
            fun input(input: String) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun input(input: JsonField<String>) = apply { this.input = input }

            /** Unique identifier for the API item associated with this event. */
            fun itemId(itemId: String) = itemId(JsonField.of(itemId))

            /**
             * Sets [Builder.itemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.itemId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

            /** The index of the output this event applies to. */
            fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

            /**
             * Sets [Builder.outputIndex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

            /** The sequence number of this event. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("response.custom_tool_call_input.done")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ResponseCustomToolCallInputWsDone].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * .itemId()
             * .outputIndex()
             * .sequenceNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResponseCustomToolCallInputWsDone =
                ResponseCustomToolCallInputWsDone(
                    checkRequired("input", input),
                    checkRequired("itemId", itemId),
                    checkRequired("outputIndex", outputIndex),
                    checkRequired("sequenceNumber", sequenceNumber),
                    type,
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
        fun validate(): ResponseCustomToolCallInputWsDone = apply {
            if (validated) {
                return@apply
            }

            input()
            itemId()
            outputIndex()
            sequenceNumber()
            _type().let {
                if (it != JsonValue.from("response.custom_tool_call_input.done")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (input.asKnown().isPresent) 1 else 0) +
                (if (itemId.asKnown().isPresent) 1 else 0) +
                (if (outputIndex.asKnown().isPresent) 1 else 0) +
                (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("response.custom_tool_call_input.done")) 1 else 0
                } +
                (if (streamId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseCustomToolCallInputWsDone &&
                input == other.input &&
                itemId == other.itemId &&
                outputIndex == other.outputIndex &&
                sequenceNumber == other.sequenceNumber &&
                type == other.type &&
                streamId == other.streamId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                input,
                itemId,
                outputIndex,
                sequenceNumber,
                type,
                streamId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResponseCustomToolCallInputWsDone{input=$input, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
    }
}
