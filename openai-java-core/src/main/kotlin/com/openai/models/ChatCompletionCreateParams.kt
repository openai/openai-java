// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class ChatCompletionCreateParams
constructor(
    private val messages: List<ChatCompletionMessageParam>,
    private val model: Model,
    private val audio: ChatCompletionAudioParam?,
    private val frequencyPenalty: Double?,
    private val functionCall: FunctionCall?,
    private val functions: List<Function>?,
    private val logitBias: LogitBias?,
    private val logprobs: Boolean?,
    private val maxCompletionTokens: Long?,
    private val maxTokens: Long?,
    private val metadata: Metadata?,
    private val modalities: List<ChatCompletionModality>?,
    private val n: Long?,
    private val parallelToolCalls: Boolean?,
    private val prediction: ChatCompletionPredictionContent?,
    private val presencePenalty: Double?,
    private val responseFormat: ResponseFormat?,
    private val seed: Long?,
    private val serviceTier: ServiceTier?,
    private val stop: Stop?,
    private val store: Boolean?,
    private val streamOptions: ChatCompletionStreamOptions?,
    private val temperature: Double?,
    private val toolChoice: ChatCompletionToolChoiceOption?,
    private val tools: List<ChatCompletionTool>?,
    private val topLogprobs: Long?,
    private val topP: Double?,
    private val user: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun messages(): List<ChatCompletionMessageParam> = messages

    fun model(): Model = model

    fun audio(): Optional<ChatCompletionAudioParam> = Optional.ofNullable(audio)

    fun frequencyPenalty(): Optional<Double> = Optional.ofNullable(frequencyPenalty)

    fun functionCall(): Optional<FunctionCall> = Optional.ofNullable(functionCall)

    fun functions(): Optional<List<Function>> = Optional.ofNullable(functions)

    fun logitBias(): Optional<LogitBias> = Optional.ofNullable(logitBias)

    fun logprobs(): Optional<Boolean> = Optional.ofNullable(logprobs)

    fun maxCompletionTokens(): Optional<Long> = Optional.ofNullable(maxCompletionTokens)

    fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens)

    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata)

    fun modalities(): Optional<List<ChatCompletionModality>> = Optional.ofNullable(modalities)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun parallelToolCalls(): Optional<Boolean> = Optional.ofNullable(parallelToolCalls)

    fun prediction(): Optional<ChatCompletionPredictionContent> = Optional.ofNullable(prediction)

    fun presencePenalty(): Optional<Double> = Optional.ofNullable(presencePenalty)

    fun responseFormat(): Optional<ResponseFormat> = Optional.ofNullable(responseFormat)

    fun seed(): Optional<Long> = Optional.ofNullable(seed)

    fun serviceTier(): Optional<ServiceTier> = Optional.ofNullable(serviceTier)

    fun stop(): Optional<Stop> = Optional.ofNullable(stop)

    fun store(): Optional<Boolean> = Optional.ofNullable(store)

    fun streamOptions(): Optional<ChatCompletionStreamOptions> = Optional.ofNullable(streamOptions)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun toolChoice(): Optional<ChatCompletionToolChoiceOption> = Optional.ofNullable(toolChoice)

    fun tools(): Optional<List<ChatCompletionTool>> = Optional.ofNullable(tools)

    fun topLogprobs(): Optional<Long> = Optional.ofNullable(topLogprobs)

    fun topP(): Optional<Double> = Optional.ofNullable(topP)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): ChatCompletionCreateBody {
        return ChatCompletionCreateBody(
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
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(builder = ChatCompletionCreateBody.Builder::class)
    @NoAutoDetect
    class ChatCompletionCreateBody
    internal constructor(
        private val messages: List<ChatCompletionMessageParam>?,
        private val model: Model?,
        private val audio: ChatCompletionAudioParam?,
        private val frequencyPenalty: Double?,
        private val functionCall: FunctionCall?,
        private val functions: List<Function>?,
        private val logitBias: LogitBias?,
        private val logprobs: Boolean?,
        private val maxCompletionTokens: Long?,
        private val maxTokens: Long?,
        private val metadata: Metadata?,
        private val modalities: List<ChatCompletionModality>?,
        private val n: Long?,
        private val parallelToolCalls: Boolean?,
        private val prediction: ChatCompletionPredictionContent?,
        private val presencePenalty: Double?,
        private val responseFormat: ResponseFormat?,
        private val seed: Long?,
        private val serviceTier: ServiceTier?,
        private val stop: Stop?,
        private val store: Boolean?,
        private val streamOptions: ChatCompletionStreamOptions?,
        private val temperature: Double?,
        private val toolChoice: ChatCompletionToolChoiceOption?,
        private val tools: List<ChatCompletionTool>?,
        private val topLogprobs: Long?,
        private val topP: Double?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * A list of messages comprising the conversation so far. Depending on the
         * [model](https://platform.openai.com/docs/models) you use, different message types
         * (modalities) are supported, like
         * [text](https://platform.openai.com/docs/guides/text-generation),
         * [images](https://platform.openai.com/docs/guides/vision), and
         * [audio](https://platform.openai.com/docs/guides/audio).
         */
        @JsonProperty("messages") fun messages(): List<ChatCompletionMessageParam>? = messages

        /**
         * ID of the model to use. See the
         * [model endpoint compatibility](https://platform.openai.com/docs/models#model-endpoint-compatibility)
         * table for details on which models work with the Chat API.
         */
        @JsonProperty("model") fun model(): Model? = model

        /**
         * Parameters for audio output. Required when audio output is requested with `modalities:
         * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        @JsonProperty("audio") fun audio(): ChatCompletionAudioParam? = audio

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation)
         */
        @JsonProperty("frequency_penalty") fun frequencyPenalty(): Double? = frequencyPenalty

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model. `none` means the model will not
         * call a function and instead generates a message. `auto` means the model can pick between
         * generating a message or calling a function. Specifying a particular function via
         * `{"name": "my_function"}` forces the model to call that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         */
        @JsonProperty("function_call") fun functionCall(): FunctionCall? = functionCall

        /**
         * Deprecated in favor of `tools`.
         *
         * A list of functions the model may generate JSON inputs for.
         */
        @JsonProperty("functions") fun functions(): List<Function>? = functions

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         */
        @JsonProperty("logit_bias") fun logitBias(): LogitBias? = logitBias

        /**
         * Whether to return log probabilities of the output tokens or not. If true, returns the log
         * probabilities of each output token returned in the `content` of `message`.
         */
        @JsonProperty("logprobs") fun logprobs(): Boolean? = logprobs

        /**
         * An upper bound for the number of tokens that can be generated for a completion, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        @JsonProperty("max_completion_tokens")
        fun maxCompletionTokens(): Long? = maxCompletionTokens

        /**
         * The maximum number of [tokens](/tokenizer) that can be generated in the chat completion.
         * This value can be used to control [costs](https://openai.com/api/pricing/) for text
         * generated via API.
         *
         * This value is now deprecated in favor of `max_completion_tokens`, and is not compatible
         * with [o1 series models](https://platform.openai.com/docs/guides/reasoning).
         */
        @JsonProperty("max_tokens") fun maxTokens(): Long? = maxTokens

        /**
         * Developer-defined tags and values used for filtering completions in the
         * [dashboard](https://platform.openai.com/chat-completions).
         */
        @JsonProperty("metadata") fun metadata(): Metadata? = metadata

        /**
         * Output types that you would like the model to generate for this request. Most models are
         * capable of generating text, which is the default:
         *
         * `["text"]`
         *
         * The `gpt-4o-audio-preview` model can also be used to
         * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
         * model generate both text and audio responses, you can use:
         *
         * `["text", "audio"]`
         */
        @JsonProperty("modalities") fun modalities(): List<ChatCompletionModality>? = modalities

        /**
         * How many chat completion choices to generate for each input message. Note that you will
         * be charged based on the number of generated tokens across all of the choices. Keep `n` as
         * `1` to minimize costs.
         */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        @JsonProperty("parallel_tool_calls") fun parallelToolCalls(): Boolean? = parallelToolCalls

        /**
         * Static predicted output content, such as the content of a text file that is being
         * regenerated.
         */
        @JsonProperty("prediction") fun prediction(): ChatCompletionPredictionContent? = prediction

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation)
         */
        @JsonProperty("presence_penalty") fun presencePenalty(): Double? = presencePenalty

        /**
         * An object specifying the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
         * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
         * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
         * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
        @JsonProperty("response_format") fun responseFormat(): ResponseFormat? = responseFormat

        /**
         * This feature is in Beta. If specified, our system will make a best effort to sample
         * deterministically, such that repeated requests with the same `seed` and parameters should
         * return the same result. Determinism is not guaranteed, and you should refer to the
         * `system_fingerprint` response parameter to monitor changes in the backend.
         */
        @JsonProperty("seed") fun seed(): Long? = seed

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
        @JsonProperty("service_tier") fun serviceTier(): ServiceTier? = serviceTier

        /** Up to 4 sequences where the API will stop generating further tokens. */
        @JsonProperty("stop") fun stop(): Stop? = stop

        /**
         * Whether or not to store the output of this chat completion request for use in our
         * [model distillation](https://platform.openai.com/docs/guides/distillation) or
         * [evals](https://platform.openai.com/docs/guides/evals) products.
         */
        @JsonProperty("store") fun store(): Boolean? = store

        /** Options for streaming response. Only set this when you set `stream: true`. */
        @JsonProperty("stream_options")
        fun streamOptions(): ChatCompletionStreamOptions? = streamOptions

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        @JsonProperty("temperature") fun temperature(): Double? = temperature

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
        @JsonProperty("tool_choice") fun toolChoice(): ChatCompletionToolChoiceOption? = toolChoice

        /**
         * A list of tools the model may call. Currently, only functions are supported as a tool.
         * Use this to provide a list of functions the model may generate JSON inputs for. A max of
         * 128 functions are supported.
         */
        @JsonProperty("tools") fun tools(): List<ChatCompletionTool>? = tools

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability. `logprobs` must be set to `true`
         * if this parameter is used.
         */
        @JsonProperty("top_logprobs") fun topLogprobs(): Long? = topLogprobs

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        @JsonProperty("top_p") fun topP(): Double? = topP

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        @JsonProperty("user") fun user(): String? = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var messages: List<ChatCompletionMessageParam>? = null
            private var model: Model? = null
            private var audio: ChatCompletionAudioParam? = null
            private var frequencyPenalty: Double? = null
            private var functionCall: FunctionCall? = null
            private var functions: List<Function>? = null
            private var logitBias: LogitBias? = null
            private var logprobs: Boolean? = null
            private var maxCompletionTokens: Long? = null
            private var maxTokens: Long? = null
            private var metadata: Metadata? = null
            private var modalities: List<ChatCompletionModality>? = null
            private var n: Long? = null
            private var parallelToolCalls: Boolean? = null
            private var prediction: ChatCompletionPredictionContent? = null
            private var presencePenalty: Double? = null
            private var responseFormat: ResponseFormat? = null
            private var seed: Long? = null
            private var serviceTier: ServiceTier? = null
            private var stop: Stop? = null
            private var store: Boolean? = null
            private var streamOptions: ChatCompletionStreamOptions? = null
            private var temperature: Double? = null
            private var toolChoice: ChatCompletionToolChoiceOption? = null
            private var tools: List<ChatCompletionTool>? = null
            private var topLogprobs: Long? = null
            private var topP: Double? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(chatCompletionCreateBody: ChatCompletionCreateBody) = apply {
                this.messages = chatCompletionCreateBody.messages
                this.model = chatCompletionCreateBody.model
                this.audio = chatCompletionCreateBody.audio
                this.frequencyPenalty = chatCompletionCreateBody.frequencyPenalty
                this.functionCall = chatCompletionCreateBody.functionCall
                this.functions = chatCompletionCreateBody.functions
                this.logitBias = chatCompletionCreateBody.logitBias
                this.logprobs = chatCompletionCreateBody.logprobs
                this.maxCompletionTokens = chatCompletionCreateBody.maxCompletionTokens
                this.maxTokens = chatCompletionCreateBody.maxTokens
                this.metadata = chatCompletionCreateBody.metadata
                this.modalities = chatCompletionCreateBody.modalities
                this.n = chatCompletionCreateBody.n
                this.parallelToolCalls = chatCompletionCreateBody.parallelToolCalls
                this.prediction = chatCompletionCreateBody.prediction
                this.presencePenalty = chatCompletionCreateBody.presencePenalty
                this.responseFormat = chatCompletionCreateBody.responseFormat
                this.seed = chatCompletionCreateBody.seed
                this.serviceTier = chatCompletionCreateBody.serviceTier
                this.stop = chatCompletionCreateBody.stop
                this.store = chatCompletionCreateBody.store
                this.streamOptions = chatCompletionCreateBody.streamOptions
                this.temperature = chatCompletionCreateBody.temperature
                this.toolChoice = chatCompletionCreateBody.toolChoice
                this.tools = chatCompletionCreateBody.tools
                this.topLogprobs = chatCompletionCreateBody.topLogprobs
                this.topP = chatCompletionCreateBody.topP
                this.user = chatCompletionCreateBody.user
                additionalProperties(chatCompletionCreateBody.additionalProperties)
            }

            /**
             * A list of messages comprising the conversation so far. Depending on the
             * [model](https://platform.openai.com/docs/models) you use, different message types
             * (modalities) are supported, like
             * [text](https://platform.openai.com/docs/guides/text-generation),
             * [images](https://platform.openai.com/docs/guides/vision), and
             * [audio](https://platform.openai.com/docs/guides/audio).
             */
            @JsonProperty("messages")
            fun messages(messages: List<ChatCompletionMessageParam>) = apply {
                this.messages = messages
            }

            /**
             * ID of the model to use. See the
             * [model endpoint compatibility](https://platform.openai.com/docs/models#model-endpoint-compatibility)
             * table for details on which models work with the Chat API.
             */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            /**
             * Parameters for audio output. Required when audio output is requested with
             * `modalities: ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
             */
            @JsonProperty("audio")
            fun audio(audio: ChatCompletionAudioParam) = apply { this.audio = audio }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on their
             * existing frequency in the text so far, decreasing the model's likelihood to repeat
             * the same line verbatim.
             *
             * [See more information about frequency and presence
             * penalties.](https://platform.openai.com/docs/guides/text-generation)
             */
            @JsonProperty("frequency_penalty")
            fun frequencyPenalty(frequencyPenalty: Double) = apply {
                this.frequencyPenalty = frequencyPenalty
            }

            /**
             * Deprecated in favor of `tool_choice`.
             *
             * Controls which (if any) function is called by the model. `none` means the model will
             * not call a function and instead generates a message. `auto` means the model can pick
             * between generating a message or calling a function. Specifying a particular function
             * via `{"name": "my_function"}` forces the model to call that function.
             *
             * `none` is the default when no functions are present. `auto` is the default if
             * functions are present.
             */
            @JsonProperty("function_call")
            fun functionCall(functionCall: FunctionCall) = apply {
                this.functionCall = functionCall
            }

            /**
             * Deprecated in favor of `tools`.
             *
             * A list of functions the model may generate JSON inputs for.
             */
            @JsonProperty("functions")
            fun functions(functions: List<Function>) = apply { this.functions = functions }

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
            @JsonProperty("logit_bias")
            fun logitBias(logitBias: LogitBias) = apply { this.logitBias = logitBias }

            /**
             * Whether to return log probabilities of the output tokens or not. If true, returns the
             * log probabilities of each output token returned in the `content` of `message`.
             */
            @JsonProperty("logprobs")
            fun logprobs(logprobs: Boolean) = apply { this.logprobs = logprobs }

            /**
             * An upper bound for the number of tokens that can be generated for a completion,
             * including visible output tokens and
             * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
             */
            @JsonProperty("max_completion_tokens")
            fun maxCompletionTokens(maxCompletionTokens: Long) = apply {
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
            @JsonProperty("max_tokens")
            fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

            /**
             * Developer-defined tags and values used for filtering completions in the
             * [dashboard](https://platform.openai.com/chat-completions).
             */
            @JsonProperty("metadata")
            fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

            /**
             * Output types that you would like the model to generate for this request. Most models
             * are capable of generating text, which is the default:
             *
             * `["text"]`
             *
             * The `gpt-4o-audio-preview` model can also be used to
             * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
             * model generate both text and audio responses, you can use:
             *
             * `["text", "audio"]`
             */
            @JsonProperty("modalities")
            fun modalities(modalities: List<ChatCompletionModality>) = apply {
                this.modalities = modalities
            }

            /**
             * How many chat completion choices to generate for each input message. Note that you
             * will be charged based on the number of generated tokens across all of the choices.
             * Keep `n` as `1` to minimize costs.
             */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * Whether to enable
             * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
             * during tool use.
             */
            @JsonProperty("parallel_tool_calls")
            fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
                this.parallelToolCalls = parallelToolCalls
            }

            /**
             * Static predicted output content, such as the content of a text file that is being
             * regenerated.
             */
            @JsonProperty("prediction")
            fun prediction(prediction: ChatCompletionPredictionContent) = apply {
                this.prediction = prediction
            }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether
             * they appear in the text so far, increasing the model's likelihood to talk about new
             * topics.
             *
             * [See more information about frequency and presence
             * penalties.](https://platform.openai.com/docs/guides/text-generation)
             */
            @JsonProperty("presence_penalty")
            fun presencePenalty(presencePenalty: Double) = apply {
                this.presencePenalty = presencePenalty
            }

            /**
             * An object specifying the format that the model must output. Compatible with
             * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
             * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
             * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
             * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
            @JsonProperty("response_format")
            fun responseFormat(responseFormat: ResponseFormat) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * This feature is in Beta. If specified, our system will make a best effort to sample
             * deterministically, such that repeated requests with the same `seed` and parameters
             * should return the same result. Determinism is not guaranteed, and you should refer to
             * the `system_fingerprint` response parameter to monitor changes in the backend.
             */
            @JsonProperty("seed") fun seed(seed: Long) = apply { this.seed = seed }

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
            @JsonProperty("service_tier")
            fun serviceTier(serviceTier: ServiceTier) = apply { this.serviceTier = serviceTier }

            /** Up to 4 sequences where the API will stop generating further tokens. */
            @JsonProperty("stop") fun stop(stop: Stop) = apply { this.stop = stop }

            /**
             * Whether or not to store the output of this chat completion request for use in our
             * [model distillation](https://platform.openai.com/docs/guides/distillation) or
             * [evals](https://platform.openai.com/docs/guides/evals) products.
             */
            @JsonProperty("store") fun store(store: Boolean) = apply { this.store = store }

            /** Options for streaming response. Only set this when you set `stream: true`. */
            @JsonProperty("stream_options")
            fun streamOptions(streamOptions: ChatCompletionStreamOptions) = apply {
                this.streamOptions = streamOptions
            }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             *
             * We generally recommend altering this or `top_p` but not both.
             */
            @JsonProperty("temperature")
            fun temperature(temperature: Double) = apply { this.temperature = temperature }

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
            @JsonProperty("tool_choice")
            fun toolChoice(toolChoice: ChatCompletionToolChoiceOption) = apply {
                this.toolChoice = toolChoice
            }

            /**
             * A list of tools the model may call. Currently, only functions are supported as a
             * tool. Use this to provide a list of functions the model may generate JSON inputs for.
             * A max of 128 functions are supported.
             */
            @JsonProperty("tools")
            fun tools(tools: List<ChatCompletionTool>) = apply { this.tools = tools }

            /**
             * An integer between 0 and 20 specifying the number of most likely tokens to return at
             * each token position, each with an associated log probability. `logprobs` must be set
             * to `true` if this parameter is used.
             */
            @JsonProperty("top_logprobs")
            fun topLogprobs(topLogprobs: Long) = apply { this.topLogprobs = topLogprobs }

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            @JsonProperty("top_p") fun topP(topP: Double) = apply { this.topP = topP }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
             */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): ChatCompletionCreateBody =
                ChatCompletionCreateBody(
                    checkNotNull(messages) { "`messages` is required but was not set" }
                        .toImmutable(),
                    checkNotNull(model) { "`model` is required but was not set" },
                    audio,
                    frequencyPenalty,
                    functionCall,
                    functions?.toImmutable(),
                    logitBias,
                    logprobs,
                    maxCompletionTokens,
                    maxTokens,
                    metadata,
                    modalities?.toImmutable(),
                    n,
                    parallelToolCalls,
                    prediction,
                    presencePenalty,
                    responseFormat,
                    seed,
                    serviceTier,
                    stop,
                    store,
                    streamOptions,
                    temperature,
                    toolChoice,
                    tools?.toImmutable(),
                    topLogprobs,
                    topP,
                    user,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ChatCompletionCreateBody && messages == other.messages && model == other.model && audio == other.audio && frequencyPenalty == other.frequencyPenalty && functionCall == other.functionCall && functions == other.functions && logitBias == other.logitBias && logprobs == other.logprobs && maxCompletionTokens == other.maxCompletionTokens && maxTokens == other.maxTokens && metadata == other.metadata && modalities == other.modalities && n == other.n && parallelToolCalls == other.parallelToolCalls && prediction == other.prediction && presencePenalty == other.presencePenalty && responseFormat == other.responseFormat && seed == other.seed && serviceTier == other.serviceTier && stop == other.stop && store == other.store && streamOptions == other.streamOptions && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && topLogprobs == other.topLogprobs && topP == other.topP && user == other.user && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messages, model, audio, frequencyPenalty, functionCall, functions, logitBias, logprobs, maxCompletionTokens, maxTokens, metadata, modalities, n, parallelToolCalls, prediction, presencePenalty, responseFormat, seed, serviceTier, stop, store, streamOptions, temperature, toolChoice, tools, topLogprobs, topP, user, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ChatCompletionCreateBody{messages=$messages, model=$model, audio=$audio, frequencyPenalty=$frequencyPenalty, functionCall=$functionCall, functions=$functions, logitBias=$logitBias, logprobs=$logprobs, maxCompletionTokens=$maxCompletionTokens, maxTokens=$maxTokens, metadata=$metadata, modalities=$modalities, n=$n, parallelToolCalls=$parallelToolCalls, prediction=$prediction, presencePenalty=$presencePenalty, responseFormat=$responseFormat, seed=$seed, serviceTier=$serviceTier, stop=$stop, store=$store, streamOptions=$streamOptions, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topLogprobs=$topLogprobs, topP=$topP, user=$user, additionalProperties=$additionalProperties}"
    }

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionCreateParams && messages == other.messages && model == other.model && audio == other.audio && frequencyPenalty == other.frequencyPenalty && functionCall == other.functionCall && functions == other.functions && logitBias == other.logitBias && logprobs == other.logprobs && maxCompletionTokens == other.maxCompletionTokens && maxTokens == other.maxTokens && metadata == other.metadata && modalities == other.modalities && n == other.n && parallelToolCalls == other.parallelToolCalls && prediction == other.prediction && presencePenalty == other.presencePenalty && responseFormat == other.responseFormat && seed == other.seed && serviceTier == other.serviceTier && stop == other.stop && store == other.store && streamOptions == other.streamOptions && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && topLogprobs == other.topLogprobs && topP == other.topP && user == other.user && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messages, model, audio, frequencyPenalty, functionCall, functions, logitBias, logprobs, maxCompletionTokens, maxTokens, metadata, modalities, n, parallelToolCalls, prediction, presencePenalty, responseFormat, seed, serviceTier, stop, store, streamOptions, temperature, toolChoice, tools, topLogprobs, topP, user, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "ChatCompletionCreateParams{messages=$messages, model=$model, audio=$audio, frequencyPenalty=$frequencyPenalty, functionCall=$functionCall, functions=$functions, logitBias=$logitBias, logprobs=$logprobs, maxCompletionTokens=$maxCompletionTokens, maxTokens=$maxTokens, metadata=$metadata, modalities=$modalities, n=$n, parallelToolCalls=$parallelToolCalls, prediction=$prediction, presencePenalty=$presencePenalty, responseFormat=$responseFormat, seed=$seed, serviceTier=$serviceTier, stop=$stop, store=$store, streamOptions=$streamOptions, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, topLogprobs=$topLogprobs, topP=$topP, user=$user, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var messages: MutableList<ChatCompletionMessageParam> = mutableListOf()
        private var model: Model? = null
        private var audio: ChatCompletionAudioParam? = null
        private var frequencyPenalty: Double? = null
        private var functionCall: FunctionCall? = null
        private var functions: MutableList<Function> = mutableListOf()
        private var logitBias: LogitBias? = null
        private var logprobs: Boolean? = null
        private var maxCompletionTokens: Long? = null
        private var maxTokens: Long? = null
        private var metadata: Metadata? = null
        private var modalities: MutableList<ChatCompletionModality> = mutableListOf()
        private var n: Long? = null
        private var parallelToolCalls: Boolean? = null
        private var prediction: ChatCompletionPredictionContent? = null
        private var presencePenalty: Double? = null
        private var responseFormat: ResponseFormat? = null
        private var seed: Long? = null
        private var serviceTier: ServiceTier? = null
        private var stop: Stop? = null
        private var store: Boolean? = null
        private var streamOptions: ChatCompletionStreamOptions? = null
        private var temperature: Double? = null
        private var toolChoice: ChatCompletionToolChoiceOption? = null
        private var tools: MutableList<ChatCompletionTool> = mutableListOf()
        private var topLogprobs: Long? = null
        private var topP: Double? = null
        private var user: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionCreateParams: ChatCompletionCreateParams) = apply {
            this.messages(chatCompletionCreateParams.messages)
            this.model = chatCompletionCreateParams.model
            this.audio = chatCompletionCreateParams.audio
            this.frequencyPenalty = chatCompletionCreateParams.frequencyPenalty
            this.functionCall = chatCompletionCreateParams.functionCall
            this.functions(chatCompletionCreateParams.functions ?: listOf())
            this.logitBias = chatCompletionCreateParams.logitBias
            this.logprobs = chatCompletionCreateParams.logprobs
            this.maxCompletionTokens = chatCompletionCreateParams.maxCompletionTokens
            this.maxTokens = chatCompletionCreateParams.maxTokens
            this.metadata = chatCompletionCreateParams.metadata
            this.modalities(chatCompletionCreateParams.modalities ?: listOf())
            this.n = chatCompletionCreateParams.n
            this.parallelToolCalls = chatCompletionCreateParams.parallelToolCalls
            this.prediction = chatCompletionCreateParams.prediction
            this.presencePenalty = chatCompletionCreateParams.presencePenalty
            this.responseFormat = chatCompletionCreateParams.responseFormat
            this.seed = chatCompletionCreateParams.seed
            this.serviceTier = chatCompletionCreateParams.serviceTier
            this.stop = chatCompletionCreateParams.stop
            this.store = chatCompletionCreateParams.store
            this.streamOptions = chatCompletionCreateParams.streamOptions
            this.temperature = chatCompletionCreateParams.temperature
            this.toolChoice = chatCompletionCreateParams.toolChoice
            this.tools(chatCompletionCreateParams.tools ?: listOf())
            this.topLogprobs = chatCompletionCreateParams.topLogprobs
            this.topP = chatCompletionCreateParams.topP
            this.user = chatCompletionCreateParams.user
            additionalHeaders(chatCompletionCreateParams.additionalHeaders)
            additionalQueryParams(chatCompletionCreateParams.additionalQueryParams)
            additionalBodyProperties(chatCompletionCreateParams.additionalBodyProperties)
        }

        /**
         * A list of messages comprising the conversation so far. Depending on the
         * [model](https://platform.openai.com/docs/models) you use, different message types
         * (modalities) are supported, like
         * [text](https://platform.openai.com/docs/guides/text-generation),
         * [images](https://platform.openai.com/docs/guides/vision), and
         * [audio](https://platform.openai.com/docs/guides/audio).
         */
        fun messages(messages: List<ChatCompletionMessageParam>) = apply {
            this.messages.clear()
            this.messages.addAll(messages)
        }

        /**
         * A list of messages comprising the conversation so far. Depending on the
         * [model](https://platform.openai.com/docs/models) you use, different message types
         * (modalities) are supported, like
         * [text](https://platform.openai.com/docs/guides/text-generation),
         * [images](https://platform.openai.com/docs/guides/vision), and
         * [audio](https://platform.openai.com/docs/guides/audio).
         */
        fun addMessage(message: ChatCompletionMessageParam) = apply { this.messages.add(message) }

        /**
         * ID of the model to use. See the
         * [model endpoint compatibility](https://platform.openai.com/docs/models#model-endpoint-compatibility)
         * table for details on which models work with the Chat API.
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * ID of the model to use. See the
         * [model endpoint compatibility](https://platform.openai.com/docs/models#model-endpoint-compatibility)
         * table for details on which models work with the Chat API.
         */
        fun model(value: String) = apply { this.model = Model.of(value) }

        /**
         * Parameters for audio output. Required when audio output is requested with `modalities:
         * ["audio"]`. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        fun audio(audio: ChatCompletionAudioParam) = apply { this.audio = audio }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation)
         */
        fun frequencyPenalty(frequencyPenalty: Double) = apply {
            this.frequencyPenalty = frequencyPenalty
        }

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model. `none` means the model will not
         * call a function and instead generates a message. `auto` means the model can pick between
         * generating a message or calling a function. Specifying a particular function via
         * `{"name": "my_function"}` forces the model to call that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         */
        fun functionCall(functionCall: FunctionCall) = apply { this.functionCall = functionCall }

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model. `none` means the model will not
         * call a function and instead generates a message. `auto` means the model can pick between
         * generating a message or calling a function. Specifying a particular function via
         * `{"name": "my_function"}` forces the model to call that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         */
        fun functionCall(behavior: FunctionCall.Behavior) = apply {
            this.functionCall = FunctionCall.ofBehavior(behavior)
        }

        /**
         * Deprecated in favor of `tool_choice`.
         *
         * Controls which (if any) function is called by the model. `none` means the model will not
         * call a function and instead generates a message. `auto` means the model can pick between
         * generating a message or calling a function. Specifying a particular function via
         * `{"name": "my_function"}` forces the model to call that function.
         *
         * `none` is the default when no functions are present. `auto` is the default if functions
         * are present.
         */
        fun functionCall(functionCallOption: ChatCompletionFunctionCallOption) = apply {
            this.functionCall = FunctionCall.ofFunctionCallOption(functionCallOption)
        }

        /**
         * Deprecated in favor of `tools`.
         *
         * A list of functions the model may generate JSON inputs for.
         */
        fun functions(functions: List<Function>) = apply {
            this.functions.clear()
            this.functions.addAll(functions)
        }

        /**
         * Deprecated in favor of `tools`.
         *
         * A list of functions the model may generate JSON inputs for.
         */
        fun addFunction(function: Function) = apply { this.functions.add(function) }

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         */
        fun logitBias(logitBias: LogitBias) = apply { this.logitBias = logitBias }

        /**
         * Whether to return log probabilities of the output tokens or not. If true, returns the log
         * probabilities of each output token returned in the `content` of `message`.
         */
        fun logprobs(logprobs: Boolean) = apply { this.logprobs = logprobs }

        /**
         * An upper bound for the number of tokens that can be generated for a completion, including
         * visible output tokens and
         * [reasoning tokens](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxCompletionTokens(maxCompletionTokens: Long) = apply {
            this.maxCompletionTokens = maxCompletionTokens
        }

        /**
         * The maximum number of [tokens](/tokenizer) that can be generated in the chat completion.
         * This value can be used to control [costs](https://openai.com/api/pricing/) for text
         * generated via API.
         *
         * This value is now deprecated in favor of `max_completion_tokens`, and is not compatible
         * with [o1 series models](https://platform.openai.com/docs/guides/reasoning).
         */
        fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

        /**
         * Developer-defined tags and values used for filtering completions in the
         * [dashboard](https://platform.openai.com/chat-completions).
         */
        fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

        /**
         * Output types that you would like the model to generate for this request. Most models are
         * capable of generating text, which is the default:
         *
         * `["text"]`
         *
         * The `gpt-4o-audio-preview` model can also be used to
         * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
         * model generate both text and audio responses, you can use:
         *
         * `["text", "audio"]`
         */
        fun modalities(modalities: List<ChatCompletionModality>) = apply {
            this.modalities.clear()
            this.modalities.addAll(modalities)
        }

        /**
         * Output types that you would like the model to generate for this request. Most models are
         * capable of generating text, which is the default:
         *
         * `["text"]`
         *
         * The `gpt-4o-audio-preview` model can also be used to
         * [generate audio](https://platform.openai.com/docs/guides/audio). To request that this
         * model generate both text and audio responses, you can use:
         *
         * `["text", "audio"]`
         */
        fun addModality(modality: ChatCompletionModality) = apply { this.modalities.add(modality) }

        /**
         * How many chat completion choices to generate for each input message. Note that you will
         * be charged based on the number of generated tokens across all of the choices. Keep `n` as
         * `1` to minimize costs.
         */
        fun n(n: Long) = apply { this.n = n }

        /**
         * Whether to enable
         * [parallel function calling](https://platform.openai.com/docs/guides/function-calling#configuring-parallel-function-calling)
         * during tool use.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) = apply {
            this.parallelToolCalls = parallelToolCalls
        }

        /**
         * Static predicted output content, such as the content of a text file that is being
         * regenerated.
         */
        fun prediction(prediction: ChatCompletionPredictionContent) = apply {
            this.prediction = prediction
        }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation)
         */
        fun presencePenalty(presencePenalty: Double) = apply {
            this.presencePenalty = presencePenalty
        }

        /**
         * An object specifying the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
         * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
         * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
         * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            this.responseFormat = responseFormat
        }

        /**
         * An object specifying the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
         * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
         * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
         * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
        fun responseFormat(responseFormatText: ResponseFormatText) = apply {
            this.responseFormat = ResponseFormat.ofResponseFormatText(responseFormatText)
        }

        /**
         * An object specifying the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
         * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
         * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
         * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
        fun responseFormat(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            this.responseFormat =
                ResponseFormat.ofResponseFormatJsonObject(responseFormatJsonObject)
        }

        /**
         * An object specifying the format that the model must output. Compatible with
         * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4o
         * mini](https://platform.openai.com/docs/models#gpt-4o-mini),
         * [GPT-4 Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4) and all
         * GPT-3.5 Turbo models newer than `gpt-3.5-turbo-1106`.
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
        fun responseFormat(responseFormatJsonSchema: ResponseFormatJsonSchema) = apply {
            this.responseFormat =
                ResponseFormat.ofResponseFormatJsonSchema(responseFormatJsonSchema)
        }

        /**
         * This feature is in Beta. If specified, our system will make a best effort to sample
         * deterministically, such that repeated requests with the same `seed` and parameters should
         * return the same result. Determinism is not guaranteed, and you should refer to the
         * `system_fingerprint` response parameter to monitor changes in the backend.
         */
        fun seed(seed: Long) = apply { this.seed = seed }

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
        fun serviceTier(serviceTier: ServiceTier) = apply { this.serviceTier = serviceTier }

        /** Up to 4 sequences where the API will stop generating further tokens. */
        fun stop(stop: Stop) = apply { this.stop = stop }

        /** Up to 4 sequences where the API will stop generating further tokens. */
        fun stop(string: String) = apply { this.stop = Stop.ofString(string) }

        /** Up to 4 sequences where the API will stop generating further tokens. */
        fun stopOfStrings(strings: List<String>) = apply { this.stop = Stop.ofStrings(strings) }

        /**
         * Whether or not to store the output of this chat completion request for use in our
         * [model distillation](https://platform.openai.com/docs/guides/distillation) or
         * [evals](https://platform.openai.com/docs/guides/evals) products.
         */
        fun store(store: Boolean) = apply { this.store = store }

        /** Options for streaming response. Only set this when you set `stream: true`. */
        fun streamOptions(streamOptions: ChatCompletionStreamOptions) = apply {
            this.streamOptions = streamOptions
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double) = apply { this.temperature = temperature }

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
            this.toolChoice = toolChoice
        }

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
        fun toolChoice(behavior: ChatCompletionToolChoiceOption.Behavior) = apply {
            this.toolChoice = ChatCompletionToolChoiceOption.ofBehavior(behavior)
        }

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
        fun toolChoice(chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice) = apply {
            this.toolChoice =
                ChatCompletionToolChoiceOption.ofChatCompletionNamedToolChoice(
                    chatCompletionNamedToolChoice
                )
        }

        /**
         * A list of tools the model may call. Currently, only functions are supported as a tool.
         * Use this to provide a list of functions the model may generate JSON inputs for. A max of
         * 128 functions are supported.
         */
        fun tools(tools: List<ChatCompletionTool>) = apply {
            this.tools.clear()
            this.tools.addAll(tools)
        }

        /**
         * A list of tools the model may call. Currently, only functions are supported as a tool.
         * Use this to provide a list of functions the model may generate JSON inputs for. A max of
         * 128 functions are supported.
         */
        fun addTool(tool: ChatCompletionTool) = apply { this.tools.add(tool) }

        /**
         * An integer between 0 and 20 specifying the number of most likely tokens to return at each
         * token position, each with an associated log probability. `logprobs` must be set to `true`
         * if this parameter is used.
         */
        fun topLogprobs(topLogprobs: Long) = apply { this.topLogprobs = topLogprobs }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double) = apply { this.topP = topP }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices#end-user-ids).
         */
        fun user(user: String) = apply { this.user = user }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): ChatCompletionCreateParams =
            ChatCompletionCreateParams(
                checkNotNull(messages) { "`messages` is required but was not set" }.toImmutable(),
                checkNotNull(model) { "`model` is required but was not set" },
                audio,
                frequencyPenalty,
                functionCall,
                if (functions.size == 0) null else functions.toImmutable(),
                logitBias,
                logprobs,
                maxCompletionTokens,
                maxTokens,
                metadata,
                if (modalities.size == 0) null else modalities.toImmutable(),
                n,
                parallelToolCalls,
                prediction,
                presencePenalty,
                responseFormat,
                seed,
                serviceTier,
                stop,
                store,
                streamOptions,
                temperature,
                toolChoice,
                if (tools.size == 0) null else tools.toImmutable(),
                topLogprobs,
                topP,
                user,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    class Model
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val O1_PREVIEW = Model(JsonField.of("o1-preview"))

            @JvmField val O1_PREVIEW_2024_09_12 = Model(JsonField.of("o1-preview-2024-09-12"))

            @JvmField val O1_MINI = Model(JsonField.of("o1-mini"))

            @JvmField val O1_MINI_2024_09_12 = Model(JsonField.of("o1-mini-2024-09-12"))

            @JvmField val GPT_4O = Model(JsonField.of("gpt-4o"))

            @JvmField val GPT_4O_2024_11_20 = Model(JsonField.of("gpt-4o-2024-11-20"))

            @JvmField val GPT_4O_2024_08_06 = Model(JsonField.of("gpt-4o-2024-08-06"))

            @JvmField val GPT_4O_2024_05_13 = Model(JsonField.of("gpt-4o-2024-05-13"))

            @JvmField val GPT_4O_REALTIME_PREVIEW = Model(JsonField.of("gpt-4o-realtime-preview"))

            @JvmField
            val GPT_4O_REALTIME_PREVIEW_2024_10_01 =
                Model(JsonField.of("gpt-4o-realtime-preview-2024-10-01"))

            @JvmField val GPT_4O_AUDIO_PREVIEW = Model(JsonField.of("gpt-4o-audio-preview"))

            @JvmField
            val GPT_4O_AUDIO_PREVIEW_2024_10_01 =
                Model(JsonField.of("gpt-4o-audio-preview-2024-10-01"))

            @JvmField val CHATGPT_4O_LATEST = Model(JsonField.of("chatgpt-4o-latest"))

            @JvmField val GPT_4O_MINI = Model(JsonField.of("gpt-4o-mini"))

            @JvmField val GPT_4O_MINI_2024_07_18 = Model(JsonField.of("gpt-4o-mini-2024-07-18"))

            @JvmField val GPT_4_TURBO = Model(JsonField.of("gpt-4-turbo"))

            @JvmField val GPT_4_TURBO_2024_04_09 = Model(JsonField.of("gpt-4-turbo-2024-04-09"))

            @JvmField val GPT_4_0125_PREVIEW = Model(JsonField.of("gpt-4-0125-preview"))

            @JvmField val GPT_4_TURBO_PREVIEW = Model(JsonField.of("gpt-4-turbo-preview"))

            @JvmField val GPT_4_1106_PREVIEW = Model(JsonField.of("gpt-4-1106-preview"))

            @JvmField val GPT_4_VISION_PREVIEW = Model(JsonField.of("gpt-4-vision-preview"))

            @JvmField val GPT_4 = Model(JsonField.of("gpt-4"))

            @JvmField val GPT_4_0314 = Model(JsonField.of("gpt-4-0314"))

            @JvmField val GPT_4_0613 = Model(JsonField.of("gpt-4-0613"))

            @JvmField val GPT_4_32K = Model(JsonField.of("gpt-4-32k"))

            @JvmField val GPT_4_32K_0314 = Model(JsonField.of("gpt-4-32k-0314"))

            @JvmField val GPT_4_32K_0613 = Model(JsonField.of("gpt-4-32k-0613"))

            @JvmField val GPT_3_5_TURBO = Model(JsonField.of("gpt-3.5-turbo"))

            @JvmField val GPT_3_5_TURBO_16K = Model(JsonField.of("gpt-3.5-turbo-16k"))

            @JvmField val GPT_3_5_TURBO_0301 = Model(JsonField.of("gpt-3.5-turbo-0301"))

            @JvmField val GPT_3_5_TURBO_0613 = Model(JsonField.of("gpt-3.5-turbo-0613"))

            @JvmField val GPT_3_5_TURBO_1106 = Model(JsonField.of("gpt-3.5-turbo-1106"))

            @JvmField val GPT_3_5_TURBO_0125 = Model(JsonField.of("gpt-3.5-turbo-0125"))

            @JvmField val GPT_3_5_TURBO_16K_0613 = Model(JsonField.of("gpt-3.5-turbo-16k-0613"))

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        enum class Known {
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            CHATGPT_4O_LATEST,
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
        }

        enum class Value {
            O1_PREVIEW,
            O1_PREVIEW_2024_09_12,
            O1_MINI,
            O1_MINI_2024_09_12,
            GPT_4O,
            GPT_4O_2024_11_20,
            GPT_4O_2024_08_06,
            GPT_4O_2024_05_13,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_AUDIO_PREVIEW,
            GPT_4O_AUDIO_PREVIEW_2024_10_01,
            CHATGPT_4O_LATEST,
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
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                O1_PREVIEW -> Value.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Value.O1_PREVIEW_2024_09_12
                O1_MINI -> Value.O1_MINI
                O1_MINI_2024_09_12 -> Value.O1_MINI_2024_09_12
                GPT_4O -> Value.GPT_4O
                GPT_4O_2024_11_20 -> Value.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Value.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Value.GPT_4O_2024_05_13
                GPT_4O_REALTIME_PREVIEW -> Value.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Value.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW -> Value.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Value.GPT_4O_AUDIO_PREVIEW_2024_10_01
                CHATGPT_4O_LATEST -> Value.CHATGPT_4O_LATEST
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
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                O1_PREVIEW -> Known.O1_PREVIEW
                O1_PREVIEW_2024_09_12 -> Known.O1_PREVIEW_2024_09_12
                O1_MINI -> Known.O1_MINI
                O1_MINI_2024_09_12 -> Known.O1_MINI_2024_09_12
                GPT_4O -> Known.GPT_4O
                GPT_4O_2024_11_20 -> Known.GPT_4O_2024_11_20
                GPT_4O_2024_08_06 -> Known.GPT_4O_2024_08_06
                GPT_4O_2024_05_13 -> Known.GPT_4O_2024_05_13
                GPT_4O_REALTIME_PREVIEW -> Known.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Known.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_AUDIO_PREVIEW -> Known.GPT_4O_AUDIO_PREVIEW
                GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Known.GPT_4O_AUDIO_PREVIEW_2024_10_01
                CHATGPT_4O_LATEST -> Known.CHATGPT_4O_LATEST
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
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(using = FunctionCall.Deserializer::class)
    @JsonSerialize(using = FunctionCall.Serializer::class)
    class FunctionCall
    private constructor(
        private val behavior: Behavior? = null,
        private val functionCallOption: ChatCompletionFunctionCallOption? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /**
         * `none` means the model will not call a function and instead generates a message. `auto`
         * means the model can pick between generating a message or calling a function.
         */
        fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)
        /**
         * Specifying a particular function via `{"name": "my_function"}` forces the model to call
         * that function.
         */
        fun functionCallOption(): Optional<ChatCompletionFunctionCallOption> =
            Optional.ofNullable(functionCallOption)

        fun isBehavior(): Boolean = behavior != null

        fun isFunctionCallOption(): Boolean = functionCallOption != null

        fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

        fun asFunctionCallOption(): ChatCompletionFunctionCallOption =
            functionCallOption.getOrThrow("functionCallOption")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                behavior != null -> visitor.visitBehavior(behavior)
                functionCallOption != null -> visitor.visitFunctionCallOption(functionCallOption)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): FunctionCall = apply {
            if (!validated) {
                if (behavior == null && functionCallOption == null) {
                    throw OpenAIInvalidDataException("Unknown FunctionCall: $_json")
                }
                functionCallOption?.validate()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FunctionCall && behavior == other.behavior && functionCallOption == other.functionCallOption /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, functionCallOption) /* spotless:on */

        override fun toString(): String =
            when {
                behavior != null -> "FunctionCall{behavior=$behavior}"
                functionCallOption != null -> "FunctionCall{functionCallOption=$functionCallOption}"
                _json != null -> "FunctionCall{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FunctionCall")
            }

        companion object {

            @JvmStatic fun ofBehavior(behavior: Behavior) = FunctionCall(behavior = behavior)

            @JvmStatic
            fun ofFunctionCallOption(functionCallOption: ChatCompletionFunctionCallOption) =
                FunctionCall(functionCallOption = functionCallOption)
        }

        interface Visitor<out T> {

            fun visitBehavior(behavior: Behavior): T

            fun visitFunctionCallOption(functionCallOption: ChatCompletionFunctionCallOption): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown FunctionCall: $json")
            }
        }

        class Deserializer : BaseDeserializer<FunctionCall>(FunctionCall::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FunctionCall {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                    return FunctionCall(behavior = it, _json = json)
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

        class Serializer : BaseSerializer<FunctionCall>(FunctionCall::class) {

            override fun serialize(
                value: FunctionCall,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.behavior != null -> generator.writeObject(value.behavior)
                    value.functionCallOption != null ->
                        generator.writeObject(value.functionCallOption)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FunctionCall")
                }
            }
        }

        class Behavior
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val NONE = Behavior(JsonField.of("none"))

                @JvmField val AUTO = Behavior(JsonField.of("auto"))

                @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
            }

            enum class Known {
                NONE,
                AUTO,
            }

            enum class Value {
                NONE,
                AUTO,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    NONE -> Value.NONE
                    AUTO -> Value.AUTO
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    NONE -> Known.NONE
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    @JsonDeserialize(builder = Function.Builder::class)
    @NoAutoDetect
    class Function
    private constructor(
        private val description: String?,
        private val name: String?,
        private val parameters: FunctionParameters?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         */
        @JsonProperty("description") fun description(): String? = description

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        @JsonProperty("name") fun name(): String? = name

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         */
        @JsonProperty("parameters") fun parameters(): FunctionParameters? = parameters

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var description: String? = null
            private var name: String? = null
            private var parameters: FunctionParameters? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                this.description = function.description
                this.name = function.name
                this.parameters = function.parameters
                additionalProperties(function.additionalProperties)
            }

            /**
             * A description of what the function does, used by the model to choose when and how to
             * call the function.
             */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /**
             * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores
             * and dashes, with a maximum length of 64.
             */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /**
             * The parameters the functions accepts, described as a JSON Schema object. See the
             * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and
             * the [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
             * documentation about the format.
             *
             * Omitting `parameters` defines a function with an empty parameter list.
             */
            @JsonProperty("parameters")
            fun parameters(parameters: FunctionParameters) = apply { this.parameters = parameters }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Function =
                Function(
                    description,
                    checkNotNull(name) { "`name` is required but was not set" },
                    parameters,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && description == other.description && name == other.name && parameters == other.parameters && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, name, parameters, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{description=$description, name=$name, parameters=$parameters, additionalProperties=$additionalProperties}"
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
    @JsonDeserialize(builder = LogitBias.Builder::class)
    @NoAutoDetect
    class LogitBias
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logitBias: LogitBias) = apply {
                additionalProperties(logitBias.additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): LogitBias = LogitBias(additionalProperties.toImmutable())
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

    /**
     * Developer-defined tags and values used for filtering completions in the
     * [dashboard](https://platform.openai.com/chat-completions).
     */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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

    @JsonDeserialize(using = ResponseFormat.Deserializer::class)
    @JsonSerialize(using = ResponseFormat.Serializer::class)
    class ResponseFormat
    private constructor(
        private val responseFormatText: ResponseFormatText? = null,
        private val responseFormatJsonObject: ResponseFormatJsonObject? = null,
        private val responseFormatJsonSchema: ResponseFormatJsonSchema? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun responseFormatText(): Optional<ResponseFormatText> =
            Optional.ofNullable(responseFormatText)

        fun responseFormatJsonObject(): Optional<ResponseFormatJsonObject> =
            Optional.ofNullable(responseFormatJsonObject)

        fun responseFormatJsonSchema(): Optional<ResponseFormatJsonSchema> =
            Optional.ofNullable(responseFormatJsonSchema)

        fun isResponseFormatText(): Boolean = responseFormatText != null

        fun isResponseFormatJsonObject(): Boolean = responseFormatJsonObject != null

        fun isResponseFormatJsonSchema(): Boolean = responseFormatJsonSchema != null

        fun asResponseFormatText(): ResponseFormatText =
            responseFormatText.getOrThrow("responseFormatText")

        fun asResponseFormatJsonObject(): ResponseFormatJsonObject =
            responseFormatJsonObject.getOrThrow("responseFormatJsonObject")

        fun asResponseFormatJsonSchema(): ResponseFormatJsonSchema =
            responseFormatJsonSchema.getOrThrow("responseFormatJsonSchema")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                responseFormatText != null -> visitor.visitResponseFormatText(responseFormatText)
                responseFormatJsonObject != null ->
                    visitor.visitResponseFormatJsonObject(responseFormatJsonObject)
                responseFormatJsonSchema != null ->
                    visitor.visitResponseFormatJsonSchema(responseFormatJsonSchema)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): ResponseFormat = apply {
            if (!validated) {
                if (
                    responseFormatText == null &&
                        responseFormatJsonObject == null &&
                        responseFormatJsonSchema == null
                ) {
                    throw OpenAIInvalidDataException("Unknown ResponseFormat: $_json")
                }
                responseFormatText?.validate()
                responseFormatJsonObject?.validate()
                responseFormatJsonSchema?.validate()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && responseFormatText == other.responseFormatText && responseFormatJsonObject == other.responseFormatJsonObject && responseFormatJsonSchema == other.responseFormatJsonSchema /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(responseFormatText, responseFormatJsonObject, responseFormatJsonSchema) /* spotless:on */

        override fun toString(): String =
            when {
                responseFormatText != null ->
                    "ResponseFormat{responseFormatText=$responseFormatText}"
                responseFormatJsonObject != null ->
                    "ResponseFormat{responseFormatJsonObject=$responseFormatJsonObject}"
                responseFormatJsonSchema != null ->
                    "ResponseFormat{responseFormatJsonSchema=$responseFormatJsonSchema}"
                _json != null -> "ResponseFormat{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ResponseFormat")
            }

        companion object {

            @JvmStatic
            fun ofResponseFormatText(responseFormatText: ResponseFormatText) =
                ResponseFormat(responseFormatText = responseFormatText)

            @JvmStatic
            fun ofResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject) =
                ResponseFormat(responseFormatJsonObject = responseFormatJsonObject)

            @JvmStatic
            fun ofResponseFormatJsonSchema(responseFormatJsonSchema: ResponseFormatJsonSchema) =
                ResponseFormat(responseFormatJsonSchema = responseFormatJsonSchema)
        }

        interface Visitor<out T> {

            fun visitResponseFormatText(responseFormatText: ResponseFormatText): T

            fun visitResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject): T

            fun visitResponseFormatJsonSchema(responseFormatJsonSchema: ResponseFormatJsonSchema): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ResponseFormat: $json")
            }
        }

        class Deserializer : BaseDeserializer<ResponseFormat>(ResponseFormat::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ResponseFormat {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<ResponseFormatText>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(responseFormatText = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonObject>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(responseFormatJsonObject = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonSchema>()) { it.validate() }
                    ?.let {
                        return ResponseFormat(responseFormatJsonSchema = it, _json = json)
                    }

                return ResponseFormat(_json = json)
            }
        }

        class Serializer : BaseSerializer<ResponseFormat>(ResponseFormat::class) {

            override fun serialize(
                value: ResponseFormat,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.responseFormatText != null ->
                        generator.writeObject(value.responseFormatText)
                    value.responseFormatJsonObject != null ->
                        generator.writeObject(value.responseFormatJsonObject)
                    value.responseFormatJsonSchema != null ->
                        generator.writeObject(value.responseFormatJsonSchema)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ResponseFormat")
                }
            }
        }
    }

    class ServiceTier
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ServiceTier && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val AUTO = ServiceTier(JsonField.of("auto"))

            @JvmField val DEFAULT = ServiceTier(JsonField.of("default"))

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        enum class Known {
            AUTO,
            DEFAULT,
        }

        enum class Value {
            AUTO,
            DEFAULT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                DEFAULT -> Value.DEFAULT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                DEFAULT -> Known.DEFAULT
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(using = Stop.Deserializer::class)
    @JsonSerialize(using = Stop.Serializer::class)
    class Stop
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

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

        fun validate(): Stop = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw OpenAIInvalidDataException("Unknown Stop: $_json")
                }
                validated = true
            }
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

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Stop: $json")
            }
        }

        class Deserializer : BaseDeserializer<Stop>(Stop::class) {

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

        class Serializer : BaseSerializer<Stop>(Stop::class) {

            override fun serialize(
                value: Stop,
                generator: JsonGenerator,
                provider: SerializerProvider
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
}
