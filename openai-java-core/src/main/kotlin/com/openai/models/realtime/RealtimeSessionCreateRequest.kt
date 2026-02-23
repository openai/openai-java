// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceMcp
import com.openai.models.responses.ToolChoiceOptions
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Realtime session object configuration. */
class RealtimeSessionCreateRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val audio: JsonField<RealtimeAudioConfig>,
    private val include: JsonField<List<Include>>,
    private val instructions: JsonField<String>,
    private val maxOutputTokens: JsonField<MaxOutputTokens>,
    private val model: JsonField<Model>,
    private val outputModalities: JsonField<List<OutputModality>>,
    private val prompt: JsonField<ResponsePrompt>,
    private val toolChoice: JsonField<RealtimeToolChoiceConfig>,
    private val tools: JsonField<List<RealtimeToolsConfigUnion>>,
    private val tracing: JsonField<RealtimeTracingConfig>,
    private val truncation: JsonField<RealtimeTruncation>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("audio")
        @ExcludeMissing
        audio: JsonField<RealtimeAudioConfig> = JsonMissing.of(),
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
        toolChoice: JsonField<RealtimeToolChoiceConfig> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        tools: JsonField<List<RealtimeToolsConfigUnion>> = JsonMissing.of(),
        @JsonProperty("tracing")
        @ExcludeMissing
        tracing: JsonField<RealtimeTracingConfig> = JsonMissing.of(),
        @JsonProperty("truncation")
        @ExcludeMissing
        truncation: JsonField<RealtimeTruncation> = JsonMissing.of(),
    ) : this(
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
    fun audio(): Optional<RealtimeAudioConfig> = audio.getOptional("audio")

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
    fun toolChoice(): Optional<RealtimeToolChoiceConfig> = toolChoice.getOptional("tool_choice")

    /**
     * Tools available to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<RealtimeToolsConfigUnion>> = tools.getOptional("tools")

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
    fun tracing(): Optional<RealtimeTracingConfig> = tracing.getOptional("tracing")

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
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<RealtimeAudioConfig> = audio

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
    fun _toolChoice(): JsonField<RealtimeToolChoiceConfig> = toolChoice

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tools")
    @ExcludeMissing
    fun _tools(): JsonField<List<RealtimeToolsConfigUnion>> = tools

    /**
     * Returns the raw JSON value of [tracing].
     *
     * Unlike [tracing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tracing")
    @ExcludeMissing
    fun _tracing(): JsonField<RealtimeTracingConfig> = tracing

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
         * Returns a mutable builder for constructing an instance of [RealtimeSessionCreateRequest].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeSessionCreateRequest]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("realtime")
        private var audio: JsonField<RealtimeAudioConfig> = JsonMissing.of()
        private var include: JsonField<MutableList<Include>>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
        private var model: JsonField<Model> = JsonMissing.of()
        private var outputModalities: JsonField<MutableList<OutputModality>>? = null
        private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
        private var toolChoice: JsonField<RealtimeToolChoiceConfig> = JsonMissing.of()
        private var tools: JsonField<MutableList<RealtimeToolsConfigUnion>>? = null
        private var tracing: JsonField<RealtimeTracingConfig> = JsonMissing.of()
        private var truncation: JsonField<RealtimeTruncation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeSessionCreateRequest: RealtimeSessionCreateRequest) = apply {
            type = realtimeSessionCreateRequest.type
            audio = realtimeSessionCreateRequest.audio
            include = realtimeSessionCreateRequest.include.map { it.toMutableList() }
            instructions = realtimeSessionCreateRequest.instructions
            maxOutputTokens = realtimeSessionCreateRequest.maxOutputTokens
            model = realtimeSessionCreateRequest.model
            outputModalities =
                realtimeSessionCreateRequest.outputModalities.map { it.toMutableList() }
            prompt = realtimeSessionCreateRequest.prompt
            toolChoice = realtimeSessionCreateRequest.toolChoice
            tools = realtimeSessionCreateRequest.tools.map { it.toMutableList() }
            tracing = realtimeSessionCreateRequest.tracing
            truncation = realtimeSessionCreateRequest.truncation
            additionalProperties = realtimeSessionCreateRequest.additionalProperties.toMutableMap()
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
        fun audio(audio: RealtimeAudioConfig) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [RealtimeAudioConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun audio(audio: JsonField<RealtimeAudioConfig>) = apply { this.audio = audio }

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
        fun toolChoice(toolChoice: RealtimeToolChoiceConfig) = toolChoice(JsonField.of(toolChoice))

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [RealtimeToolChoiceConfig]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun toolChoice(toolChoice: JsonField<RealtimeToolChoiceConfig>) = apply {
            this.toolChoice = toolChoice
        }

        /**
         * Alias for calling [toolChoice] with
         * `RealtimeToolChoiceConfig.ofToolChoiceOptions(toolChoiceOptions)`.
         */
        fun toolChoice(toolChoiceOptions: ToolChoiceOptions) =
            toolChoice(RealtimeToolChoiceConfig.ofToolChoiceOptions(toolChoiceOptions))

        /**
         * Alias for calling [toolChoice] with
         * `RealtimeToolChoiceConfig.ofToolChoiceFunction(toolChoiceFunction)`.
         */
        fun toolChoice(toolChoiceFunction: ToolChoiceFunction) =
            toolChoice(RealtimeToolChoiceConfig.ofToolChoiceFunction(toolChoiceFunction))

        /**
         * Alias for calling [toolChoice] with
         * `RealtimeToolChoiceConfig.ofToolChoiceMcp(toolChoiceMcp)`.
         */
        fun toolChoice(toolChoiceMcp: ToolChoiceMcp) =
            toolChoice(RealtimeToolChoiceConfig.ofToolChoiceMcp(toolChoiceMcp))

        /** Tools available to the model. */
        fun tools(tools: List<RealtimeToolsConfigUnion>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed
         * `List<RealtimeToolsConfigUnion>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun tools(tools: JsonField<List<RealtimeToolsConfigUnion>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [RealtimeToolsConfigUnion] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: RealtimeToolsConfigUnion) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `RealtimeToolsConfigUnion.ofFunction(function)`. */
        fun addTool(function: RealtimeFunctionTool) =
            addTool(RealtimeToolsConfigUnion.ofFunction(function))

        /** Alias for calling [addTool] with `RealtimeToolsConfigUnion.ofMcp(mcp)`. */
        fun addTool(mcp: RealtimeToolsConfigUnion.Mcp) =
            addTool(RealtimeToolsConfigUnion.ofMcp(mcp))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * RealtimeToolsConfigUnion.Mcp.builder()
         *     .serverLabel(serverLabel)
         *     .build()
         * ```
         */
        fun addMcpTool(serverLabel: String) =
            addTool(RealtimeToolsConfigUnion.Mcp.builder().serverLabel(serverLabel).build())

        /**
         * Realtime API can write session traces to the [Traces Dashboard](/logs?api=traces). Set to
         * null to disable tracing. Once tracing is enabled for a session, the configuration cannot
         * be modified.
         *
         * `auto` will create a trace for the session with default values for the workflow name,
         * group id, and metadata.
         */
        fun tracing(tracing: RealtimeTracingConfig?) = tracing(JsonField.ofNullable(tracing))

        /** Alias for calling [Builder.tracing] with `tracing.orElse(null)`. */
        fun tracing(tracing: Optional<RealtimeTracingConfig>) = tracing(tracing.getOrNull())

        /**
         * Sets [Builder.tracing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tracing] with a well-typed [RealtimeTracingConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tracing(tracing: JsonField<RealtimeTracingConfig>) = apply { this.tracing = tracing }

        /** Alias for calling [tracing] with `RealtimeTracingConfig.ofAuto()`. */
        fun tracingAuto() = tracing(RealtimeTracingConfig.ofAuto())

        /**
         * Alias for calling [tracing] with
         * `RealtimeTracingConfig.ofTracingConfiguration(tracingConfiguration)`.
         */
        fun tracing(tracingConfiguration: RealtimeTracingConfig.TracingConfiguration) =
            tracing(RealtimeTracingConfig.ofTracingConfiguration(tracingConfiguration))

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
         * Returns an immutable instance of [RealtimeSessionCreateRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeSessionCreateRequest =
            RealtimeSessionCreateRequest(
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

    fun validate(): RealtimeSessionCreateRequest = apply {
        if (validated) {
            return@apply
        }

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
                    // all the possible variants (e.g. deserializing from boolean).
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

            @JvmField val GPT_REALTIME_1_5 = of("gpt-realtime-1.5")

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

            @JvmField val GPT_REALTIME_MINI_2025_12_15 = of("gpt-realtime-mini-2025-12-15")

            @JvmField val GPT_AUDIO_1_5 = of("gpt-audio-1.5")

            @JvmField val GPT_AUDIO_MINI = of("gpt-audio-mini")

            @JvmField val GPT_AUDIO_MINI_2025_10_06 = of("gpt-audio-mini-2025-10-06")

            @JvmField val GPT_AUDIO_MINI_2025_12_15 = of("gpt-audio-mini-2025-12-15")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_REALTIME,
            GPT_REALTIME_1_5,
            GPT_REALTIME_2025_08_28,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
            GPT_REALTIME_MINI,
            GPT_REALTIME_MINI_2025_10_06,
            GPT_REALTIME_MINI_2025_12_15,
            GPT_AUDIO_1_5,
            GPT_AUDIO_MINI,
            GPT_AUDIO_MINI_2025_10_06,
            GPT_AUDIO_MINI_2025_12_15,
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
            GPT_REALTIME_1_5,
            GPT_REALTIME_2025_08_28,
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
            GPT_REALTIME_MINI,
            GPT_REALTIME_MINI_2025_10_06,
            GPT_REALTIME_MINI_2025_12_15,
            GPT_AUDIO_1_5,
            GPT_AUDIO_MINI,
            GPT_AUDIO_MINI_2025_10_06,
            GPT_AUDIO_MINI_2025_12_15,
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
                GPT_REALTIME_1_5 -> Value.GPT_REALTIME_1_5
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
                GPT_REALTIME_MINI_2025_12_15 -> Value.GPT_REALTIME_MINI_2025_12_15
                GPT_AUDIO_1_5 -> Value.GPT_AUDIO_1_5
                GPT_AUDIO_MINI -> Value.GPT_AUDIO_MINI
                GPT_AUDIO_MINI_2025_10_06 -> Value.GPT_AUDIO_MINI_2025_10_06
                GPT_AUDIO_MINI_2025_12_15 -> Value.GPT_AUDIO_MINI_2025_12_15
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
                GPT_REALTIME_1_5 -> Known.GPT_REALTIME_1_5
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
                GPT_REALTIME_MINI_2025_12_15 -> Known.GPT_REALTIME_MINI_2025_12_15
                GPT_AUDIO_1_5 -> Known.GPT_AUDIO_1_5
                GPT_AUDIO_MINI -> Known.GPT_AUDIO_MINI
                GPT_AUDIO_MINI_2025_10_06 -> Known.GPT_AUDIO_MINI_2025_10_06
                GPT_AUDIO_MINI_2025_12_15 -> Known.GPT_AUDIO_MINI_2025_12_15
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeSessionCreateRequest &&
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
        "RealtimeSessionCreateRequest{type=$type, audio=$audio, include=$include, instructions=$instructions, maxOutputTokens=$maxOutputTokens, model=$model, outputModalities=$outputModalities, prompt=$prompt, toolChoice=$toolChoice, tools=$tools, tracing=$tracing, truncation=$truncation, additionalProperties=$additionalProperties}"
}
