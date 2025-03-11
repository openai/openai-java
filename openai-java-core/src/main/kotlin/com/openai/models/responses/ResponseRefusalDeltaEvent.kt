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

/** Emitted when there is a partial refusal text. */
@NoAutoDetect
class ResponseRefusalDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("content_index")
    @ExcludeMissing
    private val contentIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("delta") @ExcludeMissing private val delta: JsonField<String> = JsonMissing.of(),
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part that the refusal text is added to. */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /** The refusal text that is added. */
    fun delta(): String = delta.getRequired("delta")

    /** The ID of the output item that the refusal text is added to. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item that the refusal text is added to. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.refusal.delta`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The index of the content part that the refusal text is added to. */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /** The refusal text that is added. */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /** The ID of the output item that the refusal text is added to. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item that the refusal text is added to. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseRefusalDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        delta()
        itemId()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.refusal.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseRefusalDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .delta()
         * .itemId()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseRefusalDeltaEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var delta: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.refusal.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseRefusalDeltaEvent: ResponseRefusalDeltaEvent) = apply {
            contentIndex = responseRefusalDeltaEvent.contentIndex
            delta = responseRefusalDeltaEvent.delta
            itemId = responseRefusalDeltaEvent.itemId
            outputIndex = responseRefusalDeltaEvent.outputIndex
            type = responseRefusalDeltaEvent.type
            additionalProperties = responseRefusalDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part that the refusal text is added to. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /** The index of the content part that the refusal text is added to. */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The refusal text that is added. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /** The refusal text that is added. */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The ID of the output item that the refusal text is added to. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the output item that the refusal text is added to. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the refusal text is added to. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the refusal text is added to. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.refusal.delta`. */
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

        fun build(): ResponseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("delta", delta),
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

        return /* spotless:off */ other is ResponseRefusalDeltaEvent && contentIndex == other.contentIndex && delta == other.delta && itemId == other.itemId && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(contentIndex, delta, itemId, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseRefusalDeltaEvent{contentIndex=$contentIndex, delta=$delta, itemId=$itemId, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
