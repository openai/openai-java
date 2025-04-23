// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name
import kotlin.jvm.optionals.getOrNull

/**
 * Creates an edited or extended image given one or more source images and a prompt. This endpoint
 * only supports `gpt-image-1` and `dall-e-2`.
 */
class ImageEditParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The image(s) to edit. Must be a supported image file or an array of images. For
     * `gpt-image-1`, each image should be a `png`, `webp`, or `jpg` file less than 25MB. For
     * `dall-e-2`, you can only provide one image, and it should be a square `png` file less than
     * 4MB.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun image(): Image = body.image()

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters for
     * `dall-e-2`, and 32000 characters for `gpt-image-1`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun prompt(): String = body.prompt()

    /**
     * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where
     * `image` should be edited. If there are multiple images provided, the mask will be applied on
     * the first image. Must be a valid PNG file, less than 4MB, and have the same dimensions as
     * `image`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mask(): Optional<InputStream> = body.mask()

    /**
     * The model to use for image generation. Only `dall-e-2` and `gpt-image-1` are supported.
     * Defaults to `dall-e-2` unless a parameter specific to `gpt-image-1` is used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<ImageModel> = body.model()

    /**
     * The number of images to generate. Must be between 1 and 10.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun n(): Optional<Long> = body.n()

    /**
     * The quality of the image that will be generated. `high`, `medium` and `low` are only
     * supported for `gpt-image-1`. `dall-e-2` only supports `standard` quality. Defaults to `auto`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quality(): Optional<Quality> = body.quality()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated. This parameter is only
     * supported for `dall-e-2`, as `gpt-image-1` will always return base64-encoded images.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /**
     * The size of the generated images. Must be one of `1024x1024`, `1536x1024` (landscape),
     * `1024x1536` (portrait), or `auto` (default value) for `gpt-image-1`, and one of `256x256`,
     * `512x512`, or `1024x1024` for `dall-e-2`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Size> = body.size()

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
     * Returns the raw multipart value of [image].
     *
     * Unlike [image], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _image(): MultipartField<Image> = body._image()

    /**
     * Returns the raw multipart value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * Returns the raw multipart value of [mask].
     *
     * Unlike [mask], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _mask(): MultipartField<InputStream> = body._mask()

    /**
     * Returns the raw multipart value of [model].
     *
     * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _model(): MultipartField<ImageModel> = body._model()

    /**
     * Returns the raw multipart value of [n].
     *
     * Unlike [n], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _n(): MultipartField<Long> = body._n()

    /**
     * Returns the raw multipart value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _quality(): MultipartField<Quality> = body._quality()

    /**
     * Returns the raw multipart value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _responseFormat(): MultipartField<ResponseFormat> = body._responseFormat()

    /**
     * Returns the raw multipart value of [size].
     *
     * Unlike [size], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _size(): MultipartField<Size> = body._size()

    /**
     * Returns the raw multipart value of [user].
     *
     * Unlike [user], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _user(): MultipartField<String> = body._user()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ImageEditParams].
         *
         * The following fields are required:
         * ```java
         * .image()
         * .prompt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageEditParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(imageEditParams: ImageEditParams) = apply {
            body = imageEditParams.body.toBuilder()
            additionalHeaders = imageEditParams.additionalHeaders.toBuilder()
            additionalQueryParams = imageEditParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [image]
         * - [prompt]
         * - [mask]
         * - [model]
         * - [n]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The image(s) to edit. Must be a supported image file or an array of images. For
         * `gpt-image-1`, each image should be a `png`, `webp`, or `jpg` file less than 25MB. For
         * `dall-e-2`, you can only provide one image, and it should be a square `png` file less
         * than 4MB.
         */
        fun image(image: Image) = apply { body.image(image) }

        /**
         * Sets [Builder.image] to an arbitrary multipart value.
         *
         * You should usually call [Builder.image] with a well-typed [Image] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun image(image: MultipartField<Image>) = apply { body.image(image) }

        /** Alias for calling [image] with `Image.ofInputStream(inputStream)`. */
        fun image(inputStream: InputStream) = apply { body.image(inputStream) }

        /** Alias for calling [image] with `Image.ofInputStreams(inputStreams)`. */
        fun imageOfInputStreams(inputStreams: List<InputStream>) = apply {
            body.imageOfInputStreams(inputStreams)
        }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2`, and 32000 characters for `gpt-image-1`.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * Sets [Builder.prompt] to an arbitrary multipart value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: MultipartField<String>) = apply { body.prompt(prompt) }

        /**
         * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
         * where `image` should be edited. If there are multiple images provided, the mask will be
         * applied on the first image. Must be a valid PNG file, less than 4MB, and have the same
         * dimensions as `image`.
         */
        fun mask(mask: InputStream) = apply { body.mask(mask) }

        /**
         * Sets [Builder.mask] to an arbitrary multipart value.
         *
         * You should usually call [Builder.mask] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mask(mask: MultipartField<InputStream>) = apply { body.mask(mask) }

        /**
         * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
         * where `image` should be edited. If there are multiple images provided, the mask will be
         * applied on the first image. Must be a valid PNG file, less than 4MB, and have the same
         * dimensions as `image`.
         */
        fun mask(mask: ByteArray) = apply { body.mask(mask) }

        /**
         * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
         * where `image` should be edited. If there are multiple images provided, the mask will be
         * applied on the first image. Must be a valid PNG file, less than 4MB, and have the same
         * dimensions as `image`.
         */
        fun mask(mask: Path) = apply { body.mask(mask) }

        /**
         * The model to use for image generation. Only `dall-e-2` and `gpt-image-1` are supported.
         * Defaults to `dall-e-2` unless a parameter specific to `gpt-image-1` is used.
         */
        fun model(model: ImageModel?) = apply { body.model(model) }

        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
        fun model(model: Optional<ImageModel>) = model(model.getOrNull())

        /**
         * Sets [Builder.model] to an arbitrary multipart value.
         *
         * You should usually call [Builder.model] with a well-typed [ImageModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: MultipartField<ImageModel>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [ImageModel] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /** The number of images to generate. Must be between 1 and 10. */
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
         * Sets [Builder.n] to an arbitrary multipart value.
         *
         * You should usually call [Builder.n] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun n(n: MultipartField<Long>) = apply { body.n(n) }

        /**
         * The quality of the image that will be generated. `high`, `medium` and `low` are only
         * supported for `gpt-image-1`. `dall-e-2` only supports `standard` quality. Defaults to
         * `auto`.
         */
        fun quality(quality: Quality?) = apply { body.quality(quality) }

        /** Alias for calling [Builder.quality] with `quality.orElse(null)`. */
        fun quality(quality: Optional<Quality>) = quality(quality.getOrNull())

        /**
         * Sets [Builder.quality] to an arbitrary multipart value.
         *
         * You should usually call [Builder.quality] with a well-typed [Quality] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quality(quality: MultipartField<Quality>) = apply { body.quality(quality) }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated. This
         * parameter is only supported for `dall-e-2`, as `gpt-image-1` will always return
         * base64-encoded images.
         */
        fun responseFormat(responseFormat: ResponseFormat?) = apply {
            body.responseFormat(responseFormat)
        }

        /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
        fun responseFormat(responseFormat: Optional<ResponseFormat>) =
            responseFormat(responseFormat.getOrNull())

        /**
         * Sets [Builder.responseFormat] to an arbitrary multipart value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The size of the generated images. Must be one of `1024x1024`, `1536x1024` (landscape),
         * `1024x1536` (portrait), or `auto` (default value) for `gpt-image-1`, and one of
         * `256x256`, `512x512`, or `1024x1024` for `dall-e-2`.
         */
        fun size(size: Size?) = apply { body.size(size) }

        /** Alias for calling [Builder.size] with `size.orElse(null)`. */
        fun size(size: Optional<Size>) = size(size.getOrNull())

        /**
         * Sets [Builder.size] to an arbitrary multipart value.
         *
         * You should usually call [Builder.size] with a well-typed [Size] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: MultipartField<Size>) = apply { body.size(size) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * Sets [Builder.user] to an arbitrary multipart value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: MultipartField<String>) = apply { body.user(user) }

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
         * Returns an immutable instance of [ImageEditParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .image()
         * .prompt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImageEditParams =
            ImageEditParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "image" to _image(),
                "prompt" to _prompt(),
                "mask" to _mask(),
                "model" to _model(),
                "n" to _n(),
                "quality" to _quality(),
                "response_format" to _responseFormat(),
                "size" to _size(),
                "user" to _user(),
            )
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val image: MultipartField<Image>,
        private val prompt: MultipartField<String>,
        private val mask: MultipartField<InputStream>,
        private val model: MultipartField<ImageModel>,
        private val n: MultipartField<Long>,
        private val quality: MultipartField<Quality>,
        private val responseFormat: MultipartField<ResponseFormat>,
        private val size: MultipartField<Size>,
        private val user: MultipartField<String>,
    ) {

        /**
         * The image(s) to edit. Must be a supported image file or an array of images. For
         * `gpt-image-1`, each image should be a `png`, `webp`, or `jpg` file less than 25MB. For
         * `dall-e-2`, you can only provide one image, and it should be a square `png` file less
         * than 4MB.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun image(): Image = image.value.getRequired("image")

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2`, and 32000 characters for `gpt-image-1`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prompt(): String = prompt.value.getRequired("prompt")

        /**
         * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
         * where `image` should be edited. If there are multiple images provided, the mask will be
         * applied on the first image. Must be a valid PNG file, less than 4MB, and have the same
         * dimensions as `image`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mask(): Optional<InputStream> = mask.value.getOptional("mask")

        /**
         * The model to use for image generation. Only `dall-e-2` and `gpt-image-1` are supported.
         * Defaults to `dall-e-2` unless a parameter specific to `gpt-image-1` is used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<ImageModel> = model.value.getOptional("model")

        /**
         * The number of images to generate. Must be between 1 and 10.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun n(): Optional<Long> = n.value.getOptional("n")

        /**
         * The quality of the image that will be generated. `high`, `medium` and `low` are only
         * supported for `gpt-image-1`. `dall-e-2` only supports `standard` quality. Defaults to
         * `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun quality(): Optional<Quality> = quality.value.getOptional("quality")

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated. This
         * parameter is only supported for `dall-e-2`, as `gpt-image-1` will always return
         * base64-encoded images.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<ResponseFormat> =
            responseFormat.value.getOptional("response_format")

        /**
         * The size of the generated images. Must be one of `1024x1024`, `1536x1024` (landscape),
         * `1024x1536` (portrait), or `auto` (default value) for `gpt-image-1`, and one of
         * `256x256`, `512x512`, or `1024x1024` for `dall-e-2`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun size(): Optional<Size> = size.value.getOptional("size")

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun user(): Optional<String> = user.value.getOptional("user")

        /**
         * Returns the raw multipart value of [image].
         *
         * Unlike [image], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("image") @ExcludeMissing fun _image(): MultipartField<Image> = image

        /**
         * Returns the raw multipart value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): MultipartField<String> = prompt

        /**
         * Returns the raw multipart value of [mask].
         *
         * Unlike [mask], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("mask") @ExcludeMissing fun _mask(): MultipartField<InputStream> = mask

        /**
         * Returns the raw multipart value of [model].
         *
         * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): MultipartField<ImageModel> = model

        /**
         * Returns the raw multipart value of [n].
         *
         * Unlike [n], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("n") @ExcludeMissing fun _n(): MultipartField<Long> = n

        /**
         * Returns the raw multipart value of [quality].
         *
         * Unlike [quality], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("quality") @ExcludeMissing fun _quality(): MultipartField<Quality> = quality

        /**
         * Returns the raw multipart value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): MultipartField<ResponseFormat> = responseFormat

        /**
         * Returns the raw multipart value of [size].
         *
         * Unlike [size], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): MultipartField<Size> = size

        /**
         * Returns the raw multipart value of [user].
         *
         * Unlike [user], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): MultipartField<String> = user

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .image()
             * .prompt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var image: MultipartField<Image>? = null
            private var prompt: MultipartField<String>? = null
            private var mask: MultipartField<InputStream> = MultipartField.of(null)
            private var model: MultipartField<ImageModel> = MultipartField.of(null)
            private var n: MultipartField<Long> = MultipartField.of(null)
            private var quality: MultipartField<Quality> = MultipartField.of(null)
            private var responseFormat: MultipartField<ResponseFormat> = MultipartField.of(null)
            private var size: MultipartField<Size> = MultipartField.of(null)
            private var user: MultipartField<String> = MultipartField.of(null)

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                image = body.image
                prompt = body.prompt
                mask = body.mask
                model = body.model
                n = body.n
                quality = body.quality
                responseFormat = body.responseFormat
                size = body.size
                user = body.user
            }

            /**
             * The image(s) to edit. Must be a supported image file or an array of images. For
             * `gpt-image-1`, each image should be a `png`, `webp`, or `jpg` file less than 25MB.
             * For `dall-e-2`, you can only provide one image, and it should be a square `png` file
             * less than 4MB.
             */
            fun image(image: Image) = image(MultipartField.of(image))

            /**
             * Sets [Builder.image] to an arbitrary multipart value.
             *
             * You should usually call [Builder.image] with a well-typed [Image] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun image(image: MultipartField<Image>) = apply { this.image = image }

            /** Alias for calling [image] with `Image.ofInputStream(inputStream)`. */
            fun image(inputStream: InputStream) = image(Image.ofInputStream(inputStream))

            /** Alias for calling [image] with `Image.ofInputStreams(inputStreams)`. */
            fun imageOfInputStreams(inputStreams: List<InputStream>) =
                image(Image.ofInputStreams(inputStreams))

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2`, and 32000 characters for `gpt-image-1`.
             */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary multipart value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

            /**
             * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
             * where `image` should be edited. If there are multiple images provided, the mask will
             * be applied on the first image. Must be a valid PNG file, less than 4MB, and have the
             * same dimensions as `image`.
             */
            fun mask(mask: InputStream) = mask(MultipartField.of(mask))

            /**
             * Sets [Builder.mask] to an arbitrary multipart value.
             *
             * You should usually call [Builder.mask] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mask(mask: MultipartField<InputStream>) = apply { this.mask = mask }

            /**
             * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
             * where `image` should be edited. If there are multiple images provided, the mask will
             * be applied on the first image. Must be a valid PNG file, less than 4MB, and have the
             * same dimensions as `image`.
             */
            fun mask(mask: ByteArray) = mask(mask.inputStream())

            /**
             * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate
             * where `image` should be edited. If there are multiple images provided, the mask will
             * be applied on the first image. Must be a valid PNG file, less than 4MB, and have the
             * same dimensions as `image`.
             */
            fun mask(mask: Path) =
                mask(
                    MultipartField.builder<InputStream>()
                        .value(mask.inputStream())
                        .filename(mask.name)
                        .build()
                )

            /**
             * The model to use for image generation. Only `dall-e-2` and `gpt-image-1` are
             * supported. Defaults to `dall-e-2` unless a parameter specific to `gpt-image-1` is
             * used.
             */
            fun model(model: ImageModel?) = model(MultipartField.of(model))

            /** Alias for calling [Builder.model] with `model.orElse(null)`. */
            fun model(model: Optional<ImageModel>) = model(model.getOrNull())

            /**
             * Sets [Builder.model] to an arbitrary multipart value.
             *
             * You should usually call [Builder.model] with a well-typed [ImageModel] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: MultipartField<ImageModel>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [ImageModel] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(ImageModel.of(value))

            /** The number of images to generate. Must be between 1 and 10. */
            fun n(n: Long?) = n(MultipartField.of(n))

            /**
             * Alias for [Builder.n].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun n(n: Long) = n(n as Long?)

            /** Alias for calling [Builder.n] with `n.orElse(null)`. */
            fun n(n: Optional<Long>) = n(n.getOrNull())

            /**
             * Sets [Builder.n] to an arbitrary multipart value.
             *
             * You should usually call [Builder.n] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun n(n: MultipartField<Long>) = apply { this.n = n }

            /**
             * The quality of the image that will be generated. `high`, `medium` and `low` are only
             * supported for `gpt-image-1`. `dall-e-2` only supports `standard` quality. Defaults to
             * `auto`.
             */
            fun quality(quality: Quality?) = quality(MultipartField.of(quality))

            /** Alias for calling [Builder.quality] with `quality.orElse(null)`. */
            fun quality(quality: Optional<Quality>) = quality(quality.getOrNull())

            /**
             * Sets [Builder.quality] to an arbitrary multipart value.
             *
             * You should usually call [Builder.quality] with a well-typed [Quality] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quality(quality: MultipartField<Quality>) = apply { this.quality = quality }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             * This parameter is only supported for `dall-e-2`, as `gpt-image-1` will always return
             * base64-encoded images.
             */
            fun responseFormat(responseFormat: ResponseFormat?) =
                responseFormat(MultipartField.of(responseFormat))

            /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
            fun responseFormat(responseFormat: Optional<ResponseFormat>) =
                responseFormat(responseFormat.getOrNull())

            /**
             * Sets [Builder.responseFormat] to an arbitrary multipart value.
             *
             * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The size of the generated images. Must be one of `1024x1024`, `1536x1024`
             * (landscape), `1024x1536` (portrait), or `auto` (default value) for `gpt-image-1`, and
             * one of `256x256`, `512x512`, or `1024x1024` for `dall-e-2`.
             */
            fun size(size: Size?) = size(MultipartField.of(size))

            /** Alias for calling [Builder.size] with `size.orElse(null)`. */
            fun size(size: Optional<Size>) = size(size.getOrNull())

            /**
             * Sets [Builder.size] to an arbitrary multipart value.
             *
             * You should usually call [Builder.size] with a well-typed [Size] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun size(size: MultipartField<Size>) = apply { this.size = size }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(MultipartField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary multipart value.
             *
             * You should usually call [Builder.user] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun user(user: MultipartField<String>) = apply { this.user = user }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .image()
             * .prompt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("image", image),
                    checkRequired("prompt", prompt),
                    mask,
                    model,
                    n,
                    quality,
                    responseFormat,
                    size,
                    user,
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            image().validate()
            prompt()
            mask()
            model().ifPresent { it.validate() }
            n()
            quality().ifPresent { it.validate() }
            responseFormat().ifPresent { it.validate() }
            size().ifPresent { it.validate() }
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && image == other.image && prompt == other.prompt && mask == other.mask && model == other.model && n == other.n && quality == other.quality && responseFormat == other.responseFormat && size == other.size && user == other.user /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(image, prompt, mask, model, n, quality, responseFormat, size, user) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{image=$image, prompt=$prompt, mask=$mask, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, user=$user}"
    }

    /**
     * The image(s) to edit. Must be a supported image file or an array of images. For
     * `gpt-image-1`, each image should be a `png`, `webp`, or `jpg` file less than 25MB. For
     * `dall-e-2`, you can only provide one image, and it should be a square `png` file less than
     * 4MB.
     */
    @JsonDeserialize(using = Image.Deserializer::class)
    @JsonSerialize(using = Image.Serializer::class)
    class Image
    private constructor(
        private val inputStream: InputStream? = null,
        private val inputStreams: List<InputStream>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun inputStream(): Optional<InputStream> = Optional.ofNullable(inputStream)

        fun inputStreams(): Optional<List<InputStream>> = Optional.ofNullable(inputStreams)

        fun isInputStream(): Boolean = inputStream != null

        fun isInputStreams(): Boolean = inputStreams != null

        fun asInputStream(): InputStream = inputStream.getOrThrow("inputStream")

        fun asInputStreams(): List<InputStream> = inputStreams.getOrThrow("inputStreams")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                inputStream != null -> visitor.visitInputStream(inputStream)
                inputStreams != null -> visitor.visitInputStreams(inputStreams)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Image = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInputStream(inputStream: InputStream) {}

                    override fun visitInputStreams(inputStreams: List<InputStream>) {}
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitInputStream(inputStream: InputStream) = 1

                    override fun visitInputStreams(inputStreams: List<InputStream>) =
                        inputStreams.size

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Image && inputStream == other.inputStream && inputStreams == other.inputStreams /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(inputStream, inputStreams) /* spotless:on */

        override fun toString(): String =
            when {
                inputStream != null -> "Image{inputStream=$inputStream}"
                inputStreams != null -> "Image{inputStreams=$inputStreams}"
                _json != null -> "Image{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Image")
            }

        companion object {

            @JvmStatic
            fun ofInputStream(inputStream: InputStream) = Image(inputStream = inputStream)

            @JvmStatic
            fun ofInputStreams(inputStreams: List<InputStream>) = Image(inputStreams = inputStreams)
        }

        /** An interface that defines how to map each variant of [Image] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitInputStream(inputStream: InputStream): T

            fun visitInputStreams(inputStreams: List<InputStream>): T

            /**
             * Maps an unknown variant of [Image] to a value of type [T].
             *
             * An instance of [Image] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Image: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Image>(Image::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Image {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<InputStream>())?.let {
                                Image(inputStream = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<InputStream>>())?.let {
                                Image(inputStreams = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Image(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Image>(Image::class) {

            override fun serialize(
                value: Image,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.inputStream != null -> generator.writeObject(value.inputStream)
                    value.inputStreams != null -> generator.writeObject(value.inputStreams)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Image")
                }
            }
        }
    }

    /**
     * The quality of the image that will be generated. `high`, `medium` and `low` are only
     * supported for `gpt-image-1`. `dall-e-2` only supports `standard` quality. Defaults to `auto`.
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

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
        }

        /** An enum containing [Quality]'s known values. */
        enum class Known {
            STANDARD,
            LOW,
            MEDIUM,
            HIGH,
            AUTO,
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
            LOW,
            MEDIUM,
            HIGH,
            AUTO,
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
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
                AUTO -> Value.AUTO
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
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                AUTO -> Known.AUTO
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
     * URLs are only valid for 60 minutes after the image has been generated. This parameter is only
     * supported for `dall-e-2`, as `gpt-image-1` will always return base64-encoded images.
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
     * The size of the generated images. Must be one of `1024x1024`, `1536x1024` (landscape),
     * `1024x1536` (portrait), or `auto` (default value) for `gpt-image-1`, and one of `256x256`,
     * `512x512`, or `1024x1024` for `dall-e-2`.
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

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        /** An enum containing [Size]'s known values. */
        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageEditParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ImageEditParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
