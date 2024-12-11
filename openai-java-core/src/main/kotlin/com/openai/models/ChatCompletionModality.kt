// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class ChatCompletionModality
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionModality && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {

        @JvmField val TEXT = of("text")

        @JvmField val AUDIO = of("audio")

        @JvmStatic fun of(value: String) = ChatCompletionModality(JsonField.of(value))
    }

    enum class Known {
        TEXT,
        AUDIO,
    }

    enum class Value {
        TEXT,
        AUDIO,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            TEXT -> Value.TEXT
            AUDIO -> Value.AUDIO
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            TEXT -> Known.TEXT
            AUDIO -> Known.AUDIO
            else -> throw OpenAIInvalidDataException("Unknown ChatCompletionModality: $value")
        }

    fun asString(): String = _value().asStringOrThrow()
}
