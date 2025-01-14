// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** The text content that is part of a message. */
@NoAutoDetect
class TextDeltaBlock
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<TextDelta> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part in the message. */
    fun index(): Long = index.getRequired("index")

    /** Always `text`. */
    fun type(): Type = type.getRequired("type")

    fun text(): Optional<TextDelta> = Optional.ofNullable(text.getNullable("text"))

    /** The index of the content part in the message. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** Always `text`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<TextDelta> = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TextDeltaBlock = apply {
        if (validated) {
            return@apply
        }

        index()
        type()
        text().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var text: JsonField<TextDelta> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(textDeltaBlock: TextDeltaBlock) = apply {
            index = textDeltaBlock.index
            type = textDeltaBlock.type
            text = textDeltaBlock.text
            additionalProperties = textDeltaBlock.additionalProperties.toMutableMap()
        }

        /** The index of the content part in the message. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the content part in the message. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `text`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `text`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun text(text: TextDelta) = text(JsonField.of(text))

        fun text(text: JsonField<TextDelta>) = apply { this.text = text }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): TextDeltaBlock =
            TextDeltaBlock(
                checkRequired("index", index),
                checkRequired("type", type),
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

        return /* spotless:off */ other is TextDeltaBlock && index == other.index && type == other.type && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, text, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TextDeltaBlock{index=$index, type=$type, text=$text, additionalProperties=$additionalProperties}"
}
