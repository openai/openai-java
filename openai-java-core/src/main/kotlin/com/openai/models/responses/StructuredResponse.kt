package com.openai.models.responses

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.Reasoning
import com.openai.models.ResponsesModel
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [Response] that provides type-safe access to the [output] when using the
 * _Structured Outputs_ feature to deserialize a JSON response to an instance of an arbitrary class.
 * See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class to which the JSON data in the response will be deserialized.
 */
class StructuredResponse<T : Any>(
    @get:JvmName("responseType") val responseType: Class<T>,
    @get:JvmName("rawResponse") val rawResponse: Response,
) {
    /** @see Response.id */
    fun id(): Optional<String> = rawResponse.id()

    fun idOrThrow(): String = rawResponse.idOrThrow()

    /** @see Response.accessPrograms */
    fun accessPrograms(): Optional<Response.AccessPrograms> = rawResponse.accessPrograms()

    fun accessProgramsOrThrow(): Response.AccessPrograms = rawResponse.accessProgramsOrThrow()

    /** @see Response._accessPrograms */
    fun _accessPrograms(): JsonField<Response.AccessPrograms> = rawResponse._accessPrograms()

    /** @see Response.createdAt */
    fun createdAt(): Optional<Double> = rawResponse.createdAt()

    fun createdAtOrThrow(): Double = rawResponse.createdAtOrThrow()

    /** @see Response.error */
    fun error(): Optional<ResponseError> = rawResponse.error()

    fun errorOrThrow(): ResponseError = rawResponse.errorOrThrow()

    /** @see Response.incompleteDetails */
    fun incompleteDetails(): Optional<Response.IncompleteDetails> = rawResponse.incompleteDetails()

    fun incompleteDetailsOrThrow(): Response.IncompleteDetails =
        rawResponse.incompleteDetailsOrThrow()

    /** @see Response.instructions */
    fun instructions(): Optional<Response.Instructions> = rawResponse.instructions()

    fun instructionsOrThrow(): Response.Instructions = rawResponse.instructionsOrThrow()

    /** @see Response.metadata */
    fun metadata(): Optional<Response.Metadata> = rawResponse.metadata()

    fun metadataOrThrow(): Response.Metadata = rawResponse.metadataOrThrow()

    /** @see Response.model */
    fun model(): Optional<ResponsesModel> = rawResponse.model()

    fun modelOrThrow(): ResponsesModel = rawResponse.modelOrThrow()

    /** @see Response.moderation */
    fun moderation(): Optional<Response.Moderation> = rawResponse.moderation()

    fun moderationOrThrow(): Response.Moderation = rawResponse.moderationOrThrow()

    /** @see Response._object_ */
    fun _object_(): JsonField<JsonValue> = rawResponse._object_()

    fun object_(): Optional<JsonValue> = rawResponse.object_()

    fun object_OrThrow(): JsonValue = rawResponse.object_OrThrow()

    private val output by lazy {
        rawResponse._output().map { outputs ->
            outputs.map { StructuredResponseOutputItem<T>(responseType, it) }
        }
    }

    /** @see Response.output */
    fun output(): Optional<List<StructuredResponseOutputItem<T>>> = output.getOptional("output")

    fun outputOrThrow(): List<StructuredResponseOutputItem<T>> = output.getRequired("output")

    /** @see Response.parallelToolCalls */
    fun parallelToolCalls(): Optional<Boolean> = rawResponse.parallelToolCalls()

    fun parallelToolCallsOrThrow(): Boolean = rawResponse.parallelToolCallsOrThrow()

    /** @see Response.temperature */
    fun temperature(): Optional<Double> = rawResponse.temperature()

    fun temperatureOrThrow(): Double = rawResponse.temperatureOrThrow()

    /** @see Response.toolChoice */
    fun toolChoice(): Optional<Response.ToolChoice> = rawResponse.toolChoice()

    fun toolChoiceOrThrow(): Response.ToolChoice = rawResponse.toolChoiceOrThrow()

    /** @see Response.tools */
    fun tools(): Optional<List<Tool>> = rawResponse.tools()

    fun toolsOrThrow(): List<Tool> = rawResponse.toolsOrThrow()

    /** @see Response.toolUsage */
    fun toolUsage(): Optional<Response.ToolUsage> = rawResponse.toolUsage()

    fun toolUsageOrThrow(): Response.ToolUsage = rawResponse.toolUsageOrThrow()

    /** @see Response._toolUsage */
    fun _toolUsage(): JsonField<Response.ToolUsage> = rawResponse._toolUsage()

    /** @see Response.topP */
    fun topP(): Optional<Double> = rawResponse.topP()

    fun topPOrThrow(): Double = rawResponse.topPOrThrow()

    /** @see Response.maxToolCalls */
    fun maxToolCalls(): Optional<Long> = rawResponse.maxToolCalls()

    fun maxToolCallsOrThrow(): Long = rawResponse.maxToolCallsOrThrow()

    /** @see Response.topLogprobs */
    fun topLogprobs(): Optional<Long> = rawResponse.topLogprobs()

    fun topLogprobsOrThrow(): Long = rawResponse.topLogprobsOrThrow()

    /** @see Response.maxOutputTokens */
    fun maxOutputTokens(): Optional<Long> = rawResponse.maxOutputTokens()

    fun maxOutputTokensOrThrow(): Long = rawResponse.maxOutputTokensOrThrow()

    /** @see Response.previousResponseId */
    fun previousResponseId(): Optional<String> = rawResponse.previousResponseId()

    fun previousResponseIdOrThrow(): String = rawResponse.previousResponseIdOrThrow()

    /** @see Response.prompt */
    fun prompt(): Optional<ResponsePrompt> = rawResponse.prompt()

    fun promptOrThrow(): ResponsePrompt = rawResponse.promptOrThrow()

    /** @see Response.promptCacheDiagnostics */
    fun promptCacheDiagnostics(): Optional<Response.PromptCacheDiagnostics> =
        rawResponse.promptCacheDiagnostics()

    fun promptCacheDiagnosticsOrThrow(): Response.PromptCacheDiagnostics =
        rawResponse.promptCacheDiagnosticsOrThrow()

    /** @see Response.promptCacheKey */
    fun promptCacheKey(): Optional<String> = rawResponse.promptCacheKey()

    fun promptCacheKeyOrThrow(): String = rawResponse.promptCacheKeyOrThrow()

    /** @see Response.promptCacheOptions */
    fun promptCacheOptions(): Optional<Response.PromptCacheOptions> =
        rawResponse.promptCacheOptions()

    fun promptCacheOptionsOrThrow(): Response.PromptCacheOptions =
        rawResponse.promptCacheOptionsOrThrow()

    /** @see Response.promptCacheRetention */
    fun promptCacheRetention(): Optional<Response.PromptCacheRetention> =
        rawResponse.promptCacheRetention()

    fun promptCacheRetentionOrThrow(): Response.PromptCacheRetention =
        rawResponse.promptCacheRetentionOrThrow()

    /** @see Response.reasoning */
    fun reasoning(): Optional<Reasoning> = rawResponse.reasoning()

    fun reasoningOrThrow(): Reasoning = rawResponse.reasoningOrThrow()

    /** @see Response.safetyIdentifier */
    fun safetyIdentifier(): Optional<String> = rawResponse.safetyIdentifier()

    fun safetyIdentifierOrThrow(): String = rawResponse.safetyIdentifierOrThrow()

    /** @see Response.serviceTier */
    fun serviceTier(): Optional<Response.ServiceTier> = rawResponse.serviceTier()

    fun serviceTierOrThrow(): Response.ServiceTier = rawResponse.serviceTierOrThrow()

    /** @see Response.status */
    fun status(): Optional<ResponseStatus> = rawResponse.status()

    fun statusOrThrow(): ResponseStatus = rawResponse.statusOrThrow()

    /** @see Response.text */
    fun text(): Optional<ResponseTextConfig> = rawResponse.text()

    fun textOrThrow(): ResponseTextConfig = rawResponse.textOrThrow()

    /** @see Response.truncation */
    fun truncation(): Optional<Response.Truncation> = rawResponse.truncation()

    fun truncationOrThrow(): Response.Truncation = rawResponse.truncationOrThrow()

    /** @see Response.usage */
    fun usage(): Optional<ResponseUsage> = rawResponse.usage()

    fun usageOrThrow(): ResponseUsage = rawResponse.usageOrThrow()

    /** @see Response.user */
    fun user(): Optional<String> = rawResponse.user()

    fun userOrThrow(): String = rawResponse.userOrThrow()

    /** @see Response.background */
    fun background(): Optional<Boolean> = rawResponse.background()

    fun backgroundOrThrow(): Boolean = rawResponse.backgroundOrThrow()

    /** @see Response.completedAt */
    fun completedAt(): Optional<Double> = rawResponse.completedAt()

    fun completedAtOrThrow(): Double = rawResponse.completedAtOrThrow()

    /** @see Response.conversation */
    fun conversation(): Optional<Response.Conversation> = rawResponse.conversation()

    fun conversationOrThrow(): Response.Conversation = rawResponse.conversationOrThrow()

    /** @see Response.image */
    fun image(): Optional<Response.Image> = rawResponse.image()

    fun imageOrThrow(): Response.Image = rawResponse.imageOrThrow()

    /** @see Response.inputTransformations */
    fun inputTransformations(): Optional<List<Response.InputTransformation>> =
        rawResponse.inputTransformations()

    fun inputTransformationsOrThrow(): List<Response.InputTransformation> =
        rawResponse.inputTransformationsOrThrow()

    /** @see Response._id */
    fun _id(): JsonField<String> = rawResponse._id()

    /** @see Response._createdAt */
    fun _createdAt(): JsonField<Double> = rawResponse._createdAt()

    /** @see Response._error */
    fun _error(): JsonField<ResponseError> = rawResponse._error()

    /** @see Response._incompleteDetails */
    fun _incompleteDetails(): JsonField<Response.IncompleteDetails> =
        rawResponse._incompleteDetails()

    /** @see Response._instructions */
    fun _instructions(): JsonField<Response.Instructions> = rawResponse._instructions()

    /** @see Response._metadata */
    fun _metadata(): JsonField<Response.Metadata> = rawResponse._metadata()

    /** @see Response._model */
    fun _model(): JsonField<ResponsesModel> = rawResponse._model()

    /** @see Response._moderation */
    fun _moderation(): JsonField<Response.Moderation> = rawResponse._moderation()

    /** @see Response._output */
    fun _output(): JsonField<List<StructuredResponseOutputItem<T>>> = output

    /** @see Response._parallelToolCalls */
    fun _parallelToolCalls(): JsonField<Boolean> = rawResponse._parallelToolCalls()

    /** @see Response._temperature */
    fun _temperature(): JsonField<Double> = rawResponse._temperature()

    /** @see Response._toolChoice */
    fun _toolChoice(): JsonField<Response.ToolChoice> = rawResponse._toolChoice()

    /** @see Response._tools */
    fun _tools(): JsonField<List<Tool>> = rawResponse._tools()

    /** @see Response._topP */
    fun _topP(): JsonField<Double> = rawResponse._topP()

    /** @see Response._maxToolCalls */
    fun _maxToolCalls(): JsonField<Long> = rawResponse._maxToolCalls()

    /** @see Response._topLogprobs */
    fun _topLogprobs(): JsonField<Long> = rawResponse._topLogprobs()

    /** @see Response._maxOutputTokens */
    fun _maxOutputTokens(): JsonField<Long> = rawResponse._maxOutputTokens()

    /** @see Response._previousResponseId */
    fun _previousResponseId(): JsonField<String> = rawResponse._previousResponseId()

    /** @see Response._prompt */
    fun _prompt(): JsonField<ResponsePrompt> = rawResponse._prompt()

    /** @see Response._promptCacheDiagnostics */
    fun _promptCacheDiagnostics(): JsonField<Response.PromptCacheDiagnostics> =
        rawResponse._promptCacheDiagnostics()

    /** @see Response._promptCacheKey */
    fun _promptCacheKey(): JsonField<String> = rawResponse._promptCacheKey()

    /** @see Response._promptCacheOptions */
    fun _promptCacheOptions(): JsonField<Response.PromptCacheOptions> =
        rawResponse._promptCacheOptions()

    /** @see Response._promptCacheRetention */
    fun _promptCacheRetention(): JsonField<Response.PromptCacheRetention> =
        rawResponse._promptCacheRetention()

    /** @see Response._reasoning */
    fun _reasoning(): JsonField<Reasoning> = rawResponse._reasoning()

    /** @see Response._safetyIdentifier */
    fun _safetyIdentifier(): JsonField<String> = rawResponse._safetyIdentifier()

    /** @see Response._serviceTier */
    fun _serviceTier(): JsonField<Response.ServiceTier> = rawResponse._serviceTier()

    /** @see Response._status */
    fun _status(): JsonField<ResponseStatus> = rawResponse._status()

    /** @see Response._text */
    fun _text(): JsonField<ResponseTextConfig> = rawResponse._text()

    /** @see Response._truncation */
    fun _truncation(): JsonField<Response.Truncation> = rawResponse._truncation()

    /** @see Response._usage */
    fun _usage(): JsonField<ResponseUsage> = rawResponse._usage()

    /** @see Response._user */
    fun _user(): JsonField<String> = rawResponse._user()

    /** @see Response._background */
    fun _background(): JsonField<Boolean> = rawResponse._background()

    /** @see Response._completedAt */
    fun _completedAt(): JsonField<Double> = rawResponse._completedAt()

    /** @see Response._conversation() */
    fun _conversation(): JsonField<Response.Conversation> = rawResponse._conversation()

    /** @see Response._image */
    fun _image(): JsonField<Response.Image> = rawResponse._image()

    /** @see Response._inputTransformations */
    fun _inputTransformations(): JsonField<List<Response.InputTransformation>> =
        rawResponse._inputTransformations()

    /** @see Response._allProperties */
    fun _allProperties(): Map<String, JsonValue> = rawResponse._allProperties()

    /** @see Response.validate */
    fun validate(): StructuredResponse<T> = apply {
        outputOrThrow().forEach { it.validate() }
        rawResponse.validate()
    }

    /** @see Response.isValid */
    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        return other is StructuredResponse<*> &&
            responseType == other.responseType &&
            rawResponse == other.rawResponse
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawResponse) }

    override fun hashCode(): Int = hashCode

    override fun toString(): String =
        "${javaClass.simpleName}{responseType=$responseType, rawResponse=$rawResponse}"
}
