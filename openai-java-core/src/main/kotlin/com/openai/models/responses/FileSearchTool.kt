// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ComparisonFilter
import com.openai.models.CompoundFilter
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A tool that searches for relevant content from uploaded files. Learn more about the
 * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
 */
class FileSearchTool
private constructor(
    private val type: JsonValue,
    private val vectorStoreIds: JsonField<List<String>>,
    private val filters: JsonField<Filters>,
    private val maxNumResults: JsonField<Long>,
    private val rankingOptions: JsonField<RankingOptions>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("vector_store_ids")
        @ExcludeMissing
        vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filters> = JsonMissing.of(),
        @JsonProperty("max_num_results")
        @ExcludeMissing
        maxNumResults: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ranking_options")
        @ExcludeMissing
        rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
    ) : this(type, vectorStoreIds, filters, maxNumResults, rankingOptions, mutableMapOf())

    /**
     * The type of the file search tool. Always `file_search`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("file_search")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The IDs of the vector stores to search.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vectorStoreIds(): List<String> = vectorStoreIds.getRequired("vector_store_ids")

    /**
     * A filter to apply based on file attributes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filters(): Optional<Filters> = filters.getOptional("filters")

    /**
     * The maximum number of results to return. This number should be between 1 and 50 inclusive.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxNumResults(): Optional<Long> = maxNumResults.getOptional("max_num_results")

    /**
     * Ranking options for search.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rankingOptions(): Optional<RankingOptions> = rankingOptions.getOptional("ranking_options")

    /**
     * Returns the raw JSON value of [vectorStoreIds].
     *
     * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vector_store_ids")
    @ExcludeMissing
    fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

    /**
     * Returns the raw JSON value of [filters].
     *
     * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filters> = filters

    /**
     * Returns the raw JSON value of [maxNumResults].
     *
     * Unlike [maxNumResults], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_num_results")
    @ExcludeMissing
    fun _maxNumResults(): JsonField<Long> = maxNumResults

    /**
     * Returns the raw JSON value of [rankingOptions].
     *
     * Unlike [rankingOptions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ranking_options")
    @ExcludeMissing
    fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

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
         * Returns a mutable builder for constructing an instance of [FileSearchTool].
         *
         * The following fields are required:
         * ```java
         * .vectorStoreIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileSearchTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("file_search")
        private var vectorStoreIds: JsonField<MutableList<String>>? = null
        private var filters: JsonField<Filters> = JsonMissing.of()
        private var maxNumResults: JsonField<Long> = JsonMissing.of()
        private var rankingOptions: JsonField<RankingOptions> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchTool: FileSearchTool) = apply {
            type = fileSearchTool.type
            vectorStoreIds = fileSearchTool.vectorStoreIds.map { it.toMutableList() }
            filters = fileSearchTool.filters
            maxNumResults = fileSearchTool.maxNumResults
            rankingOptions = fileSearchTool.rankingOptions
            additionalProperties = fileSearchTool.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("file_search")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The IDs of the vector stores to search. */
        fun vectorStoreIds(vectorStoreIds: List<String>) =
            vectorStoreIds(JsonField.of(vectorStoreIds))

        /**
         * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vectorStoreIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
            this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [vectorStoreIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVectorStoreId(vectorStoreId: String) = apply {
            vectorStoreIds =
                (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("vectorStoreIds", it).add(vectorStoreId)
                }
        }

        /** A filter to apply based on file attributes. */
        fun filters(filters: Filters) = filters(JsonField.of(filters))

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed [Filters] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.maxNumResults] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.rankingOptions] with a well-typed [RankingOptions] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rankingOptions(rankingOptions: JsonField<RankingOptions>) = apply {
            this.rankingOptions = rankingOptions
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
         * Returns an immutable instance of [FileSearchTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .vectorStoreIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileSearchTool =
            FileSearchTool(
                type,
                checkRequired("vectorStoreIds", vectorStoreIds).map { it.toImmutable() },
                filters,
                maxNumResults,
                rankingOptions,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileSearchTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("file_search")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        vectorStoreIds()
        filters().ifPresent { it.validate() }
        maxNumResults()
        rankingOptions().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        type.let { if (it == JsonValue.from("file_search")) 1 else 0 } +
            (vectorStoreIds.asKnown().getOrNull()?.size ?: 0) +
            (filters.asKnown().getOrNull()?.validity() ?: 0) +
            (if (maxNumResults.asKnown().isPresent) 1 else 0) +
            (rankingOptions.asKnown().getOrNull()?.validity() ?: 0)

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
         * The ranker to use for the file search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun ranker(): Optional<Ranker> = ranker.getOptional("ranker")

        /**
         * The score threshold for the file search, a number between 0 and 1. Numbers closer to 1
         * will attempt to return only the most relevant results, but may return fewer results.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scoreThreshold(): Optional<Double> = scoreThreshold.getOptional("score_threshold")

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

            /** The ranker to use for the file search. */
            fun ranker(ranker: Ranker) = ranker(JsonField.of(ranker))

            /**
             * Sets [Builder.ranker] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ranker] with a well-typed [Ranker] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ranker(ranker: JsonField<Ranker>) = apply { this.ranker = ranker }

            /**
             * The score threshold for the file search, a number between 0 and 1. Numbers closer to
             * 1 will attempt to return only the most relevant results, but may return fewer
             * results.
             */
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

        /** The ranker to use for the file search. */
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

        return /* spotless:off */ other is FileSearchTool && type == other.type && vectorStoreIds == other.vectorStoreIds && filters == other.filters && maxNumResults == other.maxNumResults && rankingOptions == other.rankingOptions && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, vectorStoreIds, filters, maxNumResults, rankingOptions, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchTool{type=$type, vectorStoreIds=$vectorStoreIds, filters=$filters, maxNumResults=$maxNumResults, rankingOptions=$rankingOptions, additionalProperties=$additionalProperties}"
}
