// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ResponsesModel
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Response
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Double>,
    private val error: JsonField<ResponseError>,
    private val incompleteDetails: JsonField<IncompleteDetails>,
    private val instructions: JsonField<Instructions>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<ResponsesModel>,
    private val object_: JsonValue,
    private val output: JsonField<List<ResponseOutputItem>>,
    private val parallelToolCalls: JsonField<Boolean>,
    private val temperature: JsonField<Double>,
    private val toolChoice: JsonField<ToolChoice>,
    private val tools: JsonField<List<Tool>>,
    private val topP: JsonField<Double>,
    private val background: JsonField<Boolean>,
    private val conversation: JsonField<Conversation>,
    private val maxOutputTokens: JsonField<Long>,
    private val maxToolCalls: JsonField<Long>,
    private val previousResponseId: JsonField<String>,
    private val prompt: JsonField<ResponsePrompt>,
    private val promptCacheKey: JsonField<String>,
    private val reasoning: JsonField<Reasoning>,
    private val safetyIdentifier: JsonField<String>,
    private val serviceTier: JsonField<ServiceTier>,
    private val status: JsonField<ResponseStatus>,
    private val text: JsonField<ResponseTextConfig>,
    private val topLogprobs: JsonField<Long>,
    private val truncation: JsonField<Truncation>,
    private val usage: JsonField<ResponseUsage>,
    private val user: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ResponseError> = JsonMissing.of(),
        @JsonProperty("incomplete_details")
        @ExcludeMissing
        incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<Instructions> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<ResponsesModel> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<List<ResponseOutputItem>> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("conversation")
        @ExcludeMissing
        conversation: JsonField<Conversation> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_tool_calls")
        @ExcludeMissing
        maxToolCalls: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        previousResponseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("prompt")
        @ExcludeMissing
        prompt: JsonField<ResponsePrompt> = JsonMissing.of(),
        @JsonProperty("prompt_cache_key")
        @ExcludeMissing
        promptCacheKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        reasoning: JsonField<Reasoning> = JsonMissing.of(),
        @JsonProperty("safety_identifier")
        @ExcludeMissing
        safetyIdentifier: JsonField<String> = JsonMissing.of(),
        @JsonProperty("service_tier")
        @ExcludeMissing
        serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<ResponseStatus> = JsonMissing.of(),
        @JsonProperty("text")
        @ExcludeMissing
        text: JsonField<ResponseTextConfig> = JsonMissing.of(),
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        topLogprobs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("truncation")
        @ExcludeMissing
        truncation: JsonField<Truncation> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<ResponseUsage> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        error,
        incompleteDetails,
        instructions,
        metadata,
        model,
        object_,
        output,
        parallelToolCalls,
        temperature,
        toolChoice,
        tools,
        topP,
        background,
        conversation,
        maxOutputTokens,
        maxToolCalls,
        previousResponseId,
        prompt,
        promptCacheKey,
        reasoning,
        safetyIdentifier,
        serviceTier,
        status,
        text,
        topLogprobs,
        truncation,
        usage,
        user,
        mutableMapOf(),
    )

    /**
     * Unique identifier for this Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) of when this Response was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Double = createdAt.getRequired("created_at")

    /**
     * An error object returned when the model fails to generate a Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<ResponseError> = error.getOptional("error")

    /**
     * Details about why the response is incomplete.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun incompleteDetails(): Optional<IncompleteDetails> =
        incompleteDetails.getOptional("incomplete_details")

    /**
     * A system (or developer) message inserted into the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<Instructions> = instructions.getOptional("instructions")

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
     * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): ResponsesModel = model.getRequired("model")

    /**
     * The object type of this resource - always set to `response`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * An array of content items generated by the model.
     * - The length and order of items in the `output` array is dependent on the model's response.
     * - Rather than accessing the first item in the `output` array and assuming it's an `assistant`
     *   message with the content generated by the model, you might consider using the `output_text`
     *   property where supported in SDKs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun output(): List<ResponseOutputItem> = output.getRequired("output")

    /**
     * Whether to allow the model to run tool calls in parallel.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun parallelToolCalls(): Boolean = parallelToolCalls.getRequired("parallel_tool_calls")

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = temperature.getOptional("temperature")

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolChoice(): ToolChoice = toolChoice.getRequired("tool_choice")

    /**
     * An array of tools the model may call while generating a response. You can specify which tool
     * to use by setting the `tool_choice` parameter.
     *
     * We support the following categories of tools:
     * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's capabilities,
     *   like [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more about
     *   [built-in tools](https://platform.openai.com/docs/guides/tools).
     * - **MCP Tools**: Integrations with third-party systems via custom MCP servers or predefined
     *   connectors such as Google Drive and SharePoint. Learn more about
     *   [MCP Tools](https://platform.openai.com/docs/guides/tools-connectors-mcp).
     * - **Function calls (custom tools)**: Functions that are defined by you, enabling the model to
     *   call your own code with strongly typed arguments and outputs. Learn more about
     *   [function calling](https://platform.openai.com/docs/guides/function-calling). You can also
     *   use custom tools to call your own code.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tools(): List<Tool> = tools.getRequired("tools")

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or `temperature` but not both.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topP(): Optional<Double> = topP.getOptional("top_p")

    /**
     * Whether to run the model response in the background.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<Boolean> = background.getOptional("background")

    /**
     * The conversation that this response belongs to. Input items and output items from this
     * response are automatically added to this conversation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversation(): Optional<Conversation> = conversation.getOptional("conversation")

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxOutputTokens(): Optional<Long> = maxOutputTokens.getOptional("max_output_tokens")

    /**
     * The maximum number of total calls to built-in tools that can be processed in a response. This
     * maximum number applies across all built-in tool calls, not per individual tool. Any further
     * attempts to call a tool by the model will be ignored.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxToolCalls(): Optional<Long> = maxToolCalls.getOptional("max_tool_calls")

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot be
     * used in conjunction with `conversation`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousResponseId(): Optional<String> =
        previousResponseId.getOptional("previous_response_id")

    /**
     * Reference to a prompt template and its variables.
     * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<ResponsePrompt> = prompt.getOptional("prompt")

    /**
     * Used by OpenAI to cache responses for similar requests to optimize your cache hit rates.
     * Replaces the `user` field.
     * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheKey(): Optional<String> = promptCacheKey.getOptional("prompt_cache_key")

    /**
     * **gpt-5 and o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoning(): Optional<Reasoning> = reasoning.getOptional("reasoning")

    /**
     * A stable identifier used to help detect users of your application that may be violating
     * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user. We
     * recommend hashing their username or email address, in order to avoid sending us any
     * identifying information.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun safetyIdentifier(): Optional<String> = safetyIdentifier.getOptional("safety_identifier")

    /**
     * Specifies the processing type used for serving the request.
     * - If set to 'auto', then the request will be processed with the service tier configured in
     *   the Project settings. Unless otherwise configured, the Project will use 'default'.
     * - If set to 'default', then the request will be processed with the standard pricing and
     *   performance for the selected model.
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
     *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
     *   processed with the corresponding service tier.
     * - When not set, the default behavior is 'auto'.
     *
     *   When the `service_tier` parameter is set, the response body will include the `service_tier`
     *   value based on the processing mode actually used to serve the request. This response value
     *   may be different from the value set in the parameter.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

    /**
     * The status of the response generation. One of `completed`, `failed`, `in_progress`,
     * `cancelled`, `queued`, or `incomplete`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<ResponseStatus> = status.getOptional("status")

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<ResponseTextConfig> = text.getOptional("text")

    /**
     * An integer between 0 and 20 specifying the number of most likely tokens to return at each
     * token position, each with an associated log probability.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topLogprobs(): Optional<Long> = topLogprobs.getOptional("top_logprobs")

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the input to this Response exceeds the model's context window size, the model
     *   will truncate the response to fit the context window by dropping items from the beginning
     *   of the conversation.
     * - `disabled` (default): If the input size will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncation(): Optional<Truncation> = truncation.getOptional("truncation")

    /**
     * Represents token usage details including input tokens, output tokens, a breakdown of output
     * tokens, and the total tokens used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<ResponseUsage> = usage.getOptional("usage")

    /**
     * This field is being replaced by `safety_identifier` and `prompt_cache_key`. Use
     * `prompt_cache_key` instead to maintain caching optimizations. A stable identifier for your
     * end-users. Used to boost cache hit rates by better bucketing similar requests and to help
     * OpenAI detect and prevent abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated") fun user(): Optional<String> = user.getOptional("user")

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
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Double> = createdAt

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ResponseError> = error

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
    fun _instructions(): JsonField<Instructions> = instructions

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
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ResponsesModel> = model

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<List<ResponseOutputItem>> = output

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
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_choice")
    @ExcludeMissing
    fun _toolChoice(): JsonField<ToolChoice> = toolChoice

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
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("background") @ExcludeMissing fun _background(): JsonField<Boolean> = background

    /**
     * Returns the raw JSON value of [conversation].
     *
     * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversation")
    @ExcludeMissing
    fun _conversation(): JsonField<Conversation> = conversation

    /**
     * Returns the raw JSON value of [maxOutputTokens].
     *
     * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

    /**
     * Returns the raw JSON value of [maxToolCalls].
     *
     * Unlike [maxToolCalls], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_tool_calls")
    @ExcludeMissing
    fun _maxToolCalls(): JsonField<Long> = maxToolCalls

    /**
     * Returns the raw JSON value of [previousResponseId].
     *
     * Unlike [previousResponseId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("previous_response_id")
    @ExcludeMissing
    fun _previousResponseId(): JsonField<String> = previousResponseId

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<ResponsePrompt> = prompt

    /**
     * Returns the raw JSON value of [promptCacheKey].
     *
     * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prompt_cache_key")
    @ExcludeMissing
    fun _promptCacheKey(): JsonField<String> = promptCacheKey

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reasoning") @ExcludeMissing fun _reasoning(): JsonField<Reasoning> = reasoning

    /**
     * Returns the raw JSON value of [safetyIdentifier].
     *
     * Unlike [safetyIdentifier], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("safety_identifier")
    @ExcludeMissing
    fun _safetyIdentifier(): JsonField<String> = safetyIdentifier

    /**
     * Returns the raw JSON value of [serviceTier].
     *
     * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("service_tier")
    @ExcludeMissing
    fun _serviceTier(): JsonField<ServiceTier> = serviceTier

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<ResponseStatus> = status

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<ResponseTextConfig> = text

    /**
     * Returns the raw JSON value of [topLogprobs].
     *
     * Unlike [topLogprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_logprobs") @ExcludeMissing fun _topLogprobs(): JsonField<Long> = topLogprobs

    /**
     * Returns the raw JSON value of [truncation].
     *
     * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("truncation")
    @ExcludeMissing
    fun _truncation(): JsonField<Truncation> = truncation

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<ResponseUsage> = usage

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated")
    @JsonProperty("user")
    @ExcludeMissing
    fun _user(): JsonField<String> = user

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
         * Returns a mutable builder for constructing an instance of [Response].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .error()
         * .incompleteDetails()
         * .instructions()
         * .metadata()
         * .model()
         * .output()
         * .parallelToolCalls()
         * .temperature()
         * .toolChoice()
         * .tools()
         * .topP()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Response]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Double>? = null
        private var error: JsonField<ResponseError>? = null
        private var incompleteDetails: JsonField<IncompleteDetails>? = null
        private var instructions: JsonField<Instructions>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<ResponsesModel>? = null
        private var object_: JsonValue = JsonValue.from("response")
        private var output: JsonField<MutableList<ResponseOutputItem>>? = null
        private var parallelToolCalls: JsonField<Boolean>? = null
        private var temperature: JsonField<Double>? = null
        private var toolChoice: JsonField<ToolChoice>? = null
        private var tools: JsonField<MutableList<Tool>>? = null
        private var topP: JsonField<Double>? = null
        private var background: JsonField<Boolean> = JsonMissing.of()
        private var conversation: JsonField<Conversation> = JsonMissing.of()
        private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
        private var maxToolCalls: JsonField<Long> = JsonMissing.of()
        private var previousResponseId: JsonField<String> = JsonMissing.of()
        private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
        private var promptCacheKey: JsonField<String> = JsonMissing.of()
        private var reasoning: JsonField<Reasoning> = JsonMissing.of()
        private var safetyIdentifier: JsonField<String> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var status: JsonField<ResponseStatus> = JsonMissing.of()
        private var text: JsonField<ResponseTextConfig> = JsonMissing.of()
        private var topLogprobs: JsonField<Long> = JsonMissing.of()
        private var truncation: JsonField<Truncation> = JsonMissing.of()
        private var usage: JsonField<ResponseUsage> = JsonMissing.of()
        private var user: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(response: Response) = apply {
            id = response.id
            createdAt = response.createdAt
            error = response.error
            incompleteDetails = response.incompleteDetails
            instructions = response.instructions
            metadata = response.metadata
            model = response.model
            object_ = response.object_
            output = response.output.map { it.toMutableList() }
            parallelToolCalls = response.parallelToolCalls
            temperature = response.temperature
            toolChoice = response.toolChoice
            tools = response.tools.map { it.toMutableList() }
            topP = response.topP
            background = response.background
            conversation = response.conversation
            maxOutputTokens = response.maxOutputTokens
            maxToolCalls = response.maxToolCalls
            previousResponseId = response.previousResponseId
            prompt = response.prompt
            promptCacheKey = response.promptCacheKey
            reasoning = response.reasoning
            safetyIdentifier = response.safetyIdentifier
            serviceTier = response.serviceTier
            status = response.status
            text = response.text
            topLogprobs = response.topLogprobs
            truncation = response.truncation
            usage = response.usage
            user = response.user
            additionalProperties = response.additionalProperties.toMutableMap()
        }

        /** Unique identifier for this Response. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) of when this Response was created. */
        fun createdAt(createdAt: Double) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<Double>) = apply { this.createdAt = createdAt }

        /** An error object returned when the model fails to generate a Response. */
        fun error(error: ResponseError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ResponseError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ResponseError] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun error(error: JsonField<ResponseError>) = apply { this.error = error }

        /** Details about why the response is incomplete. */
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
         * A system (or developer) message inserted into the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(instructions: Instructions?) =
            instructions(JsonField.ofNullable(instructions))

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<Instructions>) =
            instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [Instructions] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun instructions(instructions: JsonField<Instructions>) = apply {
            this.instructions = instructions
        }

        /** Alias for calling [instructions] with `Instructions.ofString(string)`. */
        fun instructions(string: String) = instructions(Instructions.ofString(string))

        /** Alias for calling [instructions] with `Instructions.ofInputItemList(inputItemList)`. */
        fun instructionsOfInputItemList(inputItemList: List<ResponseInputItem>) =
            instructions(Instructions.ofInputItemList(inputItemList))

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
         * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: ResponsesModel) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [ResponsesModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: JsonField<ResponsesModel>) = apply { this.model = model }

        /** Alias for calling [model] with `ResponsesModel.ofString(string)`. */
        fun model(string: String) = model(ResponsesModel.ofString(string))

        /** Alias for calling [model] with `ResponsesModel.ofChat(chat)`. */
        fun model(chat: ChatModel) = model(ResponsesModel.ofChat(chat))

        /** Alias for calling [model] with `ResponsesModel.ofOnly(only)`. */
        fun model(only: ResponsesModel.ResponsesOnlyModel) = model(ResponsesModel.ofOnly(only))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * An array of content items generated by the model.
         * - The length and order of items in the `output` array is dependent on the model's
         *   response.
         * - Rather than accessing the first item in the `output` array and assuming it's an
         *   `assistant` message with the content generated by the model, you might consider using
         *   the `output_text` property where supported in SDKs.
         */
        fun output(output: List<ResponseOutputItem>) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed `List<ResponseOutputItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun output(output: JsonField<List<ResponseOutputItem>>) = apply {
            this.output = output.map { it.toMutableList() }
        }

        /**
         * Adds a single [ResponseOutputItem] to [Builder.output].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOutput(output: ResponseOutputItem) = apply {
            this.output =
                (this.output ?: JsonField.of(mutableListOf())).also {
                    checkKnown("output", it).add(output)
                }
        }

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMessage(message)`. */
        fun addOutput(message: ResponseOutputMessage) =
            addOutput(ResponseOutputItem.ofMessage(message))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addOutput(fileSearchCall: ResponseFileSearchToolCall) =
            addOutput(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofFunctionCall(functionCall)`. */
        fun addOutput(functionCall: ResponseFunctionToolCall) =
            addOutput(ResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addOutput(webSearchCall: ResponseFunctionWebSearch) =
            addOutput(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
        fun addOutput(computerCall: ResponseComputerToolCall) =
            addOutput(ResponseOutputItem.ofComputerCall(computerCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofReasoning(reasoning)`. */
        fun addOutput(reasoning: ResponseReasoningItem) =
            addOutput(ResponseOutputItem.ofReasoning(reasoning))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addOutput(imageGenerationCall: ResponseOutputItem.ImageGenerationCall) =
            addOutput(ResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addOutput(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            addOutput(ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addOutput(localShellCall: ResponseOutputItem.LocalShellCall) =
            addOutput(ResponseOutputItem.ofLocalShellCall(localShellCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMcpCall(mcpCall)`. */
        fun addOutput(mcpCall: ResponseOutputItem.McpCall) =
            addOutput(ResponseOutputItem.ofMcpCall(mcpCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMcpListTools(mcpListTools)`. */
        fun addOutput(mcpListTools: ResponseOutputItem.McpListTools) =
            addOutput(ResponseOutputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addOutput(mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest) =
            addOutput(ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addOutput(customToolCall: ResponseCustomToolCall) =
            addOutput(ResponseOutputItem.ofCustomToolCall(customToolCall))

        /** Whether to allow the model to run tool calls in parallel. */
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
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
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
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: ToolChoice) = toolChoice(JsonField.of(toolChoice))

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { this.toolChoice = toolChoice }

        /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
        fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

        /** Alias for calling [toolChoice] with `ToolChoice.ofAllowed(allowed)`. */
        fun toolChoice(allowed: ToolChoiceAllowed) = toolChoice(ToolChoice.ofAllowed(allowed))

        /** Alias for calling [toolChoice] with `ToolChoice.ofTypes(types)`. */
        fun toolChoice(types: ToolChoiceTypes) = toolChoice(ToolChoice.ofTypes(types))

        /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
        fun toolChoice(function: ToolChoiceFunction) = toolChoice(ToolChoice.ofFunction(function))

        /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
        fun toolChoice(mcp: ToolChoiceMcp) = toolChoice(ToolChoice.ofMcp(mcp))

        /** Alias for calling [toolChoice] with `ToolChoice.ofCustom(custom)`. */
        fun toolChoice(custom: ToolChoiceCustom) = toolChoice(ToolChoice.ofCustom(custom))

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * We support the following categories of tools:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **MCP Tools**: Integrations with third-party systems via custom MCP servers or
         *   predefined connectors such as Google Drive and SharePoint. Learn more about
         *   [MCP Tools](https://platform.openai.com/docs/guides/tools-connectors-mcp).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code with strongly typed arguments and outputs. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling). You can
         *   also use custom tools to call your own code.
         */
        fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

        /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = addTool(Tool.ofFileSearch(fileSearch))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) =
            addTool(FileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

        /** Alias for calling [addTool] with `Tool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: ComputerTool) =
            addTool(Tool.ofComputerUsePreview(computerUsePreview))

        /** Alias for calling [addTool] with `Tool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: WebSearchTool) = addTool(Tool.ofWebSearch(webSearch))

        /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
        fun addTool(mcp: Tool.Mcp) = addTool(Tool.ofMcp(mcp))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) =
            addTool(Tool.Mcp.builder().serverLabel(serverLabel).build())

        /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: Tool.CodeInterpreter) =
            addTool(Tool.ofCodeInterpreter(codeInterpreter))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: Tool.CodeInterpreter.Container) =
            addTool(Tool.CodeInterpreter.builder().container(container).build())

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) =
            addCodeInterpreterTool(Tool.CodeInterpreter.Container.ofString(string))

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) =
            addCodeInterpreterTool(
                Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)
            )

        /** Alias for calling [addTool] with `Tool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: Tool.ImageGeneration) =
            addTool(Tool.ofImageGeneration(imageGeneration))

        /** Alias for calling [addTool] with `Tool.ofLocalShell()`. */
        fun addToolLocalShell() = addTool(Tool.ofLocalShell())

        /** Alias for calling [addTool] with `Tool.ofCustom(custom)`. */
        fun addTool(custom: CustomTool) = addTool(Tool.ofCustom(custom))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * CustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = addTool(CustomTool.builder().name(name).build())

        /** Alias for calling [addTool] with `Tool.ofWebSearchPreview(webSearchPreview)`. */
        fun addTool(webSearchPreview: WebSearchPreviewTool) =
            addTool(Tool.ofWebSearchPreview(webSearchPreview))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
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
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

        /**
         * Whether to run the model response in the background.
         * [Learn more](https://platform.openai.com/docs/guides/background).
         */
        fun background(background: Boolean?) = background(JsonField.ofNullable(background))

        /**
         * Alias for [Builder.background].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun background(background: Boolean) = background(background as Boolean?)

        /** Alias for calling [Builder.background] with `background.orElse(null)`. */
        fun background(background: Optional<Boolean>) = background(background.getOrNull())

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun background(background: JsonField<Boolean>) = apply { this.background = background }

        /**
         * The conversation that this response belongs to. Input items and output items from this
         * response are automatically added to this conversation.
         */
        fun conversation(conversation: Conversation?) =
            conversation(JsonField.ofNullable(conversation))

        /** Alias for calling [Builder.conversation] with `conversation.orElse(null)`. */
        fun conversation(conversation: Optional<Conversation>) =
            conversation(conversation.getOrNull())

        /**
         * Sets [Builder.conversation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversation] with a well-typed [Conversation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun conversation(conversation: JsonField<Conversation>) = apply {
            this.conversation = conversation
        }

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Long?) =
            maxOutputTokens(JsonField.ofNullable(maxOutputTokens))

        /**
         * Alias for [Builder.maxOutputTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

        /** Alias for calling [Builder.maxOutputTokens] with `maxOutputTokens.orElse(null)`. */
        fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
            maxOutputTokens(maxOutputTokens.getOrNull())

        /**
         * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxOutputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
            this.maxOutputTokens = maxOutputTokens
        }

        /**
         * The maximum number of total calls to built-in tools that can be processed in a response.
         * This maximum number applies across all built-in tool calls, not per individual tool. Any
         * further attempts to call a tool by the model will be ignored.
         */
        fun maxToolCalls(maxToolCalls: Long?) = maxToolCalls(JsonField.ofNullable(maxToolCalls))

        /**
         * Alias for [Builder.maxToolCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxToolCalls(maxToolCalls: Long) = maxToolCalls(maxToolCalls as Long?)

        /** Alias for calling [Builder.maxToolCalls] with `maxToolCalls.orElse(null)`. */
        fun maxToolCalls(maxToolCalls: Optional<Long>) = maxToolCalls(maxToolCalls.getOrNull())

        /**
         * Sets [Builder.maxToolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxToolCalls] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxToolCalls(maxToolCalls: JsonField<Long>) = apply { this.maxToolCalls = maxToolCalls }

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot
         * be used in conjunction with `conversation`.
         */
        fun previousResponseId(previousResponseId: String?) =
            previousResponseId(JsonField.ofNullable(previousResponseId))

        /**
         * Alias for calling [Builder.previousResponseId] with `previousResponseId.orElse(null)`.
         */
        fun previousResponseId(previousResponseId: Optional<String>) =
            previousResponseId(previousResponseId.getOrNull())

        /**
         * Sets [Builder.previousResponseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousResponseId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            this.previousResponseId = previousResponseId
        }

        /**
         * Reference to a prompt template and its variables.
         * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
         */
        fun prompt(prompt: ResponsePrompt?) = prompt(JsonField.ofNullable(prompt))

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<ResponsePrompt>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [ResponsePrompt] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun prompt(prompt: JsonField<ResponsePrompt>) = apply { this.prompt = prompt }

        /**
         * Used by OpenAI to cache responses for similar requests to optimize your cache hit rates.
         * Replaces the `user` field.
         * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
         */
        fun promptCacheKey(promptCacheKey: String) = promptCacheKey(JsonField.of(promptCacheKey))

        /**
         * Sets [Builder.promptCacheKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheKey] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
            this.promptCacheKey = promptCacheKey
        }

        /**
         * **gpt-5 and o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Reasoning?) = reasoning(JsonField.ofNullable(reasoning))

        /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

        /**
         * A stable identifier used to help detect users of your application that may be violating
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user.
         * We recommend hashing their username or email address, in order to avoid sending us any
         * identifying information.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         */
        fun safetyIdentifier(safetyIdentifier: String) =
            safetyIdentifier(JsonField.of(safetyIdentifier))

        /**
         * Sets [Builder.safetyIdentifier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.safetyIdentifier] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
            this.safetyIdentifier = safetyIdentifier
        }

        /**
         * Specifies the processing type used for serving the request.
         * - If set to 'auto', then the request will be processed with the service tier configured
         *   in the Project settings. Unless otherwise configured, the Project will use 'default'.
         * - If set to 'default', then the request will be processed with the standard pricing and
         *   performance for the selected model.
         * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
         *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
         *   processed with the corresponding service tier.
         * - When not set, the default behavior is 'auto'.
         *
         *   When the `service_tier` parameter is set, the response body will include the
         *   `service_tier` value based on the processing mode actually used to serve the request.
         *   This response value may be different from the value set in the parameter.
         */
        fun serviceTier(serviceTier: ServiceTier?) = serviceTier(JsonField.ofNullable(serviceTier))

        /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
        fun serviceTier(serviceTier: Optional<ServiceTier>) = serviceTier(serviceTier.getOrNull())

        /**
         * Sets [Builder.serviceTier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceTier] with a well-typed [ServiceTier] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /**
         * The status of the response generation. One of `completed`, `failed`, `in_progress`,
         * `cancelled`, `queued`, or `incomplete`.
         */
        fun status(status: ResponseStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [ResponseStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<ResponseStatus>) = apply { this.status = status }

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: ResponseTextConfig) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [ResponseTextConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<ResponseTextConfig>) = apply { this.text = text }

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability.
         */
        fun topLogprobs(topLogprobs: Long?) = topLogprobs(JsonField.ofNullable(topLogprobs))

        /**
         * Alias for [Builder.topLogprobs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun topLogprobs(topLogprobs: Long) = topLogprobs(topLogprobs as Long?)

        /** Alias for calling [Builder.topLogprobs] with `topLogprobs.orElse(null)`. */
        fun topLogprobs(topLogprobs: Optional<Long>) = topLogprobs(topLogprobs.getOrNull())

        /**
         * Sets [Builder.topLogprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topLogprobs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun topLogprobs(topLogprobs: JsonField<Long>) = apply { this.topLogprobs = topLogprobs }

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the input to this Response exceeds the model's context window size, the
         *   model will truncate the response to fit the context window by dropping items from the
         *   beginning of the conversation.
         * - `disabled` (default): If the input size will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: Truncation?) = truncation(JsonField.ofNullable(truncation))

        /** Alias for calling [Builder.truncation] with `truncation.orElse(null)`. */
        fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [Truncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun truncation(truncation: JsonField<Truncation>) = apply { this.truncation = truncation }

        /**
         * Represents token usage details including input tokens, output tokens, a breakdown of
         * output tokens, and the total tokens used.
         */
        fun usage(usage: ResponseUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [ResponseUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<ResponseUsage>) = apply { this.usage = usage }

        /**
         * This field is being replaced by `safety_identifier` and `prompt_cache_key`. Use
         * `prompt_cache_key` instead to maintain caching optimizations. A stable identifier for
         * your end-users. Used to boost cache hit rates by better bucketing similar requests and to
         * help OpenAI detect and prevent abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         */
        @Deprecated("deprecated") fun user(user: String) = user(JsonField.of(user))

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        @Deprecated("deprecated") fun user(user: JsonField<String>) = apply { this.user = user }

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
         * Returns an immutable instance of [Response].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .error()
         * .incompleteDetails()
         * .instructions()
         * .metadata()
         * .model()
         * .output()
         * .parallelToolCalls()
         * .temperature()
         * .toolChoice()
         * .tools()
         * .topP()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Response =
            Response(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("error", error),
                checkRequired("incompleteDetails", incompleteDetails),
                checkRequired("instructions", instructions),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                object_,
                checkRequired("output", output).map { it.toImmutable() },
                checkRequired("parallelToolCalls", parallelToolCalls),
                checkRequired("temperature", temperature),
                checkRequired("toolChoice", toolChoice),
                checkRequired("tools", tools).map { it.toImmutable() },
                checkRequired("topP", topP),
                background,
                conversation,
                maxOutputTokens,
                maxToolCalls,
                previousResponseId,
                prompt,
                promptCacheKey,
                reasoning,
                safetyIdentifier,
                serviceTier,
                status,
                text,
                topLogprobs,
                truncation,
                usage,
                user,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Response = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        error().ifPresent { it.validate() }
        incompleteDetails().ifPresent { it.validate() }
        instructions().ifPresent { it.validate() }
        metadata().ifPresent { it.validate() }
        model().validate()
        _object_().let {
            if (it != JsonValue.from("response")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        output().forEach { it.validate() }
        parallelToolCalls()
        temperature()
        toolChoice().validate()
        tools().forEach { it.validate() }
        topP()
        background()
        conversation().ifPresent { it.validate() }
        maxOutputTokens()
        maxToolCalls()
        previousResponseId()
        prompt().ifPresent { it.validate() }
        promptCacheKey()
        reasoning().ifPresent { it.validate() }
        safetyIdentifier()
        serviceTier().ifPresent { it.validate() }
        status().ifPresent { it.validate() }
        text().ifPresent { it.validate() }
        topLogprobs()
        truncation().ifPresent { it.validate() }
        usage().ifPresent { it.validate() }
        user()
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
            (incompleteDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (instructions.asKnown().getOrNull()?.validity() ?: 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (model.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("response")) 1 else 0 } +
            (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (topP.asKnown().isPresent) 1 else 0) +
            (if (background.asKnown().isPresent) 1 else 0) +
            (conversation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
            (if (maxToolCalls.asKnown().isPresent) 1 else 0) +
            (if (previousResponseId.asKnown().isPresent) 1 else 0) +
            (prompt.asKnown().getOrNull()?.validity() ?: 0) +
            (if (promptCacheKey.asKnown().isPresent) 1 else 0) +
            (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
            (if (safetyIdentifier.asKnown().isPresent) 1 else 0) +
            (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (if (topLogprobs.asKnown().isPresent) 1 else 0) +
            (truncation.asKnown().getOrNull()?.validity() ?: 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (if (user.asKnown().isPresent) 1 else 0)

    /** Details about why the response is incomplete. */
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
         * The reason why the response is incomplete.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reason(): Optional<Reason> = reason.getOptional("reason")

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

            /** The reason why the response is incomplete. */
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

            reason().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (reason.asKnown().getOrNull()?.validity() ?: 0)

        /** The reason why the response is incomplete. */
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

                @JvmField val MAX_OUTPUT_TOKENS = of("max_output_tokens")

                @JvmField val CONTENT_FILTER = of("content_filter")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            /** An enum containing [Reason]'s known values. */
            enum class Known {
                MAX_OUTPUT_TOKENS,
                CONTENT_FILTER,
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
                MAX_OUTPUT_TOKENS,
                CONTENT_FILTER,
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
                    MAX_OUTPUT_TOKENS -> Value.MAX_OUTPUT_TOKENS
                    CONTENT_FILTER -> Value.CONTENT_FILTER
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
                    MAX_OUTPUT_TOKENS -> Known.MAX_OUTPUT_TOKENS
                    CONTENT_FILTER -> Known.CONTENT_FILTER
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

            private var validated: Boolean = false

            fun validate(): Reason = apply {
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

                return other is Reason && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IncompleteDetails &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(reason, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IncompleteDetails{reason=$reason, additionalProperties=$additionalProperties}"
    }

    /**
     * A system (or developer) message inserted into the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     */
    @JsonDeserialize(using = Instructions.Deserializer::class)
    @JsonSerialize(using = Instructions.Serializer::class)
    class Instructions
    private constructor(
        private val string: String? = null,
        private val inputItemList: List<ResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `developer` role. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** A list of one or many input items to the model, containing different content types. */
        fun inputItemList(): Optional<List<ResponseInputItem>> = Optional.ofNullable(inputItemList)

        fun isString(): Boolean = string != null

        fun isInputItemList(): Boolean = inputItemList != null

        /** A text input to the model, equivalent to a text input with the `developer` role. */
        fun asString(): String = string.getOrThrow("string")

        /** A list of one or many input items to the model, containing different content types. */
        fun asInputItemList(): List<ResponseInputItem> = inputItemList.getOrThrow("inputItemList")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                inputItemList != null -> visitor.visitInputItemList(inputItemList)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Instructions = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitInputItemList(inputItemList: List<ResponseInputItem>) {
                        inputItemList.forEach { it.validate() }
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
                    override fun visitString(string: String) = 1

                    override fun visitInputItemList(inputItemList: List<ResponseInputItem>) =
                        inputItemList.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Instructions &&
                string == other.string &&
                inputItemList == other.inputItemList
        }

        override fun hashCode(): Int = Objects.hash(string, inputItemList)

        override fun toString(): String =
            when {
                string != null -> "Instructions{string=$string}"
                inputItemList != null -> "Instructions{inputItemList=$inputItemList}"
                _json != null -> "Instructions{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Instructions")
            }

        companion object {

            /** A text input to the model, equivalent to a text input with the `developer` role. */
            @JvmStatic fun ofString(string: String) = Instructions(string = string)

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            @JvmStatic
            fun ofInputItemList(inputItemList: List<ResponseInputItem>) =
                Instructions(inputItemList = inputItemList.toImmutable())
        }

        /**
         * An interface that defines how to map each variant of [Instructions] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** A text input to the model, equivalent to a text input with the `developer` role. */
            fun visitString(string: String): T

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun visitInputItemList(inputItemList: List<ResponseInputItem>): T

            /**
             * Maps an unknown variant of [Instructions] to a value of type [T].
             *
             * An instance of [Instructions] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Instructions: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Instructions>(Instructions::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Instructions {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Instructions(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<ResponseInputItem>>())?.let {
                                Instructions(inputItemList = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Instructions(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Instructions>(Instructions::class) {

            override fun serialize(
                value: Instructions,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.inputItemList != null -> generator.writeObject(value.inputItemList)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Instructions")
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

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val options: ToolChoiceOptions? = null,
        private val allowed: ToolChoiceAllowed? = null,
        private val types: ToolChoiceTypes? = null,
        private val function: ToolChoiceFunction? = null,
        private val mcp: ToolChoiceMcp? = null,
        private val custom: ToolChoiceCustom? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        fun options(): Optional<ToolChoiceOptions> = Optional.ofNullable(options)

        /** Constrains the tools available to the model to a pre-defined set. */
        fun allowed(): Optional<ToolChoiceAllowed> = Optional.ofNullable(allowed)

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun types(): Optional<ToolChoiceTypes> = Optional.ofNullable(types)

        /** Use this option to force the model to call a specific function. */
        fun function(): Optional<ToolChoiceFunction> = Optional.ofNullable(function)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun mcp(): Optional<ToolChoiceMcp> = Optional.ofNullable(mcp)

        /** Use this option to force the model to call a specific custom tool. */
        fun custom(): Optional<ToolChoiceCustom> = Optional.ofNullable(custom)

        fun isOptions(): Boolean = options != null

        fun isAllowed(): Boolean = allowed != null

        fun isTypes(): Boolean = types != null

        fun isFunction(): Boolean = function != null

        fun isMcp(): Boolean = mcp != null

        fun isCustom(): Boolean = custom != null

        /**
         * Controls which (if any) tool is called by the model.
         *
         * `none` means the model will not call any tool and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling one or more
         * tools.
         *
         * `required` means the model must call one or more tools.
         */
        fun asOptions(): ToolChoiceOptions = options.getOrThrow("options")

        /** Constrains the tools available to the model to a pre-defined set. */
        fun asAllowed(): ToolChoiceAllowed = allowed.getOrThrow("allowed")

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asTypes(): ToolChoiceTypes = types.getOrThrow("types")

        /** Use this option to force the model to call a specific function. */
        fun asFunction(): ToolChoiceFunction = function.getOrThrow("function")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asMcp(): ToolChoiceMcp = mcp.getOrThrow("mcp")

        /** Use this option to force the model to call a specific custom tool. */
        fun asCustom(): ToolChoiceCustom = custom.getOrThrow("custom")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                options != null -> visitor.visitOptions(options)
                allowed != null -> visitor.visitAllowed(allowed)
                types != null -> visitor.visitTypes(types)
                function != null -> visitor.visitFunction(function)
                mcp != null -> visitor.visitMcp(mcp)
                custom != null -> visitor.visitCustom(custom)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOptions(options: ToolChoiceOptions) {
                        options.validate()
                    }

                    override fun visitAllowed(allowed: ToolChoiceAllowed) {
                        allowed.validate()
                    }

                    override fun visitTypes(types: ToolChoiceTypes) {
                        types.validate()
                    }

                    override fun visitFunction(function: ToolChoiceFunction) {
                        function.validate()
                    }

                    override fun visitMcp(mcp: ToolChoiceMcp) {
                        mcp.validate()
                    }

                    override fun visitCustom(custom: ToolChoiceCustom) {
                        custom.validate()
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
                    override fun visitOptions(options: ToolChoiceOptions) = options.validity()

                    override fun visitAllowed(allowed: ToolChoiceAllowed) = allowed.validity()

                    override fun visitTypes(types: ToolChoiceTypes) = types.validity()

                    override fun visitFunction(function: ToolChoiceFunction) = function.validity()

                    override fun visitMcp(mcp: ToolChoiceMcp) = mcp.validity()

                    override fun visitCustom(custom: ToolChoiceCustom) = custom.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                options == other.options &&
                allowed == other.allowed &&
                types == other.types &&
                function == other.function &&
                mcp == other.mcp &&
                custom == other.custom
        }

        override fun hashCode(): Int = Objects.hash(options, allowed, types, function, mcp, custom)

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
                allowed != null -> "ToolChoice{allowed=$allowed}"
                types != null -> "ToolChoice{types=$types}"
                function != null -> "ToolChoice{function=$function}"
                mcp != null -> "ToolChoice{mcp=$mcp}"
                custom != null -> "ToolChoice{custom=$custom}"
                _json != null -> "ToolChoice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ToolChoice")
            }

        companion object {

            /**
             * Controls which (if any) tool is called by the model.
             *
             * `none` means the model will not call any tool and instead generates a message.
             *
             * `auto` means the model can pick between generating a message or calling one or more
             * tools.
             *
             * `required` means the model must call one or more tools.
             */
            @JvmStatic fun ofOptions(options: ToolChoiceOptions) = ToolChoice(options = options)

            /** Constrains the tools available to the model to a pre-defined set. */
            @JvmStatic fun ofAllowed(allowed: ToolChoiceAllowed) = ToolChoice(allowed = allowed)

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            @JvmStatic fun ofTypes(types: ToolChoiceTypes) = ToolChoice(types = types)

            /** Use this option to force the model to call a specific function. */
            @JvmStatic
            fun ofFunction(function: ToolChoiceFunction) = ToolChoice(function = function)

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            @JvmStatic fun ofMcp(mcp: ToolChoiceMcp) = ToolChoice(mcp = mcp)

            /** Use this option to force the model to call a specific custom tool. */
            @JvmStatic fun ofCustom(custom: ToolChoiceCustom) = ToolChoice(custom = custom)
        }

        /**
         * An interface that defines how to map each variant of [ToolChoice] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Controls which (if any) tool is called by the model.
             *
             * `none` means the model will not call any tool and instead generates a message.
             *
             * `auto` means the model can pick between generating a message or calling one or more
             * tools.
             *
             * `required` means the model must call one or more tools.
             */
            fun visitOptions(options: ToolChoiceOptions): T

            /** Constrains the tools available to the model to a pre-defined set. */
            fun visitAllowed(allowed: ToolChoiceAllowed): T

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun visitTypes(types: ToolChoiceTypes): T

            /** Use this option to force the model to call a specific function. */
            fun visitFunction(function: ToolChoiceFunction): T

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            fun visitMcp(mcp: ToolChoiceMcp): T

            /** Use this option to force the model to call a specific custom tool. */
            fun visitCustom(custom: ToolChoiceCustom): T

            /**
             * Maps an unknown variant of [ToolChoice] to a value of type [T].
             *
             * An instance of [ToolChoice] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ToolChoice: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<ToolChoice>(ToolChoice::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ToolChoice {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceOptions>())?.let {
                                ToolChoice(options = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceAllowed>())?.let {
                                ToolChoice(allowed = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceTypes>())?.let {
                                ToolChoice(types = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>())?.let {
                                ToolChoice(function = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceMcp>())?.let {
                                ToolChoice(mcp = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceCustom>())?.let {
                                ToolChoice(custom = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> ToolChoice(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<ToolChoice>(ToolChoice::class) {

            override fun serialize(
                value: ToolChoice,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.options != null -> generator.writeObject(value.options)
                    value.allowed != null -> generator.writeObject(value.allowed)
                    value.types != null -> generator.writeObject(value.types)
                    value.function != null -> generator.writeObject(value.function)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value.custom != null -> generator.writeObject(value.custom)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * The conversation that this response belongs to. Input items and output items from this
     * response are automatically added to this conversation.
     */
    class Conversation
    private constructor(
        private val id: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of()
        ) : this(id, mutableMapOf())

        /**
         * The unique ID of the conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
             * Returns a mutable builder for constructing an instance of [Conversation].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Conversation]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(conversation: Conversation) = apply {
                id = conversation.id
                additionalProperties = conversation.additionalProperties.toMutableMap()
            }

            /** The unique ID of the conversation. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [Conversation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Conversation =
                Conversation(checkRequired("id", id), additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Conversation = apply {
            if (validated) {
                return@apply
            }

            id()
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
        @JvmSynthetic internal fun validity(): Int = (if (id.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Conversation &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Conversation{id=$id, additionalProperties=$additionalProperties}"
    }

    /**
     * Specifies the processing type used for serving the request.
     * - If set to 'auto', then the request will be processed with the service tier configured in
     *   the Project settings. Unless otherwise configured, the Project will use 'default'.
     * - If set to 'default', then the request will be processed with the standard pricing and
     *   performance for the selected model.
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
     *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
     *   processed with the corresponding service tier.
     * - When not set, the default behavior is 'auto'.
     *
     *   When the `service_tier` parameter is set, the response body will include the `service_tier`
     *   value based on the processing mode actually used to serve the request. This response value
     *   may be different from the value set in the parameter.
     */
    class ServiceTier @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val AUTO = of("auto")

            @JvmField val DEFAULT = of("default")

            @JvmField val FLEX = of("flex")

            @JvmField val SCALE = of("scale")

            @JvmField val PRIORITY = of("priority")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        enum class Known {
            AUTO,
            DEFAULT,
            FLEX,
            SCALE,
            PRIORITY,
        }

        /**
         * An enum containing [ServiceTier]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ServiceTier] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            DEFAULT,
            FLEX,
            SCALE,
            PRIORITY,
            /**
             * An enum member indicating that [ServiceTier] was instantiated with an unknown value.
             */
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
                AUTO -> Value.AUTO
                DEFAULT -> Value.DEFAULT
                FLEX -> Value.FLEX
                SCALE -> Value.SCALE
                PRIORITY -> Value.PRIORITY
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
                AUTO -> Known.AUTO
                DEFAULT -> Known.DEFAULT
                FLEX -> Known.FLEX
                SCALE -> Known.SCALE
                PRIORITY -> Known.PRIORITY
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
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

        fun validate(): ServiceTier = apply {
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

            return other is ServiceTier && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the input to this Response exceeds the model's context window size, the model
     *   will truncate the response to fit the context window by dropping items from the beginning
     *   of the conversation.
     * - `disabled` (default): If the input size will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    class Truncation @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val AUTO = of("auto")

            @JvmField val DISABLED = of("disabled")

            @JvmStatic fun of(value: String) = Truncation(JsonField.of(value))
        }

        /** An enum containing [Truncation]'s known values. */
        enum class Known {
            AUTO,
            DISABLED,
        }

        /**
         * An enum containing [Truncation]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Truncation] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            DISABLED,
            /**
             * An enum member indicating that [Truncation] was instantiated with an unknown value.
             */
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
                AUTO -> Value.AUTO
                DISABLED -> Value.DISABLED
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
                AUTO -> Known.AUTO
                DISABLED -> Known.DISABLED
                else -> throw OpenAIInvalidDataException("Unknown Truncation: $value")
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

        fun validate(): Truncation = apply {
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

            return other is Truncation && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Response &&
            id == other.id &&
            createdAt == other.createdAt &&
            error == other.error &&
            incompleteDetails == other.incompleteDetails &&
            instructions == other.instructions &&
            metadata == other.metadata &&
            model == other.model &&
            object_ == other.object_ &&
            output == other.output &&
            parallelToolCalls == other.parallelToolCalls &&
            temperature == other.temperature &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            topP == other.topP &&
            background == other.background &&
            conversation == other.conversation &&
            maxOutputTokens == other.maxOutputTokens &&
            maxToolCalls == other.maxToolCalls &&
            previousResponseId == other.previousResponseId &&
            prompt == other.prompt &&
            promptCacheKey == other.promptCacheKey &&
            reasoning == other.reasoning &&
            safetyIdentifier == other.safetyIdentifier &&
            serviceTier == other.serviceTier &&
            status == other.status &&
            text == other.text &&
            topLogprobs == other.topLogprobs &&
            truncation == other.truncation &&
            usage == other.usage &&
            user == other.user &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            error,
            incompleteDetails,
            instructions,
            metadata,
            model,
            object_,
            output,
            parallelToolCalls,
            temperature,
            toolChoice,
            tools,
            topP,
            background,
            conversation,
            maxOutputTokens,
            maxToolCalls,
            previousResponseId,
            prompt,
            promptCacheKey,
            reasoning,
            safetyIdentifier,
            serviceTier,
            status,
            text,
            topLogprobs,
            truncation,
            usage,
            user,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Response{id=$id, createdAt=$createdAt, error=$error, incompleteDetails=$incompleteDetails, instructions=$instructions, metadata=$metadata, model=$model, object_=$object_, output=$output, parallelToolCalls=$parallelToolCalls, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topP=$topP, background=$background, conversation=$conversation, maxOutputTokens=$maxOutputTokens, maxToolCalls=$maxToolCalls, previousResponseId=$previousResponseId, prompt=$prompt, promptCacheKey=$promptCacheKey, reasoning=$reasoning, safetyIdentifier=$safetyIdentifier, serviceTier=$serviceTier, status=$status, text=$text, topLogprobs=$topLogprobs, truncation=$truncation, usage=$usage, user=$user, additionalProperties=$additionalProperties}"
}
