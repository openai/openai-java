// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Generates audio from the input text. */
class AudioSpeechCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** The text to generate audio for. The maximum length is 4096 characters. */
    fun input(): String = body.input()

    /**
     * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1` or
     * `tts-1-hd`
     */
    fun model(): SpeechModel = body.model()

    /**
     * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
     * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are available
     * in the
     * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
     */
    fun voice(): Voice = body.voice()

    /**
     * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and `pcm`.
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

    /**
     * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the default.
     */
    fun speed(): Optional<Double> = body.speed()

    /** The text to generate audio for. The maximum length is 4096 characters. */
    fun _input(): JsonField<String> = body._input()

    /**
     * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1` or
     * `tts-1-hd`
     */
    fun _model(): JsonField<SpeechModel> = body._model()

    /**
     * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
     * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are available
     * in the
     * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
     */
    fun _voice(): JsonField<Voice> = body._voice()

    /**
     * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and `pcm`.
     */
    fun _responseFormat(): JsonField<ResponseFormat> = body._responseFormat()

    /**
     * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the default.
     */
    fun _speed(): JsonField<Double> = body._speed()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        private val input: JsonField<String> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<SpeechModel> = JsonMissing.of(),
        @JsonProperty("voice")
        @ExcludeMissing
        private val voice: JsonField<Voice> = JsonMissing.of(),
        @JsonProperty("response_format")
        @ExcludeMissing
        private val responseFormat: JsonField<ResponseFormat> = JsonMissing.of(),
        @JsonProperty("speed")
        @ExcludeMissing
        private val speed: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The text to generate audio for. The maximum length is 4096 characters. */
        fun input(): String = input.getRequired("input")

        /**
         * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1`
         * or `tts-1-hd`
         */
        fun model(): SpeechModel = model.getRequired("model")

        /**
         * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
         * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are
         * available in the
         * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
         */
        fun voice(): Voice = voice.getRequired("voice")

        /**
         * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and
         * `pcm`.
         */
        fun responseFormat(): Optional<ResponseFormat> =
            Optional.ofNullable(responseFormat.getNullable("response_format"))

        /**
         * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
         * default.
         */
        fun speed(): Optional<Double> = Optional.ofNullable(speed.getNullable("speed"))

        /** The text to generate audio for. The maximum length is 4096 characters. */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

        /**
         * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1`
         * or `tts-1-hd`
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<SpeechModel> = model

        /**
         * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
         * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are
         * available in the
         * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
         */
        @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

        /**
         * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and
         * `pcm`.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): JsonField<ResponseFormat> = responseFormat

        /**
         * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
         * default.
         */
        @JsonProperty("speed") @ExcludeMissing fun _speed(): JsonField<Double> = speed

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            input()
            model()
            voice()
            responseFormat()
            speed()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var input: JsonField<String>? = null
            private var model: JsonField<SpeechModel>? = null
            private var voice: JsonField<Voice>? = null
            private var responseFormat: JsonField<ResponseFormat> = JsonMissing.of()
            private var speed: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                input = body.input
                model = body.model
                voice = body.voice
                responseFormat = body.responseFormat
                speed = body.speed
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The text to generate audio for. The maximum length is 4096 characters. */
            fun input(input: String) = input(JsonField.of(input))

            /** The text to generate audio for. The maximum length is 4096 characters. */
            fun input(input: JsonField<String>) = apply { this.input = input }

            /**
             * One of the available [TTS models](https://platform.openai.com/docs/models#tts):
             * `tts-1` or `tts-1-hd`
             */
            fun model(model: SpeechModel) = model(JsonField.of(model))

            /**
             * One of the available [TTS models](https://platform.openai.com/docs/models#tts):
             * `tts-1` or `tts-1-hd`
             */
            fun model(model: JsonField<SpeechModel>) = apply { this.model = model }

            /**
             * One of the available [TTS models](https://platform.openai.com/docs/models#tts):
             * `tts-1` or `tts-1-hd`
             */
            fun model(value: String) = model(SpeechModel.of(value))

            /**
             * The voice to use when generating the audio. Supported voices are `alloy`, `ash`,
             * `coral`, `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the
             * voices are available in the
             * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
             */
            fun voice(voice: Voice) = voice(JsonField.of(voice))

            /**
             * The voice to use when generating the audio. Supported voices are `alloy`, `ash`,
             * `coral`, `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the
             * voices are available in the
             * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
             */
            fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

            /**
             * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`,
             * and `pcm`.
             */
            fun responseFormat(responseFormat: ResponseFormat) =
                responseFormat(JsonField.of(responseFormat))

            /**
             * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`,
             * and `pcm`.
             */
            fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
             * default.
             */
            fun speed(speed: Double) = speed(JsonField.of(speed))

            /**
             * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
             * default.
             */
            fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

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

            fun build(): Body =
                Body(
                    checkRequired("input", input),
                    checkRequired("model", model),
                    checkRequired("voice", voice),
                    responseFormat,
                    speed,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && input == other.input && model == other.model && voice == other.voice && responseFormat == other.responseFormat && speed == other.speed && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, model, voice, responseFormat, speed, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{input=$input, model=$model, voice=$voice, responseFormat=$responseFormat, speed=$speed, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AudioSpeechCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(audioSpeechCreateParams: AudioSpeechCreateParams) = apply {
            body = audioSpeechCreateParams.body.toBuilder()
            additionalHeaders = audioSpeechCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = audioSpeechCreateParams.additionalQueryParams.toBuilder()
        }

        /** The text to generate audio for. The maximum length is 4096 characters. */
        fun input(input: String) = apply { body.input(input) }

        /** The text to generate audio for. The maximum length is 4096 characters. */
        fun input(input: JsonField<String>) = apply { body.input(input) }

        /**
         * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1`
         * or `tts-1-hd`
         */
        fun model(model: SpeechModel) = apply { body.model(model) }

        /**
         * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1`
         * or `tts-1-hd`
         */
        fun model(model: JsonField<SpeechModel>) = apply { body.model(model) }

        /**
         * One of the available [TTS models](https://platform.openai.com/docs/models#tts): `tts-1`
         * or `tts-1-hd`
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
         * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are
         * available in the
         * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
         */
        fun voice(voice: Voice) = apply { body.voice(voice) }

        /**
         * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
         * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are
         * available in the
         * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
         */
        fun voice(voice: JsonField<Voice>) = apply { body.voice(voice) }

        /**
         * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and
         * `pcm`.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and
         * `pcm`.
         */
        fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
         * default.
         */
        fun speed(speed: Double) = apply { body.speed(speed) }

        /**
         * The speed of the generated audio. Select a value from `0.25` to `4.0`. `1.0` is the
         * default.
         */
        fun speed(speed: JsonField<Double>) = apply { body.speed(speed) }

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

        fun build(): AudioSpeechCreateParams =
            AudioSpeechCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * The voice to use when generating the audio. Supported voices are `alloy`, `ash`, `coral`,
     * `echo`, `fable`, `onyx`, `nova`, `sage` and `shimmer`. Previews of the voices are available
     * in the
     * [Text to speech guide](https://platform.openai.com/docs/guides/text-to-speech#voice-options).
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

            @JvmField val CORAL = of("coral")

            @JvmField val ECHO = of("echo")

            @JvmField val FABLE = of("fable")

            @JvmField val ONYX = of("onyx")

            @JvmField val NOVA = of("nova")

            @JvmField val SAGE = of("sage")

            @JvmField val SHIMMER = of("shimmer")

            @JvmStatic fun of(value: String) = Voice(JsonField.of(value))
        }

        /** An enum containing [Voice]'s known values. */
        enum class Known {
            ALLOY,
            ASH,
            CORAL,
            ECHO,
            FABLE,
            ONYX,
            NOVA,
            SAGE,
            SHIMMER,
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
            CORAL,
            ECHO,
            FABLE,
            ONYX,
            NOVA,
            SAGE,
            SHIMMER,
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
                CORAL -> Value.CORAL
                ECHO -> Value.ECHO
                FABLE -> Value.FABLE
                ONYX -> Value.ONYX
                NOVA -> Value.NOVA
                SAGE -> Value.SAGE
                SHIMMER -> Value.SHIMMER
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
                CORAL -> Known.CORAL
                ECHO -> Known.ECHO
                FABLE -> Known.FABLE
                ONYX -> Known.ONYX
                NOVA -> Known.NOVA
                SAGE -> Known.SAGE
                SHIMMER -> Known.SHIMMER
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Voice && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The format to audio in. Supported formats are `mp3`, `opus`, `aac`, `flac`, `wav`, and `pcm`.
     */
    class ResponseFormat @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val MP3 = of("mp3")

            @JvmField val OPUS = of("opus")

            @JvmField val AAC = of("aac")

            @JvmField val FLAC = of("flac")

            @JvmField val WAV = of("wav")

            @JvmField val PCM = of("pcm")

            @JvmStatic fun of(value: String) = ResponseFormat(JsonField.of(value))
        }

        /** An enum containing [ResponseFormat]'s known values. */
        enum class Known {
            MP3,
            OPUS,
            AAC,
            FLAC,
            WAV,
            PCM,
        }

        /**
         * An enum containing [ResponseFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ResponseFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MP3,
            OPUS,
            AAC,
            FLAC,
            WAV,
            PCM,
            /**
             * An enum member indicating that [ResponseFormat] was instantiated with an unknown
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
                MP3 -> Value.MP3
                OPUS -> Value.OPUS
                AAC -> Value.AAC
                FLAC -> Value.FLAC
                WAV -> Value.WAV
                PCM -> Value.PCM
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
                MP3 -> Known.MP3
                OPUS -> Known.OPUS
                AAC -> Known.AAC
                FLAC -> Known.FLAC
                WAV -> Known.WAV
                PCM -> Known.PCM
                else -> throw OpenAIInvalidDataException("Unknown ResponseFormat: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AudioSpeechCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "AudioSpeechCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
