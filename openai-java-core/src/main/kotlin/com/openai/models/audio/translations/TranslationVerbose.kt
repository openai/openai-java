// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.transcriptions.TranscriptionSegment
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TranslationVerbose
private constructor(
    private val duration: JsonField<Double>,
    private val language: JsonField<String>,
    private val text: JsonField<String>,
    private val segments: JsonField<List<TranscriptionSegment>>,
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
    ) : this(duration, language, text, segments, mutableMapOf())

    /**
     * The duration of the input audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun duration(): Double = duration.getRequired("duration")

    /**
     * The language of the output translation (always `english`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun language(): String = language.getRequired("language")

    /**
     * The translated text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Segments of the translated text and their corresponding details.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun segments(): Optional<List<TranscriptionSegment>> = segments.getOptional("segments")

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
         * Returns a mutable builder for constructing an instance of [TranslationVerbose].
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

    /** A builder for [TranslationVerbose]. */
    class Builder internal constructor() {

        private var duration: JsonField<Double>? = null
        private var language: JsonField<String>? = null
        private var text: JsonField<String>? = null
        private var segments: JsonField<MutableList<TranscriptionSegment>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(translationVerbose: TranslationVerbose) = apply {
            duration = translationVerbose.duration
            language = translationVerbose.language
            text = translationVerbose.text
            segments = translationVerbose.segments.map { it.toMutableList() }
            additionalProperties = translationVerbose.additionalProperties.toMutableMap()
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

        /** The language of the output translation (always `english`). */
        fun language(language: String) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** The translated text. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Segments of the translated text and their corresponding details. */
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
                (segments ?: JsonField.of(mutableListOf())).also {
                    checkKnown("segments", it).add(segment)
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
         * Returns an immutable instance of [TranslationVerbose].
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
        fun build(): TranslationVerbose =
            TranslationVerbose(
                checkRequired("duration", duration),
                checkRequired("language", language),
                checkRequired("text", text),
                (segments ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranslationVerbose = apply {
        if (validated) {
            return@apply
        }

        duration()
        language()
        text()
        segments().ifPresent { it.forEach { it.validate() } }
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
            (segments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranslationVerbose && duration == other.duration && language == other.language && text == other.text && segments == other.segments && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(duration, language, text, segments, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranslationVerbose{duration=$duration, language=$language, text=$text, segments=$segments, additionalProperties=$additionalProperties}"
}
