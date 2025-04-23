// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A TextSimilarityGrader object which grades text based on similarity metrics. */
class EvalTextSimilarityGrader
private constructor(
    private val evaluationMetric: JsonField<EvaluationMetric>,
    private val input: JsonField<String>,
    private val passThreshold: JsonField<Double>,
    private val reference: JsonField<String>,
    private val type: JsonValue,
    private val name: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("evaluation_metric")
        @ExcludeMissing
        evaluationMetric: JsonField<EvaluationMetric> = JsonMissing.of(),
        @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pass_threshold")
        @ExcludeMissing
        passThreshold: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("reference") @ExcludeMissing reference: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
    ) : this(evaluationMetric, input, passThreshold, reference, type, name, mutableMapOf())

    /**
     * The evaluation metric to use. One of `fuzzy_match`, `bleu`, `gleu`, `meteor`, `rouge_1`,
     * `rouge_2`, `rouge_3`, `rouge_4`, `rouge_5`, or `rouge_l`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun evaluationMetric(): EvaluationMetric = evaluationMetric.getRequired("evaluation_metric")

    /**
     * The text being graded.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): String = input.getRequired("input")

    /**
     * A float score where a value greater than or equal indicates a passing grade.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun passThreshold(): Double = passThreshold.getRequired("pass_threshold")

    /**
     * The text being graded against.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reference(): String = reference.getRequired("reference")

    /**
     * The type of grader.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("text_similarity")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Returns the raw JSON value of [evaluationMetric].
     *
     * Unlike [evaluationMetric], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("evaluation_metric")
    @ExcludeMissing
    fun _evaluationMetric(): JsonField<EvaluationMetric> = evaluationMetric

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

    /**
     * Returns the raw JSON value of [passThreshold].
     *
     * Unlike [passThreshold], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pass_threshold")
    @ExcludeMissing
    fun _passThreshold(): JsonField<Double> = passThreshold

    /**
     * Returns the raw JSON value of [reference].
     *
     * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

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

        /**
         * Returns a mutable builder for constructing an instance of [EvalTextSimilarityGrader].
         *
         * The following fields are required:
         * ```java
         * .evaluationMetric()
         * .input()
         * .passThreshold()
         * .reference()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalTextSimilarityGrader]. */
    class Builder internal constructor() {

        private var evaluationMetric: JsonField<EvaluationMetric>? = null
        private var input: JsonField<String>? = null
        private var passThreshold: JsonField<Double>? = null
        private var reference: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("text_similarity")
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evalTextSimilarityGrader: EvalTextSimilarityGrader) = apply {
            evaluationMetric = evalTextSimilarityGrader.evaluationMetric
            input = evalTextSimilarityGrader.input
            passThreshold = evalTextSimilarityGrader.passThreshold
            reference = evalTextSimilarityGrader.reference
            type = evalTextSimilarityGrader.type
            name = evalTextSimilarityGrader.name
            additionalProperties = evalTextSimilarityGrader.additionalProperties.toMutableMap()
        }

        /**
         * The evaluation metric to use. One of `fuzzy_match`, `bleu`, `gleu`, `meteor`, `rouge_1`,
         * `rouge_2`, `rouge_3`, `rouge_4`, `rouge_5`, or `rouge_l`.
         */
        fun evaluationMetric(evaluationMetric: EvaluationMetric) =
            evaluationMetric(JsonField.of(evaluationMetric))

        /**
         * Sets [Builder.evaluationMetric] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evaluationMetric] with a well-typed [EvaluationMetric]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun evaluationMetric(evaluationMetric: JsonField<EvaluationMetric>) = apply {
            this.evaluationMetric = evaluationMetric
        }

        /** The text being graded. */
        fun input(input: String) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<String>) = apply { this.input = input }

        /** A float score where a value greater than or equal indicates a passing grade. */
        fun passThreshold(passThreshold: Double) = passThreshold(JsonField.of(passThreshold))

        /**
         * Sets [Builder.passThreshold] to an arbitrary JSON value.
         *
         * You should usually call [Builder.passThreshold] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun passThreshold(passThreshold: JsonField<Double>) = apply {
            this.passThreshold = passThreshold
        }

        /** The text being graded against. */
        fun reference(reference: String) = reference(JsonField.of(reference))

        /**
         * Sets [Builder.reference] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reference] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reference(reference: JsonField<String>) = apply { this.reference = reference }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("text_similarity")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [EvalTextSimilarityGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .evaluationMetric()
         * .input()
         * .passThreshold()
         * .reference()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalTextSimilarityGrader =
            EvalTextSimilarityGrader(
                checkRequired("evaluationMetric", evaluationMetric),
                checkRequired("input", input),
                checkRequired("passThreshold", passThreshold),
                checkRequired("reference", reference),
                type,
                name,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvalTextSimilarityGrader = apply {
        if (validated) {
            return@apply
        }

        evaluationMetric().validate()
        input()
        passThreshold()
        reference()
        _type().let {
            if (it != JsonValue.from("text_similarity")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (evaluationMetric.asKnown().getOrNull()?.validity() ?: 0) +
            (if (input.asKnown().isPresent) 1 else 0) +
            (if (passThreshold.asKnown().isPresent) 1 else 0) +
            (if (reference.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("text_similarity")) 1 else 0 } +
            (if (name.asKnown().isPresent) 1 else 0)

    /**
     * The evaluation metric to use. One of `fuzzy_match`, `bleu`, `gleu`, `meteor`, `rouge_1`,
     * `rouge_2`, `rouge_3`, `rouge_4`, `rouge_5`, or `rouge_l`.
     */
    class EvaluationMetric @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val FUZZY_MATCH = of("fuzzy_match")

            @JvmField val BLEU = of("bleu")

            @JvmField val GLEU = of("gleu")

            @JvmField val METEOR = of("meteor")

            @JvmField val ROUGE_1 = of("rouge_1")

            @JvmField val ROUGE_2 = of("rouge_2")

            @JvmField val ROUGE_3 = of("rouge_3")

            @JvmField val ROUGE_4 = of("rouge_4")

            @JvmField val ROUGE_5 = of("rouge_5")

            @JvmField val ROUGE_L = of("rouge_l")

            @JvmStatic fun of(value: String) = EvaluationMetric(JsonField.of(value))
        }

        /** An enum containing [EvaluationMetric]'s known values. */
        enum class Known {
            FUZZY_MATCH,
            BLEU,
            GLEU,
            METEOR,
            ROUGE_1,
            ROUGE_2,
            ROUGE_3,
            ROUGE_4,
            ROUGE_5,
            ROUGE_L,
        }

        /**
         * An enum containing [EvaluationMetric]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EvaluationMetric] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FUZZY_MATCH,
            BLEU,
            GLEU,
            METEOR,
            ROUGE_1,
            ROUGE_2,
            ROUGE_3,
            ROUGE_4,
            ROUGE_5,
            ROUGE_L,
            /**
             * An enum member indicating that [EvaluationMetric] was instantiated with an unknown
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
                FUZZY_MATCH -> Value.FUZZY_MATCH
                BLEU -> Value.BLEU
                GLEU -> Value.GLEU
                METEOR -> Value.METEOR
                ROUGE_1 -> Value.ROUGE_1
                ROUGE_2 -> Value.ROUGE_2
                ROUGE_3 -> Value.ROUGE_3
                ROUGE_4 -> Value.ROUGE_4
                ROUGE_5 -> Value.ROUGE_5
                ROUGE_L -> Value.ROUGE_L
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
                FUZZY_MATCH -> Known.FUZZY_MATCH
                BLEU -> Known.BLEU
                GLEU -> Known.GLEU
                METEOR -> Known.METEOR
                ROUGE_1 -> Known.ROUGE_1
                ROUGE_2 -> Known.ROUGE_2
                ROUGE_3 -> Known.ROUGE_3
                ROUGE_4 -> Known.ROUGE_4
                ROUGE_5 -> Known.ROUGE_5
                ROUGE_L -> Known.ROUGE_L
                else -> throw OpenAIInvalidDataException("Unknown EvaluationMetric: $value")
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

        fun validate(): EvaluationMetric = apply {
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

            return /* spotless:off */ other is EvaluationMetric && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalTextSimilarityGrader && evaluationMetric == other.evaluationMetric && input == other.input && passThreshold == other.passThreshold && reference == other.reference && type == other.type && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(evaluationMetric, input, passThreshold, reference, type, name, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvalTextSimilarityGrader{evaluationMetric=$evaluationMetric, input=$input, passThreshold=$passThreshold, reference=$reference, type=$type, name=$name, additionalProperties=$additionalProperties}"
}
