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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
@NoAutoDetect
class ChatCompletionContentPartImage
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("image_url")
    @ExcludeMissing
    private val imageUrl: JsonField<ImageUrl> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of the content part. */
    fun type(): Type = type.getRequired("type")

    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

    /** The type of the content part. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl() = imageUrl

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

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
            type = chatCompletionContentPartImage.type
            imageUrl = chatCompletionContentPartImage.imageUrl
            additionalProperties =
                chatCompletionContentPartImage.additionalProperties.toMutableMap()
        }

        /** The type of the content part. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun imageUrl(imageUrl: ImageUrl) = imageUrl(JsonField.of(imageUrl))

        fun imageUrl(imageUrl: JsonField<ImageUrl>) = apply { this.imageUrl = imageUrl }

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

        fun build(): ChatCompletionContentPartImage =
            ChatCompletionContentPartImage(
                type,
                imageUrl,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class ImageUrl
    @JsonCreator
    private constructor(
        @JsonProperty("url") @ExcludeMissing private val url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("detail")
        @ExcludeMissing
        private val detail: JsonField<Detail> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

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

        private var validated: Boolean = false

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
                url = imageUrl.url
                detail = imageUrl.detail
                additionalProperties = imageUrl.additionalProperties.toMutableMap()
            }

            /** Either a URL of the image or the base64 encoded image data. */
            fun url(url: String) = url(JsonField.of(url))

            /** Either a URL of the image or the base64 encoded image data. */
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
            fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

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
