// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Emitted when a code interpreter call is in progress. */
@NoAutoDetect
class ResponseCodeInterpreterCallInProgressEvent
@JsonCreator
private constructor(
    @JsonProperty("code_interpreter_call")
    @ExcludeMissing
    private val codeInterpreterCall: JsonField<ResponseCodeInterpreterToolCall> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * A tool call to run code.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun codeInterpreterCall(): ResponseCodeInterpreterToolCall =
        codeInterpreterCall.getRequired("code_interpreter_call")

    /**
     * The index of the output item that the code interpreter call is in progress.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The type of the event. Always `response.code_interpreter_call.in_progress`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.code_interpreter_call.in_progress")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [codeInterpreterCall].
     *
     * Unlike [codeInterpreterCall], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("code_interpreter_call")
    @ExcludeMissing
    fun _codeInterpreterCall(): JsonField<ResponseCodeInterpreterToolCall> = codeInterpreterCall

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseCodeInterpreterCallInProgressEvent = apply {
        if (validated) {
            return@apply
        }

        codeInterpreterCall().validate()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.code_interpreter_call.in_progress")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseCodeInterpreterCallInProgressEvent].
         *
         * The following fields are required:
         * ```java
         * .codeInterpreterCall()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCodeInterpreterCallInProgressEvent]. */
    class Builder internal constructor() {

        private var codeInterpreterCall: JsonField<ResponseCodeInterpreterToolCall>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.code_interpreter_call.in_progress")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseCodeInterpreterCallInProgressEvent: ResponseCodeInterpreterCallInProgressEvent
        ) = apply {
            codeInterpreterCall = responseCodeInterpreterCallInProgressEvent.codeInterpreterCall
            outputIndex = responseCodeInterpreterCallInProgressEvent.outputIndex
            type = responseCodeInterpreterCallInProgressEvent.type
            additionalProperties =
                responseCodeInterpreterCallInProgressEvent.additionalProperties.toMutableMap()
        }

        /** A tool call to run code. */
        fun codeInterpreterCall(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            codeInterpreterCall(JsonField.of(codeInterpreterCall))

        /**
         * Sets [Builder.codeInterpreterCall] to an arbitrary JSON value.
         *
         * You should usually call [Builder.codeInterpreterCall] with a well-typed
         * [ResponseCodeInterpreterToolCall] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun codeInterpreterCall(codeInterpreterCall: JsonField<ResponseCodeInterpreterToolCall>) =
            apply {
                this.codeInterpreterCall = codeInterpreterCall
            }

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.code_interpreter_call.in_progress")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [ResponseCodeInterpreterCallInProgressEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .codeInterpreterCall()
         * .outputIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseCodeInterpreterCallInProgressEvent =
            ResponseCodeInterpreterCallInProgressEvent(
                checkRequired("codeInterpreterCall", codeInterpreterCall),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCodeInterpreterCallInProgressEvent && codeInterpreterCall == other.codeInterpreterCall && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(codeInterpreterCall, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCodeInterpreterCallInProgressEvent{codeInterpreterCall=$codeInterpreterCall, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
