// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** An object describing text to classify. */
@JsonDeserialize(builder = ModerationTextInput.Builder::class)
@NoAutoDetect
class ModerationTextInput
private constructor(
    private val type: JsonField<Type>,
    private val text: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** Always `text`. */
    fun type(): Type = type.getRequired("type")

    /** A string of text to classify. */
    fun text(): String = text.getRequired("text")

    /** Always `text`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** A string of text to classify. */
    @JsonProperty("text") @ExcludeMissing fun _text() = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ModerationTextInput = apply {
        if (!validated) {
            type()
            text()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationTextInput: ModerationTextInput) = apply {
            this.type = moderationTextInput.type
            this.text = moderationTextInput.text
            additionalProperties(moderationTextInput.additionalProperties)
        }

        /** Always `text`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `text`. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** A string of text to classify. */
        fun text(text: String) = text(JsonField.of(text))

        /** A string of text to classify. */
        @JsonProperty("text")
        @ExcludeMissing
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ModerationTextInput =
            ModerationTextInput(
                type,
                text,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TEXT = of("text")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            TEXT,
        }

        enum class Value {
            TEXT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TEXT -> Value.TEXT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TEXT -> Known.TEXT
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationTextInput && type == other.type && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, text, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ModerationTextInput{type=$type, text=$text, additionalProperties=$additionalProperties}"
}
