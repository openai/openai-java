// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.FunctionParameters
import com.openai.models.Metadata
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **Starting a new project?** We recommend trying
 * [Responses](https://platform.openai.com/docs/api-reference/responses) to take advantage of the
 * latest OpenAI platform features. Compare
 * [Chat Completions with Responses](https://platform.openai.com/docs/guides/responses-vs-chat-completions?api-mode=responses).
 *
 * ---
 *
 * Creates a model response for the given chat conversation. Learn more in the
 * [text generation](https://platform.openai.com/docs/guides/text-generation),
 * [vision](https://platform.openai.com/docs/guides/vision), and
 * [audio](https://platform.openai.com/docs/guides/audio) guides.
 *
 * Parameter support can differ depending on the model used to generate the response, particularly
 * for newer reasoning models. Parameters that are only supported for reasoning models are noted
 * below. For the current state of unsupported parameters in reasoning models,
 * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
 */
class ChatCompletionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A list of messages comprising the conversation so far. Depending on the
     * [model](https://platform.openai.com/docs/models) you use, different message types
     * (modalities) are supported, like
     * [text](https://platform.openai.com/docs/guides/text-generation),
     * [images](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messages(): List<ChatCompletionMessageParam> = body.messages()

    /**
     * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range of
     * models with different capabilities, performance characteristics, and price points. Refer to
     * the [model guide](https://platform.openai.com/docs/models) to browse and compare available
     * models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): ChatModel = body.model()

    /**
     * Parameters for audio output. Required when audio output is requested with `modalities:
     * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<ChatCompletionAudioParam> = body.audio()

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
     * frequency in the text so far, decreasing the model's likelihood to repeat the same line
     * verbatim.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun frequencyPenalty(): Optional<Double> = body.frequencyPenalty()

    /**
     * Deprecated in favor of `tool_choice`.
     *
     * Controls which (if any) function is called by the model.
     *
     * `none` means the model will not call a function and instead generates a message.
     *
     * `auto` means the model can pick between generating a message or calling a function.
     *
     * Specifying a particular function via `{"name": "my_function"}` forces the model to call that
     * function.
     *
     * `none` is the default when no functions are present. `auto` is the default if functions are
     * present.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated") fun functionCall(): Optional<FunctionCall> = body.functionCall()

    /**
     * Deprecated in favor of `tools`.
     *
     * A list of functions the model may generate JSON inputs for.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated") fun functions(): Optional<List<Function>> = body.functions()

    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     *
     * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to an
     * associated bias value from -100 to 100. Mathematically, the bias is added to the logits
     * generated by the model prior to sampling. The exact effect will vary per model, but values
     * between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100
     * should result in a ban or exclusive selection of the relevant token.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logitBias(): Optional<LogitBias> = body.logitBias()

    /**
     * Whether to return log probabilities of the output tokens or not. If true, returns the log
     * probabilities of each output token returned in the `content` of `message`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<Boolean> = body.logprobs()

    /**
     * An upper bound for the number of tokens that can be generated for a completion, including
     * visible output tokens and
     * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxCompletionTokens(): Optional<Long> = body.maxCompletionTokens()

    /**
     * The maximum number of [tokens](/tokenizer) that can be generated in the chat completion. This
     * value can be used to control [costs](https://openai.com/api/pricing/) for text generated via
     * API.
     *
     * This value is now deprecated in favor of `max_completion_tokens`, and is not compatible with
     * [o1 series models](https://platform.openai.com/docs/guides/reasoning).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    @Deprecated("deprecated") fun maxTokens(): Optional<Long> = body.maxTokens()

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
     * Output types that you would like the model to generate. Most models are capable of generating
     * text, which is the default:
     *
     * `["text"]`
     *
     * The `gpt-4o-audio-preview` model can also be used to
     * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this model
     * generate both text and audio responses, you can use:
     *
     * `["text", "audio"]`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modalities(): Optional<List<Modality>> = body.modalities()

    /**
     * How many chat completion choices to generate for each input message. Note that you will be
     * charged based on the number of generated tokens across all of the choices. Keep `n` as `1` to
     * minimize costs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun n(): Optional<Long> = body.n()

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
     * Static predicted output content, such as the content of a text file that is being
     * regenerated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prediction(): Optional<ChatCompletionPredictionContent> = body.prediction()

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear
     * in the text so far, increasing the model's likelihood to talk about new topics.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun presencePenalty(): Optional<Double> = body.presencePenalty()

    /**
     * **o-series models only**
     *
     * Constrains effort on reasoning for
     * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently supported
     * values are `low`, `medium`, and `high`. Reducing reasoning effort can result in faster
     * responses and fewer tokens used on reasoning in a response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoningEffort(): Optional<ReasoningEffort> = body.reasoningEffort()

    /**
     * An object specifying the format that the model must output.
     *
     * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
     * ensures the model will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the message
     * the model generates is valid JSON. Using `json_schema` is preferred for models that support
     * it.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /**
     * This feature is in Beta. If specified, our system will make a best effort to sample
     * deterministically, such that repeated requests with the same `seed` and parameters should
     * return the same result. Determinism is not guaranteed, and you should refer to the
     * `system_fingerprint` response parameter to monitor changes in the backend.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun seed(): Optional<Long> = body.seed()

    /**
     * Specifies the latency tier to use for processing the request. This parameter is relevant for
     * customers subscribed to the scale tier service:
     * - If set to 'auto', and the Project is Scale tier enabled, the system will utilize scale tier
     *   credits until they are exhausted.
     * - If set to 'auto', and the Project is not Scale tier enabled, the request will be processed
     *   using the default service tier with a lower uptime SLA and no latency guarentee.
     * - If set to 'default', the request will be processed using the default service tier with a
     *   lower uptime SLA and no latency guarentee.
     * - When not set, the default behavior is 'auto'.
     *
     * When this parameter is set, the response body will include the `service_tier` utilized.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceTier(): Optional<ServiceTier> = body.serviceTier()

    /**
     * Up to 4 sequences where the API will stop generating further tokens. The returned text will
     * not contain the stop sequence.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stop(): Optional<Stop> = body.stop()

    /**
     * Whether or not to store the output of this chat completion request for use in our
     * [model distillation](https://platform.openai.com/docs/guides/distillation) or
     * [evals](https://platform.openai.com/docs/guides/evals) products.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun store(): Optional<Boolean> = body.store()

    /**
     * Options for streaming response. Only set this when you set `stream: true`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamOptions(): Optional<ChatCompletionStreamOptions> = body.streamOptions()

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
     * Controls which (if any) tool is called by the model. `none` means the model will not call any
     * tool and instead generates a message. `auto` means the model can pick between generating a
     * message or calling one or more tools. `required` means the model must call one or more tools.
     * Specifying a particular tool via `{"type": "function", "function": {"name": "my_function"}}`
     * forces the model to call that tool.
     *
     * `none` is the default when no tools are present. `auto` is the default if tools are present.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<ChatCompletionToolChoiceOption> = body.toolChoice()

    /**
     * A list of tools the model may call. Currently, only functions are supported as a tool. Use
     * this to provide a list of functions the model may generate JSON inputs for. A max of 128
     * functions are supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<ChatCompletionTool>> = body.tools()

    /**
     * An integer between 0 and 20 specifying the number of most likely tokens to return at each
     * token position, each with an associated log probability. `logprobs` must be set to `true` if
     * this parameter is used.
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
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect
     * abuse.
     * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun user(): Optional<String> = body.user()

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search?api-mode=chat).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun webSearchOptions(): Optional<WebSearchOptions> = body.webSearchOptions()

    /**
     * Returns the raw JSON value of [messages].
     *
     * Unlike [messages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _messages(): JsonField<List<ChatCompletionMessageParam>> = body._messages()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<ChatModel> = body._model()

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _audio(): JsonField<ChatCompletionAudioParam> = body._audio()

    /**
     * Returns the raw JSON value of [frequencyPenalty].
     *
     * Unlike [frequencyPenalty], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _frequencyPenalty(): JsonField<Double> = body._frequencyPenalty()

    /**
     * Returns the raw JSON value of [functionCall].
     *
     * Unlike [functionCall], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _functionCall(): JsonField<FunctionCall> = body._functionCall()

    /**
     * Returns the raw JSON value of [functions].
     *
     * Unlike [functions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _functions(): JsonField<List<Function>> = body._functions()

    /**
     * Returns the raw JSON value of [logitBias].
     *
     * Unlike [logitBias], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _logitBias(): JsonField<LogitBias> = body._logitBias()

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _logprobs(): JsonField<Boolean> = body._logprobs()

    /**
     * Returns the raw JSON value of [maxCompletionTokens].
     *
     * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxCompletionTokens(): JsonField<Long> = body._maxCompletionTokens()

    /**
     * Returns the raw JSON value of [maxTokens].
     *
     * Unlike [maxTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("deprecated") fun _maxTokens(): JsonField<Long> = body._maxTokens()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [modalities].
     *
     * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _modalities(): JsonField<List<Modality>> = body._modalities()

    /**
     * Returns the raw JSON value of [n].
     *
     * Unlike [n], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _n(): JsonField<Long> = body._n()

    /**
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _parallelToolCalls(): JsonField<Boolean> = body._parallelToolCalls()

    /**
     * Returns the raw JSON value of [prediction].
     *
     * Unlike [prediction], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _prediction(): JsonField<ChatCompletionPredictionContent> = body._prediction()

    /**
     * Returns the raw JSON value of [presencePenalty].
     *
     * Unlike [presencePenalty], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _presencePenalty(): JsonField<Double> = body._presencePenalty()

    /**
     * Returns the raw JSON value of [reasoningEffort].
     *
     * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reasoningEffort(): JsonField<ReasoningEffort> = body._reasoningEffort()

    /**
     * Returns the raw JSON value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseFormat(): JsonField<ResponseFormat> = body._responseFormat()

    /**
     * Returns the raw JSON value of [seed].
     *
     * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _seed(): JsonField<Long> = body._seed()

    /**
     * Returns the raw JSON value of [serviceTier].
     *
     * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _serviceTier(): JsonField<ServiceTier> = body._serviceTier()

    /**
     * Returns the raw JSON value of [stop].
     *
     * Unlike [stop], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stop(): JsonField<Stop> = body._stop()

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
    fun _streamOptions(): JsonField<ChatCompletionStreamOptions> = body._streamOptions()

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolChoice(): JsonField<ChatCompletionToolChoiceOption> = body._toolChoice()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<ChatCompletionTool>> = body._tools()

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
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _user(): JsonField<String> = body._user()

    /**
     * Returns the raw JSON value of [webSearchOptions].
     *
     * Unlike [webSearchOptions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _webSearchOptions(): JsonField<WebSearchOptions> = body._webSearchOptions()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .messages()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(chatCompletionCreateParams: ChatCompletionCreateParams) = apply {
            body = chatCompletionCreateParams.body.toBuilder()
            additionalHeaders = chatCompletionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = chatCompletionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * A list of messages comprising the conversation so far. Depending on the
         * [model](https://platform.openai.com/docs/models) you use, different message types
         * (modalities) are supported, like
         * [text](https://platform.openai.com/docs/guides/text-generation),
         * [images](https://platform.openai.com/docs/guides/vision), and
         * [audio](https://platform.openai.com/docs/guides/audio).
         */
        fun messages(messages: List<ChatCompletionMessageParam>) = apply { body.messages(messages) }

        /**
         * Sets [Builder.messages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messages] with a well-typed
         * `List<ChatCompletionMessageParam>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun messages(messages: JsonField<List<ChatCompletionMessageParam>>) = apply {
            body.messages(messages)
        }

        /**
         * Adds a single [ChatCompletionMessageParam] to [messages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMessage(message: ChatCompletionMessageParam) = apply { body.addMessage(message) }

        /**
         * Alias for calling [addMessage] with `ChatCompletionMessageParam.ofDeveloper(developer)`.
         */
        fun addMessage(developer: ChatCompletionDeveloperMessageParam) = apply {
            body.addMessage(developer)
        }

        /**
         * Alias for calling [addMessage] with the following:
         * ```java
         * ChatCompletionDeveloperMessageParam.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addDeveloperMessage(content: ChatCompletionDeveloperMessageParam.Content) = apply {
            body.addDeveloperMessage(content)
        }

        /**
         * Alias for calling [addDeveloperMessage] with
         * `ChatCompletionDeveloperMessageParam.Content.ofText(text)`.
         */
        fun addDeveloperMessage(text: String) = apply { body.addDeveloperMessage(text) }

        /**
         * Alias for calling [addDeveloperMessage] with
         * `ChatCompletionDeveloperMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
         */
        fun addDeveloperMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPartText>
        ) = apply { body.addDeveloperMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** Alias for calling [addMessage] with `ChatCompletionMessageParam.ofSystem(system)`. */
        fun addMessage(system: ChatCompletionSystemMessageParam) = apply { body.addMessage(system) }

        /**
         * Alias for calling [addMessage] with the following:
         * ```java
         * ChatCompletionSystemMessageParam.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addSystemMessage(content: ChatCompletionSystemMessageParam.Content) = apply {
            body.addSystemMessage(content)
        }

        /**
         * Alias for calling [addSystemMessage] with
         * `ChatCompletionSystemMessageParam.Content.ofText(text)`.
         */
        fun addSystemMessage(text: String) = apply { body.addSystemMessage(text) }

        /**
         * Alias for calling [addSystemMessage] with
         * `ChatCompletionSystemMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
         */
        fun addSystemMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPartText>
        ) = apply { body.addSystemMessageOfArrayOfContentParts(arrayOfContentParts) }

        /** Alias for calling [addMessage] with `ChatCompletionMessageParam.ofUser(user)`. */
        fun addMessage(user: ChatCompletionUserMessageParam) = apply { body.addMessage(user) }

        /**
         * Alias for calling [addMessage] with the following:
         * ```java
         * ChatCompletionUserMessageParam.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addUserMessage(content: ChatCompletionUserMessageParam.Content) = apply {
            body.addUserMessage(content)
        }

        /**
         * Alias for calling [addUserMessage] with
         * `ChatCompletionUserMessageParam.Content.ofText(text)`.
         */
        fun addUserMessage(text: String) = apply { body.addUserMessage(text) }

        /**
         * Alias for calling [addUserMessage] with
         * `ChatCompletionUserMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
         */
        fun addUserMessageOfArrayOfContentParts(
            arrayOfContentParts: List<ChatCompletionContentPart>
        ) = apply { body.addUserMessageOfArrayOfContentParts(arrayOfContentParts) }

        /**
         * Alias for calling [addMessage] with `ChatCompletionMessageParam.ofAssistant(assistant)`.
         */
        fun addMessage(assistant: ChatCompletionAssistantMessageParam) = apply {
            body.addMessage(assistant)
        }

        /** Alias for calling [addMessage] with `assistant.toParam()`. */
        fun addMessage(assistant: ChatCompletionMessage) = apply { body.addMessage(assistant) }

        /** Alias for calling [addMessage] with `ChatCompletionMessageParam.ofTool(tool)`. */
        fun addMessage(tool: ChatCompletionToolMessageParam) = apply { body.addMessage(tool) }

        /**
         * Alias for calling [addMessage] with `ChatCompletionMessageParam.ofFunction(function)`.
         */
        @Deprecated("deprecated")
        fun addMessage(function: ChatCompletionFunctionMessageParam) = apply {
            body.addMessage(function)
        }

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         */
        fun model(model: ChatModel) = apply { body.model(model) }

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
         * Parameters for audio output. Required when audio output is requested with `modalities:
         * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        fun audio(audio: ChatCompletionAudioParam?) = apply { body.audio(audio) }

        /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
        fun audio(audio: Optional<ChatCompletionAudioParam>) = audio(audio.getOrNull())

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [ChatCompletionAudioParam]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun audio(audio: JsonField<ChatCompletionAudioParam>) = apply { body.audio(audio) }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         */
        fun frequencyPenalty(frequencyPenalty: Double?) = apply {
            body.frequencyPenalty(frequencyPenalty)
        }

        /**
         * Alias for [Builder.frequencyPenalty].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun frequencyPenalty(frequencyPenalty: Double) =
            frequencyPenalty(frequencyPenalty as Double?)

        /** Alias for calling [Builder.frequencyPenalty] with `frequencyPenalty.orElse(null)`. */
        fun frequencyPenalty(frequencyPenalty: Optional<Double>) =
            frequencyPenalty(frequencyPenalty.getOrNull())

        /**
         * Sets [Builder.frequencyPenalty] to an arbitrary JSON value.
         *
         * You should usually call [Builder.frequencyPenalty] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun frequencyPenalty(frequencyPenalty: JsonField<Double>) = apply {
            body.frequencyPenalty(frequencyPenalty)
        }

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model.
         *
         * `none` means the model will not call a function and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling a function.
         *
         * Specifying a particular function via `{"name": "my_function"}` forces the model to call
         * that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCall: FunctionCall) = apply { body.functionCall(functionCall) }

        /**
         * Sets [Builder.functionCall] to an arbitrary JSON value.
         *
         * You should usually call [Builder.functionCall] with a well-typed [FunctionCall] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
            body.functionCall(functionCall)
        }

        /** Alias for calling [functionCall] with `FunctionCall.ofMode(mode)`. */
        @Deprecated("deprecated")
        fun functionCall(mode: FunctionCall.FunctionCallMode) = apply { body.functionCall(mode) }

        /**
         * Alias for calling [functionCall] with
         * `FunctionCall.ofFunctionCallOption(functionCallOption)`.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCallOption: ChatCompletionFunctionCallOption) = apply {
            body.functionCall(functionCallOption)
        }

        /**
         * Deprecated in favor of `tools`.
         *
         * A list of functions the model may generate JSON inputs for.
         */
        @Deprecated("deprecated")
        fun functions(functions: List<Function>) = apply { body.functions(functions) }

        /**
         * Sets [Builder.functions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.functions] with a well-typed `List<Function>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        @Deprecated("deprecated")
        fun functions(functions: JsonField<List<Function>>) = apply { body.functions(functions) }

        /**
         * Adds a single [Function] to [functions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        @Deprecated("deprecated")
        fun addFunction(function: Function) = apply { body.addFunction(function) }

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         */
        fun logitBias(logitBias: LogitBias?) = apply { body.logitBias(logitBias) }

        /** Alias for calling [Builder.logitBias] with `logitBias.orElse(null)`. */
        fun logitBias(logitBias: Optional<LogitBias>) = logitBias(logitBias.getOrNull())

        /**
         * Sets [Builder.logitBias] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logitBias] with a well-typed [LogitBias] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun logitBias(logitBias: JsonField<LogitBias>) = apply { body.logitBias(logitBias) }

        /**
         * Whether to return log probabilities of the output tokens or not. If true, returns the log
         * probabilities of each output token returned in the `content` of `message`.
         */
        fun logprobs(logprobs: Boolean?) = apply { body.logprobs(logprobs) }

        /**
         * Alias for [Builder.logprobs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun logprobs(logprobs: Boolean) = logprobs(logprobs as Boolean?)

        /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
        fun logprobs(logprobs: Optional<Boolean>) = logprobs(logprobs.getOrNull())

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun logprobs(logprobs: JsonField<Boolean>) = apply { body.logprobs(logprobs) }

        /**
         * An upper bound for the number of tokens that can be generated for a completion, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
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
         * The maximum number of [tokens](/tokenizer) that can be generated in the chat completion.
         * This value can be used to control [costs](https://openai.com/api/pricing/) for text
         * generated via API.
         *
         * This value is now deprecated in favor of `max_completion_tokens`, and is not compatible
         * with [o1 series models](https://platform.openai.com/docs/guides/reasoning).
         */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: Long?) = apply { body.maxTokens(maxTokens) }

        /**
         * Alias for [Builder.maxTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        @Deprecated("deprecated") fun maxTokens(maxTokens: Long) = maxTokens(maxTokens as Long?)

        /** Alias for calling [Builder.maxTokens] with `maxTokens.orElse(null)`. */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: Optional<Long>) = maxTokens(maxTokens.getOrNull())

        /**
         * Sets [Builder.maxTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxTokens] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        @Deprecated("deprecated")
        fun maxTokens(maxTokens: JsonField<Long>) = apply { body.maxTokens(maxTokens) }

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
         * Output types that you would like the model to generate. Most models are capable of
         * generating text, which is the default:
         *
         * `["text"]`
         *
         * The `gpt-4o-audio-preview` model can also be used to
         * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
         * model generate both text and audio responses, you can use:
         *
         * `["text", "audio"]`
         */
        fun modalities(modalities: List<Modality>?) = apply { body.modalities(modalities) }

        /** Alias for calling [Builder.modalities] with `modalities.orElse(null)`. */
        fun modalities(modalities: Optional<List<Modality>>) = modalities(modalities.getOrNull())

        /**
         * Sets [Builder.modalities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modalities] with a well-typed `List<Modality>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun modalities(modalities: JsonField<List<Modality>>) = apply {
            body.modalities(modalities)
        }

        /**
         * Adds a single [Modality] to [modalities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addModality(modality: Modality) = apply { body.addModality(modality) }

        /**
         * How many chat completion choices to generate for each input message. Note that you will
         * be charged based on the number of generated tokens across all of the choices. Keep `n` as
         * `1` to minimize costs.
         */
        fun n(n: Long?) = apply { body.n(n) }

        /**
         * Alias for [Builder.n].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun n(n: Long) = n(n as Long?)

        /** Alias for calling [Builder.n] with `n.orElse(null)`. */
        fun n(n: Optional<Long>) = n(n.getOrNull())

        /**
         * Sets [Builder.n] to an arbitrary JSON value.
         *
         * You should usually call [Builder.n] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun n(n: JsonField<Long>) = apply { body.n(n) }

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
         * Static predicted output content, such as the content of a text file that is being
         * regenerated.
         */
        fun prediction(prediction: ChatCompletionPredictionContent?) = apply {
            body.prediction(prediction)
        }

        /** Alias for calling [Builder.prediction] with `prediction.orElse(null)`. */
        fun prediction(prediction: Optional<ChatCompletionPredictionContent>) =
            prediction(prediction.getOrNull())

        /**
         * Sets [Builder.prediction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prediction] with a well-typed
         * [ChatCompletionPredictionContent] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun prediction(prediction: JsonField<ChatCompletionPredictionContent>) = apply {
            body.prediction(prediction)
        }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         */
        fun presencePenalty(presencePenalty: Double?) = apply {
            body.presencePenalty(presencePenalty)
        }

        /**
         * Alias for [Builder.presencePenalty].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun presencePenalty(presencePenalty: Double) = presencePenalty(presencePenalty as Double?)

        /** Alias for calling [Builder.presencePenalty] with `presencePenalty.orElse(null)`. */
        fun presencePenalty(presencePenalty: Optional<Double>) =
            presencePenalty(presencePenalty.getOrNull())

        /**
         * Sets [Builder.presencePenalty] to an arbitrary JSON value.
         *
         * You should usually call [Builder.presencePenalty] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun presencePenalty(presencePenalty: JsonField<Double>) = apply {
            body.presencePenalty(presencePenalty)
        }

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         */
        fun reasoningEffort(reasoningEffort: ReasoningEffort?) = apply {
            body.reasoningEffort(reasoningEffort)
        }

        /** Alias for calling [Builder.reasoningEffort] with `reasoningEffort.orElse(null)`. */
        fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
            reasoningEffort(reasoningEffort.getOrNull())

        /**
         * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
            body.reasoningEffort(reasoningEffort)
        }

        /**
         * An object specifying the format that the model must output.
         *
         * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs
         * which ensures the model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
         * message the model generates is valid JSON. Using `json_schema` is preferred for models
         * that support it.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * Sets [Builder.responseFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /** Alias for calling [responseFormat] with `ResponseFormat.ofText(text)`. */
        fun responseFormat(text: ResponseFormatText) = apply { body.responseFormat(text) }

        /** Alias for calling [responseFormat] with `ResponseFormat.ofJsonSchema(jsonSchema)`. */
        fun responseFormat(jsonSchema: ResponseFormatJsonSchema) = apply {
            body.responseFormat(jsonSchema)
        }

        /** Alias for calling [responseFormat] with `ResponseFormat.ofJsonObject(jsonObject)`. */
        fun responseFormat(jsonObject: ResponseFormatJsonObject) = apply {
            body.responseFormat(jsonObject)
        }

        /**
         * This feature is in Beta. If specified, our system will make a best effort to sample
         * deterministically, such that repeated requests with the same `seed` and parameters should
         * return the same result. Determinism is not guaranteed, and you should refer to the
         * `system_fingerprint` response parameter to monitor changes in the backend.
         */
        fun seed(seed: Long?) = apply { body.seed(seed) }

        /**
         * Alias for [Builder.seed].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun seed(seed: Long) = seed(seed as Long?)

        /** Alias for calling [Builder.seed] with `seed.orElse(null)`. */
        fun seed(seed: Optional<Long>) = seed(seed.getOrNull())

        /**
         * Sets [Builder.seed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seed(seed: JsonField<Long>) = apply { body.seed(seed) }

        /**
         * Specifies the latency tier to use for processing the request. This parameter is relevant
         * for customers subscribed to the scale tier service:
         * - If set to 'auto', and the Project is Scale tier enabled, the system will utilize scale
         *   tier credits until they are exhausted.
         * - If set to 'auto', and the Project is not Scale tier enabled, the request will be
         *   processed using the default service tier with a lower uptime SLA and no latency
         *   guarentee.
         * - If set to 'default', the request will be processed using the default service tier with
         *   a lower uptime SLA and no latency guarentee.
         * - When not set, the default behavior is 'auto'.
         *
         * When this parameter is set, the response body will include the `service_tier` utilized.
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

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stop(stop: Stop?) = apply { body.stop(stop) }

        /** Alias for calling [Builder.stop] with `stop.orElse(null)`. */
        fun stop(stop: Optional<Stop>) = stop(stop.getOrNull())

        /**
         * Sets [Builder.stop] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stop] with a well-typed [Stop] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stop(stop: JsonField<Stop>) = apply { body.stop(stop) }

        /** Alias for calling [stop] with `Stop.ofString(string)`. */
        fun stop(string: String) = apply { body.stop(string) }

        /** Alias for calling [stop] with `Stop.ofStrings(strings)`. */
        fun stopOfStrings(strings: List<String>) = apply { body.stopOfStrings(strings) }

        /**
         * Whether or not to store the output of this chat completion request for use in our
         * [model distillation](https://platform.openai.com/docs/guides/distillation) or
         * [evals](https://platform.openai.com/docs/guides/evals) products.
         */
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

        /** Options for streaming response. Only set this when you set `stream: true`. */
        fun streamOptions(streamOptions: ChatCompletionStreamOptions?) = apply {
            body.streamOptions(streamOptions)
        }

        /** Alias for calling [Builder.streamOptions] with `streamOptions.orElse(null)`. */
        fun streamOptions(streamOptions: Optional<ChatCompletionStreamOptions>) =
            streamOptions(streamOptions.getOrNull())

        /**
         * Sets [Builder.streamOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.streamOptions] with a well-typed
         * [ChatCompletionStreamOptions] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun streamOptions(streamOptions: JsonField<ChatCompletionStreamOptions>) = apply {
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
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tool and instead generates a message. `auto` means the model can pick between
         * generating a message or calling one or more tools. `required` means the model must call
         * one or more tools. Specifying a particular tool via `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         *
         * `none` is the default when no tools are present. `auto` is the default if tools are
         * present.
         */
        fun toolChoice(toolChoice: ChatCompletionToolChoiceOption) = apply {
            body.toolChoice(toolChoice)
        }

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed
         * [ChatCompletionToolChoiceOption] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun toolChoice(toolChoice: JsonField<ChatCompletionToolChoiceOption>) = apply {
            body.toolChoice(toolChoice)
        }

        /** Alias for calling [toolChoice] with `ChatCompletionToolChoiceOption.ofAuto(auto)`. */
        fun toolChoice(auto: ChatCompletionToolChoiceOption.Auto) = apply { body.toolChoice(auto) }

        /**
         * Alias for calling [toolChoice] with
         * `ChatCompletionToolChoiceOption.ofNamedToolChoice(namedToolChoice)`.
         */
        fun toolChoice(namedToolChoice: ChatCompletionNamedToolChoice) = apply {
            body.toolChoice(namedToolChoice)
        }

        /**
         * A list of tools the model may call. Currently, only functions are supported as a tool.
         * Use this to provide a list of functions the model may generate JSON inputs for. A max of
         * 128 functions are supported.
         */
        fun tools(tools: List<ChatCompletionTool>) = apply { body.tools(tools) }

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<ChatCompletionTool>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun tools(tools: JsonField<List<ChatCompletionTool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [ChatCompletionTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: ChatCompletionTool) = apply { body.addTool(tool) }

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability. `logprobs` must be set to `true`
         * if this parameter is used.
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
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { body.user(user) }

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: JsonField<String>) = apply { body.user(user) }

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the
         * [web search tool](https://platform.openai.com/docs/guides/tools-web-search?api-mode=chat).
         */
        fun webSearchOptions(webSearchOptions: WebSearchOptions) = apply {
            body.webSearchOptions(webSearchOptions)
        }

        /**
         * Sets [Builder.webSearchOptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webSearchOptions] with a well-typed [WebSearchOptions]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun webSearchOptions(webSearchOptions: JsonField<WebSearchOptions>) = apply {
            body.webSearchOptions(webSearchOptions)
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
         * Returns an immutable instance of [ChatCompletionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .messages()
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionCreateParams =
            ChatCompletionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val messages: JsonField<List<ChatCompletionMessageParam>>,
        private val model: JsonField<ChatModel>,
        private val audio: JsonField<ChatCompletionAudioParam>,
        private val frequencyPenalty: JsonField<Double>,
        private val functionCall: JsonField<FunctionCall>,
        private val functions: JsonField<List<Function>>,
        private val logitBias: JsonField<LogitBias>,
        private val logprobs: JsonField<Boolean>,
        private val maxCompletionTokens: JsonField<Long>,
        private val maxTokens: JsonField<Long>,
        private val metadata: JsonField<Metadata>,
        private val modalities: JsonField<List<Modality>>,
        private val n: JsonField<Long>,
        private val parallelToolCalls: JsonField<Boolean>,
        private val prediction: JsonField<ChatCompletionPredictionContent>,
        private val presencePenalty: JsonField<Double>,
        private val reasoningEffort: JsonField<ReasoningEffort>,
        private val responseFormat: JsonField<ResponseFormat>,
        private val seed: JsonField<Long>,
        private val serviceTier: JsonField<ServiceTier>,
        private val stop: JsonField<Stop>,
        private val store: JsonField<Boolean>,
        private val streamOptions: JsonField<ChatCompletionStreamOptions>,
        private val temperature: JsonField<Double>,
        private val toolChoice: JsonField<ChatCompletionToolChoiceOption>,
        private val tools: JsonField<List<ChatCompletionTool>>,
        private val topLogprobs: JsonField<Long>,
        private val topP: JsonField<Double>,
        private val user: JsonField<String>,
        private val webSearchOptions: JsonField<WebSearchOptions>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("messages")
            @ExcludeMissing
            messages: JsonField<List<ChatCompletionMessageParam>> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<ChatModel> = JsonMissing.of(),
            @JsonProperty("audio")
            @ExcludeMissing
            audio: JsonField<ChatCompletionAudioParam> = JsonMissing.of(),
            @JsonProperty("frequency_penalty")
            @ExcludeMissing
            frequencyPenalty: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("function_call")
            @ExcludeMissing
            functionCall: JsonField<FunctionCall> = JsonMissing.of(),
            @JsonProperty("functions")
            @ExcludeMissing
            functions: JsonField<List<Function>> = JsonMissing.of(),
            @JsonProperty("logit_bias")
            @ExcludeMissing
            logitBias: JsonField<LogitBias> = JsonMissing.of(),
            @JsonProperty("logprobs")
            @ExcludeMissing
            logprobs: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("max_completion_tokens")
            @ExcludeMissing
            maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("max_tokens")
            @ExcludeMissing
            maxTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("modalities")
            @ExcludeMissing
            modalities: JsonField<List<Modality>> = JsonMissing.of(),
            @JsonProperty("n") @ExcludeMissing n: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("parallel_tool_calls")
            @ExcludeMissing
            parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("prediction")
            @ExcludeMissing
            prediction: JsonField<ChatCompletionPredictionContent> = JsonMissing.of(),
            @JsonProperty("presence_penalty")
            @ExcludeMissing
            presencePenalty: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("reasoning_effort")
            @ExcludeMissing
            reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of(),
            @JsonProperty("response_format")
            @ExcludeMissing
            responseFormat: JsonField<ResponseFormat> = JsonMissing.of(),
            @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("service_tier")
            @ExcludeMissing
            serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
            @JsonProperty("stop") @ExcludeMissing stop: JsonField<Stop> = JsonMissing.of(),
            @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("stream_options")
            @ExcludeMissing
            streamOptions: JsonField<ChatCompletionStreamOptions> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<ChatCompletionToolChoiceOption> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<ChatCompletionTool>> = JsonMissing.of(),
            @JsonProperty("top_logprobs")
            @ExcludeMissing
            topLogprobs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
            @JsonProperty("web_search_options")
            @ExcludeMissing
            webSearchOptions: JsonField<WebSearchOptions> = JsonMissing.of(),
        ) : this(
            messages,
            model,
            audio,
            frequencyPenalty,
            functionCall,
            functions,
            logitBias,
            logprobs,
            maxCompletionTokens,
            maxTokens,
            metadata,
            modalities,
            n,
            parallelToolCalls,
            prediction,
            presencePenalty,
            reasoningEffort,
            responseFormat,
            seed,
            serviceTier,
            stop,
            store,
            streamOptions,
            temperature,
            toolChoice,
            tools,
            topLogprobs,
            topP,
            user,
            webSearchOptions,
            mutableMapOf(),
        )

        /**
         * A list of messages comprising the conversation so far. Depending on the
         * [model](https://platform.openai.com/docs/models) you use, different message types
         * (modalities) are supported, like
         * [text](https://platform.openai.com/docs/guides/text-generation),
         * [images](https://platform.openai.com/docs/guides/vision), and
         * [audio](https://platform.openai.com/docs/guides/audio).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun messages(): List<ChatCompletionMessageParam> = messages.getRequired("messages")

        /**
         * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide range
         * of models with different capabilities, performance characteristics, and price points.
         * Refer to the [model guide](https://platform.openai.com/docs/models) to browse and compare
         * available models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): ChatModel = model.getRequired("model")

        /**
         * Parameters for audio output. Required when audio output is requested with `modalities:
         * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audio(): Optional<ChatCompletionAudioParam> =
            Optional.ofNullable(audio.getNullable("audio"))

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun frequencyPenalty(): Optional<Double> =
            Optional.ofNullable(frequencyPenalty.getNullable("frequency_penalty"))

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model.
         *
         * `none` means the model will not call a function and instead generates a message.
         *
         * `auto` means the model can pick between generating a message or calling a function.
         *
         * Specifying a particular function via `{"name": "my_function"}` forces the model to call
         * that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun functionCall(): Optional<FunctionCall> =
            Optional.ofNullable(functionCall.getNullable("function_call"))

        /**
         * Deprecated in favor of `tools`.
         *
         * A list of functions the model may generate JSON inputs for.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun functions(): Optional<List<Function>> =
            Optional.ofNullable(functions.getNullable("functions"))

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logitBias(): Optional<LogitBias> =
            Optional.ofNullable(logitBias.getNullable("logit_bias"))

        /**
         * Whether to return log probabilities of the output tokens or not. If true, returns the log
         * probabilities of each output token returned in the `content` of `message`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logprobs(): Optional<Boolean> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        /**
         * An upper bound for the number of tokens that can be generated for a completion, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxCompletionTokens(): Optional<Long> =
            Optional.ofNullable(maxCompletionTokens.getNullable("max_completion_tokens"))

        /**
         * The maximum number of [tokens](/tokenizer) that can be generated in the chat completion.
         * This value can be used to control [costs](https://openai.com/api/pricing/) for text
         * generated via API.
         *
         * This value is now deprecated in favor of `max_completion_tokens`, and is not compatible
         * with [o1 series models](https://platform.openai.com/docs/guides/reasoning).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        @Deprecated("deprecated")
        fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens.getNullable("max_tokens"))

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
         * Output types that you would like the model to generate. Most models are capable of
         * generating text, which is the default:
         *
         * `["text"]`
         *
         * The `gpt-4o-audio-preview` model can also be used to
         * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
         * model generate both text and audio responses, you can use:
         *
         * `["text", "audio"]`
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun modalities(): Optional<List<Modality>> =
            Optional.ofNullable(modalities.getNullable("modalities"))

        /**
         * How many chat completion choices to generate for each input message. Note that you will
         * be charged based on the number of generated tokens across all of the choices. Keep `n` as
         * `1` to minimize costs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun n(): Optional<Long> = Optional.ofNullable(n.getNullable("n"))

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
         * Static predicted output content, such as the content of a text file that is being
         * regenerated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prediction(): Optional<ChatCompletionPredictionContent> =
            Optional.ofNullable(prediction.getNullable("prediction"))

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun presencePenalty(): Optional<Double> =
            Optional.ofNullable(presencePenalty.getNullable("presence_penalty"))

        /**
         * **o-series models only**
         *
         * Constrains effort on reasoning for
         * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
         * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can result in
         * faster responses and fewer tokens used on reasoning in a response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasoningEffort(): Optional<ReasoningEffort> =
            Optional.ofNullable(reasoningEffort.getNullable("reasoning_effort"))

        /**
         * An object specifying the format that the model must output.
         *
         * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs
         * which ensures the model will match your supplied JSON schema. Learn more in the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         *
         * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
         * message the model generates is valid JSON. Using `json_schema` is preferred for models
         * that support it.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<ResponseFormat> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * This feature is in Beta. If specified, our system will make a best effort to sample
         * deterministically, such that repeated requests with the same `seed` and parameters should
         * return the same result. Determinism is not guaranteed, and you should refer to the
         * `system_fingerprint` response parameter to monitor changes in the backend.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seed(): Optional<Long> = Optional.ofNullable(seed.getNullable("seed"))

        /**
         * Specifies the latency tier to use for processing the request. This parameter is relevant
         * for customers subscribed to the scale tier service:
         * - If set to 'auto', and the Project is Scale tier enabled, the system will utilize scale
         *   tier credits until they are exhausted.
         * - If set to 'auto', and the Project is not Scale tier enabled, the request will be
         *   processed using the default service tier with a lower uptime SLA and no latency
         *   guarentee.
         * - If set to 'default', the request will be processed using the default service tier with
         *   a lower uptime SLA and no latency guarentee.
         * - When not set, the default behavior is 'auto'.
         *
         * When this parameter is set, the response body will include the `service_tier` utilized.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serviceTier(): Optional<ServiceTier> =
            Optional.ofNullable(serviceTier.getNullable("service_tier"))

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stop(): Optional<Stop> = Optional.ofNullable(stop.getNullable("stop"))

        /**
         * Whether or not to store the output of this chat completion request for use in our
         * [model distillation](https://platform.openai.com/docs/guides/distillation) or
         * [evals](https://platform.openai.com/docs/guides/evals) products.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun store(): Optional<Boolean> = Optional.ofNullable(store.getNullable("store"))

        /**
         * Options for streaming response. Only set this when you set `stream: true`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun streamOptions(): Optional<ChatCompletionStreamOptions> =
            Optional.ofNullable(streamOptions.getNullable("stream_options"))

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic. We generally recommend altering this or `top_p` but not both.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.getNullable("temperature"))

        /**
         * Controls which (if any) tool is called by the model. `none` means the model will not call
         * any tool and instead generates a message. `auto` means the model can pick between
         * generating a message or calling one or more tools. `required` means the model must call
         * one or more tools. Specifying a particular tool via `{"type": "function", "function":
         * {"name": "my_function"}}` forces the model to call that tool.
         *
         * `none` is the default when no tools are present. `auto` is the default if tools are
         * present.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<ChatCompletionToolChoiceOption> =
            Optional.ofNullable(toolChoice.getNullable("tool_choice"))

        /**
         * A list of tools the model may call. Currently, only functions are supported as a tool.
         * Use this to provide a list of functions the model may generate JSON inputs for. A max of
         * 128 functions are supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<ChatCompletionTool>> =
            Optional.ofNullable(tools.getNullable("tools"))

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability. `logprobs` must be set to `true`
         * if this parameter is used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topLogprobs(): Optional<Long> =
            Optional.ofNullable(topLogprobs.getNullable("top_logprobs"))

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
        fun topP(): Optional<Double> = Optional.ofNullable(topP.getNullable("top_p"))

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun user(): Optional<String> = Optional.ofNullable(user.getNullable("user"))

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the
         * [web search tool](https://platform.openai.com/docs/guides/tools-web-search?api-mode=chat).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun webSearchOptions(): Optional<WebSearchOptions> =
            Optional.ofNullable(webSearchOptions.getNullable("web_search_options"))

        /**
         * Returns the raw JSON value of [messages].
         *
         * Unlike [messages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("messages")
        @ExcludeMissing
        fun _messages(): JsonField<List<ChatCompletionMessageParam>> = messages

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ChatModel> = model

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio")
        @ExcludeMissing
        fun _audio(): JsonField<ChatCompletionAudioParam> = audio

        /**
         * Returns the raw JSON value of [frequencyPenalty].
         *
         * Unlike [frequencyPenalty], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("frequency_penalty")
        @ExcludeMissing
        fun _frequencyPenalty(): JsonField<Double> = frequencyPenalty

        /**
         * Returns the raw JSON value of [functionCall].
         *
         * Unlike [functionCall], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @Deprecated("deprecated")
        @JsonProperty("function_call")
        @ExcludeMissing
        fun _functionCall(): JsonField<FunctionCall> = functionCall

        /**
         * Returns the raw JSON value of [functions].
         *
         * Unlike [functions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @Deprecated("deprecated")
        @JsonProperty("functions")
        @ExcludeMissing
        fun _functions(): JsonField<List<Function>> = functions

        /**
         * Returns the raw JSON value of [logitBias].
         *
         * Unlike [logitBias], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logit_bias")
        @ExcludeMissing
        fun _logitBias(): JsonField<LogitBias> = logitBias

        /**
         * Returns the raw JSON value of [logprobs].
         *
         * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<Boolean> = logprobs

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
         * Returns the raw JSON value of [maxTokens].
         *
         * Unlike [maxTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @Deprecated("deprecated")
        @JsonProperty("max_tokens")
        @ExcludeMissing
        fun _maxTokens(): JsonField<Long> = maxTokens

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [modalities].
         *
         * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("modalities")
        @ExcludeMissing
        fun _modalities(): JsonField<List<Modality>> = modalities

        /**
         * Returns the raw JSON value of [n].
         *
         * Unlike [n], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("n") @ExcludeMissing fun _n(): JsonField<Long> = n

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
         * Returns the raw JSON value of [prediction].
         *
         * Unlike [prediction], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prediction")
        @ExcludeMissing
        fun _prediction(): JsonField<ChatCompletionPredictionContent> = prediction

        /**
         * Returns the raw JSON value of [presencePenalty].
         *
         * Unlike [presencePenalty], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("presence_penalty")
        @ExcludeMissing
        fun _presencePenalty(): JsonField<Double> = presencePenalty

        /**
         * Returns the raw JSON value of [reasoningEffort].
         *
         * Unlike [reasoningEffort], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reasoning_effort")
        @ExcludeMissing
        fun _reasoningEffort(): JsonField<ReasoningEffort> = reasoningEffort

        /**
         * Returns the raw JSON value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<ResponseFormat> = responseFormat

        /**
         * Returns the raw JSON value of [seed].
         *
         * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

        /**
         * Returns the raw JSON value of [serviceTier].
         *
         * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("service_tier")
        @ExcludeMissing
        fun _serviceTier(): JsonField<ServiceTier> = serviceTier

        /**
         * Returns the raw JSON value of [stop].
         *
         * Unlike [stop], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stop") @ExcludeMissing fun _stop(): JsonField<Stop> = stop

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
        fun _streamOptions(): JsonField<ChatCompletionStreamOptions> = streamOptions

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [toolChoice].
         *
         * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_choice")
        @ExcludeMissing
        fun _toolChoice(): JsonField<ChatCompletionToolChoiceOption> = toolChoice

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools")
        @ExcludeMissing
        fun _tools(): JsonField<List<ChatCompletionTool>> = tools

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
         * Returns the raw JSON value of [user].
         *
         * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

        /**
         * Returns the raw JSON value of [webSearchOptions].
         *
         * Unlike [webSearchOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("web_search_options")
        @ExcludeMissing
        fun _webSearchOptions(): JsonField<WebSearchOptions> = webSearchOptions

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .messages()
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var messages: JsonField<MutableList<ChatCompletionMessageParam>>? = null
            private var model: JsonField<ChatModel>? = null
            private var audio: JsonField<ChatCompletionAudioParam> = JsonMissing.of()
            private var frequencyPenalty: JsonField<Double> = JsonMissing.of()
            private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
            private var functions: JsonField<MutableList<Function>>? = null
            private var logitBias: JsonField<LogitBias> = JsonMissing.of()
            private var logprobs: JsonField<Boolean> = JsonMissing.of()
            private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
            private var maxTokens: JsonField<Long> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var n: JsonField<Long> = JsonMissing.of()
            private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
            private var prediction: JsonField<ChatCompletionPredictionContent> = JsonMissing.of()
            private var presencePenalty: JsonField<Double> = JsonMissing.of()
            private var reasoningEffort: JsonField<ReasoningEffort> = JsonMissing.of()
            private var responseFormat: JsonField<ResponseFormat> = JsonMissing.of()
            private var seed: JsonField<Long> = JsonMissing.of()
            private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
            private var stop: JsonField<Stop> = JsonMissing.of()
            private var store: JsonField<Boolean> = JsonMissing.of()
            private var streamOptions: JsonField<ChatCompletionStreamOptions> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolChoice: JsonField<ChatCompletionToolChoiceOption> = JsonMissing.of()
            private var tools: JsonField<MutableList<ChatCompletionTool>>? = null
            private var topLogprobs: JsonField<Long> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var user: JsonField<String> = JsonMissing.of()
            private var webSearchOptions: JsonField<WebSearchOptions> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                messages = body.messages.map { it.toMutableList() }
                model = body.model
                audio = body.audio
                frequencyPenalty = body.frequencyPenalty
                functionCall = body.functionCall
                functions = body.functions.map { it.toMutableList() }
                logitBias = body.logitBias
                logprobs = body.logprobs
                maxCompletionTokens = body.maxCompletionTokens
                maxTokens = body.maxTokens
                metadata = body.metadata
                modalities = body.modalities.map { it.toMutableList() }
                n = body.n
                parallelToolCalls = body.parallelToolCalls
                prediction = body.prediction
                presencePenalty = body.presencePenalty
                reasoningEffort = body.reasoningEffort
                responseFormat = body.responseFormat
                seed = body.seed
                serviceTier = body.serviceTier
                stop = body.stop
                store = body.store
                streamOptions = body.streamOptions
                temperature = body.temperature
                toolChoice = body.toolChoice
                tools = body.tools.map { it.toMutableList() }
                topLogprobs = body.topLogprobs
                topP = body.topP
                user = body.user
                webSearchOptions = body.webSearchOptions
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * A list of messages comprising the conversation so far. Depending on the
             * [model](https://platform.openai.com/docs/models) you use, different message types
             * (modalities) are supported, like
             * [text](https://platform.openai.com/docs/guides/text-generation),
             * [images](https://platform.openai.com/docs/guides/vision), and
             * [audio](https://platform.openai.com/docs/guides/audio).
             */
            fun messages(messages: List<ChatCompletionMessageParam>) =
                messages(JsonField.of(messages))

            /**
             * Sets [Builder.messages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messages] with a well-typed
             * `List<ChatCompletionMessageParam>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun messages(messages: JsonField<List<ChatCompletionMessageParam>>) = apply {
                this.messages = messages.map { it.toMutableList() }
            }

            /**
             * Adds a single [ChatCompletionMessageParam] to [messages].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMessage(message: ChatCompletionMessageParam) = apply {
                messages =
                    (messages ?: JsonField.of(mutableListOf())).also {
                        checkKnown("messages", it).add(message)
                    }
            }

            /**
             * Alias for calling [addMessage] with
             * `ChatCompletionMessageParam.ofDeveloper(developer)`.
             */
            fun addMessage(developer: ChatCompletionDeveloperMessageParam) =
                addMessage(ChatCompletionMessageParam.ofDeveloper(developer))

            /**
             * Alias for calling [addMessage] with the following:
             * ```java
             * ChatCompletionDeveloperMessageParam.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun addDeveloperMessage(content: ChatCompletionDeveloperMessageParam.Content) =
                addMessage(ChatCompletionDeveloperMessageParam.builder().content(content).build())

            /**
             * Alias for calling [addDeveloperMessage] with
             * `ChatCompletionDeveloperMessageParam.Content.ofText(text)`.
             */
            fun addDeveloperMessage(text: String) =
                addDeveloperMessage(ChatCompletionDeveloperMessageParam.Content.ofText(text))

            /**
             * Alias for calling [addDeveloperMessage] with
             * `ChatCompletionDeveloperMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
             */
            fun addDeveloperMessageOfArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPartText>
            ) =
                addDeveloperMessage(
                    ChatCompletionDeveloperMessageParam.Content.ofArrayOfContentParts(
                        arrayOfContentParts
                    )
                )

            /**
             * Alias for calling [addMessage] with `ChatCompletionMessageParam.ofSystem(system)`.
             */
            fun addMessage(system: ChatCompletionSystemMessageParam) =
                addMessage(ChatCompletionMessageParam.ofSystem(system))

            /**
             * Alias for calling [addMessage] with the following:
             * ```java
             * ChatCompletionSystemMessageParam.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun addSystemMessage(content: ChatCompletionSystemMessageParam.Content) =
                addMessage(ChatCompletionSystemMessageParam.builder().content(content).build())

            /**
             * Alias for calling [addSystemMessage] with
             * `ChatCompletionSystemMessageParam.Content.ofText(text)`.
             */
            fun addSystemMessage(text: String) =
                addSystemMessage(ChatCompletionSystemMessageParam.Content.ofText(text))

            /**
             * Alias for calling [addSystemMessage] with
             * `ChatCompletionSystemMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
             */
            fun addSystemMessageOfArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPartText>
            ) =
                addSystemMessage(
                    ChatCompletionSystemMessageParam.Content.ofArrayOfContentParts(
                        arrayOfContentParts
                    )
                )

            /** Alias for calling [addMessage] with `ChatCompletionMessageParam.ofUser(user)`. */
            fun addMessage(user: ChatCompletionUserMessageParam) =
                addMessage(ChatCompletionMessageParam.ofUser(user))

            /**
             * Alias for calling [addMessage] with the following:
             * ```java
             * ChatCompletionUserMessageParam.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun addUserMessage(content: ChatCompletionUserMessageParam.Content) =
                addMessage(ChatCompletionUserMessageParam.builder().content(content).build())

            /**
             * Alias for calling [addUserMessage] with
             * `ChatCompletionUserMessageParam.Content.ofText(text)`.
             */
            fun addUserMessage(text: String) =
                addUserMessage(ChatCompletionUserMessageParam.Content.ofText(text))

            /**
             * Alias for calling [addUserMessage] with
             * `ChatCompletionUserMessageParam.Content.ofArrayOfContentParts(arrayOfContentParts)`.
             */
            fun addUserMessageOfArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPart>
            ) =
                addUserMessage(
                    ChatCompletionUserMessageParam.Content.ofArrayOfContentParts(
                        arrayOfContentParts
                    )
                )

            /**
             * Alias for calling [addMessage] with
             * `ChatCompletionMessageParam.ofAssistant(assistant)`.
             */
            fun addMessage(assistant: ChatCompletionAssistantMessageParam) =
                addMessage(ChatCompletionMessageParam.ofAssistant(assistant))

            /** Alias for calling [addMessage] with `assistant.toParam()`. */
            fun addMessage(assistant: ChatCompletionMessage) = addMessage(assistant.toParam())

            /** Alias for calling [addMessage] with `ChatCompletionMessageParam.ofTool(tool)`. */
            fun addMessage(tool: ChatCompletionToolMessageParam) =
                addMessage(ChatCompletionMessageParam.ofTool(tool))

            /**
             * Alias for calling [addMessage] with
             * `ChatCompletionMessageParam.ofFunction(function)`.
             */
            @Deprecated("deprecated")
            fun addMessage(function: ChatCompletionFunctionMessageParam) =
                addMessage(ChatCompletionMessageParam.ofFunction(function))

            /**
             * Model ID used to generate the response, like `gpt-4o` or `o1`. OpenAI offers a wide
             * range of models with different capabilities, performance characteristics, and price
             * points. Refer to the [model guide](https://platform.openai.com/docs/models) to browse
             * and compare available models.
             */
            fun model(model: ChatModel) = model(JsonField.of(model))

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
             * Parameters for audio output. Required when audio output is requested with
             * `modalities: ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
             */
            fun audio(audio: ChatCompletionAudioParam?) = audio(JsonField.ofNullable(audio))

            /** Alias for calling [Builder.audio] with `audio.orElse(null)`. */
            fun audio(audio: Optional<ChatCompletionAudioParam>) = audio(audio.getOrNull())

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [ChatCompletionAudioParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun audio(audio: JsonField<ChatCompletionAudioParam>) = apply { this.audio = audio }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on their
             * existing frequency in the text so far, decreasing the model's likelihood to repeat
             * the same line verbatim.
             */
            fun frequencyPenalty(frequencyPenalty: Double?) =
                frequencyPenalty(JsonField.ofNullable(frequencyPenalty))

            /**
             * Alias for [Builder.frequencyPenalty].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun frequencyPenalty(frequencyPenalty: Double) =
                frequencyPenalty(frequencyPenalty as Double?)

            /**
             * Alias for calling [Builder.frequencyPenalty] with `frequencyPenalty.orElse(null)`.
             */
            fun frequencyPenalty(frequencyPenalty: Optional<Double>) =
                frequencyPenalty(frequencyPenalty.getOrNull())

            /**
             * Sets [Builder.frequencyPenalty] to an arbitrary JSON value.
             *
             * You should usually call [Builder.frequencyPenalty] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun frequencyPenalty(frequencyPenalty: JsonField<Double>) = apply {
                this.frequencyPenalty = frequencyPenalty
            }

            /**
             * Deprecated in favor of `tool_choice`.
             *
             * Controls which (if any) function is called by the model.
             *
             * `none` means the model will not call a function and instead generates a message.
             *
             * `auto` means the model can pick between generating a message or calling a function.
             *
             * Specifying a particular function via `{"name": "my_function"}` forces the model to
             * call that function.
             *
             * `none` is the default when no functions are present. `auto` is the default if
             * functions are present.
             */
            @Deprecated("deprecated")
            fun functionCall(functionCall: FunctionCall) = functionCall(JsonField.of(functionCall))

            /**
             * Sets [Builder.functionCall] to an arbitrary JSON value.
             *
             * You should usually call [Builder.functionCall] with a well-typed [FunctionCall] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
            fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
                this.functionCall = functionCall
            }

            /** Alias for calling [functionCall] with `FunctionCall.ofMode(mode)`. */
            @Deprecated("deprecated")
            fun functionCall(mode: FunctionCall.FunctionCallMode) =
                functionCall(FunctionCall.ofMode(mode))

            /**
             * Alias for calling [functionCall] with
             * `FunctionCall.ofFunctionCallOption(functionCallOption)`.
             */
            @Deprecated("deprecated")
            fun functionCall(functionCallOption: ChatCompletionFunctionCallOption) =
                functionCall(FunctionCall.ofFunctionCallOption(functionCallOption))

            /**
             * Deprecated in favor of `tools`.
             *
             * A list of functions the model may generate JSON inputs for.
             */
            @Deprecated("deprecated")
            fun functions(functions: List<Function>) = functions(JsonField.of(functions))

            /**
             * Sets [Builder.functions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.functions] with a well-typed `List<Function>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
            fun functions(functions: JsonField<List<Function>>) = apply {
                this.functions = functions.map { it.toMutableList() }
            }

            /**
             * Adds a single [Function] to [functions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            @Deprecated("deprecated")
            fun addFunction(function: Function) = apply {
                functions =
                    (functions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("functions", it).add(function)
                    }
            }

            /**
             * Modify the likelihood of specified tokens appearing in the completion.
             *
             * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer)
             * to an associated bias value from -100 to 100. Mathematically, the bias is added to
             * the logits generated by the model prior to sampling. The exact effect will vary per
             * model, but values between -1 and 1 should decrease or increase likelihood of
             * selection; values like -100 or 100 should result in a ban or exclusive selection of
             * the relevant token.
             */
            fun logitBias(logitBias: LogitBias?) = logitBias(JsonField.ofNullable(logitBias))

            /** Alias for calling [Builder.logitBias] with `logitBias.orElse(null)`. */
            fun logitBias(logitBias: Optional<LogitBias>) = logitBias(logitBias.getOrNull())

            /**
             * Sets [Builder.logitBias] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logitBias] with a well-typed [LogitBias] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logitBias(logitBias: JsonField<LogitBias>) = apply { this.logitBias = logitBias }

            /**
             * Whether to return log probabilities of the output tokens or not. If true, returns the
             * log probabilities of each output token returned in the `content` of `message`.
             */
            fun logprobs(logprobs: Boolean?) = logprobs(JsonField.ofNullable(logprobs))

            /**
             * Alias for [Builder.logprobs].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun logprobs(logprobs: Boolean) = logprobs(logprobs as Boolean?)

            /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
            fun logprobs(logprobs: Optional<Boolean>) = logprobs(logprobs.getOrNull())

            /**
             * Sets [Builder.logprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprobs] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logprobs(logprobs: JsonField<Boolean>) = apply { this.logprobs = logprobs }

            /**
             * An upper bound for the number of tokens that can be generated for a completion,
             * including visible output tokens and
             * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
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
             * The maximum number of [tokens](/tokenizer) that can be generated in the chat
             * completion. This value can be used to control
             * [costs](https://openai.com/api/pricing/) for text generated via API.
             *
             * This value is now deprecated in favor of `max_completion_tokens`, and is not
             * compatible with
             * [o1 series models](https://platform.openai.com/docs/guides/reasoning).
             */
            @Deprecated("deprecated")
            fun maxTokens(maxTokens: Long?) = maxTokens(JsonField.ofNullable(maxTokens))

            /**
             * Alias for [Builder.maxTokens].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            @Deprecated("deprecated") fun maxTokens(maxTokens: Long) = maxTokens(maxTokens as Long?)

            /** Alias for calling [Builder.maxTokens] with `maxTokens.orElse(null)`. */
            @Deprecated("deprecated")
            fun maxTokens(maxTokens: Optional<Long>) = maxTokens(maxTokens.getOrNull())

            /**
             * Sets [Builder.maxTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            @Deprecated("deprecated")
            fun maxTokens(maxTokens: JsonField<Long>) = apply { this.maxTokens = maxTokens }

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
             * Output types that you would like the model to generate. Most models are capable of
             * generating text, which is the default:
             *
             * `["text"]`
             *
             * The `gpt-4o-audio-preview` model can also be used to
             * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
             * model generate both text and audio responses, you can use:
             *
             * `["text", "audio"]`
             */
            fun modalities(modalities: List<Modality>?) =
                modalities(JsonField.ofNullable(modalities))

            /** Alias for calling [Builder.modalities] with `modalities.orElse(null)`. */
            fun modalities(modalities: Optional<List<Modality>>) =
                modalities(modalities.getOrNull())

            /**
             * Sets [Builder.modalities] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modalities] with a well-typed `List<Modality>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun modalities(modalities: JsonField<List<Modality>>) = apply {
                this.modalities = modalities.map { it.toMutableList() }
            }

            /**
             * Adds a single [Modality] to [modalities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addModality(modality: Modality) = apply {
                modalities =
                    (modalities ?: JsonField.of(mutableListOf())).also {
                        checkKnown("modalities", it).add(modality)
                    }
            }

            /**
             * How many chat completion choices to generate for each input message. Note that you
             * will be charged based on the number of generated tokens across all of the choices.
             * Keep `n` as `1` to minimize costs.
             */
            fun n(n: Long?) = n(JsonField.ofNullable(n))

            /**
             * Alias for [Builder.n].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun n(n: Long) = n(n as Long?)

            /** Alias for calling [Builder.n] with `n.orElse(null)`. */
            fun n(n: Optional<Long>) = n(n.getOrNull())

            /**
             * Sets [Builder.n] to an arbitrary JSON value.
             *
             * You should usually call [Builder.n] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun n(n: JsonField<Long>) = apply { this.n = n }

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
             * Static predicted output content, such as the content of a text file that is being
             * regenerated.
             */
            fun prediction(prediction: ChatCompletionPredictionContent?) =
                prediction(JsonField.ofNullable(prediction))

            /** Alias for calling [Builder.prediction] with `prediction.orElse(null)`. */
            fun prediction(prediction: Optional<ChatCompletionPredictionContent>) =
                prediction(prediction.getOrNull())

            /**
             * Sets [Builder.prediction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prediction] with a well-typed
             * [ChatCompletionPredictionContent] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun prediction(prediction: JsonField<ChatCompletionPredictionContent>) = apply {
                this.prediction = prediction
            }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether
             * they appear in the text so far, increasing the model's likelihood to talk about new
             * topics.
             */
            fun presencePenalty(presencePenalty: Double?) =
                presencePenalty(JsonField.ofNullable(presencePenalty))

            /**
             * Alias for [Builder.presencePenalty].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun presencePenalty(presencePenalty: Double) =
                presencePenalty(presencePenalty as Double?)

            /** Alias for calling [Builder.presencePenalty] with `presencePenalty.orElse(null)`. */
            fun presencePenalty(presencePenalty: Optional<Double>) =
                presencePenalty(presencePenalty.getOrNull())

            /**
             * Sets [Builder.presencePenalty] to an arbitrary JSON value.
             *
             * You should usually call [Builder.presencePenalty] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun presencePenalty(presencePenalty: JsonField<Double>) = apply {
                this.presencePenalty = presencePenalty
            }

            /**
             * **o-series models only**
             *
             * Constrains effort on reasoning for
             * [reasoning models](https://platform.openai.com/docs/guides/reasoning). Currently
             * supported values are `low`, `medium`, and `high`. Reducing reasoning effort can
             * result in faster responses and fewer tokens used on reasoning in a response.
             */
            fun reasoningEffort(reasoningEffort: ReasoningEffort?) =
                reasoningEffort(JsonField.ofNullable(reasoningEffort))

            /** Alias for calling [Builder.reasoningEffort] with `reasoningEffort.orElse(null)`. */
            fun reasoningEffort(reasoningEffort: Optional<ReasoningEffort>) =
                reasoningEffort(reasoningEffort.getOrNull())

            /**
             * Sets [Builder.reasoningEffort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoningEffort] with a well-typed [ReasoningEffort]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun reasoningEffort(reasoningEffort: JsonField<ReasoningEffort>) = apply {
                this.reasoningEffort = reasoningEffort
            }

            /**
             * An object specifying the format that the model must output.
             *
             * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured
             * Outputs which ensures the model will match your supplied JSON schema. Learn more in
             * the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
             *
             * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the
             * message the model generates is valid JSON. Using `json_schema` is preferred for
             * models that support it.
             */
            fun responseFormat(responseFormat: ResponseFormat) =
                responseFormat(JsonField.of(responseFormat))

            /**
             * Sets [Builder.responseFormat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /** Alias for calling [responseFormat] with `ResponseFormat.ofText(text)`. */
            fun responseFormat(text: ResponseFormatText) =
                responseFormat(ResponseFormat.ofText(text))

            /**
             * Alias for calling [responseFormat] with `ResponseFormat.ofJsonSchema(jsonSchema)`.
             */
            fun responseFormat(jsonSchema: ResponseFormatJsonSchema) =
                responseFormat(ResponseFormat.ofJsonSchema(jsonSchema))

            /**
             * Alias for calling [responseFormat] with `ResponseFormat.ofJsonObject(jsonObject)`.
             */
            fun responseFormat(jsonObject: ResponseFormatJsonObject) =
                responseFormat(ResponseFormat.ofJsonObject(jsonObject))

            /**
             * This feature is in Beta. If specified, our system will make a best effort to sample
             * deterministically, such that repeated requests with the same `seed` and parameters
             * should return the same result. Determinism is not guaranteed, and you should refer to
             * the `system_fingerprint` response parameter to monitor changes in the backend.
             */
            fun seed(seed: Long?) = seed(JsonField.ofNullable(seed))

            /**
             * Alias for [Builder.seed].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun seed(seed: Long) = seed(seed as Long?)

            /** Alias for calling [Builder.seed] with `seed.orElse(null)`. */
            fun seed(seed: Optional<Long>) = seed(seed.getOrNull())

            /**
             * Sets [Builder.seed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

            /**
             * Specifies the latency tier to use for processing the request. This parameter is
             * relevant for customers subscribed to the scale tier service:
             * - If set to 'auto', and the Project is Scale tier enabled, the system will utilize
             *   scale tier credits until they are exhausted.
             * - If set to 'auto', and the Project is not Scale tier enabled, the request will be
             *   processed using the default service tier with a lower uptime SLA and no latency
             *   guarentee.
             * - If set to 'default', the request will be processed using the default service tier
             *   with a lower uptime SLA and no latency guarentee.
             * - When not set, the default behavior is 'auto'.
             *
             * When this parameter is set, the response body will include the `service_tier`
             * utilized.
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

            /**
             * Up to 4 sequences where the API will stop generating further tokens. The returned
             * text will not contain the stop sequence.
             */
            fun stop(stop: Stop?) = stop(JsonField.ofNullable(stop))

            /** Alias for calling [Builder.stop] with `stop.orElse(null)`. */
            fun stop(stop: Optional<Stop>) = stop(stop.getOrNull())

            /**
             * Sets [Builder.stop] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stop] with a well-typed [Stop] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun stop(stop: JsonField<Stop>) = apply { this.stop = stop }

            /** Alias for calling [stop] with `Stop.ofString(string)`. */
            fun stop(string: String) = stop(Stop.ofString(string))

            /** Alias for calling [stop] with `Stop.ofStrings(strings)`. */
            fun stopOfStrings(strings: List<String>) = stop(Stop.ofStrings(strings))

            /**
             * Whether or not to store the output of this chat completion request for use in our
             * [model distillation](https://platform.openai.com/docs/guides/distillation) or
             * [evals](https://platform.openai.com/docs/guides/evals) products.
             */
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

            /** Options for streaming response. Only set this when you set `stream: true`. */
            fun streamOptions(streamOptions: ChatCompletionStreamOptions?) =
                streamOptions(JsonField.ofNullable(streamOptions))

            /** Alias for calling [Builder.streamOptions] with `streamOptions.orElse(null)`. */
            fun streamOptions(streamOptions: Optional<ChatCompletionStreamOptions>) =
                streamOptions(streamOptions.getOrNull())

            /**
             * Sets [Builder.streamOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streamOptions] with a well-typed
             * [ChatCompletionStreamOptions] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun streamOptions(streamOptions: JsonField<ChatCompletionStreamOptions>) = apply {
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
             * Controls which (if any) tool is called by the model. `none` means the model will not
             * call any tool and instead generates a message. `auto` means the model can pick
             * between generating a message or calling one or more tools. `required` means the model
             * must call one or more tools. Specifying a particular tool via `{"type": "function",
             * "function": {"name": "my_function"}}` forces the model to call that tool.
             *
             * `none` is the default when no tools are present. `auto` is the default if tools are
             * present.
             */
            fun toolChoice(toolChoice: ChatCompletionToolChoiceOption) =
                toolChoice(JsonField.of(toolChoice))

            /**
             * Sets [Builder.toolChoice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolChoice] with a well-typed
             * [ChatCompletionToolChoiceOption] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun toolChoice(toolChoice: JsonField<ChatCompletionToolChoiceOption>) = apply {
                this.toolChoice = toolChoice
            }

            /**
             * Alias for calling [toolChoice] with `ChatCompletionToolChoiceOption.ofAuto(auto)`.
             */
            fun toolChoice(auto: ChatCompletionToolChoiceOption.Auto) =
                toolChoice(ChatCompletionToolChoiceOption.ofAuto(auto))

            /**
             * Alias for calling [toolChoice] with
             * `ChatCompletionToolChoiceOption.ofNamedToolChoice(namedToolChoice)`.
             */
            fun toolChoice(namedToolChoice: ChatCompletionNamedToolChoice) =
                toolChoice(ChatCompletionToolChoiceOption.ofNamedToolChoice(namedToolChoice))

            /**
             * A list of tools the model may call. Currently, only functions are supported as a
             * tool. Use this to provide a list of functions the model may generate JSON inputs for.
             * A max of 128 functions are supported.
             */
            fun tools(tools: List<ChatCompletionTool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<ChatCompletionTool>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun tools(tools: JsonField<List<ChatCompletionTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [ChatCompletionTool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: ChatCompletionTool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /**
             * An integer between 0 and 20 specifying the number of most likely tokens to return at
             * each token position, each with an associated log probability. `logprobs` must be set
             * to `true` if this parameter is used.
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
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            fun user(user: String) = user(JsonField.of(user))

            /**
             * Sets [Builder.user] to an arbitrary JSON value.
             *
             * You should usually call [Builder.user] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun user(user: JsonField<String>) = apply { this.user = user }

            /**
             * This tool searches the web for relevant results to use in a response. Learn more
             * about the
             * [web search tool](https://platform.openai.com/docs/guides/tools-web-search?api-mode=chat).
             */
            fun webSearchOptions(webSearchOptions: WebSearchOptions) =
                webSearchOptions(JsonField.of(webSearchOptions))

            /**
             * Sets [Builder.webSearchOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webSearchOptions] with a well-typed
             * [WebSearchOptions] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun webSearchOptions(webSearchOptions: JsonField<WebSearchOptions>) = apply {
                this.webSearchOptions = webSearchOptions
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
             * .messages()
             * .model()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("messages", messages).map { it.toImmutable() },
                    checkRequired("model", model),
                    audio,
                    frequencyPenalty,
                    functionCall,
                    (functions ?: JsonMissing.of()).map { it.toImmutable() },
                    logitBias,
                    logprobs,
                    maxCompletionTokens,
                    maxTokens,
                    metadata,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    n,
                    parallelToolCalls,
                    prediction,
                    presencePenalty,
                    reasoningEffort,
                    responseFormat,
                    seed,
                    serviceTier,
                    stop,
                    store,
                    streamOptions,
                    temperature,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    topLogprobs,
                    topP,
                    user,
                    webSearchOptions,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            messages().forEach { it.validate() }
            model()
            audio().ifPresent { it.validate() }
            frequencyPenalty()
            functionCall().ifPresent { it.validate() }
            functions().ifPresent { it.forEach { it.validate() } }
            logitBias().ifPresent { it.validate() }
            logprobs()
            maxCompletionTokens()
            maxTokens()
            metadata().ifPresent { it.validate() }
            modalities()
            n()
            parallelToolCalls()
            prediction().ifPresent { it.validate() }
            presencePenalty()
            reasoningEffort()
            responseFormat().ifPresent { it.validate() }
            seed()
            serviceTier()
            stop().ifPresent { it.validate() }
            store()
            streamOptions().ifPresent { it.validate() }
            temperature()
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
            topLogprobs()
            topP()
            user()
            webSearchOptions().ifPresent { it.validate() }
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && messages == other.messages && model == other.model && audio == other.audio && frequencyPenalty == other.frequencyPenalty && functionCall == other.functionCall && functions == other.functions && logitBias == other.logitBias && logprobs == other.logprobs && maxCompletionTokens == other.maxCompletionTokens && maxTokens == other.maxTokens && metadata == other.metadata && modalities == other.modalities && n == other.n && parallelToolCalls == other.parallelToolCalls && prediction == other.prediction && presencePenalty == other.presencePenalty && reasoningEffort == other.reasoningEffort && responseFormat == other.responseFormat && seed == other.seed && serviceTier == other.serviceTier && stop == other.stop && store == other.store && streamOptions == other.streamOptions && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && topLogprobs == other.topLogprobs && topP == other.topP && user == other.user && webSearchOptions == other.webSearchOptions && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messages, model, audio, frequencyPenalty, functionCall, functions, logitBias, logprobs, maxCompletionTokens, maxTokens, metadata, modalities, n, parallelToolCalls, prediction, presencePenalty, reasoningEffort, responseFormat, seed, serviceTier, stop, store, streamOptions, temperature, toolChoice, tools, topLogprobs, topP, user, webSearchOptions, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{messages=$messages, model=$model, audio=$audio, frequencyPenalty=$frequencyPenalty, functionCall=$functionCall, functions=$functions, logitBias=$logitBias, logprobs=$logprobs, maxCompletionTokens=$maxCompletionTokens, maxTokens=$maxTokens, metadata=$metadata, modalities=$modalities, n=$n, parallelToolCalls=$parallelToolCalls, prediction=$prediction, presencePenalty=$presencePenalty, reasoningEffort=$reasoningEffort, responseFormat=$responseFormat, seed=$seed, serviceTier=$serviceTier, stop=$stop, store=$store, streamOptions=$streamOptions, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topLogprobs=$topLogprobs, topP=$topP, user=$user, webSearchOptions=$webSearchOptions, additionalProperties=$additionalProperties}"
    }

    /**
     * Deprecated in favor of `tool_choice`.
     *
     * Controls which (if any) function is called by the model.
     *
     * `none` means the model will not call a function and instead generates a message.
     *
     * `auto` means the model can pick between generating a message or calling a function.
     *
     * Specifying a particular function via `{"name": "my_function"}` forces the model to call that
     * function.
     *
     * `none` is the default when no functions are present. `auto` is the default if functions are
     * present.
     */
    @Deprecated("deprecated")
    @JsonDeserialize(using = FunctionCall.Deserializer::class)
    @JsonSerialize(using = FunctionCall.Serializer::class)
    class FunctionCall
    private constructor(
        private val mode: FunctionCallMode? = null,
        private val functionCallOption: ChatCompletionFunctionCallOption? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * `none` means the model will not call a function and instead generates a message. `auto`
         * means the model can pick between generating a message or calling a function.
         */
        fun mode(): Optional<FunctionCallMode> = Optional.ofNullable(mode)

        /**
         * Specifying a particular function via `{"name": "my_function"}` forces the model to call
         * that function.
         */
        fun functionCallOption(): Optional<ChatCompletionFunctionCallOption> =
            Optional.ofNullable(functionCallOption)

        fun isMode(): Boolean = mode != null

        fun isFunctionCallOption(): Boolean = functionCallOption != null

        /**
         * `none` means the model will not call a function and instead generates a message. `auto`
         * means the model can pick between generating a message or calling a function.
         */
        fun asMode(): FunctionCallMode = mode.getOrThrow("mode")

        /**
         * Specifying a particular function via `{"name": "my_function"}` forces the model to call
         * that function.
         */
        fun asFunctionCallOption(): ChatCompletionFunctionCallOption =
            functionCallOption.getOrThrow("functionCallOption")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                mode != null -> visitor.visitMode(mode)
                functionCallOption != null -> visitor.visitFunctionCallOption(functionCallOption)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): FunctionCall = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMode(mode: FunctionCallMode) {}

                    override fun visitFunctionCallOption(
                        functionCallOption: ChatCompletionFunctionCallOption
                    ) {
                        functionCallOption.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FunctionCall && mode == other.mode && functionCallOption == other.functionCallOption /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(mode, functionCallOption) /* spotless:on */

        override fun toString(): String =
            when {
                mode != null -> "FunctionCall{mode=$mode}"
                functionCallOption != null -> "FunctionCall{functionCallOption=$functionCallOption}"
                _json != null -> "FunctionCall{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FunctionCall")
            }

        companion object {

            /**
             * `none` means the model will not call a function and instead generates a message.
             * `auto` means the model can pick between generating a message or calling a function.
             */
            @JvmStatic fun ofMode(mode: FunctionCallMode) = FunctionCall(mode = mode)

            /**
             * Specifying a particular function via `{"name": "my_function"}` forces the model to
             * call that function.
             */
            @JvmStatic
            fun ofFunctionCallOption(functionCallOption: ChatCompletionFunctionCallOption) =
                FunctionCall(functionCallOption = functionCallOption)
        }

        /**
         * An interface that defines how to map each variant of [FunctionCall] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /**
             * `none` means the model will not call a function and instead generates a message.
             * `auto` means the model can pick between generating a message or calling a function.
             */
            fun visitMode(mode: FunctionCallMode): T

            /**
             * Specifying a particular function via `{"name": "my_function"}` forces the model to
             * call that function.
             */
            fun visitFunctionCallOption(functionCallOption: ChatCompletionFunctionCallOption): T

            /**
             * Maps an unknown variant of [FunctionCall] to a value of type [T].
             *
             * An instance of [FunctionCall] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown FunctionCall: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<FunctionCall>(FunctionCall::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FunctionCall {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<FunctionCallMode>())?.let {
                    return FunctionCall(mode = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionCallOption>()) {
                        it.validate()
                    }
                    ?.let {
                        return FunctionCall(functionCallOption = it, _json = json)
                    }

                return FunctionCall(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<FunctionCall>(FunctionCall::class) {

            override fun serialize(
                value: FunctionCall,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.mode != null -> generator.writeObject(value.mode)
                    value.functionCallOption != null ->
                        generator.writeObject(value.functionCallOption)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FunctionCall")
                }
            }
        }

        /**
         * `none` means the model will not call a function and instead generates a message. `auto`
         * means the model can pick between generating a message or calling a function.
         */
        class FunctionCallMode
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

                @JvmField val NONE = of("none")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = FunctionCallMode(JsonField.of(value))
            }

            /** An enum containing [FunctionCallMode]'s known values. */
            enum class Known {
                NONE,
                AUTO,
            }

            /**
             * An enum containing [FunctionCallMode]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [FunctionCallMode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NONE,
                AUTO,
                /**
                 * An enum member indicating that [FunctionCallMode] was instantiated with an
                 * unknown value.
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
                    AUTO -> Value.AUTO
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
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown FunctionCallMode: $value")
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

                return /* spotless:off */ other is FunctionCallMode && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    @Deprecated("deprecated")
    class Function
    private constructor(
        private val name: JsonField<String>,
        private val description: JsonField<String>,
        private val parameters: JsonField<FunctionParameters>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parameters")
            @ExcludeMissing
            parameters: JsonField<FunctionParameters> = JsonMissing.of(),
        ) : this(name, description, parameters, mutableMapOf())

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parameters(): Optional<FunctionParameters> =
            Optional.ofNullable(parameters.getNullable("parameters"))

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [parameters].
         *
         * Unlike [parameters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parameters")
        @ExcludeMissing
        fun _parameters(): JsonField<FunctionParameters> = parameters

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
             * Returns a mutable builder for constructing an instance of [Function].
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Function]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var description: JsonField<String> = JsonMissing.of()
            private var parameters: JsonField<FunctionParameters> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                name = function.name
                description = function.description
                parameters = function.parameters
                additionalProperties = function.additionalProperties.toMutableMap()
            }

            /**
             * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores
             * and dashes, with a maximum length of 64.
             */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * A description of what the function does, used by the model to choose when and how to
             * call the function.
             */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * The parameters the functions accepts, described as a JSON Schema object. See the
             * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and
             * the [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
             * documentation about the format.
             *
             * Omitting `parameters` defines a function with an empty parameter list.
             */
            fun parameters(parameters: FunctionParameters) = parameters(JsonField.of(parameters))

            /**
             * Sets [Builder.parameters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parameters] with a well-typed [FunctionParameters]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun parameters(parameters: JsonField<FunctionParameters>) = apply {
                this.parameters = parameters
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
             * Returns an immutable instance of [Function].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Function =
                Function(
                    checkRequired("name", name),
                    description,
                    parameters,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Function = apply {
            if (validated) {
                return@apply
            }

            name()
            description()
            parameters().ifPresent { it.validate() }
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && name == other.name && description == other.description && parameters == other.parameters && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(name, description, parameters, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{name=$name, description=$description, parameters=$parameters, additionalProperties=$additionalProperties}"
    }

    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     *
     * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to an
     * associated bias value from -100 to 100. Mathematically, the bias is added to the logits
     * generated by the model prior to sampling. The exact effect will vary per model, but values
     * between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100
     * should result in a ban or exclusive selection of the relevant token.
     */
    class LogitBias
    private constructor(private val additionalProperties: MutableMap<String, JsonValue>) {

        @JsonCreator private constructor() : this(mutableMapOf())

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

            /** Returns a mutable builder for constructing an instance of [LogitBias]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LogitBias]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logitBias: LogitBias) = apply {
                additionalProperties = logitBias.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [LogitBias].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): LogitBias = LogitBias(additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): LogitBias = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is LogitBias && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "LogitBias{additionalProperties=$additionalProperties}"
    }

    class Modality @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val TEXT = of("text")

            @JvmField val AUDIO = of("audio")

            @JvmStatic fun of(value: String) = Modality(JsonField.of(value))
        }

        /** An enum containing [Modality]'s known values. */
        enum class Known {
            TEXT,
            AUDIO,
        }

        /**
         * An enum containing [Modality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Modality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TEXT,
            AUDIO,
            /** An enum member indicating that [Modality] was instantiated with an unknown value. */
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
                TEXT -> Value.TEXT
                AUDIO -> Value.AUDIO
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
                TEXT -> Known.TEXT
                AUDIO -> Known.AUDIO
                else -> throw OpenAIInvalidDataException("Unknown Modality: $value")
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

            return /* spotless:off */ other is Modality && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * An object specifying the format that the model must output.
     *
     * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
     * ensures the model will match your supplied JSON schema. Learn more in the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the message
     * the model generates is valid JSON. Using `json_schema` is preferred for models that support
     * it.
     */
    @JsonDeserialize(using = ResponseFormat.Deserializer::class)
    @JsonSerialize(using = ResponseFormat.Serializer::class)
    class ResponseFormat
    private constructor(
        private val text: ResponseFormatText? = null,
        private val jsonSchema: ResponseFormatJsonSchema? = null,
        private val jsonObject: ResponseFormatJsonObject? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Default response format. Used to generate text responses. */
        fun text(): Optional<ResponseFormatText> = Optional.ofNullable(text)

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun jsonSchema(): Optional<ResponseFormatJsonSchema> = Optional.ofNullable(jsonSchema)

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        fun jsonObject(): Optional<ResponseFormatJsonObject> = Optional.ofNullable(jsonObject)

        fun isText(): Boolean = text != null

        fun isJsonSchema(): Boolean = jsonSchema != null

        fun isJsonObject(): Boolean = jsonObject != null

        /** Default response format. Used to generate text responses. */
        fun asText(): ResponseFormatText = text.getOrThrow("text")

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun asJsonSchema(): ResponseFormatJsonSchema = jsonSchema.getOrThrow("jsonSchema")

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        fun asJsonObject(): ResponseFormatJsonObject = jsonObject.getOrThrow("jsonObject")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                text != null -> visitor.visitText(text)
                jsonSchema != null -> visitor.visitJsonSchema(jsonSchema)
                jsonObject != null -> visitor.visitJsonObject(jsonObject)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): ResponseFormat = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitText(text: ResponseFormatText) {
                        text.validate()
                    }

                    override fun visitJsonSchema(jsonSchema: ResponseFormatJsonSchema) {
                        jsonSchema.validate()
                    }

                    override fun visitJsonObject(jsonObject: ResponseFormatJsonObject) {
                        jsonObject.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && text == other.text && jsonSchema == other.jsonSchema && jsonObject == other.jsonObject /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, jsonSchema, jsonObject) /* spotless:on */

        override fun toString(): String =
            when {
                text != null -> "ResponseFormat{text=$text}"
                jsonSchema != null -> "ResponseFormat{jsonSchema=$jsonSchema}"
                jsonObject != null -> "ResponseFormat{jsonObject=$jsonObject}"
                _json != null -> "ResponseFormat{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ResponseFormat")
            }

        companion object {

            /** Default response format. Used to generate text responses. */
            @JvmStatic fun ofText(text: ResponseFormatText) = ResponseFormat(text = text)

            /**
             * JSON Schema response format. Used to generate structured JSON responses. Learn more
             * about
             * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
             */
            @JvmStatic
            fun ofJsonSchema(jsonSchema: ResponseFormatJsonSchema) =
                ResponseFormat(jsonSchema = jsonSchema)

            /**
             * JSON object response format. An older method of generating JSON responses. Using
             * `json_schema` is recommended for models that support it. Note that the model will not
             * generate JSON without a system or user message instructing it to do so.
             */
            @JvmStatic
            fun ofJsonObject(jsonObject: ResponseFormatJsonObject) =
                ResponseFormat(jsonObject = jsonObject)
        }

        /**
         * An interface that defines how to map each variant of [ResponseFormat] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** Default response format. Used to generate text responses. */
            fun visitText(text: ResponseFormatText): T

            /**
             * JSON Schema response format. Used to generate structured JSON responses. Learn more
             * about
             * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
             */
            fun visitJsonSchema(jsonSchema: ResponseFormatJsonSchema): T

            /**
             * JSON object response format. An older method of generating JSON responses. Using
             * `json_schema` is recommended for models that support it. Note that the model will not
             * generate JSON without a system or user message instructing it to do so.
             */
            fun visitJsonObject(jsonObject: ResponseFormatJsonObject): T

            /**
             * Maps an unknown variant of [ResponseFormat] to a value of type [T].
             *
             * An instance of [ResponseFormat] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ResponseFormat: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<ResponseFormat>(ResponseFormat::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ResponseFormat {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<ResponseFormatText>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(text = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonSchema>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(jsonSchema = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonObject>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(jsonObject = it, _json = json)
                    }

                return ResponseFormat(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<ResponseFormat>(ResponseFormat::class) {

            override fun serialize(
                value: ResponseFormat,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.text != null -> generator.writeObject(value.text)
                    value.jsonSchema != null -> generator.writeObject(value.jsonSchema)
                    value.jsonObject != null -> generator.writeObject(value.jsonObject)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ResponseFormat")
                }
            }
        }
    }

    /**
     * Specifies the latency tier to use for processing the request. This parameter is relevant for
     * customers subscribed to the scale tier service:
     * - If set to 'auto', and the Project is Scale tier enabled, the system will utilize scale tier
     *   credits until they are exhausted.
     * - If set to 'auto', and the Project is not Scale tier enabled, the request will be processed
     *   using the default service tier with a lower uptime SLA and no latency guarentee.
     * - If set to 'default', the request will be processed using the default service tier with a
     *   lower uptime SLA and no latency guarentee.
     * - When not set, the default behavior is 'auto'.
     *
     * When this parameter is set, the response body will include the `service_tier` utilized.
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

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        enum class Known {
            AUTO,
            DEFAULT,
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
     * Up to 4 sequences where the API will stop generating further tokens. The returned text will
     * not contain the stop sequence.
     */
    @JsonDeserialize(using = Stop.Deserializer::class)
    @JsonSerialize(using = Stop.Serializer::class)
    class Stop
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Stop = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitStrings(strings: List<String>) {}
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Stop && string == other.string && strings == other.strings /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, strings) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Stop{string=$string}"
                strings != null -> "Stop{strings=$strings}"
                _json != null -> "Stop{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Stop")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Stop(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Stop(strings = strings)
        }

        /** An interface that defines how to map each variant of [Stop] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [Stop] to a value of type [T].
             *
             * An instance of [Stop] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Stop: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Stop>(Stop::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Stop {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Stop(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Stop(strings = it, _json = json)
                }

                return Stop(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Stop>(Stop::class) {

            override fun serialize(
                value: Stop,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Stop")
                }
            }
        }
    }

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search?api-mode=chat).
     */
    class WebSearchOptions
    private constructor(
        private val searchContextSize: JsonField<SearchContextSize>,
        private val userLocation: JsonField<UserLocation>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("search_context_size")
            @ExcludeMissing
            searchContextSize: JsonField<SearchContextSize> = JsonMissing.of(),
            @JsonProperty("user_location")
            @ExcludeMissing
            userLocation: JsonField<UserLocation> = JsonMissing.of(),
        ) : this(searchContextSize, userLocation, mutableMapOf())

        /**
         * High level guidance for the amount of context window space to use for the search. One of
         * `low`, `medium`, or `high`. `medium` is the default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun searchContextSize(): Optional<SearchContextSize> =
            Optional.ofNullable(searchContextSize.getNullable("search_context_size"))

        /**
         * Approximate location parameters for the search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun userLocation(): Optional<UserLocation> =
            Optional.ofNullable(userLocation.getNullable("user_location"))

        /**
         * Returns the raw JSON value of [searchContextSize].
         *
         * Unlike [searchContextSize], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("search_context_size")
        @ExcludeMissing
        fun _searchContextSize(): JsonField<SearchContextSize> = searchContextSize

        /**
         * Returns the raw JSON value of [userLocation].
         *
         * Unlike [userLocation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("user_location")
        @ExcludeMissing
        fun _userLocation(): JsonField<UserLocation> = userLocation

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

            /** Returns a mutable builder for constructing an instance of [WebSearchOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WebSearchOptions]. */
        class Builder internal constructor() {

            private var searchContextSize: JsonField<SearchContextSize> = JsonMissing.of()
            private var userLocation: JsonField<UserLocation> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webSearchOptions: WebSearchOptions) = apply {
                searchContextSize = webSearchOptions.searchContextSize
                userLocation = webSearchOptions.userLocation
                additionalProperties = webSearchOptions.additionalProperties.toMutableMap()
            }

            /**
             * High level guidance for the amount of context window space to use for the search. One
             * of `low`, `medium`, or `high`. `medium` is the default.
             */
            fun searchContextSize(searchContextSize: SearchContextSize) =
                searchContextSize(JsonField.of(searchContextSize))

            /**
             * Sets [Builder.searchContextSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.searchContextSize] with a well-typed
             * [SearchContextSize] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun searchContextSize(searchContextSize: JsonField<SearchContextSize>) = apply {
                this.searchContextSize = searchContextSize
            }

            /** Approximate location parameters for the search. */
            fun userLocation(userLocation: UserLocation?) =
                userLocation(JsonField.ofNullable(userLocation))

            /** Alias for calling [Builder.userLocation] with `userLocation.orElse(null)`. */
            fun userLocation(userLocation: Optional<UserLocation>) =
                userLocation(userLocation.getOrNull())

            /**
             * Sets [Builder.userLocation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userLocation] with a well-typed [UserLocation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userLocation(userLocation: JsonField<UserLocation>) = apply {
                this.userLocation = userLocation
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
             * Returns an immutable instance of [WebSearchOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): WebSearchOptions =
                WebSearchOptions(
                    searchContextSize,
                    userLocation,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WebSearchOptions = apply {
            if (validated) {
                return@apply
            }

            searchContextSize()
            userLocation().ifPresent { it.validate() }
            validated = true
        }

        /**
         * High level guidance for the amount of context window space to use for the search. One of
         * `low`, `medium`, or `high`. `medium` is the default.
         */
        class SearchContextSize
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

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmStatic fun of(value: String) = SearchContextSize(JsonField.of(value))
            }

            /** An enum containing [SearchContextSize]'s known values. */
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
            }

            /**
             * An enum containing [SearchContextSize]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [SearchContextSize] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                LOW,
                MEDIUM,
                HIGH,
                /**
                 * An enum member indicating that [SearchContextSize] was instantiated with an
                 * unknown value.
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
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
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
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    else -> throw OpenAIInvalidDataException("Unknown SearchContextSize: $value")
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

                return /* spotless:off */ other is SearchContextSize && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Approximate location parameters for the search. */
        class UserLocation
        private constructor(
            private val approximate: JsonField<Approximate>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("approximate")
                @ExcludeMissing
                approximate: JsonField<Approximate> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(approximate, type, mutableMapOf())

            /**
             * Approximate location parameters for the search.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun approximate(): Approximate = approximate.getRequired("approximate")

            /**
             * The type of location approximation. Always `approximate`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("approximate")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [approximate].
             *
             * Unlike [approximate], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("approximate")
            @ExcludeMissing
            fun _approximate(): JsonField<Approximate> = approximate

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
                 * Returns a mutable builder for constructing an instance of [UserLocation].
                 *
                 * The following fields are required:
                 * ```java
                 * .approximate()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UserLocation]. */
            class Builder internal constructor() {

                private var approximate: JsonField<Approximate>? = null
                private var type: JsonValue = JsonValue.from("approximate")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(userLocation: UserLocation) = apply {
                    approximate = userLocation.approximate
                    type = userLocation.type
                    additionalProperties = userLocation.additionalProperties.toMutableMap()
                }

                /** Approximate location parameters for the search. */
                fun approximate(approximate: Approximate) = approximate(JsonField.of(approximate))

                /**
                 * Sets [Builder.approximate] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.approximate] with a well-typed [Approximate]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun approximate(approximate: JsonField<Approximate>) = apply {
                    this.approximate = approximate
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("approximate")
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
                 * Returns an immutable instance of [UserLocation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .approximate()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UserLocation =
                    UserLocation(
                        checkRequired("approximate", approximate),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): UserLocation = apply {
                if (validated) {
                    return@apply
                }

                approximate().validate()
                _type().let {
                    if (it != JsonValue.from("approximate")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            /** Approximate location parameters for the search. */
            class Approximate
            private constructor(
                private val city: JsonField<String>,
                private val country: JsonField<String>,
                private val region: JsonField<String>,
                private val timezone: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("city")
                    @ExcludeMissing
                    city: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("region")
                    @ExcludeMissing
                    region: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("timezone")
                    @ExcludeMissing
                    timezone: JsonField<String> = JsonMissing.of(),
                ) : this(city, country, region, timezone, mutableMapOf())

                /**
                 * Free text input for the city of the user, e.g. `San Francisco`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun city(): Optional<String> = Optional.ofNullable(city.getNullable("city"))

                /**
                 * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1) of
                 * the user, e.g. `US`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun country(): Optional<String> =
                    Optional.ofNullable(country.getNullable("country"))

                /**
                 * Free text input for the region of the user, e.g. `California`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun region(): Optional<String> = Optional.ofNullable(region.getNullable("region"))

                /**
                 * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the user,
                 * e.g. `America/Los_Angeles`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun timezone(): Optional<String> =
                    Optional.ofNullable(timezone.getNullable("timezone"))

                /**
                 * Returns the raw JSON value of [city].
                 *
                 * Unlike [city], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [region].
                 *
                 * Unlike [region], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<String> = region

                /**
                 * Returns the raw JSON value of [timezone].
                 *
                 * Unlike [timezone], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("timezone")
                @ExcludeMissing
                fun _timezone(): JsonField<String> = timezone

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

                    /** Returns a mutable builder for constructing an instance of [Approximate]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Approximate]. */
                class Builder internal constructor() {

                    private var city: JsonField<String> = JsonMissing.of()
                    private var country: JsonField<String> = JsonMissing.of()
                    private var region: JsonField<String> = JsonMissing.of()
                    private var timezone: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(approximate: Approximate) = apply {
                        city = approximate.city
                        country = approximate.country
                        region = approximate.region
                        timezone = approximate.timezone
                        additionalProperties = approximate.additionalProperties.toMutableMap()
                    }

                    /** Free text input for the city of the user, e.g. `San Francisco`. */
                    fun city(city: String) = city(JsonField.of(city))

                    /**
                     * Sets [Builder.city] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.city] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun city(city: JsonField<String>) = apply { this.city = city }

                    /**
                     * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1)
                     * of the user, e.g. `US`.
                     */
                    fun country(country: String) = country(JsonField.of(country))

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    /** Free text input for the region of the user, e.g. `California`. */
                    fun region(region: String) = region(JsonField.of(region))

                    /**
                     * Sets [Builder.region] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.region] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun region(region: JsonField<String>) = apply { this.region = region }

                    /**
                     * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the
                     * user, e.g. `America/Los_Angeles`.
                     */
                    fun timezone(timezone: String) = timezone(JsonField.of(timezone))

                    /**
                     * Sets [Builder.timezone] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.timezone] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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
                     * Returns an immutable instance of [Approximate].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Approximate =
                        Approximate(
                            city,
                            country,
                            region,
                            timezone,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Approximate = apply {
                    if (validated) {
                        return@apply
                    }

                    city()
                    country()
                    region()
                    timezone()
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Approximate && city == other.city && country == other.country && region == other.region && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(city, country, region, timezone, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Approximate{city=$city, country=$country, region=$region, timezone=$timezone, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is UserLocation && approximate == other.approximate && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(approximate, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UserLocation{approximate=$approximate, type=$type, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is WebSearchOptions && searchContextSize == other.searchContextSize && userLocation == other.userLocation && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(searchContextSize, userLocation, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WebSearchOptions{searchContextSize=$searchContextSize, userLocation=$userLocation, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ChatCompletionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
