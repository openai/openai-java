// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class DecisionsDelegationConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val model: JsonField<String>,
    private val questions: JsonField<List<DecisionQuestion>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("questions")
        @ExcludeMissing
        questions: JsonField<List<DecisionQuestion>> = JsonMissing.of(),
    ) : this(model, questions, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun model(): java.util.Optional<String> = model.getOptional("model")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun modelOrThrow(): String = model.getRequired("model")

    /**
     * Native Decision API questions evaluated together, in order. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun questions(): java.util.Optional<List<DecisionQuestion>> = questions.getOptional("questions")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun questionsOrThrow(): List<DecisionQuestion> = questions.getRequired("questions")

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [questions].
     *
     * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("questions")
    @ExcludeMissing
    fun _questions(): JsonField<List<DecisionQuestion>> = questions

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "model" to this.model,
            "questions" to this.questions,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DecisionsDelegationConfig].
         *
         * The following fields are required:
         * ```java
         * .model()
         * .questions()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionsDelegationConfig]. */
    class Builder internal constructor() {

        private var model: JsonField<String>? = null
        private var questions: JsonField<MutableList<DecisionQuestion>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionsDelegationConfig: DecisionsDelegationConfig) = apply {
            model = decisionsDelegationConfig.model
            questions = decisionsDelegationConfig.questions.map { it.toMutableList() }
            additionalProperties = decisionsDelegationConfig.additionalProperties.toMutableMap()
        }

        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** Native Decision API questions evaluated together, in order. */
        fun questions(questions: List<DecisionQuestion>) = questions(JsonField.of(questions))

        /**
         * Sets [Builder.questions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.questions] with a well-typed `List<DecisionQuestion>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun questions(questions: JsonField<List<DecisionQuestion>>) = apply {
            this.questions = questions.map { it.toMutableList() }
        }

        /**
         * Adds a single [DecisionQuestion] to [questions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addQuestion(question: DecisionQuestion) = apply {
            questions =
                (questions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("questions", it).add(question)
                }
        }

        /** Alias for calling [addQuestion] with `DecisionQuestion.ofChoice(choice)`. */
        fun addQuestion(choice: DecisionQuestion.Choice) =
            addQuestion(DecisionQuestion.ofChoice(choice))

        /** Alias for calling [addQuestion] with `DecisionQuestion.ofPredicate(predicate)`. */
        fun addQuestion(predicate: DecisionQuestion.Predicate) =
            addQuestion(DecisionQuestion.ofPredicate(predicate))

        /**
         * Alias for calling [addQuestion] with the following:
         * ```java
         * DecisionQuestion.Predicate.builder()
         *     .instructions(instructions)
         *     .build()
         * ```
         */
        fun addPredicateQuestion(instructions: DecisionQuestionInstructions) =
            addQuestion(DecisionQuestion.Predicate.builder().instructions(instructions).build())

        /**
         * Alias for calling [addPredicateQuestion] with
         * `DecisionQuestionInstructions.ofString(string)`.
         */
        fun addPredicateQuestion(string: String) =
            addPredicateQuestion(DecisionQuestionInstructions.ofString(string))

        /**
         * Alias for calling [addPredicateQuestion] with
         * `DecisionQuestionInstructions.ofParts(parts)`.
         */
        fun addPredicateQuestionOfParts(parts: List<DecisionQuestionInputPart>) =
            addPredicateQuestion(DecisionQuestionInstructions.ofParts(parts))

        /** Alias for calling [addQuestion] with `DecisionQuestion.ofScore(score)`. */
        fun addQuestion(score: DecisionQuestion.Score) =
            addQuestion(DecisionQuestion.ofScore(score))

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
         * Returns an immutable instance of [DecisionsDelegationConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * .questions()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionsDelegationConfig =
            DecisionsDelegationConfig(
                checkRequired("model", model),
                checkRequired("questions", questions).map { it.toImmutable() },
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
    fun validate(): DecisionsDelegationConfig = apply {
        if (validated) {
            return@apply
        }

        modelOrThrow()
        questionsOrThrow().forEach { it.validate() }
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
        (if (model.asKnown().isPresent) 1 else 0) +
            (questions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionsDelegationConfig &&
            model == other.model &&
            questions == other.questions &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(model, questions, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionsDelegationConfig{model=$model, questions=$questions, additionalProperties=$additionalProperties}"
}
