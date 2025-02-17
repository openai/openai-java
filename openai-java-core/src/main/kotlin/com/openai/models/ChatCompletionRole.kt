// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/** The role of the author of a message */
class ChatCompletionRole @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val DEVELOPER = of("developer")

        @JvmField val SYSTEM = of("system")

        @JvmField val USER = of("user")

        @JvmField val ASSISTANT = of("assistant")

        @JvmField val TOOL = of("tool")

        @JvmField val FUNCTION = of("function")

        @JvmStatic fun of(value: String) = ChatCompletionRole(JsonField.of(value))
    }

    /** An enum containing [ChatCompletionRole]'s known values. */
    enum class Known {
        DEVELOPER,
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
    }

    /**
     * An enum containing [ChatCompletionRole]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ChatCompletionRole] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        DEVELOPER,
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
        /**
         * An enum member indicating that [ChatCompletionRole] was instantiated with an unknown
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
            DEVELOPER -> Value.DEVELOPER
            SYSTEM -> Value.SYSTEM
            USER -> Value.USER
            ASSISTANT -> Value.ASSISTANT
            TOOL -> Value.TOOL
            FUNCTION -> Value.FUNCTION
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
            DEVELOPER -> Known.DEVELOPER
            SYSTEM -> Known.SYSTEM
            USER -> Known.USER
            ASSISTANT -> Known.ASSISTANT
            TOOL -> Known.TOOL
            FUNCTION -> Known.FUNCTION
            else -> throw OpenAIInvalidDataException("Unknown ChatCompletionRole: $value")
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

        return /* spotless:off */ other is ChatCompletionRole && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
