// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

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

/** Create a vector store. */
class VectorStoreCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy.
     * Only applicable if `file_ids` is non-empty.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun chunkingStrategy(): Optional<FileChunkingStrategyParam> = body.chunkingStrategy()

    /**
     * The expiration policy for a vector store.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAfter(): Optional<ExpiresAfter> = body.expiresAfter()

    /**
     * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the vector
     * store should use. Useful for tools like `file_search` that can access files.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileIds(): Optional<List<String>> = body.fileIds()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * The name of the vector store.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Returns the raw JSON value of [chunkingStrategy].
     *
     * Unlike [chunkingStrategy], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = body._chunkingStrategy()

    /**
     * Returns the raw JSON value of [expiresAfter].
     *
     * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _expiresAfter(): JsonField<ExpiresAfter> = body._expiresAfter()

    /**
     * Returns the raw JSON value of [fileIds].
     *
     * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fileIds(): JsonField<List<String>> = body._fileIds()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): VectorStoreCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [VectorStoreCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(vectorStoreCreateParams: VectorStoreCreateParams) = apply {
            body = vectorStoreCreateParams.body.toBuilder()
            additionalHeaders = vectorStoreCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = vectorStoreCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [chunkingStrategy]
         * - [expiresAfter]
         * - [fileIds]
         * - [metadata]
         * - [name]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         */
        fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /**
         * Sets [Builder.chunkingStrategy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chunkingStrategy] with a well-typed
         * [FileChunkingStrategyParam] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /** Alias for calling [chunkingStrategy] with `FileChunkingStrategyParam.ofAuto(auto)`. */
        fun chunkingStrategy(auto: AutoFileChunkingStrategyParam) = apply {
            body.chunkingStrategy(auto)
        }

        /**
         * Alias for calling [chunkingStrategy] with `FileChunkingStrategyParam.ofStatic(static_)`.
         */
        fun chunkingStrategy(static_: StaticFileChunkingStrategyObjectParam) = apply {
            body.chunkingStrategy(static_)
        }

        /**
         * Alias for calling [chunkingStrategy] with the following:
         * ```java
         * StaticFileChunkingStrategyObjectParam.builder()
         *     .static_(static_)
         *     .build()
         * ```
         */
        fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) = apply {
            body.staticChunkingStrategy(static_)
        }

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = apply { body.expiresAfter(expiresAfter) }

        /**
         * Sets [Builder.expiresAfter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            body.expiresAfter(expiresAfter)
        }

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         */
        fun fileIds(fileIds: List<String>) = apply { body.fileIds(fileIds) }

        /**
         * Sets [Builder.fileIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileIds] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fileIds(fileIds: JsonField<List<String>>) = apply { body.fileIds(fileIds) }

        /**
         * Adds a single [String] to [fileIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFileId(fileId: String) = apply { body.addFileId(fileId) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /** The name of the vector store. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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

        /**
         * Returns an immutable instance of [VectorStoreCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VectorStoreCreateParams =
            VectorStoreCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val chunkingStrategy: JsonField<FileChunkingStrategyParam>,
        private val expiresAfter: JsonField<ExpiresAfter>,
        private val fileIds: JsonField<List<String>>,
        private val metadata: JsonField<Metadata>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("chunking_strategy")
            @ExcludeMissing
            chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of(),
            @JsonProperty("expires_after")
            @ExcludeMissing
            expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
            @JsonProperty("file_ids")
            @ExcludeMissing
            fileIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(chunkingStrategy, expiresAfter, fileIds, metadata, name, mutableMapOf())

        /**
         * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
         * strategy. Only applicable if `file_ids` is non-empty.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
            Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

        /**
         * The expiration policy for a vector store.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAfter(): Optional<ExpiresAfter> =
            Optional.ofNullable(expiresAfter.getNullable("expires_after"))

        /**
         * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
         * vector store should use. Useful for tools like `file_search` that can access files.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds.getNullable("file_ids"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * The name of the vector store.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /**
         * Returns the raw JSON value of [chunkingStrategy].
         *
         * Unlike [chunkingStrategy], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = chunkingStrategy

        /**
         * Returns the raw JSON value of [expiresAfter].
         *
         * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

        /**
         * Returns the raw JSON value of [fileIds].
         *
         * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_ids") @ExcludeMissing fun _fileIds(): JsonField<List<String>> = fileIds

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var chunkingStrategy: JsonField<FileChunkingStrategyParam> = JsonMissing.of()
            private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
            private var fileIds: JsonField<MutableList<String>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                chunkingStrategy = body.chunkingStrategy
                expiresAfter = body.expiresAfter
                fileIds = body.fileIds.map { it.toMutableList() }
                metadata = body.metadata
                name = body.name
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
             * strategy. Only applicable if `file_ids` is non-empty.
             */
            fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) =
                chunkingStrategy(JsonField.of(chunkingStrategy))

            /**
             * Sets [Builder.chunkingStrategy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chunkingStrategy] with a well-typed
             * [FileChunkingStrategyParam] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) = apply {
                this.chunkingStrategy = chunkingStrategy
            }

            /**
             * Alias for calling [chunkingStrategy] with `FileChunkingStrategyParam.ofAuto(auto)`.
             */
            fun chunkingStrategy(auto: AutoFileChunkingStrategyParam) =
                chunkingStrategy(FileChunkingStrategyParam.ofAuto(auto))

            /**
             * Alias for calling [chunkingStrategy] with
             * `FileChunkingStrategyParam.ofStatic(static_)`.
             */
            fun chunkingStrategy(static_: StaticFileChunkingStrategyObjectParam) =
                chunkingStrategy(FileChunkingStrategyParam.ofStatic(static_))

            /**
             * Alias for calling [chunkingStrategy] with the following:
             * ```java
             * StaticFileChunkingStrategyObjectParam.builder()
             *     .static_(static_)
             *     .build()
             * ```
             */
            fun staticChunkingStrategy(static_: StaticFileChunkingStrategy) =
                chunkingStrategy(
                    StaticFileChunkingStrategyObjectParam.builder().static_(static_).build()
                )

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

            /**
             * Sets [Builder.expiresAfter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
            }

            /**
             * A list of [File](https://platform.openai.com/docs/api-reference/files) IDs that the
             * vector store should use. Useful for tools like `file_search` that can access files.
             */
            fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

            /**
             * Sets [Builder.fileIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileIds(fileIds: JsonField<List<String>>) = apply {
                this.fileIds = fileIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [fileIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFileId(fileId: String) = apply {
                fileIds =
                    (fileIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("fileIds", it).add(fileId)
                    }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /** The name of the vector store. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    chunkingStrategy,
                    expiresAfter,
                    (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    name,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            chunkingStrategy().ifPresent { it.validate() }
            expiresAfter().ifPresent { it.validate() }
            fileIds()
            metadata().ifPresent { it.validate() }
            name()
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
            (chunkingStrategy.asKnown().getOrNull()?.validity() ?: 0) +
                (expiresAfter.asKnown().getOrNull()?.validity() ?: 0) +
                (fileIds.asKnown().getOrNull()?.size ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && chunkingStrategy == other.chunkingStrategy && expiresAfter == other.expiresAfter && fileIds == other.fileIds && metadata == other.metadata && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(chunkingStrategy, expiresAfter, fileIds, metadata, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{chunkingStrategy=$chunkingStrategy, expiresAfter=$expiresAfter, fileIds=$fileIds, metadata=$metadata, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The expiration policy for a vector store. */
    class ExpiresAfter
    private constructor(
        private val anchor: JsonValue,
        private val days: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("anchor") @ExcludeMissing anchor: JsonValue = JsonMissing.of(),
            @JsonProperty("days") @ExcludeMissing days: JsonField<Long> = JsonMissing.of(),
        ) : this(anchor, days, mutableMapOf())

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("last_active_at")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

        /**
         * The number of days after the anchor time that the vector store will expire.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun days(): Long = days.getRequired("days")

        /**
         * Returns the raw JSON value of [days].
         *
         * Unlike [days], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

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
             * Returns a mutable builder for constructing an instance of [ExpiresAfter].
             *
             * The following fields are required:
             * ```java
             * .days()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonValue = JsonValue.from("last_active_at")
            private var days: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                days = expiresAfter.days
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("last_active_at")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: Long) = days(JsonField.of(days))

            /**
             * Sets [Builder.days] to an arbitrary JSON value.
             *
             * You should usually call [Builder.days] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
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

            /**
             * Returns an immutable instance of [ExpiresAfter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .days()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ExpiresAfter =
                ExpiresAfter(
                    anchor,
                    checkRequired("days", days),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            _anchor().let {
                if (it != JsonValue.from("last_active_at")) {
                    throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
                }
            }
            days()
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
            anchor.let { if (it == JsonValue.from("last_active_at")) 1 else 0 } +
                (if (days.asKnown().isPresent) 1 else 0)

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

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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

            /**
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "VectorStoreCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
