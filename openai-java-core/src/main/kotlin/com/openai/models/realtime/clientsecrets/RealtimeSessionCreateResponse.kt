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
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A Realtime session configuration object. */
class RealtimeSessionCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val audio: JsonField<Audio>,
    private val expiresAt: JsonField<Long>,
    private val include: JsonField<List<Include>>,
    private val instructions: JsonField<String>,
    private val maxOutputTokens: JsonField<MaxOutputTokens>,
    private val model: JsonField<String>,
    private val object_: JsonField<String>,
    private val outputModalities: JsonField<List<OutputModality>>,
    private val toolChoice: JsonField<String>,
    private val tools: JsonField<List<Tool>>,
    private val tracing: JsonField<Tracing>,
    private val turnDetection: JsonField<TurnDetection>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("include")
        @ExcludeMissing
        include: JsonField<List<Include>> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_modalities")
        @ExcludeMissing
        outputModalities: JsonField<List<OutputModality>> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonProperty("tracing") @ExcludeMissing tracing: JsonField<Tracing> = JsonMissing.of(),
        @JsonProperty("turn_detection")
        @ExcludeMissing
        turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
    ) : this(
        id,
        audio,
        expiresAt,
        include,
        instructions,
        maxOutputTokens,
        model,
        object_,
        outputModalities,
        toolChoice,
        tools,
        tracing,
        turnDetection,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the session that looks like `sess_1234567890abcdef`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Configuration for input and output audio for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<Audio> = audio.getOptional("audio")

    /**
     * Expiration timestamp for the session, in seconds since epoch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresAt(): Optional<Long> = expiresAt.getOptional("expires_at")

    /**
     * Additional fields to include in server outputs.
     * - `item.input_audio_transcription.logprobs`: Include logprobs for input audio transcription.
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
    fun model(): Optional<String> = model.getOptional("model")

    /**
     * The object type. Always `realtime.session`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<String> = object_.getOptional("object")

    /**
     * The set of modalities the model can respond with. To disable audio, set this to ["text"].
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputModalities(): Optional<List<OutputModality>> =
        outputModalities.getOptional("output_modalities")

    /**
     * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a function.
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
     * Configuration options for tracing. Set to null to disable tracing. Once tracing is enabled
     * for a session, the configuration cannot be modified.
     *
     * `auto` will create a trace for the session with default values for the workflow name, group
     * id, and metadata.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tracing(): Optional<Tracing> = tracing.getOptional("tracing")

    /**
     * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that the
     * model will detect the start and end of speech based on audio volume and respond at the end of
     * user speech.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun turnDetection(): Optional<TurnDetection> = turnDetection.getOptional("turn_detection")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Audio> = audio

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

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
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_choice") @ExcludeMissing fun _toolChoice(): JsonField<String> = toolChoice

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
     * Returns the raw JSON value of [turnDetection].
     *
     * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected type.
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [RealtimeSessionCreateResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeSessionCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var audio: JsonField<Audio> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var include: JsonField<MutableList<Include>>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var outputModalities: JsonField<MutableList<OutputModality>>? = null
        private var toolChoice: JsonField<String> = JsonMissing.of()
        private var tools: JsonField<MutableList<Tool>>? = null
        private var tracing: JsonField<Tracing> = JsonMissing.of()
        private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeSessionCreateResponse: RealtimeSessionCreateResponse) = apply {
            id = realtimeSessionCreateResponse.id
            audio = realtimeSessionCreateResponse.audio
            expiresAt = realtimeSessionCreateResponse.expiresAt
            include = realtimeSessionCreateResponse.include.map { it.toMutableList() }
            instructions = realtimeSessionCreateResponse.instructions
            maxOutputTokens = realtimeSessionCreateResponse.maxOutputTokens
            model = realtimeSessionCreateResponse.model
            object_ = realtimeSessionCreateResponse.object_
            outputModalities =
                realtimeSessionCreateResponse.outputModalities.map { it.toMutableList() }
            toolChoice = realtimeSessionCreateResponse.toolChoice
            tools = realtimeSessionCreateResponse.tools.map { it.toMutableList() }
            tracing = realtimeSessionCreateResponse.tracing
            turnDetection = realtimeSessionCreateResponse.turnDetection
            additionalProperties = realtimeSessionCreateResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the session that looks like `sess_1234567890abcdef`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Configuration for input and output audio for the session. */
        fun audio(audio: Audio) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

        /** Expiration timestamp for the session, in seconds since epoch. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /**
         * Additional fields to include in server outputs.
         * - `item.input_audio_transcription.logprobs`: Include logprobs for input audio
         *   transcription.
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
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type. Always `realtime.session`. */
        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        /**
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
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
         * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a
         * function.
         */
        fun toolChoice(toolChoice: String) = toolChoice(JsonField.of(toolChoice))

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun toolChoice(toolChoice: JsonField<String>) = apply { this.toolChoice = toolChoice }

        /** Tools (functions) available to the model. */
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

        /**
         * Configuration options for tracing. Set to null to disable tracing. Once tracing is
         * enabled for a session, the configuration cannot be modified.
         *
         * `auto` will create a trace for the session with default values for the workflow name,
         * group id, and metadata.
         */
        fun tracing(tracing: Tracing) = tracing(JsonField.of(tracing))

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
         * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that
         * the model will detect the start and end of speech based on audio volume and respond at
         * the end of user speech.
         */
        fun turnDetection(turnDetection: TurnDetection) = turnDetection(JsonField.of(turnDetection))

        /**
         * Sets [Builder.turnDetection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnDetection] with a well-typed [TurnDetection] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun turnDetection(turnDetection: JsonField<TurnDetection>) = apply {
            this.turnDetection = turnDetection
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
         * Returns an immutable instance of [RealtimeSessionCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeSessionCreateResponse =
            RealtimeSessionCreateResponse(
                id,
                audio,
                expiresAt,
                (include ?: JsonMissing.of()).map { it.toImmutable() },
                instructions,
                maxOutputTokens,
                model,
                object_,
                (outputModalities ?: JsonMissing.of()).map { it.toImmutable() },
                toolChoice,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
                tracing,
                turnDetection,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeSessionCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        audio().ifPresent { it.validate() }
        expiresAt()
        include().ifPresent { it.forEach { it.validate() } }
        instructions()
        maxOutputTokens().ifPresent { it.validate() }
        model()
        object_()
        outputModalities().ifPresent { it.forEach { it.validate() } }
        toolChoice()
        tools().ifPresent { it.forEach { it.validate() } }
        tracing().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (maxOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0) +
            (outputModalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (toolChoice.asKnown().isPresent) 1 else 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (tracing.asKnown().getOrNull()?.validity() ?: 0) +
            (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

    /** Configuration for input and output audio for the session. */
    class Audio
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
        private constructor(
            private val format: JsonField<String>,
            private val noiseReduction: JsonField<NoiseReduction>,
            private val transcription: JsonField<Transcription>,
            private val turnDetection: JsonField<TurnDetection>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("format")
                @ExcludeMissing
                format: JsonField<String> = JsonMissing.of(),
                @JsonProperty("noise_reduction")
                @ExcludeMissing
                noiseReduction: JsonField<NoiseReduction> = JsonMissing.of(),
                @JsonProperty("transcription")
                @ExcludeMissing
                transcription: JsonField<Transcription> = JsonMissing.of(),
                @JsonProperty("turn_detection")
                @ExcludeMissing
                turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
            ) : this(format, noiseReduction, transcription, turnDetection, mutableMapOf())

            /**
             * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun format(): Optional<String> = format.getOptional("format")

            /**
             * Configuration for input audio noise reduction.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun noiseReduction(): Optional<NoiseReduction> =
                noiseReduction.getOptional("noise_reduction")

            /**
             * Configuration for input audio transcription.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun transcription(): Optional<Transcription> =
                transcription.getOptional("transcription")

            /**
             * Configuration for turn detection.
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
            @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<String> = format

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
            fun _transcription(): JsonField<Transcription> = transcription

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

                private var format: JsonField<String> = JsonMissing.of()
                private var noiseReduction: JsonField<NoiseReduction> = JsonMissing.of()
                private var transcription: JsonField<Transcription> = JsonMissing.of()
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

                /** The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
                fun format(format: String) = format(JsonField.of(format))

                /**
                 * Sets [Builder.format] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.format] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun format(format: JsonField<String>) = apply { this.format = format }

                /** Configuration for input audio noise reduction. */
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

                /** Configuration for input audio transcription. */
                fun transcription(transcription: Transcription) =
                    transcription(JsonField.of(transcription))

                /**
                 * Sets [Builder.transcription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transcription] with a well-typed [Transcription]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun transcription(transcription: JsonField<Transcription>) = apply {
                    this.transcription = transcription
                }

                /** Configuration for turn detection. */
                fun turnDetection(turnDetection: TurnDetection) =
                    turnDetection(JsonField.of(turnDetection))

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

                format()
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
                (if (format.asKnown().isPresent) 1 else 0) +
                    (noiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                    (transcription.asKnown().getOrNull()?.validity() ?: 0) +
                    (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

            /** Configuration for input audio noise reduction. */
            class NoiseReduction
            private constructor(
                private val type: JsonField<Type>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
                ) : this(type, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<Type> = type.getOptional("type")

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /**
                     * Returns a mutable builder for constructing an instance of [NoiseReduction].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [NoiseReduction]. */
                class Builder internal constructor() {

                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(noiseReduction: NoiseReduction) = apply {
                        type = noiseReduction.type
                        additionalProperties = noiseReduction.additionalProperties.toMutableMap()
                    }

                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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

                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
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

                        @JvmField val NEAR_FIELD = of("near_field")

                        @JvmField val FAR_FIELD = of("far_field")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        NEAR_FIELD,
                        FAR_FIELD,
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        NEAR_FIELD,
                        FAR_FIELD,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
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
                            NEAR_FIELD -> Value.NEAR_FIELD
                            FAR_FIELD -> Value.FAR_FIELD
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
                            NEAR_FIELD -> Known.NEAR_FIELD
                            FAR_FIELD -> Known.FAR_FIELD
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                    return other is NoiseReduction &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "NoiseReduction{type=$type, additionalProperties=$additionalProperties}"
            }

            /** Configuration for input audio transcription. */
            class Transcription
            private constructor(
                private val language: JsonField<String>,
                private val model: JsonField<String>,
                private val prompt: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("language")
                    @ExcludeMissing
                    language: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("prompt")
                    @ExcludeMissing
                    prompt: JsonField<String> = JsonMissing.of(),
                ) : this(language, model, prompt, mutableMapOf())

                /**
                 * The language of the input audio.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun language(): Optional<String> = language.getOptional("language")

                /**
                 * The model to use for transcription.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun model(): Optional<String> = model.getOptional("model")

                /**
                 * Optional text to guide the model's style or continue a previous audio segment.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun prompt(): Optional<String> = prompt.getOptional("prompt")

                /**
                 * Returns the raw JSON value of [language].
                 *
                 * Unlike [language], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("language")
                @ExcludeMissing
                fun _language(): JsonField<String> = language

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Returns the raw JSON value of [prompt].
                 *
                 * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<String> = prompt

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
                     * Returns a mutable builder for constructing an instance of [Transcription].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Transcription]. */
                class Builder internal constructor() {

                    private var language: JsonField<String> = JsonMissing.of()
                    private var model: JsonField<String> = JsonMissing.of()
                    private var prompt: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(transcription: Transcription) = apply {
                        language = transcription.language
                        model = transcription.model
                        prompt = transcription.prompt
                        additionalProperties = transcription.additionalProperties.toMutableMap()
                    }

                    /** The language of the input audio. */
                    fun language(language: String) = language(JsonField.of(language))

                    /**
                     * Sets [Builder.language] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.language] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun language(language: JsonField<String>) = apply { this.language = language }

                    /** The model to use for transcription. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /**
                     * Optional text to guide the model's style or continue a previous audio
                     * segment.
                     */
                    fun prompt(prompt: String) = prompt(JsonField.of(prompt))

                    /**
                     * Sets [Builder.prompt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.prompt] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

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
                     * Returns an immutable instance of [Transcription].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Transcription =
                        Transcription(language, model, prompt, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Transcription = apply {
                    if (validated) {
                        return@apply
                    }

                    language()
                    model()
                    prompt()
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
                    (if (language.asKnown().isPresent) 1 else 0) +
                        (if (model.asKnown().isPresent) 1 else 0) +
                        (if (prompt.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Transcription &&
                        language == other.language &&
                        model == other.model &&
                        prompt == other.prompt &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(language, model, prompt, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Transcription{language=$language, model=$model, prompt=$prompt, additionalProperties=$additionalProperties}"
            }

            /** Configuration for turn detection. */
            class TurnDetection
            private constructor(
                private val prefixPaddingMs: JsonField<Long>,
                private val silenceDurationMs: JsonField<Long>,
                private val threshold: JsonField<Double>,
                private val type: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("prefix_padding_ms")
                    @ExcludeMissing
                    prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("silence_duration_ms")
                    @ExcludeMissing
                    silenceDurationMs: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("threshold")
                    @ExcludeMissing
                    threshold: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                ) : this(prefixPaddingMs, silenceDurationMs, threshold, type, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun prefixPaddingMs(): Optional<Long> =
                    prefixPaddingMs.getOptional("prefix_padding_ms")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun silenceDurationMs(): Optional<Long> =
                    silenceDurationMs.getOptional("silence_duration_ms")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun threshold(): Optional<Double> = threshold.getOptional("threshold")

                /**
                 * Type of turn detection, only `server_vad` is currently supported.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

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
                 * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("silence_duration_ms")
                @ExcludeMissing
                fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

                /**
                 * Returns the raw JSON value of [threshold].
                 *
                 * Unlike [threshold], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("threshold")
                @ExcludeMissing
                fun _threshold(): JsonField<Double> = threshold

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                     * Returns a mutable builder for constructing an instance of [TurnDetection].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [TurnDetection]. */
                class Builder internal constructor() {

                    private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
                    private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
                    private var threshold: JsonField<Double> = JsonMissing.of()
                    private var type: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(turnDetection: TurnDetection) = apply {
                        prefixPaddingMs = turnDetection.prefixPaddingMs
                        silenceDurationMs = turnDetection.silenceDurationMs
                        threshold = turnDetection.threshold
                        type = turnDetection.type
                        additionalProperties = turnDetection.additionalProperties.toMutableMap()
                    }

                    fun prefixPaddingMs(prefixPaddingMs: Long) =
                        prefixPaddingMs(JsonField.of(prefixPaddingMs))

                    /**
                     * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                        this.prefixPaddingMs = prefixPaddingMs
                    }

                    fun silenceDurationMs(silenceDurationMs: Long) =
                        silenceDurationMs(JsonField.of(silenceDurationMs))

                    /**
                     * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.silenceDurationMs] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                        this.silenceDurationMs = silenceDurationMs
                    }

                    fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

                    /**
                     * Sets [Builder.threshold] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.threshold] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun threshold(threshold: JsonField<Double>) = apply {
                        this.threshold = threshold
                    }

                    /** Type of turn detection, only `server_vad` is currently supported. */
                    fun type(type: String) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

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
                     * Returns an immutable instance of [TurnDetection].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): TurnDetection =
                        TurnDetection(
                            prefixPaddingMs,
                            silenceDurationMs,
                            threshold,
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): TurnDetection = apply {
                    if (validated) {
                        return@apply
                    }

                    prefixPaddingMs()
                    silenceDurationMs()
                    threshold()
                    type()
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
                    (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                        (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                        (if (threshold.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is TurnDetection &&
                        prefixPaddingMs == other.prefixPaddingMs &&
                        silenceDurationMs == other.silenceDurationMs &&
                        threshold == other.threshold &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        prefixPaddingMs,
                        silenceDurationMs,
                        threshold,
                        type,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "TurnDetection{prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
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
        private constructor(
            private val format: JsonField<String>,
            private val speed: JsonField<Double>,
            private val voice: JsonField<Voice>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("format")
                @ExcludeMissing
                format: JsonField<String> = JsonMissing.of(),
                @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
            ) : this(format, speed, voice, mutableMapOf())

            /**
             * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun format(): Optional<String> = format.getOptional("format")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun speed(): Optional<Double> = speed.getOptional("speed")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun voice(): Optional<Voice> = voice.getOptional("voice")

            /**
             * Returns the raw JSON value of [format].
             *
             * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<String> = format

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

                private var format: JsonField<String> = JsonMissing.of()
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

                /** The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
                fun format(format: String) = format(JsonField.of(format))

                /**
                 * Sets [Builder.format] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.format] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun format(format: JsonField<String>) = apply { this.format = format }

                fun speed(speed: Double) = speed(JsonField.of(speed))

                /**
                 * Sets [Builder.speed] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.speed] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

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

                format()
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
                (if (format.asKnown().isPresent) 1 else 0) +
                    (if (speed.asKnown().isPresent) 1 else 0) +
                    (if (voice.asKnown().isPresent) 1 else 0)

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
            @JsonProperty("parameters") @ExcludeMissing parameters: JsonValue = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(description, name, parameters, type, mutableMapOf())

        /**
         * The description of the function, including guidance on when and how to call it, and
         * guidance about what to tell the user when calling (if anything).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * The name of the function.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /** Parameters of the function in JSON Schema. */
        @JsonProperty("parameters") @ExcludeMissing fun _parameters(): JsonValue = parameters

        /**
         * The type of the tool, i.e. `function`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
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
             * The description of the function, including guidance on when and how to call it, and
             * guidance about what to tell the user when calling (if anything).
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

            /** The name of the function. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Parameters of the function in JSON Schema. */
            fun parameters(parameters: JsonValue) = apply { this.parameters = parameters }

            /** The type of the tool, i.e. `function`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FUNCTION,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    FUNCTION -> Value.FUNCTION
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
                    FUNCTION -> Known.FUNCTION
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
     * Configuration options for tracing. Set to null to disable tracing. Once tracing is enabled
     * for a session, the configuration cannot be modified.
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

        /** Default tracing mode for the session. */
        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        /** Granular configuration for tracing. */
        fun configuration(): Optional<TracingConfiguration> = Optional.ofNullable(configuration)

        fun isAuto(): Boolean = auto != null

        fun isConfiguration(): Boolean = configuration != null

        /** Default tracing mode for the session. */
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

            /** Default tracing mode for the session. */
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

            /** Default tracing mode for the session. */
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
             * The group id to attach to this trace to enable filtering and grouping in the traces
             * dashboard.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun groupId(): Optional<String> = groupId.getOptional("group_id")

            /**
             * The arbitrary metadata to attach to this trace to enable filtering in the traces
             * dashboard.
             */
            @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

            /**
             * The name of the workflow to attach to this trace. This is used to name the trace in
             * the traces dashboard.
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
                 * traces dashboard.
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
                 * The arbitrary metadata to attach to this trace to enable filtering in the traces
                 * dashboard.
                 */
                fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

                /**
                 * The name of the workflow to attach to this trace. This is used to name the trace
                 * in the traces dashboard.
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

    /**
     * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that the
     * model will detect the start and end of speech based on audio volume and respond at the end of
     * user speech.
     */
    class TurnDetection
    private constructor(
        private val prefixPaddingMs: JsonField<Long>,
        private val silenceDurationMs: JsonField<Long>,
        private val threshold: JsonField<Double>,
        private val type: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("prefix_padding_ms")
            @ExcludeMissing
            prefixPaddingMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("silence_duration_ms")
            @ExcludeMissing
            silenceDurationMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("threshold")
            @ExcludeMissing
            threshold: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        ) : this(prefixPaddingMs, silenceDurationMs, threshold, type, mutableMapOf())

        /**
         * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults to
         * 300ms.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

        /**
         * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With
         * shorter values the model will respond more quickly, but may jump in on short pauses from
         * the user.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun silenceDurationMs(): Optional<Long> =
            silenceDurationMs.getOptional("silence_duration_ms")

        /**
         * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold will
         * require louder audio to activate the model, and thus might perform better in noisy
         * environments.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun threshold(): Optional<Double> = threshold.getOptional("threshold")

        /**
         * Type of turn detection, only `server_vad` is currently supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [prefixPaddingMs].
         *
         * Unlike [prefixPaddingMs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("prefix_padding_ms")
        @ExcludeMissing
        fun _prefixPaddingMs(): JsonField<Long> = prefixPaddingMs

        /**
         * Returns the raw JSON value of [silenceDurationMs].
         *
         * Unlike [silenceDurationMs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("silence_duration_ms")
        @ExcludeMissing
        fun _silenceDurationMs(): JsonField<Long> = silenceDurationMs

        /**
         * Returns the raw JSON value of [threshold].
         *
         * Unlike [threshold], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("threshold") @ExcludeMissing fun _threshold(): JsonField<Double> = threshold

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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

            /** Returns a mutable builder for constructing an instance of [TurnDetection]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TurnDetection]. */
        class Builder internal constructor() {

            private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
            private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
            private var threshold: JsonField<Double> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(turnDetection: TurnDetection) = apply {
                prefixPaddingMs = turnDetection.prefixPaddingMs
                silenceDurationMs = turnDetection.silenceDurationMs
                threshold = turnDetection.threshold
                type = turnDetection.type
                additionalProperties = turnDetection.additionalProperties.toMutableMap()
            }

            /**
             * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults
             * to 300ms.
             */
            fun prefixPaddingMs(prefixPaddingMs: Long) =
                prefixPaddingMs(JsonField.of(prefixPaddingMs))

            /**
             * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                this.prefixPaddingMs = prefixPaddingMs
            }

            /**
             * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With
             * shorter values the model will respond more quickly, but may jump in on short pauses
             * from the user.
             */
            fun silenceDurationMs(silenceDurationMs: Long) =
                silenceDurationMs(JsonField.of(silenceDurationMs))

            /**
             * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.silenceDurationMs] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                this.silenceDurationMs = silenceDurationMs
            }

            /**
             * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold
             * will require louder audio to activate the model, and thus might perform better in
             * noisy environments.
             */
            fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

            /**
             * Sets [Builder.threshold] to an arbitrary JSON value.
             *
             * You should usually call [Builder.threshold] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun threshold(threshold: JsonField<Double>) = apply { this.threshold = threshold }

            /** Type of turn detection, only `server_vad` is currently supported. */
            fun type(type: String) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

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
             * Returns an immutable instance of [TurnDetection].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): TurnDetection =
                TurnDetection(
                    prefixPaddingMs,
                    silenceDurationMs,
                    threshold,
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TurnDetection = apply {
            if (validated) {
                return@apply
            }

            prefixPaddingMs()
            silenceDurationMs()
            threshold()
            type()
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
            (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                (if (threshold.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TurnDetection &&
                prefixPaddingMs == other.prefixPaddingMs &&
                silenceDurationMs == other.silenceDurationMs &&
                threshold == other.threshold &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(prefixPaddingMs, silenceDurationMs, threshold, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TurnDetection{prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeSessionCreateResponse &&
            id == other.id &&
            audio == other.audio &&
            expiresAt == other.expiresAt &&
            include == other.include &&
            instructions == other.instructions &&
            maxOutputTokens == other.maxOutputTokens &&
            model == other.model &&
            object_ == other.object_ &&
            outputModalities == other.outputModalities &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            tracing == other.tracing &&
            turnDetection == other.turnDetection &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            audio,
            expiresAt,
            include,
            instructions,
            maxOutputTokens,
            model,
            object_,
            outputModalities,
            toolChoice,
            tools,
            tracing,
            turnDetection,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeSessionCreateResponse{id=$id, audio=$audio, expiresAt=$expiresAt, include=$include, instructions=$instructions, maxOutputTokens=$maxOutputTokens, model=$model, object_=$object_, outputModalities=$outputModalities, toolChoice=$toolChoice, tools=$tools, tracing=$tracing, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
}
