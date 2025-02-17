// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/**
 * Parameters for audio output. Required when audio output is requested with `modalities:
 * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
 */
@NoAutoDetect
class ChatCompletionAudioParam
@JsonCreator
private constructor(
    @JsonProperty("format")
    @ExcludeMissing
    private val format: JsonField<Format> = JsonMissing.of(),
    @JsonProperty("voice") @ExcludeMissing private val voice: JsonField<Voice> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or `pcm16`.
     */
    fun format(): Format = format.getRequired("format")

    /**
     * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`, `sage`,
     * and `verse` (also supported but not recommended are `alloy`, `echo`, and `shimmer`; these
     * voices are less expressive).
     */
    fun voice(): Voice = voice.getRequired("voice")

    /**
     * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or `pcm16`.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

    /**
     * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`, `sage`,
     * and `verse` (also supported but not recommended are `alloy`, `echo`, and `shimmer`; these
     * voices are less expressive).
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionAudioParam = apply {
        if (validated) {
            return@apply
        }

        format()
        voice()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionAudioParam]. */
    class Builder internal constructor() {

        private var format: JsonField<Format>? = null
        private var voice: JsonField<Voice>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionAudioParam: ChatCompletionAudioParam) = apply {
            format = chatCompletionAudioParam.format
            voice = chatCompletionAudioParam.voice
            additionalProperties = chatCompletionAudioParam.additionalProperties.toMutableMap()
        }

        /**
         * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or
         * `pcm16`.
         */
        fun format(format: Format) = format(JsonField.of(format))

        /**
         * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or
         * `pcm16`.
         */
        fun format(format: JsonField<Format>) = apply { this.format = format }

        /**
         * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`,
         * `sage`, and `verse` (also supported but not recommended are `alloy`, `echo`, and
         * `shimmer`; these voices are less expressive).
         */
        fun voice(voice: Voice) = voice(JsonField.of(voice))

        /**
         * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`,
         * `sage`, and `verse` (also supported but not recommended are `alloy`, `echo`, and
         * `shimmer`; these voices are less expressive).
         */
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

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

        fun build(): ChatCompletionAudioParam =
            ChatCompletionAudioParam(
                checkRequired("format", format),
                checkRequired("voice", voice),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or `pcm16`.
     */
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

            @JvmField val WAV = of("wav")

            @JvmField val MP3 = of("mp3")

            @JvmField val FLAC = of("flac")

            @JvmField val OPUS = of("opus")

            @JvmField val PCM16 = of("pcm16")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            WAV,
            MP3,
            FLAC,
            OPUS,
            PCM16,
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
            WAV,
            MP3,
            FLAC,
            OPUS,
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
                WAV -> Value.WAV
                MP3 -> Value.MP3
                FLAC -> Value.FLAC
                OPUS -> Value.OPUS
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
                WAV -> Known.WAV
                MP3 -> Known.MP3
                FLAC -> Known.FLAC
                OPUS -> Known.OPUS
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Format && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`, `sage`,
     * and `verse` (also supported but not recommended are `alloy`, `echo`, and `shimmer`; these
     * voices are less expressive).
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Voice && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionAudioParam && format == other.format && voice == other.voice && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(format, voice, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionAudioParam{format=$format, voice=$voice, additionalProperties=$additionalProperties}"
}
