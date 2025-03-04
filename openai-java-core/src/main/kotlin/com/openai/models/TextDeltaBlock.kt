// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<TextDelta> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part in the message. */
    fun index(): Long = index.getRequired("index")

    /** Always `text`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    fun text(): Optional<TextDelta> = Optional.ofNullable(text.getNullable("text"))

    /** The index of the content part in the message. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

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
        _type().let {
            if (it != JsonValue.from("text")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        text().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TextDeltaBlock].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TextDeltaBlock]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("text")
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
        fun type(type: JsonValue) = apply { this.type = type }

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
                type,
                text,
                additionalProperties.toImmutable(),
            )
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
