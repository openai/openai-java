// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
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

/** Create a new video generation job by editing a source video or existing generated video. */
class VideoEditParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Text prompt that describes how to edit the source video.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun prompt(): String = body.prompt()

    /**
     * Reference to the completed video to edit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun video(): Video = body.video()

    /**
     * Returns the raw multipart value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * Returns the raw multipart value of [video].
     *
     * Unlike [video], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _video(): MultipartField<Video> = body._video()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VideoEditParams].
         *
         * The following fields are required:
         * ```java
         * .prompt()
         * .video()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VideoEditParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(videoEditParams: VideoEditParams) = apply {
            body = videoEditParams.body.toBuilder()
            additionalHeaders = videoEditParams.additionalHeaders.toBuilder()
            additionalQueryParams = videoEditParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [prompt]
         * - [video]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Text prompt that describes how to edit the source video. */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * Sets [Builder.prompt] to an arbitrary multipart value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: MultipartField<String>) = apply { body.prompt(prompt) }

        /** Reference to the completed video to edit. */
        fun video(video: Video) = apply { body.video(video) }

        /**
         * Sets [Builder.video] to an arbitrary multipart value.
         *
         * You should usually call [Builder.video] with a well-typed [Video] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun video(video: MultipartField<Video>) = apply { body.video(video) }

        /** Alias for calling [video] with `Video.ofInputStream(inputStream)`. */
        fun video(inputStream: InputStream) = apply { body.video(inputStream) }

        /** Reference to the completed video to edit. */
        fun video(inputStream: ByteArray) = apply { body.video(inputStream) }

        /** Reference to the completed video to edit. */
        fun video(path: Path) = apply { body.video(path) }

        /** Alias for calling [video] with `Video.ofReferenceInputParam(referenceInputParam)`. */
        fun video(referenceInputParam: Video.VideoReferenceInputParam) = apply {
            body.video(referenceInputParam)
        }

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
         * Returns an immutable instance of [VideoEditParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .prompt()
         * .video()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VideoEditParams =
            VideoEditParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("prompt" to _prompt(), "video" to _video()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Parameters for editing an existing generated video. */
    class Body
    private constructor(
        private val prompt: MultipartField<String>,
        private val video: MultipartField<Video>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Text prompt that describes how to edit the source video.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun prompt(): String = prompt.value.getRequired("prompt")

        /**
         * Reference to the completed video to edit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun video(): Video = video.value.getRequired("video")

        /**
         * Returns the raw multipart value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): MultipartField<String> = prompt

        /**
         * Returns the raw multipart value of [video].
         *
         * Unlike [video], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("video") @ExcludeMissing fun _video(): MultipartField<Video> = video

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
             * .video()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var prompt: MultipartField<String>? = null
            private var video: MultipartField<Video>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                prompt = body.prompt
                video = body.video
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Text prompt that describes how to edit the source video. */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary multipart value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

            /** Reference to the completed video to edit. */
            fun video(video: Video) =
                video(
                    MultipartField.builder<Video>()
                        .value(video)
                        .contentType("application/octet-stream")
                        .build()
                )

            /**
             * Sets [Builder.video] to an arbitrary multipart value.
             *
             * You should usually call [Builder.video] with a well-typed [Video] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun video(video: MultipartField<Video>) = apply { this.video = video }

            /** Alias for calling [video] with `Video.ofInputStream(inputStream)`. */
            fun video(inputStream: InputStream) = video(Video.ofInputStream(inputStream))

            /** Reference to the completed video to edit. */
            fun video(inputStream: ByteArray) = video(inputStream.inputStream())

            /** Reference to the completed video to edit. */
            fun video(path: Path) =
                video(
                    MultipartField.builder<Video>()
                        .value(Video.ofInputStream(path.inputStream()))
                        .contentType("application/octet-stream")
                        .filename(path.name)
                        .build()
                )

            /**
             * Alias for calling [video] with `Video.ofReferenceInputParam(referenceInputParam)`.
             */
            fun video(referenceInputParam: Video.VideoReferenceInputParam) =
                video(Video.ofReferenceInputParam(referenceInputParam))

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
             * .video()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("prompt", prompt),
                    checkRequired("video", video),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            prompt()
            video().validate()
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
                video == other.video &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(prompt, video, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{prompt=$prompt, video=$video, additionalProperties=$additionalProperties}"
    }

    /** Reference to the completed video to edit. */
    @JsonSerialize(using = Video.Serializer::class)
    class Video
    private constructor(
        private val inputStream: InputStream? = null,
        private val referenceInputParam: VideoReferenceInputParam? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Reference to the completed video to edit. */
        fun inputStream(): Optional<InputStream> = Optional.ofNullable(inputStream)

        /** Reference to the completed video. */
        fun referenceInputParam(): Optional<VideoReferenceInputParam> =
            Optional.ofNullable(referenceInputParam)

        fun isInputStream(): Boolean = inputStream != null

        fun isReferenceInputParam(): Boolean = referenceInputParam != null

        /** Reference to the completed video to edit. */
        fun asInputStream(): InputStream = inputStream.getOrThrow("inputStream")

        /** Reference to the completed video. */
        fun asReferenceInputParam(): VideoReferenceInputParam =
            referenceInputParam.getOrThrow("referenceInputParam")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                inputStream != null -> visitor.visitInputStream(inputStream)
                referenceInputParam != null -> visitor.visitReferenceInputParam(referenceInputParam)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Video = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInputStream(inputStream: InputStream) {}

                    override fun visitReferenceInputParam(
                        referenceInputParam: VideoReferenceInputParam
                    ) {
                        referenceInputParam.validate()
                    }
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Video &&
                inputStream == other.inputStream &&
                referenceInputParam == other.referenceInputParam
        }

        override fun hashCode(): Int = Objects.hash(inputStream, referenceInputParam)

        override fun toString(): String =
            when {
                inputStream != null -> "Video{inputStream=$inputStream}"
                referenceInputParam != null -> "Video{referenceInputParam=$referenceInputParam}"
                _json != null -> "Video{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Video")
            }

        companion object {

            /** Reference to the completed video to edit. */
            @JvmStatic
            fun ofInputStream(inputStream: InputStream) = Video(inputStream = inputStream)

            /** Reference to the completed video. */
            @JvmStatic
            fun ofReferenceInputParam(referenceInputParam: VideoReferenceInputParam) =
                Video(referenceInputParam = referenceInputParam)
        }

        /** An interface that defines how to map each variant of [Video] to a value of type [T]. */
        interface Visitor<out T> {

            /** Reference to the completed video to edit. */
            fun visitInputStream(inputStream: InputStream): T

            /** Reference to the completed video. */
            fun visitReferenceInputParam(referenceInputParam: VideoReferenceInputParam): T

            /**
             * Maps an unknown variant of [Video] to a value of type [T].
             *
             * An instance of [Video] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Video: $json")
            }
        }

        internal class Serializer : BaseSerializer<Video>(Video::class) {

            override fun serialize(
                value: Video,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.inputStream != null -> generator.writeObject(value.inputStream)
                    value.referenceInputParam != null ->
                        generator.writeObject(value.referenceInputParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Video")
                }
            }
        }

        /** Reference to the completed video. */
        class VideoReferenceInputParam
        private constructor(
            private val id: MultipartField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The identifier of the completed video.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.value.getRequired("id")

            /**
             * Returns the raw multipart value of [id].
             *
             * Unlike [id], this method doesn't throw if the multipart field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): MultipartField<String> = id

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
                 * Returns a mutable builder for constructing an instance of
                 * [VideoReferenceInputParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [VideoReferenceInputParam]. */
            class Builder internal constructor() {

                private var id: MultipartField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(videoReferenceInputParam: VideoReferenceInputParam) = apply {
                    id = videoReferenceInputParam.id
                    additionalProperties =
                        videoReferenceInputParam.additionalProperties.toMutableMap()
                }

                /** The identifier of the completed video. */
                fun id(id: String) = id(MultipartField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: MultipartField<String>) = apply { this.id = id }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [VideoReferenceInputParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): VideoReferenceInputParam =
                    VideoReferenceInputParam(
                        checkRequired("id", id),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): VideoReferenceInputParam = apply {
                if (validated) {
                    return@apply
                }

                id()
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

                return other is VideoReferenceInputParam &&
                    id == other.id &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "VideoReferenceInputParam{id=$id, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VideoEditParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VideoEditParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
