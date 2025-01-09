// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Create a vector store. */
class BetaVectorStoreCreateParams
constructor(
    private val body: BetaVectorStoreCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun chunkingStrategy(): Optional<FileChunkingStrategyParam> = body.chunkingStrategy()

    /** The expiration policy for a vector store. */
    fun expiresAfter(): Optional<ExpiresAfter> = body.expiresAfter()

    /**
     * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the vector
     * store should use. Useful for tools like `file_search` that can access files.
     */
    fun fileIds(): Optional<List<String>> = body.fileIds()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun _metadata(): JsonValue = body._metadata()

    /** The name of the vector store. */
    fun name(): Optional<String> = body.name()

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     */
    fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = body._chunkingStrategy()

    /** The expiration policy for a vector store. */
    fun _expiresAfter(): JsonField<ExpiresAfter> = body._expiresAfter()

    /**
     * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the vector
     * store should use. Useful for tools like `file_search` that can access files.
     */
    fun _fileIds(): JsonField<List<String>> = body._fileIds()

    /** The name of the vector store. */
    fun _name(): JsonField<String> = body._name()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): BetaVectorStoreCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class BetaVectorStoreCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        private val chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of(),
        @JsonProperty("expires_after")
        @ExcludeMissing
        private val expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
        @JsonProperty("file_ids")
        @ExcludeMissing
        private val fileIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
            Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

        /** The expiration policy for a vector store. */
        fun expiresAfter(): Optional<ExpiresAfter> =
            Optional.ofNullable(expiresAfter.getNullable("expires_after"))

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds.getNullable("file_ids"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /** The name of the vector store. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = chunkingStrategy

        /** The expiration policy for a vector store. */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        @JsonProperty("file_ids") @ExcludeMissing fun _fileIds(): JsonField<List<String>> = fileIds

        /** The name of the vector store. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaVectorStoreCreateBody = apply {
            if (!validated) {
                chunkingStrategy()
                expiresAfter().map { it.validate() }
                fileIds()
                name()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of()
            private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
            private var fileIds: JsonField<MutableList<String>>? = null
            private var metadata: JsonValue = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaVectorStoreCreateBody: BetaVectorStoreCreateBody) = apply {
                chunkingStrategy = betaVectorStoreCreateBody.chunkingStrategy
                expiresAfter = betaVectorStoreCreateBody.expiresAfter
                fileIds = betaVectorStoreCreateBody.fileIds.map { it.toMutableList() }
                metadata = betaVectorStoreCreateBody.metadata
                name = betaVectorStoreCreateBody.name
                additionalProperties = betaVectorStoreCreateBody.additionalProperties.toMutableMap()
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

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
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
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /** The name of the vector store. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the vector store. */
            fun name(name: JsonField<String>) = apply { this.name = name }

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

            fun build(): BetaVectorStoreCreateBody =
                BetaVectorStoreCreateBody(
                    chunkingStrategy,
                    expiresAfter,
                    (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    name,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaVectorStoreCreateBody && chunkingStrategy == other.chunkingStrategy && expiresAfter == other.expiresAfter && fileIds == other.fileIds && metadata == other.metadata && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(chunkingStrategy, expiresAfter, fileIds, metadata, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaVectorStoreCreateBody{chunkingStrategy=$chunkingStrategy, expiresAfter=$expiresAfter, fileIds=$fileIds, metadata=$metadata, name=$name, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var body: BetaVectorStoreCreateBody.Builder = BetaVectorStoreCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaVectorStoreCreateParams: BetaVectorStoreCreateParams) = apply {
            body = betaVectorStoreCreateParams.body.toBuilder()
            additionalHeaders = betaVectorStoreCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaVectorStoreCreateParams.additionalQueryParams.toBuilder()
        }

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

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = apply { body.expiresAfter(expiresAfter) }

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            body.expiresAfter(expiresAfter)
        }

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
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /** The name of the vector store. */
        fun name(name: String) = apply { body.name(name) }

        /** The name of the vector store. */
        fun name(name: JsonField<String>) = apply { body.name(name) }

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

        fun build(): BetaVectorStoreCreateParams =
            BetaVectorStoreCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** The expiration policy for a vector store. */
    @NoAutoDetect
    class ExpiresAfter
    @JsonCreator
    private constructor(
        @JsonProperty("anchor")
        @ExcludeMissing
        private val anchor: JsonField<Anchor> = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing private val days: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        fun anchor(): Anchor = anchor.getRequired("anchor")

        /** The number of days after the anchor time that the vector store will expire. */
        fun days(): Long = days.getRequired("days")

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonField<Anchor> = anchor

        /** The number of days after the anchor time that the vector store will expire. */
        @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (!validated) {
                anchor()
                days()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var anchor: JsonField<Anchor>? = null
            private var days: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                days = expiresAfter.days
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Anchor timestamp after which the expiration policy applies. Supported anchors:
             * `last_active_at`.
             */
            fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

            /**
             * Anchor timestamp after which the expiration policy applies. Supported anchors:
             * `last_active_at`.
             */
            fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: Long) = days(JsonField.of(days))

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: JsonField<Long>) = apply { this.days = days }

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

            fun build(): ExpiresAfter =
                ExpiresAfter(
                    checkNotNull(anchor) { "`anchor` is required but was not set" },
                    checkNotNull(days) { "`days` is required but was not set" },
                    additionalProperties.toImmutable(),
                )
        }

        class Anchor
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val LAST_ACTIVE_AT = of("last_active_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            enum class Known {
                LAST_ACTIVE_AT,
            }

            enum class Value {
                LAST_ACTIVE_AT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    LAST_ACTIVE_AT -> Value.LAST_ACTIVE_AT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    LAST_ACTIVE_AT -> Known.LAST_ACTIVE_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Anchor && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ExpiresAfter && anchor == other.anchor && days == other.days && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(anchor, days, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, days=$days, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaVectorStoreCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaVectorStoreCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
