// File generated from our OpenAPI spec by Stainless.

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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Sent by the server when in `server_vad` mode to indicate that speech has been detected in the
 * audio buffer. This can happen any time audio is added to the buffer (unless speech is already
 * detected). The client may want to use this event to interrupt audio playback or provide visual
 * feedback to the user.
 *
 * The client should expect to receive a `input_audio_buffer.speech_stopped` event when speech
 * stops. The `item_id` property is the ID of the user message item that will be created when speech
 * stops and will also be included in the `input_audio_buffer.speech_stopped` event (unless the
 * client manually commits the audio buffer during VAD activation).
 */
class InputAudioBufferSpeechStartedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audioStartMs: JsonField<Long>,
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio_start_ms")
        @ExcludeMissing
        audioStartMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(audioStartMs, eventId, itemId, type, mutableMapOf())

    /**
     * Milliseconds from the start of all audio written to the buffer during the session when speech
     * was first detected. This will correspond to the beginning of audio sent to the model, and
     * thus includes the `prefix_padding_ms` configured in the Session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audioStartMs(): Long = audioStartMs.getRequired("audio_start_ms")

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the user message item that will be created when speech stops.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The event type, must be `input_audio_buffer.speech_started`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_audio_buffer.speech_started")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [audioStartMs].
     *
     * Unlike [audioStartMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio_start_ms")
    @ExcludeMissing
    fun _audioStartMs(): JsonField<Long> = audioStartMs

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
         * [InputAudioBufferSpeechStartedEvent].
         *
         * The following fields are required:
         * ```java
         * .audioStartMs()
         * .eventId()
         * .itemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputAudioBufferSpeechStartedEvent]. */
    class Builder internal constructor() {

        private var audioStartMs: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_audio_buffer.speech_started")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inputAudioBufferSpeechStartedEvent: InputAudioBufferSpeechStartedEvent) =
            apply {
                audioStartMs = inputAudioBufferSpeechStartedEvent.audioStartMs
                eventId = inputAudioBufferSpeechStartedEvent.eventId
                itemId = inputAudioBufferSpeechStartedEvent.itemId
                type = inputAudioBufferSpeechStartedEvent.type
                additionalProperties =
                    inputAudioBufferSpeechStartedEvent.additionalProperties.toMutableMap()
            }

        /**
         * Milliseconds from the start of all audio written to the buffer during the session when
         * speech was first detected. This will correspond to the beginning of audio sent to the
         * model, and thus includes the `prefix_padding_ms` configured in the Session.
         */
        fun audioStartMs(audioStartMs: Long) = audioStartMs(JsonField.of(audioStartMs))

        /**
         * Sets [Builder.audioStartMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioStartMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun audioStartMs(audioStartMs: JsonField<Long>) = apply { this.audioStartMs = audioStartMs }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the user message item that will be created when speech stops. */
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
         * JsonValue.from("input_audio_buffer.speech_started")
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
         * Returns an immutable instance of [InputAudioBufferSpeechStartedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audioStartMs()
         * .eventId()
         * .itemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputAudioBufferSpeechStartedEvent =
            InputAudioBufferSpeechStartedEvent(
                checkRequired("audioStartMs", audioStartMs),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InputAudioBufferSpeechStartedEvent = apply {
        if (validated) {
            return@apply
        }

        audioStartMs()
        eventId()
        itemId()
        _type().let {
            if (it != JsonValue.from("input_audio_buffer.speech_started")) {
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
        (if (audioStartMs.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_audio_buffer.speech_started")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputAudioBufferSpeechStartedEvent &&
            audioStartMs == other.audioStartMs &&
            eventId == other.eventId &&
            itemId == other.itemId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(audioStartMs, eventId, itemId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputAudioBufferSpeechStartedEvent{audioStartMs=$audioStartMs, eventId=$eventId, itemId=$itemId, type=$type, additionalProperties=$additionalProperties}"
}
