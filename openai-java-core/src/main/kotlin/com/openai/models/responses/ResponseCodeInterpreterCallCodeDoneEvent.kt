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

/** Emitted when code snippet output is finalized by the code interpreter. */
@NoAutoDetect
class ResponseCodeInterpreterCallCodeDoneEvent
@JsonCreator
private constructor(
    @JsonProperty("code") @ExcludeMissing private val code: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The final code snippet output by the code interpreter. */
    fun code(): String = code.getRequired("code")

    /** The index of the output item that the code interpreter call is in progress. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.code_interpreter_call.code.done`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The final code snippet output by the code interpreter. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /** The index of the output item that the code interpreter call is in progress. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseCodeInterpreterCallCodeDoneEvent = apply {
        if (validated) {
            return@apply
        }

        code()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.code_interpreter_call.code.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseCodeInterpreterCallCodeDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCodeInterpreterCallCodeDoneEvent]. */
    class Builder internal constructor() {

        private var code: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.code_interpreter_call.code.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseCodeInterpreterCallCodeDoneEvent: ResponseCodeInterpreterCallCodeDoneEvent
        ) = apply {
            code = responseCodeInterpreterCallCodeDoneEvent.code
            outputIndex = responseCodeInterpreterCallCodeDoneEvent.outputIndex
            type = responseCodeInterpreterCallCodeDoneEvent.type
            additionalProperties =
                responseCodeInterpreterCallCodeDoneEvent.additionalProperties.toMutableMap()
        }

        /** The final code snippet output by the code interpreter. */
        fun code(code: String) = code(JsonField.of(code))

        /** The final code snippet output by the code interpreter. */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.code_interpreter_call.code.done`. */
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

        fun build(): ResponseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent(
                checkRequired("code", code),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCodeInterpreterCallCodeDoneEvent && code == other.code && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(code, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCodeInterpreterCallCodeDoneEvent{code=$code, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
