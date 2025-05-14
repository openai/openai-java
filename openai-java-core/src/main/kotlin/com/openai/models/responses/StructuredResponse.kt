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
    fun id(): String = rawResponse.id()

    /** @see Response.createdAt */
    fun createdAt(): Double = rawResponse.createdAt()

    /** @see Response.error */
    fun error(): Optional<ResponseError> = rawResponse.error()

    /** @see Response.incompleteDetails */
    fun incompleteDetails(): Optional<Response.IncompleteDetails> = rawResponse.incompleteDetails()

    /** @see Response.instructions */
    fun instructions(): Optional<String> = rawResponse.instructions()

    /** @see Response.metadata */
    fun metadata(): Optional<Response.Metadata> = rawResponse.metadata()

    /** @see Response.model */
    fun model(): ResponsesModel = rawResponse.model()

    /** @see Response._object_ */
    fun _object_(): JsonValue = rawResponse._object_()

    private val output by lazy {
        rawResponse._output().map { outputs ->
            outputs.map { StructuredResponseOutputItem<T>(responseType, it) }
        }
    }

    /** @see Response.output */
    fun output(): List<StructuredResponseOutputItem<T>> = output.getRequired("output")

    /** @see Response.parallelToolCalls */
    fun parallelToolCalls(): Boolean = rawResponse.parallelToolCalls()

    /** @see Response.temperature */
    fun temperature(): Optional<Double> = rawResponse.temperature()

    /** @see Response.toolChoice */
    fun toolChoice(): Response.ToolChoice = rawResponse.toolChoice()

    /** @see Response.tools */
    fun tools(): List<Tool> = rawResponse.tools()

    /** @see Response.topP */
    fun topP(): Optional<Double> = rawResponse.topP()

    /** @see Response.maxOutputTokens */
    fun maxOutputTokens(): Optional<Long> = rawResponse.maxOutputTokens()

    /** @see Response.previousResponseId */
    fun previousResponseId(): Optional<String> = rawResponse.previousResponseId()

    /** @see Response.reasoning */
    fun reasoning(): Optional<Reasoning> = rawResponse.reasoning()

    /** @see Response.serviceTier */
    fun serviceTier(): Optional<Response.ServiceTier> = rawResponse.serviceTier()

    /** @see Response.status */
    fun status(): Optional<ResponseStatus> = rawResponse.status()

    /** @see Response.text */
    fun text(): Optional<ResponseTextConfig> = rawResponse.text()

    /** @see Response.truncation */
    fun truncation(): Optional<Response.Truncation> = rawResponse.truncation()

    /** @see Response.usage */
    fun usage(): Optional<ResponseUsage> = rawResponse.usage()

    /** @see Response.user */
    fun user(): Optional<String> = rawResponse.user()

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
    fun _instructions(): JsonField<String> = rawResponse._instructions()

    /** @see Response._metadata */
    fun _metadata(): JsonField<Response.Metadata> = rawResponse._metadata()

    /** @see Response._model */
    fun _model(): JsonField<ResponsesModel> = rawResponse._model()

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

    /** @see Response._maxOutputTokens */
    fun _maxOutputTokens(): JsonField<Long> = rawResponse._maxOutputTokens()

    /** @see Response._previousResponseId */
    fun _previousResponseId(): JsonField<String> = rawResponse._previousResponseId()

    /** @see Response._reasoning */
    fun _reasoning(): JsonField<Reasoning> = rawResponse._reasoning()

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

    /** @see Response._additionalProperties */
    fun _additionalProperties(): Map<String, JsonValue> = rawResponse._additionalProperties()

    /** @see Response.validate */
    fun validate(): StructuredResponse<T> = apply {
        output().forEach { it.validate() }
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
