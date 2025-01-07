// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
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
 * For certain `purpose`s, the correct `mime_type` must be specified. Please refer to documentation
 * for the supported MIME types for your use case:
 * - [Assistants](https://platform.openai.com/docs/assistants/tools/file-search#supported-files)
 *
 * For guidance on the proper filename extensions for each purpose, please follow the documentation
 * on [creating a File](https://platform.openai.com/docs/api-reference/files/create).
 */
class UploadCreateParams
constructor(
    private val body: UploadCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /** The number of bytes in the file you are uploading. */
    fun bytes(): Long = body.bytes()

    /** The name of the file to upload. */
    fun filename(): String = body.filename()

    /**
     * The MIME type of the file.
     *
     * This must fall within the supported MIME types for your file purpose. See the supported MIME
     * types for assistants and vision.
     */
    fun mimeType(): String = body.mimeType()

    /**
     * The intended purpose of the uploaded file.
     *
     * See the
     * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
     */
    fun purpose(): FilePurpose = body.purpose()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): UploadCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class UploadCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("bytes") private val bytes: Long,
        @JsonProperty("filename") private val filename: String,
        @JsonProperty("mime_type") private val mimeType: String,
        @JsonProperty("purpose") private val purpose: FilePurpose,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The number of bytes in the file you are uploading. */
        @JsonProperty("bytes") fun bytes(): Long = bytes

        /** The name of the file to upload. */
        @JsonProperty("filename") fun filename(): String = filename

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         */
        @JsonProperty("mime_type") fun mimeType(): String = mimeType

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         */
        @JsonProperty("purpose") fun purpose(): FilePurpose = purpose

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var bytes: Long? = null
            private var filename: String? = null
            private var mimeType: String? = null
            private var purpose: FilePurpose? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(uploadCreateBody: UploadCreateBody) = apply {
                bytes = uploadCreateBody.bytes
                filename = uploadCreateBody.filename
                mimeType = uploadCreateBody.mimeType
                purpose = uploadCreateBody.purpose
                additionalProperties = uploadCreateBody.additionalProperties.toMutableMap()
            }

            /** The number of bytes in the file you are uploading. */
            fun bytes(bytes: Long) = apply { this.bytes = bytes }

            /** The name of the file to upload. */
            fun filename(filename: String) = apply { this.filename = filename }

            /**
             * The MIME type of the file.
             *
             * This must fall within the supported MIME types for your file purpose. See the
             * supported MIME types for assistants and vision.
             */
            fun mimeType(mimeType: String) = apply { this.mimeType = mimeType }

            /**
             * The intended purpose of the uploaded file.
             *
             * See the
             * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
             */
            fun purpose(purpose: FilePurpose) = apply { this.purpose = purpose }

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

            fun build(): UploadCreateBody =
                UploadCreateBody(
                    checkNotNull(bytes) { "`bytes` is required but was not set" },
                    checkNotNull(filename) { "`filename` is required but was not set" },
                    checkNotNull(mimeType) { "`mimeType` is required but was not set" },
                    checkNotNull(purpose) { "`purpose` is required but was not set" },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UploadCreateBody && bytes == other.bytes && filename == other.filename && mimeType == other.mimeType && purpose == other.purpose && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(bytes, filename, mimeType, purpose, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UploadCreateBody{bytes=$bytes, filename=$filename, mimeType=$mimeType, purpose=$purpose, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var body: UploadCreateBody.Builder = UploadCreateBody.builder()
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

        /** The name of the file to upload. */
        fun filename(filename: String) = apply { body.filename(filename) }

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         */
        fun mimeType(mimeType: String) = apply { body.mimeType(mimeType) }

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         */
        fun purpose(purpose: FilePurpose) = apply { body.purpose(purpose) }

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
