// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.MultipartField
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import kotlin.io.path.inputStream
import kotlin.io.path.name

/**
 * Upload a file that can be used across various endpoints. Individual files can be up to 512 MB,
 * and the size of all files uploaded by one organization can be up to 100 GB.
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

    /** The File object (not file name) to be uploaded. */
    fun file(): InputStream = body.file()

    /**
     * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
     * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`: Images
     * used for vision fine-tuning - `user_data`: Flexible file type for any purpose - `evals`: Used
     * for eval data sets
     */
    fun purpose(): FilePurpose = body.purpose()

    /** The File object (not file name) to be uploaded. */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
     * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`: Images
     * used for vision fine-tuning - `user_data`: Flexible file type for any purpose - `evals`: Used
     * for eval data sets
     */
    fun _purpose(): MultipartField<FilePurpose> = body._purpose()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Map<String, MultipartField<*>> =
        mapOf("file" to _file(), "purpose" to _purpose()).toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        private val file: MultipartField<InputStream>,
        private val purpose: MultipartField<FilePurpose>,
    ) {

        /** The File object (not file name) to be uploaded. */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         */
        fun purpose(): FilePurpose = purpose.value.getRequired("purpose")

        /** The File object (not file name) to be uploaded. */
        fun _file(): MultipartField<InputStream> = file

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         */
        fun _purpose(): MultipartField<FilePurpose> = purpose

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
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

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                purpose = body.purpose
            }

            /** The File object (not file name) to be uploaded. */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /** The File object (not file name) to be uploaded. */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /** The File object (not file name) to be uploaded. */
            fun file(file: ByteArray) = file(ByteArrayInputStream(file))

            /** The File object (not file name) to be uploaded. */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
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
             * The intended purpose of the uploaded file. One of: - `assistants`: Used in the
             * Assistants API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning -
             * `vision`: Images used for vision fine-tuning - `user_data`: Flexible file type for
             * any purpose - `evals`: Used for eval data sets
             */
            fun purpose(purpose: MultipartField<FilePurpose>) = apply { this.purpose = purpose }

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
            fun build(): Body = Body(checkRequired("file", file), checkRequired("purpose", purpose))
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file && purpose == other.purpose /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, purpose) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{file=$file, purpose=$purpose}"
    }

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
    @NoAutoDetect
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

        /** The File object (not file name) to be uploaded. */
        fun file(file: InputStream) = apply { body.file(file) }

        /** The File object (not file name) to be uploaded. */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /** The File object (not file name) to be uploaded. */
        fun file(file: ByteArray) = apply { body.file(file) }

        /** The File object (not file name) to be uploaded. */
        fun file(file: Path) = apply { body.file(file) }

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         */
        fun purpose(purpose: FilePurpose) = apply { body.purpose(purpose) }

        /**
         * The intended purpose of the uploaded file. One of: - `assistants`: Used in the Assistants
         * API - `batch`: Used in the Batch API - `fine-tune`: Used for fine-tuning - `vision`:
         * Images used for vision fine-tuning - `user_data`: Flexible file type for any purpose -
         * `evals`: Used for eval data sets
         */
        fun purpose(purpose: MultipartField<FilePurpose>) = apply { body.purpose(purpose) }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FileCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
