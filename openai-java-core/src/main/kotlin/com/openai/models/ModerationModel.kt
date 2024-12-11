// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class ModerationModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val OMNI_MODERATION_LATEST = of("omni-moderation-latest")

        @JvmField val OMNI_MODERATION_2024_09_26 = of("omni-moderation-2024-09-26")

        @JvmField val TEXT_MODERATION_LATEST = of("text-moderation-latest")

        @JvmField val TEXT_MODERATION_STABLE = of("text-moderation-stable")

        @JvmStatic fun of(value: String) = ModerationModel(JsonField.of(value))
    }

    enum class Known {
        OMNI_MODERATION_LATEST,
        OMNI_MODERATION_2024_09_26,
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
    }

    enum class Value {
        OMNI_MODERATION_LATEST,
        OMNI_MODERATION_2024_09_26,
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            OMNI_MODERATION_LATEST -> Value.OMNI_MODERATION_LATEST
            OMNI_MODERATION_2024_09_26 -> Value.OMNI_MODERATION_2024_09_26
            TEXT_MODERATION_LATEST -> Value.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Value.TEXT_MODERATION_STABLE
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            OMNI_MODERATION_LATEST -> Known.OMNI_MODERATION_LATEST
            OMNI_MODERATION_2024_09_26 -> Known.OMNI_MODERATION_2024_09_26
            TEXT_MODERATION_LATEST -> Known.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Known.TEXT_MODERATION_STABLE
            else -> throw OpenAIInvalidDataException("Unknown ModerationModel: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
