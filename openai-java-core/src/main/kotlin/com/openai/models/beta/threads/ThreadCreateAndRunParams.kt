// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

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
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.Metadata
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.assistants.FileSearchTool
import com.openai.models.beta.assistants.FunctionTool
import com.openai.models.beta.threads.messages.MessageContentPartParam
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a thread and run it in one request. */
class ThreadCreateAndRunParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to use
     * to execute this run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assistantId(): String = body.assistantId()

    /**
     * Override the default system message of the assistant. This is useful for modifying the
     * behavior on a per-run basis.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * The maximum number of completion tokens that may be used over the course of the run. The run
     * will make a best effort to use only the number of completion tokens specified, across
     * multiple turns of the run. If the run exceeds the number of completion tokens specified, the
     * run will end with status `incomplete`. See `incomplete_details` for more info.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxCompletionTokens(): Optional<Long> = body.maxCompletionTokens()

    /**
     * The maximum number of prompt tokens that may be used over the course of the run. The run will
     * make a best effort to use only the number of prompt tokens specified, across multiple turns
     * of the run. If the run exceeds the number of prompt tokens specified, the run will end with
     * status `incomplete`. See `incomplete_details` for more info.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxPromptTokens(): Optional<Long> = body.maxPromptTokens()

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
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used to
     * execute this run. If a value is provided here, it will override the model associated with the
     * assistant. If not, the model associated with the assistant will be used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<ChatModel> = body.model()

    /**
     * Whether to enable
     * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
     * during tool use.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun parallelToolCalls(): Optional<Boolean> = body.parallelToolCalls()

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
    fun responseFormat(): Optional<AssistantResponseFormatOption> = body.responseFormat()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * Options to create a new thread. If no thread is provided when running a request, an empty
     * thread will be created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun thread(): Optional<Thread> = body.thread()

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
    fun toolChoice(): Optional<AssistantToolChoiceOption> = body.toolChoice()

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    /**
     * Override the tools the assistant can use for this run. This is useful for modifying the
     * behavior on a per-run basis.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = body.tools()

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topP(): Optional<Double> = body.topP()

    /**
     * Controls for how a thread will be truncated prior to the run. Use this to control the intial
     * context window of the run.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncationStrategy(): Optional<TruncationStrategy> = body.truncationStrategy()

    /**
     * Returns the raw JSON value of [assistantId].
     *
     * Unlike [assistantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _assistantId(): JsonField<String> = body._assistantId()

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Returns the raw JSON value of [maxCompletionTokens].
     *
     * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxCompletionTokens(): JsonField<Long> = body._maxCompletionTokens()

    /**
     * Returns the raw JSON value of [maxPromptTokens].
     *
     * Unlike [maxPromptTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxPromptTokens(): JsonField<Long> = body._maxPromptTokens()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<ChatModel> = body._model()

    /**
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseFormat(): JsonField<AssistantResponseFormatOption> = body._responseFormat()

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Returns the raw JSON value of [thread].
     *
     * Unlike [thread], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _thread(): JsonField<Thread> = body._thread()

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolChoice(): JsonField<AssistantToolChoiceOption> = body._toolChoice()

    /**
     * Returns the raw JSON value of [toolResources].
     *
     * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolResources(): JsonField<ToolResources> = body._toolResources()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<Tool>> = body._tools()

    /**
     * Returns the raw JSON value of [topP].
     *
     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topP(): JsonField<Double> = body._topP()

    /**
     * Returns the raw JSON value of [truncationStrategy].
     *
     * Unlike [truncationStrategy], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _truncationStrategy(): JsonField<TruncationStrategy> = body._truncationStrategy()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("assistant_id")
        @ExcludeMissing
        private val assistantId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        private val instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        private val maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_prompt_tokens")
        @ExcludeMissing
        private val maxPromptTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ChatModel> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        private val parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        private val responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        private val temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("thread")
        @ExcludeMissing
        private val thread: JsonField<Thread> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        private val toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        private val toolResources: JsonField<ToolResources> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        private val tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("top_p")
        @ExcludeMissing
        private val topP: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("truncation_strategy")
        @ExcludeMissing
        private val truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun assistantId(): String = assistantId.getRequired("assistant_id")

        /**
         * Override the default system message of the assistant. This is useful for modifying the
         * behavior on a per-run basis.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> =
            Optional.ofNullable(instructions.getNullable("instructions"))

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxCompletionTokens(): Optional<Long> =
            Optional.ofNullable(maxCompletionTokens.getNullable("max_completion_tokens"))

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxPromptTokens(): Optional<Long> =
            Optional.ofNullable(maxPromptTokens.getNullable("max_prompt_tokens"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<ChatModel> = Optional.ofNullable(model.getNullable("model"))

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parallelToolCalls(): Optional<Boolean> =
            Optional.ofNullable(parallelToolCalls.getNullable("parallel_tool_calls"))

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
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<AssistantResponseFormatOption> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.getNullable("temperature"))

        /**
         * Options to create a new thread. If no thread is provided when running a request, an empty
         * thread will be created.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun thread(): Optional<Thread> = Optional.ofNullable(thread.getNullable("thread"))

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<AssistantToolChoiceOption> =
            Optional.ofNullable(toolChoice.getNullable("tool_choice"))

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun truncationStrategy(): Optional<TruncationStrategy> =
            Optional.ofNullable(truncationStrategy.getNullable("truncation_strategy"))

        /**
         * Returns the raw JSON value of [assistantId].
         *
         * Unlike [assistantId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("assistant_id")
        @ExcludeMissing
        fun _assistantId(): JsonField<String> = assistantId

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * Returns the raw JSON value of [maxCompletionTokens].
         *
         * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        fun _maxCompletionTokens(): JsonField<Long> = maxCompletionTokens

        /**
         * Returns the raw JSON value of [maxPromptTokens].
         *
         * Unlike [maxPromptTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

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
         * Returns the raw JSON value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<AssistantResponseFormatOption> = responseFormat

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [thread].
         *
         * Unlike [thread], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("thread") @ExcludeMissing fun _thread(): JsonField<Thread> = thread

        /**
         * Returns the raw JSON value of [toolChoice].
         *
         * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_choice")
        @ExcludeMissing
        fun _toolChoice(): JsonField<AssistantToolChoiceOption> = toolChoice

        /**
         * Returns the raw JSON value of [toolResources].
         *
         * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

        /**
         * Returns the raw JSON value of [truncationStrategy].
         *
         * Unlike [truncationStrategy], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("truncation_strategy")
        @ExcludeMissing
        fun _truncationStrategy(): JsonField<TruncationStrategy> = truncationStrategy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            assistantId()
            instructions()
            maxCompletionTokens()
            maxPromptTokens()
            metadata().ifPresent { it.validate() }
            model()
            parallelToolCalls()
            responseFormat().ifPresent { it.validate() }
            temperature()
            thread().ifPresent { it.validate() }
            toolChoice().ifPresent { it.validate() }
            toolResources().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topP()
            truncationStrategy().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .assistantId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var assistantId: JsonField<String>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
            private var maxPromptTokens: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var model: JsonField<ChatModel> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var responseFormat: JsonField<AssistantResponseFormatOption> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var thread: JsonField<Thread> = JsonMissing.of()
            private var toolChoice: JsonField<AssistantToolChoiceOption> = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var topP: JsonField<Double> = JsonMissing.of()
            private var truncationStrategy: JsonField<TruncationStrategy> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                assistantId = body.assistantId
                instructions = body.instructions
                maxCompletionTokens = body.maxCompletionTokens
                maxPromptTokens = body.maxPromptTokens
                metadata = body.metadata
                model = body.model
                parallelToolCalls = body.parallelToolCalls
                responseFormat = body.responseFormat
                temperature = body.temperature
                thread = body.thread
                toolChoice = body.toolChoice
                toolResources = body.toolResources
                tools = body.tools.map { it.toMutableList() }
                topP = body.topP
                truncationStrategy = body.truncationStrategy
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants)
             * to use to execute this run.
             */
            fun assistantId(assistantId: String) = assistantId(JsonField.of(assistantId))

            /**
             * Sets [Builder.assistantId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assistantId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assistantId(assistantId: JsonField<String>) = apply {
                this.assistantId = assistantId
            }

            /**
             * Override the default system message of the assistant. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.getOrNull())

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /**
             * The maximum number of completion tokens that may be used over the course of the run.
             * The run will make a best effort to use only the number of completion tokens
             * specified, across multiple turns of the run. If the run exceeds the number of
             * completion tokens specified, the run will end with status `incomplete`. See
             * `incomplete_details` for more info.
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
             * Alias for calling [Builder.maxCompletionTokens] with
             * `maxCompletionTokens.orElse(null)`.
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
             * The maximum number of prompt tokens that may be used over the course of the run. The
             * run will make a best effort to use only the number of prompt tokens specified, across
             * multiple turns of the run. If the run exceeds the number of prompt tokens specified,
             * the run will end with status `incomplete`. See `incomplete_details` for more info.
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
             * You should usually call [Builder.maxPromptTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxPromptTokens(maxPromptTokens: JsonField<Long>) = apply {
                this.maxPromptTokens = maxPromptTokens
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
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
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /**
             * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be
             * used to execute this run. If a value is provided here, it will override the model
             * associated with the assistant. If not, the model associated with the assistant will
             * be used.
             */
            fun model(model: ChatModel?) = model(JsonField.ofNullable(model))

            /** Alias for calling [Builder.model] with `model.orElse(null)`. */
            fun model(model: Optional<ChatModel>) = model(model.getOrNull())

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [ChatModel] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<ChatModel>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [ChatModel] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(ChatModel.of(value))

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
             * Specifies the format that the model must output. Compatible with
             * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
             * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all
             * GPT-3.5 Turbo models since `gpt-3.5-turbo-1106`.
             *
             * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured
             * Outputs which ensures the model will match your supplied JSON schema. Learn more in
             * the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
             *
             * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message
             * the model generates is valid JSON.
             *
             * **Important:** when using JSON mode, you **must** also instruct the model to produce
             * JSON yourself via a system or user message. Without this, the model may generate an
             * unending stream of whitespace until the generation reaches the token limit, resulting
             * in a long-running and seemingly "stuck" request. Also note that the message content
             * may be partially cut off if `finish_reason="length"`, which indicates the generation
             * exceeded `max_tokens` or the conversation exceeded the max context length.
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
             * [AssistantResponseFormatOption] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun responseFormat(responseFormat: JsonField<AssistantResponseFormatOption>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofJsonValue()`.
             */
            fun responseFormatJsonValue() =
                responseFormat(AssistantResponseFormatOption.ofJsonValue())

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
             */
            fun responseFormat(responseFormatText: ResponseFormatText) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)
                )

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
             */
            fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatJsonObject(
                        responseFormatJsonObject
                    )
                )

            /**
             * Alias for calling [responseFormat] with
             * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
             */
            fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) =
                responseFormat(
                    AssistantResponseFormatOption.ofResponseFormatJsonSchema(
                        responseFormatJsonSchema
                    )
                )

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
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
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * Options to create a new thread. If no thread is provided when running a request, an
             * empty thread will be created.
             */
            fun thread(thread: Thread) = thread(JsonField.of(thread))

            /**
             * Sets [Builder.thread] to an arbitrary JSON value.
             *
             * You should usually call [Builder.thread] with a well-typed [Thread] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun thread(thread: JsonField<Thread>) = apply { this.thread = thread }

            /**
             * Controls which (if any) tool is called by the model. `none` means the model will not
             * call any tools and instead generates a message. `auto` is the default value and means
             * the model can pick between generating a message or calling one or more tools.
             * `required` means the model must call one or more tools before responding to the user.
             * Specifying a particular tool like `{"type": "file_search"}` or `{"type": "function",
             * "function": {"name": "my_function"}}` forces the model to call that tool.
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
             * [AssistantToolChoiceOption] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
             * A set of resources that are used by the assistant's tools. The resources are specific
             * to the type of tool. For example, the `code_interpreter` tool requires a list of file
             * IDs, while the `file_search` tool requires a list of vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.getOrNull())

            /**
             * Sets [Builder.toolResources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolResources] with a well-typed [ToolResources]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun toolResources(toolResources: JsonField<ToolResources>) = apply {
                this.toolResources = toolResources
            }

            /**
             * Override the tools the assistant can use for this run. This is useful for modifying
             * the behavior on a per-run basis.
             */
            fun tools(tools: List<Tool>?) = tools(JsonField.ofNullable(tools))

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<List<Tool>>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<Tool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [Tool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: Tool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
            fun addTool(codeInterpreter: CodeInterpreterTool) =
                addTool(Tool.ofCodeInterpreter(codeInterpreter))

            /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
            fun addTool(fileSearch: FileSearchTool) = addTool(Tool.ofFileSearch(fileSearch))

            /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
            fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or temperature but not both.
             */
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

            /**
             * Controls for how a thread will be truncated prior to the run. Use this to control the
             * intial context window of the run.
             */
            fun truncationStrategy(truncationStrategy: TruncationStrategy?) =
                truncationStrategy(JsonField.ofNullable(truncationStrategy))

            /**
             * Alias for calling [Builder.truncationStrategy] with
             * `truncationStrategy.orElse(null)`.
             */
            fun truncationStrategy(truncationStrategy: Optional<TruncationStrategy>) =
                truncationStrategy(truncationStrategy.getOrNull())

            /**
             * Sets [Builder.truncationStrategy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.truncationStrategy] with a well-typed
             * [TruncationStrategy] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun truncationStrategy(truncationStrategy: JsonField<TruncationStrategy>) = apply {
                this.truncationStrategy = truncationStrategy
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .assistantId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("assistantId", assistantId),
                    instructions,
                    maxCompletionTokens,
                    maxPromptTokens,
                    metadata,
                    model,
                    parallelToolCalls,
                    responseFormat,
                    temperature,
                    thread,
                    toolChoice,
                    toolResources,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topP,
                    truncationStrategy,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && assistantId == other.assistantId && instructions == other.instructions && maxCompletionTokens == other.maxCompletionTokens && maxPromptTokens == other.maxPromptTokens && metadata == other.metadata && model == other.model && parallelToolCalls == other.parallelToolCalls && responseFormat == other.responseFormat && temperature == other.temperature && thread == other.thread && toolChoice == other.toolChoice && toolResources == other.toolResources && tools == other.tools && topP == other.topP && truncationStrategy == other.truncationStrategy && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(assistantId, instructions, maxCompletionTokens, maxPromptTokens, metadata, model, parallelToolCalls, responseFormat, temperature, thread, toolChoice, toolResources, tools, topP, truncationStrategy, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{assistantId=$assistantId, instructions=$instructions, maxCompletionTokens=$maxCompletionTokens, maxPromptTokens=$maxPromptTokens, metadata=$metadata, model=$model, parallelToolCalls=$parallelToolCalls, responseFormat=$responseFormat, temperature=$temperature, thread=$thread, toolChoice=$toolChoice, toolResources=$toolResources, tools=$tools, topP=$topP, truncationStrategy=$truncationStrategy, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ThreadCreateAndRunParams].
         *
         * The following fields are required:
         * ```java
         * .assistantId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ThreadCreateAndRunParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(threadCreateAndRunParams: ThreadCreateAndRunParams) = apply {
            body = threadCreateAndRunParams.body.toBuilder()
            additionalHeaders = threadCreateAndRunParams.additionalHeaders.toBuilder()
            additionalQueryParams = threadCreateAndRunParams.additionalQueryParams.toBuilder()
        }

        /**
         * The ID of the [assistant](https://platform.openai.com/docs/api-reference/assistants) to
         * use to execute this run.
         */
        fun assistantId(assistantId: String) = apply { body.assistantId(assistantId) }

        /**
         * Sets [Builder.assistantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assistantId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assistantId(assistantId: JsonField<String>) = apply { body.assistantId(assistantId) }

        /**
         * Override the default system message of the assistant. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun instructions(instructions: String?) = apply { body.instructions(instructions) }

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            body.instructions(instructions)
        }

        /**
         * The maximum number of completion tokens that may be used over the course of the run. The
         * run will make a best effort to use only the number of completion tokens specified, across
         * multiple turns of the run. If the run exceeds the number of completion tokens specified,
         * the run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxCompletionTokens(maxCompletionTokens: Long?) = apply {
            body.maxCompletionTokens(maxCompletionTokens)
        }

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
            body.maxCompletionTokens(maxCompletionTokens)
        }

        /**
         * The maximum number of prompt tokens that may be used over the course of the run. The run
         * will make a best effort to use only the number of prompt tokens specified, across
         * multiple turns of the run. If the run exceeds the number of prompt tokens specified, the
         * run will end with status `incomplete`. See `incomplete_details` for more info.
         */
        fun maxPromptTokens(maxPromptTokens: Long?) = apply {
            body.maxPromptTokens(maxPromptTokens)
        }

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
            body.maxPromptTokens(maxPromptTokens)
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /**
         * The ID of the [Model](https://platform.openai.com/docs/api-reference/models) to be used
         * to execute this run. If a value is provided here, it will override the model associated
         * with the assistant. If not, the model associated with the assistant will be used.
         */
        fun model(model: ChatModel?) = apply { body.model(model) }

        /** Alias for calling [Builder.model] with `model.orElse(null)`. */
        fun model(model: Optional<ChatModel>) = model(model.getOrNull())

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [ChatModel] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<ChatModel>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [ChatModel] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /**
         * Sets [Builder.parallelToolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parallelToolCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            body.parallelToolCalls(parallelToolCalls)
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
        fun responseFormat(responseFormat: AssistantResponseFormatOption?) = apply {
            body.responseFormat(responseFormat)
        }

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
            body.responseFormat(responseFormat)
        }

        /**
         * Alias for calling [responseFormat] with `AssistantResponseFormatOption.ofJsonValue()`.
         */
        fun responseFormatJsonValue() = apply { body.responseFormatJsonValue() }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)`.
         */
        fun responseFormat(responseFormatText: ResponseFormatText) = apply {
            body.responseFormat(responseFormatText)
        }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)`.
         */
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            body.responseFormat(responseFormatJsonObject)
        }

        /**
         * Alias for calling [responseFormat] with
         * `AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)`.
         */
        fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) = apply {
            body.responseFormat(responseFormatJsonSchema)
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double?) = apply { body.temperature(temperature) }

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
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /**
         * Options to create a new thread. If no thread is provided when running a request, an empty
         * thread will be created.
         */
        fun thread(thread: Thread) = apply { body.thread(thread) }

        /**
         * Sets [Builder.thread] to an arbitrary JSON value.
         *
         * You should usually call [Builder.thread] with a well-typed [Thread] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun thread(thread: JsonField<Thread>) = apply { body.thread(thread) }

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tools and instead generates a message. `auto` is the default value and means the
         * model can pick between generating a message or calling one or more tools. `required`
         * means the model must call one or more tools before responding to the user. Specifying a
         * particular tool like `{"type": "file_search"}` or `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         */
        fun toolChoice(toolChoice: AssistantToolChoiceOption?) = apply {
            body.toolChoice(toolChoice)
        }

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
            body.toolChoice(toolChoice)
        }

        /** Alias for calling [toolChoice] with `AssistantToolChoiceOption.ofAuto(auto)`. */
        fun toolChoice(auto: AssistantToolChoiceOption.Auto) = apply { body.toolChoice(auto) }

        /**
         * Alias for calling [toolChoice] with
         * `AssistantToolChoiceOption.ofAssistantToolChoice(assistantToolChoice)`.
         */
        fun toolChoice(assistantToolChoice: AssistantToolChoice) = apply {
            body.toolChoice(assistantToolChoice)
        }

        /**
         * A set of resources that are used by the assistant's tools. The resources are specific to
         * the type of tool. For example, the `code_interpreter` tool requires a list of file IDs,
         * while the `file_search` tool requires a list of vector store IDs.
         */
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

        /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.getOrNull())

        /**
         * Sets [Builder.toolResources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolResources] with a well-typed [ToolResources] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolResources(toolResources: JsonField<ToolResources>) = apply {
            body.toolResources(toolResources)
        }

        /**
         * Override the tools the assistant can use for this run. This is useful for modifying the
         * behavior on a per-run basis.
         */
        fun tools(tools: List<Tool>?) = apply { body.tools(tools) }

        /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
        fun tools(tools: Optional<List<Tool>>) = tools(tools.getOrNull())

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<Tool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [Tool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: Tool) = apply { body.addTool(tool) }

        /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: CodeInterpreterTool) = apply { body.addTool(codeInterpreter) }

        /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or temperature but not both.
         */
        fun topP(topP: Double?) = apply { body.topP(topP) }

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
        fun topP(topP: JsonField<Double>) = apply { body.topP(topP) }

        /**
         * Controls for how a thread will be truncated prior to the run. Use this to control the
         * intial context window of the run.
         */
        fun truncationStrategy(truncationStrategy: TruncationStrategy?) = apply {
            body.truncationStrategy(truncationStrategy)
        }

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
            body.truncationStrategy(truncationStrategy)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ThreadCreateAndRunParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assistantId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ThreadCreateAndRunParams =
            ThreadCreateAndRunParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * Options to create a new thread. If no thread is provided when running a request, an empty
     * thread will be created.
     */
    @NoAutoDetect
    class Thread
    @JsonCreator
    private constructor(
        @JsonProperty("messages")
        @ExcludeMissing
        private val messages: JsonField<List<Message>> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        private val toolResources: JsonField<ToolResources> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messages(): Optional<List<Message>> =
            Optional.ofNullable(messages.getNullable("messages"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * Returns the raw JSON value of [messages].
         *
         * Unlike [messages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("messages")
        @ExcludeMissing
        fun _messages(): JsonField<List<Message>> = messages

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [toolResources].
         *
         * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Thread = apply {
            if (validated) {
                return@apply
            }

            messages().ifPresent { it.forEach { it.validate() } }
            metadata().ifPresent { it.validate() }
            toolResources().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Thread]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Thread]. */
        class Builder internal constructor() {

            private var messages: JsonField<MutableList<Message>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(thread: Thread) = apply {
                messages = thread.messages.map { it.toMutableList() }
                metadata = thread.metadata
                toolResources = thread.toolResources
                additionalProperties = thread.additionalProperties.toMutableMap()
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun messages(messages: List<Message>) = messages(JsonField.of(messages))

            /**
             * Sets [Builder.messages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messages] with a well-typed `List<Message>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messages(messages: JsonField<List<Message>>) = apply {
                this.messages = messages.map { it.toMutableList() }
            }

            /**
             * Adds a single [Message] to [messages].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMessage(message: Message) = apply {
                messages =
                    (messages ?: JsonField.of(mutableListOf())).also {
                        checkKnown("messages", it).add(message)
                    }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
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
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.getOrNull())

            /**
             * Sets [Builder.toolResources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolResources] with a well-typed [ToolResources]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun toolResources(toolResources: JsonField<ToolResources>) = apply {
                this.toolResources = toolResources
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
             * Returns an immutable instance of [Thread].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Thread =
                Thread(
                    (messages ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    toolResources,
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class Message
        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<Content> = JsonMissing.of(),
            @JsonProperty("role")
            @ExcludeMissing
            private val role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("attachments")
            @ExcludeMissing
            private val attachments: JsonField<List<Attachment>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            private val metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The text contents of the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun content(): Content = content.getRequired("content")

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun role(): Role = role.getRequired("role")

            /**
             * A list of files attached to the message, and the tools they should be added to.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun attachments(): Optional<List<Attachment>> =
                Optional.ofNullable(attachments.getNullable("attachments"))

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun metadata(): Optional<Metadata> =
                Optional.ofNullable(metadata.getNullable("metadata"))

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

            /**
             * Returns the raw JSON value of [attachments].
             *
             * Unlike [attachments], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("attachments")
            @ExcludeMissing
            fun _attachments(): JsonField<List<Attachment>> = attachments

            /**
             * Returns the raw JSON value of [metadata].
             *
             * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata(): JsonField<Metadata> = metadata

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Message = apply {
                if (validated) {
                    return@apply
                }

                content().validate()
                role()
                attachments().ifPresent { it.forEach { it.validate() } }
                metadata().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Message].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .role()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Message]. */
            class Builder internal constructor() {

                private var content: JsonField<Content>? = null
                private var role: JsonField<Role>? = null
                private var attachments: JsonField<MutableList<Attachment>>? = null
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(message: Message) = apply {
                    content = message.content
                    role = message.role
                    attachments = message.attachments.map { it.toMutableList() }
                    metadata = message.metadata
                    additionalProperties = message.additionalProperties.toMutableMap()
                }

                /** The text contents of the message. */
                fun content(content: Content) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed [Content] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<Content>) = apply { this.content = content }

                /** Alias for calling [content] with `Content.ofText(text)`. */
                fun content(text: String) = content(Content.ofText(text))

                /**
                 * Alias for calling [content] with
                 * `Content.ofArrayOfContentParts(arrayOfContentParts)`.
                 */
                fun contentOfArrayOfContentParts(
                    arrayOfContentParts: List<MessageContentPartParam>
                ) = content(Content.ofArrayOfContentParts(arrayOfContentParts))

                /**
                 * The role of the entity that is creating the message. Allowed values include:
                 * - `user`: Indicates the message is sent by an actual user and should be used in
                 *   most cases to represent user-generated messages.
                 * - `assistant`: Indicates the message is generated by the assistant. Use this
                 *   value to insert messages from the assistant into the conversation.
                 */
                fun role(role: Role) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [Role] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<Role>) = apply { this.role = role }

                /**
                 * A list of files attached to the message, and the tools they should be added to.
                 */
                fun attachments(attachments: List<Attachment>?) =
                    attachments(JsonField.ofNullable(attachments))

                /** Alias for calling [Builder.attachments] with `attachments.orElse(null)`. */
                fun attachments(attachments: Optional<List<Attachment>>) =
                    attachments(attachments.getOrNull())

                /**
                 * Sets [Builder.attachments] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.attachments] with a well-typed
                 * `List<Attachment>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun attachments(attachments: JsonField<List<Attachment>>) = apply {
                    this.attachments = attachments.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Attachment] to [attachments].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAttachment(attachment: Attachment) = apply {
                    attachments =
                        (attachments ?: JsonField.of(mutableListOf())).also {
                            checkKnown("attachments", it).add(attachment)
                        }
                }

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
                fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

                /**
                 * Sets [Builder.metadata] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.metadata] with a well-typed [Metadata] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
                 * Returns an immutable instance of [Message].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * .role()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Message =
                    Message(
                        checkRequired("content", content),
                        checkRequired("role", role),
                        (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                        metadata,
                        additionalProperties.toImmutable(),
                    )
            }

            /** The text contents of the message. */
            @JsonDeserialize(using = Content.Deserializer::class)
            @JsonSerialize(using = Content.Serializer::class)
            class Content
            private constructor(
                private val text: String? = null,
                private val arrayOfContentParts: List<MessageContentPartParam>? = null,
                private val _json: JsonValue? = null,
            ) {

                /** The text contents of the message. */
                fun text(): Optional<String> = Optional.ofNullable(text)

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                fun arrayOfContentParts(): Optional<List<MessageContentPartParam>> =
                    Optional.ofNullable(arrayOfContentParts)

                fun isText(): Boolean = text != null

                fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

                /** The text contents of the message. */
                fun asText(): String = text.getOrThrow("text")

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                fun asArrayOfContentParts(): List<MessageContentPartParam> =
                    arrayOfContentParts.getOrThrow("arrayOfContentParts")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        text != null -> visitor.visitText(text)
                        arrayOfContentParts != null ->
                            visitor.visitArrayOfContentParts(arrayOfContentParts)
                        else -> visitor.unknown(_json)
                    }
                }

                private var validated: Boolean = false

                fun validate(): Content = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitText(text: String) {}

                            override fun visitArrayOfContentParts(
                                arrayOfContentParts: List<MessageContentPartParam>
                            ) {
                                arrayOfContentParts.forEach { it.validate() }
                            }
                        }
                    )
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Content && text == other.text && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, arrayOfContentParts) /* spotless:on */

                override fun toString(): String =
                    when {
                        text != null -> "Content{text=$text}"
                        arrayOfContentParts != null ->
                            "Content{arrayOfContentParts=$arrayOfContentParts}"
                        _json != null -> "Content{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Content")
                    }

                companion object {

                    /** The text contents of the message. */
                    @JvmStatic fun ofText(text: String) = Content(text = text)

                    /**
                     * An array of content parts with a defined type, each can be of type `text` or
                     * images can be passed with `image_url` or `image_file`. Image types are only
                     * supported on
                     * [Vision-compatible models](https://platform.openai.com/docs/models).
                     */
                    @JvmStatic
                    fun ofArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                        Content(arrayOfContentParts = arrayOfContentParts)
                }

                /**
                 * An interface that defines how to map each variant of [Content] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /** The text contents of the message. */
                    fun visitText(text: String): T

                    /**
                     * An array of content parts with a defined type, each can be of type `text` or
                     * images can be passed with `image_url` or `image_file`. Image types are only
                     * supported on
                     * [Vision-compatible models](https://platform.openai.com/docs/models).
                     */
                    fun visitArrayOfContentParts(
                        arrayOfContentParts: List<MessageContentPartParam>
                    ): T

                    /**
                     * Maps an unknown variant of [Content] to a value of type [T].
                     *
                     * An instance of [Content] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Content: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Content {
                        val json = JsonValue.fromJsonNode(node)

                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            return Content(text = it, _json = json)
                        }
                        tryDeserialize(node, jacksonTypeRef<List<MessageContentPartParam>>()) {
                                it.forEach { it.validate() }
                            }
                            ?.let {
                                return Content(arrayOfContentParts = it, _json = json)
                            }

                        return Content(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Content>(Content::class) {

                    override fun serialize(
                        value: Content,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.text != null -> generator.writeObject(value.text)
                            value.arrayOfContentParts != null ->
                                generator.writeObject(value.arrayOfContentParts)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Content")
                        }
                    }
                }
            }

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            class Role @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val USER = of("user")

                    @JvmField val ASSISTANT = of("assistant")

                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                }

                /** An enum containing [Role]'s known values. */
                enum class Known {
                    USER,
                    ASSISTANT,
                }

                /**
                 * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Role] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    USER,
                    ASSISTANT,
                    /**
                     * An enum member indicating that [Role] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        USER -> Value.USER
                        ASSISTANT -> Value.ASSISTANT
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        USER -> Known.USER
                        ASSISTANT -> Known.ASSISTANT
                        else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            @NoAutoDetect
            class Attachment
            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                private val fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tools")
                @ExcludeMissing
                private val tools: JsonField<List<Tool>> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The ID of the file to attach to the message.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

                /**
                 * The tools to add this file to.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

                /**
                 * Returns the raw JSON value of [fileId].
                 *
                 * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

                /**
                 * Returns the raw JSON value of [tools].
                 *
                 * Unlike [tools], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Attachment = apply {
                    if (validated) {
                        return@apply
                    }

                    fileId()
                    tools().ifPresent { it.forEach { it.validate() } }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Attachment]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Attachment]. */
                class Builder internal constructor() {

                    private var fileId: JsonField<String> = JsonMissing.of()
                    private var tools: JsonField<MutableList<Tool>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(attachment: Attachment) = apply {
                        fileId = attachment.fileId
                        tools = attachment.tools.map { it.toMutableList() }
                        additionalProperties = attachment.additionalProperties.toMutableMap()
                    }

                    /** The ID of the file to attach to the message. */
                    fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                    /**
                     * Sets [Builder.fileId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                    /** The tools to add this file to. */
                    fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

                    /**
                     * Sets [Builder.tools] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.tools] with a well-typed `List<Tool>` value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun tools(tools: JsonField<List<Tool>>) = apply {
                        this.tools = tools.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Tool] to [tools].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addTool(tool: Tool) = apply {
                        tools =
                            (tools ?: JsonField.of(mutableListOf())).also {
                                checkKnown("tools", it).add(tool)
                            }
                    }

                    /**
                     * Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`.
                     */
                    fun addTool(codeInterpreter: CodeInterpreterTool) =
                        addTool(Tool.ofCodeInterpreter(codeInterpreter))

                    /** Alias for calling [addTool] with `Tool.ofFileSearch()`. */
                    fun addToolFileSearch() = addTool(Tool.ofFileSearch())

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
                     * Returns an immutable instance of [Attachment].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Attachment =
                        Attachment(
                            fileId,
                            (tools ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toImmutable(),
                        )
                }

                @JsonDeserialize(using = Tool.Deserializer::class)
                @JsonSerialize(using = Tool.Serializer::class)
                class Tool
                private constructor(
                    private val codeInterpreter: CodeInterpreterTool? = null,
                    private val fileSearch: JsonValue? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun codeInterpreter(): Optional<CodeInterpreterTool> =
                        Optional.ofNullable(codeInterpreter)

                    fun fileSearch(): Optional<JsonValue> = Optional.ofNullable(fileSearch)

                    fun isCodeInterpreter(): Boolean = codeInterpreter != null

                    fun isFileSearch(): Boolean = fileSearch != null

                    fun asCodeInterpreter(): CodeInterpreterTool =
                        codeInterpreter.getOrThrow("codeInterpreter")

                    fun asFileSearch(): JsonValue = fileSearch.getOrThrow("fileSearch")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
                            fileSearch != null -> visitor.visitFileSearch(fileSearch)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): Tool = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitCodeInterpreter(
                                    codeInterpreter: CodeInterpreterTool
                                ) {
                                    codeInterpreter.validate()
                                }

                                override fun visitFileSearch(fileSearch: JsonValue) {
                                    fileSearch.let {
                                        if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                            throw OpenAIInvalidDataException(
                                                "'fileSearch' is invalid, received $it"
                                            )
                                        }
                                    }
                                }
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Tool && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch) /* spotless:on */

                    override fun toString(): String =
                        when {
                            codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                            fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                            _json != null -> "Tool{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Tool")
                        }

                    companion object {

                        @JvmStatic
                        fun ofCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
                            Tool(codeInterpreter = codeInterpreter)

                        @JvmStatic
                        fun ofFileSearch() =
                            Tool(fileSearch = JsonValue.from(mapOf("type" to "file_search")))
                    }

                    /**
                     * An interface that defines how to map each variant of [Tool] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

                        fun visitFileSearch(fileSearch: JsonValue): T

                        /**
                         * Maps an unknown variant of [Tool] to a value of type [T].
                         *
                         * An instance of [Tool] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown Tool: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                            val json = JsonValue.fromJsonNode(node)
                            val type =
                                json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                            when (type) {
                                "code_interpreter" -> {
                                    tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return Tool(codeInterpreter = it, _json = json)
                                        }
                                }
                                "file_search" -> {
                                    tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                            it.let {
                                                if (
                                                    it !=
                                                        JsonValue.from(
                                                            mapOf("type" to "file_search")
                                                        )
                                                ) {
                                                    throw OpenAIInvalidDataException(
                                                        "'fileSearch' is invalid, received $it"
                                                    )
                                                }
                                            }
                                        }
                                        ?.let {
                                            return Tool(fileSearch = it, _json = json)
                                        }
                                }
                            }

                            return Tool(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Tool>(Tool::class) {

                        override fun serialize(
                            value: Tool,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.codeInterpreter != null ->
                                    generator.writeObject(value.codeInterpreter)
                                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Tool")
                            }
                        }
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Attachment && fileId == other.fileId && tools == other.tools && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(fileId, tools, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Attachment{fileId=$fileId, tools=$tools, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Message && content == other.content && role == other.role && attachments == other.attachments && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, role, attachments, metadata, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Message{content=$content, role=$role, attachments=$attachments, metadata=$metadata, additionalProperties=$additionalProperties}"
        }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        @NoAutoDetect
        class ToolResources
        @JsonCreator
        private constructor(
            @JsonProperty("code_interpreter")
            @ExcludeMissing
            private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
            @JsonProperty("file_search")
            @ExcludeMissing
            private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun codeInterpreter(): Optional<CodeInterpreter> =
                Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileSearch(): Optional<FileSearch> =
                Optional.ofNullable(fileSearch.getNullable("file_search"))

            /**
             * Returns the raw JSON value of [codeInterpreter].
             *
             * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("code_interpreter")
            @ExcludeMissing
            fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

            /**
             * Returns the raw JSON value of [fileSearch].
             *
             * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_search")
            @ExcludeMissing
            fun _fileSearch(): JsonField<FileSearch> = fileSearch

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): ToolResources = apply {
                if (validated) {
                    return@apply
                }

                codeInterpreter().ifPresent { it.validate() }
                fileSearch().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [ToolResources]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ToolResources]. */
            class Builder internal constructor() {

                private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
                private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(toolResources: ToolResources) = apply {
                    codeInterpreter = toolResources.codeInterpreter
                    fileSearch = toolResources.fileSearch
                    additionalProperties = toolResources.additionalProperties.toMutableMap()
                }

                fun codeInterpreter(codeInterpreter: CodeInterpreter) =
                    codeInterpreter(JsonField.of(codeInterpreter))

                /**
                 * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.codeInterpreter] with a well-typed
                 * [CodeInterpreter] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                    this.codeInterpreter = codeInterpreter
                }

                fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

                /**
                 * Sets [Builder.fileSearch] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileSearch(fileSearch: JsonField<FileSearch>) = apply {
                    this.fileSearch = fileSearch
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
                 * Returns an immutable instance of [ToolResources].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ToolResources =
                    ToolResources(codeInterpreter, fileSearch, additionalProperties.toImmutable())
            }

            @NoAutoDetect
            class CodeInterpreter
            @JsonCreator
            private constructor(
                @JsonProperty("file_ids")
                @ExcludeMissing
                private val fileIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun fileIds(): Optional<List<String>> =
                    Optional.ofNullable(fileIds.getNullable("file_ids"))

                /**
                 * Returns the raw JSON value of [fileIds].
                 *
                 * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_ids")
                @ExcludeMissing
                fun _fileIds(): JsonField<List<String>> = fileIds

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): CodeInterpreter = apply {
                    if (validated) {
                        return@apply
                    }

                    fileIds()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [CodeInterpreter].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [CodeInterpreter]. */
                class Builder internal constructor() {

                    private var fileIds: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(codeInterpreter: CodeInterpreter) = apply {
                        fileIds = codeInterpreter.fileIds.map { it.toMutableList() }
                        additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                    }

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs
                     * made available to the `code_interpreter` tool. There can be a maximum of 20
                     * files associated with the tool.
                     */
                    fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                    /**
                     * Sets [Builder.fileIds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileIds] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun fileIds(fileIds: JsonField<List<String>>) = apply {
                        this.fileIds = fileIds.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [fileIds].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds =
                            (fileIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("fileIds", it).add(fileId)
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
                     * Returns an immutable instance of [CodeInterpreter].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): CodeInterpreter =
                        CodeInterpreter(
                            (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is CodeInterpreter && fileIds == other.fileIds && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(fileIds, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "CodeInterpreter{fileIds=$fileIds, additionalProperties=$additionalProperties}"
            }

            @NoAutoDetect
            class FileSearch
            @JsonCreator
            private constructor(
                @JsonProperty("vector_store_ids")
                @ExcludeMissing
                private val vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("vector_stores")
                @ExcludeMissing
                private val vectorStores: JsonField<List<VectorStore>> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun vectorStoreIds(): Optional<List<String>> =
                    Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun vectorStores(): Optional<List<VectorStore>> =
                    Optional.ofNullable(vectorStores.getNullable("vector_stores"))

                /**
                 * Returns the raw JSON value of [vectorStoreIds].
                 *
                 * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("vector_store_ids")
                @ExcludeMissing
                fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

                /**
                 * Returns the raw JSON value of [vectorStores].
                 *
                 * Unlike [vectorStores], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("vector_stores")
                @ExcludeMissing
                fun _vectorStores(): JsonField<List<VectorStore>> = vectorStores

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): FileSearch = apply {
                    if (validated) {
                        return@apply
                    }

                    vectorStoreIds()
                    vectorStores().ifPresent { it.forEach { it.validate() } }
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [FileSearch]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [FileSearch]. */
                class Builder internal constructor() {

                    private var vectorStoreIds: JsonField<MutableList<String>>? = null
                    private var vectorStores: JsonField<MutableList<VectorStore>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(fileSearch: FileSearch) = apply {
                        vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                        vectorStores = fileSearch.vectorStores.map { it.toMutableList() }
                        additionalProperties = fileSearch.additionalProperties.toMutableMap()
                    }

                    /**
                     * The
                     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                     * attached to this thread. There can be a maximum of 1 vector store attached to
                     * the thread.
                     */
                    fun vectorStoreIds(vectorStoreIds: List<String>) =
                        vectorStoreIds(JsonField.of(vectorStoreIds))

                    /**
                     * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.vectorStoreIds] with a well-typed
                     * `List<String>` value instead. This method is primarily for setting the field
                     * to an undocumented or not yet supported value.
                     */
                    fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                        this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [vectorStoreIds].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVectorStoreId(vectorStoreId: String) = apply {
                        vectorStoreIds =
                            (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("vectorStoreIds", it).add(vectorStoreId)
                            }
                    }

                    /**
                     * A helper to create a
                     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                     * with file_ids and attach it to this thread. There can be a maximum of 1
                     * vector store attached to the thread.
                     */
                    fun vectorStores(vectorStores: List<VectorStore>) =
                        vectorStores(JsonField.of(vectorStores))

                    /**
                     * Sets [Builder.vectorStores] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.vectorStores] with a well-typed
                     * `List<VectorStore>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun vectorStores(vectorStores: JsonField<List<VectorStore>>) = apply {
                        this.vectorStores = vectorStores.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [VectorStore] to [vectorStores].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVectorStore(vectorStore: VectorStore) = apply {
                        vectorStores =
                            (vectorStores ?: JsonField.of(mutableListOf())).also {
                                checkKnown("vectorStores", it).add(vectorStore)
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
                     * Returns an immutable instance of [FileSearch].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): FileSearch =
                        FileSearch(
                            (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                            (vectorStores ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toImmutable(),
                        )
                }

                @NoAutoDetect
                class VectorStore
                @JsonCreator
                private constructor(
                    @JsonProperty("chunking_strategy")
                    @ExcludeMissing
                    private val chunkingStrategy: JsonField<ChunkingStrategy> = JsonMissing.of(),
                    @JsonProperty("file_ids")
                    @ExcludeMissing
                    private val fileIds: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("metadata")
                    @ExcludeMissing
                    private val metadata: JsonField<Metadata> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun chunkingStrategy(): Optional<ChunkingStrategy> =
                        Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun fileIds(): Optional<List<String>> =
                        Optional.ofNullable(fileIds.getNullable("file_ids"))

                    /**
                     * Set of 16 key-value pairs that can be attached to an object. This can be
                     * useful for storing additional information about the object in a structured
                     * format, and querying for objects via API or the dashboard.
                     *
                     * Keys are strings with a maximum length of 64 characters. Values are strings
                     * with a maximum length of 512 characters.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun metadata(): Optional<Metadata> =
                        Optional.ofNullable(metadata.getNullable("metadata"))

                    /**
                     * Returns the raw JSON value of [chunkingStrategy].
                     *
                     * Unlike [chunkingStrategy], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("chunking_strategy")
                    @ExcludeMissing
                    fun _chunkingStrategy(): JsonField<ChunkingStrategy> = chunkingStrategy

                    /**
                     * Returns the raw JSON value of [fileIds].
                     *
                     * Unlike [fileIds], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("file_ids")
                    @ExcludeMissing
                    fun _fileIds(): JsonField<List<String>> = fileIds

                    /**
                     * Returns the raw JSON value of [metadata].
                     *
                     * Unlike [metadata], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("metadata")
                    @ExcludeMissing
                    fun _metadata(): JsonField<Metadata> = metadata

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): VectorStore = apply {
                        if (validated) {
                            return@apply
                        }

                        chunkingStrategy().ifPresent { it.validate() }
                        fileIds()
                        metadata().ifPresent { it.validate() }
                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [VectorStore].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [VectorStore]. */
                    class Builder internal constructor() {

                        private var chunkingStrategy: JsonField<ChunkingStrategy> = JsonMissing.of()
                        private var fileIds: JsonField<MutableList<String>>? = null
                        private var metadata: JsonField<Metadata> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(vectorStore: VectorStore) = apply {
                            chunkingStrategy = vectorStore.chunkingStrategy
                            fileIds = vectorStore.fileIds.map { it.toMutableList() }
                            metadata = vectorStore.metadata
                            additionalProperties = vectorStore.additionalProperties.toMutableMap()
                        }

                        /**
                         * The chunking strategy used to chunk the file(s). If not set, will use the
                         * `auto` strategy.
                         */
                        fun chunkingStrategy(chunkingStrategy: ChunkingStrategy) =
                            chunkingStrategy(JsonField.of(chunkingStrategy))

                        /**
                         * Sets [Builder.chunkingStrategy] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.chunkingStrategy] with a well-typed
                         * [ChunkingStrategy] value instead. This method is primarily for setting
                         * the field to an undocumented or not yet supported value.
                         */
                        fun chunkingStrategy(chunkingStrategy: JsonField<ChunkingStrategy>) =
                            apply {
                                this.chunkingStrategy = chunkingStrategy
                            }

                        /**
                         * Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofAuto()`.
                         */
                        fun chunkingStrategyAuto() = chunkingStrategy(ChunkingStrategy.ofAuto())

                        /**
                         * Alias for calling [chunkingStrategy] with
                         * `ChunkingStrategy.ofStatic(static_)`.
                         */
                        fun chunkingStrategy(static_: ChunkingStrategy.StaticObject) =
                            chunkingStrategy(ChunkingStrategy.ofStatic(static_))

                        /**
                         * Alias for calling [chunkingStrategy] with the following:
                         * ```java
                         * ChunkingStrategy.StaticObject.builder()
                         *     .static_(static_)
                         *     .build()
                         * ```
                         */
                        fun staticChunkingStrategy(static_: ChunkingStrategy.StaticObject.Static) =
                            chunkingStrategy(
                                ChunkingStrategy.StaticObject.builder().static_(static_).build()
                            )

                        /**
                         * A list of [file](https://platform.openai.com/docs/api-reference/files)
                         * IDs to add to the vector store. There can be a maximum of 10000 files in
                         * a vector store.
                         */
                        fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                        /**
                         * Sets [Builder.fileIds] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.fileIds] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun fileIds(fileIds: JsonField<List<String>>) = apply {
                            this.fileIds = fileIds.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [fileIds].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addFileId(fileId: String) = apply {
                            fileIds =
                                (fileIds ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("fileIds", it).add(fileId)
                                }
                        }

                        /**
                         * Set of 16 key-value pairs that can be attached to an object. This can be
                         * useful for storing additional information about the object in a
                         * structured format, and querying for objects via API or the dashboard.
                         *
                         * Keys are strings with a maximum length of 64 characters. Values are
                         * strings with a maximum length of 512 characters.
                         */
                        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
                        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

                        /**
                         * Sets [Builder.metadata] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.metadata] with a well-typed [Metadata]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun metadata(metadata: JsonField<Metadata>) = apply {
                            this.metadata = metadata
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [VectorStore].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): VectorStore =
                            VectorStore(
                                chunkingStrategy,
                                (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                                metadata,
                                additionalProperties.toImmutable(),
                            )
                    }

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy.
                     */
                    @JsonDeserialize(using = ChunkingStrategy.Deserializer::class)
                    @JsonSerialize(using = ChunkingStrategy.Serializer::class)
                    class ChunkingStrategy
                    private constructor(
                        private val auto: JsonValue? = null,
                        private val static_: StaticObject? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        /**
                         * The default strategy. This strategy currently uses a
                         * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                         */
                        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                        fun static_(): Optional<StaticObject> = Optional.ofNullable(static_)

                        fun isAuto(): Boolean = auto != null

                        fun isStatic(): Boolean = static_ != null

                        /**
                         * The default strategy. This strategy currently uses a
                         * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                         */
                        fun asAuto(): JsonValue = auto.getOrThrow("auto")

                        fun asStatic(): StaticObject = static_.getOrThrow("static_")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        fun <T> accept(visitor: Visitor<T>): T {
                            return when {
                                auto != null -> visitor.visitAuto(auto)
                                static_ != null -> visitor.visitStatic(static_)
                                else -> visitor.unknown(_json)
                            }
                        }

                        private var validated: Boolean = false

                        fun validate(): ChunkingStrategy = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitAuto(auto: JsonValue) {
                                        auto.let {
                                            if (it != JsonValue.from(mapOf("type" to "auto"))) {
                                                throw OpenAIInvalidDataException(
                                                    "'auto' is invalid, received $it"
                                                )
                                            }
                                        }
                                    }

                                    override fun visitStatic(static_: StaticObject) {
                                        static_.validate()
                                    }
                                }
                            )
                            validated = true
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is ChunkingStrategy && auto == other.auto && static_ == other.static_ /* spotless:on */
                        }

                        override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, static_) /* spotless:on */

                        override fun toString(): String =
                            when {
                                auto != null -> "ChunkingStrategy{auto=$auto}"
                                static_ != null -> "ChunkingStrategy{static_=$static_}"
                                _json != null -> "ChunkingStrategy{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid ChunkingStrategy")
                            }

                        companion object {

                            /**
                             * The default strategy. This strategy currently uses a
                             * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                             */
                            @JvmStatic
                            fun ofAuto() =
                                ChunkingStrategy(auto = JsonValue.from(mapOf("type" to "auto")))

                            @JvmStatic
                            fun ofStatic(static_: StaticObject) =
                                ChunkingStrategy(static_ = static_)
                        }

                        /**
                         * An interface that defines how to map each variant of [ChunkingStrategy]
                         * to a value of type [T].
                         */
                        interface Visitor<out T> {

                            /**
                             * The default strategy. This strategy currently uses a
                             * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                             */
                            fun visitAuto(auto: JsonValue): T

                            fun visitStatic(static_: StaticObject): T

                            /**
                             * Maps an unknown variant of [ChunkingStrategy] to a value of type [T].
                             *
                             * An instance of [ChunkingStrategy] can contain an unknown variant if
                             * it was deserialized from data that doesn't match any known variant.
                             * For example, if the SDK is on an older version than the API, then the
                             * API may respond with new variants that the SDK is unaware of.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown ChunkingStrategy: $json")
                            }
                        }

                        internal class Deserializer :
                            BaseDeserializer<ChunkingStrategy>(ChunkingStrategy::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): ChunkingStrategy {
                                val json = JsonValue.fromJsonNode(node)
                                val type =
                                    json
                                        .asObject()
                                        .getOrNull()
                                        ?.get("type")
                                        ?.asString()
                                        ?.getOrNull()

                                when (type) {
                                    "auto" -> {
                                        tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                                it.let {
                                                    if (
                                                        it !=
                                                            JsonValue.from(mapOf("type" to "auto"))
                                                    ) {
                                                        throw OpenAIInvalidDataException(
                                                            "'auto' is invalid, received $it"
                                                        )
                                                    }
                                                }
                                            }
                                            ?.let {
                                                return ChunkingStrategy(auto = it, _json = json)
                                            }
                                    }
                                    "static" -> {
                                        tryDeserialize(node, jacksonTypeRef<StaticObject>()) {
                                                it.validate()
                                            }
                                            ?.let {
                                                return ChunkingStrategy(static_ = it, _json = json)
                                            }
                                    }
                                }

                                return ChunkingStrategy(_json = json)
                            }
                        }

                        internal class Serializer :
                            BaseSerializer<ChunkingStrategy>(ChunkingStrategy::class) {

                            override fun serialize(
                                value: ChunkingStrategy,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.auto != null -> generator.writeObject(value.auto)
                                    value.static_ != null -> generator.writeObject(value.static_)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid ChunkingStrategy")
                                }
                            }
                        }

                        @NoAutoDetect
                        class StaticObject
                        @JsonCreator
                        private constructor(
                            @JsonProperty("static")
                            @ExcludeMissing
                            private val static_: JsonField<Static> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            private val type: JsonValue = JsonMissing.of(),
                            @JsonAnySetter
                            private val additionalProperties: Map<String, JsonValue> =
                                immutableEmptyMap(),
                        ) {

                            /**
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun static_(): Static = static_.getRequired("static")

                            /**
                             * Always `static`.
                             *
                             * Expected to always return the following:
                             * ```java
                             * JsonValue.from("static")
                             * ```
                             *
                             * However, this method can be useful for debugging and logging (e.g. if
                             * the server responded with an unexpected value).
                             */
                            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                            /**
                             * Returns the raw JSON value of [static_].
                             *
                             * Unlike [static_], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("static")
                            @ExcludeMissing
                            fun _static_(): JsonField<Static> = static_

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            private var validated: Boolean = false

                            fun validate(): StaticObject = apply {
                                if (validated) {
                                    return@apply
                                }

                                static_().validate()
                                _type().let {
                                    if (it != JsonValue.from("static")) {
                                        throw OpenAIInvalidDataException(
                                            "'type' is invalid, received $it"
                                        )
                                    }
                                }
                                validated = true
                            }

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of
                                 * [StaticObject].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .static_()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [StaticObject]. */
                            class Builder internal constructor() {

                                private var static_: JsonField<Static>? = null
                                private var type: JsonValue = JsonValue.from("static")
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(staticObject: StaticObject) = apply {
                                    static_ = staticObject.static_
                                    type = staticObject.type
                                    additionalProperties =
                                        staticObject.additionalProperties.toMutableMap()
                                }

                                fun static_(static_: Static) = static_(JsonField.of(static_))

                                /**
                                 * Sets [Builder.static_] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.static_] with a well-typed
                                 * [Static] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun static_(static_: JsonField<Static>) = apply {
                                    this.static_ = static_
                                }

                                /**
                                 * Sets the field to an arbitrary JSON value.
                                 *
                                 * It is usually unnecessary to call this method because the field
                                 * defaults to the following:
                                 * ```java
                                 * JsonValue.from("static")
                                 * ```
                                 *
                                 * This method is primarily for setting the field to an undocumented
                                 * or not yet supported value.
                                 */
                                fun type(type: JsonValue) = apply { this.type = type }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [StaticObject].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .static_()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): StaticObject =
                                    StaticObject(
                                        checkRequired("static_", static_),
                                        type,
                                        additionalProperties.toImmutable(),
                                    )
                            }

                            @NoAutoDetect
                            class Static
                            @JsonCreator
                            private constructor(
                                @JsonProperty("chunk_overlap_tokens")
                                @ExcludeMissing
                                private val chunkOverlapTokens: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("max_chunk_size_tokens")
                                @ExcludeMissing
                                private val maxChunkSizeTokens: JsonField<Long> = JsonMissing.of(),
                                @JsonAnySetter
                                private val additionalProperties: Map<String, JsonValue> =
                                    immutableEmptyMap(),
                            ) {

                                /**
                                 * The number of tokens that overlap between chunks. The default
                                 * value is `400`.
                                 *
                                 * Note that the overlap must not exceed half of
                                 * `max_chunk_size_tokens`.
                                 *
                                 * @throws OpenAIInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun chunkOverlapTokens(): Long =
                                    chunkOverlapTokens.getRequired("chunk_overlap_tokens")

                                /**
                                 * The maximum number of tokens in each chunk. The default value is
                                 * `800`. The minimum value is `100` and the maximum value is
                                 * `4096`.
                                 *
                                 * @throws OpenAIInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun maxChunkSizeTokens(): Long =
                                    maxChunkSizeTokens.getRequired("max_chunk_size_tokens")

                                /**
                                 * Returns the raw JSON value of [chunkOverlapTokens].
                                 *
                                 * Unlike [chunkOverlapTokens], this method doesn't throw if the
                                 * JSON field has an unexpected type.
                                 */
                                @JsonProperty("chunk_overlap_tokens")
                                @ExcludeMissing
                                fun _chunkOverlapTokens(): JsonField<Long> = chunkOverlapTokens

                                /**
                                 * Returns the raw JSON value of [maxChunkSizeTokens].
                                 *
                                 * Unlike [maxChunkSizeTokens], this method doesn't throw if the
                                 * JSON field has an unexpected type.
                                 */
                                @JsonProperty("max_chunk_size_tokens")
                                @ExcludeMissing
                                fun _maxChunkSizeTokens(): JsonField<Long> = maxChunkSizeTokens

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                private var validated: Boolean = false

                                fun validate(): Static = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    chunkOverlapTokens()
                                    maxChunkSizeTokens()
                                    validated = true
                                }

                                fun toBuilder() = Builder().from(this)

                                companion object {

                                    /**
                                     * Returns a mutable builder for constructing an instance of
                                     * [Static].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .chunkOverlapTokens()
                                     * .maxChunkSizeTokens()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [Static]. */
                                class Builder internal constructor() {

                                    private var chunkOverlapTokens: JsonField<Long>? = null
                                    private var maxChunkSizeTokens: JsonField<Long>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(static_: Static) = apply {
                                        chunkOverlapTokens = static_.chunkOverlapTokens
                                        maxChunkSizeTokens = static_.maxChunkSizeTokens
                                        additionalProperties =
                                            static_.additionalProperties.toMutableMap()
                                    }

                                    /**
                                     * The number of tokens that overlap between chunks. The default
                                     * value is `400`.
                                     *
                                     * Note that the overlap must not exceed half of
                                     * `max_chunk_size_tokens`.
                                     */
                                    fun chunkOverlapTokens(chunkOverlapTokens: Long) =
                                        chunkOverlapTokens(JsonField.of(chunkOverlapTokens))

                                    /**
                                     * Sets [Builder.chunkOverlapTokens] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.chunkOverlapTokens] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun chunkOverlapTokens(chunkOverlapTokens: JsonField<Long>) =
                                        apply {
                                            this.chunkOverlapTokens = chunkOverlapTokens
                                        }

                                    /**
                                     * The maximum number of tokens in each chunk. The default value
                                     * is `800`. The minimum value is `100` and the maximum value is
                                     * `4096`.
                                     */
                                    fun maxChunkSizeTokens(maxChunkSizeTokens: Long) =
                                        maxChunkSizeTokens(JsonField.of(maxChunkSizeTokens))

                                    /**
                                     * Sets [Builder.maxChunkSizeTokens] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.maxChunkSizeTokens] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun maxChunkSizeTokens(maxChunkSizeTokens: JsonField<Long>) =
                                        apply {
                                            this.maxChunkSizeTokens = maxChunkSizeTokens
                                        }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [Static].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .chunkOverlapTokens()
                                     * .maxChunkSizeTokens()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): Static =
                                        Static(
                                            checkRequired("chunkOverlapTokens", chunkOverlapTokens),
                                            checkRequired("maxChunkSizeTokens", maxChunkSizeTokens),
                                            additionalProperties.toImmutable(),
                                        )
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return /* spotless:off */ other is Static && chunkOverlapTokens == other.chunkOverlapTokens && maxChunkSizeTokens == other.maxChunkSizeTokens && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(chunkOverlapTokens, maxChunkSizeTokens, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "Static{chunkOverlapTokens=$chunkOverlapTokens, maxChunkSizeTokens=$maxChunkSizeTokens, additionalProperties=$additionalProperties}"
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is StaticObject && static_ == other.static_ && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(static_, type, additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "StaticObject{static_=$static_, type=$type, additionalProperties=$additionalProperties}"
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is VectorStore && chunkingStrategy == other.chunkingStrategy && fileIds == other.fileIds && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(chunkingStrategy, fileIds, metadata, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "VectorStore{chunkingStrategy=$chunkingStrategy, fileIds=$fileIds, metadata=$metadata, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && vectorStores == other.vectorStores && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, vectorStores, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "FileSearch{vectorStoreIds=$vectorStoreIds, vectorStores=$vectorStores, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ToolResources && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(codeInterpreter, fileSearch, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ToolResources{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Thread && messages == other.messages && metadata == other.metadata && toolResources == other.toolResources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messages, metadata, toolResources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Thread{messages=$messages, metadata=$metadata, toolResources=$toolResources, additionalProperties=$additionalProperties}"
    }

    /**
     * A set of resources that are used by the assistant's tools. The resources are specific to the
     * type of tool. For example, the `code_interpreter` tool requires a list of file IDs, while the
     * `file_search` tool requires a list of vector store IDs.
     */
    @NoAutoDetect
    class ToolResources
    @JsonCreator
    private constructor(
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeInterpreter(): Optional<CodeInterpreter> =
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

        /**
         * Returns the raw JSON value of [codeInterpreter].
         *
         * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

        /**
         * Returns the raw JSON value of [fileSearch].
         *
         * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_search")
        @ExcludeMissing
        fun _fileSearch(): JsonField<FileSearch> = fileSearch

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [ToolResources]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolResources]. */
        class Builder internal constructor() {

            private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
            private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter) =
                codeInterpreter(JsonField.of(codeInterpreter))

            /**
             * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

            /**
             * Sets [Builder.fileSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileSearch(fileSearch: JsonField<FileSearch>) = apply {
                this.fileSearch = fileSearch
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
             * Returns an immutable instance of [ToolResources].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ToolResources =
                ToolResources(codeInterpreter, fileSearch, additionalProperties.toImmutable())
        }

        @NoAutoDetect
        class CodeInterpreter
        @JsonCreator
        private constructor(
            @JsonProperty("file_ids")
            @ExcludeMissing
            private val fileIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * Returns the raw JSON value of [fileIds].
             *
             * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [CodeInterpreter]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CodeInterpreter]. */
            class Builder internal constructor() {

                private var fileIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds.map { it.toMutableList() }
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * Sets [Builder.fileIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileIds] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply {
                    this.fileIds = fileIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [fileIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds =
                        (fileIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("fileIds", it).add(fileId)
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
                 * Returns an immutable instance of [CodeInterpreter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CodeInterpreter && fileIds == other.fileIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CodeInterpreter{fileIds=$fileIds, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class FileSearch
        @JsonCreator
        private constructor(
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            private val vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The ID of the
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this assistant. There can be a maximum of 1 vector store attached to the
             * assistant.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * Returns the raw JSON value of [vectorStoreIds].
             *
             * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [FileSearch]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileSearch]. */
            class Builder internal constructor() {

                private var vectorStoreIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The ID of the
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this assistant. There can be a maximum of 1 vector store attached to
                 * the assistant.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) =
                    vectorStoreIds(JsonField.of(vectorStoreIds))

                /**
                 * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectorStoreIds] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [vectorStoreIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectorStoreIds", it).add(vectorStoreId)
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
                 * Returns an immutable instance of [FileSearch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileSearch{vectorStoreIds=$vectorStoreIds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolResources && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(codeInterpreter, fileSearch, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolResources{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
    }

    @JsonDeserialize(using = Tool.Deserializer::class)
    @JsonSerialize(using = Tool.Serializer::class)
    class Tool
    private constructor(
        private val codeInterpreter: CodeInterpreterTool? = null,
        private val fileSearch: FileSearchTool? = null,
        private val function: FunctionTool? = null,
        private val _json: JsonValue? = null,
    ) {

        fun codeInterpreter(): Optional<CodeInterpreterTool> = Optional.ofNullable(codeInterpreter)

        fun fileSearch(): Optional<FileSearchTool> = Optional.ofNullable(fileSearch)

        fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

        fun isCodeInterpreter(): Boolean = codeInterpreter != null

        fun isFileSearch(): Boolean = fileSearch != null

        fun isFunction(): Boolean = function != null

        fun asCodeInterpreter(): CodeInterpreterTool = codeInterpreter.getOrThrow("codeInterpreter")

        fun asFileSearch(): FileSearchTool = fileSearch.getOrThrow("fileSearch")

        fun asFunction(): FunctionTool = function.getOrThrow("function")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
                fileSearch != null -> visitor.visitFileSearch(fileSearch)
                function != null -> visitor.visitFunction(function)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Tool = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool) {
                        codeInterpreter.validate()
                    }

                    override fun visitFileSearch(fileSearch: FileSearchTool) {
                        fileSearch.validate()
                    }

                    override fun visitFunction(function: FunctionTool) {
                        function.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Tool && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && function == other.function /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch, function) /* spotless:on */

        override fun toString(): String =
            when {
                codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                function != null -> "Tool{function=$function}"
                _json != null -> "Tool{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Tool")
            }

        companion object {

            @JvmStatic
            fun ofCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
                Tool(codeInterpreter = codeInterpreter)

            @JvmStatic fun ofFileSearch(fileSearch: FileSearchTool) = Tool(fileSearch = fileSearch)

            @JvmStatic fun ofFunction(function: FunctionTool) = Tool(function = function)
        }

        /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

            fun visitFileSearch(fileSearch: FileSearchTool): T

            fun visitFunction(function: FunctionTool): T

            /**
             * Maps an unknown variant of [Tool] to a value of type [T].
             *
             * An instance of [Tool] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Tool: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) { it.validate() }
                    ?.let {
                        return Tool(codeInterpreter = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<FileSearchTool>()) { it.validate() }
                    ?.let {
                        return Tool(fileSearch = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<FunctionTool>()) { it.validate() }
                    ?.let {
                        return Tool(function = it, _json = json)
                    }

                return Tool(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Tool>(Tool::class) {

            override fun serialize(
                value: Tool,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                    value.fileSearch != null -> generator.writeObject(value.fileSearch)
                    value.function != null -> generator.writeObject(value.function)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tool")
                }
            }
        }
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): TruncationStrategy = apply {
            if (validated) {
                return@apply
            }

            type()
            lastMessages()
            validated = true
        }

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
                    additionalProperties.toImmutable(),
                )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ThreadCreateAndRunParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ThreadCreateAndRunParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
