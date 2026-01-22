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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Realtime session object for the beta interface. */
class RealtimeSession
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val expiresAt: JsonField<Long>,
    private val include: JsonField<List<Include>>,
    private val inputAudioFormat: JsonField<InputAudioFormat>,
    private val inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>,
    private val inputAudioTranscription: JsonField<AudioTranscription>,
    private val instructions: JsonField<String>,
    private val maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>,
    private val modalities: JsonField<List<Modality>>,
    private val model: JsonField<Model>,
    private val object_: JsonField<Object>,
    private val outputAudioFormat: JsonField<OutputAudioFormat>,
    private val prompt: JsonField<ResponsePrompt>,
    private val speed: JsonField<Double>,
    private val temperature: JsonField<Double>,
    private val toolChoice: JsonField<String>,
    private val tools: JsonField<List<RealtimeFunctionTool>>,
    private val tracing: JsonField<Tracing>,
    private val turnDetection: JsonField<TurnDetection>,
    private val voice: JsonField<Voice>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("include")
        @ExcludeMissing
        include: JsonField<List<Include>> = JsonMissing.of(),
        @JsonProperty("input_audio_format")
        @ExcludeMissing
        inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of(),
        @JsonProperty("input_audio_noise_reduction")
        @ExcludeMissing
        inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> = JsonMissing.of(),
        @JsonProperty("input_audio_transcription")
        @ExcludeMissing
        inputAudioTranscription: JsonField<AudioTranscription> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_response_output_tokens")
        @ExcludeMissing
        maxResponseOutputTokens: JsonField<MaxResponseOutputTokens> = JsonMissing.of(),
        @JsonProperty("modalities")
        @ExcludeMissing
        modalities: JsonField<List<Modality>> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("output_audio_format")
        @ExcludeMissing
        outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of(),
        @JsonProperty("prompt")
        @ExcludeMissing
        prompt: JsonField<ResponsePrompt> = JsonMissing.of(),
        @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        tools: JsonField<List<RealtimeFunctionTool>> = JsonMissing.of(),
        @JsonProperty("tracing") @ExcludeMissing tracing: JsonField<Tracing> = JsonMissing.of(),
        @JsonProperty("turn_detection")
        @ExcludeMissing
        turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
        @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
    ) : this(
        id,
        expiresAt,
        include,
        inputAudioFormat,
        inputAudioNoiseReduction,
        inputAudioTranscription,
        instructions,
        maxResponseOutputTokens,
        modalities,
        model,
        object_,
        outputAudioFormat,
        prompt,
        speed,
        temperature,
        toolChoice,
        tools,
        tracing,
        turnDetection,
        voice,
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
     * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
     * little-endian byte order.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioFormat(): Optional<InputAudioFormat> =
        inputAudioFormat.getOptional("input_audio_format")

    /**
     * Configuration for input audio noise reduction. This can be set to `null` to turn off. Noise
     * reduction filters audio added to the input audio buffer before it is sent to VAD and the
     * model. Filtering the audio can improve VAD and turn detection accuracy (reducing false
     * positives) and model performance by improving perception of the input audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioNoiseReduction(): Optional<InputAudioNoiseReduction> =
        inputAudioNoiseReduction.getOptional("input_audio_noise_reduction")

    /**
     * Configuration for input audio transcription, defaults to off and can be set to `null` to turn
     * off once on. Input audio transcription is not native to the model, since the model consumes
     * audio directly. Transcription runs asynchronously through
     * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
     * and should be treated as guidance of input audio content rather than precisely what the model
     * heard. The client can optionally set the language and prompt for transcription, these offer
     * additional guidance to the transcription service.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioTranscription(): Optional<AudioTranscription> =
        inputAudioTranscription.getOptional("input_audio_transcription")

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
    fun maxResponseOutputTokens(): Optional<MaxResponseOutputTokens> =
        maxResponseOutputTokens.getOptional("max_response_output_tokens")

    /**
     * The set of modalities the model can respond with. To disable audio, set this to ["text"].
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modalities(): Optional<List<Modality>> = modalities.getOptional("modalities")

    /**
     * The Realtime model used for this session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = model.getOptional("model")

    /**
     * The object type. Always `realtime.session`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * output audio is sampled at a rate of 24kHz.
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
     * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the minimum
     * speed. 1.5 is the maximum speed. This value can only be changed in between model turns, not
     * while a response is in progress.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun speed(): Optional<Double> = speed.getOptional("speed")

    /**
     * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a temperature of
     * 0.8 is highly recommended for best performance.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = temperature.getOptional("temperature")

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
    fun tools(): Optional<List<RealtimeFunctionTool>> = tools.getOptional("tools")

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
     * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to `null`
     * to turn off, in which case the client must manually trigger model response.
     *
     * Server VAD means that the model will detect the start and end of speech based on audio volume
     * and respond at the end of user speech.
     *
     * Semantic VAD is more advanced and uses a turn detection model (in conjunction with VAD) to
     * semantically estimate whether the user has finished speaking, then dynamically sets a timeout
     * based on this probability. For example, if user audio trails off with "uhhm", the model will
     * score a low probability of turn end and wait longer for the user to continue speaking. This
     * can be useful for more natural conversations, but may have a higher latency.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun turnDetection(): Optional<TurnDetection> = turnDetection.getOptional("turn_detection")

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
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [inputAudioFormat].
     *
     * Unlike [inputAudioFormat], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("input_audio_format")
    @ExcludeMissing
    fun _inputAudioFormat(): JsonField<InputAudioFormat> = inputAudioFormat

    /**
     * Returns the raw JSON value of [inputAudioNoiseReduction].
     *
     * Unlike [inputAudioNoiseReduction], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("input_audio_noise_reduction")
    @ExcludeMissing
    fun _inputAudioNoiseReduction(): JsonField<InputAudioNoiseReduction> = inputAudioNoiseReduction

    /**
     * Returns the raw JSON value of [inputAudioTranscription].
     *
     * Unlike [inputAudioTranscription], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("input_audio_transcription")
    @ExcludeMissing
    fun _inputAudioTranscription(): JsonField<AudioTranscription> = inputAudioTranscription

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
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
     * Returns the raw JSON value of [modalities].
     *
     * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("modalities")
    @ExcludeMissing
    fun _modalities(): JsonField<List<Modality>> = modalities

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

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
     * Returns the raw JSON value of [speed].
     *
     * Unlike [speed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("speed") @ExcludeMissing fun _speed(): JsonField<Double> = speed

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

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
    @JsonProperty("tools")
    @ExcludeMissing
    fun _tools(): JsonField<List<RealtimeFunctionTool>> = tools

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

        /** Returns a mutable builder for constructing an instance of [RealtimeSession]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeSession]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var include: JsonField<MutableList<Include>>? = null
        private var inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of()
        private var inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> = JsonMissing.of()
        private var inputAudioTranscription: JsonField<AudioTranscription> = JsonMissing.of()
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxResponseOutputTokens: JsonField<MaxResponseOutputTokens> = JsonMissing.of()
        private var modalities: JsonField<MutableList<Modality>>? = null
        private var model: JsonField<Model> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of()
        private var prompt: JsonField<ResponsePrompt> = JsonMissing.of()
        private var speed: JsonField<Double> = JsonMissing.of()
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var toolChoice: JsonField<String> = JsonMissing.of()
        private var tools: JsonField<MutableList<RealtimeFunctionTool>>? = null
        private var tracing: JsonField<Tracing> = JsonMissing.of()
        private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
        private var voice: JsonField<Voice> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeSession: RealtimeSession) = apply {
            id = realtimeSession.id
            expiresAt = realtimeSession.expiresAt
            include = realtimeSession.include.map { it.toMutableList() }
            inputAudioFormat = realtimeSession.inputAudioFormat
            inputAudioNoiseReduction = realtimeSession.inputAudioNoiseReduction
            inputAudioTranscription = realtimeSession.inputAudioTranscription
            instructions = realtimeSession.instructions
            maxResponseOutputTokens = realtimeSession.maxResponseOutputTokens
            modalities = realtimeSession.modalities.map { it.toMutableList() }
            model = realtimeSession.model
            object_ = realtimeSession.object_
            outputAudioFormat = realtimeSession.outputAudioFormat
            prompt = realtimeSession.prompt
            speed = realtimeSession.speed
            temperature = realtimeSession.temperature
            toolChoice = realtimeSession.toolChoice
            tools = realtimeSession.tools.map { it.toMutableList() }
            tracing = realtimeSession.tracing
            turnDetection = realtimeSession.turnDetection
            voice = realtimeSession.voice
            additionalProperties = realtimeSession.additionalProperties.toMutableMap()
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
        fun include(include: List<Include>?) = include(JsonField.ofNullable(include))

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<Include>>) = include(include.getOrNull())

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
         * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
         * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
         * little-endian byte order.
         */
        fun inputAudioFormat(inputAudioFormat: InputAudioFormat) =
            inputAudioFormat(JsonField.of(inputAudioFormat))

        /**
         * Sets [Builder.inputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioFormat] with a well-typed [InputAudioFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun inputAudioFormat(inputAudioFormat: JsonField<InputAudioFormat>) = apply {
            this.inputAudioFormat = inputAudioFormat
        }

        /**
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         */
        fun inputAudioNoiseReduction(inputAudioNoiseReduction: InputAudioNoiseReduction) =
            inputAudioNoiseReduction(JsonField.of(inputAudioNoiseReduction))

        /**
         * Sets [Builder.inputAudioNoiseReduction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioNoiseReduction] with a well-typed
         * [InputAudioNoiseReduction] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun inputAudioNoiseReduction(
            inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>
        ) = apply { this.inputAudioNoiseReduction = inputAudioNoiseReduction }

        /**
         * Configuration for input audio transcription, defaults to off and can be set to `null` to
         * turn off once on. Input audio transcription is not native to the model, since the model
         * consumes audio directly. Transcription runs asynchronously through
         * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
         * and should be treated as guidance of input audio content rather than precisely what the
         * model heard. The client can optionally set the language and prompt for transcription,
         * these offer additional guidance to the transcription service.
         */
        fun inputAudioTranscription(inputAudioTranscription: AudioTranscription?) =
            inputAudioTranscription(JsonField.ofNullable(inputAudioTranscription))

        /**
         * Alias for calling [Builder.inputAudioTranscription] with
         * `inputAudioTranscription.orElse(null)`.
         */
        fun inputAudioTranscription(inputAudioTranscription: Optional<AudioTranscription>) =
            inputAudioTranscription(inputAudioTranscription.getOrNull())

        /**
         * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioTranscription] with a well-typed
         * [AudioTranscription] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun inputAudioTranscription(inputAudioTranscription: JsonField<AudioTranscription>) =
            apply {
                this.inputAudioTranscription = inputAudioTranscription
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
        fun maxResponseOutputTokens(maxResponseOutputTokens: MaxResponseOutputTokens) =
            maxResponseOutputTokens(JsonField.of(maxResponseOutputTokens))

        /**
         * Sets [Builder.maxResponseOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxResponseOutputTokens] with a well-typed
         * [MaxResponseOutputTokens] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun maxResponseOutputTokens(maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>) =
            apply {
                this.maxResponseOutputTokens = maxResponseOutputTokens
            }

        /**
         * Alias for calling [maxResponseOutputTokens] with
         * `MaxResponseOutputTokens.ofInteger(integer)`.
         */
        fun maxResponseOutputTokens(integer: Long) =
            maxResponseOutputTokens(MaxResponseOutputTokens.ofInteger(integer))

        /** Alias for calling [maxResponseOutputTokens] with `MaxResponseOutputTokens.ofInf()`. */
        fun maxResponseOutputTokensInf() = maxResponseOutputTokens(MaxResponseOutputTokens.ofInf())

        /**
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
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

        /** The object type. Always `realtime.session`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
         * `pcm16`, output audio is sampled at a rate of 24kHz.
         */
        fun outputAudioFormat(outputAudioFormat: OutputAudioFormat) =
            outputAudioFormat(JsonField.of(outputAudioFormat))

        /**
         * Sets [Builder.outputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputAudioFormat] with a well-typed [OutputAudioFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
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

        /**
         * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the minimum
         * speed. 1.5 is the maximum speed. This value can only be changed in between model turns,
         * not while a response is in progress.
         */
        fun speed(speed: Double) = speed(JsonField.of(speed))

        /**
         * Sets [Builder.speed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speed] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

        /**
         * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a temperature
         * of 0.8 is highly recommended for best performance.
         */
        fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

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
        fun tools(tools: List<RealtimeFunctionTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<RealtimeFunctionTool>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun tools(tools: JsonField<List<RealtimeFunctionTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [RealtimeFunctionTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: RealtimeFunctionTool) = apply {
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
         * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to
         * `null` to turn off, in which case the client must manually trigger model response.
         *
         * Server VAD means that the model will detect the start and end of speech based on audio
         * volume and respond at the end of user speech.
         *
         * Semantic VAD is more advanced and uses a turn detection model (in conjunction with VAD)
         * to semantically estimate whether the user has finished speaking, then dynamically sets a
         * timeout based on this probability. For example, if user audio trails off with "uhhm", the
         * model will score a low probability of turn end and wait longer for the user to continue
         * speaking. This can be useful for more natural conversations, but may have a higher
         * latency.
         */
        fun turnDetection(turnDetection: TurnDetection?) =
            turnDetection(JsonField.ofNullable(turnDetection))

        /** Alias for calling [Builder.turnDetection] with `turnDetection.orElse(null)`. */
        fun turnDetection(turnDetection: Optional<TurnDetection>) =
            turnDetection(turnDetection.getOrNull())

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

        /** Alias for calling [turnDetection] with `TurnDetection.ofServerVad(serverVad)`. */
        fun turnDetection(serverVad: TurnDetection.ServerVad) =
            turnDetection(TurnDetection.ofServerVad(serverVad))

        /** Alias for calling [turnDetection] with `TurnDetection.ofSemanticVad(semanticVad)`. */
        fun turnDetection(semanticVad: TurnDetection.SemanticVad) =
            turnDetection(TurnDetection.ofSemanticVad(semanticVad))

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, and `verse`.
         */
        fun voice(voice: Voice) = voice(JsonField.of(voice))

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

        /**
         * Sets [voice] to an arbitrary [String].
         *
         * You should usually call [voice] with a well-typed [Voice] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [RealtimeSession].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeSession =
            RealtimeSession(
                id,
                expiresAt,
                (include ?: JsonMissing.of()).map { it.toImmutable() },
                inputAudioFormat,
                inputAudioNoiseReduction,
                inputAudioTranscription,
                instructions,
                maxResponseOutputTokens,
                (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                model,
                object_,
                outputAudioFormat,
                prompt,
                speed,
                temperature,
                toolChoice,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
                tracing,
                turnDetection,
                voice,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeSession = apply {
        if (validated) {
            return@apply
        }

        id()
        expiresAt()
        include().ifPresent { it.forEach { it.validate() } }
        inputAudioFormat().ifPresent { it.validate() }
        inputAudioNoiseReduction().ifPresent { it.validate() }
        inputAudioTranscription().ifPresent { it.validate() }
        instructions()
        maxResponseOutputTokens().ifPresent { it.validate() }
        modalities().ifPresent { it.forEach { it.validate() } }
        model()
        object_().ifPresent { it.validate() }
        outputAudioFormat().ifPresent { it.validate() }
        prompt().ifPresent { it.validate() }
        speed()
        temperature()
        toolChoice()
        tools().ifPresent { it.forEach { it.validate() } }
        tracing().ifPresent { it.validate() }
        turnDetection().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (inputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
            (inputAudioNoiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
            (inputAudioTranscription.asKnown().getOrNull()?.validity() ?: 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (maxResponseOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
            (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (outputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
            (prompt.asKnown().getOrNull()?.validity() ?: 0) +
            (if (speed.asKnown().isPresent) 1 else 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (if (toolChoice.asKnown().isPresent) 1 else 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (tracing.asKnown().getOrNull()?.validity() ?: 0) +
            (turnDetection.asKnown().getOrNull()?.validity() ?: 0) +
            (if (voice.asKnown().isPresent) 1 else 0)

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
     * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
     * little-endian byte order.
     */
    class InputAudioFormat @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val PCM16 = of("pcm16")

            @JvmField val G711_ULAW = of("g711_ulaw")

            @JvmField val G711_ALAW = of("g711_alaw")

            @JvmStatic fun of(value: String) = InputAudioFormat(JsonField.of(value))
        }

        /** An enum containing [InputAudioFormat]'s known values. */
        enum class Known {
            PCM16,
            G711_ULAW,
            G711_ALAW,
        }

        /**
         * An enum containing [InputAudioFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [InputAudioFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PCM16,
            G711_ULAW,
            G711_ALAW,
            /**
             * An enum member indicating that [InputAudioFormat] was instantiated with an unknown
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
                PCM16 -> Value.PCM16
                G711_ULAW -> Value.G711_ULAW
                G711_ALAW -> Value.G711_ALAW
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
                PCM16 -> Known.PCM16
                G711_ULAW -> Known.G711_ULAW
                G711_ALAW -> Known.G711_ALAW
                else -> throw OpenAIInvalidDataException("Unknown InputAudioFormat: $value")
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

        fun validate(): InputAudioFormat = apply {
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

            return other is InputAudioFormat && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Configuration for input audio noise reduction. This can be set to `null` to turn off. Noise
     * reduction filters audio added to the input audio buffer before it is sent to VAD and the
     * model. Filtering the audio can improve VAD and turn detection accuracy (reducing false
     * positives) and model performance by improving perception of the input audio.
     */
    class InputAudioNoiseReduction
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
         * headphones, `far_field` is for far-field microphones such as laptop or conference room
         * microphones.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<NoiseReductionType> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<NoiseReductionType> = type

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
             * Returns a mutable builder for constructing an instance of [InputAudioNoiseReduction].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputAudioNoiseReduction]. */
        class Builder internal constructor() {

            private var type: JsonField<NoiseReductionType> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputAudioNoiseReduction: InputAudioNoiseReduction) = apply {
                type = inputAudioNoiseReduction.type
                additionalProperties = inputAudioNoiseReduction.additionalProperties.toMutableMap()
            }

            /**
             * Type of noise reduction. `near_field` is for close-talking microphones such as
             * headphones, `far_field` is for far-field microphones such as laptop or conference
             * room microphones.
             */
            fun type(type: NoiseReductionType) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [NoiseReductionType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonField<NoiseReductionType>) = apply { this.type = type }

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
             * Returns an immutable instance of [InputAudioNoiseReduction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InputAudioNoiseReduction =
                InputAudioNoiseReduction(type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): InputAudioNoiseReduction = apply {
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
        @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputAudioNoiseReduction &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputAudioNoiseReduction{type=$type, additionalProperties=$additionalProperties}"
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

            return other is MaxResponseOutputTokens && integer == other.integer && inf == other.inf
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
         * An interface that defines how to map each variant of [MaxResponseOutputTokens] to a value
         * of type [T].
         */
        interface Visitor<out T> {

            fun visitInteger(integer: Long): T

            fun visitInf(inf: JsonValue): T

            /**
             * Maps an unknown variant of [MaxResponseOutputTokens] to a value of type [T].
             *
             * An instance of [MaxResponseOutputTokens] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> MaxResponseOutputTokens(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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

            @JvmField val GPT_REALTIME_MINI_2025_12_15 = of("gpt-realtime-mini-2025-12-15")

            @JvmField val GPT_AUDIO_MINI = of("gpt-audio-mini")

            @JvmField val GPT_AUDIO_MINI_2025_10_06 = of("gpt-audio-mini-2025-10-06")

            @JvmField val GPT_AUDIO_MINI_2025_12_15 = of("gpt-audio-mini-2025-12-15")

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
            GPT_REALTIME_MINI_2025_12_15,
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

    /** The object type. Always `realtime.session`. */
    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val REALTIME_SESSION = of("realtime.session")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            REALTIME_SESSION
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            REALTIME_SESSION,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                REALTIME_SESSION -> Value.REALTIME_SESSION
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
                REALTIME_SESSION -> Known.REALTIME_SESSION
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
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

        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * output audio is sampled at a rate of 24kHz.
     */
    class OutputAudioFormat @JsonCreator private constructor(private val value: JsonField<String>) :
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
         * An enum containing [OutputAudioFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputAudioFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PCM16,
            G711_ULAW,
            G711_ALAW,
            /**
             * An enum member indicating that [OutputAudioFormat] was instantiated with an unknown
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
                PCM16 -> Value.PCM16
                G711_ULAW -> Value.G711_ULAW
                G711_ALAW -> Value.G711_ALAW
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
                PCM16 -> Known.PCM16
                G711_ULAW -> Known.G711_ULAW
                G711_ALAW -> Known.G711_ALAW
                else -> throw OpenAIInvalidDataException("Unknown OutputAudioFormat: $value")
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
                    // all the possible variants (e.g. deserializing from boolean).
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
             *
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = tracingConfiguration.metadata().convert(MyClass.class);
             * ```
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
     * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to `null`
     * to turn off, in which case the client must manually trigger model response.
     *
     * Server VAD means that the model will detect the start and end of speech based on audio volume
     * and respond at the end of user speech.
     *
     * Semantic VAD is more advanced and uses a turn detection model (in conjunction with VAD) to
     * semantically estimate whether the user has finished speaking, then dynamically sets a timeout
     * based on this probability. For example, if user audio trails off with "uhhm", the model will
     * score a low probability of turn end and wait longer for the user to continue speaking. This
     * can be useful for more natural conversations, but may have a higher latency.
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
         * Server-side voice activity detection (VAD) which flips on when user speech is detected
         * and off after a period of silence.
         */
        fun serverVad(): Optional<ServerVad> = Optional.ofNullable(serverVad)

        /**
         * Server-side semantic turn detection which uses a model to determine when the user has
         * finished speaking.
         */
        fun semanticVad(): Optional<SemanticVad> = Optional.ofNullable(semanticVad)

        fun isServerVad(): Boolean = serverVad != null

        fun isSemanticVad(): Boolean = semanticVad != null

        /**
         * Server-side voice activity detection (VAD) which flips on when user speech is detected
         * and off after a period of silence.
         */
        fun asServerVad(): ServerVad = serverVad.getOrThrow("serverVad")

        /**
         * Server-side semantic turn detection which uses a model to determine when the user has
         * finished speaking.
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

                    override fun visitSemanticVad(semanticVad: SemanticVad) = semanticVad.validity()

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
            @JvmStatic fun ofServerVad(serverVad: ServerVad) = TurnDetection(serverVad = serverVad)

            /**
             * Server-side semantic turn detection which uses a model to determine when the user has
             * finished speaking.
             */
            @JvmStatic
            fun ofSemanticVad(semanticVad: SemanticVad) = TurnDetection(semanticVad = semanticVad)
        }

        /**
         * An interface that defines how to map each variant of [TurnDetection] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /**
             * Server-side voice activity detection (VAD) which flips on when user speech is
             * detected and off after a period of silence.
             */
            fun visitServerVad(serverVad: ServerVad): T

            /**
             * Server-side semantic turn detection which uses a model to determine when the user has
             * finished speaking.
             */
            fun visitSemanticVad(semanticVad: SemanticVad): T

            /**
             * Maps an unknown variant of [TurnDetection] to a value of type [T].
             *
             * An instance of [TurnDetection] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown TurnDetection: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<TurnDetection>(TurnDetection::class) {

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
         * Server-side voice activity detection (VAD) which flips on when user speech is detected
         * and off after a period of silence.
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
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Whether or not to automatically generate a response when a VAD stop event occurs. If
             * `interrupt_response` is set to `false` this may fail to create a response if the
             * model is already responding.
             *
             * If both `create_response` and `interrupt_response` are set to `false`, the model will
             * never respond automatically but VAD events will still be emitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

            /**
             * Optional timeout after which a model response will be triggered automatically. This
             * is useful for situations in which a long pause from the user is unexpected, such as a
             * phone call. The model will effectively prompt the user to continue the conversation
             * based on the current context.
             *
             * The timeout value will be applied after the last model response's audio has finished
             * playing, i.e. it's set to the `response.done` time plus audio playback duration.
             *
             * An `input_audio_buffer.timeout_triggered` event (plus events associated with the
             * Response) will be emitted when the timeout is reached. Idle timeout is currently only
             * supported for `server_vad` mode.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun idleTimeoutMs(): Optional<Long> = idleTimeoutMs.getOptional("idle_timeout_ms")

            /**
             * Whether or not to automatically interrupt (cancel) any ongoing response with output
             * to the default conversation (i.e. `conversation` of `auto`) when a VAD start event
             * occurs. If `true` then the response will be cancelled, otherwise it will continue
             * until complete.
             *
             * If both `create_response` and `interrupt_response` are set to `false`, the model will
             * never respond automatically but VAD events will still be emitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun interruptResponse(): Optional<Boolean> =
                interruptResponse.getOptional("interrupt_response")

            /**
             * Used only for `server_vad` mode. Amount of audio to include before the VAD detected
             * speech (in milliseconds). Defaults to 300ms.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

            /**
             * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
             * milliseconds). Defaults to 500ms. With shorter values the model will respond more
             * quickly, but may jump in on short pauses from the user.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun silenceDurationMs(): Optional<Long> =
                silenceDurationMs.getOptional("silence_duration_ms")

            /**
             * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this
             * defaults to 0.5. A higher threshold will require louder audio to activate the model,
             * and thus might perform better in noisy environments.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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
             * Unlike [idleTimeoutMs], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("idle_timeout_ms")
            @ExcludeMissing
            fun _idleTimeoutMs(): JsonField<Long> = idleTimeoutMs

            /**
             * Returns the raw JSON value of [interruptResponse].
             *
             * Unlike [interruptResponse], this method doesn't throw if the JSON field has an
             * unexpected type.
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

                /** Returns a mutable builder for constructing an instance of [ServerVad]. */
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
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("server_vad")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * Whether or not to automatically generate a response when a VAD stop event occurs.
                 * If `interrupt_response` is set to `false` this may fail to create a response if
                 * the model is already responding.
                 *
                 * If both `create_response` and `interrupt_response` are set to `false`, the model
                 * will never respond automatically but VAD events will still be emitted.
                 */
                fun createResponse(createResponse: Boolean) =
                    createResponse(JsonField.of(createResponse))

                /**
                 * Sets [Builder.createResponse] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createResponse] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createResponse(createResponse: JsonField<Boolean>) = apply {
                    this.createResponse = createResponse
                }

                /**
                 * Optional timeout after which a model response will be triggered automatically.
                 * This is useful for situations in which a long pause from the user is unexpected,
                 * such as a phone call. The model will effectively prompt the user to continue the
                 * conversation based on the current context.
                 *
                 * The timeout value will be applied after the last model response's audio has
                 * finished playing, i.e. it's set to the `response.done` time plus audio playback
                 * duration.
                 *
                 * An `input_audio_buffer.timeout_triggered` event (plus events associated with the
                 * Response) will be emitted when the timeout is reached. Idle timeout is currently
                 * only supported for `server_vad` mode.
                 */
                fun idleTimeoutMs(idleTimeoutMs: Long?) =
                    idleTimeoutMs(JsonField.ofNullable(idleTimeoutMs))

                /**
                 * Alias for [Builder.idleTimeoutMs].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun idleTimeoutMs(idleTimeoutMs: Long) = idleTimeoutMs(idleTimeoutMs as Long?)

                /** Alias for calling [Builder.idleTimeoutMs] with `idleTimeoutMs.orElse(null)`. */
                fun idleTimeoutMs(idleTimeoutMs: Optional<Long>) =
                    idleTimeoutMs(idleTimeoutMs.getOrNull())

                /**
                 * Sets [Builder.idleTimeoutMs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.idleTimeoutMs] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun idleTimeoutMs(idleTimeoutMs: JsonField<Long>) = apply {
                    this.idleTimeoutMs = idleTimeoutMs
                }

                /**
                 * Whether or not to automatically interrupt (cancel) any ongoing response with
                 * output to the default conversation (i.e. `conversation` of `auto`) when a VAD
                 * start event occurs. If `true` then the response will be cancelled, otherwise it
                 * will continue until complete.
                 *
                 * If both `create_response` and `interrupt_response` are set to `false`, the model
                 * will never respond automatically but VAD events will still be emitted.
                 */
                fun interruptResponse(interruptResponse: Boolean) =
                    interruptResponse(JsonField.of(interruptResponse))

                /**
                 * Sets [Builder.interruptResponse] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.interruptResponse] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                    this.interruptResponse = interruptResponse
                }

                /**
                 * Used only for `server_vad` mode. Amount of audio to include before the VAD
                 * detected speech (in milliseconds). Defaults to 300ms.
                 */
                fun prefixPaddingMs(prefixPaddingMs: Long) =
                    prefixPaddingMs(JsonField.of(prefixPaddingMs))

                /**
                 * Sets [Builder.prefixPaddingMs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefixPaddingMs(prefixPaddingMs: JsonField<Long>) = apply {
                    this.prefixPaddingMs = prefixPaddingMs
                }

                /**
                 * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
                 * milliseconds). Defaults to 500ms. With shorter values the model will respond more
                 * quickly, but may jump in on short pauses from the user.
                 */
                fun silenceDurationMs(silenceDurationMs: Long) =
                    silenceDurationMs(JsonField.of(silenceDurationMs))

                /**
                 * Sets [Builder.silenceDurationMs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.silenceDurationMs] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun silenceDurationMs(silenceDurationMs: JsonField<Long>) = apply {
                    this.silenceDurationMs = silenceDurationMs
                }

                /**
                 * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this
                 * defaults to 0.5. A higher threshold will require louder audio to activate the
                 * model, and thus might perform better in noisy environments.
                 */
                fun threshold(threshold: Double) = threshold(JsonField.of(threshold))

                /**
                 * Sets [Builder.threshold] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.threshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun threshold(threshold: JsonField<Double>) = apply { this.threshold = threshold }

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
         * Server-side semantic turn detection which uses a model to determine when the user has
         * finished speaking.
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
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Whether or not to automatically generate a response when a VAD stop event occurs.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

            /**
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`. `low`, `medium`, and `high` have
             * max timeouts of 8s, 4s, and 2s respectively.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun eagerness(): Optional<Eagerness> = eagerness.getOptional("eagerness")

            /**
             * Whether or not to automatically interrupt any ongoing response with output to the
             * default conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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
             * Unlike [eagerness], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("eagerness")
            @ExcludeMissing
            fun _eagerness(): JsonField<Eagerness> = eagerness

            /**
             * Returns the raw JSON value of [interruptResponse].
             *
             * Unlike [interruptResponse], this method doesn't throw if the JSON field has an
             * unexpected type.
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

                /** Returns a mutable builder for constructing an instance of [SemanticVad]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SemanticVad]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("semantic_vad")
                private var createResponse: JsonField<Boolean> = JsonMissing.of()
                private var eagerness: JsonField<Eagerness> = JsonMissing.of()
                private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("semantic_vad")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * Whether or not to automatically generate a response when a VAD stop event occurs.
                 */
                fun createResponse(createResponse: Boolean) =
                    createResponse(JsonField.of(createResponse))

                /**
                 * Sets [Builder.createResponse] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createResponse] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createResponse(createResponse: JsonField<Boolean>) = apply {
                    this.createResponse = createResponse
                }

                /**
                 * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low`
                 * will wait longer for the user to continue speaking, `high` will respond more
                 * quickly. `auto` is the default and is equivalent to `medium`. `low`, `medium`,
                 * and `high` have max timeouts of 8s, 4s, and 2s respectively.
                 */
                fun eagerness(eagerness: Eagerness) = eagerness(JsonField.of(eagerness))

                /**
                 * Sets [Builder.eagerness] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.eagerness] with a well-typed [Eagerness] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun eagerness(eagerness: JsonField<Eagerness>) = apply {
                    this.eagerness = eagerness
                }

                /**
                 * Whether or not to automatically interrupt any ongoing response with output to the
                 * default conversation (i.e. `conversation` of `auto`) when a VAD start event
                 * occurs.
                 */
                fun interruptResponse(interruptResponse: Boolean) =
                    interruptResponse(JsonField.of(interruptResponse))

                /**
                 * Sets [Builder.interruptResponse] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.interruptResponse] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                    this.interruptResponse = interruptResponse
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
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`. `low`, `medium`, and `high` have
             * max timeouts of 8s, 4s, and 2s respectively.
             */
            class Eagerness @JsonCreator private constructor(private val value: JsonField<String>) :
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
                 * An enum containing [Eagerness]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Eagerness] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    LOW,
                    MEDIUM,
                    HIGH,
                    AUTO,
                    /**
                     * An enum member indicating that [Eagerness] was instantiated with an unknown
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
                        LOW -> Value.LOW
                        MEDIUM -> Value.MEDIUM
                        HIGH -> Value.HIGH
                        AUTO -> Value.AUTO
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
                        LOW -> Known.LOW
                        MEDIUM -> Known.MEDIUM
                        HIGH -> Known.HIGH
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown Eagerness: $value")
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
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
            /** An enum member indicating that [Voice] was instantiated with an unknown value. */
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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

        return other is RealtimeSession &&
            id == other.id &&
            expiresAt == other.expiresAt &&
            include == other.include &&
            inputAudioFormat == other.inputAudioFormat &&
            inputAudioNoiseReduction == other.inputAudioNoiseReduction &&
            inputAudioTranscription == other.inputAudioTranscription &&
            instructions == other.instructions &&
            maxResponseOutputTokens == other.maxResponseOutputTokens &&
            modalities == other.modalities &&
            model == other.model &&
            object_ == other.object_ &&
            outputAudioFormat == other.outputAudioFormat &&
            prompt == other.prompt &&
            speed == other.speed &&
            temperature == other.temperature &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            tracing == other.tracing &&
            turnDetection == other.turnDetection &&
            voice == other.voice &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            expiresAt,
            include,
            inputAudioFormat,
            inputAudioNoiseReduction,
            inputAudioTranscription,
            instructions,
            maxResponseOutputTokens,
            modalities,
            model,
            object_,
            outputAudioFormat,
            prompt,
            speed,
            temperature,
            toolChoice,
            tools,
            tracing,
            turnDetection,
            voice,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeSession{id=$id, expiresAt=$expiresAt, include=$include, inputAudioFormat=$inputAudioFormat, inputAudioNoiseReduction=$inputAudioNoiseReduction, inputAudioTranscription=$inputAudioTranscription, instructions=$instructions, maxResponseOutputTokens=$maxResponseOutputTokens, modalities=$modalities, model=$model, object_=$object_, outputAudioFormat=$outputAudioFormat, prompt=$prompt, speed=$speed, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, tracing=$tracing, turnDetection=$turnDetection, voice=$voice, additionalProperties=$additionalProperties}"
}
