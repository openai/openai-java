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
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/**
 * Create a vector store file by attaching a
 * [File](https://platform.openai.com/docs/api-reference/files) to a
 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
 */
class BetaVectorStoreFileCreateParams
private constructor(
    private val vectorStoreId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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

    /**
     * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
     * should use. Useful for tools like `file_search` that can access files.
     */
    fun _fileId(): JsonField<String> = body._fileId()

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = body._chunkingStrategy()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> vectorStoreId
            else -> ""
        }
    }

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        private val chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
         * should use. Useful for tools like `file_search` that can access files.
         */
        fun fileId(): String = fileId.getRequired("file_id")

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
            Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

        /**
         * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
         * should use. Useful for tools like `file_search` that can access files.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

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

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            fileId()
            chunkingStrategy().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .fileId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var fileId: JsonField<String>? = null
            private var chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                fileId = body.fileId
                chunkingStrategy = body.chunkingStrategy
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector
             * store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /**
             * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector
             * store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

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
            fun chunkingStrategy(auto: AutoFileChunkingStrategyParam) =
                chunkingStrategy(FileChunkingStrategyParam.ofAuto(auto))

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(static_: StaticFileChunkingStrategyObjectParam) =
                chunkingStrategy(FileChunkingStrategyParam.ofStatic(static_))

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) =
                chunkingStrategy(
                    StaticFileChunkingStrategyObjectParam.builder().static_(static_).build()
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

            fun build(): Body =
                Body(
                    checkRequired("fileId", fileId),
                    chunkingStrategy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && fileId == other.fileId && chunkingStrategy == other.chunkingStrategy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, chunkingStrategy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{fileId=$fileId, chunkingStrategy=$chunkingStrategy, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BetaVectorStoreFileCreateParams].
         *
         * The following fields are required:
         * ```java
         * .vectorStoreId()
         * .fileId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaVectorStoreFileCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var vectorStoreId: String? = null
        private var body: Body.Builder = Body.builder()
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
         * A [File](https://platform.openai.com/docs/api-reference/files) ID that the vector store
         * should use. Useful for tools like `file_search` that can access files.
         */
        fun fileId(fileId: JsonField<String>) = apply { body.fileId(fileId) }

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
        fun chunkingStrategy(auto: AutoFileChunkingStrategyParam) = apply {
            body.chunkingStrategy(auto)
        }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(static_: StaticFileChunkingStrategyObjectParam) = apply {
            body.chunkingStrategy(static_)
        }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) = apply {
            body.staticChunkingStrategy(static_)
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

        fun build(): BetaVectorStoreFileCreateParams =
            BetaVectorStoreFileCreateParams(
                checkRequired("vectorStoreId", vectorStoreId),
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
