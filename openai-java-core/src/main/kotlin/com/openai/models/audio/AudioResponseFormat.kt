// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
 * `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format is `json`.
 */
class AudioResponseFormat @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val JSON = of("json")

        @JvmField val TEXT = of("text")

        @JvmField val SRT = of("srt")

        @JvmField val VERBOSE_JSON = of("verbose_json")

        @JvmField val VTT = of("vtt")

        @JvmStatic fun of(value: String) = AudioResponseFormat(JsonField.of(value))
    }

    /** An enum containing [AudioResponseFormat]'s known values. */
    enum class Known {
        JSON,
        TEXT,
        SRT,
        VERBOSE_JSON,
        VTT,
    }

    /**
     * An enum containing [AudioResponseFormat]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [AudioResponseFormat] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        JSON,
        TEXT,
        SRT,
        VERBOSE_JSON,
        VTT,
        /**
         * An enum member indicating that [AudioResponseFormat] was instantiated with an unknown
         * value.
         */
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
            JSON -> Value.JSON
            TEXT -> Value.TEXT
            SRT -> Value.SRT
            VERBOSE_JSON -> Value.VERBOSE_JSON
            VTT -> Value.VTT
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
            JSON -> Known.JSON
            TEXT -> Known.TEXT
            SRT -> Known.SRT
            VERBOSE_JSON -> Known.VERBOSE_JSON
            VTT -> Known.VTT
            else -> throw OpenAIInvalidDataException("Unknown AudioResponseFormat: $value")
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

    fun validate(): AudioResponseFormat = apply {
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

        return /* spotless:off */ other is AudioResponseFormat && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
