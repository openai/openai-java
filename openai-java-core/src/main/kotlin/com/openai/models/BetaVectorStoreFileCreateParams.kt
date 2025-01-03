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

class BetaVectorStoreFileCreateParams
constructor(
    private val vectorStoreId: String,
    private val body: BetaVectorStoreFileCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun vectorStoreId(): String = vectorStoreId

    /**
     * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
     * should use. Useful for tools like `file_search` that can access files.
     */
    fun fileId(): String = body.fileId()

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun chunkingStrategy(): Optional<FileChunkingStrategyParam> = body.chunkingStrategy()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BetaVectorStoreFileCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> vectorStoreId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaVectorStoreFileCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("file_id") private val fileId: String,
        @JsonProperty("chunking_strategy") private val chunkingStrategy: FileChunkingStrategyParam?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
         * should use. Useful for tools like `file_search` that can access files.
         */
        @JsonProperty("file_id") fun fileId(): String = fileId

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        @JsonProperty("chunking_strategy")
        fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
            Optional.ofNullable(chunkingStrategy)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: String? = null
            private var chunkingStrategy: FileChunkingStrategyParam? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaVectorStoreFileCreateBody: BetaVectorStoreFileCreateBody) =
                apply {
                    fileId = betaVectorStoreFileCreateBody.fileId
                    chunkingStrategy = betaVectorStoreFileCreateBody.chunkingStrategy
                    additionalProperties =
                        betaVectorStoreFileCreateBody.additionalProperties.toMutableMap()
                }

            /**
             * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector
             * store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileId(fileId: String) = apply { this.fileId = fileId }

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) = apply {
                this.chunkingStrategy = chunkingStrategy
            }

            /**
             * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800`
             * and `chunk_overlap_tokens` of `400`.
             */
            fun chunkingStrategy(autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam) =
                apply {
                    this.chunkingStrategy =
                        FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                            autoFileChunkingStrategyParam
                        )
                }

            fun chunkingStrategy(staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam) =
                apply {
                    this.chunkingStrategy =
                        FileChunkingStrategyParam.ofStaticFileChunkingStrategyParam(
                            staticFileChunkingStrategyParam
                        )
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

            fun build(): BetaVectorStoreFileCreateBody =
                BetaVectorStoreFileCreateBody(
                    checkNotNull(fileId) { "`fileId` is required but was not set" },
                    chunkingStrategy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaVectorStoreFileCreateBody && fileId == other.fileId && chunkingStrategy == other.chunkingStrategy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, chunkingStrategy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaVectorStoreFileCreateBody{fileId=$fileId, chunkingStrategy=$chunkingStrategy, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var vectorStoreId: String? = null
        private var body: BetaVectorStoreFileCreateBody.Builder =
            BetaVectorStoreFileCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaVectorStoreFileCreateParams: BetaVectorStoreFileCreateParams) =
            apply {
                vectorStoreId = betaVectorStoreFileCreateParams.vectorStoreId
                body = betaVectorStoreFileCreateParams.body.toBuilder()
                additionalHeaders = betaVectorStoreFileCreateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    betaVectorStoreFileCreateParams.additionalQueryParams.toBuilder()
            }

        fun vectorStoreId(vectorStoreId: String) = apply { this.vectorStoreId = vectorStoreId }

        /**
         * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
         * should use. Useful for tools like `file_search` that can access files.
         */
        fun fileId(fileId: String) = apply { body.fileId(fileId) }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /**
         * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
         * `chunk_overlap_tokens` of `400`.
         */
        fun chunkingStrategy(autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam) = apply {
            body.chunkingStrategy(autoFileChunkingStrategyParam)
        }

        fun chunkingStrategy(staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam) =
            apply {
                body.chunkingStrategy(staticFileChunkingStrategyParam)
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

        fun build(): BetaVectorStoreFileCreateParams =
            BetaVectorStoreFileCreateParams(
                checkNotNull(vectorStoreId) { "`vectorStoreId` is required but was not set" },
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaVectorStoreFileCreateParams && vectorStoreId == other.vectorStoreId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoreId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaVectorStoreFileCreateParams{vectorStoreId=$vectorStoreId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
