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

/** Emitted when a partial code snippet is added by the code interpreter. */
@NoAutoDetect
class ResponseCodeInterpreterCallCodeDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("delta") @ExcludeMissing private val delta: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The partial code snippet added by the code interpreter. */
    fun delta(): String = delta.getRequired("delta")

    /** The index of the output item that the code interpreter call is in progress. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.code_interpreter_call.code.delta`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The partial code snippet added by the code interpreter. */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /** The index of the output item that the code interpreter call is in progress. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseCodeInterpreterCallCodeDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.code_interpreter_call.code.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseCodeInterpreterCallCodeDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCodeInterpreterCallCodeDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.code_interpreter_call.code.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseCodeInterpreterCallCodeDeltaEvent: ResponseCodeInterpreterCallCodeDeltaEvent
        ) = apply {
            delta = responseCodeInterpreterCallCodeDeltaEvent.delta
            outputIndex = responseCodeInterpreterCallCodeDeltaEvent.outputIndex
            type = responseCodeInterpreterCallCodeDeltaEvent.type
            additionalProperties =
                responseCodeInterpreterCallCodeDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The partial code snippet added by the code interpreter. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /** The partial code snippet added by the code interpreter. */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the code interpreter call is in progress. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.code_interpreter_call.code.delta`. */
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

        fun build(): ResponseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent(
                checkRequired("delta", delta),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCodeInterpreterCallCodeDeltaEvent && delta == other.delta && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(delta, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCodeInterpreterCallCodeDeltaEvent{delta=$delta, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
