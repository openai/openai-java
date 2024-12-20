// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * The `fine_tuning.job.checkpoint` object represents a model checkpoint for a fine-tuning job that
 * is ready to use.
 */
@NoAutoDetect
class FineTuningJobCheckpoint
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("fine_tuned_model_checkpoint")
    @ExcludeMissing
    private val fineTunedModelCheckpoint: JsonField<String> = JsonMissing.of(),
    @JsonProperty("step_number")
    @ExcludeMissing
    private val stepNumber: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("metrics")
    @ExcludeMissing
    private val metrics: JsonField<Metrics> = JsonMissing.of(),
    @JsonProperty("fine_tuning_job_id")
    @ExcludeMissing
    private val fineTuningJobId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The checkpoint identifier, which can be referenced in the API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the checkpoint was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the fine-tuned checkpoint model that is created. */
    fun fineTunedModelCheckpoint(): String =
        fineTunedModelCheckpoint.getRequired("fine_tuned_model_checkpoint")

    /** The step number that the checkpoint was created at. */
    fun stepNumber(): Long = stepNumber.getRequired("step_number")

    /** Metrics at the step number during the fine-tuning job. */
    fun metrics(): Metrics = metrics.getRequired("metrics")

    /** The name of the fine-tuning job that this checkpoint was created from. */
    fun fineTuningJobId(): String = fineTuningJobId.getRequired("fine_tuning_job_id")

    /** The object type, which is always "fine_tuning.job.checkpoint". */
    fun object_(): Object = object_.getRequired("object")

    /** The checkpoint identifier, which can be referenced in the API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the checkpoint was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the fine-tuned checkpoint model that is created. */
    @JsonProperty("fine_tuned_model_checkpoint")
    @ExcludeMissing
    fun _fineTunedModelCheckpoint() = fineTunedModelCheckpoint

    /** The step number that the checkpoint was created at. */
    @JsonProperty("step_number") @ExcludeMissing fun _stepNumber() = stepNumber

    /** Metrics at the step number during the fine-tuning job. */
    @JsonProperty("metrics") @ExcludeMissing fun _metrics() = metrics

    /** The name of the fine-tuning job that this checkpoint was created from. */
    @JsonProperty("fine_tuning_job_id") @ExcludeMissing fun _fineTuningJobId() = fineTuningJobId

    /** The object type, which is always "fine_tuning.job.checkpoint". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FineTuningJobCheckpoint = apply {
        if (!validated) {
            id()
            createdAt()
            fineTunedModelCheckpoint()
            stepNumber()
            metrics().validate()
            fineTuningJobId()
            object_()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var fineTunedModelCheckpoint: JsonField<String> = JsonMissing.of()
        private var stepNumber: JsonField<Long> = JsonMissing.of()
        private var metrics: JsonField<Metrics> = JsonMissing.of()
        private var fineTuningJobId: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobCheckpoint: FineTuningJobCheckpoint) = apply {
            id = fineTuningJobCheckpoint.id
            createdAt = fineTuningJobCheckpoint.createdAt
            fineTunedModelCheckpoint = fineTuningJobCheckpoint.fineTunedModelCheckpoint
            stepNumber = fineTuningJobCheckpoint.stepNumber
            metrics = fineTuningJobCheckpoint.metrics
            fineTuningJobId = fineTuningJobCheckpoint.fineTuningJobId
            object_ = fineTuningJobCheckpoint.object_
            additionalProperties = fineTuningJobCheckpoint.additionalProperties.toMutableMap()
        }

        /** The checkpoint identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The checkpoint identifier, which can be referenced in the API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the checkpoint was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the checkpoint was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the fine-tuned checkpoint model that is created. */
        fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: String) =
            fineTunedModelCheckpoint(JsonField.of(fineTunedModelCheckpoint))

        /** The name of the fine-tuned checkpoint model that is created. */
        fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: JsonField<String>) = apply {
            this.fineTunedModelCheckpoint = fineTunedModelCheckpoint
        }

        /** The step number that the checkpoint was created at. */
        fun stepNumber(stepNumber: Long) = stepNumber(JsonField.of(stepNumber))

        /** The step number that the checkpoint was created at. */
        fun stepNumber(stepNumber: JsonField<Long>) = apply { this.stepNumber = stepNumber }

        /** Metrics at the step number during the fine-tuning job. */
        fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

        /** Metrics at the step number during the fine-tuning job. */
        fun metrics(metrics: JsonField<Metrics>) = apply { this.metrics = metrics }

        /** The name of the fine-tuning job that this checkpoint was created from. */
        fun fineTuningJobId(fineTuningJobId: String) =
            fineTuningJobId(JsonField.of(fineTuningJobId))

        /** The name of the fine-tuning job that this checkpoint was created from. */
        fun fineTuningJobId(fineTuningJobId: JsonField<String>) = apply {
            this.fineTuningJobId = fineTuningJobId
        }

        /** The object type, which is always "fine_tuning.job.checkpoint". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "fine_tuning.job.checkpoint". */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

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

        fun build(): FineTuningJobCheckpoint =
            FineTuningJobCheckpoint(
                id,
                createdAt,
                fineTunedModelCheckpoint,
                stepNumber,
                metrics,
                fineTuningJobId,
                object_,
                additionalProperties.toImmutable(),
            )
    }

    /** Metrics at the step number during the fine-tuning job. */
    @NoAutoDetect
    class Metrics
    @JsonCreator
    private constructor(
        @JsonProperty("step")
        @ExcludeMissing
        private val step: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("train_loss")
        @ExcludeMissing
        private val trainLoss: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("train_mean_token_accuracy")
        @ExcludeMissing
        private val trainMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("valid_loss")
        @ExcludeMissing
        private val validLoss: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("valid_mean_token_accuracy")
        @ExcludeMissing
        private val validMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("full_valid_loss")
        @ExcludeMissing
        private val fullValidLoss: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("full_valid_mean_token_accuracy")
        @ExcludeMissing
        private val fullValidMeanTokenAccuracy: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun step(): Optional<Double> = Optional.ofNullable(step.getNullable("step"))

        fun trainLoss(): Optional<Double> = Optional.ofNullable(trainLoss.getNullable("train_loss"))

        fun trainMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(trainMeanTokenAccuracy.getNullable("train_mean_token_accuracy"))

        fun validLoss(): Optional<Double> = Optional.ofNullable(validLoss.getNullable("valid_loss"))

        fun validMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(validMeanTokenAccuracy.getNullable("valid_mean_token_accuracy"))

        fun fullValidLoss(): Optional<Double> =
            Optional.ofNullable(fullValidLoss.getNullable("full_valid_loss"))

        fun fullValidMeanTokenAccuracy(): Optional<Double> =
            Optional.ofNullable(
                fullValidMeanTokenAccuracy.getNullable("full_valid_mean_token_accuracy")
            )

        @JsonProperty("step") @ExcludeMissing fun _step() = step

        @JsonProperty("train_loss") @ExcludeMissing fun _trainLoss() = trainLoss

        @JsonProperty("train_mean_token_accuracy")
        @ExcludeMissing
        fun _trainMeanTokenAccuracy() = trainMeanTokenAccuracy

        @JsonProperty("valid_loss") @ExcludeMissing fun _validLoss() = validLoss

        @JsonProperty("valid_mean_token_accuracy")
        @ExcludeMissing
        fun _validMeanTokenAccuracy() = validMeanTokenAccuracy

        @JsonProperty("full_valid_loss") @ExcludeMissing fun _fullValidLoss() = fullValidLoss

        @JsonProperty("full_valid_mean_token_accuracy")
        @ExcludeMissing
        fun _fullValidMeanTokenAccuracy() = fullValidMeanTokenAccuracy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Metrics = apply {
            if (!validated) {
                step()
                trainLoss()
                trainMeanTokenAccuracy()
                validLoss()
                validMeanTokenAccuracy()
                fullValidLoss()
                fullValidMeanTokenAccuracy()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var step: JsonField<Double> = JsonMissing.of()
            private var trainLoss: JsonField<Double> = JsonMissing.of()
            private var trainMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var validLoss: JsonField<Double> = JsonMissing.of()
            private var validMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var fullValidLoss: JsonField<Double> = JsonMissing.of()
            private var fullValidMeanTokenAccuracy: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metrics: Metrics) = apply {
                step = metrics.step
                trainLoss = metrics.trainLoss
                trainMeanTokenAccuracy = metrics.trainMeanTokenAccuracy
                validLoss = metrics.validLoss
                validMeanTokenAccuracy = metrics.validMeanTokenAccuracy
                fullValidLoss = metrics.fullValidLoss
                fullValidMeanTokenAccuracy = metrics.fullValidMeanTokenAccuracy
                additionalProperties = metrics.additionalProperties.toMutableMap()
            }

            fun step(step: Double) = step(JsonField.of(step))

            fun step(step: JsonField<Double>) = apply { this.step = step }

            fun trainLoss(trainLoss: Double) = trainLoss(JsonField.of(trainLoss))

            fun trainLoss(trainLoss: JsonField<Double>) = apply { this.trainLoss = trainLoss }

            fun trainMeanTokenAccuracy(trainMeanTokenAccuracy: Double) =
                trainMeanTokenAccuracy(JsonField.of(trainMeanTokenAccuracy))

            fun trainMeanTokenAccuracy(trainMeanTokenAccuracy: JsonField<Double>) = apply {
                this.trainMeanTokenAccuracy = trainMeanTokenAccuracy
            }

            fun validLoss(validLoss: Double) = validLoss(JsonField.of(validLoss))

            fun validLoss(validLoss: JsonField<Double>) = apply { this.validLoss = validLoss }

            fun validMeanTokenAccuracy(validMeanTokenAccuracy: Double) =
                validMeanTokenAccuracy(JsonField.of(validMeanTokenAccuracy))

            fun validMeanTokenAccuracy(validMeanTokenAccuracy: JsonField<Double>) = apply {
                this.validMeanTokenAccuracy = validMeanTokenAccuracy
            }

            fun fullValidLoss(fullValidLoss: Double) = fullValidLoss(JsonField.of(fullValidLoss))

            fun fullValidLoss(fullValidLoss: JsonField<Double>) = apply {
                this.fullValidLoss = fullValidLoss
            }

            fun fullValidMeanTokenAccuracy(fullValidMeanTokenAccuracy: Double) =
                fullValidMeanTokenAccuracy(JsonField.of(fullValidMeanTokenAccuracy))

            fun fullValidMeanTokenAccuracy(fullValidMeanTokenAccuracy: JsonField<Double>) = apply {
                this.fullValidMeanTokenAccuracy = fullValidMeanTokenAccuracy
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

            fun build(): Metrics =
                Metrics(
                    step,
                    trainLoss,
                    trainMeanTokenAccuracy,
                    validLoss,
                    validMeanTokenAccuracy,
                    fullValidLoss,
                    fullValidMeanTokenAccuracy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metrics && step == other.step && trainLoss == other.trainLoss && trainMeanTokenAccuracy == other.trainMeanTokenAccuracy && validLoss == other.validLoss && validMeanTokenAccuracy == other.validMeanTokenAccuracy && fullValidLoss == other.fullValidLoss && fullValidMeanTokenAccuracy == other.fullValidMeanTokenAccuracy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(step, trainLoss, trainMeanTokenAccuracy, validLoss, validMeanTokenAccuracy, fullValidLoss, fullValidMeanTokenAccuracy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Metrics{step=$step, trainLoss=$trainLoss, trainMeanTokenAccuracy=$trainMeanTokenAccuracy, validLoss=$validLoss, validMeanTokenAccuracy=$validMeanTokenAccuracy, fullValidLoss=$fullValidLoss, fullValidMeanTokenAccuracy=$fullValidMeanTokenAccuracy, additionalProperties=$additionalProperties}"
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FINE_TUNING_JOB_CHECKPOINT = of("fine_tuning.job.checkpoint")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            FINE_TUNING_JOB_CHECKPOINT,
        }

        enum class Value {
            FINE_TUNING_JOB_CHECKPOINT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FINE_TUNING_JOB_CHECKPOINT -> Value.FINE_TUNING_JOB_CHECKPOINT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FINE_TUNING_JOB_CHECKPOINT -> Known.FINE_TUNING_JOB_CHECKPOINT
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobCheckpoint && id == other.id && createdAt == other.createdAt && fineTunedModelCheckpoint == other.fineTunedModelCheckpoint && stepNumber == other.stepNumber && metrics == other.metrics && fineTuningJobId == other.fineTuningJobId && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, fineTunedModelCheckpoint, stepNumber, metrics, fineTuningJobId, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobCheckpoint{id=$id, createdAt=$createdAt, fineTunedModelCheckpoint=$fineTunedModelCheckpoint, stepNumber=$stepNumber, metrics=$metrics, fineTuningJobId=$fineTuningJobId, object_=$object_, additionalProperties=$additionalProperties}"
}
