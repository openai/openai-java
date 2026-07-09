// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BetaResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Double>,
    private val error: JsonField<BetaResponseError>,
    private val incompleteDetails: JsonField<IncompleteDetails>,
    private val instructions: JsonField<Instructions>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<Model>,
    private val object_: JsonValue,
    private val output: JsonField<List<BetaResponseOutputItem>>,
    private val parallelToolCalls: JsonField<Boolean>,
    private val temperature: JsonField<Double>,
    private val toolChoice: JsonField<ToolChoice>,
    private val tools: JsonField<List<BetaTool>>,
    private val topP: JsonField<Double>,
    private val background: JsonField<Boolean>,
    private val completedAt: JsonField<Double>,
    private val conversation: JsonField<Conversation>,
    private val maxOutputTokens: JsonField<Long>,
    private val maxToolCalls: JsonField<Long>,
    private val moderation: JsonField<Moderation>,
    private val previousResponseId: JsonField<String>,
    private val prompt: JsonField<BetaResponsePrompt>,
    private val promptCacheKey: JsonField<String>,
    private val promptCacheOptions: JsonField<PromptCacheOptions>,
    private val promptCacheRetention: JsonField<PromptCacheRetention>,
    private val reasoning: JsonField<Reasoning>,
    private val safetyIdentifier: JsonField<String>,
    private val serviceTier: JsonField<ServiceTier>,
    private val status: JsonField<BetaResponseStatus>,
    private val text: JsonField<BetaResponseTextConfig>,
    private val topLogprobs: JsonField<Long>,
    private val truncation: JsonField<Truncation>,
    private val usage: JsonField<BetaResponseUsage>,
    private val user: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("error")
        @ExcludeMissing
        error: JsonField<BetaResponseError> = JsonMissing.of(),
        @JsonProperty("incomplete_details")
        @ExcludeMissing
        incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<Instructions> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<List<BetaResponseOutputItem>> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<BetaTool>> = JsonMissing.of(),
        @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("completed_at")
        @ExcludeMissing
        completedAt: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("conversation")
        @ExcludeMissing
        conversation: JsonField<Conversation> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("max_tool_calls")
        @ExcludeMissing
        maxToolCalls: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("moderation")
        @ExcludeMissing
        moderation: JsonField<Moderation> = JsonMissing.of(),
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        previousResponseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("prompt")
        @ExcludeMissing
        prompt: JsonField<BetaResponsePrompt> = JsonMissing.of(),
        @JsonProperty("prompt_cache_key")
        @ExcludeMissing
        promptCacheKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("prompt_cache_options")
        @ExcludeMissing
        promptCacheOptions: JsonField<PromptCacheOptions> = JsonMissing.of(),
        @JsonProperty("prompt_cache_retention")
        @ExcludeMissing
        promptCacheRetention: JsonField<PromptCacheRetention> = JsonMissing.of(),
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
        status: JsonField<BetaResponseStatus> = JsonMissing.of(),
        @JsonProperty("text")
        @ExcludeMissing
        text: JsonField<BetaResponseTextConfig> = JsonMissing.of(),
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        topLogprobs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("truncation")
        @ExcludeMissing
        truncation: JsonField<Truncation> = JsonMissing.of(),
        @JsonProperty("usage")
        @ExcludeMissing
        usage: JsonField<BetaResponseUsage> = JsonMissing.of(),
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
        completedAt,
        conversation,
        maxOutputTokens,
        maxToolCalls,
        moderation,
        previousResponseId,
        prompt,
        promptCacheKey,
        promptCacheOptions,
        promptCacheRetention,
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
    fun error(): Optional<BetaResponseError> = error.getOptional("error")

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
    fun model(): Model = model.getRequired("model")

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
    fun output(): List<BetaResponseOutputItem> = output.getRequired("output")

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
    fun tools(): List<BetaTool> = tools.getRequired("tools")

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
     * Unix timestamp (in seconds) of when this Response was completed. Only present when the status
     * is `completed`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun completedAt(): Optional<Double> = completedAt.getOptional("completed_at")

    /**
     * The conversation that this response belonged to. Input items and output items from this
     * response were automatically added to this conversation.
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
     * Moderation results for the response input and output, if moderated completions were
     * requested.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun moderation(): Optional<Moderation> = moderation.getOptional("moderation")

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
    fun prompt(): Optional<BetaResponsePrompt> = prompt.getOptional("prompt")

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
     * The prompt-caching options that were applied to the response. Supported for `gpt-5.6` and
     * later models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheOptions(): Optional<PromptCacheOptions> =
        promptCacheOptions.getOptional("prompt_cache_options")

    /**
     * Deprecated. Use `prompt_cache_options.ttl` instead.
     *
     * The retention policy for the prompt cache. Set to `24h` to enable extended prompt caching,
     * which keeps cached prefixes active for longer, up to a maximum of 24 hours.
     * [Learn more](https://platform.openai.com/docs/guides/prompt-caching#prompt-cache-retention).
     * This field expresses a maximum retention policy, while `prompt_cache_options.ttl` expresses a
     * minimum cache lifetime. The two fields are independent and do not interact. For `gpt-5.5`,
     * `gpt-5.5-pro`, and future models, only `24h` is supported.
     *
     * For older models that support both `in_memory` and `24h`, the default depends on your
     * organization's data retention policy:
     * - Organizations without ZDR enabled default to `24h`.
     * - Organizations with ZDR enabled default to `in_memory` when `prompt_cache_retention` is not
     *   specified.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated")
    fun promptCacheRetention(): Optional<PromptCacheRetention> =
        promptCacheRetention.getOptional("prompt_cache_retention")

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
     * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user, with
     * a maximum length of 64 characters. We recommend hashing their username or email address, in
     * order to avoid sending us any identifying information.
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
    fun status(): Optional<BetaResponseStatus> = status.getOptional("status")

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<BetaResponseTextConfig> = text.getOptional("text")

    /**
     * An integer between 0 and 20 specifying the maximum number of most likely tokens to return at
     * each token position, each with an associated log probability. In some cases, the number of
     * returned tokens may be fewer than requested.
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
    fun usage(): Optional<BetaResponseUsage> = usage.getOptional("usage")

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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<BetaResponseError> = error

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
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<List<BetaResponseOutputItem>> = output

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
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<BetaTool>> = tools

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
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed_at")
    @ExcludeMissing
    fun _completedAt(): JsonField<Double> = completedAt

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
     * Returns the raw JSON value of [moderation].
     *
     * Unlike [moderation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("moderation")
    @ExcludeMissing
    fun _moderation(): JsonField<Moderation> = moderation

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
    @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<BetaResponsePrompt> = prompt

    /**
     * Returns the raw JSON value of [promptCacheKey].
     *
     * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prompt_cache_key")
    @ExcludeMissing
    fun _promptCacheKey(): JsonField<String> = promptCacheKey

    /**
     * Returns the raw JSON value of [promptCacheOptions].
     *
     * Unlike [promptCacheOptions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("prompt_cache_options")
    @ExcludeMissing
    fun _promptCacheOptions(): JsonField<PromptCacheOptions> = promptCacheOptions

    /**
     * Returns the raw JSON value of [promptCacheRetention].
     *
     * Unlike [promptCacheRetention], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @Deprecated("deprecated")
    @JsonProperty("prompt_cache_retention")
    @ExcludeMissing
    fun _promptCacheRetention(): JsonField<PromptCacheRetention> = promptCacheRetention

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
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<BetaResponseStatus> = status

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<BetaResponseTextConfig> = text

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
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<BetaResponseUsage> = usage

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
         * Returns a mutable builder for constructing an instance of [BetaResponse].
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

    /** A builder for [BetaResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Double>? = null
        private var error: JsonField<BetaResponseError>? = null
        private var incompleteDetails: JsonField<IncompleteDetails>? = null
        private var instructions: JsonField<Instructions>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<Model>? = null
        private var object_: JsonValue = JsonValue.from("response")
        private var output: JsonField<MutableList<BetaResponseOutputItem>>? = null
        private var parallelToolCalls: JsonField<Boolean>? = null
        private var temperature: JsonField<Double>? = null
        private var toolChoice: JsonField<ToolChoice>? = null
        private var tools: JsonField<MutableList<BetaTool>>? = null
        private var topP: JsonField<Double>? = null
        private var background: JsonField<Boolean> = JsonMissing.of()
        private var completedAt: JsonField<Double> = JsonMissing.of()
        private var conversation: JsonField<Conversation> = JsonMissing.of()
        private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
        private var maxToolCalls: JsonField<Long> = JsonMissing.of()
        private var moderation: JsonField<Moderation> = JsonMissing.of()
        private var previousResponseId: JsonField<String> = JsonMissing.of()
        private var prompt: JsonField<BetaResponsePrompt> = JsonMissing.of()
        private var promptCacheKey: JsonField<String> = JsonMissing.of()
        private var promptCacheOptions: JsonField<PromptCacheOptions> = JsonMissing.of()
        private var promptCacheRetention: JsonField<PromptCacheRetention> = JsonMissing.of()
        private var reasoning: JsonField<Reasoning> = JsonMissing.of()
        private var safetyIdentifier: JsonField<String> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var status: JsonField<BetaResponseStatus> = JsonMissing.of()
        private var text: JsonField<BetaResponseTextConfig> = JsonMissing.of()
        private var topLogprobs: JsonField<Long> = JsonMissing.of()
        private var truncation: JsonField<Truncation> = JsonMissing.of()
        private var usage: JsonField<BetaResponseUsage> = JsonMissing.of()
        private var user: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponse: BetaResponse) = apply {
            id = betaResponse.id
            createdAt = betaResponse.createdAt
            error = betaResponse.error
            incompleteDetails = betaResponse.incompleteDetails
            instructions = betaResponse.instructions
            metadata = betaResponse.metadata
            model = betaResponse.model
            object_ = betaResponse.object_
            output = betaResponse.output.map { it.toMutableList() }
            parallelToolCalls = betaResponse.parallelToolCalls
            temperature = betaResponse.temperature
            toolChoice = betaResponse.toolChoice
            tools = betaResponse.tools.map { it.toMutableList() }
            topP = betaResponse.topP
            background = betaResponse.background
            completedAt = betaResponse.completedAt
            conversation = betaResponse.conversation
            maxOutputTokens = betaResponse.maxOutputTokens
            maxToolCalls = betaResponse.maxToolCalls
            moderation = betaResponse.moderation
            previousResponseId = betaResponse.previousResponseId
            prompt = betaResponse.prompt
            promptCacheKey = betaResponse.promptCacheKey
            promptCacheOptions = betaResponse.promptCacheOptions
            promptCacheRetention = betaResponse.promptCacheRetention
            reasoning = betaResponse.reasoning
            safetyIdentifier = betaResponse.safetyIdentifier
            serviceTier = betaResponse.serviceTier
            status = betaResponse.status
            text = betaResponse.text
            topLogprobs = betaResponse.topLogprobs
            truncation = betaResponse.truncation
            usage = betaResponse.usage
            user = betaResponse.user
            additionalProperties = betaResponse.additionalProperties.toMutableMap()
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
        fun error(error: BetaResponseError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<BetaResponseError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [BetaResponseError] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun error(error: JsonField<BetaResponseError>) = apply { this.error = error }

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
        fun instructionsOfInputItemList(inputItemList: List<BetaResponseInputItem>) =
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
        fun model(model: Model) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { this.model = model }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [Model] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = model(Model.of(value))

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
        fun output(output: List<BetaResponseOutputItem>) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed `List<BetaResponseOutputItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun output(output: JsonField<List<BetaResponseOutputItem>>) = apply {
            this.output = output.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaResponseOutputItem] to [Builder.output].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOutput(output: BetaResponseOutputItem) = apply {
            this.output =
                (this.output ?: JsonField.of(mutableListOf())).also {
                    checkKnown("output", it).add(output)
                }
        }

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofMessage(message)`. */
        fun addOutput(message: BetaResponseOutputMessage) =
            addOutput(BetaResponseOutputItem.ofMessage(message))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addOutput(fileSearchCall: BetaResponseFileSearchToolCall) =
            addOutput(BetaResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /**
         * Alias for calling [addOutput] with `BetaResponseOutputItem.ofFunctionCall(functionCall)`.
         */
        fun addOutput(functionCall: BetaResponseFunctionToolCall) =
            addOutput(BetaResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addOutput(functionCallOutput: BetaResponseFunctionToolCallOutputItem) =
            addOutput(BetaResponseOutputItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addOutput] with `BetaResponseOutputItem.ofAgentMessage(agentMessage)`.
         */
        fun addOutput(agentMessage: BetaResponseOutputItem.AgentMessage) =
            addOutput(BetaResponseOutputItem.ofAgentMessage(agentMessage))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofMultiAgentCall(multiAgentCall)`.
         */
        fun addOutput(multiAgentCall: BetaResponseOutputItem.MultiAgentCall) =
            addOutput(BetaResponseOutputItem.ofMultiAgentCall(multiAgentCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofMultiAgentCallOutput(multiAgentCallOutput)`.
         */
        fun addOutput(multiAgentCallOutput: BetaResponseOutputItem.MultiAgentCallOutput) =
            addOutput(BetaResponseOutputItem.ofMultiAgentCallOutput(multiAgentCallOutput))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addOutput(webSearchCall: BetaResponseFunctionWebSearch) =
            addOutput(BetaResponseOutputItem.ofWebSearchCall(webSearchCall))

        /**
         * Alias for calling [addOutput] with `BetaResponseOutputItem.ofComputerCall(computerCall)`.
         */
        fun addOutput(computerCall: BetaResponseComputerToolCall) =
            addOutput(BetaResponseOutputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addOutput(computerCallOutput: BetaResponseComputerToolCallOutputItem) =
            addOutput(BetaResponseOutputItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofReasoning(reasoning)`. */
        fun addOutput(reasoning: BetaResponseReasoningItem) =
            addOutput(BetaResponseOutputItem.ofReasoning(reasoning))

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofProgram(program)`. */
        fun addOutput(program: BetaResponseOutputItem.Program) =
            addOutput(BetaResponseOutputItem.ofProgram(program))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofProgramOutput(programOutput)`.
         */
        fun addOutput(programOutput: BetaResponseOutputItem.ProgramOutput) =
            addOutput(BetaResponseOutputItem.ofProgramOutput(programOutput))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofToolSearchCall(toolSearchCall)`.
         */
        fun addOutput(toolSearchCall: BetaResponseToolSearchCall) =
            addOutput(BetaResponseOutputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addOutput(toolSearchOutput: BetaResponseToolSearchOutputItem) =
            addOutput(BetaResponseOutputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofAdditionalTools(additionalTools)`.
         */
        fun addOutput(additionalTools: BetaResponseOutputItem.AdditionalTools) =
            addOutput(BetaResponseOutputItem.ofAdditionalTools(additionalTools))

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofCompaction(compaction)`. */
        fun addOutput(compaction: BetaResponseCompactionItem) =
            addOutput(BetaResponseOutputItem.ofCompaction(compaction))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addOutput(imageGenerationCall: BetaResponseOutputItem.ImageGenerationCall) =
            addOutput(BetaResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addOutput(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            addOutput(BetaResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addOutput(localShellCall: BetaResponseOutputItem.LocalShellCall) =
            addOutput(BetaResponseOutputItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addOutput(localShellCallOutput: BetaResponseOutputItem.LocalShellCallOutput) =
            addOutput(BetaResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofShellCall(shellCall)`. */
        fun addOutput(shellCall: BetaResponseFunctionShellToolCall) =
            addOutput(BetaResponseOutputItem.ofShellCall(shellCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addOutput(shellCallOutput: BetaResponseFunctionShellToolCallOutput) =
            addOutput(BetaResponseOutputItem.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun addOutput(applyPatchCall: BetaResponseApplyPatchToolCall) =
            addOutput(BetaResponseOutputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addOutput(applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput) =
            addOutput(BetaResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /** Alias for calling [addOutput] with `BetaResponseOutputItem.ofMcpCall(mcpCall)`. */
        fun addOutput(mcpCall: BetaResponseOutputItem.McpCall) =
            addOutput(BetaResponseOutputItem.ofMcpCall(mcpCall))

        /**
         * Alias for calling [addOutput] with `BetaResponseOutputItem.ofMcpListTools(mcpListTools)`.
         */
        fun addOutput(mcpListTools: BetaResponseOutputItem.McpListTools) =
            addOutput(BetaResponseOutputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addOutput(mcpApprovalRequest: BetaResponseOutputItem.McpApprovalRequest) =
            addOutput(BetaResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addOutput(mcpApprovalResponse: BetaResponseOutputItem.McpApprovalResponse) =
            addOutput(BetaResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addOutput(customToolCall: BetaResponseCustomToolCall) =
            addOutput(BetaResponseOutputItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addOutput] with
         * `BetaResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addOutput(customToolCallOutput: BetaResponseCustomToolCallOutputItem) =
            addOutput(BetaResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput))

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

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions)`.
         */
        fun toolChoice(betaToolChoiceOptions: BetaToolChoiceOptions) =
            toolChoice(ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed)`.
         */
        fun toolChoice(betaToolChoiceAllowed: BetaToolChoiceAllowed) =
            toolChoice(ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes)`.
         */
        fun toolChoice(betaToolChoiceTypes: BetaToolChoiceTypes) =
            toolChoice(ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction)`.
         */
        fun toolChoice(betaToolChoiceFunction: BetaToolChoiceFunction) =
            toolChoice(ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction))

        /**
         * Alias for calling [toolChoice] with `ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp)`.
         */
        fun toolChoice(betaToolChoiceMcp: BetaToolChoiceMcp) =
            toolChoice(ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom)`.
         */
        fun toolChoice(betaToolChoiceCustom: BetaToolChoiceCustom) =
            toolChoice(ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaSpecificProgrammaticToolCallingParam()`.
         */
        fun toolChoiceBetaSpecificProgrammaticToolCallingParam() =
            toolChoice(ToolChoice.ofBetaSpecificProgrammaticToolCallingParam())

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)`.
         */
        fun toolChoice(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) =
            toolChoice(ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell)`.
         */
        fun toolChoice(betaToolChoiceShell: BetaToolChoiceShell) =
            toolChoice(ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell))

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
        fun tools(tools: List<BetaTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<BetaTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: BetaTool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `BetaTool.ofFunction(function)`. */
        fun addTool(function: BetaFunctionTool) = addTool(BetaTool.ofFunction(function))

        /** Alias for calling [addTool] with `BetaTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: BetaFileSearchTool) = addTool(BetaTool.ofFileSearch(fileSearch))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaFileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) =
            addTool(BetaFileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

        /** Alias for calling [addTool] with `BetaTool.ofComputer(computer)`. */
        fun addTool(computer: BetaComputerTool) = addTool(BetaTool.ofComputer(computer))

        /** Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: BetaComputerUsePreviewTool) =
            addTool(BetaTool.ofComputerUsePreview(computerUsePreview))

        /** Alias for calling [addTool] with `BetaTool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: BetaWebSearchTool) = addTool(BetaTool.ofWebSearch(webSearch))

        /** Alias for calling [addTool] with `BetaTool.ofMcp(mcp)`. */
        fun addTool(mcp: BetaTool.Mcp) = addTool(BetaTool.ofMcp(mcp))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) =
            addTool(BetaTool.Mcp.builder().serverLabel(serverLabel).build())

        /** Alias for calling [addTool] with `BetaTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: BetaTool.CodeInterpreter) =
            addTool(BetaTool.ofCodeInterpreter(codeInterpreter))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: BetaTool.CodeInterpreter.Container) =
            addTool(BetaTool.CodeInterpreter.builder().container(container).build())

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) =
            addCodeInterpreterTool(BetaTool.CodeInterpreter.Container.ofString(string))

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: BetaTool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) =
            addCodeInterpreterTool(
                BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(
                    codeInterpreterToolAuto
                )
            )

        /** Alias for calling [addTool] with `BetaTool.ofProgrammaticToolCalling()`. */
        fun addToolProgrammaticToolCalling() = addTool(BetaTool.ofProgrammaticToolCalling())

        /** Alias for calling [addTool] with `BetaTool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: BetaTool.ImageGeneration) =
            addTool(BetaTool.ofImageGeneration(imageGeneration))

        /** Alias for calling [addTool] with `BetaTool.ofLocalShell()`. */
        fun addToolLocalShell() = addTool(BetaTool.ofLocalShell())

        /** Alias for calling [addTool] with `BetaTool.ofShell(shell)`. */
        fun addTool(shell: BetaFunctionShellTool) = addTool(BetaTool.ofShell(shell))

        /** Alias for calling [addTool] with `BetaTool.ofCustom(custom)`. */
        fun addTool(custom: BetaCustomTool) = addTool(BetaTool.ofCustom(custom))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaCustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = addTool(BetaCustomTool.builder().name(name).build())

        /** Alias for calling [addTool] with `BetaTool.ofNamespace(namespace)`. */
        fun addTool(namespace: BetaNamespaceTool) = addTool(BetaTool.ofNamespace(namespace))

        /** Alias for calling [addTool] with `BetaTool.ofToolSearch(toolSearch)`. */
        fun addTool(toolSearch: BetaToolSearchTool) = addTool(BetaTool.ofToolSearch(toolSearch))

        /** Alias for calling [addTool] with `BetaTool.ofWebSearchPreview(webSearchPreview)`. */
        fun addTool(webSearchPreview: BetaWebSearchPreviewTool) =
            addTool(BetaTool.ofWebSearchPreview(webSearchPreview))

        /** Alias for calling [addTool] with `BetaTool.ofApplyPatch(applyPatch)`. */
        fun addTool(applyPatch: BetaApplyPatchTool) = addTool(BetaTool.ofApplyPatch(applyPatch))

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
         * Unix timestamp (in seconds) of when this Response was completed. Only present when the
         * status is `completed`.
         */
        fun completedAt(completedAt: Double?) = completedAt(JsonField.ofNullable(completedAt))

        /**
         * Alias for [Builder.completedAt].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun completedAt(completedAt: Double) = completedAt(completedAt as Double?)

        /** Alias for calling [Builder.completedAt] with `completedAt.orElse(null)`. */
        fun completedAt(completedAt: Optional<Double>) = completedAt(completedAt.getOrNull())

        /**
         * Sets [Builder.completedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completedAt] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completedAt(completedAt: JsonField<Double>) = apply { this.completedAt = completedAt }

        /**
         * The conversation that this response belonged to. Input items and output items from this
         * response were automatically added to this conversation.
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
         * Moderation results for the response input and output, if moderated completions were
         * requested.
         */
        fun moderation(moderation: Moderation?) = moderation(JsonField.ofNullable(moderation))

        /** Alias for calling [Builder.moderation] with `moderation.orElse(null)`. */
        fun moderation(moderation: Optional<Moderation>) = moderation(moderation.getOrNull())

        /**
         * Sets [Builder.moderation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.moderation] with a well-typed [Moderation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun moderation(moderation: JsonField<Moderation>) = apply { this.moderation = moderation }

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
        fun prompt(prompt: BetaResponsePrompt?) = prompt(JsonField.ofNullable(prompt))

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<BetaResponsePrompt>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [BetaResponsePrompt] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun prompt(prompt: JsonField<BetaResponsePrompt>) = apply { this.prompt = prompt }

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
         * The prompt-caching options that were applied to the response. Supported for `gpt-5.6` and
         * later models.
         */
        fun promptCacheOptions(promptCacheOptions: PromptCacheOptions) =
            promptCacheOptions(JsonField.of(promptCacheOptions))

        /**
         * Sets [Builder.promptCacheOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheOptions] with a well-typed
         * [PromptCacheOptions] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun promptCacheOptions(promptCacheOptions: JsonField<PromptCacheOptions>) = apply {
            this.promptCacheOptions = promptCacheOptions
        }

        /**
         * Deprecated. Use `prompt_cache_options.ttl` instead.
         *
         * The retention policy for the prompt cache. Set to `24h` to enable extended prompt
         * caching, which keeps cached prefixes active for longer, up to a maximum of 24 hours.
         * [Learn more](https://platform.openai.com/docs/guides/prompt-caching#prompt-cache-retention).
         * This field expresses a maximum retention policy, while `prompt_cache_options.ttl`
         * expresses a minimum cache lifetime. The two fields are independent and do not interact.
         * For `gpt-5.5`, `gpt-5.5-pro`, and future models, only `24h` is supported.
         *
         * For older models that support both `in_memory` and `24h`, the default depends on your
         * organization's data retention policy:
         * - Organizations without ZDR enabled default to `24h`.
         * - Organizations with ZDR enabled default to `in_memory` when `prompt_cache_retention` is
         *   not specified.
         */
        @Deprecated("deprecated")
        fun promptCacheRetention(promptCacheRetention: PromptCacheRetention?) =
            promptCacheRetention(JsonField.ofNullable(promptCacheRetention))

        /**
         * Alias for calling [Builder.promptCacheRetention] with
         * `promptCacheRetention.orElse(null)`.
         */
        @Deprecated("deprecated")
        fun promptCacheRetention(promptCacheRetention: Optional<PromptCacheRetention>) =
            promptCacheRetention(promptCacheRetention.getOrNull())

        /**
         * Sets [Builder.promptCacheRetention] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheRetention] with a well-typed
         * [PromptCacheRetention] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        @Deprecated("deprecated")
        fun promptCacheRetention(promptCacheRetention: JsonField<PromptCacheRetention>) = apply {
            this.promptCacheRetention = promptCacheRetention
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
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user,
         * with a maximum length of 64 characters. We recommend hashing their username or email
         * address, in order to avoid sending us any identifying information.
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
        fun status(status: BetaResponseStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [BetaResponseStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<BetaResponseStatus>) = apply { this.status = status }

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: BetaResponseTextConfig) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [BetaResponseTextConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<BetaResponseTextConfig>) = apply { this.text = text }

        /**
         * An integer between 0 and 20 specifying the maximum number of most likely tokens to return
         * at each token position, each with an associated log probability. In some cases, the
         * number of returned tokens may be fewer than requested.
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
        fun usage(usage: BetaResponseUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [BetaResponseUsage] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usage(usage: JsonField<BetaResponseUsage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [BetaResponse].
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
        fun build(): BetaResponse =
            BetaResponse(
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
                completedAt,
                conversation,
                maxOutputTokens,
                maxToolCalls,
                moderation,
                previousResponseId,
                prompt,
                promptCacheKey,
                promptCacheOptions,
                promptCacheRetention,
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        error().ifPresent { it.validate() }
        incompleteDetails().ifPresent { it.validate() }
        instructions().ifPresent { it.validate() }
        metadata().ifPresent { it.validate() }
        model()
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
        completedAt()
        conversation().ifPresent { it.validate() }
        maxOutputTokens()
        maxToolCalls()
        moderation().ifPresent { it.validate() }
        previousResponseId()
        prompt().ifPresent { it.validate() }
        promptCacheKey()
        promptCacheOptions().ifPresent { it.validate() }
        promptCacheRetention().ifPresent { it.validate() }
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
            (if (model.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("response")) 1 else 0 } +
            (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (topP.asKnown().isPresent) 1 else 0) +
            (if (background.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (conversation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
            (if (maxToolCalls.asKnown().isPresent) 1 else 0) +
            (moderation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (previousResponseId.asKnown().isPresent) 1 else 0) +
            (prompt.asKnown().getOrNull()?.validity() ?: 0) +
            (if (promptCacheKey.asKnown().isPresent) 1 else 0) +
            (promptCacheOptions.asKnown().getOrNull()?.validity() ?: 0) +
            (promptCacheRetention.asKnown().getOrNull()?.validity() ?: 0) +
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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
        private val inputItemList: List<BetaResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `developer` role. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** A list of one or many input items to the model, containing different content types. */
        fun inputItemList(): Optional<List<BetaResponseInputItem>> =
            Optional.ofNullable(inputItemList)

        fun isString(): Boolean = string != null

        fun isInputItemList(): Boolean = inputItemList != null

        /** A text input to the model, equivalent to a text input with the `developer` role. */
        fun asString(): String = string.getOrThrow("string")

        /** A list of one or many input items to the model, containing different content types. */
        fun asInputItemList(): List<BetaResponseInputItem> =
            inputItemList.getOrThrow("inputItemList")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = instructions.accept(new Instructions.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitString(String string) {
         *         return Optional.of(string.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                inputItemList != null -> visitor.visitInputItemList(inputItemList)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Instructions = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitInputItemList(inputItemList: List<BetaResponseInputItem>) {
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

                    override fun visitInputItemList(inputItemList: List<BetaResponseInputItem>) =
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
            fun ofInputItemList(inputItemList: List<BetaResponseInputItem>) =
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
            fun visitInputItemList(inputItemList: List<BetaResponseInputItem>): T

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
                            tryDeserialize(node, jacksonTypeRef<List<BetaResponseInputItem>>())
                                ?.let { Instructions(inputItemList = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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
     * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     */
    class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GPT_5_6_SOL = of("gpt-5.6-sol")

            @JvmField val GPT_5_6_TERRA = of("gpt-5.6-terra")

            @JvmField val GPT_5_6_LUNA = of("gpt-5.6-luna")

            @JvmField val GPT_5_4 = of("gpt-5.4")

            @JvmField val GPT_5_4_MINI = of("gpt-5.4-mini")

            @JvmField val GPT_5_4_NANO = of("gpt-5.4-nano")

            @JvmField val GPT_5_4_MINI_2026_03_17 = of("gpt-5.4-mini-2026-03-17")

            @JvmField val GPT_5_4_NANO_2026_03_17 = of("gpt-5.4-nano-2026-03-17")

            @JvmField val GPT_5_3_CHAT_LATEST = of("gpt-5.3-chat-latest")

            @JvmField val GPT_5_2 = of("gpt-5.2")

            @JvmField val GPT_5_2_2025_12_11 = of("gpt-5.2-2025-12-11")

            @JvmField val GPT_5_2_CHAT_LATEST = of("gpt-5.2-chat-latest")

            @JvmField val GPT_5_2_PRO = of("gpt-5.2-pro")

            @JvmField val GPT_5_2_PRO_2025_12_11 = of("gpt-5.2-pro-2025-12-11")

            @JvmField val GPT_5_1 = of("gpt-5.1")

            @JvmField val GPT_5_1_2025_11_13 = of("gpt-5.1-2025-11-13")

            @JvmField val GPT_5_1_CODEX = of("gpt-5.1-codex")

            @JvmField val GPT_5_1_MINI = of("gpt-5.1-mini")

            @JvmField val GPT_5_1_CHAT_LATEST = of("gpt-5.1-chat-latest")

            @JvmField val GPT_5 = of("gpt-5")

            @JvmField val GPT_5_MINI = of("gpt-5-mini")

            @JvmField val GPT_5_NANO = of("gpt-5-nano")

            @JvmField val GPT_5_2025_08_07 = of("gpt-5-2025-08-07")

            @JvmField val GPT_5_MINI_2025_08_07 = of("gpt-5-mini-2025-08-07")

            @JvmField val GPT_5_NANO_2025_08_07 = of("gpt-5-nano-2025-08-07")

            @JvmField val GPT_5_CHAT_LATEST = of("gpt-5-chat-latest")

            @JvmField val GPT_4_1 = of("gpt-4.1")

            @JvmField val GPT_4_1_MINI = of("gpt-4.1-mini")

            @JvmField val GPT_4_1_NANO = of("gpt-4.1-nano")

            @JvmField val GPT_4_1_2025_04_14 = of("gpt-4.1-2025-04-14")

            @JvmField val GPT_4_1_MINI_2025_04_14 = of("gpt-4.1-mini-2025-04-14")

            @JvmField val GPT_4_1_NANO_2025_04_14 = of("gpt-4.1-nano-2025-04-14")

            @JvmField val O4_MINI = of("o4-mini")

            @JvmField val O4_MINI_2025_04_16 = of("o4-mini-2025-04-16")

            @JvmField val O3 = of("o3")

            @JvmField val O3_2025_04_16 = of("o3-2025-04-16")

            @JvmField val O3_MINI = of("o3-mini")

            @JvmField val O3_MINI_2025_01_31 = of("o3-mini-2025-01-31")

            @JvmField val O1 = of("o1")

            @JvmField val O1_2024_12_17 = of("o1-2024-12-17")

            @JvmField val O1_PREVIEW = of("o1-preview")

            @JvmField val O1_PREVIEW_2024_09_12 = of("o1-preview-2024-09-12")

            @JvmField val O1_MINI = of("o1-mini")

            @JvmField val O1_MINI_2024_09_12 = of("o1-mini-2024-09-12")

            @JvmField val GPT_4O = of("gpt-4o")

            @JvmField val GPT_4O_2024_11_20 = of("gpt-4o-2024-11-20")

            @JvmField val GPT_4O_2024_08_06 = of("gpt-4o-2024-08-06")

            @JvmField val GPT_4O_2024_05_13 = of("gpt-4o-2024-05-13")

            @JvmField val GPT_4O_AUDIO_PREVIEW = of("gpt-4o-audio-preview")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2024_10_01 = of("gpt-4o-audio-preview-2024-10-01")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2024_12_17 = of("gpt-4o-audio-preview-2024-12-17")

            @JvmField val GPT_4O_AUDIO_PREVIEW_2025_06_03 = of("gpt-4o-audio-preview-2025-06-03")

            @JvmField val GPT_4O_MINI_AUDIO_PREVIEW = of("gpt-4o-mini-audio-preview")

            @JvmField
            val GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 = of("gpt-4o-mini-audio-preview-2024-12-17")

            @JvmField val GPT_4O_SEARCH_PREVIEW = of("gpt-4o-search-preview")

            @JvmField val GPT_4O_MINI_SEARCH_PREVIEW = of("gpt-4o-mini-search-preview")

            @JvmField val GPT_4O_SEARCH_PREVIEW_2025_03_11 = of("gpt-4o-search-preview-2025-03-11")

            @JvmField
            val GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 = of("gpt-4o-mini-search-preview-2025-03-11")

            @JvmField val CHATGPT_4O_LATEST = of("chatgpt-4o-latest")

            @JvmField val CODEX_MINI_LATEST = of("codex-mini-latest")

            @JvmField val GPT_4O_MINI = of("gpt-4o-mini")

            @JvmField val GPT_4O_MINI_2024_07_18 = of("gpt-4o-mini-2024-07-18")

            @JvmField val GPT_4_TURBO = of("gpt-4-turbo")

            @JvmField val GPT_4_TURBO_2024_04_09 = of("gpt-4-turbo-2024-04-09")

            @JvmField val GPT_4_0125_PREVIEW = of("gpt-4-0125-preview")

            @JvmField val GPT_4_TURBO_PREVIEW = of("gpt-4-turbo-preview")

            @JvmField val GPT_4_1106_PREVIEW = of("gpt-4-1106-preview")

            @JvmField val GPT_4_VISION_PREVIEW = of("gpt-4-vision-preview")

            @JvmField val GPT_4 = of("gpt-4")

            @JvmField val GPT_4_0314 = of("gpt-4-0314")

            @JvmField val GPT_4_0613 = of("gpt-4-0613")

            @JvmField val GPT_4_32K = of("gpt-4-32k")

            @JvmField val GPT_4_32K_0314 = of("gpt-4-32k-0314")

            @JvmField val GPT_4_32K_0613 = of("gpt-4-32k-0613")

            @JvmField val GPT_3_5_TURBO = of("gpt-3.5-turbo")

            @JvmField val GPT_3_5_TURBO_16K = of("gpt-3.5-turbo-16k")

            @JvmField val GPT_3_5_TURBO_0301 = of("gpt-3.5-turbo-0301")

            @JvmField val GPT_3_5_TURBO_0613 = of("gpt-3.5-turbo-0613")

            @JvmField val GPT_3_5_TURBO_1106 = of("gpt-3.5-turbo-1106")

            @JvmField val GPT_3_5_TURBO_0125 = of("gpt-3.5-turbo-0125")

            @JvmField val GPT_3_5_TURBO_16K_0613 = of("gpt-3.5-turbo-16k-0613")

            @JvmField val O1_PRO = of("o1-pro")

            @JvmField val O1_PRO_2025_03_19 = of("o1-pro-2025-03-19")

            @JvmField val O3_PRO = of("o3-pro")

            @JvmField val O3_PRO_2025_06_10 = of("o3-pro-2025-06-10")

            @JvmField val O3_DEEP_RESEARCH = of("o3-deep-research")

            @JvmField val O3_DEEP_RESEARCH_2025_06_26 = of("o3-deep-research-2025-06-26")

            @JvmField val O4_MINI_DEEP_RESEARCH = of("o4-mini-deep-research")

            @JvmField val O4_MINI_DEEP_RESEARCH_2025_06_26 = of("o4-mini-deep-research-2025-06-26")

            @JvmField val COMPUTER_USE_PREVIEW = of("computer-use-preview")

            @JvmField val COMPUTER_USE_PREVIEW_2025_03_11 = of("computer-use-preview-2025-03-11")

            @JvmField val GPT_5_CODEX = of("gpt-5-codex")

            @JvmField val GPT_5_PRO = of("gpt-5-pro")

            @JvmField val GPT_5_PRO_2025_10_06 = of("gpt-5-pro-2025-10-06")

            @JvmField val GPT_5_1_CODEX_MAX = of("gpt-5.1-codex-max")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_5_6_SOL,
            GPT_5_6_TERRA,
            GPT_5_6_LUNA,
            GPT_5_4,
            GPT_5_4_MINI,
            GPT_5_4_NANO,
            GPT_5_4_MINI_2026_03_17,
            GPT_5_4_NANO_2026_03_17,
            GPT_5_3_CHAT_LATEST,
            GPT_5_2,
            GPT_5_2_2025_12_11,
            GPT_5_2_CHAT_LATEST,
            GPT_5_2_PRO,
            GPT_5_2_PRO_2025_12_11,
            GPT_5_1,
            GPT_5_1_2025_11_13,
            GPT_5_1_CODEX,
            GPT_5_1_MINI,
            GPT_5_1_CHAT_LATEST,
            GPT_5,
            GPT_5_MINI,
            GPT_5_NANO,
            GPT_5_2025_08_07,
            GPT_5_MINI_2025_08_07,
            GPT_5_NANO_2025_08_07,
            GPT_5_CHAT_LATEST,
            GPT_4_1,
            GPT_4_1_MINI,
            GPT_4_1_NANO,
            GPT_4_1_2025_04_14,
            GPT_4_1_MINI_2025_04_14,
            GPT_4_1_NANO_2025_04_14,
            O4_MINI,
            O4_MINI_2025_04_16,
            O3,
            O3_2025_04_16,
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_AUDIO_PREVIEW_2025_06_03,
            GPT_4O_MINI_AUDIO_PREVIEW,
            GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_SEARCH_PREVIEW,
            GPT_4O_MINI_SEARCH_PREVIEW,
            GPT_4O_SEARCH_PREVIEW_2025_03_11,
            GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11,
            CHATGPT_4O_LATEST,
            CODEX_MINI_LATEST,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
            GPT_4_TURBO,
            GPT_4_TURBO_2024_04_09,
            GPT_4_0125_PREVIEW,
            GPT_4_TURBO_PREVIEW,
            GPT_4_1106_PREVIEW,
            GPT_4_VISION_PREVIEW,
            GPT_4,
            GPT_4_0314,
            GPT_4_0613,
            GPT_4_32K,
            GPT_4_32K_0314,
            GPT_4_32K_0613,
            GPT_3_5_TURBO,
            GPT_3_5_TURBO_16K,
            GPT_3_5_TURBO_0301,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            GPT_5_CODEX,
            GPT_5_PRO,
            GPT_5_PRO_2025_10_06,
            GPT_5_1_CODEX_MAX,
        }

        /**
         * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Model] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GPT_5_6_SOL,
            GPT_5_6_TERRA,
            GPT_5_6_LUNA,
            GPT_5_4,
            GPT_5_4_MINI,
            GPT_5_4_NANO,
            GPT_5_4_MINI_2026_03_17,
            GPT_5_4_NANO_2026_03_17,
            GPT_5_3_CHAT_LATEST,
            GPT_5_2,
            GPT_5_2_2025_12_11,
            GPT_5_2_CHAT_LATEST,
            GPT_5_2_PRO,
            GPT_5_2_PRO_2025_12_11,
            GPT_5_1,
            GPT_5_1_2025_11_13,
            GPT_5_1_CODEX,
            GPT_5_1_MINI,
            GPT_5_1_CHAT_LATEST,
            GPT_5,
            GPT_5_MINI,
            GPT_5_NANO,
            GPT_5_2025_08_07,
            GPT_5_MINI_2025_08_07,
            GPT_5_NANO_2025_08_07,
            GPT_5_CHAT_LATEST,
            GPT_4_1,
            GPT_4_1_MINI,
            GPT_4_1_NANO,
            GPT_4_1_2025_04_14,
            GPT_4_1_MINI_2025_04_14,
            GPT_4_1_NANO_2025_04_14,
            O4_MINI,
            O4_MINI_2025_04_16,
            O3,
            O3_2025_04_16,
            O3_MINI,
            O3_MINI_2025_01_31,
            O1,
            O1_2024_12_17,
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_AUDIO_PREVIEW_2025_06_03,
            GPT_4O_MINI_AUDIO_PREVIEW,
            GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17,
            GPT_4O_SEARCH_PREVIEW,
            GPT_4O_MINI_SEARCH_PREVIEW,
            GPT_4O_SEARCH_PREVIEW_2025_03_11,
            GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11,
            CHATGPT_4O_LATEST,
            CODEX_MINI_LATEST,
            GPT_4O_MINI,
            GPT_4O_MINI_2024_07_18,
            GPT_4_TURBO,
            GPT_4_TURBO_2024_04_09,
            GPT_4_0125_PREVIEW,
            GPT_4_TURBO_PREVIEW,
            GPT_4_1106_PREVIEW,
            GPT_4_VISION_PREVIEW,
            GPT_4,
            GPT_4_0314,
            GPT_4_0613,
            GPT_4_32K,
            GPT_4_32K_0314,
            GPT_4_32K_0613,
            GPT_3_5_TURBO,
            GPT_3_5_TURBO_16K,
            GPT_3_5_TURBO_0301,
            GPT_3_5_TURBO_0613,
            GPT_3_5_TURBO_1106,
            GPT_3_5_TURBO_0125,
            GPT_3_5_TURBO_16K_0613,
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            GPT_5_CODEX,
            GPT_5_PRO,
            GPT_5_PRO_2025_10_06,
            GPT_5_1_CODEX_MAX,
            /** An enum member indicating that [Model] was instantiated with an unknown value. */
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
                GPT_5_6_SOL -> Value.GPT_5_6_SOL
                GPT_5_6_TERRA -> Value.GPT_5_6_TERRA
                GPT_5_6_LUNA -> Value.GPT_5_6_LUNA
                GPT_5_4 -> Value.GPT_5_4
                GPT_5_4_MINI -> Value.GPT_5_4_MINI
                GPT_5_4_NANO -> Value.GPT_5_4_NANO
                GPT_5_4_MINI_2026_03_17 -> Value.GPT_5_4_MINI_2026_03_17
                GPT_5_4_NANO_2026_03_17 -> Value.GPT_5_4_NANO_2026_03_17
                GPT_5_3_CHAT_LATEST -> Value.GPT_5_3_CHAT_LATEST
                GPT_5_2 -> Value.GPT_5_2
                GPT_5_2_2025_12_11 -> Value.GPT_5_2_2025_12_11
                GPT_5_2_CHAT_LATEST -> Value.GPT_5_2_CHAT_LATEST
                GPT_5_2_PRO -> Value.GPT_5_2_PRO
                GPT_5_2_PRO_2025_12_11 -> Value.GPT_5_2_PRO_2025_12_11
                GPT_5_1 -> Value.GPT_5_1
                GPT_5_1_2025_11_13 -> Value.GPT_5_1_2025_11_13
                GPT_5_1_CODEX -> Value.GPT_5_1_CODEX
                GPT_5_1_MINI -> Value.GPT_5_1_MINI
                GPT_5_1_CHAT_LATEST -> Value.GPT_5_1_CHAT_LATEST
                GPT_5 -> Value.GPT_5
                GPT_5_MINI -> Value.GPT_5_MINI
                GPT_5_NANO -> Value.GPT_5_NANO
                GPT_5_2025_08_07 -> Value.GPT_5_2025_08_07
                GPT_5_MINI_2025_08_07 -> Value.GPT_5_MINI_2025_08_07
                GPT_5_NANO_2025_08_07 -> Value.GPT_5_NANO_2025_08_07
                GPT_5_CHAT_LATEST -> Value.GPT_5_CHAT_LATEST
                GPT_4_1 -> Value.GPT_4_1
                GPT_4_1_MINI -> Value.GPT_4_1_MINI
                GPT_4_1_NANO -> Value.GPT_4_1_NANO
                GPT_4_1_2025_04_14 -> Value.GPT_4_1_2025_04_14
                GPT_4_1_MINI_2025_04_14 -> Value.GPT_4_1_MINI_2025_04_14
                GPT_4_1_NANO_2025_04_14 -> Value.GPT_4_1_NANO_2025_04_14
                O4_MINI -> Value.O4_MINI
                O4_MINI_2025_04_16 -> Value.O4_MINI_2025_04_16
                O3 -> Value.O3
                O3_2025_04_16 -> Value.O3_2025_04_16
                O3_MINI -> Value.O3_MINI
                O3_MINI_2025_01_31 -> Value.O3_MINI_2025_01_31
                O1 -> Value.O1
                O1_2024_12_17 -> Value.O1_2024_12_17
                O1_PREVIEW -> Value.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Value.O1_PREVIEW_2024_09_12
                O1_MINI -> Value.O1_MINI
                O1_MINI_2024_09_12 -> Value.O1_MINI_2024_09_12
                GPT_4O -> Value.GPT_4O
                GPT_4O_2024_11_20 -> Value.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Value.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Value.GPT_4O_2024_05_13
                GPT_4O_AUDIO_PREVIEW -> Value.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Value.GPT_4O_AUDIO_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW_2024_12_17 -> Value.GPT_4O_AUDIO_PREVIEW_2024_12_17
                GPT_4O_AUDIO_PREVIEW_2025_06_03 -> Value.GPT_4O_AUDIO_PREVIEW_2025_06_03
                GPT_4O_MINI_AUDIO_PREVIEW -> Value.GPT_4O_MINI_AUDIO_PREVIEW
                GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 -> Value.GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17
                GPT_4O_SEARCH_PREVIEW -> Value.GPT_4O_SEARCH_PREVIEW
                GPT_4O_MINI_SEARCH_PREVIEW -> Value.GPT_4O_MINI_SEARCH_PREVIEW
                GPT_4O_SEARCH_PREVIEW_2025_03_11 -> Value.GPT_4O_SEARCH_PREVIEW_2025_03_11
                GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 -> Value.GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11
                CHATGPT_4O_LATEST -> Value.CHATGPT_4O_LATEST
                CODEX_MINI_LATEST -> Value.CODEX_MINI_LATEST
                GPT_4O_MINI -> Value.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Value.GPT_4O_MINI_2024_07_18
                GPT_4_TURBO -> Value.GPT_4_TURBO
                GPT_4_TURBO_2024_04_09 -> Value.GPT_4_TURBO_2024_04_09
                GPT_4_0125_PREVIEW -> Value.GPT_4_0125_PREVIEW
                GPT_4_TURBO_PREVIEW -> Value.GPT_4_TURBO_PREVIEW
                GPT_4_1106_PREVIEW -> Value.GPT_4_1106_PREVIEW
                GPT_4_VISION_PREVIEW -> Value.GPT_4_VISION_PREVIEW
                GPT_4 -> Value.GPT_4
                GPT_4_0314 -> Value.GPT_4_0314
                GPT_4_0613 -> Value.GPT_4_0613
                GPT_4_32K -> Value.GPT_4_32K
                GPT_4_32K_0314 -> Value.GPT_4_32K_0314
                GPT_4_32K_0613 -> Value.GPT_4_32K_0613
                GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
                GPT_3_5_TURBO_16K -> Value.GPT_3_5_TURBO_16K
                GPT_3_5_TURBO_0301 -> Value.GPT_3_5_TURBO_0301
                GPT_3_5_TURBO_0613 -> Value.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Value.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Value.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Value.GPT_3_5_TURBO_16K_0613
                O1_PRO -> Value.O1_PRO
                O1_PRO_2025_03_19 -> Value.O1_PRO_2025_03_19
                O3_PRO -> Value.O3_PRO
                O3_PRO_2025_06_10 -> Value.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Value.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Value.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Value.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Value.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Value.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Value.COMPUTER_USE_PREVIEW_2025_03_11
                GPT_5_CODEX -> Value.GPT_5_CODEX
                GPT_5_PRO -> Value.GPT_5_PRO
                GPT_5_PRO_2025_10_06 -> Value.GPT_5_PRO_2025_10_06
                GPT_5_1_CODEX_MAX -> Value.GPT_5_1_CODEX_MAX
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
                GPT_5_6_SOL -> Known.GPT_5_6_SOL
                GPT_5_6_TERRA -> Known.GPT_5_6_TERRA
                GPT_5_6_LUNA -> Known.GPT_5_6_LUNA
                GPT_5_4 -> Known.GPT_5_4
                GPT_5_4_MINI -> Known.GPT_5_4_MINI
                GPT_5_4_NANO -> Known.GPT_5_4_NANO
                GPT_5_4_MINI_2026_03_17 -> Known.GPT_5_4_MINI_2026_03_17
                GPT_5_4_NANO_2026_03_17 -> Known.GPT_5_4_NANO_2026_03_17
                GPT_5_3_CHAT_LATEST -> Known.GPT_5_3_CHAT_LATEST
                GPT_5_2 -> Known.GPT_5_2
                GPT_5_2_2025_12_11 -> Known.GPT_5_2_2025_12_11
                GPT_5_2_CHAT_LATEST -> Known.GPT_5_2_CHAT_LATEST
                GPT_5_2_PRO -> Known.GPT_5_2_PRO
                GPT_5_2_PRO_2025_12_11 -> Known.GPT_5_2_PRO_2025_12_11
                GPT_5_1 -> Known.GPT_5_1
                GPT_5_1_2025_11_13 -> Known.GPT_5_1_2025_11_13
                GPT_5_1_CODEX -> Known.GPT_5_1_CODEX
                GPT_5_1_MINI -> Known.GPT_5_1_MINI
                GPT_5_1_CHAT_LATEST -> Known.GPT_5_1_CHAT_LATEST
                GPT_5 -> Known.GPT_5
                GPT_5_MINI -> Known.GPT_5_MINI
                GPT_5_NANO -> Known.GPT_5_NANO
                GPT_5_2025_08_07 -> Known.GPT_5_2025_08_07
                GPT_5_MINI_2025_08_07 -> Known.GPT_5_MINI_2025_08_07
                GPT_5_NANO_2025_08_07 -> Known.GPT_5_NANO_2025_08_07
                GPT_5_CHAT_LATEST -> Known.GPT_5_CHAT_LATEST
                GPT_4_1 -> Known.GPT_4_1
                GPT_4_1_MINI -> Known.GPT_4_1_MINI
                GPT_4_1_NANO -> Known.GPT_4_1_NANO
                GPT_4_1_2025_04_14 -> Known.GPT_4_1_2025_04_14
                GPT_4_1_MINI_2025_04_14 -> Known.GPT_4_1_MINI_2025_04_14
                GPT_4_1_NANO_2025_04_14 -> Known.GPT_4_1_NANO_2025_04_14
                O4_MINI -> Known.O4_MINI
                O4_MINI_2025_04_16 -> Known.O4_MINI_2025_04_16
                O3 -> Known.O3
                O3_2025_04_16 -> Known.O3_2025_04_16
                O3_MINI -> Known.O3_MINI
                O3_MINI_2025_01_31 -> Known.O3_MINI_2025_01_31
                O1 -> Known.O1
                O1_2024_12_17 -> Known.O1_2024_12_17
                O1_PREVIEW -> Known.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Known.O1_PREVIEW_2024_09_12
                O1_MINI -> Known.O1_MINI
                O1_MINI_2024_09_12 -> Known.O1_MINI_2024_09_12
                GPT_4O -> Known.GPT_4O
                GPT_4O_2024_11_20 -> Known.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Known.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Known.GPT_4O_2024_05_13
                GPT_4O_AUDIO_PREVIEW -> Known.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Known.GPT_4O_AUDIO_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW_2024_12_17 -> Known.GPT_4O_AUDIO_PREVIEW_2024_12_17
                GPT_4O_AUDIO_PREVIEW_2025_06_03 -> Known.GPT_4O_AUDIO_PREVIEW_2025_06_03
                GPT_4O_MINI_AUDIO_PREVIEW -> Known.GPT_4O_MINI_AUDIO_PREVIEW
                GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17 -> Known.GPT_4O_MINI_AUDIO_PREVIEW_2024_12_17
                GPT_4O_SEARCH_PREVIEW -> Known.GPT_4O_SEARCH_PREVIEW
                GPT_4O_MINI_SEARCH_PREVIEW -> Known.GPT_4O_MINI_SEARCH_PREVIEW
                GPT_4O_SEARCH_PREVIEW_2025_03_11 -> Known.GPT_4O_SEARCH_PREVIEW_2025_03_11
                GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11 -> Known.GPT_4O_MINI_SEARCH_PREVIEW_2025_03_11
                CHATGPT_4O_LATEST -> Known.CHATGPT_4O_LATEST
                CODEX_MINI_LATEST -> Known.CODEX_MINI_LATEST
                GPT_4O_MINI -> Known.GPT_4O_MINI
                GPT_4O_MINI_2024_07_18 -> Known.GPT_4O_MINI_2024_07_18
                GPT_4_TURBO -> Known.GPT_4_TURBO
                GPT_4_TURBO_2024_04_09 -> Known.GPT_4_TURBO_2024_04_09
                GPT_4_0125_PREVIEW -> Known.GPT_4_0125_PREVIEW
                GPT_4_TURBO_PREVIEW -> Known.GPT_4_TURBO_PREVIEW
                GPT_4_1106_PREVIEW -> Known.GPT_4_1106_PREVIEW
                GPT_4_VISION_PREVIEW -> Known.GPT_4_VISION_PREVIEW
                GPT_4 -> Known.GPT_4
                GPT_4_0314 -> Known.GPT_4_0314
                GPT_4_0613 -> Known.GPT_4_0613
                GPT_4_32K -> Known.GPT_4_32K
                GPT_4_32K_0314 -> Known.GPT_4_32K_0314
                GPT_4_32K_0613 -> Known.GPT_4_32K_0613
                GPT_3_5_TURBO -> Known.GPT_3_5_TURBO
                GPT_3_5_TURBO_16K -> Known.GPT_3_5_TURBO_16K
                GPT_3_5_TURBO_0301 -> Known.GPT_3_5_TURBO_0301
                GPT_3_5_TURBO_0613 -> Known.GPT_3_5_TURBO_0613
                GPT_3_5_TURBO_1106 -> Known.GPT_3_5_TURBO_1106
                GPT_3_5_TURBO_0125 -> Known.GPT_3_5_TURBO_0125
                GPT_3_5_TURBO_16K_0613 -> Known.GPT_3_5_TURBO_16K_0613
                O1_PRO -> Known.O1_PRO
                O1_PRO_2025_03_19 -> Known.O1_PRO_2025_03_19
                O3_PRO -> Known.O3_PRO
                O3_PRO_2025_06_10 -> Known.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Known.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Known.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Known.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Known.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Known.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Known.COMPUTER_USE_PREVIEW_2025_03_11
                GPT_5_CODEX -> Known.GPT_5_CODEX
                GPT_5_PRO -> Known.GPT_5_PRO
                GPT_5_PRO_2025_10_06 -> Known.GPT_5_PRO_2025_10_06
                GPT_5_1_CODEX_MAX -> Known.GPT_5_1_CODEX_MAX
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Model = apply {
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

            return other is Model && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val betaToolChoiceOptions: BetaToolChoiceOptions? = null,
        private val betaToolChoiceAllowed: BetaToolChoiceAllowed? = null,
        private val betaToolChoiceTypes: BetaToolChoiceTypes? = null,
        private val betaToolChoiceFunction: BetaToolChoiceFunction? = null,
        private val betaToolChoiceMcp: BetaToolChoiceMcp? = null,
        private val betaToolChoiceCustom: BetaToolChoiceCustom? = null,
        private val betaSpecificProgrammaticToolCallingParam: JsonValue? = null,
        private val betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch? = null,
        private val betaToolChoiceShell: BetaToolChoiceShell? = null,
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
        fun betaToolChoiceOptions(): Optional<BetaToolChoiceOptions> =
            Optional.ofNullable(betaToolChoiceOptions)

        /** Constrains the tools available to the model to a pre-defined set. */
        fun betaToolChoiceAllowed(): Optional<BetaToolChoiceAllowed> =
            Optional.ofNullable(betaToolChoiceAllowed)

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun betaToolChoiceTypes(): Optional<BetaToolChoiceTypes> =
            Optional.ofNullable(betaToolChoiceTypes)

        /** Use this option to force the model to call a specific function. */
        fun betaToolChoiceFunction(): Optional<BetaToolChoiceFunction> =
            Optional.ofNullable(betaToolChoiceFunction)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun betaToolChoiceMcp(): Optional<BetaToolChoiceMcp> =
            Optional.ofNullable(betaToolChoiceMcp)

        /** Use this option to force the model to call a specific custom tool. */
        fun betaToolChoiceCustom(): Optional<BetaToolChoiceCustom> =
            Optional.ofNullable(betaToolChoiceCustom)

        fun betaSpecificProgrammaticToolCallingParam(): Optional<JsonValue> =
            Optional.ofNullable(betaSpecificProgrammaticToolCallingParam)

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun betaToolChoiceApplyPatch(): Optional<BetaToolChoiceApplyPatch> =
            Optional.ofNullable(betaToolChoiceApplyPatch)

        /** Forces the model to call the shell tool when a tool call is required. */
        fun betaToolChoiceShell(): Optional<BetaToolChoiceShell> =
            Optional.ofNullable(betaToolChoiceShell)

        fun isBetaToolChoiceOptions(): Boolean = betaToolChoiceOptions != null

        fun isBetaToolChoiceAllowed(): Boolean = betaToolChoiceAllowed != null

        fun isBetaToolChoiceTypes(): Boolean = betaToolChoiceTypes != null

        fun isBetaToolChoiceFunction(): Boolean = betaToolChoiceFunction != null

        fun isBetaToolChoiceMcp(): Boolean = betaToolChoiceMcp != null

        fun isBetaToolChoiceCustom(): Boolean = betaToolChoiceCustom != null

        fun isBetaSpecificProgrammaticToolCallingParam(): Boolean =
            betaSpecificProgrammaticToolCallingParam != null

        fun isBetaToolChoiceApplyPatch(): Boolean = betaToolChoiceApplyPatch != null

        fun isBetaToolChoiceShell(): Boolean = betaToolChoiceShell != null

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
        fun asBetaToolChoiceOptions(): BetaToolChoiceOptions =
            betaToolChoiceOptions.getOrThrow("betaToolChoiceOptions")

        /** Constrains the tools available to the model to a pre-defined set. */
        fun asBetaToolChoiceAllowed(): BetaToolChoiceAllowed =
            betaToolChoiceAllowed.getOrThrow("betaToolChoiceAllowed")

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asBetaToolChoiceTypes(): BetaToolChoiceTypes =
            betaToolChoiceTypes.getOrThrow("betaToolChoiceTypes")

        /** Use this option to force the model to call a specific function. */
        fun asBetaToolChoiceFunction(): BetaToolChoiceFunction =
            betaToolChoiceFunction.getOrThrow("betaToolChoiceFunction")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asBetaToolChoiceMcp(): BetaToolChoiceMcp =
            betaToolChoiceMcp.getOrThrow("betaToolChoiceMcp")

        /** Use this option to force the model to call a specific custom tool. */
        fun asBetaToolChoiceCustom(): BetaToolChoiceCustom =
            betaToolChoiceCustom.getOrThrow("betaToolChoiceCustom")

        fun asBetaSpecificProgrammaticToolCallingParam(): JsonValue =
            betaSpecificProgrammaticToolCallingParam.getOrThrow(
                "betaSpecificProgrammaticToolCallingParam"
            )

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun asBetaToolChoiceApplyPatch(): BetaToolChoiceApplyPatch =
            betaToolChoiceApplyPatch.getOrThrow("betaToolChoiceApplyPatch")

        /** Forces the model to call the shell tool when a tool call is required. */
        fun asBetaToolChoiceShell(): BetaToolChoiceShell =
            betaToolChoiceShell.getOrThrow("betaToolChoiceShell")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = toolChoice.accept(new ToolChoice.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitBetaToolChoiceOptions(BetaToolChoiceOptions betaToolChoiceOptions) {
         *         return Optional.of(betaToolChoiceOptions.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                betaToolChoiceOptions != null ->
                    visitor.visitBetaToolChoiceOptions(betaToolChoiceOptions)
                betaToolChoiceAllowed != null ->
                    visitor.visitBetaToolChoiceAllowed(betaToolChoiceAllowed)
                betaToolChoiceTypes != null -> visitor.visitBetaToolChoiceTypes(betaToolChoiceTypes)
                betaToolChoiceFunction != null ->
                    visitor.visitBetaToolChoiceFunction(betaToolChoiceFunction)
                betaToolChoiceMcp != null -> visitor.visitBetaToolChoiceMcp(betaToolChoiceMcp)
                betaToolChoiceCustom != null ->
                    visitor.visitBetaToolChoiceCustom(betaToolChoiceCustom)
                betaSpecificProgrammaticToolCallingParam != null ->
                    visitor.visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam
                    )
                betaToolChoiceApplyPatch != null ->
                    visitor.visitBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)
                betaToolChoiceShell != null -> visitor.visitBetaToolChoiceShell(betaToolChoiceShell)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBetaToolChoiceOptions(
                        betaToolChoiceOptions: BetaToolChoiceOptions
                    ) {
                        betaToolChoiceOptions.validate()
                    }

                    override fun visitBetaToolChoiceAllowed(
                        betaToolChoiceAllowed: BetaToolChoiceAllowed
                    ) {
                        betaToolChoiceAllowed.validate()
                    }

                    override fun visitBetaToolChoiceTypes(
                        betaToolChoiceTypes: BetaToolChoiceTypes
                    ) {
                        betaToolChoiceTypes.validate()
                    }

                    override fun visitBetaToolChoiceFunction(
                        betaToolChoiceFunction: BetaToolChoiceFunction
                    ) {
                        betaToolChoiceFunction.validate()
                    }

                    override fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) {
                        betaToolChoiceMcp.validate()
                    }

                    override fun visitBetaToolChoiceCustom(
                        betaToolChoiceCustom: BetaToolChoiceCustom
                    ) {
                        betaToolChoiceCustom.validate()
                    }

                    override fun visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam: JsonValue
                    ) {
                        betaSpecificProgrammaticToolCallingParam.let {
                            if (
                                it != JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                            ) {
                                throw OpenAIInvalidDataException(
                                    "'betaSpecificProgrammaticToolCallingParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitBetaToolChoiceApplyPatch(
                        betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch
                    ) {
                        betaToolChoiceApplyPatch.validate()
                    }

                    override fun visitBetaToolChoiceShell(
                        betaToolChoiceShell: BetaToolChoiceShell
                    ) {
                        betaToolChoiceShell.validate()
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
                    override fun visitBetaToolChoiceOptions(
                        betaToolChoiceOptions: BetaToolChoiceOptions
                    ) = betaToolChoiceOptions.validity()

                    override fun visitBetaToolChoiceAllowed(
                        betaToolChoiceAllowed: BetaToolChoiceAllowed
                    ) = betaToolChoiceAllowed.validity()

                    override fun visitBetaToolChoiceTypes(
                        betaToolChoiceTypes: BetaToolChoiceTypes
                    ) = betaToolChoiceTypes.validity()

                    override fun visitBetaToolChoiceFunction(
                        betaToolChoiceFunction: BetaToolChoiceFunction
                    ) = betaToolChoiceFunction.validity()

                    override fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) =
                        betaToolChoiceMcp.validity()

                    override fun visitBetaToolChoiceCustom(
                        betaToolChoiceCustom: BetaToolChoiceCustom
                    ) = betaToolChoiceCustom.validity()

                    override fun visitBetaSpecificProgrammaticToolCallingParam(
                        betaSpecificProgrammaticToolCallingParam: JsonValue
                    ) =
                        betaSpecificProgrammaticToolCallingParam.let {
                            if (it == JsonValue.from(mapOf("type" to "programmatic_tool_calling")))
                                1
                            else 0
                        }

                    override fun visitBetaToolChoiceApplyPatch(
                        betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch
                    ) = betaToolChoiceApplyPatch.validity()

                    override fun visitBetaToolChoiceShell(
                        betaToolChoiceShell: BetaToolChoiceShell
                    ) = betaToolChoiceShell.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                betaToolChoiceOptions == other.betaToolChoiceOptions &&
                betaToolChoiceAllowed == other.betaToolChoiceAllowed &&
                betaToolChoiceTypes == other.betaToolChoiceTypes &&
                betaToolChoiceFunction == other.betaToolChoiceFunction &&
                betaToolChoiceMcp == other.betaToolChoiceMcp &&
                betaToolChoiceCustom == other.betaToolChoiceCustom &&
                betaSpecificProgrammaticToolCallingParam ==
                    other.betaSpecificProgrammaticToolCallingParam &&
                betaToolChoiceApplyPatch == other.betaToolChoiceApplyPatch &&
                betaToolChoiceShell == other.betaToolChoiceShell
        }

        override fun hashCode(): Int =
            Objects.hash(
                betaToolChoiceOptions,
                betaToolChoiceAllowed,
                betaToolChoiceTypes,
                betaToolChoiceFunction,
                betaToolChoiceMcp,
                betaToolChoiceCustom,
                betaSpecificProgrammaticToolCallingParam,
                betaToolChoiceApplyPatch,
                betaToolChoiceShell,
            )

        override fun toString(): String =
            when {
                betaToolChoiceOptions != null ->
                    "ToolChoice{betaToolChoiceOptions=$betaToolChoiceOptions}"
                betaToolChoiceAllowed != null ->
                    "ToolChoice{betaToolChoiceAllowed=$betaToolChoiceAllowed}"
                betaToolChoiceTypes != null ->
                    "ToolChoice{betaToolChoiceTypes=$betaToolChoiceTypes}"
                betaToolChoiceFunction != null ->
                    "ToolChoice{betaToolChoiceFunction=$betaToolChoiceFunction}"
                betaToolChoiceMcp != null -> "ToolChoice{betaToolChoiceMcp=$betaToolChoiceMcp}"
                betaToolChoiceCustom != null ->
                    "ToolChoice{betaToolChoiceCustom=$betaToolChoiceCustom}"
                betaSpecificProgrammaticToolCallingParam != null ->
                    "ToolChoice{betaSpecificProgrammaticToolCallingParam=$betaSpecificProgrammaticToolCallingParam}"
                betaToolChoiceApplyPatch != null ->
                    "ToolChoice{betaToolChoiceApplyPatch=$betaToolChoiceApplyPatch}"
                betaToolChoiceShell != null ->
                    "ToolChoice{betaToolChoiceShell=$betaToolChoiceShell}"
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
            @JvmStatic
            fun ofBetaToolChoiceOptions(betaToolChoiceOptions: BetaToolChoiceOptions) =
                ToolChoice(betaToolChoiceOptions = betaToolChoiceOptions)

            /** Constrains the tools available to the model to a pre-defined set. */
            @JvmStatic
            fun ofBetaToolChoiceAllowed(betaToolChoiceAllowed: BetaToolChoiceAllowed) =
                ToolChoice(betaToolChoiceAllowed = betaToolChoiceAllowed)

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            @JvmStatic
            fun ofBetaToolChoiceTypes(betaToolChoiceTypes: BetaToolChoiceTypes) =
                ToolChoice(betaToolChoiceTypes = betaToolChoiceTypes)

            /** Use this option to force the model to call a specific function. */
            @JvmStatic
            fun ofBetaToolChoiceFunction(betaToolChoiceFunction: BetaToolChoiceFunction) =
                ToolChoice(betaToolChoiceFunction = betaToolChoiceFunction)

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            @JvmStatic
            fun ofBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp) =
                ToolChoice(betaToolChoiceMcp = betaToolChoiceMcp)

            /** Use this option to force the model to call a specific custom tool. */
            @JvmStatic
            fun ofBetaToolChoiceCustom(betaToolChoiceCustom: BetaToolChoiceCustom) =
                ToolChoice(betaToolChoiceCustom = betaToolChoiceCustom)

            @JvmStatic
            fun ofBetaSpecificProgrammaticToolCallingParam() =
                ToolChoice(
                    betaSpecificProgrammaticToolCallingParam =
                        JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                )

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            @JvmStatic
            fun ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) =
                ToolChoice(betaToolChoiceApplyPatch = betaToolChoiceApplyPatch)

            /** Forces the model to call the shell tool when a tool call is required. */
            @JvmStatic
            fun ofBetaToolChoiceShell(betaToolChoiceShell: BetaToolChoiceShell) =
                ToolChoice(betaToolChoiceShell = betaToolChoiceShell)
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
            fun visitBetaToolChoiceOptions(betaToolChoiceOptions: BetaToolChoiceOptions): T

            /** Constrains the tools available to the model to a pre-defined set. */
            fun visitBetaToolChoiceAllowed(betaToolChoiceAllowed: BetaToolChoiceAllowed): T

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun visitBetaToolChoiceTypes(betaToolChoiceTypes: BetaToolChoiceTypes): T

            /** Use this option to force the model to call a specific function. */
            fun visitBetaToolChoiceFunction(betaToolChoiceFunction: BetaToolChoiceFunction): T

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
            fun visitBetaToolChoiceMcp(betaToolChoiceMcp: BetaToolChoiceMcp): T

            /** Use this option to force the model to call a specific custom tool. */
            fun visitBetaToolChoiceCustom(betaToolChoiceCustom: BetaToolChoiceCustom): T

            fun visitBetaSpecificProgrammaticToolCallingParam(
                betaSpecificProgrammaticToolCallingParam: JsonValue
            ): T

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            fun visitBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch): T

            /** Forces the model to call the shell tool when a tool call is required. */
            fun visitBetaToolChoiceShell(betaToolChoiceShell: BetaToolChoiceShell): T

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
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let {
                                    ToolChoice(
                                        betaSpecificProgrammaticToolCallingParam = it,
                                        _json = json,
                                    )
                                }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceOptions>())?.let {
                                ToolChoice(betaToolChoiceOptions = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceAllowed>())?.let {
                                ToolChoice(betaToolChoiceAllowed = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceTypes>())?.let {
                                ToolChoice(betaToolChoiceTypes = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceFunction>())?.let {
                                ToolChoice(betaToolChoiceFunction = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceMcp>())?.let {
                                ToolChoice(betaToolChoiceMcp = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceCustom>())?.let {
                                ToolChoice(betaToolChoiceCustom = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceApplyPatch>())?.let {
                                ToolChoice(betaToolChoiceApplyPatch = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<BetaToolChoiceShell>())?.let {
                                ToolChoice(betaToolChoiceShell = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
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
                    value.betaToolChoiceOptions != null ->
                        generator.writeObject(value.betaToolChoiceOptions)
                    value.betaToolChoiceAllowed != null ->
                        generator.writeObject(value.betaToolChoiceAllowed)
                    value.betaToolChoiceTypes != null ->
                        generator.writeObject(value.betaToolChoiceTypes)
                    value.betaToolChoiceFunction != null ->
                        generator.writeObject(value.betaToolChoiceFunction)
                    value.betaToolChoiceMcp != null ->
                        generator.writeObject(value.betaToolChoiceMcp)
                    value.betaToolChoiceCustom != null ->
                        generator.writeObject(value.betaToolChoiceCustom)
                    value.betaSpecificProgrammaticToolCallingParam != null ->
                        generator.writeObject(value.betaSpecificProgrammaticToolCallingParam)
                    value.betaToolChoiceApplyPatch != null ->
                        generator.writeObject(value.betaToolChoiceApplyPatch)
                    value.betaToolChoiceShell != null ->
                        generator.writeObject(value.betaToolChoiceShell)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * The conversation that this response belonged to. Input items and output items from this
     * response were automatically added to this conversation.
     */
    class Conversation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of()
        ) : this(id, mutableMapOf())

        /**
         * The unique ID of the conversation that this response was associated with.
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

            /** The unique ID of the conversation that this response was associated with. */
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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
     * Moderation results for the response input and output, if moderated completions were
     * requested.
     */
    class Moderation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<Input>,
        private val output: JsonField<Output>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
        ) : this(input, output, mutableMapOf())

        /**
         * Moderation for the response input.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): Input = input.getRequired("input")

        /**
         * Moderation for the response output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): Output = output.getRequired("output")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

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
             * Returns a mutable builder for constructing an instance of [Moderation].
             *
             * The following fields are required:
             * ```java
             * .input()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Moderation]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var output: JsonField<Output>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderation: Moderation) = apply {
                input = moderation.input
                output = moderation.output
                additionalProperties = moderation.additionalProperties.toMutableMap()
            }

            /** Moderation for the response input. */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofModerationResult(moderationResult)`. */
            fun input(moderationResult: Input.ModerationResult) =
                input(Input.ofModerationResult(moderationResult))

            /** Alias for calling [input] with `Input.ofError(error)`. */
            fun input(error: Input.Error) = input(Input.ofError(error))

            /** Moderation for the response output. */
            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

            /** Alias for calling [output] with `Output.ofModerationResult(moderationResult)`. */
            fun output(moderationResult: Output.ModerationResult) =
                output(Output.ofModerationResult(moderationResult))

            /** Alias for calling [output] with `Output.ofError(error)`. */
            fun output(error: Output.Error) = output(Output.ofError(error))

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
             * Returns an immutable instance of [Moderation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Moderation =
                Moderation(
                    checkRequired("input", input),
                    checkRequired("output", output),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Moderation = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            output().validate()
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
            (input.asKnown().getOrNull()?.validity() ?: 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0)

        /** Moderation for the response input. */
        @JsonDeserialize(using = Input.Deserializer::class)
        @JsonSerialize(using = Input.Serializer::class)
        class Input
        private constructor(
            private val moderationResult: ModerationResult? = null,
            private val error: Error? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A moderation result produced for the response input or output. */
            fun moderationResult(): Optional<ModerationResult> =
                Optional.ofNullable(moderationResult)

            /** An error produced while attempting moderation for the response input or output. */
            fun error(): Optional<Error> = Optional.ofNullable(error)

            fun isModerationResult(): Boolean = moderationResult != null

            fun isError(): Boolean = error != null

            /** A moderation result produced for the response input or output. */
            fun asModerationResult(): ModerationResult =
                moderationResult.getOrThrow("moderationResult")

            /** An error produced while attempting moderation for the response input or output. */
            fun asError(): Error = error.getOrThrow("error")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitModerationResult(ModerationResult moderationResult) {
             *         return Optional.of(moderationResult.toString());
             *     }
             *
             *     // ...
             *
             *     @Override
             *     public Optional<String> unknown(JsonValue json) {
             *         // Or inspect the `json`.
             *         return Optional.empty();
             *     }
             * });
             * ```
             *
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    moderationResult != null -> visitor.visitModerationResult(moderationResult)
                    error != null -> visitor.visitError(error)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Input = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitModerationResult(moderationResult: ModerationResult) {
                            moderationResult.validate()
                        }

                        override fun visitError(error: Error) {
                            error.validate()
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
                        override fun visitModerationResult(moderationResult: ModerationResult) =
                            moderationResult.validity()

                        override fun visitError(error: Error) = error.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Input &&
                    moderationResult == other.moderationResult &&
                    error == other.error
            }

            override fun hashCode(): Int = Objects.hash(moderationResult, error)

            override fun toString(): String =
                when {
                    moderationResult != null -> "Input{moderationResult=$moderationResult}"
                    error != null -> "Input{error=$error}"
                    _json != null -> "Input{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Input")
                }

            companion object {

                /** A moderation result produced for the response input or output. */
                @JvmStatic
                fun ofModerationResult(moderationResult: ModerationResult) =
                    Input(moderationResult = moderationResult)

                /**
                 * An error produced while attempting moderation for the response input or output.
                 */
                @JvmStatic fun ofError(error: Error) = Input(error = error)
            }

            /**
             * An interface that defines how to map each variant of [Input] to a value of type [T].
             */
            interface Visitor<out T> {

                /** A moderation result produced for the response input or output. */
                fun visitModerationResult(moderationResult: ModerationResult): T

                /**
                 * An error produced while attempting moderation for the response input or output.
                 */
                fun visitError(error: Error): T

                /**
                 * Maps an unknown variant of [Input] to a value of type [T].
                 *
                 * An instance of [Input] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Input: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Input>(Input::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Input {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "moderation_result" -> {
                            return tryDeserialize(node, jacksonTypeRef<ModerationResult>())?.let {
                                Input(moderationResult = it, _json = json)
                            } ?: Input(_json = json)
                        }
                        "error" -> {
                            return tryDeserialize(node, jacksonTypeRef<Error>())?.let {
                                Input(error = it, _json = json)
                            } ?: Input(_json = json)
                        }
                    }

                    return Input(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Input>(Input::class) {

                override fun serialize(
                    value: Input,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.moderationResult != null ->
                            generator.writeObject(value.moderationResult)
                        value.error != null -> generator.writeObject(value.error)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Input")
                    }
                }
            }

            /** A moderation result produced for the response input or output. */
            class ModerationResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val categories: JsonField<Categories>,
                private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>,
                private val categoryScores: JsonField<CategoryScores>,
                private val flagged: JsonField<Boolean>,
                private val model: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("categories")
                    @ExcludeMissing
                    categories: JsonField<Categories> = JsonMissing.of(),
                    @JsonProperty("category_applied_input_types")
                    @ExcludeMissing
                    categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> =
                        JsonMissing.of(),
                    @JsonProperty("category_scores")
                    @ExcludeMissing
                    categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
                    @JsonProperty("flagged")
                    @ExcludeMissing
                    flagged: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(
                    categories,
                    categoryAppliedInputTypes,
                    categoryScores,
                    flagged,
                    model,
                    type,
                    mutableMapOf(),
                )

                /**
                 * A dictionary of moderation categories to booleans, True if the input is flagged
                 * under this category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categories(): Categories = categories.getRequired("categories")

                /**
                 * Which modalities of input are reflected by the score for each category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
                    categoryAppliedInputTypes.getRequired("category_applied_input_types")

                /**
                 * A dictionary of moderation categories to scores.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

                /**
                 * A boolean indicating whether the content was flagged by any category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun flagged(): Boolean = flagged.getRequired("flagged")

                /**
                 * The moderation model that produced this result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun model(): String = model.getRequired("model")

                /**
                 * The object type, which was always `moderation_result` for successful moderation
                 * results.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("moderation_result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [categories].
                 *
                 * Unlike [categories], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("categories")
                @ExcludeMissing
                fun _categories(): JsonField<Categories> = categories

                /**
                 * Returns the raw JSON value of [categoryAppliedInputTypes].
                 *
                 * Unlike [categoryAppliedInputTypes], this method doesn't throw if the JSON field
                 * has an unexpected type.
                 */
                @JsonProperty("category_applied_input_types")
                @ExcludeMissing
                fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
                    categoryAppliedInputTypes

                /**
                 * Returns the raw JSON value of [categoryScores].
                 *
                 * Unlike [categoryScores], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("category_scores")
                @ExcludeMissing
                fun _categoryScores(): JsonField<CategoryScores> = categoryScores

                /**
                 * Returns the raw JSON value of [flagged].
                 *
                 * Unlike [flagged], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("flagged")
                @ExcludeMissing
                fun _flagged(): JsonField<Boolean> = flagged

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                     * Returns a mutable builder for constructing an instance of [ModerationResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .categories()
                     * .categoryAppliedInputTypes()
                     * .categoryScores()
                     * .flagged()
                     * .model()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ModerationResult]. */
                class Builder internal constructor() {

                    private var categories: JsonField<Categories>? = null
                    private var categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>? =
                        null
                    private var categoryScores: JsonField<CategoryScores>? = null
                    private var flagged: JsonField<Boolean>? = null
                    private var model: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("moderation_result")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(moderationResult: ModerationResult) = apply {
                        categories = moderationResult.categories
                        categoryAppliedInputTypes = moderationResult.categoryAppliedInputTypes
                        categoryScores = moderationResult.categoryScores
                        flagged = moderationResult.flagged
                        model = moderationResult.model
                        type = moderationResult.type
                        additionalProperties = moderationResult.additionalProperties.toMutableMap()
                    }

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     */
                    fun categories(categories: Categories) = categories(JsonField.of(categories))

                    /**
                     * Sets [Builder.categories] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categories] with a well-typed [Categories]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun categories(categories: JsonField<Categories>) = apply {
                        this.categories = categories
                    }

                    /** Which modalities of input are reflected by the score for each category. */
                    fun categoryAppliedInputTypes(
                        categoryAppliedInputTypes: CategoryAppliedInputTypes
                    ) = categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

                    /**
                     * Sets [Builder.categoryAppliedInputTypes] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categoryAppliedInputTypes] with a well-typed
                     * [CategoryAppliedInputTypes] value instead. This method is primarily for
                     * setting the field to an undocumented or not yet supported value.
                     */
                    fun categoryAppliedInputTypes(
                        categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
                    ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

                    /** A dictionary of moderation categories to scores. */
                    fun categoryScores(categoryScores: CategoryScores) =
                        categoryScores(JsonField.of(categoryScores))

                    /**
                     * Sets [Builder.categoryScores] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categoryScores] with a well-typed
                     * [CategoryScores] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
                        this.categoryScores = categoryScores
                    }

                    /** A boolean indicating whether the content was flagged by any category. */
                    fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

                    /**
                     * Sets [Builder.flagged] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.flagged] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

                    /** The moderation model that produced this result. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("moderation_result")
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
                     * Returns an immutable instance of [ModerationResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .categories()
                     * .categoryAppliedInputTypes()
                     * .categoryScores()
                     * .flagged()
                     * .model()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ModerationResult =
                        ModerationResult(
                            checkRequired("categories", categories),
                            checkRequired("categoryAppliedInputTypes", categoryAppliedInputTypes),
                            checkRequired("categoryScores", categoryScores),
                            checkRequired("flagged", flagged),
                            checkRequired("model", model),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): ModerationResult = apply {
                    if (validated) {
                        return@apply
                    }

                    categories().validate()
                    categoryAppliedInputTypes().validate()
                    categoryScores().validate()
                    flagged()
                    model()
                    _type().let {
                        if (it != JsonValue.from("moderation_result")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
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
                    (categories.asKnown().getOrNull()?.validity() ?: 0) +
                        (categoryAppliedInputTypes.asKnown().getOrNull()?.validity() ?: 0) +
                        (categoryScores.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (flagged.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("moderation_result")) 1 else 0 }

                /**
                 * A dictionary of moderation categories to booleans, True if the input is flagged
                 * under this category.
                 */
                class Categories
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

                        /**
                         * Returns a mutable builder for constructing an instance of [Categories].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Categories]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categories: Categories) = apply {
                            additionalProperties = categories.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [Categories].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Categories = Categories(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Categories = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Categories &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Categories{additionalProperties=$additionalProperties}"
                }

                /** Which modalities of input are reflected by the score for each category. */
                class CategoryAppliedInputTypes
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

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [CategoryAppliedInputTypes].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [CategoryAppliedInputTypes]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categoryAppliedInputTypes: CategoryAppliedInputTypes) =
                            apply {
                                additionalProperties =
                                    categoryAppliedInputTypes.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [CategoryAppliedInputTypes].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): CategoryAppliedInputTypes =
                            CategoryAppliedInputTypes(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): CategoryAppliedInputTypes = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is CategoryAppliedInputTypes &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "CategoryAppliedInputTypes{additionalProperties=$additionalProperties}"
                }

                /** A dictionary of moderation categories to scores. */
                class CategoryScores
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

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [CategoryScores].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [CategoryScores]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categoryScores: CategoryScores) = apply {
                            additionalProperties =
                                categoryScores.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [CategoryScores].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): CategoryScores =
                            CategoryScores(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): CategoryScores = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is CategoryScores &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "CategoryScores{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ModerationResult &&
                        categories == other.categories &&
                        categoryAppliedInputTypes == other.categoryAppliedInputTypes &&
                        categoryScores == other.categoryScores &&
                        flagged == other.flagged &&
                        model == other.model &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        categories,
                        categoryAppliedInputTypes,
                        categoryScores,
                        flagged,
                        model,
                        type,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ModerationResult{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, model=$model, type=$type, additionalProperties=$additionalProperties}"
            }

            /** An error produced while attempting moderation for the response input or output. */
            class Error
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val code: JsonField<String>,
                private val message: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("code")
                    @ExcludeMissing
                    code: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message")
                    @ExcludeMissing
                    message: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(code, message, type, mutableMapOf())

                /**
                 * The error code.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun code(): String = code.getRequired("code")

                /**
                 * The error message.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun message(): String = message.getRequired("message")

                /**
                 * The object type, which was always `error` for moderation failures.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("error")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var code: JsonField<String>? = null
                    private var message: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("error")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(error: Error) = apply {
                        code = error.code
                        message = error.message
                        type = error.type
                        additionalProperties = error.additionalProperties.toMutableMap()
                    }

                    /** The error code. */
                    fun code(code: String) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<String>) = apply { this.code = code }

                    /** The error message. */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun message(message: JsonField<String>) = apply { this.message = message }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("error")
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
                     * Returns an immutable instance of [Error].
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
                    fun build(): Error =
                        Error(
                            checkRequired("code", code),
                            checkRequired("message", message),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    code()
                    message()
                    _type().let {
                        if (it != JsonValue.from("error")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
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
                    (if (code.asKnown().isPresent) 1 else 0) +
                        (if (message.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("error")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Error &&
                        code == other.code &&
                        message == other.message &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        /** Moderation for the response output. */
        @JsonDeserialize(using = Output.Deserializer::class)
        @JsonSerialize(using = Output.Serializer::class)
        class Output
        private constructor(
            private val moderationResult: ModerationResult? = null,
            private val error: Error? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A moderation result produced for the response input or output. */
            fun moderationResult(): Optional<ModerationResult> =
                Optional.ofNullable(moderationResult)

            /** An error produced while attempting moderation for the response input or output. */
            fun error(): Optional<Error> = Optional.ofNullable(error)

            fun isModerationResult(): Boolean = moderationResult != null

            fun isError(): Boolean = error != null

            /** A moderation result produced for the response input or output. */
            fun asModerationResult(): ModerationResult =
                moderationResult.getOrThrow("moderationResult")

            /** An error produced while attempting moderation for the response input or output. */
            fun asError(): Error = error.getOrThrow("error")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = output.accept(new Output.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitModerationResult(ModerationResult moderationResult) {
             *         return Optional.of(moderationResult.toString());
             *     }
             *
             *     // ...
             *
             *     @Override
             *     public Optional<String> unknown(JsonValue json) {
             *         // Or inspect the `json`.
             *         return Optional.empty();
             *     }
             * });
             * ```
             *
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    moderationResult != null -> visitor.visitModerationResult(moderationResult)
                    error != null -> visitor.visitError(error)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitModerationResult(moderationResult: ModerationResult) {
                            moderationResult.validate()
                        }

                        override fun visitError(error: Error) {
                            error.validate()
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
                        override fun visitModerationResult(moderationResult: ModerationResult) =
                            moderationResult.validity()

                        override fun visitError(error: Error) = error.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    moderationResult == other.moderationResult &&
                    error == other.error
            }

            override fun hashCode(): Int = Objects.hash(moderationResult, error)

            override fun toString(): String =
                when {
                    moderationResult != null -> "Output{moderationResult=$moderationResult}"
                    error != null -> "Output{error=$error}"
                    _json != null -> "Output{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Output")
                }

            companion object {

                /** A moderation result produced for the response input or output. */
                @JvmStatic
                fun ofModerationResult(moderationResult: ModerationResult) =
                    Output(moderationResult = moderationResult)

                /**
                 * An error produced while attempting moderation for the response input or output.
                 */
                @JvmStatic fun ofError(error: Error) = Output(error = error)
            }

            /**
             * An interface that defines how to map each variant of [Output] to a value of type [T].
             */
            interface Visitor<out T> {

                /** A moderation result produced for the response input or output. */
                fun visitModerationResult(moderationResult: ModerationResult): T

                /**
                 * An error produced while attempting moderation for the response input or output.
                 */
                fun visitError(error: Error): T

                /**
                 * Maps an unknown variant of [Output] to a value of type [T].
                 *
                 * An instance of [Output] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Output: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Output>(Output::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Output {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "moderation_result" -> {
                            return tryDeserialize(node, jacksonTypeRef<ModerationResult>())?.let {
                                Output(moderationResult = it, _json = json)
                            } ?: Output(_json = json)
                        }
                        "error" -> {
                            return tryDeserialize(node, jacksonTypeRef<Error>())?.let {
                                Output(error = it, _json = json)
                            } ?: Output(_json = json)
                        }
                    }

                    return Output(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Output>(Output::class) {

                override fun serialize(
                    value: Output,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.moderationResult != null ->
                            generator.writeObject(value.moderationResult)
                        value.error != null -> generator.writeObject(value.error)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Output")
                    }
                }
            }

            /** A moderation result produced for the response input or output. */
            class ModerationResult
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val categories: JsonField<Categories>,
                private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>,
                private val categoryScores: JsonField<CategoryScores>,
                private val flagged: JsonField<Boolean>,
                private val model: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("categories")
                    @ExcludeMissing
                    categories: JsonField<Categories> = JsonMissing.of(),
                    @JsonProperty("category_applied_input_types")
                    @ExcludeMissing
                    categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> =
                        JsonMissing.of(),
                    @JsonProperty("category_scores")
                    @ExcludeMissing
                    categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
                    @JsonProperty("flagged")
                    @ExcludeMissing
                    flagged: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(
                    categories,
                    categoryAppliedInputTypes,
                    categoryScores,
                    flagged,
                    model,
                    type,
                    mutableMapOf(),
                )

                /**
                 * A dictionary of moderation categories to booleans, True if the input is flagged
                 * under this category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categories(): Categories = categories.getRequired("categories")

                /**
                 * Which modalities of input are reflected by the score for each category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
                    categoryAppliedInputTypes.getRequired("category_applied_input_types")

                /**
                 * A dictionary of moderation categories to scores.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

                /**
                 * A boolean indicating whether the content was flagged by any category.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun flagged(): Boolean = flagged.getRequired("flagged")

                /**
                 * The moderation model that produced this result.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun model(): String = model.getRequired("model")

                /**
                 * The object type, which was always `moderation_result` for successful moderation
                 * results.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("moderation_result")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [categories].
                 *
                 * Unlike [categories], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("categories")
                @ExcludeMissing
                fun _categories(): JsonField<Categories> = categories

                /**
                 * Returns the raw JSON value of [categoryAppliedInputTypes].
                 *
                 * Unlike [categoryAppliedInputTypes], this method doesn't throw if the JSON field
                 * has an unexpected type.
                 */
                @JsonProperty("category_applied_input_types")
                @ExcludeMissing
                fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
                    categoryAppliedInputTypes

                /**
                 * Returns the raw JSON value of [categoryScores].
                 *
                 * Unlike [categoryScores], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("category_scores")
                @ExcludeMissing
                fun _categoryScores(): JsonField<CategoryScores> = categoryScores

                /**
                 * Returns the raw JSON value of [flagged].
                 *
                 * Unlike [flagged], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("flagged")
                @ExcludeMissing
                fun _flagged(): JsonField<Boolean> = flagged

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                     * Returns a mutable builder for constructing an instance of [ModerationResult].
                     *
                     * The following fields are required:
                     * ```java
                     * .categories()
                     * .categoryAppliedInputTypes()
                     * .categoryScores()
                     * .flagged()
                     * .model()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ModerationResult]. */
                class Builder internal constructor() {

                    private var categories: JsonField<Categories>? = null
                    private var categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>? =
                        null
                    private var categoryScores: JsonField<CategoryScores>? = null
                    private var flagged: JsonField<Boolean>? = null
                    private var model: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("moderation_result")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(moderationResult: ModerationResult) = apply {
                        categories = moderationResult.categories
                        categoryAppliedInputTypes = moderationResult.categoryAppliedInputTypes
                        categoryScores = moderationResult.categoryScores
                        flagged = moderationResult.flagged
                        model = moderationResult.model
                        type = moderationResult.type
                        additionalProperties = moderationResult.additionalProperties.toMutableMap()
                    }

                    /**
                     * A dictionary of moderation categories to booleans, True if the input is
                     * flagged under this category.
                     */
                    fun categories(categories: Categories) = categories(JsonField.of(categories))

                    /**
                     * Sets [Builder.categories] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categories] with a well-typed [Categories]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun categories(categories: JsonField<Categories>) = apply {
                        this.categories = categories
                    }

                    /** Which modalities of input are reflected by the score for each category. */
                    fun categoryAppliedInputTypes(
                        categoryAppliedInputTypes: CategoryAppliedInputTypes
                    ) = categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

                    /**
                     * Sets [Builder.categoryAppliedInputTypes] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categoryAppliedInputTypes] with a well-typed
                     * [CategoryAppliedInputTypes] value instead. This method is primarily for
                     * setting the field to an undocumented or not yet supported value.
                     */
                    fun categoryAppliedInputTypes(
                        categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
                    ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

                    /** A dictionary of moderation categories to scores. */
                    fun categoryScores(categoryScores: CategoryScores) =
                        categoryScores(JsonField.of(categoryScores))

                    /**
                     * Sets [Builder.categoryScores] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.categoryScores] with a well-typed
                     * [CategoryScores] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
                        this.categoryScores = categoryScores
                    }

                    /** A boolean indicating whether the content was flagged by any category. */
                    fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

                    /**
                     * Sets [Builder.flagged] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.flagged] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

                    /** The moderation model that produced this result. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("moderation_result")
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
                     * Returns an immutable instance of [ModerationResult].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .categories()
                     * .categoryAppliedInputTypes()
                     * .categoryScores()
                     * .flagged()
                     * .model()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ModerationResult =
                        ModerationResult(
                            checkRequired("categories", categories),
                            checkRequired("categoryAppliedInputTypes", categoryAppliedInputTypes),
                            checkRequired("categoryScores", categoryScores),
                            checkRequired("flagged", flagged),
                            checkRequired("model", model),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): ModerationResult = apply {
                    if (validated) {
                        return@apply
                    }

                    categories().validate()
                    categoryAppliedInputTypes().validate()
                    categoryScores().validate()
                    flagged()
                    model()
                    _type().let {
                        if (it != JsonValue.from("moderation_result")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
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
                    (categories.asKnown().getOrNull()?.validity() ?: 0) +
                        (categoryAppliedInputTypes.asKnown().getOrNull()?.validity() ?: 0) +
                        (categoryScores.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (flagged.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("moderation_result")) 1 else 0 }

                /**
                 * A dictionary of moderation categories to booleans, True if the input is flagged
                 * under this category.
                 */
                class Categories
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

                        /**
                         * Returns a mutable builder for constructing an instance of [Categories].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Categories]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categories: Categories) = apply {
                            additionalProperties = categories.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [Categories].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Categories = Categories(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Categories = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Categories &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Categories{additionalProperties=$additionalProperties}"
                }

                /** Which modalities of input are reflected by the score for each category. */
                class CategoryAppliedInputTypes
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

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [CategoryAppliedInputTypes].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [CategoryAppliedInputTypes]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categoryAppliedInputTypes: CategoryAppliedInputTypes) =
                            apply {
                                additionalProperties =
                                    categoryAppliedInputTypes.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [CategoryAppliedInputTypes].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): CategoryAppliedInputTypes =
                            CategoryAppliedInputTypes(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): CategoryAppliedInputTypes = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is CategoryAppliedInputTypes &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "CategoryAppliedInputTypes{additionalProperties=$additionalProperties}"
                }

                /** A dictionary of moderation categories to scores. */
                class CategoryScores
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

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [CategoryScores].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [CategoryScores]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(categoryScores: CategoryScores) = apply {
                            additionalProperties =
                                categoryScores.additionalProperties.toMutableMap()
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
                         * Returns an immutable instance of [CategoryScores].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): CategoryScores =
                            CategoryScores(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): CategoryScores = apply {
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is CategoryScores &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "CategoryScores{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ModerationResult &&
                        categories == other.categories &&
                        categoryAppliedInputTypes == other.categoryAppliedInputTypes &&
                        categoryScores == other.categoryScores &&
                        flagged == other.flagged &&
                        model == other.model &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        categories,
                        categoryAppliedInputTypes,
                        categoryScores,
                        flagged,
                        model,
                        type,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ModerationResult{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, model=$model, type=$type, additionalProperties=$additionalProperties}"
            }

            /** An error produced while attempting moderation for the response input or output. */
            class Error
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val code: JsonField<String>,
                private val message: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("code")
                    @ExcludeMissing
                    code: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message")
                    @ExcludeMissing
                    message: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(code, message, type, mutableMapOf())

                /**
                 * The error code.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun code(): String = code.getRequired("code")

                /**
                 * The error message.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun message(): String = message.getRequired("message")

                /**
                 * The object type, which was always `error` for moderation failures.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("error")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var code: JsonField<String>? = null
                    private var message: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("error")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(error: Error) = apply {
                        code = error.code
                        message = error.message
                        type = error.type
                        additionalProperties = error.additionalProperties.toMutableMap()
                    }

                    /** The error code. */
                    fun code(code: String) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<String>) = apply { this.code = code }

                    /** The error message. */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun message(message: JsonField<String>) = apply { this.message = message }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("error")
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
                     * Returns an immutable instance of [Error].
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
                    fun build(): Error =
                        Error(
                            checkRequired("code", code),
                            checkRequired("message", message),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    code()
                    message()
                    _type().let {
                        if (it != JsonValue.from("error")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
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
                    (if (code.asKnown().isPresent) 1 else 0) +
                        (if (message.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("error")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Error &&
                        code == other.code &&
                        message == other.message &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Moderation &&
                input == other.input &&
                output == other.output &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Moderation{input=$input, output=$output, additionalProperties=$additionalProperties}"
    }

    /**
     * The prompt-caching options that were applied to the response. Supported for `gpt-5.6` and
     * later models.
     */
    class PromptCacheOptions
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mode: JsonField<Mode>,
        private val ttl: JsonField<Ttl>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("ttl") @ExcludeMissing ttl: JsonField<Ttl> = JsonMissing.of(),
        ) : this(mode, ttl, mutableMapOf())

        /**
         * Whether implicit prompt-cache breakpoints were enabled.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mode(): Mode = mode.getRequired("mode")

        /**
         * The minimum lifetime applied to each cache breakpoint.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun ttl(): Ttl = ttl.getRequired("ttl")

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

        /**
         * Returns the raw JSON value of [ttl].
         *
         * Unlike [ttl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttl") @ExcludeMissing fun _ttl(): JsonField<Ttl> = ttl

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
             * Returns a mutable builder for constructing an instance of [PromptCacheOptions].
             *
             * The following fields are required:
             * ```java
             * .mode()
             * .ttl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PromptCacheOptions]. */
        class Builder internal constructor() {

            private var mode: JsonField<Mode>? = null
            private var ttl: JsonField<Ttl>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptCacheOptions: PromptCacheOptions) = apply {
                mode = promptCacheOptions.mode
                ttl = promptCacheOptions.ttl
                additionalProperties = promptCacheOptions.additionalProperties.toMutableMap()
            }

            /** Whether implicit prompt-cache breakpoints were enabled. */
            fun mode(mode: Mode) = mode(JsonField.of(mode))

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

            /** The minimum lifetime applied to each cache breakpoint. */
            fun ttl(ttl: Ttl) = ttl(JsonField.of(ttl))

            /**
             * Sets [Builder.ttl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttl] with a well-typed [Ttl] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ttl(ttl: JsonField<Ttl>) = apply { this.ttl = ttl }

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
             * Returns an immutable instance of [PromptCacheOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .mode()
             * .ttl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PromptCacheOptions =
                PromptCacheOptions(
                    checkRequired("mode", mode),
                    checkRequired("ttl", ttl),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): PromptCacheOptions = apply {
            if (validated) {
                return@apply
            }

            mode().validate()
            ttl().validate()
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
            (mode.asKnown().getOrNull()?.validity() ?: 0) +
                (ttl.asKnown().getOrNull()?.validity() ?: 0)

        /** Whether implicit prompt-cache breakpoints were enabled. */
        class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IMPLICIT = of("implicit")

                @JvmField val EXPLICIT = of("explicit")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                IMPLICIT,
                EXPLICIT,
            }

            /**
             * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Mode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IMPLICIT,
                EXPLICIT,
                /** An enum member indicating that [Mode] was instantiated with an unknown value. */
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
                    IMPLICIT -> Value.IMPLICIT
                    EXPLICIT -> Value.EXPLICIT
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
                    IMPLICIT -> Known.IMPLICIT
                    EXPLICIT -> Known.EXPLICIT
                    else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Mode = apply {
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

                return other is Mode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The minimum lifetime applied to each cache breakpoint. */
        class Ttl @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val _30M = of("30m")

                @JvmStatic fun of(value: String) = Ttl(JsonField.of(value))
            }

            /** An enum containing [Ttl]'s known values. */
            enum class Known {
                _30M
            }

            /**
             * An enum containing [Ttl]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Ttl] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _30M,
                /** An enum member indicating that [Ttl] was instantiated with an unknown value. */
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
                    _30M -> Value._30M
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
                    _30M -> Known._30M
                    else -> throw OpenAIInvalidDataException("Unknown Ttl: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Ttl = apply {
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

                return other is Ttl && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PromptCacheOptions &&
                mode == other.mode &&
                ttl == other.ttl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(mode, ttl, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PromptCacheOptions{mode=$mode, ttl=$ttl, additionalProperties=$additionalProperties}"
    }

    /**
     * Deprecated. Use `prompt_cache_options.ttl` instead.
     *
     * The retention policy for the prompt cache. Set to `24h` to enable extended prompt caching,
     * which keeps cached prefixes active for longer, up to a maximum of 24 hours.
     * [Learn more](https://platform.openai.com/docs/guides/prompt-caching#prompt-cache-retention).
     * This field expresses a maximum retention policy, while `prompt_cache_options.ttl` expresses a
     * minimum cache lifetime. The two fields are independent and do not interact. For `gpt-5.5`,
     * `gpt-5.5-pro`, and future models, only `24h` is supported.
     *
     * For older models that support both `in_memory` and `24h`, the default depends on your
     * organization's data retention policy:
     * - Organizations without ZDR enabled default to `24h`.
     * - Organizations with ZDR enabled default to `in_memory` when `prompt_cache_retention` is not
     *   specified.
     */
    @Deprecated("deprecated")
    class PromptCacheRetention
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val IN_MEMORY = of("in_memory")

            @JvmField val _24H = of("24h")

            @JvmStatic fun of(value: String) = PromptCacheRetention(JsonField.of(value))
        }

        /** An enum containing [PromptCacheRetention]'s known values. */
        enum class Known {
            IN_MEMORY,
            _24H,
        }

        /**
         * An enum containing [PromptCacheRetention]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [PromptCacheRetention] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_MEMORY,
            _24H,
            /**
             * An enum member indicating that [PromptCacheRetention] was instantiated with an
             * unknown value.
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
                IN_MEMORY -> Value.IN_MEMORY
                _24H -> Value._24H
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
                IN_MEMORY -> Known.IN_MEMORY
                _24H -> Known._24H
                else -> throw OpenAIInvalidDataException("Unknown PromptCacheRetention: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): PromptCacheRetention = apply {
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

            return other is PromptCacheRetention && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * **gpt-5 and o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    class Reasoning
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val context: JsonField<Context>,
        private val effort: JsonField<Effort>,
        private val generateSummary: JsonField<GenerateSummary>,
        private val mode: JsonField<Mode>,
        private val summary: JsonField<Summary>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("context") @ExcludeMissing context: JsonField<Context> = JsonMissing.of(),
            @JsonProperty("effort") @ExcludeMissing effort: JsonField<Effort> = JsonMissing.of(),
            @JsonProperty("generate_summary")
            @ExcludeMissing
            generateSummary: JsonField<GenerateSummary> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
        ) : this(context, effort, generateSummary, mode, summary, mutableMapOf())

        /**
         * Controls which reasoning items are rendered back to the model on later turns. When
         * returned on a response, this is the effective reasoning context mode used for the
         * response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun context(): Optional<Context> = context.getOptional("context")

        /**
         * Constrains effort on reasoning for reasoning models. Currently supported values are
         * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning effort
         * can result in faster responses and fewer tokens used on reasoning in a response. Not all
         * reasoning models support every value. See the
         * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for model-specific
         * support.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun effort(): Optional<Effort> = effort.getOptional("effort")

        /**
         * **Deprecated:** use `summary` instead.
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun generateSummary(): Optional<GenerateSummary> =
            generateSummary.getOptional("generate_summary")

        /**
         * Controls the reasoning execution mode for the request.
         *
         * When returned on a response, this is the effective execution mode.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<Mode> = mode.getOptional("mode")

        /**
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * `concise` is supported for `computer-use-preview` models and all reasoning models after
         * `gpt-5`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun summary(): Optional<Summary> = summary.getOptional("summary")

        /**
         * Returns the raw JSON value of [context].
         *
         * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<Context> = context

        /**
         * Returns the raw JSON value of [effort].
         *
         * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<Effort> = effort

        /**
         * Returns the raw JSON value of [generateSummary].
         *
         * Unlike [generateSummary], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @Deprecated("deprecated")
        @JsonProperty("generate_summary")
        @ExcludeMissing
        fun _generateSummary(): JsonField<GenerateSummary> = generateSummary

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

        /**
         * Returns the raw JSON value of [summary].
         *
         * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

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

            /** Returns a mutable builder for constructing an instance of [Reasoning]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Reasoning]. */
        class Builder internal constructor() {

            private var context: JsonField<Context> = JsonMissing.of()
            private var effort: JsonField<Effort> = JsonMissing.of()
            private var generateSummary: JsonField<GenerateSummary> = JsonMissing.of()
            private var mode: JsonField<Mode> = JsonMissing.of()
            private var summary: JsonField<Summary> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoning: Reasoning) = apply {
                context = reasoning.context
                effort = reasoning.effort
                generateSummary = reasoning.generateSummary
                mode = reasoning.mode
                summary = reasoning.summary
                additionalProperties = reasoning.additionalProperties.toMutableMap()
            }

            /**
             * Controls which reasoning items are rendered back to the model on later turns. When
             * returned on a response, this is the effective reasoning context mode used for the
             * response.
             */
            fun context(context: Context?) = context(JsonField.ofNullable(context))

            /** Alias for calling [Builder.context] with `context.orElse(null)`. */
            fun context(context: Optional<Context>) = context(context.getOrNull())

            /**
             * Sets [Builder.context] to an arbitrary JSON value.
             *
             * You should usually call [Builder.context] with a well-typed [Context] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun context(context: JsonField<Context>) = apply { this.context = context }

            /**
             * Constrains effort on reasoning for reasoning models. Currently supported values are
             * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning
             * effort can result in faster responses and fewer tokens used on reasoning in a
             * response. Not all reasoning models support every value. See the
             * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for
             * model-specific support.
             */
            fun effort(effort: Effort?) = effort(JsonField.ofNullable(effort))

            /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
            fun effort(effort: Optional<Effort>) = effort(effort.getOrNull())

            /**
             * Sets [Builder.effort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.effort] with a well-typed [Effort] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun effort(effort: JsonField<Effort>) = apply { this.effort = effort }

            /**
             * **Deprecated:** use `summary` instead.
             *
             * A summary of the reasoning performed by the model. This can be useful for debugging
             * and understanding the model's reasoning process. One of `auto`, `concise`, or
             * `detailed`.
             */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: GenerateSummary?) =
                generateSummary(JsonField.ofNullable(generateSummary))

            /** Alias for calling [Builder.generateSummary] with `generateSummary.orElse(null)`. */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: Optional<GenerateSummary>) =
                generateSummary(generateSummary.getOrNull())

            /**
             * Sets [Builder.generateSummary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.generateSummary] with a well-typed [GenerateSummary]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            @Deprecated("deprecated")
            fun generateSummary(generateSummary: JsonField<GenerateSummary>) = apply {
                this.generateSummary = generateSummary
            }

            /**
             * Controls the reasoning execution mode for the request.
             *
             * When returned on a response, this is the effective execution mode.
             */
            fun mode(mode: Mode) = mode(JsonField.of(mode))

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

            /**
             * Sets [mode] to an arbitrary [String].
             *
             * You should usually call [mode] with a well-typed [Mode] constant instead. This method
             * is primarily for setting the field to an undocumented or not yet supported value.
             */
            fun mode(value: String) = mode(Mode.of(value))

            /**
             * A summary of the reasoning performed by the model. This can be useful for debugging
             * and understanding the model's reasoning process. One of `auto`, `concise`, or
             * `detailed`.
             *
             * `concise` is supported for `computer-use-preview` models and all reasoning models
             * after `gpt-5`.
             */
            fun summary(summary: Summary?) = summary(JsonField.ofNullable(summary))

            /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
            fun summary(summary: Optional<Summary>) = summary(summary.getOrNull())

            /**
             * Sets [Builder.summary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summary] with a well-typed [Summary] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
             * Returns an immutable instance of [Reasoning].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Reasoning =
                Reasoning(
                    context,
                    effort,
                    generateSummary,
                    mode,
                    summary,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Reasoning = apply {
            if (validated) {
                return@apply
            }

            context().ifPresent { it.validate() }
            effort().ifPresent { it.validate() }
            generateSummary().ifPresent { it.validate() }
            mode()
            summary().ifPresent { it.validate() }
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
            (context.asKnown().getOrNull()?.validity() ?: 0) +
                (effort.asKnown().getOrNull()?.validity() ?: 0) +
                (generateSummary.asKnown().getOrNull()?.validity() ?: 0) +
                (if (mode.asKnown().isPresent) 1 else 0) +
                (summary.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Controls which reasoning items are rendered back to the model on later turns. When
         * returned on a response, this is the effective reasoning context mode used for the
         * response.
         */
        class Context @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val CURRENT_TURN = of("current_turn")

                @JvmField val ALL_TURNS = of("all_turns")

                @JvmStatic fun of(value: String) = Context(JsonField.of(value))
            }

            /** An enum containing [Context]'s known values. */
            enum class Known {
                AUTO,
                CURRENT_TURN,
                ALL_TURNS,
            }

            /**
             * An enum containing [Context]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Context] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CURRENT_TURN,
                ALL_TURNS,
                /**
                 * An enum member indicating that [Context] was instantiated with an unknown value.
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
                    AUTO -> Value.AUTO
                    CURRENT_TURN -> Value.CURRENT_TURN
                    ALL_TURNS -> Value.ALL_TURNS
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
                    CURRENT_TURN -> Known.CURRENT_TURN
                    ALL_TURNS -> Known.ALL_TURNS
                    else -> throw OpenAIInvalidDataException("Unknown Context: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Context = apply {
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

                return other is Context && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Constrains effort on reasoning for reasoning models. Currently supported values are
         * `none`, `minimal`, `low`, `medium`, `high`, `xhigh`, and `max`. Reducing reasoning effort
         * can result in faster responses and fewer tokens used on reasoning in a response. Not all
         * reasoning models support every value. See the
         * [reasoning guide](https://platform.openai.com/docs/guides/reasoning) for model-specific
         * support.
         */
        class Effort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val NONE = of("none")

                @JvmField val MINIMAL = of("minimal")

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmField val XHIGH = of("xhigh")

                @JvmField val MAX = of("max")

                @JvmStatic fun of(value: String) = Effort(JsonField.of(value))
            }

            /** An enum containing [Effort]'s known values. */
            enum class Known {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
                MAX,
            }

            /**
             * An enum containing [Effort]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Effort] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
                MAX,
                /**
                 * An enum member indicating that [Effort] was instantiated with an unknown value.
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
                    NONE -> Value.NONE
                    MINIMAL -> Value.MINIMAL
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    XHIGH -> Value.XHIGH
                    MAX -> Value.MAX
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
                    NONE -> Known.NONE
                    MINIMAL -> Known.MINIMAL
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    XHIGH -> Known.XHIGH
                    MAX -> Known.MAX
                    else -> throw OpenAIInvalidDataException("Unknown Effort: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Effort = apply {
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

                return other is Effort && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * **Deprecated:** use `summary` instead.
         *
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         */
        @Deprecated("deprecated")
        class GenerateSummary
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val CONCISE = of("concise")

                @JvmField val DETAILED = of("detailed")

                @JvmStatic fun of(value: String) = GenerateSummary(JsonField.of(value))
            }

            /** An enum containing [GenerateSummary]'s known values. */
            enum class Known {
                AUTO,
                CONCISE,
                DETAILED,
            }

            /**
             * An enum containing [GenerateSummary]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [GenerateSummary] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CONCISE,
                DETAILED,
                /**
                 * An enum member indicating that [GenerateSummary] was instantiated with an unknown
                 * value.
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
                    AUTO -> Value.AUTO
                    CONCISE -> Value.CONCISE
                    DETAILED -> Value.DETAILED
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
                    CONCISE -> Known.CONCISE
                    DETAILED -> Known.DETAILED
                    else -> throw OpenAIInvalidDataException("Unknown GenerateSummary: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): GenerateSummary = apply {
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

                return other is GenerateSummary && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Controls the reasoning execution mode for the request.
         *
         * When returned on a response, this is the effective execution mode.
         */
        class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val STANDARD = of("standard")

                @JvmField val PRO = of("pro")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                STANDARD,
                PRO,
            }

            /**
             * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Mode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STANDARD,
                PRO,
                /** An enum member indicating that [Mode] was instantiated with an unknown value. */
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
                    STANDARD -> Value.STANDARD
                    PRO -> Value.PRO
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
                    STANDARD -> Known.STANDARD
                    PRO -> Known.PRO
                    else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Mode = apply {
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

                return other is Mode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * A summary of the reasoning performed by the model. This can be useful for debugging and
         * understanding the model's reasoning process. One of `auto`, `concise`, or `detailed`.
         *
         * `concise` is supported for `computer-use-preview` models and all reasoning models after
         * `gpt-5`.
         */
        class Summary @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val CONCISE = of("concise")

                @JvmField val DETAILED = of("detailed")

                @JvmStatic fun of(value: String) = Summary(JsonField.of(value))
            }

            /** An enum containing [Summary]'s known values. */
            enum class Known {
                AUTO,
                CONCISE,
                DETAILED,
            }

            /**
             * An enum containing [Summary]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Summary] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                CONCISE,
                DETAILED,
                /**
                 * An enum member indicating that [Summary] was instantiated with an unknown value.
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
                    AUTO -> Value.AUTO
                    CONCISE -> Value.CONCISE
                    DETAILED -> Value.DETAILED
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
                    CONCISE -> Known.CONCISE
                    DETAILED -> Known.DETAILED
                    else -> throw OpenAIInvalidDataException("Unknown Summary: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Summary = apply {
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

                return other is Summary && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Reasoning &&
                context == other.context &&
                effort == other.effort &&
                generateSummary == other.generateSummary &&
                mode == other.mode &&
                summary == other.summary &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(context, effort, generateSummary, mode, summary, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Reasoning{context=$context, effort=$effort, generateSummary=$generateSummary, mode=$mode, summary=$summary, additionalProperties=$additionalProperties}"
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        return other is BetaResponse &&
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
            completedAt == other.completedAt &&
            conversation == other.conversation &&
            maxOutputTokens == other.maxOutputTokens &&
            maxToolCalls == other.maxToolCalls &&
            moderation == other.moderation &&
            previousResponseId == other.previousResponseId &&
            prompt == other.prompt &&
            promptCacheKey == other.promptCacheKey &&
            promptCacheOptions == other.promptCacheOptions &&
            promptCacheRetention == other.promptCacheRetention &&
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
            completedAt,
            conversation,
            maxOutputTokens,
            maxToolCalls,
            moderation,
            previousResponseId,
            prompt,
            promptCacheKey,
            promptCacheOptions,
            promptCacheRetention,
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
        "BetaResponse{id=$id, createdAt=$createdAt, error=$error, incompleteDetails=$incompleteDetails, instructions=$instructions, metadata=$metadata, model=$model, object_=$object_, output=$output, parallelToolCalls=$parallelToolCalls, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topP=$topP, background=$background, completedAt=$completedAt, conversation=$conversation, maxOutputTokens=$maxOutputTokens, maxToolCalls=$maxToolCalls, moderation=$moderation, previousResponseId=$previousResponseId, prompt=$prompt, promptCacheKey=$promptCacheKey, promptCacheOptions=$promptCacheOptions, promptCacheRetention=$promptCacheRetention, reasoning=$reasoning, safetyIdentifier=$safetyIdentifier, serviceTier=$serviceTier, status=$status, text=$text, topLogprobs=$topLogprobs, truncation=$truncation, usage=$usage, user=$user, additionalProperties=$additionalProperties}"
}
