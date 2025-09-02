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

/**
 * This event instructs the server to create a Response, which means triggering model inference.
 * When in Server VAD mode, the server will create Responses automatically.
 *
 * A Response will include at least one Item, and may have two, in which case the second will be a
 * function call. These Items will be appended to the conversation history.
 *
 * The server will respond with a `response.created` event, events for Items and content created,
 * and finally a `response.done` event to indicate the Response is complete.
 *
 * The `response.create` event includes inference configuration like `instructions`, and
 * `temperature`. These fields will override the Session's configuration for this Response only.
 */
class ResponseCreateEvent
private constructor(
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val response: JsonField<Response>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("response") @ExcludeMissing response: JsonField<Response> = JsonMissing.of(),
    ) : this(type, eventId, response, mutableMapOf())

    /**
     * The event type, must be `response.create`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.create")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client-generated ID used to identify this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Create a new Realtime response with these parameters
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun response(): Optional<Response> = response.getOptional("response")

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [response].
     *
     * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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

        /** Returns a mutable builder for constructing an instance of [ResponseCreateEvent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCreateEvent]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("response.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var response: JsonField<Response> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseCreateEvent: ResponseCreateEvent) = apply {
            type = responseCreateEvent.type
            eventId = responseCreateEvent.eventId
            response = responseCreateEvent.response
            additionalProperties = responseCreateEvent.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional client-generated ID used to identify this event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** Create a new Realtime response with these parameters */
        fun response(response: Response) = response(JsonField.of(response))

        /**
         * Sets [Builder.response] to an arbitrary JSON value.
         *
         * You should usually call [Builder.response] with a well-typed [Response] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun response(response: JsonField<Response>) = apply { this.response = response }

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
         * Returns an immutable instance of [ResponseCreateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseCreateEvent =
            ResponseCreateEvent(type, eventId, response, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ResponseCreateEvent = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("response.create")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
        response().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("response.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (response.asKnown().getOrNull()?.validity() ?: 0)

    /** Create a new Realtime response with these parameters */
    class Response
    private constructor(
        private val conversation: JsonField<Conversation>,
        private val input: JsonField<List<ConversationItem>>,
        private val instructions: JsonField<String>,
        private val maxOutputTokens: JsonField<MaxOutputTokens>,
        private val metadata: JsonField<Metadata>,
        private val modalities: JsonField<List<Modality>>,
        private val outputAudioFormat: JsonField<OutputAudioFormat>,
        private val prompt: JsonField<ResponsePrompt>,
        private val temperature: JsonField<Double>,
        private val toolChoice: JsonField<ToolChoice>,
        private val tools: JsonField<List<Tool>>,
        private val voice: JsonField<Voice>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
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
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("modalities")
            @ExcludeMissing
            modalities: JsonField<List<Modality>> = JsonMissing.of(),
            @JsonProperty("output_audio_format")
            @ExcludeMissing
            outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of(),
            @JsonProperty("prompt")
            @ExcludeMissing
            prompt: JsonField<ResponsePrompt> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
        ) : this(
            conversation,
            input,
            instructions,
            maxOutputTokens,
            metadata,
            modalities,
            outputAudioFormat,
            prompt,
            temperature,
            toolChoice,
            tools,
            voice,
            mutableMapOf(),
        )

        /**
         * Controls which conversation the response is added to. Currently supports `auto` and
         * `none`, with `auto` as the default value. The `auto` value means that the contents of the
         * response will be added to the default conversation. Set this to `none` to create an
         * out-of-band response which will not add items to default conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun conversation(): Optional<Conversation> = conversation.getOptional("conversation")

        /**
         * Input items to include in the prompt for the model. Using this field creates a new
         * context for this Response instead of using the default conversation. An empty array `[]`
         * will clear the context for this Response. Note that this can include references to items
         * from the default conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<List<ConversationItem>> = input.getOptional("input")

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
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun modalities(): Optional<List<Modality>> = modalities.getOptional("modalities")

        /**
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputAudioFormat(): Optional<OutputAudioFormat> =
            outputAudioFormat.getOptional("output_audio_format")

        /**
         * Reference to a prompt template and its variables.
         * [Learn more](https://platform.openai.com/docs/guides/text?api-mode=responses#reusable-prompts).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prompt(): Optional<ResponsePrompt> = prompt.getOptional("prompt")

        /**
         * Sampling temperature for the model, limited to [0.6, 1.2]. Defaults to 0.8.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * How the model chooses tools. Provide one of the string modes or force a specific
         * function/MCP tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

        /**
         * Tools (functions) available to the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<Tool>> = tools.getOptional("tools")

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, and `verse`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun voice(): Optional<Voice> = voice.getOptional("voice")

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
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input")
        @ExcludeMissing
        fun _input(): JsonField<List<ConversationItem>> = input

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
        fun _maxOutputTokens(): JsonField<MaxOutputTokens> = maxOutputTokens

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
         * Returns the raw JSON value of [outputAudioFormat].
         *
         * Unlike [outputAudioFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_audio_format")
        @ExcludeMissing
        fun _outputAudioFormat(): JsonField<OutputAudioFormat> = outputAudioFormat

        /**
         * Returns the raw JSON value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<ResponsePrompt> = prompt

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
        fun _toolChoice(): JsonField<ToolChoice> = toolChoice

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

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

            /** Returns a mutable builder for constructing an instance of [Response]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Response]. */
        class Builder internal constructor() {

            private var conversation: JsonField<Conversation> = JsonMissing.of()
            private var input: JsonField<MutableList<ConversationItem>>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of()
            private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var voice: JsonField<Voice> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(response: Response) = apply {
                conversation = response.conversation
                input = response.input.map { it.toMutableList() }
                instructions = response.instructions
                maxOutputTokens = response.maxOutputTokens
                metadata = response.metadata
                modalities = response.modalities.map { it.toMutableList() }
                outputAudioFormat = response.outputAudioFormat
                prompt = response.prompt
                temperature = response.temperature
                toolChoice = response.toolChoice
                tools = response.tools.map { it.toMutableList() }
                voice = response.voice
                additionalProperties = response.additionalProperties.toMutableMap()
            }

            /**
             * Controls which conversation the response is added to. Currently supports `auto` and
             * `none`, with `auto` as the default value. The `auto` value means that the contents of
             * the response will be added to the default conversation. Set this to `none` to create
             * an out-of-band response which will not add items to default conversation.
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
             * You should usually call [conversation] with a well-typed [Conversation] constant
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun conversation(value: String) = conversation(Conversation.of(value))

            /**
             * Input items to include in the prompt for the model. Using this field creates a new
             * context for this Response instead of using the default conversation. An empty array
             * `[]` will clear the context for this Response. Note that this can include references
             * to items from the default conversation.
             */
            fun input(input: List<ConversationItem>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed `List<ConversationItem>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
            fun addInput(
                realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
            ) =
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
            ) =
                addInput(
                    RealtimeConversationItemAssistantMessage.builder().content(content).build()
                )

            /**
             * Alias for calling [addInput] with `ConversationItem.ofFunctionCall(functionCall)`.
             */
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

            /**
             * Alias for calling [addInput] with `ConversationItem.ofMcpListTools(mcpListTools)`.
             */
            fun addInput(mcpListTools: RealtimeMcpListTools) =
                addInput(ConversationItem.ofMcpListTools(mcpListTools))

            /** Alias for calling [addInput] with `ConversationItem.ofMcpToolCall(mcpToolCall)`. */
            fun addInput(mcpToolCall: RealtimeMcpToolCall) =
                addInput(ConversationItem.ofMcpToolCall(mcpToolCall))

            /**
             * Alias for calling [addInput] with
             * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
             */
            fun addInput(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
                addInput(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

            /**
             * The default system instructions (i.e. system message) prepended to model calls. This
             * field allows the client to guide the model on desired responses. The model can be
             * instructed on response content and format, (e.g. "be extremely succinct", "act
             * friendly", "here are examples of good responses") and on audio behavior (e.g. "talk
             * quickly", "inject emotion into your voice", "laugh frequently"). The instructions are
             * not guaranteed to be followed by the model, but they provide guidance to the model on
             * the desired behavior.
             *
             * Note that the server sets default instructions which will be used if this field is
             * not set and are visible in the `session.created` event at the start of the session.
             */
            fun instructions(instructions: String) = instructions(JsonField.of(instructions))

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
             * Maximum number of output tokens for a single assistant response, inclusive of tool
             * calls. Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the
             * maximum available tokens for a given model. Defaults to `inf`.
             */
            fun maxOutputTokens(maxOutputTokens: MaxOutputTokens) =
                maxOutputTokens(JsonField.of(maxOutputTokens))

            /**
             * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxOutputTokens] with a well-typed [MaxOutputTokens]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * The set of modalities the model can respond with. To disable audio, set this to
             * ["text"].
             */
            fun modalities(modalities: List<Modality>) = modalities(JsonField.of(modalities))

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

            /** The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
            fun outputAudioFormat(outputAudioFormat: OutputAudioFormat) =
                outputAudioFormat(JsonField.of(outputAudioFormat))

            /**
             * Sets [Builder.outputAudioFormat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputAudioFormat] with a well-typed
             * [OutputAudioFormat] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun outputAudioFormat(outputAudioFormat: JsonField<OutputAudioFormat>) = apply {
                this.outputAudioFormat = outputAudioFormat
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

            /** Sampling temperature for the model, limited to [0.6, 1.2]. Defaults to 0.8. */
            fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

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
            fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply {
                this.toolChoice = toolChoice
            }

            /** Alias for calling [toolChoice] with `ToolChoice.ofOptions(options)`. */
            fun toolChoice(options: ToolChoiceOptions) = toolChoice(ToolChoice.ofOptions(options))

            /** Alias for calling [toolChoice] with `ToolChoice.ofFunction(function)`. */
            fun toolChoice(function: ToolChoiceFunction) =
                toolChoice(ToolChoice.ofFunction(function))

            /** Alias for calling [toolChoice] with `ToolChoice.ofMcp(mcp)`. */
            fun toolChoice(mcp: ToolChoiceMcp) = toolChoice(ToolChoice.ofMcp(mcp))

            /** Tools (functions) available to the model. */
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

            /**
             * The voice the model uses to respond. Voice cannot be changed during the session once
             * the model has responded with audio at least once. Current voice options are `alloy`,
             * `ash`, `ballad`, `coral`, `echo`, `sage`, `shimmer`, and `verse`.
             */
            fun voice(voice: Voice) = voice(JsonField.of(voice))

            /**
             * Sets [Builder.voice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             */
            fun build(): Response =
                Response(
                    conversation,
                    (input ?: JsonMissing.of()).map { it.toImmutable() },
                    instructions,
                    maxOutputTokens,
                    metadata,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    outputAudioFormat,
                    prompt,
                    temperature,
                    toolChoice,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    voice,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            conversation()
            input().ifPresent { it.forEach { it.validate() } }
            instructions()
            maxOutputTokens().ifPresent { it.validate() }
            metadata().ifPresent { it.validate() }
            modalities().ifPresent { it.forEach { it.validate() } }
            outputAudioFormat().ifPresent { it.validate() }
            prompt().ifPresent { it.validate() }
            temperature()
            toolChoice().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
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
            (if (conversation.asKnown().isPresent) 1 else 0) +
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (maxOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (outputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (prompt.asKnown().getOrNull()?.validity() ?: 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (voice.asKnown().isPresent) 1 else 0)

        /**
         * Controls which conversation the response is added to. Currently supports `auto` and
         * `none`, with `auto` as the default value. The `auto` value means that the contents of the
         * response will be added to the default conversation. Set this to `none` to create an
         * out-of-band response which will not add items to default conversation.
         */
        class Conversation @JsonCreator private constructor(private val value: JsonField<String>) :
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                NONE,
                /**
                 * An enum member indicating that [Conversation] was instantiated with an unknown
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
                    NONE -> Value.NONE
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
                    NONE -> Known.NONE
                    else -> throw OpenAIInvalidDataException("Unknown Conversation: $value")
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
                                    throw OpenAIInvalidDataException(
                                        "'inf' is invalid, received $it"
                                    )
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
             * An interface that defines how to map each variant of [MaxOutputTokens] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                fun visitInteger(integer: Long): T

                fun visitInf(inf: JsonValue): T

                /**
                 * Maps an unknown variant of [MaxOutputTokens] to a value of type [T].
                 *
                 * An instance of [MaxOutputTokens] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown MaxOutputTokens: $json")
                }
            }

            internal class Deserializer :
                BaseDeserializer<MaxOutputTokens>(MaxOutputTokens::class) {

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> MaxOutputTokens(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
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
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
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

        class Modality @JsonCreator private constructor(private val value: JsonField<String>) :
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                AUDIO,
                /**
                 * An enum member indicating that [Modality] was instantiated with an unknown value.
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
                    TEXT -> Value.TEXT
                    AUDIO -> Value.AUDIO
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
                    TEXT -> Known.TEXT
                    AUDIO -> Known.AUDIO
                    else -> throw OpenAIInvalidDataException("Unknown Modality: $value")
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

            fun validate(): Modality = apply {
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

                return other is Modality && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
        class OutputAudioFormat
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

                @JvmField val PCM16 = of("pcm16")

                @JvmField val G711_ULAW = of("g711_ulaw")

                @JvmField val G711_ALAW = of("g711_alaw")

                @JvmStatic fun of(value: String) = OutputAudioFormat(JsonField.of(value))
            }

            /** An enum containing [OutputAudioFormat]'s known values. */
            enum class Known {
                PCM16,
                G711_ULAW,
                G711_ALAW,
            }

            /**
             * An enum containing [OutputAudioFormat]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [OutputAudioFormat] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PCM16,
                G711_ULAW,
                G711_ALAW,
                /**
                 * An enum member indicating that [OutputAudioFormat] was instantiated with an
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
                    PCM16 -> Value.PCM16
                    G711_ULAW -> Value.G711_ULAW
                    G711_ALAW -> Value.G711_ALAW
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
                    PCM16 -> Known.PCM16
                    G711_ULAW -> Known.G711_ULAW
                    G711_ALAW -> Known.G711_ALAW
                    else -> throw OpenAIInvalidDataException("Unknown OutputAudioFormat: $value")
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

            fun validate(): OutputAudioFormat = apply {
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

                return other is OutputAudioFormat && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * How the model chooses tools. Provide one of the string modes or force a specific
         * function/MCP tool.
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

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
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

            /**
             * Use this option to force the model to call a specific tool on a remote MCP server.
             */
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

                        override fun visitFunction(function: ToolChoiceFunction) =
                            function.validity()

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
                 * `auto` means the model can pick between generating a message or calling one or
                 * more tools.
                 *
                 * `required` means the model must call one or more tools.
                 */
                @JvmStatic fun ofOptions(options: ToolChoiceOptions) = ToolChoice(options = options)

                /** Use this option to force the model to call a specific function. */
                @JvmStatic
                fun ofFunction(function: ToolChoiceFunction) = ToolChoice(function = function)

                /**
                 * Use this option to force the model to call a specific tool on a remote MCP
                 * server.
                 */
                @JvmStatic fun ofMcp(mcp: ToolChoiceMcp) = ToolChoice(mcp = mcp)
            }

            /**
             * An interface that defines how to map each variant of [ToolChoice] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /**
                 * Controls which (if any) tool is called by the model.
                 *
                 * `none` means the model will not call any tool and instead generates a message.
                 *
                 * `auto` means the model can pick between generating a message or calling one or
                 * more tools.
                 *
                 * `required` means the model must call one or more tools.
                 */
                fun visitOptions(options: ToolChoiceOptions): T

                /** Use this option to force the model to call a specific function. */
                fun visitFunction(function: ToolChoiceFunction): T

                /**
                 * Use this option to force the model to call a specific tool on a remote MCP
                 * server.
                 */
                fun visitMcp(mcp: ToolChoiceMcp): T

                /**
                 * Maps an unknown variant of [ToolChoice] to a value of type [T].
                 *
                 * An instance of [ToolChoice] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
                        0 -> ToolChoice(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
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

        class Tool
        private constructor(
            private val description: JsonField<String>,
            private val name: JsonField<String>,
            private val parameters: JsonValue,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("parameters")
                @ExcludeMissing
                parameters: JsonValue = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(description, name, parameters, type, mutableMapOf())

            /**
             * The description of the function, including guidance on when and how to call it, and
             * guidance about what to tell the user when calling (if anything).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * The name of the function.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /** Parameters of the function in JSON Schema. */
            @JsonProperty("parameters") @ExcludeMissing fun _parameters(): JsonValue = parameters

            /**
             * The type of the tool, i.e. `function`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

                /** Returns a mutable builder for constructing an instance of [Tool]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tool]. */
            class Builder internal constructor() {

                private var description: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var parameters: JsonValue = JsonMissing.of()
                private var type: JsonField<Type> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tool: Tool) = apply {
                    description = tool.description
                    name = tool.name
                    parameters = tool.parameters
                    type = tool.type
                    additionalProperties = tool.additionalProperties.toMutableMap()
                }

                /**
                 * The description of the function, including guidance on when and how to call it,
                 * and guidance about what to tell the user when calling (if anything).
                 */
                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** The name of the function. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Parameters of the function in JSON Schema. */
                fun parameters(parameters: JsonValue) = apply { this.parameters = parameters }

                /** The type of the tool, i.e. `function`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [Tool].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Tool =
                    Tool(description, name, parameters, type, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Tool = apply {
                if (validated) {
                    return@apply
                }

                description()
                name()
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
            internal fun validity(): Int =
                (if (description.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /** The type of the tool, i.e. `function`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val FUNCTION = of("function")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    FUNCTION
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    FUNCTION,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
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
                        FUNCTION -> Value.FUNCTION
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
                        FUNCTION -> Known.FUNCTION
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

                fun validate(): Type = apply {
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

                    return other is Type && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Tool &&
                    description == other.description &&
                    name == other.name &&
                    parameters == other.parameters &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, name, parameters, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Tool{description=$description, name=$name, parameters=$parameters, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, and `verse`.
         */
        class Voice @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
                 * An enum member indicating that [Voice] was instantiated with an unknown value.
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
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
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
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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

            return other is Response &&
                conversation == other.conversation &&
                input == other.input &&
                instructions == other.instructions &&
                maxOutputTokens == other.maxOutputTokens &&
                metadata == other.metadata &&
                modalities == other.modalities &&
                outputAudioFormat == other.outputAudioFormat &&
                prompt == other.prompt &&
                temperature == other.temperature &&
                toolChoice == other.toolChoice &&
                tools == other.tools &&
                voice == other.voice &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                conversation,
                input,
                instructions,
                maxOutputTokens,
                metadata,
                modalities,
                outputAudioFormat,
                prompt,
                temperature,
                toolChoice,
                tools,
                voice,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Response{conversation=$conversation, input=$input, instructions=$instructions, maxOutputTokens=$maxOutputTokens, metadata=$metadata, modalities=$modalities, outputAudioFormat=$outputAudioFormat, prompt=$prompt, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, voice=$voice, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseCreateEvent &&
            type == other.type &&
            eventId == other.eventId &&
            response == other.response &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, eventId, response, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCreateEvent{type=$type, eventId=$eventId, response=$response, additionalProperties=$additionalProperties}"
}
