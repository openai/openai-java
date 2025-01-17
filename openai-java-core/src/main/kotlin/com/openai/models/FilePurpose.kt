// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The intended purpose of the uploaded file.
 *
 * Use "assistants" for [Assistants](https://platform.openai.com/docs/api-reference/assistants) and
 * [Message](https://platform.openai.com/docs/api-reference/messages) files, "vision" for Assistants
 * image file inputs, "batch" for [Batch API](https://platform.openai.com/docs/guides/batch), and
 * "fine-tune" for [Fine-tuning](https://platform.openai.com/docs/api-reference/fine-tuning).
 */
class FilePurpose
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val ASSISTANTS = of("assistants")

        @JvmField val BATCH = of("batch")

        @JvmField val FINE_TUNE = of("fine-tune")

        @JvmField val VISION = of("vision")

        @JvmStatic fun of(value: String) = FilePurpose(JsonField.of(value))
    }

    enum class Known {
        ASSISTANTS,
        BATCH,
        FINE_TUNE,
        VISION,
    }

    enum class Value {
        ASSISTANTS,
        BATCH,
        FINE_TUNE,
        VISION,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            ASSISTANTS -> Value.ASSISTANTS
            BATCH -> Value.BATCH
            FINE_TUNE -> Value.FINE_TUNE
            VISION -> Value.VISION
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            ASSISTANTS -> Known.ASSISTANTS
            BATCH -> Known.BATCH
            FINE_TUNE -> Known.FINE_TUNE
            VISION -> Known.VISION
            else -> throw OpenAIInvalidDataException("Unknown FilePurpose: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FilePurpose && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
