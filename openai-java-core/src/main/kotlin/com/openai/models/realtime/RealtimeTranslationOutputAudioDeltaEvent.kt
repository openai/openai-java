// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when translated output audio is available. Output audio deltas are 200 ms frames of
 * PCM16 audio.
 */
class RealtimeTranslationOutputAudioDeltaEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delta: JsonField<String>,
    private val eventId: JsonField<String>,
    private val type: JsonValue,
    private val channels: JsonField<Long>,
    private val elapsedMs: JsonField<Long>,
    private val format: JsonField<Format>,
    private val sampleRate: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("channels") @ExcludeMissing channels: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("elapsed_ms") @ExcludeMissing elapsedMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
        @JsonProperty("sample_rate") @ExcludeMissing sampleRate: JsonField<Long> = JsonMissing.of(),
    ) : this(delta, eventId, type, channels, elapsedMs, format, sampleRate, mutableMapOf())

    /**
     * Base64-encoded translated audio data.
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
     * The event type, must be `session.output_audio.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.output_audio.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Number of audio channels.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channels(): Optional<Long> = channels.getOptional("channels")

    /**
     * Timing metadata for stream alignment, derived from the translation frame when available.
     * Treat `elapsed_ms` as alignment metadata, not a unique event identifier.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun elapsedMs(): Optional<Long> = elapsedMs.getOptional("elapsed_ms")

    /**
     * Audio encoding for `delta`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<Format> = format.getOptional("format")

    /**
     * Sample rate of the audio delta.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sampleRate(): Optional<Long> = sampleRate.getOptional("sample_rate")

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
     * Returns the raw JSON value of [channels].
     *
     * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channels") @ExcludeMissing fun _channels(): JsonField<Long> = channels

    /**
     * Returns the raw JSON value of [elapsedMs].
     *
     * Unlike [elapsedMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("elapsed_ms") @ExcludeMissing fun _elapsedMs(): JsonField<Long> = elapsedMs

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

    /**
     * Returns the raw JSON value of [sampleRate].
     *
     * Unlike [sampleRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sample_rate") @ExcludeMissing fun _sampleRate(): JsonField<Long> = sampleRate

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
         * [RealtimeTranslationOutputAudioDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .eventId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranslationOutputAudioDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var eventId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("session.output_audio.delta")
        private var channels: JsonField<Long> = JsonMissing.of()
        private var elapsedMs: JsonField<Long> = JsonMissing.of()
        private var format: JsonField<Format> = JsonMissing.of()
        private var sampleRate: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranslationOutputAudioDeltaEvent: RealtimeTranslationOutputAudioDeltaEvent
        ) = apply {
            delta = realtimeTranslationOutputAudioDeltaEvent.delta
            eventId = realtimeTranslationOutputAudioDeltaEvent.eventId
            type = realtimeTranslationOutputAudioDeltaEvent.type
            channels = realtimeTranslationOutputAudioDeltaEvent.channels
            elapsedMs = realtimeTranslationOutputAudioDeltaEvent.elapsedMs
            format = realtimeTranslationOutputAudioDeltaEvent.format
            sampleRate = realtimeTranslationOutputAudioDeltaEvent.sampleRate
            additionalProperties =
                realtimeTranslationOutputAudioDeltaEvent.additionalProperties.toMutableMap()
        }

        /** Base64-encoded translated audio data. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.output_audio.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Number of audio channels. */
        fun channels(channels: Long) = channels(JsonField.of(channels))

        /**
         * Sets [Builder.channels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channels] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channels(channels: JsonField<Long>) = apply { this.channels = channels }

        /**
         * Timing metadata for stream alignment, derived from the translation frame when available.
         * Treat `elapsed_ms` as alignment metadata, not a unique event identifier.
         */
        fun elapsedMs(elapsedMs: Long?) = elapsedMs(JsonField.ofNullable(elapsedMs))

        /**
         * Alias for [Builder.elapsedMs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun elapsedMs(elapsedMs: Long) = elapsedMs(elapsedMs as Long?)

        /** Alias for calling [Builder.elapsedMs] with `elapsedMs.orElse(null)`. */
        fun elapsedMs(elapsedMs: Optional<Long>) = elapsedMs(elapsedMs.getOrNull())

        /**
         * Sets [Builder.elapsedMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.elapsedMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun elapsedMs(elapsedMs: JsonField<Long>) = apply { this.elapsedMs = elapsedMs }

        /** Audio encoding for `delta`. */
        fun format(format: Format) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [Format] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun format(format: JsonField<Format>) = apply { this.format = format }

        /** Sample rate of the audio delta. */
        fun sampleRate(sampleRate: Long) = sampleRate(JsonField.of(sampleRate))

        /**
         * Sets [Builder.sampleRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleRate] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sampleRate(sampleRate: JsonField<Long>) = apply { this.sampleRate = sampleRate }

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
         * Returns an immutable instance of [RealtimeTranslationOutputAudioDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .eventId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeTranslationOutputAudioDeltaEvent =
            RealtimeTranslationOutputAudioDeltaEvent(
                checkRequired("delta", delta),
                checkRequired("eventId", eventId),
                type,
                channels,
                elapsedMs,
                format,
                sampleRate,
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
    fun validate(): RealtimeTranslationOutputAudioDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        eventId()
        _type().let {
            if (it != JsonValue.from("session.output_audio.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        channels()
        elapsedMs()
        format().ifPresent { it.validate() }
        sampleRate()
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
        (if (delta.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.output_audio.delta")) 1 else 0 } +
            (if (channels.asKnown().isPresent) 1 else 0) +
            (if (elapsedMs.asKnown().isPresent) 1 else 0) +
            (format.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sampleRate.asKnown().isPresent) 1 else 0)

    /** Audio encoding for `delta`. */
    class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PCM16 = of("pcm16")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            PCM16
        }

        /**
         * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Format] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PCM16,
            /** An enum member indicating that [Format] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PCM16 -> Value.PCM16
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PCM16 -> Known.PCM16
                else -> throw OpenAIInvalidDataException("Unknown Format: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Format = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Format && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranslationOutputAudioDeltaEvent &&
            delta == other.delta &&
            eventId == other.eventId &&
            type == other.type &&
            channels == other.channels &&
            elapsedMs == other.elapsedMs &&
            format == other.format &&
            sampleRate == other.sampleRate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            delta,
            eventId,
            type,
            channels,
            elapsedMs,
            format,
            sampleRate,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranslationOutputAudioDeltaEvent{delta=$delta, eventId=$eventId, type=$type, channels=$channels, elapsedMs=$elapsedMs, format=$format, sampleRate=$sampleRate, additionalProperties=$additionalProperties}"
}
