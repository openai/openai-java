// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The hyperparameters used for the reinforcement fine-tuning job. */
class ReinforcementHyperparameters
private constructor(
    private val batchSize: JsonField<BatchSize>,
    private val computeMultiplier: JsonField<ComputeMultiplier>,
    private val evalInterval: JsonField<EvalInterval>,
    private val evalSamples: JsonField<EvalSamples>,
    private val learningRateMultiplier: JsonField<LearningRateMultiplier>,
    private val nEpochs: JsonField<NEpochs>,
    private val reasoningEffort: JsonField<ReasoningEffort>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("batch_size")
        @ExcludeMissing
        batchSize: JsonField<BatchSize> = JsonMissing.of(),
        @JsonProperty("compute_multiplier")
        @ExcludeMissing
        computeMultiplier: JsonField<ComputeMultiplier> = JsonMissing.of(),
        @JsonProperty("eval_interval")
        @ExcludeMissing
        evalInterval: JsonField<EvalInterval> = JsonMissing.of(),
        @JsonProperty("eval_samples")
        @ExcludeMissing
        evalSamples: JsonField<EvalSamples> = JsonMissing.of(),
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of(),
        @JsonProperty("n_epochs") @ExcludeMissing nEpochs: JsonField<NEpochs> = JsonMissing.of(),
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
    ) : this(
        batchSize,
        computeMultiplier,
        evalInterval,
        evalSamples,
        learningRateMultiplier,
        nEpochs,
        reasoningEffort,
        mutableMapOf(),
    )

    /**
     * Number of examples in each batch. A larger batch size means that model parameters are updated
     * less frequently, but with lower variance.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun batchSize(): Optional<BatchSize> = batchSize.getOptional("batch_size")

    /**
     * Multiplier on amount of compute used for exploring search space during training.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun computeMultiplier(): Optional<ComputeMultiplier> =
        computeMultiplier.getOptional("compute_multiplier")

    /**
     * The number of training steps between evaluation runs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun evalInterval(): Optional<EvalInterval> = evalInterval.getOptional("eval_interval")

    /**
     * Number of evaluation samples to generate per training step.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun evalSamples(): Optional<EvalSamples> = evalSamples.getOptional("eval_samples")

    /**
     * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
     * overfitting.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
        learningRateMultiplier.getOptional("learning_rate_multiplier")

    /**
     * The number of epochs to train the model for. An epoch refers to one full cycle through the
     * training dataset.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nEpochs(): Optional<NEpochs> = nEpochs.getOptional("n_epochs")

    /**
     * Level of reasoning effort.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoningEffort(): Optional<ReasoningEffort> =
        reasoningEffort.getOptional("reasoning_effort")

    /**
     * Returns the raw JSON value of [batchSize].
     *
     * Unlike [batchSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("batch_size") @ExcludeMissing fun _batchSize(): JsonField<BatchSize> = batchSize

    /**
     * Returns the raw JSON value of [computeMultiplier].
     *
     * Unlike [computeMultiplier], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("compute_multiplier")
    @ExcludeMissing
    fun _computeMultiplier(): JsonField<ComputeMultiplier> = computeMultiplier

    /**
     * Returns the raw JSON value of [evalInterval].
     *
     * Unlike [evalInterval], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eval_interval")
    @ExcludeMissing
    fun _evalInterval(): JsonField<EvalInterval> = evalInterval

    /**
     * Returns the raw JSON value of [evalSamples].
     *
     * Unlike [evalSamples], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eval_samples")
    @ExcludeMissing
    fun _evalSamples(): JsonField<EvalSamples> = evalSamples

    /**
     * Returns the raw JSON value of [learningRateMultiplier].
     *
     * Unlike [learningRateMultiplier], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("learning_rate_multiplier")
    @ExcludeMissing
    fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> = learningRateMultiplier

    /**
     * Returns the raw JSON value of [nEpochs].
     *
     * Unlike [nEpochs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("n_epochs") @ExcludeMissing fun _nEpochs(): JsonField<NEpochs> = nEpochs

    /**
     * Returns the raw JSON value of [reasoningEffort].
     *
     * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reasoning_effort")
    @ExcludeMissing
    fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

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
         * Returns a mutable builder for constructing an instance of [ReinforcementHyperparameters].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ReinforcementHyperparameters]. */
    class Builder internal constructor() {

        private var batchSize: JsonField<BatchSize> = JsonMissing.of()
        private var computeMultiplier: JsonField<ComputeMultiplier> = JsonMissing.of()
        private var evalInterval: JsonField<EvalInterval> = JsonMissing.of()
        private var evalSamples: JsonField<EvalSamples> = JsonMissing.of()
        private var learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of()
        private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
        private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(reinforcementHyperparameters: ReinforcementHyperparameters) = apply {
            batchSize = reinforcementHyperparameters.batchSize
            computeMultiplier = reinforcementHyperparameters.computeMultiplier
            evalInterval = reinforcementHyperparameters.evalInterval
            evalSamples = reinforcementHyperparameters.evalSamples
            learningRateMultiplier = reinforcementHyperparameters.learningRateMultiplier
            nEpochs = reinforcementHyperparameters.nEpochs
            reasoningEffort = reinforcementHyperparameters.reasoningEffort
            additionalProperties = reinforcementHyperparameters.additionalProperties.toMutableMap()
        }

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

        /**
         * Sets [Builder.batchSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.batchSize] with a well-typed [BatchSize] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun batchSize(batchSize: JsonField<BatchSize>) = apply { this.batchSize = batchSize }

        /** Alias for calling [batchSize] with `BatchSize.ofAuto()`. */
        fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

        /** Alias for calling [batchSize] with `BatchSize.ofInteger(integer)`. */
        fun batchSize(integer: Long) = batchSize(BatchSize.ofInteger(integer))

        /** Multiplier on amount of compute used for exploring search space during training. */
        fun computeMultiplier(computeMultiplier: ComputeMultiplier) =
            computeMultiplier(JsonField.of(computeMultiplier))

        /**
         * Sets [Builder.computeMultiplier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.computeMultiplier] with a well-typed [ComputeMultiplier]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun computeMultiplier(computeMultiplier: JsonField<ComputeMultiplier>) = apply {
            this.computeMultiplier = computeMultiplier
        }

        /** Alias for calling [computeMultiplier] with `ComputeMultiplier.ofAuto()`. */
        fun computeMultiplierAuto() = computeMultiplier(ComputeMultiplier.ofAuto())

        /** Alias for calling [computeMultiplier] with `ComputeMultiplier.ofNumber(number)`. */
        fun computeMultiplier(number: Double) =
            computeMultiplier(ComputeMultiplier.ofNumber(number))

        /** The number of training steps between evaluation runs. */
        fun evalInterval(evalInterval: EvalInterval) = evalInterval(JsonField.of(evalInterval))

        /**
         * Sets [Builder.evalInterval] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evalInterval] with a well-typed [EvalInterval] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun evalInterval(evalInterval: JsonField<EvalInterval>) = apply {
            this.evalInterval = evalInterval
        }

        /** Alias for calling [evalInterval] with `EvalInterval.ofAuto()`. */
        fun evalIntervalAuto() = evalInterval(EvalInterval.ofAuto())

        /** Alias for calling [evalInterval] with `EvalInterval.ofInteger(integer)`. */
        fun evalInterval(integer: Long) = evalInterval(EvalInterval.ofInteger(integer))

        /** Number of evaluation samples to generate per training step. */
        fun evalSamples(evalSamples: EvalSamples) = evalSamples(JsonField.of(evalSamples))

        /**
         * Sets [Builder.evalSamples] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evalSamples] with a well-typed [EvalSamples] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun evalSamples(evalSamples: JsonField<EvalSamples>) = apply {
            this.evalSamples = evalSamples
        }

        /** Alias for calling [evalSamples] with `EvalSamples.ofAuto()`. */
        fun evalSamplesAuto() = evalSamples(EvalSamples.ofAuto())

        /** Alias for calling [evalSamples] with `EvalSamples.ofInteger(integer)`. */
        fun evalSamples(integer: Long) = evalSamples(EvalSamples.ofInteger(integer))

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
            learningRateMultiplier(JsonField.of(learningRateMultiplier))

        /**
         * Sets [Builder.learningRateMultiplier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.learningRateMultiplier] with a well-typed
         * [LearningRateMultiplier] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun learningRateMultiplier(learningRateMultiplier: JsonField<LearningRateMultiplier>) =
            apply {
                this.learningRateMultiplier = learningRateMultiplier
            }

        /** Alias for calling [learningRateMultiplier] with `LearningRateMultiplier.ofAuto()`. */
        fun learningRateMultiplierAuto() = learningRateMultiplier(LearningRateMultiplier.ofAuto())

        /**
         * Alias for calling [learningRateMultiplier] with
         * `LearningRateMultiplier.ofNumber(number)`.
         */
        fun learningRateMultiplier(number: Double) =
            learningRateMultiplier(LearningRateMultiplier.ofNumber(number))

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

        /**
         * Sets [Builder.nEpochs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nEpochs] with a well-typed [NEpochs] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

        /** Alias for calling [nEpochs] with `NEpochs.ofAuto()`. */
        fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

        /** Alias for calling [nEpochs] with `NEpochs.ofInteger(integer)`. */
        fun nEpochs(integer: Long) = nEpochs(NEpochs.ofInteger(integer))

        /** Level of reasoning effort. */
        fun reasoningEffort(reasoningEffort: ReasoningEffort) =
            reasoningEffort(JsonField.of(reasoningEffort))

        /**
         * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
            this.reasoningEffort = reasoningEffort
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
         * Returns an immutable instance of [ReinforcementHyperparameters].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ReinforcementHyperparameters =
            ReinforcementHyperparameters(
                batchSize,
                computeMultiplier,
                evalInterval,
                evalSamples,
                learningRateMultiplier,
                nEpochs,
                reasoningEffort,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ReinforcementHyperparameters = apply {
        if (validated) {
            return@apply
        }

        batchSize().ifPresent { it.validate() }
        computeMultiplier().ifPresent { it.validate() }
        evalInterval().ifPresent { it.validate() }
        evalSamples().ifPresent { it.validate() }
        learningRateMultiplier().ifPresent { it.validate() }
        nEpochs().ifPresent { it.validate() }
        reasoningEffort().ifPresent { it.validate() }
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
        (batchSize.asKnown().getOrNull()?.validity() ?: 0) +
            (computeMultiplier.asKnown().getOrNull()?.validity() ?: 0) +
            (evalInterval.asKnown().getOrNull()?.validity() ?: 0) +
            (evalSamples.asKnown().getOrNull()?.validity() ?: 0) +
            (learningRateMultiplier.asKnown().getOrNull()?.validity() ?: 0) +
            (nEpochs.asKnown().getOrNull()?.validity() ?: 0) +
            (reasoningEffort.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Number of examples in each batch. A larger batch size means that model parameters are updated
     * less frequently, but with lower variance.
     */
    @JsonDeserialize(using = BatchSize.Deserializer::class)
    @JsonSerialize(using = BatchSize.Serializer::class)
    class BatchSize
    private constructor(
        private val auto: JsonValue? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isAuto(): Boolean = auto != null

        fun isInteger(): Boolean = integer != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): BatchSize = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitInteger(integer: Long) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BatchSize && auto == other.auto && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(auto, integer)

        override fun toString(): String =
            when {
                auto != null -> "BatchSize{auto=$auto}"
                integer != null -> "BatchSize{integer=$integer}"
                _json != null -> "BatchSize{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid BatchSize")
            }

        companion object {

            @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

            @JvmStatic fun ofInteger(integer: Long) = BatchSize(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [BatchSize] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [BatchSize] to a value of type [T].
             *
             * An instance of [BatchSize] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown BatchSize: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { BatchSize(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                BatchSize(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> BatchSize(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

            override fun serialize(
                value: BatchSize,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid BatchSize")
                }
            }
        }
    }

    /** Multiplier on amount of compute used for exploring search space during training. */
    @JsonDeserialize(using = ComputeMultiplier.Deserializer::class)
    @JsonSerialize(using = ComputeMultiplier.Serializer::class)
    class ComputeMultiplier
    private constructor(
        private val auto: JsonValue? = null,
        private val number: Double? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun isAuto(): Boolean = auto != null

        fun isNumber(): Boolean = number != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asNumber(): Double = number.getOrThrow("number")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                number != null -> visitor.visitNumber(number)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): ComputeMultiplier = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitNumber(number: Double) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitNumber(number: Double) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComputeMultiplier && auto == other.auto && number == other.number
        }

        override fun hashCode(): Int = Objects.hash(auto, number)

        override fun toString(): String =
            when {
                auto != null -> "ComputeMultiplier{auto=$auto}"
                number != null -> "ComputeMultiplier{number=$number}"
                _json != null -> "ComputeMultiplier{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ComputeMultiplier")
            }

        companion object {

            @JvmStatic fun ofAuto() = ComputeMultiplier(auto = JsonValue.from("auto"))

            @JvmStatic fun ofNumber(number: Double) = ComputeMultiplier(number = number)
        }

        /**
         * An interface that defines how to map each variant of [ComputeMultiplier] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitNumber(number: Double): T

            /**
             * Maps an unknown variant of [ComputeMultiplier] to a value of type [T].
             *
             * An instance of [ComputeMultiplier] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ComputeMultiplier: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<ComputeMultiplier>(ComputeMultiplier::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ComputeMultiplier {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { ComputeMultiplier(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                ComputeMultiplier(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> ComputeMultiplier(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<ComputeMultiplier>(ComputeMultiplier::class) {

            override fun serialize(
                value: ComputeMultiplier,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ComputeMultiplier")
                }
            }
        }
    }

    /** The number of training steps between evaluation runs. */
    @JsonDeserialize(using = EvalInterval.Deserializer::class)
    @JsonSerialize(using = EvalInterval.Serializer::class)
    class EvalInterval
    private constructor(
        private val auto: JsonValue? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isAuto(): Boolean = auto != null

        fun isInteger(): Boolean = integer != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): EvalInterval = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitInteger(integer: Long) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EvalInterval && auto == other.auto && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(auto, integer)

        override fun toString(): String =
            when {
                auto != null -> "EvalInterval{auto=$auto}"
                integer != null -> "EvalInterval{integer=$integer}"
                _json != null -> "EvalInterval{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid EvalInterval")
            }

        companion object {

            @JvmStatic fun ofAuto() = EvalInterval(auto = JsonValue.from("auto"))

            @JvmStatic fun ofInteger(integer: Long) = EvalInterval(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [EvalInterval] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [EvalInterval] to a value of type [T].
             *
             * An instance of [EvalInterval] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown EvalInterval: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<EvalInterval>(EvalInterval::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): EvalInterval {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { EvalInterval(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                EvalInterval(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> EvalInterval(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<EvalInterval>(EvalInterval::class) {

            override fun serialize(
                value: EvalInterval,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EvalInterval")
                }
            }
        }
    }

    /** Number of evaluation samples to generate per training step. */
    @JsonDeserialize(using = EvalSamples.Deserializer::class)
    @JsonSerialize(using = EvalSamples.Serializer::class)
    class EvalSamples
    private constructor(
        private val auto: JsonValue? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isAuto(): Boolean = auto != null

        fun isInteger(): Boolean = integer != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): EvalSamples = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitInteger(integer: Long) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EvalSamples && auto == other.auto && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(auto, integer)

        override fun toString(): String =
            when {
                auto != null -> "EvalSamples{auto=$auto}"
                integer != null -> "EvalSamples{integer=$integer}"
                _json != null -> "EvalSamples{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid EvalSamples")
            }

        companion object {

            @JvmStatic fun ofAuto() = EvalSamples(auto = JsonValue.from("auto"))

            @JvmStatic fun ofInteger(integer: Long) = EvalSamples(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [EvalSamples] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [EvalSamples] to a value of type [T].
             *
             * An instance of [EvalSamples] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown EvalSamples: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<EvalSamples>(EvalSamples::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): EvalSamples {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { EvalSamples(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                EvalSamples(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> EvalSamples(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<EvalSamples>(EvalSamples::class) {

            override fun serialize(
                value: EvalSamples,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EvalSamples")
                }
            }
        }
    }

    /**
     * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
     * overfitting.
     */
    @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
    @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
    class LearningRateMultiplier
    private constructor(
        private val auto: JsonValue? = null,
        private val number: Double? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun isAuto(): Boolean = auto != null

        fun isNumber(): Boolean = number != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asNumber(): Double = number.getOrThrow("number")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                number != null -> visitor.visitNumber(number)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): LearningRateMultiplier = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitNumber(number: Double) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitNumber(number: Double) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LearningRateMultiplier && auto == other.auto && number == other.number
        }

        override fun hashCode(): Int = Objects.hash(auto, number)

        override fun toString(): String =
            when {
                auto != null -> "LearningRateMultiplier{auto=$auto}"
                number != null -> "LearningRateMultiplier{number=$number}"
                _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid LearningRateMultiplier")
            }

        companion object {

            @JvmStatic fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

            @JvmStatic fun ofNumber(number: Double) = LearningRateMultiplier(number = number)
        }

        /**
         * An interface that defines how to map each variant of [LearningRateMultiplier] to a value
         * of type [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitNumber(number: Double): T

            /**
             * Maps an unknown variant of [LearningRateMultiplier] to a value of type [T].
             *
             * An instance of [LearningRateMultiplier] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): LearningRateMultiplier {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { LearningRateMultiplier(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                LearningRateMultiplier(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> LearningRateMultiplier(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer :
            BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

            override fun serialize(
                value: LearningRateMultiplier,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                }
            }
        }
    }

    /**
     * The number of epochs to train the model for. An epoch refers to one full cycle through the
     * training dataset.
     */
    @JsonDeserialize(using = NEpochs.Deserializer::class)
    @JsonSerialize(using = NEpochs.Serializer::class)
    class NEpochs
    private constructor(
        private val auto: JsonValue? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isAuto(): Boolean = auto != null

        fun isInteger(): Boolean = integer != null

        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): NEpochs = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitInteger(integer: Long) {}
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NEpochs && auto == other.auto && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(auto, integer)

        override fun toString(): String =
            when {
                auto != null -> "NEpochs{auto=$auto}"
                integer != null -> "NEpochs{integer=$integer}"
                _json != null -> "NEpochs{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid NEpochs")
            }

        companion object {

            @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

            @JvmStatic fun ofInteger(integer: Long) = NEpochs(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [NEpochs] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [NEpochs] to a value of type [T].
             *
             * An instance of [NEpochs] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown NEpochs: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { NEpochs(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                NEpochs(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> NEpochs(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

            override fun serialize(
                value: NEpochs,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid NEpochs")
                }
            }
        }
    }

    /** Level of reasoning effort. */
    class ReasoningEffort @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val DEFAULT = of("default")

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = ReasoningEffort(JsonField.of(value))
        }

        /** An enum containing [ReasoningEffort]'s known values. */
        enum class Known {
            DEFAULT,
            LOW,
            MEDIUM,
            HIGH,
        }

        /**
         * An enum containing [ReasoningEffort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ReasoningEffort] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DEFAULT,
            LOW,
            MEDIUM,
            HIGH,
            /**
             * An enum member indicating that [ReasoningEffort] was instantiated with an unknown
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
                DEFAULT -> Value.DEFAULT
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
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
                DEFAULT -> Known.DEFAULT
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown ReasoningEffort: $value")
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

        fun validate(): ReasoningEffort = apply {
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

            return other is ReasoningEffort && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReinforcementHyperparameters &&
            batchSize == other.batchSize &&
            computeMultiplier == other.computeMultiplier &&
            evalInterval == other.evalInterval &&
            evalSamples == other.evalSamples &&
            learningRateMultiplier == other.learningRateMultiplier &&
            nEpochs == other.nEpochs &&
            reasoningEffort == other.reasoningEffort &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            batchSize,
            computeMultiplier,
            evalInterval,
            evalSamples,
            learningRateMultiplier,
            nEpochs,
            reasoningEffort,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ReinforcementHyperparameters{batchSize=$batchSize, computeMultiplier=$computeMultiplier, evalInterval=$evalInterval, evalSamples=$evalSamples, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, reasoningEffort=$reasoningEffort, additionalProperties=$additionalProperties}"
}
