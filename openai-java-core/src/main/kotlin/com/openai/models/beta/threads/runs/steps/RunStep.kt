// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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
import com.openai.models.Metadata
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a step in execution of a run. */
@NoAutoDetect
class RunStep
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("assistant_id")
    @ExcludeMissing
    private val assistantId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("cancelled_at")
    @ExcludeMissing
    private val cancelledAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("completed_at")
    @ExcludeMissing
    private val completedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("expired_at")
    @ExcludeMissing
    private val expiredAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("failed_at")
    @ExcludeMissing
    private val failedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("last_error")
    @ExcludeMissing
    private val lastError: JsonField<LastError> = JsonMissing.of(),
    @JsonProperty("metadata")
    @ExcludeMissing
    private val metadata: JsonField<Metadata> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("run_id") @ExcludeMissing private val runId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("step_details")
    @ExcludeMissing
    private val stepDetails: JsonField<StepDetails> = JsonMissing.of(),
    @JsonProperty("thread_id")
    @ExcludeMissing
    private val threadId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("usage") @ExcludeMissing private val usage: JsonField<Usage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The identifier of the run step, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants)
     * associated with the run step.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assistantId(): String = assistantId.getRequired("assistant_id")

    /**
     * The Unix timestamp (in seconds) for when the run step was cancelled.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelledAt(): Optional<Long> = Optional.ofNullable(cancelledAt.getNullable("cancelled_at"))

    /**
     * The Unix timestamp (in seconds) for when the run step completed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /**
     * The Unix timestamp (in seconds) for when the run step was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The Unix timestamp (in seconds) for when the run step expired. A step is considered expired
     * if the parent run is expired.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiredAt(): Optional<Long> = Optional.ofNullable(expiredAt.getNullable("expired_at"))

    /**
     * The Unix timestamp (in seconds) for when the run step failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun failedAt(): Optional<Long> = Optional.ofNullable(failedAt.getNullable("failed_at"))

    /**
     * The last error associated with this run step. Will be `null` if there are no errors.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastError(): Optional<LastError> = Optional.ofNullable(lastError.getNullable("last_error"))

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
    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

    /**
     * The object type, which is always `thread.run.step`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("thread.run.step")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) that this run step
     * is a part of.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun runId(): String = runId.getRequired("run_id")

    /**
     * The status of the run step, which can be either `in_progress`, `cancelled`, `failed`,
     * `completed`, or `expired`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The details of the run step.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stepDetails(): StepDetails = stepDetails.getRequired("step_details")

    /**
     * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun threadId(): String = threadId.getRequired("thread_id")

    /**
     * The type of run step, which can be either `message_creation` or `tool_calls`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Usage statistics related to the run step. This value will be `null` while the run step's
     * status is `in_progress`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<Usage> = Optional.ofNullable(usage.getNullable("usage"))

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [assistantId].
     *
     * Unlike [assistantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("assistant_id")
    @ExcludeMissing
    fun _assistantId(): JsonField<String> = assistantId

    /**
     * Returns the raw JSON value of [cancelledAt].
     *
     * Unlike [cancelledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancelled_at") @ExcludeMissing fun _cancelledAt(): JsonField<Long> = cancelledAt

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [expiredAt].
     *
     * Unlike [expiredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expired_at") @ExcludeMissing fun _expiredAt(): JsonField<Long> = expiredAt

    /**
     * Returns the raw JSON value of [failedAt].
     *
     * Unlike [failedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt(): JsonField<Long> = failedAt

    /**
     * Returns the raw JSON value of [lastError].
     *
     * Unlike [lastError], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_error") @ExcludeMissing fun _lastError(): JsonField<LastError> = lastError

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [runId].
     *
     * Unlike [runId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("run_id") @ExcludeMissing fun _runId(): JsonField<String> = runId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [stepDetails].
     *
     * Unlike [stepDetails], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("step_details")
    @ExcludeMissing
    fun _stepDetails(): JsonField<StepDetails> = stepDetails

    /**
     * Returns the raw JSON value of [threadId].
     *
     * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RunStep = apply {
        if (validated) {
            return@apply
        }

        id()
        assistantId()
        cancelledAt()
        completedAt()
        createdAt()
        expiredAt()
        failedAt()
        lastError().ifPresent { it.validate() }
        metadata().ifPresent { it.validate() }
        _object_().let {
            if (it != JsonValue.from("thread.run.step")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        runId()
        status()
        stepDetails().validate()
        threadId()
        type()
        usage().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunStep].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .assistantId()
         * .cancelledAt()
         * .completedAt()
         * .createdAt()
         * .expiredAt()
         * .failedAt()
         * .lastError()
         * .metadata()
         * .runId()
         * .status()
         * .stepDetails()
         * .threadId()
         * .type()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RunStep]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var assistantId: JsonField<String>? = null
        private var cancelledAt: JsonField<Long>? = null
        private var completedAt: JsonField<Long>? = null
        private var createdAt: JsonField<Long>? = null
        private var expiredAt: JsonField<Long>? = null
        private var failedAt: JsonField<Long>? = null
        private var lastError: JsonField<LastError>? = null
        private var metadata: JsonField<Metadata>? = null
        private var object_: JsonValue = JsonValue.from("thread.run.step")
        private var runId: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var stepDetails: JsonField<StepDetails>? = null
        private var threadId: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var usage: JsonField<Usage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runStep: RunStep) = apply {
            id = runStep.id
            assistantId = runStep.assistantId
            cancelledAt = runStep.cancelledAt
            completedAt = runStep.completedAt
            createdAt = runStep.createdAt
            expiredAt = runStep.expiredAt
            failedAt = runStep.failedAt
            lastError = runStep.lastError
            metadata = runStep.metadata
            object_ = runStep.object_
            runId = runStep.runId
            status = runStep.status
            stepDetails = runStep.stepDetails
            threadId = runStep.threadId
            type = runStep.type
            usage = runStep.usage
            additionalProperties = runStep.additionalProperties.toMutableMap()
        }

        /** The identifier of the run step, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants)
         * associated with the run step.
         */
        fun assistantId(assistantId: String) = assistantId(JsonField.of(assistantId))

        /**
         * Sets [Builder.assistantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assistantId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assistantId(assistantId: JsonField<String>) = apply { this.assistantId = assistantId }

        /** The Unix timestamp (in seconds) for when the run step was cancelled. */
        fun cancelledAt(cancelledAt: Long?) = cancelledAt(JsonField.ofNullable(cancelledAt))

        /**
         * Alias for [Builder.cancelledAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun cancelledAt(cancelledAt: Long) = cancelledAt(cancelledAt as Long?)

        /** Alias for calling [Builder.cancelledAt] with `cancelledAt.orElse(null)`. */
        fun cancelledAt(cancelledAt: Optional<Long>) = cancelledAt(cancelledAt.getOrNull())

        /**
         * Sets [Builder.cancelledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelledAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cancelledAt(cancelledAt: JsonField<Long>) = apply { this.cancelledAt = cancelledAt }

        /** The Unix timestamp (in seconds) for when the run step completed. */
        fun completedAt(completedAt: Long?) = completedAt(JsonField.ofNullable(completedAt))

        /**
         * Alias for [Builder.completedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun completedAt(completedAt: Long) = completedAt(completedAt as Long?)

        /** Alias for calling [Builder.completedAt] with `completedAt.orElse(null)`. */
        fun completedAt(completedAt: Optional<Long>) = completedAt(completedAt.getOrNull())

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** The Unix timestamp (in seconds) for when the run step was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * The Unix timestamp (in seconds) for when the run step expired. A step is considered
         * expired if the parent run is expired.
         */
        fun expiredAt(expiredAt: Long?) = expiredAt(JsonField.ofNullable(expiredAt))

        /**
         * Alias for [Builder.expiredAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun expiredAt(expiredAt: Long) = expiredAt(expiredAt as Long?)

        /** Alias for calling [Builder.expiredAt] with `expiredAt.orElse(null)`. */
        fun expiredAt(expiredAt: Optional<Long>) = expiredAt(expiredAt.getOrNull())

        /**
         * Sets [Builder.expiredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiredAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiredAt(expiredAt: JsonField<Long>) = apply { this.expiredAt = expiredAt }

        /** The Unix timestamp (in seconds) for when the run step failed. */
        fun failedAt(failedAt: Long?) = failedAt(JsonField.ofNullable(failedAt))

        /**
         * Alias for [Builder.failedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun failedAt(failedAt: Long) = failedAt(failedAt as Long?)

        /** Alias for calling [Builder.failedAt] with `failedAt.orElse(null)`. */
        fun failedAt(failedAt: Optional<Long>) = failedAt(failedAt.getOrNull())

        /**
         * Sets [Builder.failedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun failedAt(failedAt: JsonField<Long>) = apply { this.failedAt = failedAt }

        /** The last error associated with this run step. Will be `null` if there are no errors. */
        fun lastError(lastError: LastError?) = lastError(JsonField.ofNullable(lastError))

        /** Alias for calling [Builder.lastError] with `lastError.orElse(null)`. */
        fun lastError(lastError: Optional<LastError>) = lastError(lastError.getOrNull())

        /**
         * Sets [Builder.lastError] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastError] with a well-typed [LastError] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastError(lastError: JsonField<LastError>) = apply { this.lastError = lastError }

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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("thread.run.step")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) that this run
         * step is a part of.
         */
        fun runId(runId: String) = runId(JsonField.of(runId))

        /**
         * Sets [Builder.runId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.runId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun runId(runId: JsonField<String>) = apply { this.runId = runId }

        /**
         * The status of the run step, which can be either `in_progress`, `cancelled`, `failed`,
         * `completed`, or `expired`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The details of the run step. */
        fun stepDetails(stepDetails: StepDetails) = stepDetails(JsonField.of(stepDetails))

        /**
         * Sets [Builder.stepDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stepDetails] with a well-typed [StepDetails] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun stepDetails(stepDetails: JsonField<StepDetails>) = apply {
            this.stepDetails = stepDetails
        }

        /**
         * Alias for calling [stepDetails] with `StepDetails.ofMessageCreation(messageCreation)`.
         */
        fun stepDetails(messageCreation: MessageCreationStepDetails) =
            stepDetails(StepDetails.ofMessageCreation(messageCreation))

        /**
         * Alias for calling [stepDetails] with the following:
         * ```java
         * MessageCreationStepDetails.builder()
         *     .messageCreation(messageCreation)
         *     .build()
         * ```
         */
        fun messageCreationStepDetails(
            messageCreation: MessageCreationStepDetails.MessageCreation
        ) =
            stepDetails(
                MessageCreationStepDetails.builder().messageCreation(messageCreation).build()
            )

        /** Alias for calling [stepDetails] with `StepDetails.ofToolCalls(toolCalls)`. */
        fun stepDetails(toolCalls: ToolCallsStepDetails) =
            stepDetails(StepDetails.ofToolCalls(toolCalls))

        /**
         * Alias for calling [stepDetails] with the following:
         * ```java
         * ToolCallsStepDetails.builder()
         *     .toolCalls(toolCalls)
         *     .build()
         * ```
         */
        fun toolCallsStepDetails(toolCalls: List<ToolCall>) =
            stepDetails(ToolCallsStepDetails.builder().toolCalls(toolCalls).build())

        /**
         * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
         * run.
         */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * Sets [Builder.threadId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threadId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

        /** The type of run step, which can be either `message_creation` or `tool_calls`. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /**
         * Usage statistics related to the run step. This value will be `null` while the run step's
         * status is `in_progress`.
         */
        fun usage(usage: Usage?) = usage(JsonField.ofNullable(usage))

        /** Alias for calling [Builder.usage] with `usage.orElse(null)`. */
        fun usage(usage: Optional<Usage>) = usage(usage.getOrNull())

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [RunStep].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .assistantId()
         * .cancelledAt()
         * .completedAt()
         * .createdAt()
         * .expiredAt()
         * .failedAt()
         * .lastError()
         * .metadata()
         * .runId()
         * .status()
         * .stepDetails()
         * .threadId()
         * .type()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RunStep =
            RunStep(
                checkRequired("id", id),
                checkRequired("assistantId", assistantId),
                checkRequired("cancelledAt", cancelledAt),
                checkRequired("completedAt", completedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("expiredAt", expiredAt),
                checkRequired("failedAt", failedAt),
                checkRequired("lastError", lastError),
                checkRequired("metadata", metadata),
                object_,
                checkRequired("runId", runId),
                checkRequired("status", status),
                checkRequired("stepDetails", stepDetails),
                checkRequired("threadId", threadId),
                checkRequired("type", type),
                checkRequired("usage", usage),
                additionalProperties.toImmutable(),
            )
    }

    /** The last error associated with this run step. Will be `null` if there are no errors. */
    @NoAutoDetect
    class LastError
    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing private val code: JsonField<Code> = JsonMissing.of(),
        @JsonProperty("message")
        @ExcludeMissing
        private val message: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * One of `server_error` or `rate_limit_exceeded`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): Code = code.getRequired("code")

        /**
         * A human-readable description of the error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): LastError = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [LastError].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LastError]. */
        class Builder internal constructor() {

            private var code: JsonField<Code>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(lastError: LastError) = apply {
                code = lastError.code
                message = lastError.message
                additionalProperties = lastError.additionalProperties.toMutableMap()
            }

            /** One of `server_error` or `rate_limit_exceeded`. */
            fun code(code: Code) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [Code] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<Code>) = apply { this.code = code }

            /** A human-readable description of the error. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [LastError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LastError =
                LastError(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    additionalProperties.toImmutable(),
                )
        }

        /** One of `server_error` or `rate_limit_exceeded`. */
        class Code @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val SERVER_ERROR = of("server_error")

                @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

                @JvmStatic fun of(value: String) = Code(JsonField.of(value))
            }

            /** An enum containing [Code]'s known values. */
            enum class Known {
                SERVER_ERROR,
                RATE_LIMIT_EXCEEDED,
            }

            /**
             * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Code] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SERVER_ERROR,
                RATE_LIMIT_EXCEEDED,
                /** An enum member indicating that [Code] was instantiated with an unknown value. */
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
                    SERVER_ERROR -> Value.SERVER_ERROR
                    RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
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
                    SERVER_ERROR -> Known.SERVER_ERROR
                    RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                    else -> throw OpenAIInvalidDataException("Unknown Code: $value")
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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Code && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is LastError && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LastError{code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the run step, which can be either `in_progress`, `cancelled`, `failed`,
     * `completed`, or `expired`.
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val FAILED = of("failed")

            @JvmField val COMPLETED = of("completed")

            @JvmField val EXPIRED = of("expired")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            CANCELLED,
            FAILED,
            COMPLETED,
            EXPIRED,
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
            IN_PROGRESS,
            CANCELLED,
            FAILED,
            COMPLETED,
            EXPIRED,
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
                IN_PROGRESS -> Value.IN_PROGRESS
                CANCELLED -> Value.CANCELLED
                FAILED -> Value.FAILED
                COMPLETED -> Value.COMPLETED
                EXPIRED -> Value.EXPIRED
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
                IN_PROGRESS -> Known.IN_PROGRESS
                CANCELLED -> Known.CANCELLED
                FAILED -> Known.FAILED
                COMPLETED -> Known.COMPLETED
                EXPIRED -> Known.EXPIRED
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The details of the run step. */
    @JsonDeserialize(using = StepDetails.Deserializer::class)
    @JsonSerialize(using = StepDetails.Serializer::class)
    class StepDetails
    private constructor(
        private val messageCreation: MessageCreationStepDetails? = null,
        private val toolCalls: ToolCallsStepDetails? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Details of the message creation by the run step. */
        fun messageCreation(): Optional<MessageCreationStepDetails> =
            Optional.ofNullable(messageCreation)

        /** Details of the tool call. */
        fun toolCalls(): Optional<ToolCallsStepDetails> = Optional.ofNullable(toolCalls)

        fun isMessageCreation(): Boolean = messageCreation != null

        fun isToolCalls(): Boolean = toolCalls != null

        /** Details of the message creation by the run step. */
        fun asMessageCreation(): MessageCreationStepDetails =
            messageCreation.getOrThrow("messageCreation")

        /** Details of the tool call. */
        fun asToolCalls(): ToolCallsStepDetails = toolCalls.getOrThrow("toolCalls")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                messageCreation != null -> visitor.visitMessageCreation(messageCreation)
                toolCalls != null -> visitor.visitToolCalls(toolCalls)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): StepDetails = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessageCreation(messageCreation: MessageCreationStepDetails) {
                        messageCreation.validate()
                    }

                    override fun visitToolCalls(toolCalls: ToolCallsStepDetails) {
                        toolCalls.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StepDetails && messageCreation == other.messageCreation && toolCalls == other.toolCalls /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageCreation, toolCalls) /* spotless:on */

        override fun toString(): String =
            when {
                messageCreation != null -> "StepDetails{messageCreation=$messageCreation}"
                toolCalls != null -> "StepDetails{toolCalls=$toolCalls}"
                _json != null -> "StepDetails{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid StepDetails")
            }

        companion object {

            /** Details of the message creation by the run step. */
            @JvmStatic
            fun ofMessageCreation(messageCreation: MessageCreationStepDetails) =
                StepDetails(messageCreation = messageCreation)

            /** Details of the tool call. */
            @JvmStatic
            fun ofToolCalls(toolCalls: ToolCallsStepDetails) = StepDetails(toolCalls = toolCalls)
        }

        /**
         * An interface that defines how to map each variant of [StepDetails] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** Details of the message creation by the run step. */
            fun visitMessageCreation(messageCreation: MessageCreationStepDetails): T

            /** Details of the tool call. */
            fun visitToolCalls(toolCalls: ToolCallsStepDetails): T

            /**
             * Maps an unknown variant of [StepDetails] to a value of type [T].
             *
             * An instance of [StepDetails] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown StepDetails: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<StepDetails>(StepDetails::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): StepDetails {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "message_creation" -> {
                        tryDeserialize(node, jacksonTypeRef<MessageCreationStepDetails>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(messageCreation = it, _json = json)
                            }
                    }
                    "tool_calls" -> {
                        tryDeserialize(node, jacksonTypeRef<ToolCallsStepDetails>()) {
                                it.validate()
                            }
                            ?.let {
                                return StepDetails(toolCalls = it, _json = json)
                            }
                    }
                }

                return StepDetails(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<StepDetails>(StepDetails::class) {

            override fun serialize(
                value: StepDetails,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.messageCreation != null -> generator.writeObject(value.messageCreation)
                    value.toolCalls != null -> generator.writeObject(value.toolCalls)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid StepDetails")
                }
            }
        }
    }

    /** The type of run step, which can be either `message_creation` or `tool_calls`. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MESSAGE_CREATION = of("message_creation")

            @JvmField val TOOL_CALLS = of("tool_calls")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            MESSAGE_CREATION,
            TOOL_CALLS,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MESSAGE_CREATION,
            TOOL_CALLS,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                MESSAGE_CREATION -> Value.MESSAGE_CREATION
                TOOL_CALLS -> Value.TOOL_CALLS
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
                MESSAGE_CREATION -> Known.MESSAGE_CREATION
                TOOL_CALLS -> Known.TOOL_CALLS
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Usage statistics related to the run step. This value will be `null` while the run step's
     * status is `in_progress`.
     */
    @NoAutoDetect
    class Usage
    @JsonCreator
    private constructor(
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        private val completionTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        private val promptTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total_tokens")
        @ExcludeMissing
        private val totalTokens: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Number of completion tokens used over the course of the run step.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        /**
         * Number of prompt tokens used over the course of the run step.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /**
         * Total number of tokens used (prompt + completion).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            completionTokens()
            promptTokens()
            totalTokens()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Usage].
             *
             * The following fields are required:
             * ```java
             * .completionTokens()
             * .promptTokens()
             * .totalTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Usage]. */
        class Builder internal constructor() {

            private var completionTokens: JsonField<Long>? = null
            private var promptTokens: JsonField<Long>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                completionTokens = usage.completionTokens
                promptTokens = usage.promptTokens
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** Number of completion tokens used over the course of the run step. */
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

            /** Number of prompt tokens used over the course of the run step. */
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

            /** Total number of tokens used (prompt + completion). */
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
             * Returns an immutable instance of [Usage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .completionTokens()
             * .promptTokens()
             * .totalTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Usage =
                Usage(
                    checkRequired("completionTokens", completionTokens),
                    checkRequired("promptTokens", promptTokens),
                    checkRequired("totalTokens", totalTokens),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Usage && completionTokens == other.completionTokens && promptTokens == other.promptTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(completionTokens, promptTokens, totalTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{completionTokens=$completionTokens, promptTokens=$promptTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStep && id == other.id && assistantId == other.assistantId && cancelledAt == other.cancelledAt && completedAt == other.completedAt && createdAt == other.createdAt && expiredAt == other.expiredAt && failedAt == other.failedAt && lastError == other.lastError && metadata == other.metadata && object_ == other.object_ && runId == other.runId && status == other.status && stepDetails == other.stepDetails && threadId == other.threadId && type == other.type && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, assistantId, cancelledAt, completedAt, createdAt, expiredAt, failedAt, lastError, metadata, object_, runId, status, stepDetails, threadId, type, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunStep{id=$id, assistantId=$assistantId, cancelledAt=$cancelledAt, completedAt=$completedAt, createdAt=$createdAt, expiredAt=$expiredAt, failedAt=$failedAt, lastError=$lastError, metadata=$metadata, object_=$object_, runId=$runId, status=$status, stepDetails=$stepDetails, threadId=$threadId, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
}
