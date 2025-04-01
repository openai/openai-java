// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.speech

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class SpeechModel @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val TTS_1 = of("tts-1")

        @JvmField val TTS_1_HD = of("tts-1-hd")

        @JvmField val GPT_4O_MINI_TTS = of("gpt-4o-mini-tts")

        @JvmStatic fun of(value: String) = SpeechModel(JsonField.of(value))
    }

    /** An enum containing [SpeechModel]'s known values. */
    enum class Known {
        TTS_1,
        TTS_1_HD,
        GPT_4O_MINI_TTS,
    }

    /**
     * An enum containing [SpeechModel]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [SpeechModel] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        TTS_1,
        TTS_1_HD,
        GPT_4O_MINI_TTS,
        /** An enum member indicating that [SpeechModel] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            TTS_1 -> Value.TTS_1
            TTS_1_HD -> Value.TTS_1_HD
            GPT_4O_MINI_TTS -> Value.GPT_4O_MINI_TTS
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws OpenAIInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            TTS_1 -> Known.TTS_1
            TTS_1_HD -> Known.TTS_1_HD
            GPT_4O_MINI_TTS -> Known.GPT_4O_MINI_TTS
            else -> throw OpenAIInvalidDataException("Unknown SpeechModel: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws OpenAIInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): SpeechModel = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SpeechModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
