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
import com.openai.models.Reasoning
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
     * Text, image, or file inputs to the model, used to generate a response.
     *
     * Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Image inputs](https://platform.openai.com/docs/guides/images)
     * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
     * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
     * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
     */
    fun input(): Input = body.input()

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     */
    fun model(): ChatModel = body.model()

    /**
     * Specify additional output data to include in the model response. Currently supported values
     * are:
     * - `file_search_call.results`: Include the search results of the file search tool call.
     * - `message.input_image.image_url`: Include image urls from the input message.
     * - `computer_call_output.output.image_url`: Include image urls from the computer call output.
     */
    fun include(): Optional<List<ResponseIncludable>> = body.include()

    /**
     * Inserts a system (or developer) message as the first item in the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * be not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     */
    fun instructions(): Optional<String> = body.instructions()

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     */
    fun maxOutputTokens(): Optional<Long> = body.maxOutputTokens()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /** Whether to allow the model to run tool calls in parallel. */
    fun parallelToolCalls(): Optional<Boolean> = body.parallelToolCalls()

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun previousResponseId(): Optional<String> = body.previousResponseId()

    /**
     * **o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    fun reasoning(): Optional<Reasoning> = body.reasoning()

    /** Whether to store the generated model response for later retrieval via API. */
    fun store(): Optional<Boolean> = body.store()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     */
    fun text(): Optional<ResponseTextConfig> = body.text()

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
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
     */
    fun tools(): Optional<List<Tool>> = body.tools()

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or `temperature` but not both.
     */
    fun topP(): Optional<Double> = body.topP()

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    fun truncation(): Optional<Truncation> = body.truncation()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun user(): Optional<String> = body.user()

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
    fun _input(): JsonField<Input> = body._input()

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     */
    fun _model(): JsonField<ChatModel> = body._model()

    /**
     * Specify additional output data to include in the model response. Currently supported values
     * are:
     * - `file_search_call.results`: Include the search results of the file search tool call.
     * - `message.input_image.image_url`: Include image urls from the input message.
     * - `computer_call_output.output.image_url`: Include image urls from the computer call output.
     */
    fun _include(): JsonField<List<ResponseIncludable>> = body._include()

    /**
     * Inserts a system (or developer) message as the first item in the model's context.
     *
     * When using along with `previous_response_id`, the instructions from a previous response will
     * be not be carried over to the next response. This makes it simple to swap out system (or
     * developer) messages in new responses.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * An upper bound for the number of tokens that can be generated for a response, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     */
    fun _maxOutputTokens(): JsonField<Long> = body._maxOutputTokens()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /** Whether to allow the model to run tool calls in parallel. */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

    /**
     * The unique ID of the previous response to the model. Use this to create multi-turn
     * conversations. Learn more about
     * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun _previousResponseId(): JsonField<String> = body._previousResponseId()

    /**
     * **o-series models only**
     *
     * Configuration options for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
     */
    fun _reasoning(): JsonField<Reasoning> = body._reasoning()

    /** Whether to store the generated model response for later retrieval via API. */
    fun _store(): JsonField<Boolean> = body._store()

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
     * output more random, while lower values like 0.2 will make it more focused and deterministic.
     * We generally recommend altering this or `top_p` but not both.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Configuration options for a text response from the model. Can be plain text or structured
     * JSON data. Learn more:
     * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
     * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
     */
    fun _text(): JsonField<ResponseTextConfig> = body._text()

    /**
     * How the model should select which tool (or tools) to use when generating a response. See the
     * `tools` parameter to see how to specify which tools the model can call.
     */
    fun _toolChoice(): JsonField<ToolChoice> = body._toolChoice()

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
     */
    fun _tools(): JsonField<List<Tool>> = body._tools()

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens
     * comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or `temperature` but not both.
     */
    fun _topP(): JsonField<Double> = body._topP()

    /**
     * The truncation strategy to use for the model response.
     * - `auto`: If the context of this response and previous ones exceeds the model's context
     *   window size, the model will truncate the response to fit the context window by dropping
     *   input items in the middle of the conversation.
     * - `disabled` (default): If a model response will exceed the context window size for a model,
     *   the request will fail with a 400 error.
     */
    fun _truncation(): JsonField<Truncation> = body._truncation()

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     */
    fun _user(): JsonField<String> = body._user()

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
        @JsonProperty("input")
        @ExcludeMissing
        private val input: JsonField<Input> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ChatModel> = JsonMissing.of(),
        @JsonProperty("include")
        @ExcludeMissing
        private val include: JsonField<List<ResponseIncludable>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        private val instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        private val maxOutputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        private val parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        private val previousResponseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        private val reasoning: JsonField<Reasoning> = JsonMissing.of(),
        @JsonProperty("store")
        @ExcludeMissing
        private val store: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        private val temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("text")
        @ExcludeMissing
        private val text: JsonField<ResponseTextConfig> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        private val toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        private val tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("top_p")
        @ExcludeMissing
        private val topP: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("truncation")
        @ExcludeMissing
        private val truncation: JsonField<Truncation> = JsonMissing.of(),
        @JsonProperty("user")
        @ExcludeMissing
        private val user: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

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
        fun input(): Input = input.getRequired("input")

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(): ChatModel = model.getRequired("model")

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        fun include(): Optional<List<ResponseIncludable>> =
            Optional.ofNullable(include.getNullable("include"))

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(): Optional<String> =
            Optional.ofNullable(instructions.getNullable("instructions"))

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(): Optional<Long> =
            Optional.ofNullable(maxOutputTokens.getNullable("max_output_tokens"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(): Optional<Boolean> =
            Optional.ofNullable(parallelToolCalls.getNullable("parallel_tool_calls"))

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(): Optional<String> =
            Optional.ofNullable(previousResponseId.getNullable("previous_response_id"))

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(): Optional<Reasoning> =
            Optional.ofNullable(reasoning.getNullable("reasoning"))

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(): Optional<Boolean> = Optional.ofNullable(store.getNullable("store"))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.getNullable("temperature"))

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(): Optional<ResponseTextConfig> = Optional.ofNullable(text.getNullable("text"))

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(): Optional<ToolChoice> =
            Optional.ofNullable(toolChoice.getNullable("tool_choice"))

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
        fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(): Optional<Truncation> =
            Optional.ofNullable(truncation.getNullable("truncation"))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

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
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        @JsonProperty("include")
        @ExcludeMissing
        fun _include(): JsonField<List<ResponseIncludable>> = include

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /** Whether to allow the model to run tool calls in parallel. */
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        @JsonProperty("previous_response_id")
        @ExcludeMissing
        fun _previousResponseId(): JsonField<String> = previousResponseId

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        @JsonProperty("reasoning")
        @ExcludeMissing
        fun _reasoning(): JsonField<Reasoning> = reasoning

        /** Whether to store the generated model response for later retrieval via API. */
        @JsonProperty("store") @ExcludeMissing fun _store(): JsonField<Boolean> = store

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<ResponseTextConfig> = text

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        @JsonProperty("tool_choice")
        @ExcludeMissing
        fun _toolChoice(): JsonField<ToolChoice> = toolChoice

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
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        @JsonProperty("truncation")
        @ExcludeMissing
        fun _truncation(): JsonField<Truncation> = truncation

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            model()
            include()
            instructions()
            maxOutputTokens()
            metadata().ifPresent { it.validate() }
            parallelToolCalls()
            previousResponseId()
            reasoning().ifPresent { it.validate() }
            store()
            temperature()
            text().ifPresent { it.validate() }
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topP()
            truncation()
            user()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .input()
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var model: JsonField<ChatModel>? = null
            private var include: JsonField<MutableList<ResponseIncludable>>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var previousResponseId: JsonField<String> = JsonMissing.of()
            private var reasoning: JsonField<Reasoning> = JsonMissing.of()
            private var store: JsonField<Boolean> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var text: JsonField<ResponseTextConfig> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var topP: JsonField<Double> = JsonMissing.of()
            private var truncation: JsonField<Truncation> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                input = body.input
                model = body.model
                include = body.include.map { it.toMutableList() }
                instructions = body.instructions
                maxOutputTokens = body.maxOutputTokens
                metadata = body.metadata
                parallelToolCalls = body.parallelToolCalls
                previousResponseId = body.previousResponseId
                reasoning = body.reasoning
                store = body.store
                temperature = body.temperature
                text = body.text
                toolChoice = body.toolChoice
                tools = body.tools.map { it.toMutableList() }
                topP = body.topP
                truncation = body.truncation
                user = body.user
                additionalProperties = body.additionalProperties.toMutableMap()
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
             * Text, image, or file inputs to the model, used to generate a response.
             *
             * Learn more:
             * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
             * - [Image inputs](https://platform.openai.com/docs/guides/images)
             * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
             * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
             * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** A text input to the model, equivalent to a text input with the `user` role. */
            fun input(text: String) = input(Input.ofText(text))

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun inputOfResponse(response: List<ResponseInputItem>) =
                input(Input.ofResponse(response))

            /**
             * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(model: ChatModel) = model(JsonField.of(model))

            /**
             * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(model: JsonField<ChatModel>) = apply { this.model = model }

            /**
             * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(value: String) = model(ChatModel.of(value))

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
             * - `file_search_call.results`: Include the search results of the file search tool
             *   call.
             * - `message.input_image.image_url`: Include image urls from the input message.
             * - `computer_call_output.output.image_url`: Include image urls from the computer call
             *   output.
             */
            fun include(include: List<ResponseIncludable>?) = include(JsonField.ofNullable(include))

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
             * - `file_search_call.results`: Include the search results of the file search tool
             *   call.
             * - `message.input_image.image_url`: Include image urls from the input message.
             * - `computer_call_output.output.image_url`: Include image urls from the computer call
             *   output.
             */
            fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
             * - `file_search_call.results`: Include the search results of the file search tool
             *   call.
             * - `message.input_image.image_url`: Include image urls from the input message.
             * - `computer_call_output.output.image_url`: Include image urls from the computer call
             *   output.
             */
            fun include(include: JsonField<List<ResponseIncludable>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Specify additional output data to include in the model response. Currently supported
             * values are:
             * - `file_search_call.results`: Include the search results of the file search tool
             *   call.
             * - `message.input_image.image_url`: Include image urls from the input message.
             * - `computer_call_output.output.image_url`: Include image urls from the computer call
             *   output.
             */
            fun addInclude(include: ResponseIncludable) = apply {
                this.include =
                    (this.include ?: JsonField.of(mutableListOf())).also {
                        checkKnown("include", it).add(include)
                    }
            }

            /**
             * Inserts a system (or developer) message as the first item in the model's context.
             *
             * When using along with `previous_response_id`, the instructions from a previous
             * response will be not be carried over to the next response. This makes it simple to
             * swap out system (or developer) messages in new responses.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /**
             * Inserts a system (or developer) message as the first item in the model's context.
             *
             * When using along with `previous_response_id`, the instructions from a previous
             * response will be not be carried over to the next response. This makes it simple to
             * swap out system (or developer) messages in new responses.
             */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.getOrNull())

            /**
             * Inserts a system (or developer) message as the first item in the model's context.
             *
             * When using along with `previous_response_id`, the instructions from a previous
             * response will be not be carried over to the next response. This makes it simple to
             * swap out system (or developer) messages in new responses.
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
             * An upper bound for the number of tokens that can be generated for a response,
             * including visible output tokens and
             * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
             */
            fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

            /**
             * An upper bound for the number of tokens that can be generated for a response,
             * including visible output tokens and
             * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
             */
            fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
                maxOutputTokens(maxOutputTokens.getOrNull())

            /**
             * An upper bound for the number of tokens that can be generated for a response,
             * including visible output tokens and
             * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
             */
            fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
                this.maxOutputTokens = maxOutputTokens
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

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /** Whether to allow the model to run tool calls in parallel. */
            fun parallelToolCalls(parallelToolCalls: Boolean?) =
                parallelToolCalls(JsonField.ofNullable(parallelToolCalls))

            /** Whether to allow the model to run tool calls in parallel. */
            fun parallelToolCalls(parallelToolCalls: Boolean) =
                parallelToolCalls(parallelToolCalls as Boolean?)

            /** Whether to allow the model to run tool calls in parallel. */
            fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
                parallelToolCalls(parallelToolCalls.getOrNull())

            /** Whether to allow the model to run tool calls in parallel. */
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
             * The unique ID of the previous response to the model. Use this to create multi-turn
             * conversations. Learn more about
             * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
             */
            fun previousResponseId(previousResponseId: Optional<String>) =
                previousResponseId(previousResponseId.getOrNull())

            /**
             * The unique ID of the previous response to the model. Use this to create multi-turn
             * conversations. Learn more about
             * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
             */
            fun previousResponseId(previousResponseId: JsonField<String>) = apply {
                this.previousResponseId = previousResponseId
            }

            /**
             * **o-series models only**
             *
             * Configuration options for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
             */
            fun reasoning(reasoning: Reasoning?) = reasoning(JsonField.ofNullable(reasoning))

            /**
             * **o-series models only**
             *
             * Configuration options for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
             */
            fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

            /**
             * **o-series models only**
             *
             * Configuration options for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
             */
            fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

            /** Whether to store the generated model response for later retrieval via API. */
            fun store(store: Boolean?) = store(JsonField.ofNullable(store))

            /** Whether to store the generated model response for later retrieval via API. */
            fun store(store: Boolean) = store(store as Boolean?)

            /** Whether to store the generated model response for later retrieval via API. */
            fun store(store: Optional<Boolean>) = store(store.getOrNull())

            /** Whether to store the generated model response for later retrieval via API. */
            fun store(store: JsonField<Boolean>) = apply { this.store = store }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic. We generally recommend altering this or `top_p` but not both.
             */
            fun temperature(temperature: Double?) = temperature(JsonField.ofNullable(temperature))

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic. We generally recommend altering this or `top_p` but not both.
             */
            fun temperature(temperature: Double) = temperature(temperature as Double?)

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic. We generally recommend altering this or `top_p` but not both.
             */
            fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic. We generally recommend altering this or `top_p` but not both.
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
             * Configuration options for a text response from the model. Can be plain text or
             * structured JSON data. Learn more:
             * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
             * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
             */
            fun text(text: JsonField<ResponseTextConfig>) = apply { this.text = text }

            /**
             * How the model should select which tool (or tools) to use when generating a response.
             * See the `tools` parameter to see how to specify which tools the model can call.
             */
            fun toolChoice(toolChoice: ToolChoice) = toolChoice(JsonField.of(toolChoice))

            /**
             * How the model should select which tool (or tools) to use when generating a response.
             * See the `tools` parameter to see how to specify which tools the model can call.
             */
            fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply {
                this.toolChoice = toolChoice
            }

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
            fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

            /**
             * Indicates that the model should use a built-in tool to generate a response.
             * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
             */
            fun toolChoice(types: ToolChoiceTypes) = toolChoice(ToolChoice.ofTypes(types))

            /** Use this option to force the model to call a specific function. */
            fun toolChoice(function: ToolChoiceFunction) =
                toolChoice(ToolChoice.ofFunction(function))

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
            fun tools(tools: JsonField<List<Tool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

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
            fun addTool(tool: Tool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /**
             * A tool that searches for relevant content from uploaded files. Learn more about the
             * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
             */
            fun addTool(fileSearch: FileSearchTool) = addTool(Tool.ofFileSearch(fileSearch))

            /**
             * A tool that searches for relevant content from uploaded files. Learn more about the
             * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
             */
            fun addFileSearchTool(vectorStoreIds: List<String>) =
                addTool(FileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

            /**
             * Defines a function in your own code the model can choose to call. Learn more about
             * [function calling](https://platform.openai.com/docs/guides/function-calling).
             */
            fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

            /**
             * A tool that controls a virtual computer. Learn more about the
             * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
             */
            fun addTool(computerUsePreview: ComputerTool) =
                addTool(Tool.ofComputerUsePreview(computerUsePreview))

            /**
             * This tool searches the web for relevant results to use in a response. Learn more
             * about the
             * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
             */
            fun addTool(webSearch: WebSearchTool) = addTool(Tool.ofWebSearch(webSearch))

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            fun topP(topP: Double?) = topP(JsonField.ofNullable(topP))

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            fun topP(topP: Double) = topP(topP as Double?)

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
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

            /**
             * The truncation strategy to use for the model response.
             * - `auto`: If the context of this response and previous ones exceeds the model's
             *   context window size, the model will truncate the response to fit the context window
             *   by dropping input items in the middle of the conversation.
             * - `disabled` (default): If a model response will exceed the context window size for a
             *   model, the request will fail with a 400 error.
             */
            fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

            /**
             * The truncation strategy to use for the model response.
             * - `auto`: If the context of this response and previous ones exceeds the model's
             *   context window size, the model will truncate the response to fit the context window
             *   by dropping input items in the middle of the conversation.
             * - `disabled` (default): If a model response will exceed the context window size for a
             *   model, the request will fail with a 400 error.
             */
            fun truncation(truncation: JsonField<Truncation>) = apply {
                this.truncation = truncation
            }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: JsonField<String>) = apply { this.user = user }

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

            fun build(): Body =
                Body(
                    checkRequired("input", input),
                    checkRequired("model", model),
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    instructions,
                    maxOutputTokens,
                    metadata,
                    parallelToolCalls,
                    previousResponseId,
                    reasoning,
                    store,
                    temperature,
                    text,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topP,
                    truncation,
                    user,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && input == other.input && model == other.model && include == other.include && instructions == other.instructions && maxOutputTokens == other.maxOutputTokens && metadata == other.metadata && parallelToolCalls == other.parallelToolCalls && previousResponseId == other.previousResponseId && reasoning == other.reasoning && store == other.store && temperature == other.temperature && text == other.text && toolChoice == other.toolChoice && tools == other.tools && topP == other.topP && truncation == other.truncation && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, model, include, instructions, maxOutputTokens, metadata, parallelToolCalls, previousResponseId, reasoning, store, temperature, text, toolChoice, tools, topP, truncation, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{input=$input, model=$model, include=$include, instructions=$instructions, maxOutputTokens=$maxOutputTokens, metadata=$metadata, parallelToolCalls=$parallelToolCalls, previousResponseId=$previousResponseId, reasoning=$reasoning, store=$store, temperature=$temperature, text=$text, toolChoice=$toolChoice, tools=$tools, topP=$topP, truncation=$truncation, user=$user, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseCreateParams].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCreateParams]. */
    @NoAutoDetect
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
         * Text, image, or file inputs to the model, used to generate a response.
         *
         * Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Image inputs](https://platform.openai.com/docs/guides/images)
         * - [File inputs](https://platform.openai.com/docs/guides/pdf-files)
         * - [Conversation state](https://platform.openai.com/docs/guides/conversation-state)
         * - [Function calling](https://platform.openai.com/docs/guides/function-calling)
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** A text input to the model, equivalent to a text input with the `user` role. */
        fun input(text: String) = apply { body.input(text) }

        /** A list of one or many input items to the model, containing different content types. */
        fun inputOfResponse(response: List<ResponseInputItem>) = apply {
            body.inputOfResponse(response)
        }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: ChatModel) = apply { body.model(model) }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: JsonField<ChatModel>) = apply { body.model(model) }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        fun include(include: List<ResponseIncludable>?) = apply { body.include(include) }

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        fun include(include: JsonField<List<ResponseIncludable>>) = apply { body.include(include) }

        /**
         * Specify additional output data to include in the model response. Currently supported
         * values are:
         * - `file_search_call.results`: Include the search results of the file search tool call.
         * - `message.input_image.image_url`: Include image urls from the input message.
         * - `computer_call_output.output.image_url`: Include image urls from the computer call
         *   output.
         */
        fun addInclude(include: ResponseIncludable) = apply { body.addInclude(include) }

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(instructions: String?) = apply { body.instructions(instructions) }

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
         */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Inserts a system (or developer) message as the first item in the model's context.
         *
         * When using along with `previous_response_id`, the instructions from a previous response
         * will be not be carried over to the next response. This makes it simple to swap out system
         * (or developer) messages in new responses.
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
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
            maxOutputTokens(maxOutputTokens.getOrNull())

        /**
         * An upper bound for the number of tokens that can be generated for a response, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
            body.maxOutputTokens(maxOutputTokens)
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

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Boolean?) = apply {
            body.parallelToolCalls(parallelToolCalls)
        }

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(parallelToolCalls as Boolean?)

        /** Whether to allow the model to run tool calls in parallel. */
        fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
            parallelToolCalls(parallelToolCalls.getOrNull())

        /** Whether to allow the model to run tool calls in parallel. */
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
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(previousResponseId: Optional<String>) =
            previousResponseId(previousResponseId.getOrNull())

        /**
         * The unique ID of the previous response to the model. Use this to create multi-turn
         * conversations. Learn more about
         * [conversation state](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun previousResponseId(previousResponseId: JsonField<String>) = apply {
            body.previousResponseId(previousResponseId)
        }

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Reasoning?) = apply { body.reasoning(reasoning) }

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * **o-series models only**
         *
         * Configuration options for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { body.reasoning(reasoning) }

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(store: Boolean?) = apply { body.store(store) }

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(store: Boolean) = store(store as Boolean?)

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(store: Optional<Boolean>) = store(store.getOrNull())

        /** Whether to store the generated model response for later retrieval via API. */
        fun store(store: JsonField<Boolean>) = apply { body.store(store) }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double?) = apply { body.temperature(temperature) }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double) = temperature(temperature as Double?)

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Optional<Double>) = temperature(temperature.getOrNull())

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
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
         * Configuration options for a text response from the model. Can be plain text or structured
         * JSON data. Learn more:
         * - [Text inputs and outputs](https://platform.openai.com/docs/guides/text)
         * - [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs)
         */
        fun text(text: JsonField<ResponseTextConfig>) = apply { body.text(text) }

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: ToolChoice) = apply { body.toolChoice(toolChoice) }

        /**
         * How the model should select which tool (or tools) to use when generating a response. See
         * the `tools` parameter to see how to specify which tools the model can call.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { body.toolChoice(toolChoice) }

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
        fun toolChoice(options: ToolChoiceOptions) = apply { body.toolChoice(options) }

        /**
         * Indicates that the model should use a built-in tool to generate a response.
         * [Learn more about built-in tools](https://platform.openai.com/docs/guides/tools).
         */
        fun toolChoice(types: ToolChoiceTypes) = apply { body.toolChoice(types) }

        /** Use this option to force the model to call a specific function. */
        fun toolChoice(function: ToolChoiceFunction) = apply { body.toolChoice(function) }

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
        fun tools(tools: JsonField<List<Tool>>) = apply { body.tools(tools) }

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
        fun addTool(tool: Tool) = apply { body.addTool(tool) }

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun addTool(fileSearch: FileSearchTool) = apply { body.addTool(fileSearch) }

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun addFileSearchTool(vectorStoreIds: List<String>) = apply {
            body.addFileSearchTool(vectorStoreIds)
        }

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun addTool(function: FunctionTool) = apply { body.addTool(function) }

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        fun addTool(computerUsePreview: ComputerTool) = apply { body.addTool(computerUsePreview) }

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun addTool(webSearch: WebSearchTool) = apply { body.addTool(webSearch) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double?) = apply { body.topP(topP) }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double) = topP(topP as Double?)

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Optional<Double>) = topP(topP.getOrNull())

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
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

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: Optional<Truncation>) = truncation(truncation.getOrNull())

        /**
         * The truncation strategy to use for the model response.
         * - `auto`: If the context of this response and previous ones exceeds the model's context
         *   window size, the model will truncate the response to fit the context window by dropping
         *   input items in the middle of the conversation.
         * - `disabled` (default): If a model response will exceed the context window size for a
         *   model, the request will fail with a 400 error.
         */
        fun truncation(truncation: JsonField<Truncation>) = apply { body.truncation(truncation) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: JsonField<String>) = apply { body.user(user) }

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

        fun build(): ResponseCreateParams =
            ResponseCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                text != null -> visitor.visitText(text)
                response != null -> visitor.visitResponse(response)
                else -> visitor.unknown(_json)
            }
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
            fun ofResponse(response: List<ResponseInputItem>) = Input(response = response)
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

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Input(text = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ResponseInputItem>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Input(response = it, _json = json)
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
                    value.text != null -> generator.writeObject(value.text)
                    value.response != null -> generator.writeObject(value.response)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
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

        fun isOptions(): Boolean = options != null

        fun isTypes(): Boolean = types != null

        fun isFunction(): Boolean = function != null

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

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                options != null -> visitor.visitOptions(options)
                types != null -> visitor.visitTypes(types)
                function != null -> visitor.visitFunction(function)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOptions(options: ToolChoiceOptions) {}

                    override fun visitTypes(types: ToolChoiceTypes) {
                        types.validate()
                    }

                    override fun visitFunction(function: ToolChoiceFunction) {
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

            return /* spotless:off */ other is ToolChoice && options == other.options && types == other.types && function == other.function /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(options, types, function) /* spotless:on */

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
                types != null -> "ToolChoice{types=$types}"
                function != null -> "ToolChoice{function=$function}"
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

                tryDeserialize(node, jacksonTypeRef<ToolChoiceOptions>())?.let {
                    return ToolChoice(options = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ToolChoiceTypes>()) { it.validate() }
                    ?.let {
                        return ToolChoice(types = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ToolChoiceFunction>()) { it.validate() }
                    ?.let {
                        return ToolChoice(function = it, _json = json)
                    }

                return ToolChoice(_json = json)
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
