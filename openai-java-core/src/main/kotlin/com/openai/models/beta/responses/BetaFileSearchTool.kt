// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A tool that searches for relevant content from uploaded files. Learn more about the
 * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
 */
class BetaFileSearchTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
     * A filter to apply.
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
         * Returns a mutable builder for constructing an instance of [BetaFileSearchTool].
         *
         * The following fields are required:
         * ```java
         * .vectorStoreIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaFileSearchTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("file_search")
        private var vectorStoreIds: JsonField<MutableList<String>>? = null
        private var filters: JsonField<Filters> = JsonMissing.of()
        private var maxNumResults: JsonField<Long> = JsonMissing.of()
        private var rankingOptions: JsonField<RankingOptions> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaFileSearchTool: BetaFileSearchTool) = apply {
            type = betaFileSearchTool.type
            vectorStoreIds = betaFileSearchTool.vectorStoreIds.map { it.toMutableList() }
            filters = betaFileSearchTool.filters
            maxNumResults = betaFileSearchTool.maxNumResults
            rankingOptions = betaFileSearchTool.rankingOptions
            additionalProperties = betaFileSearchTool.additionalProperties.toMutableMap()
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

        /** A filter to apply. */
        fun filters(filters: Filters?) = filters(JsonField.ofNullable(filters))

        /** Alias for calling [Builder.filters] with `filters.orElse(null)`. */
        fun filters(filters: Optional<Filters>) = filters(filters.getOrNull())

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed [Filters] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filters(filters: JsonField<Filters>) = apply { this.filters = filters }

        /** Alias for calling [filters] with `Filters.ofComparisonFilter(comparisonFilter)`. */
        fun filters(comparisonFilter: Filters.ComparisonFilter) =
            filters(Filters.ofComparisonFilter(comparisonFilter))

        /** Alias for calling [filters] with `Filters.ofCompoundFilter(compoundFilter)`. */
        fun filters(compoundFilter: Filters.CompoundFilter) =
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
         * Returns an immutable instance of [BetaFileSearchTool].
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
        fun build(): BetaFileSearchTool =
            BetaFileSearchTool(
                type,
                checkRequired("vectorStoreIds", vectorStoreIds).map { it.toImmutable() },
                filters,
                maxNumResults,
                rankingOptions,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaFileSearchTool = apply {
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

    /** A filter to apply. */
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

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = filters.accept(new Filters.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitComparisonFilter(ComparisonFilter comparisonFilter) {
         *         return Optional.of(comparisonFilter.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                comparisonFilter != null -> visitor.visitComparisonFilter(comparisonFilter)
                compoundFilter != null -> visitor.visitCompoundFilter(compoundFilter)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

            return other is Filters &&
                comparisonFilter == other.comparisonFilter &&
                compoundFilter == other.compoundFilter
        }

        override fun hashCode(): Int = Objects.hash(comparisonFilter, compoundFilter)

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

        /**
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        class ComparisonFilter
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val key: JsonField<String>,
            private val type: JsonField<Type>,
            private val value: JsonField<Value>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<Value> = JsonMissing.of(),
            ) : this(key, type, value, mutableMapOf())

            /**
             * The key to compare against the value.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun key(): String = key.getRequired("key")

            /**
             * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`, `in`, `nin`.
             * - `eq`: equals
             * - `ne`: not equal
             * - `gt`: greater than
             * - `gte`: greater than or equal
             * - `lt`: less than
             * - `lte`: less than or equal
             * - `in`: in
             * - `nin`: not in
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * The value to compare against the attribute key; supports string, number, or boolean
             * types.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun value(): Value = value.getRequired("value")

            /**
             * Returns the raw JSON value of [key].
             *
             * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Value> = value

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
                 * Returns a mutable builder for constructing an instance of [ComparisonFilter].
                 *
                 * The following fields are required:
                 * ```java
                 * .key()
                 * .type()
                 * .value()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComparisonFilter]. */
            class Builder internal constructor() {

                private var key: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var value: JsonField<Value>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(comparisonFilter: ComparisonFilter) = apply {
                    key = comparisonFilter.key
                    type = comparisonFilter.type
                    value = comparisonFilter.value
                    additionalProperties = comparisonFilter.additionalProperties.toMutableMap()
                }

                /** The key to compare against the value. */
                fun key(key: String) = key(JsonField.of(key))

                /**
                 * Sets [Builder.key] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.key] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun key(key: JsonField<String>) = apply { this.key = key }

                /**
                 * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`, `in`,
                 * `nin`.
                 * - `eq`: equals
                 * - `ne`: not equal
                 * - `gt`: greater than
                 * - `gte`: greater than or equal
                 * - `lt`: less than
                 * - `lte`: less than or equal
                 * - `in`: in
                 * - `nin`: not in
                 */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /**
                 * The value to compare against the attribute key; supports string, number, or
                 * boolean types.
                 */
                fun value(value: Value) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [Value] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<Value>) = apply { this.value = value }

                /** Alias for calling [value] with `Value.ofString(string)`. */
                fun value(string: String) = value(Value.ofString(string))

                /** Alias for calling [value] with `Value.ofNumber(number)`. */
                fun value(number: Double) = value(Value.ofNumber(number))

                /** Alias for calling [value] with `Value.ofBool(bool)`. */
                fun value(bool: Boolean) = value(Value.ofBool(bool))

                /**
                 * Alias for calling [value] with
                 * `Value.ofComparisonFilterValueItems(comparisonFilterValueItems)`.
                 */
                fun valueOfComparisonFilterValueItems(
                    comparisonFilterValueItems: List<Value.ComparisonFilterValueItem>
                ) = value(Value.ofComparisonFilterValueItems(comparisonFilterValueItems))

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ComparisonFilter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .key()
                 * .type()
                 * .value()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ComparisonFilter =
                    ComparisonFilter(
                        checkRequired("key", key),
                        checkRequired("type", type),
                        checkRequired("value", value),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): ComparisonFilter = apply {
                if (validated) {
                    return@apply
                }

                key()
                type().validate()
                value().validate()
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
                (if (key.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (value.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`, `in`, `nin`.
             * - `eq`: equals
             * - `ne`: not equal
             * - `gt`: greater than
             * - `gte`: greater than or equal
             * - `lt`: less than
             * - `lte`: less than or equal
             * - `in`: in
             * - `nin`: not in
             */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val EQ = of("eq")

                    @JvmField val NE = of("ne")

                    @JvmField val GT = of("gt")

                    @JvmField val GTE = of("gte")

                    @JvmField val LT = of("lt")

                    @JvmField val LTE = of("lte")

                    @JvmField val IN = of("in")

                    @JvmField val NIN = of("nin")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    EQ,
                    NE,
                    GT,
                    GTE,
                    LT,
                    LTE,
                    IN,
                    NIN,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    EQ,
                    NE,
                    GT,
                    GTE,
                    LT,
                    LTE,
                    IN,
                    NIN,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        EQ -> Value.EQ
                        NE -> Value.NE
                        GT -> Value.GT
                        GTE -> Value.GTE
                        LT -> Value.LT
                        LTE -> Value.LTE
                        IN -> Value.IN
                        NIN -> Value.NIN
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        EQ -> Known.EQ
                        NE -> Known.NE
                        GT -> Known.GT
                        GTE -> Known.GTE
                        LT -> Known.LT
                        LTE -> Known.LTE
                        IN -> Known.IN
                        NIN -> Known.NIN
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Type = apply {
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

                    return other is Type && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * The value to compare against the attribute key; supports string, number, or boolean
             * types.
             */
            @JsonDeserialize(using = Value.Deserializer::class)
            @JsonSerialize(using = Value.Serializer::class)
            class Value
            private constructor(
                private val string: String? = null,
                private val number: Double? = null,
                private val bool: Boolean? = null,
                private val comparisonFilterValueItems: List<ComparisonFilterValueItem>? = null,
                private val _json: JsonValue? = null,
            ) {

                fun string(): Optional<String> = Optional.ofNullable(string)

                fun number(): Optional<Double> = Optional.ofNullable(number)

                fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                fun comparisonFilterValueItems(): Optional<List<ComparisonFilterValueItem>> =
                    Optional.ofNullable(comparisonFilterValueItems)

                fun isString(): Boolean = string != null

                fun isNumber(): Boolean = number != null

                fun isBool(): Boolean = bool != null

                fun isComparisonFilterValueItems(): Boolean = comparisonFilterValueItems != null

                fun asString(): String = string.getOrThrow("string")

                fun asNumber(): Double = number.getOrThrow("number")

                fun asBool(): Boolean = bool.getOrThrow("bool")

                fun asComparisonFilterValueItems(): List<ComparisonFilterValueItem> =
                    comparisonFilterValueItems.getOrThrow("comparisonFilterValueItems")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = value.accept(new Value.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitString(String string) {
                 *         return Optional.of(string.toString());
                 *     }
                 *
                 *     // ...
                 *
                 *     @Override
                 *     public Optional<String> unknown(JsonValue json) {
                 *         // Or inspect the `json`.
                 *         return Optional.empty();
                 *     }
                 * });
                 * ```
                 *
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        string != null -> visitor.visitString(string)
                        number != null -> visitor.visitNumber(number)
                        bool != null -> visitor.visitBool(bool)
                        comparisonFilterValueItems != null ->
                            visitor.visitComparisonFilterValueItems(comparisonFilterValueItems)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Value = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitString(string: String) {}

                            override fun visitNumber(number: Double) {}

                            override fun visitBool(bool: Boolean) {}

                            override fun visitComparisonFilterValueItems(
                                comparisonFilterValueItems: List<ComparisonFilterValueItem>
                            ) {
                                comparisonFilterValueItems.forEach { it.validate() }
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
                            override fun visitString(string: String) = 1

                            override fun visitNumber(number: Double) = 1

                            override fun visitBool(bool: Boolean) = 1

                            override fun visitComparisonFilterValueItems(
                                comparisonFilterValueItems: List<ComparisonFilterValueItem>
                            ) = comparisonFilterValueItems.sumOf { it.validity().toInt() }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Value &&
                        string == other.string &&
                        number == other.number &&
                        bool == other.bool &&
                        comparisonFilterValueItems == other.comparisonFilterValueItems
                }

                override fun hashCode(): Int =
                    Objects.hash(string, number, bool, comparisonFilterValueItems)

                override fun toString(): String =
                    when {
                        string != null -> "Value{string=$string}"
                        number != null -> "Value{number=$number}"
                        bool != null -> "Value{bool=$bool}"
                        comparisonFilterValueItems != null ->
                            "Value{comparisonFilterValueItems=$comparisonFilterValueItems}"
                        _json != null -> "Value{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Value")
                    }

                companion object {

                    @JvmStatic fun ofString(string: String) = Value(string = string)

                    @JvmStatic fun ofNumber(number: Double) = Value(number = number)

                    @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                    @JvmStatic
                    fun ofComparisonFilterValueItems(
                        comparisonFilterValueItems: List<ComparisonFilterValueItem>
                    ) = Value(comparisonFilterValueItems = comparisonFilterValueItems.toImmutable())
                }

                /**
                 * An interface that defines how to map each variant of [Value] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitString(string: String): T

                    fun visitNumber(number: Double): T

                    fun visitBool(bool: Boolean): T

                    fun visitComparisonFilterValueItems(
                        comparisonFilterValueItems: List<ComparisonFilterValueItem>
                    ): T

                    /**
                     * Maps an unknown variant of [Value] to a value of type [T].
                     *
                     * An instance of [Value] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Value: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Value>(Value::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Value {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        Value(string = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                        Value(number = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                        Value(bool = it, _json = json)
                                    },
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<List<ComparisonFilterValueItem>>(),
                                        )
                                        ?.let {
                                            Value(comparisonFilterValueItems = it, _json = json)
                                        },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // object).
                            0 -> Value(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Value>(Value::class) {

                    override fun serialize(
                        value: Value,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.string != null -> generator.writeObject(value.string)
                            value.number != null -> generator.writeObject(value.number)
                            value.bool != null -> generator.writeObject(value.bool)
                            value.comparisonFilterValueItems != null ->
                                generator.writeObject(value.comparisonFilterValueItems)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Value")
                        }
                    }
                }

                @JsonDeserialize(using = ComparisonFilterValueItem.Deserializer::class)
                @JsonSerialize(using = ComparisonFilterValueItem.Serializer::class)
                class ComparisonFilterValueItem
                private constructor(
                    private val string: String? = null,
                    private val number: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun string(): Optional<String> = Optional.ofNullable(string)

                    fun number(): Optional<Double> = Optional.ofNullable(number)

                    fun isString(): Boolean = string != null

                    fun isNumber(): Boolean = number != null

                    fun asString(): String = string.getOrThrow("string")

                    fun asNumber(): Double = number.getOrThrow("number")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    /**
                     * Maps this instance's current variant to a value of type [T] using the given
                     * [visitor].
                     *
                     * Note that this method is _not_ forwards compatible with new variants from the
                     * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not
                     * known to this version of the SDK gracefully, consider overriding
                     * [Visitor.unknown]:
                     * ```java
                     * import com.openai.core.JsonValue;
                     * import java.util.Optional;
                     *
                     * Optional<String> result = comparisonFilterValueItem.accept(new ComparisonFilterValueItem.Visitor<Optional<String>>() {
                     *     @Override
                     *     public Optional<String> visitString(String string) {
                     *         return Optional.of(string.toString());
                     *     }
                     *
                     *     // ...
                     *
                     *     @Override
                     *     public Optional<String> unknown(JsonValue json) {
                     *         // Or inspect the `json`.
                     *         return Optional.empty();
                     *     }
                     * });
                     * ```
                     *
                     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                     *   [visitor] and the current variant is unknown.
                     */
                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            string != null -> visitor.visitString(string)
                            number != null -> visitor.visitNumber(number)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): ComparisonFilterValueItem = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitString(string: String) {}

                                override fun visitNumber(number: Double) {}
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

                                override fun visitNumber(number: Double) = 1

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ComparisonFilterValueItem &&
                            string == other.string &&
                            number == other.number
                    }

                    override fun hashCode(): Int = Objects.hash(string, number)

                    override fun toString(): String =
                        when {
                            string != null -> "ComparisonFilterValueItem{string=$string}"
                            number != null -> "ComparisonFilterValueItem{number=$number}"
                            _json != null -> "ComparisonFilterValueItem{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid ComparisonFilterValueItem")
                        }

                    companion object {

                        @JvmStatic
                        fun ofString(string: String) = ComparisonFilterValueItem(string = string)

                        @JvmStatic
                        fun ofNumber(number: Double) = ComparisonFilterValueItem(number = number)
                    }

                    /**
                     * An interface that defines how to map each variant of
                     * [ComparisonFilterValueItem] to a value of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitString(string: String): T

                        fun visitNumber(number: Double): T

                        /**
                         * Maps an unknown variant of [ComparisonFilterValueItem] to a value of type
                         * [T].
                         *
                         * An instance of [ComparisonFilterValueItem] can contain an unknown variant
                         * if it was deserialized from data that doesn't match any known variant.
                         * For example, if the SDK is on an older version than the API, then the API
                         * may respond with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown ComparisonFilterValueItem: $json"
                            )
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<ComparisonFilterValueItem>(
                            ComparisonFilterValueItem::class
                        ) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): ComparisonFilterValueItem {
                            val json = JsonValue.fromJsonNode(node)

                            val bestMatches =
                                sequenceOf(
                                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                            ComparisonFilterValueItem(string = it, _json = json)
                                        },
                                        tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                            ComparisonFilterValueItem(number = it, _json = json)
                                        },
                                    )
                                    .filterNotNull()
                                    .allMaxBy { it.validity() }
                                    .toList()
                            return when (bestMatches.size) {
                                // This can happen if what we're deserializing is completely
                                // incompatible with all the possible variants (e.g. deserializing
                                // from boolean).
                                0 -> ComparisonFilterValueItem(_json = json)
                                1 -> bestMatches.single()
                                // If there's more than one match with the highest validity, then
                                // use the first completely valid match, or simply the first match
                                // if none are completely valid.
                                else ->
                                    bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                            }
                        }
                    }

                    internal class Serializer :
                        BaseSerializer<ComparisonFilterValueItem>(
                            ComparisonFilterValueItem::class
                        ) {

                        override fun serialize(
                            value: ComparisonFilterValueItem,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.string != null -> generator.writeObject(value.string)
                                value.number != null -> generator.writeObject(value.number)
                                value._json != null -> generator.writeObject(value._json)
                                else ->
                                    throw IllegalStateException("Invalid ComparisonFilterValueItem")
                            }
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ComparisonFilter &&
                    key == other.key &&
                    type == other.type &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(key, type, value, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComparisonFilter{key=$key, type=$type, value=$value, additionalProperties=$additionalProperties}"
        }

        /** Combine multiple filters using `and` or `or`. */
        class CompoundFilter
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val filters: JsonField<List<Filter>>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("filters")
                @ExcludeMissing
                filters: JsonField<List<Filter>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(filters, type, mutableMapOf())

            /**
             * Array of filters to combine. Items can be `ComparisonFilter` or `CompoundFilter`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun filters(): List<Filter> = filters.getRequired("filters")

            /**
             * Type of operation: `and` or `or`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [filters].
             *
             * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("filters")
            @ExcludeMissing
            fun _filters(): JsonField<List<Filter>> = filters

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * Returns a mutable builder for constructing an instance of [CompoundFilter].
                 *
                 * The following fields are required:
                 * ```java
                 * .filters()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CompoundFilter]. */
            class Builder internal constructor() {

                private var filters: JsonField<MutableList<Filter>>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(compoundFilter: CompoundFilter) = apply {
                    filters = compoundFilter.filters.map { it.toMutableList() }
                    type = compoundFilter.type
                    additionalProperties = compoundFilter.additionalProperties.toMutableMap()
                }

                /**
                 * Array of filters to combine. Items can be `ComparisonFilter` or `CompoundFilter`.
                 */
                fun filters(filters: List<Filter>) = filters(JsonField.of(filters))

                /**
                 * Sets [Builder.filters] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.filters] with a well-typed `List<Filter>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun filters(filters: JsonField<List<Filter>>) = apply {
                    this.filters = filters.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Filter] to [filters].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addFilter(filter: Filter) = apply {
                    filters =
                        (filters ?: JsonField.of(mutableListOf())).also {
                            checkKnown("filters", it).add(filter)
                        }
                }

                /** Alias for calling [addFilter] with `Filter.ofComparison(comparison)`. */
                fun addFilter(comparison: Filter.ComparisonFilter) =
                    addFilter(Filter.ofComparison(comparison))

                /** Alias for calling [addFilter] with `Filter.ofJsonValue(jsonValue)`. */
                fun addFilter(jsonValue: JsonValue) = addFilter(Filter.ofJsonValue(jsonValue))

                /** Type of operation: `and` or `or`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [CompoundFilter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .filters()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CompoundFilter =
                    CompoundFilter(
                        checkRequired("filters", filters).map { it.toImmutable() },
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): CompoundFilter = apply {
                if (validated) {
                    return@apply
                }

                filters().forEach { it.validate() }
                type().validate()
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
                (filters.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * A filter used to compare a specified attribute key to a given value using a defined
             * comparison operation.
             */
            @JsonDeserialize(using = Filter.Deserializer::class)
            @JsonSerialize(using = Filter.Serializer::class)
            class Filter
            private constructor(
                private val comparison: ComparisonFilter? = null,
                private val jsonValue: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                /**
                 * A filter used to compare a specified attribute key to a given value using a
                 * defined comparison operation.
                 */
                fun comparison(): Optional<ComparisonFilter> = Optional.ofNullable(comparison)

                fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

                fun isComparison(): Boolean = comparison != null

                fun isJsonValue(): Boolean = jsonValue != null

                /**
                 * A filter used to compare a specified attribute key to a given value using a
                 * defined comparison operation.
                 */
                fun asComparison(): ComparisonFilter = comparison.getOrThrow("comparison")

                fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = filter.accept(new Filter.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitComparison(ComparisonFilter comparison) {
                 *         return Optional.of(comparison.toString());
                 *     }
                 *
                 *     // ...
                 *
                 *     @Override
                 *     public Optional<String> unknown(JsonValue json) {
                 *         // Or inspect the `json`.
                 *         return Optional.empty();
                 *     }
                 * });
                 * ```
                 *
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        comparison != null -> visitor.visitComparison(comparison)
                        jsonValue != null -> visitor.visitJsonValue(jsonValue)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Filter = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitComparison(comparison: ComparisonFilter) {
                                comparison.validate()
                            }

                            override fun visitJsonValue(jsonValue: JsonValue) {}
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
                            override fun visitComparison(comparison: ComparisonFilter) =
                                comparison.validity()

                            override fun visitJsonValue(jsonValue: JsonValue) = 1

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Filter &&
                        comparison == other.comparison &&
                        jsonValue == other.jsonValue
                }

                override fun hashCode(): Int = Objects.hash(comparison, jsonValue)

                override fun toString(): String =
                    when {
                        comparison != null -> "Filter{comparison=$comparison}"
                        jsonValue != null -> "Filter{jsonValue=$jsonValue}"
                        _json != null -> "Filter{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Filter")
                    }

                companion object {

                    /**
                     * A filter used to compare a specified attribute key to a given value using a
                     * defined comparison operation.
                     */
                    @JvmStatic
                    fun ofComparison(comparison: ComparisonFilter) = Filter(comparison = comparison)

                    @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Filter(jsonValue = jsonValue)
                }

                /**
                 * An interface that defines how to map each variant of [Filter] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /**
                     * A filter used to compare a specified attribute key to a given value using a
                     * defined comparison operation.
                     */
                    fun visitComparison(comparison: ComparisonFilter): T

                    fun visitJsonValue(jsonValue: JsonValue): T

                    /**
                     * Maps an unknown variant of [Filter] to a value of type [T].
                     *
                     * An instance of [Filter] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Filter: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Filter>(Filter::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Filter {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<ComparisonFilter>())?.let {
                                        Filter(comparison = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<JsonValue>())?.let {
                                        Filter(jsonValue = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants.
                            0 -> Filter(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Filter>(Filter::class) {

                    override fun serialize(
                        value: Filter,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.comparison != null -> generator.writeObject(value.comparison)
                            value.jsonValue != null -> generator.writeObject(value.jsonValue)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Filter")
                        }
                    }
                }

                /**
                 * A filter used to compare a specified attribute key to a given value using a
                 * defined comparison operation.
                 */
                class ComparisonFilter
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val key: JsonField<String>,
                    private val type: JsonField<Type>,
                    private val value: JsonField<Value>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("key")
                        @ExcludeMissing
                        key: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<Type> = JsonMissing.of(),
                        @JsonProperty("value")
                        @ExcludeMissing
                        value: JsonField<Value> = JsonMissing.of(),
                    ) : this(key, type, value, mutableMapOf())

                    /**
                     * The key to compare against the value.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun key(): String = key.getRequired("key")

                    /**
                     * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`,
                     * `in`, `nin`.
                     * - `eq`: equals
                     * - `ne`: not equal
                     * - `gt`: greater than
                     * - `gte`: greater than or equal
                     * - `lt`: less than
                     * - `lte`: less than or equal
                     * - `in`: in
                     * - `nin`: not in
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

                    /**
                     * The value to compare against the attribute key; supports string, number, or
                     * boolean types.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun value(): Value = value.getRequired("value")

                    /**
                     * Returns the raw JSON value of [key].
                     *
                     * Unlike [key], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                    /**
                     * Returns the raw JSON value of [value].
                     *
                     * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Value> = value

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
                         * Returns a mutable builder for constructing an instance of
                         * [ComparisonFilter].
                         *
                         * The following fields are required:
                         * ```java
                         * .key()
                         * .type()
                         * .value()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ComparisonFilter]. */
                    class Builder internal constructor() {

                        private var key: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var value: JsonField<Value>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(comparisonFilter: ComparisonFilter) = apply {
                            key = comparisonFilter.key
                            type = comparisonFilter.type
                            value = comparisonFilter.value
                            additionalProperties =
                                comparisonFilter.additionalProperties.toMutableMap()
                        }

                        /** The key to compare against the value. */
                        fun key(key: String) = key(JsonField.of(key))

                        /**
                         * Sets [Builder.key] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.key] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun key(key: JsonField<String>) = apply { this.key = key }

                        /**
                         * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`,
                         * `in`, `nin`.
                         * - `eq`: equals
                         * - `ne`: not equal
                         * - `gt`: greater than
                         * - `gte`: greater than or equal
                         * - `lt`: less than
                         * - `lte`: less than or equal
                         * - `in`: in
                         * - `nin`: not in
                         */
                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        /**
                         * The value to compare against the attribute key; supports string, number,
                         * or boolean types.
                         */
                        fun value(value: Value) = value(JsonField.of(value))

                        /**
                         * Sets [Builder.value] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.value] with a well-typed [Value] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun value(value: JsonField<Value>) = apply { this.value = value }

                        /** Alias for calling [value] with `Value.ofString(string)`. */
                        fun value(string: String) = value(Value.ofString(string))

                        /** Alias for calling [value] with `Value.ofNumber(number)`. */
                        fun value(number: Double) = value(Value.ofNumber(number))

                        /** Alias for calling [value] with `Value.ofBool(bool)`. */
                        fun value(bool: Boolean) = value(Value.ofBool(bool))

                        /**
                         * Alias for calling [value] with
                         * `Value.ofComparisonFilterValueItems(comparisonFilterValueItems)`.
                         */
                        fun valueOfComparisonFilterValueItems(
                            comparisonFilterValueItems: List<Value.ComparisonFilterValueItem>
                        ) = value(Value.ofComparisonFilterValueItems(comparisonFilterValueItems))

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ComparisonFilter].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .key()
                         * .type()
                         * .value()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ComparisonFilter =
                            ComparisonFilter(
                                checkRequired("key", key),
                                checkRequired("type", type),
                                checkRequired("value", value),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): ComparisonFilter = apply {
                        if (validated) {
                            return@apply
                        }

                        key()
                        type().validate()
                        value().validate()
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
                        (if (key.asKnown().isPresent) 1 else 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0) +
                            (value.asKnown().getOrNull()?.validity() ?: 0)

                    /**
                     * Specifies the comparison operator: `eq`, `ne`, `gt`, `gte`, `lt`, `lte`,
                     * `in`, `nin`.
                     * - `eq`: equals
                     * - `ne`: not equal
                     * - `gt`: greater than
                     * - `gte`: greater than or equal
                     * - `lt`: less than
                     * - `lte`: less than or equal
                     * - `in`: in
                     * - `nin`: not in
                     */
                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val EQ = of("eq")

                            @JvmField val NE = of("ne")

                            @JvmField val GT = of("gt")

                            @JvmField val GTE = of("gte")

                            @JvmField val LT = of("lt")

                            @JvmField val LTE = of("lte")

                            @JvmField val IN = of("in")

                            @JvmField val NIN = of("nin")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        /** An enum containing [Type]'s known values. */
                        enum class Known {
                            EQ,
                            NE,
                            GT,
                            GTE,
                            LT,
                            LTE,
                            IN,
                            NIN,
                        }

                        /**
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            EQ,
                            NE,
                            GT,
                            GTE,
                            LT,
                            LTE,
                            IN,
                            NIN,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                EQ -> Value.EQ
                                NE -> Value.NE
                                GT -> Value.GT
                                GTE -> Value.GTE
                                LT -> Value.LT
                                LTE -> Value.LTE
                                IN -> Value.IN
                                NIN -> Value.NIN
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                EQ -> Known.EQ
                                NE -> Known.NE
                                GT -> Known.GT
                                GTE -> Known.GTE
                                LT -> Known.LT
                                LTE -> Known.LTE
                                IN -> Known.IN
                                NIN -> Known.NIN
                                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Type = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Type && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    /**
                     * The value to compare against the attribute key; supports string, number, or
                     * boolean types.
                     */
                    @JsonDeserialize(using = Value.Deserializer::class)
                    @JsonSerialize(using = Value.Serializer::class)
                    class Value
                    private constructor(
                        private val string: String? = null,
                        private val number: Double? = null,
                        private val bool: Boolean? = null,
                        private val comparisonFilterValueItems: List<ComparisonFilterValueItem>? =
                            null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun string(): Optional<String> = Optional.ofNullable(string)

                        fun number(): Optional<Double> = Optional.ofNullable(number)

                        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                        fun comparisonFilterValueItems():
                            Optional<List<ComparisonFilterValueItem>> =
                            Optional.ofNullable(comparisonFilterValueItems)

                        fun isString(): Boolean = string != null

                        fun isNumber(): Boolean = number != null

                        fun isBool(): Boolean = bool != null

                        fun isComparisonFilterValueItems(): Boolean =
                            comparisonFilterValueItems != null

                        fun asString(): String = string.getOrThrow("string")

                        fun asNumber(): Double = number.getOrThrow("number")

                        fun asBool(): Boolean = bool.getOrThrow("bool")

                        fun asComparisonFilterValueItems(): List<ComparisonFilterValueItem> =
                            comparisonFilterValueItems.getOrThrow("comparisonFilterValueItems")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        /**
                         * Maps this instance's current variant to a value of type [T] using the
                         * given [visitor].
                         *
                         * Note that this method is _not_ forwards compatible with new variants from
                         * the API, unless [visitor] overrides [Visitor.unknown]. To handle variants
                         * not known to this version of the SDK gracefully, consider overriding
                         * [Visitor.unknown]:
                         * ```java
                         * import com.openai.core.JsonValue;
                         * import java.util.Optional;
                         *
                         * Optional<String> result = value.accept(new Value.Visitor<Optional<String>>() {
                         *     @Override
                         *     public Optional<String> visitString(String string) {
                         *         return Optional.of(string.toString());
                         *     }
                         *
                         *     // ...
                         *
                         *     @Override
                         *     public Optional<String> unknown(JsonValue json) {
                         *         // Or inspect the `json`.
                         *         return Optional.empty();
                         *     }
                         * });
                         * ```
                         *
                         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden
                         *   in [visitor] and the current variant is unknown.
                         */
                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                string != null -> visitor.visitString(string)
                                number != null -> visitor.visitNumber(number)
                                bool != null -> visitor.visitBool(bool)
                                comparisonFilterValueItems != null ->
                                    visitor.visitComparisonFilterValueItems(
                                        comparisonFilterValueItems
                                    )
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Value = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitString(string: String) {}

                                    override fun visitNumber(number: Double) {}

                                    override fun visitBool(bool: Boolean) {}

                                    override fun visitComparisonFilterValueItems(
                                        comparisonFilterValueItems: List<ComparisonFilterValueItem>
                                    ) {
                                        comparisonFilterValueItems.forEach { it.validate() }
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            accept(
                                object : Visitor<Int> {
                                    override fun visitString(string: String) = 1

                                    override fun visitNumber(number: Double) = 1

                                    override fun visitBool(bool: Boolean) = 1

                                    override fun visitComparisonFilterValueItems(
                                        comparisonFilterValueItems: List<ComparisonFilterValueItem>
                                    ) = comparisonFilterValueItems.sumOf { it.validity().toInt() }

                                    override fun unknown(json: JsonValue?) = 0
                                }
                            )

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Value &&
                                string == other.string &&
                                number == other.number &&
                                bool == other.bool &&
                                comparisonFilterValueItems == other.comparisonFilterValueItems
                        }

                        override fun hashCode(): Int =
                            Objects.hash(string, number, bool, comparisonFilterValueItems)

                        override fun toString(): String =
                            when {
                                string != null -> "Value{string=$string}"
                                number != null -> "Value{number=$number}"
                                bool != null -> "Value{bool=$bool}"
                                comparisonFilterValueItems != null ->
                                    "Value{comparisonFilterValueItems=$comparisonFilterValueItems}"
                                _json != null -> "Value{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid Value")
                            }

                        companion object {

                            @JvmStatic fun ofString(string: String) = Value(string = string)

                            @JvmStatic fun ofNumber(number: Double) = Value(number = number)

                            @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                            @JvmStatic
                            fun ofComparisonFilterValueItems(
                                comparisonFilterValueItems: List<ComparisonFilterValueItem>
                            ) =
                                Value(
                                    comparisonFilterValueItems =
                                        comparisonFilterValueItems.toImmutable()
                                )
                        }

                        /**
                         * An interface that defines how to map each variant of [Value] to a value
                         * of type [T].
                         */
                        interface Visitor<out T> {

                            fun visitString(string: String): T

                            fun visitNumber(number: Double): T

                            fun visitBool(bool: Boolean): T

                            fun visitComparisonFilterValueItems(
                                comparisonFilterValueItems: List<ComparisonFilterValueItem>
                            ): T

                            /**
                             * Maps an unknown variant of [Value] to a value of type [T].
                             *
                             * An instance of [Value] can contain an unknown variant if it was
                             * deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown Value: $json")
                            }
                        }

                        internal class Deserializer : BaseDeserializer<Value>(Value::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): Value {
                                val json = JsonValue.fromJsonNode(node)

                                val bestMatches =
                                    sequenceOf(
                                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                                Value(string = it, _json = json)
                                            },
                                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                                Value(number = it, _json = json)
                                            },
                                            tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                                Value(bool = it, _json = json)
                                            },
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<
                                                        List<ComparisonFilterValueItem>
                                                    >(),
                                                )
                                                ?.let {
                                                    Value(
                                                        comparisonFilterValueItems = it,
                                                        _json = json,
                                                    )
                                                },
                                        )
                                        .filterNotNull()
                                        .allMaxBy { it.validity() }
                                        .toList()
                                return when (bestMatches.size) {
                                    // This can happen if what we're deserializing is completely
                                    // incompatible with all the possible variants (e.g.
                                    // deserializing from object).
                                    0 -> Value(_json = json)
                                    1 -> bestMatches.single()
                                    // If there's more than one match with the highest validity,
                                    // then use the first completely valid match, or simply the
                                    // first match if none are completely valid.
                                    else ->
                                        bestMatches.firstOrNull { it.isValid() }
                                            ?: bestMatches.first()
                                }
                            }
                        }

                        internal class Serializer : BaseSerializer<Value>(Value::class) {

                            override fun serialize(
                                value: Value,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.string != null -> generator.writeObject(value.string)
                                    value.number != null -> generator.writeObject(value.number)
                                    value.bool != null -> generator.writeObject(value.bool)
                                    value.comparisonFilterValueItems != null ->
                                        generator.writeObject(value.comparisonFilterValueItems)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid Value")
                                }
                            }
                        }

                        @JsonDeserialize(using = ComparisonFilterValueItem.Deserializer::class)
                        @JsonSerialize(using = ComparisonFilterValueItem.Serializer::class)
                        class ComparisonFilterValueItem
                        private constructor(
                            private val string: String? = null,
                            private val number: Double? = null,
                            private val _json: JsonValue? = null,
                        ) {

                            fun string(): Optional<String> = Optional.ofNullable(string)

                            fun number(): Optional<Double> = Optional.ofNullable(number)

                            fun isString(): Boolean = string != null

                            fun isNumber(): Boolean = number != null

                            fun asString(): String = string.getOrThrow("string")

                            fun asNumber(): Double = number.getOrThrow("number")

                            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                            /**
                             * Maps this instance's current variant to a value of type [T] using the
                             * given [visitor].
                             *
                             * Note that this method is _not_ forwards compatible with new variants
                             * from the API, unless [visitor] overrides [Visitor.unknown]. To handle
                             * variants not known to this version of the SDK gracefully, consider
                             * overriding [Visitor.unknown]:
                             * ```java
                             * import com.openai.core.JsonValue;
                             * import java.util.Optional;
                             *
                             * Optional<String> result = comparisonFilterValueItem.accept(new ComparisonFilterValueItem.Visitor<Optional<String>>() {
                             *     @Override
                             *     public Optional<String> visitString(String string) {
                             *         return Optional.of(string.toString());
                             *     }
                             *
                             *     // ...
                             *
                             *     @Override
                             *     public Optional<String> unknown(JsonValue json) {
                             *         // Or inspect the `json`.
                             *         return Optional.empty();
                             *     }
                             * });
                             * ```
                             *
                             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not
                             *   overridden in [visitor] and the current variant is unknown.
                             */
                            fun <T> accept(visitor: Visitor<T>): T =
                                when {
                                    string != null -> visitor.visitString(string)
                                    number != null -> visitor.visitNumber(number)
                                    else -> visitor.unknown(_json)
                                }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws OpenAIInvalidDataException if any value type in this object
                             *   doesn't match its expected type.
                             */
                            fun validate(): ComparisonFilterValueItem = apply {
                                if (validated) {
                                    return@apply
                                }

                                accept(
                                    object : Visitor<Unit> {
                                        override fun visitString(string: String) {}

                                        override fun visitNumber(number: Double) {}
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                accept(
                                    object : Visitor<Int> {
                                        override fun visitString(string: String) = 1

                                        override fun visitNumber(number: Double) = 1

                                        override fun unknown(json: JsonValue?) = 0
                                    }
                                )

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is ComparisonFilterValueItem &&
                                    string == other.string &&
                                    number == other.number
                            }

                            override fun hashCode(): Int = Objects.hash(string, number)

                            override fun toString(): String =
                                when {
                                    string != null -> "ComparisonFilterValueItem{string=$string}"
                                    number != null -> "ComparisonFilterValueItem{number=$number}"
                                    _json != null -> "ComparisonFilterValueItem{_unknown=$_json}"
                                    else ->
                                        throw IllegalStateException(
                                            "Invalid ComparisonFilterValueItem"
                                        )
                                }

                            companion object {

                                @JvmStatic
                                fun ofString(string: String) =
                                    ComparisonFilterValueItem(string = string)

                                @JvmStatic
                                fun ofNumber(number: Double) =
                                    ComparisonFilterValueItem(number = number)
                            }

                            /**
                             * An interface that defines how to map each variant of
                             * [ComparisonFilterValueItem] to a value of type [T].
                             */
                            interface Visitor<out T> {

                                fun visitString(string: String): T

                                fun visitNumber(number: Double): T

                                /**
                                 * Maps an unknown variant of [ComparisonFilterValueItem] to a value
                                 * of type [T].
                                 *
                                 * An instance of [ComparisonFilterValueItem] can contain an unknown
                                 * variant if it was deserialized from data that doesn't match any
                                 * known variant. For example, if the SDK is on an older version
                                 * than the API, then the API may respond with new variants that the
                                 * SDK is unaware of.
                                 *
                                 * @throws OpenAIInvalidDataException in the default implementation.
                                 */
                                fun unknown(json: JsonValue?): T {
                                    throw OpenAIInvalidDataException(
                                        "Unknown ComparisonFilterValueItem: $json"
                                    )
                                }
                            }

                            internal class Deserializer :
                                BaseDeserializer<ComparisonFilterValueItem>(
                                    ComparisonFilterValueItem::class
                                ) {

                                override fun ObjectCodec.deserialize(
                                    node: JsonNode
                                ): ComparisonFilterValueItem {
                                    val json = JsonValue.fromJsonNode(node)

                                    val bestMatches =
                                        sequenceOf(
                                                tryDeserialize(node, jacksonTypeRef<String>())
                                                    ?.let {
                                                        ComparisonFilterValueItem(
                                                            string = it,
                                                            _json = json,
                                                        )
                                                    },
                                                tryDeserialize(node, jacksonTypeRef<Double>())
                                                    ?.let {
                                                        ComparisonFilterValueItem(
                                                            number = it,
                                                            _json = json,
                                                        )
                                                    },
                                            )
                                            .filterNotNull()
                                            .allMaxBy { it.validity() }
                                            .toList()
                                    return when (bestMatches.size) {
                                        // This can happen if what we're deserializing is completely
                                        // incompatible with all the possible variants (e.g.
                                        // deserializing from boolean).
                                        0 -> ComparisonFilterValueItem(_json = json)
                                        1 -> bestMatches.single()
                                        // If there's more than one match with the highest validity,
                                        // then use the first completely valid match, or simply the
                                        // first match if none are completely valid.
                                        else ->
                                            bestMatches.firstOrNull { it.isValid() }
                                                ?: bestMatches.first()
                                    }
                                }
                            }

                            internal class Serializer :
                                BaseSerializer<ComparisonFilterValueItem>(
                                    ComparisonFilterValueItem::class
                                ) {

                                override fun serialize(
                                    value: ComparisonFilterValueItem,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    when {
                                        value.string != null -> generator.writeObject(value.string)
                                        value.number != null -> generator.writeObject(value.number)
                                        value._json != null -> generator.writeObject(value._json)
                                        else ->
                                            throw IllegalStateException(
                                                "Invalid ComparisonFilterValueItem"
                                            )
                                    }
                                }
                            }
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ComparisonFilter &&
                            key == other.key &&
                            type == other.type &&
                            value == other.value &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(key, type, value, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ComparisonFilter{key=$key, type=$type, value=$value, additionalProperties=$additionalProperties}"
                }
            }

            /** Type of operation: `and` or `or`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AND = of("and")

                    @JvmField val OR = of("or")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    AND,
                    OR,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    AND,
                    OR,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        AND -> Value.AND
                        OR -> Value.OR
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        AND -> Known.AND
                        OR -> Known.OR
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Type = apply {
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

                    return other is Type && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CompoundFilter &&
                    filters == other.filters &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(filters, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CompoundFilter{filters=$filters, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** Ranking options for search. */
    class RankingOptions
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hybridSearch: JsonField<HybridSearch>,
        private val ranker: JsonField<Ranker>,
        private val scoreThreshold: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hybrid_search")
            @ExcludeMissing
            hybridSearch: JsonField<HybridSearch> = JsonMissing.of(),
            @JsonProperty("ranker") @ExcludeMissing ranker: JsonField<Ranker> = JsonMissing.of(),
            @JsonProperty("score_threshold")
            @ExcludeMissing
            scoreThreshold: JsonField<Double> = JsonMissing.of(),
        ) : this(hybridSearch, ranker, scoreThreshold, mutableMapOf())

        /**
         * Weights that control how reciprocal rank fusion balances semantic embedding matches
         * versus sparse keyword matches when hybrid search is enabled.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun hybridSearch(): Optional<HybridSearch> = hybridSearch.getOptional("hybrid_search")

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
         * Returns the raw JSON value of [hybridSearch].
         *
         * Unlike [hybridSearch], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("hybrid_search")
        @ExcludeMissing
        fun _hybridSearch(): JsonField<HybridSearch> = hybridSearch

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

            private var hybridSearch: JsonField<HybridSearch> = JsonMissing.of()
            private var ranker: JsonField<Ranker> = JsonMissing.of()
            private var scoreThreshold: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rankingOptions: RankingOptions) = apply {
                hybridSearch = rankingOptions.hybridSearch
                ranker = rankingOptions.ranker
                scoreThreshold = rankingOptions.scoreThreshold
                additionalProperties = rankingOptions.additionalProperties.toMutableMap()
            }

            /**
             * Weights that control how reciprocal rank fusion balances semantic embedding matches
             * versus sparse keyword matches when hybrid search is enabled.
             */
            fun hybridSearch(hybridSearch: HybridSearch) = hybridSearch(JsonField.of(hybridSearch))

            /**
             * Sets [Builder.hybridSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hybridSearch] with a well-typed [HybridSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hybridSearch(hybridSearch: JsonField<HybridSearch>) = apply {
                this.hybridSearch = hybridSearch
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
                RankingOptions(
                    hybridSearch,
                    ranker,
                    scoreThreshold,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): RankingOptions = apply {
            if (validated) {
                return@apply
            }

            hybridSearch().ifPresent { it.validate() }
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
            (hybridSearch.asKnown().getOrNull()?.validity() ?: 0) +
                (ranker.asKnown().getOrNull()?.validity() ?: 0) +
                (if (scoreThreshold.asKnown().isPresent) 1 else 0)

        /**
         * Weights that control how reciprocal rank fusion balances semantic embedding matches
         * versus sparse keyword matches when hybrid search is enabled.
         */
        class HybridSearch
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val embeddingWeight: JsonField<Double>,
            private val textWeight: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("embedding_weight")
                @ExcludeMissing
                embeddingWeight: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("text_weight")
                @ExcludeMissing
                textWeight: JsonField<Double> = JsonMissing.of(),
            ) : this(embeddingWeight, textWeight, mutableMapOf())

            /**
             * The weight of the embedding in the reciprocal ranking fusion.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun embeddingWeight(): Double = embeddingWeight.getRequired("embedding_weight")

            /**
             * The weight of the text in the reciprocal ranking fusion.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun textWeight(): Double = textWeight.getRequired("text_weight")

            /**
             * Returns the raw JSON value of [embeddingWeight].
             *
             * Unlike [embeddingWeight], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("embedding_weight")
            @ExcludeMissing
            fun _embeddingWeight(): JsonField<Double> = embeddingWeight

            /**
             * Returns the raw JSON value of [textWeight].
             *
             * Unlike [textWeight], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("text_weight")
            @ExcludeMissing
            fun _textWeight(): JsonField<Double> = textWeight

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
                 * Returns a mutable builder for constructing an instance of [HybridSearch].
                 *
                 * The following fields are required:
                 * ```java
                 * .embeddingWeight()
                 * .textWeight()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [HybridSearch]. */
            class Builder internal constructor() {

                private var embeddingWeight: JsonField<Double>? = null
                private var textWeight: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(hybridSearch: HybridSearch) = apply {
                    embeddingWeight = hybridSearch.embeddingWeight
                    textWeight = hybridSearch.textWeight
                    additionalProperties = hybridSearch.additionalProperties.toMutableMap()
                }

                /** The weight of the embedding in the reciprocal ranking fusion. */
                fun embeddingWeight(embeddingWeight: Double) =
                    embeddingWeight(JsonField.of(embeddingWeight))

                /**
                 * Sets [Builder.embeddingWeight] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.embeddingWeight] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun embeddingWeight(embeddingWeight: JsonField<Double>) = apply {
                    this.embeddingWeight = embeddingWeight
                }

                /** The weight of the text in the reciprocal ranking fusion. */
                fun textWeight(textWeight: Double) = textWeight(JsonField.of(textWeight))

                /**
                 * Sets [Builder.textWeight] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.textWeight] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun textWeight(textWeight: JsonField<Double>) = apply {
                    this.textWeight = textWeight
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [HybridSearch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .embeddingWeight()
                 * .textWeight()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): HybridSearch =
                    HybridSearch(
                        checkRequired("embeddingWeight", embeddingWeight),
                        checkRequired("textWeight", textWeight),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): HybridSearch = apply {
                if (validated) {
                    return@apply
                }

                embeddingWeight()
                textWeight()
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
                (if (embeddingWeight.asKnown().isPresent) 1 else 0) +
                    (if (textWeight.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is HybridSearch &&
                    embeddingWeight == other.embeddingWeight &&
                    textWeight == other.textWeight &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(embeddingWeight, textWeight, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "HybridSearch{embeddingWeight=$embeddingWeight, textWeight=$textWeight, additionalProperties=$additionalProperties}"
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

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is Ranker && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RankingOptions &&
                hybridSearch == other.hybridSearch &&
                ranker == other.ranker &&
                scoreThreshold == other.scoreThreshold &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hybridSearch, ranker, scoreThreshold, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RankingOptions{hybridSearch=$hybridSearch, ranker=$ranker, scoreThreshold=$scoreThreshold, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaFileSearchTool &&
            type == other.type &&
            vectorStoreIds == other.vectorStoreIds &&
            filters == other.filters &&
            maxNumResults == other.maxNumResults &&
            rankingOptions == other.rankingOptions &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            type,
            vectorStoreIds,
            filters,
            maxNumResults,
            rankingOptions,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaFileSearchTool{type=$type, vectorStoreIds=$vectorStoreIds, filters=$filters, maxNumResults=$maxNumResults, rankingOptions=$rankingOptions, additionalProperties=$additionalProperties}"
}
