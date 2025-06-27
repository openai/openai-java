// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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

/** Returned when the model-generated function call arguments are updated. */
class ResponseFunctionCallArgumentsDeltaEvent
private constructor(
    private val callId: JsonField<String>,
    private val delta: JsonField<String>,
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val responseId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(callId, delta, eventId, itemId, outputIndex, responseId, type, mutableMapOf())

    /**
     * The ID of the function call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callId(): String = callId.getRequired("call_id")

    /**
     * The arguments delta as a JSON string.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): String = delta.getRequired("delta")

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the function call item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item in the response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The ID of the response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseId(): String = responseId.getRequired("response_id")

    /**
     * The event type, must be `response.function_call_arguments.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.function_call_arguments.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [callId].
     *
     * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

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
         * [ResponseFunctionCallArgumentsDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .callId()
         * .delta()
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .responseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFunctionCallArgumentsDeltaEvent]. */
    class Builder internal constructor() {

        private var callId: JsonField<String>? = null
        private var delta: JsonField<String>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var responseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.function_call_arguments.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseFunctionCallArgumentsDeltaEvent: ResponseFunctionCallArgumentsDeltaEvent
        ) = apply {
            callId = responseFunctionCallArgumentsDeltaEvent.callId
            delta = responseFunctionCallArgumentsDeltaEvent.delta
            eventId = responseFunctionCallArgumentsDeltaEvent.eventId
            itemId = responseFunctionCallArgumentsDeltaEvent.itemId
            outputIndex = responseFunctionCallArgumentsDeltaEvent.outputIndex
            responseId = responseFunctionCallArgumentsDeltaEvent.responseId
            type = responseFunctionCallArgumentsDeltaEvent.type
            additionalProperties =
                responseFunctionCallArgumentsDeltaEvent.additionalProperties.toMutableMap()
        }

        /** The ID of the function call. */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /**
         * Sets [Builder.callId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /** The arguments delta as a JSON string. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the function call item. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item in the response. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The ID of the response. */
        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.function_call_arguments.delta")
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
         * Returns an immutable instance of [ResponseFunctionCallArgumentsDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .callId()
         * .delta()
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .responseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent(
                checkRequired("callId", callId),
                checkRequired("delta", delta),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("responseId", responseId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseFunctionCallArgumentsDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        callId()
        delta()
        eventId()
        itemId()
        outputIndex()
        responseId()
        _type().let {
            if (it != JsonValue.from("response.function_call_arguments.delta")) {
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
        (if (callId.asKnown().isPresent) 1 else 0) +
            (if (delta.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("response.function_call_arguments.delta")) 1 else 0
            }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFunctionCallArgumentsDeltaEvent && callId == other.callId && delta == other.delta && eventId == other.eventId && itemId == other.itemId && outputIndex == other.outputIndex && responseId == other.responseId && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(callId, delta, eventId, itemId, outputIndex, responseId, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFunctionCallArgumentsDeltaEvent{callId=$callId, delta=$delta, eventId=$eventId, itemId=$itemId, outputIndex=$outputIndex, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
}
