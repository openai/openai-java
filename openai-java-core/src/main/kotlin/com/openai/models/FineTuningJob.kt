// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * The `fine_tuning.job` object represents a fine-tuning job that has been created through the API.
 */
@JsonDeserialize(builder = FineTuningJob.Builder::class)
@NoAutoDetect
class FineTuningJob
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val error: JsonField<Error>,
    private val fineTunedModel: JsonField<String>,
    private val finishedAt: JsonField<Long>,
    private val hyperparameters: JsonField<Hyperparameters>,
    private val model: JsonField<String>,
    private val object_: JsonField<Object>,
    private val organizationId: JsonField<String>,
    private val resultFiles: JsonField<List<String>>,
    private val status: JsonField<Status>,
    private val trainedTokens: JsonField<Long>,
    private val trainingFile: JsonField<String>,
    private val validationFile: JsonField<String>,
    private val integrations: JsonField<List<FineTuningJobWandbIntegrationObject>>,
    private val seed: JsonField<Long>,
    private val estimatedFinish: JsonField<Long>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The object identifier, which can be referenced in the API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    fun error(): Optional<Error> = Optional.ofNullable(error.getNullable("error"))

    /**
     * The name of the fine-tuned model that is being created. The value will be null if the
     * fine-tuning job is still running.
     */
    fun fineTunedModel(): Optional<String> =
        Optional.ofNullable(fineTunedModel.getNullable("fine_tuned_model"))

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will be
     * null if the fine-tuning job is still running.
     */
    fun finishedAt(): Optional<Long> = Optional.ofNullable(finishedAt.getNullable("finished_at"))

    /**
     * The hyperparameters used for the fine-tuning job. See the
     * [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more details.
     */
    fun hyperparameters(): Hyperparameters = hyperparameters.getRequired("hyperparameters")

    /** The base model that is being fine-tuned. */
    fun model(): String = model.getRequired("model")

    /** The object type, which is always "fine_tuning.job". */
    fun object_(): Object = object_.getRequired("object")

    /** The organization that owns the fine-tuning job. */
    fun organizationId(): String = organizationId.getRequired("organization_id")

    /**
     * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results with
     * the [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    fun resultFiles(): List<String> = resultFiles.getRequired("result_files")

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The total number of billable tokens processed by this fine-tuning job. The value will be null
     * if the fine-tuning job is still running.
     */
    fun trainedTokens(): Optional<Long> =
        Optional.ofNullable(trainedTokens.getNullable("trained_tokens"))

    /**
     * The file ID used for training. You can retrieve the training data with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    fun trainingFile(): String = trainingFile.getRequired("training_file")

    /**
     * The file ID used for validation. You can retrieve the validation results with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    fun validationFile(): Optional<String> =
        Optional.ofNullable(validationFile.getNullable("validation_file"))

    /** A list of integrations to enable for this fine-tuning job. */
    fun integrations(): Optional<List<FineTuningJobWandbIntegrationObject>> =
        Optional.ofNullable(integrations.getNullable("integrations"))

    /** The seed used for the fine-tuning job. */
    fun seed(): Long = seed.getRequired("seed")

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
     * value will be null if the fine-tuning job is not running.
     */
    fun estimatedFinish(): Optional<Long> =
        Optional.ofNullable(estimatedFinish.getNullable("estimated_finish"))

    /** The object identifier, which can be referenced in the API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    @JsonProperty("error") @ExcludeMissing fun _error() = error

    /**
     * The name of the fine-tuned model that is being created. The value will be null if the
     * fine-tuning job is still running.
     */
    @JsonProperty("fine_tuned_model") @ExcludeMissing fun _fineTunedModel() = fineTunedModel

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will be
     * null if the fine-tuning job is still running.
     */
    @JsonProperty("finished_at") @ExcludeMissing fun _finishedAt() = finishedAt

    /**
     * The hyperparameters used for the fine-tuning job. See the
     * [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more details.
     */
    @JsonProperty("hyperparameters") @ExcludeMissing fun _hyperparameters() = hyperparameters

    /** The base model that is being fine-tuned. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /** The object type, which is always "fine_tuning.job". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The organization that owns the fine-tuning job. */
    @JsonProperty("organization_id") @ExcludeMissing fun _organizationId() = organizationId

    /**
     * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results with
     * the [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("result_files") @ExcludeMissing fun _resultFiles() = resultFiles

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * The total number of billable tokens processed by this fine-tuning job. The value will be null
     * if the fine-tuning job is still running.
     */
    @JsonProperty("trained_tokens") @ExcludeMissing fun _trainedTokens() = trainedTokens

    /**
     * The file ID used for training. You can retrieve the training data with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("training_file") @ExcludeMissing fun _trainingFile() = trainingFile

    /**
     * The file ID used for validation. You can retrieve the validation results with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("validation_file") @ExcludeMissing fun _validationFile() = validationFile

    /** A list of integrations to enable for this fine-tuning job. */
    @JsonProperty("integrations") @ExcludeMissing fun _integrations() = integrations

    /** The seed used for the fine-tuning job. */
    @JsonProperty("seed") @ExcludeMissing fun _seed() = seed

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
     * value will be null if the fine-tuning job is not running.
     */
    @JsonProperty("estimated_finish") @ExcludeMissing fun _estimatedFinish() = estimatedFinish

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FineTuningJob = apply {
        if (!validated) {
            id()
            createdAt()
            error().map { it.validate() }
            fineTunedModel()
            finishedAt()
            hyperparameters().validate()
            model()
            object_()
            organizationId()
            resultFiles()
            status()
            trainedTokens()
            trainingFile()
            validationFile()
            integrations().map { it.forEach { it.validate() } }
            seed()
            estimatedFinish()
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
        private var error: JsonField<Error> = JsonMissing.of()
        private var fineTunedModel: JsonField<String> = JsonMissing.of()
        private var finishedAt: JsonField<Long> = JsonMissing.of()
        private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var resultFiles: JsonField<List<String>> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var trainedTokens: JsonField<Long> = JsonMissing.of()
        private var trainingFile: JsonField<String> = JsonMissing.of()
        private var validationFile: JsonField<String> = JsonMissing.of()
        private var integrations: JsonField<List<FineTuningJobWandbIntegrationObject>> =
            JsonMissing.of()
        private var seed: JsonField<Long> = JsonMissing.of()
        private var estimatedFinish: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJob: FineTuningJob) = apply {
            this.id = fineTuningJob.id
            this.createdAt = fineTuningJob.createdAt
            this.error = fineTuningJob.error
            this.fineTunedModel = fineTuningJob.fineTunedModel
            this.finishedAt = fineTuningJob.finishedAt
            this.hyperparameters = fineTuningJob.hyperparameters
            this.model = fineTuningJob.model
            this.object_ = fineTuningJob.object_
            this.organizationId = fineTuningJob.organizationId
            this.resultFiles = fineTuningJob.resultFiles
            this.status = fineTuningJob.status
            this.trainedTokens = fineTuningJob.trainedTokens
            this.trainingFile = fineTuningJob.trainingFile
            this.validationFile = fineTuningJob.validationFile
            this.integrations = fineTuningJob.integrations
            this.seed = fineTuningJob.seed
            this.estimatedFinish = fineTuningJob.estimatedFinish
            additionalProperties(fineTuningJob.additionalProperties)
        }

        /** The object identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The object identifier, which can be referenced in the API endpoints. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        fun error(error: Error) = error(JsonField.of(error))

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        @JsonProperty("error")
        @ExcludeMissing
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        fun fineTunedModel(fineTunedModel: String) = fineTunedModel(JsonField.of(fineTunedModel))

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        @JsonProperty("fine_tuned_model")
        @ExcludeMissing
        fun fineTunedModel(fineTunedModel: JsonField<String>) = apply {
            this.fineTunedModel = fineTunedModel
        }

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        fun finishedAt(finishedAt: Long) = finishedAt(JsonField.of(finishedAt))

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        @JsonProperty("finished_at")
        @ExcludeMissing
        fun finishedAt(finishedAt: JsonField<Long>) = apply { this.finishedAt = finishedAt }

        /**
         * The hyperparameters used for the fine-tuning job. See the
         * [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        fun hyperparameters(hyperparameters: Hyperparameters) =
            hyperparameters(JsonField.of(hyperparameters))

        /**
         * The hyperparameters used for the fine-tuning job. See the
         * [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        @JsonProperty("hyperparameters")
        @ExcludeMissing
        fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
            this.hyperparameters = hyperparameters
        }

        /** The base model that is being fine-tuned. */
        fun model(model: String) = model(JsonField.of(model))

        /** The base model that is being fine-tuned. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type, which is always "fine_tuning.job". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "fine_tuning.job". */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The organization that owns the fine-tuning job. */
        fun organizationId(organizationId: String) = organizationId(JsonField.of(organizationId))

        /** The organization that owns the fine-tuning job. */
        @JsonProperty("organization_id")
        @ExcludeMissing
        fun organizationId(organizationId: JsonField<String>) = apply {
            this.organizationId = organizationId
        }

        /**
         * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results
         * with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun resultFiles(resultFiles: List<String>) = resultFiles(JsonField.of(resultFiles))

        /**
         * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results
         * with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        @JsonProperty("result_files")
        @ExcludeMissing
        fun resultFiles(resultFiles: JsonField<List<String>>) = apply {
            this.resultFiles = resultFiles
        }

        /**
         * The current status of the fine-tuning job, which can be either `validating_files`,
         * `queued`, `running`, `succeeded`, `failed`, or `cancelled`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The current status of the fine-tuning job, which can be either `validating_files`,
         * `queued`, `running`, `succeeded`, `failed`, or `cancelled`.
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        fun trainedTokens(trainedTokens: Long) = trainedTokens(JsonField.of(trainedTokens))

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        @JsonProperty("trained_tokens")
        @ExcludeMissing
        fun trainedTokens(trainedTokens: JsonField<Long>) = apply {
            this.trainedTokens = trainedTokens
        }

        /**
         * The file ID used for training. You can retrieve the training data with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun trainingFile(trainingFile: String) = trainingFile(JsonField.of(trainingFile))

        /**
         * The file ID used for training. You can retrieve the training data with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        @JsonProperty("training_file")
        @ExcludeMissing
        fun trainingFile(trainingFile: JsonField<String>) = apply {
            this.trainingFile = trainingFile
        }

        /**
         * The file ID used for validation. You can retrieve the validation results with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun validationFile(validationFile: String) = validationFile(JsonField.of(validationFile))

        /**
         * The file ID used for validation. You can retrieve the validation results with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        @JsonProperty("validation_file")
        @ExcludeMissing
        fun validationFile(validationFile: JsonField<String>) = apply {
            this.validationFile = validationFile
        }

        /** A list of integrations to enable for this fine-tuning job. */
        fun integrations(integrations: List<FineTuningJobWandbIntegrationObject>) =
            integrations(JsonField.of(integrations))

        /** A list of integrations to enable for this fine-tuning job. */
        @JsonProperty("integrations")
        @ExcludeMissing
        fun integrations(integrations: JsonField<List<FineTuningJobWandbIntegrationObject>>) =
            apply {
                this.integrations = integrations
            }

        /** The seed used for the fine-tuning job. */
        fun seed(seed: Long) = seed(JsonField.of(seed))

        /** The seed used for the fine-tuning job. */
        @JsonProperty("seed")
        @ExcludeMissing
        fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        fun estimatedFinish(estimatedFinish: Long) = estimatedFinish(JsonField.of(estimatedFinish))

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        @JsonProperty("estimated_finish")
        @ExcludeMissing
        fun estimatedFinish(estimatedFinish: JsonField<Long>) = apply {
            this.estimatedFinish = estimatedFinish
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): FineTuningJob =
            FineTuningJob(
                id,
                createdAt,
                error,
                fineTunedModel,
                finishedAt,
                hyperparameters,
                model,
                object_,
                organizationId,
                resultFiles.map { it.toImmutable() },
                status,
                trainedTokens,
                trainingFile,
                validationFile,
                integrations.map { it.toImmutable() },
                seed,
                estimatedFinish,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    @JsonDeserialize(builder = Error.Builder::class)
    @NoAutoDetect
    class Error
    private constructor(
        private val code: JsonField<String>,
        private val message: JsonField<String>,
        private val param: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** A machine-readable error code. */
        fun code(): String = code.getRequired("code")

        /** A human-readable error message. */
        fun message(): String = message.getRequired("message")

        /**
         * The parameter that was invalid, usually `training_file` or `validation_file`. This field
         * will be null if the failure was not parameter-specific.
         */
        fun param(): Optional<String> = Optional.ofNullable(param.getNullable("param"))

        /** A machine-readable error code. */
        @JsonProperty("code") @ExcludeMissing fun _code() = code

        /** A human-readable error message. */
        @JsonProperty("message") @ExcludeMissing fun _message() = message

        /**
         * The parameter that was invalid, usually `training_file` or `validation_file`. This field
         * will be null if the failure was not parameter-specific.
         */
        @JsonProperty("param") @ExcludeMissing fun _param() = param

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Error = apply {
            if (!validated) {
                code()
                message()
                param()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var code: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var param: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                this.code = error.code
                this.message = error.message
                this.param = error.param
                additionalProperties(error.additionalProperties)
            }

            /** A machine-readable error code. */
            fun code(code: String) = code(JsonField.of(code))

            /** A machine-readable error code. */
            @JsonProperty("code")
            @ExcludeMissing
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** A human-readable error message. */
            fun message(message: String) = message(JsonField.of(message))

            /** A human-readable error message. */
            @JsonProperty("message")
            @ExcludeMissing
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            fun param(param: String) = param(JsonField.of(param))

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            @JsonProperty("param")
            @ExcludeMissing
            fun param(param: JsonField<String>) = apply { this.param = param }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Error =
                Error(
                    code,
                    message,
                    param,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Error && code == other.code && message == other.message && param == other.param && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(code, message, param, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, message=$message, param=$param, additionalProperties=$additionalProperties}"
    }

    /**
     * The hyperparameters used for the fine-tuning job. See the
     * [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more details.
     */
    @JsonDeserialize(builder = Hyperparameters.Builder::class)
    @NoAutoDetect
    class Hyperparameters
    private constructor(
        private val nEpochs: JsonField<NEpochs>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset. "auto" decides the optimal number of epochs based on the size of
         * the dataset. If setting the number manually, we support any number between 1 and 50
         * epochs.
         */
        fun nEpochs(): NEpochs = nEpochs.getRequired("n_epochs")

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset. "auto" decides the optimal number of epochs based on the size of
         * the dataset. If setting the number manually, we support any number between 1 and 50
         * epochs.
         */
        @JsonProperty("n_epochs") @ExcludeMissing fun _nEpochs() = nEpochs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Hyperparameters = apply {
            if (!validated) {
                nEpochs()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hyperparameters: Hyperparameters) = apply {
                this.nEpochs = hyperparameters.nEpochs
                additionalProperties(hyperparameters.additionalProperties)
            }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset. "auto" decides the optimal number of epochs based on
             * the size of the dataset. If setting the number manually, we support any number
             * between 1 and 50 epochs.
             */
            fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset. "auto" decides the optimal number of epochs based on
             * the size of the dataset. If setting the number manually, we support any number
             * between 1 and 50 epochs.
             */
            @JsonProperty("n_epochs")
            @ExcludeMissing
            fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Hyperparameters =
                Hyperparameters(nEpochs, additionalProperties.toImmutable())
        }

        @JsonDeserialize(using = NEpochs.Deserializer::class)
        @JsonSerialize(using = NEpochs.Serializer::class)
        class NEpochs
        private constructor(
            private val behavior: Behavior? = null,
            private val integer: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)

            fun integer(): Optional<Long> = Optional.ofNullable(integer)

            fun isBehavior(): Boolean = behavior != null

            fun isInteger(): Boolean = integer != null

            fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

            fun asInteger(): Long = integer.getOrThrow("integer")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    behavior != null -> visitor.visitBehavior(behavior)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): NEpochs = apply {
                if (!validated) {
                    if (behavior == null && integer == null) {
                        throw OpenAIInvalidDataException("Unknown NEpochs: $_json")
                    }
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is NEpochs && behavior == other.behavior && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, integer) /* spotless:on */

            override fun toString(): String =
                when {
                    behavior != null -> "NEpochs{behavior=$behavior}"
                    integer != null -> "NEpochs{integer=$integer}"
                    _json != null -> "NEpochs{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid NEpochs")
                }

            companion object {

                @JvmStatic fun ofBehavior(behavior: Behavior) = NEpochs(behavior = behavior)

                @JvmStatic fun ofInteger(integer: Long) = NEpochs(integer = integer)
            }

            interface Visitor<out T> {

                fun visitBehavior(behavior: Behavior): T

                fun visitInteger(integer: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                }
            }

            class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                        return NEpochs(behavior = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return NEpochs(integer = it, _json = json)
                    }

                    return NEpochs(_json = json)
                }
            }

            class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                override fun serialize(
                    value: NEpochs,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.behavior != null -> generator.writeObject(value.behavior)
                        value.integer != null -> generator.writeObject(value.integer)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid NEpochs")
                    }
                }
            }

            class Behavior
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val AUTO = Behavior(JsonField.of("auto"))

                    @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Hyperparameters && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(nEpochs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hyperparameters{nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val FINE_TUNING_JOB = Object(JsonField.of("fine_tuning.job"))

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            FINE_TUNING_JOB,
        }

        enum class Value {
            FINE_TUNING_JOB,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FINE_TUNING_JOB -> Value.FINE_TUNING_JOB
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FINE_TUNING_JOB -> Known.FINE_TUNING_JOB
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VALIDATING_FILES = Status(JsonField.of("validating_files"))

            @JvmField val QUEUED = Status(JsonField.of("queued"))

            @JvmField val RUNNING = Status(JsonField.of("running"))

            @JvmField val SUCCEEDED = Status(JsonField.of("succeeded"))

            @JvmField val FAILED = Status(JsonField.of("failed"))

            @JvmField val CANCELLED = Status(JsonField.of("cancelled"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            VALIDATING_FILES,
            QUEUED,
            RUNNING,
            SUCCEEDED,
            FAILED,
            CANCELLED,
        }

        enum class Value {
            VALIDATING_FILES,
            QUEUED,
            RUNNING,
            SUCCEEDED,
            FAILED,
            CANCELLED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VALIDATING_FILES -> Value.VALIDATING_FILES
                QUEUED -> Value.QUEUED
                RUNNING -> Value.RUNNING
                SUCCEEDED -> Value.SUCCEEDED
                FAILED -> Value.FAILED
                CANCELLED -> Value.CANCELLED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VALIDATING_FILES -> Known.VALIDATING_FILES
                QUEUED -> Known.QUEUED
                RUNNING -> Known.RUNNING
                SUCCEEDED -> Known.SUCCEEDED
                FAILED -> Known.FAILED
                CANCELLED -> Known.CANCELLED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJob && id == other.id && createdAt == other.createdAt && error == other.error && fineTunedModel == other.fineTunedModel && finishedAt == other.finishedAt && hyperparameters == other.hyperparameters && model == other.model && object_ == other.object_ && organizationId == other.organizationId && resultFiles == other.resultFiles && status == other.status && trainedTokens == other.trainedTokens && trainingFile == other.trainingFile && validationFile == other.validationFile && integrations == other.integrations && seed == other.seed && estimatedFinish == other.estimatedFinish && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, error, fineTunedModel, finishedAt, hyperparameters, model, object_, organizationId, resultFiles, status, trainedTokens, trainingFile, validationFile, integrations, seed, estimatedFinish, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJob{id=$id, createdAt=$createdAt, error=$error, fineTunedModel=$fineTunedModel, finishedAt=$finishedAt, hyperparameters=$hyperparameters, model=$model, object_=$object_, organizationId=$organizationId, resultFiles=$resultFiles, status=$status, trainedTokens=$trainedTokens, trainingFile=$trainingFile, validationFile=$validationFile, integrations=$integrations, seed=$seed, estimatedFinish=$estimatedFinish, additionalProperties=$additionalProperties}"
}
