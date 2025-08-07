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

/** Event indicating that input for a custom tool call is complete. */
class ResponseCustomToolCallInputDoneEvent
private constructor(
    private val input: JsonField<String>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(input, itemId, outputIndex, sequenceNumber, type, mutableMapOf())

    /**
     * The complete input data for the custom tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): String = input.getRequired("input")

    /**
     * Unique identifier for the API item associated with this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output this event applies to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The sequence number of this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The event type identifier.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.custom_tool_call_input.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

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
         * [ResponseCustomToolCallInputDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCustomToolCallInputDoneEvent]. */
    class Builder internal constructor() {

        private var input: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.custom_tool_call_input.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseCustomToolCallInputDoneEvent: ResponseCustomToolCallInputDoneEvent
        ) = apply {
            input = responseCustomToolCallInputDoneEvent.input
            itemId = responseCustomToolCallInputDoneEvent.itemId
            outputIndex = responseCustomToolCallInputDoneEvent.outputIndex
            sequenceNumber = responseCustomToolCallInputDoneEvent.sequenceNumber
            type = responseCustomToolCallInputDoneEvent.type
            additionalProperties =
                responseCustomToolCallInputDoneEvent.additionalProperties.toMutableMap()
        }

        /** The complete input data for the custom tool call. */
        fun input(input: String) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<String>) = apply { this.input = input }

        /** Unique identifier for the API item associated with this event. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output this event applies to. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.custom_tool_call_input.done")
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
         * Returns an immutable instance of [ResponseCustomToolCallInputDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .itemId()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseCustomToolCallInputDoneEvent =
            ResponseCustomToolCallInputDoneEvent(
                checkRequired("input", input),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseCustomToolCallInputDoneEvent = apply {
        if (validated) {
            return@apply
        }

        input()
        itemId()
        outputIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.custom_tool_call_input.done")) {
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
        (if (input.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.custom_tool_call_input.done")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCustomToolCallInputDoneEvent && input == other.input && itemId == other.itemId && outputIndex == other.outputIndex && sequenceNumber == other.sequenceNumber && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(input, itemId, outputIndex, sequenceNumber, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCustomToolCallInputDoneEvent{input=$input, itemId=$itemId, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, additionalProperties=$additionalProperties}"
}
