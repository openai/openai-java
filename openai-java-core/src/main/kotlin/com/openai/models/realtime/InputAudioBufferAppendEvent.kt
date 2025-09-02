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
import java.util.Optional

/**
 * Send this event to append audio bytes to the input audio buffer. The audio buffer is temporary
 * storage you can write to and later commit. In Server VAD mode, the audio buffer is used to detect
 * speech and the server will decide when to commit. When Server VAD is disabled, you must commit
 * the audio buffer manually.
 *
 * The client may choose how much audio to place in each event up to a maximum of 15 MiB, for
 * example streaming smaller chunks from the client may allow the VAD to be more responsive. Unlike
 * made other client events, the server will not send a confirmation response to this event.
 */
class InputAudioBufferAppendEvent
private constructor(
    private val audio: JsonField<String>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(audio, type, eventId, mutableMapOf())

    /**
     * Base64-encoded audio bytes. This must be in the format specified by the `input_audio_format`
     * field in the session configuration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audio(): String = audio.getRequired("audio")

    /**
     * The event type, must be `input_audio_buffer.append`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_audio_buffer.append")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client-generated ID used to identify this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<String> = audio

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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InputAudioBufferAppendEvent].
         *
         * The following fields are required:
         * ```java
         * .audio()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputAudioBufferAppendEvent]. */
    class Builder internal constructor() {

        private var audio: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_audio_buffer.append")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inputAudioBufferAppendEvent: InputAudioBufferAppendEvent) = apply {
            audio = inputAudioBufferAppendEvent.audio
            type = inputAudioBufferAppendEvent.type
            eventId = inputAudioBufferAppendEvent.eventId
            additionalProperties = inputAudioBufferAppendEvent.additionalProperties.toMutableMap()
        }

        /**
         * Base64-encoded audio bytes. This must be in the format specified by the
         * `input_audio_format` field in the session configuration.
         */
        fun audio(audio: String) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<String>) = apply { this.audio = audio }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_audio_buffer.append")
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
         * Returns an immutable instance of [InputAudioBufferAppendEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .audio()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputAudioBufferAppendEvent =
            InputAudioBufferAppendEvent(
                checkRequired("audio", audio),
                type,
                eventId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InputAudioBufferAppendEvent = apply {
        if (validated) {
            return@apply
        }

        audio()
        _type().let {
            if (it != JsonValue.from("input_audio_buffer.append")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (if (audio.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_audio_buffer.append")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputAudioBufferAppendEvent &&
            audio == other.audio &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(audio, type, eventId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputAudioBufferAppendEvent{audio=$audio, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
