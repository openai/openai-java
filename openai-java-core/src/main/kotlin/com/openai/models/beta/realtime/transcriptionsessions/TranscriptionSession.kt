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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A new Realtime transcription session configuration.
 *
 * When a session is created on the server via REST API, the session object also contains an
 * ephemeral key. Default TTL for keys is 10 minutes. This property is not present when a session is
 * updated via the WebSocket API.
 */
class TranscriptionSession
private constructor(
    private val clientSecret: JsonField<ClientSecret>,
    private val inputAudioFormat: JsonField<String>,
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
        @JsonProperty("input_audio_format")
        @ExcludeMissing
        inputAudioFormat: JsonField<String> = JsonMissing.of(),
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
        inputAudioFormat,
        inputAudioTranscription,
        modalities,
        turnDetection,
        mutableMapOf(),
    )

    /**
     * Ephemeral key returned by the API. Only present when the session is created on the server via
     * REST API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clientSecret(): ClientSecret = clientSecret.getRequired("client_secret")

    /**
     * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputAudioFormat(): Optional<String> = inputAudioFormat.getOptional("input_audio_format")

    /**
     * Configuration of the transcription model.
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
     * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that the
     * model will detect the start and end of speech based on audio volume and respond at the end of
     * user speech.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun turnDetection(): Optional<TurnDetection> = turnDetection.getOptional("turn_detection")

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
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
    fun _inputAudioFormat(): JsonField<String> = inputAudioFormat

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
         * Returns a mutable builder for constructing an instance of [TranscriptionSession].
         *
         * The following fields are required:
         * ```java
         * .clientSecret()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSession]. */
    class Builder internal constructor() {

        private var clientSecret: JsonField<ClientSecret>? = null
        private var inputAudioFormat: JsonField<String> = JsonMissing.of()
        private var inputAudioTranscription: JsonField<InputAudioTranscription> = JsonMissing.of()
        private var modalities: JsonField<MutableList<Modality>>? = null
        private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionSession: TranscriptionSession) = apply {
            clientSecret = transcriptionSession.clientSecret
            inputAudioFormat = transcriptionSession.inputAudioFormat
            inputAudioTranscription = transcriptionSession.inputAudioTranscription
            modalities = transcriptionSession.modalities.map { it.toMutableList() }
            turnDetection = transcriptionSession.turnDetection
            additionalProperties = transcriptionSession.additionalProperties.toMutableMap()
        }

        /**
         * Ephemeral key returned by the API. Only present when the session is created on the server
         * via REST API.
         */
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

        /** The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
        fun inputAudioFormat(inputAudioFormat: String) =
            inputAudioFormat(JsonField.of(inputAudioFormat))

        /**
         * Sets [Builder.inputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioFormat] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inputAudioFormat(inputAudioFormat: JsonField<String>) = apply {
            this.inputAudioFormat = inputAudioFormat
        }

        /** Configuration of the transcription model. */
        fun inputAudioTranscription(inputAudioTranscription: InputAudioTranscription) =
            inputAudioTranscription(JsonField.of(inputAudioTranscription))

        /**
         * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioTranscription] with a well-typed
         * [InputAudioTranscription] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun inputAudioTranscription(inputAudioTranscription: JsonField<InputAudioTranscription>) =
            apply {
                this.inputAudioTranscription = inputAudioTranscription
            }

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
         * Returns an immutable instance of [TranscriptionSession].
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
        fun build(): TranscriptionSession =
            TranscriptionSession(
                checkRequired("clientSecret", clientSecret),
                inputAudioFormat,
                inputAudioTranscription,
                (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                turnDetection,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionSession = apply {
        if (validated) {
            return@apply
        }

        clientSecret().validate()
        inputAudioFormat()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (clientSecret.asKnown().getOrNull()?.validity() ?: 0) +
            (if (inputAudioFormat.asKnown().isPresent) 1 else 0) +
            (inputAudioTranscription.asKnown().getOrNull()?.validity() ?: 0) +
            (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Ephemeral key returned by the API. Only present when the session is created on the server via
     * REST API.
     */
    class ClientSecret
    private constructor(
        private val expiresAt: JsonField<Long>,
        private val value: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
        ) : this(expiresAt, value, mutableMapOf())

        /**
         * Timestamp for when the token expires. Currently, all tokens expire after one minute.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun expiresAt(): Long = expiresAt.getRequired("expires_at")

        /**
         * Ephemeral key usable in client environments to authenticate connections to the Realtime
         * API. Use this in client-side environments rather than a standard API token, which should
         * only be used server-side.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun value(): String = value.getRequired("value")

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
             * Returns a mutable builder for constructing an instance of [ClientSecret].
             *
             * The following fields are required:
             * ```java
             * .expiresAt()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecret]. */
        class Builder internal constructor() {

            private var expiresAt: JsonField<Long>? = null
            private var value: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecret: ClientSecret) = apply {
                expiresAt = clientSecret.expiresAt
                value = clientSecret.value
                additionalProperties = clientSecret.additionalProperties.toMutableMap()
            }

            /**
             * Timestamp for when the token expires. Currently, all tokens expire after one minute.
             */
            fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

            /**
             * Ephemeral key usable in client environments to authenticate connections to the
             * Realtime API. Use this in client-side environments rather than a standard API token,
             * which should only be used server-side.
             */
            fun value(value: String) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun value(value: JsonField<String>) = apply { this.value = value }

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
             *
             * The following fields are required:
             * ```java
             * .expiresAt()
             * .value()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ClientSecret =
                ClientSecret(
                    checkRequired("expiresAt", expiresAt),
                    checkRequired("value", value),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ClientSecret = apply {
            if (validated) {
                return@apply
            }

            expiresAt()
            value()
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
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (value.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ClientSecret && expiresAt == other.expiresAt && value == other.value && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(expiresAt, value, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecret{expiresAt=$expiresAt, value=$value, additionalProperties=$additionalProperties}"
    }

    /** Configuration of the transcription model. */
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
         * The model to use for transcription. Can be `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * or `whisper-1`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<Model> = model.getOptional("model")

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
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
             * The model to use for transcription. Can be `gpt-4o-transcribe`,
             * `gpt-4o-mini-transcribe`, or `whisper-1`.
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
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should
             * match the audio language.
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
         * The model to use for transcription. Can be `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * or `whisper-1`.
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

            return /* spotless:off */ other is TurnDetection && prefixPaddingMs == other.prefixPaddingMs && silenceDurationMs == other.silenceDurationMs && threshold == other.threshold && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(prefixPaddingMs, silenceDurationMs, threshold, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TurnDetection{prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionSession && clientSecret == other.clientSecret && inputAudioFormat == other.inputAudioFormat && inputAudioTranscription == other.inputAudioTranscription && modalities == other.modalities && turnDetection == other.turnDetection && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(clientSecret, inputAudioFormat, inputAudioTranscription, modalities, turnDetection, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSession{clientSecret=$clientSecret, inputAudioFormat=$inputAudioFormat, inputAudioTranscription=$inputAudioTranscription, modalities=$modalities, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
}
