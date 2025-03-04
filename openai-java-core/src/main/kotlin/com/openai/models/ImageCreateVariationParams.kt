// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.MultipartField
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Creates a variation of a given image. */
class ImageCreateVariationParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The image to use as the basis for the variation(s). Must be a valid PNG file, less than 4MB,
     * and square.
     */
    fun image(): ByteArray = body.image()

    /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
    fun model(): Optional<ImageModel> = body.model()

    /**
     * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
     * supported.
     */
    fun n(): Optional<Long> = body.n()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /** The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`. */
    fun size(): Optional<Size> = body.size()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun user(): Optional<String> = body.user()

    /**
     * The image to use as the basis for the variation(s). Must be a valid PNG file, less than 4MB,
     * and square.
     */
    fun _image(): MultipartField<ByteArray> = body._image()

    /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
    fun _model(): MultipartField<ImageModel> = body._model()

    /**
     * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
     * supported.
     */
    fun _n(): MultipartField<Long> = body._n()

    /**
     * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
     * URLs are only valid for 60 minutes after the image has been generated.
     */
    fun _responseFormat(): MultipartField<ResponseFormat> = body._responseFormat()

    /** The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`. */
    fun _size(): MultipartField<Size> = body._size()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun _user(): MultipartField<String> = body._user()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "image" to _image(),
                "model" to _model(),
                "n" to _n(),
                "response_format" to _responseFormat(),
                "size" to _size(),
                "user" to _user(),
            )
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        private val image: MultipartField<ByteArray>,
        private val model: MultipartField<ImageModel>,
        private val n: MultipartField<Long>,
        private val responseFormat: MultipartField<ResponseFormat>,
        private val size: MultipartField<Size>,
        private val user: MultipartField<String>,
    ) {

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        fun image(): ByteArray = image.value.getRequired("image")

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
        fun model(): Optional<ImageModel> = Optional.ofNullable(model.value.getNullable("model"))

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(): Optional<Long> = Optional.ofNullable(n.value.getNullable("n"))

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(): Optional<ResponseFormat> =
            Optional.ofNullable(responseFormat.value.getNullable("response_format"))

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun size(): Optional<Size> = Optional.ofNullable(size.value.getNullable("size"))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(): Optional<String> = Optional.ofNullable(user.value.getNullable("user"))

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        fun _image(): MultipartField<ByteArray> = image

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
        fun _model(): MultipartField<ImageModel> = model

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun _n(): MultipartField<Long> = n

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun _responseFormat(): MultipartField<ResponseFormat> = responseFormat

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun _size(): MultipartField<Size> = size

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun _user(): MultipartField<String> = user

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            image()
            model()
            n()
            responseFormat()
            size()
            user()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var image: MultipartField<ByteArray>? = null
            private var model: MultipartField<ImageModel> = MultipartField.of(null)
            private var n: MultipartField<Long> = MultipartField.of(null)
            private var responseFormat: MultipartField<ResponseFormat> = MultipartField.of(null)
            private var size: MultipartField<Size> = MultipartField.of(null)
            private var user: MultipartField<String> = MultipartField.of(null)

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                image = body.image
                model = body.model
                n = body.n
                responseFormat = body.responseFormat
                size = body.size
                user = body.user
            }

            /**
             * The image to use as the basis for the variation(s). Must be a valid PNG file, less
             * than 4MB, and square.
             */
            fun image(image: ByteArray) = image(MultipartField.of(image))

            /**
             * The image to use as the basis for the variation(s). Must be a valid PNG file, less
             * than 4MB, and square.
             */
            fun image(image: MultipartField<ByteArray>) = apply { this.image = image }

            /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
            fun model(model: ImageModel?) = model(MultipartField.of(model))

            /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
            fun model(model: Optional<ImageModel>) = model(model.orElse(null))

            /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
            fun model(model: MultipartField<ImageModel>) = apply { this.model = model }

            /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
            fun model(value: String) = model(ImageModel.of(value))

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            fun n(n: Long?) = n(MultipartField.of(n))

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
            fun n(n: MultipartField<Long>) = apply { this.n = n }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            fun responseFormat(responseFormat: ResponseFormat?) =
                responseFormat(MultipartField.of(responseFormat))

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
            fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or
             * `1024x1024`.
             */
            fun size(size: Size?) = size(MultipartField.of(size))

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or
             * `1024x1024`.
             */
            fun size(size: Optional<Size>) = size(size.orElse(null))

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or
             * `1024x1024`.
             */
            fun size(size: MultipartField<Size>) = apply { this.size = size }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(MultipartField.of(user))

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: MultipartField<String>) = apply { this.user = user }

            fun build(): Body =
                Body(checkRequired("image", image), model, n, responseFormat, size, user)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && image == other.image && model == other.model && n == other.n && responseFormat == other.responseFormat && size == other.size && user == other.user /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(image, model, n, responseFormat, size, user) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{image=$image, model=$model, n=$n, responseFormat=$responseFormat, size=$size, user=$user}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImageCreateVariationParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(imageCreateVariationParams: ImageCreateVariationParams) = apply {
            body = imageCreateVariationParams.body.toBuilder()
            additionalHeaders = imageCreateVariationParams.additionalHeaders.toBuilder()
            additionalQueryParams = imageCreateVariationParams.additionalQueryParams.toBuilder()
        }

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        fun image(image: ByteArray) = apply { body.image(image) }

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        fun image(image: MultipartField<ByteArray>) = apply { body.image(image) }

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
        fun model(model: ImageModel?) = apply { body.model(model) }

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
        fun model(model: Optional<ImageModel>) = model(model.orElse(null))

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
        fun model(model: MultipartField<ImageModel>) = apply { body.model(model) }

        /** The model to use for image generation. Only `dall-e-2` is supported at this time. */
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
        fun n(n: MultipartField<Long>) = apply { body.n(n) }

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
        fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun size(size: Size?) = apply { body.size(size) }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun size(size: Optional<Size>) = size(size.orElse(null))

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun size(size: MultipartField<Size>) = apply { body.size(size) }

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

        fun build(): ImageCreateVariationParams =
            ImageCreateVariationParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`. */
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

        return /* spotless:off */ other is ImageCreateVariationParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ImageCreateVariationParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
