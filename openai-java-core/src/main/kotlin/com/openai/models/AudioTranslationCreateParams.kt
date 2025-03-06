// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.MultipartField
import com.openai.core.NoAutoDetect
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name

/** Translates audio into English. */
class AudioTranslationCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
     * mpeg, mpga, m4a, ogg, wav, or webm.
     */
    fun file(): InputStream = body.file()

    /**
     * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
     * model) is currently available.
     */
    fun model(): AudioModel = body.model()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
     * English.
     */
    fun prompt(): Optional<String> = body.prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`.
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
     * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
     * mpeg, mpga, m4a, ogg, wav, or webm.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
     * model) is currently available.
     */
    fun _model(): MultipartField<AudioModel> = body._model()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
     * English.
     */
    fun _prompt(): MultipartField<String> = body._prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`.
     */
    fun _responseFormat(): MultipartField<AudioResponseFormat> = body._responseFormat()

    /**
     * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output more
     * random, while lower values like 0.2 will make it more focused and deterministic. If set to 0,
     * the model will use [log probability](https://en.wikipedia.org/wiki/Log_probability) to
     * automatically increase the temperature until certain thresholds are hit.
     */
    fun _temperature(): MultipartField<Double> = body._temperature()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "file" to _file(),
                "model" to _model(),
                "prompt" to _prompt(),
                "response_format" to _responseFormat(),
                "temperature" to _temperature(),
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
        private val prompt: MultipartField<String>,
        private val responseFormat: MultipartField<AudioResponseFormat>,
        private val temperature: MultipartField<Double>,
    ) {

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         */
        fun model(): AudioModel = model.value.getRequired("model")

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
         */
        fun prompt(): Optional<String> = Optional.ofNullable(prompt.value.getNullable("prompt"))

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`.
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
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun _file(): MultipartField<InputStream> = file

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         */
        fun _model(): MultipartField<AudioModel> = model

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
         */
        fun _prompt(): MultipartField<String> = prompt

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`.
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

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            model()
            prompt()
            responseFormat()
            temperature()
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
            private var prompt: MultipartField<String> = MultipartField.of(null)
            private var responseFormat: MultipartField<AudioResponseFormat> =
                MultipartField.of(null)
            private var temperature: MultipartField<Double> = MultipartField.of(null)

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                model = body.model
                prompt = body.prompt
                responseFormat = body.responseFormat
                temperature = body.temperature
            }

            /**
             * The audio file object (not file name) translate, in one of these formats: flac, mp3,
             * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * The audio file object (not file name) translate, in one of these formats: flac, mp3,
             * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * The audio file object (not file name) translate, in one of these formats: flac, mp3,
             * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: ByteArray) = file(ByteArrayInputStream(file))

            /**
             * The audio file object (not file name) translate, in one of these formats: flac, mp3,
             * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /**
             * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper
             * V2 model) is currently available.
             */
            fun model(model: AudioModel) = model(MultipartField.of(model))

            /**
             * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper
             * V2 model) is currently available.
             */
            fun model(model: MultipartField<AudioModel>) = apply { this.model = model }

            /**
             * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper
             * V2 model) is currently available.
             */
            fun model(value: String) = model(AudioModel.of(value))

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be
             * in English.
             */
            fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be
             * in English.
             */
            fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

            /**
             * The format of the output, in one of these options: `json`, `text`, `srt`,
             * `verbose_json`, or `vtt`.
             */
            fun responseFormat(responseFormat: AudioResponseFormat) =
                responseFormat(MultipartField.of(responseFormat))

            /**
             * The format of the output, in one of these options: `json`, `text`, `srt`,
             * `verbose_json`, or `vtt`.
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

            fun build(): Body =
                Body(
                    checkRequired("file", file),
                    checkRequired("model", model),
                    prompt,
                    responseFormat,
                    temperature,
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file && model == other.model && prompt == other.prompt && responseFormat == other.responseFormat && temperature == other.temperature /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, model, prompt, responseFormat, temperature) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AudioTranslationCreateParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AudioTranslationCreateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(audioTranslationCreateParams: AudioTranslationCreateParams) = apply {
            body = audioTranslationCreateParams.body.toBuilder()
            additionalHeaders = audioTranslationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = audioTranslationCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: ByteArray) = apply { body.file(file) }

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         */
        fun file(file: Path) = apply { body.file(file) }

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         */
        fun model(model: AudioModel) = apply { body.model(model) }

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         */
        fun model(model: MultipartField<AudioModel>) = apply { body.model(model) }

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         */
        fun model(value: String) = apply { body.model(value) }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
         */
        fun prompt(prompt: String) = apply { body.prompt(prompt) }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
         */
        fun prompt(prompt: MultipartField<String>) = apply { body.prompt(prompt) }

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`.
         */
        fun responseFormat(responseFormat: AudioResponseFormat) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`.
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

        fun build(): AudioTranslationCreateParams =
            AudioTranslationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AudioTranslationCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "AudioTranslationCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
