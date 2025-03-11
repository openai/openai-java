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

/** Emitted when refusal text is finalized. */
@NoAutoDetect
class ResponseRefusalDoneEvent
@JsonCreator
private constructor(
    @JsonProperty("content_index")
    @ExcludeMissing
    private val contentIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("refusal")
    @ExcludeMissing
    private val refusal: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part that the refusal text is finalized. */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /** The ID of the output item that the refusal text is finalized. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item that the refusal text is finalized. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The refusal text that is finalized. */
    fun refusal(): String = refusal.getRequired("refusal")

    /** The type of the event. Always `response.refusal.done`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The index of the content part that the refusal text is finalized. */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /** The ID of the output item that the refusal text is finalized. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item that the refusal text is finalized. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /** The refusal text that is finalized. */
    @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseRefusalDoneEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        itemId()
        outputIndex()
        refusal()
        _type().let {
            if (it != JsonValue.from("response.refusal.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseRefusalDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * .refusal()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseRefusalDoneEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var refusal: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.refusal.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseRefusalDoneEvent: ResponseRefusalDoneEvent) = apply {
            contentIndex = responseRefusalDoneEvent.contentIndex
            itemId = responseRefusalDoneEvent.itemId
            outputIndex = responseRefusalDoneEvent.outputIndex
            refusal = responseRefusalDoneEvent.refusal
            type = responseRefusalDoneEvent.type
            additionalProperties = responseRefusalDoneEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part that the refusal text is finalized. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /** The index of the content part that the refusal text is finalized. */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the refusal text is finalized. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the output item that the refusal text is finalized. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the refusal text is finalized. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the refusal text is finalized. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The refusal text that is finalized. */
        fun refusal(refusal: String) = refusal(JsonField.of(refusal))

        /** The refusal text that is finalized. */
        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

        /** The type of the event. Always `response.refusal.done`. */
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

        fun build(): ResponseRefusalDoneEvent =
            ResponseRefusalDoneEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("refusal", refusal),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseRefusalDoneEvent && contentIndex == other.contentIndex && itemId == other.itemId && outputIndex == other.outputIndex && refusal == other.refusal && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(contentIndex, itemId, outputIndex, refusal, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseRefusalDoneEvent{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, refusal=$refusal, type=$type, additionalProperties=$additionalProperties}"
}
