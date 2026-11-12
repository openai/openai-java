// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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
     * Questions evaluated using the current transcript and the session's shared Decision items. The
     * schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun decisions(): java.util.Optional<Decisions> = decisions.getOptional("decisions")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun decisionsOrThrow(): Decisions = decisions.getRequired("decisions")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventType(): java.util.Optional<EventType> = eventType.getOptional("event_type")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventTypeOrThrow(): EventType = eventType.getRequired("event_type")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("decisions")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
        fun questionsDecisions(questions: List<DecisionQuestion>) =
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

        decisionsOrThrow().validate()
        eventTypeOrThrow().validate()
        typeOrThrow()
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
        private val questions: JsonField<List<DecisionQuestion>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("questions")
            @ExcludeMissing
            questions: JsonField<List<DecisionQuestion>> = JsonMissing.of()
        ) : this(questions, mutableMapOf())

        /**
         * Native Decision API questions evaluated together, in order. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun questions(): java.util.Optional<List<DecisionQuestion>> =
            questions.getOptional("questions")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun questionsOrThrow(): List<DecisionQuestion> = questions.getRequired("questions")

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
            collectAllProperties(additionalProperties, "questions" to this.questions)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            private var questions: JsonField<MutableList<DecisionQuestion>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(decisions: Decisions) = apply {
                questions = decisions.questions.map { it.toMutableList() }
                additionalProperties = decisions.additionalProperties.toMutableMap()
            }

            /** Native Decision API questions evaluated together, in order. */
            fun questions(questions: List<DecisionQuestion>) = questions(JsonField.of(questions))

            /**
             * Sets [Builder.questions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.questions] with a well-typed
             * `List<DecisionQuestion>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (questions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
