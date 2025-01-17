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

/** References an image URL in the content of a message. */
@NoAutoDetect
class ImageUrlDeltaBlock
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("image_url")
    @ExcludeMissing
    private val imageUrl: JsonField<ImageUrlDelta> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part in the message. */
    fun index(): Long = index.getRequired("index")

    /** Always `image_url`. */
    fun type(): Type = type.getRequired("type")

    fun imageUrl(): Optional<ImageUrlDelta> = Optional.ofNullable(imageUrl.getNullable("image_url"))

    /** The index of the content part in the message. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** Always `image_url`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<ImageUrlDelta> = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageUrlDeltaBlock = apply {
        if (validated) {
            return@apply
        }

        index()
        type()
        imageUrl().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var imageUrl: JsonField<ImageUrlDelta> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageUrlDeltaBlock: ImageUrlDeltaBlock) = apply {
            index = imageUrlDeltaBlock.index
            type = imageUrlDeltaBlock.type
            imageUrl = imageUrlDeltaBlock.imageUrl
            additionalProperties = imageUrlDeltaBlock.additionalProperties.toMutableMap()
        }

        /** The index of the content part in the message. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the content part in the message. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `image_url`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `image_url`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun imageUrl(imageUrl: ImageUrlDelta) = imageUrl(JsonField.of(imageUrl))

        fun imageUrl(imageUrl: JsonField<ImageUrlDelta>) = apply { this.imageUrl = imageUrl }

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

        fun build(): ImageUrlDeltaBlock =
            ImageUrlDeltaBlock(
                checkRequired("index", index),
                checkRequired("type", type),
                imageUrl,
                additionalProperties.toImmutable(),
            )
    }

    /** Always `image_url`. */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IMAGE_URL = of("image_url")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            IMAGE_URL,
        }

        enum class Value {
            IMAGE_URL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IMAGE_URL -> Value.IMAGE_URL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IMAGE_URL -> Known.IMAGE_URL
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

        return /* spotless:off */ other is ImageUrlDeltaBlock && index == other.index && type == other.type && imageUrl == other.imageUrl && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, imageUrl, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageUrlDeltaBlock{index=$index, type=$type, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
