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
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Completes the [Upload](https://platform.openai.com/docs/api-reference/uploads/object).
 *
 * Within the returned Upload object, there is a nested
 * [File](https://platform.openai.com/docs/api-reference/files/object) object that is ready to use
 * in the rest of the platform.
 *
 * You can specify the order of the Parts by passing in an ordered list of the Part IDs.
 *
 * The number of bytes uploaded upon completion must match the number of bytes initially specified
 * when creating the Upload object. No Parts may be added after an Upload is completed.
 */
class UploadCompleteParams
private constructor(
    private val uploadId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun uploadId(): String = uploadId

    /**
     * The ordered list of Part IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun partIds(): List<String> = body.partIds()

    /**
     * The optional md5 checksum for the file contents to verify if the bytes uploaded matches what
     * you expect.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun md5(): Optional<String> = body.md5()

    /**
     * Returns the raw JSON value of [partIds].
     *
     * Unlike [partIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _partIds(): JsonField<List<String>> = body._partIds()

    /**
     * Returns the raw JSON value of [md5].
     *
     * Unlike [md5], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _md5(): JsonField<String> = body._md5()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UploadCompleteParams].
         *
         * The following fields are required:
         * ```java
         * .uploadId()
         * .partIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UploadCompleteParams]. */
    class Builder internal constructor() {

        private var uploadId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(uploadCompleteParams: UploadCompleteParams) = apply {
            uploadId = uploadCompleteParams.uploadId
            body = uploadCompleteParams.body.toBuilder()
            additionalHeaders = uploadCompleteParams.additionalHeaders.toBuilder()
            additionalQueryParams = uploadCompleteParams.additionalQueryParams.toBuilder()
        }

        fun uploadId(uploadId: String) = apply { this.uploadId = uploadId }

        /** The ordered list of Part IDs. */
        fun partIds(partIds: List<String>) = apply { body.partIds(partIds) }

        /**
         * Sets [Builder.partIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.partIds] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun partIds(partIds: JsonField<List<String>>) = apply { body.partIds(partIds) }

        /**
         * Adds a single [String] to [partIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPartId(partId: String) = apply { body.addPartId(partId) }

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        fun md5(md5: String) = apply { body.md5(md5) }

        /**
         * Sets [Builder.md5] to an arbitrary JSON value.
         *
         * You should usually call [Builder.md5] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun md5(md5: JsonField<String>) = apply { body.md5(md5) }

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
         * Returns an immutable instance of [UploadCompleteParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .uploadId()
         * .partIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UploadCompleteParams =
            UploadCompleteParams(
                checkRequired("uploadId", uploadId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> uploadId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val partIds: JsonField<List<String>>,
        private val md5: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("part_ids")
            @ExcludeMissing
            partIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("md5") @ExcludeMissing md5: JsonField<String> = JsonMissing.of(),
        ) : this(partIds, md5, mutableMapOf())

        /**
         * The ordered list of Part IDs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun partIds(): List<String> = partIds.getRequired("part_ids")

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun md5(): Optional<String> = Optional.ofNullable(md5.getNullable("md5"))

        /**
         * Returns the raw JSON value of [partIds].
         *
         * Unlike [partIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("part_ids") @ExcludeMissing fun _partIds(): JsonField<List<String>> = partIds

        /**
         * Returns the raw JSON value of [md5].
         *
         * Unlike [md5], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("md5") @ExcludeMissing fun _md5(): JsonField<String> = md5

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
             * .partIds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var partIds: JsonField<MutableList<String>>? = null
            private var md5: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                partIds = body.partIds.map { it.toMutableList() }
                md5 = body.md5
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The ordered list of Part IDs. */
            fun partIds(partIds: List<String>) = partIds(JsonField.of(partIds))

            /**
             * Sets [Builder.partIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.partIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun partIds(partIds: JsonField<List<String>>) = apply {
                this.partIds = partIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [partIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPartId(partId: String) = apply {
                partIds =
                    (partIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("partIds", it).add(partId)
                    }
            }

            /**
             * The optional md5 checksum for the file contents to verify if the bytes uploaded
             * matches what you expect.
             */
            fun md5(md5: String) = md5(JsonField.of(md5))

            /**
             * Sets [Builder.md5] to an arbitrary JSON value.
             *
             * You should usually call [Builder.md5] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun md5(md5: JsonField<String>) = apply { this.md5 = md5 }

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
             * .partIds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("partIds", partIds).map { it.toImmutable() },
                    md5,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            partIds()
            md5()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (partIds.asKnown().getOrNull()?.size ?: 0) + (if (md5.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && partIds == other.partIds && md5 == other.md5 && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(partIds, md5, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{partIds=$partIds, md5=$md5, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadCompleteParams && uploadId == other.uploadId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(uploadId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UploadCompleteParams{uploadId=$uploadId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
