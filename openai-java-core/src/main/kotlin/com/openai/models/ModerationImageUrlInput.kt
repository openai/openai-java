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

/** An object describing an image to classify. */
@JsonDeserialize(builder = ModerationImageUrlInput.Builder::class)
@NoAutoDetect
class ModerationImageUrlInput
private constructor(
    private val type: JsonField<Type>,
    private val imageUrl: JsonField<ImageUrl>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** Always `image_url`. */
    fun type(): Type = type.getRequired("type")

    /** Contains either an image URL or a data URL for a base64 encoded image. */
    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

    /** Always `image_url`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** Contains either an image URL or a data URL for a base64 encoded image. */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl() = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ModerationImageUrlInput = apply {
        if (!validated) {
            type()
            imageUrl().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var imageUrl: JsonField<ImageUrl> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationImageUrlInput: ModerationImageUrlInput) = apply {
            this.type = moderationImageUrlInput.type
            this.imageUrl = moderationImageUrlInput.imageUrl
            additionalProperties(moderationImageUrlInput.additionalProperties)
        }

        /** Always `image_url`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `image_url`. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Contains either an image URL or a data URL for a base64 encoded image. */
        fun imageUrl(imageUrl: ImageUrl) = imageUrl(JsonField.of(imageUrl))

        /** Contains either an image URL or a data URL for a base64 encoded image. */
        @JsonProperty("image_url")
        @ExcludeMissing
        fun imageUrl(imageUrl: JsonField<ImageUrl>) = apply { this.imageUrl = imageUrl }

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

        fun build(): ModerationImageUrlInput =
            ModerationImageUrlInput(
                type,
                imageUrl,
                additionalProperties.toImmutable(),
            )
    }

    /** Contains either an image URL or a data URL for a base64 encoded image. */
    @JsonDeserialize(builder = ImageUrl.Builder::class)
    @NoAutoDetect
    class ImageUrl
    private constructor(
        private val url: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** Either a URL of the image or the base64 encoded image data. */
        fun url(): String = url.getRequired("url")

        /** Either a URL of the image or the base64 encoded image data. */
        @JsonProperty("url") @ExcludeMissing fun _url() = url

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): ImageUrl = apply {
            if (!validated) {
                url()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageUrl: ImageUrl) = apply {
                this.url = imageUrl.url
                additionalProperties(imageUrl.additionalProperties)
            }

            /** Either a URL of the image or the base64 encoded image data. */
            fun url(url: String) = url(JsonField.of(url))

            /** Either a URL of the image or the base64 encoded image data. */
            @JsonProperty("url")
            @ExcludeMissing
            fun url(url: JsonField<String>) = apply { this.url = url }

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

            fun build(): ImageUrl = ImageUrl(url, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ImageUrl && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "ImageUrl{url=$url, additionalProperties=$additionalProperties}"
    }

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

        return /* spotless:off */ other is ModerationImageUrlInput && type == other.type && imageUrl == other.imageUrl && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, imageUrl, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ModerationImageUrlInput{type=$type, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
