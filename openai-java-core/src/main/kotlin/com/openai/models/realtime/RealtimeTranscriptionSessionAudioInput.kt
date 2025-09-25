// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class RealtimeTranscriptionSessionAudioInput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val format: JsonField<RealtimeAudioFormats>,
    private val noiseReduction: JsonField<NoiseReduction>,
    private val transcription: JsonField<AudioTranscription>,
    private val turnDetection: JsonField<RealtimeTranscriptionSessionAudioInputTurnDetection>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<RealtimeAudioFormats> = JsonMissing.of(),
        @JsonProperty("noise_reduction")
        @ExcludeMissing
        noiseReduction: JsonField<NoiseReduction> = JsonMissing.of(),
        @JsonProperty("transcription")
        @ExcludeMissing
        transcription: JsonField<AudioTranscription> = JsonMissing.of(),
        @JsonProperty("turn_detection")
        @ExcludeMissing
        turnDetection: JsonField<RealtimeTranscriptionSessionAudioInputTurnDetection> =
            JsonMissing.of(),
    ) : this(format, noiseReduction, transcription, turnDetection, mutableMapOf())

    /**
     * The PCM audio format. Only a 24kHz sample rate is supported.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

    /**
     * Configuration for input audio noise reduction. This can be set to `null` to turn off. Noise
     * reduction filters audio added to the input audio buffer before it is sent to VAD and the
     * model. Filtering the audio can improve VAD and turn detection accuracy (reducing false
     * positives) and model performance by improving perception of the input audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun noiseReduction(): Optional<NoiseReduction> = noiseReduction.getOptional("noise_reduction")

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
    fun transcription(): Optional<AudioTranscription> = transcription.getOptional("transcription")

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
    fun turnDetection(): Optional<RealtimeTranscriptionSessionAudioInputTurnDetection> =
        turnDetection.getOptional("turn_detection")

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<RealtimeAudioFormats> = format

    /**
     * Returns the raw JSON value of [noiseReduction].
     *
     * Unlike [noiseReduction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("noise_reduction")
    @ExcludeMissing
    fun _noiseReduction(): JsonField<NoiseReduction> = noiseReduction

    /**
     * Returns the raw JSON value of [transcription].
     *
     * Unlike [transcription], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transcription")
    @ExcludeMissing
    fun _transcription(): JsonField<AudioTranscription> = transcription

    /**
     * Returns the raw JSON value of [turnDetection].
     *
     * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("turn_detection")
    @ExcludeMissing
    fun _turnDetection(): JsonField<RealtimeTranscriptionSessionAudioInputTurnDetection> =
        turnDetection

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
         * [RealtimeTranscriptionSessionAudioInput].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranscriptionSessionAudioInput]. */
    class Builder internal constructor() {

        private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
        private var noiseReduction: JsonField<NoiseReduction> = JsonMissing.of()
        private var transcription: JsonField<AudioTranscription> = JsonMissing.of()
        private var turnDetection: JsonField<RealtimeTranscriptionSessionAudioInputTurnDetection> =
            JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranscriptionSessionAudioInput: RealtimeTranscriptionSessionAudioInput
        ) = apply {
            format = realtimeTranscriptionSessionAudioInput.format
            noiseReduction = realtimeTranscriptionSessionAudioInput.noiseReduction
            transcription = realtimeTranscriptionSessionAudioInput.transcription
            turnDetection = realtimeTranscriptionSessionAudioInput.turnDetection
            additionalProperties =
                realtimeTranscriptionSessionAudioInput.additionalProperties.toMutableMap()
        }

        /** The PCM audio format. Only a 24kHz sample rate is supported. */
        fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
        fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
            format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`. */
        fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
            format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`. */
        fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
            format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

        /**
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         */
        fun noiseReduction(noiseReduction: NoiseReduction) =
            noiseReduction(JsonField.of(noiseReduction))

        /**
         * Sets [Builder.noiseReduction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.noiseReduction] with a well-typed [NoiseReduction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun noiseReduction(noiseReduction: JsonField<NoiseReduction>) = apply {
            this.noiseReduction = noiseReduction
        }

        /**
         * Configuration for input audio transcription, defaults to off and can be set to `null` to
         * turn off once on. Input audio transcription is not native to the model, since the model
         * consumes audio directly. Transcription runs asynchronously through
         * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
         * and should be treated as guidance of input audio content rather than precisely what the
         * model heard. The client can optionally set the language and prompt for transcription,
         * these offer additional guidance to the transcription service.
         */
        fun transcription(transcription: AudioTranscription) =
            transcription(JsonField.of(transcription))

        /**
         * Sets [Builder.transcription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcription] with a well-typed [AudioTranscription]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun transcription(transcription: JsonField<AudioTranscription>) = apply {
            this.transcription = transcription
        }

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
        fun turnDetection(turnDetection: RealtimeTranscriptionSessionAudioInputTurnDetection?) =
            turnDetection(JsonField.ofNullable(turnDetection))

        /** Alias for calling [Builder.turnDetection] with `turnDetection.orElse(null)`. */
        fun turnDetection(
            turnDetection: Optional<RealtimeTranscriptionSessionAudioInputTurnDetection>
        ) = turnDetection(turnDetection.getOrNull())

        /**
         * Sets [Builder.turnDetection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnDetection] with a well-typed
         * [RealtimeTranscriptionSessionAudioInputTurnDetection] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnDetection(
            turnDetection: JsonField<RealtimeTranscriptionSessionAudioInputTurnDetection>
        ) = apply { this.turnDetection = turnDetection }

        /**
         * Alias for calling [turnDetection] with
         * `RealtimeTranscriptionSessionAudioInputTurnDetection.ofServerVad(serverVad)`.
         */
        fun turnDetection(
            serverVad: RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad
        ) =
            turnDetection(
                RealtimeTranscriptionSessionAudioInputTurnDetection.ofServerVad(serverVad)
            )

        /**
         * Alias for calling [turnDetection] with
         * `RealtimeTranscriptionSessionAudioInputTurnDetection.ofSemanticVad(semanticVad)`.
         */
        fun turnDetection(
            semanticVad: RealtimeTranscriptionSessionAudioInputTurnDetection.SemanticVad
        ) =
            turnDetection(
                RealtimeTranscriptionSessionAudioInputTurnDetection.ofSemanticVad(semanticVad)
            )

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
         * Returns an immutable instance of [RealtimeTranscriptionSessionAudioInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeTranscriptionSessionAudioInput =
            RealtimeTranscriptionSessionAudioInput(
                format,
                noiseReduction,
                transcription,
                turnDetection,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTranscriptionSessionAudioInput = apply {
        if (validated) {
            return@apply
        }

        format().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (format.asKnown().getOrNull()?.validity() ?: 0) +
            (noiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
            (transcription.asKnown().getOrNull()?.validity() ?: 0) +
            (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Configuration for input audio noise reduction. This can be set to `null` to turn off. Noise
     * reduction filters audio added to the input audio buffer before it is sent to VAD and the
     * model. Filtering the audio can improve VAD and turn detection accuracy (reducing false
     * positives) and model performance by improving perception of the input audio.
     */
    class NoiseReduction
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

            /** Returns a mutable builder for constructing an instance of [NoiseReduction]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NoiseReduction]. */
        class Builder internal constructor() {

            private var type: JsonField<NoiseReductionType> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(noiseReduction: NoiseReduction) = apply {
                type = noiseReduction.type
                additionalProperties = noiseReduction.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [NoiseReduction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): NoiseReduction = NoiseReduction(type, additionalProperties.toMutableMap())
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
        @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranscriptionSessionAudioInput &&
            format == other.format &&
            noiseReduction == other.noiseReduction &&
            transcription == other.transcription &&
            turnDetection == other.turnDetection &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(format, noiseReduction, transcription, turnDetection, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranscriptionSessionAudioInput{format=$format, noiseReduction=$noiseReduction, transcription=$transcription, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
}
