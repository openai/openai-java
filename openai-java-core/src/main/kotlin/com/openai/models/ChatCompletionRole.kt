// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/** The role of the author of a message */
class ChatCompletionRole
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val SYSTEM = of("system")

        @JvmField val USER = of("user")

        @JvmField val ASSISTANT = of("assistant")

        @JvmField val TOOL = of("tool")

        @JvmField val FUNCTION = of("function")

        @JvmStatic fun of(value: String) = ChatCompletionRole(JsonField.of(value))
    }

    enum class Known {
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
    }

    enum class Value {
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            SYSTEM -> Value.SYSTEM
            USER -> Value.USER
            ASSISTANT -> Value.ASSISTANT
            TOOL -> Value.TOOL
            FUNCTION -> Value.FUNCTION
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            SYSTEM -> Known.SYSTEM
            USER -> Known.USER
            ASSISTANT -> Known.ASSISTANT
            TOOL -> Known.TOOL
            FUNCTION -> Known.FUNCTION
            else -> throw OpenAIInvalidDataException("Unknown ChatCompletionRole: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionRole && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
