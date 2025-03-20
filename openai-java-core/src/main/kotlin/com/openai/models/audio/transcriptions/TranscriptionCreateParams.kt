// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.MultipartField
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name

/** Transcribes audio into the input language. */
class TranscriptionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3, mp4,
     * mpeg, mpga, m4a, ogg, wav, or webm.
     */
    fun file(): InputStream = body.file()

    /**
     * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`, and
     * `whisper-1` (which is powered by our open source Whisper V2 model).
     */
    fun model(): AudioModel = body.model()

    /**
     * Additional information to include in the transcription response. `logprobs` will return the
     * log probabilities of the tokens in the response to understand the model's confidence in the
     * transcription. `logprobs` only works with response_format set to `json` and only with the
     * models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
     */
    fun include(): Optional<List<TranscriptionInclude>> = body.include()

    /**
     * The language of the input audio. Supplying the input language in
     * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format will
     * improve accuracy and latency.
     */
    fun language(): Optional<String> = body.language()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match the
     * audio language.
     */
    fun prompt(): Optional<String> = body.prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format is
     * `json`.
     */
    fun responseFormat(): Optional<AudioResponseFormat> = body.responseFormat()

    /**
     * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output more
     * random, while lower values like 0.2 will make it more focused and deterministic. If set to 0,
     * the model will use [log probability](https://en.wikipedia.org/wiki/Log_probability) to
     * automatically increase the temperature until certain thresholds are hit.
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * The timestamp granularities to populate for this transcription. `response_format` must be set
     * `verbose_json` to use timestamp granularities. Either or both of these options are supported:
     * `word`, or `segment`. Note: There is no additional latency for segment timestamps, but
     * generating word timestamps incurs additional latency.
     */
    fun timestampGranularities(): Optional<List<TimestampGranularity>> =
        body.timestampGranularities()

    /**
     * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3, mp4,
     * mpeg, mpga, m4a, ogg, wav, or webm.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`, and
     * `whisper-1` (which is powered by our open source Whisper V2 model).
     */
    fun _model(): MultipartField<AudioModel> = body._model()

    /**
     * Additional information to include in the transcription response. `logprobs` will return the
     * log probabilities of the tokens in the response to understand the model's confidence in the
     * transcription. `logprobs` only works with response_format set to `json` and only with the
     * models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
     */
    fun _include(): MultipartField<List<TranscriptionInclude>> = body._include()

    /**
     * The language of the input audio. Supplying the input language in
     * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format will
     * improve accuracy and latency.
     */
    fun _language(): MultipartField<String> = body._language()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match the
     * audio language.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format is
     * `json`.
     */
    fun _responseFormat(): MultipartField<AudioResponseFormat> = body._responseFormat()

    /**
     * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output more
     * random, while lower values like 0.2 will make it more focused and deterministic. If set to 0,
     * the model will use [log probability](https://en.wikipedia.org/wiki/Log_probability) to
     * automatically increase the temperature until certain thresholds are hit.
     */
    fun _temperature(): MultipartField<Double> = body._temperature()

    /**
     * The timestamp granularities to populate for this transcription. `response_format` must be set
     * `verbose_json` to use timestamp granularities. Either or both of these options are supported:
     * `word`, or `segment`. Note: There is no additional latency for segment timestamps, but
     * generating word timestamps incurs additional latency.
     */
    fun _timestampGranularities(): MultipartField<List<TimestampGranularity>> =
        body._timestampGranularities()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "file" to _file(),
                "model" to _model(),
                "include" to _include(),
                "language" to _language(),
                "prompt" to _prompt(),
                "response_format" to _responseFormat(),
                "temperature" to _temperature(),
                "timestamp_granularities" to _timestampGranularities(),
            )
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        private val file: MultipartField<InputStream>,
        private val model: MultipartField<AudioModel>,
        private val include: MultipartField<List<TranscriptionInclude>>,
        private val language: MultipartField<String>,
        private val prompt: MultipartField<String>,
        private val responseFormat: MultipartField<AudioResponseFormat>,
        private val temperature: MultipartField<Double>,
        private val timestampGranularities: MultipartField<List<TimestampGranularity>>,
    ) {

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * and `whisper-1` (which is powered by our open source Whisper V2 model).
         */
        fun model(): AudioModel = model.value.getRequired("model")

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         */
        fun include(): Optional<List<TranscriptionInclude>> =
            Optional.ofNullable(include.value.getNullable("include"))

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         */
        fun language(): Optional<String> =
            Optional.ofNullable(language.value.getNullable("language"))

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         */
        fun prompt(): Optional<String> = Optional.ofNullable(prompt.value.getNullable("prompt"))

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format
         * is `json`.
         */
        fun responseFormat(): Optional<AudioResponseFormat> =
            Optional.ofNullable(responseFormat.value.getNullable("response_format"))

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        fun temperature(): Optional<Double> =
            Optional.ofNullable(temperature.value.getNullable("temperature"))

        /**
         * The timestamp granularities to populate for this transcription. `response_format` must be
         * set `verbose_json` to use timestamp granularities. Either or both of these options are
         * supported: `word`, or `segment`. Note: There is no additional latency for segment
         * timestamps, but generating word timestamps incurs additional latency.
         */
        fun timestampGranularities(): Optional<List<TimestampGranularity>> =
            Optional.ofNullable(timestampGranularities.value.getNullable("timestamp_granularities"))

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun _file(): MultipartField<InputStream> = file

        /**
         * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * and `whisper-1` (which is powered by our open source Whisper V2 model).
         */
        fun _model(): MultipartField<AudioModel> = model

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         */
        fun _include(): MultipartField<List<TranscriptionInclude>> = include

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         */
        fun _language(): MultipartField<String> = language

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         */
        fun _prompt(): MultipartField<String> = prompt

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format
         * is `json`.
         */
        fun _responseFormat(): MultipartField<AudioResponseFormat> = responseFormat

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        fun _temperature(): MultipartField<Double> = temperature

        /**
         * The timestamp granularities to populate for this transcription. `response_format` must be
         * set `verbose_json` to use timestamp granularities. Either or both of these options are
         * supported: `word`, or `segment`. Note: There is no additional latency for segment
         * timestamps, but generating word timestamps incurs additional latency.
         */
        fun _timestampGranularities(): MultipartField<List<TimestampGranularity>> =
            timestampGranularities

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            model()
            include()
            language()
            prompt()
            responseFormat()
            temperature()
            timestampGranularities()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .file()
             * .model()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream>? = null
            private var model: MultipartField<AudioModel>? = null
            private var include: MultipartField<MutableList<TranscriptionInclude>>? = null
            private var language: MultipartField<String> = MultipartField.of(null)
            private var prompt: MultipartField<String> = MultipartField.of(null)
            private var responseFormat: MultipartField<AudioResponseFormat> =
                MultipartField.of(null)
            private var temperature: MultipartField<Double> = MultipartField.of(null)
            private var timestampGranularities: MultipartField<MutableList<TimestampGranularity>>? =
                null

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                model = body.model
                include = body.include.map { it.toMutableList() }
                language = body.language
                prompt = body.prompt
                responseFormat = body.responseFormat
                temperature = body.temperature
                timestampGranularities = body.timestampGranularities.map { it.toMutableList() }
            }

            /**
             * The audio file object (not file name) to transcribe, in one of these formats: flac,
             * mp3, mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * The audio file object (not file name) to transcribe, in one of these formats: flac,
             * mp3, mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * The audio file object (not file name) to transcribe, in one of these formats: flac,
             * mp3, mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: ByteArray) = file(ByteArrayInputStream(file))

            /**
             * The audio file object (not file name) to transcribe, in one of these formats: flac,
             * mp3, mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /**
             * ID of the model to use. The options are `gpt-4o-transcribe`,
             * `gpt-4o-mini-transcribe`, and `whisper-1` (which is powered by our open source
             * Whisper V2 model).
             */
            fun model(model: AudioModel) = model(MultipartField.of(model))

            /**
             * ID of the model to use. The options are `gpt-4o-transcribe`,
             * `gpt-4o-mini-transcribe`, and `whisper-1` (which is powered by our open source
             * Whisper V2 model).
             */
            fun model(model: MultipartField<AudioModel>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [AudioModel] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(value: String) = model(AudioModel.of(value))

            /**
             * Additional information to include in the transcription response. `logprobs` will
             * return the log probabilities of the tokens in the response to understand the model's
             * confidence in the transcription. `logprobs` only works with response_format set to
             * `json` and only with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
             */
            fun include(include: List<TranscriptionInclude>) = include(MultipartField.of(include))

            /**
             * Additional information to include in the transcription response. `logprobs` will
             * return the log probabilities of the tokens in the response to understand the model's
             * confidence in the transcription. `logprobs` only works with response_format set to
             * `json` and only with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
             */
            fun include(include: MultipartField<List<TranscriptionInclude>>) = apply {
                this.include = include.map { it.toMutableList() }
            }

            /**
             * Adds a single [TranscriptionInclude] to [Builder.include].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInclude(include: TranscriptionInclude) = apply {
                this.include =
                    (this.include ?: MultipartField.of(mutableListOf())).also {
                        checkKnown("include", it).add(include)
                    }
            }

            /**
             * The language of the input audio. Supplying the input language in
             * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
             * will improve accuracy and latency.
             */
            fun language(language: String) = language(MultipartField.of(language))

            /**
             * The language of the input audio. Supplying the input language in
             * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
             * will improve accuracy and latency.
             */
            fun language(language: MultipartField<String>) = apply { this.language = language }

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should
             * match the audio language.
             */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should
             * match the audio language.
             */
            fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

            /**
             * The format of the output, in one of these options: `json`, `text`, `srt`,
             * `verbose_json`, or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the
             * only supported format is `json`.
             */
            fun responseFormat(responseFormat: AudioResponseFormat) =
                responseFormat(MultipartField.of(responseFormat))

            /**
             * The format of the output, in one of these options: `json`, `text`, `srt`,
             * `verbose_json`, or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the
             * only supported format is `json`.
             */
            fun responseFormat(responseFormat: MultipartField<AudioResponseFormat>) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the
             * output more random, while lower values like 0.2 will make it more focused and
             * deterministic. If set to 0, the model will use
             * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
             * increase the temperature until certain thresholds are hit.
             */
            fun temperature(temperature: Double) = temperature(MultipartField.of(temperature))

            /**
             * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the
             * output more random, while lower values like 0.2 will make it more focused and
             * deterministic. If set to 0, the model will use
             * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
             * increase the temperature until certain thresholds are hit.
             */
            fun temperature(temperature: MultipartField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * The timestamp granularities to populate for this transcription. `response_format`
             * must be set `verbose_json` to use timestamp granularities. Either or both of these
             * options are supported: `word`, or `segment`. Note: There is no additional latency for
             * segment timestamps, but generating word timestamps incurs additional latency.
             */
            fun timestampGranularities(timestampGranularities: List<TimestampGranularity>) =
                timestampGranularities(MultipartField.of(timestampGranularities))

            /**
             * The timestamp granularities to populate for this transcription. `response_format`
             * must be set `verbose_json` to use timestamp granularities. Either or both of these
             * options are supported: `word`, or `segment`. Note: There is no additional latency for
             * segment timestamps, but generating word timestamps incurs additional latency.
             */
            fun timestampGranularities(
                timestampGranularities: MultipartField<List<TimestampGranularity>>
            ) = apply {
                this.timestampGranularities = timestampGranularities.map { it.toMutableList() }
            }

            /**
             * Adds a single [TimestampGranularity] to [timestampGranularities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTimestampGranularity(timestampGranularity: TimestampGranularity) = apply {
                timestampGranularities =
                    (timestampGranularities ?: MultipartField.of(mutableListOf())).also {
                        checkKnown("timestampGranularities", it).add(timestampGranularity)
                    }
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .file()
             * .model()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("file", file),
                    checkRequired("model", model),
                    (include ?: MultipartField.of(null)).map { it.toImmutable() },
                    language,
                    prompt,
                    responseFormat,
                    temperature,
                    (timestampGranularities ?: MultipartField.of(null)).map { it.toImmutable() },
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file && model == other.model && include == other.include && language == other.language && prompt == other.prompt && responseFormat == other.responseFormat && temperature == other.temperature && timestampGranularities == other.timestampGranularities /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, model, include, language, prompt, responseFormat, temperature, timestampGranularities) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, model=$model, include=$include, language=$language, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, timestampGranularities=$timestampGranularities}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TranscriptionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(transcriptionCreateParams: TranscriptionCreateParams) = apply {
            body = transcriptionCreateParams.body.toBuilder()
            additionalHeaders = transcriptionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = transcriptionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: ByteArray) = apply { body.file(file) }

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: Path) = apply { body.file(file) }

        /**
         * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * and `whisper-1` (which is powered by our open source Whisper V2 model).
         */
        fun model(model: AudioModel) = apply { body.model(model) }

        /**
         * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * and `whisper-1` (which is powered by our open source Whisper V2 model).
         */
        fun model(model: MultipartField<AudioModel>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [AudioModel] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         */
        fun include(include: List<TranscriptionInclude>) = apply { body.include(include) }

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         */
        fun include(include: MultipartField<List<TranscriptionInclude>>) = apply {
            body.include(include)
        }

        /**
         * Adds a single [TranscriptionInclude] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: TranscriptionInclude) = apply { body.addInclude(include) }

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         */
        fun language(language: String) = apply { body.language(language) }

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         */
        fun language(language: MultipartField<String>) = apply { body.language(language) }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         */
        fun prompt(prompt: MultipartField<String>) = apply { body.prompt(prompt) }

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format
         * is `json`.
         */
        fun responseFormat(responseFormat: AudioResponseFormat) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format
         * is `json`.
         */
        fun responseFormat(responseFormat: MultipartField<AudioResponseFormat>) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        fun temperature(temperature: Double) = apply { body.temperature(temperature) }

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        fun temperature(temperature: MultipartField<Double>) = apply {
            body.temperature(temperature)
        }

        /**
         * The timestamp granularities to populate for this transcription. `response_format` must be
         * set `verbose_json` to use timestamp granularities. Either or both of these options are
         * supported: `word`, or `segment`. Note: There is no additional latency for segment
         * timestamps, but generating word timestamps incurs additional latency.
         */
        fun timestampGranularities(timestampGranularities: List<TimestampGranularity>) = apply {
            body.timestampGranularities(timestampGranularities)
        }

        /**
         * The timestamp granularities to populate for this transcription. `response_format` must be
         * set `verbose_json` to use timestamp granularities. Either or both of these options are
         * supported: `word`, or `segment`. Note: There is no additional latency for segment
         * timestamps, but generating word timestamps incurs additional latency.
         */
        fun timestampGranularities(
            timestampGranularities: MultipartField<List<TimestampGranularity>>
        ) = apply { body.timestampGranularities(timestampGranularities) }

        /**
         * Adds a single [TimestampGranularity] to [timestampGranularities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTimestampGranularity(timestampGranularity: TimestampGranularity) = apply {
            body.addTimestampGranularity(timestampGranularity)
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
         * Returns an immutable instance of [TranscriptionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .file()
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionCreateParams =
            TranscriptionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class TimestampGranularity
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val WORD = of("word")

            @JvmField val SEGMENT = of("segment")

            @JvmStatic fun of(value: String) = TimestampGranularity(JsonField.of(value))
        }

        /** An enum containing [TimestampGranularity]'s known values. */
        enum class Known {
            WORD,
            SEGMENT,
        }

        /**
         * An enum containing [TimestampGranularity]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [TimestampGranularity] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            WORD,
            SEGMENT,
            /**
             * An enum member indicating that [TimestampGranularity] was instantiated with an
             * unknown value.
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
                WORD -> Value.WORD
                SEGMENT -> Value.SEGMENT
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
                WORD -> Known.WORD
                SEGMENT -> Known.SEGMENT
                else -> throw OpenAIInvalidDataException("Unknown TimestampGranularity: $value")
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

            return /* spotless:off */ other is TimestampGranularity && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "TranscriptionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
