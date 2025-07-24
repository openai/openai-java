// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime.transcriptionsessions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create an ephemeral API token for use in client-side applications with the Realtime API
 * specifically for realtime transcriptions. Can be configured with the same session parameters as
 * the `transcription_session.update` client event.
 *
 * It responds with a session object, plus a `client_secret` key which contains a usable ephemeral
 * API token that can be used to authenticate browser clients for the Realtime API.
 */
class TranscriptionSessionCreateParams
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
     * The set of items to include in the transcription. Current available items are:
     * - `item.input_audio_transcription.logprobs`
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun include(): Optional<List<String>> = body.include()

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
     * Configuration for input audio transcription. The client can optionally set the language and
     * prompt for transcription, these offer additional guidance to the transcription service.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioTranscription(): Optional<InputAudioTranscription> =
        body.inputAudioTranscription()

    /**
     * The set of modalities the model can respond with. To disable audio, set this to ["text"].
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modalities(): Optional<List<Modality>> = body.modalities()

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
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientSecret(): JsonField<ClientSecret> = body._clientSecret()

    /**
     * Returns the raw JSON value of [include].
     *
     * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _include(): JsonField<List<String>> = body._include()

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
     * Returns the raw JSON value of [modalities].
     *
     * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _modalities(): JsonField<List<Modality>> = body._modalities()

    /**
     * Returns the raw JSON value of [turnDetection].
     *
     * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _turnDetection(): JsonField<TurnDetection> = body._turnDetection()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TranscriptionSessionCreateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [TranscriptionSessionCreateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSessionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(transcriptionSessionCreateParams: TranscriptionSessionCreateParams) =
            apply {
                body = transcriptionSessionCreateParams.body.toBuilder()
                additionalHeaders = transcriptionSessionCreateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    transcriptionSessionCreateParams.additionalQueryParams.toBuilder()
            }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [clientSecret]
         * - [include]
         * - [inputAudioFormat]
         * - [inputAudioNoiseReduction]
         * - [inputAudioTranscription]
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
         * The set of items to include in the transcription. Current available items are:
         * - `item.input_audio_transcription.logprobs`
         */
        fun include(include: List<String>) = apply { body.include(include) }

        /**
         * Sets [Builder.include] to an arbitrary JSON value.
         *
         * You should usually call [Builder.include] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun include(include: JsonField<List<String>>) = apply { body.include(include) }

        /**
         * Adds a single [String] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: String) = apply { body.addInclude(include) }

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
         * Configuration for input audio transcription. The client can optionally set the language
         * and prompt for transcription, these offer additional guidance to the transcription
         * service.
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
         * Returns an immutable instance of [TranscriptionSessionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TranscriptionSessionCreateParams =
            TranscriptionSessionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Realtime transcription session object configuration. */
    class Body
    private constructor(
        private val clientSecret: JsonField<ClientSecret>,
        private val include: JsonField<List<String>>,
        private val inputAudioFormat: JsonField<InputAudioFormat>,
        private val inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>,
        private val inputAudioTranscription: JsonField<InputAudioTranscription>,
        private val modalities: JsonField<List<Modality>>,
        private val turnDetection: JsonField<TurnDetection>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<ClientSecret> = JsonMissing.of(),
            @JsonProperty("include")
            @ExcludeMissing
            include: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("input_audio_format")
            @ExcludeMissing
            inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of(),
            @JsonProperty("input_audio_noise_reduction")
            @ExcludeMissing
            inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> = JsonMissing.of(),
            @JsonProperty("input_audio_transcription")
            @ExcludeMissing
            inputAudioTranscription: JsonField<InputAudioTranscription> = JsonMissing.of(),
            @JsonProperty("modalities")
            @ExcludeMissing
            modalities: JsonField<List<Modality>> = JsonMissing.of(),
            @JsonProperty("turn_detection")
            @ExcludeMissing
            turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
        ) : this(
            clientSecret,
            include,
            inputAudioFormat,
            inputAudioNoiseReduction,
            inputAudioTranscription,
            modalities,
            turnDetection,
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
         * The set of items to include in the transcription. Current available items are:
         * - `item.input_audio_transcription.logprobs`
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun include(): Optional<List<String>> = include.getOptional("include")

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
         * Configuration for input audio transcription. The client can optionally set the language
         * and prompt for transcription, these offer additional guidance to the transcription
         * service.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputAudioTranscription(): Optional<InputAudioTranscription> =
            inputAudioTranscription.getOptional("input_audio_transcription")

        /**
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun modalities(): Optional<List<Modality>> = modalities.getOptional("modalities")

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
         * Returns the raw JSON value of [clientSecret].
         *
         * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("client_secret")
        @ExcludeMissing
        fun _clientSecret(): JsonField<ClientSecret> = clientSecret

        /**
         * Returns the raw JSON value of [include].
         *
         * Unlike [include], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("include") @ExcludeMissing fun _include(): JsonField<List<String>> = include

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
         * Returns the raw JSON value of [modalities].
         *
         * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("modalities")
        @ExcludeMissing
        fun _modalities(): JsonField<List<Modality>> = modalities

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var clientSecret: JsonField<ClientSecret> = JsonMissing.of()
            private var include: JsonField<MutableList<String>>? = null
            private var inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of()
            private var inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> =
                JsonMissing.of()
            private var inputAudioTranscription: JsonField<InputAudioTranscription> =
                JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                clientSecret = body.clientSecret
                include = body.include.map { it.toMutableList() }
                inputAudioFormat = body.inputAudioFormat
                inputAudioNoiseReduction = body.inputAudioNoiseReduction
                inputAudioTranscription = body.inputAudioTranscription
                modalities = body.modalities.map { it.toMutableList() }
                turnDetection = body.turnDetection
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
             * The set of items to include in the transcription. Current available items are:
             * - `item.input_audio_transcription.logprobs`
             */
            fun include(include: List<String>) = include(JsonField.of(include))

            /**
             * Sets [Builder.include] to an arbitrary JSON value.
             *
             * You should usually call [Builder.include] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun include(include: JsonField<List<String>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.include].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInclude(include: String) = apply {
                this.include =
                    (this.include ?: JsonField.of(mutableListOf())).also {
                        checkKnown("include", it).add(include)
                    }
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
             * Configuration for input audio transcription. The client can optionally set the
             * language and prompt for transcription, these offer additional guidance to the
             * transcription service.
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
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    inputAudioFormat,
                    inputAudioNoiseReduction,
                    inputAudioTranscription,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    turnDetection,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            clientSecret().ifPresent { it.validate() }
            include()
            inputAudioFormat().ifPresent { it.validate() }
            inputAudioNoiseReduction().ifPresent { it.validate() }
            inputAudioTranscription().ifPresent { it.validate() }
            modalities().ifPresent { it.forEach { it.validate() } }
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
            (clientSecret.asKnown().getOrNull()?.validity() ?: 0) +
                (include.asKnown().getOrNull()?.size ?: 0) +
                (inputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioNoiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioTranscription.asKnown().getOrNull()?.validity() ?: 0) +
                (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && clientSecret == other.clientSecret && include == other.include && inputAudioFormat == other.inputAudioFormat && inputAudioNoiseReduction == other.inputAudioNoiseReduction && inputAudioTranscription == other.inputAudioTranscription && modalities == other.modalities && turnDetection == other.turnDetection && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(clientSecret, include, inputAudioFormat, inputAudioNoiseReduction, inputAudioTranscription, modalities, turnDetection, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{clientSecret=$clientSecret, include=$include, inputAudioFormat=$inputAudioFormat, inputAudioNoiseReduction=$inputAudioNoiseReduction, inputAudioTranscription=$inputAudioTranscription, modalities=$modalities, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
    }

    /** Configuration options for the generated client secret. */
    class ClientSecret
    private constructor(
        private val expiresAt: JsonField<ExpiresAt>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<ExpiresAt> = JsonMissing.of()
        ) : this(expiresAt, mutableMapOf())

        /**
         * Configuration for the ephemeral token expiration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun expiresAt(): Optional<ExpiresAt> = expiresAt.getOptional("expires_at")

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun _expiresAt(): JsonField<ExpiresAt> = expiresAt

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

            private var expiresAt: JsonField<ExpiresAt> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecret: ClientSecret) = apply {
                expiresAt = clientSecret.expiresAt
                additionalProperties = clientSecret.additionalProperties.toMutableMap()
            }

            /** Configuration for the ephemeral token expiration. */
            fun expiresAt(expiresAt: ExpiresAt) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [ExpiresAt] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<ExpiresAt>) = apply { this.expiresAt = expiresAt }

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
            fun build(): ClientSecret = ClientSecret(expiresAt, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ClientSecret = apply {
            if (validated) {
                return@apply
            }

            expiresAt().ifPresent { it.validate() }
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
        internal fun validity(): Int = (expiresAt.asKnown().getOrNull()?.validity() ?: 0)

        /** Configuration for the ephemeral token expiration. */
        class ExpiresAt
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun anchor(): Optional<Anchor> = anchor.getOptional("anchor")

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

                /** Returns a mutable builder for constructing an instance of [ExpiresAt]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ExpiresAt]. */
            class Builder internal constructor() {

                private var anchor: JsonField<Anchor> = JsonMissing.of()
                private var seconds: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(expiresAt: ExpiresAt) = apply {
                    anchor = expiresAt.anchor
                    seconds = expiresAt.seconds
                    additionalProperties = expiresAt.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [ExpiresAt].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ExpiresAt =
                    ExpiresAt(anchor, seconds, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ExpiresAt = apply {
                if (validated) {
                    return@apply
                }

                anchor().ifPresent { it.validate() }
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

                return /* spotless:off */ other is ExpiresAt && anchor == other.anchor && seconds == other.seconds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ExpiresAt{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ClientSecret && expiresAt == other.expiresAt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(expiresAt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecret{expiresAt=$expiresAt, additionalProperties=$additionalProperties}"
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
     * Configuration for input audio transcription. The client can optionally set the language and
     * prompt for transcription, these offer additional guidance to the transcription service.
     */
    class InputAudioTranscription
    private constructor(
        private val language: JsonField<String>,
        private val model: JsonField<Model>,
        private val prompt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
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
        fun model(): Optional<Model> = model.getOptional("model")

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
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

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
            private var model: JsonField<Model> = JsonMissing.of()
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
            model().ifPresent { it.validate() }
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
                (model.asKnown().getOrNull()?.validity() ?: 0) +
                (if (prompt.asKnown().isPresent) 1 else 0)

        /**
         * The model to use for transcription, current options are `gpt-4o-transcribe`,
         * `gpt-4o-mini-transcribe`, and `whisper-1`.
         */
        class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val GPT_4O_TRANSCRIBE = of("gpt-4o-transcribe")

                @JvmField val GPT_4O_MINI_TRANSCRIBE = of("gpt-4o-mini-transcribe")

                @JvmField val WHISPER_1 = of("whisper-1")

                @JvmStatic fun of(value: String) = Model(JsonField.of(value))
            }

            /** An enum containing [Model]'s known values. */
            enum class Known {
                GPT_4O_TRANSCRIBE,
                GPT_4O_MINI_TRANSCRIBE,
                WHISPER_1,
            }

            /**
             * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Model] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                GPT_4O_TRANSCRIBE,
                GPT_4O_MINI_TRANSCRIBE,
                WHISPER_1,
                /**
                 * An enum member indicating that [Model] was instantiated with an unknown value.
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
                    GPT_4O_TRANSCRIBE -> Value.GPT_4O_TRANSCRIBE
                    GPT_4O_MINI_TRANSCRIBE -> Value.GPT_4O_MINI_TRANSCRIBE
                    WHISPER_1 -> Value.WHISPER_1
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
                    GPT_4O_TRANSCRIBE -> Known.GPT_4O_TRANSCRIBE
                    GPT_4O_MINI_TRANSCRIBE -> Known.GPT_4O_MINI_TRANSCRIBE
                    WHISPER_1 -> Known.WHISPER_1
                    else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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
         * Whether or not to automatically generate a response when a VAD stop event occurs. Not
         * available for transcription sessions.
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
         * conversation (i.e. `conversation` of `auto`) when a VAD start event occurs. Not available
         * for transcription sessions.
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

            /**
             * Whether or not to automatically generate a response when a VAD stop event occurs. Not
             * available for transcription sessions.
             */
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
             * Not available for transcription sessions.
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionSessionCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "TranscriptionSessionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
