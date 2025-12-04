// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

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
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioFormats
import com.openai.models.realtime.RealtimeFunctionTool
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.realtime.RealtimeTruncationRetentionRatio
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceMcp
import com.openai.models.responses.ToolChoiceOptions
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A new Realtime session configuration, with an ephemeral key. Default TTL for keys is one minute.
 */
class RealtimeSessionCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val clientSecret: JsonField<RealtimeSessionClientSecret>,
    private val type: JsonValue,
    private val audio: JsonField<Audio>,
    private val include: JsonField<List<Include>>,
    private val instructions: JsonField<String>,
    private val maxOutputTokens: JsonField<MaxOutputTokens>,
    private val model: JsonField<Model>,
    private val outputModalities: JsonField<List<OutputModality>>,
    private val prompt: JsonField<ResponsePrompt>,
    private val toolChoice: JsonField<ToolChoice>,
    private val tools: JsonField<List<Tool>>,
    private val tracing: JsonField<Tracing>,
    private val truncation: JsonField<RealtimeTruncation>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("client_secret")
        @ExcludeMissing
        clientSecret: JsonField<RealtimeSessionClientSecret> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
        @JsonProperty("include")
        @ExcludeMissing
        include: JsonField<List<Include>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("output_modalities")
        @ExcludeMissing
        outputModalities: JsonField<List<OutputModality>> = JsonMissing.of(),
        @JsonProperty("prompt")
        @ExcludeMissing
        prompt: JsonField<ResponsePrompt> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("tracing") @ExcludeMissing tracing: JsonField<Tracing> = JsonMissing.of(),
        @JsonProperty("truncation")
        @ExcludeMissing
        truncation: JsonField<RealtimeTruncation> = JsonMissing.of(),
    ) : this(
        clientSecret,
        type,
        audio,
        include,
        instructions,
        maxOutputTokens,
        model,
        outputModalities,
        prompt,
        toolChoice,
        tools,
        tracing,
        truncation,
        mutableMapOf(),
    )

    /**
     * Ephemeral key returned by the API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clientSecret(): RealtimeSessionClientSecret = clientSecret.getRequired("client_secret")

    /**
     * The type of session to create. Always `realtime` for the Realtime API.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("realtime")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Configuration for input and output audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<Audio> = audio.getOptional("audio")

    /**
     * Additional fields to include in server outputs.
     *
     * `item.input_audio_transcription.logprobs`: Include logprobs for input audio transcription.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun include(): Optional<List<Include>> = include.getOptional("include")

    /**
     * The default system instructions (i.e. system message) prepended to model calls. This field
     * allows the client to guide the model on desired responses. The model can be instructed on
     * response content and format, (e.g. "be extremely succinct", "act friendly", "here are
     * examples of good responses") and on audio behavior (e.g. "talk quickly", "inject emotion into
     * your voice", "laugh frequently"). The instructions are not guaranteed to be followed by the
     * model, but they provide guidance to the model on the desired behavior.
     *
     * Note that the server sets default instructions which will be used if this field is not set
     * and are visible in the `session.created` event at the start of the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = instructions.getOptional("instructions")

    /**
     * Maximum number of output tokens for a single assistant response, inclusive of tool calls.
     * Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the maximum
     * available tokens for a given model. Defaults to `inf`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxOutputTokens(): Optional<MaxOutputTokens> =
        maxOutputTokens.getOptional("max_output_tokens")

    /**
     * The Realtime model used for this session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = model.getOptional("model")

    /**
     * The set of modalities the model can respond with. It defaults to `["audio"]`, indicating that
     * the model will respond with audio plus a transcript. `["text"]` can be used to make the model
     * respond with text only. It is not possible to request both `text` and `audio` at the same
     * time.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputModalities(): Optional<List<OutputModality>> =
        outputModalities.getOptional("output_modalities")

    /**
     * Reference to a prompt template and its variables.
     * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<ResponsePrompt> = prompt.getOptional("prompt")

    /**
     * How the model chooses tools. Provide one of the string modes or force a specific function/MCP
     * tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

    /**
     * Tools available to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = tools.getOptional("tools")

    /**
     * Realtime API can write session traces to the [Traces Dashboard](/logs?api=traces). Set to
     * null to disable tracing. Once tracing is enabled for a session, the configuration cannot be
     * modified.
     *
     * `auto` will create a trace for the session with default values for the workflow name, group
     * id, and metadata.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tracing(): Optional<Tracing> = tracing.getOptional("tracing")

    /**
     * When the number of tokens in a conversation exceeds the model's input token limit, the
     * conversation be truncated, meaning messages (starting from the oldest) will not be included
     * in the model's context. A 32k context model with 4,096 max output tokens can only include
     * 28,224 tokens in the context before truncation occurs.
     *
     * Clients can configure truncation behavior to truncate with a lower max token limit, which is
     * an effective way to control token usage and cost.
     *
     * Truncation will reduce the number of cached tokens on the next turn (busting the cache),
     * since messages are dropped from the beginning of the context. However, clients can also
     * configure truncation to retain messages up to a fraction of the maximum context size, which
     * will reduce the need for future truncations and thus improve the cache rate.
     *
     * Truncation can be disabled entirely, which means the server will never truncate but would
     * instead return an error if the conversation exceeds the model's input token limit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun truncation(): Optional<RealtimeTruncation> = truncation.getOptional("truncation")

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_secret")
    @ExcludeMissing
    fun _clientSecret(): JsonField<RealtimeSessionClientSecret> = clientSecret

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Audio> = audio

    /**
     * Returns the raw JSON value of [include].
     *
     * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("include") @ExcludeMissing fun _include(): JsonField<List<Include>> = include

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [maxOutputTokens].
     *
     * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    fun _maxOutputTokens(): JsonField<MaxOutputTokens> = maxOutputTokens

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * Returns the raw JSON value of [outputModalities].
     *
     * Unlike [outputModalities], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("output_modalities")
    @ExcludeMissing
    fun _outputModalities(): JsonField<List<OutputModality>> = outputModalities

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<ResponsePrompt> = prompt

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
     * Returns the raw JSON value of [tracing].
     *
     * Unlike [tracing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tracing") @ExcludeMissing fun _tracing(): JsonField<Tracing> = tracing

    /**
     * Returns the raw JSON value of [truncation].
     *
     * Unlike [truncation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("truncation")
    @ExcludeMissing
    fun _truncation(): JsonField<RealtimeTruncation> = truncation

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
         * Returns a mutable builder for constructing an instance of
         * [RealtimeSessionCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .clientSecret()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeSessionCreateResponse]. */
    class Builder internal constructor() {

        private var clientSecret: JsonField<RealtimeSessionClientSecret>? = null
        private var type: JsonValue = JsonValue.from("realtime")
        private var audio: JsonField<Audio> = JsonMissing.of()
        private var include: JsonField<MutableList<Include>>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
        private var model: JsonField<Model> = JsonMissing.of()
        private var outputModalities: JsonField<MutableList<OutputModality>>? = null
        private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
        private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
        private var tools: JsonField<MutableList<Tool>>? = null
        private var tracing: JsonField<Tracing> = JsonMissing.of()
        private var truncation: JsonField<RealtimeTruncation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeSessionCreateResponse: RealtimeSessionCreateResponse) = apply {
            clientSecret = realtimeSessionCreateResponse.clientSecret
            type = realtimeSessionCreateResponse.type
            audio = realtimeSessionCreateResponse.audio
            include = realtimeSessionCreateResponse.include.map { it.toMutableList() }
            instructions = realtimeSessionCreateResponse.instructions
            maxOutputTokens = realtimeSessionCreateResponse.maxOutputTokens
            model = realtimeSessionCreateResponse.model
            outputModalities =
                realtimeSessionCreateResponse.outputModalities.map { it.toMutableList() }
            prompt = realtimeSessionCreateResponse.prompt
            toolChoice = realtimeSessionCreateResponse.toolChoice
            tools = realtimeSessionCreateResponse.tools.map { it.toMutableList() }
            tracing = realtimeSessionCreateResponse.tracing
            truncation = realtimeSessionCreateResponse.truncation
            additionalProperties = realtimeSessionCreateResponse.additionalProperties.toMutableMap()
        }

        /** Ephemeral key returned by the API. */
        fun clientSecret(clientSecret: RealtimeSessionClientSecret) =
            clientSecret(JsonField.of(clientSecret))

        /**
         * Sets [Builder.clientSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientSecret] with a well-typed
         * [RealtimeSessionClientSecret] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun clientSecret(clientSecret: JsonField<RealtimeSessionClientSecret>) = apply {
            this.clientSecret = clientSecret
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("realtime")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Configuration for input and output audio. */
        fun audio(audio: Audio) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

        /**
         * Additional fields to include in server outputs.
         *
         * `item.input_audio_transcription.logprobs`: Include logprobs for input audio
         * transcription.
         */
        fun include(include: List<Include>) = include(JsonField.of(include))

        /**
         * Sets [Builder.include] to an arbitrary JSON value.
         *
         * You should usually call [Builder.include] with a well-typed `List<Include>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun include(include: JsonField<List<Include>>) = apply {
            this.include = include.map { it.toMutableList() }
        }

        /**
         * Adds a single [Include] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: Include) = apply {
            this.include =
                (this.include ?: JsonField.of(mutableListOf())).also {
                    checkKnown("include", it).add(include)
                }
        }

        /**
         * The default system instructions (i.e. system message) prepended to model calls. This
         * field allows the client to guide the model on desired responses. The model can be
         * instructed on response content and format, (e.g. "be extremely succinct", "act friendly",
         * "here are examples of good responses") and on audio behavior (e.g. "talk quickly",
         * "inject emotion into your voice", "laugh frequently"). The instructions are not
         * guaranteed to be followed by the model, but they provide guidance to the model on the
         * desired behavior.
         *
         * Note that the server sets default instructions which will be used if this field is not
         * set and are visible in the `session.created` event at the start of the session.
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

        /**
         * Maximum number of output tokens for a single assistant response, inclusive of tool calls.
         * Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the maximum
         * available tokens for a given model. Defaults to `inf`.
         */
        fun maxOutputTokens(maxOutputTokens: MaxOutputTokens) =
            maxOutputTokens(JsonField.of(maxOutputTokens))

        /**
         * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxOutputTokens] with a well-typed [MaxOutputTokens]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<MaxOutputTokens>) = apply {
            this.maxOutputTokens = maxOutputTokens
        }

        /** Alias for calling [maxOutputTokens] with `MaxOutputTokens.ofInteger(integer)`. */
        fun maxOutputTokens(integer: Long) = maxOutputTokens(MaxOutputTokens.ofInteger(integer))

        /** Alias for calling [maxOutputTokens] with `MaxOutputTokens.ofInf()`. */
        fun maxOutputTokensInf() = maxOutputTokens(MaxOutputTokens.ofInf())

        /** The Realtime model used for this session. */
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
         * The set of modalities the model can respond with. It defaults to `["audio"]`, indicating
         * that the model will respond with audio plus a transcript. `["text"]` can be used to make
         * the model respond with text only. It is not possible to request both `text` and `audio`
         * at the same time.
         */
        fun outputModalities(outputModalities: List<OutputModality>) =
            outputModalities(JsonField.of(outputModalities))

        /**
         * Sets [Builder.outputModalities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputModalities] with a well-typed
         * `List<OutputModality>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun outputModalities(outputModalities: JsonField<List<OutputModality>>) = apply {
            this.outputModalities = outputModalities.map { it.toMutableList() }
        }

        /**
         * Adds a single [OutputModality] to [outputModalities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOutputModality(outputModality: OutputModality) = apply {
            outputModalities =
                (outputModalities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("outputModalities", it).add(outputModality)
                }
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
         * How the model chooses tools. Provide one of the string modes or force a specific
         * function/MCP tool.
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

        /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
        fun toolChoice(function: ToolChoiceFunction) = toolChoice(ToolChoice.ofFunction(function))

        /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
        fun toolChoice(mcp: ToolChoiceMcp) = toolChoice(ToolChoice.ofMcp(mcp))

        /** Tools available to the model. */
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

        /** Alias for calling [addTool] with `Tool.ofRealtimeFunction(realtimeFunction)`. */
        fun addTool(realtimeFunction: RealtimeFunctionTool) =
            addTool(Tool.ofRealtimeFunction(realtimeFunction))

        /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
        fun addTool(mcp: Tool.McpTool) = addTool(Tool.ofMcp(mcp))

        /**
         * Realtime API can write session traces to the [Traces Dashboard](/logs?api=traces). Set to
         * null to disable tracing. Once tracing is enabled for a session, the configuration cannot
         * be modified.
         *
         * `auto` will create a trace for the session with default values for the workflow name,
         * group id, and metadata.
         */
        fun tracing(tracing: Tracing?) = tracing(JsonField.ofNullable(tracing))

        /** Alias for calling [Builder.tracing] with `tracing.orElse(null)`. */
        fun tracing(tracing: Optional<Tracing>) = tracing(tracing.getOrNull())

        /**
         * Sets [Builder.tracing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tracing] with a well-typed [Tracing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tracing(tracing: JsonField<Tracing>) = apply { this.tracing = tracing }

        /** Alias for calling [tracing] with `Tracing.ofAuto()`. */
        fun tracingAuto() = tracing(Tracing.ofAuto())

        /** Alias for calling [tracing] with `Tracing.ofConfiguration(configuration)`. */
        fun tracing(configuration: Tracing.TracingConfiguration) =
            tracing(Tracing.ofConfiguration(configuration))

        /**
         * When the number of tokens in a conversation exceeds the model's input token limit, the
         * conversation be truncated, meaning messages (starting from the oldest) will not be
         * included in the model's context. A 32k context model with 4,096 max output tokens can
         * only include 28,224 tokens in the context before truncation occurs.
         *
         * Clients can configure truncation behavior to truncate with a lower max token limit, which
         * is an effective way to control token usage and cost.
         *
         * Truncation will reduce the number of cached tokens on the next turn (busting the cache),
         * since messages are dropped from the beginning of the context. However, clients can also
         * configure truncation to retain messages up to a fraction of the maximum context size,
         * which will reduce the need for future truncations and thus improve the cache rate.
         *
         * Truncation can be disabled entirely, which means the server will never truncate but would
         * instead return an error if the conversation exceeds the model's input token limit.
         */
        fun truncation(truncation: RealtimeTruncation) = truncation(JsonField.of(truncation))

        /**
         * Sets [Builder.truncation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.truncation] with a well-typed [RealtimeTruncation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun truncation(truncation: JsonField<RealtimeTruncation>) = apply {
            this.truncation = truncation
        }

        /** Alias for calling [truncation] with `RealtimeTruncation.ofStrategy(strategy)`. */
        fun truncation(strategy: RealtimeTruncation.RealtimeTruncationStrategy) =
            truncation(RealtimeTruncation.ofStrategy(strategy))

        /**
         * Alias for calling [truncation] with
         * `RealtimeTruncation.ofRetentionRatio(retentionRatio)`.
         */
        fun truncation(retentionRatio: RealtimeTruncationRetentionRatio) =
            truncation(RealtimeTruncation.ofRetentionRatio(retentionRatio))

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
         * Returns an immutable instance of [RealtimeSessionCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .clientSecret()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeSessionCreateResponse =
            RealtimeSessionCreateResponse(
                checkRequired("clientSecret", clientSecret),
                type,
                audio,
                (include ?: JsonMissing.of()).map { it.toImmutable() },
                instructions,
                maxOutputTokens,
                model,
                (outputModalities ?: JsonMissing.of()).map { it.toImmutable() },
                prompt,
                toolChoice,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
                tracing,
                truncation,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeSessionCreateResponse = apply {
        if (validated) {
            return@apply
        }

        clientSecret().validate()
        _type().let {
            if (it != JsonValue.from("realtime")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        audio().ifPresent { it.validate() }
        include().ifPresent { it.forEach { it.validate() } }
        instructions()
        maxOutputTokens().ifPresent { it.validate() }
        model()
        outputModalities().ifPresent { it.forEach { it.validate() } }
        prompt().ifPresent { it.validate() }
        toolChoice().ifPresent { it.validate() }
        tools().ifPresent { it.forEach { it.validate() } }
        tracing().ifPresent { it.validate() }
        truncation().ifPresent { it.validate() }
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
        (clientSecret.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("realtime")) 1 else 0 } +
            (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (maxOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (outputModalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (prompt.asKnown().getOrNull()?.validity() ?: 0) +
            (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (tracing.asKnown().getOrNull()?.validity() ?: 0) +
            (truncation.asKnown().getOrNull()?.validity() ?: 0)

    /** Configuration for input and output audio. */
    class Audio
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
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<Input> = input.getOptional("input")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
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

            /** Returns a mutable builder for constructing an instance of [Audio]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Audio]. */
        class Builder internal constructor() {

            private var input: JsonField<Input> = JsonMissing.of()
            private var output: JsonField<Output> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audio: Audio) = apply {
                input = audio.input
                output = audio.output
                additionalProperties = audio.additionalProperties.toMutableMap()
            }

            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            fun output(output: Output) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

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
             * Returns an immutable instance of [Audio].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Audio = Audio(input, output, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Audio = apply {
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

        class Input
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val format: JsonField<RealtimeAudioFormats>,
            private val noiseReduction: JsonField<NoiseReduction>,
            private val transcription: JsonField<AudioTranscription>,
            private val turnDetection: JsonField<TurnDetection>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("format")
                @ExcludeMissing
                format: JsonField<RealtimeAudioFormats> = JsonMissing.of(),
                @JsonProperty("noise_reduction")
                @ExcludeMissing
                noiseReduction: JsonField<NoiseReduction> = JsonMissing.of(),
                @JsonProperty("transcription")
                @ExcludeMissing
                transcription: JsonField<AudioTranscription> = JsonMissing.of(),
                @JsonProperty("turn_detection")
                @ExcludeMissing
                turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
            ) : this(format, noiseReduction, transcription, turnDetection, mutableMapOf())

            /**
             * The format of the input audio.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

            /**
             * Configuration for input audio noise reduction. This can be set to `null` to turn off.
             * Noise reduction filters audio added to the input audio buffer before it is sent to
             * VAD and the model. Filtering the audio can improve VAD and turn detection accuracy
             * (reducing false positives) and model performance by improving perception of the input
             * audio.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun noiseReduction(): Optional<NoiseReduction> =
                noiseReduction.getOptional("noise_reduction")

            /**
             * Configuration for input audio transcription, defaults to off and can be set to `null`
             * to turn off once on. Input audio transcription is not native to the model, since the
             * model consumes audio directly. Transcription runs asynchronously through
             * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
             * and should be treated as guidance of input audio content rather than precisely what
             * the model heard. The client can optionally set the language and prompt for
             * transcription, these offer additional guidance to the transcription service.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun transcription(): Optional<AudioTranscription> =
                transcription.getOptional("transcription")

            /**
             * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set
             * to `null` to turn off, in which case the client must manually trigger model response.
             *
             * Server VAD means that the model will detect the start and end of speech based on
             * audio volume and respond at the end of user speech.
             *
             * Semantic VAD is more advanced and uses a turn detection model (in conjunction with
             * VAD) to semantically estimate whether the user has finished speaking, then
             * dynamically sets a timeout based on this probability. For example, if user audio
             * trails off with "uhhm", the model will score a low probability of turn end and wait
             * longer for the user to continue speaking. This can be useful for more natural
             * conversations, but may have a higher latency.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun turnDetection(): Optional<TurnDetection> =
                turnDetection.getOptional("turn_detection")

            /**
             * Returns the raw JSON value of [format].
             *
             * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("format")
            @ExcludeMissing
            fun _format(): JsonField<RealtimeAudioFormats> = format

            /**
             * Returns the raw JSON value of [noiseReduction].
             *
             * Unlike [noiseReduction], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("noise_reduction")
            @ExcludeMissing
            fun _noiseReduction(): JsonField<NoiseReduction> = noiseReduction

            /**
             * Returns the raw JSON value of [transcription].
             *
             * Unlike [transcription], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transcription")
            @ExcludeMissing
            fun _transcription(): JsonField<AudioTranscription> = transcription

            /**
             * Returns the raw JSON value of [turnDetection].
             *
             * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("turn_detection")
            @ExcludeMissing
            fun _turnDetection(): JsonField<TurnDetection> = turnDetection

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

                /** Returns a mutable builder for constructing an instance of [Input]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Input]. */
            class Builder internal constructor() {

                private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
                private var noiseReduction: JsonField<NoiseReduction> = JsonMissing.of()
                private var transcription: JsonField<AudioTranscription> = JsonMissing.of()
                private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(input: Input) = apply {
                    format = input.format
                    noiseReduction = input.noiseReduction
                    transcription = input.transcription
                    turnDetection = input.turnDetection
                    additionalProperties = input.additionalProperties.toMutableMap()
                }

                /** The format of the input audio. */
                fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

                /**
                 * Sets [Builder.format] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

                /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
                fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
                    format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`.
                 */
                fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
                    format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`.
                 */
                fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
                    format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

                /**
                 * Configuration for input audio noise reduction. This can be set to `null` to turn
                 * off. Noise reduction filters audio added to the input audio buffer before it is
                 * sent to VAD and the model. Filtering the audio can improve VAD and turn detection
                 * accuracy (reducing false positives) and model performance by improving perception
                 * of the input audio.
                 */
                fun noiseReduction(noiseReduction: NoiseReduction) =
                    noiseReduction(JsonField.of(noiseReduction))

                /**
                 * Sets [Builder.noiseReduction] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.noiseReduction] with a well-typed
                 * [NoiseReduction] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun noiseReduction(noiseReduction: JsonField<NoiseReduction>) = apply {
                    this.noiseReduction = noiseReduction
                }

                /**
                 * Configuration for input audio transcription, defaults to off and can be set to
                 * `null` to turn off once on. Input audio transcription is not native to the model,
                 * since the model consumes audio directly. Transcription runs asynchronously
                 * through
                 * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
                 * and should be treated as guidance of input audio content rather than precisely
                 * what the model heard. The client can optionally set the language and prompt for
                 * transcription, these offer additional guidance to the transcription service.
                 */
                fun transcription(transcription: AudioTranscription) =
                    transcription(JsonField.of(transcription))

                /**
                 * Sets [Builder.transcription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transcription] with a well-typed
                 * [AudioTranscription] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun transcription(transcription: JsonField<AudioTranscription>) = apply {
                    this.transcription = transcription
                }

                /**
                 * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be
                 * set to `null` to turn off, in which case the client must manually trigger model
                 * response.
                 *
                 * Server VAD means that the model will detect the start and end of speech based on
                 * audio volume and respond at the end of user speech.
                 *
                 * Semantic VAD is more advanced and uses a turn detection model (in conjunction
                 * with VAD) to semantically estimate whether the user has finished speaking, then
                 * dynamically sets a timeout based on this probability. For example, if user audio
                 * trails off with "uhhm", the model will score a low probability of turn end and
                 * wait longer for the user to continue speaking. This can be useful for more
                 * natural conversations, but may have a higher latency.
                 */
                fun turnDetection(turnDetection: TurnDetection?) =
                    turnDetection(JsonField.ofNullable(turnDetection))

                /** Alias for calling [Builder.turnDetection] with `turnDetection.orElse(null)`. */
                fun turnDetection(turnDetection: Optional<TurnDetection>) =
                    turnDetection(turnDetection.getOrNull())

                /**
                 * Sets [Builder.turnDetection] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.turnDetection] with a well-typed [TurnDetection]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun turnDetection(turnDetection: JsonField<TurnDetection>) = apply {
                    this.turnDetection = turnDetection
                }

                /**
                 * Alias for calling [turnDetection] with `TurnDetection.ofServerVad(serverVad)`.
                 */
                fun turnDetection(serverVad: TurnDetection.ServerVad) =
                    turnDetection(TurnDetection.ofServerVad(serverVad))

                /**
                 * Alias for calling [turnDetection] with
                 * `TurnDetection.ofSemanticVad(semanticVad)`.
                 */
                fun turnDetection(semanticVad: TurnDetection.SemanticVad) =
                    turnDetection(TurnDetection.ofSemanticVad(semanticVad))

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
                 */
                fun build(): Input =
                    Input(
                        format,
                        noiseReduction,
                        transcription,
                        turnDetection,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Input = apply {
                if (validated) {
                    return@apply
                }

                format().ifPresent { it.validate() }
                noiseReduction().ifPresent { it.validate() }
                transcription().ifPresent { it.validate() }
                turnDetection().ifPresent { it.validate() }
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
                (format.asKnown().getOrNull()?.validity() ?: 0) +
                    (noiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                    (transcription.asKnown().getOrNull()?.validity() ?: 0) +
                    (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Configuration for input audio noise reduction. This can be set to `null` to turn off.
             * Noise reduction filters audio added to the input audio buffer before it is sent to
             * VAD and the model. Filtering the audio can improve VAD and turn detection accuracy
             * (reducing false positives) and model performance by improving perception of the input
             * audio.
             */
            class NoiseReduction
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val type: JsonField<NoiseReductionType>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<NoiseReductionType> = JsonMissing.of()
                ) : this(type, mutableMapOf())

                /**
                 * Type of noise reduction. `near_field` is for close-talking microphones such as
                 * headphones, `far_field` is for far-field microphones such as laptop or conference
                 * room microphones.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<NoiseReductionType> = type.getOptional("type")

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type")
                @ExcludeMissing
                fun _type(): JsonField<NoiseReductionType> = type

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
                     * Returns a mutable builder for constructing an instance of [NoiseReduction].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [NoiseReduction]. */
                class Builder internal constructor() {

                    private var type: JsonField<NoiseReductionType> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(noiseReduction: NoiseReduction) = apply {
                        type = noiseReduction.type
                        additionalProperties = noiseReduction.additionalProperties.toMutableMap()
                    }

                    /**
                     * Type of noise reduction. `near_field` is for close-talking microphones such
                     * as headphones, `far_field` is for far-field microphones such as laptop or
                     * conference room microphones.
                     */
                    fun type(type: NoiseReductionType) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [NoiseReductionType]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun type(type: JsonField<NoiseReductionType>) = apply { this.type = type }

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
                     * Returns an immutable instance of [NoiseReduction].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): NoiseReduction =
                        NoiseReduction(type, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): NoiseReduction = apply {
                    if (validated) {
                        return@apply
                    }

                    type().ifPresent { it.validate() }
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
                internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is NoiseReduction &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "NoiseReduction{type=$type, additionalProperties=$additionalProperties}"
            }

            /**
             * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set
             * to `null` to turn off, in which case the client must manually trigger model response.
             *
             * Server VAD means that the model will detect the start and end of speech based on
             * audio volume and respond at the end of user speech.
             *
             * Semantic VAD is more advanced and uses a turn detection model (in conjunction with
             * VAD) to semantically estimate whether the user has finished speaking, then
             * dynamically sets a timeout based on this probability. For example, if user audio
             * trails off with "uhhm", the model will score a low probability of turn end and wait
             * longer for the user to continue speaking. This can be useful for more natural
             * conversations, but may have a higher latency.
             */
            @JsonDeserialize(using = TurnDetection.Deserializer::class)
            @JsonSerialize(using = TurnDetection.Serializer::class)
            class TurnDetection
            private constructor(
                private val serverVad: ServerVad? = null,
                private val semanticVad: SemanticVad? = null,
                private val _json: JsonValue? = null,
            ) {

                /**
                 * Server-side voice activity detection (VAD) which flips on when user speech is
                 * detected and off after a period of silence.
                 */
                fun serverVad(): Optional<ServerVad> = Optional.ofNullable(serverVad)

                /**
                 * Server-side semantic turn detection which uses a model to determine when the user
                 * has finished speaking.
                 */
                fun semanticVad(): Optional<SemanticVad> = Optional.ofNullable(semanticVad)

                fun isServerVad(): Boolean = serverVad != null

                fun isSemanticVad(): Boolean = semanticVad != null

                /**
                 * Server-side voice activity detection (VAD) which flips on when user speech is
                 * detected and off after a period of silence.
                 */
                fun asServerVad(): ServerVad = serverVad.getOrThrow("serverVad")

                /**
                 * Server-side semantic turn detection which uses a model to determine when the user
                 * has finished speaking.
                 */
                fun asSemanticVad(): SemanticVad = semanticVad.getOrThrow("semanticVad")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        serverVad != null -> visitor.visitServerVad(serverVad)
                        semanticVad != null -> visitor.visitSemanticVad(semanticVad)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): TurnDetection = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitServerVad(serverVad: ServerVad) {
                                serverVad.validate()
                            }

                            override fun visitSemanticVad(semanticVad: SemanticVad) {
                                semanticVad.validate()
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
                            override fun visitServerVad(serverVad: ServerVad) = serverVad.validity()

                            override fun visitSemanticVad(semanticVad: SemanticVad) =
                                semanticVad.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is TurnDetection &&
                        serverVad == other.serverVad &&
                        semanticVad == other.semanticVad
                }

                override fun hashCode(): Int = Objects.hash(serverVad, semanticVad)

                override fun toString(): String =
                    when {
                        serverVad != null -> "TurnDetection{serverVad=$serverVad}"
                        semanticVad != null -> "TurnDetection{semanticVad=$semanticVad}"
                        _json != null -> "TurnDetection{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid TurnDetection")
                    }

                companion object {

                    /**
                     * Server-side voice activity detection (VAD) which flips on when user speech is
                     * detected and off after a period of silence.
                     */
                    @JvmStatic
                    fun ofServerVad(serverVad: ServerVad) = TurnDetection(serverVad = serverVad)

                    /**
                     * Server-side semantic turn detection which uses a model to determine when the
                     * user has finished speaking.
                     */
                    @JvmStatic
                    fun ofSemanticVad(semanticVad: SemanticVad) =
                        TurnDetection(semanticVad = semanticVad)
                }

                /**
                 * An interface that defines how to map each variant of [TurnDetection] to a value
                 * of type [T].
                 */
                interface Visitor<out T> {

                    /**
                     * Server-side voice activity detection (VAD) which flips on when user speech is
                     * detected and off after a period of silence.
                     */
                    fun visitServerVad(serverVad: ServerVad): T

                    /**
                     * Server-side semantic turn detection which uses a model to determine when the
                     * user has finished speaking.
                     */
                    fun visitSemanticVad(semanticVad: SemanticVad): T

                    /**
                     * Maps an unknown variant of [TurnDetection] to a value of type [T].
                     *
                     * An instance of [TurnDetection] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown TurnDetection: $json")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<TurnDetection>(TurnDetection::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): TurnDetection {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "server_vad" -> {
                                return tryDeserialize(node, jacksonTypeRef<ServerVad>())?.let {
                                    TurnDetection(serverVad = it, _json = json)
                                } ?: TurnDetection(_json = json)
                            }
                            "semantic_vad" -> {
                                return tryDeserialize(node, jacksonTypeRef<SemanticVad>())?.let {
                                    TurnDetection(semanticVad = it, _json = json)
                                } ?: TurnDetection(_json = json)
                            }
                        }

                        return TurnDetection(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<TurnDetection>(TurnDetection::class) {

                    override fun serialize(
                        value: TurnDetection,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.serverVad != null -> generator.writeObject(value.serverVad)
                            value.semanticVad != null -> generator.writeObject(value.semanticVad)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid TurnDetection")
                        }
                    }
                }

                /**
                 * Server-side voice activity detection (VAD) which flips on when user speech is
                 * detected and off after a period of silence.
                 */
                class ServerVad
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val type: JsonValue,
                    private val createResponse: JsonField<Boolean>,
                    private val idleTimeoutMs: JsonField<Long>,
                    private val interruptResponse: JsonField<Boolean>,
                    private val prefixPaddingMs: JsonField<Long>,
                    private val silenceDurationMs: JsonField<Long>,
                    private val threshold: JsonField<Double>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("create_response")
                        @ExcludeMissing
                        createResponse: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("idle_timeout_ms")
                        @ExcludeMissing
                        idleTimeoutMs: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("interrupt_response")
                        @ExcludeMissing
                        interruptResponse: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("prefix_padding_ms")
                        @ExcludeMissing
                        prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("silence_duration_ms")
                        @ExcludeMissing
                        silenceDurationMs: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("threshold")
                        @ExcludeMissing
                        threshold: JsonField<Double> = JsonMissing.of(),
                    ) : this(
                        type,
                        createResponse,
                        idleTimeoutMs,
                        interruptResponse,
                        prefixPaddingMs,
                        silenceDurationMs,
                        threshold,
                        mutableMapOf(),
                    )

                    /**
                     * Type of turn detection, `server_vad` to turn on simple Server VAD.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("server_vad")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Whether or not to automatically generate a response when a VAD stop event
                     * occurs. If `interrupt_response` is set to `false` this may fail to create a
                     * response if the model is already responding.
                     *
                     * If both `create_response` and `interrupt_response` are set to `false`, the
                     * model will never respond automatically but VAD events will still be emitted.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun createResponse(): Optional<Boolean> =
                        createResponse.getOptional("create_response")

                    /**
                     * Optional timeout after which a model response will be triggered
                     * automatically. This is useful for situations in which a long pause from the
                     * user is unexpected, such as a phone call. The model will effectively prompt
                     * the user to continue the conversation based on the current context.
                     *
                     * The timeout value will be applied after the last model response's audio has
                     * finished playing, i.e. it's set to the `response.done` time plus audio
                     * playback duration.
                     *
                     * An `input_audio_buffer.timeout_triggered` event (plus events associated with
                     * the Response) will be emitted when the timeout is reached. Idle timeout is
                     * currently only supported for `server_vad` mode.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun idleTimeoutMs(): Optional<Long> =
                        idleTimeoutMs.getOptional("idle_timeout_ms")

                    /**
                     * Whether or not to automatically interrupt (cancel) any ongoing response with
                     * output to the default conversation (i.e. `conversation` of `auto`) when a VAD
                     * start event occurs. If `true` then the response will be cancelled, otherwise
                     * it will continue until complete.
                     *
                     * If both `create_response` and `interrupt_response` are set to `false`, the
                     * model will never respond automatically but VAD events will still be emitted.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun interruptResponse(): Optional<Boolean> =
                        interruptResponse.getOptional("interrupt_response")

                    /**
                     * Used only for `server_vad` mode. Amount of audio to include before the VAD
                     * detected speech (in milliseconds). Defaults to 300ms.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun prefixPaddingMs(): Optional<Long> =
                        prefixPaddingMs.getOptional("prefix_padding_ms")

                    /**
                     * Used only for `server_vad` mode. Duration of silence to detect speech stop
                     * (in milliseconds). Defaults to 500ms. With shorter values the model will
                     * respond more quickly, but may jump in on short pauses from the user.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun silenceDurationMs(): Optional<Long> =
                        silenceDurationMs.getOptional("silence_duration_ms")

                    /**
                     * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0),
                     * this defaults to 0.5. A higher threshold will require louder audio to
                     * activate the model, and thus might perform better in noisy environments.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun threshold(): Optional<Double> = threshold.getOptional("threshold")

                    /**
                     * Returns the raw JSON value of [createResponse].
                     *
                     * Unlike [createResponse], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("create_response")
                    @ExcludeMissing
                    fun _createResponse(): JsonField<Boolean> = createResponse

                    /**
                     * Returns the raw JSON value of [idleTimeoutMs].
                     *
                     * Unlike [idleTimeoutMs], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("idle_timeout_ms")
                    @ExcludeMissing
                    fun _idleTimeoutMs(): JsonField<Long> = idleTimeoutMs

                    /**
                     * Returns the raw JSON value of [interruptResponse].
                     *
                     * Unlike [interruptResponse], this method doesn't throw if the JSON field has
                     * an unexpected type.
                     */
                    @JsonProperty("interrupt_response")
                    @ExcludeMissing
                    fun _interruptResponse(): JsonField<Boolean> = interruptResponse

                    /**
                     * Returns the raw JSON value of [prefixPaddingMs].
                     *
                     * Unlike [prefixPaddingMs], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("prefix_padding_ms")
                    @ExcludeMissing
                    fun _prefixPaddingMs(): JsonField<Long> = prefixPaddingMs

                    /**
                     * Returns the raw JSON value of [silenceDurationMs].
                     *
                     * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has
                     * an unexpected type.
                     */
                    @JsonProperty("silence_duration_ms")
                    @ExcludeMissing
                    fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

                    /**
                     * Returns the raw JSON value of [threshold].
                     *
                     * Unlike [threshold], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("threshold")
                    @ExcludeMissing
                    fun _threshold(): JsonField<Double> = threshold

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
                         * Returns a mutable builder for constructing an instance of [ServerVad].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ServerVad]. */
                    class Builder internal constructor() {

                        private var type: JsonValue = JsonValue.from("server_vad")
                        private var createResponse: JsonField<Boolean> = JsonMissing.of()
                        private var idleTimeoutMs: JsonField<Long> = JsonMissing.of()
                        private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
                        private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
                        private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
                        private var threshold: JsonField<Double> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(serverVad: ServerVad) = apply {
                            type = serverVad.type
                            createResponse = serverVad.createResponse
                            idleTimeoutMs = serverVad.idleTimeoutMs
                            interruptResponse = serverVad.interruptResponse
                            prefixPaddingMs = serverVad.prefixPaddingMs
                            silenceDurationMs = serverVad.silenceDurationMs
                            threshold = serverVad.threshold
                            additionalProperties = serverVad.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("server_vad")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * Whether or not to automatically generate a response when a VAD stop event
                         * occurs. If `interrupt_response` is set to `false` this may fail to create
                         * a response if the model is already responding.
                         *
                         * If both `create_response` and `interrupt_response` are set to `false`,
                         * the model will never respond automatically but VAD events will still be
                         * emitted.
                         */
                        fun createResponse(createResponse: Boolean) =
                            createResponse(JsonField.of(createResponse))

                        /**
                         * Sets [Builder.createResponse] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.createResponse] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun createResponse(createResponse: JsonField<Boolean>) = apply {
                            this.createResponse = createResponse
                        }

                        /**
                         * Optional timeout after which a model response will be triggered
                         * automatically. This is useful for situations in which a long pause from
                         * the user is unexpected, such as a phone call. The model will effectively
                         * prompt the user to continue the conversation based on the current
                         * context.
                         *
                         * The timeout value will be applied after the last model response's audio
                         * has finished playing, i.e. it's set to the `response.done` time plus
                         * audio playback duration.
                         *
                         * An `input_audio_buffer.timeout_triggered` event (plus events associated
                         * with the Response) will be emitted when the timeout is reached. Idle
                         * timeout is currently only supported for `server_vad` mode.
                         */
                        fun idleTimeoutMs(idleTimeoutMs: Long?) =
                            idleTimeoutMs(JsonField.ofNullable(idleTimeoutMs))

                        /**
                         * Alias for [Builder.idleTimeoutMs].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun idleTimeoutMs(idleTimeoutMs: Long) =
                            idleTimeoutMs(idleTimeoutMs as Long?)

                        /**
                         * Alias for calling [Builder.idleTimeoutMs] with
                         * `idleTimeoutMs.orElse(null)`.
                         */
                        fun idleTimeoutMs(idleTimeoutMs: Optional<Long>) =
                            idleTimeoutMs(idleTimeoutMs.getOrNull())

                        /**
                         * Sets [Builder.idleTimeoutMs] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.idleTimeoutMs] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun idleTimeoutMs(idleTimeoutMs: JsonField<Long>) = apply {
                            this.idleTimeoutMs = idleTimeoutMs
                        }

                        /**
                         * Whether or not to automatically interrupt (cancel) any ongoing response
                         * with output to the default conversation (i.e. `conversation` of `auto`)
                         * when a VAD start event occurs. If `true` then the response will be
                         * cancelled, otherwise it will continue until complete.
                         *
                         * If both `create_response` and `interrupt_response` are set to `false`,
                         * the model will never respond automatically but VAD events will still be
                         * emitted.
                         */
                        fun interruptResponse(interruptResponse: Boolean) =
                            interruptResponse(JsonField.of(interruptResponse))

                        /**
                         * Sets [Builder.interruptResponse] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.interruptResponse] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                            this.interruptResponse = interruptResponse
                        }

                        /**
                         * Used only for `server_vad` mode. Amount of audio to include before the
                         * VAD detected speech (in milliseconds). Defaults to 300ms.
                         */
                        fun prefixPaddingMs(prefixPaddingMs: Long) =
                            prefixPaddingMs(JsonField.of(prefixPaddingMs))

                        /**
                         * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.prefixPaddingMs] with a well-typed
                         * [Long] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                            this.prefixPaddingMs = prefixPaddingMs
                        }

                        /**
                         * Used only for `server_vad` mode. Duration of silence to detect speech
                         * stop (in milliseconds). Defaults to 500ms. With shorter values the model
                         * will respond more quickly, but may jump in on short pauses from the user.
                         */
                        fun silenceDurationMs(silenceDurationMs: Long) =
                            silenceDurationMs(JsonField.of(silenceDurationMs))

                        /**
                         * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.silenceDurationMs] with a well-typed
                         * [Long] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                            this.silenceDurationMs = silenceDurationMs
                        }

                        /**
                         * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to
                         * 1.0), this defaults to 0.5. A higher threshold will require louder audio
                         * to activate the model, and thus might perform better in noisy
                         * environments.
                         */
                        fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

                        /**
                         * Sets [Builder.threshold] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.threshold] with a well-typed [Double]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun threshold(threshold: JsonField<Double>) = apply {
                            this.threshold = threshold
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
                         * Returns an immutable instance of [ServerVad].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): ServerVad =
                            ServerVad(
                                type,
                                createResponse,
                                idleTimeoutMs,
                                interruptResponse,
                                prefixPaddingMs,
                                silenceDurationMs,
                                threshold,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): ServerVad = apply {
                        if (validated) {
                            return@apply
                        }

                        _type().let {
                            if (it != JsonValue.from("server_vad")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
                        createResponse()
                        idleTimeoutMs()
                        interruptResponse()
                        prefixPaddingMs()
                        silenceDurationMs()
                        threshold()
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
                        type.let { if (it == JsonValue.from("server_vad")) 1 else 0 } +
                            (if (createResponse.asKnown().isPresent) 1 else 0) +
                            (if (idleTimeoutMs.asKnown().isPresent) 1 else 0) +
                            (if (interruptResponse.asKnown().isPresent) 1 else 0) +
                            (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                            (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                            (if (threshold.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ServerVad &&
                            type == other.type &&
                            createResponse == other.createResponse &&
                            idleTimeoutMs == other.idleTimeoutMs &&
                            interruptResponse == other.interruptResponse &&
                            prefixPaddingMs == other.prefixPaddingMs &&
                            silenceDurationMs == other.silenceDurationMs &&
                            threshold == other.threshold &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            type,
                            createResponse,
                            idleTimeoutMs,
                            interruptResponse,
                            prefixPaddingMs,
                            silenceDurationMs,
                            threshold,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ServerVad{type=$type, createResponse=$createResponse, idleTimeoutMs=$idleTimeoutMs, interruptResponse=$interruptResponse, prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, additionalProperties=$additionalProperties}"
                }

                /**
                 * Server-side semantic turn detection which uses a model to determine when the user
                 * has finished speaking.
                 */
                class SemanticVad
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val type: JsonValue,
                    private val createResponse: JsonField<Boolean>,
                    private val eagerness: JsonField<Eagerness>,
                    private val interruptResponse: JsonField<Boolean>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("create_response")
                        @ExcludeMissing
                        createResponse: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("eagerness")
                        @ExcludeMissing
                        eagerness: JsonField<Eagerness> = JsonMissing.of(),
                        @JsonProperty("interrupt_response")
                        @ExcludeMissing
                        interruptResponse: JsonField<Boolean> = JsonMissing.of(),
                    ) : this(type, createResponse, eagerness, interruptResponse, mutableMapOf())

                    /**
                     * Type of turn detection, `semantic_vad` to turn on Semantic VAD.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("semantic_vad")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Whether or not to automatically generate a response when a VAD stop event
                     * occurs.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun createResponse(): Optional<Boolean> =
                        createResponse.getOptional("create_response")

                    /**
                     * Used only for `semantic_vad` mode. The eagerness of the model to respond.
                     * `low` will wait longer for the user to continue speaking, `high` will respond
                     * more quickly. `auto` is the default and is equivalent to `medium`. `low`,
                     * `medium`, and `high` have max timeouts of 8s, 4s, and 2s respectively.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun eagerness(): Optional<Eagerness> = eagerness.getOptional("eagerness")

                    /**
                     * Whether or not to automatically interrupt any ongoing response with output to
                     * the default conversation (i.e. `conversation` of `auto`) when a VAD start
                     * event occurs.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun interruptResponse(): Optional<Boolean> =
                        interruptResponse.getOptional("interrupt_response")

                    /**
                     * Returns the raw JSON value of [createResponse].
                     *
                     * Unlike [createResponse], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("create_response")
                    @ExcludeMissing
                    fun _createResponse(): JsonField<Boolean> = createResponse

                    /**
                     * Returns the raw JSON value of [eagerness].
                     *
                     * Unlike [eagerness], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("eagerness")
                    @ExcludeMissing
                    fun _eagerness(): JsonField<Eagerness> = eagerness

                    /**
                     * Returns the raw JSON value of [interruptResponse].
                     *
                     * Unlike [interruptResponse], this method doesn't throw if the JSON field has
                     * an unexpected type.
                     */
                    @JsonProperty("interrupt_response")
                    @ExcludeMissing
                    fun _interruptResponse(): JsonField<Boolean> = interruptResponse

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
                         * Returns a mutable builder for constructing an instance of [SemanticVad].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [SemanticVad]. */
                    class Builder internal constructor() {

                        private var type: JsonValue = JsonValue.from("semantic_vad")
                        private var createResponse: JsonField<Boolean> = JsonMissing.of()
                        private var eagerness: JsonField<Eagerness> = JsonMissing.of()
                        private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(semanticVad: SemanticVad) = apply {
                            type = semanticVad.type
                            createResponse = semanticVad.createResponse
                            eagerness = semanticVad.eagerness
                            interruptResponse = semanticVad.interruptResponse
                            additionalProperties = semanticVad.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("semantic_vad")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * Whether or not to automatically generate a response when a VAD stop event
                         * occurs.
                         */
                        fun createResponse(createResponse: Boolean) =
                            createResponse(JsonField.of(createResponse))

                        /**
                         * Sets [Builder.createResponse] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.createResponse] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun createResponse(createResponse: JsonField<Boolean>) = apply {
                            this.createResponse = createResponse
                        }

                        /**
                         * Used only for `semantic_vad` mode. The eagerness of the model to respond.
                         * `low` will wait longer for the user to continue speaking, `high` will
                         * respond more quickly. `auto` is the default and is equivalent to
                         * `medium`. `low`, `medium`, and `high` have max timeouts of 8s, 4s, and 2s
                         * respectively.
                         */
                        fun eagerness(eagerness: Eagerness) = eagerness(JsonField.of(eagerness))

                        /**
                         * Sets [Builder.eagerness] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.eagerness] with a well-typed [Eagerness]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun eagerness(eagerness: JsonField<Eagerness>) = apply {
                            this.eagerness = eagerness
                        }

                        /**
                         * Whether or not to automatically interrupt any ongoing response with
                         * output to the default conversation (i.e. `conversation` of `auto`) when a
                         * VAD start event occurs.
                         */
                        fun interruptResponse(interruptResponse: Boolean) =
                            interruptResponse(JsonField.of(interruptResponse))

                        /**
                         * Sets [Builder.interruptResponse] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.interruptResponse] with a well-typed
                         * [Boolean] value instead. This method is primarily for setting the field
                         * to an undocumented or not yet supported value.
                         */
                        fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                            this.interruptResponse = interruptResponse
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
                         * Returns an immutable instance of [SemanticVad].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): SemanticVad =
                            SemanticVad(
                                type,
                                createResponse,
                                eagerness,
                                interruptResponse,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): SemanticVad = apply {
                        if (validated) {
                            return@apply
                        }

                        _type().let {
                            if (it != JsonValue.from("semantic_vad")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
                        createResponse()
                        eagerness().ifPresent { it.validate() }
                        interruptResponse()
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
                        type.let { if (it == JsonValue.from("semantic_vad")) 1 else 0 } +
                            (if (createResponse.asKnown().isPresent) 1 else 0) +
                            (eagerness.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (interruptResponse.asKnown().isPresent) 1 else 0)

                    /**
                     * Used only for `semantic_vad` mode. The eagerness of the model to respond.
                     * `low` will wait longer for the user to continue speaking, `high` will respond
                     * more quickly. `auto` is the default and is equivalent to `medium`. `low`,
                     * `medium`, and `high` have max timeouts of 8s, 4s, and 2s respectively.
                     */
                    class Eagerness
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val LOW = of("low")

                            @JvmField val MEDIUM = of("medium")

                            @JvmField val HIGH = of("high")

                            @JvmField val AUTO = of("auto")

                            @JvmStatic fun of(value: String) = Eagerness(JsonField.of(value))
                        }

                        /** An enum containing [Eagerness]'s known values. */
                        enum class Known {
                            LOW,
                            MEDIUM,
                            HIGH,
                            AUTO,
                        }

                        /**
                         * An enum containing [Eagerness]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Eagerness] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            LOW,
                            MEDIUM,
                            HIGH,
                            AUTO,
                            /**
                             * An enum member indicating that [Eagerness] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                LOW -> Value.LOW
                                MEDIUM -> Value.MEDIUM
                                HIGH -> Value.HIGH
                                AUTO -> Value.AUTO
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                LOW -> Known.LOW
                                MEDIUM -> Known.MEDIUM
                                HIGH -> Known.HIGH
                                AUTO -> Known.AUTO
                                else ->
                                    throw OpenAIInvalidDataException("Unknown Eagerness: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Eagerness = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Eagerness && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is SemanticVad &&
                            type == other.type &&
                            createResponse == other.createResponse &&
                            eagerness == other.eagerness &&
                            interruptResponse == other.interruptResponse &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            type,
                            createResponse,
                            eagerness,
                            interruptResponse,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "SemanticVad{type=$type, createResponse=$createResponse, eagerness=$eagerness, interruptResponse=$interruptResponse, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Input &&
                    format == other.format &&
                    noiseReduction == other.noiseReduction &&
                    transcription == other.transcription &&
                    turnDetection == other.turnDetection &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    format,
                    noiseReduction,
                    transcription,
                    turnDetection,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Input{format=$format, noiseReduction=$noiseReduction, transcription=$transcription, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
        }

        class Output
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val format: JsonField<RealtimeAudioFormats>,
            private val speed: JsonField<Double>,
            private val voice: JsonField<Voice>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("format")
                @ExcludeMissing
                format: JsonField<RealtimeAudioFormats> = JsonMissing.of(),
                @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
            ) : this(format, speed, voice, mutableMapOf())

            /**
             * The format of the output audio.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

            /**
             * The speed of the model's spoken response as a multiple of the original speed. 1.0 is
             * the default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This value
             * can only be changed in between model turns, not while a response is in progress.
             *
             * This parameter is a post-processing adjustment to the audio after it is generated,
             * it's also possible to prompt the model to speak faster or slower.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun speed(): Optional<Double> = speed.getOptional("speed")

            /**
             * The voice the model uses to respond. Voice cannot be changed during the session once
             * the model has responded with audio at least once. Current voice options are `alloy`,
             * `ash`, `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`.
             * We recommend `marin` and `cedar` for best quality.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun voice(): Optional<Voice> = voice.getOptional("voice")

            /**
             * Returns the raw JSON value of [format].
             *
             * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("format")
            @ExcludeMissing
            fun _format(): JsonField<RealtimeAudioFormats> = format

            /**
             * Returns the raw JSON value of [speed].
             *
             * Unlike [speed], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("speed") @ExcludeMissing fun _speed(): JsonField<Double> = speed

            /**
             * Returns the raw JSON value of [voice].
             *
             * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

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

                /** Returns a mutable builder for constructing an instance of [Output]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Output]. */
            class Builder internal constructor() {

                private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
                private var speed: JsonField<Double> = JsonMissing.of()
                private var voice: JsonField<Voice> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(output: Output) = apply {
                    format = output.format
                    speed = output.speed
                    voice = output.voice
                    additionalProperties = output.additionalProperties.toMutableMap()
                }

                /** The format of the output audio. */
                fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

                /**
                 * Sets [Builder.format] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

                /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
                fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
                    format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`.
                 */
                fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
                    format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`.
                 */
                fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
                    format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

                /**
                 * The speed of the model's spoken response as a multiple of the original speed. 1.0
                 * is the default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This
                 * value can only be changed in between model turns, not while a response is in
                 * progress.
                 *
                 * This parameter is a post-processing adjustment to the audio after it is
                 * generated, it's also possible to prompt the model to speak faster or slower.
                 */
                fun speed(speed: Double) = speed(JsonField.of(speed))

                /**
                 * Sets [Builder.speed] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.speed] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

                /**
                 * The voice the model uses to respond. Voice cannot be changed during the session
                 * once the model has responded with audio at least once. Current voice options are
                 * `alloy`, `ash`, `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`,
                 * and `cedar`. We recommend `marin` and `cedar` for best quality.
                 */
                fun voice(voice: Voice) = voice(JsonField.of(voice))

                /**
                 * Sets [Builder.voice] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.voice] with a well-typed [Voice] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

                /**
                 * Sets [voice] to an arbitrary [String].
                 *
                 * You should usually call [voice] with a well-typed [Voice] constant instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun voice(value: String) = voice(Voice.of(value))

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
                 */
                fun build(): Output =
                    Output(format, speed, voice, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                format().ifPresent { it.validate() }
                speed()
                voice()
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
                (format.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (speed.asKnown().isPresent) 1 else 0) +
                    (if (voice.asKnown().isPresent) 1 else 0)

            /**
             * The voice the model uses to respond. Voice cannot be changed during the session once
             * the model has responded with audio at least once. Current voice options are `alloy`,
             * `ash`, `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`.
             * We recommend `marin` and `cedar` for best quality.
             */
            class Voice @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val ALLOY = of("alloy")

                    @JvmField val ASH = of("ash")

                    @JvmField val BALLAD = of("ballad")

                    @JvmField val CORAL = of("coral")

                    @JvmField val ECHO = of("echo")

                    @JvmField val SAGE = of("sage")

                    @JvmField val SHIMMER = of("shimmer")

                    @JvmField val VERSE = of("verse")

                    @JvmField val MARIN = of("marin")

                    @JvmField val CEDAR = of("cedar")

                    @JvmStatic fun of(value: String) = Voice(JsonField.of(value))
                }

                /** An enum containing [Voice]'s known values. */
                enum class Known {
                    ALLOY,
                    ASH,
                    BALLAD,
                    CORAL,
                    ECHO,
                    SAGE,
                    SHIMMER,
                    VERSE,
                    MARIN,
                    CEDAR,
                }

                /**
                 * An enum containing [Voice]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Voice] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ALLOY,
                    ASH,
                    BALLAD,
                    CORAL,
                    ECHO,
                    SAGE,
                    SHIMMER,
                    VERSE,
                    MARIN,
                    CEDAR,
                    /**
                     * An enum member indicating that [Voice] was instantiated with an unknown
                     * value.
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
                        ALLOY -> Value.ALLOY
                        ASH -> Value.ASH
                        BALLAD -> Value.BALLAD
                        CORAL -> Value.CORAL
                        ECHO -> Value.ECHO
                        SAGE -> Value.SAGE
                        SHIMMER -> Value.SHIMMER
                        VERSE -> Value.VERSE
                        MARIN -> Value.MARIN
                        CEDAR -> Value.CEDAR
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
                        ALLOY -> Known.ALLOY
                        ASH -> Known.ASH
                        BALLAD -> Known.BALLAD
                        CORAL -> Known.CORAL
                        ECHO -> Known.ECHO
                        SAGE -> Known.SAGE
                        SHIMMER -> Known.SHIMMER
                        VERSE -> Known.VERSE
                        MARIN -> Known.MARIN
                        CEDAR -> Known.CEDAR
                        else -> throw OpenAIInvalidDataException("Unknown Voice: $value")
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

                private var validated: Boolean = false

                fun validate(): Voice = apply {
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

                    return other is Voice && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    format == other.format &&
                    speed == other.speed &&
                    voice == other.voice &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(format, speed, voice, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Output{format=$format, speed=$speed, voice=$voice, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Audio &&
                input == other.input &&
                output == other.output &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Audio{input=$input, output=$output, additionalProperties=$additionalProperties}"
    }

    class Include @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField
            val ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS =
                of("item.input_audio_transcription.logprobs")

            @JvmStatic fun of(value: String) = Include(JsonField.of(value))
        }

        /** An enum containing [Include]'s known values. */
        enum class Known {
            ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
        }

        /**
         * An enum containing [Include]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Include] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS,
            /** An enum member indicating that [Include] was instantiated with an unknown value. */
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
                ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                    Value.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
                ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                    Known.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                else -> throw OpenAIInvalidDataException("Unknown Include: $value")
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

        fun validate(): Include = apply {
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

            return other is Include && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Maximum number of output tokens for a single assistant response, inclusive of tool calls.
     * Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the maximum
     * available tokens for a given model. Defaults to `inf`.
     */
    @JsonDeserialize(using = MaxOutputTokens.Deserializer::class)
    @JsonSerialize(using = MaxOutputTokens.Serializer::class)
    class MaxOutputTokens
    private constructor(
        private val integer: Long? = null,
        private val inf: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun inf(): Optional<JsonValue> = Optional.ofNullable(inf)

        fun isInteger(): Boolean = integer != null

        fun isInf(): Boolean = inf != null

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun asInf(): JsonValue = inf.getOrThrow("inf")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                integer != null -> visitor.visitInteger(integer)
                inf != null -> visitor.visitInf(inf)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): MaxOutputTokens = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInteger(integer: Long) {}

                    override fun visitInf(inf: JsonValue) {
                        inf.let {
                            if (it != JsonValue.from("inf")) {
                                throw OpenAIInvalidDataException("'inf' is invalid, received $it")
                            }
                        }
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
                    override fun visitInteger(integer: Long) = 1

                    override fun visitInf(inf: JsonValue) =
                        inf.let { if (it == JsonValue.from("inf")) 1 else 0 }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MaxOutputTokens && integer == other.integer && inf == other.inf
        }

        override fun hashCode(): Int = Objects.hash(integer, inf)

        override fun toString(): String =
            when {
                integer != null -> "MaxOutputTokens{integer=$integer}"
                inf != null -> "MaxOutputTokens{inf=$inf}"
                _json != null -> "MaxOutputTokens{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid MaxOutputTokens")
            }

        companion object {

            @JvmStatic fun ofInteger(integer: Long) = MaxOutputTokens(integer = integer)

            @JvmStatic fun ofInf() = MaxOutputTokens(inf = JsonValue.from("inf"))
        }

        /**
         * An interface that defines how to map each variant of [MaxOutputTokens] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitInteger(integer: Long): T

            fun visitInf(inf: JsonValue): T

            /**
             * Maps an unknown variant of [MaxOutputTokens] to a value of type [T].
             *
             * An instance of [MaxOutputTokens] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown MaxOutputTokens: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<MaxOutputTokens>(MaxOutputTokens::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): MaxOutputTokens {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { MaxOutputTokens(inf = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                MaxOutputTokens(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> MaxOutputTokens(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<MaxOutputTokens>(MaxOutputTokens::class) {

            override fun serialize(
                value: MaxOutputTokens,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.integer != null -> generator.writeObject(value.integer)
                    value.inf != null -> generator.writeObject(value.inf)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid MaxOutputTokens")
                }
            }
        }
    }

    /** The Realtime model used for this session. */
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

            @JvmField val GPT_REALTIME = of("gpt-realtime")

            @JvmField val GPT_REALTIME_2025_08_28 = of("gpt-realtime-2025-08-28")

            @JvmField val GPT_4O_REALTIME_PREVIEW = of("gpt-4o-realtime-preview")

            @JvmField
            val GPT_4O_REALTIME_PREVIEW_2024_10_01 = of("gpt-4o-realtime-preview-2024-10-01")

            @JvmField
            val GPT_4O_REALTIME_PREVIEW_2024_12_17 = of("gpt-4o-realtime-preview-2024-12-17")

            @JvmField
            val GPT_4O_REALTIME_PREVIEW_2025_06_03 = of("gpt-4o-realtime-preview-2025-06-03")

            @JvmField val GPT_4O_MINI_REALTIME_PREVIEW = of("gpt-4o-mini-realtime-preview")

            @JvmField
            val GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17 =
                of("gpt-4o-mini-realtime-preview-2024-12-17")

            @JvmField val GPT_REALTIME_MINI = of("gpt-realtime-mini")

            @JvmField val GPT_REALTIME_MINI_2025_10_06 = of("gpt-realtime-mini-2025-10-06")

            @JvmField val GPT_AUDIO_MINI = of("gpt-audio-mini")

            @JvmField val GPT_AUDIO_MINI_2025_10_06 = of("gpt-audio-mini-2025-10-06")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_REALTIME,
            GPT_REALTIME_2025_08_28,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
            GPT_REALTIME_MINI,
            GPT_REALTIME_MINI_2025_10_06,
            GPT_AUDIO_MINI,
            GPT_AUDIO_MINI_2025_10_06,
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
            GPT_REALTIME,
            GPT_REALTIME_2025_08_28,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
            GPT_REALTIME_MINI,
            GPT_REALTIME_MINI_2025_10_06,
            GPT_AUDIO_MINI,
            GPT_AUDIO_MINI_2025_10_06,
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
                GPT_REALTIME -> Value.GPT_REALTIME
                GPT_REALTIME_2025_08_28 -> Value.GPT_REALTIME_2025_08_28
                GPT_4O_REALTIME_PREVIEW -> Value.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Value.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_REALTIME_PREVIEW_2024_12_17 -> Value.GPT_4O_REALTIME_PREVIEW_2024_12_17
                GPT_4O_REALTIME_PREVIEW_2025_06_03 -> Value.GPT_4O_REALTIME_PREVIEW_2025_06_03
                GPT_4O_MINI_REALTIME_PREVIEW -> Value.GPT_4O_MINI_REALTIME_PREVIEW
                GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17 ->
                    Value.GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17
                GPT_REALTIME_MINI -> Value.GPT_REALTIME_MINI
                GPT_REALTIME_MINI_2025_10_06 -> Value.GPT_REALTIME_MINI_2025_10_06
                GPT_AUDIO_MINI -> Value.GPT_AUDIO_MINI
                GPT_AUDIO_MINI_2025_10_06 -> Value.GPT_AUDIO_MINI_2025_10_06
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
                GPT_REALTIME -> Known.GPT_REALTIME
                GPT_REALTIME_2025_08_28 -> Known.GPT_REALTIME_2025_08_28
                GPT_4O_REALTIME_PREVIEW -> Known.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Known.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_REALTIME_PREVIEW_2024_12_17 -> Known.GPT_4O_REALTIME_PREVIEW_2024_12_17
                GPT_4O_REALTIME_PREVIEW_2025_06_03 -> Known.GPT_4O_REALTIME_PREVIEW_2025_06_03
                GPT_4O_MINI_REALTIME_PREVIEW -> Known.GPT_4O_MINI_REALTIME_PREVIEW
                GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17 ->
                    Known.GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17
                GPT_REALTIME_MINI -> Known.GPT_REALTIME_MINI
                GPT_REALTIME_MINI_2025_10_06 -> Known.GPT_REALTIME_MINI_2025_10_06
                GPT_AUDIO_MINI -> Known.GPT_AUDIO_MINI
                GPT_AUDIO_MINI_2025_10_06 -> Known.GPT_AUDIO_MINI_2025_10_06
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

    class OutputModality @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TEXT = of("text")

            @JvmField val AUDIO = of("audio")

            @JvmStatic fun of(value: String) = OutputModality(JsonField.of(value))
        }

        /** An enum containing [OutputModality]'s known values. */
        enum class Known {
            TEXT,
            AUDIO,
        }

        /**
         * An enum containing [OutputModality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputModality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TEXT,
            AUDIO,
            /**
             * An enum member indicating that [OutputModality] was instantiated with an unknown
             * value.
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
                else -> throw OpenAIInvalidDataException("Unknown OutputModality: $value")
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

        fun validate(): OutputModality = apply {
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

            return other is OutputModality && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * How the model chooses tools. Provide one of the string modes or force a specific function/MCP
     * tool.
     */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val options: ToolChoiceOptions? = null,
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

        /** Use this option to force the model to call a specific function. */
        fun function(): Optional<ToolChoiceFunction> = Optional.ofNullable(function)

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun mcp(): Optional<ToolChoiceMcp> = Optional.ofNullable(mcp)

        fun isOptions(): Boolean = options != null

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

        /** Use this option to force the model to call a specific function. */
        fun asFunction(): ToolChoiceFunction = function.getOrThrow("function")

        /** Use this option to force the model to call a specific tool on a remote MCP server. */
        fun asMcp(): ToolChoiceMcp = mcp.getOrThrow("mcp")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                options != null -> visitor.visitOptions(options)
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

                    override fun visitFunction(function: ToolChoiceFunction) = function.validity()

                    override fun visitMcp(mcp: ToolChoiceMcp) = mcp.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                options == other.options &&
                function == other.function &&
                mcp == other.mcp
        }

        override fun hashCode(): Int = Objects.hash(options, function, mcp)

        override fun toString(): String =
            when {
                options != null -> "ToolChoice{options=$options}"
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
                    value.function != null -> generator.writeObject(value.function)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }
    }

    /**
     * Give the model access to additional tools via remote Model Context Protocol (MCP) servers.
     * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
     */
    @JsonDeserialize(using = Tool.Deserializer::class)
    @JsonSerialize(using = Tool.Serializer::class)
    class Tool
    private constructor(
        private val realtimeFunction: RealtimeFunctionTool? = null,
        private val mcp: McpTool? = null,
        private val _json: JsonValue? = null,
    ) {

        fun realtimeFunction(): Optional<RealtimeFunctionTool> =
            Optional.ofNullable(realtimeFunction)

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        fun mcp(): Optional<McpTool> = Optional.ofNullable(mcp)

        fun isRealtimeFunction(): Boolean = realtimeFunction != null

        fun isMcp(): Boolean = mcp != null

        fun asRealtimeFunction(): RealtimeFunctionTool =
            realtimeFunction.getOrThrow("realtimeFunction")

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        fun asMcp(): McpTool = mcp.getOrThrow("mcp")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                realtimeFunction != null -> visitor.visitRealtimeFunction(realtimeFunction)
                mcp != null -> visitor.visitMcp(mcp)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Tool = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRealtimeFunction(realtimeFunction: RealtimeFunctionTool) {
                        realtimeFunction.validate()
                    }

                    override fun visitMcp(mcp: McpTool) {
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
                    override fun visitRealtimeFunction(realtimeFunction: RealtimeFunctionTool) =
                        realtimeFunction.validity()

                    override fun visitMcp(mcp: McpTool) = mcp.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tool && realtimeFunction == other.realtimeFunction && mcp == other.mcp
        }

        override fun hashCode(): Int = Objects.hash(realtimeFunction, mcp)

        override fun toString(): String =
            when {
                realtimeFunction != null -> "Tool{realtimeFunction=$realtimeFunction}"
                mcp != null -> "Tool{mcp=$mcp}"
                _json != null -> "Tool{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Tool")
            }

        companion object {

            @JvmStatic
            fun ofRealtimeFunction(realtimeFunction: RealtimeFunctionTool) =
                Tool(realtimeFunction = realtimeFunction)

            /**
             * Give the model access to additional tools via remote Model Context Protocol (MCP)
             * servers.
             * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
             */
            @JvmStatic fun ofMcp(mcp: McpTool) = Tool(mcp = mcp)
        }

        /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitRealtimeFunction(realtimeFunction: RealtimeFunctionTool): T

            /**
             * Give the model access to additional tools via remote Model Context Protocol (MCP)
             * servers.
             * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
             */
            fun visitMcp(mcp: McpTool): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<RealtimeFunctionTool>())?.let {
                                Tool(realtimeFunction = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<McpTool>())?.let {
                                Tool(mcp = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Tool(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Tool>(Tool::class) {

            override fun serialize(
                value: Tool,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.realtimeFunction != null -> generator.writeObject(value.realtimeFunction)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tool")
                }
            }
        }

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        class McpTool
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val serverLabel: JsonField<String>,
            private val type: JsonValue,
            private val allowedTools: JsonField<AllowedTools>,
            private val authorization: JsonField<String>,
            private val connectorId: JsonField<ConnectorId>,
            private val headers: JsonField<Headers>,
            private val requireApproval: JsonField<RequireApproval>,
            private val serverDescription: JsonField<String>,
            private val serverUrl: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("server_label")
                @ExcludeMissing
                serverLabel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("allowed_tools")
                @ExcludeMissing
                allowedTools: JsonField<AllowedTools> = JsonMissing.of(),
                @JsonProperty("authorization")
                @ExcludeMissing
                authorization: JsonField<String> = JsonMissing.of(),
                @JsonProperty("connector_id")
                @ExcludeMissing
                connectorId: JsonField<ConnectorId> = JsonMissing.of(),
                @JsonProperty("headers")
                @ExcludeMissing
                headers: JsonField<Headers> = JsonMissing.of(),
                @JsonProperty("require_approval")
                @ExcludeMissing
                requireApproval: JsonField<RequireApproval> = JsonMissing.of(),
                @JsonProperty("server_description")
                @ExcludeMissing
                serverDescription: JsonField<String> = JsonMissing.of(),
                @JsonProperty("server_url")
                @ExcludeMissing
                serverUrl: JsonField<String> = JsonMissing.of(),
            ) : this(
                serverLabel,
                type,
                allowedTools,
                authorization,
                connectorId,
                headers,
                requireApproval,
                serverDescription,
                serverUrl,
                mutableMapOf(),
            )

            /**
             * A label for this MCP server, used to identify it in tool calls.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun serverLabel(): String = serverLabel.getRequired("server_label")

            /**
             * The type of the MCP tool. Always `mcp`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("mcp")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * List of allowed tool names or a filter object.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun allowedTools(): Optional<AllowedTools> = allowedTools.getOptional("allowed_tools")

            /**
             * An OAuth access token that can be used with a remote MCP server, either with a custom
             * MCP server URL or a service connector. Your application must handle the OAuth
             * authorization flow and provide the token here.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun authorization(): Optional<String> = authorization.getOptional("authorization")

            /**
             * Identifier for service connectors, like those available in ChatGPT. One of
             * `server_url` or `connector_id` must be provided. Learn more about service connectors
             * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
             *
             * Currently supported `connector_id` values are:
             * - Dropbox: `connector_dropbox`
             * - Gmail: `connector_gmail`
             * - Google Calendar: `connector_googlecalendar`
             * - Google Drive: `connector_googledrive`
             * - Microsoft Teams: `connector_microsoftteams`
             * - Outlook Calendar: `connector_outlookcalendar`
             * - Outlook Email: `connector_outlookemail`
             * - SharePoint: `connector_sharepoint`
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun connectorId(): Optional<ConnectorId> = connectorId.getOptional("connector_id")

            /**
             * Optional HTTP headers to send to the MCP server. Use for authentication or other
             * purposes.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun headers(): Optional<Headers> = headers.getOptional("headers")

            /**
             * Specify which of the MCP server's tools require approval.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun requireApproval(): Optional<RequireApproval> =
                requireApproval.getOptional("require_approval")

            /**
             * Optional description of the MCP server, used to provide more context.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun serverDescription(): Optional<String> =
                serverDescription.getOptional("server_description")

            /**
             * The URL for the MCP server. One of `server_url` or `connector_id` must be provided.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun serverUrl(): Optional<String> = serverUrl.getOptional("server_url")

            /**
             * Returns the raw JSON value of [serverLabel].
             *
             * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("server_label")
            @ExcludeMissing
            fun _serverLabel(): JsonField<String> = serverLabel

            /**
             * Returns the raw JSON value of [allowedTools].
             *
             * Unlike [allowedTools], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("allowed_tools")
            @ExcludeMissing
            fun _allowedTools(): JsonField<AllowedTools> = allowedTools

            /**
             * Returns the raw JSON value of [authorization].
             *
             * Unlike [authorization], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("authorization")
            @ExcludeMissing
            fun _authorization(): JsonField<String> = authorization

            /**
             * Returns the raw JSON value of [connectorId].
             *
             * Unlike [connectorId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("connector_id")
            @ExcludeMissing
            fun _connectorId(): JsonField<ConnectorId> = connectorId

            /**
             * Returns the raw JSON value of [headers].
             *
             * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

            /**
             * Returns the raw JSON value of [requireApproval].
             *
             * Unlike [requireApproval], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("require_approval")
            @ExcludeMissing
            fun _requireApproval(): JsonField<RequireApproval> = requireApproval

            /**
             * Returns the raw JSON value of [serverDescription].
             *
             * Unlike [serverDescription], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("server_description")
            @ExcludeMissing
            fun _serverDescription(): JsonField<String> = serverDescription

            /**
             * Returns the raw JSON value of [serverUrl].
             *
             * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("server_url")
            @ExcludeMissing
            fun _serverUrl(): JsonField<String> = serverUrl

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
                 * Returns a mutable builder for constructing an instance of [McpTool].
                 *
                 * The following fields are required:
                 * ```java
                 * .serverLabel()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [McpTool]. */
            class Builder internal constructor() {

                private var serverLabel: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("mcp")
                private var allowedTools: JsonField<AllowedTools> = JsonMissing.of()
                private var authorization: JsonField<String> = JsonMissing.of()
                private var connectorId: JsonField<ConnectorId> = JsonMissing.of()
                private var headers: JsonField<Headers> = JsonMissing.of()
                private var requireApproval: JsonField<RequireApproval> = JsonMissing.of()
                private var serverDescription: JsonField<String> = JsonMissing.of()
                private var serverUrl: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(mcpTool: McpTool) = apply {
                    serverLabel = mcpTool.serverLabel
                    type = mcpTool.type
                    allowedTools = mcpTool.allowedTools
                    authorization = mcpTool.authorization
                    connectorId = mcpTool.connectorId
                    headers = mcpTool.headers
                    requireApproval = mcpTool.requireApproval
                    serverDescription = mcpTool.serverDescription
                    serverUrl = mcpTool.serverUrl
                    additionalProperties = mcpTool.additionalProperties.toMutableMap()
                }

                /** A label for this MCP server, used to identify it in tool calls. */
                fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

                /**
                 * Sets [Builder.serverLabel] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serverLabel] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun serverLabel(serverLabel: JsonField<String>) = apply {
                    this.serverLabel = serverLabel
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("mcp")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** List of allowed tool names or a filter object. */
                fun allowedTools(allowedTools: AllowedTools?) =
                    allowedTools(JsonField.ofNullable(allowedTools))

                /** Alias for calling [Builder.allowedTools] with `allowedTools.orElse(null)`. */
                fun allowedTools(allowedTools: Optional<AllowedTools>) =
                    allowedTools(allowedTools.getOrNull())

                /**
                 * Sets [Builder.allowedTools] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.allowedTools] with a well-typed [AllowedTools]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun allowedTools(allowedTools: JsonField<AllowedTools>) = apply {
                    this.allowedTools = allowedTools
                }

                /** Alias for calling [allowedTools] with `AllowedTools.ofMcp(mcp)`. */
                fun allowedToolsOfMcp(mcp: List<String>) = allowedTools(AllowedTools.ofMcp(mcp))

                /**
                 * Alias for calling [allowedTools] with
                 * `AllowedTools.ofMcpToolFilter(mcpToolFilter)`.
                 */
                fun allowedTools(mcpToolFilter: AllowedTools.McpToolFilter) =
                    allowedTools(AllowedTools.ofMcpToolFilter(mcpToolFilter))

                /**
                 * An OAuth access token that can be used with a remote MCP server, either with a
                 * custom MCP server URL or a service connector. Your application must handle the
                 * OAuth authorization flow and provide the token here.
                 */
                fun authorization(authorization: String) =
                    authorization(JsonField.of(authorization))

                /**
                 * Sets [Builder.authorization] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.authorization] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun authorization(authorization: JsonField<String>) = apply {
                    this.authorization = authorization
                }

                /**
                 * Identifier for service connectors, like those available in ChatGPT. One of
                 * `server_url` or `connector_id` must be provided. Learn more about service
                 * connectors
                 * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
                 *
                 * Currently supported `connector_id` values are:
                 * - Dropbox: `connector_dropbox`
                 * - Gmail: `connector_gmail`
                 * - Google Calendar: `connector_googlecalendar`
                 * - Google Drive: `connector_googledrive`
                 * - Microsoft Teams: `connector_microsoftteams`
                 * - Outlook Calendar: `connector_outlookcalendar`
                 * - Outlook Email: `connector_outlookemail`
                 * - SharePoint: `connector_sharepoint`
                 */
                fun connectorId(connectorId: ConnectorId) = connectorId(JsonField.of(connectorId))

                /**
                 * Sets [Builder.connectorId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.connectorId] with a well-typed [ConnectorId]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun connectorId(connectorId: JsonField<ConnectorId>) = apply {
                    this.connectorId = connectorId
                }

                /**
                 * Optional HTTP headers to send to the MCP server. Use for authentication or other
                 * purposes.
                 */
                fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

                /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
                fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

                /**
                 * Sets [Builder.headers] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.headers] with a well-typed [Headers] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

                /** Specify which of the MCP server's tools require approval. */
                fun requireApproval(requireApproval: RequireApproval?) =
                    requireApproval(JsonField.ofNullable(requireApproval))

                /**
                 * Alias for calling [Builder.requireApproval] with `requireApproval.orElse(null)`.
                 */
                fun requireApproval(requireApproval: Optional<RequireApproval>) =
                    requireApproval(requireApproval.getOrNull())

                /**
                 * Sets [Builder.requireApproval] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requireApproval] with a well-typed
                 * [RequireApproval] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun requireApproval(requireApproval: JsonField<RequireApproval>) = apply {
                    this.requireApproval = requireApproval
                }

                /**
                 * Alias for calling [requireApproval] with
                 * `RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter)`.
                 */
                fun requireApproval(mcpToolApprovalFilter: RequireApproval.McpToolApprovalFilter) =
                    requireApproval(RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter))

                /**
                 * Alias for calling [requireApproval] with
                 * `RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting)`.
                 */
                fun requireApproval(
                    mcpToolApprovalSetting: RequireApproval.McpToolApprovalSetting
                ) =
                    requireApproval(
                        RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting)
                    )

                /** Optional description of the MCP server, used to provide more context. */
                fun serverDescription(serverDescription: String) =
                    serverDescription(JsonField.of(serverDescription))

                /**
                 * Sets [Builder.serverDescription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serverDescription] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun serverDescription(serverDescription: JsonField<String>) = apply {
                    this.serverDescription = serverDescription
                }

                /**
                 * The URL for the MCP server. One of `server_url` or `connector_id` must be
                 * provided.
                 */
                fun serverUrl(serverUrl: String) = serverUrl(JsonField.of(serverUrl))

                /**
                 * Sets [Builder.serverUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serverUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun serverUrl(serverUrl: JsonField<String>) = apply { this.serverUrl = serverUrl }

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
                 * Returns an immutable instance of [McpTool].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .serverLabel()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): McpTool =
                    McpTool(
                        checkRequired("serverLabel", serverLabel),
                        type,
                        allowedTools,
                        authorization,
                        connectorId,
                        headers,
                        requireApproval,
                        serverDescription,
                        serverUrl,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): McpTool = apply {
                if (validated) {
                    return@apply
                }

                serverLabel()
                _type().let {
                    if (it != JsonValue.from("mcp")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                allowedTools().ifPresent { it.validate() }
                authorization()
                connectorId().ifPresent { it.validate() }
                headers().ifPresent { it.validate() }
                requireApproval().ifPresent { it.validate() }
                serverDescription()
                serverUrl()
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
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("mcp")) 1 else 0 } +
                    (allowedTools.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (authorization.asKnown().isPresent) 1 else 0) +
                    (connectorId.asKnown().getOrNull()?.validity() ?: 0) +
                    (headers.asKnown().getOrNull()?.validity() ?: 0) +
                    (requireApproval.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (serverDescription.asKnown().isPresent) 1 else 0) +
                    (if (serverUrl.asKnown().isPresent) 1 else 0)

            /** List of allowed tool names or a filter object. */
            @JsonDeserialize(using = AllowedTools.Deserializer::class)
            @JsonSerialize(using = AllowedTools.Serializer::class)
            class AllowedTools
            private constructor(
                private val mcp: List<String>? = null,
                private val mcpToolFilter: McpToolFilter? = null,
                private val _json: JsonValue? = null,
            ) {

                /** A string array of allowed tool names */
                fun mcp(): Optional<List<String>> = Optional.ofNullable(mcp)

                /** A filter object to specify which tools are allowed. */
                fun mcpToolFilter(): Optional<McpToolFilter> = Optional.ofNullable(mcpToolFilter)

                fun isMcp(): Boolean = mcp != null

                fun isMcpToolFilter(): Boolean = mcpToolFilter != null

                /** A string array of allowed tool names */
                fun asMcp(): List<String> = mcp.getOrThrow("mcp")

                /** A filter object to specify which tools are allowed. */
                fun asMcpToolFilter(): McpToolFilter = mcpToolFilter.getOrThrow("mcpToolFilter")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        mcp != null -> visitor.visitMcp(mcp)
                        mcpToolFilter != null -> visitor.visitMcpToolFilter(mcpToolFilter)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): AllowedTools = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitMcp(mcp: List<String>) {}

                            override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) {
                                mcpToolFilter.validate()
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
                            override fun visitMcp(mcp: List<String>) = mcp.size

                            override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) =
                                mcpToolFilter.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AllowedTools &&
                        mcp == other.mcp &&
                        mcpToolFilter == other.mcpToolFilter
                }

                override fun hashCode(): Int = Objects.hash(mcp, mcpToolFilter)

                override fun toString(): String =
                    when {
                        mcp != null -> "AllowedTools{mcp=$mcp}"
                        mcpToolFilter != null -> "AllowedTools{mcpToolFilter=$mcpToolFilter}"
                        _json != null -> "AllowedTools{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid AllowedTools")
                    }

                companion object {

                    /** A string array of allowed tool names */
                    @JvmStatic fun ofMcp(mcp: List<String>) = AllowedTools(mcp = mcp.toImmutable())

                    /** A filter object to specify which tools are allowed. */
                    @JvmStatic
                    fun ofMcpToolFilter(mcpToolFilter: McpToolFilter) =
                        AllowedTools(mcpToolFilter = mcpToolFilter)
                }

                /**
                 * An interface that defines how to map each variant of [AllowedTools] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    /** A string array of allowed tool names */
                    fun visitMcp(mcp: List<String>): T

                    /** A filter object to specify which tools are allowed. */
                    fun visitMcpToolFilter(mcpToolFilter: McpToolFilter): T

                    /**
                     * Maps an unknown variant of [AllowedTools] to a value of type [T].
                     *
                     * An instance of [AllowedTools] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown AllowedTools: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<AllowedTools>(AllowedTools::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): AllowedTools {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<McpToolFilter>())?.let {
                                        AllowedTools(mcpToolFilter = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                        AllowedTools(mcp = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> AllowedTools(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<AllowedTools>(AllowedTools::class) {

                    override fun serialize(
                        value: AllowedTools,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.mcp != null -> generator.writeObject(value.mcp)
                            value.mcpToolFilter != null ->
                                generator.writeObject(value.mcpToolFilter)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid AllowedTools")
                        }
                    }
                }

                /** A filter object to specify which tools are allowed. */
                class McpToolFilter
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val readOnly: JsonField<Boolean>,
                    private val toolNames: JsonField<List<String>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("read_only")
                        @ExcludeMissing
                        readOnly: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("tool_names")
                        @ExcludeMissing
                        toolNames: JsonField<List<String>> = JsonMissing.of(),
                    ) : this(readOnly, toolNames, mutableMapOf())

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                    /**
                     * List of allowed tool names.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                    /**
                     * Returns the raw JSON value of [readOnly].
                     *
                     * Unlike [readOnly], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    fun _readOnly(): JsonField<Boolean> = readOnly

                    /**
                     * Returns the raw JSON value of [toolNames].
                     *
                     * Unlike [toolNames], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    fun _toolNames(): JsonField<List<String>> = toolNames

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
                         * Returns a mutable builder for constructing an instance of
                         * [McpToolFilter].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [McpToolFilter]. */
                    class Builder internal constructor() {

                        private var readOnly: JsonField<Boolean> = JsonMissing.of()
                        private var toolNames: JsonField<MutableList<String>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(mcpToolFilter: McpToolFilter) = apply {
                            readOnly = mcpToolFilter.readOnly
                            toolNames = mcpToolFilter.toolNames.map { it.toMutableList() }
                            additionalProperties = mcpToolFilter.additionalProperties.toMutableMap()
                        }

                        /**
                         * Indicates whether or not a tool modifies data or is read-only. If an MCP
                         * server is
                         * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                         * it will match this filter.
                         */
                        fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                        /**
                         * Sets [Builder.readOnly] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.readOnly] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun readOnly(readOnly: JsonField<Boolean>) = apply {
                            this.readOnly = readOnly
                        }

                        /** List of allowed tool names. */
                        fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                        /**
                         * Sets [Builder.toolNames] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.toolNames] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun toolNames(toolNames: JsonField<List<String>>) = apply {
                            this.toolNames = toolNames.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [toolNames].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addToolName(toolName: String) = apply {
                            toolNames =
                                (toolNames ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("toolNames", it).add(toolName)
                                }
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
                         * Returns an immutable instance of [McpToolFilter].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): McpToolFilter =
                            McpToolFilter(
                                readOnly,
                                (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): McpToolFilter = apply {
                        if (validated) {
                            return@apply
                        }

                        readOnly()
                        toolNames()
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
                        (if (readOnly.asKnown().isPresent) 1 else 0) +
                            (toolNames.asKnown().getOrNull()?.size ?: 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is McpToolFilter &&
                            readOnly == other.readOnly &&
                            toolNames == other.toolNames &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(readOnly, toolNames, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "McpToolFilter{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
                }
            }

            /**
             * Identifier for service connectors, like those available in ChatGPT. One of
             * `server_url` or `connector_id` must be provided. Learn more about service connectors
             * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
             *
             * Currently supported `connector_id` values are:
             * - Dropbox: `connector_dropbox`
             * - Gmail: `connector_gmail`
             * - Google Calendar: `connector_googlecalendar`
             * - Google Drive: `connector_googledrive`
             * - Microsoft Teams: `connector_microsoftteams`
             * - Outlook Calendar: `connector_outlookcalendar`
             * - Outlook Email: `connector_outlookemail`
             * - SharePoint: `connector_sharepoint`
             */
            class ConnectorId
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

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

                    @JvmField val CONNECTOR_DROPBOX = of("connector_dropbox")

                    @JvmField val CONNECTOR_GMAIL = of("connector_gmail")

                    @JvmField val CONNECTOR_GOOGLECALENDAR = of("connector_googlecalendar")

                    @JvmField val CONNECTOR_GOOGLEDRIVE = of("connector_googledrive")

                    @JvmField val CONNECTOR_MICROSOFTTEAMS = of("connector_microsoftteams")

                    @JvmField val CONNECTOR_OUTLOOKCALENDAR = of("connector_outlookcalendar")

                    @JvmField val CONNECTOR_OUTLOOKEMAIL = of("connector_outlookemail")

                    @JvmField val CONNECTOR_SHAREPOINT = of("connector_sharepoint")

                    @JvmStatic fun of(value: String) = ConnectorId(JsonField.of(value))
                }

                /** An enum containing [ConnectorId]'s known values. */
                enum class Known {
                    CONNECTOR_DROPBOX,
                    CONNECTOR_GMAIL,
                    CONNECTOR_GOOGLECALENDAR,
                    CONNECTOR_GOOGLEDRIVE,
                    CONNECTOR_MICROSOFTTEAMS,
                    CONNECTOR_OUTLOOKCALENDAR,
                    CONNECTOR_OUTLOOKEMAIL,
                    CONNECTOR_SHAREPOINT,
                }

                /**
                 * An enum containing [ConnectorId]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [ConnectorId] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CONNECTOR_DROPBOX,
                    CONNECTOR_GMAIL,
                    CONNECTOR_GOOGLECALENDAR,
                    CONNECTOR_GOOGLEDRIVE,
                    CONNECTOR_MICROSOFTTEAMS,
                    CONNECTOR_OUTLOOKCALENDAR,
                    CONNECTOR_OUTLOOKEMAIL,
                    CONNECTOR_SHAREPOINT,
                    /**
                     * An enum member indicating that [ConnectorId] was instantiated with an unknown
                     * value.
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
                        CONNECTOR_DROPBOX -> Value.CONNECTOR_DROPBOX
                        CONNECTOR_GMAIL -> Value.CONNECTOR_GMAIL
                        CONNECTOR_GOOGLECALENDAR -> Value.CONNECTOR_GOOGLECALENDAR
                        CONNECTOR_GOOGLEDRIVE -> Value.CONNECTOR_GOOGLEDRIVE
                        CONNECTOR_MICROSOFTTEAMS -> Value.CONNECTOR_MICROSOFTTEAMS
                        CONNECTOR_OUTLOOKCALENDAR -> Value.CONNECTOR_OUTLOOKCALENDAR
                        CONNECTOR_OUTLOOKEMAIL -> Value.CONNECTOR_OUTLOOKEMAIL
                        CONNECTOR_SHAREPOINT -> Value.CONNECTOR_SHAREPOINT
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
                        CONNECTOR_DROPBOX -> Known.CONNECTOR_DROPBOX
                        CONNECTOR_GMAIL -> Known.CONNECTOR_GMAIL
                        CONNECTOR_GOOGLECALENDAR -> Known.CONNECTOR_GOOGLECALENDAR
                        CONNECTOR_GOOGLEDRIVE -> Known.CONNECTOR_GOOGLEDRIVE
                        CONNECTOR_MICROSOFTTEAMS -> Known.CONNECTOR_MICROSOFTTEAMS
                        CONNECTOR_OUTLOOKCALENDAR -> Known.CONNECTOR_OUTLOOKCALENDAR
                        CONNECTOR_OUTLOOKEMAIL -> Known.CONNECTOR_OUTLOOKEMAIL
                        CONNECTOR_SHAREPOINT -> Known.CONNECTOR_SHAREPOINT
                        else -> throw OpenAIInvalidDataException("Unknown ConnectorId: $value")
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

                private var validated: Boolean = false

                fun validate(): ConnectorId = apply {
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

                    return other is ConnectorId && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * Optional HTTP headers to send to the MCP server. Use for authentication or other
             * purposes.
             */
            class Headers
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

                    /** Returns a mutable builder for constructing an instance of [Headers]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Headers]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(headers: Headers) = apply {
                        additionalProperties = headers.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Headers].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Headers = Headers(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Headers = apply {
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

                    return other is Headers && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Headers{additionalProperties=$additionalProperties}"
            }

            /** Specify which of the MCP server's tools require approval. */
            @JsonDeserialize(using = RequireApproval.Deserializer::class)
            @JsonSerialize(using = RequireApproval.Serializer::class)
            class RequireApproval
            private constructor(
                private val mcpToolApprovalFilter: McpToolApprovalFilter? = null,
                private val mcpToolApprovalSetting: McpToolApprovalSetting? = null,
                private val _json: JsonValue? = null,
            ) {

                /**
                 * Specify which of the MCP server's tools require approval. Can be `always`,
                 * `never`, or a filter object associated with tools that require approval.
                 */
                fun mcpToolApprovalFilter(): Optional<McpToolApprovalFilter> =
                    Optional.ofNullable(mcpToolApprovalFilter)

                /**
                 * Specify a single approval policy for all tools. One of `always` or `never`. When
                 * set to `always`, all tools will require approval. When set to `never`, all tools
                 * will not require approval.
                 */
                fun mcpToolApprovalSetting(): Optional<McpToolApprovalSetting> =
                    Optional.ofNullable(mcpToolApprovalSetting)

                fun isMcpToolApprovalFilter(): Boolean = mcpToolApprovalFilter != null

                fun isMcpToolApprovalSetting(): Boolean = mcpToolApprovalSetting != null

                /**
                 * Specify which of the MCP server's tools require approval. Can be `always`,
                 * `never`, or a filter object associated with tools that require approval.
                 */
                fun asMcpToolApprovalFilter(): McpToolApprovalFilter =
                    mcpToolApprovalFilter.getOrThrow("mcpToolApprovalFilter")

                /**
                 * Specify a single approval policy for all tools. One of `always` or `never`. When
                 * set to `always`, all tools will require approval. When set to `never`, all tools
                 * will not require approval.
                 */
                fun asMcpToolApprovalSetting(): McpToolApprovalSetting =
                    mcpToolApprovalSetting.getOrThrow("mcpToolApprovalSetting")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        mcpToolApprovalFilter != null ->
                            visitor.visitMcpToolApprovalFilter(mcpToolApprovalFilter)
                        mcpToolApprovalSetting != null ->
                            visitor.visitMcpToolApprovalSetting(mcpToolApprovalSetting)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): RequireApproval = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitMcpToolApprovalFilter(
                                mcpToolApprovalFilter: McpToolApprovalFilter
                            ) {
                                mcpToolApprovalFilter.validate()
                            }

                            override fun visitMcpToolApprovalSetting(
                                mcpToolApprovalSetting: McpToolApprovalSetting
                            ) {
                                mcpToolApprovalSetting.validate()
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
                            override fun visitMcpToolApprovalFilter(
                                mcpToolApprovalFilter: McpToolApprovalFilter
                            ) = mcpToolApprovalFilter.validity()

                            override fun visitMcpToolApprovalSetting(
                                mcpToolApprovalSetting: McpToolApprovalSetting
                            ) = mcpToolApprovalSetting.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is RequireApproval &&
                        mcpToolApprovalFilter == other.mcpToolApprovalFilter &&
                        mcpToolApprovalSetting == other.mcpToolApprovalSetting
                }

                override fun hashCode(): Int =
                    Objects.hash(mcpToolApprovalFilter, mcpToolApprovalSetting)

                override fun toString(): String =
                    when {
                        mcpToolApprovalFilter != null ->
                            "RequireApproval{mcpToolApprovalFilter=$mcpToolApprovalFilter}"
                        mcpToolApprovalSetting != null ->
                            "RequireApproval{mcpToolApprovalSetting=$mcpToolApprovalSetting}"
                        _json != null -> "RequireApproval{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid RequireApproval")
                    }

                companion object {

                    /**
                     * Specify which of the MCP server's tools require approval. Can be `always`,
                     * `never`, or a filter object associated with tools that require approval.
                     */
                    @JvmStatic
                    fun ofMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter) =
                        RequireApproval(mcpToolApprovalFilter = mcpToolApprovalFilter)

                    /**
                     * Specify a single approval policy for all tools. One of `always` or `never`.
                     * When set to `always`, all tools will require approval. When set to `never`,
                     * all tools will not require approval.
                     */
                    @JvmStatic
                    fun ofMcpToolApprovalSetting(mcpToolApprovalSetting: McpToolApprovalSetting) =
                        RequireApproval(mcpToolApprovalSetting = mcpToolApprovalSetting)
                }

                /**
                 * An interface that defines how to map each variant of [RequireApproval] to a value
                 * of type [T].
                 */
                interface Visitor<out T> {

                    /**
                     * Specify which of the MCP server's tools require approval. Can be `always`,
                     * `never`, or a filter object associated with tools that require approval.
                     */
                    fun visitMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter): T

                    /**
                     * Specify a single approval policy for all tools. One of `always` or `never`.
                     * When set to `always`, all tools will require approval. When set to `never`,
                     * all tools will not require approval.
                     */
                    fun visitMcpToolApprovalSetting(
                        mcpToolApprovalSetting: McpToolApprovalSetting
                    ): T

                    /**
                     * Maps an unknown variant of [RequireApproval] to a value of type [T].
                     *
                     * An instance of [RequireApproval] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown RequireApproval: $json")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<RequireApproval>(RequireApproval::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): RequireApproval {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<McpToolApprovalFilter>())
                                        ?.let {
                                            RequireApproval(
                                                mcpToolApprovalFilter = it,
                                                _json = json,
                                            )
                                        },
                                    tryDeserialize(node, jacksonTypeRef<McpToolApprovalSetting>())
                                        ?.let {
                                            RequireApproval(
                                                mcpToolApprovalSetting = it,
                                                _json = json,
                                            )
                                        },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // array).
                            0 -> RequireApproval(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer :
                    BaseSerializer<RequireApproval>(RequireApproval::class) {

                    override fun serialize(
                        value: RequireApproval,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.mcpToolApprovalFilter != null ->
                                generator.writeObject(value.mcpToolApprovalFilter)
                            value.mcpToolApprovalSetting != null ->
                                generator.writeObject(value.mcpToolApprovalSetting)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid RequireApproval")
                        }
                    }
                }

                /**
                 * Specify which of the MCP server's tools require approval. Can be `always`,
                 * `never`, or a filter object associated with tools that require approval.
                 */
                class McpToolApprovalFilter
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val always: JsonField<Always>,
                    private val never: JsonField<Never>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("always")
                        @ExcludeMissing
                        always: JsonField<Always> = JsonMissing.of(),
                        @JsonProperty("never")
                        @ExcludeMissing
                        never: JsonField<Never> = JsonMissing.of(),
                    ) : this(always, never, mutableMapOf())

                    /**
                     * A filter object to specify which tools are allowed.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun always(): Optional<Always> = always.getOptional("always")

                    /**
                     * A filter object to specify which tools are allowed.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun never(): Optional<Never> = never.getOptional("never")

                    /**
                     * Returns the raw JSON value of [always].
                     *
                     * Unlike [always], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("always")
                    @ExcludeMissing
                    fun _always(): JsonField<Always> = always

                    /**
                     * Returns the raw JSON value of [never].
                     *
                     * Unlike [never], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("never") @ExcludeMissing fun _never(): JsonField<Never> = never

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
                         * Returns a mutable builder for constructing an instance of
                         * [McpToolApprovalFilter].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [McpToolApprovalFilter]. */
                    class Builder internal constructor() {

                        private var always: JsonField<Always> = JsonMissing.of()
                        private var never: JsonField<Never> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(mcpToolApprovalFilter: McpToolApprovalFilter) = apply {
                            always = mcpToolApprovalFilter.always
                            never = mcpToolApprovalFilter.never
                            additionalProperties =
                                mcpToolApprovalFilter.additionalProperties.toMutableMap()
                        }

                        /** A filter object to specify which tools are allowed. */
                        fun always(always: Always) = always(JsonField.of(always))

                        /**
                         * Sets [Builder.always] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.always] with a well-typed [Always] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun always(always: JsonField<Always>) = apply { this.always = always }

                        /** A filter object to specify which tools are allowed. */
                        fun never(never: Never) = never(JsonField.of(never))

                        /**
                         * Sets [Builder.never] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.never] with a well-typed [Never] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun never(never: JsonField<Never>) = apply { this.never = never }

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
                         * Returns an immutable instance of [McpToolApprovalFilter].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): McpToolApprovalFilter =
                            McpToolApprovalFilter(
                                always,
                                never,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): McpToolApprovalFilter = apply {
                        if (validated) {
                            return@apply
                        }

                        always().ifPresent { it.validate() }
                        never().ifPresent { it.validate() }
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
                        (always.asKnown().getOrNull()?.validity() ?: 0) +
                            (never.asKnown().getOrNull()?.validity() ?: 0)

                    /** A filter object to specify which tools are allowed. */
                    class Always
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val readOnly: JsonField<Boolean>,
                        private val toolNames: JsonField<List<String>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("read_only")
                            @ExcludeMissing
                            readOnly: JsonField<Boolean> = JsonMissing.of(),
                            @JsonProperty("tool_names")
                            @ExcludeMissing
                            toolNames: JsonField<List<String>> = JsonMissing.of(),
                        ) : this(readOnly, toolNames, mutableMapOf())

                        /**
                         * Indicates whether or not a tool modifies data or is read-only. If an MCP
                         * server is
                         * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                         * it will match this filter.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                        /**
                         * List of allowed tool names.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun toolNames(): Optional<List<String>> =
                            toolNames.getOptional("tool_names")

                        /**
                         * Returns the raw JSON value of [readOnly].
                         *
                         * Unlike [readOnly], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("read_only")
                        @ExcludeMissing
                        fun _readOnly(): JsonField<Boolean> = readOnly

                        /**
                         * Returns the raw JSON value of [toolNames].
                         *
                         * Unlike [toolNames], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("tool_names")
                        @ExcludeMissing
                        fun _toolNames(): JsonField<List<String>> = toolNames

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
                             * Returns a mutable builder for constructing an instance of [Always].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Always]. */
                        class Builder internal constructor() {

                            private var readOnly: JsonField<Boolean> = JsonMissing.of()
                            private var toolNames: JsonField<MutableList<String>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(always: Always) = apply {
                                readOnly = always.readOnly
                                toolNames = always.toolNames.map { it.toMutableList() }
                                additionalProperties = always.additionalProperties.toMutableMap()
                            }

                            /**
                             * Indicates whether or not a tool modifies data or is read-only. If an
                             * MCP server is
                             * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                             * it will match this filter.
                             */
                            fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                            /**
                             * Sets [Builder.readOnly] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.readOnly] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun readOnly(readOnly: JsonField<Boolean>) = apply {
                                this.readOnly = readOnly
                            }

                            /** List of allowed tool names. */
                            fun toolNames(toolNames: List<String>) =
                                toolNames(JsonField.of(toolNames))

                            /**
                             * Sets [Builder.toolNames] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.toolNames] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun toolNames(toolNames: JsonField<List<String>>) = apply {
                                this.toolNames = toolNames.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [toolNames].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addToolName(toolName: String) = apply {
                                toolNames =
                                    (toolNames ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("toolNames", it).add(toolName)
                                    }
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
                             * Returns an immutable instance of [Always].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Always =
                                Always(
                                    readOnly,
                                    (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Always = apply {
                            if (validated) {
                                return@apply
                            }

                            readOnly()
                            toolNames()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (readOnly.asKnown().isPresent) 1 else 0) +
                                (toolNames.asKnown().getOrNull()?.size ?: 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Always &&
                                readOnly == other.readOnly &&
                                toolNames == other.toolNames &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(readOnly, toolNames, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Always{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
                    }

                    /** A filter object to specify which tools are allowed. */
                    class Never
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val readOnly: JsonField<Boolean>,
                        private val toolNames: JsonField<List<String>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("read_only")
                            @ExcludeMissing
                            readOnly: JsonField<Boolean> = JsonMissing.of(),
                            @JsonProperty("tool_names")
                            @ExcludeMissing
                            toolNames: JsonField<List<String>> = JsonMissing.of(),
                        ) : this(readOnly, toolNames, mutableMapOf())

                        /**
                         * Indicates whether or not a tool modifies data or is read-only. If an MCP
                         * server is
                         * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                         * it will match this filter.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                        /**
                         * List of allowed tool names.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun toolNames(): Optional<List<String>> =
                            toolNames.getOptional("tool_names")

                        /**
                         * Returns the raw JSON value of [readOnly].
                         *
                         * Unlike [readOnly], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("read_only")
                        @ExcludeMissing
                        fun _readOnly(): JsonField<Boolean> = readOnly

                        /**
                         * Returns the raw JSON value of [toolNames].
                         *
                         * Unlike [toolNames], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("tool_names")
                        @ExcludeMissing
                        fun _toolNames(): JsonField<List<String>> = toolNames

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
                             * Returns a mutable builder for constructing an instance of [Never].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Never]. */
                        class Builder internal constructor() {

                            private var readOnly: JsonField<Boolean> = JsonMissing.of()
                            private var toolNames: JsonField<MutableList<String>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(never: Never) = apply {
                                readOnly = never.readOnly
                                toolNames = never.toolNames.map { it.toMutableList() }
                                additionalProperties = never.additionalProperties.toMutableMap()
                            }

                            /**
                             * Indicates whether or not a tool modifies data or is read-only. If an
                             * MCP server is
                             * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                             * it will match this filter.
                             */
                            fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                            /**
                             * Sets [Builder.readOnly] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.readOnly] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun readOnly(readOnly: JsonField<Boolean>) = apply {
                                this.readOnly = readOnly
                            }

                            /** List of allowed tool names. */
                            fun toolNames(toolNames: List<String>) =
                                toolNames(JsonField.of(toolNames))

                            /**
                             * Sets [Builder.toolNames] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.toolNames] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun toolNames(toolNames: JsonField<List<String>>) = apply {
                                this.toolNames = toolNames.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [toolNames].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addToolName(toolName: String) = apply {
                                toolNames =
                                    (toolNames ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("toolNames", it).add(toolName)
                                    }
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
                             * Returns an immutable instance of [Never].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Never =
                                Never(
                                    readOnly,
                                    (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Never = apply {
                            if (validated) {
                                return@apply
                            }

                            readOnly()
                            toolNames()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (readOnly.asKnown().isPresent) 1 else 0) +
                                (toolNames.asKnown().getOrNull()?.size ?: 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Never &&
                                readOnly == other.readOnly &&
                                toolNames == other.toolNames &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(readOnly, toolNames, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Never{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is McpToolApprovalFilter &&
                            always == other.always &&
                            never == other.never &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(always, never, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "McpToolApprovalFilter{always=$always, never=$never, additionalProperties=$additionalProperties}"
                }

                /**
                 * Specify a single approval policy for all tools. One of `always` or `never`. When
                 * set to `always`, all tools will require approval. When set to `never`, all tools
                 * will not require approval.
                 */
                class McpToolApprovalSetting
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

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

                        @JvmField val ALWAYS = of("always")

                        @JvmField val NEVER = of("never")

                        @JvmStatic
                        fun of(value: String) = McpToolApprovalSetting(JsonField.of(value))
                    }

                    /** An enum containing [McpToolApprovalSetting]'s known values. */
                    enum class Known {
                        ALWAYS,
                        NEVER,
                    }

                    /**
                     * An enum containing [McpToolApprovalSetting]'s known values, as well as an
                     * [_UNKNOWN] member.
                     *
                     * An instance of [McpToolApprovalSetting] can contain an unknown value in a
                     * couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        ALWAYS,
                        NEVER,
                        /**
                         * An enum member indicating that [McpToolApprovalSetting] was instantiated
                         * with an unknown value.
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
                            ALWAYS -> Value.ALWAYS
                            NEVER -> Value.NEVER
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
                            ALWAYS -> Known.ALWAYS
                            NEVER -> Known.NEVER
                            else ->
                                throw OpenAIInvalidDataException(
                                    "Unknown McpToolApprovalSetting: $value"
                                )
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

                    fun validate(): McpToolApprovalSetting = apply {
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

                        return other is McpToolApprovalSetting && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is McpTool &&
                    serverLabel == other.serverLabel &&
                    type == other.type &&
                    allowedTools == other.allowedTools &&
                    authorization == other.authorization &&
                    connectorId == other.connectorId &&
                    headers == other.headers &&
                    requireApproval == other.requireApproval &&
                    serverDescription == other.serverDescription &&
                    serverUrl == other.serverUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    serverLabel,
                    type,
                    allowedTools,
                    authorization,
                    connectorId,
                    headers,
                    requireApproval,
                    serverDescription,
                    serverUrl,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "McpTool{serverLabel=$serverLabel, type=$type, allowedTools=$allowedTools, authorization=$authorization, connectorId=$connectorId, headers=$headers, requireApproval=$requireApproval, serverDescription=$serverDescription, serverUrl=$serverUrl, additionalProperties=$additionalProperties}"
        }
    }

    /**
     * Realtime API can write session traces to the [Traces Dashboard](/logs?api=traces). Set to
     * null to disable tracing. Once tracing is enabled for a session, the configuration cannot be
     * modified.
     *
     * `auto` will create a trace for the session with default values for the workflow name, group
     * id, and metadata.
     */
    @JsonDeserialize(using = Tracing.Deserializer::class)
    @JsonSerialize(using = Tracing.Serializer::class)
    class Tracing
    private constructor(
        private val auto: JsonValue? = null,
        private val configuration: TracingConfiguration? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Enables tracing and sets default values for tracing configuration options. Always `auto`.
         */
        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        /** Granular configuration for tracing. */
        fun configuration(): Optional<TracingConfiguration> = Optional.ofNullable(configuration)

        fun isAuto(): Boolean = auto != null

        fun isConfiguration(): Boolean = configuration != null

        /**
         * Enables tracing and sets default values for tracing configuration options. Always `auto`.
         */
        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        /** Granular configuration for tracing. */
        fun asConfiguration(): TracingConfiguration = configuration.getOrThrow("configuration")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                configuration != null -> visitor.visitConfiguration(configuration)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Tracing = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitConfiguration(configuration: TracingConfiguration) {
                        configuration.validate()
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
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitConfiguration(configuration: TracingConfiguration) =
                        configuration.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tracing && auto == other.auto && configuration == other.configuration
        }

        override fun hashCode(): Int = Objects.hash(auto, configuration)

        override fun toString(): String =
            when {
                auto != null -> "Tracing{auto=$auto}"
                configuration != null -> "Tracing{configuration=$configuration}"
                _json != null -> "Tracing{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Tracing")
            }

        companion object {

            /**
             * Enables tracing and sets default values for tracing configuration options. Always
             * `auto`.
             */
            @JvmStatic fun ofAuto() = Tracing(auto = JsonValue.from("auto"))

            /** Granular configuration for tracing. */
            @JvmStatic
            fun ofConfiguration(configuration: TracingConfiguration) =
                Tracing(configuration = configuration)
        }

        /**
         * An interface that defines how to map each variant of [Tracing] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Enables tracing and sets default values for tracing configuration options. Always
             * `auto`.
             */
            fun visitAuto(auto: JsonValue): T

            /** Granular configuration for tracing. */
            fun visitConfiguration(configuration: TracingConfiguration): T

            /**
             * Maps an unknown variant of [Tracing] to a value of type [T].
             *
             * An instance of [Tracing] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Tracing: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Tracing>(Tracing::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Tracing {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Tracing(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<TracingConfiguration>())?.let {
                                Tracing(configuration = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> Tracing(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Tracing>(Tracing::class) {

            override fun serialize(
                value: Tracing,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.configuration != null -> generator.writeObject(value.configuration)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tracing")
                }
            }
        }

        /** Granular configuration for tracing. */
        class TracingConfiguration
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val groupId: JsonField<String>,
            private val metadata: JsonValue,
            private val workflowName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("group_id")
                @ExcludeMissing
                groupId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
                @JsonProperty("workflow_name")
                @ExcludeMissing
                workflowName: JsonField<String> = JsonMissing.of(),
            ) : this(groupId, metadata, workflowName, mutableMapOf())

            /**
             * The group id to attach to this trace to enable filtering and grouping in the Traces
             * Dashboard.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun groupId(): Optional<String> = groupId.getOptional("group_id")

            /**
             * The arbitrary metadata to attach to this trace to enable filtering in the Traces
             * Dashboard.
             */
            @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

            /**
             * The name of the workflow to attach to this trace. This is used to name the trace in
             * the Traces Dashboard.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun workflowName(): Optional<String> = workflowName.getOptional("workflow_name")

            /**
             * Returns the raw JSON value of [groupId].
             *
             * Unlike [groupId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("group_id") @ExcludeMissing fun _groupId(): JsonField<String> = groupId

            /**
             * Returns the raw JSON value of [workflowName].
             *
             * Unlike [workflowName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("workflow_name")
            @ExcludeMissing
            fun _workflowName(): JsonField<String> = workflowName

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
                 * Returns a mutable builder for constructing an instance of [TracingConfiguration].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TracingConfiguration]. */
            class Builder internal constructor() {

                private var groupId: JsonField<String> = JsonMissing.of()
                private var metadata: JsonValue = JsonMissing.of()
                private var workflowName: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tracingConfiguration: TracingConfiguration) = apply {
                    groupId = tracingConfiguration.groupId
                    metadata = tracingConfiguration.metadata
                    workflowName = tracingConfiguration.workflowName
                    additionalProperties = tracingConfiguration.additionalProperties.toMutableMap()
                }

                /**
                 * The group id to attach to this trace to enable filtering and grouping in the
                 * Traces Dashboard.
                 */
                fun groupId(groupId: String) = groupId(JsonField.of(groupId))

                /**
                 * Sets [Builder.groupId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.groupId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun groupId(groupId: JsonField<String>) = apply { this.groupId = groupId }

                /**
                 * The arbitrary metadata to attach to this trace to enable filtering in the Traces
                 * Dashboard.
                 */
                fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

                /**
                 * The name of the workflow to attach to this trace. This is used to name the trace
                 * in the Traces Dashboard.
                 */
                fun workflowName(workflowName: String) = workflowName(JsonField.of(workflowName))

                /**
                 * Sets [Builder.workflowName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workflowName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun workflowName(workflowName: JsonField<String>) = apply {
                    this.workflowName = workflowName
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
                 * Returns an immutable instance of [TracingConfiguration].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): TracingConfiguration =
                    TracingConfiguration(
                        groupId,
                        metadata,
                        workflowName,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TracingConfiguration = apply {
                if (validated) {
                    return@apply
                }

                groupId()
                workflowName()
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
                (if (groupId.asKnown().isPresent) 1 else 0) +
                    (if (workflowName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TracingConfiguration &&
                    groupId == other.groupId &&
                    metadata == other.metadata &&
                    workflowName == other.workflowName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(groupId, metadata, workflowName, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TracingConfiguration{groupId=$groupId, metadata=$metadata, workflowName=$workflowName, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeSessionCreateResponse &&
            clientSecret == other.clientSecret &&
            type == other.type &&
            audio == other.audio &&
            include == other.include &&
            instructions == other.instructions &&
            maxOutputTokens == other.maxOutputTokens &&
            model == other.model &&
            outputModalities == other.outputModalities &&
            prompt == other.prompt &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            tracing == other.tracing &&
            truncation == other.truncation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            clientSecret,
            type,
            audio,
            include,
            instructions,
            maxOutputTokens,
            model,
            outputModalities,
            prompt,
            toolChoice,
            tools,
            tracing,
            truncation,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeSessionCreateResponse{clientSecret=$clientSecret, type=$type, audio=$audio, include=$include, instructions=$instructions, maxOutputTokens=$maxOutputTokens, model=$model, outputModalities=$outputModalities, prompt=$prompt, toolChoice=$toolChoice, tools=$tools, tracing=$tracing, truncation=$truncation, additionalProperties=$additionalProperties}"
}
