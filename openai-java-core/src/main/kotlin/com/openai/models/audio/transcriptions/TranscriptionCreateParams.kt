// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import java.io.InputStream
import java.nio.file.Path
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name
import kotlin.jvm.optionals.getOrNull

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
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`, and
     * `whisper-1` (which is powered by our open source Whisper V2 model).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): AudioModel = body.model()

    /**
     * Controls how the audio is cut into chunks. When set to `"auto"`, the server first normalizes
     * loudness and then uses voice activity detection (VAD) to choose boundaries. `server_vad`
     * object can be provided to tweak VAD detection parameters manually. If unset, the audio is
     * transcribed as a single block.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun chunkingStrategy(): Optional<ChunkingStrategy> = body.chunkingStrategy()

    /**
     * Additional information to include in the transcription response. `logprobs` will return the
     * log probabilities of the tokens in the response to understand the model's confidence in the
     * transcription. `logprobs` only works with response_format set to `json` and only with the
     * models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun include(): Optional<List<TranscriptionInclude>> = body.include()

    /**
     * The language of the input audio. Supplying the input language in
     * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format will
     * improve accuracy and latency.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match the
     * audio language.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<String> = body.prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format is
     * `json`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<AudioResponseFormat> = body.responseFormat()

    /**
     * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output more
     * random, while lower values like 0.2 will make it more focused and deterministic. If set to 0,
     * the model will use [log probability](https://en.wikipedia.org/wiki/Log_probability) to
     * automatically increase the temperature until certain thresholds are hit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * The timestamp granularities to populate for this transcription. `response_format` must be set
     * `verbose_json` to use timestamp granularities. Either or both of these options are supported:
     * `word`, or `segment`. Note: There is no additional latency for segment timestamps, but
     * generating word timestamps incurs additional latency.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timestampGranularities(): Optional<List<TimestampGranularity>> =
        body.timestampGranularities()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * Returns the raw multipart value of [model].
     *
     * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _model(): MultipartField<AudioModel> = body._model()

    /**
     * Returns the raw multipart value of [chunkingStrategy].
     *
     * Unlike [chunkingStrategy], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _chunkingStrategy(): MultipartField<ChunkingStrategy> = body._chunkingStrategy()

    /**
     * Returns the raw multipart value of [include].
     *
     * Unlike [include], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _include(): MultipartField<List<TranscriptionInclude>> = body._include()

    /**
     * Returns the raw multipart value of [language].
     *
     * Unlike [language], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _language(): MultipartField<String> = body._language()

    /**
     * Returns the raw multipart value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * Returns the raw multipart value of [responseFormat].
     *
     * Unlike [responseFormat], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _responseFormat(): MultipartField<AudioResponseFormat> = body._responseFormat()

    /**
     * Returns the raw multipart value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _temperature(): MultipartField<Double> = body._temperature()

    /**
     * Returns the raw multipart value of [timestampGranularities].
     *
     * Unlike [timestampGranularities], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _timestampGranularities(): MultipartField<List<TimestampGranularity>> =
        body._timestampGranularities()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

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
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [model]
         * - [chunkingStrategy]
         * - [include]
         * - [language]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The audio file object (not file name) to transcribe, in one of these formats: flac, mp3,
         * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Sets [Builder.model] to an arbitrary multipart value.
         *
         * You should usually call [Builder.model] with a well-typed [AudioModel] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Controls how the audio is cut into chunks. When set to `"auto"`, the server first
         * normalizes loudness and then uses voice activity detection (VAD) to choose boundaries.
         * `server_vad` object can be provided to tweak VAD detection parameters manually. If unset,
         * the audio is transcribed as a single block.
         */
        fun chunkingStrategy(chunkingStrategy: ChunkingStrategy?) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /** Alias for calling [Builder.chunkingStrategy] with `chunkingStrategy.orElse(null)`. */
        fun chunkingStrategy(chunkingStrategy: Optional<ChunkingStrategy>) =
            chunkingStrategy(chunkingStrategy.getOrNull())

        /**
         * Sets [Builder.chunkingStrategy] to an arbitrary multipart value.
         *
         * You should usually call [Builder.chunkingStrategy] with a well-typed [ChunkingStrategy]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun chunkingStrategy(chunkingStrategy: MultipartField<ChunkingStrategy>) = apply {
            body.chunkingStrategy(chunkingStrategy)
        }

        /** Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofAuto()`. */
        fun chunkingStrategyAuto() = apply { body.chunkingStrategyAuto() }

        /** Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofVadConfig(vadConfig)`. */
        fun chunkingStrategy(vadConfig: ChunkingStrategy.VadConfig) = apply {
            body.chunkingStrategy(vadConfig)
        }

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         */
        fun include(include: List<TranscriptionInclude>) = apply { body.include(include) }

        /**
         * Sets [Builder.include] to an arbitrary multipart value.
         *
         * You should usually call [Builder.include] with a well-typed `List<TranscriptionInclude>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
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
         * Sets [Builder.language] to an arbitrary multipart value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: MultipartField<String>) = apply { body.language(language) }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * Sets [Builder.prompt] to an arbitrary multipart value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Sets [Builder.responseFormat] to an arbitrary multipart value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed [AudioResponseFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
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
         * Sets [Builder.temperature] to an arbitrary multipart value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Sets [Builder.timestampGranularities] to an arbitrary multipart value.
         *
         * You should usually call [Builder.timestampGranularities] with a well-typed
         * `List<TimestampGranularity>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
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

    fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "file" to _file(),
                "model" to _model(),
                "chunking_strategy" to _chunkingStrategy(),
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

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val model: MultipartField<AudioModel>,
        private val chunkingStrategy: MultipartField<ChunkingStrategy>,
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
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * ID of the model to use. The options are `gpt-4o-transcribe`, `gpt-4o-mini-transcribe`,
         * and `whisper-1` (which is powered by our open source Whisper V2 model).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): AudioModel = model.value.getRequired("model")

        /**
         * Controls how the audio is cut into chunks. When set to `"auto"`, the server first
         * normalizes loudness and then uses voice activity detection (VAD) to choose boundaries.
         * `server_vad` object can be provided to tweak VAD detection parameters manually. If unset,
         * the audio is transcribed as a single block.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chunkingStrategy(): Optional<ChunkingStrategy> =
            chunkingStrategy.value.getOptional("chunking_strategy")

        /**
         * Additional information to include in the transcription response. `logprobs` will return
         * the log probabilities of the tokens in the response to understand the model's confidence
         * in the transcription. `logprobs` only works with response_format set to `json` and only
         * with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun include(): Optional<List<TranscriptionInclude>> = include.value.getOptional("include")

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.value.getOptional("language")

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should match
         * the audio language.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prompt(): Optional<String> = prompt.value.getOptional("prompt")

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`. For `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`, the only supported format
         * is `json`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<AudioResponseFormat> =
            responseFormat.value.getOptional("response_format")

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.value.getOptional("temperature")

        /**
         * The timestamp granularities to populate for this transcription. `response_format` must be
         * set `verbose_json` to use timestamp granularities. Either or both of these options are
         * supported: `word`, or `segment`. Note: There is no additional latency for segment
         * timestamps, but generating word timestamps incurs additional latency.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timestampGranularities(): Optional<List<TimestampGranularity>> =
            timestampGranularities.value.getOptional("timestamp_granularities")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        /**
         * Returns the raw multipart value of [model].
         *
         * Unlike [model], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): MultipartField<AudioModel> = model

        /**
         * Returns the raw multipart value of [chunkingStrategy].
         *
         * Unlike [chunkingStrategy], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("chunking_strategy")
        @ExcludeMissing
        fun _chunkingStrategy(): MultipartField<ChunkingStrategy> = chunkingStrategy

        /**
         * Returns the raw multipart value of [include].
         *
         * Unlike [include], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("include")
        @ExcludeMissing
        fun _include(): MultipartField<List<TranscriptionInclude>> = include

        /**
         * Returns the raw multipart value of [language].
         *
         * Unlike [language], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): MultipartField<String> = language

        /**
         * Returns the raw multipart value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): MultipartField<String> = prompt

        /**
         * Returns the raw multipart value of [responseFormat].
         *
         * Unlike [responseFormat], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("response_format")
        @ExcludeMissing
        fun _responseFormat(): MultipartField<AudioResponseFormat> = responseFormat

        /**
         * Returns the raw multipart value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): MultipartField<Double> = temperature

        /**
         * Returns the raw multipart value of [timestampGranularities].
         *
         * Unlike [timestampGranularities], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("timestamp_granularities")
        @ExcludeMissing
        fun _timestampGranularities(): MultipartField<List<TimestampGranularity>> =
            timestampGranularities

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
            private var chunkingStrategy: MultipartField<ChunkingStrategy> = MultipartField.of(null)
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
                chunkingStrategy = body.chunkingStrategy
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
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * The audio file object (not file name) to transcribe, in one of these formats: flac,
             * mp3, mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: ByteArray) = file(file.inputStream())

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
             * Sets [Builder.model] to an arbitrary multipart value.
             *
             * You should usually call [Builder.model] with a well-typed [AudioModel] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Controls how the audio is cut into chunks. When set to `"auto"`, the server first
             * normalizes loudness and then uses voice activity detection (VAD) to choose
             * boundaries. `server_vad` object can be provided to tweak VAD detection parameters
             * manually. If unset, the audio is transcribed as a single block.
             */
            fun chunkingStrategy(chunkingStrategy: ChunkingStrategy?) =
                chunkingStrategy(MultipartField.of(chunkingStrategy))

            /**
             * Alias for calling [Builder.chunkingStrategy] with `chunkingStrategy.orElse(null)`.
             */
            fun chunkingStrategy(chunkingStrategy: Optional<ChunkingStrategy>) =
                chunkingStrategy(chunkingStrategy.getOrNull())

            /**
             * Sets [Builder.chunkingStrategy] to an arbitrary multipart value.
             *
             * You should usually call [Builder.chunkingStrategy] with a well-typed
             * [ChunkingStrategy] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun chunkingStrategy(chunkingStrategy: MultipartField<ChunkingStrategy>) = apply {
                this.chunkingStrategy = chunkingStrategy
            }

            /** Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofAuto()`. */
            fun chunkingStrategyAuto() = chunkingStrategy(ChunkingStrategy.ofAuto())

            /**
             * Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofVadConfig(vadConfig)`.
             */
            fun chunkingStrategy(vadConfig: ChunkingStrategy.VadConfig) =
                chunkingStrategy(ChunkingStrategy.ofVadConfig(vadConfig))

            /**
             * Additional information to include in the transcription response. `logprobs` will
             * return the log probabilities of the tokens in the response to understand the model's
             * confidence in the transcription. `logprobs` only works with response_format set to
             * `json` and only with the models `gpt-4o-transcribe` and `gpt-4o-mini-transcribe`.
             */
            fun include(include: List<TranscriptionInclude>) = include(MultipartField.of(include))

            /**
             * Sets [Builder.include] to an arbitrary multipart value.
             *
             * You should usually call [Builder.include] with a well-typed
             * `List<TranscriptionInclude>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
             * Sets [Builder.language] to an arbitrary multipart value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: MultipartField<String>) = apply { this.language = language }

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should
             * match the audio language.
             */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * Sets [Builder.prompt] to an arbitrary multipart value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Sets [Builder.responseFormat] to an arbitrary multipart value.
             *
             * You should usually call [Builder.responseFormat] with a well-typed
             * [AudioResponseFormat] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
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
             * Sets [Builder.temperature] to an arbitrary multipart value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Sets [Builder.timestampGranularities] to an arbitrary multipart value.
             *
             * You should usually call [Builder.timestampGranularities] with a well-typed
             * `List<TimestampGranularity>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
                    chunkingStrategy,
                    (include ?: MultipartField.of(null)).map { it.toImmutable() },
                    language,
                    prompt,
                    responseFormat,
                    temperature,
                    (timestampGranularities ?: MultipartField.of(null)).map { it.toImmutable() },
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            model().validate()
            chunkingStrategy().ifPresent { it.validate() }
            include().ifPresent { it.forEach { it.validate() } }
            language()
            prompt()
            responseFormat().ifPresent { it.validate() }
            temperature()
            timestampGranularities().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file && model == other.model && chunkingStrategy == other.chunkingStrategy && include == other.include && language == other.language && prompt == other.prompt && responseFormat == other.responseFormat && temperature == other.temperature && timestampGranularities == other.timestampGranularities /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, model, chunkingStrategy, include, language, prompt, responseFormat, temperature, timestampGranularities) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, model=$model, chunkingStrategy=$chunkingStrategy, include=$include, language=$language, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, timestampGranularities=$timestampGranularities}"
    }

    /**
     * Controls how the audio is cut into chunks. When set to `"auto"`, the server first normalizes
     * loudness and then uses voice activity detection (VAD) to choose boundaries. `server_vad`
     * object can be provided to tweak VAD detection parameters manually. If unset, the audio is
     * transcribed as a single block.
     */
    @JsonDeserialize(using = ChunkingStrategy.Deserializer::class)
    @JsonSerialize(using = ChunkingStrategy.Serializer::class)
    class ChunkingStrategy
    private constructor(
        private val auto: JsonValue? = null,
        private val vadConfig: VadConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Automatically set chunking parameters based on the audio. Must be set to `"auto"`. */
        fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

        fun vadConfig(): Optional<VadConfig> = Optional.ofNullable(vadConfig)

        fun isAuto(): Boolean = auto != null

        fun isVadConfig(): Boolean = vadConfig != null

        /** Automatically set chunking parameters based on the audio. Must be set to `"auto"`. */
        fun asAuto(): JsonValue = auto.getOrThrow("auto")

        fun asVadConfig(): VadConfig = vadConfig.getOrThrow("vadConfig")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                auto != null -> visitor.visitAuto(auto)
                vadConfig != null -> visitor.visitVadConfig(vadConfig)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): ChunkingStrategy = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAuto(auto: JsonValue) {
                        auto.let {
                            if (it != JsonValue.from("auto")) {
                                throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitVadConfig(vadConfig: VadConfig) {
                        vadConfig.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitAuto(auto: JsonValue) =
                        auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                    override fun visitVadConfig(vadConfig: VadConfig) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ChunkingStrategy && auto == other.auto && vadConfig == other.vadConfig /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, vadConfig) /* spotless:on */

        override fun toString(): String =
            when {
                auto != null -> "ChunkingStrategy{auto=$auto}"
                vadConfig != null -> "ChunkingStrategy{vadConfig=$vadConfig}"
                _json != null -> "ChunkingStrategy{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ChunkingStrategy")
            }

        companion object {

            /**
             * Automatically set chunking parameters based on the audio. Must be set to `"auto"`.
             */
            @JvmStatic fun ofAuto() = ChunkingStrategy(auto = JsonValue.from("auto"))

            @JvmStatic
            fun ofVadConfig(vadConfig: VadConfig) = ChunkingStrategy(vadConfig = vadConfig)
        }

        /**
         * An interface that defines how to map each variant of [ChunkingStrategy] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /**
             * Automatically set chunking parameters based on the audio. Must be set to `"auto"`.
             */
            fun visitAuto(auto: JsonValue): T

            fun visitVadConfig(vadConfig: VadConfig): T

            /**
             * Maps an unknown variant of [ChunkingStrategy] to a value of type [T].
             *
             * An instance of [ChunkingStrategy] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ChunkingStrategy: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<ChunkingStrategy>(ChunkingStrategy::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ChunkingStrategy {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { ChunkingStrategy(auto = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<VadConfig>())?.let {
                                ChunkingStrategy(vadConfig = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> ChunkingStrategy(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<ChunkingStrategy>(ChunkingStrategy::class) {

            override fun serialize(
                value: ChunkingStrategy,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.auto != null -> generator.writeObject(value.auto)
                    value.vadConfig != null -> generator.writeObject(value.vadConfig)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ChunkingStrategy")
                }
            }
        }

        class VadConfig
        private constructor(
            private val type: MultipartField<Type>,
            private val prefixPaddingMs: MultipartField<Long>,
            private val silenceDurationMs: MultipartField<Long>,
            private val threshold: MultipartField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * Must be set to `server_vad` to enable manual chunking using server side VAD.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.value.getRequired("type")

            /**
             * Amount of audio to include before the VAD detected speech (in milliseconds).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun prefixPaddingMs(): Optional<Long> =
                prefixPaddingMs.value.getOptional("prefix_padding_ms")

            /**
             * Duration of silence to detect speech stop (in milliseconds). With shorter values the
             * model will respond more quickly, but may jump in on short pauses from the user.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun silenceDurationMs(): Optional<Long> =
                silenceDurationMs.value.getOptional("silence_duration_ms")

            /**
             * Sensitivity threshold (0.0 to 1.0) for voice activity detection. A higher threshold
             * will require louder audio to activate the model, and thus might perform better in
             * noisy environments.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun threshold(): Optional<Double> = threshold.value.getOptional("threshold")

            /**
             * Returns the raw multipart value of [type].
             *
             * Unlike [type], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

            /**
             * Returns the raw multipart value of [prefixPaddingMs].
             *
             * Unlike [prefixPaddingMs], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("prefix_padding_ms")
            @ExcludeMissing
            fun _prefixPaddingMs(): MultipartField<Long> = prefixPaddingMs

            /**
             * Returns the raw multipart value of [silenceDurationMs].
             *
             * Unlike [silenceDurationMs], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("silence_duration_ms")
            @ExcludeMissing
            fun _silenceDurationMs(): MultipartField<Long> = silenceDurationMs

            /**
             * Returns the raw multipart value of [threshold].
             *
             * Unlike [threshold], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("threshold")
            @ExcludeMissing
            fun _threshold(): MultipartField<Double> = threshold

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
                 * Returns a mutable builder for constructing an instance of [VadConfig].
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [VadConfig]. */
            class Builder internal constructor() {

                private var type: MultipartField<Type>? = null
                private var prefixPaddingMs: MultipartField<Long> = MultipartField.of(null)
                private var silenceDurationMs: MultipartField<Long> = MultipartField.of(null)
                private var threshold: MultipartField<Double> = MultipartField.of(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(vadConfig: VadConfig) = apply {
                    type = vadConfig.type
                    prefixPaddingMs = vadConfig.prefixPaddingMs
                    silenceDurationMs = vadConfig.silenceDurationMs
                    threshold = vadConfig.threshold
                    additionalProperties = vadConfig.additionalProperties.toMutableMap()
                }

                /** Must be set to `server_vad` to enable manual chunking using server side VAD. */
                fun type(type: Type) = type(MultipartField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: MultipartField<Type>) = apply { this.type = type }

                /** Amount of audio to include before the VAD detected speech (in milliseconds). */
                fun prefixPaddingMs(prefixPaddingMs: Long) =
                    prefixPaddingMs(MultipartField.of(prefixPaddingMs))

                /**
                 * Sets [Builder.prefixPaddingMs] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.prefixPaddingMs] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prefixPaddingMs(prefixPaddingMs: MultipartField<Long>) = apply {
                    this.prefixPaddingMs = prefixPaddingMs
                }

                /**
                 * Duration of silence to detect speech stop (in milliseconds). With shorter values
                 * the model will respond more quickly, but may jump in on short pauses from the
                 * user.
                 */
                fun silenceDurationMs(silenceDurationMs: Long) =
                    silenceDurationMs(MultipartField.of(silenceDurationMs))

                /**
                 * Sets [Builder.silenceDurationMs] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.silenceDurationMs] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun silenceDurationMs(silenceDurationMs: MultipartField<Long>) = apply {
                    this.silenceDurationMs = silenceDurationMs
                }

                /**
                 * Sensitivity threshold (0.0 to 1.0) for voice activity detection. A higher
                 * threshold will require louder audio to activate the model, and thus might perform
                 * better in noisy environments.
                 */
                fun threshold(threshold: Double) = threshold(MultipartField.of(threshold))

                /**
                 * Sets [Builder.threshold] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.threshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun threshold(threshold: MultipartField<Double>) = apply {
                    this.threshold = threshold
                }

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
                 * Returns an immutable instance of [VadConfig].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): VadConfig =
                    VadConfig(
                        checkRequired("type", type),
                        prefixPaddingMs,
                        silenceDurationMs,
                        threshold,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): VadConfig = apply {
                if (validated) {
                    return@apply
                }

                type().validate()
                prefixPaddingMs()
                silenceDurationMs()
                threshold()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /** Must be set to `server_vad` to enable manual chunking using server side VAD. */
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

                    return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is VadConfig && type == other.type && prefixPaddingMs == other.prefixPaddingMs && silenceDurationMs == other.silenceDurationMs && threshold == other.threshold && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, prefixPaddingMs, silenceDurationMs, threshold, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "VadConfig{type=$type, prefixPaddingMs=$prefixPaddingMs, silenceDurationMs=$silenceDurationMs, threshold=$threshold, additionalProperties=$additionalProperties}"
        }
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

        private var validated: Boolean = false

        fun validate(): TimestampGranularity = apply {
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
