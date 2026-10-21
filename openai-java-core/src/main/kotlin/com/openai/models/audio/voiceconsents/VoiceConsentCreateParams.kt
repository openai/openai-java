// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.nio.file.Path
import java.util.Collections
import java.util.Objects
import kotlin.io.path.inputStream
import kotlin.io.path.name

/** Upload a voice consent recording. */
class VoiceConsentCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The BCP 47 language tag for the consent phrase (for example, `en-US`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun language(): String = body.language()

    /**
     * The label to use for this consent recording.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = body.name()

    /**
     * The consent audio recording file. Maximum size is 10 MiB.
     *
     * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`, `audio/aac`,
     * `audio/flac`, `audio/webm`, `audio/mp4`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recording(): InputStream = body.recording()

    /**
     * Returns the raw multipart value of [language].
     *
     * Unlike [language], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _language(): MultipartField<String> = body._language()

    /**
     * Returns the raw multipart value of [name].
     *
     * Unlike [name], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _name(): MultipartField<String> = body._name()

    /**
     * Returns the raw multipart value of [recording].
     *
     * Unlike [recording], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _recording(): MultipartField<InputStream> = body._recording()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VoiceConsentCreateParams].
         *
         * The following fields are required:
         * ```java
         * .language()
         * .name()
         * .recording()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceConsentCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(voiceConsentCreateParams: VoiceConsentCreateParams) = apply {
            body = voiceConsentCreateParams.body.toBuilder()
            additionalHeaders = voiceConsentCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = voiceConsentCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [language]
         * - [name]
         * - [recording]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The BCP 47 language tag for the consent phrase (for example, `en-US`). */
        fun language(language: String) = apply { body.language(language) }

        /**
         * Sets [Builder.language] to an arbitrary multipart value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: MultipartField<String>) = apply { body.language(language) }

        /** The label to use for this consent recording. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary multipart value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: MultipartField<String>) = apply { body.name(name) }

        /**
         * The consent audio recording file. Maximum size is 10 MiB.
         *
         * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`, `audio/aac`,
         * `audio/flac`, `audio/webm`, `audio/mp4`.
         */
        fun recording(recording: InputStream) = apply { body.recording(recording) }

        /**
         * Sets [Builder.recording] to an arbitrary multipart value.
         *
         * You should usually call [Builder.recording] with a well-typed [InputStream] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recording(recording: MultipartField<InputStream>) = apply { body.recording(recording) }

        /**
         * The consent audio recording file. Maximum size is 10 MiB.
         *
         * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`, `audio/aac`,
         * `audio/flac`, `audio/webm`, `audio/mp4`.
         */
        fun recording(recording: ByteArray) = apply { body.recording(recording) }

        /**
         * The consent audio recording file. Maximum size is 10 MiB.
         *
         * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`, `audio/aac`,
         * `audio/flac`, `audio/webm`, `audio/mp4`.
         */
        fun recording(path: Path) = apply { body.recording(path) }

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

        /**
         * Returns an immutable instance of [VoiceConsentCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .language()
         * .name()
         * .recording()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VoiceConsentCreateParams =
            VoiceConsentCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("language" to _language(), "name" to _name(), "recording" to _recording()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val language: MultipartField<String>,
        private val name: MultipartField<String>,
        private val recording: MultipartField<InputStream>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * The BCP 47 language tag for the consent phrase (for example, `en-US`).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun language(): String = language.value.getRequired("language")

        /**
         * The label to use for this consent recording.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.value.getRequired("name")

        /**
         * The consent audio recording file. Maximum size is 10 MiB.
         *
         * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`, `audio/aac`,
         * `audio/flac`, `audio/webm`, `audio/mp4`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recording(): InputStream = recording.value.getRequired("recording")

        /**
         * Returns the raw multipart value of [language].
         *
         * Unlike [language], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): MultipartField<String> = language

        /**
         * Returns the raw multipart value of [name].
         *
         * Unlike [name], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<String> = name

        /**
         * Returns the raw multipart value of [recording].
         *
         * Unlike [recording], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("recording")
        @ExcludeMissing
        fun _recording(): MultipartField<InputStream> = recording

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .language()
             * .name()
             * .recording()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var language: MultipartField<String>? = null
            private var name: MultipartField<String>? = null
            private var recording: MultipartField<InputStream>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                language = body.language
                name = body.name
                recording = body.recording
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The BCP 47 language tag for the consent phrase (for example, `en-US`). */
            fun language(language: String) = language(MultipartField.of(language))

            /**
             * Sets [Builder.language] to an arbitrary multipart value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: MultipartField<String>) = apply { this.language = language }

            /** The label to use for this consent recording. */
            fun name(name: String) = name(MultipartField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary multipart value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: MultipartField<String>) = apply { this.name = name }

            /**
             * The consent audio recording file. Maximum size is 10 MiB.
             *
             * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`,
             * `audio/aac`, `audio/flac`, `audio/webm`, `audio/mp4`.
             */
            fun recording(recording: InputStream) = recording(MultipartField.of(recording))

            /**
             * Sets [Builder.recording] to an arbitrary multipart value.
             *
             * You should usually call [Builder.recording] with a well-typed [InputStream] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recording(recording: MultipartField<InputStream>) = apply {
                this.recording = recording
            }

            /**
             * The consent audio recording file. Maximum size is 10 MiB.
             *
             * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`,
             * `audio/aac`, `audio/flac`, `audio/webm`, `audio/mp4`.
             */
            fun recording(recording: ByteArray) = recording(recording.inputStream())

            /**
             * The consent audio recording file. Maximum size is 10 MiB.
             *
             * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`,
             * `audio/aac`, `audio/flac`, `audio/webm`, `audio/mp4`.
             */
            fun recording(path: Path) =
                recording(
                    MultipartField.builder<InputStream>()
                        .value(path.inputStream())
                        .filename(path.name)
                        .build()
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .language()
             * .name()
             * .recording()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("language", language),
                    checkRequired("name", name),
                    checkRequired("recording", recording),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            language()
            name()
            recording()
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

            return other is Body &&
                language == other.language &&
                name == other.name &&
                recording == other.recording &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(language, name, recording, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{language=$language, name=$name, recording=$recording, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceConsentCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VoiceConsentCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
