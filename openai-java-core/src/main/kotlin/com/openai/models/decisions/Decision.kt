// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Decision
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val answers: JsonField<List<Answer>>,
    private val model: JsonField<String>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("answers")
        @ExcludeMissing
        answers: JsonField<List<Answer>> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
    ) : this(answers, model, usage, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun answers(): List<Answer> = answers.getRequired("answers")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): Usage = usage.getRequired("usage")

    /**
     * Returns the raw JSON value of [answers].
     *
     * Unlike [answers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("answers") @ExcludeMissing fun _answers(): JsonField<List<Answer>> = answers

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
         * Returns a mutable builder for constructing an instance of [Decision].
         *
         * The following fields are required:
         * ```java
         * .answers()
         * .model()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Decision]. */
    class Builder internal constructor() {

        private var answers: JsonField<MutableList<Answer>>? = null
        private var model: JsonField<String>? = null
        private var usage: JsonField<Usage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decision: Decision) = apply {
            answers = decision.answers.map { it.toMutableList() }
            model = decision.model
            usage = decision.usage
            additionalProperties = decision.additionalProperties.toMutableMap()
        }

        fun answers(answers: List<Answer>) = answers(JsonField.of(answers))

        /**
         * Sets [Builder.answers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.answers] with a well-typed `List<Answer>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun answers(answers: JsonField<List<Answer>>) = apply {
            this.answers = answers.map { it.toMutableList() }
        }

        /**
         * Adds a single [Answer] to [answers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAnswer(answer: Answer) = apply {
            answers =
                (answers ?: JsonField.of(mutableListOf())).also {
                    checkKnown("answers", it).add(answer)
                }
        }

        /** Alias for calling [addAnswer] with `Answer.ofPredicate(predicate)`. */
        fun addAnswer(predicate: Answer.Predicate) = addAnswer(Answer.ofPredicate(predicate))

        /** Alias for calling [addAnswer] with `Answer.ofChoice(choice)`. */
        fun addAnswer(choice: Answer.Choice) = addAnswer(Answer.ofChoice(choice))

        /** Alias for calling [addAnswer] with `Answer.ofScore(score)`. */
        fun addAnswer(score: Answer.Score) = addAnswer(Answer.ofScore(score))

        /** Alias for calling [addAnswer] with `Answer.ofRefusal(refusal)`. */
        fun addAnswer(refusal: Answer.Refusal) = addAnswer(Answer.ofRefusal(refusal))

        /**
         * Alias for calling [addAnswer] with the following:
         * ```java
         * Answer.Refusal.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addRefusalAnswer(name: String?) = addAnswer(Answer.Refusal.builder().name(name).build())

        /** Alias for calling [addRefusalAnswer] with `name.orElse(null)`. */
        fun addRefusalAnswer(name: Optional<String>) = addRefusalAnswer(name.getOrNull())

        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [Decision].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .answers()
         * .model()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Decision =
            Decision(
                checkRequired("answers", answers).map { it.toImmutable() },
                checkRequired("model", model),
                checkRequired("usage", usage),
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
    fun validate(): Decision = apply {
        if (validated) {
            return@apply
        }

        answers().forEach { it.validate() }
        model()
        usage().validate()
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
        (answers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    /** A completed question always includes its name, including null when unnamed. */
    @JsonDeserialize(using = Answer.Deserializer::class)
    @JsonSerialize(using = Answer.Serializer::class)
    class Answer
    private constructor(
        private val predicate: Predicate? = null,
        private val choice: Choice? = null,
        private val score: Score? = null,
        private val refusal: Refusal? = null,
        private val _json: JsonValue? = null,
    ) {

        fun predicate(): Optional<Predicate> = Optional.ofNullable(predicate)

        fun choice(): Optional<Choice> = Optional.ofNullable(choice)

        fun score(): Optional<Score> = Optional.ofNullable(score)

        /**
         * The model declined to answer this question. Other questions in the same request can still
         * receive answers.
         */
        fun refusal(): Optional<Refusal> = Optional.ofNullable(refusal)

        fun isPredicate(): Boolean = predicate != null

        fun isChoice(): Boolean = choice != null

        fun isScore(): Boolean = score != null

        fun isRefusal(): Boolean = refusal != null

        fun asPredicate(): Predicate = predicate.getOrThrow("predicate")

        fun asChoice(): Choice = choice.getOrThrow("choice")

        fun asScore(): Score = score.getOrThrow("score")

        /**
         * The model declined to answer this question. Other questions in the same request can still
         * receive answers.
         */
        fun asRefusal(): Refusal = refusal.getOrThrow("refusal")

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
         * Optional<String> result = answer.accept(new Answer.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitPredicate(Predicate predicate) {
         *         return Optional.of(predicate.toString());
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
                predicate != null -> visitor.visitPredicate(predicate)
                choice != null -> visitor.visitChoice(choice)
                score != null -> visitor.visitScore(score)
                refusal != null -> visitor.visitRefusal(refusal)
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
        fun validate(): Answer = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitPredicate(predicate: Predicate) {
                        predicate.validate()
                    }

                    override fun visitChoice(choice: Choice) {
                        choice.validate()
                    }

                    override fun visitScore(score: Score) {
                        score.validate()
                    }

                    override fun visitRefusal(refusal: Refusal) {
                        refusal.validate()
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
                    override fun visitPredicate(predicate: Predicate) = predicate.validity()

                    override fun visitChoice(choice: Choice) = choice.validity()

                    override fun visitScore(score: Score) = score.validity()

                    override fun visitRefusal(refusal: Refusal) = refusal.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Answer &&
                predicate == other.predicate &&
                choice == other.choice &&
                score == other.score &&
                refusal == other.refusal
        }

        override fun hashCode(): Int = Objects.hash(predicate, choice, score, refusal)

        override fun toString(): String =
            when {
                predicate != null -> "Answer{predicate=$predicate}"
                choice != null -> "Answer{choice=$choice}"
                score != null -> "Answer{score=$score}"
                refusal != null -> "Answer{refusal=$refusal}"
                _json != null -> "Answer{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Answer")
            }

        companion object {

            @JvmStatic fun ofPredicate(predicate: Predicate) = Answer(predicate = predicate)

            @JvmStatic fun ofChoice(choice: Choice) = Answer(choice = choice)

            @JvmStatic fun ofScore(score: Score) = Answer(score = score)

            /**
             * The model declined to answer this question. Other questions in the same request can
             * still receive answers.
             */
            @JvmStatic fun ofRefusal(refusal: Refusal) = Answer(refusal = refusal)
        }

        /** An interface that defines how to map each variant of [Answer] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitPredicate(predicate: Predicate): T

            fun visitChoice(choice: Choice): T

            fun visitScore(score: Score): T

            /**
             * The model declined to answer this question. Other questions in the same request can
             * still receive answers.
             */
            fun visitRefusal(refusal: Refusal): T

            /**
             * Maps an unknown variant of [Answer] to a value of type [T].
             *
             * An instance of [Answer] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Answer")
            }
        }

        internal class Deserializer : BaseDeserializer<Answer>(Answer::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Answer {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "predicate" -> {
                        return tryDeserialize(node, jacksonTypeRef<Predicate>())?.let {
                            Answer(predicate = it, _json = json)
                        } ?: Answer(_json = json)
                    }
                    "choice" -> {
                        return tryDeserialize(node, jacksonTypeRef<Choice>())?.let {
                            Answer(choice = it, _json = json)
                        } ?: Answer(_json = json)
                    }
                    "score" -> {
                        return tryDeserialize(node, jacksonTypeRef<Score>())?.let {
                            Answer(score = it, _json = json)
                        } ?: Answer(_json = json)
                    }
                    "refusal" -> {
                        return tryDeserialize(node, jacksonTypeRef<Refusal>())?.let {
                            Answer(refusal = it, _json = json)
                        } ?: Answer(_json = json)
                    }
                }

                return Answer(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Answer>(Answer::class) {

            override fun serialize(
                value: Answer,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.predicate != null -> generator.writeObject(value.predicate)
                    value.choice != null -> generator.writeObject(value.choice)
                    value.score != null -> generator.writeObject(value.score)
                    value.refusal != null -> generator.writeObject(value.refusal)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Answer")
                }
            }
        }

        class Predicate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val probability: JsonField<Double>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("probability")
                @ExcludeMissing
                probability: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(name, probability, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun probability(): Double = probability.getRequired("probability")

            /**
             * The type of the object. Always `predicate`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("predicate")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [probability].
             *
             * Unlike [probability], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("probability")
            @ExcludeMissing
            fun _probability(): JsonField<Double> = probability

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
                 * Returns a mutable builder for constructing an instance of [Predicate].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .probability()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Predicate]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var probability: JsonField<Double>? = null
                private var type: JsonValue = JsonValue.from("predicate")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(predicate: Predicate) = apply {
                    name = predicate.name
                    probability = predicate.probability
                    type = predicate.type
                    additionalProperties = predicate.additionalProperties.toMutableMap()
                }

                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun probability(probability: Double) = probability(JsonField.of(probability))

                /**
                 * Sets [Builder.probability] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.probability] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun probability(probability: JsonField<Double>) = apply {
                    this.probability = probability
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("predicate")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Predicate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .probability()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Predicate =
                    Predicate(
                        checkRequired("name", name),
                        checkRequired("probability", probability),
                        type,
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
            fun validate(): Predicate = apply {
                if (validated) {
                    return@apply
                }

                name()
                probability()
                _type().let {
                    if (it != JsonValue.from("predicate")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (probability.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("predicate")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Predicate &&
                    name == other.name &&
                    probability == other.probability &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(name, probability, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Predicate{name=$name, probability=$probability, type=$type, additionalProperties=$additionalProperties}"
        }

        class Choice
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val choice: JsonField<DecisionChoiceValue>,
            private val confidence: JsonField<Double>,
            private val name: JsonField<String>,
            private val probabilities: JsonField<List<Probability>>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("choice")
                @ExcludeMissing
                choice: JsonField<DecisionChoiceValue> = JsonMissing.of(),
                @JsonProperty("confidence")
                @ExcludeMissing
                confidence: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("probabilities")
                @ExcludeMissing
                probabilities: JsonField<List<Probability>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(choice, confidence, name, probabilities, type, mutableMapOf())

            /**
             * Choice values are typed: a string and a boolean with the same text are distinct.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun choice(): DecisionChoiceValue = choice.getRequired("choice")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun confidence(): Double = confidence.getRequired("confidence")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun probabilities(): List<Probability> = probabilities.getRequired("probabilities")

            /**
             * The type of the object. Always `choice`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("choice")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [choice].
             *
             * Unlike [choice], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("choice")
            @ExcludeMissing
            fun _choice(): JsonField<DecisionChoiceValue> = choice

            /**
             * Returns the raw JSON value of [confidence].
             *
             * Unlike [confidence], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("confidence")
            @ExcludeMissing
            fun _confidence(): JsonField<Double> = confidence

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [probabilities].
             *
             * Unlike [probabilities], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("probabilities")
            @ExcludeMissing
            fun _probabilities(): JsonField<List<Probability>> = probabilities

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
                 * Returns a mutable builder for constructing an instance of [Choice].
                 *
                 * The following fields are required:
                 * ```java
                 * .choice()
                 * .confidence()
                 * .name()
                 * .probabilities()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Choice]. */
            class Builder internal constructor() {

                private var choice: JsonField<DecisionChoiceValue>? = null
                private var confidence: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var probabilities: JsonField<MutableList<Probability>>? = null
                private var type: JsonValue = JsonValue.from("choice")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(choice: Choice) = apply {
                    this.choice = choice.choice
                    confidence = choice.confidence
                    name = choice.name
                    probabilities = choice.probabilities.map { it.toMutableList() }
                    type = choice.type
                    additionalProperties = choice.additionalProperties.toMutableMap()
                }

                /**
                 * Choice values are typed: a string and a boolean with the same text are distinct.
                 */
                fun choice(choice: DecisionChoiceValue) = choice(JsonField.of(choice))

                /**
                 * Sets [Builder.choice] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.choice] with a well-typed [DecisionChoiceValue]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun choice(choice: JsonField<DecisionChoiceValue>) = apply { this.choice = choice }

                /** Alias for calling [choice] with `DecisionChoiceValue.ofString(string)`. */
                fun choice(string: String) = choice(DecisionChoiceValue.ofString(string))

                /** Alias for calling [choice] with `DecisionChoiceValue.ofBool(bool)`. */
                fun choice(bool: Boolean) = choice(DecisionChoiceValue.ofBool(bool))

                fun confidence(confidence: Double) = confidence(JsonField.of(confidence))

                /**
                 * Sets [Builder.confidence] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.confidence] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun confidence(confidence: JsonField<Double>) = apply {
                    this.confidence = confidence
                }

                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun probabilities(probabilities: List<Probability>) =
                    probabilities(JsonField.of(probabilities))

                /**
                 * Sets [Builder.probabilities] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.probabilities] with a well-typed
                 * `List<Probability>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun probabilities(probabilities: JsonField<List<Probability>>) = apply {
                    this.probabilities = probabilities.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Probability] to [probabilities].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addProbability(probability: Probability) = apply {
                    probabilities =
                        (probabilities ?: JsonField.of(mutableListOf())).also {
                            checkKnown("probabilities", it).add(probability)
                        }
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("choice")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Choice].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .choice()
                 * .confidence()
                 * .name()
                 * .probabilities()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Choice =
                    Choice(
                        checkRequired("choice", choice),
                        checkRequired("confidence", confidence),
                        checkRequired("name", name),
                        checkRequired("probabilities", probabilities).map { it.toImmutable() },
                        type,
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
            fun validate(): Choice = apply {
                if (validated) {
                    return@apply
                }

                choice().validate()
                confidence()
                name()
                probabilities().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("choice")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (choice.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (confidence.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (probabilities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("choice")) 1 else 0 }

            class Probability
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val probability: JsonField<Double>,
                private val value: JsonField<DecisionChoiceValue>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("probability")
                    @ExcludeMissing
                    probability: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<DecisionChoiceValue> = JsonMissing.of(),
                ) : this(probability, value, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun probability(): Double = probability.getRequired("probability")

                /**
                 * Choice values are typed: a string and a boolean with the same text are distinct.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun value(): DecisionChoiceValue = value.getRequired("value")

                /**
                 * Returns the raw JSON value of [probability].
                 *
                 * Unlike [probability], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("probability")
                @ExcludeMissing
                fun _probability(): JsonField<Double> = probability

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value")
                @ExcludeMissing
                fun _value(): JsonField<DecisionChoiceValue> = value

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
                     * Returns a mutable builder for constructing an instance of [Probability].
                     *
                     * The following fields are required:
                     * ```java
                     * .probability()
                     * .value()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Probability]. */
                class Builder internal constructor() {

                    private var probability: JsonField<Double>? = null
                    private var value: JsonField<DecisionChoiceValue>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(probability: Probability) = apply {
                        this.probability = probability.probability
                        value = probability.value
                        additionalProperties = probability.additionalProperties.toMutableMap()
                    }

                    fun probability(probability: Double) = probability(JsonField.of(probability))

                    /**
                     * Sets [Builder.probability] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.probability] with a well-typed [Double]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun probability(probability: JsonField<Double>) = apply {
                        this.probability = probability
                    }

                    /**
                     * Choice values are typed: a string and a boolean with the same text are
                     * distinct.
                     */
                    fun value(value: DecisionChoiceValue) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed
                     * [DecisionChoiceValue] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun value(value: JsonField<DecisionChoiceValue>) = apply { this.value = value }

                    /** Alias for calling [value] with `DecisionChoiceValue.ofString(string)`. */
                    fun value(string: String) = value(DecisionChoiceValue.ofString(string))

                    /** Alias for calling [value] with `DecisionChoiceValue.ofBool(bool)`. */
                    fun value(bool: Boolean) = value(DecisionChoiceValue.ofBool(bool))

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
                     * Returns an immutable instance of [Probability].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .probability()
                     * .value()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Probability =
                        Probability(
                            checkRequired("probability", probability),
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Probability = apply {
                    if (validated) {
                        return@apply
                    }

                    probability()
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
                    (if (probability.asKnown().isPresent) 1 else 0) +
                        (value.asKnown().getOrNull()?.validity() ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Probability &&
                        probability == other.probability &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(probability, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Probability{probability=$probability, value=$value, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Choice &&
                    choice == other.choice &&
                    confidence == other.confidence &&
                    name == other.name &&
                    probabilities == other.probabilities &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(choice, confidence, name, probabilities, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Choice{choice=$choice, confidence=$confidence, name=$name, probabilities=$probabilities, type=$type, additionalProperties=$additionalProperties}"
        }

        class Score
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val confidence: JsonField<Double>,
            private val name: JsonField<String>,
            private val probabilities: JsonField<List<Probability>>,
            private val score: JsonField<Double>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("confidence")
                @ExcludeMissing
                confidence: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("probabilities")
                @ExcludeMissing
                probabilities: JsonField<List<Probability>> = JsonMissing.of(),
                @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(confidence, name, probabilities, score, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun confidence(): Double = confidence.getRequired("confidence")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun probabilities(): List<Probability> = probabilities.getRequired("probabilities")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun score(): Double = score.getRequired("score")

            /**
             * The type of the object. Always `score`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("score")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [confidence].
             *
             * Unlike [confidence], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("confidence")
            @ExcludeMissing
            fun _confidence(): JsonField<Double> = confidence

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [probabilities].
             *
             * Unlike [probabilities], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("probabilities")
            @ExcludeMissing
            fun _probabilities(): JsonField<List<Probability>> = probabilities

            /**
             * Returns the raw JSON value of [score].
             *
             * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

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
                 * Returns a mutable builder for constructing an instance of [Score].
                 *
                 * The following fields are required:
                 * ```java
                 * .confidence()
                 * .name()
                 * .probabilities()
                 * .score()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Score]. */
            class Builder internal constructor() {

                private var confidence: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var probabilities: JsonField<MutableList<Probability>>? = null
                private var score: JsonField<Double>? = null
                private var type: JsonValue = JsonValue.from("score")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(score: Score) = apply {
                    confidence = score.confidence
                    name = score.name
                    probabilities = score.probabilities.map { it.toMutableList() }
                    this.score = score.score
                    type = score.type
                    additionalProperties = score.additionalProperties.toMutableMap()
                }

                fun confidence(confidence: Double) = confidence(JsonField.of(confidence))

                /**
                 * Sets [Builder.confidence] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.confidence] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun confidence(confidence: JsonField<Double>) = apply {
                    this.confidence = confidence
                }

                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun probabilities(probabilities: List<Probability>) =
                    probabilities(JsonField.of(probabilities))

                /**
                 * Sets [Builder.probabilities] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.probabilities] with a well-typed
                 * `List<Probability>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun probabilities(probabilities: JsonField<List<Probability>>) = apply {
                    this.probabilities = probabilities.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Probability] to [probabilities].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addProbability(probability: Probability) = apply {
                    probabilities =
                        (probabilities ?: JsonField.of(mutableListOf())).also {
                            checkKnown("probabilities", it).add(probability)
                        }
                }

                fun score(score: Double) = score(JsonField.of(score))

                /**
                 * Sets [Builder.score] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.score] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun score(score: JsonField<Double>) = apply { this.score = score }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("score")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Score].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .confidence()
                 * .name()
                 * .probabilities()
                 * .score()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Score =
                    Score(
                        checkRequired("confidence", confidence),
                        checkRequired("name", name),
                        checkRequired("probabilities", probabilities).map { it.toImmutable() },
                        checkRequired("score", score),
                        type,
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
            fun validate(): Score = apply {
                if (validated) {
                    return@apply
                }

                confidence()
                name()
                probabilities().forEach { it.validate() }
                score()
                _type().let {
                    if (it != JsonValue.from("score")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (if (confidence.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (probabilities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (score.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("score")) 1 else 0 }

            class Probability
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val label: JsonField<String>,
                private val probability: JsonField<Double>,
                private val value: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("label")
                    @ExcludeMissing
                    label: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("probability")
                    @ExcludeMissing
                    probability: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("value") @ExcludeMissing value: JsonField<Long> = JsonMissing.of(),
                ) : this(label, probability, value, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun label(): String = label.getRequired("label")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun probability(): Double = probability.getRequired("probability")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun value(): Long = value.getRequired("value")

                /**
                 * Returns the raw JSON value of [label].
                 *
                 * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                /**
                 * Returns the raw JSON value of [probability].
                 *
                 * Unlike [probability], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("probability")
                @ExcludeMissing
                fun _probability(): JsonField<Double> = probability

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Long> = value

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
                     * Returns a mutable builder for constructing an instance of [Probability].
                     *
                     * The following fields are required:
                     * ```java
                     * .label()
                     * .probability()
                     * .value()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Probability]. */
                class Builder internal constructor() {

                    private var label: JsonField<String>? = null
                    private var probability: JsonField<Double>? = null
                    private var value: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(probability: Probability) = apply {
                        label = probability.label
                        this.probability = probability.probability
                        value = probability.value
                        additionalProperties = probability.additionalProperties.toMutableMap()
                    }

                    fun label(label: String) = label(JsonField.of(label))

                    /**
                     * Sets [Builder.label] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.label] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun label(label: JsonField<String>) = apply { this.label = label }

                    fun probability(probability: Double) = probability(JsonField.of(probability))

                    /**
                     * Sets [Builder.probability] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.probability] with a well-typed [Double]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun probability(probability: JsonField<Double>) = apply {
                        this.probability = probability
                    }

                    fun value(value: Long) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Long>) = apply { this.value = value }

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
                     * Returns an immutable instance of [Probability].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .label()
                     * .probability()
                     * .value()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Probability =
                        Probability(
                            checkRequired("label", label),
                            checkRequired("probability", probability),
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Probability = apply {
                    if (validated) {
                        return@apply
                    }

                    label()
                    probability()
                    value()
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
                    (if (label.asKnown().isPresent) 1 else 0) +
                        (if (probability.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Probability &&
                        label == other.label &&
                        probability == other.probability &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(label, probability, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Probability{label=$label, probability=$probability, value=$value, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Score &&
                    confidence == other.confidence &&
                    name == other.name &&
                    probabilities == other.probabilities &&
                    score == other.score &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(confidence, name, probabilities, score, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Score{confidence=$confidence, name=$name, probabilities=$probabilities, score=$score, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * The model declined to answer this question. Other questions in the same request can still
         * receive answers.
         */
        class Refusal
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(name, type, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * The type of the object. Always `refusal`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("refusal")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
                 * Returns a mutable builder for constructing an instance of [Refusal].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Refusal]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("refusal")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(refusal: Refusal) = apply {
                    name = refusal.name
                    type = refusal.type
                    additionalProperties = refusal.additionalProperties.toMutableMap()
                }

                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("refusal")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Refusal].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Refusal =
                    Refusal(checkRequired("name", name), type, additionalProperties.toMutableMap())
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
            fun validate(): Refusal = apply {
                if (validated) {
                    return@apply
                }

                name()
                _type().let {
                    if (it != JsonValue.from("refusal")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("refusal")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Refusal &&
                    name == other.name &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Refusal{name=$name, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    class Usage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val inputTokens: JsonField<Long>,
        private val inputTokensDetails: JsonField<InputTokensDetails>,
        private val outputTokens: JsonField<Long>,
        private val outputTokensDetails: JsonField<OutputTokensDetails>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input_tokens")
            @ExcludeMissing
            inputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("input_tokens_details")
            @ExcludeMissing
            inputTokensDetails: JsonField<InputTokensDetails> = JsonMissing.of(),
            @JsonProperty("output_tokens")
            @ExcludeMissing
            outputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("output_tokens_details")
            @ExcludeMissing
            outputTokensDetails: JsonField<OutputTokensDetails> = JsonMissing.of(),
            @JsonProperty("total_tokens")
            @ExcludeMissing
            totalTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(
            inputTokens,
            inputTokensDetails,
            outputTokens,
            outputTokensDetails,
            totalTokens,
            mutableMapOf(),
        )

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokensDetails(): InputTokensDetails =
            inputTokensDetails.getRequired("input_tokens_details")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputTokensDetails(): OutputTokensDetails =
            outputTokensDetails.getRequired("output_tokens_details")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /**
         * Returns the raw JSON value of [inputTokens].
         *
         * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input_tokens")
        @ExcludeMissing
        fun _inputTokens(): JsonField<Long> = inputTokens

        /**
         * Returns the raw JSON value of [inputTokensDetails].
         *
         * Unlike [inputTokensDetails], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("input_tokens_details")
        @ExcludeMissing
        fun _inputTokensDetails(): JsonField<InputTokensDetails> = inputTokensDetails

        /**
         * Returns the raw JSON value of [outputTokens].
         *
         * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_tokens")
        @ExcludeMissing
        fun _outputTokens(): JsonField<Long> = outputTokens

        /**
         * Returns the raw JSON value of [outputTokensDetails].
         *
         * Unlike [outputTokensDetails], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("output_tokens_details")
        @ExcludeMissing
        fun _outputTokensDetails(): JsonField<OutputTokensDetails> = outputTokensDetails

        /**
         * Returns the raw JSON value of [totalTokens].
         *
         * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun _totalTokens(): JsonField<Long> = totalTokens

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
             * Returns a mutable builder for constructing an instance of [Usage].
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .outputTokensDetails()
             * .totalTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Usage]. */
        class Builder internal constructor() {

            private var inputTokens: JsonField<Long>? = null
            private var inputTokensDetails: JsonField<InputTokensDetails>? = null
            private var outputTokens: JsonField<Long>? = null
            private var outputTokensDetails: JsonField<OutputTokensDetails>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                inputTokens = usage.inputTokens
                inputTokensDetails = usage.inputTokensDetails
                outputTokens = usage.outputTokens
                outputTokensDetails = usage.outputTokensDetails
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

            /**
             * Sets [Builder.inputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

            fun inputTokensDetails(inputTokensDetails: InputTokensDetails) =
                inputTokensDetails(JsonField.of(inputTokensDetails))

            /**
             * Sets [Builder.inputTokensDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokensDetails] with a well-typed
             * [InputTokensDetails] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun inputTokensDetails(inputTokensDetails: JsonField<InputTokensDetails>) = apply {
                this.inputTokensDetails = inputTokensDetails
            }

            fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

            /**
             * Sets [Builder.outputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokens(outputTokens: JsonField<Long>) = apply {
                this.outputTokens = outputTokens
            }

            fun outputTokensDetails(outputTokensDetails: OutputTokensDetails) =
                outputTokensDetails(JsonField.of(outputTokensDetails))

            /**
             * Sets [Builder.outputTokensDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokensDetails] with a well-typed
             * [OutputTokensDetails] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun outputTokensDetails(outputTokensDetails: JsonField<OutputTokensDetails>) = apply {
                this.outputTokensDetails = outputTokensDetails
            }

            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /**
             * Sets [Builder.totalTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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
             * Returns an immutable instance of [Usage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .outputTokensDetails()
             * .totalTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Usage =
                Usage(
                    checkRequired("inputTokens", inputTokens),
                    checkRequired("inputTokensDetails", inputTokensDetails),
                    checkRequired("outputTokens", outputTokens),
                    checkRequired("outputTokensDetails", outputTokensDetails),
                    checkRequired("totalTokens", totalTokens),
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
        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            inputTokens()
            inputTokensDetails().validate()
            outputTokens()
            outputTokensDetails().validate()
            totalTokens()
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
            (if (inputTokens.asKnown().isPresent) 1 else 0) +
                (inputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputTokens.asKnown().isPresent) 1 else 0) +
                (outputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalTokens.asKnown().isPresent) 1 else 0)

        class InputTokensDetails
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cacheWriteTokens: JsonField<Long>,
            private val cachedTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cache_write_tokens")
                @ExcludeMissing
                cacheWriteTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("cached_tokens")
                @ExcludeMissing
                cachedTokens: JsonField<Long> = JsonMissing.of(),
            ) : this(cacheWriteTokens, cachedTokens, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cacheWriteTokens(): Long = cacheWriteTokens.getRequired("cache_write_tokens")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cachedTokens(): Long = cachedTokens.getRequired("cached_tokens")

            /**
             * Returns the raw JSON value of [cacheWriteTokens].
             *
             * Unlike [cacheWriteTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("cache_write_tokens")
            @ExcludeMissing
            fun _cacheWriteTokens(): JsonField<Long> = cacheWriteTokens

            /**
             * Returns the raw JSON value of [cachedTokens].
             *
             * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            fun _cachedTokens(): JsonField<Long> = cachedTokens

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
                 * Returns a mutable builder for constructing an instance of [InputTokensDetails].
                 *
                 * The following fields are required:
                 * ```java
                 * .cacheWriteTokens()
                 * .cachedTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [InputTokensDetails]. */
            class Builder internal constructor() {

                private var cacheWriteTokens: JsonField<Long>? = null
                private var cachedTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(inputTokensDetails: InputTokensDetails) = apply {
                    cacheWriteTokens = inputTokensDetails.cacheWriteTokens
                    cachedTokens = inputTokensDetails.cachedTokens
                    additionalProperties = inputTokensDetails.additionalProperties.toMutableMap()
                }

                fun cacheWriteTokens(cacheWriteTokens: Long) =
                    cacheWriteTokens(JsonField.of(cacheWriteTokens))

                /**
                 * Sets [Builder.cacheWriteTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cacheWriteTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cacheWriteTokens(cacheWriteTokens: JsonField<Long>) = apply {
                    this.cacheWriteTokens = cacheWriteTokens
                }

                fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

                /**
                 * Sets [Builder.cachedTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cachedTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                    this.cachedTokens = cachedTokens
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
                 * Returns an immutable instance of [InputTokensDetails].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .cacheWriteTokens()
                 * .cachedTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): InputTokensDetails =
                    InputTokensDetails(
                        checkRequired("cacheWriteTokens", cacheWriteTokens),
                        checkRequired("cachedTokens", cachedTokens),
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
            fun validate(): InputTokensDetails = apply {
                if (validated) {
                    return@apply
                }

                cacheWriteTokens()
                cachedTokens()
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
                (if (cacheWriteTokens.asKnown().isPresent) 1 else 0) +
                    (if (cachedTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is InputTokensDetails &&
                    cacheWriteTokens == other.cacheWriteTokens &&
                    cachedTokens == other.cachedTokens &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(cacheWriteTokens, cachedTokens, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "InputTokensDetails{cacheWriteTokens=$cacheWriteTokens, cachedTokens=$cachedTokens, additionalProperties=$additionalProperties}"
        }

        class OutputTokensDetails
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val reasoningTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("reasoning_tokens")
                @ExcludeMissing
                reasoningTokens: JsonField<Long> = JsonMissing.of()
            ) : this(reasoningTokens, mutableMapOf())

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reasoningTokens(): Long = reasoningTokens.getRequired("reasoning_tokens")

            /**
             * Returns the raw JSON value of [reasoningTokens].
             *
             * Unlike [reasoningTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("reasoning_tokens")
            @ExcludeMissing
            fun _reasoningTokens(): JsonField<Long> = reasoningTokens

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
                 * Returns a mutable builder for constructing an instance of [OutputTokensDetails].
                 *
                 * The following fields are required:
                 * ```java
                 * .reasoningTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [OutputTokensDetails]. */
            class Builder internal constructor() {

                private var reasoningTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(outputTokensDetails: OutputTokensDetails) = apply {
                    reasoningTokens = outputTokensDetails.reasoningTokens
                    additionalProperties = outputTokensDetails.additionalProperties.toMutableMap()
                }

                fun reasoningTokens(reasoningTokens: Long) =
                    reasoningTokens(JsonField.of(reasoningTokens))

                /**
                 * Sets [Builder.reasoningTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reasoningTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reasoningTokens(reasoningTokens: JsonField<Long>) = apply {
                    this.reasoningTokens = reasoningTokens
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
                 * Returns an immutable instance of [OutputTokensDetails].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .reasoningTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): OutputTokensDetails =
                    OutputTokensDetails(
                        checkRequired("reasoningTokens", reasoningTokens),
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
            fun validate(): OutputTokensDetails = apply {
                if (validated) {
                    return@apply
                }

                reasoningTokens()
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
            internal fun validity(): Int = (if (reasoningTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is OutputTokensDetails &&
                    reasoningTokens == other.reasoningTokens &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(reasoningTokens, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "OutputTokensDetails{reasoningTokens=$reasoningTokens, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                inputTokens == other.inputTokens &&
                inputTokensDetails == other.inputTokensDetails &&
                outputTokens == other.outputTokens &&
                outputTokensDetails == other.outputTokensDetails &&
                totalTokens == other.totalTokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                inputTokens,
                inputTokensDetails,
                outputTokens,
                outputTokensDetails,
                totalTokens,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{inputTokens=$inputTokens, inputTokensDetails=$inputTokensDetails, outputTokens=$outputTokens, outputTokensDetails=$outputTokensDetails, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Decision &&
            answers == other.answers &&
            model == other.model &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(answers, model, usage, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Decision{answers=$answers, model=$model, usage=$usage, additionalProperties=$additionalProperties}"
}
