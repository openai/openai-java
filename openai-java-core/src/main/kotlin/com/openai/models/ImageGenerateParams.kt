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
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Creates an image given a prompt. */
class ImageGenerateParams
constructor(
    private val body: ImageGenerateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters for
     * `dall-e-2` and 4000 characters for `dall-e-3`.
     */
    fun prompt(): String = body.prompt()

    /** The model to use for image generation. */
    fun model(): Optional<ImageModel> = body.model()

    /**
     * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
     * supported.
     */
    fun n(): Optional<Long> = body.n()

    /**
     * The quality of the image that will be generated. `hd` creates images with finer details and
     * greater consistency across the image. This param is only supported for `dall-e-3`.
     */
    fun quality(): Optional<Quality> = body.quality()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /**
     * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
     * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3` models.
     */
    fun size(): Optional<Size> = body.size()

    /**
     * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
     * model to lean towards generating hyper-real and dramatic images. Natural causes the model to
     * produce more natural, less hyper-real looking images. This param is only supported for
     * `dall-e-3`.
     */
    fun style(): Optional<Style> = body.style()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun user(): Optional<String> = body.user()

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters for
     * `dall-e-2` and 4000 characters for `dall-e-3`.
     */
    fun _prompt(): JsonField<String> = body._prompt()

    /** The model to use for image generation. */
    fun _model(): JsonField<ImageModel> = body._model()

    /**
     * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
     * supported.
     */
    fun _n(): JsonField<Long> = body._n()

    /**
     * The quality of the image that will be generated. `hd` creates images with finer details and
     * greater consistency across the image. This param is only supported for `dall-e-3`.
     */
    fun _quality(): JsonField<Quality> = body._quality()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     */
    fun _responseFormat(): JsonField<ResponseFormat> = body._responseFormat()

    /**
     * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
     * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3` models.
     */
    fun _size(): JsonField<Size> = body._size()

    /**
     * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
     * model to lean towards generating hyper-real and dramatic images. Natural causes the model to
     * produce more natural, less hyper-real looking images. This param is only supported for
     * `dall-e-3`.
     */
    fun _style(): JsonField<Style> = body._style()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun _user(): JsonField<String> = body._user()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): ImageGenerateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class ImageGenerateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("prompt")
        @ExcludeMissing
        private val prompt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ImageModel> = JsonMissing.of(),
        @JsonProperty("n") @ExcludeMissing private val n: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("quality")
        @ExcludeMissing
        private val quality: JsonField<Quality> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        private val responseFormat: JsonField<ResponseFormat> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing private val size: JsonField<Size> = JsonMissing.of(),
        @JsonProperty("style")
        @ExcludeMissing
        private val style: JsonField<Style> = JsonMissing.of(),
        @JsonProperty("user")
        @ExcludeMissing
        private val user: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(): String = prompt.getRequired("prompt")

        /** The model to use for image generation. */
        fun model(): Optional<ImageModel> = Optional.ofNullable(model.getNullable("model"))

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(): Optional<Long> = Optional.ofNullable(n.getNullable("n"))

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(): Optional<Quality> = Optional.ofNullable(quality.getNullable("quality"))

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(): Optional<ResponseFormat> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(): Optional<Size> = Optional.ofNullable(size.getNullable("size"))

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(): Optional<Style> = Optional.ofNullable(style.getNullable("style"))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<String> = prompt

        /** The model to use for image generation. */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ImageModel> = model

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        @JsonProperty("n") @ExcludeMissing fun _n(): JsonField<Long> = n

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Quality> = quality

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<ResponseFormat> = responseFormat

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Size> = size

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        @JsonProperty("style") @ExcludeMissing fun _style(): JsonField<Style> = style

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ImageGenerateBody = apply {
            if (validated) {
                return@apply
            }

            prompt()
            model()
            n()
            quality()
            responseFormat()
            size()
            style()
            user()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var prompt: JsonField<String>? = null
            private var model: JsonField<ImageModel> = JsonMissing.of()
            private var n: JsonField<Long> = JsonMissing.of()
            private var quality: JsonField<Quality> = JsonMissing.of()
            private var responseFormat: JsonField<ResponseFormat> = JsonMissing.of()
            private var size: JsonField<Size> = JsonMissing.of()
            private var style: JsonField<Style> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGenerateBody: ImageGenerateBody) = apply {
                prompt = imageGenerateBody.prompt
                model = imageGenerateBody.model
                n = imageGenerateBody.n
                quality = imageGenerateBody.quality
                responseFormat = imageGenerateBody.responseFormat
                size = imageGenerateBody.size
                style = imageGenerateBody.style
                user = imageGenerateBody.user
                additionalProperties = imageGenerateBody.additionalProperties.toMutableMap()
            }

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2` and 4000 characters for `dall-e-3`.
             */
            fun prompt(prompt: String) = prompt(JsonField.of(prompt))

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2` and 4000 characters for `dall-e-3`.
             */
            fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

            /** The model to use for image generation. */
            fun model(model: ImageModel?) = model(JsonField.ofNullable(model))

            /** The model to use for image generation. */
            fun model(model: Optional<ImageModel>) = model(model.orElse(null))

            /** The model to use for image generation. */
            fun model(model: JsonField<ImageModel>) = apply { this.model = model }

            /** The model to use for image generation. */
            fun model(value: String) = apply { model(ImageModel.of(value)) }

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            fun n(n: Long?) = n(JsonField.ofNullable(n))

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            fun n(n: Long) = n(n as Long?)

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun n(n: Optional<Long>) = n(n.orElse(null) as Long?)

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            fun n(n: JsonField<Long>) = apply { this.n = n }

            /**
             * The quality of the image that will be generated. `hd` creates images with finer
             * details and greater consistency across the image. This param is only supported for
             * `dall-e-3`.
             */
            fun quality(quality: Quality) = quality(JsonField.of(quality))

            /**
             * The quality of the image that will be generated. `hd` creates images with finer
             * details and greater consistency across the image. This param is only supported for
             * `dall-e-3`.
             */
            fun quality(quality: JsonField<Quality>) = apply { this.quality = quality }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            fun responseFormat(responseFormat: ResponseFormat?) =
                responseFormat(JsonField.ofNullable(responseFormat))

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            fun responseFormat(responseFormat: Optional<ResponseFormat>) =
                responseFormat(responseFormat.orElse(null))

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`
             * for `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for
             * `dall-e-3` models.
             */
            fun size(size: Size?) = size(JsonField.ofNullable(size))

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`
             * for `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for
             * `dall-e-3` models.
             */
            fun size(size: Optional<Size>) = size(size.orElse(null))

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`
             * for `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for
             * `dall-e-3` models.
             */
            fun size(size: JsonField<Size>) = apply { this.size = size }

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            fun style(style: Style?) = style(JsonField.ofNullable(style))

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            fun style(style: Optional<Style>) = style(style.orElse(null))

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            fun style(style: JsonField<Style>) = apply { this.style = style }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: JsonField<String>) = apply { this.user = user }

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

            fun build(): ImageGenerateBody =
                ImageGenerateBody(
                    checkRequired("prompt", prompt),
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

        private var body: ImageGenerateBody.Builder = ImageGenerateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(imageGenerateParams: ImageGenerateParams) = apply {
            body = imageGenerateParams.body.toBuilder()
            additionalHeaders = imageGenerateParams.additionalHeaders.toBuilder()
            additionalQueryParams = imageGenerateParams.additionalQueryParams.toBuilder()
        }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(prompt: JsonField<String>) = apply { body.prompt(prompt) }

        /** The model to use for image generation. */
        fun model(model: ImageModel?) = apply { body.model(model) }

        /** The model to use for image generation. */
        fun model(model: Optional<ImageModel>) = model(model.orElse(null))

        /** The model to use for image generation. */
        fun model(model: JsonField<ImageModel>) = apply { body.model(model) }

        /** The model to use for image generation. */
        fun model(value: String) = apply { body.model(value) }

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: Long?) = apply { body.n(n) }

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: Long) = n(n as Long?)

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun n(n: Optional<Long>) = n(n.orElse(null) as Long?)

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: JsonField<Long>) = apply { body.n(n) }

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(quality: Quality) = apply { body.quality(quality) }

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(quality: JsonField<Quality>) = apply { body.quality(quality) }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: ResponseFormat?) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: Optional<ResponseFormat>) =
            responseFormat(responseFormat.orElse(null))

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(size: Size?) = apply { body.size(size) }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(size: Optional<Size>) = size(size.orElse(null))

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(size: JsonField<Size>) = apply { body.size(size) }

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: Style?) = apply { body.style(style) }

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: Optional<Style>) = style(style.orElse(null))

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: JsonField<Style>) = apply { body.style(style) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: JsonField<String>) = apply { body.user(user) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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

        fun build(): ImageGenerateParams =
            ImageGenerateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * The quality of the image that will be generated. `hd` creates images with finer details and
     * greater consistency across the image. This param is only supported for `dall-e-3`.
     */
    class Quality
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STANDARD = of("standard")

            @JvmField val HD = of("hd")

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Quality && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     */
    class ResponseFormat
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val URL = of("url")

            @JvmField val B64_JSON = of("b64_json")

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
     * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3` models.
     */
    class Size
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val _256X256 = of("256x256")

            @JvmField val _512X512 = of("512x512")

            @JvmField val _1024X1024 = of("1024x1024")

            @JvmField val _1792X1024 = of("1792x1024")

            @JvmField val _1024X1792 = of("1024x1792")

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Size && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
     * model to lean towards generating hyper-real and dramatic images. Natural causes the model to
     * produce more natural, less hyper-real looking images. This param is only supported for
     * `dall-e-3`.
     */
    class Style
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VIVID = of("vivid")

            @JvmField val NATURAL = of("natural")

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Style && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageGenerateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ImageGenerateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
