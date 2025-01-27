// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class EmbeddingModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val TEXT_EMBEDDING_ADA_002 = of("text-embedding-ada-002")

        @JvmField val TEXT_EMBEDDING_3_SMALL = of("text-embedding-3-small")

        @JvmField val TEXT_EMBEDDING_3_LARGE = of("text-embedding-3-large")

        @JvmStatic fun of(value: String) = EmbeddingModel(JsonField.of(value))
    }

    /** An enum containing [EmbeddingModel]'s known values. */
    enum class Known {
        TEXT_EMBEDDING_ADA_002,
        TEXT_EMBEDDING_3_SMALL,
        TEXT_EMBEDDING_3_LARGE,
    }

    /**
     * An enum containing [EmbeddingModel]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [EmbeddingModel] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        TEXT_EMBEDDING_ADA_002,
        TEXT_EMBEDDING_3_SMALL,
        TEXT_EMBEDDING_3_LARGE,
        /**
         * An enum member indicating that [EmbeddingModel] was instantiated with an unknown value.
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
            TEXT_EMBEDDING_ADA_002 -> Value.TEXT_EMBEDDING_ADA_002
            TEXT_EMBEDDING_3_SMALL -> Value.TEXT_EMBEDDING_3_SMALL
            TEXT_EMBEDDING_3_LARGE -> Value.TEXT_EMBEDDING_3_LARGE
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
