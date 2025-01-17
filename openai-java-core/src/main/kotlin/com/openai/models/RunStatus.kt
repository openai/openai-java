// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
 * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
 */
class RunStatus
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

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
        _UNKNOWN,
    }

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

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStatus && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
