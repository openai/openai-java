// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

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
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A schema representing an evaluation run. */
class RunCancelResponse
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val dataSource: JsonField<DataSource>,
    private val error: JsonField<EvalApiError>,
    private val evalId: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<String>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val perModelUsage: JsonField<List<PerModelUsage>>,
    private val perTestingCriteriaResults: JsonField<List<PerTestingCriteriaResult>>,
    private val reportUrl: JsonField<String>,
    private val resultCounts: JsonField<ResultCounts>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data_source")
        @ExcludeMissing
        dataSource: JsonField<DataSource> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<EvalApiError> = JsonMissing.of(),
        @JsonProperty("eval_id") @ExcludeMissing evalId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("per_model_usage")
        @ExcludeMissing
        perModelUsage: JsonField<List<PerModelUsage>> = JsonMissing.of(),
        @JsonProperty("per_testing_criteria_results")
        @ExcludeMissing
        perTestingCriteriaResults: JsonField<List<PerTestingCriteriaResult>> = JsonMissing.of(),
        @JsonProperty("report_url") @ExcludeMissing reportUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("result_counts")
        @ExcludeMissing
        resultCounts: JsonField<ResultCounts> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        dataSource,
        error,
        evalId,
        metadata,
        model,
        name,
        object_,
        perModelUsage,
        perTestingCriteriaResults,
        reportUrl,
        resultCounts,
        status,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) when the evaluation run was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Information about the run's data source.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dataSource(): DataSource = dataSource.getRequired("data_source")

    /**
     * An object representing an error response from the Eval API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun error(): EvalApiError = error.getRequired("error")

    /**
     * The identifier of the associated evaluation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun evalId(): String = evalId.getRequired("eval_id")

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
     * The model that is evaluated, if applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The name of the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The type of the object. Always "eval.run".
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("eval.run")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Usage statistics for each model during the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun perModelUsage(): List<PerModelUsage> = perModelUsage.getRequired("per_model_usage")

    /**
     * Results per testing criteria applied during the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun perTestingCriteriaResults(): List<PerTestingCriteriaResult> =
        perTestingCriteriaResults.getRequired("per_testing_criteria_results")

    /**
     * The URL to the rendered evaluation run report on the UI dashboard.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reportUrl(): String = reportUrl.getRequired("report_url")

    /**
     * Counters summarizing the outcomes of the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun resultCounts(): ResultCounts = resultCounts.getRequired("result_counts")

    /**
     * The status of the evaluation run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

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
     * Returns the raw JSON value of [dataSource].
     *
     * Unlike [dataSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data_source")
    @ExcludeMissing
    fun _dataSource(): JsonField<DataSource> = dataSource

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<EvalApiError> = error

    /**
     * Returns the raw JSON value of [evalId].
     *
     * Unlike [evalId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eval_id") @ExcludeMissing fun _evalId(): JsonField<String> = evalId

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [perModelUsage].
     *
     * Unlike [perModelUsage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("per_model_usage")
    @ExcludeMissing
    fun _perModelUsage(): JsonField<List<PerModelUsage>> = perModelUsage

    /**
     * Returns the raw JSON value of [perTestingCriteriaResults].
     *
     * Unlike [perTestingCriteriaResults], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("per_testing_criteria_results")
    @ExcludeMissing
    fun _perTestingCriteriaResults(): JsonField<List<PerTestingCriteriaResult>> =
        perTestingCriteriaResults

    /**
     * Returns the raw JSON value of [reportUrl].
     *
     * Unlike [reportUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("report_url") @ExcludeMissing fun _reportUrl(): JsonField<String> = reportUrl

    /**
     * Returns the raw JSON value of [resultCounts].
     *
     * Unlike [resultCounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("result_counts")
    @ExcludeMissing
    fun _resultCounts(): JsonField<ResultCounts> = resultCounts

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
         * Returns a mutable builder for constructing an instance of [RunCancelResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .dataSource()
         * .error()
         * .evalId()
         * .metadata()
         * .model()
         * .name()
         * .perModelUsage()
         * .perTestingCriteriaResults()
         * .reportUrl()
         * .resultCounts()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RunCancelResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var dataSource: JsonField<DataSource>? = null
        private var error: JsonField<EvalApiError>? = null
        private var evalId: JsonField<String>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("eval.run")
        private var perModelUsage: JsonField<MutableList<PerModelUsage>>? = null
        private var perTestingCriteriaResults: JsonField<MutableList<PerTestingCriteriaResult>>? =
            null
        private var reportUrl: JsonField<String>? = null
        private var resultCounts: JsonField<ResultCounts>? = null
        private var status: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runCancelResponse: RunCancelResponse) = apply {
            id = runCancelResponse.id
            createdAt = runCancelResponse.createdAt
            dataSource = runCancelResponse.dataSource
            error = runCancelResponse.error
            evalId = runCancelResponse.evalId
            metadata = runCancelResponse.metadata
            model = runCancelResponse.model
            name = runCancelResponse.name
            object_ = runCancelResponse.object_
            perModelUsage = runCancelResponse.perModelUsage.map { it.toMutableList() }
            perTestingCriteriaResults =
                runCancelResponse.perTestingCriteriaResults.map { it.toMutableList() }
            reportUrl = runCancelResponse.reportUrl
            resultCounts = runCancelResponse.resultCounts
            status = runCancelResponse.status
            additionalProperties = runCancelResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the evaluation run. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) when the evaluation run was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Information about the run's data source. */
        fun dataSource(dataSource: DataSource) = dataSource(JsonField.of(dataSource))

        /**
         * Sets [Builder.dataSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dataSource] with a well-typed [DataSource] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dataSource(dataSource: JsonField<DataSource>) = apply { this.dataSource = dataSource }

        /** Alias for calling [dataSource] with `DataSource.ofJsonl(jsonl)`. */
        fun dataSource(jsonl: CreateEvalJsonlRunDataSource) = dataSource(DataSource.ofJsonl(jsonl))

        /**
         * Alias for calling [dataSource] with the following:
         * ```java
         * CreateEvalJsonlRunDataSource.builder()
         *     .source(source)
         *     .build()
         * ```
         */
        fun jsonlDataSource(source: CreateEvalJsonlRunDataSource.Source) =
            dataSource(CreateEvalJsonlRunDataSource.builder().source(source).build())

        /**
         * Alias for calling [jsonlDataSource] with
         * `CreateEvalJsonlRunDataSource.Source.ofFileContent(fileContent)`.
         */
        fun jsonlDataSource(fileContent: CreateEvalJsonlRunDataSource.Source.FileContent) =
            jsonlDataSource(CreateEvalJsonlRunDataSource.Source.ofFileContent(fileContent))

        /**
         * Alias for calling [jsonlDataSource] with the following:
         * ```java
         * CreateEvalJsonlRunDataSource.Source.FileContent.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun fileContentJsonlDataSource(
            content: List<CreateEvalJsonlRunDataSource.Source.FileContent.Content>
        ) =
            jsonlDataSource(
                CreateEvalJsonlRunDataSource.Source.FileContent.builder().content(content).build()
            )

        /**
         * Alias for calling [jsonlDataSource] with
         * `CreateEvalJsonlRunDataSource.Source.ofFileId(fileId)`.
         */
        fun jsonlDataSource(fileId: CreateEvalJsonlRunDataSource.Source.FileId) =
            jsonlDataSource(CreateEvalJsonlRunDataSource.Source.ofFileId(fileId))

        /**
         * Alias for calling [jsonlDataSource] with the following:
         * ```java
         * CreateEvalJsonlRunDataSource.Source.FileId.builder()
         *     .id(id)
         *     .build()
         * ```
         */
        fun fileIdJsonlDataSource(id: String) =
            jsonlDataSource(CreateEvalJsonlRunDataSource.Source.FileId.builder().id(id).build())

        /** Alias for calling [dataSource] with `DataSource.ofCompletions(completions)`. */
        fun dataSource(completions: CreateEvalCompletionsRunDataSource) =
            dataSource(DataSource.ofCompletions(completions))

        /** An object representing an error response from the Eval API. */
        fun error(error: EvalApiError) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [EvalApiError] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun error(error: JsonField<EvalApiError>) = apply { this.error = error }

        /** The identifier of the associated evaluation. */
        fun evalId(evalId: String) = evalId(JsonField.of(evalId))

        /**
         * Sets [Builder.evalId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.evalId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun evalId(evalId: JsonField<String>) = apply { this.evalId = evalId }

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

        /** The model that is evaluated, if applicable. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The name of the evaluation run. */
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
         * JsonValue.from("eval.run")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Usage statistics for each model during the evaluation run. */
        fun perModelUsage(perModelUsage: List<PerModelUsage>) =
            perModelUsage(JsonField.of(perModelUsage))

        /**
         * Sets [Builder.perModelUsage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.perModelUsage] with a well-typed `List<PerModelUsage>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun perModelUsage(perModelUsage: JsonField<List<PerModelUsage>>) = apply {
            this.perModelUsage = perModelUsage.map { it.toMutableList() }
        }

        /**
         * Adds a single [PerModelUsage] to [Builder.perModelUsage].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPerModelUsage(perModelUsage: PerModelUsage) = apply {
            this.perModelUsage =
                (this.perModelUsage ?: JsonField.of(mutableListOf())).also {
                    checkKnown("perModelUsage", it).add(perModelUsage)
                }
        }

        /** Results per testing criteria applied during the evaluation run. */
        fun perTestingCriteriaResults(perTestingCriteriaResults: List<PerTestingCriteriaResult>) =
            perTestingCriteriaResults(JsonField.of(perTestingCriteriaResults))

        /**
         * Sets [Builder.perTestingCriteriaResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.perTestingCriteriaResults] with a well-typed
         * `List<PerTestingCriteriaResult>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun perTestingCriteriaResults(
            perTestingCriteriaResults: JsonField<List<PerTestingCriteriaResult>>
        ) = apply {
            this.perTestingCriteriaResults = perTestingCriteriaResults.map { it.toMutableList() }
        }

        /**
         * Adds a single [PerTestingCriteriaResult] to [perTestingCriteriaResults].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPerTestingCriteriaResult(perTestingCriteriaResult: PerTestingCriteriaResult) =
            apply {
                perTestingCriteriaResults =
                    (perTestingCriteriaResults ?: JsonField.of(mutableListOf())).also {
                        checkKnown("perTestingCriteriaResults", it).add(perTestingCriteriaResult)
                    }
            }

        /** The URL to the rendered evaluation run report on the UI dashboard. */
        fun reportUrl(reportUrl: String) = reportUrl(JsonField.of(reportUrl))

        /**
         * Sets [Builder.reportUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reportUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reportUrl(reportUrl: JsonField<String>) = apply { this.reportUrl = reportUrl }

        /** Counters summarizing the outcomes of the evaluation run. */
        fun resultCounts(resultCounts: ResultCounts) = resultCounts(JsonField.of(resultCounts))

        /**
         * Sets [Builder.resultCounts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resultCounts] with a well-typed [ResultCounts] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun resultCounts(resultCounts: JsonField<ResultCounts>) = apply {
            this.resultCounts = resultCounts
        }

        /** The status of the evaluation run. */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [RunCancelResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .dataSource()
         * .error()
         * .evalId()
         * .metadata()
         * .model()
         * .name()
         * .perModelUsage()
         * .perTestingCriteriaResults()
         * .reportUrl()
         * .resultCounts()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RunCancelResponse =
            RunCancelResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("dataSource", dataSource),
                checkRequired("error", error),
                checkRequired("evalId", evalId),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                checkRequired("name", name),
                object_,
                checkRequired("perModelUsage", perModelUsage).map { it.toImmutable() },
                checkRequired("perTestingCriteriaResults", perTestingCriteriaResults).map {
                    it.toImmutable()
                },
                checkRequired("reportUrl", reportUrl),
                checkRequired("resultCounts", resultCounts),
                checkRequired("status", status),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RunCancelResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        dataSource().validate()
        error().validate()
        evalId()
        metadata().ifPresent { it.validate() }
        model()
        name()
        _object_().let {
            if (it != JsonValue.from("eval.run")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        perModelUsage().forEach { it.validate() }
        perTestingCriteriaResults().forEach { it.validate() }
        reportUrl()
        resultCounts().validate()
        status()
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
            (dataSource.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (evalId.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("eval.run")) 1 else 0 } +
            (perModelUsage.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (perTestingCriteriaResults.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                ?: 0) +
            (if (reportUrl.asKnown().isPresent) 1 else 0) +
            (resultCounts.asKnown().getOrNull()?.validity() ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    /** Information about the run's data source. */
    @JsonDeserialize(using = DataSource.Deserializer::class)
    @JsonSerialize(using = DataSource.Serializer::class)
    class DataSource
    private constructor(
        private val jsonl: CreateEvalJsonlRunDataSource? = null,
        private val completions: CreateEvalCompletionsRunDataSource? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun jsonl(): Optional<CreateEvalJsonlRunDataSource> = Optional.ofNullable(jsonl)

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun completions(): Optional<CreateEvalCompletionsRunDataSource> =
            Optional.ofNullable(completions)

        fun isJsonl(): Boolean = jsonl != null

        fun isCompletions(): Boolean = completions != null

        /** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
        fun asJsonl(): CreateEvalJsonlRunDataSource = jsonl.getOrThrow("jsonl")

        /** A CompletionsRunDataSource object describing a model sampling configuration. */
        fun asCompletions(): CreateEvalCompletionsRunDataSource =
            completions.getOrThrow("completions")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                jsonl != null -> visitor.visitJsonl(jsonl)
                completions != null -> visitor.visitCompletions(completions)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): DataSource = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitJsonl(jsonl: CreateEvalJsonlRunDataSource) {
                        jsonl.validate()
                    }

                    override fun visitCompletions(completions: CreateEvalCompletionsRunDataSource) {
                        completions.validate()
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
                    override fun visitJsonl(jsonl: CreateEvalJsonlRunDataSource) = jsonl.validity()

                    override fun visitCompletions(completions: CreateEvalCompletionsRunDataSource) =
                        completions.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DataSource && jsonl == other.jsonl && completions == other.completions /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(jsonl, completions) /* spotless:on */

        override fun toString(): String =
            when {
                jsonl != null -> "DataSource{jsonl=$jsonl}"
                completions != null -> "DataSource{completions=$completions}"
                _json != null -> "DataSource{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid DataSource")
            }

        companion object {

            /**
             * A JsonlRunDataSource object with that specifies a JSONL file that matches the eval
             */
            @JvmStatic fun ofJsonl(jsonl: CreateEvalJsonlRunDataSource) = DataSource(jsonl = jsonl)

            /** A CompletionsRunDataSource object describing a model sampling configuration. */
            @JvmStatic
            fun ofCompletions(completions: CreateEvalCompletionsRunDataSource) =
                DataSource(completions = completions)
        }

        /**
         * An interface that defines how to map each variant of [DataSource] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * A JsonlRunDataSource object with that specifies a JSONL file that matches the eval
             */
            fun visitJsonl(jsonl: CreateEvalJsonlRunDataSource): T

            /** A CompletionsRunDataSource object describing a model sampling configuration. */
            fun visitCompletions(completions: CreateEvalCompletionsRunDataSource): T

            /**
             * Maps an unknown variant of [DataSource] to a value of type [T].
             *
             * An instance of [DataSource] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown DataSource: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<DataSource>(DataSource::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): DataSource {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "jsonl" -> {
                        return tryDeserialize(node, jacksonTypeRef<CreateEvalJsonlRunDataSource>())
                            ?.let { DataSource(jsonl = it, _json = json) }
                            ?: DataSource(_json = json)
                    }
                    "completions" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<CreateEvalCompletionsRunDataSource>(),
                            )
                            ?.let { DataSource(completions = it, _json = json) }
                            ?: DataSource(_json = json)
                    }
                }

                return DataSource(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<DataSource>(DataSource::class) {

            override fun serialize(
                value: DataSource,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.jsonl != null -> generator.writeObject(value.jsonl)
                    value.completions != null -> generator.writeObject(value.completions)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid DataSource")
                }
            }
        }
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

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    class PerModelUsage
    private constructor(
        private val cachedTokens: JsonField<Long>,
        private val completionTokens: JsonField<Long>,
        private val invocationCount: JsonField<Long>,
        private val modelName: JsonField<String>,
        private val promptTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            cachedTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("completion_tokens")
            @ExcludeMissing
            completionTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("invocation_count")
            @ExcludeMissing
            invocationCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("model_name")
            @ExcludeMissing
            modelName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            promptTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total_tokens")
            @ExcludeMissing
            totalTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(
            cachedTokens,
            completionTokens,
            invocationCount,
            modelName,
            promptTokens,
            totalTokens,
            mutableMapOf(),
        )

        /**
         * The number of tokens retrieved from cache.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cachedTokens(): Long = cachedTokens.getRequired("cached_tokens")

        /**
         * The number of completion tokens generated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        /**
         * The number of invocations.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun invocationCount(): Long = invocationCount.getRequired("invocation_count")

        /**
         * The name of the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun modelName(): String = modelName.getRequired("model_name")

        /**
         * The number of prompt tokens used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /**
         * The total number of tokens used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /**
         * Returns the raw JSON value of [cachedTokens].
         *
         * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cached_tokens")
        @ExcludeMissing
        fun _cachedTokens(): JsonField<Long> = cachedTokens

        /**
         * Returns the raw JSON value of [completionTokens].
         *
         * Unlike [completionTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun _completionTokens(): JsonField<Long> = completionTokens

        /**
         * Returns the raw JSON value of [invocationCount].
         *
         * Unlike [invocationCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("invocation_count")
        @ExcludeMissing
        fun _invocationCount(): JsonField<Long> = invocationCount

        /**
         * Returns the raw JSON value of [modelName].
         *
         * Unlike [modelName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model_name") @ExcludeMissing fun _modelName(): JsonField<String> = modelName

        /**
         * Returns the raw JSON value of [promptTokens].
         *
         * Unlike [promptTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        fun _promptTokens(): JsonField<Long> = promptTokens

        /**
         * Returns the raw JSON value of [totalTokens].
         *
         * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun _totalTokens(): JsonField<Long> = totalTokens

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
             * Returns a mutable builder for constructing an instance of [PerModelUsage].
             *
             * The following fields are required:
             * ```java
             * .cachedTokens()
             * .completionTokens()
             * .invocationCount()
             * .modelName()
             * .promptTokens()
             * .totalTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PerModelUsage]. */
        class Builder internal constructor() {

            private var cachedTokens: JsonField<Long>? = null
            private var completionTokens: JsonField<Long>? = null
            private var invocationCount: JsonField<Long>? = null
            private var modelName: JsonField<String>? = null
            private var promptTokens: JsonField<Long>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(perModelUsage: PerModelUsage) = apply {
                cachedTokens = perModelUsage.cachedTokens
                completionTokens = perModelUsage.completionTokens
                invocationCount = perModelUsage.invocationCount
                modelName = perModelUsage.modelName
                promptTokens = perModelUsage.promptTokens
                totalTokens = perModelUsage.totalTokens
                additionalProperties = perModelUsage.additionalProperties.toMutableMap()
            }

            /** The number of tokens retrieved from cache. */
            fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

            /**
             * Sets [Builder.cachedTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cachedTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                this.cachedTokens = cachedTokens
            }

            /** The number of completion tokens generated. */
            fun completionTokens(completionTokens: Long) =
                completionTokens(JsonField.of(completionTokens))

            /**
             * Sets [Builder.completionTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completionTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun completionTokens(completionTokens: JsonField<Long>) = apply {
                this.completionTokens = completionTokens
            }

            /** The number of invocations. */
            fun invocationCount(invocationCount: Long) =
                invocationCount(JsonField.of(invocationCount))

            /**
             * Sets [Builder.invocationCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.invocationCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun invocationCount(invocationCount: JsonField<Long>) = apply {
                this.invocationCount = invocationCount
            }

            /** The name of the model. */
            fun modelName(modelName: String) = modelName(JsonField.of(modelName))

            /**
             * Sets [Builder.modelName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modelName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun modelName(modelName: JsonField<String>) = apply { this.modelName = modelName }

            /** The number of prompt tokens used. */
            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            /**
             * Sets [Builder.promptTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promptTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            /** The total number of tokens used. */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /**
             * Sets [Builder.totalTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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
             * Returns an immutable instance of [PerModelUsage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .cachedTokens()
             * .completionTokens()
             * .invocationCount()
             * .modelName()
             * .promptTokens()
             * .totalTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PerModelUsage =
                PerModelUsage(
                    checkRequired("cachedTokens", cachedTokens),
                    checkRequired("completionTokens", completionTokens),
                    checkRequired("invocationCount", invocationCount),
                    checkRequired("modelName", modelName),
                    checkRequired("promptTokens", promptTokens),
                    checkRequired("totalTokens", totalTokens),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PerModelUsage = apply {
            if (validated) {
                return@apply
            }

            cachedTokens()
            completionTokens()
            invocationCount()
            modelName()
            promptTokens()
            totalTokens()
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
            (if (cachedTokens.asKnown().isPresent) 1 else 0) +
                (if (completionTokens.asKnown().isPresent) 1 else 0) +
                (if (invocationCount.asKnown().isPresent) 1 else 0) +
                (if (modelName.asKnown().isPresent) 1 else 0) +
                (if (promptTokens.asKnown().isPresent) 1 else 0) +
                (if (totalTokens.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PerModelUsage && cachedTokens == other.cachedTokens && completionTokens == other.completionTokens && invocationCount == other.invocationCount && modelName == other.modelName && promptTokens == other.promptTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cachedTokens, completionTokens, invocationCount, modelName, promptTokens, totalTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PerModelUsage{cachedTokens=$cachedTokens, completionTokens=$completionTokens, invocationCount=$invocationCount, modelName=$modelName, promptTokens=$promptTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    class PerTestingCriteriaResult
    private constructor(
        private val failed: JsonField<Long>,
        private val passed: JsonField<Long>,
        private val testingCriteria: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("failed") @ExcludeMissing failed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("passed") @ExcludeMissing passed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("testing_criteria")
            @ExcludeMissing
            testingCriteria: JsonField<String> = JsonMissing.of(),
        ) : this(failed, passed, testingCriteria, mutableMapOf())

        /**
         * Number of tests failed for this criteria.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun failed(): Long = failed.getRequired("failed")

        /**
         * Number of tests passed for this criteria.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun passed(): Long = passed.getRequired("passed")

        /**
         * A description of the testing criteria.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun testingCriteria(): String = testingCriteria.getRequired("testing_criteria")

        /**
         * Returns the raw JSON value of [failed].
         *
         * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

        /**
         * Returns the raw JSON value of [passed].
         *
         * Unlike [passed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("passed") @ExcludeMissing fun _passed(): JsonField<Long> = passed

        /**
         * Returns the raw JSON value of [testingCriteria].
         *
         * Unlike [testingCriteria], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("testing_criteria")
        @ExcludeMissing
        fun _testingCriteria(): JsonField<String> = testingCriteria

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
             * Returns a mutable builder for constructing an instance of [PerTestingCriteriaResult].
             *
             * The following fields are required:
             * ```java
             * .failed()
             * .passed()
             * .testingCriteria()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PerTestingCriteriaResult]. */
        class Builder internal constructor() {

            private var failed: JsonField<Long>? = null
            private var passed: JsonField<Long>? = null
            private var testingCriteria: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(perTestingCriteriaResult: PerTestingCriteriaResult) = apply {
                failed = perTestingCriteriaResult.failed
                passed = perTestingCriteriaResult.passed
                testingCriteria = perTestingCriteriaResult.testingCriteria
                additionalProperties = perTestingCriteriaResult.additionalProperties.toMutableMap()
            }

            /** Number of tests failed for this criteria. */
            fun failed(failed: Long) = failed(JsonField.of(failed))

            /**
             * Sets [Builder.failed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

            /** Number of tests passed for this criteria. */
            fun passed(passed: Long) = passed(JsonField.of(passed))

            /**
             * Sets [Builder.passed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.passed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun passed(passed: JsonField<Long>) = apply { this.passed = passed }

            /** A description of the testing criteria. */
            fun testingCriteria(testingCriteria: String) =
                testingCriteria(JsonField.of(testingCriteria))

            /**
             * Sets [Builder.testingCriteria] to an arbitrary JSON value.
             *
             * You should usually call [Builder.testingCriteria] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun testingCriteria(testingCriteria: JsonField<String>) = apply {
                this.testingCriteria = testingCriteria
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
             * Returns an immutable instance of [PerTestingCriteriaResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .failed()
             * .passed()
             * .testingCriteria()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PerTestingCriteriaResult =
                PerTestingCriteriaResult(
                    checkRequired("failed", failed),
                    checkRequired("passed", passed),
                    checkRequired("testingCriteria", testingCriteria),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PerTestingCriteriaResult = apply {
            if (validated) {
                return@apply
            }

            failed()
            passed()
            testingCriteria()
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
            (if (failed.asKnown().isPresent) 1 else 0) +
                (if (passed.asKnown().isPresent) 1 else 0) +
                (if (testingCriteria.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PerTestingCriteriaResult && failed == other.failed && passed == other.passed && testingCriteria == other.testingCriteria && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(failed, passed, testingCriteria, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PerTestingCriteriaResult{failed=$failed, passed=$passed, testingCriteria=$testingCriteria, additionalProperties=$additionalProperties}"
    }

    /** Counters summarizing the outcomes of the evaluation run. */
    class ResultCounts
    private constructor(
        private val errored: JsonField<Long>,
        private val failed: JsonField<Long>,
        private val passed: JsonField<Long>,
        private val total: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("errored") @ExcludeMissing errored: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("failed") @ExcludeMissing failed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("passed") @ExcludeMissing passed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        ) : this(errored, failed, passed, total, mutableMapOf())

        /**
         * Number of output items that resulted in an error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun errored(): Long = errored.getRequired("errored")

        /**
         * Number of output items that failed to pass the evaluation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun failed(): Long = failed.getRequired("failed")

        /**
         * Number of output items that passed the evaluation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun passed(): Long = passed.getRequired("passed")

        /**
         * Total number of executed output items.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun total(): Long = total.getRequired("total")

        /**
         * Returns the raw JSON value of [errored].
         *
         * Unlike [errored], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("errored") @ExcludeMissing fun _errored(): JsonField<Long> = errored

        /**
         * Returns the raw JSON value of [failed].
         *
         * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

        /**
         * Returns the raw JSON value of [passed].
         *
         * Unlike [passed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("passed") @ExcludeMissing fun _passed(): JsonField<Long> = passed

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
             * Returns a mutable builder for constructing an instance of [ResultCounts].
             *
             * The following fields are required:
             * ```java
             * .errored()
             * .failed()
             * .passed()
             * .total()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ResultCounts]. */
        class Builder internal constructor() {

            private var errored: JsonField<Long>? = null
            private var failed: JsonField<Long>? = null
            private var passed: JsonField<Long>? = null
            private var total: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(resultCounts: ResultCounts) = apply {
                errored = resultCounts.errored
                failed = resultCounts.failed
                passed = resultCounts.passed
                total = resultCounts.total
                additionalProperties = resultCounts.additionalProperties.toMutableMap()
            }

            /** Number of output items that resulted in an error. */
            fun errored(errored: Long) = errored(JsonField.of(errored))

            /**
             * Sets [Builder.errored] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errored] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errored(errored: JsonField<Long>) = apply { this.errored = errored }

            /** Number of output items that failed to pass the evaluation. */
            fun failed(failed: Long) = failed(JsonField.of(failed))

            /**
             * Sets [Builder.failed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

            /** Number of output items that passed the evaluation. */
            fun passed(passed: Long) = passed(JsonField.of(passed))

            /**
             * Sets [Builder.passed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.passed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun passed(passed: JsonField<Long>) = apply { this.passed = passed }

            /** Total number of executed output items. */
            fun total(total: Long) = total(JsonField.of(total))

            /**
             * Sets [Builder.total] to an arbitrary JSON value.
             *
             * You should usually call [Builder.total] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun total(total: JsonField<Long>) = apply { this.total = total }

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
             * Returns an immutable instance of [ResultCounts].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .errored()
             * .failed()
             * .passed()
             * .total()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ResultCounts =
                ResultCounts(
                    checkRequired("errored", errored),
                    checkRequired("failed", failed),
                    checkRequired("passed", passed),
                    checkRequired("total", total),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ResultCounts = apply {
            if (validated) {
                return@apply
            }

            errored()
            failed()
            passed()
            total()
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
            (if (errored.asKnown().isPresent) 1 else 0) +
                (if (failed.asKnown().isPresent) 1 else 0) +
                (if (passed.asKnown().isPresent) 1 else 0) +
                (if (total.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResultCounts && errored == other.errored && failed == other.failed && passed == other.passed && total == other.total && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(errored, failed, passed, total, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ResultCounts{errored=$errored, failed=$failed, passed=$passed, total=$total, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunCancelResponse && id == other.id && createdAt == other.createdAt && dataSource == other.dataSource && error == other.error && evalId == other.evalId && metadata == other.metadata && model == other.model && name == other.name && object_ == other.object_ && perModelUsage == other.perModelUsage && perTestingCriteriaResults == other.perTestingCriteriaResults && reportUrl == other.reportUrl && resultCounts == other.resultCounts && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, dataSource, error, evalId, metadata, model, name, object_, perModelUsage, perTestingCriteriaResults, reportUrl, resultCounts, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunCancelResponse{id=$id, createdAt=$createdAt, dataSource=$dataSource, error=$error, evalId=$evalId, metadata=$metadata, model=$model, name=$name, object_=$object_, perModelUsage=$perModelUsage, perTestingCriteriaResults=$perTestingCriteriaResults, reportUrl=$reportUrl, resultCounts=$resultCounts, status=$status, additionalProperties=$additionalProperties}"
}
