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
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioFormats
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A Realtime transcription session configuration object. */
class RealtimeTranscriptionSessionCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val type: JsonValue,
    private val audio: JsonField<Audio>,
    private val expiresAt: JsonField<Long>,
    private val include: JsonField<List<Include>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("include")
        @ExcludeMissing
        include: JsonField<List<Include>> = JsonMissing.of(),
    ) : this(id, object_, type, audio, expiresAt, include, mutableMapOf())

    /**
     * Unique identifier for the session that looks like `sess_1234567890abcdef`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The object type. Always `realtime.transcription_session`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * The type of session. Always `transcription` for transcription sessions.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcription")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Configuration for input audio for the session.
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
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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
         * .id()
         * .object_()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTranscriptionSessionCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("transcription")
        private var audio: JsonField<Audio> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var include: JsonField<MutableList<Include>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeTranscriptionSessionCreateResponse: RealtimeTranscriptionSessionCreateResponse
        ) = apply {
            id = realtimeTranscriptionSessionCreateResponse.id
            object_ = realtimeTranscriptionSessionCreateResponse.object_
            type = realtimeTranscriptionSessionCreateResponse.type
            audio = realtimeTranscriptionSessionCreateResponse.audio
            expiresAt = realtimeTranscriptionSessionCreateResponse.expiresAt
            include = realtimeTranscriptionSessionCreateResponse.include.map { it.toMutableList() }
            additionalProperties =
                realtimeTranscriptionSessionCreateResponse.additionalProperties.toMutableMap()
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

        /** The object type. Always `realtime.transcription_session`. */
        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcription")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Configuration for input audio for the session. */
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
         * .id()
         * .object_()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeTranscriptionSessionCreateResponse =
            RealtimeTranscriptionSessionCreateResponse(
                checkRequired("id", id),
                checkRequired("object_", object_),
                type,
                audio,
                expiresAt,
                (include ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTranscriptionSessionCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        object_()
        _type().let {
            if (it != JsonValue.from("transcription")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        audio().ifPresent { it.validate() }
        expiresAt()
        include().ifPresent { it.forEach { it.validate() } }
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
            (if (object_.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("transcription")) 1 else 0 } +
            (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Configuration for input audio for the session. */
    class Audio
    private constructor(
        private val input: JsonField<Input>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of()
        ) : this(input, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<Input> = input.getOptional("input")

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

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
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audio: Audio) = apply {
                input = audio.input
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
            fun build(): Audio = Audio(input, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Audio = apply {
            if (validated) {
                return@apply
            }

            input().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (input.asKnown().getOrNull()?.validity() ?: 0)

        class Input
        private constructor(
            private val format: JsonField<RealtimeAudioFormats>,
            private val noiseReduction: JsonField<NoiseReduction>,
            private val transcription: JsonField<AudioTranscription>,
            private val turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection>,
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
                turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection> =
                    JsonMissing.of(),
            ) : this(format, noiseReduction, transcription, turnDetection, mutableMapOf())

            /**
             * The PCM audio format. Only a 24kHz sample rate is supported.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

            /**
             * Configuration for input audio noise reduction.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun noiseReduction(): Optional<NoiseReduction> =
                noiseReduction.getOptional("noise_reduction")

            /**
             * Configuration of the transcription model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun transcription(): Optional<AudioTranscription> =
                transcription.getOptional("transcription")

            /**
             * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means
             * that the model will detect the start and end of speech based on audio volume and
             * respond at the end of user speech.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun turnDetection(): Optional<RealtimeTranscriptionSessionTurnDetection> =
                turnDetection.getOptional("turn_detection")

            /**
             * Returns the raw JSON value of [format].
             *
             * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("format")
            @ExcludeMissing
            fun _format(): JsonField<RealtimeAudioFormats> = format

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
            fun _transcription(): JsonField<AudioTranscription> = transcription

            /**
             * Returns the raw JSON value of [turnDetection].
             *
             * Unlike [turnDetection], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("turn_detection")
            @ExcludeMissing
            fun _turnDetection(): JsonField<RealtimeTranscriptionSessionTurnDetection> =
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

                /** Returns a mutable builder for constructing an instance of [Input]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Input]. */
            class Builder internal constructor() {

                private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
                private var noiseReduction: JsonField<NoiseReduction> = JsonMissing.of()
                private var transcription: JsonField<AudioTranscription> = JsonMissing.of()
                private var turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection> =
                    JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(input: Input) = apply {
                    format = input.format
                    noiseReduction = input.noiseReduction
                    transcription = input.transcription
                    turnDetection = input.turnDetection
                    additionalProperties = input.additionalProperties.toMutableMap()
                }

                /** The PCM audio format. Only a 24kHz sample rate is supported. */
                fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

                /**
                 * Sets [Builder.format] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

                /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
                fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
                    format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`.
                 */
                fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
                    format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

                /**
                 * Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`.
                 */
                fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
                    format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

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

                /** Configuration of the transcription model. */
                fun transcription(transcription: AudioTranscription) =
                    transcription(JsonField.of(transcription))

                /**
                 * Sets [Builder.transcription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transcription] with a well-typed
                 * [AudioTranscription] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun transcription(transcription: JsonField<AudioTranscription>) = apply {
                    this.transcription = transcription
                }

                /**
                 * Configuration for turn detection. Can be set to `null` to turn off. Server VAD
                 * means that the model will detect the start and end of speech based on audio
                 * volume and respond at the end of user speech.
                 */
                fun turnDetection(turnDetection: RealtimeTranscriptionSessionTurnDetection) =
                    turnDetection(JsonField.of(turnDetection))

                /**
                 * Sets [Builder.turnDetection] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.turnDetection] with a well-typed
                 * [RealtimeTranscriptionSessionTurnDetection] value instead. This method is
                 * primarily for setting the field to an undocumented or not yet supported value.
                 */
                fun turnDetection(
                    turnDetection: JsonField<RealtimeTranscriptionSessionTurnDetection>
                ) = apply { this.turnDetection = turnDetection }

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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (format.asKnown().getOrNull()?.validity() ?: 0) +
                    (noiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                    (transcription.asKnown().getOrNull()?.validity() ?: 0) +
                    (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

            /** Configuration for input audio noise reduction. */
            class NoiseReduction
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
                 * headphones, `far_field` is for far-field microphones such as laptop or conference
                 * room microphones.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<NoiseReductionType> = type.getOptional("type")

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type")
                @ExcludeMissing
                fun _type(): JsonField<NoiseReductionType> = type

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

                    private var type: JsonField<NoiseReductionType> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(noiseReduction: NoiseReduction) = apply {
                        type = noiseReduction.type
                        additionalProperties = noiseReduction.additionalProperties.toMutableMap()
                    }

                    /**
                     * Type of noise reduction. `near_field` is for close-talking microphones such
                     * as headphones, `far_field` is for far-field microphones such as laptop or
                     * conference room microphones.
                     */
                    fun type(type: NoiseReductionType) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [NoiseReductionType]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun type(type: JsonField<NoiseReductionType>) = apply { this.type = type }

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Audio &&
                input == other.input &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(input, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Audio{input=$input, additionalProperties=$additionalProperties}"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTranscriptionSessionCreateResponse &&
            id == other.id &&
            object_ == other.object_ &&
            type == other.type &&
            audio == other.audio &&
            expiresAt == other.expiresAt &&
            include == other.include &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, object_, type, audio, expiresAt, include, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTranscriptionSessionCreateResponse{id=$id, object_=$object_, type=$type, audio=$audio, expiresAt=$expiresAt, include=$include, additionalProperties=$additionalProperties}"
}
