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

/** References an image URL in the content of a message. */
@NoAutoDetect
class ImageUrlContentBlock
@JsonCreator
private constructor(
    @JsonProperty("image_url")
    @ExcludeMissing
    private val imageUrl: JsonField<ImageUrl> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

    /** The type of the content part. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<ImageUrl> = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImageUrlContentBlock = apply {
        if (validated) {
            return@apply
        }

        imageUrl().validate()
        _type().let {
            if (it != JsonValue.from("image_url")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ImageUrlContentBlock].
         *
         * The following fields are required:
         * ```java
         * .imageUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageUrlContentBlock]. */
    class Builder internal constructor() {

        private var imageUrl: JsonField<ImageUrl>? = null
        private var type: JsonValue = JsonValue.from("image_url")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageUrlContentBlock: ImageUrlContentBlock) = apply {
            imageUrl = imageUrlContentBlock.imageUrl
            type = imageUrlContentBlock.type
            additionalProperties = imageUrlContentBlock.additionalProperties.toMutableMap()
        }

        fun imageUrl(imageUrl: ImageUrl) = imageUrl(JsonField.of(imageUrl))

        fun imageUrl(imageUrl: JsonField<ImageUrl>) = apply { this.imageUrl = imageUrl }

        /** The type of the content part. */
        fun type(type: JsonValue) = apply { this.type = type }

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

        fun build(): ImageUrlContentBlock =
            ImageUrlContentBlock(
                checkRequired("imageUrl", imageUrl),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageUrlContentBlock && imageUrl == other.imageUrl && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(imageUrl, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImageUrlContentBlock{imageUrl=$imageUrl, type=$type, additionalProperties=$additionalProperties}"
}
