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
 * Represents an execution run on a
 * [thread](https://platform.openai.com/docs/api-reference/threads).
 */
@NoAutoDetect
class Run
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("thread_id")
    @ExcludeMissing
    private val threadId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("assistant_id")
    @ExcludeMissing
    private val assistantId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<RunStatus> = JsonMissing.of(),
    @JsonProperty("required_action")
    @ExcludeMissing
    private val requiredAction: JsonField<RequiredAction> = JsonMissing.of(),
    @JsonProperty("last_error")
    @ExcludeMissing
    private val lastError: JsonField<LastError> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("started_at")
    @ExcludeMissing
    private val startedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("cancelled_at")
    @ExcludeMissing
    private val cancelledAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("failed_at")
    @ExcludeMissing
    private val failedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("completed_at")
    @ExcludeMissing
    private val completedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    private val incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("instructions")
    @ExcludeMissing
    private val instructions: JsonField<String> = JsonMissing.of(),
    @JsonProperty("tools")
    @ExcludeMissing
    private val tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
    @JsonProperty("metadata") @ExcludeMissing private val metadata: JsonValue = JsonMissing.of(),
    @JsonProperty("usage") @ExcludeMissing private val usage: JsonField<Usage> = JsonMissing.of(),
    @JsonProperty("temperature")
    @ExcludeMissing
    private val temperature: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("top_p") @ExcludeMissing private val topP: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("max_prompt_tokens")
    @ExcludeMissing
    private val maxPromptTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("max_completion_tokens")
    @ExcludeMissing
    private val maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("truncation_strategy")
    @ExcludeMissing
    private val truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of(),
    @JsonProperty("tool_choice")
    @ExcludeMissing
    private val toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of(),
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    private val parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("response_format")
    @ExcludeMissing
    private val responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The object type, which is always `thread.run`. */
    fun object_(): Object = object_.getRequired("object")

    /** The Unix timestamp (in seconds) for when the run was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
     * executed on as a part of this run.
     */
    fun threadId(): String = threadId.getRequired("thread_id")

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used for
     * execution of this run.
     */
    fun assistantId(): String = assistantId.getRequired("assistant_id")

    /**
     * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
     * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
     */
    fun status(): RunStatus = status.getRequired("status")

    /**
     * Details on the action required to continue the run. Will be `null` if no action is required.
     */
    fun requiredAction(): Optional<RequiredAction> =
        Optional.ofNullable(requiredAction.getNullable("required_action"))

    /** The last error associated with this run. Will be `null` if there are no errors. */
    fun lastError(): Optional<LastError> = Optional.ofNullable(lastError.getNullable("last_error"))

    /** The Unix timestamp (in seconds) for when the run will expire. */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /** The Unix timestamp (in seconds) for when the run was started. */
    fun startedAt(): Optional<Long> = Optional.ofNullable(startedAt.getNullable("started_at"))

    /** The Unix timestamp (in seconds) for when the run was cancelled. */
    fun cancelledAt(): Optional<Long> = Optional.ofNullable(cancelledAt.getNullable("cancelled_at"))

    /** The Unix timestamp (in seconds) for when the run failed. */
    fun failedAt(): Optional<Long> = Optional.ofNullable(failedAt.getNullable("failed_at"))

    /** The Unix timestamp (in seconds) for when the run was completed. */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
    fun incompleteDetails(): Optional<IncompleteDetails> =
        Optional.ofNullable(incompleteDetails.getNullable("incomplete_details"))

    /**
     * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
     * used for this run.
     */
    fun model(): String = model.getRequired("model")

    /**
     * The instructions that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     */
    fun instructions(): String = instructions.getRequired("instructions")

    /**
     * The list of tools that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     */
    fun tools(): List<AssistantTool> = tools.getRequired("tools")

    /**
     * Usage statistics related to the run. This value will be `null` if the run is not in a
     * terminal state (i.e. `in_progress`, `queued`, etc.).
     */
    fun usage(): Optional<Usage> = Optional.ofNullable(usage.getNullable("usage"))

    /** The sampling temperature used for this run. If not set, defaults to 1. */
    fun temperature(): Optional<Double> =
        Optional.ofNullable(temperature.getNullable("temperature"))

    /** The nucleus sampling value used for this run. If not set, defaults to 1. */
    fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

    /**
     * The maximum number of prompt tokens specified to have been used over the course of the run.
     */
    fun maxPromptTokens(): Optional<Long> =
        Optional.ofNullable(maxPromptTokens.getNullable("max_prompt_tokens"))

    /**
     * The maximum number of completion tokens specified to have been used over the course of the
     * run.
     */
    fun maxCompletionTokens(): Optional<Long> =
        Optional.ofNullable(maxCompletionTokens.getNullable("max_completion_tokens"))

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    fun truncationStrategy(): Optional<TruncationStrategy> =
        Optional.ofNullable(truncationStrategy.getNullable("truncation_strategy"))

    /**
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tools and instead generates a message. `auto` is the default value and means the model can
     * pick between generating a message or calling one or more tools. `required` means the model
     * must call one or more tools before responding to the user. Specifying a particular tool like
     * `{"type": "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     */
    fun toolChoice(): Optional<AssistantToolChoiceOption> =
        Optional.ofNullable(toolChoice.getNullable("tool_choice"))

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     */
    fun parallelToolCalls(): Boolean = parallelToolCalls.getRequired("parallel_tool_calls")

    /**
     * Specifies the format that the model must output. Compatible with
     * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
     * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5 Turbo
     * models since `gpt-3.5-turbo-1106`.
     *
     * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
     * ensures the model will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the model
     * generates is valid JSON.
     *
     * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
     * yourself via a system or user message. Without this, the model may generate an unending
     * stream of whitespace until the generation reaches the token limit, resulting in a
     * long-running and seemingly "stuck" request. Also note that the message content may be
     * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
     * `max_tokens` or the conversation exceeded the max context length.
     */
    fun responseFormat(): Optional<AssistantResponseFormatOption> =
        Optional.ofNullable(responseFormat.getNullable("response_format"))

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The object type, which is always `thread.run`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The Unix timestamp (in seconds) for when the run was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /**
     * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
     * executed on as a part of this run.
     */
    @JsonProperty("thread_id") @ExcludeMissing fun _threadId() = threadId

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used for
     * execution of this run.
     */
    @JsonProperty("assistant_id") @ExcludeMissing fun _assistantId() = assistantId

    /**
     * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
     * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * Details on the action required to continue the run. Will be `null` if no action is required.
     */
    @JsonProperty("required_action") @ExcludeMissing fun _requiredAction() = requiredAction

    /** The last error associated with this run. Will be `null` if there are no errors. */
    @JsonProperty("last_error") @ExcludeMissing fun _lastError() = lastError

    /** The Unix timestamp (in seconds) for when the run will expire. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The Unix timestamp (in seconds) for when the run was started. */
    @JsonProperty("started_at") @ExcludeMissing fun _startedAt() = startedAt

    /** The Unix timestamp (in seconds) for when the run was cancelled. */
    @JsonProperty("cancelled_at") @ExcludeMissing fun _cancelledAt() = cancelledAt

    /** The Unix timestamp (in seconds) for when the run failed. */
    @JsonProperty("failed_at") @ExcludeMissing fun _failedAt() = failedAt

    /** The Unix timestamp (in seconds) for when the run was completed. */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt() = completedAt

    /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
    @JsonProperty("incomplete_details") @ExcludeMissing fun _incompleteDetails() = incompleteDetails

    /**
     * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
     * used for this run.
     */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * The instructions that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     */
    @JsonProperty("instructions") @ExcludeMissing fun _instructions() = instructions

    /**
     * The list of tools that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools() = tools

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    /**
     * Usage statistics related to the run. This value will be `null` if the run is not in a
     * terminal state (i.e. `in_progress`, `queued`, etc.).
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    /** The sampling temperature used for this run. If not set, defaults to 1. */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature() = temperature

    /** The nucleus sampling value used for this run. If not set, defaults to 1. */
    @JsonProperty("top_p") @ExcludeMissing fun _topP() = topP

    /**
     * The maximum number of prompt tokens specified to have been used over the course of the run.
     */
    @JsonProperty("max_prompt_tokens") @ExcludeMissing fun _maxPromptTokens() = maxPromptTokens

    /**
     * The maximum number of completion tokens specified to have been used over the course of the
     * run.
     */
    @JsonProperty("max_completion_tokens")
    @ExcludeMissing
    fun _maxCompletionTokens() = maxCompletionTokens

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    @JsonProperty("truncation_strategy")
    @ExcludeMissing
    fun _truncationStrategy() = truncationStrategy

    /**
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tools and instead generates a message. `auto` is the default value and means the model can
     * pick between generating a message or calling one or more tools. `required` means the model
     * must call one or more tools before responding to the user. Specifying a particular tool like
     * `{"type": "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     */
    @JsonProperty("tool_choice") @ExcludeMissing fun _toolChoice() = toolChoice

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     */
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    fun _parallelToolCalls() = parallelToolCalls

    /**
     * Specifies the format that the model must output. Compatible with
     * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
     * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5 Turbo
     * models since `gpt-3.5-turbo-1106`.
     *
     * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
     * ensures the model will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the model
     * generates is valid JSON.
     *
     * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
     * yourself via a system or user message. Without this, the model may generate an unending
     * stream of whitespace until the generation reaches the token limit, resulting in a
     * long-running and seemingly "stuck" request. Also note that the message content may be
     * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
     * `max_tokens` or the conversation exceeded the max context length.
     */
    @JsonProperty("response_format") @ExcludeMissing fun _responseFormat() = responseFormat

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Run = apply {
        if (!validated) {
            id()
            object_()
            createdAt()
            threadId()
            assistantId()
            status()
            requiredAction().map { it.validate() }
            lastError().map { it.validate() }
            expiresAt()
            startedAt()
            cancelledAt()
            failedAt()
            completedAt()
            incompleteDetails().map { it.validate() }
            model()
            instructions()
            tools()
            usage().map { it.validate() }
            temperature()
            topP()
            maxPromptTokens()
            maxCompletionTokens()
            truncationStrategy().map { it.validate() }
            toolChoice()
            parallelToolCalls()
            responseFormat()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var threadId: JsonField<String> = JsonMissing.of()
        private var assistantId: JsonField<String> = JsonMissing.of()
        private var status: JsonField<RunStatus> = JsonMissing.of()
        private var requiredAction: JsonField<RequiredAction> = JsonMissing.of()
        private var lastError: JsonField<LastError> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var startedAt: JsonField<Long> = JsonMissing.of()
        private var cancelledAt: JsonField<Long> = JsonMissing.of()
        private var failedAt: JsonField<Long> = JsonMissing.of()
        private var completedAt: JsonField<Long> = JsonMissing.of()
        private var incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var instructions: JsonField<String> = JsonMissing.of()
        private var tools: JsonField<List<AssistantTool>> = JsonMissing.of()
        private var metadata: JsonValue = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var topP: JsonField<Double> = JsonMissing.of()
        private var maxPromptTokens: JsonField<Long> = JsonMissing.of()
        private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
        private var truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of()
        private var toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of()
        private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
        private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(run: Run) = apply {
            id = run.id
            object_ = run.object_
            createdAt = run.createdAt
            threadId = run.threadId
            assistantId = run.assistantId
            status = run.status
            requiredAction = run.requiredAction
            lastError = run.lastError
            expiresAt = run.expiresAt
            startedAt = run.startedAt
            cancelledAt = run.cancelledAt
            failedAt = run.failedAt
            completedAt = run.completedAt
            incompleteDetails = run.incompleteDetails
            model = run.model
            instructions = run.instructions
            tools = run.tools
            metadata = run.metadata
            usage = run.usage
            temperature = run.temperature
            topP = run.topP
            maxPromptTokens = run.maxPromptTokens
            maxCompletionTokens = run.maxCompletionTokens
            truncationStrategy = run.truncationStrategy
            toolChoice = run.toolChoice
            parallelToolCalls = run.parallelToolCalls
            responseFormat = run.responseFormat
            additionalProperties = run.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The object type, which is always `thread.run`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `thread.run`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The Unix timestamp (in seconds) for when the run was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the run was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
         * executed on as a part of this run.
         */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
         * executed on as a part of this run.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used
         * for execution of this run.
         */
        fun assistantId(assistantId: String) = assistantId(JsonField.of(assistantId))

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used
         * for execution of this run.
         */
        fun assistantId(assistantId: JsonField<String>) = apply { this.assistantId = assistantId }

        /**
         * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
         * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
         */
        fun status(status: RunStatus) = status(JsonField.of(status))

        /**
         * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
         * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
         */
        fun status(status: JsonField<RunStatus>) = apply { this.status = status }

        /**
         * Details on the action required to continue the run. Will be `null` if no action is
         * required.
         */
        fun requiredAction(requiredAction: RequiredAction) =
            requiredAction(JsonField.of(requiredAction))

        /**
         * Details on the action required to continue the run. Will be `null` if no action is
         * required.
         */
        fun requiredAction(requiredAction: JsonField<RequiredAction>) = apply {
            this.requiredAction = requiredAction
        }

        /** The last error associated with this run. Will be `null` if there are no errors. */
        fun lastError(lastError: LastError) = lastError(JsonField.of(lastError))

        /** The last error associated with this run. Will be `null` if there are no errors. */
        fun lastError(lastError: JsonField<LastError>) = apply { this.lastError = lastError }

        /** The Unix timestamp (in seconds) for when the run will expire. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the run will expire. */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the run was started. */
        fun startedAt(startedAt: Long) = startedAt(JsonField.of(startedAt))

        /** The Unix timestamp (in seconds) for when the run was started. */
        fun startedAt(startedAt: JsonField<Long>) = apply { this.startedAt = startedAt }

        /** The Unix timestamp (in seconds) for when the run was cancelled. */
        fun cancelledAt(cancelledAt: Long) = cancelledAt(JsonField.of(cancelledAt))

        /** The Unix timestamp (in seconds) for when the run was cancelled. */
        fun cancelledAt(cancelledAt: JsonField<Long>) = apply { this.cancelledAt = cancelledAt }

        /** The Unix timestamp (in seconds) for when the run failed. */
        fun failedAt(failedAt: Long) = failedAt(JsonField.of(failedAt))

        /** The Unix timestamp (in seconds) for when the run failed. */
        fun failedAt(failedAt: JsonField<Long>) = apply { this.failedAt = failedAt }

        /** The Unix timestamp (in seconds) for when the run was completed. */
        fun completedAt(completedAt: Long) = completedAt(JsonField.of(completedAt))

        /** The Unix timestamp (in seconds) for when the run was completed. */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
        fun incompleteDetails(incompleteDetails: IncompleteDetails) =
            incompleteDetails(JsonField.of(incompleteDetails))

        /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
        fun incompleteDetails(incompleteDetails: JsonField<IncompleteDetails>) = apply {
            this.incompleteDetails = incompleteDetails
        }

        /**
         * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
         * used for this run.
         */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
         * used for this run.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The instructions that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun instructions(instructions: String) = instructions(JsonField.of(instructions))

        /**
         * The instructions that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
        }

        /**
         * The list of tools that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun tools(tools: List<AssistantTool>) = tools(JsonField.of(tools))

        /**
         * The list of tools that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply { this.tools = tools }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

        /**
         * Usage statistics related to the run. This value will be `null` if the run is not in a
         * terminal state (i.e. `in_progress`, `queued`, etc.).
         */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Usage statistics related to the run. This value will be `null` if the run is not in a
         * terminal state (i.e. `in_progress`, `queued`, etc.).
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        /** The sampling temperature used for this run. If not set, defaults to 1. */
        fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

        /** The sampling temperature used for this run. If not set, defaults to 1. */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /** The nucleus sampling value used for this run. If not set, defaults to 1. */
        fun topP(topP: Double) = topP(JsonField.of(topP))

        /** The nucleus sampling value used for this run. If not set, defaults to 1. */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

        /**
         * The maximum number of prompt tokens specified to have been used over the course of the
         * run.
         */
        fun maxPromptTokens(maxPromptTokens: Long) = maxPromptTokens(JsonField.of(maxPromptTokens))

        /**
         * The maximum number of prompt tokens specified to have been used over the course of the
         * run.
         */
        fun maxPromptTokens(maxPromptTokens: JsonField<Long>) = apply {
            this.maxPromptTokens = maxPromptTokens
        }

        /**
         * The maximum number of completion tokens specified to have been used over the course of
         * the run.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long) =
            maxCompletionTokens(JsonField.of(maxCompletionTokens))

        /**
         * The maximum number of completion tokens specified to have been used over the course of
         * the run.
         */
        fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
            this.maxCompletionTokens = maxCompletionTokens
        }

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: TruncationStrategy) =
            truncationStrategy(JsonField.of(truncationStrategy))

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: JsonField<TruncationStrategy>) = apply {
            this.truncationStrategy = truncationStrategy
        }

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: AssistantToolChoiceOption) = toolChoice(JsonField.of(toolChoice))

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: JsonField<AssistantToolChoiceOption>) = apply {
            this.toolChoice = toolChoice
        }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(JsonField.of(parallelToolCalls))

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            this.parallelToolCalls = parallelToolCalls
        }

        /**
         * Specifies the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
         * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5
         * Turbo models since `gpt-3.5-turbo-1106`.
         *
         * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs
         * which ensures the model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the
         * model generates is valid JSON.
         *
         * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
         * yourself via a system or user message. Without this, the model may generate an unending
         * stream of whitespace until the generation reaches the token limit, resulting in a
         * long-running and seemingly "stuck" request. Also note that the message content may be
         * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
         * `max_tokens` or the conversation exceeded the max context length.
         */
        fun responseFormat(responseFormat: AssistantResponseFormatOption) =
            responseFormat(JsonField.of(responseFormat))

        /**
         * Specifies the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
         * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5
         * Turbo models since `gpt-3.5-turbo-1106`.
         *
         * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs
         * which ensures the model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the
         * model generates is valid JSON.
         *
         * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
         * yourself via a system or user message. Without this, the model may generate an unending
         * stream of whitespace until the generation reaches the token limit, resulting in a
         * long-running and seemingly "stuck" request. Also note that the message content may be
         * partially cut off if `finish_reason="length"`, which indicates the generation exceeded
         * `max_tokens` or the conversation exceeded the max context length.
         */
        fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
            this.responseFormat = responseFormat
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

        fun build(): Run =
            Run(
                id,
                object_,
                createdAt,
                threadId,
                assistantId,
                status,
                requiredAction,
                lastError,
                expiresAt,
                startedAt,
                cancelledAt,
                failedAt,
                completedAt,
                incompleteDetails,
                model,
                instructions,
                tools.map { it.toImmutable() },
                metadata,
                usage,
                temperature,
                topP,
                maxPromptTokens,
                maxCompletionTokens,
                truncationStrategy,
                toolChoice,
                parallelToolCalls,
                responseFormat,
                additionalProperties.toImmutable(),
            )
    }

    /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
    @NoAutoDetect
    class IncompleteDetails
    @JsonCreator
    private constructor(
        @JsonProperty("reason")
        @ExcludeMissing
        private val reason: JsonField<Reason> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The reason why the run is incomplete. This will point to which specific token limit was
         * reached over the course of the run.
         */
        fun reason(): Optional<Reason> = Optional.ofNullable(reason.getNullable("reason"))

        /**
         * The reason why the run is incomplete. This will point to which specific token limit was
         * reached over the course of the run.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason() = reason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): IncompleteDetails = apply {
            if (!validated) {
                reason()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var reason: JsonField<Reason> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(incompleteDetails: IncompleteDetails) = apply {
                reason = incompleteDetails.reason
                additionalProperties = incompleteDetails.additionalProperties.toMutableMap()
            }

            /**
             * The reason why the run is incomplete. This will point to which specific token limit
             * was reached over the course of the run.
             */
            fun reason(reason: Reason) = reason(JsonField.of(reason))

            /**
             * The reason why the run is incomplete. This will point to which specific token limit
             * was reached over the course of the run.
             */
            fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

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

            fun build(): IncompleteDetails =
                IncompleteDetails(reason, additionalProperties.toImmutable())
        }

        class Reason
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val MAX_COMPLETION_TOKENS = of("max_completion_tokens")

                @JvmField val MAX_PROMPT_TOKENS = of("max_prompt_tokens")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            enum class Known {
                MAX_COMPLETION_TOKENS,
                MAX_PROMPT_TOKENS,
            }

            enum class Value {
                MAX_COMPLETION_TOKENS,
                MAX_PROMPT_TOKENS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    MAX_COMPLETION_TOKENS -> Value.MAX_COMPLETION_TOKENS
                    MAX_PROMPT_TOKENS -> Value.MAX_PROMPT_TOKENS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    MAX_COMPLETION_TOKENS -> Known.MAX_COMPLETION_TOKENS
                    MAX_PROMPT_TOKENS -> Known.MAX_PROMPT_TOKENS
                    else -> throw OpenAIInvalidDataException("Unknown Reason: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Reason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IncompleteDetails && reason == other.reason && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(reason, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IncompleteDetails{reason=$reason, additionalProperties=$additionalProperties}"
    }

    /** The last error associated with this run. Will be `null` if there are no errors. */
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

        /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
        fun code(): Code = code.getRequired("code")

        /** A human-readable description of the error. */
        fun message(): String = message.getRequired("message")

        /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
        @JsonProperty("code") @ExcludeMissing fun _code() = code

        /** A human-readable description of the error. */
        @JsonProperty("message") @ExcludeMissing fun _message() = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): LastError = apply {
            if (!validated) {
                code()
                message()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var code: JsonField<Code> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(lastError: LastError) = apply {
                code = lastError.code
                message = lastError.message
                additionalProperties = lastError.additionalProperties.toMutableMap()
            }

            /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
            fun code(code: Code) = code(JsonField.of(code))

            /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
            fun code(code: JsonField<Code>) = apply { this.code = code }

            /** A human-readable description of the error. */
            fun message(message: String) = message(JsonField.of(message))

            /** A human-readable description of the error. */
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

            fun build(): LastError =
                LastError(
                    code,
                    message,
                    additionalProperties.toImmutable(),
                )
        }

        class Code
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SERVER_ERROR = of("server_error")

                @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

                @JvmField val INVALID_PROMPT = of("invalid_prompt")

                @JvmStatic fun of(value: String) = Code(JsonField.of(value))
            }

            enum class Known {
                SERVER_ERROR,
                RATE_LIMIT_EXCEEDED,
                INVALID_PROMPT,
            }

            enum class Value {
                SERVER_ERROR,
                RATE_LIMIT_EXCEEDED,
                INVALID_PROMPT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SERVER_ERROR -> Value.SERVER_ERROR
                    RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
                    INVALID_PROMPT -> Value.INVALID_PROMPT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SERVER_ERROR -> Known.SERVER_ERROR
                    RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                    INVALID_PROMPT -> Known.INVALID_PROMPT
                    else -> throw OpenAIInvalidDataException("Unknown Code: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

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

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val THREAD_RUN = of("thread.run")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            THREAD_RUN,
        }

        enum class Value {
            THREAD_RUN,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                THREAD_RUN -> Value.THREAD_RUN
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                THREAD_RUN -> Known.THREAD_RUN
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

    /**
     * Details on the action required to continue the run. Will be `null` if no action is required.
     */
    @NoAutoDetect
    class RequiredAction
    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("submit_tool_outputs")
        @ExcludeMissing
        private val submitToolOutputs: JsonField<SubmitToolOutputs> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** For now, this is always `submit_tool_outputs`. */
        fun type(): Type = type.getRequired("type")

        /** Details on the tool outputs needed for this run to continue. */
        fun submitToolOutputs(): SubmitToolOutputs =
            submitToolOutputs.getRequired("submit_tool_outputs")

        /** For now, this is always `submit_tool_outputs`. */
        @JsonProperty("type") @ExcludeMissing fun _type() = type

        /** Details on the tool outputs needed for this run to continue. */
        @JsonProperty("submit_tool_outputs")
        @ExcludeMissing
        fun _submitToolOutputs() = submitToolOutputs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): RequiredAction = apply {
            if (!validated) {
                type()
                submitToolOutputs().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var type: JsonField<Type> = JsonMissing.of()
            private var submitToolOutputs: JsonField<SubmitToolOutputs> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(requiredAction: RequiredAction) = apply {
                type = requiredAction.type
                submitToolOutputs = requiredAction.submitToolOutputs
                additionalProperties = requiredAction.additionalProperties.toMutableMap()
            }

            /** For now, this is always `submit_tool_outputs`. */
            fun type(type: Type) = type(JsonField.of(type))

            /** For now, this is always `submit_tool_outputs`. */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /** Details on the tool outputs needed for this run to continue. */
            fun submitToolOutputs(submitToolOutputs: SubmitToolOutputs) =
                submitToolOutputs(JsonField.of(submitToolOutputs))

            /** Details on the tool outputs needed for this run to continue. */
            fun submitToolOutputs(submitToolOutputs: JsonField<SubmitToolOutputs>) = apply {
                this.submitToolOutputs = submitToolOutputs
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

            fun build(): RequiredAction =
                RequiredAction(
                    type,
                    submitToolOutputs,
                    additionalProperties.toImmutable(),
                )
        }

        /** Details on the tool outputs needed for this run to continue. */
        @NoAutoDetect
        class SubmitToolOutputs
        @JsonCreator
        private constructor(
            @JsonProperty("tool_calls")
            @ExcludeMissing
            private val toolCalls: JsonField<List<RequiredActionFunctionToolCall>> =
                JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** A list of the relevant tool calls. */
            fun toolCalls(): List<RequiredActionFunctionToolCall> =
                toolCalls.getRequired("tool_calls")

            /** A list of the relevant tool calls. */
            @JsonProperty("tool_calls") @ExcludeMissing fun _toolCalls() = toolCalls

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): SubmitToolOutputs = apply {
                if (!validated) {
                    toolCalls().forEach { it.validate() }
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var toolCalls: JsonField<List<RequiredActionFunctionToolCall>> =
                    JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(submitToolOutputs: SubmitToolOutputs) = apply {
                    toolCalls = submitToolOutputs.toolCalls
                    additionalProperties = submitToolOutputs.additionalProperties.toMutableMap()
                }

                /** A list of the relevant tool calls. */
                fun toolCalls(toolCalls: List<RequiredActionFunctionToolCall>) =
                    toolCalls(JsonField.of(toolCalls))

                /** A list of the relevant tool calls. */
                fun toolCalls(toolCalls: JsonField<List<RequiredActionFunctionToolCall>>) = apply {
                    this.toolCalls = toolCalls
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

                fun build(): SubmitToolOutputs =
                    SubmitToolOutputs(
                        toolCalls.map { it.toImmutable() },
                        additionalProperties.toImmutable()
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SubmitToolOutputs && toolCalls == other.toolCalls && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(toolCalls, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SubmitToolOutputs{toolCalls=$toolCalls, additionalProperties=$additionalProperties}"
        }

        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SUBMIT_TOOL_OUTPUTS = of("submit_tool_outputs")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                SUBMIT_TOOL_OUTPUTS,
            }

            enum class Value {
                SUBMIT_TOOL_OUTPUTS,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SUBMIT_TOOL_OUTPUTS -> Value.SUBMIT_TOOL_OUTPUTS
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SUBMIT_TOOL_OUTPUTS -> Known.SUBMIT_TOOL_OUTPUTS
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

            return /* spotless:off */ other is RequiredAction && type == other.type && submitToolOutputs == other.submitToolOutputs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, submitToolOutputs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RequiredAction{type=$type, submitToolOutputs=$submitToolOutputs, additionalProperties=$additionalProperties}"
    }

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    @NoAutoDetect
    class TruncationStrategy
    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("last_messages")
        @ExcludeMissing
        private val lastMessages: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
        fun type(): Type = type.getRequired("type")

        /**
         * The number of most recent messages from the thread when constructing the context for the
         * run.
         */
        fun lastMessages(): Optional<Long> =
            Optional.ofNullable(lastMessages.getNullable("last_messages"))

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
        @JsonProperty("type") @ExcludeMissing fun _type() = type

        /**
         * The number of most recent messages from the thread when constructing the context for the
         * run.
         */
        @JsonProperty("last_messages") @ExcludeMissing fun _lastMessages() = lastMessages

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): TruncationStrategy = apply {
            if (!validated) {
                type()
                lastMessages()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var type: JsonField<Type> = JsonMissing.of()
            private var lastMessages: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(truncationStrategy: TruncationStrategy) = apply {
                type = truncationStrategy.type
                lastMessages = truncationStrategy.lastMessages
                additionalProperties = truncationStrategy.additionalProperties.toMutableMap()
            }

            /**
             * The truncation strategy to use for the thread. The default is `auto`. If set to
             * `last_messages`, the thread will be truncated to the n most recent messages in the
             * thread. When set to `auto`, messages in the middle of the thread will be dropped to
             * fit the context length of the model, `max_prompt_tokens`.
             */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * The truncation strategy to use for the thread. The default is `auto`. If set to
             * `last_messages`, the thread will be truncated to the n most recent messages in the
             * thread. When set to `auto`, messages in the middle of the thread will be dropped to
             * fit the context length of the model, `max_prompt_tokens`.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: Long) = lastMessages(JsonField.of(lastMessages))

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: JsonField<Long>) = apply {
                this.lastMessages = lastMessages
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

            fun build(): TruncationStrategy =
                TruncationStrategy(
                    type,
                    lastMessages,
                    additionalProperties.toImmutable(),
                )
        }

        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val AUTO = of("auto")

                @JvmField val LAST_MESSAGES = of("last_messages")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                AUTO,
                LAST_MESSAGES,
            }

            enum class Value {
                AUTO,
                LAST_MESSAGES,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    AUTO -> Value.AUTO
                    LAST_MESSAGES -> Value.LAST_MESSAGES
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    AUTO -> Known.AUTO
                    LAST_MESSAGES -> Known.LAST_MESSAGES
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

            return /* spotless:off */ other is TruncationStrategy && type == other.type && lastMessages == other.lastMessages && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, lastMessages, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TruncationStrategy{type=$type, lastMessages=$lastMessages, additionalProperties=$additionalProperties}"
    }

    /**
     * Usage statistics related to the run. This value will be `null` if the run is not in a
     * terminal state (i.e. `in_progress`, `queued`, etc.).
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

        /** Number of completion tokens used over the course of the run. */
        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        /** Number of prompt tokens used over the course of the run. */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /** Total number of tokens used (prompt + completion). */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /** Number of completion tokens used over the course of the run. */
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun _completionTokens() = completionTokens

        /** Number of prompt tokens used over the course of the run. */
        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        /** Total number of tokens used (prompt + completion). */
        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (!validated) {
                completionTokens()
                promptTokens()
                totalTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var completionTokens: JsonField<Long> = JsonMissing.of()
            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                completionTokens = usage.completionTokens
                promptTokens = usage.promptTokens
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** Number of completion tokens used over the course of the run. */
            fun completionTokens(completionTokens: Long) =
                completionTokens(JsonField.of(completionTokens))

            /** Number of completion tokens used over the course of the run. */
            fun completionTokens(completionTokens: JsonField<Long>) = apply {
                this.completionTokens = completionTokens
            }

            /** Number of prompt tokens used over the course of the run. */
            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            /** Number of prompt tokens used over the course of the run. */
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            /** Total number of tokens used (prompt + completion). */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /** Total number of tokens used (prompt + completion). */
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

            fun build(): Usage =
                Usage(
                    completionTokens,
                    promptTokens,
                    totalTokens,
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

        return /* spotless:off */ other is Run && id == other.id && object_ == other.object_ && createdAt == other.createdAt && threadId == other.threadId && assistantId == other.assistantId && status == other.status && requiredAction == other.requiredAction && lastError == other.lastError && expiresAt == other.expiresAt && startedAt == other.startedAt && cancelledAt == other.cancelledAt && failedAt == other.failedAt && completedAt == other.completedAt && incompleteDetails == other.incompleteDetails && model == other.model && instructions == other.instructions && tools == other.tools && metadata == other.metadata && usage == other.usage && temperature == other.temperature && topP == other.topP && maxPromptTokens == other.maxPromptTokens && maxCompletionTokens == other.maxCompletionTokens && truncationStrategy == other.truncationStrategy && toolChoice == other.toolChoice && parallelToolCalls == other.parallelToolCalls && responseFormat == other.responseFormat && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, object_, createdAt, threadId, assistantId, status, requiredAction, lastError, expiresAt, startedAt, cancelledAt, failedAt, completedAt, incompleteDetails, model, instructions, tools, metadata, usage, temperature, topP, maxPromptTokens, maxCompletionTokens, truncationStrategy, toolChoice, parallelToolCalls, responseFormat, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Run{id=$id, object_=$object_, createdAt=$createdAt, threadId=$threadId, assistantId=$assistantId, status=$status, requiredAction=$requiredAction, lastError=$lastError, expiresAt=$expiresAt, startedAt=$startedAt, cancelledAt=$cancelledAt, failedAt=$failedAt, completedAt=$completedAt, incompleteDetails=$incompleteDetails, model=$model, instructions=$instructions, tools=$tools, metadata=$metadata, usage=$usage, temperature=$temperature, topP=$topP, maxPromptTokens=$maxPromptTokens, maxCompletionTokens=$maxCompletionTokens, truncationStrategy=$truncationStrategy, toolChoice=$toolChoice, parallelToolCalls=$parallelToolCalls, responseFormat=$responseFormat, additionalProperties=$additionalProperties}"
}
