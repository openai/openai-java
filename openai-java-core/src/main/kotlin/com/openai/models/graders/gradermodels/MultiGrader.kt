// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

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
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A MultiGrader object combines the output of multiple graders to produce a single score. */
class MultiGrader
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val calculateOutput: JsonField<String>,
    private val graders: JsonField<Graders>,
    private val name: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("calculate_output")
        @ExcludeMissing
        calculateOutput: JsonField<String> = JsonMissing.of(),
        @JsonProperty("graders") @ExcludeMissing graders: JsonField<Graders> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(calculateOutput, graders, name, type, mutableMapOf())

    /**
     * A formula to calculate the output based on grader results.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun calculateOutput(): String = calculateOutput.getRequired("calculate_output")

    /**
     * A StringCheckGrader object that performs a string comparison between input and reference
     * using a specified operation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun graders(): Graders = graders.getRequired("graders")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The object type, which is always `multi`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("multi")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [calculateOutput].
     *
     * Unlike [calculateOutput], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("calculate_output")
    @ExcludeMissing
    fun _calculateOutput(): JsonField<String> = calculateOutput

    /**
     * Returns the raw JSON value of [graders].
     *
     * Unlike [graders], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("graders") @ExcludeMissing fun _graders(): JsonField<Graders> = graders

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
         * Returns a mutable builder for constructing an instance of [MultiGrader].
         *
         * The following fields are required:
         * ```java
         * .calculateOutput()
         * .graders()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MultiGrader]. */
    class Builder internal constructor() {

        private var calculateOutput: JsonField<String>? = null
        private var graders: JsonField<Graders>? = null
        private var name: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("multi")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(multiGrader: MultiGrader) = apply {
            calculateOutput = multiGrader.calculateOutput
            graders = multiGrader.graders
            name = multiGrader.name
            type = multiGrader.type
            additionalProperties = multiGrader.additionalProperties.toMutableMap()
        }

        /** A formula to calculate the output based on grader results. */
        fun calculateOutput(calculateOutput: String) =
            calculateOutput(JsonField.of(calculateOutput))

        /**
         * Sets [Builder.calculateOutput] to an arbitrary JSON value.
         *
         * You should usually call [Builder.calculateOutput] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun calculateOutput(calculateOutput: JsonField<String>) = apply {
            this.calculateOutput = calculateOutput
        }

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun graders(graders: Graders) = graders(JsonField.of(graders))

        /**
         * Sets [Builder.graders] to an arbitrary JSON value.
         *
         * You should usually call [Builder.graders] with a well-typed [Graders] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun graders(graders: JsonField<Graders>) = apply { this.graders = graders }

        /** Alias for calling [graders] with `Graders.ofStringCheckGrader(stringCheckGrader)`. */
        fun graders(stringCheckGrader: StringCheckGrader) =
            graders(Graders.ofStringCheckGrader(stringCheckGrader))

        /**
         * Alias for calling [graders] with `Graders.ofTextSimilarityGrader(textSimilarityGrader)`.
         */
        fun graders(textSimilarityGrader: TextSimilarityGrader) =
            graders(Graders.ofTextSimilarityGrader(textSimilarityGrader))

        /** Alias for calling [graders] with `Graders.ofPythonGrader(pythonGrader)`. */
        fun graders(pythonGrader: PythonGrader) = graders(Graders.ofPythonGrader(pythonGrader))

        /** Alias for calling [graders] with `Graders.ofScoreModelGrader(scoreModelGrader)`. */
        fun graders(scoreModelGrader: ScoreModelGrader) =
            graders(Graders.ofScoreModelGrader(scoreModelGrader))

        /** Alias for calling [graders] with `Graders.ofLabelModelGrader(labelModelGrader)`. */
        fun graders(labelModelGrader: LabelModelGrader) =
            graders(Graders.ofLabelModelGrader(labelModelGrader))

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
         * JsonValue.from("multi")
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
         * Returns an immutable instance of [MultiGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .calculateOutput()
         * .graders()
         * .name()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MultiGrader =
            MultiGrader(
                checkRequired("calculateOutput", calculateOutput),
                checkRequired("graders", graders),
                checkRequired("name", name),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MultiGrader = apply {
        if (validated) {
            return@apply
        }

        calculateOutput()
        graders().validate()
        name()
        _type().let {
            if (it != JsonValue.from("multi")) {
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
        (if (calculateOutput.asKnown().isPresent) 1 else 0) +
            (graders.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("multi")) 1 else 0 }

    /**
     * A StringCheckGrader object that performs a string comparison between input and reference
     * using a specified operation.
     */
    @JsonDeserialize(using = Graders.Deserializer::class)
    @JsonSerialize(using = Graders.Serializer::class)
    class Graders
    private constructor(
        private val stringCheckGrader: StringCheckGrader? = null,
        private val textSimilarityGrader: TextSimilarityGrader? = null,
        private val pythonGrader: PythonGrader? = null,
        private val scoreModelGrader: ScoreModelGrader? = null,
        private val labelModelGrader: LabelModelGrader? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun stringCheckGrader(): Optional<StringCheckGrader> =
            Optional.ofNullable(stringCheckGrader)

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun textSimilarityGrader(): Optional<TextSimilarityGrader> =
            Optional.ofNullable(textSimilarityGrader)

        /** A PythonGrader object that runs a python script on the input. */
        fun pythonGrader(): Optional<PythonGrader> = Optional.ofNullable(pythonGrader)

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun scoreModelGrader(): Optional<ScoreModelGrader> = Optional.ofNullable(scoreModelGrader)

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun labelModelGrader(): Optional<LabelModelGrader> = Optional.ofNullable(labelModelGrader)

        fun isStringCheckGrader(): Boolean = stringCheckGrader != null

        fun isTextSimilarityGrader(): Boolean = textSimilarityGrader != null

        fun isPythonGrader(): Boolean = pythonGrader != null

        fun isScoreModelGrader(): Boolean = scoreModelGrader != null

        fun isLabelModelGrader(): Boolean = labelModelGrader != null

        /**
         * A StringCheckGrader object that performs a string comparison between input and reference
         * using a specified operation.
         */
        fun asStringCheckGrader(): StringCheckGrader =
            stringCheckGrader.getOrThrow("stringCheckGrader")

        /** A TextSimilarityGrader object which grades text based on similarity metrics. */
        fun asTextSimilarityGrader(): TextSimilarityGrader =
            textSimilarityGrader.getOrThrow("textSimilarityGrader")

        /** A PythonGrader object that runs a python script on the input. */
        fun asPythonGrader(): PythonGrader = pythonGrader.getOrThrow("pythonGrader")

        /** A ScoreModelGrader object that uses a model to assign a score to the input. */
        fun asScoreModelGrader(): ScoreModelGrader = scoreModelGrader.getOrThrow("scoreModelGrader")

        /**
         * A LabelModelGrader object which uses a model to assign labels to each item in the
         * evaluation.
         */
        fun asLabelModelGrader(): LabelModelGrader = labelModelGrader.getOrThrow("labelModelGrader")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                stringCheckGrader != null -> visitor.visitStringCheckGrader(stringCheckGrader)
                textSimilarityGrader != null ->
                    visitor.visitTextSimilarityGrader(textSimilarityGrader)
                pythonGrader != null -> visitor.visitPythonGrader(pythonGrader)
                scoreModelGrader != null -> visitor.visitScoreModelGrader(scoreModelGrader)
                labelModelGrader != null -> visitor.visitLabelModelGrader(labelModelGrader)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Graders = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader) {
                        stringCheckGrader.validate()
                    }

                    override fun visitTextSimilarityGrader(
                        textSimilarityGrader: TextSimilarityGrader
                    ) {
                        textSimilarityGrader.validate()
                    }

                    override fun visitPythonGrader(pythonGrader: PythonGrader) {
                        pythonGrader.validate()
                    }

                    override fun visitScoreModelGrader(scoreModelGrader: ScoreModelGrader) {
                        scoreModelGrader.validate()
                    }

                    override fun visitLabelModelGrader(labelModelGrader: LabelModelGrader) {
                        labelModelGrader.validate()
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
                    override fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader) =
                        stringCheckGrader.validity()

                    override fun visitTextSimilarityGrader(
                        textSimilarityGrader: TextSimilarityGrader
                    ) = textSimilarityGrader.validity()

                    override fun visitPythonGrader(pythonGrader: PythonGrader) =
                        pythonGrader.validity()

                    override fun visitScoreModelGrader(scoreModelGrader: ScoreModelGrader) =
                        scoreModelGrader.validity()

                    override fun visitLabelModelGrader(labelModelGrader: LabelModelGrader) =
                        labelModelGrader.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Graders &&
                stringCheckGrader == other.stringCheckGrader &&
                textSimilarityGrader == other.textSimilarityGrader &&
                pythonGrader == other.pythonGrader &&
                scoreModelGrader == other.scoreModelGrader &&
                labelModelGrader == other.labelModelGrader
        }

        override fun hashCode(): Int =
            Objects.hash(
                stringCheckGrader,
                textSimilarityGrader,
                pythonGrader,
                scoreModelGrader,
                labelModelGrader,
            )

        override fun toString(): String =
            when {
                stringCheckGrader != null -> "Graders{stringCheckGrader=$stringCheckGrader}"
                textSimilarityGrader != null ->
                    "Graders{textSimilarityGrader=$textSimilarityGrader}"
                pythonGrader != null -> "Graders{pythonGrader=$pythonGrader}"
                scoreModelGrader != null -> "Graders{scoreModelGrader=$scoreModelGrader}"
                labelModelGrader != null -> "Graders{labelModelGrader=$labelModelGrader}"
                _json != null -> "Graders{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Graders")
            }

        companion object {

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            @JvmStatic
            fun ofStringCheckGrader(stringCheckGrader: StringCheckGrader) =
                Graders(stringCheckGrader = stringCheckGrader)

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            @JvmStatic
            fun ofTextSimilarityGrader(textSimilarityGrader: TextSimilarityGrader) =
                Graders(textSimilarityGrader = textSimilarityGrader)

            /** A PythonGrader object that runs a python script on the input. */
            @JvmStatic
            fun ofPythonGrader(pythonGrader: PythonGrader) = Graders(pythonGrader = pythonGrader)

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            @JvmStatic
            fun ofScoreModelGrader(scoreModelGrader: ScoreModelGrader) =
                Graders(scoreModelGrader = scoreModelGrader)

            /**
             * A LabelModelGrader object which uses a model to assign labels to each item in the
             * evaluation.
             */
            @JvmStatic
            fun ofLabelModelGrader(labelModelGrader: LabelModelGrader) =
                Graders(labelModelGrader = labelModelGrader)
        }

        /**
         * An interface that defines how to map each variant of [Graders] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * A StringCheckGrader object that performs a string comparison between input and
             * reference using a specified operation.
             */
            fun visitStringCheckGrader(stringCheckGrader: StringCheckGrader): T

            /** A TextSimilarityGrader object which grades text based on similarity metrics. */
            fun visitTextSimilarityGrader(textSimilarityGrader: TextSimilarityGrader): T

            /** A PythonGrader object that runs a python script on the input. */
            fun visitPythonGrader(pythonGrader: PythonGrader): T

            /** A ScoreModelGrader object that uses a model to assign a score to the input. */
            fun visitScoreModelGrader(scoreModelGrader: ScoreModelGrader): T

            /**
             * A LabelModelGrader object which uses a model to assign labels to each item in the
             * evaluation.
             */
            fun visitLabelModelGrader(labelModelGrader: LabelModelGrader): T

            /**
             * Maps an unknown variant of [Graders] to a value of type [T].
             *
             * An instance of [Graders] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Graders: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Graders>(Graders::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Graders {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<StringCheckGrader>())?.let {
                                Graders(stringCheckGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<TextSimilarityGrader>())?.let {
                                Graders(textSimilarityGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<PythonGrader>())?.let {
                                Graders(pythonGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ScoreModelGrader>())?.let {
                                Graders(scoreModelGrader = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<LabelModelGrader>())?.let {
                                Graders(labelModelGrader = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Graders(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Graders>(Graders::class) {

            override fun serialize(
                value: Graders,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.stringCheckGrader != null ->
                        generator.writeObject(value.stringCheckGrader)
                    value.textSimilarityGrader != null ->
                        generator.writeObject(value.textSimilarityGrader)
                    value.pythonGrader != null -> generator.writeObject(value.pythonGrader)
                    value.scoreModelGrader != null -> generator.writeObject(value.scoreModelGrader)
                    value.labelModelGrader != null -> generator.writeObject(value.labelModelGrader)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Graders")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MultiGrader &&
            calculateOutput == other.calculateOutput &&
            graders == other.graders &&
            name == other.name &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(calculateOutput, graders, name, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MultiGrader{calculateOutput=$calculateOutput, graders=$graders, name=$name, type=$type, additionalProperties=$additionalProperties}"
}
