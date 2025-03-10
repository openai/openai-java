// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
 * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
 */
class RunStatus @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val QUEUED = of("queued")

        @JvmField val IN_PROGRESS = of("in_progress")

        @JvmField val REQUIRES_ACTION = of("requires_action")

        @JvmField val CANCELLING = of("cancelling")

        @JvmField val CANCELLED = of("cancelled")

        @JvmField val FAILED = of("failed")

        @JvmField val COMPLETED = of("completed")

        @JvmField val INCOMPLETE = of("incomplete")

        @JvmField val EXPIRED = of("expired")

        @JvmStatic fun of(value: String) = RunStatus(JsonField.of(value))
    }

    /** An enum containing [RunStatus]'s known values. */
    enum class Known {
        QUEUED,
        IN_PROGRESS,
        REQUIRES_ACTION,
        CANCELLING,
        CANCELLED,
        FAILED,
        COMPLETED,
        INCOMPLETE,
        EXPIRED,
    }

    /**
     * An enum containing [RunStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [RunStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        QUEUED,
        IN_PROGRESS,
        REQUIRES_ACTION,
        CANCELLING,
        CANCELLED,
        FAILED,
        COMPLETED,
        INCOMPLETE,
        EXPIRED,
        /** An enum member indicating that [RunStatus] was instantiated with an unknown value. */
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
            QUEUED -> Value.QUEUED
            IN_PROGRESS -> Value.IN_PROGRESS
            REQUIRES_ACTION -> Value.REQUIRES_ACTION
            CANCELLING -> Value.CANCELLING
            CANCELLED -> Value.CANCELLED
            FAILED -> Value.FAILED
            COMPLETED -> Value.COMPLETED
            INCOMPLETE -> Value.INCOMPLETE
            EXPIRED -> Value.EXPIRED
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
            QUEUED -> Known.QUEUED
            IN_PROGRESS -> Known.IN_PROGRESS
            REQUIRES_ACTION -> Known.REQUIRES_ACTION
            CANCELLING -> Known.CANCELLING
            CANCELLED -> Known.CANCELLED
            FAILED -> Known.FAILED
            COMPLETED -> Known.COMPLETED
            INCOMPLETE -> Known.INCOMPLETE
            EXPIRED -> Known.EXPIRED
            else -> throw OpenAIInvalidDataException("Unknown RunStatus: $value")
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

        return /* spotless:off */ other is RunStatus && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
