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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ComparisonFilter
import com.openai.models.CompoundFilter
import java.util.Objects
import java.util.Optional

/**
 * A tool that searches for relevant content from uploaded files. Learn more about the
 * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
 */
@NoAutoDetect
class FileSearchTool
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("vector_store_ids")
    @ExcludeMissing
    private val vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
    @JsonProperty("filters")
    @ExcludeMissing
    private val filters: JsonField<Filters> = JsonMissing.of(),
    @JsonProperty("max_num_results")
    @ExcludeMissing
    private val maxNumResults: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("ranking_options")
    @ExcludeMissing
    private val rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of the file search tool. Always `file_search`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The IDs of the vector stores to search. */
    fun vectorStoreIds(): List<String> = vectorStoreIds.getRequired("vector_store_ids")

    /** A filter to apply based on file attributes. */
    fun filters(): Optional<Filters> = Optional.ofNullable(filters.getNullable("filters"))

    /**
     * The maximum number of results to return. This number should be between 1 and 50 inclusive.
     */
    fun maxNumResults(): Optional<Long> =
        Optional.ofNullable(maxNumResults.getNullable("max_num_results"))

    /** Ranking options for search. */
    fun rankingOptions(): Optional<RankingOptions> =
        Optional.ofNullable(rankingOptions.getNullable("ranking_options"))

    /** The IDs of the vector stores to search. */
    @JsonProperty("vector_store_ids")
    @ExcludeMissing
    fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

    /** A filter to apply based on file attributes. */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filters> = filters

    /**
     * The maximum number of results to return. This number should be between 1 and 50 inclusive.
     */
    @JsonProperty("max_num_results")
    @ExcludeMissing
    fun _maxNumResults(): JsonField<Long> = maxNumResults

    /** Ranking options for search. */
    @JsonProperty("ranking_options")
    @ExcludeMissing
    fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /** The type of the file search tool. Always `file_search`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The IDs of the vector stores to search. */
        fun vectorStoreIds(vectorStoreIds: List<String>) =
            vectorStoreIds(JsonField.of(vectorStoreIds))

        /** The IDs of the vector stores to search. */
        fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
            this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
        }

        /** The IDs of the vector stores to search. */
        fun addVectorStoreId(vectorStoreId: String) = apply {
            vectorStoreIds =
                (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("vectorStoreIds", it).add(vectorStoreId)
                }
        }

        /** A filter to apply based on file attributes. */
        fun filters(filters: Filters) = filters(JsonField.of(filters))

        /** A filter to apply based on file attributes. */
        fun filters(filters: JsonField<Filters>) = apply { this.filters = filters }

        /**
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        fun filters(comparisonFilter: ComparisonFilter) =
            filters(Filters.ofComparisonFilter(comparisonFilter))

        /** Combine multiple filters using `and` or `or`. */
        fun filters(compoundFilter: CompoundFilter) =
            filters(Filters.ofCompoundFilter(compoundFilter))

        /**
         * The maximum number of results to return. This number should be between 1 and 50
         * inclusive.
         */
        fun maxNumResults(maxNumResults: Long) = maxNumResults(JsonField.of(maxNumResults))

        /**
         * The maximum number of results to return. This number should be between 1 and 50
         * inclusive.
         */
        fun maxNumResults(maxNumResults: JsonField<Long>) = apply {
            this.maxNumResults = maxNumResults
        }

        /** Ranking options for search. */
        fun rankingOptions(rankingOptions: RankingOptions) =
            rankingOptions(JsonField.of(rankingOptions))

        /** Ranking options for search. */
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

        fun build(): FileSearchTool =
            FileSearchTool(
                type,
                checkRequired("vectorStoreIds", vectorStoreIds).map { it.toImmutable() },
                filters,
                maxNumResults,
                rankingOptions,
                additionalProperties.toImmutable(),
            )
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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                comparisonFilter != null -> visitor.visitComparisonFilter(comparisonFilter)
                compoundFilter != null -> visitor.visitCompoundFilter(compoundFilter)
                else -> visitor.unknown(_json)
            }
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

                tryDeserialize(node, jacksonTypeRef<ComparisonFilter>()) { it.validate() }
                    ?.let {
                        return Filters(comparisonFilter = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<CompoundFilter>()) { it.validate() }
                    ?.let {
                        return Filters(compoundFilter = it, _json = json)
                    }

                return Filters(_json = json)
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
    @NoAutoDetect
    class RankingOptions
    @JsonCreator
    private constructor(
        @JsonProperty("ranker")
        @ExcludeMissing
        private val ranker: JsonField<Ranker> = JsonMissing.of(),
        @JsonProperty("score_threshold")
        @ExcludeMissing
        private val scoreThreshold: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ranker to use for the file search. */
        fun ranker(): Optional<Ranker> = Optional.ofNullable(ranker.getNullable("ranker"))

        /**
         * The score threshold for the file search, a number between 0 and 1. Numbers closer to 1
         * will attempt to return only the most relevant results, but may return fewer results.
         */
        fun scoreThreshold(): Optional<Double> =
            Optional.ofNullable(scoreThreshold.getNullable("score_threshold"))

        /** The ranker to use for the file search. */
        @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonField<Ranker> = ranker

        /**
         * The score threshold for the file search, a number between 0 and 1. Numbers closer to 1
         * will attempt to return only the most relevant results, but may return fewer results.
         */
        @JsonProperty("score_threshold")
        @ExcludeMissing
        fun _scoreThreshold(): JsonField<Double> = scoreThreshold

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): RankingOptions = apply {
            if (validated) {
                return@apply
            }

            ranker()
            scoreThreshold()
            validated = true
        }

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

            /** The ranker to use for the file search. */
            fun ranker(ranker: JsonField<Ranker>) = apply { this.ranker = ranker }

            /**
             * The score threshold for the file search, a number between 0 and 1. Numbers closer to
             * 1 will attempt to return only the most relevant results, but may return fewer
             * results.
             */
            fun scoreThreshold(scoreThreshold: Double) =
                scoreThreshold(JsonField.of(scoreThreshold))

            /**
             * The score threshold for the file search, a number between 0 and 1. Numbers closer to
             * 1 will attempt to return only the most relevant results, but may return fewer
             * results.
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

            fun build(): RankingOptions =
                RankingOptions(ranker, scoreThreshold, additionalProperties.toImmutable())
        }

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
