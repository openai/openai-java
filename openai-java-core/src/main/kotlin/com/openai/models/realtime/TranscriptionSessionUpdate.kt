// File generated from our OpenAPI spec by Stainless.

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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Send this event to update a transcription session. */
class TranscriptionSessionUpdate
private constructor(
    private val session: JsonField<Session>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(session, type, eventId, mutableMapOf())

    /**
     * Realtime transcription session object configuration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): Session = session.getRequired("session")

    /**
     * The event type, must be `transcription_session.update`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcription_session.update")
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
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
         * Returns a mutable builder for constructing an instance of [TranscriptionSessionUpdate].
         *
         * The following fields are required:
         * ```java
         * .session()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSessionUpdate]. */
    class Builder internal constructor() {

        private var session: JsonField<Session>? = null
        private var type: JsonValue = JsonValue.from("transcription_session.update")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionSessionUpdate: TranscriptionSessionUpdate) = apply {
            session = transcriptionSessionUpdate.session
            type = transcriptionSessionUpdate.type
            eventId = transcriptionSessionUpdate.eventId
            additionalProperties = transcriptionSessionUpdate.additionalProperties.toMutableMap()
        }

        /** Realtime transcription session object configuration. */
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
         * JsonValue.from("transcription_session.update")
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
         * Returns an immutable instance of [TranscriptionSessionUpdate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .session()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionSessionUpdate =
            TranscriptionSessionUpdate(
                checkRequired("session", session),
                type,
                eventId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionSessionUpdate = apply {
        if (validated) {
            return@apply
        }

        session().validate()
        _type().let {
            if (it != JsonValue.from("transcription_session.update")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
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
        (session.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("transcription_session.update")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    /** Realtime transcription session object configuration. */
    class Session
    private constructor(
        private val include: JsonField<List<Include>>,
        private val inputAudioFormat: JsonField<InputAudioFormat>,
        private val inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction>,
        private val inputAudioTranscription: JsonField<AudioTranscription>,
        private val turnDetection: JsonField<TurnDetection>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
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
            @JsonProperty("turn_detection")
            @ExcludeMissing
            turnDetection: JsonField<TurnDetection> = JsonMissing.of(),
        ) : this(
            include,
            inputAudioFormat,
            inputAudioNoiseReduction,
            inputAudioTranscription,
            turnDetection,
            mutableMapOf(),
        )

        /**
         * The set of items to include in the transcription. Current available items are:
         * `item.input_audio_transcription.logprobs`
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
        fun inputAudioTranscription(): Optional<AudioTranscription> =
            inputAudioTranscription.getOptional("input_audio_transcription")

        /**
         * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that
         * the model will detect the start and end of speech based on audio volume and respond at
         * the end of user speech.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun turnDetection(): Optional<TurnDetection> = turnDetection.getOptional("turn_detection")

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
        fun _inputAudioTranscription(): JsonField<AudioTranscription> = inputAudioTranscription

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

            /** Returns a mutable builder for constructing an instance of [Session]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Session]. */
        class Builder internal constructor() {

            private var include: JsonField<MutableList<Include>>? = null
            private var inputAudioFormat: JsonField<InputAudioFormat> = JsonMissing.of()
            private var inputAudioNoiseReduction: JsonField<InputAudioNoiseReduction> =
                JsonMissing.of()
            private var inputAudioTranscription: JsonField<AudioTranscription> = JsonMissing.of()
            private var turnDetection: JsonField<TurnDetection> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(session: Session) = apply {
                include = session.include.map { it.toMutableList() }
                inputAudioFormat = session.inputAudioFormat
                inputAudioNoiseReduction = session.inputAudioNoiseReduction
                inputAudioTranscription = session.inputAudioTranscription
                turnDetection = session.turnDetection
                additionalProperties = session.additionalProperties.toMutableMap()
            }

            /**
             * The set of items to include in the transcription. Current available items are:
             * `item.input_audio_transcription.logprobs`
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
             */
            fun build(): Session =
                Session(
                    (include ?: JsonMissing.of()).map { it.toImmutable() },
                    inputAudioFormat,
                    inputAudioNoiseReduction,
                    inputAudioTranscription,
                    turnDetection,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Session = apply {
            if (validated) {
                return@apply
            }

            include().ifPresent { it.forEach { it.validate() } }
            inputAudioFormat().ifPresent { it.validate() }
            inputAudioNoiseReduction().ifPresent { it.validate() }
            inputAudioTranscription().ifPresent { it.validate() }
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
            (include.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (inputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioNoiseReduction.asKnown().getOrNull()?.validity() ?: 0) +
                (inputAudioTranscription.asKnown().getOrNull()?.validity() ?: 0) +
                (turnDetection.asKnown().getOrNull()?.validity() ?: 0)

        class Include @JsonCreator private constructor(private val value: JsonField<String>) :
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS,
                /**
                 * An enum member indicating that [Include] was instantiated with an unknown value.
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
                    ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                        Value.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
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
                    ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS ->
                        Known.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                    else -> throw OpenAIInvalidDataException("Unknown Include: $value")
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
        class InputAudioFormat
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

                @JvmStatic fun of(value: String) = InputAudioFormat(JsonField.of(value))
            }

            /** An enum containing [InputAudioFormat]'s known values. */
            enum class Known {
                PCM16,
                G711_ULAW,
                G711_ALAW,
            }

            /**
             * An enum containing [InputAudioFormat]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [InputAudioFormat] can contain an unknown value in a couple of cases:
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
                 * An enum member indicating that [InputAudioFormat] was instantiated with an
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
                    else -> throw OpenAIInvalidDataException("Unknown InputAudioFormat: $value")
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
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         */
        class InputAudioNoiseReduction
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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
                 * Returns a mutable builder for constructing an instance of
                 * [InputAudioNoiseReduction].
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
                    additionalProperties =
                        inputAudioNoiseReduction.additionalProperties.toMutableMap()
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
                 * You should usually call [Builder.type] with a well-typed [NoiseReductionType]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
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
            @JvmSynthetic
            internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

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
         * Configuration for turn detection. Can be set to `null` to turn off. Server VAD means that
         * the model will detect the start and end of speech based on audio volume and respond at
         * the end of user speech.
         */
        class TurnDetection
        private constructor(
            private val prefixPaddingMs: JsonField<Long>,
            private val silenceDurationMs: JsonField<Long>,
            private val threshold: JsonField<Double>,
            private val type: JsonField<Type>,
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
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(prefixPaddingMs, silenceDurationMs, threshold, type, mutableMapOf())

            /**
             * Amount of audio to include before the VAD detected speech (in milliseconds). Defaults
             * to 300ms.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun prefixPaddingMs(): Optional<Long> = prefixPaddingMs.getOptional("prefix_padding_ms")

            /**
             * Duration of silence to detect speech stop (in milliseconds). Defaults to 500ms. With
             * shorter values the model will respond more quickly, but may jump in on short pauses
             * from the user.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun silenceDurationMs(): Optional<Long> =
                silenceDurationMs.getOptional("silence_duration_ms")

            /**
             * Activation threshold for VAD (0.0 to 1.0), this defaults to 0.5. A higher threshold
             * will require louder audio to activate the model, and thus might perform better in
             * noisy environments.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun threshold(): Optional<Double> = threshold.getOptional("threshold")

            /**
             * Type of turn detection. Only `server_vad` is currently supported for transcription
             * sessions.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

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

                private var prefixPaddingMs: JsonField<Long> = JsonMissing.of()
                private var silenceDurationMs: JsonField<Long> = JsonMissing.of()
                private var threshold: JsonField<Double> = JsonMissing.of()
                private var type: JsonField<Type> = JsonMissing.of()
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

                /**
                 * Type of turn detection. Only `server_vad` is currently supported for
                 * transcription sessions.
                 */
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
                (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                    (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                    (if (threshold.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Type of turn detection. Only `server_vad` is currently supported for transcription
             * sessions.
             */
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

                    @JvmField val SERVER_VAD = of("server_vad")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    SERVER_VAD
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
                    SERVER_VAD,
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
                        SERVER_VAD -> Value.SERVER_VAD
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
                        SERVER_VAD -> Known.SERVER_VAD
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
                include == other.include &&
                inputAudioFormat == other.inputAudioFormat &&
                inputAudioNoiseReduction == other.inputAudioNoiseReduction &&
                inputAudioTranscription == other.inputAudioTranscription &&
                turnDetection == other.turnDetection &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                include,
                inputAudioFormat,
                inputAudioNoiseReduction,
                inputAudioTranscription,
                turnDetection,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Session{include=$include, inputAudioFormat=$inputAudioFormat, inputAudioNoiseReduction=$inputAudioNoiseReduction, inputAudioTranscription=$inputAudioTranscription, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionSessionUpdate &&
            session == other.session &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(session, type, eventId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSessionUpdate{session=$session, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
