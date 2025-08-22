// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
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
        private val input: JsonField<List<ConversationItemWithReference>>,
        private val instructions: JsonField<String>,
        private val maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>,
        private val metadata: JsonField<Metadata>,
        private val modalities: JsonField<List<Modality>>,
        private val outputAudioFormat: JsonField<OutputAudioFormat>,
        private val temperature: JsonField<Double>,
        private val toolChoice: JsonField<String>,
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
            input: JsonField<List<ConversationItemWithReference>> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("max_response_output_tokens")
            @ExcludeMissing
            maxResponseOutputTokens: JsonField<MaxResponseOutputTokens> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("modalities")
            @ExcludeMissing
            modalities: JsonField<List<Modality>> = JsonMissing.of(),
            @JsonProperty("output_audio_format")
            @ExcludeMissing
            outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
        ) : this(
            conversation,
            input,
            instructions,
            maxResponseOutputTokens,
            metadata,
            modalities,
            outputAudioFormat,
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
        fun input(): Optional<List<ConversationItemWithReference>> = input.getOptional("input")

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
        fun maxResponseOutputTokens(): Optional<MaxResponseOutputTokens> =
            maxResponseOutputTokens.getOptional("max_response_output_tokens")

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
         * Sampling temperature for the model, limited to [0.6, 1.2]. Defaults to 0.8.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a
         * function, like `{"type": "function", "function": {"name": "my_function"}}`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolChoice(): Optional<String> = toolChoice.getOptional("tool_choice")

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
        fun _input(): JsonField<List<ConversationItemWithReference>> = input

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
         * Returns the raw JSON value of [maxResponseOutputTokens].
         *
         * Unlike [maxResponseOutputTokens], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_response_output_tokens")
        @ExcludeMissing
        fun _maxResponseOutputTokens(): JsonField<MaxResponseOutputTokens> = maxResponseOutputTokens

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
        fun _toolChoice(): JsonField<String> = toolChoice

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
            private var input: JsonField<MutableList<ConversationItemWithReference>>? = null
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxResponseOutputTokens: JsonField<MaxResponseOutputTokens> =
                JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolChoice: JsonField<String> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var voice: JsonField<Voice> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(response: Response) = apply {
                conversation = response.conversation
                input = response.input.map { it.toMutableList() }
                instructions = response.instructions
                maxResponseOutputTokens = response.maxResponseOutputTokens
                metadata = response.metadata
                modalities = response.modalities.map { it.toMutableList() }
                outputAudioFormat = response.outputAudioFormat
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
            fun input(input: List<ConversationItemWithReference>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed
             * `List<ConversationItemWithReference>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun input(input: JsonField<List<ConversationItemWithReference>>) = apply {
                this.input = input.map { it.toMutableList() }
            }

            /**
             * Adds a single [ConversationItemWithReference] to [Builder.input].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInput(input: ConversationItemWithReference) = apply {
                this.input =
                    (this.input ?: JsonField.of(mutableListOf())).also {
                        checkKnown("input", it).add(input)
                    }
            }

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
            fun maxResponseOutputTokens(maxResponseOutputTokens: MaxResponseOutputTokens) =
                maxResponseOutputTokens(JsonField.of(maxResponseOutputTokens))

            /**
             * Sets [Builder.maxResponseOutputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxResponseOutputTokens] with a well-typed
             * [MaxResponseOutputTokens] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun maxResponseOutputTokens(
                maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>
            ) = apply { this.maxResponseOutputTokens = maxResponseOutputTokens }

            /**
             * Alias for calling [maxResponseOutputTokens] with
             * `MaxResponseOutputTokens.ofInteger(integer)`.
             */
            fun maxResponseOutputTokens(integer: Long) =
                maxResponseOutputTokens(MaxResponseOutputTokens.ofInteger(integer))

            /**
             * Alias for calling [maxResponseOutputTokens] with `MaxResponseOutputTokens.ofInf()`.
             */
            fun maxResponseOutputTokensInf() =
                maxResponseOutputTokens(MaxResponseOutputTokens.ofInf())

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
             * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a
             * function, like `{"type": "function", "function": {"name": "my_function"}}`.
             */
            fun toolChoice(toolChoice: String) = toolChoice(JsonField.of(toolChoice))

            /**
             * Sets [Builder.toolChoice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolChoice] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolChoice(toolChoice: JsonField<String>) = apply { this.toolChoice = toolChoice }

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
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                    maxResponseOutputTokens,
                    metadata,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    outputAudioFormat,
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
            maxResponseOutputTokens().ifPresent { it.validate() }
            metadata().ifPresent { it.validate() }
            modalities().ifPresent { it.forEach { it.validate() } }
            outputAudioFormat().ifPresent { it.validate() }
            temperature()
            toolChoice()
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
                (maxResponseOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (outputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (toolChoice.asKnown().isPresent) 1 else 0) +
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
        @JsonDeserialize(using = MaxResponseOutputTokens.Deserializer::class)
        @JsonSerialize(using = MaxResponseOutputTokens.Serializer::class)
        class MaxResponseOutputTokens
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

            fun validate(): MaxResponseOutputTokens = apply {
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

                return other is MaxResponseOutputTokens &&
                    integer == other.integer &&
                    inf == other.inf
            }

            override fun hashCode(): Int = Objects.hash(integer, inf)

            override fun toString(): String =
                when {
                    integer != null -> "MaxResponseOutputTokens{integer=$integer}"
                    inf != null -> "MaxResponseOutputTokens{inf=$inf}"
                    _json != null -> "MaxResponseOutputTokens{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid MaxResponseOutputTokens")
                }

            companion object {

                @JvmStatic fun ofInteger(integer: Long) = MaxResponseOutputTokens(integer = integer)

                @JvmStatic fun ofInf() = MaxResponseOutputTokens(inf = JsonValue.from("inf"))
            }

            /**
             * An interface that defines how to map each variant of [MaxResponseOutputTokens] to a
             * value of type [T].
             */
            interface Visitor<out T> {

                fun visitInteger(integer: Long): T

                fun visitInf(inf: JsonValue): T

                /**
                 * Maps an unknown variant of [MaxResponseOutputTokens] to a value of type [T].
                 *
                 * An instance of [MaxResponseOutputTokens] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown MaxResponseOutputTokens: $json")
                }
            }

            internal class Deserializer :
                BaseDeserializer<MaxResponseOutputTokens>(MaxResponseOutputTokens::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): MaxResponseOutputTokens {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { MaxResponseOutputTokens(inf = it, _json = json) }
                                    ?.takeIf { it.isValid() },
                                tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                    MaxResponseOutputTokens(integer = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
                        0 -> MaxResponseOutputTokens(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer :
                BaseSerializer<MaxResponseOutputTokens>(MaxResponseOutputTokens::class) {

                override fun serialize(
                    value: MaxResponseOutputTokens,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.integer != null -> generator.writeObject(value.integer)
                        value.inf != null -> generator.writeObject(value.inf)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid MaxResponseOutputTokens")
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
                    putAlladditional_properties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                    putAlladditional_properties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                maxResponseOutputTokens == other.maxResponseOutputTokens &&
                metadata == other.metadata &&
                modalities == other.modalities &&
                outputAudioFormat == other.outputAudioFormat &&
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
                maxResponseOutputTokens,
                metadata,
                modalities,
                outputAudioFormat,
                temperature,
                toolChoice,
                tools,
                voice,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Response{conversation=$conversation, input=$input, instructions=$instructions, maxResponseOutputTokens=$maxResponseOutputTokens, metadata=$metadata, modalities=$modalities, outputAudioFormat=$outputAudioFormat, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, voice=$voice, additionalProperties=$additionalProperties}"
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
