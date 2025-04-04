// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.AudioModel
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name

/** Translates audio into English. */
class TranslationCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
     * mpeg, mpga, m4a, ogg, wav, or webm.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
     * model) is currently available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): AudioModel = body.model()

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The
     * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
     * English.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<String> = body.prompt()

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFormat(): Optional<ResponseFormat> = body.responseFormat()

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
    fun _responseFormat(): MultipartField<ResponseFormat> = body._responseFormat()

    /**
     * Returns the raw multipart value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _temperature(): MultipartField<Double> = body._temperature()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TranslationCreateParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranslationCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(translationCreateParams: TranslationCreateParams) = apply {
            body = translationCreateParams.body.toBuilder()
            additionalHeaders = translationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = translationCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [model]
         * - [prompt]
         * - [responseFormat]
         * - [temperature]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
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
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
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
         * or `vtt`.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            body.responseFormat(responseFormat)
        }

        /**
         * Sets [Builder.responseFormat] to an arbitrary multipart value.
         *
         * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
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
         * Returns an immutable instance of [TranslationCreateParams].
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
        fun build(): TranslationCreateParams =
            TranslationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
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

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val model: MultipartField<AudioModel>,
        private val prompt: MultipartField<String>,
        private val responseFormat: MultipartField<ResponseFormat>,
        private val temperature: MultipartField<Double>,
    ) {

        /**
         * The audio file object (not file name) translate, in one of these formats: flac, mp3, mp4,
         * mpeg, mpga, m4a, ogg, wav, or webm.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * ID of the model to use. Only `whisper-1` (which is powered by our open source Whisper V2
         * model) is currently available.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): AudioModel = model.value.getRequired("model")

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be in
         * English.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun prompt(): Optional<String> = prompt.value.getOptional("prompt")

        /**
         * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`,
         * or `vtt`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseFormat(): Optional<ResponseFormat> =
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
        fun _responseFormat(): MultipartField<ResponseFormat> = responseFormat

        /**
         * Returns the raw multipart value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): MultipartField<Double> = temperature

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
            private var responseFormat: MultipartField<ResponseFormat> = MultipartField.of(null)
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
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * The audio file object (not file name) translate, in one of these formats: flac, mp3,
             * mp4, mpeg, mpga, m4a, ogg, wav, or webm.
             */
            fun file(file: ByteArray) = file(file.inputStream())

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
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](https://platform.openai.com/docs/guides/speech-to-text#prompting) should be
             * in English.
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
             * `verbose_json`, or `vtt`.
             */
            fun responseFormat(responseFormat: ResponseFormat) =
                responseFormat(MultipartField.of(responseFormat))

            /**
             * Sets [Builder.responseFormat] to an arbitrary multipart value.
             *
             * You should usually call [Builder.responseFormat] with a well-typed [ResponseFormat]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun responseFormat(responseFormat: MultipartField<ResponseFormat>) = apply {
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
                    prompt,
                    responseFormat,
                    temperature,
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            model().validate()
            prompt()
            responseFormat().ifPresent { it.validate() }
            temperature()
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

            return /* spotless:off */ other is Body && file == other.file && model == other.model && prompt == other.prompt && responseFormat == other.responseFormat && temperature == other.temperature /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, model, prompt, responseFormat, temperature) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature}"
    }

    /**
     * The format of the output, in one of these options: `json`, `text`, `srt`, `verbose_json`, or
     * `vtt`.
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

            @JvmField val JSON = of("json")

            @JvmField val TEXT = of("text")

            @JvmField val SRT = of("srt")

            @JvmField val VERBOSE_JSON = of("verbose_json")

            @JvmField val VTT = of("vtt")

            @JvmStatic fun of(value: String) = ResponseFormat(JsonField.of(value))
        }

        /** An enum containing [ResponseFormat]'s known values. */
        enum class Known {
            JSON,
            TEXT,
            SRT,
            VERBOSE_JSON,
            VTT,
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
            JSON,
            TEXT,
            SRT,
            VERBOSE_JSON,
            VTT,
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
                JSON -> Value.JSON
                TEXT -> Value.TEXT
                SRT -> Value.SRT
                VERBOSE_JSON -> Value.VERBOSE_JSON
                VTT -> Value.VTT
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
                JSON -> Known.JSON
                TEXT -> Known.TEXT
                SRT -> Known.SRT
                VERBOSE_JSON -> Known.VERBOSE_JSON
                VTT -> Known.VTT
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

        private var validated: Boolean = false

        fun validate(): ResponseFormat = apply {
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

            return /* spotless:off */ other is ResponseFormat && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranslationCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "TranslationCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
