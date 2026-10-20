// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.decisions.DecisionChoiceOption
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class DecisionTrigger
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val decisions: JsonField<Decisions>,
    private val eventType: JsonField<EventType>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("decisions")
        @ExcludeMissing
        decisions: JsonField<Decisions> = JsonMissing.of(),
        @JsonProperty("event_type")
        @ExcludeMissing
        eventType: JsonField<EventType> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(decisions, eventType, type, mutableMapOf())

    /**
     * Questions evaluated using the current transcript and the session's shared Decision items.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun decisions(): Decisions = decisions.getRequired("decisions")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventType(): EventType = eventType.getRequired("event_type")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("decisions")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [decisions].
     *
     * Unlike [decisions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("decisions") @ExcludeMissing fun _decisions(): JsonField<Decisions> = decisions

    /**
     * Returns the raw JSON value of [eventType].
     *
     * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_type") @ExcludeMissing fun _eventType(): JsonField<EventType> = eventType

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
            "decisions" to this.decisions,
            "event_type" to this.eventType,
            "type" to this.type,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DecisionTrigger].
         *
         * The following fields are required:
         * ```java
         * .decisions()
         * .eventType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionTrigger]. */
    class Builder internal constructor() {

        private var decisions: JsonField<Decisions>? = null
        private var eventType: JsonField<EventType>? = null
        private var type: JsonValue = JsonValue.from("decisions")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionTrigger: DecisionTrigger) = apply {
            decisions = decisionTrigger.decisions
            eventType = decisionTrigger.eventType
            type = decisionTrigger.type
            additionalProperties = decisionTrigger.additionalProperties.toMutableMap()
        }

        /**
         * Questions evaluated using the current transcript and the session's shared Decision items.
         */
        fun decisions(decisions: Decisions) = decisions(JsonField.of(decisions))

        /**
         * Sets [Builder.decisions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.decisions] with a well-typed [Decisions] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun decisions(decisions: JsonField<Decisions>) = apply { this.decisions = decisions }

        /**
         * Alias for calling [decisions] with the following:
         * ```java
         * Decisions.builder()
         *     .questions(questions)
         *     .build()
         * ```
         */
        fun questionsDecisions(questions: List<Decisions.Question>) =
            decisions(Decisions.builder().questions(questions).build())

        fun eventType(eventType: EventType) = eventType(JsonField.of(eventType))

        /**
         * Sets [Builder.eventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventType] with a well-typed [EventType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun eventType(eventType: JsonField<EventType>) = apply { this.eventType = eventType }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("decisions")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [DecisionTrigger].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .decisions()
         * .eventType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionTrigger =
            DecisionTrigger(
                checkRequired("decisions", decisions),
                checkRequired("eventType", eventType),
                type,
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
    fun validate(): DecisionTrigger = apply {
        if (validated) {
            return@apply
        }

        decisions().validate()
        eventType().validate()
        _type().let {
            if (it != JsonValue.from("decisions")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (decisions.asKnown().getOrNull()?.validity() ?: 0) +
            (eventType.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("decisions")) 1 else 0 }

    /** Questions evaluated using the current transcript and the session's shared Decision items. */
    class Decisions
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val questions: JsonField<List<Question>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("questions")
            @ExcludeMissing
            questions: JsonField<List<Question>> = JsonMissing.of()
        ) : this(questions, mutableMapOf())

        /**
         * Native Decision API questions evaluated together, in order.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun questions(): List<Question> = questions.getRequired("questions")

        /**
         * Returns the raw JSON value of [questions].
         *
         * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("questions")
        @ExcludeMissing
        fun _questions(): JsonField<List<Question>> = questions

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
            collectAllProperties(additionalProperties, "questions" to this.questions)

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Decisions].
             *
             * The following fields are required:
             * ```java
             * .questions()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Decisions]. */
        class Builder internal constructor() {

            private var questions: JsonField<MutableList<Question>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(decisions: Decisions) = apply {
                questions = decisions.questions.map { it.toMutableList() }
                additionalProperties = decisions.additionalProperties.toMutableMap()
            }

            /** Native Decision API questions evaluated together, in order. */
            fun questions(questions: List<Question>) = questions(JsonField.of(questions))

            /**
             * Sets [Builder.questions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.questions] with a well-typed `List<Question>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun questions(questions: JsonField<List<Question>>) = apply {
                this.questions = questions.map { it.toMutableList() }
            }

            /**
             * Adds a single [Question] to [questions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQuestion(question: Question) = apply {
                questions =
                    (questions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("questions", it).add(question)
                    }
            }

            /** Alias for calling [addQuestion] with `Question.ofPredicate(predicate)`. */
            fun addQuestion(predicate: Question.Predicate) =
                addQuestion(Question.ofPredicate(predicate))

            /**
             * Alias for calling [addQuestion] with the following:
             * ```java
             * Question.Predicate.builder()
             *     .instructions(instructions)
             *     .build()
             * ```
             */
            fun addPredicateQuestion(instructions: String) =
                addQuestion(Question.Predicate.builder().instructions(instructions).build())

            /** Alias for calling [addQuestion] with `Question.ofChoice(choice)`. */
            fun addQuestion(choice: Question.Choice) = addQuestion(Question.ofChoice(choice))

            /** Alias for calling [addQuestion] with `Question.ofScore(score)`. */
            fun addQuestion(score: Question.Score) = addQuestion(Question.ofScore(score))

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
             * Returns an immutable instance of [Decisions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .questions()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Decisions =
                Decisions(
                    checkRequired("questions", questions).map { it.toImmutable() },
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
        fun validate(): Decisions = apply {
            if (validated) {
                return@apply
            }

            questions().forEach { it.validate() }
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
            (questions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** A question about the request's input, with an optional correlation name. */
        @JsonDeserialize(using = Question.Deserializer::class)
        @JsonSerialize(using = Question.Serializer::class)
        class Question
        private constructor(
            private val predicate: Predicate? = null,
            private val choice: Choice? = null,
            private val score: Score? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Estimate how likely it is that a statement about the input is true. */
            fun predicate(): Optional<Predicate> = Optional.ofNullable(predicate)

            /** Choose from the supplied options based on the input. */
            fun choice(): Optional<Choice> = Optional.ofNullable(choice)

            /** Rate the input against the supplied ordered levels. */
            fun score(): Optional<Score> = Optional.ofNullable(score)

            fun isPredicate(): Boolean = predicate != null

            fun isChoice(): Boolean = choice != null

            fun isScore(): Boolean = score != null

            /** Estimate how likely it is that a statement about the input is true. */
            fun asPredicate(): Predicate = predicate.getOrThrow("predicate")

            /** Choose from the supplied options based on the input. */
            fun asChoice(): Choice = choice.getOrThrow("choice")

            /** Rate the input against the supplied ordered levels. */
            fun asScore(): Score = score.getOrThrow("score")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = question.accept(new Question.Visitor<Optional<String>>() {
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    predicate != null -> visitor.visitPredicate(predicate)
                    choice != null -> visitor.visitChoice(choice)
                    score != null -> visitor.visitScore(score)
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Question = apply {
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

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Question &&
                    predicate == other.predicate &&
                    choice == other.choice &&
                    score == other.score
            }

            override fun hashCode(): Int = Objects.hash(predicate, choice, score)

            override fun toString(): String =
                when {
                    predicate != null -> "Question{predicate=$predicate}"
                    choice != null -> "Question{choice=$choice}"
                    score != null -> "Question{score=$score}"
                    _json != null -> "Question{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Question")
                }

            companion object {

                /** Estimate how likely it is that a statement about the input is true. */
                @JvmStatic fun ofPredicate(predicate: Predicate) = Question(predicate = predicate)

                /** Choose from the supplied options based on the input. */
                @JvmStatic fun ofChoice(choice: Choice) = Question(choice = choice)

                /** Rate the input against the supplied ordered levels. */
                @JvmStatic fun ofScore(score: Score) = Question(score = score)
            }

            /**
             * An interface that defines how to map each variant of [Question] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** Estimate how likely it is that a statement about the input is true. */
                fun visitPredicate(predicate: Predicate): T

                /** Choose from the supplied options based on the input. */
                fun visitChoice(choice: Choice): T

                /** Rate the input against the supplied ordered levels. */
                fun visitScore(score: Score): T

                /**
                 * Maps an unknown variant of [Question] to a value of type [T].
                 *
                 * An instance of [Question] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Question")
                }
            }

            internal class Deserializer : BaseDeserializer<Question>(Question::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Question {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "predicate" -> {
                            return tryDeserialize(node, jacksonTypeRef<Predicate>())?.let {
                                Question(predicate = it, _json = json)
                            } ?: Question(_json = json)
                        }
                        "choice" -> {
                            return tryDeserialize(node, jacksonTypeRef<Choice>())?.let {
                                Question(choice = it, _json = json)
                            } ?: Question(_json = json)
                        }
                        "score" -> {
                            return tryDeserialize(node, jacksonTypeRef<Score>())?.let {
                                Question(score = it, _json = json)
                            } ?: Question(_json = json)
                        }
                    }

                    return Question(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Question>(Question::class) {

                override fun serialize(
                    value: Question,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.predicate != null -> generator.writeObject(value.predicate)
                        value.choice != null -> generator.writeObject(value.choice)
                        value.score != null -> generator.writeObject(value.score)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Question")
                    }
                }
            }

            /** Estimate how likely it is that a statement about the input is true. */
            class Predicate
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val instructions: JsonField<String>,
                private val type: JsonValue,
                private val name: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("instructions")
                    @ExcludeMissing
                    instructions: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                ) : this(instructions, type, name, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun instructions(): String = instructions.getRequired("instructions")

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
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Returns the raw JSON value of [instructions].
                 *
                 * Unlike [instructions], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("instructions")
                @ExcludeMissing
                fun _instructions(): JsonField<String> = instructions

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "instructions" to this.instructions,
                        "type" to this.type,
                        "name" to this.name,
                    )

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
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
                     * .instructions()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Predicate]. */
                class Builder internal constructor() {

                    private var instructions: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("predicate")
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(predicate: Predicate) = apply {
                        instructions = predicate.instructions
                        type = predicate.type
                        name = predicate.name
                        additionalProperties = predicate.additionalProperties.toMutableMap()
                    }

                    fun instructions(instructions: String) =
                        instructions(JsonField.of(instructions))

                    /**
                     * Sets [Builder.instructions] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.instructions] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun instructions(instructions: JsonField<String>) = apply {
                        this.instructions = instructions
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("predicate")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

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
                     * .instructions()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Predicate =
                        Predicate(
                            checkRequired("instructions", instructions),
                            type,
                            name,
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
                fun validate(): Predicate = apply {
                    if (validated) {
                        return@apply
                    }

                    instructions()
                    _type().let {
                        if (it != JsonValue.from("predicate")) {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (instructions.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("predicate")) 1 else 0 } +
                        (if (name.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Predicate &&
                        instructions == other.instructions &&
                        type == other.type &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(instructions, type, name, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Predicate{instructions=$instructions, type=$type, name=$name, additionalProperties=$additionalProperties}"
            }

            /** Choose from the supplied options based on the input. */
            class Choice
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val choices: JsonField<List<DecisionChoiceOption>>,
                private val instructions: JsonField<String>,
                private val type: JsonValue,
                private val name: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("choices")
                    @ExcludeMissing
                    choices: JsonField<List<DecisionChoiceOption>> = JsonMissing.of(),
                    @JsonProperty("instructions")
                    @ExcludeMissing
                    instructions: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                ) : this(choices, instructions, type, name, mutableMapOf())

                /**
                 * Provide between 2 and 255 choices. Each choice must be unique.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun choices(): List<DecisionChoiceOption> = choices.getRequired("choices")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun instructions(): String = instructions.getRequired("instructions")

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
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Returns the raw JSON value of [choices].
                 *
                 * Unlike [choices], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("choices")
                @ExcludeMissing
                fun _choices(): JsonField<List<DecisionChoiceOption>> = choices

                /**
                 * Returns the raw JSON value of [instructions].
                 *
                 * Unlike [instructions], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("instructions")
                @ExcludeMissing
                fun _instructions(): JsonField<String> = instructions

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "choices" to this.choices,
                        "instructions" to this.instructions,
                        "type" to this.type,
                        "name" to this.name,
                    )

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
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
                     * .choices()
                     * .instructions()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Choice]. */
                class Builder internal constructor() {

                    private var choices: JsonField<MutableList<DecisionChoiceOption>>? = null
                    private var instructions: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("choice")
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(choice: Choice) = apply {
                        choices = choice.choices.map { it.toMutableList() }
                        instructions = choice.instructions
                        type = choice.type
                        name = choice.name
                        additionalProperties = choice.additionalProperties.toMutableMap()
                    }

                    /** Provide between 2 and 255 choices. Each choice must be unique. */
                    fun choices(choices: List<DecisionChoiceOption>) =
                        choices(JsonField.of(choices))

                    /**
                     * Sets [Builder.choices] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.choices] with a well-typed
                     * `List<DecisionChoiceOption>` value instead. This method is primarily for
                     * setting the field to an undocumented or not yet supported value.
                     */
                    fun choices(choices: JsonField<List<DecisionChoiceOption>>) = apply {
                        this.choices = choices.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [DecisionChoiceOption] to [choices].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addChoice(choice: DecisionChoiceOption) = apply {
                        choices =
                            (choices ?: JsonField.of(mutableListOf())).also {
                                checkKnown("choices", it).add(choice)
                            }
                    }

                    fun instructions(instructions: String) =
                        instructions(JsonField.of(instructions))

                    /**
                     * Sets [Builder.instructions] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.instructions] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun instructions(instructions: JsonField<String>) = apply {
                        this.instructions = instructions
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("choice")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

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
                     * .choices()
                     * .instructions()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Choice =
                        Choice(
                            checkRequired("choices", choices).map { it.toImmutable() },
                            checkRequired("instructions", instructions),
                            type,
                            name,
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
                fun validate(): Choice = apply {
                    if (validated) {
                        return@apply
                    }

                    choices().forEach { it.validate() }
                    instructions()
                    _type().let {
                        if (it != JsonValue.from("choice")) {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (choices.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                        (if (instructions.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("choice")) 1 else 0 } +
                        (if (name.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Choice &&
                        choices == other.choices &&
                        instructions == other.instructions &&
                        type == other.type &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(choices, instructions, type, name, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Choice{choices=$choices, instructions=$instructions, type=$type, name=$name, additionalProperties=$additionalProperties}"
            }

            /** Rate the input against the supplied ordered levels. */
            class Score
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val instructions: JsonField<String>,
                private val levels: JsonField<List<Level>>,
                private val type: JsonValue,
                private val name: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("instructions")
                    @ExcludeMissing
                    instructions: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("levels")
                    @ExcludeMissing
                    levels: JsonField<List<Level>> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                ) : this(instructions, levels, type, name, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun instructions(): String = instructions.getRequired("instructions")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun levels(): List<Level> = levels.getRequired("levels")

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
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Returns the raw JSON value of [instructions].
                 *
                 * Unlike [instructions], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("instructions")
                @ExcludeMissing
                fun _instructions(): JsonField<String> = instructions

                /**
                 * Returns the raw JSON value of [levels].
                 *
                 * Unlike [levels], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("levels")
                @ExcludeMissing
                fun _levels(): JsonField<List<Level>> = levels

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "instructions" to this.instructions,
                        "levels" to this.levels,
                        "type" to this.type,
                        "name" to this.name,
                    )

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
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
                     * .instructions()
                     * .levels()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Score]. */
                class Builder internal constructor() {

                    private var instructions: JsonField<String>? = null
                    private var levels: JsonField<MutableList<Level>>? = null
                    private var type: JsonValue = JsonValue.from("score")
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(score: Score) = apply {
                        instructions = score.instructions
                        levels = score.levels.map { it.toMutableList() }
                        type = score.type
                        name = score.name
                        additionalProperties = score.additionalProperties.toMutableMap()
                    }

                    fun instructions(instructions: String) =
                        instructions(JsonField.of(instructions))

                    /**
                     * Sets [Builder.instructions] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.instructions] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun instructions(instructions: JsonField<String>) = apply {
                        this.instructions = instructions
                    }

                    fun levels(levels: List<Level>) = levels(JsonField.of(levels))

                    /**
                     * Sets [Builder.levels] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.levels] with a well-typed `List<Level>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun levels(levels: JsonField<List<Level>>) = apply {
                        this.levels = levels.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Level] to [levels].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addLevel(level: Level) = apply {
                        levels =
                            (levels ?: JsonField.of(mutableListOf())).also {
                                checkKnown("levels", it).add(level)
                            }
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("score")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

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
                     * .instructions()
                     * .levels()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Score =
                        Score(
                            checkRequired("instructions", instructions),
                            checkRequired("levels", levels).map { it.toImmutable() },
                            type,
                            name,
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
                fun validate(): Score = apply {
                    if (validated) {
                        return@apply
                    }

                    instructions()
                    levels().forEach { it.validate() }
                    _type().let {
                        if (it != JsonValue.from("score")) {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (instructions.asKnown().isPresent) 1 else 0) +
                        (levels.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                        type.let { if (it == JsonValue.from("score")) 1 else 0 } +
                        (if (name.asKnown().isPresent) 1 else 0)

                class Level
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val label: JsonField<String>,
                    private val description: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("label")
                        @ExcludeMissing
                        label: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("description")
                        @ExcludeMissing
                        description: JsonField<String> = JsonMissing.of(),
                    ) : this(label, description, mutableMapOf())

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun label(): String = label.getRequired("label")

                    /**
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun description(): Optional<String> = description.getOptional("description")

                    /**
                     * Returns the raw JSON value of [label].
                     *
                     * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                    /**
                     * Returns the raw JSON value of [description].
                     *
                     * Unlike [description], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("description")
                    @ExcludeMissing
                    fun _description(): JsonField<String> = description

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "label" to this.label,
                            "description" to this.description,
                        )

                    /**
                     * Returns the legacy additional-properties view.
                     *
                     * @deprecated Use [_allProperties] to access both declared and additional JSON
                     *   properties. This accessor retains its legacy additional-properties
                     *   behavior.
                     */
                    @Deprecated(
                        "Use _allProperties() to access both declared and additional JSON properties."
                    )
                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [Level].
                         *
                         * The following fields are required:
                         * ```java
                         * .label()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Level]. */
                    class Builder internal constructor() {

                        private var label: JsonField<String>? = null
                        private var description: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(level: Level) = apply {
                            label = level.label
                            description = level.description
                            additionalProperties = level.additionalProperties.toMutableMap()
                        }

                        fun label(label: String) = label(JsonField.of(label))

                        /**
                         * Sets [Builder.label] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.label] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun label(label: JsonField<String>) = apply { this.label = label }

                        fun description(description: String) =
                            description(JsonField.of(description))

                        /**
                         * Sets [Builder.description] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.description] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun description(description: JsonField<String>) = apply {
                            this.description = description
                        }

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
                         * Returns an immutable instance of [Level].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .label()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Level =
                            Level(
                                checkRequired("label", label),
                                description,
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
                    fun validate(): Level = apply {
                        if (validated) {
                            return@apply
                        }

                        label()
                        description()
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
                            (if (description.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Level &&
                            label == other.label &&
                            description == other.description &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(label, description, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Level{label=$label, description=$description, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Score &&
                        instructions == other.instructions &&
                        levels == other.levels &&
                        type == other.type &&
                        name == other.name &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(instructions, levels, type, name, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Score{instructions=$instructions, levels=$levels, type=$type, name=$name, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Decisions &&
                questions == other.questions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(questions, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Decisions{questions=$questions, additionalProperties=$additionalProperties}"
    }

    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SESSION_INPUT_TRANSCRIPT_DELTA = of("session.input_transcript.delta")

            @JvmField val SESSION_OUTPUT_TRANSCRIPT_DELTA = of("session.output_transcript.delta")

            @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
        }

        /** An enum containing [EventType]'s known values. */
        enum class Known {
            SESSION_INPUT_TRANSCRIPT_DELTA,
            SESSION_OUTPUT_TRANSCRIPT_DELTA,
        }

        /**
         * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EventType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SESSION_INPUT_TRANSCRIPT_DELTA,
            SESSION_OUTPUT_TRANSCRIPT_DELTA,
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
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
                SESSION_INPUT_TRANSCRIPT_DELTA -> Value.SESSION_INPUT_TRANSCRIPT_DELTA
                SESSION_OUTPUT_TRANSCRIPT_DELTA -> Value.SESSION_OUTPUT_TRANSCRIPT_DELTA
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
                SESSION_INPUT_TRANSCRIPT_DELTA -> Known.SESSION_INPUT_TRANSCRIPT_DELTA
                SESSION_OUTPUT_TRANSCRIPT_DELTA -> Known.SESSION_OUTPUT_TRANSCRIPT_DELTA
                else -> throw OpenAIInvalidDataException("Unknown EventType: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): EventType = apply {
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

            return other is EventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionTrigger &&
            decisions == other.decisions &&
            eventType == other.eventType &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(decisions, eventType, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionTrigger{decisions=$decisions, eventType=$eventType, type=$type, additionalProperties=$additionalProperties}"
}
