// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads.parts

import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import kotlin.io.path.inputStream
import kotlin.io.path.name

/**
 * Adds a [Part](https://platform.openai.com/docs/api-reference/uploads/part-object) to an
 * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object. A Part represents
 * a chunk of bytes from the file you are trying to upload.
 *
 * Each Part can be at most 64 MB, and you can add Parts until you hit the Upload maximum of 8 GB.
 *
 * It is possible to add multiple Parts in parallel. You can decide the intended order of the Parts
 * when you [complete the Upload](https://platform.openai.com/docs/api-reference/uploads/complete).
 */
class PartCreateParams
private constructor(
    private val uploadId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun uploadId(): String = uploadId

    /**
     * The chunk of bytes for this Part.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): InputStream = body.data()

    /**
     * Returns the raw multipart value of [data].
     *
     * Unlike [data], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _data(): MultipartField<InputStream> = body._data()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PartCreateParams].
         *
         * The following fields are required:
         * ```java
         * .uploadId()
         * .data()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PartCreateParams]. */
    class Builder internal constructor() {

        private var uploadId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(partCreateParams: PartCreateParams) = apply {
            uploadId = partCreateParams.uploadId
            body = partCreateParams.body.toBuilder()
            additionalHeaders = partCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = partCreateParams.additionalQueryParams.toBuilder()
        }

        fun uploadId(uploadId: String) = apply { this.uploadId = uploadId }

        /** The chunk of bytes for this Part. */
        fun data(data: InputStream) = apply { body.data(data) }

        /**
         * Sets [Builder.data] to an arbitrary multipart value.
         *
         * You should usually call [Builder.data] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun data(data: MultipartField<InputStream>) = apply { body.data(data) }

        /** The chunk of bytes for this Part. */
        fun data(data: ByteArray) = apply { body.data(data) }

        /** The chunk of bytes for this Part. */
        fun data(data: Path) = apply { body.data(data) }

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
         * Returns an immutable instance of [PartCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .uploadId()
         * .data()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PartCreateParams =
            PartCreateParams(
                checkRequired("uploadId", uploadId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic
    internal fun _body(): Map<String, MultipartField<*>> = mapOf("data" to _data()).toImmutable()

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> uploadId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body private constructor(private val data: MultipartField<InputStream>) {

        /**
         * The chunk of bytes for this Part.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): InputStream = data.value.getRequired("data")

        /**
         * Returns the raw multipart value of [data].
         *
         * Unlike [data], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): MultipartField<InputStream> = data

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var data: MultipartField<InputStream>? = null

            @JvmSynthetic internal fun from(body: Body) = apply { data = body.data }

            /** The chunk of bytes for this Part. */
            fun data(data: InputStream) = data(MultipartField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary multipart value.
             *
             * You should usually call [Builder.data] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: MultipartField<InputStream>) = apply { this.data = data }

            /** The chunk of bytes for this Part. */
            fun data(data: ByteArray) = data(data.inputStream())

            /** The chunk of bytes for this Part. */
            fun data(data: Path) =
                data(
                    MultipartField.builder<InputStream>()
                        .value(data.inputStream())
                        .filename(data.name)
                        .build()
                )

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body = Body(checkRequired("data", data))
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            data()
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

            return /* spotless:off */ other is Body && data == other.data /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{data=$data}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PartCreateParams && uploadId == other.uploadId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(uploadId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "PartCreateParams{uploadId=$uploadId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
