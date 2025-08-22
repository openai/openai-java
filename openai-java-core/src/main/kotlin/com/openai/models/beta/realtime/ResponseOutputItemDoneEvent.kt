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
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when an Item is done streaming. Also emitted when a Response is interrupted, incomplete,
 * or cancelled.
 */
class ResponseOutputItemDoneEvent
private constructor(
    private val eventId: JsonField<String>,
    private val item: JsonField<ConversationItem>,
    private val outputIndex: JsonField<Long>,
    private val responseId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item") @ExcludeMissing item: JsonField<ConversationItem> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, item, outputIndex, responseId, type, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The item to add to the conversation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): ConversationItem = item.getRequired("item")

    /**
     * The index of the output item in the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The ID of the Response to which the item belongs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseId(): String = responseId.getRequired("response_id")

    /**
     * The event type, must be `response.output_item.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.output_item.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ConversationItem> = item

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
         * Returns a mutable builder for constructing an instance of [ResponseOutputItemDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * .outputIndex()
         * .responseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseOutputItemDoneEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var item: JsonField<ConversationItem>? = null
        private var outputIndex: JsonField<Long>? = null
        private var responseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.output_item.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseOutputItemDoneEvent: ResponseOutputItemDoneEvent) = apply {
            eventId = responseOutputItemDoneEvent.eventId
            item = responseOutputItemDoneEvent.item
            outputIndex = responseOutputItemDoneEvent.outputIndex
            responseId = responseOutputItemDoneEvent.responseId
            type = responseOutputItemDoneEvent.type
            additionalProperties = responseOutputItemDoneEvent.additionalProperties.toMutableMap()
        }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The item to add to the conversation. */
        fun item(item: ConversationItem) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [ConversationItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun item(item: JsonField<ConversationItem>) = apply { this.item = item }

        /** The index of the output item in the Response. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The ID of the Response to which the item belongs. */
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
         * JsonValue.from("response.output_item.done")
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
         * Returns an immutable instance of [ResponseOutputItemDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * .outputIndex()
         * .responseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent(
                checkRequired("eventId", eventId),
                checkRequired("item", item),
                checkRequired("outputIndex", outputIndex),
                checkRequired("responseId", responseId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseOutputItemDoneEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        item().validate()
        outputIndex()
        responseId()
        _type().let {
            if (it != JsonValue.from("response.output_item.done")) {
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (item.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.output_item.done")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseOutputItemDoneEvent &&
            eventId == other.eventId &&
            item == other.item &&
            outputIndex == other.outputIndex &&
            responseId == other.responseId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, item, outputIndex, responseId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseOutputItemDoneEvent{eventId=$eventId, item=$item, outputIndex=$outputIndex, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
}
