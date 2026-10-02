// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voices

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Creates a voice from a text prompt or from a consent recording and an audio sample.
 *
 * For prompt-based creation, send `type: "prompt"` with a `name` and `prompt` as JSON or multipart
 * form data. For creation from an audio sample, send `type: "audio_sample"` with a `name`,
 * `audio_sample`, and `consent` recording ID as multipart form data. The type defaults to
 * `audio_sample` when omitted.
 *
 * Returns the saved voice's metadata. Voices created from text prompts are supported only in Live,
 * not in Realtime or the speech endpoint. The response does not include preview audio.
 */
class VoiceCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Creates a voice from a consent recording and an audio sample. Requires multipart/form-data.
     */
    fun body(): Body = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VoiceCreateParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCreateParams]. */
    class Builder internal constructor() {

        private var body: Body? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(voiceCreateParams: VoiceCreateParams) = apply {
            body = voiceCreateParams.body
            additionalHeaders = voiceCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = voiceCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Creates a voice from a consent recording and an audio sample. Requires
         * multipart/form-data.
         */
        fun body(body: Body) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofAudioSample(audioSample)`. */
        fun body(audioSample: Body.AudioSample) = body(Body.ofAudioSample(audioSample))

        /** Alias for calling [body] with `Body.ofPrompt(prompt)`. */
        fun body(prompt: Body.Prompt) = body(Body.ofPrompt(prompt))

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
         * Returns an immutable instance of [VoiceCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VoiceCreateParams =
            VoiceCreateParams(
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (when {
                this.body.isAudioSample() ->
                    mapOf(
                        "audio_sample" to this.body.asAudioSample()._audioSample(),
                        "consent" to this.body.asAudioSample()._consent(),
                        "name" to this.body.asAudioSample()._name(),
                        "type" to this.body.asAudioSample()._type(),
                    ) +
                        this.body.asAudioSample()._additionalProperties().mapValues { (_, value) ->
                            MultipartField.of(value)
                        }
                this.body.isPrompt() ->
                    mapOf(
                        "name" to this.body.asPrompt()._name(),
                        "prompt" to this.body.asPrompt()._prompt(),
                        "type" to MultipartField.of(this.body.asPrompt()._type()),
                        "model" to this.body.asPrompt()._model(),
                        "script_hint" to this.body.asPrompt()._scriptHint(),
                    ) +
                        this.body.asPrompt()._additionalProperties().mapValues { (_, value) ->
                            MultipartField.of(value)
                        }
                else ->
                    this.body
                        ._json()
                        .flatMap { it.asObject() }
                        .orElseThrow { IllegalArgumentException("Expected an object request body") }
                        .mapValues { (_, value) -> MultipartField.of(value) }
            })
            .filterValues { !it.value.isMissing() }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Creates a voice from a consent recording and an audio sample. Requires multipart/form-data.
     */
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val audioSample: AudioSample? = null,
        private val prompt: Prompt? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Creates a voice from a consent recording and an audio sample. Requires
         * multipart/form-data.
         */
        fun audioSample(): Optional<AudioSample> = Optional.ofNullable(audioSample)

        /**
         * Creates a synthetic voice from a text description. Supports application/json or
         * multipart/form-data.
         */
        fun prompt(): Optional<Prompt> = Optional.ofNullable(prompt)

        fun isAudioSample(): Boolean = audioSample != null

        fun isPrompt(): Boolean = prompt != null

        /**
         * Creates a voice from a consent recording and an audio sample. Requires
         * multipart/form-data.
         */
        fun asAudioSample(): AudioSample = audioSample.getOrThrow("audioSample")

        /**
         * Creates a synthetic voice from a text description. Supports application/json or
         * multipart/form-data.
         */
        fun asPrompt(): Prompt = prompt.getOrThrow("prompt")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = body.accept(new Body.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitAudioSample(AudioSample audioSample) {
         *         return Optional.of(audioSample.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                audioSample != null -> visitor.visitAudioSample(audioSample)
                prompt != null -> visitor.visitPrompt(prompt)
                else -> visitor.unknown(_json)
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

            accept(
                object : Visitor<Unit> {
                    override fun visitAudioSample(audioSample: AudioSample) {
                        audioSample.validate()
                    }

                    override fun visitPrompt(prompt: Prompt) {
                        prompt.validate()
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body && audioSample == other.audioSample && prompt == other.prompt
        }

        override fun hashCode(): Int = Objects.hash(audioSample, prompt)

        override fun toString(): String =
            when {
                audioSample != null -> "Body{audioSample=$audioSample}"
                prompt != null -> "Body{prompt=$prompt}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            /**
             * Creates a voice from a consent recording and an audio sample. Requires
             * multipart/form-data.
             */
            @JvmStatic fun ofAudioSample(audioSample: AudioSample) = Body(audioSample = audioSample)

            /**
             * Creates a synthetic voice from a text description. Supports application/json or
             * multipart/form-data.
             */
            @JvmStatic fun ofPrompt(prompt: Prompt) = Body(prompt = prompt)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            /**
             * Creates a voice from a consent recording and an audio sample. Requires
             * multipart/form-data.
             */
            fun visitAudioSample(audioSample: AudioSample): T

            /**
             * Creates a synthetic voice from a text description. Supports application/json or
             * multipart/form-data.
             */
            fun visitPrompt(prompt: Prompt): T

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Body")
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.audioSample != null -> generator.writeObject(value.audioSample)
                    value.prompt != null -> generator.writeObject(value.prompt)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        /**
         * Creates a voice from a consent recording and an audio sample. Requires
         * multipart/form-data.
         */
        class AudioSample
        private constructor(
            private val audioSample: MultipartField<InputStream>,
            private val consent: MultipartField<String>,
            private val name: MultipartField<String>,
            private val type: MultipartField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The sample audio recording file. Maximum size is 10 MiB.
             *
             * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`,
             * `audio/aac`, `audio/flac`, `audio/webm`, `audio/mp4`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun audioSample(): InputStream = audioSample.value.getRequired("audio_sample")

            /**
             * The consent recording ID (for example, `cons_1234`).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun consent(): String = consent.value.getRequired("consent")

            /**
             * The name of the new voice.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.value.getRequired("name")

            /**
             * The voice creation method. Defaults to `audio_sample` when omitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.value.getOptional("type")

            /**
             * Returns the raw multipart value of [audioSample].
             *
             * Unlike [audioSample], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("audio_sample")
            @ExcludeMissing
            fun _audioSample(): MultipartField<InputStream> = audioSample

            /**
             * Returns the raw multipart value of [consent].
             *
             * Unlike [consent], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("consent")
            @ExcludeMissing
            fun _consent(): MultipartField<String> = consent

            /**
             * Returns the raw multipart value of [name].
             *
             * Unlike [name], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<String> = name

            /**
             * Returns the raw multipart value of [type].
             *
             * Unlike [type], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

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
                 * Returns a mutable builder for constructing an instance of [AudioSample].
                 *
                 * The following fields are required:
                 * ```java
                 * .audioSample()
                 * .consent()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AudioSample]. */
            class Builder internal constructor() {

                private var audioSample: MultipartField<InputStream>? = null
                private var consent: MultipartField<String>? = null
                private var name: MultipartField<String>? = null
                private var type: MultipartField<Type> = MultipartField.of(JsonMissing.of())
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(audioSample: AudioSample) = apply {
                    this.audioSample = audioSample.audioSample
                    consent = audioSample.consent
                    name = audioSample.name
                    type = audioSample.type
                    additionalProperties = audioSample.additionalProperties.toMutableMap()
                }

                /**
                 * The sample audio recording file. Maximum size is 10 MiB.
                 *
                 * Supported MIME types: `audio/mpeg`, `audio/wav`, `audio/x-wav`, `audio/ogg`,
                 * `audio/aac`, `audio/flac`, `audio/webm`, `audio/mp4`.
                 */
                fun audioSample(audioSample: InputStream) =
                    audioSample(MultipartField.of(audioSample))

                /**
                 * Sets [Builder.audioSample] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.audioSample] with a well-typed [InputStream]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun audioSample(audioSample: MultipartField<InputStream>) = apply {
                    this.audioSample = audioSample
                }

                /** The consent recording ID (for example, `cons_1234`). */
                fun consent(consent: String) = consent(MultipartField.of(consent))

                /**
                 * Sets [Builder.consent] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.consent] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun consent(consent: MultipartField<String>) = apply { this.consent = consent }

                /** The name of the new voice. */
                fun name(name: String) = name(MultipartField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: MultipartField<String>) = apply { this.name = name }

                /** The voice creation method. Defaults to `audio_sample` when omitted. */
                fun type(type: Type) = type(MultipartField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: MultipartField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [AudioSample].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .audioSample()
                 * .consent()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AudioSample =
                    AudioSample(
                        checkRequired("audioSample", audioSample),
                        checkRequired("consent", consent),
                        checkRequired("name", name),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): AudioSample = apply {
                if (validated) {
                    return@apply
                }

                audioSample()
                consent()
                name()
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

            /** The voice creation method. Defaults to `audio_sample` when omitted. */
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

                    @JvmField val AUDIO_SAMPLE = of("audio_sample")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    AUDIO_SAMPLE
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
                    AUDIO_SAMPLE,
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
                        AUDIO_SAMPLE -> Value.AUDIO_SAMPLE
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
                        AUDIO_SAMPLE -> Known.AUDIO_SAMPLE
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
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

                return other is AudioSample &&
                    audioSample == other.audioSample &&
                    consent == other.consent &&
                    name == other.name &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(audioSample, consent, name, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AudioSample{audioSample=$audioSample, consent=$consent, name=$name, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * Creates a synthetic voice from a text description. Supports application/json or
         * multipart/form-data.
         */
        class Prompt
        private constructor(
            private val name: MultipartField<String>,
            private val prompt: MultipartField<String>,
            private val type: JsonValue,
            private val model: MultipartField<Model>,
            private val scriptHint: MultipartField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The name of the new voice.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.value.getRequired("name")

            /**
             * A description of the desired voice. Must not contain only whitespace.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun prompt(): String = prompt.value.getRequired("prompt")

            /**
             * Set to `prompt` to create a voice from a text description.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("prompt")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The voice creation model to use. Defaults to `auto`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<Model> = model.value.getOptional("model")

            /**
             * Optional text for the voice to speak during creation. If omitted, a script is
             * generated from the prompt. Must not be blank after trimming whitespace; scripts that
             * are too short are rejected.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scriptHint(): Optional<String> = scriptHint.value.getOptional("script_hint")

            /**
             * Returns the raw multipart value of [name].
             *
             * Unlike [name], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<String> = name

            /**
             * Returns the raw multipart value of [prompt].
             *
             * Unlike [prompt], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("prompt") @ExcludeMissing fun _prompt(): MultipartField<String> = prompt

            /**
             * Returns the raw multipart value of [model].
             *
             * Unlike [model], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): MultipartField<Model> = model

            /**
             * Returns the raw multipart value of [scriptHint].
             *
             * Unlike [scriptHint], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("script_hint")
            @ExcludeMissing
            fun _scriptHint(): MultipartField<String> = scriptHint

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
                 * Returns a mutable builder for constructing an instance of [Prompt].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .prompt()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Prompt]. */
            class Builder internal constructor() {

                private var name: MultipartField<String>? = null
                private var prompt: MultipartField<String>? = null
                private var type: JsonValue = JsonValue.from("prompt")
                private var model: MultipartField<Model> = MultipartField.of(JsonMissing.of())
                private var scriptHint: MultipartField<String> = MultipartField.of(JsonMissing.of())
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(prompt: Prompt) = apply {
                    name = prompt.name
                    this.prompt = prompt.prompt
                    type = prompt.type
                    model = prompt.model
                    scriptHint = prompt.scriptHint
                    additionalProperties = prompt.additionalProperties.toMutableMap()
                }

                /** The name of the new voice. */
                fun name(name: String) = name(MultipartField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: MultipartField<String>) = apply { this.name = name }

                /** A description of the desired voice. Must not contain only whitespace. */
                fun prompt(prompt: String) = prompt(MultipartField.of(prompt))

                /**
                 * Sets [Builder.prompt] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.prompt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun prompt(prompt: MultipartField<String>) = apply { this.prompt = prompt }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("prompt")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The voice creation model to use. Defaults to `auto`. */
                fun model(model: Model) = model(MultipartField.of(model))

                /**
                 * Sets [Builder.model] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.model] with a well-typed [Model] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: MultipartField<Model>) = apply { this.model = model }

                /**
                 * Sets [model] to an arbitrary [String].
                 *
                 * You should usually call [model] with a well-typed [Model] constant instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun model(value: String) = model(Model.of(value))

                /**
                 * Optional text for the voice to speak during creation. If omitted, a script is
                 * generated from the prompt. Must not be blank after trimming whitespace; scripts
                 * that are too short are rejected.
                 */
                fun scriptHint(scriptHint: String) = scriptHint(MultipartField.of(scriptHint))

                /**
                 * Sets [Builder.scriptHint] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.scriptHint] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun scriptHint(scriptHint: MultipartField<String>) = apply {
                    this.scriptHint = scriptHint
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
                 * Returns an immutable instance of [Prompt].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .prompt()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Prompt =
                    Prompt(
                        checkRequired("name", name),
                        checkRequired("prompt", prompt),
                        type,
                        model,
                        scriptHint,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Prompt = apply {
                if (validated) {
                    return@apply
                }

                name()
                prompt()
                _type().let {
                    if (it != JsonValue.from("prompt")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                model()
                scriptHint()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /** The voice creation model to use. Defaults to `auto`. */
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

                    @JvmField val AUTO = of("auto")

                    @JvmField val _2026_10_01 = of("2026-10-01")

                    @JvmStatic fun of(value: String) = Model(JsonField.of(value))
                }

                /** An enum containing [Model]'s known values. */
                enum class Known {
                    AUTO,
                    _2026_10_01,
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
                    AUTO,
                    _2026_10_01,
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
                        AUTO -> Value.AUTO
                        _2026_10_01 -> Value._2026_10_01
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
                        AUTO -> Known.AUTO
                        _2026_10_01 -> Known._2026_10_01
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
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

                return other is Prompt &&
                    name == other.name &&
                    prompt == other.prompt &&
                    type == other.type &&
                    model == other.model &&
                    scriptHint == other.scriptHint &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(name, prompt, type, model, scriptHint, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Prompt{name=$name, prompt=$prompt, type=$type, model=$model, scriptHint=$scriptHint, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VoiceCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
