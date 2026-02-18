// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

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
import kotlin.jvm.optionals.getOrNull

/** Create a new immutable skill version. */
class VersionCreateParams
private constructor(
    private val skillId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun skillId(): Optional<String> = Optional.ofNullable(skillId)

    /**
     * Whether to set this version as the default.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun default_(): Optional<Boolean> = body.default_()

    /**
     * Skill files to upload (directory upload) or a single zip file.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun files(): Optional<Files> = body.files()

    /**
     * Returns the raw multipart value of [default_].
     *
     * Unlike [default_], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _default_(): MultipartField<Boolean> = body._default_()

    /**
     * Returns the raw multipart value of [files].
     *
     * Unlike [files], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _files(): MultipartField<Files> = body._files()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): VersionCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [VersionCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VersionCreateParams]. */
    class Builder internal constructor() {

        private var skillId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(versionCreateParams: VersionCreateParams) = apply {
            skillId = versionCreateParams.skillId
            body = versionCreateParams.body.toBuilder()
            additionalHeaders = versionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = versionCreateParams.additionalQueryParams.toBuilder()
        }

        fun skillId(skillId: String?) = apply { this.skillId = skillId }

        /** Alias for calling [Builder.skillId] with `skillId.orElse(null)`. */
        fun skillId(skillId: Optional<String>) = skillId(skillId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [default_]
         * - [files]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Whether to set this version as the default. */
        fun default_(default_: Boolean) = apply { body.default_(default_) }

        /**
         * Sets [Builder.default_] to an arbitrary multipart value.
         *
         * You should usually call [Builder.default_] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun default_(default_: MultipartField<Boolean>) = apply { body.default_(default_) }

        /** Skill files to upload (directory upload) or a single zip file. */
        fun files(files: Files) = apply { body.files(files) }

        /**
         * Sets [Builder.files] to an arbitrary multipart value.
         *
         * You should usually call [Builder.files] with a well-typed [Files] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun files(files: MultipartField<Files>) = apply { body.files(files) }

        /** Alias for calling [files] with `Files.ofInputStreams(inputStreams)`. */
        fun filesOfInputStreams(inputStreams: List<InputStream>) = apply {
            body.filesOfInputStreams(inputStreams)
        }

        /** Alias for calling [files] with `Files.ofInputStream(inputStream)`. */
        fun files(inputStream: InputStream) = apply { body.files(inputStream) }

        /** Skill zip file to upload. */
        fun files(inputStream: ByteArray) = apply { body.files(inputStream) }

        /** Skill zip file to upload. */
        fun files(path: Path) = apply { body.files(path) }

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
         * Returns an immutable instance of [VersionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VersionCreateParams =
            VersionCreateParams(
                skillId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("default" to _default_(), "files" to _files()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> skillId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Uploads a new immutable version of a skill. */
    class Body
    private constructor(
        private val default_: MultipartField<Boolean>,
        private val files: MultipartField<Files>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Whether to set this version as the default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun default_(): Optional<Boolean> = default_.value.getOptional("default")

        /**
         * Skill files to upload (directory upload) or a single zip file.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun files(): Optional<Files> = files.value.getOptional("files")

        /**
         * Returns the raw multipart value of [default_].
         *
         * Unlike [default_], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("default") @ExcludeMissing fun _default_(): MultipartField<Boolean> = default_

        /**
         * Returns the raw multipart value of [files].
         *
         * Unlike [files], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("files") @ExcludeMissing fun _files(): MultipartField<Files> = files

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var default_: MultipartField<Boolean> = MultipartField.of(null)
            private var files: MultipartField<Files> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                default_ = body.default_
                files = body.files
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Whether to set this version as the default. */
            fun default_(default_: Boolean) = default_(MultipartField.of(default_))

            /**
             * Sets [Builder.default_] to an arbitrary multipart value.
             *
             * You should usually call [Builder.default_] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun default_(default_: MultipartField<Boolean>) = apply { this.default_ = default_ }

            /** Skill files to upload (directory upload) or a single zip file. */
            fun files(files: Files) =
                files(
                    MultipartField.builder<Files>()
                        .value(files)
                        .contentType("application/octet-stream")
                        .build()
                )

            /**
             * Sets [Builder.files] to an arbitrary multipart value.
             *
             * You should usually call [Builder.files] with a well-typed [Files] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun files(files: MultipartField<Files>) = apply { this.files = files }

            /** Alias for calling [files] with `Files.ofInputStreams(inputStreams)`. */
            fun filesOfInputStreams(inputStreams: List<InputStream>) =
                files(Files.ofInputStreams(inputStreams))

            /** Alias for calling [files] with `Files.ofInputStream(inputStream)`. */
            fun files(inputStream: InputStream) = files(Files.ofInputStream(inputStream))

            /** Skill zip file to upload. */
            fun files(inputStream: ByteArray) = files(inputStream.inputStream())

            /** Skill zip file to upload. */
            fun files(path: Path) =
                files(
                    MultipartField.builder<Files>()
                        .value(Files.ofInputStream(path.inputStream()))
                        .contentType("application/octet-stream")
                        .filename(path.name)
                        .build()
                )

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
             */
            fun build(): Body = Body(default_, files, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            default_()
            files().ifPresent { it.validate() }
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
                default_ == other.default_ &&
                files == other.files &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(default_, files, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{default_=$default_, files=$files, additionalProperties=$additionalProperties}"
    }

    /** Skill files to upload (directory upload) or a single zip file. */
    @JsonSerialize(using = Files.Serializer::class)
    class Files
    private constructor(
        private val inputStreams: List<InputStream>? = null,
        private val inputStream: InputStream? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Skill files to upload (directory upload) or a single zip file. */
        fun inputStreams(): Optional<List<InputStream>> = Optional.ofNullable(inputStreams)

        /** Skill zip file to upload. */
        fun inputStream(): Optional<InputStream> = Optional.ofNullable(inputStream)

        fun isInputStreams(): Boolean = inputStreams != null

        fun isInputStream(): Boolean = inputStream != null

        /** Skill files to upload (directory upload) or a single zip file. */
        fun asInputStreams(): List<InputStream> = inputStreams.getOrThrow("inputStreams")

        /** Skill zip file to upload. */
        fun asInputStream(): InputStream = inputStream.getOrThrow("inputStream")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                inputStreams != null -> visitor.visitInputStreams(inputStreams)
                inputStream != null -> visitor.visitInputStream(inputStream)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Files = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInputStreams(inputStreams: List<InputStream>) {}

                    override fun visitInputStream(inputStream: InputStream) {}
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

            return other is Files &&
                inputStreams == other.inputStreams &&
                inputStream == other.inputStream
        }

        override fun hashCode(): Int = Objects.hash(inputStreams, inputStream)

        override fun toString(): String =
            when {
                inputStreams != null -> "Files{inputStreams=$inputStreams}"
                inputStream != null -> "Files{inputStream=$inputStream}"
                _json != null -> "Files{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Files")
            }

        companion object {

            /** Skill files to upload (directory upload) or a single zip file. */
            @JvmStatic
            fun ofInputStreams(inputStreams: List<InputStream>) =
                Files(inputStreams = inputStreams.toImmutable())

            /** Skill zip file to upload. */
            @JvmStatic
            fun ofInputStream(inputStream: InputStream) = Files(inputStream = inputStream)
        }

        /** An interface that defines how to map each variant of [Files] to a value of type [T]. */
        interface Visitor<out T> {

            /** Skill files to upload (directory upload) or a single zip file. */
            fun visitInputStreams(inputStreams: List<InputStream>): T

            /** Skill zip file to upload. */
            fun visitInputStream(inputStream: InputStream): T

            /**
             * Maps an unknown variant of [Files] to a value of type [T].
             *
             * An instance of [Files] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Files: $json")
            }
        }

        internal class Serializer : BaseSerializer<Files>(Files::class) {

            override fun serialize(
                value: Files,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.inputStreams != null -> generator.writeObject(value.inputStreams)
                    value.inputStream != null -> generator.writeObject(value.inputStream)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Files")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VersionCreateParams &&
            skillId == other.skillId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(skillId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VersionCreateParams{skillId=$skillId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
