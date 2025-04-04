// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Creates an image given a prompt. */
class ImageGenerateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters for
     * `dall-e-2` and 4000 characters for `dall-e-3`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun prompt(): String = body.prompt()

    /**
     * The model to use for image generation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<ImageModel> = body.model()

    /**
     * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
     * supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun n(): Optional<Long> = body.n()

    /**
     * The quality of the image that will be generated. `hd` creates images with finer details and
     * greater consistency across the image. This param is only supported for `dall-e-3`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quality(): Optional<Quality> = body.quality()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /**
     * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
     * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3` models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Size> = body.size()

    /**
     * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
     * model to lean towards generating hyper-real and dramatic images. Natural causes the model to
     * produce more natural, less hyper-real looking images. This param is only supported for
     * `dall-e-3`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun style(): Optional<Style> = body.style()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun user(): Optional<String> = body.user()

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _prompt(): JsonField<String> = body._prompt()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<ImageModel> = body._model()

    /**
     * Returns the raw JSON value of [n].
     *
     * Unlike [n], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _n(): JsonField<Long> = body._n()

    /**
     * Returns the raw JSON value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quality(): JsonField<Quality> = body._quality()

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseFormat(): JsonField<ResponseFormat> = body._responseFormat()

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _size(): JsonField<Size> = body._size()

    /**
     * Returns the raw JSON value of [style].
     *
     * Unlike [style], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _style(): JsonField<Style> = body._style()

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _user(): JsonField<String> = body._user()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ImageGenerateParams].
         *
         * The following fields are required:
         * ```java
         * .prompt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageGenerateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(imageGenerateParams: ImageGenerateParams) = apply {
            body = imageGenerateParams.body.toBuilder()
            additionalHeaders = imageGenerateParams.additionalHeaders.toBuilder()
            additionalQueryParams = imageGenerateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [prompt]
         * - [model]
         * - [n]
         * - [quality]
         * - [responseFormat]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: JsonField<String>) = apply { body.prompt(prompt) }

        /** The model to use for image generation. */
        fun model(model: ImageModel?) = apply { body.model(model) }

        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
        fun model(model: Optional<ImageModel>) = model(model.getOrNull())

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [ImageModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: JsonField<ImageModel>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [ImageModel] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: Long?) = apply { body.n(n) }

        /**
         * Alias for [Builder.n].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun n(n: Long) = n(n as Long?)

        /** Alias for calling [Builder.n] with `n.orElse(null)`. */
        fun n(n: Optional<Long>) = n(n.getOrNull())

        /**
         * Sets [Builder.n] to an arbitrary JSON value.
         *
         * You should usually call [Builder.n] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun n(n: JsonField<Long>) = apply { body.n(n) }

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(quality: Quality) = apply { body.quality(quality) }

        /**
         * Sets [Builder.quality] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quality] with a well-typed [Quality] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quality(quality: JsonField<Quality>) = apply { body.quality(quality) }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: ResponseFormat?) = apply {
            body.responseFormat(responseFormat)
        }

        /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
        fun responseFormat(responseFormat: Optional<ResponseFormat>) =
            responseFormat(responseFormat.getOrNull())

        /**
         * Sets [Builder.responseFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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

        /** Alias for calling [Builder.size] with `size.orElse(null)`. */
        fun size(size: Optional<Size>) = size(size.getOrNull())

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Size] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Size>) = apply { body.size(size) }

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: Style?) = apply { body.style(style) }

        /** Alias for calling [Builder.style] with `style.orElse(null)`. */
        fun style(style: Optional<Style>) = style(style.getOrNull())

        /**
         * Sets [Builder.style] to an arbitrary JSON value.
         *
         * You should usually call [Builder.style] with a well-typed [Style] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun style(style: JsonField<Style>) = apply { body.style(style) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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

        /**
         * Returns an immutable instance of [ImageGenerateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .prompt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageGenerateParams =
            ImageGenerateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val prompt: JsonField<String>,
        private val model: JsonField<ImageModel>,
        private val n: JsonField<Long>,
        private val quality: JsonField<Quality>,
        private val responseFormat: JsonField<ResponseFormat>,
        private val size: JsonField<Size>,
        private val style: JsonField<Style>,
        private val user: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("prompt") @ExcludeMissing prompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<ImageModel> = JsonMissing.of(),
            @JsonProperty("n") @ExcludeMissing n: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quality") @ExcludeMissing quality: JsonField<Quality> = JsonMissing.of(),
            @JsonProperty("response_format")
            @ExcludeMissing
            responseFormat: JsonField<ResponseFormat> = JsonMissing.of(),
            @JsonProperty("size") @ExcludeMissing size: JsonField<Size> = JsonMissing.of(),
            @JsonProperty("style") @ExcludeMissing style: JsonField<Style> = JsonMissing.of(),
            @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
        ) : this(prompt, model, n, quality, responseFormat, size, style, user, mutableMapOf())

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prompt(): String = prompt.getRequired("prompt")

        /**
         * The model to use for image generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<ImageModel> = model.getOptional("model")

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun n(): Optional<Long> = n.getOptional("n")

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun quality(): Optional<Quality> = quality.getOptional("quality")

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<ResponseFormat> =
            responseFormat.getOptional("response_format")

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun size(): Optional<Size> = size.getOptional("size")

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun style(): Optional<Style> = style.getOptional("style")

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun user(): Optional<String> = user.getOptional("user")

        /**
         * Returns the raw JSON value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<String> = prompt

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ImageModel> = model

        /**
         * Returns the raw JSON value of [n].
         *
         * Unlike [n], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("n") @ExcludeMissing fun _n(): JsonField<Long> = n

        /**
         * Returns the raw JSON value of [quality].
         *
         * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Quality> = quality

        /**
         * Returns the raw JSON value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<ResponseFormat> = responseFormat

        /**
         * Returns the raw JSON value of [size].
         *
         * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Size> = size

        /**
         * Returns the raw JSON value of [style].
         *
         * Unlike [style], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("style") @ExcludeMissing fun _style(): JsonField<Style> = style

        /**
         * Returns the raw JSON value of [user].
         *
         * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .prompt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

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
            internal fun from(body: Body) = apply {
                prompt = body.prompt
                model = body.model
                n = body.n
                quality = body.quality
                responseFormat = body.responseFormat
                size = body.size
                style = body.style
                user = body.user
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2` and 4000 characters for `dall-e-3`.
             */
            fun prompt(prompt: String) = prompt(JsonField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

            /** The model to use for image generation. */
            fun model(model: ImageModel?) = model(JsonField.ofNullable(model))

            /** Alias for calling [Builder.model] with `model.orElse(null)`. */
            fun model(model: Optional<ImageModel>) = model(model.getOrNull())

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [ImageModel] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<ImageModel>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [ImageModel] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(ImageModel.of(value))

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            fun n(n: Long?) = n(JsonField.ofNullable(n))

            /**
             * Alias for [Builder.n].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun n(n: Long) = n(n as Long?)

            /** Alias for calling [Builder.n] with `n.orElse(null)`. */
            fun n(n: Optional<Long>) = n(n.getOrNull())

            /**
             * Sets [Builder.n] to an arbitrary JSON value.
             *
             * You should usually call [Builder.n] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun n(n: JsonField<Long>) = apply { this.n = n }

            /**
             * The quality of the image that will be generated. `hd` creates images with finer
             * details and greater consistency across the image. This param is only supported for
             * `dall-e-3`.
             */
            fun quality(quality: Quality) = quality(JsonField.of(quality))

            /**
             * Sets [Builder.quality] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quality] with a well-typed [Quality] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quality(quality: JsonField<Quality>) = apply { this.quality = quality }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            fun responseFormat(responseFormat: ResponseFormat?) =
                responseFormat(JsonField.ofNullable(responseFormat))

            /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
            fun responseFormat(responseFormat: Optional<ResponseFormat>) =
                responseFormat(responseFormat.getOrNull())

            /**
             * Sets [Builder.responseFormat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /** Alias for calling [Builder.size] with `size.orElse(null)`. */
            fun size(size: Optional<Size>) = size(size.getOrNull())

            /**
             * Sets [Builder.size] to an arbitrary JSON value.
             *
             * You should usually call [Builder.size] with a well-typed [Size] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun size(size: JsonField<Size>) = apply { this.size = size }

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            fun style(style: Style?) = style(JsonField.ofNullable(style))

            /** Alias for calling [Builder.style] with `style.orElse(null)`. */
            fun style(style: Optional<Style>) = style(style.getOrNull())

            /**
             * Sets [Builder.style] to an arbitrary JSON value.
             *
             * You should usually call [Builder.style] with a well-typed [Style] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun style(style: JsonField<Style>) = apply { this.style = style }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary JSON value.
             *
             * You should usually call [Builder.user] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .prompt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("prompt", prompt),
                    model,
                    n,
                    quality,
                    responseFormat,
                    size,
                    style,
                    user,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            prompt()
            model().ifPresent { it.validate() }
            n()
            quality().ifPresent { it.validate() }
            responseFormat().ifPresent { it.validate() }
            size().ifPresent { it.validate() }
            style().ifPresent { it.validate() }
            user()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (prompt.asKnown().isPresent) 1 else 0) +
                (model.asKnown().getOrNull()?.validity() ?: 0) +
                (if (n.asKnown().isPresent) 1 else 0) +
                (quality.asKnown().getOrNull()?.validity() ?: 0) +
                (responseFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (size.asKnown().getOrNull()?.validity() ?: 0) +
                (style.asKnown().getOrNull()?.validity() ?: 0) +
                (if (user.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && prompt == other.prompt && model == other.model && n == other.n && quality == other.quality && responseFormat == other.responseFormat && size == other.size && style == other.style && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(prompt, model, n, quality, responseFormat, size, style, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{prompt=$prompt, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, style=$style, user=$user, additionalProperties=$additionalProperties}"
    }

    /**
     * The quality of the image that will be generated. `hd` creates images with finer details and
     * greater consistency across the image. This param is only supported for `dall-e-3`.
     */
    class Quality @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STANDARD = of("standard")

            @JvmField val HD = of("hd")

            @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
        }

        /** An enum containing [Quality]'s known values. */
        enum class Known {
            STANDARD,
            HD,
        }

        /**
         * An enum containing [Quality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Quality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STANDARD,
            HD,
            /** An enum member indicating that [Quality] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                STANDARD -> Value.STANDARD
                HD -> Value.HD
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                STANDARD -> Known.STANDARD
                HD -> Known.HD
                else -> throw OpenAIInvalidDataException("Unknown Quality: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Quality = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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
    class ResponseFormat @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val URL = of("url")

            @JvmField val B64_JSON = of("b64_json")

            @JvmStatic fun of(value: String) = ResponseFormat(JsonField.of(value))
        }

        /** An enum containing [ResponseFormat]'s known values. */
        enum class Known {
            URL,
            B64_JSON,
        }

        /**
         * An enum containing [ResponseFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ResponseFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            URL,
            B64_JSON,
            /**
             * An enum member indicating that [ResponseFormat] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                URL -> Value.URL
                B64_JSON -> Value.B64_JSON
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                URL -> Known.URL
                B64_JSON -> Known.B64_JSON
                else -> throw OpenAIInvalidDataException("Unknown ResponseFormat: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): ResponseFormat = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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
    class Size @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val _256X256 = of("256x256")

            @JvmField val _512X512 = of("512x512")

            @JvmField val _1024X1024 = of("1024x1024")

            @JvmField val _1792X1024 = of("1792x1024")

            @JvmField val _1024X1792 = of("1024x1792")

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        /** An enum containing [Size]'s known values. */
        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
        }

        /**
         * An enum containing [Size]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Size] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
            /** An enum member indicating that [Size] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                _256X256 -> Value._256X256
                _512X512 -> Value._512X512
                _1024X1024 -> Value._1024X1024
                _1792X1024 -> Value._1792X1024
                _1024X1792 -> Value._1024X1792
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                _256X256 -> Known._256X256
                _512X512 -> Known._512X512
                _1024X1024 -> Known._1024X1024
                _1792X1024 -> Known._1792X1024
                _1024X1792 -> Known._1024X1792
                else -> throw OpenAIInvalidDataException("Unknown Size: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Size = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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
    class Style @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VIVID = of("vivid")

            @JvmField val NATURAL = of("natural")

            @JvmStatic fun of(value: String) = Style(JsonField.of(value))
        }

        /** An enum containing [Style]'s known values. */
        enum class Known {
            VIVID,
            NATURAL,
        }

        /**
         * An enum containing [Style]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Style] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            VIVID,
            NATURAL,
            /** An enum member indicating that [Style] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                VIVID -> Value.VIVID
                NATURAL -> Value.NATURAL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                VIVID -> Known.VIVID
                NATURAL -> Known.NATURAL
                else -> throw OpenAIInvalidDataException("Unknown Style: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Style = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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
