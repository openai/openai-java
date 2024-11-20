// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/**
 * Parameters for audio output. Required when audio output is requested with `modalities:
 * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
 */
@JsonDeserialize(builder = ChatCompletionAudioParam.Builder::class)
@NoAutoDetect
class ChatCompletionAudioParam
private constructor(
    private val voice: JsonField<Voice>,
    private val format: JsonField<Format>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /**
     * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`, `sage`,
     * and `verse` (also supported but not recommended are `alloy`, `echo`, and `shimmer`; these
     * voices are less expressive).
     */
    fun voice(): Voice = voice.getRequired("voice")

    /**
     * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or `pcm16`.
     */
    fun format(): Format = format.getRequired("format")

    /**
     * The voice the model uses to respond. Supported voices are `ash`, `ballad`, `coral`, `sage`,
     * and `verse` (also supported but not recommended are `alloy`, `echo`, and `shimmer`; these
     * voices are less expressive).
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice() = voice

    /**
     * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or `pcm16`.
     */
    @JsonProperty("format") @ExcludeMissing fun _format() = format

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionAudioParam = apply {
        if (!validated) {
            voice()
            format()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var voice: JsonField<Voice> = JsonMissing.of()
        private var format: JsonField<Format> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionAudioParam: ChatCompletionAudioParam) = apply {
            this.voice = chatCompletionAudioParam.voice
            this.format = chatCompletionAudioParam.format
            additionalProperties(chatCompletionAudioParam.additionalProperties)
        }

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
        @JsonProperty("voice")
        @ExcludeMissing
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

        /**
         * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or
         * `pcm16`.
         */
        fun format(format: Format) = format(JsonField.of(format))

        /**
         * Specifies the output audio format. Must be one of `wav`, `mp3`, `flac`, `opus`, or
         * `pcm16`.
         */
        @JsonProperty("format")
        @ExcludeMissing
        fun format(format: JsonField<Format>) = apply { this.format = format }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionAudioParam =
            ChatCompletionAudioParam(
                voice,
                format,
                additionalProperties.toImmutable(),
            )
    }

    class Format
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Format && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val WAV = Format(JsonField.of("wav"))

            @JvmField val MP3 = Format(JsonField.of("mp3"))

            @JvmField val FLAC = Format(JsonField.of("flac"))

            @JvmField val OPUS = Format(JsonField.of("opus"))

            @JvmField val PCM16 = Format(JsonField.of("pcm16"))

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        enum class Known {
            WAV,
            MP3,
            FLAC,
            OPUS,
            PCM16,
        }

        enum class Value {
            WAV,
            MP3,
            FLAC,
            OPUS,
            PCM16,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                WAV -> Value.WAV
                MP3 -> Value.MP3
                FLAC -> Value.FLAC
                OPUS -> Value.OPUS
                PCM16 -> Value.PCM16
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                WAV -> Known.WAV
                MP3 -> Known.MP3
                FLAC -> Known.FLAC
                OPUS -> Known.OPUS
                PCM16 -> Known.PCM16
                else -> throw OpenAIInvalidDataException("Unknown Format: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Voice
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Voice && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ALLOY = Voice(JsonField.of("alloy"))

            @JvmField val ASH = Voice(JsonField.of("ash"))

            @JvmField val BALLAD = Voice(JsonField.of("ballad"))

            @JvmField val CORAL = Voice(JsonField.of("coral"))

            @JvmField val ECHO = Voice(JsonField.of("echo"))

            @JvmField val SAGE = Voice(JsonField.of("sage"))

            @JvmField val SHIMMER = Voice(JsonField.of("shimmer"))

            @JvmField val VERSE = Voice(JsonField.of("verse"))

            @JvmStatic fun of(value: String) = Voice(JsonField.of(value))
        }

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

        enum class Value {
            ALLOY,
            ASH,
            BALLAD,
            CORAL,
            ECHO,
            SAGE,
            SHIMMER,
            VERSE,
            _UNKNOWN,
        }

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

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionAudioParam && voice == other.voice && format == other.format && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(voice, format, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionAudioParam{voice=$voice, format=$format, additionalProperties=$additionalProperties}"
}
