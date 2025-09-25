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

/** Create a new Realtime response with these parameters */
class RealtimeResponseCreateParams
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audio: JsonField<RealtimeResponseCreateAudioOutput>,
    private val conversation: JsonField<Conversation>,
    private val input: JsonField<List<ConversationItem>>,
    private val instructions: JsonField<String>,
    private val maxOutputTokens: JsonField<MaxOutputTokens>,
    private val metadata: JsonField<Metadata>,
    private val outputModalities: JsonField<List<OutputModality>>,
    private val prompt: JsonField<ResponsePrompt>,
    private val toolChoice: JsonField<ToolChoice>,
    private val tools: JsonField<List<Tool>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio")
        @ExcludeMissing
        audio: JsonField<RealtimeResponseCreateAudioOutput> = JsonMissing.of(),
        @JsonProperty("conversation")
        @ExcludeMissing
        conversation: JsonField<Conversation> = JsonMissing.of(),
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<List<ConversationItem>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
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
    ) : this(
        audio,
        conversation,
        input,
        instructions,
        maxOutputTokens,
        metadata,
        outputModalities,
        prompt,
        toolChoice,
        tools,
        mutableMapOf(),
    )

    /**
     * Configuration for audio input and output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<RealtimeResponseCreateAudioOutput> = audio.getOptional("audio")

    /**
     * Controls which conversation the response is added to. Currently supports `auto` and `none`,
     * with `auto` as the default value. The `auto` value means that the contents of the response
     * will be added to the default conversation. Set this to `none` to create an out-of-band
     * response which will not add items to default conversation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversation(): Optional<Conversation> = conversation.getOptional("conversation")

    /**
     * Input items to include in the prompt for the model. Using this field creates a new context
     * for this Response instead of using the default conversation. An empty array `[]` will clear
     * the context for this Response. Note that this can include references to items that previously
     * appeared in the session using their id.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<List<ConversationItem>> = input.getOptional("input")

    /**
     * The default system instructions (i.e. system message) prepended to model calls. This field
     * allows the client to guide the model on desired responses. The model can be instructed on
     * response content and format, (e.g. "be extremely succinct", "act friendly", "here are
     * examples of good responses") and on audio behavior (e.g. "talk quickly", "inject emotion into
     * your voice", "laugh frequently"). The instructions are not guaranteed to be followed by the
     * model, but they provide guidance to the model on the desired behavior. Note that the server
     * sets default instructions which will be used if this field is not set and are visible in the
     * `session.created` event at the start of the session.
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
     * The set of modalities the model used to respond, currently the only possible values are
     * `[\"audio\"]`, `[\"text\"]`. Audio output always include a text transcript. Setting the
     * output to mode `text` will disable audio output from the model.
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
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio")
    @ExcludeMissing
    fun _audio(): JsonField<RealtimeResponseCreateAudioOutput> = audio

    /**
     * Returns the raw JSON value of [conversation].
     *
     * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversation")
    @ExcludeMissing
    fun _conversation(): JsonField<Conversation> = conversation

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<ConversationItem>> = input

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
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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
         * Returns a mutable builder for constructing an instance of [RealtimeResponseCreateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponseCreateParams]. */
    class Builder internal constructor() {

        private var audio: JsonField<RealtimeResponseCreateAudioOutput> = JsonMissing.of()
        private var conversation: JsonField<Conversation> = JsonMissing.of()
        private var input: JsonField<MutableList<ConversationItem>>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var outputModalities: JsonField<MutableList<OutputModality>>? = null
        private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
        private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
        private var tools: JsonField<MutableList<Tool>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeResponseCreateParams: RealtimeResponseCreateParams) = apply {
            audio = realtimeResponseCreateParams.audio
            conversation = realtimeResponseCreateParams.conversation
            input = realtimeResponseCreateParams.input.map { it.toMutableList() }
            instructions = realtimeResponseCreateParams.instructions
            maxOutputTokens = realtimeResponseCreateParams.maxOutputTokens
            metadata = realtimeResponseCreateParams.metadata
            outputModalities =
                realtimeResponseCreateParams.outputModalities.map { it.toMutableList() }
            prompt = realtimeResponseCreateParams.prompt
            toolChoice = realtimeResponseCreateParams.toolChoice
            tools = realtimeResponseCreateParams.tools.map { it.toMutableList() }
            additionalProperties = realtimeResponseCreateParams.additionalProperties.toMutableMap()
        }

        /** Configuration for audio input and output. */
        fun audio(audio: RealtimeResponseCreateAudioOutput) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed
         * [RealtimeResponseCreateAudioOutput] value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<RealtimeResponseCreateAudioOutput>) = apply {
            this.audio = audio
        }

        /**
         * Controls which conversation the response is added to. Currently supports `auto` and
         * `none`, with `auto` as the default value. The `auto` value means that the contents of the
         * response will be added to the default conversation. Set this to `none` to create an
         * out-of-band response which will not add items to default conversation.
         */
        fun conversation(conversation: Conversation) = conversation(JsonField.of(conversation))

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
         * Sets [conversation] to an arbitrary [String].
         *
         * You should usually call [conversation] with a well-typed [Conversation] constant instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun conversation(value: String) = conversation(Conversation.of(value))

        /**
         * Input items to include in the prompt for the model. Using this field creates a new
         * context for this Response instead of using the default conversation. An empty array `[]`
         * will clear the context for this Response. Note that this can include references to items
         * that previously appeared in the session using their id.
         */
        fun input(input: List<ConversationItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<ConversationItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun input(input: JsonField<List<ConversationItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [ConversationItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: ConversationItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofRealtimeConversationItemSystemMessage(realtimeConversationItemSystemMessage)`.
         */
        fun addInput(realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage) =
            addInput(
                ConversationItem.ofRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage
                )
            )

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * RealtimeConversationItemSystemMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemSystemMessageInput(
            content: List<RealtimeConversationItemSystemMessage.Content>
        ) = addInput(RealtimeConversationItemSystemMessage.builder().content(content).build())

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofRealtimeConversationItemUserMessage(realtimeConversationItemUserMessage)`.
         */
        fun addInput(realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage) =
            addInput(
                ConversationItem.ofRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage
                )
            )

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * RealtimeConversationItemUserMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemUserMessageInput(
            content: List<RealtimeConversationItemUserMessage.Content>
        ) = addInput(RealtimeConversationItemUserMessage.builder().content(content).build())

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofRealtimeConversationItemAssistantMessage(realtimeConversationItemAssistantMessage)`.
         */
        fun addInput(
            realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
        ) =
            addInput(
                ConversationItem.ofRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage
                )
            )

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * RealtimeConversationItemAssistantMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemAssistantMessageInput(
            content: List<RealtimeConversationItemAssistantMessage.Content>
        ) = addInput(RealtimeConversationItemAssistantMessage.builder().content(content).build())

        /** Alias for calling [addInput] with `ConversationItem.ofFunctionCall(functionCall)`. */
        fun addInput(functionCall: RealtimeConversationItemFunctionCall) =
            addInput(ConversationItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addInput(functionCallOutput: RealtimeConversationItemFunctionCallOutput) =
            addInput(ConversationItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addInput(mcpApprovalResponse: RealtimeMcpApprovalResponse) =
            addInput(ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addInput] with `ConversationItem.ofMcpListTools(mcpListTools)`. */
        fun addInput(mcpListTools: RealtimeMcpListTools) =
            addInput(ConversationItem.ofMcpListTools(mcpListTools))

        /** Alias for calling [addInput] with `ConversationItem.ofMcpCall(mcpCall)`. */
        fun addInput(mcpCall: RealtimeMcpToolCall) = addInput(ConversationItem.ofMcpCall(mcpCall))

        /**
         * Alias for calling [addInput] with
         * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addInput(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
            addInput(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * The default system instructions (i.e. system message) prepended to model calls. This
         * field allows the client to guide the model on desired responses. The model can be
         * instructed on response content and format, (e.g. "be extremely succinct", "act friendly",
         * "here are examples of good responses") and on audio behavior (e.g. "talk quickly",
         * "inject emotion into your voice", "laugh frequently"). The instructions are not
         * guaranteed to be followed by the model, but they provide guidance to the model on the
         * desired behavior. Note that the server sets default instructions which will be used if
         * this field is not set and are visible in the `session.created` event at the start of the
         * session.
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
         * The set of modalities the model used to respond, currently the only possible values are
         * `[\"audio\"]`, `[\"text\"]`. Audio output always include a text transcript. Setting the
         * output to mode `text` will disable audio output from the model.
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

        /**
         * Alias for calling [addTool] with
         * `Tool.ofRealtimeResponseCreateMcp(realtimeResponseCreateMcp)`.
         */
        fun addTool(realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool) =
            addTool(Tool.ofRealtimeResponseCreateMcp(realtimeResponseCreateMcp))

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
         * Returns an immutable instance of [RealtimeResponseCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeResponseCreateParams =
            RealtimeResponseCreateParams(
                audio,
                conversation,
                (input ?: JsonMissing.of()).map { it.toImmutable() },
                instructions,
                maxOutputTokens,
                metadata,
                (outputModalities ?: JsonMissing.of()).map { it.toImmutable() },
                prompt,
                toolChoice,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponseCreateParams = apply {
        if (validated) {
            return@apply
        }

        audio().ifPresent { it.validate() }
        conversation()
        input().ifPresent { it.forEach { it.validate() } }
        instructions()
        maxOutputTokens().ifPresent { it.validate() }
        metadata().ifPresent { it.validate() }
        outputModalities().ifPresent { it.forEach { it.validate() } }
        prompt().ifPresent { it.validate() }
        toolChoice().ifPresent { it.validate() }
        tools().ifPresent { it.forEach { it.validate() } }
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
        (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (conversation.asKnown().isPresent) 1 else 0) +
            (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (maxOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (outputModalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (prompt.asKnown().getOrNull()?.validity() ?: 0) +
            (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /**
     * Controls which conversation the response is added to. Currently supports `auto` and `none`,
     * with `auto` as the default value. The `auto` value means that the contents of the response
     * will be added to the default conversation. Set this to `none` to create an out-of-band
     * response which will not add items to default conversation.
     */
    class Conversation @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = Conversation(JsonField.of(value))
        }

        /** An enum containing [Conversation]'s known values. */
        enum class Known {
            AUTO,
            NONE,
        }

        /**
         * An enum containing [Conversation]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Conversation] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            NONE,
            /**
             * An enum member indicating that [Conversation] was instantiated with an unknown value.
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
                NONE -> Value.NONE
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
                NONE -> Known.NONE
                else -> throw OpenAIInvalidDataException("Unknown Conversation: $value")
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

        fun validate(): Conversation = apply {
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

            return other is Conversation && value == other.value
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
        private val realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool? = null,
        private val _json: JsonValue? = null,
    ) {

        fun realtimeFunction(): Optional<RealtimeFunctionTool> =
            Optional.ofNullable(realtimeFunction)

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        fun realtimeResponseCreateMcp(): Optional<RealtimeResponseCreateMcpTool> =
            Optional.ofNullable(realtimeResponseCreateMcp)

        fun isRealtimeFunction(): Boolean = realtimeFunction != null

        fun isRealtimeResponseCreateMcp(): Boolean = realtimeResponseCreateMcp != null

        fun asRealtimeFunction(): RealtimeFunctionTool =
            realtimeFunction.getOrThrow("realtimeFunction")

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        fun asRealtimeResponseCreateMcp(): RealtimeResponseCreateMcpTool =
            realtimeResponseCreateMcp.getOrThrow("realtimeResponseCreateMcp")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                realtimeFunction != null -> visitor.visitRealtimeFunction(realtimeFunction)
                realtimeResponseCreateMcp != null ->
                    visitor.visitRealtimeResponseCreateMcp(realtimeResponseCreateMcp)
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

                    override fun visitRealtimeResponseCreateMcp(
                        realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool
                    ) {
                        realtimeResponseCreateMcp.validate()
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

                    override fun visitRealtimeResponseCreateMcp(
                        realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool
                    ) = realtimeResponseCreateMcp.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tool &&
                realtimeFunction == other.realtimeFunction &&
                realtimeResponseCreateMcp == other.realtimeResponseCreateMcp
        }

        override fun hashCode(): Int = Objects.hash(realtimeFunction, realtimeResponseCreateMcp)

        override fun toString(): String =
            when {
                realtimeFunction != null -> "Tool{realtimeFunction=$realtimeFunction}"
                realtimeResponseCreateMcp != null ->
                    "Tool{realtimeResponseCreateMcp=$realtimeResponseCreateMcp}"
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
            @JvmStatic
            fun ofRealtimeResponseCreateMcp(
                realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool
            ) = Tool(realtimeResponseCreateMcp = realtimeResponseCreateMcp)
        }

        /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitRealtimeFunction(realtimeFunction: RealtimeFunctionTool): T

            /**
             * Give the model access to additional tools via remote Model Context Protocol (MCP)
             * servers.
             * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
             */
            fun visitRealtimeResponseCreateMcp(
                realtimeResponseCreateMcp: RealtimeResponseCreateMcpTool
            ): T

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
                            tryDeserialize(node, jacksonTypeRef<RealtimeResponseCreateMcpTool>())
                                ?.let { Tool(realtimeResponseCreateMcp = it, _json = json) },
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
                    value.realtimeResponseCreateMcp != null ->
                        generator.writeObject(value.realtimeResponseCreateMcp)
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

        return other is RealtimeResponseCreateParams &&
            audio == other.audio &&
            conversation == other.conversation &&
            input == other.input &&
            instructions == other.instructions &&
            maxOutputTokens == other.maxOutputTokens &&
            metadata == other.metadata &&
            outputModalities == other.outputModalities &&
            prompt == other.prompt &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            audio,
            conversation,
            input,
            instructions,
            maxOutputTokens,
            metadata,
            outputModalities,
            prompt,
            toolChoice,
            tools,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseCreateParams{audio=$audio, conversation=$conversation, input=$input, instructions=$instructions, maxOutputTokens=$maxOutputTokens, metadata=$metadata, outputModalities=$outputModalities, prompt=$prompt, toolChoice=$toolChoice, tools=$tools, additionalProperties=$additionalProperties}"
}
