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
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **o-series models only**
 *
 * Configuration options for [reasoning models](https://platform.openai.com/docs/guides/reasoning).
 */
@NoAutoDetect
class Reasoning
@JsonCreator
private constructor(
    @JsonProperty("effort")
    @ExcludeMissing
    private val effort: JsonField<ReasoningEffort> = JsonMissing.of(),
    @JsonProperty("generate_summary")
    @ExcludeMissing
    private val generateSummary: JsonField<GenerateSummary> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * **o-series models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     */
    fun effort(): Optional<ReasoningEffort> = Optional.ofNullable(effort.getNullable("effort"))

    /**
     * **o-series models only**
     *
     * A summary of the reasoning performed by the model. This can be useful for debugging and
     * understanding the model's reasoning process. One of `concise` or `detailed`.
     */
    fun generateSummary(): Optional<GenerateSummary> =
        Optional.ofNullable(generateSummary.getNullable("generate_summary"))

    /**
     * **o-series models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     */
    @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<ReasoningEffort> = effort

    /**
     * **o-series models only**
     *
     * A summary of the reasoning performed by the model. This can be useful for debugging and
     * understanding the model's reasoning process. One of `concise` or `detailed`.
     */
    @JsonProperty("generate_summary")
    @ExcludeMissing
    fun _generateSummary(): JsonField<GenerateSummary> = generateSummary

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Reasoning = apply {
        if (validated) {
            return@apply
        }

        effort()
        generateSummary()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Reasoning].
         *
         * The following fields are required:
         * ```java
         * .effort()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Reasoning]. */
    class Builder internal constructor() {

        private var effort: JsonField<ReasoningEffort>? = null
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

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun effort(effort: Optional<ReasoningEffort>) = effort(effort.getOrNull())

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun effort(effort: JsonField<ReasoningEffort>) = apply { this.effort = effort }

        /**
         * **o-series models only**
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `concise` or `detailed`.
         */
        fun generateSummary(generateSummary: GenerateSummary?) =
            generateSummary(JsonField.ofNullable(generateSummary))

        /**
         * **o-series models only**
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `concise` or `detailed`.
         */
        fun generateSummary(generateSummary: Optional<GenerateSummary>) =
            generateSummary(generateSummary.getOrNull())

        /**
         * **o-series models only**
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `concise` or `detailed`.
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

        fun build(): Reasoning =
            Reasoning(
                checkRequired("effort", effort),
                generateSummary,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * **o-series models only**
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
