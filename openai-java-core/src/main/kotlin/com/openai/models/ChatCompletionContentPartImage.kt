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
import java.util.Optional

/** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
@JsonDeserialize(builder = ChatCompletionContentPartImage.Builder::class)
@NoAutoDetect
class ChatCompletionContentPartImage
private constructor(
    private val type: JsonField<Type>,
    private val imageUrl: JsonField<ImageUrl>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The type of the content part. */
    fun type(): Type = type.getRequired("type")

    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

    /** The type of the content part. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl() = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionContentPartImage = apply {
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
        internal fun from(chatCompletionContentPartImage: ChatCompletionContentPartImage) = apply {
            this.type = chatCompletionContentPartImage.type
            this.imageUrl = chatCompletionContentPartImage.imageUrl
            additionalProperties(chatCompletionContentPartImage.additionalProperties)
        }

        /** The type of the content part. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun imageUrl(imageUrl: ImageUrl) = imageUrl(JsonField.of(imageUrl))

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

        fun build(): ChatCompletionContentPartImage =
            ChatCompletionContentPartImage(
                type,
                imageUrl,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = ImageUrl.Builder::class)
    @NoAutoDetect
    class ImageUrl
    private constructor(
        private val url: JsonField<String>,
        private val detail: JsonField<Detail>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** Either a URL of the image or the base64 encoded image data. */
        fun url(): String = url.getRequired("url")

        /**
         * Specifies the detail level of the image. Learn more in the
         * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
         */
        fun detail(): Optional<Detail> = Optional.ofNullable(detail.getNullable("detail"))

        /** Either a URL of the image or the base64 encoded image data. */
        @JsonProperty("url") @ExcludeMissing fun _url() = url

        /**
         * Specifies the detail level of the image. Learn more in the
         * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
         */
        @JsonProperty("detail") @ExcludeMissing fun _detail() = detail

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): ImageUrl = apply {
            if (!validated) {
                url()
                detail()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var url: JsonField<String> = JsonMissing.of()
            private var detail: JsonField<Detail> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageUrl: ImageUrl) = apply {
                this.url = imageUrl.url
                this.detail = imageUrl.detail
                additionalProperties(imageUrl.additionalProperties)
            }

            /** Either a URL of the image or the base64 encoded image data. */
            fun url(url: String) = url(JsonField.of(url))

            /** Either a URL of the image or the base64 encoded image data. */
            @JsonProperty("url")
            @ExcludeMissing
            fun url(url: JsonField<String>) = apply { this.url = url }

            /**
             * Specifies the detail level of the image. Learn more in the
             * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
             */
            fun detail(detail: Detail) = detail(JsonField.of(detail))

            /**
             * Specifies the detail level of the image. Learn more in the
             * [Vision guide](https://platform.openai.com/docs/guides/vision#low-or-high-fidelity-image-understanding).
             */
            @JsonProperty("detail")
            @ExcludeMissing
            fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

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

            fun build(): ImageUrl =
                ImageUrl(
                    url,
                    detail,
                    additionalProperties.toImmutable(),
                )
        }

        class Detail
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val AUTO = of("auto")

                @JvmField val LOW = of("low")

                @JvmField val HIGH = of("high")

                @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
            }

            enum class Known {
                AUTO,
                LOW,
                HIGH,
            }

            enum class Value {
                AUTO,
                LOW,
                HIGH,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    AUTO -> Value.AUTO
                    LOW -> Value.LOW
                    HIGH -> Value.HIGH
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    AUTO -> Known.AUTO
                    LOW -> Known.LOW
                    HIGH -> Known.HIGH
                    else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Detail && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ImageUrl && url == other.url && detail == other.detail && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(url, detail, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageUrl{url=$url, detail=$detail, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is ChatCompletionContentPartImage && type == other.type && imageUrl == other.imageUrl && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, imageUrl, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionContentPartImage{type=$type, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
