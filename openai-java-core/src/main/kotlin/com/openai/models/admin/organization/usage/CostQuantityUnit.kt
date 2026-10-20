// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The unit of the `quantity` value. If no single supported unit applies to the result, this field
 * is `null`.
 */
class CostQuantityUnit @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val TOKENS = of("tokens")

        @JvmField val _1000_TOKENS = of("1000_tokens")

        @JvmField val DURATION_SECONDS = of("duration_seconds")

        @JvmField val DURATION_MINUTES = of("duration_minutes")

        @JvmField val DURATION_HOURS = of("duration_hours")

        @JvmField val GIBIBYTE_HOURS = of("gibibyte_hours")

        @JvmField val IMAGES = of("images")

        @JvmField val CHARACTERS = of("characters")

        @JvmStatic fun of(value: String) = CostQuantityUnit(JsonField.of(value))
    }

    /** An enum containing [CostQuantityUnit]'s known values. */
    enum class Known {
        TOKENS,
        _1000_TOKENS,
        DURATION_SECONDS,
        DURATION_MINUTES,
        DURATION_HOURS,
        GIBIBYTE_HOURS,
        IMAGES,
        CHARACTERS,
    }

    /**
     * An enum containing [CostQuantityUnit]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [CostQuantityUnit] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        TOKENS,
        _1000_TOKENS,
        DURATION_SECONDS,
        DURATION_MINUTES,
        DURATION_HOURS,
        GIBIBYTE_HOURS,
        IMAGES,
        CHARACTERS,
        /**
         * An enum member indicating that [CostQuantityUnit] was instantiated with an unknown value.
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
            TOKENS -> Value.TOKENS
            _1000_TOKENS -> Value._1000_TOKENS
            DURATION_SECONDS -> Value.DURATION_SECONDS
            DURATION_MINUTES -> Value.DURATION_MINUTES
            DURATION_HOURS -> Value.DURATION_HOURS
            GIBIBYTE_HOURS -> Value.GIBIBYTE_HOURS
            IMAGES -> Value.IMAGES
            CHARACTERS -> Value.CHARACTERS
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
            TOKENS -> Known.TOKENS
            _1000_TOKENS -> Known._1000_TOKENS
            DURATION_SECONDS -> Known.DURATION_SECONDS
            DURATION_MINUTES -> Known.DURATION_MINUTES
            DURATION_HOURS -> Known.DURATION_HOURS
            GIBIBYTE_HOURS -> Known.GIBIBYTE_HOURS
            IMAGES -> Known.IMAGES
            CHARACTERS -> Known.CHARACTERS
            else -> throw OpenAIInvalidDataException("Unknown CostQuantityUnit: $value")
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
    fun validate(): CostQuantityUnit = apply {
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

        return other is CostQuantityUnit && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
