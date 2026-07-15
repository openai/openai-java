// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * Constrains effort on reasoning for reasoning models. Currently supported values are `none`,
 * `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning effort can result in
 * faster responses and fewer tokens used on reasoning in a response. Not all reasoning models
 * support every value. See the [reasoning guide](https://platform.openai.com/docs/guides/reasoning)
 * for model-specific support.
 */
class ReasoningEffort @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val NONE = of("none")

        @JvmField val MINIMAL = of("minimal")

        @JvmField val LOW = of("low")

        @JvmField val MEDIUM = of("medium")

        @JvmField val HIGH = of("high")

        @JvmField val XHIGH = of("xhigh")

        @JvmField val MAX = of("max")

        @JvmStatic fun of(value: String) = ReasoningEffort(JsonField.of(value))
    }

    /** An enum containing [ReasoningEffort]'s known values. */
    enum class Known {
        NONE,
        MINIMAL,
        LOW,
        MEDIUM,
        HIGH,
        XHIGH,
        MAX,
    }

    /**
     * An enum containing [ReasoningEffort]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ReasoningEffort] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        NONE,
        MINIMAL,
        LOW,
        MEDIUM,
        HIGH,
        XHIGH,
        MAX,
        /**
         * An enum member indicating that [ReasoningEffort] was instantiated with an unknown value.
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
            NONE -> Value.NONE
            MINIMAL -> Value.MINIMAL
            LOW -> Value.LOW
            MEDIUM -> Value.MEDIUM
            HIGH -> Value.HIGH
            XHIGH -> Value.XHIGH
            MAX -> Value.MAX
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
            NONE -> Known.NONE
            MINIMAL -> Known.MINIMAL
            LOW -> Known.LOW
            MEDIUM -> Known.MEDIUM
            HIGH -> Known.HIGH
            XHIGH -> Known.XHIGH
            MAX -> Known.MAX
            else -> throw OpenAIInvalidDataException("Unknown ReasoningEffort: $value")
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ReasoningEffort = apply {
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

        return other is ReasoningEffort && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
