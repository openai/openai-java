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

class AudioTranscription
private constructor(
    private val language: JsonField<String>,
    private val model: JsonField<Model>,
    private val prompt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("language") @ExcludeMissing language: JsonField<String> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
        @JsonProperty("prompt") @ExcludeMissing prompt: JsonField<String> = JsonMissing.of(),
    ) : this(language, model, prompt, mutableMapOf())

    /**
     * The language of the input audio. Supplying the input language in
     * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format will
     * improve accuracy and latency.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<String> = language.getOptional("language")

    /**
     * The model to use for transcription. Current options are `whisper-1`,
     * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, and `gpt-4o-transcribe`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<Model> = model.getOptional("model")

    /**
     * An optional text to guide the model's style or continue a previous audio segment. For
     * `whisper-1`, the
     * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
     * For `gpt-4o-transcribe` models, the prompt is a free text string, for example "expect words
     * related to technology".
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun prompt(): Optional<String> = prompt.getOptional("prompt")

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
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

        /** Returns a mutable builder for constructing an instance of [AudioTranscription]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AudioTranscription]. */
    class Builder internal constructor() {

        private var language: JsonField<String> = JsonMissing.of()
        private var model: JsonField<Model> = JsonMissing.of()
        private var prompt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audioTranscription: AudioTranscription) = apply {
            language = audioTranscription.language
            model = audioTranscription.model
            prompt = audioTranscription.prompt
            additionalProperties = audioTranscription.additionalProperties.toMutableMap()
        }

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) (e.g. `en`) format
         * will improve accuracy and latency.
         */
        fun language(language: String) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /**
         * The model to use for transcription. Current options are `whisper-1`,
         * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, and `gpt-4o-transcribe`.
         */
        fun model(model: Model) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [Model] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<Model>) = apply { this.model = model }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. For
         * `whisper-1`, the
         * [prompt is a list of keywords](https://platform.openai.com/docs/guides/speech-to-text#prompting).
         * For `gpt-4o-transcribe` models, the prompt is a free text string, for example "expect
         * words related to technology".
         */
        fun prompt(prompt: String) = prompt(JsonField.of(prompt))

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

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
         * Returns an immutable instance of [AudioTranscription].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AudioTranscription =
            AudioTranscription(language, model, prompt, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): AudioTranscription = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
     * `gpt-4o-transcribe-latest`, `gpt-4o-mini-transcribe`, and `gpt-4o-transcribe`.
     */
    class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val WHISPER_1 = of("whisper-1")

            @JvmField val GPT_4O_TRANSCRIBE_LATEST = of("gpt-4o-transcribe-latest")

            @JvmField val GPT_4O_MINI_TRANSCRIBE = of("gpt-4o-mini-transcribe")

            @JvmField val GPT_4O_TRANSCRIBE = of("gpt-4o-transcribe")

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        /** An enum containing [Model]'s known values. */
        enum class Known {
            WHISPER_1,
            GPT_4O_TRANSCRIBE_LATEST,
            GPT_4O_MINI_TRANSCRIBE,
            GPT_4O_TRANSCRIBE,
        }

        /**
         * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Model] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            WHISPER_1,
            GPT_4O_TRANSCRIBE_LATEST,
            GPT_4O_MINI_TRANSCRIBE,
            GPT_4O_TRANSCRIBE,
            /** An enum member indicating that [Model] was instantiated with an unknown value. */
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
                WHISPER_1 -> Value.WHISPER_1
                GPT_4O_TRANSCRIBE_LATEST -> Value.GPT_4O_TRANSCRIBE_LATEST
                GPT_4O_MINI_TRANSCRIBE -> Value.GPT_4O_MINI_TRANSCRIBE
                GPT_4O_TRANSCRIBE -> Value.GPT_4O_TRANSCRIBE
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
                WHISPER_1 -> Known.WHISPER_1
                GPT_4O_TRANSCRIBE_LATEST -> Known.GPT_4O_TRANSCRIBE_LATEST
                GPT_4O_MINI_TRANSCRIBE -> Known.GPT_4O_MINI_TRANSCRIBE
                GPT_4O_TRANSCRIBE -> Known.GPT_4O_TRANSCRIBE
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

        return other is AudioTranscription &&
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
        "AudioTranscription{language=$language, model=$model, prompt=$prompt, additionalProperties=$additionalProperties}"
}
