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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/** Emitted when a partial image is available during image generation streaming. */
class ResponseImageGenCallPartialImageEvent
private constructor(
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val partialImageB64: JsonField<String>,
    private val partialImageIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("partial_image_b64")
        @ExcludeMissing
        partialImageB64: JsonField<String> = JsonMissing.of(),
        @JsonProperty("partial_image_index")
        @ExcludeMissing
        partialImageIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(
        itemId,
        outputIndex,
        partialImageB64,
        partialImageIndex,
        sequenceNumber,
        type,
        mutableMapOf(),
    )

    /**
     * The unique identifier of the image generation item being processed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item in the response's output array.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * Base64-encoded partial image data, suitable for rendering as an image.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun partialImageB64(): String = partialImageB64.getRequired("partial_image_b64")

    /**
     * 0-based index for the partial image (backend is 1-based, but this is 0-based for the user).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun partialImageIndex(): Long = partialImageIndex.getRequired("partial_image_index")

    /**
     * The sequence number of the image generation item being processed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The type of the event. Always 'response.image_generation_call.partial_image'.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.image_generation_call.partial_image")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
     * Returns the raw JSON value of [partialImageB64].
     *
     * Unlike [partialImageB64], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("partial_image_b64")
    @ExcludeMissing
    fun _partialImageB64(): JsonField<String> = partialImageB64

    /**
     * Returns the raw JSON value of [partialImageIndex].
     *
     * Unlike [partialImageIndex], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("partial_image_index")
    @ExcludeMissing
    fun _partialImageIndex(): JsonField<Long> = partialImageIndex

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseImageGenCallPartialImageEvent].
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .partialImageB64()
         * .partialImageIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseImageGenCallPartialImageEvent]. */
    class Builder internal constructor() {

        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var partialImageB64: JsonField<String>? = null
        private var partialImageIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.image_generation_call.partial_image")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseImageGenCallPartialImageEvent: ResponseImageGenCallPartialImageEvent
        ) = apply {
            itemId = responseImageGenCallPartialImageEvent.itemId
            outputIndex = responseImageGenCallPartialImageEvent.outputIndex
            partialImageB64 = responseImageGenCallPartialImageEvent.partialImageB64
            partialImageIndex = responseImageGenCallPartialImageEvent.partialImageIndex
            sequenceNumber = responseImageGenCallPartialImageEvent.sequenceNumber
            type = responseImageGenCallPartialImageEvent.type
            additionalProperties =
                responseImageGenCallPartialImageEvent.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the image generation item being processed. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item in the response's output array. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** Base64-encoded partial image data, suitable for rendering as an image. */
        fun partialImageB64(partialImageB64: String) =
            partialImageB64(JsonField.of(partialImageB64))

        /**
         * Sets [Builder.partialImageB64] to an arbitrary JSON value.
         *
         * You should usually call [Builder.partialImageB64] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun partialImageB64(partialImageB64: JsonField<String>) = apply {
            this.partialImageB64 = partialImageB64
        }

        /**
         * 0-based index for the partial image (backend is 1-based, but this is 0-based for the
         * user).
         */
        fun partialImageIndex(partialImageIndex: Long) =
            partialImageIndex(JsonField.of(partialImageIndex))

        /**
         * Sets [Builder.partialImageIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.partialImageIndex] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun partialImageIndex(partialImageIndex: JsonField<Long>) = apply {
            this.partialImageIndex = partialImageIndex
        }

        /** The sequence number of the image generation item being processed. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.image_generation_call.partial_image")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ResponseImageGenCallPartialImageEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .itemId()
         * .outputIndex()
         * .partialImageB64()
         * .partialImageIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseImageGenCallPartialImageEvent =
            ResponseImageGenCallPartialImageEvent(
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("partialImageB64", partialImageB64),
                checkRequired("partialImageIndex", partialImageIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseImageGenCallPartialImageEvent = apply {
        if (validated) {
            return@apply
        }

        itemId()
        outputIndex()
        partialImageB64()
        partialImageIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.image_generation_call.partial_image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
            (if (partialImageB64.asKnown().isPresent) 1 else 0) +
            (if (partialImageIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("response.image_generation_call.partial_image")) 1 else 0
            }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseImageGenCallPartialImageEvent &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            partialImageB64 == other.partialImageB64 &&
            partialImageIndex == other.partialImageIndex &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            itemId,
            outputIndex,
            partialImageB64,
            partialImageIndex,
            sequenceNumber,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseImageGenCallPartialImageEvent{itemId=$itemId, outputIndex=$outputIndex, partialImageB64=$partialImageB64, partialImageIndex=$partialImageIndex, sequenceNumber=$sequenceNumber, type=$type, additionalProperties=$additionalProperties}"
}
