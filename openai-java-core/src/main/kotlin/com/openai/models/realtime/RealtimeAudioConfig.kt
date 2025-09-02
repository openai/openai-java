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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Configuration for input and output audio. */
class RealtimeAudioConfig
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

        /** Returns a mutable builder for constructing an instance of [RealtimeAudioConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeAudioConfig]. */
    class Builder internal constructor() {

        private var input: JsonField<Input> = JsonMissing.of()
        private var output: JsonField<Output> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeAudioConfig: RealtimeAudioConfig) = apply {
            input = realtimeAudioConfig.input
            output = realtimeAudioConfig.output
            additionalProperties = realtimeAudioConfig.additionalProperties.toMutableMap()
        }

        fun input(input: Input) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { this.input = input }

        fun output(output: Output) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed [Output] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [RealtimeAudioConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeAudioConfig =
            RealtimeAudioConfig(input, output, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RealtimeAudioConfig = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (input.asKnown().getOrNull()?.validity() ?: 0) +
            (output.asKnown().getOrNull()?.validity() ?: 0)

    class Input
    private constructor(
        private val format: JsonField<Format>,
        private val noiseReduction: JsonField<NoiseReduction>,
        private val transcription: JsonField<Transcription>,
        private val turnDetection: JsonField<TurnDetection>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
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
         * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
         * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
         * little-endian byte order.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<Format> = format.getOptional("format")

        /**
         * Configuration for input audio noise reduction. This can be set to `null` to turn off.
         * Noise reduction filters audio added to the input audio buffer before it is sent to VAD
         * and the model. Filtering the audio can improve VAD and turn detection accuracy (reducing
         * false positives) and model performance by improving perception of the input audio.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun noiseReduction(): Optional<NoiseReduction> =
            noiseReduction.getOptional("noise_reduction")

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
        fun transcription(): Optional<Transcription> = transcription.getOptional("transcription")

        /**
         * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to
         * `null` to turn off, in which case the client must manually trigger model response. Server
         * VAD means that the model will detect the start and end of speech based on audio volume
         * and respond at the end of user speech. Semantic VAD is more advanced and uses a turn
         * detection model (in conjunction with VAD) to semantically estimate whether the user has
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
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

        /**
         * Returns the raw JSON value of [noiseReduction].
         *
         * Unlike [noiseReduction], this method doesn't throw if the JSON field has an unexpected
         * type.
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

            private var format: JsonField<Format> = JsonMissing.of()
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

            /**
             * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
             * `pcm16`, input audio must be 16-bit PCM at a 24kHz sample rate, single channel
             * (mono), and little-endian byte order.
             */
            fun format(format: Format) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [Format] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<Format>) = apply { this.format = format }

            /**
             * Configuration for input audio noise reduction. This can be set to `null` to turn off.
             * Noise reduction filters audio added to the input audio buffer before it is sent to
             * VAD and the model. Filtering the audio can improve VAD and turn detection accuracy
             * (reducing false positives) and model performance by improving perception of the input
             * audio.
             */
            fun noiseReduction(noiseReduction: NoiseReduction) =
                noiseReduction(JsonField.of(noiseReduction))

            /**
             * Sets [Builder.noiseReduction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.noiseReduction] with a well-typed [NoiseReduction]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun noiseReduction(noiseReduction: JsonField<NoiseReduction>) = apply {
                this.noiseReduction = noiseReduction
            }

            /**
             * Configuration for input audio transcription, defaults to off and can be set to `null`
             * to turn off once on. Input audio transcription is not native to the model, since the
             * model consumes audio directly. Transcription runs asynchronously through
             * [the /audio/transcriptions endpoint](https://platform.openai.com/docs/api-reference/audio/createTranscription)
             * and should be treated as guidance of input audio content rather than precisely what
             * the model heard. The client can optionally set the language and prompt for
             * transcription, these offer additional guidance to the transcription service.
             */
            fun transcription(transcription: Transcription) =
                transcription(JsonField.of(transcription))

            /**
             * Sets [Builder.transcription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transcription] with a well-typed [Transcription]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun transcription(transcription: JsonField<Transcription>) = apply {
                this.transcription = transcription
            }

            /**
             * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set
             * to `null` to turn off, in which case the client must manually trigger model response.
             * Server VAD means that the model will detect the start and end of speech based on
             * audio volume and respond at the end of user speech. Semantic VAD is more advanced and
             * uses a turn detection model (in conjunction with VAD) to semantically estimate
             * whether the user has finished speaking, then dynamically sets a timeout based on this
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

        /**
         * The format of input audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For `pcm16`,
         * input audio must be 16-bit PCM at a 24kHz sample rate, single channel (mono), and
         * little-endian byte order.
         */
        class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmStatic fun of(value: String) = Format(JsonField.of(value))
            }

            /** An enum containing [Format]'s known values. */
            enum class Known {
                PCM16,
                G711_ULAW,
                G711_ALAW,
            }

            /**
             * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Format] can contain an unknown value in a couple of cases:
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
                 * An enum member indicating that [Format] was instantiated with an unknown value.
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
                    else -> throw OpenAIInvalidDataException("Unknown Format: $value")
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

            fun validate(): Format = apply {
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

                return other is Format && value == other.value
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
             * Type of noise reduction. `near_field` is for close-talking microphones such as
             * headphones, `far_field` is for far-field microphones such as laptop or conference
             * room microphones.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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

                /** Returns a mutable builder for constructing an instance of [NoiseReduction]. */
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

                /**
                 * Type of noise reduction. `near_field` is for close-talking microphones such as
                 * headphones, `far_field` is for far-field microphones such as laptop or conference
                 * room microphones.
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

            /**
             * Type of noise reduction. `near_field` is for close-talking microphones such as
             * headphones, `far_field` is for far-field microphones such as laptop or conference
             * room microphones.
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    NEAR_FIELD,
                    FAR_FIELD,
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

                return other is NoiseReduction &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "NoiseReduction{type=$type, additionalProperties=$additionalProperties}"
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
        class Transcription
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun language(): Optional<String> = language.getOptional("language")

            /**
             * The model to use for transcription. Current options are `whisper-1`,
             * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, `gpt-4o-transcribe`, and
             * `gpt-4o-transcribe-diarize`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<Model> = model.getOptional("model")

            /**
             * An optional text to guide the model's style or continue a previous audio segment. For
             * `whisper-1`, the
             * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
             * For `gpt-4o-transcribe` models, the prompt is a free text string, for example "expect
             * words related to technology".
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun prompt(): Optional<String> = prompt.getOptional("prompt")

            /**
             * Returns the raw JSON value of [language].
             *
             * Unlike [language], this method doesn't throw if the JSON field has an unexpected
             * type.
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

                /** Returns a mutable builder for constructing an instance of [Transcription]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Transcription]. */
            class Builder internal constructor() {

                private var language: JsonField<String> = JsonMissing.of()
                private var model: JsonField<Model> = JsonMissing.of()
                private var prompt: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(transcription: Transcription) = apply {
                    language = transcription.language
                    model = transcription.model
                    prompt = transcription.prompt
                    additionalProperties = transcription.additionalProperties.toMutableMap()
                }

                /**
                 * The language of the input audio. Supplying the input language in
                 * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`)
                 * format will improve accuracy and latency.
                 */
                fun language(language: String) = language(JsonField.of(language))

                /**
                 * Sets [Builder.language] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.language] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun language(language: JsonField<String>) = apply { this.language = language }

                /**
                 * The model to use for transcription. Current options are `whisper-1`,
                 * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, `gpt-4o-transcribe`, and
                 * `gpt-4o-transcribe-diarize`.
                 */
                fun model(model: Model) = model(JsonField.of(model))

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [Model] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<Model>) = apply { this.model = model }

                /**
                 * An optional text to guide the model's style or continue a previous audio segment.
                 * For `whisper-1`, the
                 * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
                 * For `gpt-4o-transcribe` models, the prompt is a free text string, for example
                 * "expect words related to technology".
                 */
                fun prompt(prompt: String) = prompt(JsonField.of(prompt))

                /**
                 * Sets [Builder.prompt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.prompt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
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
             * The model to use for transcription. Current options are `whisper-1`,
             * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, `gpt-4o-transcribe`, and
             * `gpt-4o-transcribe-diarize`.
             */
            class Model @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val WHISPER_1 = of("whisper-1")

                    @JvmField val GPT_4O_TRANSCRIBE_LATEST = of("gpt-4o-transcribe-latest")

                    @JvmField val GPT_4O_MINI_TRANSCRIBE = of("gpt-4o-mini-transcribe")

                    @JvmField val GPT_4O_TRANSCRIBE = of("gpt-4o-transcribe")

                    @JvmField val GPT_4O_TRANSCRIBE_DIARIZE = of("gpt-4o-transcribe-diarize")

                    @JvmStatic fun of(value: String) = Model(JsonField.of(value))
                }

                /** An enum containing [Model]'s known values. */
                enum class Known {
                    WHISPER_1,
                    GPT_4O_TRANSCRIBE_LATEST,
                    GPT_4O_MINI_TRANSCRIBE,
                    GPT_4O_TRANSCRIBE,
                    GPT_4O_TRANSCRIBE_DIARIZE,
                }

                /**
                 * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Model] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    WHISPER_1,
                    GPT_4O_TRANSCRIBE_LATEST,
                    GPT_4O_MINI_TRANSCRIBE,
                    GPT_4O_TRANSCRIBE,
                    GPT_4O_TRANSCRIBE_DIARIZE,
                    /**
                     * An enum member indicating that [Model] was instantiated with an unknown
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
                        WHISPER_1 -> Value.WHISPER_1
                        GPT_4O_TRANSCRIBE_LATEST -> Value.GPT_4O_TRANSCRIBE_LATEST
                        GPT_4O_MINI_TRANSCRIBE -> Value.GPT_4O_MINI_TRANSCRIBE
                        GPT_4O_TRANSCRIBE -> Value.GPT_4O_TRANSCRIBE
                        GPT_4O_TRANSCRIBE_DIARIZE -> Value.GPT_4O_TRANSCRIBE_DIARIZE
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
                        WHISPER_1 -> Known.WHISPER_1
                        GPT_4O_TRANSCRIBE_LATEST -> Known.GPT_4O_TRANSCRIBE_LATEST
                        GPT_4O_MINI_TRANSCRIBE -> Known.GPT_4O_MINI_TRANSCRIBE
                        GPT_4O_TRANSCRIBE -> Known.GPT_4O_TRANSCRIBE
                        GPT_4O_TRANSCRIBE_DIARIZE -> Known.GPT_4O_TRANSCRIBE_DIARIZE
                        else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

        /**
         * Configuration for turn detection, ether Server VAD or Semantic VAD. This can be set to
         * `null` to turn off, in which case the client must manually trigger model response. Server
         * VAD means that the model will detect the start and end of speech based on audio volume
         * and respond at the end of user speech. Semantic VAD is more advanced and uses a turn
         * detection model (in conjunction with VAD) to semantically estimate whether the user has
         * finished speaking, then dynamically sets a timeout based on this probability. For
         * example, if user audio trails off with "uhhm", the model will score a low probability of
         * turn end and wait longer for the user to continue speaking. This can be useful for more
         * natural conversations, but may have a higher latency.
         */
        class TurnDetection
        private constructor(
            private val createResponse: JsonField<Boolean>,
            private val eagerness: JsonField<Eagerness>,
            private val idleTimeoutMs: JsonField<Long>,
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
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(
                createResponse,
                eagerness,
                idleTimeoutMs,
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createResponse(): Optional<Boolean> = createResponse.getOptional("create_response")

            /**
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun eagerness(): Optional<Eagerness> = eagerness.getOptional("eagerness")

            /**
             * Optional idle timeout after which turn detection will auto-timeout when no additional
             * audio is received.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun idleTimeoutMs(): Optional<Long> = idleTimeoutMs.getOptional("idle_timeout_ms")

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
             * Type of turn detection.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

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
                private var idleTimeoutMs: JsonField<Long> = JsonMissing.of()
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
                    idleTimeoutMs = turnDetection.idleTimeoutMs
                    interruptResponse = turnDetection.interruptResponse
                    prefixPaddingMs = turnDetection.prefixPaddingMs
                    silenceDurationMs = turnDetection.silenceDurationMs
                    threshold = turnDetection.threshold
                    type = turnDetection.type
                    additionalProperties = turnDetection.additionalProperties.toMutableMap()
                }

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
                 * quickly. `auto` is the default and is equivalent to `medium`.
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
                 * Optional idle timeout after which turn detection will auto-timeout when no
                 * additional audio is received.
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

                /** Type of turn detection. */
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
                        createResponse,
                        eagerness,
                        idleTimeoutMs,
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
                idleTimeoutMs()
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
                    (if (idleTimeoutMs.asKnown().isPresent) 1 else 0) +
                    (if (interruptResponse.asKnown().isPresent) 1 else 0) +
                    (if (prefixPaddingMs.asKnown().isPresent) 1 else 0) +
                    (if (silenceDurationMs.asKnown().isPresent) 1 else 0) +
                    (if (threshold.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Used only for `semantic_vad` mode. The eagerness of the model to respond. `low` will
             * wait longer for the user to continue speaking, `high` will respond more quickly.
             * `auto` is the default and is equivalent to `medium`.
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

            /** Type of turn detection. */
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    SERVER_VAD,
                    SEMANTIC_VAD,
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
                        SEMANTIC_VAD -> Value.SEMANTIC_VAD
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
                        SEMANTIC_VAD -> Known.SEMANTIC_VAD
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
                    createResponse == other.createResponse &&
                    eagerness == other.eagerness &&
                    idleTimeoutMs == other.idleTimeoutMs &&
                    interruptResponse == other.interruptResponse &&
                    prefixPaddingMs == other.prefixPaddingMs &&
                    silenceDurationMs == other.silenceDurationMs &&
                    threshold == other.threshold &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    createResponse,
                    eagerness,
                    idleTimeoutMs,
                    interruptResponse,
                    prefixPaddingMs,
                    silenceDurationMs,
                    threshold,
                    type,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TurnDetection{createResponse=$createResponse, eagerness=$eagerness, idleTimeoutMs=$idleTimeoutMs, interruptResponse=$interruptResponse, prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, type=$type, additionalProperties=$additionalProperties}"
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
            Objects.hash(format, noiseReduction, transcription, turnDetection, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Input{format=$format, noiseReduction=$noiseReduction, transcription=$transcription, turnDetection=$turnDetection, additionalProperties=$additionalProperties}"
    }

    class Output
    private constructor(
        private val format: JsonField<Format>,
        private val speed: JsonField<Double>,
        private val voice: JsonField<Voice>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
            @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
        ) : this(format, speed, voice, mutableMapOf())

        /**
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
         * `pcm16`, output audio is sampled at a rate of 24kHz.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<Format> = format.getOptional("format")

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
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun voice(): Optional<Voice> = voice.getOptional("voice")

        /**
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

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

            private var format: JsonField<Format> = JsonMissing.of()
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

            /**
             * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
             * `pcm16`, output audio is sampled at a rate of 24kHz.
             */
            fun format(format: Format) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [Format] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<Format>) = apply { this.format = format }

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
             * The voice the model uses to respond. Voice cannot be changed during the session once
             * the model has responded with audio at least once. Current voice options are `alloy`,
             * `ash`, `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`.
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
             * Returns an immutable instance of [Output].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Output = Output(format, speed, voice, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Output = apply {
            if (validated) {
                return@apply
            }

            format().ifPresent { it.validate() }
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
            (format.asKnown().getOrNull()?.validity() ?: 0) +
                (if (speed.asKnown().isPresent) 1 else 0) +
                (if (voice.asKnown().isPresent) 1 else 0)

        /**
         * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. For
         * `pcm16`, output audio is sampled at a rate of 24kHz.
         */
        class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmStatic fun of(value: String) = Format(JsonField.of(value))
            }

            /** An enum containing [Format]'s known values. */
            enum class Known {
                PCM16,
                G711_ULAW,
                G711_ALAW,
            }

            /**
             * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Format] can contain an unknown value in a couple of cases:
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
                 * An enum member indicating that [Format] was instantiated with an unknown value.
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
                    else -> throw OpenAIInvalidDataException("Unknown Format: $value")
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

            fun validate(): Format = apply {
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

                return other is Format && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The voice the model uses to respond. Voice cannot be changed during the session once the
         * model has responded with audio at least once. Current voice options are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`.
         */
        class Voice @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
                 * An enum member indicating that [Voice] was instantiated with an unknown value.
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

        return other is RealtimeAudioConfig &&
            input == other.input &&
            output == other.output &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(input, output, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeAudioConfig{input=$input, output=$output, additionalProperties=$additionalProperties}"
}
