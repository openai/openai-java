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
import java.util.Optional

class UploadCompleteParams
constructor(
    private val uploadId: String,
    private val body: UploadCompleteBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun uploadId(): String = uploadId

    /** The ordered list of Part IDs. */
    fun partIds(): List<String> = body.partIds()

    /**
     * The optional md5 checksum for the file contents to verify if the bytes uploaded matches what
     * you expect.
     */
    fun md5(): Optional<String> = body.md5()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): UploadCompleteBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> uploadId
            else -> ""
        }
    }

    @NoAutoDetect
    class UploadCompleteBody
    @JsonCreator
    internal constructor(
        @JsonProperty("part_ids") private val partIds: List<String>,
        @JsonProperty("md5") private val md5: String?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ordered list of Part IDs. */
        @JsonProperty("part_ids") fun partIds(): List<String> = partIds

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        @JsonProperty("md5") fun md5(): Optional<String> = Optional.ofNullable(md5)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var partIds: MutableList<String>? = null
            private var md5: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(uploadCompleteBody: UploadCompleteBody) = apply {
                partIds = uploadCompleteBody.partIds.toMutableList()
                md5 = uploadCompleteBody.md5
                additionalProperties = uploadCompleteBody.additionalProperties.toMutableMap()
            }

            /** The ordered list of Part IDs. */
            fun partIds(partIds: List<String>) = apply { this.partIds = partIds.toMutableList() }

            /** The ordered list of Part IDs. */
            fun addPartId(partId: String) = apply {
                partIds = (partIds ?: mutableListOf()).apply { add(partId) }
            }

            /**
             * The optional md5 checksum for the file contents to verify if the bytes uploaded
             * matches what you expect.
             */
            fun md5(md5: String?) = apply { this.md5 = md5 }

            /**
             * The optional md5 checksum for the file contents to verify if the bytes uploaded
             * matches what you expect.
             */
            fun md5(md5: Optional<String>) = md5(md5.orElse(null))

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

            fun build(): UploadCompleteBody =
                UploadCompleteBody(
                    checkNotNull(partIds) { "`partIds` is required but was not set" }.toImmutable(),
                    md5,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UploadCompleteBody && partIds == other.partIds && md5 == other.md5 && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(partIds, md5, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UploadCompleteBody{partIds=$partIds, md5=$md5, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var uploadId: String? = null
        private var body: UploadCompleteBody.Builder = UploadCompleteBody.builder()
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

        /** The ordered list of Part IDs. */
        fun addPartId(partId: String) = apply { body.addPartId(partId) }

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        fun md5(md5: String?) = apply { body.md5(md5) }

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        fun md5(md5: Optional<String>) = md5(md5.orElse(null))

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

        fun build(): UploadCompleteParams =
            UploadCompleteParams(
                checkNotNull(uploadId) { "`uploadId` is required but was not set" },
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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
