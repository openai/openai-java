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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * The `fine_tuning.job` object represents a fine-tuning job that has been created through the API.
 */
@NoAutoDetect
class FineTuningJob
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("error") @ExcludeMissing private val error: JsonField<Error> = JsonMissing.of(),
    @JsonProperty("fine_tuned_model")
    @ExcludeMissing
    private val fineTunedModel: JsonField<String> = JsonMissing.of(),
    @JsonProperty("finished_at")
    @ExcludeMissing
    private val finishedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("hyperparameters")
    @ExcludeMissing
    private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("organization_id")
    @ExcludeMissing
    private val organizationId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("result_files")
    @ExcludeMissing
    private val resultFiles: JsonField<List<String>> = JsonMissing.of(),
    @JsonProperty("seed") @ExcludeMissing private val seed: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("trained_tokens")
    @ExcludeMissing
    private val trainedTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("training_file")
    @ExcludeMissing
    private val trainingFile: JsonField<String> = JsonMissing.of(),
    @JsonProperty("validation_file")
    @ExcludeMissing
    private val validationFile: JsonField<String> = JsonMissing.of(),
    @JsonProperty("estimated_finish")
    @ExcludeMissing
    private val estimatedFinish: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("integrations")
    @ExcludeMissing
    private val integrations: JsonField<List<FineTuningJobWandbIntegrationObject>> =
        JsonMissing.of(),
    @JsonProperty("method")
    @ExcludeMissing
    private val method: JsonField<Method> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

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
     * The hyperparameters used for the fine-tuning job. This value will only be returned when
     * running `supervised` jobs.
     */
    fun hyperparameters(): Hyperparameters = hyperparameters.getRequired("hyperparameters")

    /** The base model that is being fine-tuned. */
    fun model(): String = model.getRequired("model")

    /** The object type, which is always "fine_tuning.job". */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /** The organization that owns the fine-tuning job. */
    fun organizationId(): String = organizationId.getRequired("organization_id")

    /**
     * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results with
     * the [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    fun resultFiles(): List<String> = resultFiles.getRequired("result_files")

    /** The seed used for the fine-tuning job. */
    fun seed(): Long = seed.getRequired("seed")

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

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
     * value will be null if the fine-tuning job is not running.
     */
    fun estimatedFinish(): Optional<Long> =
        Optional.ofNullable(estimatedFinish.getNullable("estimated_finish"))

    /** A list of integrations to enable for this fine-tuning job. */
    fun integrations(): Optional<List<FineTuningJobWandbIntegrationObject>> =
        Optional.ofNullable(integrations.getNullable("integrations"))

    /** The method used for fine-tuning. */
    fun method(): Optional<Method> = Optional.ofNullable(method.getNullable("method"))

    /** The object identifier, which can be referenced in the API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * The name of the fine-tuned model that is being created. The value will be null if the
     * fine-tuning job is still running.
     */
    @JsonProperty("fine_tuned_model")
    @ExcludeMissing
    fun _fineTunedModel(): JsonField<String> = fineTunedModel

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will be
     * null if the fine-tuning job is still running.
     */
    @JsonProperty("finished_at") @ExcludeMissing fun _finishedAt(): JsonField<Long> = finishedAt

    /**
     * The hyperparameters used for the fine-tuning job. This value will only be returned when
     * running `supervised` jobs.
     */
    @JsonProperty("hyperparameters")
    @ExcludeMissing
    fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

    /** The base model that is being fine-tuned. */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /** The organization that owns the fine-tuning job. */
    @JsonProperty("organization_id")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results with
     * the [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("result_files")
    @ExcludeMissing
    fun _resultFiles(): JsonField<List<String>> = resultFiles

    /** The seed used for the fine-tuning job. */
    @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * The total number of billable tokens processed by this fine-tuning job. The value will be null
     * if the fine-tuning job is still running.
     */
    @JsonProperty("trained_tokens")
    @ExcludeMissing
    fun _trainedTokens(): JsonField<Long> = trainedTokens

    /**
     * The file ID used for training. You can retrieve the training data with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("training_file")
    @ExcludeMissing
    fun _trainingFile(): JsonField<String> = trainingFile

    /**
     * The file ID used for validation. You can retrieve the validation results with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     */
    @JsonProperty("validation_file")
    @ExcludeMissing
    fun _validationFile(): JsonField<String> = validationFile

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
     * value will be null if the fine-tuning job is not running.
     */
    @JsonProperty("estimated_finish")
    @ExcludeMissing
    fun _estimatedFinish(): JsonField<Long> = estimatedFinish

    /** A list of integrations to enable for this fine-tuning job. */
    @JsonProperty("integrations")
    @ExcludeMissing
    fun _integrations(): JsonField<List<FineTuningJobWandbIntegrationObject>> = integrations

    /** The method used for fine-tuning. */
    @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FineTuningJob = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        error().ifPresent { it.validate() }
        fineTunedModel()
        finishedAt()
        hyperparameters().validate()
        model()
        _object_().let {
            if (it != JsonValue.from("fine_tuning.job")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        organizationId()
        resultFiles()
        seed()
        status()
        trainedTokens()
        trainingFile()
        validationFile()
        estimatedFinish()
        integrations().ifPresent { it.forEach { it.validate() } }
        method().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var error: JsonField<Error>? = null
        private var fineTunedModel: JsonField<String>? = null
        private var finishedAt: JsonField<Long>? = null
        private var hyperparameters: JsonField<Hyperparameters>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("fine_tuning.job")
        private var organizationId: JsonField<String>? = null
        private var resultFiles: JsonField<MutableList<String>>? = null
        private var seed: JsonField<Long>? = null
        private var status: JsonField<Status>? = null
        private var trainedTokens: JsonField<Long>? = null
        private var trainingFile: JsonField<String>? = null
        private var validationFile: JsonField<String>? = null
        private var estimatedFinish: JsonField<Long> = JsonMissing.of()
        private var integrations: JsonField<MutableList<FineTuningJobWandbIntegrationObject>>? =
            null
        private var method: JsonField<Method> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJob: FineTuningJob) = apply {
            id = fineTuningJob.id
            createdAt = fineTuningJob.createdAt
            error = fineTuningJob.error
            fineTunedModel = fineTuningJob.fineTunedModel
            finishedAt = fineTuningJob.finishedAt
            hyperparameters = fineTuningJob.hyperparameters
            model = fineTuningJob.model
            object_ = fineTuningJob.object_
            organizationId = fineTuningJob.organizationId
            resultFiles = fineTuningJob.resultFiles.map { it.toMutableList() }
            seed = fineTuningJob.seed
            status = fineTuningJob.status
            trainedTokens = fineTuningJob.trainedTokens
            trainingFile = fineTuningJob.trainingFile
            validationFile = fineTuningJob.validationFile
            estimatedFinish = fineTuningJob.estimatedFinish
            integrations = fineTuningJob.integrations.map { it.toMutableList() }
            method = fineTuningJob.method
            additionalProperties = fineTuningJob.additionalProperties.toMutableMap()
        }

        /** The object identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The object identifier, which can be referenced in the API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        fun error(error: Optional<Error>) = error(error.orElse(null))

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        fun fineTunedModel(fineTunedModel: String?) =
            fineTunedModel(JsonField.ofNullable(fineTunedModel))

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        fun fineTunedModel(fineTunedModel: Optional<String>) =
            fineTunedModel(fineTunedModel.orElse(null))

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        fun fineTunedModel(fineTunedModel: JsonField<String>) = apply {
            this.fineTunedModel = fineTunedModel
        }

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        fun finishedAt(finishedAt: Long?) = finishedAt(JsonField.ofNullable(finishedAt))

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        fun finishedAt(finishedAt: Long) = finishedAt(finishedAt as Long?)

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun finishedAt(finishedAt: Optional<Long>) = finishedAt(finishedAt.orElse(null) as Long?)

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will
         * be null if the fine-tuning job is still running.
         */
        fun finishedAt(finishedAt: JsonField<Long>) = apply { this.finishedAt = finishedAt }

        /**
         * The hyperparameters used for the fine-tuning job. This value will only be returned when
         * running `supervised` jobs.
         */
        fun hyperparameters(hyperparameters: Hyperparameters) =
            hyperparameters(JsonField.of(hyperparameters))

        /**
         * The hyperparameters used for the fine-tuning job. This value will only be returned when
         * running `supervised` jobs.
         */
        fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
            this.hyperparameters = hyperparameters
        }

        /** The base model that is being fine-tuned. */
        fun model(model: String) = model(JsonField.of(model))

        /** The base model that is being fine-tuned. */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type, which is always "fine_tuning.job". */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The organization that owns the fine-tuning job. */
        fun organizationId(organizationId: String) = organizationId(JsonField.of(organizationId))

        /** The organization that owns the fine-tuning job. */
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
        fun resultFiles(resultFiles: JsonField<List<String>>) = apply {
            this.resultFiles = resultFiles.map { it.toMutableList() }
        }

        /**
         * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results
         * with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun addResultFile(resultFile: String) = apply {
            resultFiles =
                (resultFiles ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(resultFile)
                }
        }

        /** The seed used for the fine-tuning job. */
        fun seed(seed: Long) = seed(JsonField.of(seed))

        /** The seed used for the fine-tuning job. */
        fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

        /**
         * The current status of the fine-tuning job, which can be either `validating_files`,
         * `queued`, `running`, `succeeded`, `failed`, or `cancelled`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The current status of the fine-tuning job, which can be either `validating_files`,
         * `queued`, `running`, `succeeded`, `failed`, or `cancelled`.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        fun trainedTokens(trainedTokens: Long?) = trainedTokens(JsonField.ofNullable(trainedTokens))

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        fun trainedTokens(trainedTokens: Long) = trainedTokens(trainedTokens as Long?)

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun trainedTokens(trainedTokens: Optional<Long>) =
            trainedTokens(trainedTokens.orElse(null) as Long?)

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
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
        fun trainingFile(trainingFile: JsonField<String>) = apply {
            this.trainingFile = trainingFile
        }

        /**
         * The file ID used for validation. You can retrieve the validation results with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun validationFile(validationFile: String?) =
            validationFile(JsonField.ofNullable(validationFile))

        /**
         * The file ID used for validation. You can retrieve the validation results with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun validationFile(validationFile: Optional<String>) =
            validationFile(validationFile.orElse(null))

        /**
         * The file ID used for validation. You can retrieve the validation results with the
         * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
         */
        fun validationFile(validationFile: JsonField<String>) = apply {
            this.validationFile = validationFile
        }

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        fun estimatedFinish(estimatedFinish: Long?) =
            estimatedFinish(JsonField.ofNullable(estimatedFinish))

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        fun estimatedFinish(estimatedFinish: Long) = estimatedFinish(estimatedFinish as Long?)

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun estimatedFinish(estimatedFinish: Optional<Long>) =
            estimatedFinish(estimatedFinish.orElse(null) as Long?)

        /**
         * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
         * value will be null if the fine-tuning job is not running.
         */
        fun estimatedFinish(estimatedFinish: JsonField<Long>) = apply {
            this.estimatedFinish = estimatedFinish
        }

        /** A list of integrations to enable for this fine-tuning job. */
        fun integrations(integrations: List<FineTuningJobWandbIntegrationObject>?) =
            integrations(JsonField.ofNullable(integrations))

        /** A list of integrations to enable for this fine-tuning job. */
        fun integrations(integrations: Optional<List<FineTuningJobWandbIntegrationObject>>) =
            integrations(integrations.orElse(null))

        /** A list of integrations to enable for this fine-tuning job. */
        fun integrations(integrations: JsonField<List<FineTuningJobWandbIntegrationObject>>) =
            apply {
                this.integrations = integrations.map { it.toMutableList() }
            }

        /** A list of integrations to enable for this fine-tuning job. */
        fun addIntegration(integration: FineTuningJobWandbIntegrationObject) = apply {
            integrations =
                (integrations ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(integration)
                }
        }

        /** The method used for fine-tuning. */
        fun method(method: Method) = method(JsonField.of(method))

        /** The method used for fine-tuning. */
        fun method(method: JsonField<Method>) = apply { this.method = method }

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

        fun build(): FineTuningJob =
            FineTuningJob(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                checkRequired("fineTunedModel", fineTunedModel),
                checkRequired("finishedAt", finishedAt),
                checkRequired("hyperparameters", hyperparameters),
                checkRequired("model", model),
                object_,
                checkRequired("organizationId", organizationId),
                checkRequired("resultFiles", resultFiles).map { it.toImmutable() },
                checkRequired("seed", seed),
                checkRequired("status", status),
                checkRequired("trainedTokens", trainedTokens),
                checkRequired("trainingFile", trainingFile),
                checkRequired("validationFile", validationFile),
                estimatedFinish,
                (integrations ?: JsonMissing.of()).map { it.toImmutable() },
                method,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    @NoAutoDetect
    class Error
    @JsonCreator
    private constructor(
        @JsonProperty("code")
        @ExcludeMissing
        private val code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message")
        @ExcludeMissing
        private val message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("param")
        @ExcludeMissing
        private val param: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

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
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /** A human-readable error message. */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        /**
         * The parameter that was invalid, usually `training_file` or `validation_file`. This field
         * will be null if the failure was not parameter-specific.
         */
        @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            param()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var code: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var param: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                message = error.message
                param = error.param
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** A machine-readable error code. */
            fun code(code: String) = code(JsonField.of(code))

            /** A machine-readable error code. */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** A human-readable error message. */
            fun message(message: String) = message(JsonField.of(message))

            /** A human-readable error message. */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            fun param(param: String?) = param(JsonField.ofNullable(param))

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            fun param(param: Optional<String>) = param(param.orElse(null))

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            fun param(param: JsonField<String>) = apply { this.param = param }

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

            fun build(): Error =
                Error(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    checkRequired("param", param),
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
     * The hyperparameters used for the fine-tuning job. This value will only be returned when
     * running `supervised` jobs.
     */
    @NoAutoDetect
    class Hyperparameters
    @JsonCreator
    private constructor(
        @JsonProperty("batch_size")
        @ExcludeMissing
        private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        private val learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of(),
        @JsonProperty("n_epochs")
        @ExcludeMissing
        private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        fun batchSize(): Optional<BatchSize> =
            Optional.ofNullable(batchSize.getNullable("batch_size"))

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
            Optional.ofNullable(learningRateMultiplier.getNullable("learning_rate_multiplier"))

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        fun nEpochs(): Optional<NEpochs> = Optional.ofNullable(nEpochs.getNullable("n_epochs"))

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonProperty("batch_size")
        @ExcludeMissing
        fun _batchSize(): JsonField<BatchSize> = batchSize

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        @JsonProperty("learning_rate_multiplier")
        @ExcludeMissing
        fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> = learningRateMultiplier

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonProperty("n_epochs") @ExcludeMissing fun _nEpochs(): JsonField<NEpochs> = nEpochs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Hyperparameters = apply {
            if (validated) {
                return@apply
            }

            batchSize().ifPresent { it.validate() }
            learningRateMultiplier().ifPresent { it.validate() }
            nEpochs().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var batchSize: JsonField<BatchSize> = JsonMissing.of()
            private var learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of()
            private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hyperparameters: Hyperparameters) = apply {
                batchSize = hyperparameters.batchSize
                learningRateMultiplier = hyperparameters.learningRateMultiplier
                nEpochs = hyperparameters.nEpochs
                additionalProperties = hyperparameters.additionalProperties.toMutableMap()
            }

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(batchSize: JsonField<BatchSize>) = apply { this.batchSize = batchSize }

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                learningRateMultiplier(JsonField.of(learningRateMultiplier))

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(learningRateMultiplier: JsonField<LearningRateMultiplier>) =
                apply {
                    this.learningRateMultiplier = learningRateMultiplier
                }

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplierAuto() =
                learningRateMultiplier(LearningRateMultiplier.ofAuto())

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            fun learningRateMultiplier(number: Double) =
                learningRateMultiplier(LearningRateMultiplier.ofNumber(number))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
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

            fun build(): Hyperparameters =
                Hyperparameters(
                    batchSize,
                    learningRateMultiplier,
                    nEpochs,
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonDeserialize(using = BatchSize.Deserializer::class)
        @JsonSerialize(using = BatchSize.Serializer::class)
        class BatchSize
        private constructor(
            private val auto: JsonValue? = null,
            private val manual: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

            fun manual(): Optional<Long> = Optional.ofNullable(manual)

            fun isAuto(): Boolean = auto != null

            fun isManual(): Boolean = manual != null

            fun asAuto(): JsonValue = auto.getOrThrow("auto")

            fun asManual(): Long = manual.getOrThrow("manual")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    manual != null -> visitor.visitManual(manual)
                    else -> visitor.unknown(_json)
                }
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
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitManual(manual: Long) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is BatchSize && auto == other.auto && manual == other.manual /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

            override fun toString(): String =
                when {
                    auto != null -> "BatchSize{auto=$auto}"
                    manual != null -> "BatchSize{manual=$manual}"
                    _json != null -> "BatchSize{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid BatchSize")
                }

            companion object {

                @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
            }

            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitManual(manual: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return BatchSize(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return BatchSize(manual = it, _json = json)
                    }

                    return BatchSize(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                override fun serialize(
                    value: BatchSize,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.auto != null -> generator.writeObject(value.auto)
                        value.manual != null -> generator.writeObject(value.manual)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid BatchSize")
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

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    number != null -> visitor.visitNumber(number)
                    else -> visitor.unknown(_json)
                }
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
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitNumber(number: Double) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && number == other.number /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, number) /* spotless:on */

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

            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitNumber(number: Double): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $json")
                }
            }

            internal class Deserializer :
                BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): LearningRateMultiplier {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return LearningRateMultiplier(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                        return LearningRateMultiplier(number = it, _json = json)
                    }

                    return LearningRateMultiplier(_json = json)
                }
            }

            internal class Serializer :
                BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun serialize(
                    value: LearningRateMultiplier,
                    generator: JsonGenerator,
                    provider: SerializerProvider
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
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
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

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    auto != null -> visitor.visitAuto(auto)
                    integer != null -> visitor.visitInteger(integer)
                    else -> visitor.unknown(_json)
                }
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
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }

                        override fun visitInteger(integer: Long) {}
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is NEpochs && auto == other.auto && integer == other.integer /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, integer) /* spotless:on */

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

            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitInteger(integer: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                            it.let {
                                if (it != JsonValue.from("auto")) {
                                    throw OpenAIInvalidDataException(
                                        "'auto' is invalid, received $it"
                                    )
                                }
                            }
                        }
                        ?.let {
                            return NEpochs(auto = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return NEpochs(integer = it, _json = json)
                    }

                    return NEpochs(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                override fun serialize(
                    value: NEpochs,
                    generator: JsonGenerator,
                    provider: SerializerProvider
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

            return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(batchSize, learningRateMultiplier, nEpochs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
    }

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     */
    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VALIDATING_FILES = of("validating_files")

            @JvmField val QUEUED = of("queued")

            @JvmField val RUNNING = of("running")

            @JvmField val SUCCEEDED = of("succeeded")

            @JvmField val FAILED = of("failed")

            @JvmField val CANCELLED = of("cancelled")

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The method used for fine-tuning. */
    @NoAutoDetect
    class Method
    @JsonCreator
    private constructor(
        @JsonProperty("dpo") @ExcludeMissing private val dpo: JsonField<Dpo> = JsonMissing.of(),
        @JsonProperty("supervised")
        @ExcludeMissing
        private val supervised: JsonField<Supervised> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Configuration for the DPO fine-tuning method. */
        fun dpo(): Optional<Dpo> = Optional.ofNullable(dpo.getNullable("dpo"))

        /** Configuration for the supervised fine-tuning method. */
        fun supervised(): Optional<Supervised> =
            Optional.ofNullable(supervised.getNullable("supervised"))

        /** The type of method. Is either `supervised` or `dpo`. */
        fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

        /** Configuration for the DPO fine-tuning method. */
        @JsonProperty("dpo") @ExcludeMissing fun _dpo(): JsonField<Dpo> = dpo

        /** Configuration for the supervised fine-tuning method. */
        @JsonProperty("supervised")
        @ExcludeMissing
        fun _supervised(): JsonField<Supervised> = supervised

        /** The type of method. Is either `supervised` or `dpo`. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Method = apply {
            if (validated) {
                return@apply
            }

            dpo().ifPresent { it.validate() }
            supervised().ifPresent { it.validate() }
            type()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var dpo: JsonField<Dpo> = JsonMissing.of()
            private var supervised: JsonField<Supervised> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(method: Method) = apply {
                dpo = method.dpo
                supervised = method.supervised
                type = method.type
                additionalProperties = method.additionalProperties.toMutableMap()
            }

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: Dpo) = dpo(JsonField.of(dpo))

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: JsonField<Dpo>) = apply { this.dpo = dpo }

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: Supervised) = supervised(JsonField.of(supervised))

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: JsonField<Supervised>) = apply {
                this.supervised = supervised
            }

            /** The type of method. Is either `supervised` or `dpo`. */
            fun type(type: Type) = type(JsonField.of(type))

            /** The type of method. Is either `supervised` or `dpo`. */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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

            fun build(): Method =
                Method(
                    dpo,
                    supervised,
                    type,
                    additionalProperties.toImmutable(),
                )
        }

        /** Configuration for the DPO fine-tuning method. */
        @NoAutoDetect
        class Dpo
        @JsonCreator
        private constructor(
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            fun hyperparameters(): Optional<Hyperparameters> =
                Optional.ofNullable(hyperparameters.getNullable("hyperparameters"))

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Dpo = apply {
                if (validated) {
                    return@apply
                }

                hyperparameters().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder internal constructor() {

                private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(dpo: Dpo) = apply {
                    hyperparameters = dpo.hyperparameters
                    additionalProperties = dpo.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) =
                    hyperparameters(JsonField.of(hyperparameters))

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
                    this.hyperparameters = hyperparameters
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

                fun build(): Dpo = Dpo(hyperparameters, additionalProperties.toImmutable())
            }

            /** The hyperparameters used for the fine-tuning job. */
            @NoAutoDetect
            class Hyperparameters
            @JsonCreator
            private constructor(
                @JsonProperty("batch_size")
                @ExcludeMissing
                private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
                @JsonProperty("beta")
                @ExcludeMissing
                private val beta: JsonField<Beta> = JsonMissing.of(),
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                private val learningRateMultiplier: JsonField<LearningRateMultiplier> =
                    JsonMissing.of(),
                @JsonProperty("n_epochs")
                @ExcludeMissing
                private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                fun batchSize(): Optional<BatchSize> =
                    Optional.ofNullable(batchSize.getNullable("batch_size"))

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                fun beta(): Optional<Beta> = Optional.ofNullable(beta.getNullable("beta"))

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(
                        learningRateMultiplier.getNullable("learning_rate_multiplier")
                    )

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                fun nEpochs(): Optional<NEpochs> =
                    Optional.ofNullable(nEpochs.getNullable("n_epochs"))

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                @ExcludeMissing
                fun _batchSize(): JsonField<BatchSize> = batchSize

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonProperty("beta") @ExcludeMissing fun _beta(): JsonField<Beta> = beta

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> =
                    learningRateMultiplier

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                @ExcludeMissing
                fun _nEpochs(): JsonField<NEpochs> = nEpochs

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Hyperparameters = apply {
                    if (validated) {
                        return@apply
                    }

                    batchSize().ifPresent { it.validate() }
                    beta().ifPresent { it.validate() }
                    learningRateMultiplier().ifPresent { it.validate() }
                    nEpochs().ifPresent { it.validate() }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder internal constructor() {

                    private var batchSize: JsonField<BatchSize> = JsonMissing.of()
                    private var beta: JsonField<Beta> = JsonMissing.of()
                    private var learningRateMultiplier: JsonField<LearningRateMultiplier> =
                        JsonMissing.of()
                    private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hyperparameters: Hyperparameters) = apply {
                        batchSize = hyperparameters.batchSize
                        beta = hyperparameters.beta
                        learningRateMultiplier = hyperparameters.learningRateMultiplier
                        nEpochs = hyperparameters.nEpochs
                        additionalProperties = hyperparameters.additionalProperties.toMutableMap()
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: JsonField<BatchSize>) = apply {
                        this.batchSize = batchSize
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(beta: Beta) = beta(JsonField.of(beta))

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(beta: JsonField<Beta>) = apply { this.beta = beta }

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun betaAuto() = beta(Beta.ofAuto())

                    /**
                     * The beta value for the DPO method. A higher beta value will increase the
                     * weight of the penalty between the policy and reference model.
                     */
                    fun beta(manual: Double) = beta(Beta.ofManual(manual))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        learningRateMultiplier(JsonField.of(learningRateMultiplier))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(
                        learningRateMultiplier: JsonField<LearningRateMultiplier>
                    ) = apply { this.learningRateMultiplier = learningRateMultiplier }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplierAuto() =
                        learningRateMultiplier(LearningRateMultiplier.ofAuto())

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(manual: Double) =
                        learningRateMultiplier(LearningRateMultiplier.ofManual(manual))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(manual: Long) = nEpochs(NEpochs.ofManual(manual))

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

                    fun build(): Hyperparameters =
                        Hyperparameters(
                            batchSize,
                            beta,
                            learningRateMultiplier,
                            nEpochs,
                            additionalProperties.toImmutable(),
                        )
                }

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonDeserialize(using = BatchSize.Deserializer::class)
                @JsonSerialize(using = BatchSize.Serializer::class)
                class BatchSize
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is BatchSize && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "BatchSize{auto=$auto}"
                            manual != null -> "BatchSize{manual=$manual}"
                            _json != null -> "BatchSize{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid BatchSize")
                        }

                    companion object {

                        @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return BatchSize(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                        override fun serialize(
                            value: BatchSize,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid BatchSize")
                            }
                        }
                    }
                }

                /**
                 * The beta value for the DPO method. A higher beta value will increase the weight
                 * of the penalty between the policy and reference model.
                 */
                @JsonDeserialize(using = Beta.Deserializer::class)
                @JsonSerialize(using = Beta.Serializer::class)
                class Beta
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Beta && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "Beta{auto=$auto}"
                            manual != null -> "Beta{manual=$manual}"
                            _json != null -> "Beta{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Beta")
                        }

                    companion object {

                        @JvmStatic fun ofAuto() = Beta(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Double) = Beta(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown Beta: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Beta>(Beta::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Beta {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return Beta(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return Beta(manual = it, _json = json)
                            }

                            return Beta(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Beta>(Beta::class) {

                        override fun serialize(
                            value: Beta,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Beta")
                            }
                        }
                    }
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "LearningRateMultiplier{auto=$auto}"
                            manual != null -> "LearningRateMultiplier{manual=$manual}"
                            _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                        }

                    companion object {

                        @JvmStatic
                        fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return LearningRateMultiplier(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    internal class Serializer :
                        BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun serialize(
                            value: LearningRateMultiplier,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else ->
                                    throw IllegalStateException("Invalid LearningRateMultiplier")
                            }
                        }
                    }
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is NEpochs && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "NEpochs{auto=$auto}"
                            manual != null -> "NEpochs{manual=$manual}"
                            _json != null -> "NEpochs{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid NEpochs")
                        }

                    companion object {

                        @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return NEpochs(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                        override fun serialize(
                            value: NEpochs,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
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

                    return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && beta == other.beta && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(batchSize, beta, learningRateMultiplier, nEpochs, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hyperparameters{batchSize=$batchSize, beta=$beta, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Dpo && hyperparameters == other.hyperparameters && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(hyperparameters, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Dpo{hyperparameters=$hyperparameters, additionalProperties=$additionalProperties}"
        }

        /** Configuration for the supervised fine-tuning method. */
        @NoAutoDetect
        class Supervised
        @JsonCreator
        private constructor(
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            private val hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The hyperparameters used for the fine-tuning job. */
            fun hyperparameters(): Optional<Hyperparameters> =
                Optional.ofNullable(hyperparameters.getNullable("hyperparameters"))

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            @ExcludeMissing
            fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Supervised = apply {
                if (validated) {
                    return@apply
                }

                hyperparameters().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder internal constructor() {

                private var hyperparameters: JsonField<Hyperparameters> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(supervised: Supervised) = apply {
                    hyperparameters = supervised.hyperparameters
                    additionalProperties = supervised.additionalProperties.toMutableMap()
                }

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: Hyperparameters) =
                    hyperparameters(JsonField.of(hyperparameters))

                /** The hyperparameters used for the fine-tuning job. */
                fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
                    this.hyperparameters = hyperparameters
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

                fun build(): Supervised =
                    Supervised(hyperparameters, additionalProperties.toImmutable())
            }

            /** The hyperparameters used for the fine-tuning job. */
            @NoAutoDetect
            class Hyperparameters
            @JsonCreator
            private constructor(
                @JsonProperty("batch_size")
                @ExcludeMissing
                private val batchSize: JsonField<BatchSize> = JsonMissing.of(),
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                private val learningRateMultiplier: JsonField<LearningRateMultiplier> =
                    JsonMissing.of(),
                @JsonProperty("n_epochs")
                @ExcludeMissing
                private val nEpochs: JsonField<NEpochs> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                fun batchSize(): Optional<BatchSize> =
                    Optional.ofNullable(batchSize.getNullable("batch_size"))

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                fun learningRateMultiplier(): Optional<LearningRateMultiplier> =
                    Optional.ofNullable(
                        learningRateMultiplier.getNullable("learning_rate_multiplier")
                    )

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                fun nEpochs(): Optional<NEpochs> =
                    Optional.ofNullable(nEpochs.getNullable("n_epochs"))

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonProperty("batch_size")
                @ExcludeMissing
                fun _batchSize(): JsonField<BatchSize> = batchSize

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonProperty("learning_rate_multiplier")
                @ExcludeMissing
                fun _learningRateMultiplier(): JsonField<LearningRateMultiplier> =
                    learningRateMultiplier

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonProperty("n_epochs")
                @ExcludeMissing
                fun _nEpochs(): JsonField<NEpochs> = nEpochs

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Hyperparameters = apply {
                    if (validated) {
                        return@apply
                    }

                    batchSize().ifPresent { it.validate() }
                    learningRateMultiplier().ifPresent { it.validate() }
                    nEpochs().ifPresent { it.validate() }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder internal constructor() {

                    private var batchSize: JsonField<BatchSize> = JsonMissing.of()
                    private var learningRateMultiplier: JsonField<LearningRateMultiplier> =
                        JsonMissing.of()
                    private var nEpochs: JsonField<NEpochs> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(hyperparameters: Hyperparameters) = apply {
                        batchSize = hyperparameters.batchSize
                        learningRateMultiplier = hyperparameters.learningRateMultiplier
                        nEpochs = hyperparameters.nEpochs
                        additionalProperties = hyperparameters.additionalProperties.toMutableMap()
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: BatchSize) = batchSize(JsonField.of(batchSize))

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(batchSize: JsonField<BatchSize>) = apply {
                        this.batchSize = batchSize
                    }

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

                    /**
                     * Number of examples in each batch. A larger batch size means that model
                     * parameters are updated less frequently, but with lower variance.
                     */
                    fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) =
                        learningRateMultiplier(JsonField.of(learningRateMultiplier))

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(
                        learningRateMultiplier: JsonField<LearningRateMultiplier>
                    ) = apply { this.learningRateMultiplier = learningRateMultiplier }

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplierAuto() =
                        learningRateMultiplier(LearningRateMultiplier.ofAuto())

                    /**
                     * Scaling factor for the learning rate. A smaller learning rate may be useful
                     * to avoid overfitting.
                     */
                    fun learningRateMultiplier(manual: Double) =
                        learningRateMultiplier(LearningRateMultiplier.ofManual(manual))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(nEpochs: JsonField<NEpochs>) = apply { this.nEpochs = nEpochs }

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochsAuto() = nEpochs(NEpochs.ofAuto())

                    /**
                     * The number of epochs to train the model for. An epoch refers to one full
                     * cycle through the training dataset.
                     */
                    fun nEpochs(manual: Long) = nEpochs(NEpochs.ofManual(manual))

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

                    fun build(): Hyperparameters =
                        Hyperparameters(
                            batchSize,
                            learningRateMultiplier,
                            nEpochs,
                            additionalProperties.toImmutable(),
                        )
                }

                /**
                 * Number of examples in each batch. A larger batch size means that model parameters
                 * are updated less frequently, but with lower variance.
                 */
                @JsonDeserialize(using = BatchSize.Deserializer::class)
                @JsonSerialize(using = BatchSize.Serializer::class)
                class BatchSize
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is BatchSize && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "BatchSize{auto=$auto}"
                            manual != null -> "BatchSize{manual=$manual}"
                            _json != null -> "BatchSize{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid BatchSize")
                        }

                    companion object {

                        @JvmStatic fun ofAuto() = BatchSize(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = BatchSize(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return BatchSize(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return BatchSize(manual = it, _json = json)
                            }

                            return BatchSize(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                        override fun serialize(
                            value: BatchSize,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid BatchSize")
                            }
                        }
                    }
                }

                /**
                 * Scaling factor for the learning rate. A smaller learning rate may be useful to
                 * avoid overfitting.
                 */
                @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
                @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
                class LearningRateMultiplier
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Double> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Double = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Double) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is LearningRateMultiplier && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "LearningRateMultiplier{auto=$auto}"
                            manual != null -> "LearningRateMultiplier{manual=$manual}"
                            _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                        }

                    companion object {

                        @JvmStatic
                        fun ofAuto() = LearningRateMultiplier(auto = JsonValue.from("auto"))

                        @JvmStatic
                        fun ofManual(manual: Double) = LearningRateMultiplier(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Double): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException(
                                "Unknown LearningRateMultiplier: $json"
                            )
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun ObjectCodec.deserialize(
                            node: JsonNode
                        ): LearningRateMultiplier {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return LearningRateMultiplier(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                return LearningRateMultiplier(manual = it, _json = json)
                            }

                            return LearningRateMultiplier(_json = json)
                        }
                    }

                    internal class Serializer :
                        BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                        override fun serialize(
                            value: LearningRateMultiplier,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
                                value._json != null -> generator.writeObject(value._json)
                                else ->
                                    throw IllegalStateException("Invalid LearningRateMultiplier")
                            }
                        }
                    }
                }

                /**
                 * The number of epochs to train the model for. An epoch refers to one full cycle
                 * through the training dataset.
                 */
                @JsonDeserialize(using = NEpochs.Deserializer::class)
                @JsonSerialize(using = NEpochs.Serializer::class)
                class NEpochs
                private constructor(
                    private val auto: JsonValue? = null,
                    private val manual: Long? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun manual(): Optional<Long> = Optional.ofNullable(manual)

                    fun isAuto(): Boolean = auto != null

                    fun isManual(): Boolean = manual != null

                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asManual(): Long = manual.getOrThrow("manual")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            manual != null -> visitor.visitManual(manual)
                            else -> visitor.unknown(_json)
                        }
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
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitManual(manual: Long) {}
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is NEpochs && auto == other.auto && manual == other.manual /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, manual) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "NEpochs{auto=$auto}"
                            manual != null -> "NEpochs{manual=$manual}"
                            _json != null -> "NEpochs{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid NEpochs")
                        }

                    companion object {

                        @JvmStatic fun ofAuto() = NEpochs(auto = JsonValue.from("auto"))

                        @JvmStatic fun ofManual(manual: Long) = NEpochs(manual = manual)
                    }

                    interface Visitor<out T> {

                        fun visitAuto(auto: JsonValue): T

                        fun visitManual(manual: Long): T

                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                            val json = JsonValue.fromJsonNode(node)

                            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                    it.let {
                                        if (it != JsonValue.from("auto")) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                                ?.let {
                                    return NEpochs(auto = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                return NEpochs(manual = it, _json = json)
                            }

                            return NEpochs(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                        override fun serialize(
                            value: NEpochs,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.manual != null -> generator.writeObject(value.manual)
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

                    return /* spotless:off */ other is Hyperparameters && batchSize == other.batchSize && learningRateMultiplier == other.learningRateMultiplier && nEpochs == other.nEpochs && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(batchSize, learningRateMultiplier, nEpochs, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Supervised && hyperparameters == other.hyperparameters && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(hyperparameters, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Supervised{hyperparameters=$hyperparameters, additionalProperties=$additionalProperties}"
        }

        /** The type of method. Is either `supervised` or `dpo`. */
        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUPERVISED = of("supervised")

                @JvmField val DPO = of("dpo")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                SUPERVISED,
                DPO,
            }

            enum class Value {
                SUPERVISED,
                DPO,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SUPERVISED -> Value.SUPERVISED
                    DPO -> Value.DPO
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SUPERVISED -> Known.SUPERVISED
                    DPO -> Known.DPO
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Method && dpo == other.dpo && supervised == other.supervised && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(dpo, supervised, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Method{dpo=$dpo, supervised=$supervised, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJob && id == other.id && createdAt == other.createdAt && error == other.error && fineTunedModel == other.fineTunedModel && finishedAt == other.finishedAt && hyperparameters == other.hyperparameters && model == other.model && object_ == other.object_ && organizationId == other.organizationId && resultFiles == other.resultFiles && seed == other.seed && status == other.status && trainedTokens == other.trainedTokens && trainingFile == other.trainingFile && validationFile == other.validationFile && estimatedFinish == other.estimatedFinish && integrations == other.integrations && method == other.method && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, error, fineTunedModel, finishedAt, hyperparameters, model, object_, organizationId, resultFiles, seed, status, trainedTokens, trainingFile, validationFile, estimatedFinish, integrations, method, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJob{id=$id, createdAt=$createdAt, error=$error, fineTunedModel=$fineTunedModel, finishedAt=$finishedAt, hyperparameters=$hyperparameters, model=$model, object_=$object_, organizationId=$organizationId, resultFiles=$resultFiles, seed=$seed, status=$status, trainedTokens=$trainedTokens, trainingFile=$trainingFile, validationFile=$validationFile, estimatedFinish=$estimatedFinish, integrations=$integrations, method=$method, additionalProperties=$additionalProperties}"
}
