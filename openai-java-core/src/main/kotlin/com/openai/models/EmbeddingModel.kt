// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class EmbeddingModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val TEXT_EMBEDDING_ADA_002 = of("text-embedding-ada-002")

        @JvmField val TEXT_EMBEDDING_3_SMALL = of("text-embedding-3-small")

        @JvmField val TEXT_EMBEDDING_3_LARGE = of("text-embedding-3-large")

        @JvmStatic fun of(value: String) = EmbeddingModel(JsonField.of(value))
    }

    enum class Known {
        TEXT_EMBEDDING_ADA_002,
        TEXT_EMBEDDING_3_SMALL,
        TEXT_EMBEDDING_3_LARGE,
    }

    enum class Value {
        TEXT_EMBEDDING_ADA_002,
        TEXT_EMBEDDING_3_SMALL,
        TEXT_EMBEDDING_3_LARGE,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            TEXT_EMBEDDING_ADA_002 -> Value.TEXT_EMBEDDING_ADA_002
            TEXT_EMBEDDING_3_SMALL -> Value.TEXT_EMBEDDING_3_SMALL
            TEXT_EMBEDDING_3_LARGE -> Value.TEXT_EMBEDDING_3_LARGE
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            TEXT_EMBEDDING_ADA_002 -> Known.TEXT_EMBEDDING_ADA_002
            TEXT_EMBEDDING_3_SMALL -> Known.TEXT_EMBEDDING_3_SMALL
            TEXT_EMBEDDING_3_LARGE -> Known.TEXT_EMBEDDING_3_LARGE
            else -> throw OpenAIInvalidDataException("Unknown EmbeddingModel: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EmbeddingModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
