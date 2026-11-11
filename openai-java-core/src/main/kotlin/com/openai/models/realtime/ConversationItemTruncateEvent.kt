// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

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
import java.util.Optional

/**
 * Send this event to truncate a previous assistant message’s audio. The server will produce audio
 * faster than realtime, so this event is useful when the user interrupts to truncate audio that has
 * already been sent to the client but not yet played. This will synchronize the server's
 * understanding of the audio with the client's playback.
 *
 * Truncating audio will delete the server-side text transcript to ensure there is not text in the
 * context that hasn't been heard by the user.
 *
 * If successful, the server will respond with a `conversation.item.truncated` event.
 */
class ConversationItemTruncateEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audioEndMs: JsonField<Long>,
    private val contentIndex: JsonField<Long>,
    private val itemId: JsonField<String>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
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
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(audioEndMs, contentIndex, itemId, type, eventId, mutableMapOf())

    /**
     * Inclusive duration up to which audio is truncated, in milliseconds. If the audio_end_ms is
     * greater than the actual audio duration, the server will respond with an error. The schema
     * requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun audioEndMs(): java.util.Optional<Long> = audioEndMs.getOptional("audio_end_ms")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun audioEndMsOrThrow(): Long = audioEndMs.getRequired("audio_end_ms")

    /**
     * The index of the content part to truncate. Set this to `0`. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun contentIndex(): java.util.Optional<Long> = contentIndex.getOptional("content_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun contentIndexOrThrow(): Long = contentIndex.getRequired("content_index")

    /**
     * The ID of the assistant message item to truncate. Only assistant message items can be
     * truncated. The schema requires this property. Returns empty if the JSON property is missing
     * or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun itemId(): java.util.Optional<String> = itemId.getOptional("item_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun itemIdOrThrow(): String = itemId.getRequired("item_id")

    /**
     * The event type, must be `conversation.item.truncate`. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("conversation.item.truncate")) ->
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
     * Optional client-generated ID used to identify this event. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventId(): java.util.Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventIdOrThrow(): String = eventId.getRequired("event_id")

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
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
            "audio_end_ms" to this.audioEndMs,
            "content_index" to this.contentIndex,
            "item_id" to this.itemId,
            "type" to this.type,
            "event_id" to this.eventId,
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
         * [ConversationItemTruncateEvent].
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .contentIndex()
         * .itemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemTruncateEvent]. */
    class Builder internal constructor() {

        private var audioEndMs: JsonField<Long>? = null
        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("conversation.item.truncate")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemTruncateEvent: ConversationItemTruncateEvent) = apply {
            audioEndMs = conversationItemTruncateEvent.audioEndMs
            contentIndex = conversationItemTruncateEvent.contentIndex
            itemId = conversationItemTruncateEvent.itemId
            type = conversationItemTruncateEvent.type
            eventId = conversationItemTruncateEvent.eventId
            additionalProperties = conversationItemTruncateEvent.additionalProperties.toMutableMap()
        }

        /**
         * Inclusive duration up to which audio is truncated, in milliseconds. If the audio_end_ms
         * is greater than the actual audio duration, the server will respond with an error.
         */
        fun audioEndMs(audioEndMs: Long) = audioEndMs(JsonField.of(audioEndMs))

        /**
         * Sets [Builder.audioEndMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioEndMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audioEndMs(audioEndMs: JsonField<Long>) = apply { this.audioEndMs = audioEndMs }

        /** The index of the content part to truncate. Set this to `0`. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /**
         * The ID of the assistant message item to truncate. Only assistant message items can be
         * truncated.
         */
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
         * JsonValue.from("conversation.item.truncate")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional client-generated ID used to identify this event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

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
         * Returns an immutable instance of [ConversationItemTruncateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .contentIndex()
         * .itemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemTruncateEvent =
            ConversationItemTruncateEvent(
                checkRequired("audioEndMs", audioEndMs),
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                type,
                eventId,
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
    fun validate(): ConversationItemTruncateEvent = apply {
        if (validated) {
            return@apply
        }

        audioEndMsOrThrow()
        contentIndexOrThrow()
        itemIdOrThrow()
        typeOrThrow()
        eventId()
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
            (if (itemId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("conversation.item.truncate")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItemTruncateEvent &&
            audioEndMs == other.audioEndMs &&
            contentIndex == other.contentIndex &&
            itemId == other.itemId &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(audioEndMs, contentIndex, itemId, type, eventId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemTruncateEvent{audioEndMs=$audioEndMs, contentIndex=$contentIndex, itemId=$itemId, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
