// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.files.FilePurpose
import java.util.Objects

/**
 * Creates an intermediate [Upload](https://platform.openai.com/docs/api-reference/uploads/object)
 * object that you can add
 * [Parts](https://platform.openai.com/docs/api-reference/uploads/part-object) to. Currently, an
 * Upload can accept at most 8 GB in total and expires after an hour after you create it.
 *
 * Once you complete the Upload, we will create a
 * [File](https://platform.openai.com/docs/api-reference/files/object) object that contains all the
 * parts you uploaded. This File is usable in the rest of our platform as a regular File object.
 *
 * For certain `purpose` values, the correct `mime_type` must be specified. Please refer to
 * documentation for the
 * [supported MIME types for your use case](https://platform.openai.com/docs/assistants/tools/file-search#supported-files).
 *
 * For guidance on the proper filename extensions for each purpose, please follow the documentation
 * on [creating a File](https://platform.openai.com/docs/api-reference/files/create).
 */
class UploadCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The number of bytes in the file you are uploading.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bytes(): Long = body.bytes()

    /**
     * The name of the file to upload.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun filename(): String = body.filename()

    /**
     * The MIME type of the file.
     *
     * This must fall within the supported MIME types for your file purpose. See the supported MIME
     * types for assistants and vision.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mimeType(): String = body.mimeType()

    /**
     * The intended purpose of the uploaded file.
     *
     * See the
     * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun purpose(): FilePurpose = body.purpose()

    /**
     * Returns the raw JSON value of [bytes].
     *
     * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bytes(): JsonField<Long> = body._bytes()

    /**
     * Returns the raw JSON value of [filename].
     *
     * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _filename(): JsonField<String> = body._filename()

    /**
     * Returns the raw JSON value of [mimeType].
     *
     * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mimeType(): JsonField<String> = body._mimeType()

    /**
     * Returns the raw JSON value of [purpose].
     *
     * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _purpose(): JsonField<FilePurpose> = body._purpose()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("bytes")
        @ExcludeMissing
        private val bytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("filename")
        @ExcludeMissing
        private val filename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mime_type")
        @ExcludeMissing
        private val mimeType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("purpose")
        @ExcludeMissing
        private val purpose: JsonField<FilePurpose> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The number of bytes in the file you are uploading.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bytes(): Long = bytes.getRequired("bytes")

        /**
         * The name of the file to upload.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun filename(): String = filename.getRequired("filename")

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mimeType(): String = mimeType.getRequired("mime_type")

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun purpose(): FilePurpose = purpose.getRequired("purpose")

        /**
         * Returns the raw JSON value of [bytes].
         *
         * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<Long> = bytes

        /**
         * Returns the raw JSON value of [filename].
         *
         * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

        /**
         * Returns the raw JSON value of [mimeType].
         *
         * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mime_type") @ExcludeMissing fun _mimeType(): JsonField<String> = mimeType

        /**
         * Returns the raw JSON value of [purpose].
         *
         * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<FilePurpose> = purpose

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            bytes()
            filename()
            mimeType()
            purpose()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .bytes()
             * .filename()
             * .mimeType()
             * .purpose()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var bytes: JsonField<Long>? = null
            private var filename: JsonField<String>? = null
            private var mimeType: JsonField<String>? = null
            private var purpose: JsonField<FilePurpose>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                bytes = body.bytes
                filename = body.filename
                mimeType = body.mimeType
                purpose = body.purpose
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The number of bytes in the file you are uploading. */
            fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

            /**
             * Sets [Builder.bytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bytes] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

            /** The name of the file to upload. */
            fun filename(filename: String) = filename(JsonField.of(filename))

            /**
             * Sets [Builder.filename] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filename(filename: JsonField<String>) = apply { this.filename = filename }

            /**
             * The MIME type of the file.
             *
             * This must fall within the supported MIME types for your file purpose. See the
             * supported MIME types for assistants and vision.
             */
            fun mimeType(mimeType: String) = mimeType(JsonField.of(mimeType))

            /**
             * Sets [Builder.mimeType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mimeType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

            /**
             * The intended purpose of the uploaded file.
             *
             * See the
             * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
             */
            fun purpose(purpose: FilePurpose) = purpose(JsonField.of(purpose))

            /**
             * Sets [Builder.purpose] to an arbitrary JSON value.
             *
             * You should usually call [Builder.purpose] with a well-typed [FilePurpose] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun purpose(purpose: JsonField<FilePurpose>) = apply { this.purpose = purpose }

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
             * .bytes()
             * .filename()
             * .mimeType()
             * .purpose()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("bytes", bytes),
                    checkRequired("filename", filename),
                    checkRequired("mimeType", mimeType),
                    checkRequired("purpose", purpose),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && bytes == other.bytes && filename == other.filename && mimeType == other.mimeType && purpose == other.purpose && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(bytes, filename, mimeType, purpose, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{bytes=$bytes, filename=$filename, mimeType=$mimeType, purpose=$purpose, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UploadCreateParams].
         *
         * The following fields are required:
         * ```java
         * .bytes()
         * .filename()
         * .mimeType()
         * .purpose()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UploadCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(uploadCreateParams: UploadCreateParams) = apply {
            body = uploadCreateParams.body.toBuilder()
            additionalHeaders = uploadCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = uploadCreateParams.additionalQueryParams.toBuilder()
        }

        /** The number of bytes in the file you are uploading. */
        fun bytes(bytes: Long) = apply { body.bytes(bytes) }

        /**
         * Sets [Builder.bytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bytes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bytes(bytes: JsonField<Long>) = apply { body.bytes(bytes) }

        /** The name of the file to upload. */
        fun filename(filename: String) = apply { body.filename(filename) }

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filename(filename: JsonField<String>) = apply { body.filename(filename) }

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         */
        fun mimeType(mimeType: String) = apply { body.mimeType(mimeType) }

        /**
         * Sets [Builder.mimeType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mimeType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mimeType(mimeType: JsonField<String>) = apply { body.mimeType(mimeType) }

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         */
        fun purpose(purpose: FilePurpose) = apply { body.purpose(purpose) }

        /**
         * Sets [Builder.purpose] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purpose] with a well-typed [FilePurpose] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun purpose(purpose: JsonField<FilePurpose>) = apply { body.purpose(purpose) }

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
         * Returns an immutable instance of [UploadCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bytes()
         * .filename()
         * .mimeType()
         * .purpose()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UploadCreateParams =
            UploadCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UploadCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
