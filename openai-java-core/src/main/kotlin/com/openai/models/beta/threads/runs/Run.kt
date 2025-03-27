// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

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
import com.openai.models.FunctionDefinition
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import com.openai.models.beta.assistants.AssistantTool
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.assistants.FileSearchTool
import com.openai.models.beta.assistants.FunctionTool
import com.openai.models.beta.threads.AssistantResponseFormatOption
import com.openai.models.beta.threads.AssistantToolChoice
import com.openai.models.beta.threads.AssistantToolChoiceOption
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents an execution run on a
 * [thread](https://platform.openai.com/docs/api-reference/threads).
 */
class Run
private constructor(
    private val id: JsonField<String>,
    private val assistantId: JsonField<String>,
    private val cancelledAt: JsonField<Long>,
    private val completedAt: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val expiresAt: JsonField<Long>,
    private val failedAt: JsonField<Long>,
    private val incompleteDetails: JsonField<IncompleteDetails>,
    private val instructions: JsonField<String>,
    private val lastError: JsonField<LastError>,
    private val maxCompletionTokens: JsonField<Long>,
    private val maxPromptTokens: JsonField<Long>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<String>,
    private val object_: JsonValue,
    private val parallelToolCalls: JsonField<Boolean>,
    private val requiredAction: JsonField<RequiredAction>,
    private val responseFormat: JsonField<AssistantResponseFormatOption>,
    private val startedAt: JsonField<Long>,
    private val status: JsonField<RunStatus>,
    private val threadId: JsonField<String>,
    private val toolChoice: JsonField<AssistantToolChoiceOption>,
    private val tools: JsonField<List<AssistantTool>>,
    private val truncationStrategy: JsonField<TruncationStrategy>,
    private val usage: JsonField<Usage>,
    private val temperature: JsonField<Double>,
    private val topP: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("assistant_id")
        @ExcludeMissing
        assistantId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cancelled_at")
        @ExcludeMissing
        cancelledAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed_at") @ExcludeMissing failedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("incomplete_details")
        @ExcludeMissing
        incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("last_error")
        @ExcludeMissing
        lastError: JsonField<LastError> = JsonMissing.of(),
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_prompt_tokens")
        @ExcludeMissing
        maxPromptTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("required_action")
        @ExcludeMissing
        requiredAction: JsonField<RequiredAction> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
        @JsonProperty("started_at") @ExcludeMissing startedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<RunStatus> = JsonMissing.of(),
        @JsonProperty("thread_id") @ExcludeMissing threadId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        tools: JsonField<List<AssistantTool>> = JsonMissing.of(),
        @JsonProperty("truncation_strategy")
        @ExcludeMissing
        truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
    ) : this(
        id,
        assistantId,
        cancelledAt,
        completedAt,
        createdAt,
        expiresAt,
        failedAt,
        incompleteDetails,
        instructions,
        lastError,
        maxCompletionTokens,
        maxPromptTokens,
        metadata,
        model,
        object_,
        parallelToolCalls,
        requiredAction,
        responseFormat,
        startedAt,
        status,
        threadId,
        toolChoice,
        tools,
        truncationStrategy,
        usage,
        temperature,
        topP,
        mutableMapOf(),
    )

    /**
     * The identifier, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used for
     * execution of this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assistantId(): String = assistantId.getRequired("assistant_id")

    /**
     * The Unix timestamp (in seconds) for when the run was cancelled.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelledAt(): Optional<Long> = Optional.ofNullable(cancelledAt.getNullable("cancelled_at"))

    /**
     * The Unix timestamp (in seconds) for when the run was completed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /**
     * The Unix timestamp (in seconds) for when the run was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The Unix timestamp (in seconds) for when the run will expire.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAt(): Optional<Long> = Optional.ofNullable(expiresAt.getNullable("expires_at"))

    /**
     * The Unix timestamp (in seconds) for when the run failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun failedAt(): Optional<Long> = Optional.ofNullable(failedAt.getNullable("failed_at"))

    /**
     * Details on why the run is incomplete. Will be `null` if the run is not incomplete.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun incompleteDetails(): Optional<IncompleteDetails> =
        Optional.ofNullable(incompleteDetails.getNullable("incomplete_details"))

    /**
     * The instructions that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun instructions(): String = instructions.getRequired("instructions")

    /**
     * The last error associated with this run. Will be `null` if there are no errors.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastError(): Optional<LastError> = Optional.ofNullable(lastError.getNullable("last_error"))

    /**
     * The maximum number of completion tokens specified to have been used over the course of the
     * run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxCompletionTokens(): Optional<Long> =
        Optional.ofNullable(maxCompletionTokens.getNullable("max_completion_tokens"))

    /**
     * The maximum number of prompt tokens specified to have been used over the course of the run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxPromptTokens(): Optional<Long> =
        Optional.ofNullable(maxPromptTokens.getNullable("max_prompt_tokens"))

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
     * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
     * used for this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The object type, which is always `thread.run`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("thread.run")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun parallelToolCalls(): Boolean = parallelToolCalls.getRequired("parallel_tool_calls")

    /**
     * Details on the action required to continue the run. Will be `null` if no action is required.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requiredAction(): Optional<RequiredAction> =
        Optional.ofNullable(requiredAction.getNullable("required_action"))

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
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<AssistantResponseFormatOption> =
        Optional.ofNullable(responseFormat.getNullable("response_format"))

    /**
     * The Unix timestamp (in seconds) for when the run was started.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startedAt(): Optional<Long> = Optional.ofNullable(startedAt.getNullable("started_at"))

    /**
     * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
     * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): RunStatus = status.getRequired("status")

    /**
     * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
     * executed on as a part of this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun threadId(): String = threadId.getRequired("thread_id")

    /**
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tools and instead generates a message. `auto` is the default value and means the model can
     * pick between generating a message or calling one or more tools. `required` means the model
     * must call one or more tools before responding to the user. Specifying a particular tool like
     * `{"type": "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<AssistantToolChoiceOption> =
        Optional.ofNullable(toolChoice.getNullable("tool_choice"))

    /**
     * The list of tools that the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tools(): List<AssistantTool> = tools.getRequired("tools")

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncationStrategy(): Optional<TruncationStrategy> =
        Optional.ofNullable(truncationStrategy.getNullable("truncation_strategy"))

    /**
     * Usage statistics related to the run. This value will be `null` if the run is not in a
     * terminal state (i.e. `in_progress`, `queued`, etc.).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<Usage> = Optional.ofNullable(usage.getNullable("usage"))

    /**
     * The sampling temperature used for this run. If not set, defaults to 1.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> =
        Optional.ofNullable(temperature.getNullable("temperature"))

    /**
     * The nucleus sampling value used for this run. If not set, defaults to 1.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

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
     * Returns the raw JSON value of [incompleteDetails].
     *
     * Unlike [incompleteDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    fun _incompleteDetails(): JsonField<IncompleteDetails> = incompleteDetails

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [lastError].
     *
     * Unlike [lastError], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_error") @ExcludeMissing fun _lastError(): JsonField<LastError> = lastError

    /**
     * Returns the raw JSON value of [maxCompletionTokens].
     *
     * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_completion_tokens")
    @ExcludeMissing
    fun _maxCompletionTokens(): JsonField<Long> = maxCompletionTokens

    /**
     * Returns the raw JSON value of [maxPromptTokens].
     *
     * Unlike [maxPromptTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_prompt_tokens")
    @ExcludeMissing
    fun _maxPromptTokens(): JsonField<Long> = maxPromptTokens

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
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

    /**
     * Returns the raw JSON value of [requiredAction].
     *
     * Unlike [requiredAction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required_action")
    @ExcludeMissing
    fun _requiredAction(): JsonField<RequiredAction> = requiredAction

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_format")
    @ExcludeMissing
    fun _responseFormat(): JsonField<AssistantResponseFormatOption> = responseFormat

    /**
     * Returns the raw JSON value of [startedAt].
     *
     * Unlike [startedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("started_at") @ExcludeMissing fun _startedAt(): JsonField<Long> = startedAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<RunStatus> = status

    /**
     * Returns the raw JSON value of [threadId].
     *
     * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_choice")
    @ExcludeMissing
    fun _toolChoice(): JsonField<AssistantToolChoiceOption> = toolChoice

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AssistantTool>> = tools

    /**
     * Returns the raw JSON value of [truncationStrategy].
     *
     * Unlike [truncationStrategy], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("truncation_strategy")
    @ExcludeMissing
    fun _truncationStrategy(): JsonField<TruncationStrategy> = truncationStrategy

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /**
     * Returns the raw JSON value of [topP].
     *
     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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
         * Returns a mutable builder for constructing an instance of [Run].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .assistantId()
         * .cancelledAt()
         * .completedAt()
         * .createdAt()
         * .expiresAt()
         * .failedAt()
         * .incompleteDetails()
         * .instructions()
         * .lastError()
         * .maxCompletionTokens()
         * .maxPromptTokens()
         * .metadata()
         * .model()
         * .parallelToolCalls()
         * .requiredAction()
         * .responseFormat()
         * .startedAt()
         * .status()
         * .threadId()
         * .toolChoice()
         * .tools()
         * .truncationStrategy()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Run]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var assistantId: JsonField<String>? = null
        private var cancelledAt: JsonField<Long>? = null
        private var completedAt: JsonField<Long>? = null
        private var createdAt: JsonField<Long>? = null
        private var expiresAt: JsonField<Long>? = null
        private var failedAt: JsonField<Long>? = null
        private var incompleteDetails: JsonField<IncompleteDetails>? = null
        private var instructions: JsonField<String>? = null
        private var lastError: JsonField<LastError>? = null
        private var maxCompletionTokens: JsonField<Long>? = null
        private var maxPromptTokens: JsonField<Long>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("thread.run")
        private var parallelToolCalls: JsonField<Boolean>? = null
        private var requiredAction: JsonField<RequiredAction>? = null
        private var responseFormat: JsonField<AssistantResponseFormatOption>? = null
        private var startedAt: JsonField<Long>? = null
        private var status: JsonField<RunStatus>? = null
        private var threadId: JsonField<String>? = null
        private var toolChoice: JsonField<AssistantToolChoiceOption>? = null
        private var tools: JsonField<MutableList<AssistantTool>>? = null
        private var truncationStrategy: JsonField<TruncationStrategy>? = null
        private var usage: JsonField<Usage>? = null
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var topP: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(run: Run) = apply {
            id = run.id
            assistantId = run.assistantId
            cancelledAt = run.cancelledAt
            completedAt = run.completedAt
            createdAt = run.createdAt
            expiresAt = run.expiresAt
            failedAt = run.failedAt
            incompleteDetails = run.incompleteDetails
            instructions = run.instructions
            lastError = run.lastError
            maxCompletionTokens = run.maxCompletionTokens
            maxPromptTokens = run.maxPromptTokens
            metadata = run.metadata
            model = run.model
            object_ = run.object_
            parallelToolCalls = run.parallelToolCalls
            requiredAction = run.requiredAction
            responseFormat = run.responseFormat
            startedAt = run.startedAt
            status = run.status
            threadId = run.threadId
            toolChoice = run.toolChoice
            tools = run.tools.map { it.toMutableList() }
            truncationStrategy = run.truncationStrategy
            usage = run.usage
            temperature = run.temperature
            topP = run.topP
            additionalProperties = run.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) used
         * for execution of this run.
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

        /** The Unix timestamp (in seconds) for when the run was cancelled. */
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

        /** The Unix timestamp (in seconds) for when the run was completed. */
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

        /** The Unix timestamp (in seconds) for when the run was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The Unix timestamp (in seconds) for when the run will expire. */
        fun expiresAt(expiresAt: Long?) = expiresAt(JsonField.ofNullable(expiresAt))

        /**
         * Alias for [Builder.expiresAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun expiresAt(expiresAt: Long) = expiresAt(expiresAt as Long?)

        /** Alias for calling [Builder.expiresAt] with `expiresAt.orElse(null)`. */
        fun expiresAt(expiresAt: Optional<Long>) = expiresAt(expiresAt.getOrNull())

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The Unix timestamp (in seconds) for when the run failed. */
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

        /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
        fun incompleteDetails(incompleteDetails: IncompleteDetails?) =
            incompleteDetails(JsonField.ofNullable(incompleteDetails))

        /** Alias for calling [Builder.incompleteDetails] with `incompleteDetails.orElse(null)`. */
        fun incompleteDetails(incompleteDetails: Optional<IncompleteDetails>) =
            incompleteDetails(incompleteDetails.getOrNull())

        /**
         * Sets [Builder.incompleteDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.incompleteDetails] with a well-typed [IncompleteDetails]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun incompleteDetails(incompleteDetails: JsonField<IncompleteDetails>) = apply {
            this.incompleteDetails = incompleteDetails
        }

        /**
         * The instructions that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun instructions(instructions: String) = instructions(JsonField.of(instructions))

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
        }

        /** The last error associated with this run. Will be `null` if there are no errors. */
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
         * The maximum number of completion tokens specified to have been used over the course of
         * the run.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long?) =
            maxCompletionTokens(JsonField.ofNullable(maxCompletionTokens))

        /**
         * Alias for [Builder.maxCompletionTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long) =
            maxCompletionTokens(maxCompletionTokens as Long?)

        /**
         * Alias for calling [Builder.maxCompletionTokens] with `maxCompletionTokens.orElse(null)`.
         */
        fun maxCompletionTokens(maxCompletionTokens: Optional<Long>) =
            maxCompletionTokens(maxCompletionTokens.getOrNull())

        /**
         * Sets [Builder.maxCompletionTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxCompletionTokens] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
            this.maxCompletionTokens = maxCompletionTokens
        }

        /**
         * The maximum number of prompt tokens specified to have been used over the course of the
         * run.
         */
        fun maxPromptTokens(maxPromptTokens: Long?) =
            maxPromptTokens(JsonField.ofNullable(maxPromptTokens))

        /**
         * Alias for [Builder.maxPromptTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxPromptTokens(maxPromptTokens: Long) = maxPromptTokens(maxPromptTokens as Long?)

        /** Alias for calling [Builder.maxPromptTokens] with `maxPromptTokens.orElse(null)`. */
        fun maxPromptTokens(maxPromptTokens: Optional<Long>) =
            maxPromptTokens(maxPromptTokens.getOrNull())

        /**
         * Sets [Builder.maxPromptTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxPromptTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxPromptTokens(maxPromptTokens: JsonField<Long>) = apply {
            this.maxPromptTokens = maxPromptTokens
        }

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
         * The model that the [assistant](https://platform.openai.com/docs/api-reference/assistants)
         * used for this run.
         */
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
         * JsonValue.from("thread.run")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(JsonField.of(parallelToolCalls))

        /**
         * Sets [Builder.parallelToolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parallelToolCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            this.parallelToolCalls = parallelToolCalls
        }

        /**
         * Details on the action required to continue the run. Will be `null` if no action is
         * required.
         */
        fun requiredAction(requiredAction: RequiredAction?) =
            requiredAction(JsonField.ofNullable(requiredAction))

        /** Alias for calling [Builder.requiredAction] with `requiredAction.orElse(null)`. */
        fun requiredAction(requiredAction: Optional<RequiredAction>) =
            requiredAction(requiredAction.getOrNull())

        /**
         * Sets [Builder.requiredAction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredAction] with a well-typed [RequiredAction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requiredAction(requiredAction: JsonField<RequiredAction>) = apply {
            this.requiredAction = requiredAction
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
        fun responseFormat(responseFormat: AssistantResponseFormatOption?) =
            responseFormat(JsonField.ofNullable(responseFormat))

        /** Alias for calling [Builder.responseFormat] with `responseFormat.orElse(null)`. */
        fun responseFormat(responseFormat: Optional<AssistantResponseFormatOption>) =
            responseFormat(responseFormat.getOrNull())

        /**
         * Sets [Builder.responseFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed
         * [AssistantResponseFormatOption] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
            this.responseFormat = responseFormat
        }

        /**
         * Alias for calling [responseFormat] with `AssistantResponseFormatOption.ofJsonValue()`.
         */
        fun responseFormatJsonValue() = responseFormat(AssistantResponseFormatOption.ofJsonValue())

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
         */
        fun responseFormat(responseFormatText: ResponseFormatText) =
            responseFormat(AssistantResponseFormatOption.ofResponseFormatText(responseFormatText))

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
         */
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) =
            responseFormat(
                AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)
            )

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
         */
        fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) =
            responseFormat(
                AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)
            )

        /** The Unix timestamp (in seconds) for when the run was started. */
        fun startedAt(startedAt: Long?) = startedAt(JsonField.ofNullable(startedAt))

        /**
         * Alias for [Builder.startedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun startedAt(startedAt: Long) = startedAt(startedAt as Long?)

        /** Alias for calling [Builder.startedAt] with `startedAt.orElse(null)`. */
        fun startedAt(startedAt: Optional<Long>) = startedAt(startedAt.getOrNull())

        /**
         * Sets [Builder.startedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun startedAt(startedAt: JsonField<Long>) = apply { this.startedAt = startedAt }

        /**
         * The status of the run, which can be either `queued`, `in_progress`, `requires_action`,
         * `cancelling`, `cancelled`, `failed`, `completed`, `incomplete`, or `expired`.
         */
        fun status(status: RunStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [RunStatus] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun status(status: JsonField<RunStatus>) = apply { this.status = status }

        /**
         * The ID of the [thread](https://platform.openai.com/docs/api-reference/threads) that was
         * executed on as a part of this run.
         */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * Sets [Builder.threadId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threadId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: AssistantToolChoiceOption?) =
            toolChoice(JsonField.ofNullable(toolChoice))

        /** Alias for calling [Builder.toolChoice] with `toolChoice.orElse(null)`. */
        fun toolChoice(toolChoice: Optional<AssistantToolChoiceOption>) =
            toolChoice(toolChoice.getOrNull())

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed
         * [AssistantToolChoiceOption] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun toolChoice(toolChoice: JsonField<AssistantToolChoiceOption>) = apply {
            this.toolChoice = toolChoice
        }

        /** Alias for calling [toolChoice] with `AssistantToolChoiceOption.ofAuto(auto)`. */
        fun toolChoice(auto: AssistantToolChoiceOption.Auto) =
            toolChoice(AssistantToolChoiceOption.ofAuto(auto))

        /**
         * Alias for calling [toolChoice] with
         * `AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice)`.
         */
        fun toolChoice(assistantToolChoice: AssistantToolChoice) =
            toolChoice(AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice))

        /**
         * The list of tools that the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) used for this run.
         */
        fun tools(tools: List<AssistantTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<AssistantTool>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tools(tools: JsonField<List<AssistantTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [AssistantTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: AssistantTool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `AssistantTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: CodeInterpreterTool) =
            addTool(AssistantTool.ofCodeInterpreter(codeInterpreter))

        /** Alias for calling [addTool] with `AssistantTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = addTool(AssistantTool.ofFileSearch(fileSearch))

        /** Alias for calling [addTool] with `AssistantTool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = addTool(AssistantTool.ofFunction(function))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FunctionTool.builder()
         *     .function(function)
         *     .build()
         * ```
         */
        fun addFunctionTool(function: FunctionDefinition) =
            addTool(FunctionTool.builder().function(function).build())

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: TruncationStrategy?) =
            truncationStrategy(JsonField.ofNullable(truncationStrategy))

        /**
         * Alias for calling [Builder.truncationStrategy] with `truncationStrategy.orElse(null)`.
         */
        fun truncationStrategy(truncationStrategy: Optional<TruncationStrategy>) =
            truncationStrategy(truncationStrategy.getOrNull())

        /**
         * Sets [Builder.truncationStrategy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncationStrategy] with a well-typed
         * [TruncationStrategy] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun truncationStrategy(truncationStrategy: JsonField<TruncationStrategy>) = apply {
            this.truncationStrategy = truncationStrategy
        }

        /**
         * Usage statistics related to the run. This value will be `null` if the run is not in a
         * terminal state (i.e. `in_progress`, `queued`, etc.).
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

        /** The sampling temperature used for this run. If not set, defaults to 1. */
        fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

        /**
         * Alias for [Builder.temperature].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun temperature(temperature: Double) = temperature(temperature as Double?)

        /** Alias for calling [Builder.temperature] with `temperature.orElse(null)`. */
        fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /** The nucleus sampling value used for this run. If not set, defaults to 1. */
        fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

        /**
         * Alias for [Builder.topP].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun topP(topP: Double) = topP(topP as Double?)

        /** Alias for calling [Builder.topP] with `topP.orElse(null)`. */
        fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

        /**
         * Sets [Builder.topP] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

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
         * Returns an immutable instance of [Run].
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
         * .expiresAt()
         * .failedAt()
         * .incompleteDetails()
         * .instructions()
         * .lastError()
         * .maxCompletionTokens()
         * .maxPromptTokens()
         * .metadata()
         * .model()
         * .parallelToolCalls()
         * .requiredAction()
         * .responseFormat()
         * .startedAt()
         * .status()
         * .threadId()
         * .toolChoice()
         * .tools()
         * .truncationStrategy()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Run =
            Run(
                checkRequired("id", id),
                checkRequired("assistantId", assistantId),
                checkRequired("cancelledAt", cancelledAt),
                checkRequired("completedAt", completedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("expiresAt", expiresAt),
                checkRequired("failedAt", failedAt),
                checkRequired("incompleteDetails", incompleteDetails),
                checkRequired("instructions", instructions),
                checkRequired("lastError", lastError),
                checkRequired("maxCompletionTokens", maxCompletionTokens),
                checkRequired("maxPromptTokens", maxPromptTokens),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                object_,
                checkRequired("parallelToolCalls", parallelToolCalls),
                checkRequired("requiredAction", requiredAction),
                checkRequired("responseFormat", responseFormat),
                checkRequired("startedAt", startedAt),
                checkRequired("status", status),
                checkRequired("threadId", threadId),
                checkRequired("toolChoice", toolChoice),
                checkRequired("tools", tools).map { it.toImmutable() },
                checkRequired("truncationStrategy", truncationStrategy),
                checkRequired("usage", usage),
                temperature,
                topP,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Run = apply {
        if (validated) {
            return@apply
        }

        id()
        assistantId()
        cancelledAt()
        completedAt()
        createdAt()
        expiresAt()
        failedAt()
        incompleteDetails().ifPresent { it.validate() }
        instructions()
        lastError().ifPresent { it.validate() }
        maxCompletionTokens()
        maxPromptTokens()
        metadata().ifPresent { it.validate() }
        model()
        _object_().let {
            if (it != JsonValue.from("thread.run")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        parallelToolCalls()
        requiredAction().ifPresent { it.validate() }
        responseFormat().ifPresent { it.validate() }
        startedAt()
        status()
        threadId()
        toolChoice().ifPresent { it.validate() }
        tools().forEach { it.validate() }
        truncationStrategy().ifPresent { it.validate() }
        usage().ifPresent { it.validate() }
        temperature()
        topP()
        validated = true
    }

    /** Details on why the run is incomplete. Will be `null` if the run is not incomplete. */
    class IncompleteDetails
    private constructor(
        private val reason: JsonField<Reason>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<Reason> = JsonMissing.of()
        ) : this(reason, mutableMapOf())

        /**
         * The reason why the run is incomplete. This will point to which specific token limit was
         * reached over the course of the run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reason(): Optional<Reason> = Optional.ofNullable(reason.getNullable("reason"))

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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

            /** Returns a mutable builder for constructing an instance of [IncompleteDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IncompleteDetails]. */
        class Builder internal constructor() {

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
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [Reason] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [IncompleteDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IncompleteDetails =
                IncompleteDetails(reason, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): IncompleteDetails = apply {
            if (validated) {
                return@apply
            }

            reason()
            validated = true
        }

        /**
         * The reason why the run is incomplete. This will point to which specific token limit was
         * reached over the course of the run.
         */
        class Reason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val MAX_COMPLETION_TOKENS = of("max_completion_tokens")

                @JvmField val MAX_PROMPT_TOKENS = of("max_prompt_tokens")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            /** An enum containing [Reason]'s known values. */
            enum class Known {
                MAX_COMPLETION_TOKENS,
                MAX_PROMPT_TOKENS,
            }

            /**
             * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Reason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MAX_COMPLETION_TOKENS,
                MAX_PROMPT_TOKENS,
                /**
                 * An enum member indicating that [Reason] was instantiated with an unknown value.
                 */
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
                    MAX_COMPLETION_TOKENS -> Value.MAX_COMPLETION_TOKENS
                    MAX_PROMPT_TOKENS -> Value.MAX_PROMPT_TOKENS
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
                    MAX_COMPLETION_TOKENS -> Known.MAX_COMPLETION_TOKENS
                    MAX_PROMPT_TOKENS -> Known.MAX_PROMPT_TOKENS
                    else -> throw OpenAIInvalidDataException("Unknown Reason: $value")
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
    class LastError
    private constructor(
        private val code: JsonField<Code>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, message, mutableMapOf())

        /**
         * One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`.
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

            /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
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
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): LastError = apply {
            if (validated) {
                return@apply
            }

            code()
            message()
            validated = true
        }

        /** One of `server_error`, `rate_limit_exceeded`, or `invalid_prompt`. */
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

                @JvmField val INVALID_PROMPT = of("invalid_prompt")

                @JvmStatic fun of(value: String) = Code(JsonField.of(value))
            }

            /** An enum containing [Code]'s known values. */
            enum class Known {
                SERVER_ERROR,
                RATE_LIMIT_EXCEEDED,
                INVALID_PROMPT,
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
                INVALID_PROMPT,
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
                    INVALID_PROMPT -> Value.INVALID_PROMPT
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
                    INVALID_PROMPT -> Known.INVALID_PROMPT
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

    /**
     * Details on the action required to continue the run. Will be `null` if no action is required.
     */
    class RequiredAction
    private constructor(
        private val submitToolOutputs: JsonField<SubmitToolOutputs>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("submit_tool_outputs")
            @ExcludeMissing
            submitToolOutputs: JsonField<SubmitToolOutputs> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(submitToolOutputs, type, mutableMapOf())

        /**
         * Details on the tool outputs needed for this run to continue.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun submitToolOutputs(): SubmitToolOutputs =
            submitToolOutputs.getRequired("submit_tool_outputs")

        /**
         * For now, this is always `submit_tool_outputs`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("submit_tool_outputs")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [submitToolOutputs].
         *
         * Unlike [submitToolOutputs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("submit_tool_outputs")
        @ExcludeMissing
        fun _submitToolOutputs(): JsonField<SubmitToolOutputs> = submitToolOutputs

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
             * Returns a mutable builder for constructing an instance of [RequiredAction].
             *
             * The following fields are required:
             * ```java
             * .submitToolOutputs()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RequiredAction]. */
        class Builder internal constructor() {

            private var submitToolOutputs: JsonField<SubmitToolOutputs>? = null
            private var type: JsonValue = JsonValue.from("submit_tool_outputs")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(requiredAction: RequiredAction) = apply {
                submitToolOutputs = requiredAction.submitToolOutputs
                type = requiredAction.type
                additionalProperties = requiredAction.additionalProperties.toMutableMap()
            }

            /** Details on the tool outputs needed for this run to continue. */
            fun submitToolOutputs(submitToolOutputs: SubmitToolOutputs) =
                submitToolOutputs(JsonField.of(submitToolOutputs))

            /**
             * Sets [Builder.submitToolOutputs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submitToolOutputs] with a well-typed
             * [SubmitToolOutputs] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun submitToolOutputs(submitToolOutputs: JsonField<SubmitToolOutputs>) = apply {
                this.submitToolOutputs = submitToolOutputs
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("submit_tool_outputs")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [RequiredAction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .submitToolOutputs()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): RequiredAction =
                RequiredAction(
                    checkRequired("submitToolOutputs", submitToolOutputs),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RequiredAction = apply {
            if (validated) {
                return@apply
            }

            submitToolOutputs().validate()
            _type().let {
                if (it != JsonValue.from("submit_tool_outputs")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            validated = true
        }

        /** Details on the tool outputs needed for this run to continue. */
        class SubmitToolOutputs
        private constructor(
            private val toolCalls: JsonField<List<RequiredActionFunctionToolCall>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("tool_calls")
                @ExcludeMissing
                toolCalls: JsonField<List<RequiredActionFunctionToolCall>> = JsonMissing.of()
            ) : this(toolCalls, mutableMapOf())

            /**
             * A list of the relevant tool calls.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun toolCalls(): List<RequiredActionFunctionToolCall> =
                toolCalls.getRequired("tool_calls")

            /**
             * Returns the raw JSON value of [toolCalls].
             *
             * Unlike [toolCalls], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tool_calls")
            @ExcludeMissing
            fun _toolCalls(): JsonField<List<RequiredActionFunctionToolCall>> = toolCalls

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
                 * Returns a mutable builder for constructing an instance of [SubmitToolOutputs].
                 *
                 * The following fields are required:
                 * ```java
                 * .toolCalls()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SubmitToolOutputs]. */
            class Builder internal constructor() {

                private var toolCalls: JsonField<MutableList<RequiredActionFunctionToolCall>>? =
                    null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(submitToolOutputs: SubmitToolOutputs) = apply {
                    toolCalls = submitToolOutputs.toolCalls.map { it.toMutableList() }
                    additionalProperties = submitToolOutputs.additionalProperties.toMutableMap()
                }

                /** A list of the relevant tool calls. */
                fun toolCalls(toolCalls: List<RequiredActionFunctionToolCall>) =
                    toolCalls(JsonField.of(toolCalls))

                /**
                 * Sets [Builder.toolCalls] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.toolCalls] with a well-typed
                 * `List<RequiredActionFunctionToolCall>` value instead. This method is primarily
                 * for setting the field to an undocumented or not yet supported value.
                 */
                fun toolCalls(toolCalls: JsonField<List<RequiredActionFunctionToolCall>>) = apply {
                    this.toolCalls = toolCalls.map { it.toMutableList() }
                }

                /**
                 * Adds a single [RequiredActionFunctionToolCall] to [toolCalls].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addToolCall(toolCall: RequiredActionFunctionToolCall) = apply {
                    toolCalls =
                        (toolCalls ?: JsonField.of(mutableListOf())).also {
                            checkKnown("toolCalls", it).add(toolCall)
                        }
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

                /**
                 * Returns an immutable instance of [SubmitToolOutputs].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .toolCalls()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SubmitToolOutputs =
                    SubmitToolOutputs(
                        checkRequired("toolCalls", toolCalls).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): SubmitToolOutputs = apply {
                if (validated) {
                    return@apply
                }

                toolCalls().forEach { it.validate() }
                validated = true
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is RequiredAction && submitToolOutputs == other.submitToolOutputs && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(submitToolOutputs, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RequiredAction{submitToolOutputs=$submitToolOutputs, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     */
    class TruncationStrategy
    private constructor(
        private val type: JsonField<Type>,
        private val lastMessages: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("last_messages")
            @ExcludeMissing
            lastMessages: JsonField<Long> = JsonMissing.of(),
        ) : this(type, lastMessages, mutableMapOf())

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * The number of most recent messages from the thread when constructing the context for the
         * run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun lastMessages(): Optional<Long> =
            Optional.ofNullable(lastMessages.getNullable("last_messages"))

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [lastMessages].
         *
         * Unlike [lastMessages], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("last_messages")
        @ExcludeMissing
        fun _lastMessages(): JsonField<Long> = lastMessages

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
             * Returns a mutable builder for constructing an instance of [TruncationStrategy].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TruncationStrategy]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
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
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /**
             * The number of most recent messages from the thread when constructing the context for
             * the run.
             */
            fun lastMessages(lastMessages: Long?) = lastMessages(JsonField.ofNullable(lastMessages))

            /**
             * Alias for [Builder.lastMessages].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun lastMessages(lastMessages: Long) = lastMessages(lastMessages as Long?)

            /** Alias for calling [Builder.lastMessages] with `lastMessages.orElse(null)`. */
            fun lastMessages(lastMessages: Optional<Long>) = lastMessages(lastMessages.getOrNull())

            /**
             * Sets [Builder.lastMessages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastMessages] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [TruncationStrategy].
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
            fun build(): TruncationStrategy =
                TruncationStrategy(
                    checkRequired("type", type),
                    lastMessages,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TruncationStrategy = apply {
            if (validated) {
                return@apply
            }

            type()
            lastMessages()
            validated = true
        }

        /**
         * The truncation strategy to use for the thread. The default is `auto`. If set to
         * `last_messages`, the thread will be truncated to the n most recent messages in the
         * thread. When set to `auto`, messages in the middle of the thread will be dropped to fit
         * the context length of the model, `max_prompt_tokens`.
         */
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

                @JvmField val AUTO = of("auto")

                @JvmField val LAST_MESSAGES = of("last_messages")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AUTO,
                LAST_MESSAGES,
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
                AUTO,
                LAST_MESSAGES,
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
                    AUTO -> Value.AUTO
                    LAST_MESSAGES -> Value.LAST_MESSAGES
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
                    AUTO -> Known.AUTO
                    LAST_MESSAGES -> Known.LAST_MESSAGES
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
    class Usage
    private constructor(
        private val completionTokens: JsonField<Long>,
        private val promptTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("completion_tokens")
            @ExcludeMissing
            completionTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            promptTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total_tokens")
            @ExcludeMissing
            totalTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(completionTokens, promptTokens, totalTokens, mutableMapOf())

        /**
         * Number of completion tokens used over the course of the run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        /**
         * Number of prompt tokens used over the course of the run.
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

            /** Number of completion tokens used over the course of the run. */
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

            /** Number of prompt tokens used over the course of the run. */
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
                    additionalProperties.toMutableMap(),
                )
        }

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

        return /* spotless:off */ other is Run && id == other.id && assistantId == other.assistantId && cancelledAt == other.cancelledAt && completedAt == other.completedAt && createdAt == other.createdAt && expiresAt == other.expiresAt && failedAt == other.failedAt && incompleteDetails == other.incompleteDetails && instructions == other.instructions && lastError == other.lastError && maxCompletionTokens == other.maxCompletionTokens && maxPromptTokens == other.maxPromptTokens && metadata == other.metadata && model == other.model && object_ == other.object_ && parallelToolCalls == other.parallelToolCalls && requiredAction == other.requiredAction && responseFormat == other.responseFormat && startedAt == other.startedAt && status == other.status && threadId == other.threadId && toolChoice == other.toolChoice && tools == other.tools && truncationStrategy == other.truncationStrategy && usage == other.usage && temperature == other.temperature && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, assistantId, cancelledAt, completedAt, createdAt, expiresAt, failedAt, incompleteDetails, instructions, lastError, maxCompletionTokens, maxPromptTokens, metadata, model, object_, parallelToolCalls, requiredAction, responseFormat, startedAt, status, threadId, toolChoice, tools, truncationStrategy, usage, temperature, topP, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Run{id=$id, assistantId=$assistantId, cancelledAt=$cancelledAt, completedAt=$completedAt, createdAt=$createdAt, expiresAt=$expiresAt, failedAt=$failedAt, incompleteDetails=$incompleteDetails, instructions=$instructions, lastError=$lastError, maxCompletionTokens=$maxCompletionTokens, maxPromptTokens=$maxPromptTokens, metadata=$metadata, model=$model, object_=$object_, parallelToolCalls=$parallelToolCalls, requiredAction=$requiredAction, responseFormat=$responseFormat, startedAt=$startedAt, status=$status, threadId=$threadId, toolChoice=$toolChoice, tools=$tools, truncationStrategy=$truncationStrategy, usage=$usage, temperature=$temperature, topP=$topP, additionalProperties=$additionalProperties}"
}
