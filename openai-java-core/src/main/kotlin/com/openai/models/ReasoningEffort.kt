// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * **o-series models only**
 *
 * Constrains effort on reasoning for
 * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported values
 * are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster responses and
 * fewer tokens used on reasoning in a response.
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

        @JvmField val LOW = of("low")

        @JvmField val MEDIUM = of("medium")

        @JvmField val HIGH = of("high")

        @JvmStatic fun of(value: String) = ReasoningEffort(JsonField.of(value))
    }

    /** An enum containing [ReasoningEffort]'s known values. */
    enum class Known {
        LOW,
        MEDIUM,
        HIGH,
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
        LOW,
        MEDIUM,
        HIGH,
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
            LOW -> Value.LOW
            MEDIUM -> Value.MEDIUM
            HIGH -> Value.HIGH
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
            LOW -> Known.LOW
            MEDIUM -> Known.MEDIUM
            HIGH -> Known.HIGH
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ReasoningEffort && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
