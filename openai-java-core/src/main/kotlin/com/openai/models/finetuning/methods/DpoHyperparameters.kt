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

/** The hyperparameters used for the DPO fine-tuning job. */
class DpoHyperparameters
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val batchSize: JsonField<BatchSize>,
    private val beta: JsonField<Beta>,
    private val learningRateMultiplier: JsonField<LearningRateMultiplier>,
    private val nEpochs: JsonField<NEpochs>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("batch_size")
        @ExcludeMissing
        batchSize: JsonField<BatchSize> = JsonMissing.of(),
        @JsonProperty("beta") @ExcludeMissing beta: JsonField<Beta> = JsonMissing.of(),
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of(),
        @JsonProperty("n_epochs") @ExcludeMissing nEpochs: JsonField<NEpochs> = JsonMissing.of(),
    ) : this(batchSize, beta, learningRateMultiplier, nEpochs, mutableMapOf())

    /**
     * Number of examples in each batch. A larger batch size means that model parameters are updated
     * less frequently, but with lower variance.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun batchSize(): Optional<BatchSize> = batchSize.getOptional("batch_size")

    /**
     * The beta value for the DPO method. A higher beta value will increase the weight of the
     * penalty between the policy and reference model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun beta(): Optional<Beta> = beta.getOptional("beta")

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
     * Returns the raw JSON value of [batchSize].
     *
     * Unlike [batchSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("batch_size") @ExcludeMissing fun _batchSize(): JsonField<BatchSize> = batchSize

    /**
     * Returns the raw JSON value of [beta].
     *
     * Unlike [beta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("beta") @ExcludeMissing fun _beta(): JsonField<Beta> = beta

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

        /** Returns a mutable builder for constructing an instance of [DpoHyperparameters]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DpoHyperparameters]. */
    class Builder internal constructor() {

        private var batchSize: JsonField<BatchSize> = JsonMissing.of()
        private var beta: JsonField<Beta> = JsonMissing.of()
        private var learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of()
        private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(dpoHyperparameters: DpoHyperparameters) = apply {
            batchSize = dpoHyperparameters.batchSize
            beta = dpoHyperparameters.beta
            learningRateMultiplier = dpoHyperparameters.learningRateMultiplier
            nEpochs = dpoHyperparameters.nEpochs
            additionalProperties = dpoHyperparameters.additionalProperties.toMutableMap()
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

        /**
         * The beta value for the DPO method. A higher beta value will increase the weight of the
         * penalty between the policy and reference model.
         */
        fun beta(beta: Beta) = beta(JsonField.of(beta))

        /**
         * Sets [Builder.beta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.beta] with a well-typed [Beta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun beta(beta: JsonField<Beta>) = apply { this.beta = beta }

        /** Alias for calling [beta] with `Beta.ofAuto()`. */
        fun betaAuto() = beta(Beta.ofAuto())

        /** Alias for calling [beta] with `Beta.ofNumber(number)`. */
        fun beta(number: Double) = beta(Beta.ofNumber(number))

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
         * Returns an immutable instance of [DpoHyperparameters].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DpoHyperparameters =
            DpoHyperparameters(
                batchSize,
                beta,
                learningRateMultiplier,
                nEpochs,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DpoHyperparameters = apply {
        if (validated) {
            return@apply
        }

        batchSize().ifPresent { it.validate() }
        beta().ifPresent { it.validate() }
        learningRateMultiplier().ifPresent { it.validate() }
        nEpochs().ifPresent { it.validate() }
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
            (beta.asKnown().getOrNull()?.validity() ?: 0) +
            (learningRateMultiplier.asKnown().getOrNull()?.validity() ?: 0) +
            (nEpochs.asKnown().getOrNull()?.validity() ?: 0)

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

    /**
     * The beta value for the DPO method. A higher beta value will increase the weight of the
     * penalty between the policy and reference model.
     */
    @JsonDeserialize(using = Beta.Deserializer::class)
    @JsonSerialize(using = Beta.Serializer::class)
    class Beta
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

        fun validate(): Beta = apply {
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

            return other is Beta && auto == other.auto && number == other.number
        }

        override fun hashCode(): Int = Objects.hash(auto, number)

        override fun toString(): String =
            when {
                auto != null -> "Beta{auto=$auto}"
                number != null -> "Beta{number=$number}"
                _json != null -> "Beta{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Beta")
            }

        companion object {

            @JvmStatic fun ofAuto() = Beta(auto = JsonValue.from("auto"))

            @JvmStatic fun ofNumber(number: Double) = Beta(number = number)
        }

        /** An interface that defines how to map each variant of [Beta] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitAuto(auto: JsonValue): T

            fun visitNumber(number: Double): T

            /**
             * Maps an unknown variant of [Beta] to a value of type [T].
             *
             * An instance of [Beta] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Beta: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Beta>(Beta::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Beta {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Beta(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Beta(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Beta(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Beta>(Beta::class) {

            override fun serialize(
                value: Beta,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Beta")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DpoHyperparameters &&
            batchSize == other.batchSize &&
            beta == other.beta &&
            learningRateMultiplier == other.learningRateMultiplier &&
            nEpochs == other.nEpochs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(batchSize, beta, learningRateMultiplier, nEpochs, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DpoHyperparameters{batchSize=$batchSize, beta=$beta, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
}
