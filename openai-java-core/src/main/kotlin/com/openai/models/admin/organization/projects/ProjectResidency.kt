// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class ProjectResidency @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val GLOBAL = of("GLOBAL")

        @JvmField val US_STORAGE_PROCESSING = of("US_STORAGE_PROCESSING")

        @JvmField val EU_STORAGE_PROCESSING = of("EU_STORAGE_PROCESSING")

        @JvmField val JP_STORAGE = of("JP_STORAGE")

        @JvmField val KR_STORAGE = of("KR_STORAGE")

        @JvmField val CA_STORAGE = of("CA_STORAGE")

        @JvmField val SG_STORAGE = of("SG_STORAGE")

        @JvmField val IN_STORAGE = of("IN_STORAGE")

        @JvmField val AU_STORAGE = of("AU_STORAGE")

        @JvmField val GB_STORAGE = of("GB_STORAGE")

        @JvmField val AE_STORAGE = of("AE_STORAGE")

        @JvmField val AE_STORAGE_PROCESSING = of("AE_STORAGE_PROCESSING")

        @JvmStatic fun of(value: String) = ProjectResidency(JsonField.of(value))
    }

    /** An enum containing [ProjectResidency]'s known values. */
    enum class Known {
        GLOBAL,
        US_STORAGE_PROCESSING,
        EU_STORAGE_PROCESSING,
        JP_STORAGE,
        KR_STORAGE,
        CA_STORAGE,
        SG_STORAGE,
        IN_STORAGE,
        AU_STORAGE,
        GB_STORAGE,
        AE_STORAGE,
        AE_STORAGE_PROCESSING,
    }

    /**
     * An enum containing [ProjectResidency]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ProjectResidency] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        GLOBAL,
        US_STORAGE_PROCESSING,
        EU_STORAGE_PROCESSING,
        JP_STORAGE,
        KR_STORAGE,
        CA_STORAGE,
        SG_STORAGE,
        IN_STORAGE,
        AU_STORAGE,
        GB_STORAGE,
        AE_STORAGE,
        AE_STORAGE_PROCESSING,
        /**
         * An enum member indicating that [ProjectResidency] was instantiated with an unknown value.
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
            GLOBAL -> Value.GLOBAL
            US_STORAGE_PROCESSING -> Value.US_STORAGE_PROCESSING
            EU_STORAGE_PROCESSING -> Value.EU_STORAGE_PROCESSING
            JP_STORAGE -> Value.JP_STORAGE
            KR_STORAGE -> Value.KR_STORAGE
            CA_STORAGE -> Value.CA_STORAGE
            SG_STORAGE -> Value.SG_STORAGE
            IN_STORAGE -> Value.IN_STORAGE
            AU_STORAGE -> Value.AU_STORAGE
            GB_STORAGE -> Value.GB_STORAGE
            AE_STORAGE -> Value.AE_STORAGE
            AE_STORAGE_PROCESSING -> Value.AE_STORAGE_PROCESSING
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
            GLOBAL -> Known.GLOBAL
            US_STORAGE_PROCESSING -> Known.US_STORAGE_PROCESSING
            EU_STORAGE_PROCESSING -> Known.EU_STORAGE_PROCESSING
            JP_STORAGE -> Known.JP_STORAGE
            KR_STORAGE -> Known.KR_STORAGE
            CA_STORAGE -> Known.CA_STORAGE
            SG_STORAGE -> Known.SG_STORAGE
            IN_STORAGE -> Known.IN_STORAGE
            AU_STORAGE -> Known.AU_STORAGE
            GB_STORAGE -> Known.GB_STORAGE
            AE_STORAGE -> Known.AE_STORAGE
            AE_STORAGE_PROCESSING -> Known.AE_STORAGE_PROCESSING
            else -> throw OpenAIInvalidDataException("Unknown ProjectResidency: $value")
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
    fun validate(): ProjectResidency = apply {
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

        return other is ProjectResidency && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
