// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import java.util.Objects

@NoAutoDetect
class TranscriptionSegment
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("avg_logprob")
    @ExcludeMissing
    private val avgLogprob: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("compression_ratio")
    @ExcludeMissing
    private val compressionRatio: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("end") @ExcludeMissing private val end: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("no_speech_prob")
    @ExcludeMissing
    private val noSpeechProb: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("seek") @ExcludeMissing private val seek: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("start") @ExcludeMissing private val start: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("temperature")
    @ExcludeMissing
    private val temperature: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonProperty("tokens")
    @ExcludeMissing
    private val tokens: JsonField<List<Long>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Unique identifier of the segment. */
    fun id(): Long = id.getRequired("id")

    /**
     * Average logprob of the segment. If the value is lower than -1, consider the logprobs failed.
     */
    fun avgLogprob(): Double = avgLogprob.getRequired("avg_logprob")

    /**
     * Compression ratio of the segment. If the value is greater than 2.4, consider the compression
     * failed.
     */
    fun compressionRatio(): Double = compressionRatio.getRequired("compression_ratio")

    /** End time of the segment in seconds. */
    fun end(): Double = end.getRequired("end")

    /**
     * Probability of no speech in the segment. If the value is higher than 1.0 and the
     * `avg_logprob` is below -1, consider this segment silent.
     */
    fun noSpeechProb(): Double = noSpeechProb.getRequired("no_speech_prob")

    /** Seek offset of the segment. */
    fun seek(): Long = seek.getRequired("seek")

    /** Start time of the segment in seconds. */
    fun start(): Double = start.getRequired("start")

    /** Temperature parameter used for generating the segment. */
    fun temperature(): Double = temperature.getRequired("temperature")

    /** Text content of the segment. */
    fun text(): String = text.getRequired("text")

    /** Array of token IDs for the text content. */
    fun tokens(): List<Long> = tokens.getRequired("tokens")

    /** Unique identifier of the segment. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Long> = id

    /**
     * Average logprob of the segment. If the value is lower than -1, consider the logprobs failed.
     */
    @JsonProperty("avg_logprob") @ExcludeMissing fun _avgLogprob(): JsonField<Double> = avgLogprob

    /**
     * Compression ratio of the segment. If the value is greater than 2.4, consider the compression
     * failed.
     */
    @JsonProperty("compression_ratio")
    @ExcludeMissing
    fun _compressionRatio(): JsonField<Double> = compressionRatio

    /** End time of the segment in seconds. */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<Double> = end

    /**
     * Probability of no speech in the segment. If the value is higher than 1.0 and the
     * `avg_logprob` is below -1, consider this segment silent.
     */
    @JsonProperty("no_speech_prob")
    @ExcludeMissing
    fun _noSpeechProb(): JsonField<Double> = noSpeechProb

    /** Seek offset of the segment. */
    @JsonProperty("seek") @ExcludeMissing fun _seek(): JsonField<Long> = seek

    /** Start time of the segment in seconds. */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Double> = start

    /** Temperature parameter used for generating the segment. */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /** Text content of the segment. */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /** Array of token IDs for the text content. */
    @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<Long>> = tokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TranscriptionSegment = apply {
        if (validated) {
            return@apply
        }

        id()
        avgLogprob()
        compressionRatio()
        end()
        noSpeechProb()
        seek()
        start()
        temperature()
        text()
        tokens()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TranscriptionSegment].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .avgLogprob()
         * .compressionRatio()
         * .end()
         * .noSpeechProb()
         * .seek()
         * .start()
         * .temperature()
         * .text()
         * .tokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionSegment]. */
    class Builder internal constructor() {

        private var id: JsonField<Long>? = null
        private var avgLogprob: JsonField<Double>? = null
        private var compressionRatio: JsonField<Double>? = null
        private var end: JsonField<Double>? = null
        private var noSpeechProb: JsonField<Double>? = null
        private var seek: JsonField<Long>? = null
        private var start: JsonField<Double>? = null
        private var temperature: JsonField<Double>? = null
        private var text: JsonField<String>? = null
        private var tokens: JsonField<MutableList<Long>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionSegment: TranscriptionSegment) = apply {
            id = transcriptionSegment.id
            avgLogprob = transcriptionSegment.avgLogprob
            compressionRatio = transcriptionSegment.compressionRatio
            end = transcriptionSegment.end
            noSpeechProb = transcriptionSegment.noSpeechProb
            seek = transcriptionSegment.seek
            start = transcriptionSegment.start
            temperature = transcriptionSegment.temperature
            text = transcriptionSegment.text
            tokens = transcriptionSegment.tokens.map { it.toMutableList() }
            additionalProperties = transcriptionSegment.additionalProperties.toMutableMap()
        }

        /** Unique identifier of the segment. */
        fun id(id: Long) = id(JsonField.of(id))

        /** Unique identifier of the segment. */
        fun id(id: JsonField<Long>) = apply { this.id = id }

        /**
         * Average logprob of the segment. If the value is lower than -1, consider the logprobs
         * failed.
         */
        fun avgLogprob(avgLogprob: Double) = avgLogprob(JsonField.of(avgLogprob))

        /**
         * Average logprob of the segment. If the value is lower than -1, consider the logprobs
         * failed.
         */
        fun avgLogprob(avgLogprob: JsonField<Double>) = apply { this.avgLogprob = avgLogprob }

        /**
         * Compression ratio of the segment. If the value is greater than 2.4, consider the
         * compression failed.
         */
        fun compressionRatio(compressionRatio: Double) =
            compressionRatio(JsonField.of(compressionRatio))

        /**
         * Compression ratio of the segment. If the value is greater than 2.4, consider the
         * compression failed.
         */
        fun compressionRatio(compressionRatio: JsonField<Double>) = apply {
            this.compressionRatio = compressionRatio
        }

        /** End time of the segment in seconds. */
        fun end(end: Double) = end(JsonField.of(end))

        /** End time of the segment in seconds. */
        fun end(end: JsonField<Double>) = apply { this.end = end }

        /**
         * Probability of no speech in the segment. If the value is higher than 1.0 and the
         * `avg_logprob` is below -1, consider this segment silent.
         */
        fun noSpeechProb(noSpeechProb: Double) = noSpeechProb(JsonField.of(noSpeechProb))

        /**
         * Probability of no speech in the segment. If the value is higher than 1.0 and the
         * `avg_logprob` is below -1, consider this segment silent.
         */
        fun noSpeechProb(noSpeechProb: JsonField<Double>) = apply {
            this.noSpeechProb = noSpeechProb
        }

        /** Seek offset of the segment. */
        fun seek(seek: Long) = seek(JsonField.of(seek))

        /** Seek offset of the segment. */
        fun seek(seek: JsonField<Long>) = apply { this.seek = seek }

        /** Start time of the segment in seconds. */
        fun start(start: Double) = start(JsonField.of(start))

        /** Start time of the segment in seconds. */
        fun start(start: JsonField<Double>) = apply { this.start = start }

        /** Temperature parameter used for generating the segment. */
        fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

        /** Temperature parameter used for generating the segment. */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /** Text content of the segment. */
        fun text(text: String) = text(JsonField.of(text))

        /** Text content of the segment. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Array of token IDs for the text content. */
        fun tokens(tokens: List<Long>) = tokens(JsonField.of(tokens))

        /** Array of token IDs for the text content. */
        fun tokens(tokens: JsonField<List<Long>>) = apply {
            this.tokens = tokens.map { it.toMutableList() }
        }

        /** Array of token IDs for the text content. */
        fun addToken(token: Long) = apply {
            tokens =
                (tokens ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tokens", it).add(token)
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

        fun build(): TranscriptionSegment =
            TranscriptionSegment(
                checkRequired("id", id),
                checkRequired("avgLogprob", avgLogprob),
                checkRequired("compressionRatio", compressionRatio),
                checkRequired("end", end),
                checkRequired("noSpeechProb", noSpeechProb),
                checkRequired("seek", seek),
                checkRequired("start", start),
                checkRequired("temperature", temperature),
                checkRequired("text", text),
                checkRequired("tokens", tokens).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranscriptionSegment && id == other.id && avgLogprob == other.avgLogprob && compressionRatio == other.compressionRatio && end == other.end && noSpeechProb == other.noSpeechProb && seek == other.seek && start == other.start && temperature == other.temperature && text == other.text && tokens == other.tokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, avgLogprob, compressionRatio, end, noSpeechProb, seek, start, temperature, text, tokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSegment{id=$id, avgLogprob=$avgLogprob, compressionRatio=$compressionRatio, end=$end, noSpeechProb=$noSpeechProb, seek=$seek, start=$start, temperature=$temperature, text=$text, tokens=$tokens, additionalProperties=$additionalProperties}"
}
