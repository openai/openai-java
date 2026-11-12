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

@JsonDeserialize(using = DecisionQuestion.Deserializer::class)
@JsonSerialize(using = DecisionQuestion.Serializer::class)
class DecisionQuestion
private constructor(
    private val choice: Choice? = null,
    private val predicate: Predicate? = null,
    private val score: Score? = null,
    private val _json: JsonValue? = null,
) {

    fun choice(): Optional<Choice> = Optional.ofNullable(choice)

    fun predicate(): Optional<Predicate> = Optional.ofNullable(predicate)

    fun score(): Optional<Score> = Optional.ofNullable(score)

    fun isChoice(): Boolean = choice != null

    fun isPredicate(): Boolean = predicate != null

    fun isScore(): Boolean = score != null

    fun asChoice(): Choice = choice.getOrThrow("choice")

    fun asPredicate(): Predicate = predicate.getOrThrow("predicate")

    fun asScore(): Score = score.getOrThrow("score")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = decisionQuestion.accept(new DecisionQuestion.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitChoice(Choice choice) {
     *         return Optional.of(choice.toString());
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
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            choice != null -> visitor.visitChoice(choice)
            predicate != null -> visitor.visitPredicate(predicate)
            score != null -> visitor.visitScore(score)
            else -> visitor.unknown(_json)
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
    fun validate(): DecisionQuestion = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitChoice(choice: Choice) {
                    choice.validate()
                }

                override fun visitPredicate(predicate: Predicate) {
                    predicate.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitChoice(choice: Choice) = choice.validity()

                override fun visitPredicate(predicate: Predicate) = predicate.validity()

                override fun visitScore(score: Score) = score.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionQuestion &&
            choice == other.choice &&
            predicate == other.predicate &&
            score == other.score &&
            (choice != null || predicate != null || score != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (choice == null && predicate == null && score == null) Objects.hash(_json)
        else Objects.hash(choice, predicate, score)

    override fun toString(): String =
        when {
            choice != null -> "DecisionQuestion{choice=$choice}"
            predicate != null -> "DecisionQuestion{predicate=$predicate}"
            score != null -> "DecisionQuestion{score=$score}"
            _json != null -> "DecisionQuestion{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionQuestion")
        }

    companion object {

        @JvmStatic fun ofChoice(choice: Choice) = DecisionQuestion(choice = choice)

        @JvmStatic fun ofPredicate(predicate: Predicate) = DecisionQuestion(predicate = predicate)

        @JvmStatic fun ofScore(score: Score) = DecisionQuestion(score = score)
    }

    /**
     * An interface that defines how to map each variant of [DecisionQuestion] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitChoice(choice: Choice): T = unknown(JsonValue.from(choice))

        fun visitPredicate(predicate: Predicate): T = unknown(JsonValue.from(predicate))

        fun visitScore(score: Score): T = unknown(JsonValue.from(score))

        /**
         * Maps an unknown variant of [DecisionQuestion] to a value of type [T].
         *
         * An instance of [DecisionQuestion] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionQuestion")
        }
    }

    internal class Deserializer : BaseDeserializer<DecisionQuestion>(DecisionQuestion::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionQuestion {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "choice" -> {
                    return tryDeserialize(node, jacksonTypeRef<Choice>())?.let {
                        DecisionQuestion(choice = it, _json = json)
                    } ?: DecisionQuestion(_json = json)
                }
                "predicate" -> {
                    return tryDeserialize(node, jacksonTypeRef<Predicate>())?.let {
                        DecisionQuestion(predicate = it, _json = json)
                    } ?: DecisionQuestion(_json = json)
                }
                "score" -> {
                    return tryDeserialize(node, jacksonTypeRef<Score>())?.let {
                        DecisionQuestion(score = it, _json = json)
                    } ?: DecisionQuestion(_json = json)
                }
            }

            return DecisionQuestion(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<DecisionQuestion>(DecisionQuestion::class) {

        override fun serialize(
            value: DecisionQuestion,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.choice != null -> generator.writeObject(value.choice)
                value.predicate != null -> generator.writeObject(value.predicate)
                value.score != null -> generator.writeObject(value.score)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionQuestion")
            }
        }
    }

    class Choice
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val choices: JsonField<List<DecisionChoiceOption>>,
        private val instructions: JsonField<DecisionQuestionInstructions>,
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
            instructions: JsonField<DecisionQuestionInstructions> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(choices, instructions, type, name, mutableMapOf())

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun choices(): java.util.Optional<List<DecisionChoiceOption>> =
            choices.getOptional("choices")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun choicesOrThrow(): List<DecisionChoiceOption> = choices.getRequired("choices")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun instructions(): java.util.Optional<DecisionQuestionInstructions> =
            instructions.getOptional("instructions")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun instructionsOrThrow(): DecisionQuestionInstructions =
            instructions.getRequired("instructions")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("choice")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun name(): java.util.Optional<String> = name.getOptional("name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun nameOrThrow(): String = name.getRequired("name")

        /**
         * Returns the raw JSON value of [choices].
         *
         * Unlike [choices], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("choices")
        @ExcludeMissing
        fun _choices(): JsonField<List<DecisionChoiceOption>> = choices

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<DecisionQuestionInstructions> = instructions

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
                "choices" to this.choices,
                "instructions" to this.instructions,
                "type" to this.type,
                "name" to this.name,
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
            private var instructions: JsonField<DecisionQuestionInstructions>? = null
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

            fun choices(choices: List<DecisionChoiceOption>) = choices(JsonField.of(choices))

            /**
             * Sets [Builder.choices] to an arbitrary JSON value.
             *
             * You should usually call [Builder.choices] with a well-typed
             * `List<DecisionChoiceOption>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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

            fun instructions(instructions: DecisionQuestionInstructions) =
                instructions(JsonField.of(instructions))

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed
             * [DecisionQuestionInstructions] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun instructions(instructions: JsonField<DecisionQuestionInstructions>) = apply {
                this.instructions = instructions
            }

            /**
             * Alias for calling [instructions] with
             * `DecisionQuestionInstructions.ofString(string)`.
             */
            fun instructions(string: String) =
                instructions(DecisionQuestionInstructions.ofString(string))

            /**
             * Alias for calling [instructions] with `DecisionQuestionInstructions.ofParts(parts)`.
             */
            fun instructionsOfParts(parts: List<DecisionQuestionInputPart>) =
                instructions(DecisionQuestionInstructions.ofParts(parts))

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

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Choice = apply {
            if (validated) {
                return@apply
            }

            choicesOrThrow().forEach { it.validate() }
            instructionsOrThrow().validate()
            typeOrThrow()
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
                (instructions.asKnown().getOrNull()?.validity() ?: 0) +
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

    class Predicate
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val instructions: JsonField<DecisionQuestionInstructions>,
        private val type: JsonValue,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<DecisionQuestionInstructions> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(instructions, type, name, mutableMapOf())

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun instructions(): java.util.Optional<DecisionQuestionInstructions> =
            instructions.getOptional("instructions")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun instructionsOrThrow(): DecisionQuestionInstructions =
            instructions.getRequired("instructions")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("predicate")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun name(): java.util.Optional<String> = name.getOptional("name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun nameOrThrow(): String = name.getRequired("name")

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<DecisionQuestionInstructions> = instructions

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
                "instructions" to this.instructions,
                "type" to this.type,
                "name" to this.name,
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

            private var instructions: JsonField<DecisionQuestionInstructions>? = null
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

            fun instructions(instructions: DecisionQuestionInstructions) =
                instructions(JsonField.of(instructions))

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed
             * [DecisionQuestionInstructions] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun instructions(instructions: JsonField<DecisionQuestionInstructions>) = apply {
                this.instructions = instructions
            }

            /**
             * Alias for calling [instructions] with
             * `DecisionQuestionInstructions.ofString(string)`.
             */
            fun instructions(string: String) =
                instructions(DecisionQuestionInstructions.ofString(string))

            /**
             * Alias for calling [instructions] with `DecisionQuestionInstructions.ofParts(parts)`.
             */
            fun instructionsOfParts(parts: List<DecisionQuestionInputPart>) =
                instructions(DecisionQuestionInstructions.ofParts(parts))

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

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Predicate = apply {
            if (validated) {
                return@apply
            }

            instructionsOrThrow().validate()
            typeOrThrow()
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
            (instructions.asKnown().getOrNull()?.validity() ?: 0) +
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

    class Score
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val instructions: JsonField<DecisionQuestionInstructions>,
        private val levels: JsonField<List<Level>>,
        private val type: JsonValue,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<DecisionQuestionInstructions> = JsonMissing.of(),
            @JsonProperty("levels")
            @ExcludeMissing
            levels: JsonField<List<Level>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(instructions, levels, type, name, mutableMapOf())

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun instructions(): java.util.Optional<DecisionQuestionInstructions> =
            instructions.getOptional("instructions")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun instructionsOrThrow(): DecisionQuestionInstructions =
            instructions.getRequired("instructions")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun levels(): java.util.Optional<List<Level>> = levels.getOptional("levels")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun levelsOrThrow(): List<Level> = levels.getRequired("levels")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("score")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun name(): java.util.Optional<String> = name.getOptional("name")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun nameOrThrow(): String = name.getRequired("name")

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<DecisionQuestionInstructions> = instructions

        /**
         * Returns the raw JSON value of [levels].
         *
         * Unlike [levels], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("levels") @ExcludeMissing fun _levels(): JsonField<List<Level>> = levels

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
                "instructions" to this.instructions,
                "levels" to this.levels,
                "type" to this.type,
                "name" to this.name,
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

            private var instructions: JsonField<DecisionQuestionInstructions>? = null
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

            fun instructions(instructions: DecisionQuestionInstructions) =
                instructions(JsonField.of(instructions))

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed
             * [DecisionQuestionInstructions] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun instructions(instructions: JsonField<DecisionQuestionInstructions>) = apply {
                this.instructions = instructions
            }

            /**
             * Alias for calling [instructions] with
             * `DecisionQuestionInstructions.ofString(string)`.
             */
            fun instructions(string: String) =
                instructions(DecisionQuestionInstructions.ofString(string))

            /**
             * Alias for calling [instructions] with `DecisionQuestionInstructions.ofParts(parts)`.
             */
            fun instructionsOfParts(parts: List<DecisionQuestionInputPart>) =
                instructions(DecisionQuestionInstructions.ofParts(parts))

            fun levels(levels: List<Level>) = levels(JsonField.of(levels))

            /**
             * Sets [Builder.levels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.levels] with a well-typed `List<Level>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Score = apply {
            if (validated) {
                return@apply
            }

            instructionsOrThrow().validate()
            levelsOrThrow().forEach { it.validate() }
            typeOrThrow()
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
            (instructions.asKnown().getOrNull()?.validity() ?: 0) +
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
                @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
            ) : this(label, description, mutableMapOf())

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun label(): java.util.Optional<String> = label.getOptional("label")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun labelOrThrow(): String = label.getRequired("label")

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun description(): java.util.Optional<String> = description.getOptional("description")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun descriptionOrThrow(): String = description.getRequired("description")

            /**
             * Returns the raw JSON value of [label].
             *
             * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "label" to this.label,
                    "description" to this.description,
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
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
                 * You should usually call [Builder.label] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun label(label: JsonField<String>) = apply { this.label = label }

                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
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
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Level = apply {
                if (validated) {
                    return@apply
                }

                labelOrThrow()
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
