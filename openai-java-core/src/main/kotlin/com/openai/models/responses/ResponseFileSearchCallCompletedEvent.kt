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

/** Emitted when a file search call is completed (results found). */
@NoAutoDetect
class ResponseFileSearchCallCompletedEvent
@JsonCreator
private constructor(
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the output item that the file search call is initiated. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item that the file search call is initiated. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.file_search_call.completed`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The ID of the output item that the file search call is initiated. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item that the file search call is initiated. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFileSearchCallCompletedEvent = apply {
        if (validated) {
            return@apply
        }

        itemId()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.file_search_call.completed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseFileSearchCallCompletedEvent].
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFileSearchCallCompletedEvent]. */
    class Builder internal constructor() {

        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.file_search_call.completed")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseFileSearchCallCompletedEvent: ResponseFileSearchCallCompletedEvent
        ) = apply {
            itemId = responseFileSearchCallCompletedEvent.itemId
            outputIndex = responseFileSearchCallCompletedEvent.outputIndex
            type = responseFileSearchCallCompletedEvent.type
            additionalProperties =
                responseFileSearchCallCompletedEvent.additionalProperties.toMutableMap()
        }

        /** The ID of the output item that the file search call is initiated. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the output item that the file search call is initiated. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the file search call is initiated. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the file search call is initiated. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.file_search_call.completed`. */
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

        fun build(): ResponseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent(
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

        return /* spotless:off */ other is ResponseFileSearchCallCompletedEvent && itemId == other.itemId && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(itemId, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFileSearchCallCompletedEvent{itemId=$itemId, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
