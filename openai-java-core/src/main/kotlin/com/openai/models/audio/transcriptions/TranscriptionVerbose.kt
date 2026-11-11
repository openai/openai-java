// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a verbose json transcription response returned by model, based on the provided input.
 */
class TranscriptionVerbose
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val duration: JsonField<Double>,
    private val language: JsonField<String>,
    private val text: JsonField<String>,
    private val segments: JsonField<List<TranscriptionSegment>>,
    private val usage: JsonField<Usage>,
    private val words: JsonField<List<TranscriptionWord>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("language") @ExcludeMissing language: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("segments")
        @ExcludeMissing
        segments: JsonField<List<TranscriptionSegment>> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
        @JsonProperty("words")
        @ExcludeMissing
        words: JsonField<List<TranscriptionWord>> = JsonMissing.of(),
    ) : this(duration, language, text, segments, usage, words, mutableMapOf())

    /**
     * The duration of the input audio. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun duration(): java.util.Optional<Double> = duration.getOptional("duration")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun durationOrThrow(): Double = duration.getRequired("duration")

    /**
     * The language of the input audio. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun language(): java.util.Optional<String> = language.getOptional("language")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun languageOrThrow(): String = language.getRequired("language")

    /**
     * The transcribed text. The schema requires this property. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun text(): java.util.Optional<String> = text.getOptional("text")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun textOrThrow(): String = text.getRequired("text")

    /**
     * Segments of the transcribed text and their corresponding details. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun segments(): java.util.Optional<List<TranscriptionSegment>> =
        segments.getOptional("segments")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun segmentsOrThrow(): List<TranscriptionSegment> = segments.getRequired("segments")

    /**
     * Usage statistics for models billed by audio input duration. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun usage(): java.util.Optional<Usage> = usage.getOptional("usage")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun usageOrThrow(): Usage = usage.getRequired("usage")

    /**
     * Extracted words and their corresponding timestamps. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun words(): java.util.Optional<List<TranscriptionWord>> = words.getOptional("words")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun wordsOrThrow(): List<TranscriptionWord> = words.getRequired("words")

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Double> = duration

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [segments].
     *
     * Unlike [segments], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("segments")
    @ExcludeMissing
    fun _segments(): JsonField<List<TranscriptionSegment>> = segments

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    /**
     * Returns the raw JSON value of [words].
     *
     * Unlike [words], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("words") @ExcludeMissing fun _words(): JsonField<List<TranscriptionWord>> = words

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "duration" to this.duration,
            "language" to this.language,
            "text" to this.text,
            "segments" to this.segments,
            "usage" to this.usage,
            "words" to this.words,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TranscriptionVerbose].
         *
         * The following fields are required:
         * ```java
         * .duration()
         * .language()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionVerbose]. */
    class Builder internal constructor() {

        private var duration: JsonField<Double>? = null
        private var language: JsonField<String>? = null
        private var text: JsonField<String>? = null
        private var segments: JsonField<MutableList<TranscriptionSegment>>? = null
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var words: JsonField<MutableList<TranscriptionWord>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionVerbose: TranscriptionVerbose) = apply {
            duration = transcriptionVerbose.duration
            language = transcriptionVerbose.language
            text = transcriptionVerbose.text
            segments = transcriptionVerbose.segments.map { it.toMutableList() }
            usage = transcriptionVerbose.usage
            words = transcriptionVerbose.words.map { it.toMutableList() }
            additionalProperties = transcriptionVerbose.additionalProperties.toMutableMap()
        }

        /** The duration of the input audio. */
        fun duration(duration: Double) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun duration(duration: JsonField<Double>) = apply { this.duration = duration }

        /** The language of the input audio. */
        fun language(language: String) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** The transcribed text. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Segments of the transcribed text and their corresponding details. */
        fun segments(segments: List<TranscriptionSegment>) = segments(JsonField.of(segments))

        /**
         * Sets [Builder.segments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.segments] with a well-typed `List<TranscriptionSegment>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun segments(segments: JsonField<List<TranscriptionSegment>>) = apply {
            this.segments = segments.map { it.toMutableList() }
        }

        /**
         * Adds a single [TranscriptionSegment] to [segments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSegment(segment: TranscriptionSegment) = apply {
            segments =
                (segments?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf())).also {
                    checkKnown("segments", it).add(segment)
                }
        }

        /** Usage statistics for models billed by audio input duration. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        /** Extracted words and their corresponding timestamps. */
        fun words(words: List<TranscriptionWord>) = words(JsonField.of(words))

        /**
         * Sets [Builder.words] to an arbitrary JSON value.
         *
         * You should usually call [Builder.words] with a well-typed `List<TranscriptionWord>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun words(words: JsonField<List<TranscriptionWord>>) = apply {
            this.words = words.map { it.toMutableList() }
        }

        /**
         * Adds a single [TranscriptionWord] to [words].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWord(word: TranscriptionWord) = apply {
            words =
                (words?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf())).also {
                    checkKnown("words", it).add(word)
                }
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
         * Returns an immutable instance of [TranscriptionVerbose].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .duration()
         * .language()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionVerbose =
            TranscriptionVerbose(
                checkRequired("duration", duration),
                checkRequired("language", language),
                checkRequired("text", text),
                (segments ?: JsonMissing.of()).map { it.toImmutable() },
                usage,
                (words ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): TranscriptionVerbose = apply {
        if (validated) {
            return@apply
        }

        durationOrThrow()
        languageOrThrow()
        textOrThrow()
        segments().ifPresent { it.forEach { it.validate() } }
        usage().ifPresent { it.validate() }
        words().ifPresent { it.forEach { it.validate() } }
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
        (if (duration.asKnown().isPresent) 1 else 0) +
            (if (language.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (segments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (words.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Usage statistics for models billed by audio input duration. */
    class Usage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val seconds: JsonField<Double>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(seconds, type, mutableMapOf())

        /**
         * Duration of the input audio in seconds. The schema requires this property. Returns empty
         * if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun seconds(): java.util.Optional<Double> = seconds.getOptional("seconds")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun secondsOrThrow(): Double = seconds.getRequired("seconds")

        /**
         * The type of the usage object. Always `duration` for this variant. The schema requires
         * this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("duration")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns the raw JSON value of [seconds].
         *
         * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Double> = seconds

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "seconds" to this.seconds,
                "type" to this.type,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Usage].
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Usage]. */
        class Builder internal constructor() {

            private var seconds: JsonField<Double>? = null
            private var type: JsonValue = JsonValue.from("duration")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                seconds = usage.seconds
                type = usage.type
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** Duration of the input audio in seconds. */
            fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

            /**
             * Sets [Builder.seconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seconds] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun seconds(seconds: JsonField<Double>) = apply { this.seconds = seconds }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("duration")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [Usage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .seconds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Usage =
                Usage(checkRequired("seconds", seconds), type, additionalProperties.toMutableMap())
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
        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            secondsOrThrow()
            typeOrThrow()
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
            (if (seconds.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("duration")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                seconds == other.seconds &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(seconds, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{seconds=$seconds, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionVerbose &&
            duration == other.duration &&
            language == other.language &&
            text == other.text &&
            segments == other.segments &&
            usage == other.usage &&
            words == other.words &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(duration, language, text, segments, usage, words, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionVerbose{duration=$duration, language=$language, text=$text, segments=$segments, usage=$usage, words=$words, additionalProperties=$additionalProperties}"
}
