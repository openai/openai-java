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
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class ImageGenerateParams
constructor(
    private val prompt: String,
    private val model: Model?,
    private val n: Long?,
    private val quality: Quality?,
    private val responseFormat: ResponseFormat?,
    private val size: Size?,
    private val style: Style?,
    private val user: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun prompt(): String = prompt

    fun model(): Optional<Model> = Optional.ofNullable(model)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun quality(): Optional<Quality> = Optional.ofNullable(quality)

    fun responseFormat(): Optional<ResponseFormat> = Optional.ofNullable(responseFormat)

    fun size(): Optional<Size> = Optional.ofNullable(size)

    fun style(): Optional<Style> = Optional.ofNullable(style)

    fun user(): Optional<String> = Optional.ofNullable(user)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    @JvmSynthetic
    internal fun getBody(): ImageGenerateBody {
        return ImageGenerateBody(
            prompt,
            model,
            n,
            quality,
            responseFormat,
            size,
            style,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(builder = ImageGenerateBody.Builder::class)
    @NoAutoDetect
    class ImageGenerateBody
    internal constructor(
        private val prompt: String?,
        private val model: Model?,
        private val n: Long?,
        private val quality: Quality?,
        private val responseFormat: ResponseFormat?,
        private val size: Size?,
        private val style: Style?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        @JsonProperty("prompt") fun prompt(): String? = prompt

        /** The model to use for image generation. */
        @JsonProperty("model") fun model(): Model? = model

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        @JsonProperty("quality") fun quality(): Quality? = quality

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        @JsonProperty("response_format") fun responseFormat(): ResponseFormat? = responseFormat

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        @JsonProperty("size") fun size(): Size? = size

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        @JsonProperty("style") fun style(): Style? = style

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") fun user(): String? = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var prompt: String? = null
            private var model: Model? = null
            private var n: Long? = null
            private var quality: Quality? = null
            private var responseFormat: ResponseFormat? = null
            private var size: Size? = null
            private var style: Style? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGenerateBody: ImageGenerateBody) = apply {
                this.prompt = imageGenerateBody.prompt
                this.model = imageGenerateBody.model
                this.n = imageGenerateBody.n
                this.quality = imageGenerateBody.quality
                this.responseFormat = imageGenerateBody.responseFormat
                this.size = imageGenerateBody.size
                this.style = imageGenerateBody.style
                this.user = imageGenerateBody.user
                additionalProperties(imageGenerateBody.additionalProperties)
            }

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2` and 4000 characters for `dall-e-3`.
             */
            @JsonProperty("prompt") fun prompt(prompt: String) = apply { this.prompt = prompt }

            /** The model to use for image generation. */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * The quality of the image that will be generated. `hd` creates images with finer
             * details and greater consistency across the image. This param is only supported for
             * `dall-e-3`.
             */
            @JsonProperty("quality")
            fun quality(quality: Quality) = apply { this.quality = quality }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            @JsonProperty("response_format")
            fun responseFormat(responseFormat: ResponseFormat) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`
             * for `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for
             * `dall-e-3` models.
             */
            @JsonProperty("size") fun size(size: Size) = apply { this.size = size }

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            @JsonProperty("style") fun style(style: Style) = apply { this.style = style }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

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

            fun build(): ImageGenerateBody =
                ImageGenerateBody(
                    checkNotNull(prompt) { "`prompt` is required but was not set" },
                    model,
                    n,
                    quality,
                    responseFormat,
                    size,
                    style,
                    user,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ImageGenerateBody && prompt == other.prompt && model == other.model && n == other.n && quality == other.quality && responseFormat == other.responseFormat && size == other.size && style == other.style && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(prompt, model, n, quality, responseFormat, size, style, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageGenerateBody{prompt=$prompt, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, style=$style, user=$user, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var prompt: String? = null
        private var model: Model? = null
        private var n: Long? = null
        private var quality: Quality? = null
        private var responseFormat: ResponseFormat? = null
        private var size: Size? = null
        private var style: Style? = null
        private var user: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageGenerateParams: ImageGenerateParams) = apply {
            prompt = imageGenerateParams.prompt
            model = imageGenerateParams.model
            n = imageGenerateParams.n
            quality = imageGenerateParams.quality
            responseFormat = imageGenerateParams.responseFormat
            size = imageGenerateParams.size
            style = imageGenerateParams.style
            user = imageGenerateParams.user
            additionalHeaders = imageGenerateParams.additionalHeaders.toBuilder()
            additionalQueryParams = imageGenerateParams.additionalQueryParams.toBuilder()
            additionalBodyProperties = imageGenerateParams.additionalBodyProperties.toMutableMap()
        }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(prompt: String) = apply { this.prompt = prompt }

        /** The model to use for image generation. */
        fun model(model: Model) = apply { this.model = model }

        /** The model to use for image generation. */
        fun model(value: String) = apply { this.model = Model.of(value) }

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: Long) = apply { this.n = n }

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(quality: Quality) = apply { this.quality = quality }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            this.responseFormat = responseFormat
        }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(size: Size) = apply { this.size = size }

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: Style) = apply { this.style = style }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { this.user = user }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): ImageGenerateParams =
            ImageGenerateParams(
                checkNotNull(prompt) { "`prompt` is required but was not set" },
                model,
                n,
                quality,
                responseFormat,
                size,
                style,
                user,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    class Model
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val DALL_E_2 = Model(JsonField.of("dall-e-2"))

            @JvmField val DALL_E_3 = Model(JsonField.of("dall-e-3"))

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        enum class Known {
            DALL_E_2,
            DALL_E_3,
        }

        enum class Value {
            DALL_E_2,
            DALL_E_3,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                DALL_E_2 -> Value.DALL_E_2
                DALL_E_3 -> Value.DALL_E_3
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                DALL_E_2 -> Known.DALL_E_2
                DALL_E_3 -> Known.DALL_E_3
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Quality
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Quality && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STANDARD = Quality(JsonField.of("standard"))

            @JvmField val HD = Quality(JsonField.of("hd"))

            @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
        }

        enum class Known {
            STANDARD,
            HD,
        }

        enum class Value {
            STANDARD,
            HD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STANDARD -> Value.STANDARD
                HD -> Value.HD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STANDARD -> Known.STANDARD
                HD -> Known.HD
                else -> throw OpenAIInvalidDataException("Unknown Quality: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ResponseFormat
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val URL = ResponseFormat(JsonField.of("url"))

            @JvmField val B64_JSON = ResponseFormat(JsonField.of("b64_json"))

            @JvmStatic fun of(value: String) = ResponseFormat(JsonField.of(value))
        }

        enum class Known {
            URL,
            B64_JSON,
        }

        enum class Value {
            URL,
            B64_JSON,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                URL -> Value.URL
                B64_JSON -> Value.B64_JSON
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                URL -> Known.URL
                B64_JSON -> Known.B64_JSON
                else -> throw OpenAIInvalidDataException("Unknown ResponseFormat: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Size
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Size && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val _256X256 = Size(JsonField.of("256x256"))

            @JvmField val _512X512 = Size(JsonField.of("512x512"))

            @JvmField val _1024X1024 = Size(JsonField.of("1024x1024"))

            @JvmField val _1792X1024 = Size(JsonField.of("1792x1024"))

            @JvmField val _1024X1792 = Size(JsonField.of("1024x1792"))

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
        }

        enum class Value {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                _256X256 -> Value._256X256
                _512X512 -> Value._512X512
                _1024X1024 -> Value._1024X1024
                _1792X1024 -> Value._1792X1024
                _1024X1792 -> Value._1024X1792
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                _256X256 -> Known._256X256
                _512X512 -> Known._512X512
                _1024X1024 -> Known._1024X1024
                _1792X1024 -> Known._1792X1024
                _1024X1792 -> Known._1024X1792
                else -> throw OpenAIInvalidDataException("Unknown Size: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Style
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Style && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VIVID = Style(JsonField.of("vivid"))

            @JvmField val NATURAL = Style(JsonField.of("natural"))

            @JvmStatic fun of(value: String) = Style(JsonField.of(value))
        }

        enum class Known {
            VIVID,
            NATURAL,
        }

        enum class Value {
            VIVID,
            NATURAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VIVID -> Value.VIVID
                NATURAL -> Value.NATURAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VIVID -> Known.VIVID
                NATURAL -> Known.NATURAL
                else -> throw OpenAIInvalidDataException("Unknown Style: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageGenerateParams && prompt == other.prompt && model == other.model && n == other.n && quality == other.quality && responseFormat == other.responseFormat && size == other.size && style == other.style && user == other.user && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(prompt, model, n, quality, responseFormat, size, style, user, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "ImageGenerateParams{prompt=$prompt, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, style=$style, user=$user, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
