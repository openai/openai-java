// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.clientsecrets

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
class RealtimeTranscriptionSessionCreateResponse
private constructor(
    private val clientSecret: JsonField<RealtimeTranscriptionSessionClientSecret>,
    private val inputAudioFormat: JsonField<String>,
    private val inputAudioTranscription:
        JsonField<RealtimeTranscriptionSessionInputAudioTranscription>,
    private val modalities: JsonField<List<Modality>>,
    private val turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("client_secret")
        @ExcludeMissing
        clientSecret: JsonField<RealtimeTranscriptionSessionClientSecret> = JsonMissing.of(),
        @JsonProperty("input_audio_format")
        @ExcludeMissing
        inputAudioFormat: JsonField<String> = JsonMissing.of(),
        @JsonProperty("input_audio_transcription")
        @ExcludeMissing
        inputAudioTranscription: JsonField<RealtimeTranscriptionSessionInputAudioTranscription> =
            JsonMissing.of(),
        @JsonProperty("modalities")
        @ExcludeMissing
        modalities: JsonField<List<Modality>> = JsonMissing.of(),
        @JsonProperty("turn_detection")
        @ExcludeMissing
        turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection> = JsonMissing.of(),
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
    fun clientSecret(): RealtimeTranscriptionSessionClientSecret =
        clientSecret.getRequired("client_secret")

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
    fun inputAudioTranscription(): Optional<RealtimeTranscriptionSessionInputAudioTranscription> =
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
    fun turnDetection(): Optional<RealtimeTranscriptionSessionTurnDetection> =
        turnDetection.getOptional("turn_detection")

    /**
     * Returns the raw JSON value of [clientSecret].
     *
     * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_secret")
    @ExcludeMissing
    fun _clientSecret(): JsonField<RealtimeTranscriptionSessionClientSecret> = clientSecret

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
    fun _inputAudioTranscription(): JsonField<RealtimeTranscriptionSessionInputAudioTranscription> =
        inputAudioTranscription

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
    fun _turnDetection(): JsonField<RealtimeTranscriptionSessionTurnDetection> = turnDetection

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
         * [RealtimeTranscriptionSessionCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .clientSecret()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranscriptionSessionCreateResponse]. */
    class Builder internal constructor() {

        private var clientSecret: JsonField<RealtimeTranscriptionSessionClientSecret>? = null
        private var inputAudioFormat: JsonField<String> = JsonMissing.of()
        private var inputAudioTranscription:
            JsonField<RealtimeTranscriptionSessionInputAudioTranscription> =
            JsonMissing.of()
        private var modalities: JsonField<MutableList<Modality>>? = null
        private var turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection> =
            JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranscriptionSessionCreateResponse: RealtimeTranscriptionSessionCreateResponse
        ) = apply {
            clientSecret = realtimeTranscriptionSessionCreateResponse.clientSecret
            inputAudioFormat = realtimeTranscriptionSessionCreateResponse.inputAudioFormat
            inputAudioTranscription =
                realtimeTranscriptionSessionCreateResponse.inputAudioTranscription
            modalities =
                realtimeTranscriptionSessionCreateResponse.modalities.map { it.toMutableList() }
            turnDetection = realtimeTranscriptionSessionCreateResponse.turnDetection
            additionalProperties =
                realtimeTranscriptionSessionCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Ephemeral key returned by the API. Only present when the session is created on the server
         * via REST API.
         */
        fun clientSecret(clientSecret: RealtimeTranscriptionSessionClientSecret) =
            clientSecret(JsonField.of(clientSecret))

        /**
         * Sets [Builder.clientSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientSecret] with a well-typed
         * [RealtimeTranscriptionSessionClientSecret] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun clientSecret(clientSecret: JsonField<RealtimeTranscriptionSessionClientSecret>) =
            apply {
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
        fun inputAudioTranscription(
            inputAudioTranscription: RealtimeTranscriptionSessionInputAudioTranscription
        ) = inputAudioTranscription(JsonField.of(inputAudioTranscription))

        /**
         * Sets [Builder.inputAudioTranscription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputAudioTranscription] with a well-typed
         * [RealtimeTranscriptionSessionInputAudioTranscription] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun inputAudioTranscription(
            inputAudioTranscription: JsonField<RealtimeTranscriptionSessionInputAudioTranscription>
        ) = apply { this.inputAudioTranscription = inputAudioTranscription }

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
        fun turnDetection(turnDetection: RealtimeTranscriptionSessionTurnDetection) =
            turnDetection(JsonField.of(turnDetection))

        /**
         * Sets [Builder.turnDetection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnDetection] with a well-typed
         * [RealtimeTranscriptionSessionTurnDetection] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun turnDetection(turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection>) =
            apply {
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
         * Returns an immutable instance of [RealtimeTranscriptionSessionCreateResponse].
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
        fun build(): RealtimeTranscriptionSessionCreateResponse =
            RealtimeTranscriptionSessionCreateResponse(
                checkRequired("clientSecret", clientSecret),
                inputAudioFormat,
                inputAudioTranscription,
                (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                turnDetection,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTranscriptionSessionCreateResponse = apply {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranscriptionSessionCreateResponse &&
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
        "RealtimeTranscriptionSessionCreateResponse{clientSecret=$clientSecret, inputAudioFormat=$inputAudioFormat, inputAudioTranscription=$inputAudioTranscription, modalities=$modalities, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
}
