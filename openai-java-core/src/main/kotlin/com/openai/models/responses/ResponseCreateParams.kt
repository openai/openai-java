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
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.responseFunctionToolFromClass
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ResponsesModel
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
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Whether to run the model response in the background.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<Boolean> = body.background()

    /**
     * Specify additional output data to include in the model response. Currently supported values
     * are:
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
    fun include(): Optional<List<ResponseIncludable>> = body.include()

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
    fun model(): Optional<ResponsesModel> = body.model()

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
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
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
    fun prompt(): Optional<ResponsePrompt> = body.prompt()

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
     * **o-series models only**
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
     * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user. We
     * recommend hashing their username or email address, in order to avoid sending us any
     * identifying information.
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
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or 'priority',
     *   then the request will be processed with the corresponding service tier.
     *   [Contact sales](https://openai.com/contact-sales) to learn more about Priority processing.
     * - When not set, the default behavior is 'auto'.
     *
     * When the `service_tier` parameter is set, the response body will include the `service_tier`
     * value based on the processing mode actually used to serve the request. This response value
     * may be different from the value set in the parameter.
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
    fun text(): Optional<ResponseTextConfig> = body.text()

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
     * The two categories of tools you can provide the model are:
     * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's capabilities,
     *   like [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more about
     *   [built-in tools](https://platform.openai.com/docs/guides/tools).
     * - **Function calls (custom tools)**: Functions that are defined by you, enabling the model to
     *   call your own code. Learn more about
     *   [function calling](https://platform.openai.com/docs/guides/function-calling).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = body.tools()

    /**
     * An integer between 0 and 20 specifying the number of most likely tokens to return at each
     * token position, each with an associated log probability.
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
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncation(): Optional<Truncation> = body.truncation()

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
     * Returns the raw JSON value of [include].
     *
     * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _include(): JsonField<List<ResponseIncludable>> = body._include()

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
    fun _model(): JsonField<ResponsesModel> = body._model()

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
    fun _prompt(): JsonField<ResponsePrompt> = body._prompt()

    /**
     * Returns the raw JSON value of [promptCacheKey].
     *
     * Unlike [promptCacheKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _promptCacheKey(): JsonField<String> = body._promptCacheKey()

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
    fun _text(): JsonField<ResponseTextConfig> = body._text()

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
    fun _tools(): JsonField<List<Tool>> = body._tools()

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
    fun _truncation(): JsonField<Truncation> = body._truncation()

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

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(responseCreateParams: ResponseCreateParams) = apply {
            body = responseCreateParams.body.toBuilder()
            additionalHeaders = responseCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = responseCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [background]
         * - [include]
         * - [input]
         * - [instructions]
         * - [maxOutputTokens]
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

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
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
        fun include(include: List<ResponseIncludable>?) = apply { body.include(include) }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

        /**
         * Sets [Builder.include] to an arbitrary JSON value.
         *
         * You should usually call [Builder.include] with a well-typed `List<ResponseIncludable>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun include(include: JsonField<List<ResponseIncludable>>) = apply { body.include(include) }

        /**
         * Adds a single [ResponseIncludable] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: ResponseIncludable) = apply { body.addInclude(include) }

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

        /** Alias for calling [input] with `Input.ofResponse(response)`. */
        fun inputOfResponse(response: List<ResponseInputItem>) = apply {
            body.inputOfResponse(response)
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
        fun model(model: ResponsesModel) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [ResponsesModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun model(model: JsonField<ResponsesModel>) = apply { body.model(model) }

        /** Alias for calling [model] with `ResponsesModel.ofString(string)`. */
        fun model(string: String) = apply { body.model(string) }

        /** Alias for calling [model] with `ResponsesModel.ofChat(chat)`. */
        fun model(chat: ChatModel) = apply { body.model(chat) }

        /** Alias for calling [model] with `ResponsesModel.ofOnly(only)`. */
        fun model(only: ResponsesModel.ResponsesOnlyModel) = apply { body.model(only) }

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
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
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
        fun prompt(prompt: ResponsePrompt?) = apply { body.prompt(prompt) }

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<ResponsePrompt>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [ResponsePrompt] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun prompt(prompt: JsonField<ResponsePrompt>) = apply { body.prompt(prompt) }

        /**
         * Used by OpenAI to cache responses for similar requests to optimize your cache hit rates.
         * Replaces the `user` field.
         * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
         */
        fun promptCacheKey(promptCacheKey: String) = apply { body.promptCacheKey(promptCacheKey) }

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
         * **o-series models only**
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
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user.
         * We recommend hashing their username or email address, in order to avoid sending us any
         * identifying information.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#safety-identifiers).
         */
        fun safetyIdentifier(safetyIdentifier: String) = apply {
            body.safetyIdentifier(safetyIdentifier)
        }

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
         *   'priority', then the request will be processed with the corresponding service tier.
         *   [Contact sales](https://openai.com/contact-sales) to learn more about Priority
         *   processing.
         * - When not set, the default behavior is 'auto'.
         *
         * When the `service_tier` parameter is set, the response body will include the
         * `service_tier` value based on the processing mode actually used to serve the request.
         * This response value may be different from the value set in the parameter.
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
        fun text(text: ResponseTextConfig) = apply { body.text(text) }

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [ResponseTextConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<ResponseTextConfig>) = apply { body.text(text) }

        /**
         * Sets the text configuration's format to a JSON schema derived from the structure of the
         * given class. This changes the builder to a type-safe
         * [StructuredResponseCreateParams.Builder] that will build a
         * [StructuredResponseCreateParams] instance when `build()` is called.
         *
         * @param responseType A class from which a JSON schema will be derived to define the text
         *   configuration's format.
         * @param localValidation [JsonSchemaLocalValidation.YES] (the default) to validate the JSON
         *   schema locally when it is generated by this method to confirm that it adheres to the
         *   requirements and restrictions on JSON schemas imposed by the OpenAI specification; or
         *   [JsonSchemaLocalValidation.NO] to skip local validation and rely only on remote
         *   validation. See the SDK documentation for more details.
         * @throws IllegalArgumentException If local validation is enabled, but it fails because a
         *   valid JSON schema cannot be derived from the given class.
         */
        @JvmOverloads
        fun <T : Any> text(
            responseType: Class<T>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = StructuredResponseCreateParams.builder<T>().wrap(responseType, this, localValidation)

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

        /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
        fun toolChoice(options: ToolChoiceOptions) = apply { body.toolChoice(options) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofTypes(types)`. */
        fun toolChoice(types: ToolChoiceTypes) = apply { body.toolChoice(types) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
        fun toolChoice(function: ToolChoiceFunction) = apply { body.toolChoice(function) }

        /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
        fun toolChoice(mcp: ToolChoiceMcp) = apply { body.toolChoice(mcp) }

        /**
         * An array of tools the model may call while generating a response. You can specify which
         * tool to use by setting the `tool_choice` parameter.
         *
         * The two categories of tools you can provide the model are:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun tools(tools: List<Tool>) = apply { body.tools(tools) }

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

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * Adds a single [FunctionTool] where the JSON schema describing the function parameters is
         * derived from the fields of a given class. Local validation of that JSON schema can be
         * performed to check if the schema is likely to pass remote validation by the AI model. By
         * default, local validation is enabled; disable it by setting [localValidation] to
         * [JsonSchemaLocalValidation.NO].
         *
         * @see addTool
         */
        @JvmOverloads
        fun addTool(
            functionParametersType: Class<*>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply {
            body.addTool(responseFunctionToolFromClass(functionParametersType, localValidation))
        }

        /** Alias for calling [addTool] with `Tool.ofFileSearch(fileSearch)`. */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FileSearchTool.builder()
         *     .vectorStoreIds(vectorStoreIds)
         *     .build()
         * ```
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            body.addFileSearchTool(vectorStoreIds)
        }

        /** Alias for calling [addTool] with `Tool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: WebSearchTool) = apply { body.addTool(webSearch) }

        /** Alias for calling [addTool] with `Tool.ofComputerUsePreview(computerUsePreview)`. */
        fun addTool(computerUsePreview: ComputerTool) = apply { body.addTool(computerUsePreview) }

        /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
        fun addTool(mcp: Tool.Mcp) = apply { body.addTool(mcp) }

        /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
        fun addTool(codeInterpreter: Tool.CodeInterpreter) = apply { body.addTool(codeInterpreter) }

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * Tool.CodeInterpreter.builder()
         *     .container(container)
         *     .build()
         * ```
         */
        fun addCodeInterpreterTool(container: Tool.CodeInterpreter.Container) = apply {
            body.addCodeInterpreterTool(container)
        }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofString(string)`.
         */
        fun addCodeInterpreterTool(string: String) = apply { body.addCodeInterpreterTool(string) }

        /**
         * Alias for calling [addCodeInterpreterTool] with
         * `Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
         */
        fun addCodeInterpreterTool(
            codeInterpreterToolAuto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
        ) = apply { body.addCodeInterpreterTool(codeInterpreterToolAuto) }

        /** Alias for calling [addTool] with `Tool.ofImageGeneration(imageGeneration)`. */
        fun addTool(imageGeneration: Tool.ImageGeneration) = apply { body.addTool(imageGeneration) }

        /** Alias for calling [addTool] with `Tool.ofLocalShell()`. */
        fun addToolLocalShell() = apply { body.addToolLocalShell() }

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability.
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
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: Truncation?) = apply { body.truncation(truncation) }

        /** Alias for calling [Builder.truncation] with `truncation.orElse(null)`. */
        fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [Truncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
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
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val background: JsonField<Boolean>,
        private val include: JsonField<List<ResponseIncludable>>,
        private val input: JsonField<Input>,
        private val instructions: JsonField<String>,
        private val maxOutputTokens: JsonField<Long>,
        private val maxToolCalls: JsonField<Long>,
        private val metadata: JsonField<Metadata>,
        private val model: JsonField<ResponsesModel>,
        private val parallelToolCalls: JsonField<Boolean>,
        private val previousResponseId: JsonField<String>,
        private val prompt: JsonField<ResponsePrompt>,
        private val promptCacheKey: JsonField<String>,
        private val reasoning: JsonField<Reasoning>,
        private val safetyIdentifier: JsonField<String>,
        private val serviceTier: JsonField<ServiceTier>,
        private val store: JsonField<Boolean>,
        private val temperature: JsonField<Double>,
        private val text: JsonField<ResponseTextConfig>,
        private val toolChoice: JsonField<ToolChoice>,
        private val tools: JsonField<List<Tool>>,
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
            @JsonProperty("include")
            @ExcludeMissing
            include: JsonField<List<ResponseIncludable>> = JsonMissing.of(),
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
            @JsonProperty("model")
            @ExcludeMissing
            model: JsonField<ResponsesModel> = JsonMissing.of(),
            @JsonProperty("parallel_tool_calls")
            @ExcludeMissing
            parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
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
            @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("text")
            @ExcludeMissing
            text: JsonField<ResponseTextConfig> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
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
            include,
            input,
            instructions,
            maxOutputTokens,
            maxToolCalls,
            metadata,
            model,
            parallelToolCalls,
            previousResponseId,
            prompt,
            promptCacheKey,
            reasoning,
            safetyIdentifier,
            serviceTier,
            store,
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
         * Specify additional output data to include in the model response. Currently supported
         * values are:
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
        fun include(): Optional<List<ResponseIncludable>> = include.getOptional("include")

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
        fun model(): Optional<ResponsesModel> = model.getOptional("model")

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
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
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
         * **o-series models only**
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
         * OpenAI's usage policies. The IDs should be a string that uniquely identifies each user.
         * We recommend hashing their username or email address, in order to avoid sending us any
         * identifying information.
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
         *   'priority', then the request will be processed with the corresponding service tier.
         *   [Contact sales](https://openai.com/contact-sales) to learn more about Priority
         *   processing.
         * - When not set, the default behavior is 'auto'.
         *
         * When the `service_tier` parameter is set, the response body will include the
         * `service_tier` value based on the processing mode actually used to serve the request.
         * This response value may be different from the value set in the parameter.
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
        fun text(): Optional<ResponseTextConfig> = text.getOptional("text")

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
         * The two categories of tools you can provide the model are:
         * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
         *   capabilities, like
         *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
         *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn more
         *   about [built-in tools](https://platform.openai.com/docs/guides/tools).
         * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
         *   model to call your own code. Learn more about
         *   [function calling](https://platform.openai.com/docs/guides/function-calling).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<Tool>> = tools.getOptional("tools")

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability.
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
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
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
         * Returns the raw JSON value of [include].
         *
         * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("include")
        @ExcludeMissing
        fun _include(): JsonField<List<ResponseIncludable>> = include

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
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ResponsesModel> = model

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
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<ResponsePrompt> = prompt

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
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<ResponseTextConfig> = text

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
            private var include: JsonField<MutableList<ResponseIncludable>>? = null
            private var input: JsonField<Input> = JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
            private var maxToolCalls: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var model: JsonField<ResponsesModel> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
            private var promptCacheKey: JsonField<String> = JsonMissing.of()
            private var reasoning: JsonField<Reasoning> = JsonMissing.of()
            private var safetyIdentifier: JsonField<String> = JsonMissing.of()
            private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
            private var store: JsonField<Boolean> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var text: JsonField<ResponseTextConfig> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var topLogprobs: JsonField<Long> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var truncation: JsonField<Truncation> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                background = body.background
                include = body.include.map { it.toMutableList() }
                input = body.input
                instructions = body.instructions
                maxOutputTokens = body.maxOutputTokens
                maxToolCalls = body.maxToolCalls
                metadata = body.metadata
                model = body.model
                parallelToolCalls = body.parallelToolCalls
                previousResponseId = body.previousResponseId
                prompt = body.prompt
                promptCacheKey = body.promptCacheKey
                reasoning = body.reasoning
                safetyIdentifier = body.safetyIdentifier
                serviceTier = body.serviceTier
                store = body.store
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

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
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
            fun include(include: List<ResponseIncludable>?) = include(JsonField.ofNullable(include))

            /** Alias for calling [Builder.include] with `include.orElse(null)`. */
            fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

            /**
             * Sets [Builder.include] to an arbitrary JSON value.
             *
             * You should usually call [Builder.include] with a well-typed
             * `List<ResponseIncludable>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun include(include: JsonField<List<ResponseIncludable>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Adds a single [ResponseIncludable] to [Builder.include].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInclude(include: ResponseIncludable) = apply {
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

            /** Alias for calling [input] with `Input.ofResponse(response)`. */
            fun inputOfResponse(response: List<ResponseInputItem>) =
                input(Input.ofResponse(response))

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
            fun model(model: ResponsesModel) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [ResponsesModel] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<ResponsesModel>) = apply { this.model = model }

            /** Alias for calling [model] with `ResponsesModel.ofString(string)`. */
            fun model(string: String) = model(ResponsesModel.ofString(string))

            /** Alias for calling [model] with `ResponsesModel.ofChat(chat)`. */
            fun model(chat: ChatModel) = model(ResponsesModel.ofChat(chat))

            /** Alias for calling [model] with `ResponsesModel.ofOnly(only)`. */
            fun model(only: ResponsesModel.ResponsesOnlyModel) = model(ResponsesModel.ofOnly(only))

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
             * Used by OpenAI to cache responses for similar requests to optimize your cache hit
             * rates. Replaces the `user` field.
             * [Learn more](https://platform.openai.com/docs/guides/prompt-caching).
             */
            fun promptCacheKey(promptCacheKey: String) =
                promptCacheKey(JsonField.of(promptCacheKey))

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
             * **o-series models only**
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
             * identifies each user. We recommend hashing their username or email address, in order
             * to avoid sending us any identifying information.
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
             * - If set to 'auto', then the request will be processed with the service tier
             *   configured in the Project settings. Unless otherwise configured, the Project will
             *   use 'default'.
             * - If set to 'default', then the request will be processed with the standard pricing
             *   and performance for the selected model.
             * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or
             *   'priority', then the request will be processed with the corresponding service tier.
             *   [Contact sales](https://openai.com/contact-sales) to learn more about Priority
             *   processing.
             * - When not set, the default behavior is 'auto'.
             *
             * When the `service_tier` parameter is set, the response body will include the
             * `service_tier` value based on the processing mode actually used to serve the request.
             * This response value may be different from the value set in the parameter.
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

            /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
            fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

            /** Alias for calling [toolChoice] with `ToolChoice.ofTypes(types)`. */
            fun toolChoice(types: ToolChoiceTypes) = toolChoice(ToolChoice.ofTypes(types))

            /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
            fun toolChoice(function: ToolChoiceFunction) =
                toolChoice(ToolChoice.ofFunction(function))

            /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
            fun toolChoice(mcp: ToolChoiceMcp) = toolChoice(ToolChoice.ofMcp(mcp))

            /**
             * An array of tools the model may call while generating a response. You can specify
             * which tool to use by setting the `tool_choice` parameter.
             *
             * The two categories of tools you can provide the model are:
             * - **Built-in tools**: Tools that are provided by OpenAI that extend the model's
             *   capabilities, like
             *   [web search](https://platform.openai.com/docs/guides/tools-web-search) or
             *   [file search](https://platform.openai.com/docs/guides/tools-file-search). Learn
             *   more about [built-in tools](https://platform.openai.com/docs/guides/tools).
             * - **Function calls (custom tools)**: Functions that are defined by you, enabling the
             *   model to call your own code. Learn more about
             *   [function calling](https://platform.openai.com/docs/guides/function-calling).
             */
            fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

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

            /** Alias for calling [addTool] with `Tool.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: WebSearchTool) = addTool(Tool.ofWebSearch(webSearch))

            /** Alias for calling [addTool] with `Tool.ofComputerUsePreview(computerUsePreview)`. */
            fun addTool(computerUsePreview: ComputerTool) =
                addTool(Tool.ofComputerUsePreview(computerUsePreview))

            /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
            fun addTool(mcp: Tool.Mcp) = addTool(Tool.ofMcp(mcp))

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
                    Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(
                        codeInterpreterToolAuto
                    )
                )

            /** Alias for calling [addTool] with `Tool.ofImageGeneration(imageGeneration)`. */
            fun addTool(imageGeneration: Tool.ImageGeneration) =
                addTool(Tool.ofImageGeneration(imageGeneration))

            /** Alias for calling [addTool] with `Tool.ofLocalShell()`. */
            fun addToolLocalShell() = addTool(Tool.ofLocalShell())

            /**
             * An integer between 0 and 20 specifying the number of most likely tokens to return at
             * each token position, each with an associated log probability.
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
             * - `auto`: If the context of this response and previous ones exceeds the model's
             *   context window size, the model will truncate the response to fit the context window
             *   by dropping input items in the middle of the conversation.
             * - `disabled` (default): If a model response will exceed the context window size for a
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
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    input,
                    instructions,
                    maxOutputTokens,
                    maxToolCalls,
                    metadata,
                    model,
                    parallelToolCalls,
                    previousResponseId,
                    prompt,
                    promptCacheKey,
                    reasoning,
                    safetyIdentifier,
                    serviceTier,
                    store,
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

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            background()
            include().ifPresent { it.forEach { it.validate() } }
            input().ifPresent { it.validate() }
            instructions()
            maxOutputTokens()
            maxToolCalls()
            metadata().ifPresent { it.validate() }
            model().ifPresent { it.validate() }
            parallelToolCalls()
            previousResponseId()
            prompt().ifPresent { it.validate() }
            promptCacheKey()
            reasoning().ifPresent { it.validate() }
            safetyIdentifier()
            serviceTier().ifPresent { it.validate() }
            store()
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
                (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (input.asKnown().getOrNull()?.validity() ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
                (if (maxToolCalls.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (model.asKnown().getOrNull()?.validity() ?: 0) +
                (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
                (if (previousResponseId.asKnown().isPresent) 1 else 0) +
                (prompt.asKnown().getOrNull()?.validity() ?: 0) +
                (if (promptCacheKey.asKnown().isPresent) 1 else 0) +
                (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                (if (safetyIdentifier.asKnown().isPresent) 1 else 0) +
                (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
                (if (store.asKnown().isPresent) 1 else 0) +
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

            return /* spotless:off */ other is Body && background == other.background && include == other.include && input == other.input && instructions == other.instructions && maxOutputTokens == other.maxOutputTokens && maxToolCalls == other.maxToolCalls && metadata == other.metadata && model == other.model && parallelToolCalls == other.parallelToolCalls && previousResponseId == other.previousResponseId && prompt == other.prompt && promptCacheKey == other.promptCacheKey && reasoning == other.reasoning && safetyIdentifier == other.safetyIdentifier && serviceTier == other.serviceTier && store == other.store && temperature == other.temperature && text == other.text && toolChoice == other.toolChoice && tools == other.tools && topLogprobs == other.topLogprobs && topP == other.topP && truncation == other.truncation && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(background, include, input, instructions, maxOutputTokens, maxToolCalls, metadata, model, parallelToolCalls, previousResponseId, prompt, promptCacheKey, reasoning, safetyIdentifier, serviceTier, store, temperature, text, toolChoice, tools, topLogprobs, topP, truncation, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{background=$background, include=$include, input=$input, instructions=$instructions, maxOutputTokens=$maxOutputTokens, maxToolCalls=$maxToolCalls, metadata=$metadata, model=$model, parallelToolCalls=$parallelToolCalls, previousResponseId=$previousResponseId, prompt=$prompt, promptCacheKey=$promptCacheKey, reasoning=$reasoning, safetyIdentifier=$safetyIdentifier, serviceTier=$serviceTier, store=$store, temperature=$temperature, text=$text, toolChoice=$toolChoice, tools=$tools, topLogprobs=$topLogprobs, topP=$topP, truncation=$truncation, user=$user, additionalProperties=$additionalProperties}"
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
        private val response: List<ResponseInputItem>? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun text(): Optional<String> = Optional.ofNullable(text)

        /** A list of one or many input items to the model, containing different content types. */
        fun response(): Optional<List<ResponseInputItem>> = Optional.ofNullable(response)

        fun isText(): Boolean = text != null

        fun isResponse(): Boolean = response != null

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun asText(): String = text.getOrThrow("text")

        /** A list of one or many input items to the model, containing different content types. */
        fun asResponse(): List<ResponseInputItem> = response.getOrThrow("response")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                text != null -> visitor.visitText(text)
                response != null -> visitor.visitResponse(response)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitText(text: String) {}

                    override fun visitResponse(response: List<ResponseInputItem>) {
                        response.forEach { it.validate() }
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

                    override fun visitResponse(response: List<ResponseInputItem>) =
                        response.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Input && text == other.text && response == other.response /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, response) /* spotless:on */

        override fun toString(): String =
            when {
                text != null -> "Input{text=$text}"
                response != null -> "Input{response=$response}"
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
            fun ofResponse(response: List<ResponseInputItem>) =
                Input(response = response.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** A text input to the model, equivalent to a text input with the `user` role. */
            fun visitText(text: String): T

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun visitResponse(response: List<ResponseInputItem>): T

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
                            tryDeserialize(node, jacksonTypeRef<List<ResponseInputItem>>())?.let {
                                Input(response = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
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
                    value.response != null -> generator.writeObject(value.response)
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

    /**
     * Specifies the processing type used for serving the request.
     * - If set to 'auto', then the request will be processed with the service tier configured in
     *   the Project settings. Unless otherwise configured, the Project will use 'default'.
     * - If set to 'default', then the request will be processed with the standard pricing and
     *   performance for the selected model.
     * - If set to '[flex](https://platform.openai.com/docs/guides/flex-processing)' or 'priority',
     *   then the request will be processed with the corresponding service tier.
     *   [Contact sales](https://openai.com/contact-sales) to learn more about Priority processing.
     * - When not set, the default behavior is 'auto'.
     *
     * When the `service_tier` parameter is set, the response body will include the `service_tier`
     * value based on the processing mode actually used to serve the request. This response value
     * may be different from the value set in the parameter.
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

            return /* spotless:off */ other is ServiceTier && value == other.value /* spotless:on */
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
        private val options: ToolChoiceOptions? = null,
        private val types: ToolChoiceTypes? = null,
        private val function: ToolChoiceFunction? = null,
        private val mcp: ToolChoiceMcp? = null,
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

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun types(): Optional<ToolChoiceTypes> = Optional.ofNullable(types)

        /** Use this option to force the model to call a specific function. */
        fun function(): Optional<ToolChoiceFunction> = Optional.ofNullable(function)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun mcp(): Optional<ToolChoiceMcp> = Optional.ofNullable(mcp)

        fun isOptions(): Boolean = options != null

        fun isTypes(): Boolean = types != null

        fun isFunction(): Boolean = function != null

        fun isMcp(): Boolean = mcp != null

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

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun asTypes(): ToolChoiceTypes = types.getOrThrow("types")

        /** Use this option to force the model to call a specific function. */
        fun asFunction(): ToolChoiceFunction = function.getOrThrow("function")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asMcp(): ToolChoiceMcp = mcp.getOrThrow("mcp")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                options != null -> visitor.visitOptions(options)
                types != null -> visitor.visitTypes(types)
                function != null -> visitor.visitFunction(function)
                mcp != null -> visitor.visitMcp(mcp)
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

                    override fun visitTypes(types: ToolChoiceTypes) {
                        types.validate()
                    }

                    override fun visitFunction(function: ToolChoiceFunction) {
                        function.validate()
                    }

                    override fun visitMcp(mcp: ToolChoiceMcp) {
                        mcp.validate()
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

                    override fun visitTypes(types: ToolChoiceTypes) = types.validity()

                    override fun visitFunction(function: ToolChoiceFunction) = function.validity()

                    override fun visitMcp(mcp: ToolChoiceMcp) = mcp.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolChoice && options == other.options && types == other.types && function == other.function && mcp == other.mcp /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(options, types, function, mcp) /* spotless:on */

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
                types != null -> "ToolChoice{types=$types}"
                function != null -> "ToolChoice{function=$function}"
                mcp != null -> "ToolChoice{mcp=$mcp}"
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
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceTypes>())?.let {
                                ToolChoice(types = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>())?.let {
                                ToolChoice(function = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ToolChoiceMcp>())?.let {
                                ToolChoice(mcp = it, _json = json)
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
                    value.types != null -> generator.writeObject(value.types)
                    value.function != null -> generator.writeObject(value.function)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
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

            return /* spotless:off */ other is Truncation && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ResponseCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
