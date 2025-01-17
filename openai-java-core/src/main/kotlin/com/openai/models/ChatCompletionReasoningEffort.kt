// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * **o1 models only**
 *
 * Constrains effort on reasoning for
 * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported values
 * are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster responses and
 * fewer tokens used on reasoning in a response.
 */
class ChatCompletionReasoningEffort
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val LOW = of("low")

        @JvmField val MEDIUM = of("medium")

        @JvmField val HIGH = of("high")

        @JvmStatic fun of(value: String) = ChatCompletionReasoningEffort(JsonField.of(value))
    }

    enum class Known {
        LOW,
        MEDIUM,
        HIGH,
    }

    enum class Value {
        LOW,
        MEDIUM,
        HIGH,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            LOW -> Value.LOW
            MEDIUM -> Value.MEDIUM
            HIGH -> Value.HIGH
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            LOW -> Known.LOW
            MEDIUM -> Known.MEDIUM
            HIGH -> Known.HIGH
            else ->
                throw OpenAIInvalidDataException("Unknown ChatCompletionReasoningEffort: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionReasoningEffort && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
