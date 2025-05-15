// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.EvalItem
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A ScoreModelGrader object that uses a model to assign a score to the input. */
class ScoreModelGrader
private constructor(
    private val input: JsonField<List<EvalItem>>,
    private val model: JsonField<String>,
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val range: JsonField<List<Double>>,
    private val samplingParams: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input") @ExcludeMissing input: JsonField<List<EvalItem>> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("range") @ExcludeMissing range: JsonField<List<Double>> = JsonMissing.of(),
        @JsonProperty("sampling_params")
        @ExcludeMissing
        samplingParams: JsonValue = JsonMissing.of(),
    ) : this(input, model, name, type, range, samplingParams, mutableMapOf())

    /**
     * The input text. This may include template strings.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): List<EvalItem> = input.getRequired("input")

    /**
     * The model to use for the evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The object type, which is always `score_model`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("score_model")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The range of the score. Defaults to `[0, 1]`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun range(): Optional<List<Double>> = range.getOptional("range")

    /** The sampling parameters for the model. */
    @JsonProperty("sampling_params")
    @ExcludeMissing
    fun _samplingParams(): JsonValue = samplingParams

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<EvalItem>> = input

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [range].
     *
     * Unlike [range], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("range") @ExcludeMissing fun _range(): JsonField<List<Double>> = range

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
         * Returns a mutable builder for constructing an instance of [ScoreModelGrader].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScoreModelGrader]. */
    class Builder internal constructor() {

        private var input: JsonField<MutableList<EvalItem>>? = null
        private var model: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("score_model")
        private var range: JsonField<MutableList<Double>>? = null
        private var samplingParams: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(scoreModelGrader: ScoreModelGrader) = apply {
            input = scoreModelGrader.input.map { it.toMutableList() }
            model = scoreModelGrader.model
            name = scoreModelGrader.name
            type = scoreModelGrader.type
            range = scoreModelGrader.range.map { it.toMutableList() }
            samplingParams = scoreModelGrader.samplingParams
            additionalProperties = scoreModelGrader.additionalProperties.toMutableMap()
        }

        /** The input text. This may include template strings. */
        fun input(input: List<EvalItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<EvalItem>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun input(input: JsonField<List<EvalItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [EvalItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: EvalItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /** The model to use for the evaluation. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("score_model")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The range of the score. Defaults to `[0, 1]`. */
        fun range(range: List<Double>) = range(JsonField.of(range))

        /**
         * Sets [Builder.range] to an arbitrary JSON value.
         *
         * You should usually call [Builder.range] with a well-typed `List<Double>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun range(range: JsonField<List<Double>>) = apply {
            this.range = range.map { it.toMutableList() }
        }

        /**
         * Adds a single [Double] to [Builder.range].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRange(range: Double) = apply {
            this.range =
                (this.range ?: JsonField.of(mutableListOf())).also {
                    checkKnown("range", it).add(range)
                }
        }

        /** The sampling parameters for the model. */
        fun samplingParams(samplingParams: JsonValue) = apply {
            this.samplingParams = samplingParams
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
         * Returns an immutable instance of [ScoreModelGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScoreModelGrader =
            ScoreModelGrader(
                checkRequired("input", input).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("name", name),
                type,
                (range ?: JsonMissing.of()).map { it.toImmutable() },
                samplingParams,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ScoreModelGrader = apply {
        if (validated) {
            return@apply
        }

        input().forEach { it.validate() }
        model()
        name()
        _type().let {
            if (it != JsonValue.from("score_model")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        range()
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
        (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("score_model")) 1 else 0 } +
            (range.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScoreModelGrader && input == other.input && model == other.model && name == other.name && type == other.type && range == other.range && samplingParams == other.samplingParams && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(input, model, name, type, range, samplingParams, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ScoreModelGrader{input=$input, model=$model, name=$name, type=$type, range=$range, samplingParams=$samplingParams, additionalProperties=$additionalProperties}"
}
