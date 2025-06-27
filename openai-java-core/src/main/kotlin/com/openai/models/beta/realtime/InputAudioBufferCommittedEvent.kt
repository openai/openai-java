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

/**
 * Returned when an input audio buffer is committed, either by the client or automatically in server
 * VAD mode. The `item_id` property is the ID of the user message item that will be created, thus a
 * `conversation.item.created` event will also be sent to the client.
 */
class InputAudioBufferCommittedEvent
private constructor(
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val previousItemId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("previous_item_id")
        @ExcludeMissing
        previousItemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, itemId, previousItemId, type, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the user message item that will be created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The ID of the preceding item after which the new item will be inserted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun previousItemId(): String = previousItemId.getRequired("previous_item_id")

    /**
     * The event type, must be `input_audio_buffer.committed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_audio_buffer.committed")
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
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [previousItemId].
     *
     * Unlike [previousItemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("previous_item_id")
    @ExcludeMissing
    fun _previousItemId(): JsonField<String> = previousItemId

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
         * [InputAudioBufferCommittedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * .previousItemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputAudioBufferCommittedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var previousItemId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_audio_buffer.committed")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inputAudioBufferCommittedEvent: InputAudioBufferCommittedEvent) = apply {
            eventId = inputAudioBufferCommittedEvent.eventId
            itemId = inputAudioBufferCommittedEvent.itemId
            previousItemId = inputAudioBufferCommittedEvent.previousItemId
            type = inputAudioBufferCommittedEvent.type
            additionalProperties =
                inputAudioBufferCommittedEvent.additionalProperties.toMutableMap()
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

        /** The ID of the user message item that will be created. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The ID of the preceding item after which the new item will be inserted. */
        fun previousItemId(previousItemId: String) = previousItemId(JsonField.of(previousItemId))

        /**
         * Sets [Builder.previousItemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousItemId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousItemId(previousItemId: JsonField<String>) = apply {
            this.previousItemId = previousItemId
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_audio_buffer.committed")
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
         * Returns an immutable instance of [InputAudioBufferCommittedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * .previousItemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputAudioBufferCommittedEvent =
            InputAudioBufferCommittedEvent(
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                checkRequired("previousItemId", previousItemId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InputAudioBufferCommittedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        itemId()
        previousItemId()
        _type().let {
            if (it != JsonValue.from("input_audio_buffer.committed")) {
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (previousItemId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_audio_buffer.committed")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InputAudioBufferCommittedEvent && eventId == other.eventId && itemId == other.itemId && previousItemId == other.previousItemId && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(eventId, itemId, previousItemId, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputAudioBufferCommittedEvent{eventId=$eventId, itemId=$itemId, previousItemId=$previousItemId, type=$type, additionalProperties=$additionalProperties}"
}
