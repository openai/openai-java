// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects

@NoAutoDetect
class TranscriptionWord
@JsonCreator
private constructor(
    @JsonProperty("end") @ExcludeMissing private val end: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("start") @ExcludeMissing private val start: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("word") @ExcludeMissing private val word: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** End time of the word in seconds. */
    fun end(): Double = end.getRequired("end")

    /** Start time of the word in seconds. */
    fun start(): Double = start.getRequired("start")

    /** The text content of the word. */
    fun word(): String = word.getRequired("word")

    /** End time of the word in seconds. */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<Double> = end

    /** Start time of the word in seconds. */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Double> = start

    /** The text content of the word. */
    @JsonProperty("word") @ExcludeMissing fun _word(): JsonField<String> = word

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TranscriptionWord = apply {
        if (validated) {
            return@apply
        }

        end()
        start()
        word()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TranscriptionWord].
         *
         * The following fields are required:
         * ```java
         * .end()
         * .start()
         * .word()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionWord]. */
    class Builder internal constructor() {

        private var end: JsonField<Double>? = null
        private var start: JsonField<Double>? = null
        private var word: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionWord: TranscriptionWord) = apply {
            end = transcriptionWord.end
            start = transcriptionWord.start
            word = transcriptionWord.word
            additionalProperties = transcriptionWord.additionalProperties.toMutableMap()
        }

        /** End time of the word in seconds. */
        fun end(end: Double) = end(JsonField.of(end))

        /** End time of the word in seconds. */
        fun end(end: JsonField<Double>) = apply { this.end = end }

        /** Start time of the word in seconds. */
        fun start(start: Double) = start(JsonField.of(start))

        /** Start time of the word in seconds. */
        fun start(start: JsonField<Double>) = apply { this.start = start }

        /** The text content of the word. */
        fun word(word: String) = word(JsonField.of(word))

        /** The text content of the word. */
        fun word(word: JsonField<String>) = apply { this.word = word }

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

        fun build(): TranscriptionWord =
            TranscriptionWord(
                checkRequired("end", end),
                checkRequired("start", start),
                checkRequired("word", word),
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionWord && end == other.end && start == other.start && word == other.word && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(end, start, word, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionWord{end=$end, start=$start, word=$word, additionalProperties=$additionalProperties}"
}
