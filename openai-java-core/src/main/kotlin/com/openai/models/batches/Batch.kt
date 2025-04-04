// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Batch
private constructor(
    private val id: JsonField<String>,
    private val completionWindow: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val endpoint: JsonField<String>,
    private val inputFileId: JsonField<String>,
    private val object_: JsonValue,
    private val status: JsonField<Status>,
    private val cancelledAt: JsonField<Long>,
    private val cancellingAt: JsonField<Long>,
    private val completedAt: JsonField<Long>,
    private val errorFileId: JsonField<String>,
    private val errors: JsonField<Errors>,
    private val expiredAt: JsonField<Long>,
    private val expiresAt: JsonField<Long>,
    private val failedAt: JsonField<Long>,
    private val finalizingAt: JsonField<Long>,
    private val inProgressAt: JsonField<Long>,
    private val metadata: JsonField<Metadata>,
    private val outputFileId: JsonField<String>,
    private val requestCounts: JsonField<BatchRequestCounts>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completion_window")
        @ExcludeMissing
        completionWindow: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("endpoint") @ExcludeMissing endpoint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("input_file_id")
        @ExcludeMissing
        inputFileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("cancelled_at")
        @ExcludeMissing
        cancelledAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cancelling_at")
        @ExcludeMissing
        cancellingAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error_file_id")
        @ExcludeMissing
        errorFileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("errors") @ExcludeMissing errors: JsonField<Errors> = JsonMissing.of(),
        @JsonProperty("expired_at") @ExcludeMissing expiredAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed_at") @ExcludeMissing failedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("finalizing_at")
        @ExcludeMissing
        finalizingAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("in_progress_at")
        @ExcludeMissing
        inProgressAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("output_file_id")
        @ExcludeMissing
        outputFileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request_counts")
        @ExcludeMissing
        requestCounts: JsonField<BatchRequestCounts> = JsonMissing.of(),
    ) : this(
        id,
        completionWindow,
        createdAt,
        endpoint,
        inputFileId,
        object_,
        status,
        cancelledAt,
        cancellingAt,
        completedAt,
        errorFileId,
        errors,
        expiredAt,
        expiresAt,
        failedAt,
        finalizingAt,
        inProgressAt,
        metadata,
        outputFileId,
        requestCounts,
        mutableMapOf(),
    )

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The time frame within which the batch should be processed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionWindow(): String = completionWindow.getRequired("completion_window")

    /**
     * The Unix timestamp (in seconds) for when the batch was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The OpenAI API endpoint used by the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endpoint(): String = endpoint.getRequired("endpoint")

    /**
     * The ID of the input file for the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputFileId(): String = inputFileId.getRequired("input_file_id")

    /**
     * The object type, which is always `batch`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("batch")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The current status of the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The Unix timestamp (in seconds) for when the batch was cancelled.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelledAt(): Optional<Long> = cancelledAt.getOptional("cancelled_at")

    /**
     * The Unix timestamp (in seconds) for when the batch started cancelling.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancellingAt(): Optional<Long> = cancellingAt.getOptional("cancelling_at")

    /**
     * The Unix timestamp (in seconds) for when the batch was completed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Long> = completedAt.getOptional("completed_at")

    /**
     * The ID of the file containing the outputs of requests with errors.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errorFileId(): Optional<String> = errorFileId.getOptional("error_file_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errors(): Optional<Errors> = errors.getOptional("errors")

    /**
     * The Unix timestamp (in seconds) for when the batch expired.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiredAt(): Optional<Long> = expiredAt.getOptional("expired_at")

    /**
     * The Unix timestamp (in seconds) for when the batch will expire.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAt(): Optional<Long> = expiresAt.getOptional("expires_at")

    /**
     * The Unix timestamp (in seconds) for when the batch failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun failedAt(): Optional<Long> = failedAt.getOptional("failed_at")

    /**
     * The Unix timestamp (in seconds) for when the batch started finalizing.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun finalizingAt(): Optional<Long> = finalizingAt.getOptional("finalizing_at")

    /**
     * The Unix timestamp (in seconds) for when the batch started processing.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inProgressAt(): Optional<Long> = inProgressAt.getOptional("in_progress_at")

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
     * The ID of the file containing the outputs of successfully executed requests.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputFileId(): Optional<String> = outputFileId.getOptional("output_file_id")

    /**
     * The request counts for different statuses within the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requestCounts(): Optional<BatchRequestCounts> = requestCounts.getOptional("request_counts")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [completionWindow].
     *
     * Unlike [completionWindow], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("completion_window")
    @ExcludeMissing
    fun _completionWindow(): JsonField<String> = completionWindow

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [endpoint].
     *
     * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

    /**
     * Returns the raw JSON value of [inputFileId].
     *
     * Unlike [inputFileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input_file_id")
    @ExcludeMissing
    fun _inputFileId(): JsonField<String> = inputFileId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [cancelledAt].
     *
     * Unlike [cancelledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancelled_at") @ExcludeMissing fun _cancelledAt(): JsonField<Long> = cancelledAt

    /**
     * Returns the raw JSON value of [cancellingAt].
     *
     * Unlike [cancellingAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancelling_at")
    @ExcludeMissing
    fun _cancellingAt(): JsonField<Long> = cancellingAt

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /**
     * Returns the raw JSON value of [errorFileId].
     *
     * Unlike [errorFileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_file_id")
    @ExcludeMissing
    fun _errorFileId(): JsonField<String> = errorFileId

    /**
     * Returns the raw JSON value of [errors].
     *
     * Unlike [errors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("errors") @ExcludeMissing fun _errors(): JsonField<Errors> = errors

    /**
     * Returns the raw JSON value of [expiredAt].
     *
     * Unlike [expiredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expired_at") @ExcludeMissing fun _expiredAt(): JsonField<Long> = expiredAt

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [failedAt].
     *
     * Unlike [failedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt(): JsonField<Long> = failedAt

    /**
     * Returns the raw JSON value of [finalizingAt].
     *
     * Unlike [finalizingAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("finalizing_at")
    @ExcludeMissing
    fun _finalizingAt(): JsonField<Long> = finalizingAt

    /**
     * Returns the raw JSON value of [inProgressAt].
     *
     * Unlike [inProgressAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("in_progress_at")
    @ExcludeMissing
    fun _inProgressAt(): JsonField<Long> = inProgressAt

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [outputFileId].
     *
     * Unlike [outputFileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_file_id")
    @ExcludeMissing
    fun _outputFileId(): JsonField<String> = outputFileId

    /**
     * Returns the raw JSON value of [requestCounts].
     *
     * Unlike [requestCounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_counts")
    @ExcludeMissing
    fun _requestCounts(): JsonField<BatchRequestCounts> = requestCounts

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
         * Returns a mutable builder for constructing an instance of [Batch].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .completionWindow()
         * .createdAt()
         * .endpoint()
         * .inputFileId()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Batch]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var completionWindow: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var endpoint: JsonField<String>? = null
        private var inputFileId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("batch")
        private var status: JsonField<Status>? = null
        private var cancelledAt: JsonField<Long> = JsonMissing.of()
        private var cancellingAt: JsonField<Long> = JsonMissing.of()
        private var completedAt: JsonField<Long> = JsonMissing.of()
        private var errorFileId: JsonField<String> = JsonMissing.of()
        private var errors: JsonField<Errors> = JsonMissing.of()
        private var expiredAt: JsonField<Long> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var failedAt: JsonField<Long> = JsonMissing.of()
        private var finalizingAt: JsonField<Long> = JsonMissing.of()
        private var inProgressAt: JsonField<Long> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var outputFileId: JsonField<String> = JsonMissing.of()
        private var requestCounts: JsonField<BatchRequestCounts> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batch: Batch) = apply {
            id = batch.id
            completionWindow = batch.completionWindow
            createdAt = batch.createdAt
            endpoint = batch.endpoint
            inputFileId = batch.inputFileId
            object_ = batch.object_
            status = batch.status
            cancelledAt = batch.cancelledAt
            cancellingAt = batch.cancellingAt
            completedAt = batch.completedAt
            errorFileId = batch.errorFileId
            errors = batch.errors
            expiredAt = batch.expiredAt
            expiresAt = batch.expiresAt
            failedAt = batch.failedAt
            finalizingAt = batch.finalizingAt
            inProgressAt = batch.inProgressAt
            metadata = batch.metadata
            outputFileId = batch.outputFileId
            requestCounts = batch.requestCounts
            additionalProperties = batch.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The time frame within which the batch should be processed. */
        fun completionWindow(completionWindow: String) =
            completionWindow(JsonField.of(completionWindow))

        /**
         * Sets [Builder.completionWindow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completionWindow] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun completionWindow(completionWindow: JsonField<String>) = apply {
            this.completionWindow = completionWindow
        }

        /** The Unix timestamp (in seconds) for when the batch was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The OpenAI API endpoint used by the batch. */
        fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

        /**
         * Sets [Builder.endpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpoint] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

        /** The ID of the input file for the batch. */
        fun inputFileId(inputFileId: String) = inputFileId(JsonField.of(inputFileId))

        /**
         * Sets [Builder.inputFileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputFileId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputFileId(inputFileId: JsonField<String>) = apply { this.inputFileId = inputFileId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("batch")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The current status of the batch. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The Unix timestamp (in seconds) for when the batch was cancelled. */
        fun cancelledAt(cancelledAt: Long) = cancelledAt(JsonField.of(cancelledAt))

        /**
         * Sets [Builder.cancelledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelledAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cancelledAt(cancelledAt: JsonField<Long>) = apply { this.cancelledAt = cancelledAt }

        /** The Unix timestamp (in seconds) for when the batch started cancelling. */
        fun cancellingAt(cancellingAt: Long) = cancellingAt(JsonField.of(cancellingAt))

        /**
         * Sets [Builder.cancellingAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancellingAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cancellingAt(cancellingAt: JsonField<Long>) = apply { this.cancellingAt = cancellingAt }

        /** The Unix timestamp (in seconds) for when the batch was completed. */
        fun completedAt(completedAt: Long) = completedAt(JsonField.of(completedAt))

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** The ID of the file containing the outputs of requests with errors. */
        fun errorFileId(errorFileId: String) = errorFileId(JsonField.of(errorFileId))

        /**
         * Sets [Builder.errorFileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorFileId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorFileId(errorFileId: JsonField<String>) = apply { this.errorFileId = errorFileId }

        fun errors(errors: Errors) = errors(JsonField.of(errors))

        /**
         * Sets [Builder.errors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errors] with a well-typed [Errors] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun errors(errors: JsonField<Errors>) = apply { this.errors = errors }

        /** The Unix timestamp (in seconds) for when the batch expired. */
        fun expiredAt(expiredAt: Long) = expiredAt(JsonField.of(expiredAt))

        /**
         * Sets [Builder.expiredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiredAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiredAt(expiredAt: JsonField<Long>) = apply { this.expiredAt = expiredAt }

        /** The Unix timestamp (in seconds) for when the batch will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the batch failed. */
        fun failedAt(failedAt: Long) = failedAt(JsonField.of(failedAt))

        /**
         * Sets [Builder.failedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun failedAt(failedAt: JsonField<Long>) = apply { this.failedAt = failedAt }

        /** The Unix timestamp (in seconds) for when the batch started finalizing. */
        fun finalizingAt(finalizingAt: Long) = finalizingAt(JsonField.of(finalizingAt))

        /**
         * Sets [Builder.finalizingAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.finalizingAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun finalizingAt(finalizingAt: JsonField<Long>) = apply { this.finalizingAt = finalizingAt }

        /** The Unix timestamp (in seconds) for when the batch started processing. */
        fun inProgressAt(inProgressAt: Long) = inProgressAt(JsonField.of(inProgressAt))

        /**
         * Sets [Builder.inProgressAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inProgressAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inProgressAt(inProgressAt: JsonField<Long>) = apply { this.inProgressAt = inProgressAt }

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

        /** The ID of the file containing the outputs of successfully executed requests. */
        fun outputFileId(outputFileId: String) = outputFileId(JsonField.of(outputFileId))

        /**
         * Sets [Builder.outputFileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputFileId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputFileId(outputFileId: JsonField<String>) = apply {
            this.outputFileId = outputFileId
        }

        /** The request counts for different statuses within the batch. */
        fun requestCounts(requestCounts: BatchRequestCounts) =
            requestCounts(JsonField.of(requestCounts))

        /**
         * Sets [Builder.requestCounts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestCounts] with a well-typed [BatchRequestCounts]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun requestCounts(requestCounts: JsonField<BatchRequestCounts>) = apply {
            this.requestCounts = requestCounts
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
         * Returns an immutable instance of [Batch].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .completionWindow()
         * .createdAt()
         * .endpoint()
         * .inputFileId()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Batch =
            Batch(
                checkRequired("id", id),
                checkRequired("completionWindow", completionWindow),
                checkRequired("createdAt", createdAt),
                checkRequired("endpoint", endpoint),
                checkRequired("inputFileId", inputFileId),
                object_,
                checkRequired("status", status),
                cancelledAt,
                cancellingAt,
                completedAt,
                errorFileId,
                errors,
                expiredAt,
                expiresAt,
                failedAt,
                finalizingAt,
                inProgressAt,
                metadata,
                outputFileId,
                requestCounts,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Batch = apply {
        if (validated) {
            return@apply
        }

        id()
        completionWindow()
        createdAt()
        endpoint()
        inputFileId()
        _object_().let {
            if (it != JsonValue.from("batch")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        status().validate()
        cancelledAt()
        cancellingAt()
        completedAt()
        errorFileId()
        errors().ifPresent { it.validate() }
        expiredAt()
        expiresAt()
        failedAt()
        finalizingAt()
        inProgressAt()
        metadata().ifPresent { it.validate() }
        outputFileId()
        requestCounts().ifPresent { it.validate() }
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
            (if (completionWindow.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (endpoint.asKnown().isPresent) 1 else 0) +
            (if (inputFileId.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("batch")) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (cancelledAt.asKnown().isPresent) 1 else 0) +
            (if (cancellingAt.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (errorFileId.asKnown().isPresent) 1 else 0) +
            (errors.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expiredAt.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (failedAt.asKnown().isPresent) 1 else 0) +
            (if (finalizingAt.asKnown().isPresent) 1 else 0) +
            (if (inProgressAt.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputFileId.asKnown().isPresent) 1 else 0) +
            (requestCounts.asKnown().getOrNull()?.validity() ?: 0)

    /** The current status of the batch. */
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

            @JvmField val VALIDATING = of("validating")

            @JvmField val FAILED = of("failed")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val FINALIZING = of("finalizing")

            @JvmField val COMPLETED = of("completed")

            @JvmField val EXPIRED = of("expired")

            @JvmField val CANCELLING = of("cancelling")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            VALIDATING,
            FAILED,
            IN_PROGRESS,
            FINALIZING,
            COMPLETED,
            EXPIRED,
            CANCELLING,
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
            VALIDATING,
            FAILED,
            IN_PROGRESS,
            FINALIZING,
            COMPLETED,
            EXPIRED,
            CANCELLING,
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
                VALIDATING -> Value.VALIDATING
                FAILED -> Value.FAILED
                IN_PROGRESS -> Value.IN_PROGRESS
                FINALIZING -> Value.FINALIZING
                COMPLETED -> Value.COMPLETED
                EXPIRED -> Value.EXPIRED
                CANCELLING -> Value.CANCELLING
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
                VALIDATING -> Known.VALIDATING
                FAILED -> Known.FAILED
                IN_PROGRESS -> Known.IN_PROGRESS
                FINALIZING -> Known.FINALIZING
                COMPLETED -> Known.COMPLETED
                EXPIRED -> Known.EXPIRED
                CANCELLING -> Known.CANCELLING
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Errors
    private constructor(
        private val data: JsonField<List<BatchError>>,
        private val object_: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<List<BatchError>> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        ) : this(data, object_, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<List<BatchError>> = data.getOptional("data")

        /**
         * The object type, which is always `list`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun object_(): Optional<String> = object_.getOptional("object")

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<BatchError>> = data

        /**
         * Returns the raw JSON value of [object_].
         *
         * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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

            /** Returns a mutable builder for constructing an instance of [Errors]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Errors]. */
        class Builder internal constructor() {

            private var data: JsonField<MutableList<BatchError>>? = null
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errors: Errors) = apply {
                data = errors.data.map { it.toMutableList() }
                object_ = errors.object_
                additionalProperties = errors.additionalProperties.toMutableMap()
            }

            fun data(data: List<BatchError>) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed `List<BatchError>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<List<BatchError>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            /**
             * Adds a single [BatchError] to [Builder.data].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addData(data: BatchError) = apply {
                this.data =
                    (this.data ?: JsonField.of(mutableListOf())).also {
                        checkKnown("data", it).add(data)
                    }
            }

            /** The object type, which is always `list`. */
            fun object_(object_: String) = object_(JsonField.of(object_))

            /**
             * Sets [Builder.object_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.object_] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

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
             * Returns an immutable instance of [Errors].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Errors =
                Errors(
                    (data ?: JsonMissing.of()).map { it.toImmutable() },
                    object_,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Errors = apply {
            if (validated) {
                return@apply
            }

            data().ifPresent { it.forEach { it.validate() } }
            object_()
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
            (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (object_.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Errors && data == other.data && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, object_, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Errors{data=$data, object_=$object_, additionalProperties=$additionalProperties}"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Batch && id == other.id && completionWindow == other.completionWindow && createdAt == other.createdAt && endpoint == other.endpoint && inputFileId == other.inputFileId && object_ == other.object_ && status == other.status && cancelledAt == other.cancelledAt && cancellingAt == other.cancellingAt && completedAt == other.completedAt && errorFileId == other.errorFileId && errors == other.errors && expiredAt == other.expiredAt && expiresAt == other.expiresAt && failedAt == other.failedAt && finalizingAt == other.finalizingAt && inProgressAt == other.inProgressAt && metadata == other.metadata && outputFileId == other.outputFileId && requestCounts == other.requestCounts && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, completionWindow, createdAt, endpoint, inputFileId, object_, status, cancelledAt, cancellingAt, completedAt, errorFileId, errors, expiredAt, expiresAt, failedAt, finalizingAt, inProgressAt, metadata, outputFileId, requestCounts, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Batch{id=$id, completionWindow=$completionWindow, createdAt=$createdAt, endpoint=$endpoint, inputFileId=$inputFileId, object_=$object_, status=$status, cancelledAt=$cancelledAt, cancellingAt=$cancellingAt, completedAt=$completedAt, errorFileId=$errorFileId, errors=$errors, expiredAt=$expiredAt, expiresAt=$expiresAt, failedAt=$failedAt, finalizingAt=$finalizingAt, inProgressAt=$inProgressAt, metadata=$metadata, outputFileId=$outputFileId, requestCounts=$requestCounts, additionalProperties=$additionalProperties}"
}
