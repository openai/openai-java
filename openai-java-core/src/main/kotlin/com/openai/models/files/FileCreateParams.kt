// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

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

/**
 * Upload a file that can be used across various endpoints. Individual files can be up to 512 MB,
 * and the size of all files uploaded by one organization can be up to 1 TB.
 *
 * The Assistants API supports files up to 2 million tokens and of specific file types. See the
 * [Assistants Tools guide](https://platform.openai.com/docs/assistants/tools) for details.
 *
 * The Fine-tuning API only supports `.jsonl` files. The input also has certain required formats for
 * fine-tuning [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input) or
 * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
 * models.
 *
 * The Batch API only supports `.jsonl` files up to 200 MB in size. The input also has a specific
 * required [format](https://platform.openai.com/docs/api-reference/batch/request-input).
 *
 * Please [contact us](https://help.openai.com/) if you need to increase these storage limits.
 */
class FileCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The File object (not file name) to be uploaded.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
     * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`: Images
     * used for vision fine-tuning - `user_data`: Flexible file type for any purpose - `evals`: Used
     * for eval data sets
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun purpose(): FilePurpose = body.purpose()

    /**
     * The expiration policy for a file. By default, files with `purpose=batch` expire after 30 days
     * and all other files are persisted until they are manually deleted.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ExpiresAfter> = body.expiresAfter()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * Returns the raw multipart value of [purpose].
     *
     * Unlike [purpose], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _purpose(): MultipartField<FilePurpose> = body._purpose()

    /**
     * Returns the raw multipart value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _expiresAfter(): MultipartField<ExpiresAfter> = body._expiresAfter()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileCreateParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .purpose()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileCreateParams: FileCreateParams) = apply {
            body = fileCreateParams.body.toBuilder()
            additionalHeaders = fileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [purpose]
         * - [expiresAfter]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The File object (not file name) to be uploaded. */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /** The File object (not file name) to be uploaded. */
        fun file(file: ByteArray) = apply { body.file(file) }

        /** The File object (not file name) to be uploaded. */
        fun file(path: Path) = apply { body.file(path) }

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         */
        fun purpose(purpose: FilePurpose) = apply { body.purpose(purpose) }

        /**
         * Sets [Builder.purpose] to an arbitrary multipart value.
         *
         * You should usually call [Builder.purpose] with a well-typed [FilePurpose] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun purpose(purpose: MultipartField<FilePurpose>) = apply { body.purpose(purpose) }

        /**
         * The expiration policy for a file. By default, files with `purpose=batch` expire after 30
         * days and all other files are persisted until they are manually deleted.
         */
        fun expiresAfter(expiresAfter: ExpiresAfter) = apply { body.expiresAfter(expiresAfter) }

        /**
         * Sets [Builder.expiresAfter] to an arbitrary multipart value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAfter(expiresAfter: MultipartField<ExpiresAfter>) = apply {
            body.expiresAfter(expiresAfter)
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
         * Returns an immutable instance of [FileCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .file()
         * .purpose()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileCreateParams =
            FileCreateParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("file" to _file(), "purpose" to _purpose(), "expires_after" to _expiresAfter()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val purpose: MultipartField<FilePurpose>,
        private val expiresAfter: MultipartField<ExpiresAfter>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * The File object (not file name) to be uploaded.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun purpose(): FilePurpose = purpose.value.getRequired("purpose")

        /**
         * The expiration policy for a file. By default, files with `purpose=batch` expire after 30
         * days and all other files are persisted until they are manually deleted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAfter(): Optional<ExpiresAfter> = expiresAfter.value.getOptional("expires_after")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        /**
         * Returns the raw multipart value of [purpose].
         *
         * Unlike [purpose], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("purpose")
        @ExcludeMissing
        fun _purpose(): MultipartField<FilePurpose> = purpose

        /**
         * Returns the raw multipart value of [expiresAfter].
         *
         * Unlike [expiresAfter], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): MultipartField<ExpiresAfter> = expiresAfter

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
             * .file()
             * .purpose()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream>? = null
            private var purpose: MultipartField<FilePurpose>? = null
            private var expiresAfter: MultipartField<ExpiresAfter> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                purpose = body.purpose
                expiresAfter = body.expiresAfter
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The File object (not file name) to be uploaded. */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /** The File object (not file name) to be uploaded. */
            fun file(file: ByteArray) = file(file.inputStream())

            /** The File object (not file name) to be uploaded. */
            fun file(path: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(path.inputStream())
                        .filename(path.name)
                        .build()
                )

            /**
             * The intended purpose of the uploaded file. One of: - `assistants`: Used in the
             * Assistants API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning -
             * `vision`: Images used for vision fine-tuning - `user_data`: Flexible file type for
             * any purpose - `evals`: Used for eval data sets
             */
            fun purpose(purpose: FilePurpose) = purpose(MultipartField.of(purpose))

            /**
             * Sets [Builder.purpose] to an arbitrary multipart value.
             *
             * You should usually call [Builder.purpose] with a well-typed [FilePurpose] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun purpose(purpose: MultipartField<FilePurpose>) = apply { this.purpose = purpose }

            /**
             * The expiration policy for a file. By default, files with `purpose=batch` expire after
             * 30 days and all other files are persisted until they are manually deleted.
             */
            fun expiresAfter(expiresAfter: ExpiresAfter) =
                expiresAfter(MultipartField.of(expiresAfter))

            /**
             * Sets [Builder.expiresAfter] to an arbitrary multipart value.
             *
             * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAfter(expiresAfter: MultipartField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
            }

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
             * .file()
             * .purpose()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("file", file),
                    checkRequired("purpose", purpose),
                    expiresAfter,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            purpose().validate()
            expiresAfter().ifPresent { it.validate() }
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
                file == other.file &&
                purpose == other.purpose &&
                expiresAfter == other.expiresAfter &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(file, purpose, expiresAfter, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, purpose=$purpose, expiresAfter=$expiresAfter, additionalProperties=$additionalProperties}"
    }

    /**
     * The expiration policy for a file. By default, files with `purpose=batch` expire after 30 days
     * and all other files are persisted until they are manually deleted.
     */
    class ExpiresAfter
    private constructor(
        private val anchor: JsonValue,
        private val seconds: MultipartField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `created_at`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("created_at")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

        /**
         * The number of seconds after the anchor time that the file will expire. Must be between
         * 3600 (1 hour) and 2592000 (30 days).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun seconds(): Long = seconds.value.getRequired("seconds")

        /**
         * Returns the raw multipart value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("seconds") @ExcludeMissing fun _seconds(): MultipartField<Long> = seconds

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
             * Returns a mutable builder for constructing an instance of [ExpiresAfter].
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonValue = JsonValue.from("created_at")
            private var seconds: MultipartField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                seconds = expiresAfter.seconds
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("created_at")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

            /**
             * The number of seconds after the anchor time that the file will expire. Must be
             * between 3600 (1 hour) and 2592000 (30 days).
             */
            fun seconds(seconds: Long) = seconds(MultipartField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary multipart value.
             *
             * You should usually call [Builder.seconds] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: MultipartField<Long>) = apply { this.seconds = seconds }

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
             * Returns an immutable instance of [ExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ExpiresAfter =
                ExpiresAfter(
                    anchor,
                    checkRequired("seconds", seconds),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            _anchor().let {
                if (it != JsonValue.from("created_at")) {
                    throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
                }
            }
            seconds()
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

            return other is ExpiresAfter &&
                anchor == other.anchor &&
                seconds == other.seconds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
