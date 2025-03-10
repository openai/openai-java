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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.models.audio.transcriptions.TranscriptionSegment
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class TranslationVerbose
@JsonCreator
private constructor(
    @JsonProperty("duration")
    @ExcludeMissing
    private val duration: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("language")
    @ExcludeMissing
    private val language: JsonField<String> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("segments")
    @ExcludeMissing
    private val segments: JsonField<List<TranscriptionSegment>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The duration of the input audio. */
    fun duration(): Double = duration.getRequired("duration")

    /** The language of the output translation (always `english`). */
    fun language(): String = language.getRequired("language")

    /** The translated text. */
    fun text(): String = text.getRequired("text")

    /** Segments of the translated text and their corresponding details. */
    fun segments(): Optional<List<TranscriptionSegment>> =
        Optional.ofNullable(segments.getNullable("segments"))

    /** The duration of the input audio. */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Double> = duration

    /** The language of the output translation (always `english`). */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

    /** The translated text. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** Segments of the translated text and their corresponding details. */
    @JsonProperty("segments")
    @ExcludeMissing
    fun _segments(): JsonField<List<TranscriptionSegment>> = segments

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /** The duration of the input audio. */
        fun duration(duration: JsonField<Double>) = apply { this.duration = duration }

        /** The language of the output translation (always `english`). */
        fun language(language: String) = language(JsonField.of(language))

        /** The language of the output translation (always `english`). */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** The translated text. */
        fun text(text: String) = text(JsonField.of(text))

        /** The translated text. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Segments of the translated text and their corresponding details. */
        fun segments(segments: List<TranscriptionSegment>) = segments(JsonField.of(segments))

        /** Segments of the translated text and their corresponding details. */
        fun segments(segments: JsonField<List<TranscriptionSegment>>) = apply {
            this.segments = segments.map { it.toMutableList() }
        }

        /** Segments of the translated text and their corresponding details. */
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

        fun build(): TranslationVerbose =
            TranslationVerbose(
                checkRequired("duration", duration),
                checkRequired("language", language),
                checkRequired("text", text),
                (segments ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

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
