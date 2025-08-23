// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.finetuning.methods.DpoMethod
import com.openai.models.finetuning.methods.ReinforcementMethod
import com.openai.models.finetuning.methods.SupervisedMethod
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The `fine_tuning.job` object represents a fine-tuning job that has been created through the API.
 */
class FineTuningJob
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val error: JsonField<Error>,
    private val fineTunedModel: JsonField<String>,
    private val finishedAt: JsonField<Long>,
    private val hyperparameters: JsonField<Hyperparameters>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val organizationId: JsonField<String>,
    private val resultFiles: JsonField<List<String>>,
    private val seed: JsonField<Long>,
    private val status: JsonField<Status>,
    private val trainedTokens: JsonField<Long>,
    private val trainingFile: JsonField<String>,
    private val validationFile: JsonField<String>,
    private val estimatedFinish: JsonField<Long>,
    private val integrations: JsonField<List<FineTuningJobWandbIntegrationObject>>,
    private val metadata: JsonField<Metadata>,
    private val method: JsonField<Method>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("fine_tuned_model")
        @ExcludeMissing
        fineTunedModel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("finished_at") @ExcludeMissing finishedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hyperparameters")
        @ExcludeMissing
        hyperparameters: JsonField<Hyperparameters> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("organization_id")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("result_files")
        @ExcludeMissing
        resultFiles: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("trained_tokens")
        @ExcludeMissing
        trainedTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("training_file")
        @ExcludeMissing
        trainingFile: JsonField<String> = JsonMissing.of(),
        @JsonProperty("validation_file")
        @ExcludeMissing
        validationFile: JsonField<String> = JsonMissing.of(),
        @JsonProperty("estimated_finish")
        @ExcludeMissing
        estimatedFinish: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("integrations")
        @ExcludeMissing
        integrations: JsonField<List<FineTuningJobWandbIntegrationObject>> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("method") @ExcludeMissing method: JsonField<Method> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        error,
        fineTunedModel,
        finishedAt,
        hyperparameters,
        model,
        object_,
        organizationId,
        resultFiles,
        seed,
        status,
        trainedTokens,
        trainingFile,
        validationFile,
        estimatedFinish,
        integrations,
        metadata,
        method,
        mutableMapOf(),
    )

    /**
     * The object identifier, which can be referenced in the API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<Error> = error.getOptional("error")

    /**
     * The name of the fine-tuned model that is being created. The value will be null if the
     * fine-tuning job is still running.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fineTunedModel(): Optional<String> = fineTunedModel.getOptional("fine_tuned_model")

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job was finished. The value will be
     * null if the fine-tuning job is still running.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun finishedAt(): Optional<Long> = finishedAt.getOptional("finished_at")

    /**
     * The hyperparameters used for the fine-tuning job. This value will only be returned when
     * running `supervised` jobs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hyperparameters(): Hyperparameters = hyperparameters.getRequired("hyperparameters")

    /**
     * The base model that is being fine-tuned.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always "fine_tuning.job".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("fine_tuning.job")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The organization that owns the fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun organizationId(): String = organizationId.getRequired("organization_id")

    /**
     * The compiled results file ID(s) for the fine-tuning job. You can retrieve the results with
     * the [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun resultFiles(): List<String> = resultFiles.getRequired("result_files")

    /**
     * The seed used for the fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seed(): Long = seed.getRequired("seed")

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The total number of billable tokens processed by this fine-tuning job. The value will be null
     * if the fine-tuning job is still running.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun trainedTokens(): Optional<Long> = trainedTokens.getOptional("trained_tokens")

    /**
     * The file ID used for training. You can retrieve the training data with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun trainingFile(): String = trainingFile.getRequired("training_file")

    /**
     * The file ID used for validation. You can retrieve the validation results with the
     * [Files API](https://platform.openai.com/docs/api-reference/files/retrieve-contents).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun validationFile(): Optional<String> = validationFile.getOptional("validation_file")

    /**
     * The Unix timestamp (in seconds) for when the fine-tuning job is estimated to finish. The
     * value will be null if the fine-tuning job is not running.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun estimatedFinish(): Optional<Long> = estimatedFinish.getOptional("estimated_finish")

    /**
     * A list of integrations to enable for this fine-tuning job.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun integrations(): Optional<List<FineTuningJobWandbIntegrationObject>> =
        integrations.getOptional("integrations")

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * The method used for fine-tuning.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun method(): Optional<Method> = method.getOptional("method")

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
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [fineTunedModel].
     *
     * Unlike [fineTunedModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fine_tuned_model")
    @ExcludeMissing
    fun _fineTunedModel(): JsonField<String> = fineTunedModel

    /**
     * Returns the raw JSON value of [finishedAt].
     *
     * Unlike [finishedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("finished_at") @ExcludeMissing fun _finishedAt(): JsonField<Long> = finishedAt

    /**
     * Returns the raw JSON value of [hyperparameters].
     *
     * Unlike [hyperparameters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hyperparameters")
    @ExcludeMissing
    fun _hyperparameters(): JsonField<Hyperparameters> = hyperparameters

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("organization_id")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * Returns the raw JSON value of [resultFiles].
     *
     * Unlike [resultFiles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("result_files")
    @ExcludeMissing
    fun _resultFiles(): JsonField<List<String>> = resultFiles

    /**
     * Returns the raw JSON value of [seed].
     *
     * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [trainedTokens].
     *
     * Unlike [trainedTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trained_tokens")
    @ExcludeMissing
    fun _trainedTokens(): JsonField<Long> = trainedTokens

    /**
     * Returns the raw JSON value of [trainingFile].
     *
     * Unlike [trainingFile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("training_file")
    @ExcludeMissing
    fun _trainingFile(): JsonField<String> = trainingFile

    /**
     * Returns the raw JSON value of [validationFile].
     *
     * Unlike [validationFile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("validation_file")
    @ExcludeMissing
    fun _validationFile(): JsonField<String> = validationFile

    /**
     * Returns the raw JSON value of [estimatedFinish].
     *
     * Unlike [estimatedFinish], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("estimated_finish")
    @ExcludeMissing
    fun _estimatedFinish(): JsonField<Long> = estimatedFinish

    /**
     * Returns the raw JSON value of [integrations].
     *
     * Unlike [integrations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("integrations")
    @ExcludeMissing
    fun _integrations(): JsonField<List<FineTuningJobWandbIntegrationObject>> = integrations

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [method].
     *
     * Unlike [method], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

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
         * Returns a mutable builder for constructing an instance of [FineTuningJob].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .error()
         * .fineTunedModel()
         * .finishedAt()
         * .hyperparameters()
         * .model()
         * .organizationId()
         * .resultFiles()
         * .seed()
         * .status()
         * .trainedTokens()
         * .trainingFile()
         * .validationFile()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FineTuningJob]. */
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
        private var metadata: JsonField<Metadata> = JsonMissing.of()
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
            metadata = fineTuningJob.metadata
            method = fineTuningJob.method
            additionalProperties = fineTuningJob.additionalProperties.toMutableMap()
        }

        /** The object identifier, which can be referenced in the API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * For fine-tuning jobs that have `failed`, this will contain more information on the cause
         * of the failure.
         */
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /**
         * The name of the fine-tuned model that is being created. The value will be null if the
         * fine-tuning job is still running.
         */
        fun fineTunedModel(fineTunedModel: String?) =
            fineTunedModel(JsonField.ofNullable(fineTunedModel))

        /** Alias for calling [Builder.fineTunedModel] with `fineTunedModel.orElse(null)`. */
        fun fineTunedModel(fineTunedModel: Optional<String>) =
            fineTunedModel(fineTunedModel.getOrNull())

        /**
         * Sets [Builder.fineTunedModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fineTunedModel] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * Alias for [Builder.finishedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun finishedAt(finishedAt: Long) = finishedAt(finishedAt as Long?)

        /** Alias for calling [Builder.finishedAt] with `finishedAt.orElse(null)`. */
        fun finishedAt(finishedAt: Optional<Long>) = finishedAt(finishedAt.getOrNull())

        /**
         * Sets [Builder.finishedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.finishedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun finishedAt(finishedAt: JsonField<Long>) = apply { this.finishedAt = finishedAt }

        /**
         * The hyperparameters used for the fine-tuning job. This value will only be returned when
         * running `supervised` jobs.
         */
        fun hyperparameters(hyperparameters: Hyperparameters) =
            hyperparameters(JsonField.of(hyperparameters))

        /**
         * Sets [Builder.hyperparameters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hyperparameters] with a well-typed [Hyperparameters]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun hyperparameters(hyperparameters: JsonField<Hyperparameters>) = apply {
            this.hyperparameters = hyperparameters
        }

        /** The base model that is being fine-tuned. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("fine_tuning.job")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The organization that owns the fine-tuning job. */
        fun organizationId(organizationId: String) = organizationId(JsonField.of(organizationId))

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
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
         * Sets [Builder.resultFiles] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resultFiles] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun resultFiles(resultFiles: JsonField<List<String>>) = apply {
            this.resultFiles = resultFiles.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [resultFiles].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResultFile(resultFile: String) = apply {
            resultFiles =
                (resultFiles ?: JsonField.of(mutableListOf())).also {
                    checkKnown("resultFiles", it).add(resultFile)
                }
        }

        /** The seed used for the fine-tuning job. */
        fun seed(seed: Long) = seed(JsonField.of(seed))

        /**
         * Sets [Builder.seed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

        /**
         * The current status of the fine-tuning job, which can be either `validating_files`,
         * `queued`, `running`, `succeeded`, `failed`, or `cancelled`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * The total number of billable tokens processed by this fine-tuning job. The value will be
         * null if the fine-tuning job is still running.
         */
        fun trainedTokens(trainedTokens: Long?) = trainedTokens(JsonField.ofNullable(trainedTokens))

        /**
         * Alias for [Builder.trainedTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun trainedTokens(trainedTokens: Long) = trainedTokens(trainedTokens as Long?)

        /** Alias for calling [Builder.trainedTokens] with `trainedTokens.orElse(null)`. */
        fun trainedTokens(trainedTokens: Optional<Long>) = trainedTokens(trainedTokens.getOrNull())

        /**
         * Sets [Builder.trainedTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trainedTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Sets [Builder.trainingFile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trainingFile] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

        /** Alias for calling [Builder.validationFile] with `validationFile.orElse(null)`. */
        fun validationFile(validationFile: Optional<String>) =
            validationFile(validationFile.getOrNull())

        /**
         * Sets [Builder.validationFile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.validationFile] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * Alias for [Builder.estimatedFinish].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun estimatedFinish(estimatedFinish: Long) = estimatedFinish(estimatedFinish as Long?)

        /** Alias for calling [Builder.estimatedFinish] with `estimatedFinish.orElse(null)`. */
        fun estimatedFinish(estimatedFinish: Optional<Long>) =
            estimatedFinish(estimatedFinish.getOrNull())

        /**
         * Sets [Builder.estimatedFinish] to an arbitrary JSON value.
         *
         * You should usually call [Builder.estimatedFinish] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun estimatedFinish(estimatedFinish: JsonField<Long>) = apply {
            this.estimatedFinish = estimatedFinish
        }

        /** A list of integrations to enable for this fine-tuning job. */
        fun integrations(integrations: List<FineTuningJobWandbIntegrationObject>?) =
            integrations(JsonField.ofNullable(integrations))

        /** Alias for calling [Builder.integrations] with `integrations.orElse(null)`. */
        fun integrations(integrations: Optional<List<FineTuningJobWandbIntegrationObject>>) =
            integrations(integrations.getOrNull())

        /**
         * Sets [Builder.integrations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.integrations] with a well-typed
         * `List<FineTuningJobWandbIntegrationObject>` value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun integrations(integrations: JsonField<List<FineTuningJobWandbIntegrationObject>>) =
            apply {
                this.integrations = integrations.map { it.toMutableList() }
            }

        /**
         * Adds a single [FineTuningJobWandbIntegrationObject] to [integrations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addIntegration(integration: FineTuningJobWandbIntegrationObject) = apply {
            integrations =
                (integrations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("integrations", it).add(integration)
                }
        }

        /**
         * Alias for calling [addIntegration] with the following:
         * ```java
         * FineTuningJobWandbIntegrationObject.builder()
         *     .wandb(wandb)
         *     .build()
         * ```
         */
        fun addWandbIntegration(wandb: FineTuningJobWandbIntegration) =
            addIntegration(FineTuningJobWandbIntegrationObject.builder().wandb(wandb).build())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The method used for fine-tuning. */
        fun method(method: Method) = method(JsonField.of(method))

        /**
         * Sets [Builder.method] to an arbitrary JSON value.
         *
         * You should usually call [Builder.method] with a well-typed [Method] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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

        /**
         * Returns an immutable instance of [FineTuningJob].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .error()
         * .fineTunedModel()
         * .finishedAt()
         * .hyperparameters()
         * .model()
         * .organizationId()
         * .resultFiles()
         * .seed()
         * .status()
         * .trainedTokens()
         * .trainingFile()
         * .validationFile()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
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
                metadata,
                method,
                additionalProperties.toMutableMap(),
            )
    }

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
        status().validate()
        trainedTokens()
        trainingFile()
        validationFile()
        estimatedFinish()
        integrations().ifPresent { it.forEach { it.validate() } }
        metadata().ifPresent { it.validate() }
        method().ifPresent { it.validate() }
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
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fineTunedModel.asKnown().isPresent) 1 else 0) +
            (if (finishedAt.asKnown().isPresent) 1 else 0) +
            (hyperparameters.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("fine_tuning.job")) 1 else 0 } +
            (if (organizationId.asKnown().isPresent) 1 else 0) +
            (resultFiles.asKnown().getOrNull()?.size ?: 0) +
            (if (seed.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (trainedTokens.asKnown().isPresent) 1 else 0) +
            (if (trainingFile.asKnown().isPresent) 1 else 0) +
            (if (validationFile.asKnown().isPresent) 1 else 0) +
            (if (estimatedFinish.asKnown().isPresent) 1 else 0) +
            (integrations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (method.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * For fine-tuning jobs that have `failed`, this will contain more information on the cause of
     * the failure.
     */
    class Error
    private constructor(
        private val code: JsonField<String>,
        private val message: JsonField<String>,
        private val param: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
        ) : this(code, message, param, mutableMapOf())

        /**
         * A machine-readable error code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): String = code.getRequired("code")

        /**
         * A human-readable error message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * The parameter that was invalid, usually `training_file` or `validation_file`. This field
         * will be null if the failure was not parameter-specific.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun param(): Optional<String> = param.getOptional("param")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        /**
         * Returns the raw JSON value of [param].
         *
         * Unlike [param], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

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
             * Returns a mutable builder for constructing an instance of [Error].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * .param()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
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

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** A human-readable error message. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /**
             * The parameter that was invalid, usually `training_file` or `validation_file`. This
             * field will be null if the failure was not parameter-specific.
             */
            fun param(param: String?) = param(JsonField.ofNullable(param))

            /** Alias for calling [Builder.param] with `param.orElse(null)`. */
            fun param(param: Optional<String>) = param(param.getOrNull())

            /**
             * Sets [Builder.param] to an arbitrary JSON value.
             *
             * You should usually call [Builder.param] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * .param()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Error =
                Error(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    checkRequired("param", param),
                    additionalProperties.toMutableMap(),
                )
        }

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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                (if (param.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                message == other.message &&
                param == other.param &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, message, param, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, message=$message, param=$param, additionalProperties=$additionalProperties}"
    }

    /**
     * The hyperparameters used for the fine-tuning job. This value will only be returned when
     * running `supervised` jobs.
     */
    class Hyperparameters
    private constructor(
        private val batchSize: JsonField<BatchSize>,
        private val learningRateMultiplier: JsonField<LearningRateMultiplier>,
        private val nEpochs: JsonField<NEpochs>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("batch_size")
            @ExcludeMissing
            batchSize: JsonField<BatchSize> = JsonMissing.of(),
            @JsonProperty("learning_rate_multiplier")
            @ExcludeMissing
            learningRateMultiplier: JsonField<LearningRateMultiplier> = JsonMissing.of(),
            @JsonProperty("n_epochs") @ExcludeMissing nEpochs: JsonField<NEpochs> = JsonMissing.of(),
        ) : this(batchSize, learningRateMultiplier, nEpochs, mutableMapOf())

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun batchSize(): Optional<BatchSize> = batchSize.getOptional("batch_size")

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
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
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
        @JsonProperty("batch_size")
        @ExcludeMissing
        fun _batchSize(): JsonField<BatchSize> = batchSize

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

            /** Returns a mutable builder for constructing an instance of [Hyperparameters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Hyperparameters]. */
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
            fun batchSize(batchSize: BatchSize?) = batchSize(JsonField.ofNullable(batchSize))

            /** Alias for calling [Builder.batchSize] with `batchSize.orElse(null)`. */
            fun batchSize(batchSize: Optional<BatchSize>) = batchSize(batchSize.getOrNull())

            /**
             * Sets [Builder.batchSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.batchSize] with a well-typed [BatchSize] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun batchSize(batchSize: JsonField<BatchSize>) = apply { this.batchSize = batchSize }

            /** Alias for calling [batchSize] with `BatchSize.ofAuto()`. */
            fun batchSizeAuto() = batchSize(BatchSize.ofAuto())

            /** Alias for calling [batchSize] with `BatchSize.ofManual(manual)`. */
            fun batchSize(manual: Long) = batchSize(BatchSize.ofManual(manual))

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
             * [LearningRateMultiplier] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun learningRateMultiplier(learningRateMultiplier: JsonField<LearningRateMultiplier>) =
                apply {
                    this.learningRateMultiplier = learningRateMultiplier
                }

            /**
             * Alias for calling [learningRateMultiplier] with `LearningRateMultiplier.ofAuto()`.
             */
            fun learningRateMultiplierAuto() =
                learningRateMultiplier(LearningRateMultiplier.ofAuto())

            /**
             * Alias for calling [learningRateMultiplier] with
             * `LearningRateMultiplier.ofNumber(number)`.
             */
            fun learningRateMultiplier(number: Double) =
                learningRateMultiplier(LearningRateMultiplier.ofNumber(number))

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            fun nEpochs(nEpochs: NEpochs) = nEpochs(JsonField.of(nEpochs))

            /**
             * Sets [Builder.nEpochs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nEpochs] with a well-typed [NEpochs] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Hyperparameters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Hyperparameters =
                Hyperparameters(
                    batchSize,
                    learningRateMultiplier,
                    nEpochs,
                    additionalProperties.toMutableMap(),
                )
        }

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
            (batchSize.asKnown().getOrNull()?.validity() ?: 0) +
                (learningRateMultiplier.asKnown().getOrNull()?.validity() ?: 0) +
                (nEpochs.asKnown().getOrNull()?.validity() ?: 0)

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

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    auto != null -> visitor.visitAuto(auto)
                    manual != null -> visitor.visitManual(manual)
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

                        override fun visitManual(manual: Long) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is BatchSize && auto == other.auto && manual == other.manual
            }

            override fun hashCode(): Int = Objects.hash(auto, manual)

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

            /**
             * An interface that defines how to map each variant of [BatchSize] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitManual(manual: Long): T

                /**
                 * Maps an unknown variant of [BatchSize] to a value of type [T].
                 *
                 * An instance of [BatchSize] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
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
                                    BatchSize(manual = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> BatchSize(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
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

                return other is LearningRateMultiplier &&
                    auto == other.auto &&
                    number == other.number
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
             * An interface that defines how to map each variant of [LearningRateMultiplier] to a
             * value of type [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitNumber(number: Double): T

                /**
                 * Maps an unknown variant of [LearningRateMultiplier] to a value of type [T].
                 *
                 * An instance of [LearningRateMultiplier] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> LearningRateMultiplier(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
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
             * An interface that defines how to map each variant of [NEpochs] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitAuto(auto: JsonValue): T

                fun visitInteger(integer: Long): T

                /**
                 * Maps an unknown variant of [NEpochs] to a value of type [T].
                 *
                 * An instance of [NEpochs] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> NEpochs(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
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

            return other is Hyperparameters &&
                batchSize == other.batchSize &&
                learningRateMultiplier == other.learningRateMultiplier &&
                nEpochs == other.nEpochs &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(batchSize, learningRateMultiplier, nEpochs, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"
    }

    /**
     * The current status of the fine-tuning job, which can be either `validating_files`, `queued`,
     * `running`, `succeeded`, `failed`, or `cancelled`.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val VALIDATING_FILES = of("validating_files")

            @JvmField val QUEUED = of("queued")

            @JvmField val RUNNING = of("running")

            @JvmField val SUCCEEDED = of("succeeded")

            @JvmField val FAILED = of("failed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            VALIDATING_FILES,
            QUEUED,
            RUNNING,
            SUCCEEDED,
            FAILED,
            CANCELLED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            VALIDATING_FILES,
            QUEUED,
            RUNNING,
            SUCCEEDED,
            FAILED,
            CANCELLED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                VALIDATING_FILES -> Value.VALIDATING_FILES
                QUEUED -> Value.QUEUED
                RUNNING -> Value.RUNNING
                SUCCEEDED -> Value.SUCCEEDED
                FAILED -> Value.FAILED
                CANCELLED -> Value.CANCELLED
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
                VALIDATING_FILES -> Known.VALIDATING_FILES
                QUEUED -> Known.QUEUED
                RUNNING -> Known.RUNNING
                SUCCEEDED -> Known.SUCCEEDED
                FAILED -> Known.FAILED
                CANCELLED -> Known.CANCELLED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /** The method used for fine-tuning. */
    class Method
    private constructor(
        private val type: JsonField<Type>,
        private val dpo: JsonField<DpoMethod>,
        private val reinforcement: JsonField<ReinforcementMethod>,
        private val supervised: JsonField<SupervisedMethod>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("dpo") @ExcludeMissing dpo: JsonField<DpoMethod> = JsonMissing.of(),
            @JsonProperty("reinforcement")
            @ExcludeMissing
            reinforcement: JsonField<ReinforcementMethod> = JsonMissing.of(),
            @JsonProperty("supervised")
            @ExcludeMissing
            supervised: JsonField<SupervisedMethod> = JsonMissing.of(),
        ) : this(type, dpo, reinforcement, supervised, mutableMapOf())

        /**
         * The type of method. Is either `supervised`, `dpo`, or `reinforcement`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Configuration for the DPO fine-tuning method.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun dpo(): Optional<DpoMethod> = dpo.getOptional("dpo")

        /**
         * Configuration for the reinforcement fine-tuning method.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reinforcement(): Optional<ReinforcementMethod> =
            reinforcement.getOptional("reinforcement")

        /**
         * Configuration for the supervised fine-tuning method.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun supervised(): Optional<SupervisedMethod> = supervised.getOptional("supervised")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [dpo].
         *
         * Unlike [dpo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dpo") @ExcludeMissing fun _dpo(): JsonField<DpoMethod> = dpo

        /**
         * Returns the raw JSON value of [reinforcement].
         *
         * Unlike [reinforcement], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reinforcement")
        @ExcludeMissing
        fun _reinforcement(): JsonField<ReinforcementMethod> = reinforcement

        /**
         * Returns the raw JSON value of [supervised].
         *
         * Unlike [supervised], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("supervised")
        @ExcludeMissing
        fun _supervised(): JsonField<SupervisedMethod> = supervised

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
             * Returns a mutable builder for constructing an instance of [Method].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Method]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var dpo: JsonField<DpoMethod> = JsonMissing.of()
            private var reinforcement: JsonField<ReinforcementMethod> = JsonMissing.of()
            private var supervised: JsonField<SupervisedMethod> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(method: Method) = apply {
                type = method.type
                dpo = method.dpo
                reinforcement = method.reinforcement
                supervised = method.supervised
                additionalProperties = method.additionalProperties.toMutableMap()
            }

            /** The type of method. Is either `supervised`, `dpo`, or `reinforcement`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /** Configuration for the DPO fine-tuning method. */
            fun dpo(dpo: DpoMethod) = dpo(JsonField.of(dpo))

            /**
             * Sets [Builder.dpo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dpo] with a well-typed [DpoMethod] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dpo(dpo: JsonField<DpoMethod>) = apply { this.dpo = dpo }

            /** Configuration for the reinforcement fine-tuning method. */
            fun reinforcement(reinforcement: ReinforcementMethod) =
                reinforcement(JsonField.of(reinforcement))

            /**
             * Sets [Builder.reinforcement] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reinforcement] with a well-typed
             * [ReinforcementMethod] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun reinforcement(reinforcement: JsonField<ReinforcementMethod>) = apply {
                this.reinforcement = reinforcement
            }

            /** Configuration for the supervised fine-tuning method. */
            fun supervised(supervised: SupervisedMethod) = supervised(JsonField.of(supervised))

            /**
             * Sets [Builder.supervised] to an arbitrary JSON value.
             *
             * You should usually call [Builder.supervised] with a well-typed [SupervisedMethod]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun supervised(supervised: JsonField<SupervisedMethod>) = apply {
                this.supervised = supervised
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
             * Returns an immutable instance of [Method].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Method =
                Method(
                    checkRequired("type", type),
                    dpo,
                    reinforcement,
                    supervised,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Method = apply {
            if (validated) {
                return@apply
            }

            type().validate()
            dpo().ifPresent { it.validate() }
            reinforcement().ifPresent { it.validate() }
            supervised().ifPresent { it.validate() }
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
                (dpo.asKnown().getOrNull()?.validity() ?: 0) +
                (reinforcement.asKnown().getOrNull()?.validity() ?: 0) +
                (supervised.asKnown().getOrNull()?.validity() ?: 0)

        /** The type of method. Is either `supervised`, `dpo`, or `reinforcement`. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUPERVISED = of("supervised")

                @JvmField val DPO = of("dpo")

                @JvmField val REINFORCEMENT = of("reinforcement")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                SUPERVISED,
                DPO,
                REINFORCEMENT,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SUPERVISED,
                DPO,
                REINFORCEMENT,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SUPERVISED -> Value.SUPERVISED
                    DPO -> Value.DPO
                    REINFORCEMENT -> Value.REINFORCEMENT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SUPERVISED -> Known.SUPERVISED
                    DPO -> Known.DPO
                    REINFORCEMENT -> Known.REINFORCEMENT
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Method &&
                type == other.type &&
                dpo == other.dpo &&
                reinforcement == other.reinforcement &&
                supervised == other.supervised &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(type, dpo, reinforcement, supervised, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Method{type=$type, dpo=$dpo, reinforcement=$reinforcement, supervised=$supervised, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FineTuningJob &&
            id == other.id &&
            createdAt == other.createdAt &&
            error == other.error &&
            fineTunedModel == other.fineTunedModel &&
            finishedAt == other.finishedAt &&
            hyperparameters == other.hyperparameters &&
            model == other.model &&
            object_ == other.object_ &&
            organizationId == other.organizationId &&
            resultFiles == other.resultFiles &&
            seed == other.seed &&
            status == other.status &&
            trainedTokens == other.trainedTokens &&
            trainingFile == other.trainingFile &&
            validationFile == other.validationFile &&
            estimatedFinish == other.estimatedFinish &&
            integrations == other.integrations &&
            metadata == other.metadata &&
            method == other.method &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            error,
            fineTunedModel,
            finishedAt,
            hyperparameters,
            model,
            object_,
            organizationId,
            resultFiles,
            seed,
            status,
            trainedTokens,
            trainingFile,
            validationFile,
            estimatedFinish,
            integrations,
            metadata,
            method,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJob{id=$id, createdAt=$createdAt, error=$error, fineTunedModel=$fineTunedModel, finishedAt=$finishedAt, hyperparameters=$hyperparameters, model=$model, object_=$object_, organizationId=$organizationId, resultFiles=$resultFiles, seed=$seed, status=$status, trainedTokens=$trainedTokens, trainingFile=$trainingFile, validationFile=$validationFile, estimatedFinish=$estimatedFinish, integrations=$integrations, metadata=$metadata, method=$method, additionalProperties=$additionalProperties}"
}
