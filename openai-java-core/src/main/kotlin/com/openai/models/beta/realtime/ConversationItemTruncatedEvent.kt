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
 * Returned when an earlier assistant audio message item is truncated by the client with a
 * `conversation.item.truncate` event. This event is used to synchronize the server's understanding
 * of the audio with the client's playback.
 *
 * This action will truncate the audio and remove the server-side text transcript to ensure there is
 * no text in the context that hasn't been heard by the user.
 */
class ConversationItemTruncatedEvent
private constructor(
    private val audioEndMs: JsonField<Long>,
    private val contentIndex: JsonField<Long>,
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio_end_ms")
        @ExcludeMissing
        audioEndMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(audioEndMs, contentIndex, eventId, itemId, type, mutableMapOf())

    /**
     * The duration up to which the audio was truncated, in milliseconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audioEndMs(): Long = audioEndMs.getRequired("audio_end_ms")

    /**
     * The index of the content part that was truncated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the assistant message item that was truncated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The event type, must be `conversation.item.truncated`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("conversation.item.truncated")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [audioEndMs].
     *
     * Unlike [audioEndMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio_end_ms") @ExcludeMissing fun _audioEndMs(): JsonField<Long> = audioEndMs

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

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
         * [ConversationItemTruncatedEvent].
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .contentIndex()
         * .eventId()
         * .itemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemTruncatedEvent]. */
    class Builder internal constructor() {

        private var audioEndMs: JsonField<Long>? = null
        private var contentIndex: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("conversation.item.truncated")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemTruncatedEvent: ConversationItemTruncatedEvent) = apply {
            audioEndMs = conversationItemTruncatedEvent.audioEndMs
            contentIndex = conversationItemTruncatedEvent.contentIndex
            eventId = conversationItemTruncatedEvent.eventId
            itemId = conversationItemTruncatedEvent.itemId
            type = conversationItemTruncatedEvent.type
            additionalProperties =
                conversationItemTruncatedEvent.additionalProperties.toMutableMap()
        }

        /** The duration up to which the audio was truncated, in milliseconds. */
        fun audioEndMs(audioEndMs: Long) = audioEndMs(JsonField.of(audioEndMs))

        /**
         * Sets [Builder.audioEndMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioEndMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audioEndMs(audioEndMs: JsonField<Long>) = apply { this.audioEndMs = audioEndMs }

        /** The index of the content part that was truncated. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the assistant message item that was truncated. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("conversation.item.truncated")
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
         * Returns an immutable instance of [ConversationItemTruncatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .contentIndex()
         * .eventId()
         * .itemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemTruncatedEvent =
            ConversationItemTruncatedEvent(
                checkRequired("audioEndMs", audioEndMs),
                checkRequired("contentIndex", contentIndex),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemTruncatedEvent = apply {
        if (validated) {
            return@apply
        }

        audioEndMs()
        contentIndex()
        eventId()
        itemId()
        _type().let {
            if (it != JsonValue.from("conversation.item.truncated")) {
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
        (if (audioEndMs.asKnown().isPresent) 1 else 0) +
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("conversation.item.truncated")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ConversationItemTruncatedEvent && audioEndMs == other.audioEndMs && contentIndex == other.contentIndex && eventId == other.eventId && itemId == other.itemId && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(audioEndMs, contentIndex, eventId, itemId, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemTruncatedEvent{audioEndMs=$audioEndMs, contentIndex=$contentIndex, eventId=$eventId, itemId=$itemId, type=$type, additionalProperties=$additionalProperties}"
}
