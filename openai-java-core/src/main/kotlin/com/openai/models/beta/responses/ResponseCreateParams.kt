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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a model response. Provide [text](https://platform.openai.com/docs/guides/text) or
 * [image](https://platform.openai.com/docs/guides/images) inputs to generate
 * [text](https://platform.openai.com/docs/guides/text) or
 * [JSON](https://platform.openai.com/docs/guides/structured-outputs) outputs. Have the model call
 * your own [custom code](https://platform.openai.com/docs/guides/function-calling) or use built-in
 * [tools](https://platform.openai.com/docs/guides/tools) like
 * [web search](https://platform.openai.com/docs/guides/tools-web-search) or
 * [file search](https://platform.openai.com/docs/guides/tools-file-search) to use your own data as
 * input for the model's response.
 */
class ResponseCreateParams
private constructor(
    private val betas: List<Beta>?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun betas(): Optional<List<Beta>> = Optional.ofNullable(betas)

    /**
     * Whether to run the model response in the background.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<Boolean> = body.background()

    /**
     * Context management configuration for this request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contextManagement(): Optional<List<ContextManagement>> = body.contextManagement()

    /**
     * The conversation that this response belongs to. Items from this conversation are prepended to
     * `input_items` for this response request. Input items and output items from this response are
     * automatically added to this conversation after this response completes.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversation(): Optional<Conversation> = body.conversation()

    /**
     * Specify additional output data to include in the model response. Currently supported values
     * are:
     * - `web_search_call.action.sources`: Include the sources of the web search tool call.
     * - `code_interpreter_call.outputs`: Includes the outputs of python code execution in code
     *   interpreter tool call items.
     * - `computer_call_output.output.image_url`: Include image urls from the computer call output.
     * - `file_search_call.results`: Include the search results of the file search tool call.
     * - `message.input_image.image_url`: Include image urls from the input message.
     * - `message.output_text.logprobs`: Include logprobs with assistant messages.
     * - `reasoning.encrypted_content`: Includes an encrypted version of reasoning tokens in
     *   reasoning item outputs. This enables reasoning items to be used in multi-turn conversations
     *   when using the Responses API statelessly (like when the `store` parameter is set to
     *   `false`, or when an organization is enrolled in the zero data retention program).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun include(): Optional<List<BetaResponseIncludable>> = body.include()

    /**
     * Text, image, or file inputs to the model, used to generate a response.
     *
     * Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Image inputs](https://platform.openai.com/docs/guides/images)
     * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
     * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
     * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<Input> = body.input()

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
    fun instructions(): Optional<String> = body.instructions()

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxOutputTokens(): Optional<Long> = body.maxOutputTokens()

    /**
     * The maximum number of total calls to built-in tools that can be processed in a response. This
     * maximum number applies across all built-in tool calls, not per individual tool. Any further
     * attempts to call a tool by the model will be ignored.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxToolCalls(): Optional<Long> = body.maxToolCalls()

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
     * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = body.model()

    /**
     * Configuration for running moderation on the input and output of this response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun moderation(): Optional<Moderation> = body.moderation()

    /**
     * Configuration for server-hosted multi-agent execution.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun multiAgent(): Optional<MultiAgent> = body.multiAgent()

    /**
     * Whether to allow the model to run tool calls in parallel.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun parallelToolCalls(): Optional<Boolean> = body.parallelToolCalls()

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot be
     * used in conjunction with `conversation`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousResponseId(): Optional<String> = body.previousResponseId()

    /**
     * Reference to a prompt template and its variables.
     * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<BetaResponsePrompt> = body.prompt()

    /**
     * Used by OpenAI to cache responses for similar requests to optimize your cache hit rates.
     * Replaces the `user` field.
     * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheKey(): Optional<String> = body.promptCacheKey()

    /**
     * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
     * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
     * content blocks with `prompt_cache_breakpoint`. Each request can write up to four breakpoints.
     * For cache matching, OpenAI considers up to the latest 80 breakpoints in the conversation,
     * without a content-block lookback limit. Set `mode` to `explicit` to disable the implicit
     * breakpoint. The `ttl` defaults to `30m`, which is currently the only supported value. See the
     * [prompt caching guide](https://platform.openai.com/docs/guides/prompt-caching) for current
     * details.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheOptions(): Optional<PromptCacheOptions> = body.promptCacheOptions()

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
    fun promptCacheRetention(): Optional<PromptCacheRetention> = body.promptCacheRetention()

    /**
     * **gpt-5 and o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoning(): Optional<Reasoning> = body.reasoning()

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
    fun safetyIdentifier(): Optional<String> = body.safetyIdentifier()

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
    fun serviceTier(): Optional<ServiceTier> = body.serviceTier()

    /**
     * Whether to store the generated model response for later retrieval via API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun store(): Optional<Boolean> = body.store()

    /**
     * Options for streaming responses. Only set this when you set `stream: true`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamOptions(): Optional<StreamOptions> = body.streamOptions()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<BetaResponseTextConfig> = body.text()

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<ToolChoice> = body.toolChoice()

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
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<BetaTool>> = body.tools()

    /**
     * An integer between 0 and 20 specifying the maximum number of most likely tokens to return at
     * each token position, each with an associated log probability. In some cases, the number of
     * returned tokens may be fewer than requested.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun topLogprobs(): Optional<Long> = body.topLogprobs()

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
    fun topP(): Optional<Double> = body.topP()

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
    @Deprecated("deprecated") fun truncation(): Optional<Truncation> = body.truncation()

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
    @Deprecated("deprecated") fun user(): Optional<String> = body.user()

    /**
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _background(): JsonField<Boolean> = body._background()

    /**
     * Returns the raw JSON value of [contextManagement].
     *
     * Unlike [contextManagement], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _contextManagement(): JsonField<List<ContextManagement>> = body._contextManagement()

    /**
     * Returns the raw JSON value of [conversation].
     *
     * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _conversation(): JsonField<Conversation> = body._conversation()

    /**
     * Returns the raw JSON value of [include].
     *
     * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _include(): JsonField<List<BetaResponseIncludable>> = body._include()

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Returns the raw JSON value of [maxOutputTokens].
     *
     * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxOutputTokens(): JsonField<Long> = body._maxOutputTokens()

    /**
     * Returns the raw JSON value of [maxToolCalls].
     *
     * Unlike [maxToolCalls], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxToolCalls(): JsonField<Long> = body._maxToolCalls()

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
    fun _model(): JsonField<Model> = body._model()

    /**
     * Returns the raw JSON value of [moderation].
     *
     * Unlike [moderation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _moderation(): JsonField<Moderation> = body._moderation()

    /**
     * Returns the raw JSON value of [multiAgent].
     *
     * Unlike [multiAgent], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _multiAgent(): JsonField<MultiAgent> = body._multiAgent()

    /**
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

    /**
     * Returns the raw JSON value of [previousResponseId].
     *
     * Unlike [previousResponseId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _previousResponseId(): JsonField<String> = body._previousResponseId()

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _prompt(): JsonField<BetaResponsePrompt> = body._prompt()

    /**
     * Returns the raw JSON value of [promptCacheKey].
     *
     * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _promptCacheKey(): JsonField<String> = body._promptCacheKey()

    /**
     * Returns the raw JSON value of [promptCacheOptions].
     *
     * Unlike [promptCacheOptions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _promptCacheOptions(): JsonField<PromptCacheOptions> = body._promptCacheOptions()

    /**
     * Returns the raw JSON value of [promptCacheRetention].
     *
     * Unlike [promptCacheRetention], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @Deprecated("deprecated")
    fun _promptCacheRetention(): JsonField<PromptCacheRetention> = body._promptCacheRetention()

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reasoning(): JsonField<Reasoning> = body._reasoning()

    /**
     * Returns the raw JSON value of [safetyIdentifier].
     *
     * Unlike [safetyIdentifier], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _safetyIdentifier(): JsonField<String> = body._safetyIdentifier()

    /**
     * Returns the raw JSON value of [serviceTier].
     *
     * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _serviceTier(): JsonField<ServiceTier> = body._serviceTier()

    /**
     * Returns the raw JSON value of [store].
     *
     * Unlike [store], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _store(): JsonField<Boolean> = body._store()

    /**
     * Returns the raw JSON value of [streamOptions].
     *
     * Unlike [streamOptions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _streamOptions(): JsonField<StreamOptions> = body._streamOptions()

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _text(): JsonField<BetaResponseTextConfig> = body._text()

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolChoice(): JsonField<ToolChoice> = body._toolChoice()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<BetaTool>> = body._tools()

    /**
     * Returns the raw JSON value of [topLogprobs].
     *
     * Unlike [topLogprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topLogprobs(): JsonField<Long> = body._topLogprobs()

    /**
     * Returns the raw JSON value of [topP].
     *
     * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _topP(): JsonField<Double> = body._topP()

    /**
     * Returns the raw JSON value of [truncation].
     *
     * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _truncation(): JsonField<Truncation> = body._truncation()

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _user(): JsonField<String> = body._user()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ResponseCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ResponseCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCreateParams]. */
    class Builder internal constructor() {

        private var betas: MutableList<Beta>? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(responseCreateParams: ResponseCreateParams) = apply {
            betas = responseCreateParams.betas?.toMutableList()
            body = responseCreateParams.body.toBuilder()
            additionalHeaders = responseCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = responseCreateParams.additionalQueryParams.toBuilder()
        }

        fun betas(betas: List<Beta>?) = apply { this.betas = betas?.toMutableList() }

        /** Alias for calling [Builder.betas] with `betas.orElse(null)`. */
        fun betas(betas: Optional<List<Beta>>) = betas(betas.getOrNull())

        /**
         * Adds a single [Beta] to [betas].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBeta(beta: Beta) = apply { betas = (betas ?: mutableListOf()).apply { add(beta) } }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [background]
         * - [contextManagement]
         * - [conversation]
         * - [include]
         * - [input]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Whether to run the model response in the background.
         * [Learn more](https://platform.openai.com/docs/guides/background).
         */
        fun background(background: Boolean?) = apply { body.background(background) }

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
        fun background(background: JsonField<Boolean>) = apply { body.background(background) }

        /** Context management configuration for this request. */
        fun contextManagement(contextManagement: List<ContextManagement>?) = apply {
            body.contextManagement(contextManagement)
        }

        /** Alias for calling [Builder.contextManagement] with `contextManagement.orElse(null)`. */
        fun contextManagement(contextManagement: Optional<List<ContextManagement>>) =
            contextManagement(contextManagement.getOrNull())

        /**
         * Sets [Builder.contextManagement] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contextManagement] with a well-typed
         * `List<ContextManagement>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun contextManagement(contextManagement: JsonField<List<ContextManagement>>) = apply {
            body.contextManagement(contextManagement)
        }

        /**
         * Adds a single [ContextManagement] to [Builder.contextManagement].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContextManagement(contextManagement: ContextManagement) = apply {
            body.addContextManagement(contextManagement)
        }

        /**
         * The conversation that this response belongs to. Items from this conversation are
         * prepended to `input_items` for this response request. Input items and output items from
         * this response are automatically added to this conversation after this response completes.
         */
        fun conversation(conversation: Conversation?) = apply { body.conversation(conversation) }

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
            body.conversation(conversation)
        }

        /** Alias for calling [conversation] with `Conversation.ofId(id)`. */
        fun conversation(id: String) = apply { body.conversation(id) }

        /**
         * Alias for calling [conversation] with
         * `Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)`.
         */
        fun conversation(betaResponseConversationParam: BetaResponseConversationParam) = apply {
            body.conversation(betaResponseConversationParam)
        }

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `web_search_call.action.sources`: Include the sources of the web search tool call.
         * - `code_interpreter_call.outputs`: Includes the outputs of python code execution in code
         *   interpreter tool call items.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `message.output_text.logprobs`: Include logprobs with assistant messages.
         * - `reasoning.encrypted_content`: Includes an encrypted version of reasoning tokens in
         *   reasoning item outputs. This enables reasoning items to be used in multi-turn
         *   conversations when using the Responses API statelessly (like when the `store` parameter
         *   is set to `false`, or when an organization is enrolled in the zero data retention
         *   program).
         */
        fun include(include: List<BetaResponseIncludable>?) = apply { body.include(include) }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<BetaResponseIncludable>>) = include(include.getOrNull())

        /**
         * Sets [Builder.include] to an arbitrary JSON value.
         *
         * You should usually call [Builder.include] with a well-typed
         * `List<BetaResponseIncludable>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun include(include: JsonField<List<BetaResponseIncludable>>) = apply {
            body.include(include)
        }

        /**
         * Adds a single [BetaResponseIncludable] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: BetaResponseIncludable) = apply { body.addInclude(include) }

        /**
         * Text, image, or file inputs to the model, used to generate a response.
         *
         * Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Image inputs](https://platform.openai.com/docs/guides/images)
         * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
         * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
         * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
         */
        fun input(input: Input) = apply { body.input(input) }

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** Alias for calling [input] with `Input.ofText(text)`. */
        fun input(text: String) = apply { body.input(text) }

        /** Alias for calling [input] with `Input.ofBetaResponse(betaResponse)`. */
        fun inputOfBetaResponse(betaResponse: List<BetaResponseInputItem>) = apply {
            body.inputOfBetaResponse(betaResponse)
        }

        /**
         * A system (or developer) message inserted into the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
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
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Long?) = apply {
            body.maxOutputTokens(maxOutputTokens)
        }

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
            body.maxOutputTokens(maxOutputTokens)
        }

        /**
         * The maximum number of total calls to built-in tools that can be processed in a response.
         * This maximum number applies across all built-in tool calls, not per individual tool. Any
         * further attempts to call a tool by the model will be ignored.
         */
        fun maxToolCalls(maxToolCalls: Long?) = apply { body.maxToolCalls(maxToolCalls) }

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
        fun maxToolCalls(maxToolCalls: JsonField<Long>) = apply { body.maxToolCalls(maxToolCalls) }

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
         * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: Model) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [Model] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /** Configuration for running moderation on the input and output of this response. */
        fun moderation(moderation: Moderation?) = apply { body.moderation(moderation) }

        /** Alias for calling [Builder.moderation] with `moderation.orElse(null)`. */
        fun moderation(moderation: Optional<Moderation>) = moderation(moderation.getOrNull())

        /**
         * Sets [Builder.moderation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.moderation] with a well-typed [Moderation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun moderation(moderation: JsonField<Moderation>) = apply { body.moderation(moderation) }

        /** Configuration for server-hosted multi-agent execution. */
        fun multiAgent(multiAgent: MultiAgent?) = apply { body.multiAgent(multiAgent) }

        /** Alias for calling [Builder.multiAgent] with `multiAgent.orElse(null)`. */
        fun multiAgent(multiAgent: Optional<MultiAgent>) = multiAgent(multiAgent.getOrNull())

        /**
         * Sets [Builder.multiAgent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.multiAgent] with a well-typed [MultiAgent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun multiAgent(multiAgent: JsonField<MultiAgent>) = apply { body.multiAgent(multiAgent) }

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Boolean?) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /**
         * Alias for [Builder.parallelToolCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(parallelToolCalls as Boolean?)

        /** Alias for calling [Builder.parallelToolCalls] with `parallelToolCalls.orElse(null)`. */
        fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
            parallelToolCalls(parallelToolCalls.getOrNull())

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
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot
         * be used in conjunction with `conversation`.
         */
        fun previousResponseId(previousResponseId: String?) = apply {
            body.previousResponseId(previousResponseId)
        }

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
            body.previousResponseId(previousResponseId)
        }

        /**
         * Reference to a prompt template and its variables.
         * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
         */
        fun prompt(prompt: BetaResponsePrompt?) = apply { body.prompt(prompt) }

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<BetaResponsePrompt>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [BetaResponsePrompt] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun prompt(prompt: JsonField<BetaResponsePrompt>) = apply { body.prompt(prompt) }

        /**
         * Used by OpenAI to cache responses for similar requests to optimize your cache hit rates.
         * Replaces the `user` field.
         * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
         */
        fun promptCacheKey(promptCacheKey: String?) = apply { body.promptCacheKey(promptCacheKey) }

        /** Alias for calling [Builder.promptCacheKey] with `promptCacheKey.orElse(null)`. */
        fun promptCacheKey(promptCacheKey: Optional<String>) =
            promptCacheKey(promptCacheKey.getOrNull())

        /**
         * Sets [Builder.promptCacheKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheKey] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun promptCacheKey(promptCacheKey: JsonField<String>) = apply {
            body.promptCacheKey(promptCacheKey)
        }

        /**
         * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
         * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
         * content blocks with `prompt_cache_breakpoint`. Each request can write up to four
         * breakpoints. For cache matching, OpenAI considers up to the latest 80 breakpoints in the
         * conversation, without a content-block lookback limit. Set `mode` to `explicit` to disable
         * the implicit breakpoint. The `ttl` defaults to `30m`, which is currently the only
         * supported value. See the
         * [prompt caching guide](https://platform.openai.com/docs/guides/prompt-caching) for
         * current details.
         */
        fun promptCacheOptions(promptCacheOptions: PromptCacheOptions) = apply {
            body.promptCacheOptions(promptCacheOptions)
        }

        /**
         * Sets [Builder.promptCacheOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheOptions] with a well-typed
         * [PromptCacheOptions] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun promptCacheOptions(promptCacheOptions: JsonField<PromptCacheOptions>) = apply {
            body.promptCacheOptions(promptCacheOptions)
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
        fun promptCacheRetention(promptCacheRetention: PromptCacheRetention?) = apply {
            body.promptCacheRetention(promptCacheRetention)
        }

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
            body.promptCacheRetention(promptCacheRetention)
        }

        /**
         * **gpt-5 and o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Reasoning?) = apply { body.reasoning(reasoning) }

        /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { body.reasoning(reasoning) }

        /**
         * A stable identifier used to help detect users of your application that may be violating
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user,
         * with a maximum length of 64 characters. We recommend hashing their username or email
         * address, in order to avoid sending us any identifying information.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         */
        fun safetyIdentifier(safetyIdentifier: String?) = apply {
            body.safetyIdentifier(safetyIdentifier)
        }

        /** Alias for calling [Builder.safetyIdentifier] with `safetyIdentifier.orElse(null)`. */
        fun safetyIdentifier(safetyIdentifier: Optional<String>) =
            safetyIdentifier(safetyIdentifier.getOrNull())

        /**
         * Sets [Builder.safetyIdentifier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.safetyIdentifier] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun safetyIdentifier(safetyIdentifier: JsonField<String>) = apply {
            body.safetyIdentifier(safetyIdentifier)
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
        fun serviceTier(serviceTier: ServiceTier?) = apply { body.serviceTier(serviceTier) }

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
            body.serviceTier(serviceTier)
        }

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(store: Boolean?) = apply { body.store(store) }

        /**
         * Alias for [Builder.store].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun store(store: Boolean) = store(store as Boolean?)

        /** Alias for calling [Builder.store] with `store.orElse(null)`. */
        fun store(store: Optional<Boolean>) = store(store.getOrNull())

        /**
         * Sets [Builder.store] to an arbitrary JSON value.
         *
         * You should usually call [Builder.store] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun store(store: JsonField<Boolean>) = apply { body.store(store) }

        /** Options for streaming responses. Only set this when you set `stream: true`. */
        fun streamOptions(streamOptions: StreamOptions?) = apply {
            body.streamOptions(streamOptions)
        }

        /** Alias for calling [Builder.streamOptions] with `streamOptions.orElse(null)`. */
        fun streamOptions(streamOptions: Optional<StreamOptions>) =
            streamOptions(streamOptions.getOrNull())

        /**
         * Sets [Builder.streamOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.streamOptions] with a well-typed [StreamOptions] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun streamOptions(streamOptions: JsonField<StreamOptions>) = apply {
            body.streamOptions(streamOptions)
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
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
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: BetaResponseTextConfig) = apply { body.text(text) }

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [BetaResponseTextConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<BetaResponseTextConfig>) = apply { body.text(text) }

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: ToolChoice) = apply { body.toolChoice(toolChoice) }

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { body.toolChoice(toolChoice) }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceOptions(betaToolChoiceOptions)`.
         */
        fun toolChoice(betaToolChoiceOptions: BetaToolChoiceOptions) = apply {
            body.toolChoice(betaToolChoiceOptions)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceAllowed(betaToolChoiceAllowed)`.
         */
        fun toolChoice(betaToolChoiceAllowed: BetaToolChoiceAllowed) = apply {
            body.toolChoice(betaToolChoiceAllowed)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceTypes(betaToolChoiceTypes)`.
         */
        fun toolChoice(betaToolChoiceTypes: BetaToolChoiceTypes) = apply {
            body.toolChoice(betaToolChoiceTypes)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceFunction(betaToolChoiceFunction)`.
         */
        fun toolChoice(betaToolChoiceFunction: BetaToolChoiceFunction) = apply {
            body.toolChoice(betaToolChoiceFunction)
        }

        /**
         * Alias for calling [toolChoice] with `ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp)`.
         */
        fun toolChoice(betaToolChoiceMcp: BetaToolChoiceMcp) = apply {
            body.toolChoice(betaToolChoiceMcp)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceCustom(betaToolChoiceCustom)`.
         */
        fun toolChoice(betaToolChoiceCustom: BetaToolChoiceCustom) = apply {
            body.toolChoice(betaToolChoiceCustom)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaSpecificProgrammaticToolCallingParam()`.
         */
        fun toolChoiceBetaSpecificProgrammaticToolCallingParam() = apply {
            body.toolChoiceBetaSpecificProgrammaticToolCallingParam()
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceApplyPatch(betaToolChoiceApplyPatch)`.
         */
        fun toolChoice(betaToolChoiceApplyPatch: BetaToolChoiceApplyPatch) = apply {
            body.toolChoice(betaToolChoiceApplyPatch)
        }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofBetaToolChoiceShell(betaToolChoiceShell)`.
         */
        fun toolChoice(betaToolChoiceShell: BetaToolChoiceShell) = apply {
            body.toolChoice(betaToolChoiceShell)
        }

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
        fun tools(tools: List<BetaTool>) = apply { body.tools(tools) }

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<BetaTool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [BetaTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: BetaTool) = apply { body.addTool(tool) }

        /** Alias for calling [addTool] with `BetaTool.ofFunction(function)`. */
        fun addTool(function: BetaFunctionTool) = apply { body.addTool(function) }

        /** Alias for calling [addTool] with `BetaTool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: BetaFileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaFileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            body.addFileSearchTool(vectorStoreIds)
        }

        /** Alias for calling [addTool] with `BetaTool.ofComputer(computer)`. */
        fun addTool(computer: BetaComputerTool) = apply { body.addTool(computer) }

        /** Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: BetaComputerUsePreviewTool) = apply {
            body.addTool(computerUsePreview)
        }

        /** Alias for calling [addTool] with `BetaTool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: BetaWebSearchTool) = apply { body.addTool(webSearch) }

        /** Alias for calling [addTool] with `BetaTool.ofMcp(mcp)`. */
        fun addTool(mcp: BetaTool.Mcp) = apply { body.addTool(mcp) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) = apply { body.addMcpTool(serverLabel) }

        /** Alias for calling [addTool] with `BetaTool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: BetaTool.CodeInterpreter) = apply {
            body.addTool(codeInterpreter)
        }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaTool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: BetaTool.CodeInterpreter.Container) = apply {
            body.addCodeInterpreterTool(container)
        }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) = apply { body.addCodeInterpreterTool(string) }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: BetaTool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) = apply { body.addCodeInterpreterTool(codeInterpreterToolAuto) }

        /** Alias for calling [addTool] with `BetaTool.ofProgrammaticToolCalling()`. */
        fun addToolProgrammaticToolCalling() = apply { body.addToolProgrammaticToolCalling() }

        /** Alias for calling [addTool] with `BetaTool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: BetaTool.ImageGeneration) = apply {
            body.addTool(imageGeneration)
        }

        /** Alias for calling [addTool] with `BetaTool.ofLocalShell()`. */
        fun addToolLocalShell() = apply { body.addToolLocalShell() }

        /** Alias for calling [addTool] with `BetaTool.ofShell(shell)`. */
        fun addTool(shell: BetaFunctionShellTool) = apply { body.addTool(shell) }

        /** Alias for calling [addTool] with `BetaTool.ofCustom(custom)`. */
        fun addTool(custom: BetaCustomTool) = apply { body.addTool(custom) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * BetaCustomTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addCustomTool(name: String) = apply { body.addCustomTool(name) }

        /** Alias for calling [addTool] with `BetaTool.ofNamespace(namespace)`. */
        fun addTool(namespace: BetaNamespaceTool) = apply { body.addTool(namespace) }

        /** Alias for calling [addTool] with `BetaTool.ofToolSearch(toolSearch)`. */
        fun addTool(toolSearch: BetaToolSearchTool) = apply { body.addTool(toolSearch) }

        /** Alias for calling [addTool] with `BetaTool.ofWebSearchPreview(webSearchPreview)`. */
        fun addTool(webSearchPreview: BetaWebSearchPreviewTool) = apply {
            body.addTool(webSearchPreview)
        }

        /** Alias for calling [addTool] with `BetaTool.ofApplyPatch(applyPatch)`. */
        fun addTool(applyPatch: BetaApplyPatchTool) = apply { body.addTool(applyPatch) }

        /**
         * An integer between 0 and 20 specifying the maximum number of most likely tokens to return
         * at each token position, each with an associated log probability. In some cases, the
         * number of returned tokens may be fewer than requested.
         */
        fun topLogprobs(topLogprobs: Long?) = apply { body.topLogprobs(topLogprobs) }

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
        fun topLogprobs(topLogprobs: JsonField<Long>) = apply { body.topLogprobs(topLogprobs) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
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
         * The truncation strategy to use for the model response.
         * - `auto`: If the input to this Response exceeds the model's context window size, the
         *   model will truncate the response to fit the context window by dropping items from the
         *   beginning of the conversation.
         * - `disabled` (default): If the input size will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        @Deprecated("deprecated")
        fun truncation(truncation: Truncation?) = apply { body.truncation(truncation) }

        /** Alias for calling [Builder.truncation] with `truncation.orElse(null)`. */
        @Deprecated("deprecated")
        fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [Truncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
        fun truncation(truncation: JsonField<Truncation>) = apply { body.truncation(truncation) }

        /**
         * This field is being replaced by `safety_identifier` and `prompt_cache_key`. Use
         * `prompt_cache_key` instead to maintain caching optimizations. A stable identifier for
         * your end-users. Used to boost cache hit rates by better bucketing similar requests and to
         * help OpenAI detect and prevent abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         */
        @Deprecated("deprecated") fun user(user: String) = apply { body.user(user) }

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        @Deprecated("deprecated") fun user(user: JsonField<String>) = apply { body.user(user) }

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
         * Returns an immutable instance of [ResponseCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseCreateParams =
            ResponseCreateParams(
                betas?.toImmutable(),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                betas?.forEach { put("openai-beta", it.toString()) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val background: JsonField<Boolean>,
        private val contextManagement: JsonField<List<ContextManagement>>,
        private val conversation: JsonField<Conversation>,
        private val include: JsonField<List<BetaResponseIncludable>>,
        private val input: JsonField<Input>,
        private val instructions: JsonField<String>,
        private val maxOutputTokens: JsonField<Long>,
        private val maxToolCalls: JsonField<Long>,
        private val metadata: JsonField<Metadata>,
        private val model: JsonField<Model>,
        private val moderation: JsonField<Moderation>,
        private val multiAgent: JsonField<MultiAgent>,
        private val parallelToolCalls: JsonField<Boolean>,
        private val previousResponseId: JsonField<String>,
        private val prompt: JsonField<BetaResponsePrompt>,
        private val promptCacheKey: JsonField<String>,
        private val promptCacheOptions: JsonField<PromptCacheOptions>,
        private val promptCacheRetention: JsonField<PromptCacheRetention>,
        private val reasoning: JsonField<Reasoning>,
        private val safetyIdentifier: JsonField<String>,
        private val serviceTier: JsonField<ServiceTier>,
        private val store: JsonField<Boolean>,
        private val streamOptions: JsonField<StreamOptions>,
        private val temperature: JsonField<Double>,
        private val text: JsonField<BetaResponseTextConfig>,
        private val toolChoice: JsonField<ToolChoice>,
        private val tools: JsonField<List<BetaTool>>,
        private val topLogprobs: JsonField<Long>,
        private val topP: JsonField<Double>,
        private val truncation: JsonField<Truncation>,
        private val user: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("background")
            @ExcludeMissing
            background: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("context_management")
            @ExcludeMissing
            contextManagement: JsonField<List<ContextManagement>> = JsonMissing.of(),
            @JsonProperty("conversation")
            @ExcludeMissing
            conversation: JsonField<Conversation> = JsonMissing.of(),
            @JsonProperty("include")
            @ExcludeMissing
            include: JsonField<List<BetaResponseIncludable>> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("max_output_tokens")
            @ExcludeMissing
            maxOutputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_tool_calls")
            @ExcludeMissing
            maxToolCalls: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
            @JsonProperty("moderation")
            @ExcludeMissing
            moderation: JsonField<Moderation> = JsonMissing.of(),
            @JsonProperty("multi_agent")
            @ExcludeMissing
            multiAgent: JsonField<MultiAgent> = JsonMissing.of(),
            @JsonProperty("parallel_tool_calls")
            @ExcludeMissing
            parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
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
            @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("stream_options")
            @ExcludeMissing
            streamOptions: JsonField<StreamOptions> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("text")
            @ExcludeMissing
            text: JsonField<BetaResponseTextConfig> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<BetaTool>> = JsonMissing.of(),
            @JsonProperty("top_logprobs")
            @ExcludeMissing
            topLogprobs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("truncation")
            @ExcludeMissing
            truncation: JsonField<Truncation> = JsonMissing.of(),
            @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
        ) : this(
            background,
            contextManagement,
            conversation,
            include,
            input,
            instructions,
            maxOutputTokens,
            maxToolCalls,
            metadata,
            model,
            moderation,
            multiAgent,
            parallelToolCalls,
            previousResponseId,
            prompt,
            promptCacheKey,
            promptCacheOptions,
            promptCacheRetention,
            reasoning,
            safetyIdentifier,
            serviceTier,
            store,
            streamOptions,
            temperature,
            text,
            toolChoice,
            tools,
            topLogprobs,
            topP,
            truncation,
            user,
            mutableMapOf(),
        )

        /**
         * Whether to run the model response in the background.
         * [Learn more](https://platform.openai.com/docs/guides/background).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun background(): Optional<Boolean> = background.getOptional("background")

        /**
         * Context management configuration for this request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contextManagement(): Optional<List<ContextManagement>> =
            contextManagement.getOptional("context_management")

        /**
         * The conversation that this response belongs to. Items from this conversation are
         * prepended to `input_items` for this response request. Input items and output items from
         * this response are automatically added to this conversation after this response completes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun conversation(): Optional<Conversation> = conversation.getOptional("conversation")

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `web_search_call.action.sources`: Include the sources of the web search tool call.
         * - `code_interpreter_call.outputs`: Includes the outputs of python code execution in code
         *   interpreter tool call items.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `message.output_text.logprobs`: Include logprobs with assistant messages.
         * - `reasoning.encrypted_content`: Includes an encrypted version of reasoning tokens in
         *   reasoning item outputs. This enables reasoning items to be used in multi-turn
         *   conversations when using the Responses API statelessly (like when the `store` parameter
         *   is set to `false`, or when an organization is enrolled in the zero data retention
         *   program).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun include(): Optional<List<BetaResponseIncludable>> = include.getOptional("include")

        /**
         * Text, image, or file inputs to the model, used to generate a response.
         *
         * Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Image inputs](https://platform.openai.com/docs/guides/images)
         * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
         * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
         * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<Input> = input.getOptional("input")

        /**
         * A system (or developer) message inserted into the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("instructions")

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
         * The maximum number of total calls to built-in tools that can be processed in a response.
         * This maximum number applies across all built-in tool calls, not per individual tool. Any
         * further attempts to call a tool by the model will be ignored.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxToolCalls(): Optional<Long> = maxToolCalls.getOptional("max_tool_calls")

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
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<Model> = model.getOptional("model")

        /**
         * Configuration for running moderation on the input and output of this response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun moderation(): Optional<Moderation> = moderation.getOptional("moderation")

        /**
         * Configuration for server-hosted multi-agent execution.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun multiAgent(): Optional<MultiAgent> = multiAgent.getOptional("multi_agent")

        /**
         * Whether to allow the model to run tool calls in parallel.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parallelToolCalls(): Optional<Boolean> =
            parallelToolCalls.getOptional("parallel_tool_calls")

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state). Cannot
         * be used in conjunction with `conversation`.
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
         * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
         * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
         * content blocks with `prompt_cache_breakpoint`. Each request can write up to four
         * breakpoints. For cache matching, OpenAI considers up to the latest 80 breakpoints in the
         * conversation, without a content-block lookback limit. Set `mode` to `explicit` to disable
         * the implicit breakpoint. The `ttl` defaults to `30m`, which is currently the only
         * supported value. See the
         * [prompt caching guide](https://platform.openai.com/docs/guides/prompt-caching) for
         * current details.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun promptCacheOptions(): Optional<PromptCacheOptions> =
            promptCacheOptions.getOptional("prompt_cache_options")

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
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user,
         * with a maximum length of 64 characters. We recommend hashing their username or email
         * address, in order to avoid sending us any identifying information.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun safetyIdentifier(): Optional<String> = safetyIdentifier.getOptional("safety_identifier")

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
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

        /**
         * Whether to store the generated model response for later retrieval via API.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun store(): Optional<Boolean> = store.getOptional("store")

        /**
         * Options for streaming responses. Only set this when you set `stream: true`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamOptions(): Optional<StreamOptions> = streamOptions.getOptional("stream_options")

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

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
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

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
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<BetaTool>> = tools.getOptional("tools")

        /**
         * An integer between 0 and 20 specifying the maximum number of most likely tokens to return
         * at each token position, each with an associated log probability. In some cases, the
         * number of returned tokens may be fewer than requested.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topLogprobs(): Optional<Long> = topLogprobs.getOptional("top_logprobs")

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = topP.getOptional("top_p")

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the input to this Response exceeds the model's context window size, the
         *   model will truncate the response to fit the context window by dropping items from the
         *   beginning of the conversation.
         * - `disabled` (default): If the input size will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun truncation(): Optional<Truncation> = truncation.getOptional("truncation")

        /**
         * This field is being replaced by `safety_identifier` and `prompt_cache_key`. Use
         * `prompt_cache_key` instead to maintain caching optimizations. A stable identifier for
         * your end-users. Used to boost cache hit rates by better bucketing similar requests and to
         * help OpenAI detect and prevent abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated") fun user(): Optional<String> = user.getOptional("user")

        /**
         * Returns the raw JSON value of [background].
         *
         * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("background")
        @ExcludeMissing
        fun _background(): JsonField<Boolean> = background

        /**
         * Returns the raw JSON value of [contextManagement].
         *
         * Unlike [contextManagement], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("context_management")
        @ExcludeMissing
        fun _contextManagement(): JsonField<List<ContextManagement>> = contextManagement

        /**
         * Returns the raw JSON value of [conversation].
         *
         * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversation")
        @ExcludeMissing
        fun _conversation(): JsonField<Conversation> = conversation

        /**
         * Returns the raw JSON value of [include].
         *
         * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("include")
        @ExcludeMissing
        fun _include(): JsonField<List<BetaResponseIncludable>> = include

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

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
         * Returns the raw JSON value of [maxOutputTokens].
         *
         * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

        /**
         * Returns the raw JSON value of [maxToolCalls].
         *
         * Unlike [maxToolCalls], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_tool_calls")
        @ExcludeMissing
        fun _maxToolCalls(): JsonField<Long> = maxToolCalls

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
         * Returns the raw JSON value of [moderation].
         *
         * Unlike [moderation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("moderation")
        @ExcludeMissing
        fun _moderation(): JsonField<Moderation> = moderation

        /**
         * Returns the raw JSON value of [multiAgent].
         *
         * Unlike [multiAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("multi_agent")
        @ExcludeMissing
        fun _multiAgent(): JsonField<MultiAgent> = multiAgent

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
         * Returns the raw JSON value of [previousResponseId].
         *
         * Unlike [previousResponseId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

        /**
         * Returns the raw JSON value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prompt")
        @ExcludeMissing
        fun _prompt(): JsonField<BetaResponsePrompt> = prompt

        /**
         * Returns the raw JSON value of [promptCacheKey].
         *
         * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("prompt_cache_key")
        @ExcludeMissing
        fun _promptCacheKey(): JsonField<String> = promptCacheKey

        /**
         * Returns the raw JSON value of [promptCacheOptions].
         *
         * Unlike [promptCacheOptions], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("prompt_cache_options")
        @ExcludeMissing
        fun _promptCacheOptions(): JsonField<PromptCacheOptions> = promptCacheOptions

        /**
         * Returns the raw JSON value of [promptCacheRetention].
         *
         * Unlike [promptCacheRetention], this method doesn't throw if the JSON field has an
         * unexpected type.
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
        @JsonProperty("reasoning")
        @ExcludeMissing
        fun _reasoning(): JsonField<Reasoning> = reasoning

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
         * Returns the raw JSON value of [store].
         *
         * Unlike [store], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("store") @ExcludeMissing fun _store(): JsonField<Boolean> = store

        /**
         * Returns the raw JSON value of [streamOptions].
         *
         * Unlike [streamOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("stream_options")
        @ExcludeMissing
        fun _streamOptions(): JsonField<StreamOptions> = streamOptions

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<BetaResponseTextConfig> = text

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
         * Returns the raw JSON value of [topLogprobs].
         *
         * Unlike [topLogprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        fun _topLogprobs(): JsonField<Long> = topLogprobs

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

        /**
         * Returns the raw JSON value of [truncation].
         *
         * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @Deprecated("deprecated")
        @JsonProperty("truncation")
        @ExcludeMissing
        fun _truncation(): JsonField<Truncation> = truncation

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var background: JsonField<Boolean> = JsonMissing.of()
            private var contextManagement: JsonField<MutableList<ContextManagement>>? = null
            private var conversation: JsonField<Conversation> = JsonMissing.of()
            private var include: JsonField<MutableList<BetaResponseIncludable>>? = null
            private var input: JsonField<Input> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
            private var maxToolCalls: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var model: JsonField<Model> = JsonMissing.of()
            private var moderation: JsonField<Moderation> = JsonMissing.of()
            private var multiAgent: JsonField<MultiAgent> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var prompt: JsonField<BetaResponsePrompt> = JsonMissing.of()
            private var promptCacheKey: JsonField<String> = JsonMissing.of()
            private var promptCacheOptions: JsonField<PromptCacheOptions> = JsonMissing.of()
            private var promptCacheRetention: JsonField<PromptCacheRetention> = JsonMissing.of()
            private var reasoning: JsonField<Reasoning> = JsonMissing.of()
            private var safetyIdentifier: JsonField<String> = JsonMissing.of()
            private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
            private var store: JsonField<Boolean> = JsonMissing.of()
            private var streamOptions: JsonField<StreamOptions> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var text: JsonField<BetaResponseTextConfig> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<BetaTool>>? = null
            private var topLogprobs: JsonField<Long> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var truncation: JsonField<Truncation> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                background = body.background
                contextManagement = body.contextManagement.map { it.toMutableList() }
                conversation = body.conversation
                include = body.include.map { it.toMutableList() }
                input = body.input
                instructions = body.instructions
                maxOutputTokens = body.maxOutputTokens
                maxToolCalls = body.maxToolCalls
                metadata = body.metadata
                model = body.model
                moderation = body.moderation
                multiAgent = body.multiAgent
                parallelToolCalls = body.parallelToolCalls
                previousResponseId = body.previousResponseId
                prompt = body.prompt
                promptCacheKey = body.promptCacheKey
                promptCacheOptions = body.promptCacheOptions
                promptCacheRetention = body.promptCacheRetention
                reasoning = body.reasoning
                safetyIdentifier = body.safetyIdentifier
                serviceTier = body.serviceTier
                store = body.store
                streamOptions = body.streamOptions
                temperature = body.temperature
                text = body.text
                toolChoice = body.toolChoice
                tools = body.tools.map { it.toMutableList() }
                topLogprobs = body.topLogprobs
                topP = body.topP
                truncation = body.truncation
                user = body.user
                additionalProperties = body.additionalProperties.toMutableMap()
            }

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
             * You should usually call [Builder.background] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun background(background: JsonField<Boolean>) = apply { this.background = background }

            /** Context management configuration for this request. */
            fun contextManagement(contextManagement: List<ContextManagement>?) =
                contextManagement(JsonField.ofNullable(contextManagement))

            /**
             * Alias for calling [Builder.contextManagement] with `contextManagement.orElse(null)`.
             */
            fun contextManagement(contextManagement: Optional<List<ContextManagement>>) =
                contextManagement(contextManagement.getOrNull())

            /**
             * Sets [Builder.contextManagement] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contextManagement] with a well-typed
             * `List<ContextManagement>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun contextManagement(contextManagement: JsonField<List<ContextManagement>>) = apply {
                this.contextManagement = contextManagement.map { it.toMutableList() }
            }

            /**
             * Adds a single [ContextManagement] to [Builder.contextManagement].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContextManagement(contextManagement: ContextManagement) = apply {
                this.contextManagement =
                    (this.contextManagement ?: JsonField.of(mutableListOf())).also {
                        checkKnown("contextManagement", it).add(contextManagement)
                    }
            }

            /**
             * The conversation that this response belongs to. Items from this conversation are
             * prepended to `input_items` for this response request. Input items and output items
             * from this response are automatically added to this conversation after this response
             * completes.
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

            /** Alias for calling [conversation] with `Conversation.ofId(id)`. */
            fun conversation(id: String) = conversation(Conversation.ofId(id))

            /**
             * Alias for calling [conversation] with
             * `Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)`.
             */
            fun conversation(betaResponseConversationParam: BetaResponseConversationParam) =
                conversation(
                    Conversation.ofBetaResponseConversationParam(betaResponseConversationParam)
                )

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
             * - `web_search_call.action.sources`: Include the sources of the web search tool call.
             * - `code_interpreter_call.outputs`: Includes the outputs of python code execution in
             *   code interpreter tool call items.
             * - `computer_call_output.output.image_url`: Include image urls from the computer call
             *   output.
             * - `file_search_call.results`: Include the search results of the file search tool
             *   call.
             * - `message.input_image.image_url`: Include image urls from the input message.
             * - `message.output_text.logprobs`: Include logprobs with assistant messages.
             * - `reasoning.encrypted_content`: Includes an encrypted version of reasoning tokens in
             *   reasoning item outputs. This enables reasoning items to be used in multi-turn
             *   conversations when using the Responses API statelessly (like when the `store`
             *   parameter is set to `false`, or when an organization is enrolled in the zero data
             *   retention program).
             */
            fun include(include: List<BetaResponseIncludable>?) =
                include(JsonField.ofNullable(include))

            /** Alias for calling [Builder.include] with `include.orElse(null)`. */
            fun include(include: Optional<List<BetaResponseIncludable>>) =
                include(include.getOrNull())

            /**
             * Sets [Builder.include] to an arbitrary JSON value.
             *
             * You should usually call [Builder.include] with a well-typed
             * `List<BetaResponseIncludable>` value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun include(include: JsonField<List<BetaResponseIncludable>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Adds a single [BetaResponseIncludable] to [Builder.include].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInclude(include: BetaResponseIncludable) = apply {
                this.include =
                    (this.include ?: JsonField.of(mutableListOf())).also {
                        checkKnown("include", it).add(include)
                    }
            }

            /**
             * Text, image, or file inputs to the model, used to generate a response.
             *
             * Learn more:
             * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
             * - [Image inputs](https://platform.openai.com/docs/guides/images)
             * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
             * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
             * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
             */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofText(text)`. */
            fun input(text: String) = input(Input.ofText(text))

            /** Alias for calling [input] with `Input.ofBetaResponse(betaResponse)`. */
            fun inputOfBetaResponse(betaResponse: List<BetaResponseInputItem>) =
                input(Input.ofBetaResponse(betaResponse))

            /**
             * A system (or developer) message inserted into the model's context.
             *
             * When using along with `previous_response_id`, the instructions from a previous
             * response will not be carried over to the next response. This makes it simple to swap
             * out system (or developer) messages in new responses.
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
             * An upper bound for the number of tokens that can be generated for a response,
             * including visible output tokens and
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
             * You should usually call [Builder.maxOutputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
                this.maxOutputTokens = maxOutputTokens
            }

            /**
             * The maximum number of total calls to built-in tools that can be processed in a
             * response. This maximum number applies across all built-in tool calls, not per
             * individual tool. Any further attempts to call a tool by the model will be ignored.
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
             * You should usually call [Builder.maxToolCalls] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxToolCalls(maxToolCalls: JsonField<Long>) = apply {
                this.maxToolCalls = maxToolCalls
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
             * Model ID used to generate the response, like `gpt-4o` or `o3`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [Model] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [Model] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(Model.of(value))

            /** Configuration for running moderation on the input and output of this response. */
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
            fun moderation(moderation: JsonField<Moderation>) = apply {
                this.moderation = moderation
            }

            /** Configuration for server-hosted multi-agent execution. */
            fun multiAgent(multiAgent: MultiAgent?) = multiAgent(JsonField.ofNullable(multiAgent))

            /** Alias for calling [Builder.multiAgent] with `multiAgent.orElse(null)`. */
            fun multiAgent(multiAgent: Optional<MultiAgent>) = multiAgent(multiAgent.getOrNull())

            /**
             * Sets [Builder.multiAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.multiAgent] with a well-typed [MultiAgent] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun multiAgent(multiAgent: JsonField<MultiAgent>) = apply {
                this.multiAgent = multiAgent
            }

            /** Whether to allow the model to run tool calls in parallel. */
            fun parallelToolCalls(parallelToolCalls: Boolean?) =
                parallelToolCalls(JsonField.ofNullable(parallelToolCalls))

            /**
             * Alias for [Builder.parallelToolCalls].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun parallelToolCalls(parallelToolCalls: Boolean) =
                parallelToolCalls(parallelToolCalls as Boolean?)

            /**
             * Alias for calling [Builder.parallelToolCalls] with `parallelToolCalls.orElse(null)`.
             */
            fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
                parallelToolCalls(parallelToolCalls.getOrNull())

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
             * The unique ID of the previous response to the model. Use this to create multi-turn
             * conversations. Learn more about
             * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
             * Cannot be used in conjunction with `conversation`.
             */
            fun previousResponseId(previousResponseId: String?) =
                previousResponseId(JsonField.ofNullable(previousResponseId))

            /**
             * Alias for calling [Builder.previousResponseId] with
             * `previousResponseId.orElse(null)`.
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
             * Used by OpenAI to cache responses for similar requests to optimize your cache hit
             * rates. Replaces the `user` field.
             * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
             */
            fun promptCacheKey(promptCacheKey: String?) =
                promptCacheKey(JsonField.ofNullable(promptCacheKey))

            /** Alias for calling [Builder.promptCacheKey] with `promptCacheKey.orElse(null)`. */
            fun promptCacheKey(promptCacheKey: Optional<String>) =
                promptCacheKey(promptCacheKey.getOrNull())

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
             * Options for prompt caching. Supported for `gpt-5.6` and later models. By default,
             * OpenAI automatically chooses one implicit cache breakpoint. You can add explicit
             * breakpoints to content blocks with `prompt_cache_breakpoint`. Each request can write
             * up to four breakpoints. For cache matching, OpenAI considers up to the latest 80
             * breakpoints in the conversation, without a content-block lookback limit. Set `mode`
             * to `explicit` to disable the implicit breakpoint. The `ttl` defaults to `30m`, which
             * is currently the only supported value. See the
             * [prompt caching guide](https://platform.openai.com/docs/guides/prompt-caching) for
             * current details.
             */
            fun promptCacheOptions(promptCacheOptions: PromptCacheOptions) =
                promptCacheOptions(JsonField.of(promptCacheOptions))

            /**
             * Sets [Builder.promptCacheOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promptCacheOptions] with a well-typed
             * [PromptCacheOptions] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
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
             * expresses a minimum cache lifetime. The two fields are independent and do not
             * interact. For `gpt-5.5`, `gpt-5.5-pro`, and future models, only `24h` is supported.
             *
             * For older models that support both `in_memory` and `24h`, the default depends on your
             * organization's data retention policy:
             * - Organizations without ZDR enabled default to `24h`.
             * - Organizations with ZDR enabled default to `in_memory` when `prompt_cache_retention`
             *   is not specified.
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
             * [PromptCacheRetention] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            @Deprecated("deprecated")
            fun promptCacheRetention(promptCacheRetention: JsonField<PromptCacheRetention>) =
                apply {
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
             * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

            /**
             * A stable identifier used to help detect users of your application that may be
             * violating OpenAI's usage policies. The IDs should be a string that uniquely
             * identifies each user, with a maximum length of 64 characters. We recommend hashing
             * their username or email address, in order to avoid sending us any identifying
             * information.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
             */
            fun safetyIdentifier(safetyIdentifier: String?) =
                safetyIdentifier(JsonField.ofNullable(safetyIdentifier))

            /**
             * Alias for calling [Builder.safetyIdentifier] with `safetyIdentifier.orElse(null)`.
             */
            fun safetyIdentifier(safetyIdentifier: Optional<String>) =
                safetyIdentifier(safetyIdentifier.getOrNull())

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
             * - If set to 'auto', then the request will be processed with the service tier
             *   configured in the Project settings. Unless otherwise configured, the Project will
             *   use 'default'.
             * - If set to 'default', then the request will be processed with the standard pricing
             *   and performance for the selected model.
             * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
             *   '[priority](https://openai.com/api-priority-processing/)', then the request will be
             *   processed with the corresponding service tier.
             * - When not set, the default behavior is 'auto'.
             *
             *   When the `service_tier` parameter is set, the response body will include the
             *   `service_tier` value based on the processing mode actually used to serve the
             *   request. This response value may be different from the value set in the parameter.
             */
            fun serviceTier(serviceTier: ServiceTier?) =
                serviceTier(JsonField.ofNullable(serviceTier))

            /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
            fun serviceTier(serviceTier: Optional<ServiceTier>) =
                serviceTier(serviceTier.getOrNull())

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

            /** Whether to store the generated model response for later retrieval via API. */
            fun store(store: Boolean?) = store(JsonField.ofNullable(store))

            /**
             * Alias for [Builder.store].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun store(store: Boolean) = store(store as Boolean?)

            /** Alias for calling [Builder.store] with `store.orElse(null)`. */
            fun store(store: Optional<Boolean>) = store(store.getOrNull())

            /**
             * Sets [Builder.store] to an arbitrary JSON value.
             *
             * You should usually call [Builder.store] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun store(store: JsonField<Boolean>) = apply { this.store = store }

            /** Options for streaming responses. Only set this when you set `stream: true`. */
            fun streamOptions(streamOptions: StreamOptions?) =
                streamOptions(JsonField.ofNullable(streamOptions))

            /** Alias for calling [Builder.streamOptions] with `streamOptions.orElse(null)`. */
            fun streamOptions(streamOptions: Optional<StreamOptions>) =
                streamOptions(streamOptions.getOrNull())

            /**
             * Sets [Builder.streamOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streamOptions] with a well-typed [StreamOptions]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun streamOptions(streamOptions: JsonField<StreamOptions>) = apply {
                this.streamOptions = streamOptions
            }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
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
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * Configuration options for a text response from the model. Can be plain text or
             * structured JSON data. Learn more:
             * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
             * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
             */
            fun text(text: BetaResponseTextConfig) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [BetaResponseTextConfig]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun text(text: JsonField<BetaResponseTextConfig>) = apply { this.text = text }

            /**
             * How the model should select which tool (or tools) to use when generating a response.
             * See the `tools` parameter to see how to specify which tools the model can call.
             */
            fun toolChoice(toolChoice: ToolChoice) = toolChoice(JsonField.of(toolChoice))

            /**
             * Sets [Builder.toolChoice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply {
                this.toolChoice = toolChoice
            }

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
             * Alias for calling [toolChoice] with
             * `ToolChoice.ofBetaToolChoiceMcp(betaToolChoiceMcp)`.
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
             * An array of tools the model may call while generating a response. You can specify
             * which tool to use by setting the `tool_choice` parameter.
             *
             * We support the following categories of tools:
             * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
             *   capabilities, like
             *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
             *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn
             *   more about [built-in tools](https://platform.openai.com/docs/guides/tools).
             * - **MCP Tools**: Integrations with third-party systems via custom MCP servers or
             *   predefined connectors such as Google Drive and SharePoint. Learn more about
             *   [MCP Tools](https://platform.openai.com/docs/guides/tools-connectors-mcp).
             * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
             *   model to call your own code with strongly typed arguments and outputs. Learn more
             *   about [function calling](https://platform.openai.com/docs/guides/function-calling).
             *   You can also use custom tools to call your own code.
             */
            fun tools(tools: List<BetaTool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
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

            /**
             * Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`.
             */
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
             * An integer between 0 and 20 specifying the maximum number of most likely tokens to
             * return at each token position, each with an associated log probability. In some
             * cases, the number of returned tokens may be fewer than requested.
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
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun topLogprobs(topLogprobs: JsonField<Long>) = apply { this.topLogprobs = topLogprobs }

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

            /**
             * The truncation strategy to use for the model response.
             * - `auto`: If the input to this Response exceeds the model's context window size, the
             *   model will truncate the response to fit the context window by dropping items from
             *   the beginning of the conversation.
             * - `disabled` (default): If the input size will exceed the context window size for a
             *   model, the request will fail with a 400 error.
             */
            @Deprecated("deprecated")
            fun truncation(truncation: Truncation?) = truncation(JsonField.ofNullable(truncation))

            /** Alias for calling [Builder.truncation] with `truncation.orElse(null)`. */
            @Deprecated("deprecated")
            fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

            /**
             * Sets [Builder.truncation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.truncation] with a well-typed [Truncation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
            fun truncation(truncation: JsonField<Truncation>) = apply {
                this.truncation = truncation
            }

            /**
             * This field is being replaced by `safety_identifier` and `prompt_cache_key`. Use
             * `prompt_cache_key` instead to maintain caching optimizations. A stable identifier for
             * your end-users. Used to boost cache hit rates by better bucketing similar requests
             * and to help OpenAI detect and prevent abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
             */
            @Deprecated("deprecated") fun user(user: String) = user(JsonField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary JSON value.
             *
             * You should usually call [Builder.user] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    background,
                    (contextManagement ?: JsonMissing.of()).map { it.toImmutable() },
                    conversation,
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    input,
                    instructions,
                    maxOutputTokens,
                    maxToolCalls,
                    metadata,
                    model,
                    moderation,
                    multiAgent,
                    parallelToolCalls,
                    previousResponseId,
                    prompt,
                    promptCacheKey,
                    promptCacheOptions,
                    promptCacheRetention,
                    reasoning,
                    safetyIdentifier,
                    serviceTier,
                    store,
                    streamOptions,
                    temperature,
                    text,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topLogprobs,
                    topP,
                    truncation,
                    user,
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            background()
            contextManagement().ifPresent { it.forEach { it.validate() } }
            conversation().ifPresent { it.validate() }
            include().ifPresent { it.forEach { it.validate() } }
            input().ifPresent { it.validate() }
            instructions()
            maxOutputTokens()
            maxToolCalls()
            metadata().ifPresent { it.validate() }
            model()
            moderation().ifPresent { it.validate() }
            multiAgent().ifPresent { it.validate() }
            parallelToolCalls()
            previousResponseId()
            prompt().ifPresent { it.validate() }
            promptCacheKey()
            promptCacheOptions().ifPresent { it.validate() }
            promptCacheRetention().ifPresent { it.validate() }
            reasoning().ifPresent { it.validate() }
            safetyIdentifier()
            serviceTier().ifPresent { it.validate() }
            store()
            streamOptions().ifPresent { it.validate() }
            temperature()
            text().ifPresent { it.validate() }
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topLogprobs()
            topP()
            truncation().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (background.asKnown().isPresent) 1 else 0) +
                (contextManagement.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (conversation.asKnown().getOrNull()?.validity() ?: 0) +
                (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
                (if (maxToolCalls.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (moderation.asKnown().getOrNull()?.validity() ?: 0) +
                (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0) +
                (prompt.asKnown().getOrNull()?.validity() ?: 0) +
                (if (promptCacheKey.asKnown().isPresent) 1 else 0) +
                (promptCacheOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (promptCacheRetention.asKnown().getOrNull()?.validity() ?: 0) +
                (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                (if (safetyIdentifier.asKnown().isPresent) 1 else 0) +
                (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
                (if (store.asKnown().isPresent) 1 else 0) +
                (streamOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (text.asKnown().getOrNull()?.validity() ?: 0) +
                (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (topLogprobs.asKnown().isPresent) 1 else 0) +
                (if (topP.asKnown().isPresent) 1 else 0) +
                (truncation.asKnown().getOrNull()?.validity() ?: 0) +
                (if (user.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                background == other.background &&
                contextManagement == other.contextManagement &&
                conversation == other.conversation &&
                include == other.include &&
                input == other.input &&
                instructions == other.instructions &&
                maxOutputTokens == other.maxOutputTokens &&
                maxToolCalls == other.maxToolCalls &&
                metadata == other.metadata &&
                model == other.model &&
                moderation == other.moderation &&
                multiAgent == other.multiAgent &&
                parallelToolCalls == other.parallelToolCalls &&
                previousResponseId == other.previousResponseId &&
                prompt == other.prompt &&
                promptCacheKey == other.promptCacheKey &&
                promptCacheOptions == other.promptCacheOptions &&
                promptCacheRetention == other.promptCacheRetention &&
                reasoning == other.reasoning &&
                safetyIdentifier == other.safetyIdentifier &&
                serviceTier == other.serviceTier &&
                store == other.store &&
                streamOptions == other.streamOptions &&
                temperature == other.temperature &&
                text == other.text &&
                toolChoice == other.toolChoice &&
                tools == other.tools &&
                topLogprobs == other.topLogprobs &&
                topP == other.topP &&
                truncation == other.truncation &&
                user == other.user &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                background,
                contextManagement,
                conversation,
                include,
                input,
                instructions,
                maxOutputTokens,
                maxToolCalls,
                metadata,
                model,
                moderation,
                multiAgent,
                parallelToolCalls,
                previousResponseId,
                prompt,
                promptCacheKey,
                promptCacheOptions,
                promptCacheRetention,
                reasoning,
                safetyIdentifier,
                serviceTier,
                store,
                streamOptions,
                temperature,
                text,
                toolChoice,
                tools,
                topLogprobs,
                topP,
                truncation,
                user,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{background=$background, contextManagement=$contextManagement, conversation=$conversation, include=$include, input=$input, instructions=$instructions, maxOutputTokens=$maxOutputTokens, maxToolCalls=$maxToolCalls, metadata=$metadata, model=$model, moderation=$moderation, multiAgent=$multiAgent, parallelToolCalls=$parallelToolCalls, previousResponseId=$previousResponseId, prompt=$prompt, promptCacheKey=$promptCacheKey, promptCacheOptions=$promptCacheOptions, promptCacheRetention=$promptCacheRetention, reasoning=$reasoning, safetyIdentifier=$safetyIdentifier, serviceTier=$serviceTier, store=$store, streamOptions=$streamOptions, temperature=$temperature, text=$text, toolChoice=$toolChoice, tools=$tools, topLogprobs=$topLogprobs, topP=$topP, truncation=$truncation, user=$user, additionalProperties=$additionalProperties}"
    }

    class ContextManagement
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonField<String>,
        private val compactThreshold: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("compact_threshold")
            @ExcludeMissing
            compactThreshold: JsonField<Long> = JsonMissing.of(),
        ) : this(type, compactThreshold, mutableMapOf())

        /**
         * The context management entry type. Currently only 'compaction' is supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): String = type.getRequired("type")

        /**
         * Token threshold at which compaction should be triggered for this entry.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compactThreshold(): Optional<Long> = compactThreshold.getOptional("compact_threshold")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /**
         * Returns the raw JSON value of [compactThreshold].
         *
         * Unlike [compactThreshold], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("compact_threshold")
        @ExcludeMissing
        fun _compactThreshold(): JsonField<Long> = compactThreshold

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
             * Returns a mutable builder for constructing an instance of [ContextManagement].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ContextManagement]. */
        class Builder internal constructor() {

            private var type: JsonField<String>? = null
            private var compactThreshold: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(contextManagement: ContextManagement) = apply {
                type = contextManagement.type
                compactThreshold = contextManagement.compactThreshold
                additionalProperties = contextManagement.additionalProperties.toMutableMap()
            }

            /** The context management entry type. Currently only 'compaction' is supported. */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            /** Token threshold at which compaction should be triggered for this entry. */
            fun compactThreshold(compactThreshold: Long?) =
                compactThreshold(JsonField.ofNullable(compactThreshold))

            /**
             * Alias for [Builder.compactThreshold].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun compactThreshold(compactThreshold: Long) =
                compactThreshold(compactThreshold as Long?)

            /**
             * Alias for calling [Builder.compactThreshold] with `compactThreshold.orElse(null)`.
             */
            fun compactThreshold(compactThreshold: Optional<Long>) =
                compactThreshold(compactThreshold.getOrNull())

            /**
             * Sets [Builder.compactThreshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compactThreshold] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun compactThreshold(compactThreshold: JsonField<Long>) = apply {
                this.compactThreshold = compactThreshold
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
             * Returns an immutable instance of [ContextManagement].
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
            fun build(): ContextManagement =
                ContextManagement(
                    checkRequired("type", type),
                    compactThreshold,
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
        fun validate(): ContextManagement = apply {
            if (validated) {
                return@apply
            }

            type()
            compactThreshold()
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
            (if (type.asKnown().isPresent) 1 else 0) +
                (if (compactThreshold.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ContextManagement &&
                type == other.type &&
                compactThreshold == other.compactThreshold &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(type, compactThreshold, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ContextManagement{type=$type, compactThreshold=$compactThreshold, additionalProperties=$additionalProperties}"
    }

    /**
     * The conversation that this response belongs to. Items from this conversation are prepended to
     * `input_items` for this response request. Input items and output items from this response are
     * automatically added to this conversation after this response completes.
     */
    @JsonDeserialize(using = Conversation.Deserializer::class)
    @JsonSerialize(using = Conversation.Serializer::class)
    class Conversation
    private constructor(
        private val id: String? = null,
        private val betaResponseConversationParam: BetaResponseConversationParam? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The unique ID of the conversation. */
        fun id(): Optional<String> = Optional.ofNullable(id)

        /** The conversation that this response belongs to. */
        fun betaResponseConversationParam(): Optional<BetaResponseConversationParam> =
            Optional.ofNullable(betaResponseConversationParam)

        fun isId(): Boolean = id != null

        fun isBetaResponseConversationParam(): Boolean = betaResponseConversationParam != null

        /** The unique ID of the conversation. */
        fun asId(): String = id.getOrThrow("id")

        /** The conversation that this response belongs to. */
        fun asBetaResponseConversationParam(): BetaResponseConversationParam =
            betaResponseConversationParam.getOrThrow("betaResponseConversationParam")

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
         * Optional<String> result = conversation.accept(new Conversation.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitId(String id) {
         *         return Optional.of(id.toString());
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
                id != null -> visitor.visitId(id)
                betaResponseConversationParam != null ->
                    visitor.visitBetaResponseConversationParam(betaResponseConversationParam)
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
        fun validate(): Conversation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitId(id: String) {}

                    override fun visitBetaResponseConversationParam(
                        betaResponseConversationParam: BetaResponseConversationParam
                    ) {
                        betaResponseConversationParam.validate()
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
                    override fun visitId(id: String) = 1

                    override fun visitBetaResponseConversationParam(
                        betaResponseConversationParam: BetaResponseConversationParam
                    ) = betaResponseConversationParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Conversation &&
                id == other.id &&
                betaResponseConversationParam == other.betaResponseConversationParam
        }

        override fun hashCode(): Int = Objects.hash(id, betaResponseConversationParam)

        override fun toString(): String =
            when {
                id != null -> "Conversation{id=$id}"
                betaResponseConversationParam != null ->
                    "Conversation{betaResponseConversationParam=$betaResponseConversationParam}"
                _json != null -> "Conversation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Conversation")
            }

        companion object {

            /** The unique ID of the conversation. */
            @JvmStatic fun ofId(id: String) = Conversation(id = id)

            /** The conversation that this response belongs to. */
            @JvmStatic
            fun ofBetaResponseConversationParam(
                betaResponseConversationParam: BetaResponseConversationParam
            ) = Conversation(betaResponseConversationParam = betaResponseConversationParam)
        }

        /**
         * An interface that defines how to map each variant of [Conversation] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** The unique ID of the conversation. */
            fun visitId(id: String): T

            /** The conversation that this response belongs to. */
            fun visitBetaResponseConversationParam(
                betaResponseConversationParam: BetaResponseConversationParam
            ): T

            /**
             * Maps an unknown variant of [Conversation] to a value of type [T].
             *
             * An instance of [Conversation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Conversation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Conversation>(Conversation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Conversation {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<BetaResponseConversationParam>())
                                ?.let {
                                    Conversation(betaResponseConversationParam = it, _json = json)
                                },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Conversation(id = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Conversation(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Conversation>(Conversation::class) {

            override fun serialize(
                value: Conversation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.id != null -> generator.writeObject(value.id)
                    value.betaResponseConversationParam != null ->
                        generator.writeObject(value.betaResponseConversationParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Conversation")
                }
            }
        }
    }

    /**
     * Text, image, or file inputs to the model, used to generate a response.
     *
     * Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Image inputs](https://platform.openai.com/docs/guides/images)
     * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
     * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
     * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
     */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val text: String? = null,
        private val betaResponse: List<BetaResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun text(): Optional<String> = Optional.ofNullable(text)

        /** A list of one or many input items to the model, containing different content types. */
        fun betaResponse(): Optional<List<BetaResponseInputItem>> =
            Optional.ofNullable(betaResponse)

        fun isText(): Boolean = text != null

        fun isBetaResponse(): Boolean = betaResponse != null

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun asText(): String = text.getOrThrow("text")

        /** A list of one or many input items to the model, containing different content types. */
        fun asBetaResponse(): List<BetaResponseInputItem> = betaResponse.getOrThrow("betaResponse")

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
         * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitText(String text) {
         *         return Optional.of(text.toString());
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
                text != null -> visitor.visitText(text)
                betaResponse != null -> visitor.visitBetaResponse(betaResponse)
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
        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitText(text: String) {}

                    override fun visitBetaResponse(betaResponse: List<BetaResponseInputItem>) {
                        betaResponse.forEach { it.validate() }
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
                    override fun visitText(text: String) = 1

                    override fun visitBetaResponse(betaResponse: List<BetaResponseInputItem>) =
                        betaResponse.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input && text == other.text && betaResponse == other.betaResponse
        }

        override fun hashCode(): Int = Objects.hash(text, betaResponse)

        override fun toString(): String =
            when {
                text != null -> "Input{text=$text}"
                betaResponse != null -> "Input{betaResponse=$betaResponse}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            @JvmStatic fun ofText(text: String) = Input(text = text)

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            @JvmStatic
            fun ofBetaResponse(betaResponse: List<BetaResponseInputItem>) =
                Input(betaResponse = betaResponse.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            fun visitText(text: String): T

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun visitBetaResponse(betaResponse: List<BetaResponseInputItem>): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Input(text = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<BetaResponseInputItem>>())
                                ?.let { Input(betaResponse = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Input(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.text != null -> generator.writeObject(value.text)
                    value.betaResponse != null -> generator.writeObject(value.betaResponse)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
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

    /** Configuration for running moderation on the input and output of this response. */
    class Moderation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val model: JsonField<String>,
        private val policy: JsonField<Policy>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("policy") @ExcludeMissing policy: JsonField<Policy> = JsonMissing.of(),
        ) : this(model, policy, mutableMapOf())

        /**
         * The moderation model to use for moderated completions, e.g. 'omni-moderation-latest'.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * The policy to apply to moderated response input and output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun policy(): Optional<Policy> = policy.getOptional("policy")

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [policy].
         *
         * Unlike [policy], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("policy") @ExcludeMissing fun _policy(): JsonField<Policy> = policy

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
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Moderation]. */
        class Builder internal constructor() {

            private var model: JsonField<String>? = null
            private var policy: JsonField<Policy> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderation: Moderation) = apply {
                model = moderation.model
                policy = moderation.policy
                additionalProperties = moderation.additionalProperties.toMutableMap()
            }

            /**
             * The moderation model to use for moderated completions, e.g. 'omni-moderation-latest'.
             */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** The policy to apply to moderated response input and output. */
            fun policy(policy: Policy?) = policy(JsonField.ofNullable(policy))

            /** Alias for calling [Builder.policy] with `policy.orElse(null)`. */
            fun policy(policy: Optional<Policy>) = policy(policy.getOrNull())

            /**
             * Sets [Builder.policy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.policy] with a well-typed [Policy] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun policy(policy: JsonField<Policy>) = apply { this.policy = policy }

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
             * .model()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Moderation =
                Moderation(
                    checkRequired("model", model),
                    policy,
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

            model()
            policy().ifPresent { it.validate() }
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
            (if (model.asKnown().isPresent) 1 else 0) +
                (policy.asKnown().getOrNull()?.validity() ?: 0)

        /** The policy to apply to moderated response input and output. */
        class Policy
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
             * The moderation policy for the response input.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun input(): Optional<Input> = input.getOptional("input")

            /**
             * The moderation policy for the response output.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun output(): Optional<Output> = output.getOptional("output")

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

                /** Returns a mutable builder for constructing an instance of [Policy]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Policy]. */
            class Builder internal constructor() {

                private var input: JsonField<Input> = JsonMissing.of()
                private var output: JsonField<Output> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(policy: Policy) = apply {
                    input = policy.input
                    output = policy.output
                    additionalProperties = policy.additionalProperties.toMutableMap()
                }

                /** The moderation policy for the response input. */
                fun input(input: Input?) = input(JsonField.ofNullable(input))

                /** Alias for calling [Builder.input] with `input.orElse(null)`. */
                fun input(input: Optional<Input>) = input(input.getOrNull())

                /**
                 * Sets [Builder.input] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.input] with a well-typed [Input] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun input(input: JsonField<Input>) = apply { this.input = input }

                /** The moderation policy for the response output. */
                fun output(output: Output?) = output(JsonField.ofNullable(output))

                /** Alias for calling [Builder.output] with `output.orElse(null)`. */
                fun output(output: Optional<Output>) = output(output.getOrNull())

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [Output] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun output(output: JsonField<Output>) = apply { this.output = output }

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
                 * Returns an immutable instance of [Policy].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Policy = Policy(input, output, additionalProperties.toMutableMap())
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
            fun validate(): Policy = apply {
                if (validated) {
                    return@apply
                }

                input().ifPresent { it.validate() }
                output().ifPresent { it.validate() }
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

            /** The moderation policy for the response input. */
            class Input
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val mode: JsonField<Mode>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of()
                ) : this(mode, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun mode(): Mode = mode.getRequired("mode")

                /**
                 * Returns the raw JSON value of [mode].
                 *
                 * Unlike [mode], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

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
                     * Returns a mutable builder for constructing an instance of [Input].
                     *
                     * The following fields are required:
                     * ```java
                     * .mode()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Input]. */
                class Builder internal constructor() {

                    private var mode: JsonField<Mode>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(input: Input) = apply {
                        mode = input.mode
                        additionalProperties = input.additionalProperties.toMutableMap()
                    }

                    fun mode(mode: Mode) = mode(JsonField.of(mode))

                    /**
                     * Sets [Builder.mode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.mode] with a well-typed [Mode] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

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
                     * Returns an immutable instance of [Input].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .mode()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Input =
                        Input(checkRequired("mode", mode), additionalProperties.toMutableMap())
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
                fun validate(): Input = apply {
                    if (validated) {
                        return@apply
                    }

                    mode().validate()
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
                internal fun validity(): Int = (mode.asKnown().getOrNull()?.validity() ?: 0)

                class Mode @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val SCORE = of("score")

                        @JvmField val BLOCK = of("block")

                        @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
                    }

                    /** An enum containing [Mode]'s known values. */
                    enum class Known {
                        SCORE,
                        BLOCK,
                    }

                    /**
                     * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Mode] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        SCORE,
                        BLOCK,
                        /**
                         * An enum member indicating that [Mode] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            SCORE -> Value.SCORE
                            BLOCK -> Value.BLOCK
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            SCORE -> Known.SCORE
                            BLOCK -> Known.BLOCK
                            else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            OpenAIInvalidDataException("Value is not a String")
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Mode && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Input &&
                        mode == other.mode &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Input{mode=$mode, additionalProperties=$additionalProperties}"
            }

            /** The moderation policy for the response output. */
            class Output
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val mode: JsonField<Mode>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of()
                ) : this(mode, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun mode(): Mode = mode.getRequired("mode")

                /**
                 * Returns the raw JSON value of [mode].
                 *
                 * Unlike [mode], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

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
                     * Returns a mutable builder for constructing an instance of [Output].
                     *
                     * The following fields are required:
                     * ```java
                     * .mode()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Output]. */
                class Builder internal constructor() {

                    private var mode: JsonField<Mode>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(output: Output) = apply {
                        mode = output.mode
                        additionalProperties = output.additionalProperties.toMutableMap()
                    }

                    fun mode(mode: Mode) = mode(JsonField.of(mode))

                    /**
                     * Sets [Builder.mode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.mode] with a well-typed [Mode] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

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
                     * Returns an immutable instance of [Output].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .mode()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Output =
                        Output(checkRequired("mode", mode), additionalProperties.toMutableMap())
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
                fun validate(): Output = apply {
                    if (validated) {
                        return@apply
                    }

                    mode().validate()
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
                internal fun validity(): Int = (mode.asKnown().getOrNull()?.validity() ?: 0)

                class Mode @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val SCORE = of("score")

                        @JvmField val BLOCK = of("block")

                        @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
                    }

                    /** An enum containing [Mode]'s known values. */
                    enum class Known {
                        SCORE,
                        BLOCK,
                    }

                    /**
                     * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Mode] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        SCORE,
                        BLOCK,
                        /**
                         * An enum member indicating that [Mode] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            SCORE -> Value.SCORE
                            BLOCK -> Value.BLOCK
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            SCORE -> Known.SCORE
                            BLOCK -> Known.BLOCK
                            else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            OpenAIInvalidDataException("Value is not a String")
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Mode && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Output &&
                        mode == other.mode &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Output{mode=$mode, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Policy &&
                    input == other.input &&
                    output == other.output &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Policy{input=$input, output=$output, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Moderation &&
                model == other.model &&
                policy == other.policy &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(model, policy, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Moderation{model=$model, policy=$policy, additionalProperties=$additionalProperties}"
    }

    /** Configuration for server-hosted multi-agent execution. */
    class MultiAgent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val maxConcurrentSubagents: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("max_concurrent_subagents")
            @ExcludeMissing
            maxConcurrentSubagents: JsonField<Long> = JsonMissing.of(),
        ) : this(enabled, maxConcurrentSubagents, mutableMapOf())

        /**
         * Whether to enable server-hosted multi-agent execution for this response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun enabled(): Boolean = enabled.getRequired("enabled")

        /**
         * `max_concurrent_subagents` sets the maximum number of subagents that can be active
         * simultaneously across the entire agent tree. It includes all descendants—children,
         * grandchildren, and deeper subagents—but excludes the root agent. The API does not impose
         * a fixed upper bound on this setting. The default is `3`, which is recommended for most
         * workloads. Multi-agent runs also have no fixed limit on tree depth or the total number of
         * subagents created during a run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxConcurrentSubagents(): Optional<Long> =
            maxConcurrentSubagents.getOptional("max_concurrent_subagents")

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

        /**
         * Returns the raw JSON value of [maxConcurrentSubagents].
         *
         * Unlike [maxConcurrentSubagents], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_concurrent_subagents")
        @ExcludeMissing
        fun _maxConcurrentSubagents(): JsonField<Long> = maxConcurrentSubagents

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
             * Returns a mutable builder for constructing an instance of [MultiAgent].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MultiAgent]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var maxConcurrentSubagents: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(multiAgent: MultiAgent) = apply {
                enabled = multiAgent.enabled
                maxConcurrentSubagents = multiAgent.maxConcurrentSubagents
                additionalProperties = multiAgent.additionalProperties.toMutableMap()
            }

            /** Whether to enable server-hosted multi-agent execution for this response. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

            /**
             * `max_concurrent_subagents` sets the maximum number of subagents that can be active
             * simultaneously across the entire agent tree. It includes all descendants—children,
             * grandchildren, and deeper subagents—but excludes the root agent. The API does not
             * impose a fixed upper bound on this setting. The default is `3`, which is recommended
             * for most workloads. Multi-agent runs also have no fixed limit on tree depth or the
             * total number of subagents created during a run.
             */
            fun maxConcurrentSubagents(maxConcurrentSubagents: Long) =
                maxConcurrentSubagents(JsonField.of(maxConcurrentSubagents))

            /**
             * Sets [Builder.maxConcurrentSubagents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxConcurrentSubagents] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun maxConcurrentSubagents(maxConcurrentSubagents: JsonField<Long>) = apply {
                this.maxConcurrentSubagents = maxConcurrentSubagents
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
             * Returns an immutable instance of [MultiAgent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MultiAgent =
                MultiAgent(
                    checkRequired("enabled", enabled),
                    maxConcurrentSubagents,
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
        fun validate(): MultiAgent = apply {
            if (validated) {
                return@apply
            }

            enabled()
            maxConcurrentSubagents()
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
            (if (enabled.asKnown().isPresent) 1 else 0) +
                (if (maxConcurrentSubagents.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MultiAgent &&
                enabled == other.enabled &&
                maxConcurrentSubagents == other.maxConcurrentSubagents &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(enabled, maxConcurrentSubagents, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MultiAgent{enabled=$enabled, maxConcurrentSubagents=$maxConcurrentSubagents, additionalProperties=$additionalProperties}"
    }

    /**
     * Options for prompt caching. Supported for `gpt-5.6` and later models. By default, OpenAI
     * automatically chooses one implicit cache breakpoint. You can add explicit breakpoints to
     * content blocks with `prompt_cache_breakpoint`. Each request can write up to four breakpoints.
     * For cache matching, OpenAI considers up to the latest 80 breakpoints in the conversation,
     * without a content-block lookback limit. Set `mode` to `explicit` to disable the implicit
     * breakpoint. The `ttl` defaults to `30m`, which is currently the only supported value. See the
     * [prompt caching guide](https://platform.openai.com/docs/guides/prompt-caching) for current
     * details.
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
         * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults to
         * `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up to the
         * latest three explicit breakpoints in the request. With `explicit`, OpenAI does not create
         * an implicit breakpoint and writes up to the latest four explicit breakpoints. If there
         * are no explicit breakpoints, the request does not use prompt caching.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<Mode> = mode.getOptional("mode")

        /**
         * The minimum lifetime applied to every implicit and explicit cache breakpoint written by
         * the request. Defaults to `30m`, which is currently the only supported value. The backend
         * may retain cache entries for longer.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun ttl(): Optional<Ttl> = ttl.getOptional("ttl")

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

            /** Returns a mutable builder for constructing an instance of [PromptCacheOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PromptCacheOptions]. */
        class Builder internal constructor() {

            private var mode: JsonField<Mode> = JsonMissing.of()
            private var ttl: JsonField<Ttl> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptCacheOptions: PromptCacheOptions) = apply {
                mode = promptCacheOptions.mode
                ttl = promptCacheOptions.ttl
                additionalProperties = promptCacheOptions.additionalProperties.toMutableMap()
            }

            /**
             * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults
             * to `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up
             * to the latest three explicit breakpoints in the request. With `explicit`, OpenAI does
             * not create an implicit breakpoint and writes up to the latest four explicit
             * breakpoints. If there are no explicit breakpoints, the request does not use prompt
             * caching.
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
             * The minimum lifetime applied to every implicit and explicit cache breakpoint written
             * by the request. Defaults to `30m`, which is currently the only supported value. The
             * backend may retain cache entries for longer.
             */
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
             */
            fun build(): PromptCacheOptions =
                PromptCacheOptions(mode, ttl, additionalProperties.toMutableMap())
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

            mode().ifPresent { it.validate() }
            ttl().ifPresent { it.validate() }
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

        /**
         * Controls whether OpenAI automatically creates an implicit cache breakpoint. Defaults to
         * `implicit`. With `implicit`, OpenAI creates one implicit breakpoint and writes up to the
         * latest three explicit breakpoints in the request. With `explicit`, OpenAI does not create
         * an implicit breakpoint and writes up to the latest four explicit breakpoints. If there
         * are no explicit breakpoints, the request does not use prompt caching.
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

        /**
         * The minimum lifetime applied to every implicit and explicit cache breakpoint written by
         * the request. Defaults to `30m`, which is currently the only supported value. The backend
         * may retain cache entries for longer.
         */
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
         * Controls which reasoning items are rendered back to the model on later turns. If omitted
         * or set to `auto`, the model determines the context mode. The `gpt-5.6` model family
         * defaults to `all_turns`; earlier models default to `current_turn`.
         *
         * When returned on a response, this is the effective reasoning context mode used for the
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
             * Controls which reasoning items are rendered back to the model on later turns. If
             * omitted or set to `auto`, the model determines the context mode. The `gpt-5.6` model
             * family defaults to `all_turns`; earlier models default to `current_turn`.
             *
             * When returned on a response, this is the effective reasoning context mode used for
             * the response.
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
         * Controls which reasoning items are rendered back to the model on later turns. If omitted
         * or set to `auto`, the model determines the context mode. The `gpt-5.6` model family
         * defaults to `all_turns`; earlier models default to `current_turn`.
         *
         * When returned on a response, this is the effective reasoning context mode used for the
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

    /** Options for streaming responses. Only set this when you set `stream: true`. */
    class StreamOptions
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val includeObfuscation: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("include_obfuscation")
            @ExcludeMissing
            includeObfuscation: JsonField<Boolean> = JsonMissing.of()
        ) : this(includeObfuscation, mutableMapOf())

        /**
         * When true, stream obfuscation will be enabled. Stream obfuscation adds random characters
         * to an `obfuscation` field on streaming delta events to normalize payload sizes as a
         * mitigation to certain side-channel attacks. These obfuscation fields are included by
         * default, but add a small amount of overhead to the data stream. You can set
         * `include_obfuscation` to false to optimize for bandwidth if you trust the network links
         * between your application and the OpenAI API.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun includeObfuscation(): Optional<Boolean> =
            includeObfuscation.getOptional("include_obfuscation")

        /**
         * Returns the raw JSON value of [includeObfuscation].
         *
         * Unlike [includeObfuscation], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("include_obfuscation")
        @ExcludeMissing
        fun _includeObfuscation(): JsonField<Boolean> = includeObfuscation

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

            /** Returns a mutable builder for constructing an instance of [StreamOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StreamOptions]. */
        class Builder internal constructor() {

            private var includeObfuscation: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(streamOptions: StreamOptions) = apply {
                includeObfuscation = streamOptions.includeObfuscation
                additionalProperties = streamOptions.additionalProperties.toMutableMap()
            }

            /**
             * When true, stream obfuscation will be enabled. Stream obfuscation adds random
             * characters to an `obfuscation` field on streaming delta events to normalize payload
             * sizes as a mitigation to certain side-channel attacks. These obfuscation fields are
             * included by default, but add a small amount of overhead to the data stream. You can
             * set `include_obfuscation` to false to optimize for bandwidth if you trust the network
             * links between your application and the OpenAI API.
             */
            fun includeObfuscation(includeObfuscation: Boolean) =
                includeObfuscation(JsonField.of(includeObfuscation))

            /**
             * Sets [Builder.includeObfuscation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeObfuscation] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeObfuscation(includeObfuscation: JsonField<Boolean>) = apply {
                this.includeObfuscation = includeObfuscation
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
             * Returns an immutable instance of [StreamOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): StreamOptions =
                StreamOptions(includeObfuscation, additionalProperties.toMutableMap())
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
        fun validate(): StreamOptions = apply {
            if (validated) {
                return@apply
            }

            includeObfuscation()
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
        internal fun validity(): Int = (if (includeObfuscation.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StreamOptions &&
                includeObfuscation == other.includeObfuscation &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(includeObfuscation, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StreamOptions{includeObfuscation=$includeObfuscation, additionalProperties=$additionalProperties}"
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
     * The truncation strategy to use for the model response.
     * - `auto`: If the input to this Response exceeds the model's context window size, the model
     *   will truncate the response to fit the context window by dropping items from the beginning
     *   of the conversation.
     * - `disabled` (default): If the input size will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    @Deprecated("deprecated")
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

    class Beta @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val RESPONSES_MULTI_AGENT_V1 = of("responses_multi_agent=v1")

            @JvmStatic fun of(value: String) = Beta(JsonField.of(value))
        }

        /** An enum containing [Beta]'s known values. */
        enum class Known {
            RESPONSES_MULTI_AGENT_V1
        }

        /**
         * An enum containing [Beta]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Beta] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            RESPONSES_MULTI_AGENT_V1,
            /** An enum member indicating that [Beta] was instantiated with an unknown value. */
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
                RESPONSES_MULTI_AGENT_V1 -> Value.RESPONSES_MULTI_AGENT_V1
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
                RESPONSES_MULTI_AGENT_V1 -> Known.RESPONSES_MULTI_AGENT_V1
                else -> throw OpenAIInvalidDataException("Unknown Beta: $value")
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
        fun validate(): Beta = apply {
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

            return other is Beta && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseCreateParams &&
            betas == other.betas &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(betas, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ResponseCreateParams{betas=$betas, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
