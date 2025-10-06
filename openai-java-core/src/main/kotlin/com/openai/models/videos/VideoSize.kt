// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class VideoSize @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val _720X1280 = of("720x1280")

        @JvmField val _1280X720 = of("1280x720")

        @JvmField val _1024X1792 = of("1024x1792")

        @JvmField val _1792X1024 = of("1792x1024")

        @JvmStatic fun of(value: String) = VideoSize(JsonField.of(value))
    }

    /** An enum containing [VideoSize]'s known values. */
    enum class Known {
        _720X1280,
        _1280X720,
        _1024X1792,
        _1792X1024,
    }

    /**
     * An enum containing [VideoSize]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [VideoSize] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        _720X1280,
        _1280X720,
        _1024X1792,
        _1792X1024,
        /** An enum member indicating that [VideoSize] was instantiated with an unknown value. */
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
            _720X1280 -> Value._720X1280
            _1280X720 -> Value._1280X720
            _1024X1792 -> Value._1024X1792
            _1792X1024 -> Value._1792X1024
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
            _720X1280 -> Known._720X1280
            _1280X720 -> Known._1280X720
            _1024X1792 -> Known._1024X1792
            _1792X1024 -> Known._1792X1024
            else -> throw OpenAIInvalidDataException("Unknown VideoSize: $value")
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

    fun validate(): VideoSize = apply {
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

        return other is VideoSize && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
