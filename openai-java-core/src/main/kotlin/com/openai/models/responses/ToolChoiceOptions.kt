// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * Controls which (if any) tool is called by the model.
 *
 * `none` means the model will not call any tool and instead generates a message.
 *
 * `auto` means the model can pick between generating a message or calling one or more tools.
 *
 * `required` means the model must call one or more tools.
 */
class ToolChoiceOptions @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val AUTO = of("auto")

        @JvmField val REQUIRED = of("required")

        @JvmStatic fun of(value: String) = ToolChoiceOptions(JsonField.of(value))
    }

    /** An enum containing [ToolChoiceOptions]'s known values. */
    enum class Known {
        NONE,
        AUTO,
        REQUIRED,
    }

    /**
     * An enum containing [ToolChoiceOptions]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ToolChoiceOptions] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        NONE,
        AUTO,
        REQUIRED,
        /**
         * An enum member indicating that [ToolChoiceOptions] was instantiated with an unknown
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
            NONE -> Value.NONE
            AUTO -> Value.AUTO
            REQUIRED -> Value.REQUIRED
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
            AUTO -> Known.AUTO
            REQUIRED -> Known.REQUIRED
            else -> throw OpenAIInvalidDataException("Unknown ToolChoiceOptions: $value")
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

    fun validate(): ToolChoiceOptions = apply {
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

        return /* spotless:off */ other is ToolChoiceOptions && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
