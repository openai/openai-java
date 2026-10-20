// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * A machine-readable steering error code. Clients should handle unknown values because additional
 * codes may be introduced. Known values include:
 * - `response_not_found`: The target response is not available on this connection.
 * - `invalid_input`: The event or input failed validation.
 * - `steering_not_supported`: The model or response execution mode does not support steering.
 * - `too_many_pending_steers`: Too much steering input is pending for the response.
 * - `response_already_completed`: The response completed and is no longer accepting steering input.
 * - `response_not_active`: The response is no longer accepting steering input.
 * - `successor_creation_failed`: The successor response could not be created.
 */
class BetaResponseSteerErrorCode
@JsonCreator
private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val RESPONSE_NOT_FOUND = of("response_not_found")

        @JvmField val INVALID_INPUT = of("invalid_input")

        @JvmField val STEERING_NOT_SUPPORTED = of("steering_not_supported")

        @JvmField val TOO_MANY_PENDING_STEERS = of("too_many_pending_steers")

        @JvmField val RESPONSE_ALREADY_COMPLETED = of("response_already_completed")

        @JvmField val RESPONSE_NOT_ACTIVE = of("response_not_active")

        @JvmField val SUCCESSOR_CREATION_FAILED = of("successor_creation_failed")

        @JvmStatic fun of(value: String) = BetaResponseSteerErrorCode(JsonField.of(value))
    }

    /** An enum containing [BetaResponseSteerErrorCode]'s known values. */
    enum class Known {
        RESPONSE_NOT_FOUND,
        INVALID_INPUT,
        STEERING_NOT_SUPPORTED,
        TOO_MANY_PENDING_STEERS,
        RESPONSE_ALREADY_COMPLETED,
        RESPONSE_NOT_ACTIVE,
        SUCCESSOR_CREATION_FAILED,
    }

    /**
     * An enum containing [BetaResponseSteerErrorCode]'s known values, as well as an [_UNKNOWN]
     * member.
     *
     * An instance of [BetaResponseSteerErrorCode] can contain an unknown value in a couple of
     * cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        RESPONSE_NOT_FOUND,
        INVALID_INPUT,
        STEERING_NOT_SUPPORTED,
        TOO_MANY_PENDING_STEERS,
        RESPONSE_ALREADY_COMPLETED,
        RESPONSE_NOT_ACTIVE,
        SUCCESSOR_CREATION_FAILED,
        /**
         * An enum member indicating that [BetaResponseSteerErrorCode] was instantiated with an
         * unknown value.
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
            RESPONSE_NOT_FOUND -> Value.RESPONSE_NOT_FOUND
            INVALID_INPUT -> Value.INVALID_INPUT
            STEERING_NOT_SUPPORTED -> Value.STEERING_NOT_SUPPORTED
            TOO_MANY_PENDING_STEERS -> Value.TOO_MANY_PENDING_STEERS
            RESPONSE_ALREADY_COMPLETED -> Value.RESPONSE_ALREADY_COMPLETED
            RESPONSE_NOT_ACTIVE -> Value.RESPONSE_NOT_ACTIVE
            SUCCESSOR_CREATION_FAILED -> Value.SUCCESSOR_CREATION_FAILED
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
            RESPONSE_NOT_FOUND -> Known.RESPONSE_NOT_FOUND
            INVALID_INPUT -> Known.INVALID_INPUT
            STEERING_NOT_SUPPORTED -> Known.STEERING_NOT_SUPPORTED
            TOO_MANY_PENDING_STEERS -> Known.TOO_MANY_PENDING_STEERS
            RESPONSE_ALREADY_COMPLETED -> Known.RESPONSE_ALREADY_COMPLETED
            RESPONSE_NOT_ACTIVE -> Known.RESPONSE_NOT_ACTIVE
            SUCCESSOR_CREATION_FAILED -> Known.SUCCESSOR_CREATION_FAILED
            else -> throw OpenAIInvalidDataException("Unknown BetaResponseSteerErrorCode: $value")
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
    fun validate(): BetaResponseSteerErrorCode = apply {
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

        return other is BetaResponseSteerErrorCode && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
