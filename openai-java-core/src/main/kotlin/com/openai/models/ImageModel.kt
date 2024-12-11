// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class ImageModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val DALL_E_2 = of("dall-e-2")

        @JvmField val DALL_E_3 = of("dall-e-3")

        @JvmStatic fun of(value: String) = ImageModel(JsonField.of(value))
    }

    enum class Known {
        DALL_E_2,
        DALL_E_3,
    }

    enum class Value {
        DALL_E_2,
        DALL_E_3,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            DALL_E_2 -> Value.DALL_E_2
            DALL_E_3 -> Value.DALL_E_3
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            DALL_E_2 -> Known.DALL_E_2
            DALL_E_3 -> Known.DALL_E_3
            else -> throw OpenAIInvalidDataException("Unknown ImageModel: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
