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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class RealtimeAudioConfigOutput
private constructor(
    private val format: JsonField<RealtimeAudioFormats>,
    private val speed: JsonField<Double>,
    private val voice: JsonField<Voice>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<RealtimeAudioFormats> = JsonMissing.of(),
        @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
    ) : this(format, speed, voice, mutableMapOf())

    /**
     * The format of the output audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

    /**
     * The speed of the model's spoken response as a multiple of the original speed. 1.0 is the
     * default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This value can only be
     * changed in between model turns, not while a response is in progress.
     *
     * This parameter is a post-processing adjustment to the audio after it is generated, it's also
     * possible to prompt the model to speak faster or slower.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun speed(): Optional<Double> = speed.getOptional("speed")

    /**
     * The voice the model uses to respond. Voice cannot be changed during the session once the
     * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
     * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. We recommend
     * `marin` and `cedar` for best quality.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun voice(): Optional<Voice> = voice.getOptional("voice")

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<RealtimeAudioFormats> = format

    /**
     * Returns the raw JSON value of [speed].
     *
     * Unlike [speed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("speed") @ExcludeMissing fun _speed(): JsonField<Double> = speed

    /**
     * Returns the raw JSON value of [voice].
     *
     * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

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
         * Returns a mutable builder for constructing an instance of [RealtimeAudioConfigOutput].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeAudioConfigOutput]. */
    class Builder internal constructor() {

        private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
        private var speed: JsonField<Double> = JsonMissing.of()
        private var voice: JsonField<Voice> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeAudioConfigOutput: RealtimeAudioConfigOutput) = apply {
            format = realtimeAudioConfigOutput.format
            speed = realtimeAudioConfigOutput.speed
            voice = realtimeAudioConfigOutput.voice
            additionalProperties = realtimeAudioConfigOutput.additionalProperties.toMutableMap()
        }

        /** The format of the output audio. */
        fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
        fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
            format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`. */
        fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
            format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`. */
        fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
            format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

        /**
         * The speed of the model's spoken response as a multiple of the original speed. 1.0 is the
         * default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This value can only
         * be changed in between model turns, not while a response is in progress.
         *
         * This parameter is a post-processing adjustment to the audio after it is generated, it's
         * also possible to prompt the model to speak faster or slower.
         */
        fun speed(speed: Double) = speed(JsonField.of(speed))

        /**
         * Sets [Builder.speed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speed] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. We recommend
         * `marin` and `cedar` for best quality.
         */
        fun voice(voice: Voice) = voice(JsonField.of(voice))

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

        /**
         * Sets [voice] to an arbitrary [String].
         *
         * You should usually call [voice] with a well-typed [Voice] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(value: String) = voice(Voice.of(value))

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
         * Returns an immutable instance of [RealtimeAudioConfigOutput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeAudioConfigOutput =
            RealtimeAudioConfigOutput(format, speed, voice, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RealtimeAudioConfigOutput = apply {
        if (validated) {
            return@apply
        }

        format().ifPresent { it.validate() }
        speed()
        voice()
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
        (format.asKnown().getOrNull()?.validity() ?: 0) +
            (if (speed.asKnown().isPresent) 1 else 0) +
            (if (voice.asKnown().isPresent) 1 else 0)

    /**
     * The voice the model uses to respond. Voice cannot be changed during the session once the
     * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
     * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. We recommend
     * `marin` and `cedar` for best quality.
     */
    class Voice @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ALLOY = of("alloy")

            @JvmField val ASH = of("ash")

            @JvmField val BALLAD = of("ballad")

            @JvmField val CORAL = of("coral")

            @JvmField val ECHO = of("echo")

            @JvmField val SAGE = of("sage")

            @JvmField val SHIMMER = of("shimmer")

            @JvmField val VERSE = of("verse")

            @JvmField val MARIN = of("marin")

            @JvmField val CEDAR = of("cedar")

            @JvmStatic fun of(value: String) = Voice(JsonField.of(value))
        }

        /** An enum containing [Voice]'s known values. */
        enum class Known {
            ALLOY,
            ASH,
            BALLAD,
            CORAL,
            ECHO,
            SAGE,
            SHIMMER,
            VERSE,
            MARIN,
            CEDAR,
        }

        /**
         * An enum containing [Voice]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Voice] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALLOY,
            ASH,
            BALLAD,
            CORAL,
            ECHO,
            SAGE,
            SHIMMER,
            VERSE,
            MARIN,
            CEDAR,
            /** An enum member indicating that [Voice] was instantiated with an unknown value. */
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
                ALLOY -> Value.ALLOY
                ASH -> Value.ASH
                BALLAD -> Value.BALLAD
                CORAL -> Value.CORAL
                ECHO -> Value.ECHO
                SAGE -> Value.SAGE
                SHIMMER -> Value.SHIMMER
                VERSE -> Value.VERSE
                MARIN -> Value.MARIN
                CEDAR -> Value.CEDAR
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
                ALLOY -> Known.ALLOY
                ASH -> Known.ASH
                BALLAD -> Known.BALLAD
                CORAL -> Known.CORAL
                ECHO -> Known.ECHO
                SAGE -> Known.SAGE
                SHIMMER -> Known.SHIMMER
                VERSE -> Known.VERSE
                MARIN -> Known.MARIN
                CEDAR -> Known.CEDAR
                else -> throw OpenAIInvalidDataException("Unknown Voice: $value")
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

        fun validate(): Voice = apply {
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

            return other is Voice && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeAudioConfigOutput &&
            format == other.format &&
            speed == other.speed &&
            voice == other.voice &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(format, speed, voice, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeAudioConfigOutput{format=$format, speed=$speed, voice=$voice, additionalProperties=$additionalProperties}"
}
