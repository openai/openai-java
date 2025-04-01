// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class ModerationModel @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val OMNI_MODERATION_LATEST = of("omni-moderation-latest")

        @JvmField val OMNI_MODERATION_2024_09_26 = of("omni-moderation-2024-09-26")

        @JvmField val TEXT_MODERATION_LATEST = of("text-moderation-latest")

        @JvmField val TEXT_MODERATION_STABLE = of("text-moderation-stable")

        @JvmStatic fun of(value: String) = ModerationModel(JsonField.of(value))
    }

    /** An enum containing [ModerationModel]'s known values. */
    enum class Known {
        OMNI_MODERATION_LATEST,
        OMNI_MODERATION_2024_09_26,
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
    }

    /**
     * An enum containing [ModerationModel]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ModerationModel] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        OMNI_MODERATION_LATEST,
        OMNI_MODERATION_2024_09_26,
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
        /**
         * An enum member indicating that [ModerationModel] was instantiated with an unknown value.
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
            OMNI_MODERATION_LATEST -> Value.OMNI_MODERATION_LATEST
            OMNI_MODERATION_2024_09_26 -> Value.OMNI_MODERATION_2024_09_26
            TEXT_MODERATION_LATEST -> Value.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Value.TEXT_MODERATION_STABLE
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
            OMNI_MODERATION_LATEST -> Known.OMNI_MODERATION_LATEST
            OMNI_MODERATION_2024_09_26 -> Known.OMNI_MODERATION_2024_09_26
            TEXT_MODERATION_LATEST -> Known.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Known.TEXT_MODERATION_STABLE
            else -> throw OpenAIInvalidDataException("Unknown ModerationModel: $value")
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

    fun validate(): ModerationModel = apply {
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

        return /* spotless:off */ other is ModerationModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
