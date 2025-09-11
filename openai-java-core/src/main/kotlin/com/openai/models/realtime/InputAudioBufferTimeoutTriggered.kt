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
 * Returned when the Server VAD timeout is triggered for the input audio buffer. This is configured
 * with `idle_timeout_ms` in the `turn_detection` settings of the session, and it indicates that
 * there hasn't been any speech detected for the configured duration.
 *
 * The `audio_start_ms` and `audio_end_ms` fields indicate the segment of audio after the last model
 * response up to the triggering time, as an offset from the beginning of audio written to the input
 * audio buffer. This means it demarcates the segment of audio that was silent and the difference
 * between the start and end values will roughly match the configured timeout.
 *
 * The empty audio will be committed to the conversation as an `input_audio` item (there will be a
 * `input_audio_buffer.committed` event) and a model response will be generated. There may be speech
 * that didn't trigger VAD but is still detected by the model, so the model may respond with
 * something relevant to the conversation or a prompt to continue speaking.
 */
class InputAudioBufferTimeoutTriggered
private constructor(
    private val audioEndMs: JsonField<Long>,
    private val audioStartMs: JsonField<Long>,
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
        @JsonProperty("audio_start_ms")
        @ExcludeMissing
        audioStartMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(audioEndMs, audioStartMs, eventId, itemId, type, mutableMapOf())

    /**
     * Millisecond offset of audio written to the input audio buffer at the time the timeout was
     * triggered.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audioEndMs(): Long = audioEndMs.getRequired("audio_end_ms")

    /**
     * Millisecond offset of audio written to the input audio buffer that was after the playback
     * time of the last model response.
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
     * The ID of the item associated with this segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The event type, must be `input_audio_buffer.timeout_triggered`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_audio_buffer.timeout_triggered")
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
         * [InputAudioBufferTimeoutTriggered].
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .audioStartMs()
         * .eventId()
         * .itemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputAudioBufferTimeoutTriggered]. */
    class Builder internal constructor() {

        private var audioEndMs: JsonField<Long>? = null
        private var audioStartMs: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_audio_buffer.timeout_triggered")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered) =
            apply {
                audioEndMs = inputAudioBufferTimeoutTriggered.audioEndMs
                audioStartMs = inputAudioBufferTimeoutTriggered.audioStartMs
                eventId = inputAudioBufferTimeoutTriggered.eventId
                itemId = inputAudioBufferTimeoutTriggered.itemId
                type = inputAudioBufferTimeoutTriggered.type
                additionalProperties =
                    inputAudioBufferTimeoutTriggered.additionalProperties.toMutableMap()
            }

        /**
         * Millisecond offset of audio written to the input audio buffer at the time the timeout was
         * triggered.
         */
        fun audioEndMs(audioEndMs: Long) = audioEndMs(JsonField.of(audioEndMs))

        /**
         * Sets [Builder.audioEndMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioEndMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audioEndMs(audioEndMs: JsonField<Long>) = apply { this.audioEndMs = audioEndMs }

        /**
         * Millisecond offset of audio written to the input audio buffer that was after the playback
         * time of the last model response.
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

        /** The ID of the item associated with this segment. */
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
         * JsonValue.from("input_audio_buffer.timeout_triggered")
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
         * Returns an immutable instance of [InputAudioBufferTimeoutTriggered].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audioEndMs()
         * .audioStartMs()
         * .eventId()
         * .itemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputAudioBufferTimeoutTriggered =
            InputAudioBufferTimeoutTriggered(
                checkRequired("audioEndMs", audioEndMs),
                checkRequired("audioStartMs", audioStartMs),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InputAudioBufferTimeoutTriggered = apply {
        if (validated) {
            return@apply
        }

        audioEndMs()
        audioStartMs()
        eventId()
        itemId()
        _type().let {
            if (it != JsonValue.from("input_audio_buffer.timeout_triggered")) {
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
            (if (audioStartMs.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_audio_buffer.timeout_triggered")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputAudioBufferTimeoutTriggered &&
            audioEndMs == other.audioEndMs &&
            audioStartMs == other.audioStartMs &&
            eventId == other.eventId &&
            itemId == other.itemId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(audioEndMs, audioStartMs, eventId, itemId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputAudioBufferTimeoutTriggered{audioEndMs=$audioEndMs, audioStartMs=$audioStartMs, eventId=$eventId, itemId=$itemId, type=$type, additionalProperties=$additionalProperties}"
}
