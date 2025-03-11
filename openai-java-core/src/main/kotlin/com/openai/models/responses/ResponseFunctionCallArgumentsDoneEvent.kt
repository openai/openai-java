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

/** Emitted when function-call arguments are finalized. */
@NoAutoDetect
class ResponseFunctionCallArgumentsDoneEvent
@JsonCreator
private constructor(
    @JsonProperty("arguments")
    @ExcludeMissing
    private val arguments: JsonField<String> = JsonMissing.of(),
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The function-call arguments. */
    fun arguments(): String = arguments.getRequired("arguments")

    /** The ID of the item. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The function-call arguments. */
    @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

    /** The ID of the item. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFunctionCallArgumentsDoneEvent = apply {
        if (validated) {
            return@apply
        }

        arguments()
        itemId()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.function_call_arguments.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseFunctionCallArgumentsDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .arguments()
         * .itemId()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFunctionCallArgumentsDoneEvent]. */
    class Builder internal constructor() {

        private var arguments: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.function_call_arguments.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseFunctionCallArgumentsDoneEvent: ResponseFunctionCallArgumentsDoneEvent
        ) = apply {
            arguments = responseFunctionCallArgumentsDoneEvent.arguments
            itemId = responseFunctionCallArgumentsDoneEvent.itemId
            outputIndex = responseFunctionCallArgumentsDoneEvent.outputIndex
            type = responseFunctionCallArgumentsDoneEvent.type
            additionalProperties =
                responseFunctionCallArgumentsDoneEvent.additionalProperties.toMutableMap()
        }

        /** The function-call arguments. */
        fun arguments(arguments: String) = arguments(JsonField.of(arguments))

        /** The function-call arguments. */
        fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

        /** The ID of the item. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the item. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

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

        fun build(): ResponseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent(
                checkRequired("arguments", arguments),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFunctionCallArgumentsDoneEvent && arguments == other.arguments && itemId == other.itemId && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(arguments, itemId, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFunctionCallArgumentsDoneEvent{arguments=$arguments, itemId=$itemId, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
