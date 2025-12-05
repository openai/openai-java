// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.nio.file.Path
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name

/** Create a video */
class VideoCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Text prompt that describes the video to generate.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun prompt(): String = body.prompt()

    /**
     * Optional image reference that guides generation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputReference(): Optional<InputStream> = body.inputReference()

    /**
     * The video generation model to use (allowed values: sora-2, sora-2-pro). Defaults to `sora-2`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<VideoModel> = body.model()

    /**
     * Clip duration in seconds (allowed values: 4, 8, 12). Defaults to 4 seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun seconds(): Optional<VideoSeconds> = body.seconds()

    /**
     * Output resolution formatted as width x height (allowed values: 720x1280, 1280x720, 1024x1792,
     * 1792x1024). Defaults to 720x1280.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<VideoSize> = body.size()

    /**
     * Returns the raw multipart value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * Returns the raw multipart value of [inputReference].
     *
     * Unlike [inputReference], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _inputReference(): MultipartField<InputStream> = body._inputReference()

    /**
     * Returns the raw multipart value of [model].
     *
     * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _model(): MultipartField<VideoModel> = body._model()

    /**
     * Returns the raw multipart value of [seconds].
     *
     * Unlike [seconds], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _seconds(): MultipartField<VideoSeconds> = body._seconds()

    /**
     * Returns the raw multipart value of [size].
     *
     * Unlike [size], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _size(): MultipartField<VideoSize> = body._size()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VideoCreateParams].
         *
         * The following fields are required:
         * ```java
         * .prompt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VideoCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(videoCreateParams: VideoCreateParams) = apply {
            body = videoCreateParams.body.toBuilder()
            additionalHeaders = videoCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = videoCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [prompt]
         * - [inputReference]
         * - [model]
         * - [seconds]
         * - [size]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Text prompt that describes the video to generate. */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * Sets [Builder.prompt] to an arbitrary multipart value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: MultipartField<String>) = apply { body.prompt(prompt) }

        /** Optional image reference that guides generation. */
        fun inputReference(inputReference: InputStream) = apply {
            body.inputReference(inputReference)
        }

        /**
         * Sets [Builder.inputReference] to an arbitrary multipart value.
         *
         * You should usually call [Builder.inputReference] with a well-typed [InputStream] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inputReference(inputReference: MultipartField<InputStream>) = apply {
            body.inputReference(inputReference)
        }

        /** Optional image reference that guides generation. */
        fun inputReference(inputReference: ByteArray) = apply {
            body.inputReference(inputReference)
        }

        /** Optional image reference that guides generation. */
        fun inputReference(path: Path) = apply { body.inputReference(path) }

        /**
         * The video generation model to use (allowed values: sora-2, sora-2-pro). Defaults to
         * `sora-2`.
         */
        fun model(model: VideoModel) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary multipart value.
         *
         * You should usually call [Builder.model] with a well-typed [VideoModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: MultipartField<VideoModel>) = apply { body.model(model) }

        /** Clip duration in seconds (allowed values: 4, 8, 12). Defaults to 4 seconds. */
        fun seconds(seconds: VideoSeconds) = apply { body.seconds(seconds) }

        /**
         * Sets [Builder.seconds] to an arbitrary multipart value.
         *
         * You should usually call [Builder.seconds] with a well-typed [VideoSeconds] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun seconds(seconds: MultipartField<VideoSeconds>) = apply { body.seconds(seconds) }

        /**
         * Output resolution formatted as width x height (allowed values: 720x1280, 1280x720,
         * 1024x1792, 1792x1024). Defaults to 720x1280.
         */
        fun size(size: VideoSize) = apply { body.size(size) }

        /**
         * Sets [Builder.size] to an arbitrary multipart value.
         *
         * You should usually call [Builder.size] with a well-typed [VideoSize] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: MultipartField<VideoSize>) = apply { body.size(size) }

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
         * Returns an immutable instance of [VideoCreateParams].
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
        fun build(): VideoCreateParams =
            VideoCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf(
                "prompt" to _prompt(),
                "input_reference" to _inputReference(),
                "model" to _model(),
                "seconds" to _seconds(),
                "size" to _size(),
            ) + _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Parameters for creating a new video generation job. */
    class Body
    private constructor(
        private val prompt: MultipartField<String>,
        private val inputReference: MultipartField<InputStream>,
        private val model: MultipartField<VideoModel>,
        private val seconds: MultipartField<VideoSeconds>,
        private val size: MultipartField<VideoSize>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Text prompt that describes the video to generate.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prompt(): String = prompt.value.getRequired("prompt")

        /**
         * Optional image reference that guides generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputReference(): Optional<InputStream> =
            inputReference.value.getOptional("input_reference")

        /**
         * The video generation model to use (allowed values: sora-2, sora-2-pro). Defaults to
         * `sora-2`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<VideoModel> = model.value.getOptional("model")

        /**
         * Clip duration in seconds (allowed values: 4, 8, 12). Defaults to 4 seconds.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seconds(): Optional<VideoSeconds> = seconds.value.getOptional("seconds")

        /**
         * Output resolution formatted as width x height (allowed values: 720x1280, 1280x720,
         * 1024x1792, 1792x1024). Defaults to 720x1280.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun size(): Optional<VideoSize> = size.value.getOptional("size")

        /**
         * Returns the raw multipart value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): MultipartField<String> = prompt

        /**
         * Returns the raw multipart value of [inputReference].
         *
         * Unlike [inputReference], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("input_reference")
        @ExcludeMissing
        fun _inputReference(): MultipartField<InputStream> = inputReference

        /**
         * Returns the raw multipart value of [model].
         *
         * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): MultipartField<VideoModel> = model

        /**
         * Returns the raw multipart value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("seconds")
        @ExcludeMissing
        fun _seconds(): MultipartField<VideoSeconds> = seconds

        /**
         * Returns the raw multipart value of [size].
         *
         * Unlike [size], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): MultipartField<VideoSize> = size

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

            private var prompt: MultipartField<String>? = null
            private var inputReference: MultipartField<InputStream> = MultipartField.of(null)
            private var model: MultipartField<VideoModel> = MultipartField.of(null)
            private var seconds: MultipartField<VideoSeconds> = MultipartField.of(null)
            private var size: MultipartField<VideoSize> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                prompt = body.prompt
                inputReference = body.inputReference
                model = body.model
                seconds = body.seconds
                size = body.size
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Text prompt that describes the video to generate. */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary multipart value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

            /** Optional image reference that guides generation. */
            fun inputReference(inputReference: InputStream) =
                inputReference(MultipartField.of(inputReference))

            /**
             * Sets [Builder.inputReference] to an arbitrary multipart value.
             *
             * You should usually call [Builder.inputReference] with a well-typed [InputStream]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun inputReference(inputReference: MultipartField<InputStream>) = apply {
                this.inputReference = inputReference
            }

            /** Optional image reference that guides generation. */
            fun inputReference(inputReference: ByteArray) =
                inputReference(inputReference.inputStream())

            /** Optional image reference that guides generation. */
            fun inputReference(path: Path) =
                inputReference(
                    MultipartField.builder<InputStream>()
                        .value(path.inputStream())
                        .filename(path.name)
                        .build()
                )

            /**
             * The video generation model to use (allowed values: sora-2, sora-2-pro). Defaults to
             * `sora-2`.
             */
            fun model(model: VideoModel) = model(MultipartField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary multipart value.
             *
             * You should usually call [Builder.model] with a well-typed [VideoModel] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: MultipartField<VideoModel>) = apply { this.model = model }

            /** Clip duration in seconds (allowed values: 4, 8, 12). Defaults to 4 seconds. */
            fun seconds(seconds: VideoSeconds) = seconds(MultipartField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary multipart value.
             *
             * You should usually call [Builder.seconds] with a well-typed [VideoSeconds] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: MultipartField<VideoSeconds>) = apply { this.seconds = seconds }

            /**
             * Output resolution formatted as width x height (allowed values: 720x1280, 1280x720,
             * 1024x1792, 1792x1024). Defaults to 720x1280.
             */
            fun size(size: VideoSize) = size(MultipartField.of(size))

            /**
             * Sets [Builder.size] to an arbitrary multipart value.
             *
             * You should usually call [Builder.size] with a well-typed [VideoSize] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun size(size: MultipartField<VideoSize>) = apply { this.size = size }

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
                    inputReference,
                    model,
                    seconds,
                    size,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            prompt()
            inputReference()
            model().ifPresent { it.validate() }
            seconds().ifPresent { it.validate() }
            size().ifPresent { it.validate() }
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

            return other is Body &&
                prompt == other.prompt &&
                inputReference == other.inputReference &&
                model == other.model &&
                seconds == other.seconds &&
                size == other.size &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(prompt, inputReference, model, seconds, size, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{prompt=$prompt, inputReference=$inputReference, model=$model, seconds=$seconds, size=$size, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VideoCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VideoCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
