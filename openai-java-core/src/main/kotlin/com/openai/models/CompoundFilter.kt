// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

/** Combine multiple filters using `and` or `or`. */
class CompoundFilter
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
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun filters(): List<Filter> = filters.getRequired("filters")

    /**
     * Type of operation: `and` or `or`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [filters].
     *
     * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<List<Filter>> = filters

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

        /** Array of filters to combine. Items can be `ComparisonFilter` or `CompoundFilter`. */
        fun filters(filters: List<Filter>) = filters(JsonField.of(filters))

        /**
         * Sets [Builder.filters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filters] with a well-typed `List<Filter>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
        fun addFilter(comparison: ComparisonFilter) = addFilter(Filter.ofComparison(comparison))

        /** Alias for calling [addFilter] with `Filter.ofJsonValue(jsonValue)`. */
        fun addFilter(jsonValue: JsonValue) = addFilter(Filter.ofJsonValue(jsonValue))

        /** Type of operation: `and` or `or`. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        fun comparison(): Optional<ComparisonFilter> = Optional.ofNullable(comparison)

        fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

        fun isComparison(): Boolean = comparison != null

        fun isJsonValue(): Boolean = jsonValue != null

        /**
         * A filter used to compare a specified attribute key to a given value using a defined
         * comparison operation.
         */
        fun asComparison(): ComparisonFilter = comparison.getOrThrow("comparison")

        fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                comparison != null -> visitor.visitComparison(comparison)
                jsonValue != null -> visitor.visitJsonValue(jsonValue)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

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

            return /* spotless:off */ other is Filter && comparison == other.comparison && jsonValue == other.jsonValue /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(comparison, jsonValue) /* spotless:on */

        override fun toString(): String =
            when {
                comparison != null -> "Filter{comparison=$comparison}"
                jsonValue != null -> "Filter{jsonValue=$jsonValue}"
                _json != null -> "Filter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Filter")
            }

        companion object {

            /**
             * A filter used to compare a specified attribute key to a given value using a defined
             * comparison operation.
             */
            @JvmStatic
            fun ofComparison(comparison: ComparisonFilter) = Filter(comparison = comparison)

            @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Filter(jsonValue = jsonValue)
        }

        /** An interface that defines how to map each variant of [Filter] to a value of type [T]. */
        interface Visitor<out T> {

            /**
             * A filter used to compare a specified attribute key to a given value using a defined
             * comparison operation.
             */
            fun visitComparison(comparison: ComparisonFilter): T

            fun visitJsonValue(jsonValue: JsonValue): T

            /**
             * Maps an unknown variant of [Filter] to a value of type [T].
             *
             * An instance of [Filter] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants.
                    0 -> Filter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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
    }

    /** Type of operation: `and` or `or`. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AND,
            OR,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompoundFilter && filters == other.filters && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(filters, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompoundFilter{filters=$filters, type=$type, additionalProperties=$additionalProperties}"
}
