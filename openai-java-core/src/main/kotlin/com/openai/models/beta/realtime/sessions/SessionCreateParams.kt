// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.sessions

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create an ephemeral API token for use in client-side applications with the Realtime API. Can be
 * configured with the same session parameters as the `session.update` client event.
 *
 * It responds with a session object, plus a `client_secret` key which contains a usable ephemeral
 * API token that can be used to authenticate browser clients for the Realtime API.
 */
class SessionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Configuration options for the generated client secret.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientSecret(): Optional<ClientSecret> = body.clientSecret()

    /**
     * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
     * little-endian byte order.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioFormat(): Optional<InputAudioFormat> = body.inputAudioFormat()

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
        body.inputAudioNoiseReduction()

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
    fun inputAudioTranscription(): Optional<InputAudioTranscription> =
        body.inputAudioTranscription()

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
    fun instructions(): Optional<String> = body.instructions()

    /**
     * Maximum number of output tokens for a single assistant response, inclusive of tool calls.
     * Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the maximum
     * available tokens for a given model. Defaults to `inf`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxResponseOutputTokens(): Optional<MaxResponseOutputTokens> =
        body.maxResponseOutputTokens()

    /**
     * The set of modalities the model can respond with. To disable audio, set this to ["text"].
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modalities(): Optional<List<Modality>> = body.modalities()

    /**
     * The Realtime model used for this session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = body.model()

    /**
     * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
     * output audio is sampled at a rate of 24kHz.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputAudioFormat(): Optional<OutputAudioFormat> = body.outputAudioFormat()

    /**
     * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the minimum
     * speed. 1.5 is the maximum speed. This value can only be changed in between model turns, not
     * while a response is in progress.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun speed(): Optional<Double> = body.speed()

    /**
     * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a temperature of
     * 0.8 is highly recommended for best performance.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a function.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<String> = body.toolChoice()

    /**
     * Tools (functions) available to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = body.tools()

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
    fun tracing(): Optional<Tracing> = body.tracing()

    /**
     * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to `null`
     * to turn off, in which case the client must manually trigger model response. Server VAD means
     * that the model will detect the start and end of speech based on audio volume and respond at
     * the end of user speech. Semantic VAD is more advanced and uses a turn detection model (in
     * conjuction with VAD) to semantically estimate whether the user has finished speaking, then
     * dynamically sets a timeout based on this probability. For example, if user audio trails off
     * with "uhhm", the model will score a low probability of turn end and wait longer for the user
     * to continue speaking. This can be useful for more natural conversations, but may have a
     * higher latency.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun turnDetection(): Optional<TurnDetection> = body.turnDetection()

    /**
     * The voice the model uses to respond. Voice cannot be changed during the session once the
     * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
     * `ballad`, `coral`, `echo`, `fable`, `onyx`, `nova`, `sage`, `shimmer`, and `verse`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun voice(): Optional<Voice> = body.voice()

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientSecret(): JsonField<ClientSecret> = body._clientSecret()

    /**
     * Returns the raw JSON value of [inputAudioFormat].
     *
     * Unlike [inputAudioFormat], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _inputAudioFormat(): JsonField<InputAudioFormat> = body._inputAudioFormat()

    /**
     * Returns the raw JSON value of [inputAudioNoiseReduction].
     *
     * Unlike [inputAudioNoiseReduction], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _inputAudioNoiseReduction(): JsonField<InputAudioNoiseReduction> =
        body._inputAudioNoiseReduction()

    /**
     * Returns the raw JSON value of [inputAudioTranscription].
     *
     * Unlike [inputAudioTranscription], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _inputAudioTranscription(): JsonField<InputAudioTranscription> =
        body._inputAudioTranscription()

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _instructions(): JsonField<String> = body._instructions()

    /**
     * Returns the raw JSON value of [maxResponseOutputTokens].
     *
     * Unlike [maxResponseOutputTokens], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _maxResponseOutputTokens(): JsonField<MaxResponseOutputTokens> =
        body._maxResponseOutputTokens()

    /**
     * Returns the raw JSON value of [modalities].
     *
     * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _modalities(): JsonField<List<Modality>> = body._modalities()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<Model> = body._model()

    /**
     * Returns the raw JSON value of [outputAudioFormat].
     *
     * Unlike [outputAudioFormat], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _outputAudioFormat(): JsonField<OutputAudioFormat> = body._outputAudioFormat()

    /**
     * Returns the raw JSON value of [speed].
     *
     * Unlike [speed], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _speed(): JsonField<Double> = body._speed()

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
    fun _toolChoice(): JsonField<String> = body._toolChoice()

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tools(): JsonField<List<Tool>> = body._tools()

    /**
     * Returns the raw JSON value of [tracing].
     *
     * Unlike [tracing], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tracing(): JsonField<Tracing> = body._tracing()

    /**
     * Returns the raw JSON value of [turnDetection].
     *
     * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _turnDetection(): JsonField<TurnDetection> = body._turnDetection()

    /**
     * Returns the raw JSON value of [voice].
     *
     * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _voice(): JsonField<Voice> = body._voice()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): SessionCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [SessionCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(sessionCreateParams: SessionCreateParams) = apply {
            body = sessionCreateParams.body.toBuilder()
            additionalHeaders = sessionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = sessionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [clientSecret]
         * - [inputAudioFormat]
         * - [inputAudioNoiseReduction]
         * - [inputAudioTranscription]
         * - [instructions]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Configuration options for the generated client secret. */
        fun clientSecret(clientSecret: ClientSecret) = apply { body.clientSecret(clientSecret) }

        /**
         * Sets [Builder.clientSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientSecret] with a well-typed [ClientSecret] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun clientSecret(clientSecret: JsonField<ClientSecret>) = apply {
            body.clientSecret(clientSecret)
        }

        /**
         * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
         * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
         * little-endian byte order.
         */
        fun inputAudioFormat(inputAudioFormat: InputAudioFormat) = apply {
            body.inputAudioFormat(inputAudioFormat)
        }

        /**
         * Sets [Builder.inputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioFormat] with a well-typed [InputAudioFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun inputAudioFormat(inputAudioFormat: JsonField<InputAudioFormat>) = apply {
            body.inputAudioFormat(inputAudioFormat)
        }

        /**
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         */
        fun inputAudioNoiseReduction(inputAudioNoiseReduction: InputAudioNoiseReduction) = apply {
            body.inputAudioNoiseReduction(inputAudioNoiseReduction)
        }

        /**
         * Sets [Builder.inputAudioNoiseReduction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioNoiseReduction] with a well-typed
         * [InputAudioNoiseReduction] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun inputAudioNoiseReduction(
            inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>
        ) = apply { body.inputAudioNoiseReduction(inputAudioNoiseReduction) }

        /**
         * Configuration for input audio transcription, defaults to off and can be set to `null` to
         * turn off once on. Input audio transcription is not native to the model, since the model
         * consumes audio directly. Transcription runs asynchronously through
         * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
         * and should be treated as guidance of input audio content rather than precisely what the
         * model heard. The client can optionally set the language and prompt for transcription,
         * these offer additional guidance to the transcription service.
         */
        fun inputAudioTranscription(inputAudioTranscription: InputAudioTranscription) = apply {
            body.inputAudioTranscription(inputAudioTranscription)
        }

        /**
         * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioTranscription] with a well-typed
         * [InputAudioTranscription] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun inputAudioTranscription(inputAudioTranscription: JsonField<InputAudioTranscription>) =
            apply {
                body.inputAudioTranscription(inputAudioTranscription)
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
        fun instructions(instructions: String) = apply { body.instructions(instructions) }

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            body.instructions(instructions)
        }

        /**
         * Maximum number of output tokens for a single assistant response, inclusive of tool calls.
         * Provide an integer between 1 and 4096 to limit output tokens, or `inf` for the maximum
         * available tokens for a given model. Defaults to `inf`.
         */
        fun maxResponseOutputTokens(maxResponseOutputTokens: MaxResponseOutputTokens) = apply {
            body.maxResponseOutputTokens(maxResponseOutputTokens)
        }

        /**
         * Sets [Builder.maxResponseOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxResponseOutputTokens] with a well-typed
         * [MaxResponseOutputTokens] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun maxResponseOutputTokens(maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>) =
            apply {
                body.maxResponseOutputTokens(maxResponseOutputTokens)
            }

        /**
         * Alias for calling [maxResponseOutputTokens] with
         * `MaxResponseOutputTokens.ofInteger(integer)`.
         */
        fun maxResponseOutputTokens(integer: Long) = apply { body.maxResponseOutputTokens(integer) }

        /** Alias for calling [maxResponseOutputTokens] with `MaxResponseOutputTokens.ofInf()`. */
        fun maxResponseOutputTokensInf() = apply { body.maxResponseOutputTokensInf() }

        /**
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
         */
        fun modalities(modalities: List<Modality>) = apply { body.modalities(modalities) }

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

        /** The Realtime model used for this session. */
        fun model(model: Model) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { body.model(model) }

        /**
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
         * `pcm16`, output audio is sampled at a rate of 24kHz.
         */
        fun outputAudioFormat(outputAudioFormat: OutputAudioFormat) = apply {
            body.outputAudioFormat(outputAudioFormat)
        }

        /**
         * Sets [Builder.outputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputAudioFormat] with a well-typed [OutputAudioFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun outputAudioFormat(outputAudioFormat: JsonField<OutputAudioFormat>) = apply {
            body.outputAudioFormat(outputAudioFormat)
        }

        /**
         * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the minimum
         * speed. 1.5 is the maximum speed. This value can only be changed in between model turns,
         * not while a response is in progress.
         */
        fun speed(speed: Double) = apply { body.speed(speed) }

        /**
         * Sets [Builder.speed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speed] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun speed(speed: JsonField<Double>) = apply { body.speed(speed) }

        /**
         * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a temperature
         * of 0.8 is highly recommended for best performance.
         */
        fun temperature(temperature: Double) = apply { body.temperature(temperature) }

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /**
         * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a
         * function.
         */
        fun toolChoice(toolChoice: String) = apply { body.toolChoice(toolChoice) }

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun toolChoice(toolChoice: JsonField<String>) = apply { body.toolChoice(toolChoice) }

        /** Tools (functions) available to the model. */
        fun tools(tools: List<Tool>) = apply { body.tools(tools) }

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<Tool>>) = apply { body.tools(tools) }

        /**
         * Adds a single [Tool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: Tool) = apply { body.addTool(tool) }

        /**
         * Configuration options for tracing. Set to null to disable tracing. Once tracing is
         * enabled for a session, the configuration cannot be modified.
         *
         * `auto` will create a trace for the session with default values for the workflow name,
         * group id, and metadata.
         */
        fun tracing(tracing: Tracing) = apply { body.tracing(tracing) }

        /**
         * Sets [Builder.tracing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tracing] with a well-typed [Tracing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tracing(tracing: JsonField<Tracing>) = apply { body.tracing(tracing) }

        /** Alias for calling [tracing] with `Tracing.ofAuto()`. */
        fun tracingAuto() = apply { body.tracingAuto() }

        /** Alias for calling [tracing] with `Tracing.ofConfiguration(configuration)`. */
        fun tracing(configuration: Tracing.TracingConfiguration) = apply {
            body.tracing(configuration)
        }

        /**
         * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to
         * `null` to turn off, in which case the client must manually trigger model response. Server
         * VAD means that the model will detect the start and end of speech based on audio volume
         * and respond at the end of user speech. Semantic VAD is more advanced and uses a turn
         * detection model (in conjuction with VAD) to semantically estimate whether the user has
         * finished speaking, then dynamically sets a timeout based on this probability. For
         * example, if user audio trails off with "uhhm", the model will score a low probability of
         * turn end and wait longer for the user to continue speaking. This can be useful for more
         * natural conversations, but may have a higher latency.
         */
        fun turnDetection(turnDetection: TurnDetection) = apply {
            body.turnDetection(turnDetection)
        }

        /**
         * Sets [Builder.turnDetection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnDetection] with a well-typed [TurnDetection] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun turnDetection(turnDetection: JsonField<TurnDetection>) = apply {
            body.turnDetection(turnDetection)
        }

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `fable`, `onyx`, `nova`, `sage`, `shimmer`, and `verse`.
         */
        fun voice(voice: Voice) = apply { body.voice(voice) }

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<Voice>) = apply { body.voice(voice) }

        /**
         * Sets [voice] to an arbitrary [String].
         *
         * You should usually call [voice] with a well-typed [Voice] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(value: String) = apply { body.voice(value) }

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
         * Returns an immutable instance of [SessionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SessionCreateParams =
            SessionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Realtime session object configuration. */
    class Body
    private constructor(
        private val clientSecret: JsonField<ClientSecret>,
        private val inputAudioFormat: JsonField<InputAudioFormat>,
        private val inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>,
        private val inputAudioTranscription: JsonField<InputAudioTranscription>,
        private val instructions: JsonField<String>,
        private val maxResponseOutputTokens: JsonField<MaxResponseOutputTokens>,
        private val modalities: JsonField<List<Modality>>,
        private val model: JsonField<Model>,
        private val outputAudioFormat: JsonField<OutputAudioFormat>,
        private val speed: JsonField<Double>,
        private val temperature: JsonField<Double>,
        private val toolChoice: JsonField<String>,
        private val tools: JsonField<List<Tool>>,
        private val tracing: JsonField<Tracing>,
        private val turnDetection: JsonField<TurnDetection>,
        private val voice: JsonField<Voice>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<ClientSecret> = JsonMissing.of(),
            @JsonProperty("input_audio_format")
            @ExcludeMissing
            inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of(),
            @JsonProperty("input_audio_noise_reduction")
            @ExcludeMissing
            inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> = JsonMissing.of(),
            @JsonProperty("input_audio_transcription")
            @ExcludeMissing
            inputAudioTranscription: JsonField<InputAudioTranscription> = JsonMissing.of(),
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
            @JsonProperty("output_audio_format")
            @ExcludeMissing
            outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of(),
            @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tool_choice")
            @ExcludeMissing
            toolChoice: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("tracing") @ExcludeMissing tracing: JsonField<Tracing> = JsonMissing.of(),
            @JsonProperty("turn_detection")
            @ExcludeMissing
            turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
            @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
        ) : this(
            clientSecret,
            inputAudioFormat,
            inputAudioNoiseReduction,
            inputAudioTranscription,
            instructions,
            maxResponseOutputTokens,
            modalities,
            model,
            outputAudioFormat,
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
         * Configuration options for the generated client secret.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientSecret(): Optional<ClientSecret> = clientSecret.getOptional("client_secret")

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
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputAudioNoiseReduction(): Optional<InputAudioNoiseReduction> =
            inputAudioNoiseReduction.getOptional("input_audio_noise_reduction")

        /**
         * Configuration for input audio transcription, defaults to off and can be set to `null` to
         * turn off once on. Input audio transcription is not native to the model, since the model
         * consumes audio directly. Transcription runs asynchronously through
         * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
         * and should be treated as guidance of input audio content rather than precisely what the
         * model heard. The client can optionally set the language and prompt for transcription,
         * these offer additional guidance to the transcription service.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputAudioTranscription(): Optional<InputAudioTranscription> =
            inputAudioTranscription.getOptional("input_audio_transcription")

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
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
         * `pcm16`, output audio is sampled at a rate of 24kHz.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputAudioFormat(): Optional<OutputAudioFormat> =
            outputAudioFormat.getOptional("output_audio_format")

        /**
         * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the minimum
         * speed. 1.5 is the maximum speed. This value can only be changed in between model turns,
         * not while a response is in progress.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun speed(): Optional<Double> = speed.getOptional("speed")

        /**
         * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a temperature
         * of 0.8 is highly recommended for best performance.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * How the model chooses tools. Options are `auto`, `none`, `required`, or specify a
         * function.
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
         * Configuration options for tracing. Set to null to disable tracing. Once tracing is
         * enabled for a session, the configuration cannot be modified.
         *
         * `auto` will create a trace for the session with default values for the workflow name,
         * group id, and metadata.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tracing(): Optional<Tracing> = tracing.getOptional("tracing")

        /**
         * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to
         * `null` to turn off, in which case the client must manually trigger model response. Server
         * VAD means that the model will detect the start and end of speech based on audio volume
         * and respond at the end of user speech. Semantic VAD is more advanced and uses a turn
         * detection model (in conjuction with VAD) to semantically estimate whether the user has
         * finished speaking, then dynamically sets a timeout based on this probability. For
         * example, if user audio trails off with "uhhm", the model will score a low probability of
         * turn end and wait longer for the user to continue speaking. This can be useful for more
         * natural conversations, but may have a higher latency.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun turnDetection(): Optional<TurnDetection> = turnDetection.getOptional("turn_detection")

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `fable`, `onyx`, `nova`, `sage`, `shimmer`, and `verse`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun voice(): Optional<Voice> = voice.getOptional("voice")

        /**
         * Returns the raw JSON value of [clientSecret].
         *
         * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("client_secret")
        @ExcludeMissing
        fun _clientSecret(): JsonField<ClientSecret> = clientSecret

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
        fun _inputAudioNoiseReduction(): JsonField<InputAudioNoiseReduction> =
            inputAudioNoiseReduction

        /**
         * Returns the raw JSON value of [inputAudioTranscription].
         *
         * Unlike [inputAudioTranscription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("input_audio_transcription")
        @ExcludeMissing
        fun _inputAudioTranscription(): JsonField<InputAudioTranscription> = inputAudioTranscription

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
         * Returns the raw JSON value of [outputAudioFormat].
         *
         * Unlike [outputAudioFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_audio_format")
        @ExcludeMissing
        fun _outputAudioFormat(): JsonField<OutputAudioFormat> = outputAudioFormat

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
         * Returns the raw JSON value of [tracing].
         *
         * Unlike [tracing], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracing") @ExcludeMissing fun _tracing(): JsonField<Tracing> = tracing

        /**
         * Returns the raw JSON value of [turnDetection].
         *
         * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected
         * type.
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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var clientSecret: JsonField<ClientSecret> = JsonMissing.of()
            private var inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of()
            private var inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> =
                JsonMissing.of()
            private var inputAudioTranscription: JsonField<InputAudioTranscription> =
                JsonMissing.of()
            private var instructions: JsonField<String> = JsonMissing.of()
            private var maxResponseOutputTokens: JsonField<MaxResponseOutputTokens> =
                JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var model: JsonField<Model> = JsonMissing.of()
            private var outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of()
            private var speed: JsonField<Double> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var toolChoice: JsonField<String> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var tracing: JsonField<Tracing> = JsonMissing.of()
            private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
            private var voice: JsonField<Voice> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                clientSecret = body.clientSecret
                inputAudioFormat = body.inputAudioFormat
                inputAudioNoiseReduction = body.inputAudioNoiseReduction
                inputAudioTranscription = body.inputAudioTranscription
                instructions = body.instructions
                maxResponseOutputTokens = body.maxResponseOutputTokens
                modalities = body.modalities.map { it.toMutableList() }
                model = body.model
                outputAudioFormat = body.outputAudioFormat
                speed = body.speed
                temperature = body.temperature
                toolChoice = body.toolChoice
                tools = body.tools.map { it.toMutableList() }
                tracing = body.tracing
                turnDetection = body.turnDetection
                voice = body.voice
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Configuration options for the generated client secret. */
            fun clientSecret(clientSecret: ClientSecret) = clientSecret(JsonField.of(clientSecret))

            /**
             * Sets [Builder.clientSecret] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientSecret] with a well-typed [ClientSecret] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientSecret(clientSecret: JsonField<ClientSecret>) = apply {
                this.clientSecret = clientSecret
            }

            /**
             * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
             * `pcm16`, input audio must be 16-bit PCM at a 24kHz sample rate, single channel
             * (mono), and little-endian byte order.
             */
            fun inputAudioFormat(inputAudioFormat: InputAudioFormat) =
                inputAudioFormat(JsonField.of(inputAudioFormat))

            /**
             * Sets [Builder.inputAudioFormat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputAudioFormat] with a well-typed
             * [InputAudioFormat] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun inputAudioFormat(inputAudioFormat: JsonField<InputAudioFormat>) = apply {
                this.inputAudioFormat = inputAudioFormat
            }

            /**
             * Configuration for input audio noise reduction. This can be set to `null` to turn off.
             * Noise reduction filters audio added to the input audio buffer before it is sent to
             * VAD and the model. Filtering the audio can improve VAD and turn detection accuracy
             * (reducing false positives) and model performance by improving perception of the input
             * audio.
             */
            fun inputAudioNoiseReduction(inputAudioNoiseReduction: InputAudioNoiseReduction) =
                inputAudioNoiseReduction(JsonField.of(inputAudioNoiseReduction))

            /**
             * Sets [Builder.inputAudioNoiseReduction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputAudioNoiseReduction] with a well-typed
             * [InputAudioNoiseReduction] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun inputAudioNoiseReduction(
                inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>
            ) = apply { this.inputAudioNoiseReduction = inputAudioNoiseReduction }

            /**
             * Configuration for input audio transcription, defaults to off and can be set to `null`
             * to turn off once on. Input audio transcription is not native to the model, since the
             * model consumes audio directly. Transcription runs asynchronously through
             * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
             * and should be treated as guidance of input audio content rather than precisely what
             * the model heard. The client can optionally set the language and prompt for
             * transcription, these offer additional guidance to the transcription service.
             */
            fun inputAudioTranscription(inputAudioTranscription: InputAudioTranscription) =
                inputAudioTranscription(JsonField.of(inputAudioTranscription))

            /**
             * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputAudioTranscription] with a well-typed
             * [InputAudioTranscription] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun inputAudioTranscription(
                inputAudioTranscription: JsonField<InputAudioTranscription>
            ) = apply { this.inputAudioTranscription = inputAudioTranscription }

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

            /** The Realtime model used for this session. */
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [Model] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /**
             * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
             * `pcm16`, output audio is sampled at a rate of 24kHz.
             */
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
             * The speed of the model's spoken response. 1.0 is the default speed. 0.25 is the
             * minimum speed. 1.5 is the maximum speed. This value can only be changed in between
             * model turns, not while a response is in progress.
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
             * Sampling temperature for the model, limited to [0.6, 1.2]. For audio models a
             * temperature of 0.8 is highly recommended for best performance.
             */
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
             * function.
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
             * You should usually call [Builder.tracing] with a well-typed [Tracing] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tracing(tracing: JsonField<Tracing>) = apply { this.tracing = tracing }

            /** Alias for calling [tracing] with `Tracing.ofAuto()`. */
            fun tracingAuto() = tracing(Tracing.ofAuto())

            /** Alias for calling [tracing] with `Tracing.ofConfiguration(configuration)`. */
            fun tracing(configuration: Tracing.TracingConfiguration) =
                tracing(Tracing.ofConfiguration(configuration))

            /**
             * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set
             * to `null` to turn off, in which case the client must manually trigger model response.
             * Server VAD means that the model will detect the start and end of speech based on
             * audio volume and respond at the end of user speech. Semantic VAD is more advanced and
             * uses a turn detection model (in conjuction with VAD) to semantically estimate whether
             * the user has finished speaking, then dynamically sets a timeout based on this
             * probability. For example, if user audio trails off with "uhhm", the model will score
             * a low probability of turn end and wait longer for the user to continue speaking. This
             * can be useful for more natural conversations, but may have a higher latency.
             */
            fun turnDetection(turnDetection: TurnDetection) =
                turnDetection(JsonField.of(turnDetection))

            /**
             * Sets [Builder.turnDetection] to an arbitrary JSON value.
             *
             * You should usually call [Builder.turnDetection] with a well-typed [TurnDetection]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun turnDetection(turnDetection: JsonField<TurnDetection>) = apply {
                this.turnDetection = turnDetection
            }

            /**
             * The voice the model uses to respond. Voice cannot be changed during the session once
             * the model has responded with audio at least once. Current voice options are `alloy`,
             * `ash`, `ballad`, `coral`, `echo`, `fable`, `onyx`, `nova`, `sage`, `shimmer`, and
             * `verse`.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    clientSecret,
                    inputAudioFormat,
                    inputAudioNoiseReduction,
                    inputAudioTranscription,
                    instructions,
                    maxResponseOutputTokens,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    model,
                    outputAudioFormat,
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

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            clientSecret().ifPresent { it.validate() }
            inputAudioFormat().ifPresent { it.validate() }
            inputAudioNoiseReduction().ifPresent { it.validate() }
            inputAudioTranscription().ifPresent { it.validate() }
            instructions()
            maxResponseOutputTokens().ifPresent { it.validate() }
            modalities().ifPresent { it.forEach { it.validate() } }
            model().ifPresent { it.validate() }
            outputAudioFormat().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (clientSecret.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioNoiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioTranscription.asKnown().getOrNull()?.validity() ?: 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (maxResponseOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
                (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (model.asKnown().getOrNull()?.validity() ?: 0) +
                (outputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (if (speed.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (toolChoice.asKnown().isPresent) 1 else 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (tracing.asKnown().getOrNull()?.validity() ?: 0) +
                (turnDetection.asKnown().getOrNull()?.validity() ?: 0) +
                (if (voice.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && clientSecret == other.clientSecret && inputAudioFormat == other.inputAudioFormat && inputAudioNoiseReduction == other.inputAudioNoiseReduction && inputAudioTranscription == other.inputAudioTranscription && instructions == other.instructions && maxResponseOutputTokens == other.maxResponseOutputTokens && modalities == other.modalities && model == other.model && outputAudioFormat == other.outputAudioFormat && speed == other.speed && temperature == other.temperature && toolChoice == other.toolChoice && tools == other.tools && tracing == other.tracing && turnDetection == other.turnDetection && voice == other.voice && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(clientSecret, inputAudioFormat, inputAudioNoiseReduction, inputAudioTranscription, instructions, maxResponseOutputTokens, modalities, model, outputAudioFormat, speed, temperature, toolChoice, tools, tracing, turnDetection, voice, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{clientSecret=$clientSecret, inputAudioFormat=$inputAudioFormat, inputAudioNoiseReduction=$inputAudioNoiseReduction, inputAudioTranscription=$inputAudioTranscription, instructions=$instructions, maxResponseOutputTokens=$maxResponseOutputTokens, modalities=$modalities, model=$model, outputAudioFormat=$outputAudioFormat, speed=$speed, temperature=$temperature, toolChoice=$toolChoice, tools=$tools, tracing=$tracing, turnDetection=$turnDetection, voice=$voice, additionalProperties=$additionalProperties}"
    }

    /** Configuration options for the generated client secret. */
    class ClientSecret
    private constructor(
        private val expiresAfter: JsonField<ExpiresAfter>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_after")
            @ExcludeMissing
            expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
        ) : this(expiresAfter, mutableMapOf())

        /**
         * Configuration for the ephemeral token expiration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAfter(): Optional<ExpiresAfter> = expiresAfter.getOptional("expires_after")

        /**
         * Returns the raw JSON value of [expiresAfter].
         *
         * Unlike [expiresAfter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

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

            /** Returns a mutable builder for constructing an instance of [ClientSecret]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecret]. */
        class Builder internal constructor() {

            private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecret: ClientSecret) = apply {
                expiresAfter = clientSecret.expiresAfter
                additionalProperties = clientSecret.additionalProperties.toMutableMap()
            }

            /** Configuration for the ephemeral token expiration. */
            fun expiresAfter(expiresAfter: ExpiresAfter) = expiresAfter(JsonField.of(expiresAfter))

            /**
             * Sets [Builder.expiresAfter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAfter] with a well-typed [ExpiresAfter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
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
             * Returns an immutable instance of [ClientSecret].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ClientSecret =
                ClientSecret(expiresAfter, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ClientSecret = apply {
            if (validated) {
                return@apply
            }

            expiresAfter().ifPresent { it.validate() }
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
        internal fun validity(): Int = (expiresAfter.asKnown().getOrNull()?.validity() ?: 0)

        /** Configuration for the ephemeral token expiration. */
        class ExpiresAfter
        private constructor(
            private val anchor: JsonField<Anchor>,
            private val seconds: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("anchor")
                @ExcludeMissing
                anchor: JsonField<Anchor> = JsonMissing.of(),
                @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Long> = JsonMissing.of(),
            ) : this(anchor, seconds, mutableMapOf())

            /**
             * The anchor point for the ephemeral token expiration. Only `created_at` is currently
             * supported.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun anchor(): Anchor = anchor.getRequired("anchor")

            /**
             * The number of seconds from the anchor point to the expiration. Select a value between
             * `10` and `7200`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun seconds(): Optional<Long> = seconds.getOptional("seconds")

            /**
             * Returns the raw JSON value of [anchor].
             *
             * Unlike [anchor], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonField<Anchor> = anchor

            /**
             * Returns the raw JSON value of [seconds].
             *
             * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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
                 * Returns a mutable builder for constructing an instance of [ExpiresAfter].
                 *
                 * The following fields are required:
                 * ```java
                 * .anchor()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ExpiresAfter]. */
            class Builder internal constructor() {

                private var anchor: JsonField<Anchor>? = null
                private var seconds: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(expiresAfter: ExpiresAfter) = apply {
                    anchor = expiresAfter.anchor
                    seconds = expiresAfter.seconds
                    additionalProperties = expiresAfter.additionalProperties.toMutableMap()
                }

                /**
                 * The anchor point for the ephemeral token expiration. Only `created_at` is
                 * currently supported.
                 */
                fun anchor(anchor: Anchor) = anchor(JsonField.of(anchor))

                /**
                 * Sets [Builder.anchor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.anchor] with a well-typed [Anchor] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun anchor(anchor: JsonField<Anchor>) = apply { this.anchor = anchor }

                /**
                 * The number of seconds from the anchor point to the expiration. Select a value
                 * between `10` and `7200`.
                 */
                fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

                /**
                 * Sets [Builder.seconds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.seconds] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
                 * Returns an immutable instance of [ExpiresAfter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .anchor()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ExpiresAfter =
                    ExpiresAfter(
                        checkRequired("anchor", anchor),
                        seconds,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ExpiresAfter = apply {
                if (validated) {
                    return@apply
                }

                anchor().validate()
                seconds()
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
                (anchor.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (seconds.asKnown().isPresent) 1 else 0)

            /**
             * The anchor point for the ephemeral token expiration. Only `created_at` is currently
             * supported.
             */
            class Anchor @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val CREATED_AT = of("created_at")

                    @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
                }

                /** An enum containing [Anchor]'s known values. */
                enum class Known {
                    CREATED_AT
                }

                /**
                 * An enum containing [Anchor]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Anchor] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CREATED_AT,
                    /**
                     * An enum member indicating that [Anchor] was instantiated with an unknown
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
                        CREATED_AT -> Value.CREATED_AT
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
                        CREATED_AT -> Known.CREATED_AT
                        else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
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

                fun validate(): Anchor = apply {
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

                    return /* spotless:off */ other is Anchor && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ExpiresAfter && anchor == other.anchor && seconds == other.seconds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ExpiresAfter{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ClientSecret && expiresAfter == other.expiresAfter && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(expiresAfter, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecret{expiresAfter=$expiresAfter, additionalProperties=$additionalProperties}"
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

            return /* spotless:off */ other is InputAudioFormat && value == other.value /* spotless:on */
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
    private constructor(
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
        ) : this(type, mutableMapOf())

        /**
         * Type of noise reduction. `near_field` is for close-talking microphones such as
         * headphones, `far_field` is for far-field microphones such as laptop or conference room
         * microphones.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

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

            /**
             * Returns a mutable builder for constructing an instance of [InputAudioNoiseReduction].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputAudioNoiseReduction]. */
        class Builder internal constructor() {

            private var type: JsonField<Type> = JsonMissing.of()
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

        /**
         * Type of noise reduction. `near_field` is for close-talking microphones such as
         * headphones, `far_field` is for far-field microphones such as laptop or conference room
         * microphones.
         */
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NEAR_FIELD,
                FAR_FIELD,
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
                    NEAR_FIELD -> Value.NEAR_FIELD
                    FAR_FIELD -> Value.FAR_FIELD
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

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InputAudioNoiseReduction && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputAudioNoiseReduction{type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Configuration for input audio transcription, defaults to off and can be set to `null` to turn
     * off once on. Input audio transcription is not native to the model, since the model consumes
     * audio directly. Transcription runs asynchronously through
     * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
     * and should be treated as guidance of input audio content rather than precisely what the model
     * heard. The client can optionally set the language and prompt for transcription, these offer
     * additional guidance to the transcription service.
     */
    class InputAudioTranscription
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
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prompt") @ExcludeMissing prompt: JsonField<String> = JsonMissing.of(),
        ) : this(language, model, prompt, mutableMapOf())

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * The model to use for transcription, current options are `gpt-4o-transcribe`,
         * `gpt-4o-mini-transcribe`, and `whisper-1`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<String> = model.getOptional("model")

        /**
         * An optional text to guide the model's style or continue a previous audio segment. For
         * `whisper-1`, the
         * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
         * For `gpt-4o-transcribe` models, the prompt is a free text string, for example "expect
         * words related to technology".
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prompt(): Optional<String> = prompt.getOptional("prompt")

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
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
             * Returns a mutable builder for constructing an instance of [InputAudioTranscription].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputAudioTranscription]. */
        class Builder internal constructor() {

            private var language: JsonField<String> = JsonMissing.of()
            private var model: JsonField<String> = JsonMissing.of()
            private var prompt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputAudioTranscription: InputAudioTranscription) = apply {
                language = inputAudioTranscription.language
                model = inputAudioTranscription.model
                prompt = inputAudioTranscription.prompt
                additionalProperties = inputAudioTranscription.additionalProperties.toMutableMap()
            }

            /**
             * The language of the input audio. Supplying the input language in
             * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
             * will improve accuracy and latency.
             */
            fun language(language: String) = language(JsonField.of(language))

            /**
             * Sets [Builder.language] to an arbitrary JSON value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: JsonField<String>) = apply { this.language = language }

            /**
             * The model to use for transcription, current options are `gpt-4o-transcribe`,
             * `gpt-4o-mini-transcribe`, and `whisper-1`.
             */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /**
             * An optional text to guide the model's style or continue a previous audio segment. For
             * `whisper-1`, the
             * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
             * For `gpt-4o-transcribe` models, the prompt is a free text string, for example "expect
             * words related to technology".
             */
            fun prompt(prompt: String) = prompt(JsonField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

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
             * Returns an immutable instance of [InputAudioTranscription].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InputAudioTranscription =
                InputAudioTranscription(
                    language,
                    model,
                    prompt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): InputAudioTranscription = apply {
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

            return /* spotless:off */ other is InputAudioTranscription && language == other.language && model == other.model && prompt == other.prompt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(language, model, prompt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputAudioTranscription{language=$language, model=$model, prompt=$prompt, additionalProperties=$additionalProperties}"
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

            return /* spotless:off */ other is MaxResponseOutputTokens && integer == other.integer && inf == other.inf /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(integer, inf) /* spotless:on */

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
                    // all the possible variants (e.g. deserializing from object).
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

            return /* spotless:off */ other is Modality && value == other.value /* spotless:on */
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

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
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
            GPT_4O_REALTIME_PREVIEW,
            GPT_4O_REALTIME_PREVIEW_2024_10_01,
            GPT_4O_REALTIME_PREVIEW_2024_12_17,
            GPT_4O_REALTIME_PREVIEW_2025_06_03,
            GPT_4O_MINI_REALTIME_PREVIEW,
            GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17,
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
                GPT_4O_REALTIME_PREVIEW -> Value.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Value.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_REALTIME_PREVIEW_2024_12_17 -> Value.GPT_4O_REALTIME_PREVIEW_2024_12_17
                GPT_4O_REALTIME_PREVIEW_2025_06_03 -> Value.GPT_4O_REALTIME_PREVIEW_2025_06_03
                GPT_4O_MINI_REALTIME_PREVIEW -> Value.GPT_4O_MINI_REALTIME_PREVIEW
                GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17 ->
                    Value.GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17
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
                GPT_4O_REALTIME_PREVIEW -> Known.GPT_4O_REALTIME_PREVIEW
                GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Known.GPT_4O_REALTIME_PREVIEW_2024_10_01
                GPT_4O_REALTIME_PREVIEW_2024_12_17 -> Known.GPT_4O_REALTIME_PREVIEW_2024_12_17
                GPT_4O_REALTIME_PREVIEW_2025_06_03 -> Known.GPT_4O_REALTIME_PREVIEW_2025_06_03
                GPT_4O_MINI_REALTIME_PREVIEW -> Known.GPT_4O_MINI_REALTIME_PREVIEW
                GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17 ->
                    Known.GPT_4O_MINI_REALTIME_PREVIEW_2024_12_17
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

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
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

            return /* spotless:off */ other is OutputAudioFormat && value == other.value /* spotless:on */
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

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Tool && description == other.description && name == other.name && parameters == other.parameters && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, name, parameters, type, additionalProperties) }
        /* spotless:on */

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

            return /* spotless:off */ other is Tracing && auto == other.auto && configuration == other.configuration /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, configuration) /* spotless:on */

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

                return /* spotless:off */ other is TracingConfiguration && groupId == other.groupId && metadata == other.metadata && workflowName == other.workflowName && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(groupId, metadata, workflowName, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TracingConfiguration{groupId=$groupId, metadata=$metadata, workflowName=$workflowName, additionalProperties=$additionalProperties}"
        }
    }

    /**
     * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to `null`
     * to turn off, in which case the client must manually trigger model response. Server VAD means
     * that the model will detect the start and end of speech based on audio volume and respond at
     * the end of user speech. Semantic VAD is more advanced and uses a turn detection model (in
     * conjuction with VAD) to semantically estimate whether the user has finished speaking, then
     * dynamically sets a timeout based on this probability. For example, if user audio trails off
     * with "uhhm", the model will score a low probability of turn end and wait longer for the user
     * to continue speaking. This can be useful for more natural conversations, but may have a
     * higher latency.
     */
    class TurnDetection
    private constructor(
        private val createResponse: JsonField<Boolean>,
        private val eagerness: JsonField<Eagerness>,
        private val interruptResponse: JsonField<Boolean>,
        private val prefixPaddingMs: JsonField<Long>,
        private val silenceDurationMs: JsonField<Long>,
        private val threshold: JsonField<Double>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("create_response")
            @ExcludeMissing
            createResponse: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("eagerness")
            @ExcludeMissing
            eagerness: JsonField<Eagerness> = JsonMissing.of(),
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
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(
            createResponse,
            eagerness,
            interruptResponse,
            prefixPaddingMs,
            silenceDurationMs,
            threshold,
            type,
            mutableMapOf(),
        )

        /**
         * Whether or not to automatically generate a response when a VAD stop event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

        /**
         * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will wait
         * longer for the user to continue speaking, `high` will respond more quickly. `auto` is the
         * default and is equivalent to `medium`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun eagerness(): Optional<Eagerness> = eagerness.getOptional("eagerness")

        /**
         * Whether or not to automatically interrupt any ongoing response with output to the default
         * conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun interruptResponse(): Optional<Boolean> =
            interruptResponse.getOptional("interrupt_response")

        /**
         * Used only for `server_vad` mode. Amount of audio to include before the VAD detected
         * speech (in milliseconds). Defaults to 300ms.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

        /**
         * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
         * milliseconds). Defaults to 500ms. With shorter values the model will respond more
         * quickly, but may jump in on short pauses from the user.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun silenceDurationMs(): Optional<Long> =
            silenceDurationMs.getOptional("silence_duration_ms")

        /**
         * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this defaults
         * to 0.5. A higher threshold will require louder audio to activate the model, and thus
         * might perform better in noisy environments.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun threshold(): Optional<Double> = threshold.getOptional("threshold")

        /**
         * Type of turn detection.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [createResponse].
         *
         * Unlike [createResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("create_response")
        @ExcludeMissing
        fun _createResponse(): JsonField<Boolean> = createResponse

        /**
         * Returns the raw JSON value of [eagerness].
         *
         * Unlike [eagerness], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("eagerness")
        @ExcludeMissing
        fun _eagerness(): JsonField<Eagerness> = eagerness

        /**
         * Returns the raw JSON value of [interruptResponse].
         *
         * Unlike [interruptResponse], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interrupt_response")
        @ExcludeMissing
        fun _interruptResponse(): JsonField<Boolean> = interruptResponse

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

            /** Returns a mutable builder for constructing an instance of [TurnDetection]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TurnDetection]. */
        class Builder internal constructor() {

            private var createResponse: JsonField<Boolean> = JsonMissing.of()
            private var eagerness: JsonField<Eagerness> = JsonMissing.of()
            private var interruptResponse: JsonField<Boolean> = JsonMissing.of()
            private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
            private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
            private var threshold: JsonField<Double> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(turnDetection: TurnDetection) = apply {
                createResponse = turnDetection.createResponse
                eagerness = turnDetection.eagerness
                interruptResponse = turnDetection.interruptResponse
                prefixPaddingMs = turnDetection.prefixPaddingMs
                silenceDurationMs = turnDetection.silenceDurationMs
                threshold = turnDetection.threshold
                type = turnDetection.type
                additionalProperties = turnDetection.additionalProperties.toMutableMap()
            }

            /** Whether or not to automatically generate a response when a VAD stop event occurs. */
            fun createResponse(createResponse: Boolean) =
                createResponse(JsonField.of(createResponse))

            /**
             * Sets [Builder.createResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createResponse(createResponse: JsonField<Boolean>) = apply {
                this.createResponse = createResponse
            }

            /**
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`.
             */
            fun eagerness(eagerness: Eagerness) = eagerness(JsonField.of(eagerness))

            /**
             * Sets [Builder.eagerness] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eagerness] with a well-typed [Eagerness] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eagerness(eagerness: JsonField<Eagerness>) = apply { this.eagerness = eagerness }

            /**
             * Whether or not to automatically interrupt any ongoing response with output to the
             * default conversation (i.e. `conversation` of `auto`) when a VAD start event occurs.
             */
            fun interruptResponse(interruptResponse: Boolean) =
                interruptResponse(JsonField.of(interruptResponse))

            /**
             * Sets [Builder.interruptResponse] to an arbitrary JSON value.
             *
             * You should usually call [Builder.interruptResponse] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun interruptResponse(interruptResponse: JsonField<Boolean>) = apply {
                this.interruptResponse = interruptResponse
            }

            /**
             * Used only for `server_vad` mode. Amount of audio to include before the VAD detected
             * speech (in milliseconds). Defaults to 300ms.
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
             * Used only for `server_vad` mode. Duration of silence to detect speech stop (in
             * milliseconds). Defaults to 500ms. With shorter values the model will respond more
             * quickly, but may jump in on short pauses from the user.
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
             * Used only for `server_vad` mode. Activation threshold for VAD (0.0 to 1.0), this
             * defaults to 0.5. A higher threshold will require louder audio to activate the model,
             * and thus might perform better in noisy environments.
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

            /** Type of turn detection. */
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
             * Returns an immutable instance of [TurnDetection].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): TurnDetection =
                TurnDetection(
                    createResponse,
                    eagerness,
                    interruptResponse,
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

            createResponse()
            eagerness().ifPresent { it.validate() }
            interruptResponse()
            prefixPaddingMs()
            silenceDurationMs()
            threshold()
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
            (if (createResponse.asKnown().isPresent) 1 else 0) +
                (eagerness.asKnown().getOrNull()?.validity() ?: 0) +
                (if (interruptResponse.asKnown().isPresent) 1 else 0) +
                (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                (if (threshold.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will wait
         * longer for the user to continue speaking, `high` will respond more quickly. `auto` is the
         * default and is equivalent to `medium`.
         */
        class Eagerness @JsonCreator private constructor(private val value: JsonField<String>) :
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
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
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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

                return /* spotless:off */ other is Eagerness && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Type of turn detection. */
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

                @JvmField val SERVER_VAD = of("server_vad")

                @JvmField val SEMANTIC_VAD = of("semantic_vad")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                SERVER_VAD,
                SEMANTIC_VAD,
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
                SERVER_VAD,
                SEMANTIC_VAD,
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
                    SERVER_VAD -> Value.SERVER_VAD
                    SEMANTIC_VAD -> Value.SEMANTIC_VAD
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
                    SERVER_VAD -> Known.SERVER_VAD
                    SEMANTIC_VAD -> Known.SEMANTIC_VAD
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

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TurnDetection && createResponse == other.createResponse && eagerness == other.eagerness && interruptResponse == other.interruptResponse && prefixPaddingMs == other.prefixPaddingMs && silenceDurationMs == other.silenceDurationMs && threshold == other.threshold && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(createResponse, eagerness, interruptResponse, prefixPaddingMs, silenceDurationMs, threshold, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TurnDetection{createResponse=$createResponse, eagerness=$eagerness, interruptResponse=$interruptResponse, prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * The voice the model uses to respond. Voice cannot be changed during the session once the
     * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
     * `ballad`, `coral`, `echo`, `fable`, `onyx`, `nova`, `sage`, `shimmer`, and `verse`.
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

            @JvmField val FABLE = of("fable")

            @JvmField val ONYX = of("onyx")

            @JvmField val NOVA = of("nova")

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
            FABLE,
            ONYX,
            NOVA,
            SAGE,
            SHIMMER,
            VERSE,
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
            FABLE,
            ONYX,
            NOVA,
            SAGE,
            SHIMMER,
            VERSE,
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
                FABLE -> Value.FABLE
                ONYX -> Value.ONYX
                NOVA -> Value.NOVA
                SAGE -> Value.SAGE
                SHIMMER -> Value.SHIMMER
                VERSE -> Value.VERSE
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
                FABLE -> Known.FABLE
                ONYX -> Known.ONYX
                NOVA -> Known.NOVA
                SAGE -> Known.SAGE
                SHIMMER -> Known.SHIMMER
                VERSE -> Known.VERSE
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

            return /* spotless:off */ other is Voice && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SessionCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "SessionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
