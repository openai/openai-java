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

/** Emitted when the code interpreter call is completed. */
@NoAutoDetect
class ResponseCodeInterpreterCallCompletedEvent
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

    /** A tool call to run code. */
    fun codeInterpreterCall(): ResponseCodeInterpreterToolCall =
        codeInterpreterCall.getRequired("code_interpreter_call")

    /** The index of the output item that the code interpreter call is in progress. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.code_interpreter_call.completed`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** A tool call to run code. */
    @JsonProperty("code_interpreter_call")
    @ExcludeMissing
    fun _codeInterpreterCall(): JsonField<ResponseCodeInterpreterToolCall> = codeInterpreterCall

    /** The index of the output item that the code interpreter call is in progress. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseCodeInterpreterCallCompletedEvent = apply {
        if (validated) {
            return@apply
        }

        codeInterpreterCall().validate()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.code_interpreter_call.completed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseCodeInterpreterCallCompletedEvent].
         *
         * The following fields are required:
         * ```java
         * .codeInterpreterCall()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCodeInterpreterCallCompletedEvent]. */
    class Builder internal constructor() {

        private var codeInterpreterCall: JsonField<ResponseCodeInterpreterToolCall>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.code_interpreter_call.completed")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseCodeInterpreterCallCompletedEvent: ResponseCodeInterpreterCallCompletedEvent
        ) = apply {
            codeInterpreterCall = responseCodeInterpreterCallCompletedEvent.codeInterpreterCall
            outputIndex = responseCodeInterpreterCallCompletedEvent.outputIndex
            type = responseCodeInterpreterCallCompletedEvent.type
            additionalProperties =
                responseCodeInterpreterCallCompletedEvent.additionalProperties.toMutableMap()
        }

        /** A tool call to run code. */
        fun codeInterpreterCall(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            codeInterpreterCall(JsonField.of(codeInterpreterCall))

        /** A tool call to run code. */
        fun codeInterpreterCall(codeInterpreterCall: JsonField<ResponseCodeInterpreterToolCall>) =
            apply {
                this.codeInterpreterCall = codeInterpreterCall
            }

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.code_interpreter_call.completed`. */
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

        fun build(): ResponseCodeInterpreterCallCompletedEvent =
            ResponseCodeInterpreterCallCompletedEvent(
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

        return /* spotless:off */ other is ResponseCodeInterpreterCallCompletedEvent && codeInterpreterCall == other.codeInterpreterCall && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(codeInterpreterCall, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCodeInterpreterCallCompletedEvent{codeInterpreterCall=$codeInterpreterCall, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
