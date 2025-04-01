// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/**
 * The `fine_tuning.job.checkpoint` object represents a model checkpoint for a fine-tuning job that
 * is ready to use.
 */
class FineTuningJobCheckpoint
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val fineTunedModelCheckpoint: JsonField<String>,
    private val fineTuningJobId: JsonField<String>,
    private val metrics: JsonField<Metrics>,
    private val object_: JsonValue,
    private val stepNumber: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("fine_tuned_model_checkpoint")
        @ExcludeMissing
        fineTunedModelCheckpoint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fine_tuning_job_id")
        @ExcludeMissing
        fineTuningJobId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<Metrics> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("step_number") @ExcludeMissing stepNumber: JsonField<Long> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        fineTunedModelCheckpoint,
        fineTuningJobId,
        metrics,
        object_,
        stepNumber,
        mutableMapOf(),
    )

    /**
     * The checkpoint identifier, which can be referenced in the API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) for when the checkpoint was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The name of the fine-tuned checkpoint model that is created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fineTunedModelCheckpoint(): String =
        fineTunedModelCheckpoint.getRequired("fine_tuned_model_checkpoint")

    /**
     * The name of the fine-tuning job that this checkpoint was created from.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fineTuningJobId(): String = fineTuningJobId.getRequired("fine_tuning_job_id")

    /**
     * Metrics at the step number during the fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun metrics(): Metrics = metrics.getRequired("metrics")

    /**
     * The object type, which is always "fine_tuning.job.checkpoint".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("fine_tuning.job.checkpoint")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The step number that the checkpoint was created at.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stepNumber(): Long = stepNumber.getRequired("step_number")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [fineTunedModelCheckpoint].
     *
     * Unlike [fineTunedModelCheckpoint], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("fine_tuned_model_checkpoint")
    @ExcludeMissing
    fun _fineTunedModelCheckpoint(): JsonField<String> = fineTunedModelCheckpoint

    /**
     * Returns the raw JSON value of [fineTuningJobId].
     *
     * Unlike [fineTuningJobId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fine_tuning_job_id")
    @ExcludeMissing
    fun _fineTuningJobId(): JsonField<String> = fineTuningJobId

    /**
     * Returns the raw JSON value of [metrics].
     *
     * Unlike [metrics], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<Metrics> = metrics

    /**
     * Returns the raw JSON value of [stepNumber].
     *
     * Unlike [stepNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("step_number") @ExcludeMissing fun _stepNumber(): JsonField<Long> = stepNumber

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
         * Returns a mutable builder for constructing an instance of [FineTuningJobCheckpoint].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .fineTunedModelCheckpoint()
         * .fineTuningJobId()
         * .metrics()
         * .stepNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FineTuningJobCheckpoint]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var fineTunedModelCheckpoint: JsonField<String>? = null
        private var fineTuningJobId: JsonField<String>? = null
        private var metrics: JsonField<Metrics>? = null
        private var object_: JsonValue = JsonValue.from("fine_tuning.job.checkpoint")
        private var stepNumber: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobCheckpoint: FineTuningJobCheckpoint) = apply {
            id = fineTuningJobCheckpoint.id
            createdAt = fineTuningJobCheckpoint.createdAt
            fineTunedModelCheckpoint = fineTuningJobCheckpoint.fineTunedModelCheckpoint
            fineTuningJobId = fineTuningJobCheckpoint.fineTuningJobId
            metrics = fineTuningJobCheckpoint.metrics
            object_ = fineTuningJobCheckpoint.object_
            stepNumber = fineTuningJobCheckpoint.stepNumber
            additionalProperties = fineTuningJobCheckpoint.additionalProperties.toMutableMap()
        }

        /** The checkpoint identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the checkpoint was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the fine-tuned checkpoint model that is created. */
        fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: String) =
            fineTunedModelCheckpoint(JsonField.of(fineTunedModelCheckpoint))

        /**
         * Sets [Builder.fineTunedModelCheckpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fineTunedModelCheckpoint] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: JsonField<String>) = apply {
            this.fineTunedModelCheckpoint = fineTunedModelCheckpoint
        }

        /** The name of the fine-tuning job that this checkpoint was created from. */
        fun fineTuningJobId(fineTuningJobId: String) =
            fineTuningJobId(JsonField.of(fineTuningJobId))

        /**
         * Sets [Builder.fineTuningJobId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fineTuningJobId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fineTuningJobId(fineTuningJobId: JsonField<String>) = apply {
            this.fineTuningJobId = fineTuningJobId
        }

        /** Metrics at the step number during the fine-tuning job. */
        fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

        /**
         * Sets [Builder.metrics] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metrics] with a well-typed [Metrics] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun metrics(metrics: JsonField<Metrics>) = apply { this.metrics = metrics }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("fine_tuning.job.checkpoint")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The step number that the checkpoint was created at. */
        fun stepNumber(stepNumber: Long) = stepNumber(JsonField.of(stepNumber))

        /**
         * Sets [Builder.stepNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stepNumber] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stepNumber(stepNumber: JsonField<Long>) = apply { this.stepNumber = stepNumber }

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
         * Returns an immutable instance of [FineTuningJobCheckpoint].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .fineTunedModelCheckpoint()
         * .fineTuningJobId()
         * .metrics()
         * .stepNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FineTuningJobCheckpoint =
            FineTuningJobCheckpoint(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("fineTunedModelCheckpoint", fineTunedModelCheckpoint),
                checkRequired("fineTuningJobId", fineTuningJobId),
                checkRequired("metrics", metrics),
                object_,
                checkRequired("stepNumber", stepNumber),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FineTuningJobCheckpoint = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        fineTunedModelCheckpoint()
        fineTuningJobId()
        metrics().validate()
        _object_().let {
            if (it != JsonValue.from("fine_tuning.job.checkpoint")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        stepNumber()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (fineTunedModelCheckpoint.asKnown().isPresent) 1 else 0) +
            (if (fineTuningJobId.asKnown().isPresent) 1 else 0) +
            (metrics.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("fine_tuning.job.checkpoint")) 1 else 0 } +
            (if (stepNumber.asKnown().isPresent) 1 else 0)

    /** Metrics at the step number during the fine-tuning job. */
    class Metrics
    private constructor(
        private val fullValidLoss: JsonField<Double>,
        private val fullValidMeanTokenAccuracy: JsonField<Double>,
        private val step: JsonField<Double>,
        private val trainLoss: JsonField<Double>,
        private val trainMeanTokenAccuracy: JsonField<Double>,
        private val validLoss: JsonField<Double>,
        private val validMeanTokenAccuracy: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("full_valid_loss")
            @ExcludeMissing
            fullValidLoss: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("full_valid_mean_token_accuracy")
            @ExcludeMissing
            fullValidMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("step") @ExcludeMissing step: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("train_loss")
            @ExcludeMissing
            trainLoss: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("train_mean_token_accuracy")
            @ExcludeMissing
            trainMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("valid_loss")
            @ExcludeMissing
            validLoss: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("valid_mean_token_accuracy")
            @ExcludeMissing
            validMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
        ) : this(
            fullValidLoss,
            fullValidMeanTokenAccuracy,
            step,
            trainLoss,
            trainMeanTokenAccuracy,
            validLoss,
            validMeanTokenAccuracy,
            mutableMapOf(),
        )

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fullValidLoss(): Optional<Double> =
            Optional.ofNullable(fullValidLoss.getNullable("full_valid_loss"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fullValidMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(
                fullValidMeanTokenAccuracy.getNullable("full_valid_mean_token_accuracy")
            )

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun step(): Optional<Double> = Optional.ofNullable(step.getNullable("step"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun trainLoss(): Optional<Double> = Optional.ofNullable(trainLoss.getNullable("train_loss"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun trainMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(trainMeanTokenAccuracy.getNullable("train_mean_token_accuracy"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun validLoss(): Optional<Double> = Optional.ofNullable(validLoss.getNullable("valid_loss"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun validMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(validMeanTokenAccuracy.getNullable("valid_mean_token_accuracy"))

        /**
         * Returns the raw JSON value of [fullValidLoss].
         *
         * Unlike [fullValidLoss], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("full_valid_loss")
        @ExcludeMissing
        fun _fullValidLoss(): JsonField<Double> = fullValidLoss

        /**
         * Returns the raw JSON value of [fullValidMeanTokenAccuracy].
         *
         * Unlike [fullValidMeanTokenAccuracy], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("full_valid_mean_token_accuracy")
        @ExcludeMissing
        fun _fullValidMeanTokenAccuracy(): JsonField<Double> = fullValidMeanTokenAccuracy

        /**
         * Returns the raw JSON value of [step].
         *
         * Unlike [step], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("step") @ExcludeMissing fun _step(): JsonField<Double> = step

        /**
         * Returns the raw JSON value of [trainLoss].
         *
         * Unlike [trainLoss], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("train_loss") @ExcludeMissing fun _trainLoss(): JsonField<Double> = trainLoss

        /**
         * Returns the raw JSON value of [trainMeanTokenAccuracy].
         *
         * Unlike [trainMeanTokenAccuracy], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("train_mean_token_accuracy")
        @ExcludeMissing
        fun _trainMeanTokenAccuracy(): JsonField<Double> = trainMeanTokenAccuracy

        /**
         * Returns the raw JSON value of [validLoss].
         *
         * Unlike [validLoss], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("valid_loss") @ExcludeMissing fun _validLoss(): JsonField<Double> = validLoss

        /**
         * Returns the raw JSON value of [validMeanTokenAccuracy].
         *
         * Unlike [validMeanTokenAccuracy], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("valid_mean_token_accuracy")
        @ExcludeMissing
        fun _validMeanTokenAccuracy(): JsonField<Double> = validMeanTokenAccuracy

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

            /** Returns a mutable builder for constructing an instance of [Metrics]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metrics]. */
        class Builder internal constructor() {

            private var fullValidLoss: JsonField<Double> = JsonMissing.of()
            private var fullValidMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var step: JsonField<Double> = JsonMissing.of()
            private var trainLoss: JsonField<Double> = JsonMissing.of()
            private var trainMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var validLoss: JsonField<Double> = JsonMissing.of()
            private var validMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metrics: Metrics) = apply {
                fullValidLoss = metrics.fullValidLoss
                fullValidMeanTokenAccuracy = metrics.fullValidMeanTokenAccuracy
                step = metrics.step
                trainLoss = metrics.trainLoss
                trainMeanTokenAccuracy = metrics.trainMeanTokenAccuracy
                validLoss = metrics.validLoss
                validMeanTokenAccuracy = metrics.validMeanTokenAccuracy
                additionalProperties = metrics.additionalProperties.toMutableMap()
            }

            fun fullValidLoss(fullValidLoss: Double) = fullValidLoss(JsonField.of(fullValidLoss))

            /**
             * Sets [Builder.fullValidLoss] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fullValidLoss] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fullValidLoss(fullValidLoss: JsonField<Double>) = apply {
                this.fullValidLoss = fullValidLoss
            }

            fun fullValidMeanTokenAccuracy(fullValidMeanTokenAccuracy: Double) =
                fullValidMeanTokenAccuracy(JsonField.of(fullValidMeanTokenAccuracy))

            /**
             * Sets [Builder.fullValidMeanTokenAccuracy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fullValidMeanTokenAccuracy] with a well-typed
             * [Double] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun fullValidMeanTokenAccuracy(fullValidMeanTokenAccuracy: JsonField<Double>) = apply {
                this.fullValidMeanTokenAccuracy = fullValidMeanTokenAccuracy
            }

            fun step(step: Double) = step(JsonField.of(step))

            /**
             * Sets [Builder.step] to an arbitrary JSON value.
             *
             * You should usually call [Builder.step] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun step(step: JsonField<Double>) = apply { this.step = step }

            fun trainLoss(trainLoss: Double) = trainLoss(JsonField.of(trainLoss))

            /**
             * Sets [Builder.trainLoss] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trainLoss] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun trainLoss(trainLoss: JsonField<Double>) = apply { this.trainLoss = trainLoss }

            fun trainMeanTokenAccuracy(trainMeanTokenAccuracy: Double) =
                trainMeanTokenAccuracy(JsonField.of(trainMeanTokenAccuracy))

            /**
             * Sets [Builder.trainMeanTokenAccuracy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trainMeanTokenAccuracy] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun trainMeanTokenAccuracy(trainMeanTokenAccuracy: JsonField<Double>) = apply {
                this.trainMeanTokenAccuracy = trainMeanTokenAccuracy
            }

            fun validLoss(validLoss: Double) = validLoss(JsonField.of(validLoss))

            /**
             * Sets [Builder.validLoss] to an arbitrary JSON value.
             *
             * You should usually call [Builder.validLoss] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun validLoss(validLoss: JsonField<Double>) = apply { this.validLoss = validLoss }

            fun validMeanTokenAccuracy(validMeanTokenAccuracy: Double) =
                validMeanTokenAccuracy(JsonField.of(validMeanTokenAccuracy))

            /**
             * Sets [Builder.validMeanTokenAccuracy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.validMeanTokenAccuracy] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun validMeanTokenAccuracy(validMeanTokenAccuracy: JsonField<Double>) = apply {
                this.validMeanTokenAccuracy = validMeanTokenAccuracy
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
             * Returns an immutable instance of [Metrics].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metrics =
                Metrics(
                    fullValidLoss,
                    fullValidMeanTokenAccuracy,
                    step,
                    trainLoss,
                    trainMeanTokenAccuracy,
                    validLoss,
                    validMeanTokenAccuracy,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Metrics = apply {
            if (validated) {
                return@apply
            }

            fullValidLoss()
            fullValidMeanTokenAccuracy()
            step()
            trainLoss()
            trainMeanTokenAccuracy()
            validLoss()
            validMeanTokenAccuracy()
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
            (if (fullValidLoss.asKnown().isPresent) 1 else 0) +
                (if (fullValidMeanTokenAccuracy.asKnown().isPresent) 1 else 0) +
                (if (step.asKnown().isPresent) 1 else 0) +
                (if (trainLoss.asKnown().isPresent) 1 else 0) +
                (if (trainMeanTokenAccuracy.asKnown().isPresent) 1 else 0) +
                (if (validLoss.asKnown().isPresent) 1 else 0) +
                (if (validMeanTokenAccuracy.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metrics && fullValidLoss == other.fullValidLoss && fullValidMeanTokenAccuracy == other.fullValidMeanTokenAccuracy && step == other.step && trainLoss == other.trainLoss && trainMeanTokenAccuracy == other.trainMeanTokenAccuracy && validLoss == other.validLoss && validMeanTokenAccuracy == other.validMeanTokenAccuracy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fullValidLoss, fullValidMeanTokenAccuracy, step, trainLoss, trainMeanTokenAccuracy, validLoss, validMeanTokenAccuracy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Metrics{fullValidLoss=$fullValidLoss, fullValidMeanTokenAccuracy=$fullValidMeanTokenAccuracy, step=$step, trainLoss=$trainLoss, trainMeanTokenAccuracy=$trainMeanTokenAccuracy, validLoss=$validLoss, validMeanTokenAccuracy=$validMeanTokenAccuracy, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobCheckpoint && id == other.id && createdAt == other.createdAt && fineTunedModelCheckpoint == other.fineTunedModelCheckpoint && fineTuningJobId == other.fineTuningJobId && metrics == other.metrics && object_ == other.object_ && stepNumber == other.stepNumber && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, fineTunedModelCheckpoint, fineTuningJobId, metrics, object_, stepNumber, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobCheckpoint{id=$id, createdAt=$createdAt, fineTunedModelCheckpoint=$fineTunedModelCheckpoint, fineTuningJobId=$fineTuningJobId, metrics=$metrics, object_=$object_, stepNumber=$stepNumber, additionalProperties=$additionalProperties}"
}
