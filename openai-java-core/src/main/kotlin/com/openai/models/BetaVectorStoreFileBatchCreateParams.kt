// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Create a vector store file batch. */
class BetaVectorStoreFileBatchCreateParams
constructor(
    private val vectorStoreId: String,
    private val body: BetaVectorStoreFileBatchCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun vectorStoreId(): String = vectorStoreId

    /**
     * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the vector
     * store should use. Useful for tools like `file_search` that can access files.
     */
    fun fileIds(): List<String> = body.fileIds()

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun chunkingStrategy(): Optional<FileChunkingStrategyParam> = body.chunkingStrategy()

    /**
     * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the vector
     * store should use. Useful for tools like `file_search` that can access files.
     */
    fun _fileIds(): JsonField<List<String>> = body._fileIds()

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = body._chunkingStrategy()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): BetaVectorStoreFileBatchCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> vectorStoreId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaVectorStoreFileBatchCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("file_ids")
        @ExcludeMissing
        private val fileIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        private val chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun fileIds(): List<String> = fileIds.getRequired("file_ids")

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
            Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        @JsonProperty("file_ids") @ExcludeMissing fun _fileIds(): JsonField<List<String>> = fileIds

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = chunkingStrategy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaVectorStoreFileBatchCreateBody = apply {
            if (validated) {
                return@apply
            }

            fileIds()
            chunkingStrategy().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileIds: JsonField<MutableList<String>>? = null
            private var chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                betaVectorStoreFileBatchCreateBody: BetaVectorStoreFileBatchCreateBody
            ) = apply {
                fileIds = betaVectorStoreFileBatchCreateBody.fileIds.map { it.toMutableList() }
                chunkingStrategy = betaVectorStoreFileBatchCreateBody.chunkingStrategy
                additionalProperties =
                    betaVectorStoreFileBatchCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
             * vector store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

            /**
             * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
             * vector store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileIds(fileIds: JsonField<List<String>>) = apply {
                this.fileIds = fileIds.map { it.toMutableList() }
            }

            /**
             * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
             * vector store should use. Useful for tools like `file_search` that can access files.
             */
            fun addFileId(fileId: String) = apply {
                fileIds =
                    (fileIds ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(fileId)
                    }
            }

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) =
                chunkingStrategy(JsonField.of(chunkingStrategy))

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) = apply {
                this.chunkingStrategy = chunkingStrategy
            }

            /**
             * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800`
             * and `chunk_overlap_tokens` of `400`.
             */
            fun chunkingStrategy(autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam) =
                chunkingStrategy(
                    FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                        autoFileChunkingStrategyParam
                    )
                )

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam) =
                chunkingStrategy(
                    FileChunkingStrategyParam.ofStaticFileChunkingStrategyParam(
                        staticFileChunkingStrategyParam
                    )
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

            fun build(): BetaVectorStoreFileBatchCreateBody =
                BetaVectorStoreFileBatchCreateBody(
                    checkNotNull(fileIds) { "`fileIds` is required but was not set" }
                        .map { it.toImmutable() },
                    chunkingStrategy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaVectorStoreFileBatchCreateBody && fileIds == other.fileIds && chunkingStrategy == other.chunkingStrategy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileIds, chunkingStrategy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaVectorStoreFileBatchCreateBody{fileIds=$fileIds, chunkingStrategy=$chunkingStrategy, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var vectorStoreId: String? = null
        private var body: BetaVectorStoreFileBatchCreateBody.Builder =
            BetaVectorStoreFileBatchCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            betaVectorStoreFileBatchCreateParams: BetaVectorStoreFileBatchCreateParams
        ) = apply {
            vectorStoreId = betaVectorStoreFileBatchCreateParams.vectorStoreId
            body = betaVectorStoreFileBatchCreateParams.body.toBuilder()
            additionalHeaders = betaVectorStoreFileBatchCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                betaVectorStoreFileBatchCreateParams.additionalQueryParams.toBuilder()
        }

        fun vectorStoreId(vectorStoreId: String) = apply { this.vectorStoreId = vectorStoreId }

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun fileIds(fileIds: List<String>) = apply { body.fileIds(fileIds) }

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun fileIds(fileIds: JsonField<List<String>>) = apply { body.fileIds(fileIds) }

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun addFileId(fileId: String) = apply { body.addFileId(fileId) }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /**
         * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
         * `chunk_overlap_tokens` of `400`.
         */
        fun chunkingStrategy(autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam) = apply {
            body.chunkingStrategy(autoFileChunkingStrategyParam)
        }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam) =
            apply {
                body.chunkingStrategy(staticFileChunkingStrategyParam)
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

        fun build(): BetaVectorStoreFileBatchCreateParams =
            BetaVectorStoreFileBatchCreateParams(
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

        return /* spotless:off */ other is BetaVectorStoreFileBatchCreateParams && vectorStoreId == other.vectorStoreId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoreId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaVectorStoreFileBatchCreateParams{vectorStoreId=$vectorStoreId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
