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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **o-series models only**
 *
 * Configuration options for [reasoning models](https://platform.openai.com/docs/guides/reasoning).
 */
class Reasoning
private constructor(
    private val effort: JsonField<ReasoningEffort>,
    private val generateSummary: JsonField<GenerateSummary>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("effort")
        @ExcludeMissing
        effort: JsonField<ReasoningEffort> = JsonMissing.of(),
        @JsonProperty("generate_summary")
        @ExcludeMissing
        generateSummary: JsonField<GenerateSummary> = JsonMissing.of(),
    ) : this(effort, generateSummary, mutableMapOf())

    /**
     * **o-series models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun effort(): Optional<ReasoningEffort> = Optional.ofNullable(effort.getNullable("effort"))

    /**
     * **computer_use_preview only**
     *
     * A summary of the reasoning performed by the model. This can be useful for debugging and
     * understanding the model's reasoning process. One of `concise` or `detailed`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun generateSummary(): Optional<GenerateSummary> =
        Optional.ofNullable(generateSummary.getNullable("generate_summary"))

    /**
     * Returns the raw JSON value of [effort].
     *
     * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<ReasoningEffort> = effort

    /**
     * Returns the raw JSON value of [generateSummary].
     *
     * Unlike [generateSummary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("generate_summary")
    @ExcludeMissing
    fun _generateSummary(): JsonField<GenerateSummary> = generateSummary

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

        /** Returns a mutable builder for constructing an instance of [Reasoning]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Reasoning]. */
    class Builder internal constructor() {

        private var effort: JsonField<ReasoningEffort> = JsonMissing.of()
        private var generateSummary: JsonField<GenerateSummary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(reasoning: Reasoning) = apply {
            effort = reasoning.effort
            generateSummary = reasoning.generateSummary
            additionalProperties = reasoning.additionalProperties.toMutableMap()
        }

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun effort(effort: ReasoningEffort?) = effort(JsonField.ofNullable(effort))

        /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
        fun effort(effort: Optional<ReasoningEffort>) = effort(effort.getOrNull())

        /**
         * Sets [Builder.effort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effort] with a well-typed [ReasoningEffort] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun effort(effort: JsonField<ReasoningEffort>) = apply { this.effort = effort }

        /**
         * **computer_use_preview only**
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `concise` or `detailed`.
         */
        fun generateSummary(generateSummary: GenerateSummary?) =
            generateSummary(JsonField.ofNullable(generateSummary))

        /** Alias for calling [Builder.generateSummary] with `generateSummary.orElse(null)`. */
        fun generateSummary(generateSummary: Optional<GenerateSummary>) =
            generateSummary(generateSummary.getOrNull())

        /**
         * Sets [Builder.generateSummary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.generateSummary] with a well-typed [GenerateSummary]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun generateSummary(generateSummary: JsonField<GenerateSummary>) = apply {
            this.generateSummary = generateSummary
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
         * Returns an immutable instance of [Reasoning].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Reasoning =
            Reasoning(effort, generateSummary, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): Reasoning = apply {
        if (validated) {
            return@apply
        }

        effort().ifPresent { it.validate() }
        generateSummary().ifPresent { it.validate() }
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
        (effort.asKnown().getOrNull()?.validity() ?: 0) +
            (generateSummary.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * **computer_use_preview only**
     *
     * A summary of the reasoning performed by the model. This can be useful for debugging and
     * understanding the model's reasoning process. One of `concise` or `detailed`.
     */
    class GenerateSummary @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val CONCISE = of("concise")

            @JvmField val DETAILED = of("detailed")

            @JvmStatic fun of(value: String) = GenerateSummary(JsonField.of(value))
        }

        /** An enum containing [GenerateSummary]'s known values. */
        enum class Known {
            CONCISE,
            DETAILED,
        }

        /**
         * An enum containing [GenerateSummary]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [GenerateSummary] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CONCISE,
            DETAILED,
            /**
             * An enum member indicating that [GenerateSummary] was instantiated with an unknown
             * value.
             */
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
                CONCISE -> Value.CONCISE
                DETAILED -> Value.DETAILED
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
                CONCISE -> Known.CONCISE
                DETAILED -> Known.DETAILED
                else -> throw OpenAIInvalidDataException("Unknown GenerateSummary: $value")
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

        fun validate(): GenerateSummary = apply {
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

            return /* spotless:off */ other is GenerateSummary && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Reasoning && effort == other.effort && generateSummary == other.generateSummary && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(effort, generateSummary, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Reasoning{effort=$effort, generateSummary=$generateSummary, additionalProperties=$additionalProperties}"
}
