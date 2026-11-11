// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

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
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when a transcription session is updated with a `transcription_session.update` event,
 * unless there is an error.
 */
class TranscriptionSessionUpdatedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val session: JsonField<Session>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, session, type, mutableMapOf())

    /**
     * The unique ID of the server event. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventId(): java.util.Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventIdOrThrow(): String = eventId.getRequired("event_id")

    /**
     * A new Realtime transcription session configuration.
     *
     * When a session is created on the server via REST API, the session object also contains an
     * ephemeral key. Default TTL for keys is 10 minutes. This property is not present when a
     * session is updated via the WebSocket API. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun session(): java.util.Optional<Session> = session.getOptional("session")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun sessionOrThrow(): Session = session.getRequired("session")

    /**
     * The event type, must be `transcription_session.updated`. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("transcription_session.updated")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "event_id" to this.eventId,
            "session" to this.session,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [TranscriptionSessionUpdatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSessionUpdatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var session: JsonField<Session>? = null
        private var type: JsonValue = JsonValue.from("transcription_session.updated")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionSessionUpdatedEvent: TranscriptionSessionUpdatedEvent) =
            apply {
                eventId = transcriptionSessionUpdatedEvent.eventId
                session = transcriptionSessionUpdatedEvent.session
                type = transcriptionSessionUpdatedEvent.type
                additionalProperties =
                    transcriptionSessionUpdatedEvent.additionalProperties.toMutableMap()
            }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * A new Realtime transcription session configuration.
         *
         * When a session is created on the server via REST API, the session object also contains an
         * ephemeral key. Default TTL for keys is 10 minutes. This property is not present when a
         * session is updated via the WebSocket API.
         */
        fun session(session: Session) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { this.session = session }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcription_session.updated")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [TranscriptionSessionUpdatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionSessionUpdatedEvent =
            TranscriptionSessionUpdatedEvent(
                checkRequired("eventId", eventId),
                checkRequired("session", session),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): TranscriptionSessionUpdatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventIdOrThrow()
        sessionOrThrow().validate()
        typeOrThrow()
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (session.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("transcription_session.updated")) 1 else 0 }

    /**
     * A new Realtime transcription session configuration.
     *
     * When a session is created on the server via REST API, the session object also contains an
     * ephemeral key. Default TTL for keys is 10 minutes. This property is not present when a
     * session is updated via the WebSocket API.
     */
    class Session
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val clientSecret: JsonField<ClientSecret>,
        private val inputAudioFormat: JsonField<String>,
        private val inputAudioTranscription: JsonField<AudioTranscription>,
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
            inputAudioTranscription: JsonField<AudioTranscription> = JsonMissing.of(),
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
         * Ephemeral key returned by the API. Only present when the session is created on the server
         * via REST API. The schema requires this property. Returns empty if the JSON property is
         * missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun clientSecret(): java.util.Optional<ClientSecret> =
            clientSecret.getOptional("client_secret")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun clientSecretOrThrow(): ClientSecret = clientSecret.getRequired("client_secret")

        /**
         * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. Returns
         * empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun inputAudioFormat(): java.util.Optional<String> =
            inputAudioFormat.getOptional("input_audio_format")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun inputAudioFormatOrThrow(): String = inputAudioFormat.getRequired("input_audio_format")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun inputAudioTranscription(): java.util.Optional<AudioTranscription> =
            inputAudioTranscription.getOptional("input_audio_transcription")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun inputAudioTranscriptionOrThrow(): AudioTranscription =
            inputAudioTranscription.getRequired("input_audio_transcription")

        /**
         * The set of modalities the model can respond with. To disable audio, set this to ["text"].
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun modalities(): java.util.Optional<List<Modality>> = modalities.getOptional("modalities")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun modalitiesOrThrow(): List<Modality> = modalities.getRequired("modalities")

        /**
         * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that
         * the model will detect the start and end of speech based on audio volume and respond at
         * the end of user speech. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun turnDetection(): java.util.Optional<TurnDetection> =
            turnDetection.getOptional("turn_detection")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun turnDetectionOrThrow(): TurnDetection = turnDetection.getRequired("turn_detection")

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
        fun _inputAudioFormat(): JsonField<String> = inputAudioFormat

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "client_secret" to this.clientSecret,
                "input_audio_format" to this.inputAudioFormat,
                "input_audio_transcription" to this.inputAudioTranscription,
                "modalities" to this.modalities,
                "turn_detection" to this.turnDetection,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Session].
             *
             * The following fields are required:
             * ```java
             * .clientSecret()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Session]. */
        class Builder internal constructor() {

            private var clientSecret: JsonField<ClientSecret>? = null
            private var inputAudioFormat: JsonField<String> = JsonMissing.of()
            private var inputAudioTranscription: JsonField<AudioTranscription> = JsonMissing.of()
            private var modalities: JsonField<MutableList<Modality>>? = null
            private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(session: Session) = apply {
                clientSecret = session.clientSecret
                inputAudioFormat = session.inputAudioFormat
                inputAudioTranscription = session.inputAudioTranscription
                modalities = session.modalities.map { it.toMutableList() }
                turnDetection = session.turnDetection
                additionalProperties = session.additionalProperties.toMutableMap()
            }

            /**
             * Ephemeral key returned by the API. Only present when the session is created on the
             * server via REST API.
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

            fun inputAudioTranscription(inputAudioTranscription: AudioTranscription) =
                inputAudioTranscription(JsonField.of(inputAudioTranscription))

            /**
             * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputAudioTranscription] with a well-typed
             * [AudioTranscription] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun inputAudioTranscription(inputAudioTranscription: JsonField<AudioTranscription>) =
                apply {
                    this.inputAudioTranscription = inputAudioTranscription
                }

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
                    (modalities?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                        .also { checkKnown("modalities", it).add(modality) }
            }

            /**
             * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means
             * that the model will detect the start and end of speech based on audio volume and
             * respond at the end of user speech.
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
             * Returns an immutable instance of [Session].
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
            fun build(): Session =
                Session(
                    checkRequired("clientSecret", clientSecret),
                    inputAudioFormat,
                    inputAudioTranscription,
                    (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                    turnDetection,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Session = apply {
            if (validated) {
                return@apply
            }

            clientSecretOrThrow().validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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
         * Ephemeral key returned by the API. Only present when the session is created on the server
         * via REST API.
         */
        class ClientSecret
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun expiresAt(): java.util.Optional<Long> = expiresAt.getOptional("expires_at")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun expiresAtOrThrow(): Long = expiresAt.getRequired("expires_at")

            /**
             * Ephemeral key usable in client environments to authenticate connections to the
             * Realtime API. Use this in client-side environments rather than a standard API token,
             * which should only be used server-side. The schema requires this property. Returns
             * empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun value(): java.util.Optional<String> = value.getOptional("value")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun valueOrThrow(): String = value.getRequired("value")

            /**
             * Returns the raw JSON value of [expiresAt].
             *
             * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("expires_at")
            @ExcludeMissing
            fun _expiresAt(): JsonField<Long> = expiresAt

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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "expires_at" to this.expiresAt,
                    "value" to this.value,
                )

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                 * Timestamp for when the token expires. Currently, all tokens expire after one
                 * minute.
                 */
                fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

                /**
                 * Sets [Builder.expiresAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.expiresAt] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

                /**
                 * Ephemeral key usable in client environments to authenticate connections to the
                 * Realtime API. Use this in client-side environments rather than a standard API
                 * token, which should only be used server-side.
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): ClientSecret = apply {
                if (validated) {
                    return@apply
                }

                expiresAtOrThrow()
                valueOrThrow()
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

                return other is ClientSecret &&
                    expiresAt == other.expiresAt &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(expiresAt, value, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ClientSecret{expiresAt=$expiresAt, value=$value, additionalProperties=$additionalProperties}"
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

        /**
         * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that
         * the model will detect the start and end of speech based on audio volume and respond at
         * the end of user speech.
         */
        class TurnDetection
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
             * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults
             * to 300ms. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun prefixPaddingMs(): java.util.Optional<Long> =
                prefixPaddingMs.getOptional("prefix_padding_ms")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun prefixPaddingMsOrThrow(): Long = prefixPaddingMs.getRequired("prefix_padding_ms")

            /**
             * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With
             * shorter values the model will respond more quickly, but may jump in on short pauses
             * from the user. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun silenceDurationMs(): java.util.Optional<Long> =
                silenceDurationMs.getOptional("silence_duration_ms")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun silenceDurationMsOrThrow(): Long =
                silenceDurationMs.getRequired("silence_duration_ms")

            /**
             * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold
             * will require louder audio to activate the model, and thus might perform better in
             * noisy environments. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun threshold(): java.util.Optional<Double> = threshold.getOptional("threshold")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun thresholdOrThrow(): Double = threshold.getRequired("threshold")

            /**
             * Type of turn detection, only `server_vad` is currently supported. Returns empty if
             * the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<String> = type.getOptional("type")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): String = type.getRequired("type")

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
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "prefix_padding_ms" to this.prefixPaddingMs,
                    "silence_duration_ms" to this.silenceDurationMs,
                    "threshold" to this.threshold,
                    "type" to this.type,
                )

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                 * Amount of audio to include before the VAD detected speech (in milliseconds).
                 * Defaults to 300ms.
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
                 * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms.
                 * With shorter values the model will respond more quickly, but may jump in on short
                 * pauses from the user.
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
                 * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher
                 * threshold will require louder audio to activate the model, and thus might perform
                 * better in noisy environments.
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

                /** Type of turn detection, only `server_vad` is currently supported. */
                fun type(type: String) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

            return other is Session &&
                clientSecret == other.clientSecret &&
                inputAudioFormat == other.inputAudioFormat &&
                inputAudioTranscription == other.inputAudioTranscription &&
                modalities == other.modalities &&
                turnDetection == other.turnDetection &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                clientSecret,
                inputAudioFormat,
                inputAudioTranscription,
                modalities,
                turnDetection,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Session{clientSecret=$clientSecret, inputAudioFormat=$inputAudioFormat, inputAudioTranscription=$inputAudioTranscription, modalities=$modalities, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionSessionUpdatedEvent &&
            eventId == other.eventId &&
            session == other.session &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(eventId, session, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSessionUpdatedEvent{eventId=$eventId, session=$session, type=$type, additionalProperties=$additionalProperties}"
}
