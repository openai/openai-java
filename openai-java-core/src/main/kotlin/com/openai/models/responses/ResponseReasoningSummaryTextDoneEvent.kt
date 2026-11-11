// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/** Emitted when a reasoning summary text is completed. */
class ResponseReasoningSummaryTextDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val summaryIndex: JsonField<Long>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("summary_index")
        @ExcludeMissing
        summaryIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(itemId, outputIndex, sequenceNumber, summaryIndex, text, type, mutableMapOf())

    /**
     * The ID of the item this summary text is associated with. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun itemId(): java.util.Optional<String> = itemId.getOptional("item_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun itemIdOrThrow(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item this summary text is associated with. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun outputIndex(): java.util.Optional<Long> = outputIndex.getOptional("output_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun outputIndexOrThrow(): Long = outputIndex.getRequired("output_index")

    /**
     * The sequence number of this event. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun sequenceNumber(): java.util.Optional<Long> = sequenceNumber.getOptional("sequence_number")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun sequenceNumberOrThrow(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The index of the summary part within the reasoning summary. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun summaryIndex(): java.util.Optional<Long> = summaryIndex.getOptional("summary_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun summaryIndexOrThrow(): Long = summaryIndex.getRequired("summary_index")

    /**
     * The full text of the completed reasoning summary. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun text(): java.util.Optional<String> = text.getOptional("text")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun textOrThrow(): String = text.getRequired("text")

    /**
     * The type of the event. Always `response.reasoning_summary_text.done`. The schema requires
     * this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("response.reasoning_summary_text.done")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [summaryIndex].
     *
     * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary_index")
    @ExcludeMissing
    fun _summaryIndex(): JsonField<Long> = summaryIndex

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "item_id" to this.itemId,
            "output_index" to this.outputIndex,
            "sequence_number" to this.sequenceNumber,
            "summary_index" to this.summaryIndex,
            "text" to this.text,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseReasoningSummaryTextDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * .summaryIndex()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseReasoningSummaryTextDoneEvent]. */
    class Builder internal constructor() {

        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var summaryIndex: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.reasoning_summary_text.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseReasoningSummaryTextDoneEvent: ResponseReasoningSummaryTextDoneEvent
        ) = apply {
            itemId = responseReasoningSummaryTextDoneEvent.itemId
            outputIndex = responseReasoningSummaryTextDoneEvent.outputIndex
            sequenceNumber = responseReasoningSummaryTextDoneEvent.sequenceNumber
            summaryIndex = responseReasoningSummaryTextDoneEvent.summaryIndex
            text = responseReasoningSummaryTextDoneEvent.text
            type = responseReasoningSummaryTextDoneEvent.type
            additionalProperties =
                responseReasoningSummaryTextDoneEvent.additionalProperties.toMutableMap()
        }

        /** The ID of the item this summary text is associated with. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item this summary text is associated with. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The sequence number of this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /** The index of the summary part within the reasoning summary. */
        fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

        /**
         * Sets [Builder.summaryIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summaryIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun summaryIndex(summaryIndex: JsonField<Long>) = apply { this.summaryIndex = summaryIndex }

        /** The full text of the completed reasoning summary. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.reasoning_summary_text.done")
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
         * Returns an immutable instance of [ResponseReasoningSummaryTextDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * .summaryIndex()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseReasoningSummaryTextDoneEvent =
            ResponseReasoningSummaryTextDoneEvent(
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                checkRequired("summaryIndex", summaryIndex),
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ResponseReasoningSummaryTextDoneEvent = apply {
        if (validated) {
            return@apply
        }

        itemIdOrThrow()
        outputIndexOrThrow()
        sequenceNumberOrThrow()
        summaryIndexOrThrow()
        textOrThrow()
        typeOrThrow()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            (if (summaryIndex.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.reasoning_summary_text.done")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseReasoningSummaryTextDoneEvent &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            summaryIndex == other.summaryIndex &&
            text == other.text &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            itemId,
            outputIndex,
            sequenceNumber,
            summaryIndex,
            text,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseReasoningSummaryTextDoneEvent{itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, summaryIndex=$summaryIndex, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
