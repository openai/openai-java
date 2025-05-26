// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.MultipartField
import com.openai.core.Params
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
 * Create a Container File
 *
 * You can send either a multipart/form-data request with the raw file content, or a JSON request
 * with a file ID.
 */
class FileCreateParams
private constructor(
    private val containerId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun containerId(): Optional<String> = Optional.ofNullable(containerId)

    /**
     * The File object (not file name) to be uploaded.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun file(): Optional<InputStream> = body.file()

    /**
     * Name of the file to create.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = body.fileId()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * Returns the raw multipart value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _fileId(): MultipartField<String> = body._fileId()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): FileCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [FileCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileCreateParams]. */
    class Builder internal constructor() {

        private var containerId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileCreateParams: FileCreateParams) = apply {
            containerId = fileCreateParams.containerId
            body = fileCreateParams.body.toBuilder()
            additionalHeaders = fileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileCreateParams.additionalQueryParams.toBuilder()
        }

        fun containerId(containerId: String?) = apply { this.containerId = containerId }

        /** Alias for calling [Builder.containerId] with `containerId.orElse(null)`. */
        fun containerId(containerId: Optional<String>) = containerId(containerId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [fileId]
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
        fun file(file: Path) = apply { body.file(file) }

        /** Name of the file to create. */
        fun fileId(fileId: String) = apply { body.fileId(fileId) }

        /**
         * Sets [Builder.fileId] to an arbitrary multipart value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: MultipartField<String>) = apply { body.fileId(fileId) }

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
         */
        fun build(): FileCreateParams =
            FileCreateParams(
                containerId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        mapOf("file" to _file(), "file_id" to _fileId()).toImmutable()

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> containerId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val fileId: MultipartField<String>,
    ) {

        /**
         * The File object (not file name) to be uploaded.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun file(): Optional<InputStream> = file.value.getOptional("file")

        /**
         * Name of the file to create.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileId(): Optional<String> = fileId.value.getOptional("file_id")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        /**
         * Returns the raw multipart value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): MultipartField<String> = fileId

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream> = MultipartField.of(null)
            private var fileId: MultipartField<String> = MultipartField.of(null)

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                fileId = body.fileId
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
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /** Name of the file to create. */
            fun fileId(fileId: String) = fileId(MultipartField.of(fileId))

            /**
             * Sets [Builder.fileId] to an arbitrary multipart value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileId(fileId: MultipartField<String>) = apply { this.fileId = fileId }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body = Body(file, fileId)
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            fileId()
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

            return /* spotless:off */ other is Body && file == other.file && fileId == other.fileId /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, fileId) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{file=$file, fileId=$fileId}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileCreateParams && containerId == other.containerId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(containerId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FileCreateParams{containerId=$containerId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
