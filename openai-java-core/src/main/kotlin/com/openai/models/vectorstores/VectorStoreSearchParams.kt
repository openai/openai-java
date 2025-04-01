// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ComparisonFilter
import com.openai.models.CompoundFilter
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Search a vector store for relevant chunks based on a query and file attributes filter. */
class VectorStoreSearchParams
private constructor(
    private val vectorStoreId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun vectorStoreId(): String = vectorStoreId

    /**
     * A query string for a search
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun query(): Query = body.query()

    /**
     * A filter to apply based on file attributes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filters(): Optional<Filters> = body.filters()

    /**
     * The maximum number of results to return. This number should be between 1 and 50 inclusive.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxNumResults(): Optional<Long> = body.maxNumResults()

    /**
     * Ranking options for search.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rankingOptions(): Optional<RankingOptions> = body.rankingOptions()

    /**
     * Whether to rewrite the natural language query for vector search.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rewriteQuery(): Optional<Boolean> = body.rewriteQuery()

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _query(): JsonField<Query> = body._query()

    /**
     * Returns the raw JSON value of [filters].
     *
     * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _filters(): JsonField<Filters> = body._filters()

    /**
     * Returns the raw JSON value of [maxNumResults].
     *
     * Unlike [maxNumResults], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxNumResults(): JsonField<Long> = body._maxNumResults()

    /**
     * Returns the raw JSON value of [rankingOptions].
     *
     * Unlike [rankingOptions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _rankingOptions(): JsonField<RankingOptions> = body._rankingOptions()

    /**
     * Returns the raw JSON value of [rewriteQuery].
     *
     * Unlike [rewriteQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _rewriteQuery(): JsonField<Boolean> = body._rewriteQuery()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreSearchParams].
         *
         * The following fields are required:
         * ```java
         * .vectorStoreId()
         * .query()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreSearchParams]. */
    class Builder internal constructor() {

        private var vectorStoreId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(vectorStoreSearchParams: VectorStoreSearchParams) = apply {
            vectorStoreId = vectorStoreSearchParams.vectorStoreId
            body = vectorStoreSearchParams.body.toBuilder()
            additionalHeaders = vectorStoreSearchParams.additionalHeaders.toBuilder()
            additionalQueryParams = vectorStoreSearchParams.additionalQueryParams.toBuilder()
        }

        fun vectorStoreId(vectorStoreId: String) = apply { this.vectorStoreId = vectorStoreId }

        /** A query string for a search */
        fun query(query: Query) = apply { body.query(query) }

        /**
         * Sets [Builder.query] to an arbitrary JSON value.
         *
         * You should usually call [Builder.query] with a well-typed [Query] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun query(query: JsonField<Query>) = apply { body.query(query) }

        /** Alias for calling [query] with `Query.ofString(string)`. */
        fun query(string: String) = apply { body.query(string) }

        /** Alias for calling [query] with `Query.ofStrings(strings)`. */
        fun queryOfStrings(strings: List<String>) = apply { body.queryOfStrings(strings) }

        /** A filter to apply based on file attributes. */
        fun filters(filters: Filters) = apply { body.filters(filters) }

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed [Filters] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filters(filters: JsonField<Filters>) = apply { body.filters(filters) }

        /** Alias for calling [filters] with `Filters.ofComparisonFilter(comparisonFilter)`. */
        fun filters(comparisonFilter: ComparisonFilter) = apply { body.filters(comparisonFilter) }

        /** Alias for calling [filters] with `Filters.ofCompoundFilter(compoundFilter)`. */
        fun filters(compoundFilter: CompoundFilter) = apply { body.filters(compoundFilter) }

        /**
         * The maximum number of results to return. This number should be between 1 and 50
         * inclusive.
         */
        fun maxNumResults(maxNumResults: Long) = apply { body.maxNumResults(maxNumResults) }

        /**
         * Sets [Builder.maxNumResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxNumResults] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxNumResults(maxNumResults: JsonField<Long>) = apply {
            body.maxNumResults(maxNumResults)
        }

        /** Ranking options for search. */
        fun rankingOptions(rankingOptions: RankingOptions) = apply {
            body.rankingOptions(rankingOptions)
        }

        /**
         * Sets [Builder.rankingOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rankingOptions] with a well-typed [RankingOptions] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rankingOptions(rankingOptions: JsonField<RankingOptions>) = apply {
            body.rankingOptions(rankingOptions)
        }

        /** Whether to rewrite the natural language query for vector search. */
        fun rewriteQuery(rewriteQuery: Boolean) = apply { body.rewriteQuery(rewriteQuery) }

        /**
         * Sets [Builder.rewriteQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rewriteQuery] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rewriteQuery(rewriteQuery: JsonField<Boolean>) = apply {
            body.rewriteQuery(rewriteQuery)
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

        /**
         * Returns an immutable instance of [VectorStoreSearchParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .vectorStoreId()
         * .query()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VectorStoreSearchParams =
            VectorStoreSearchParams(
                checkRequired("vectorStoreId", vectorStoreId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> vectorStoreId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val query: JsonField<Query>,
        private val filters: JsonField<Filters>,
        private val maxNumResults: JsonField<Long>,
        private val rankingOptions: JsonField<RankingOptions>,
        private val rewriteQuery: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("query") @ExcludeMissing query: JsonField<Query> = JsonMissing.of(),
            @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filters> = JsonMissing.of(),
            @JsonProperty("max_num_results")
            @ExcludeMissing
            maxNumResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("ranking_options")
            @ExcludeMissing
            rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
            @JsonProperty("rewrite_query")
            @ExcludeMissing
            rewriteQuery: JsonField<Boolean> = JsonMissing.of(),
        ) : this(query, filters, maxNumResults, rankingOptions, rewriteQuery, mutableMapOf())

        /**
         * A query string for a search
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun query(): Query = query.getRequired("query")

        /**
         * A filter to apply based on file attributes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun filters(): Optional<Filters> = Optional.ofNullable(filters.getNullable("filters"))

        /**
         * The maximum number of results to return. This number should be between 1 and 50
         * inclusive.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxNumResults(): Optional<Long> =
            Optional.ofNullable(maxNumResults.getNullable("max_num_results"))

        /**
         * Ranking options for search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rankingOptions(): Optional<RankingOptions> =
            Optional.ofNullable(rankingOptions.getNullable("ranking_options"))

        /**
         * Whether to rewrite the natural language query for vector search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rewriteQuery(): Optional<Boolean> =
            Optional.ofNullable(rewriteQuery.getNullable("rewrite_query"))

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<Query> = query

        /**
         * Returns the raw JSON value of [filters].
         *
         * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filters> = filters

        /**
         * Returns the raw JSON value of [maxNumResults].
         *
         * Unlike [maxNumResults], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_num_results")
        @ExcludeMissing
        fun _maxNumResults(): JsonField<Long> = maxNumResults

        /**
         * Returns the raw JSON value of [rankingOptions].
         *
         * Unlike [rankingOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ranking_options")
        @ExcludeMissing
        fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

        /**
         * Returns the raw JSON value of [rewriteQuery].
         *
         * Unlike [rewriteQuery], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("rewrite_query")
        @ExcludeMissing
        fun _rewriteQuery(): JsonField<Boolean> = rewriteQuery

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
             * .query()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var query: JsonField<Query>? = null
            private var filters: JsonField<Filters> = JsonMissing.of()
            private var maxNumResults: JsonField<Long> = JsonMissing.of()
            private var rankingOptions: JsonField<RankingOptions> = JsonMissing.of()
            private var rewriteQuery: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                query = body.query
                filters = body.filters
                maxNumResults = body.maxNumResults
                rankingOptions = body.rankingOptions
                rewriteQuery = body.rewriteQuery
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** A query string for a search */
            fun query(query: Query) = query(JsonField.of(query))

            /**
             * Sets [Builder.query] to an arbitrary JSON value.
             *
             * You should usually call [Builder.query] with a well-typed [Query] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun query(query: JsonField<Query>) = apply { this.query = query }

            /** Alias for calling [query] with `Query.ofString(string)`. */
            fun query(string: String) = query(Query.ofString(string))

            /** Alias for calling [query] with `Query.ofStrings(strings)`. */
            fun queryOfStrings(strings: List<String>) = query(Query.ofStrings(strings))

            /** A filter to apply based on file attributes. */
            fun filters(filters: Filters) = filters(JsonField.of(filters))

            /**
             * Sets [Builder.filters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filters] with a well-typed [Filters] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filters(filters: JsonField<Filters>) = apply { this.filters = filters }

            /** Alias for calling [filters] with `Filters.ofComparisonFilter(comparisonFilter)`. */
            fun filters(comparisonFilter: ComparisonFilter) =
                filters(Filters.ofComparisonFilter(comparisonFilter))

            /** Alias for calling [filters] with `Filters.ofCompoundFilter(compoundFilter)`. */
            fun filters(compoundFilter: CompoundFilter) =
                filters(Filters.ofCompoundFilter(compoundFilter))

            /**
             * The maximum number of results to return. This number should be between 1 and 50
             * inclusive.
             */
            fun maxNumResults(maxNumResults: Long) = maxNumResults(JsonField.of(maxNumResults))

            /**
             * Sets [Builder.maxNumResults] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxNumResults] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxNumResults(maxNumResults: JsonField<Long>) = apply {
                this.maxNumResults = maxNumResults
            }

            /** Ranking options for search. */
            fun rankingOptions(rankingOptions: RankingOptions) =
                rankingOptions(JsonField.of(rankingOptions))

            /**
             * Sets [Builder.rankingOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rankingOptions] with a well-typed [RankingOptions]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun rankingOptions(rankingOptions: JsonField<RankingOptions>) = apply {
                this.rankingOptions = rankingOptions
            }

            /** Whether to rewrite the natural language query for vector search. */
            fun rewriteQuery(rewriteQuery: Boolean) = rewriteQuery(JsonField.of(rewriteQuery))

            /**
             * Sets [Builder.rewriteQuery] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rewriteQuery] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rewriteQuery(rewriteQuery: JsonField<Boolean>) = apply {
                this.rewriteQuery = rewriteQuery
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .query()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("query", query),
                    filters,
                    maxNumResults,
                    rankingOptions,
                    rewriteQuery,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            query().validate()
            filters().ifPresent { it.validate() }
            maxNumResults()
            rankingOptions().ifPresent { it.validate() }
            rewriteQuery()
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
            (query.asKnown().getOrNull()?.validity() ?: 0) +
                (filters.asKnown().getOrNull()?.validity() ?: 0) +
                (if (maxNumResults.asKnown().isPresent) 1 else 0) +
                (rankingOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (if (rewriteQuery.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && query == other.query && filters == other.filters && maxNumResults == other.maxNumResults && rankingOptions == other.rankingOptions && rewriteQuery == other.rewriteQuery && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(query, filters, maxNumResults, rankingOptions, rewriteQuery, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{query=$query, filters=$filters, maxNumResults=$maxNumResults, rankingOptions=$rankingOptions, rewriteQuery=$rewriteQuery, additionalProperties=$additionalProperties}"
    }

    /** A query string for a search */
    @JsonDeserialize(using = Query.Deserializer::class)
    @JsonSerialize(using = Query.Serializer::class)
    class Query
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Query = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitStrings(strings: List<String>) {}
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Query && string == other.string && strings == other.strings /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, strings) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Query{string=$string}"
                strings != null -> "Query{strings=$strings}"
                _json != null -> "Query{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Query")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Query(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Query(strings = strings)
        }

        /** An interface that defines how to map each variant of [Query] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [Query] to a value of type [T].
             *
             * An instance of [Query] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Query: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Query>(Query::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Query {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Query(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                Query(strings = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Query(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Query>(Query::class) {

            override fun serialize(
                value: Query,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Query")
                }
            }
        }
    }

    /** A filter to apply based on file attributes. */
    @JsonDeserialize(using = Filters.Deserializer::class)
    @JsonSerialize(using = Filters.Serializer::class)
    class Filters
    private constructor(
        private val comparisonFilter: ComparisonFilter? = null,
        private val compoundFilter: CompoundFilter? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        fun comparisonFilter(): Optional<ComparisonFilter> = Optional.ofNullable(comparisonFilter)

        /** Combine multiple filters using `and` or `or`. */
        fun compoundFilter(): Optional<CompoundFilter> = Optional.ofNullable(compoundFilter)

        fun isComparisonFilter(): Boolean = comparisonFilter != null

        fun isCompoundFilter(): Boolean = compoundFilter != null

        /**
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        fun asComparisonFilter(): ComparisonFilter = comparisonFilter.getOrThrow("comparisonFilter")

        /** Combine multiple filters using `and` or `or`. */
        fun asCompoundFilter(): CompoundFilter = compoundFilter.getOrThrow("compoundFilter")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                comparisonFilter != null -> visitor.visitComparisonFilter(comparisonFilter)
                compoundFilter != null -> visitor.visitCompoundFilter(compoundFilter)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Filters = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitComparisonFilter(comparisonFilter: ComparisonFilter) {
                        comparisonFilter.validate()
                    }

                    override fun visitCompoundFilter(compoundFilter: CompoundFilter) {
                        compoundFilter.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitComparisonFilter(comparisonFilter: ComparisonFilter) =
                        comparisonFilter.validity()

                    override fun visitCompoundFilter(compoundFilter: CompoundFilter) =
                        compoundFilter.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Filters && comparisonFilter == other.comparisonFilter && compoundFilter == other.compoundFilter /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(comparisonFilter, compoundFilter) /* spotless:on */

        override fun toString(): String =
            when {
                comparisonFilter != null -> "Filters{comparisonFilter=$comparisonFilter}"
                compoundFilter != null -> "Filters{compoundFilter=$compoundFilter}"
                _json != null -> "Filters{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Filters")
            }

        companion object {

            /**
             * A filter used to compare a specified attribute key to a given value using a defined
             * comparison operation.
             */
            @JvmStatic
            fun ofComparisonFilter(comparisonFilter: ComparisonFilter) =
                Filters(comparisonFilter = comparisonFilter)

            /** Combine multiple filters using `and` or `or`. */
            @JvmStatic
            fun ofCompoundFilter(compoundFilter: CompoundFilter) =
                Filters(compoundFilter = compoundFilter)
        }

        /**
         * An interface that defines how to map each variant of [Filters] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * A filter used to compare a specified attribute key to a given value using a defined
             * comparison operation.
             */
            fun visitComparisonFilter(comparisonFilter: ComparisonFilter): T

            /** Combine multiple filters using `and` or `or`. */
            fun visitCompoundFilter(compoundFilter: CompoundFilter): T

            /**
             * Maps an unknown variant of [Filters] to a value of type [T].
             *
             * An instance of [Filters] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Filters: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Filters>(Filters::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Filters {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<ComparisonFilter>())?.let {
                                Filters(comparisonFilter = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CompoundFilter>())?.let {
                                Filters(compoundFilter = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Filters(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Filters>(Filters::class) {

            override fun serialize(
                value: Filters,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.comparisonFilter != null -> generator.writeObject(value.comparisonFilter)
                    value.compoundFilter != null -> generator.writeObject(value.compoundFilter)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Filters")
                }
            }
        }
    }

    /** Ranking options for search. */
    class RankingOptions
    private constructor(
        private val ranker: JsonField<Ranker>,
        private val scoreThreshold: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ranker") @ExcludeMissing ranker: JsonField<Ranker> = JsonMissing.of(),
            @JsonProperty("score_threshold")
            @ExcludeMissing
            scoreThreshold: JsonField<Double> = JsonMissing.of(),
        ) : this(ranker, scoreThreshold, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun ranker(): Optional<Ranker> = Optional.ofNullable(ranker.getNullable("ranker"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scoreThreshold(): Optional<Double> =
            Optional.ofNullable(scoreThreshold.getNullable("score_threshold"))

        /**
         * Returns the raw JSON value of [ranker].
         *
         * Unlike [ranker], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonField<Ranker> = ranker

        /**
         * Returns the raw JSON value of [scoreThreshold].
         *
         * Unlike [scoreThreshold], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("score_threshold")
        @ExcludeMissing
        fun _scoreThreshold(): JsonField<Double> = scoreThreshold

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

            /** Returns a mutable builder for constructing an instance of [RankingOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RankingOptions]. */
        class Builder internal constructor() {

            private var ranker: JsonField<Ranker> = JsonMissing.of()
            private var scoreThreshold: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rankingOptions: RankingOptions) = apply {
                ranker = rankingOptions.ranker
                scoreThreshold = rankingOptions.scoreThreshold
                additionalProperties = rankingOptions.additionalProperties.toMutableMap()
            }

            fun ranker(ranker: Ranker) = ranker(JsonField.of(ranker))

            /**
             * Sets [Builder.ranker] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ranker] with a well-typed [Ranker] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ranker(ranker: JsonField<Ranker>) = apply { this.ranker = ranker }

            fun scoreThreshold(scoreThreshold: Double) =
                scoreThreshold(JsonField.of(scoreThreshold))

            /**
             * Sets [Builder.scoreThreshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scoreThreshold] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scoreThreshold(scoreThreshold: JsonField<Double>) = apply {
                this.scoreThreshold = scoreThreshold
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
             * Returns an immutable instance of [RankingOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RankingOptions =
                RankingOptions(ranker, scoreThreshold, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RankingOptions = apply {
            if (validated) {
                return@apply
            }

            ranker().ifPresent { it.validate() }
            scoreThreshold()
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
            (ranker.asKnown().getOrNull()?.validity() ?: 0) +
                (if (scoreThreshold.asKnown().isPresent) 1 else 0)

        class Ranker @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val AUTO = of("auto")

                @JvmField val DEFAULT_2024_11_15 = of("default-2024-11-15")

                @JvmStatic fun of(value: String) = Ranker(JsonField.of(value))
            }

            /** An enum containing [Ranker]'s known values. */
            enum class Known {
                AUTO,
                DEFAULT_2024_11_15,
            }

            /**
             * An enum containing [Ranker]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Ranker] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                DEFAULT_2024_11_15,
                /**
                 * An enum member indicating that [Ranker] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    AUTO -> Value.AUTO
                    DEFAULT_2024_11_15 -> Value.DEFAULT_2024_11_15
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    AUTO -> Known.AUTO
                    DEFAULT_2024_11_15 -> Known.DEFAULT_2024_11_15
                    else -> throw OpenAIInvalidDataException("Unknown Ranker: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Ranker = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Ranker && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is RankingOptions && ranker == other.ranker && scoreThreshold == other.scoreThreshold && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(ranker, scoreThreshold, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RankingOptions{ranker=$ranker, scoreThreshold=$scoreThreshold, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchParams && vectorStoreId == other.vectorStoreId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoreId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "VectorStoreSearchParams{vectorStoreId=$vectorStoreId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
