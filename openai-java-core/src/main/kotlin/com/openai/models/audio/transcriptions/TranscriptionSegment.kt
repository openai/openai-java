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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class TranscriptionSegment
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<Long>,
    private val avgLogprob: JsonField<Float>,
    private val compressionRatio: JsonField<Float>,
    private val end: JsonField<Float>,
    private val noSpeechProb: JsonField<Float>,
    private val seek: JsonField<Long>,
    private val start: JsonField<Float>,
    private val temperature: JsonField<Float>,
    private val text: JsonField<String>,
    private val tokens: JsonField<List<Long>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("avg_logprob")
        @ExcludeMissing
        avgLogprob: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("compression_ratio")
        @ExcludeMissing
        compressionRatio: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("end") @ExcludeMissing end: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("no_speech_prob")
        @ExcludeMissing
        noSpeechProb: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("seek") @ExcludeMissing seek: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("start") @ExcludeMissing start: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tokens") @ExcludeMissing tokens: JsonField<List<Long>> = JsonMissing.of(),
    ) : this(
        id,
        avgLogprob,
        compressionRatio,
        end,
        noSpeechProb,
        seek,
        start,
        temperature,
        text,
        tokens,
        mutableMapOf(),
    )

    /**
     * Unique identifier of the segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): Long = id.getRequired("id")

    /**
     * Average logprob of the segment. If the value is lower than -1, consider the logprobs failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun avgLogprob(): Float = avgLogprob.getRequired("avg_logprob")

    /**
     * Compression ratio of the segment. If the value is greater than 2.4, consider the compression
     * failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun compressionRatio(): Float = compressionRatio.getRequired("compression_ratio")

    /**
     * End time of the segment in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun end(): Float = end.getRequired("end")

    /**
     * Probability of no speech in the segment. If the value is higher than 1.0 and the
     * `avg_logprob` is below -1, consider this segment silent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun noSpeechProb(): Float = noSpeechProb.getRequired("no_speech_prob")

    /**
     * Seek offset of the segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seek(): Long = seek.getRequired("seek")

    /**
     * Start time of the segment in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun start(): Float = start.getRequired("start")

    /**
     * Temperature parameter used for generating the segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun temperature(): Float = temperature.getRequired("temperature")

    /**
     * Text content of the segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Array of token IDs for the text content.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokens(): List<Long> = tokens.getRequired("tokens")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Long> = id

    /**
     * Returns the raw JSON value of [avgLogprob].
     *
     * Unlike [avgLogprob], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("avg_logprob") @ExcludeMissing fun _avgLogprob(): JsonField<Float> = avgLogprob

    /**
     * Returns the raw JSON value of [compressionRatio].
     *
     * Unlike [compressionRatio], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("compression_ratio")
    @ExcludeMissing
    fun _compressionRatio(): JsonField<Float> = compressionRatio

    /**
     * Returns the raw JSON value of [end].
     *
     * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<Float> = end

    /**
     * Returns the raw JSON value of [noSpeechProb].
     *
     * Unlike [noSpeechProb], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("no_speech_prob")
    @ExcludeMissing
    fun _noSpeechProb(): JsonField<Float> = noSpeechProb

    /**
     * Returns the raw JSON value of [seek].
     *
     * Unlike [seek], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seek") @ExcludeMissing fun _seek(): JsonField<Long> = seek

    /**
     * Returns the raw JSON value of [start].
     *
     * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Float> = start

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Float> = temperature

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [tokens].
     *
     * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<Long>> = tokens

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
        private var avgLogprob: JsonField<Float>? = null
        private var compressionRatio: JsonField<Float>? = null
        private var end: JsonField<Float>? = null
        private var noSpeechProb: JsonField<Float>? = null
        private var seek: JsonField<Long>? = null
        private var start: JsonField<Float>? = null
        private var temperature: JsonField<Float>? = null
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

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Long>) = apply { this.id = id }

        /**
         * Average logprob of the segment. If the value is lower than -1, consider the logprobs
         * failed.
         */
        fun avgLogprob(avgLogprob: Float) = avgLogprob(JsonField.of(avgLogprob))

        /**
         * Sets [Builder.avgLogprob] to an arbitrary JSON value.
         *
         * You should usually call [Builder.avgLogprob] with a well-typed [Float] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun avgLogprob(avgLogprob: JsonField<Float>) = apply { this.avgLogprob = avgLogprob }

        /**
         * Compression ratio of the segment. If the value is greater than 2.4, consider the
         * compression failed.
         */
        fun compressionRatio(compressionRatio: Float) =
            compressionRatio(JsonField.of(compressionRatio))

        /**
         * Sets [Builder.compressionRatio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compressionRatio] with a well-typed [Float] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compressionRatio(compressionRatio: JsonField<Float>) = apply {
            this.compressionRatio = compressionRatio
        }

        /** End time of the segment in seconds. */
        fun end(end: Float) = end(JsonField.of(end))

        /**
         * Sets [Builder.end] to an arbitrary JSON value.
         *
         * You should usually call [Builder.end] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun end(end: JsonField<Float>) = apply { this.end = end }

        /**
         * Probability of no speech in the segment. If the value is higher than 1.0 and the
         * `avg_logprob` is below -1, consider this segment silent.
         */
        fun noSpeechProb(noSpeechProb: Float) = noSpeechProb(JsonField.of(noSpeechProb))

        /**
         * Sets [Builder.noSpeechProb] to an arbitrary JSON value.
         *
         * You should usually call [Builder.noSpeechProb] with a well-typed [Float] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun noSpeechProb(noSpeechProb: JsonField<Float>) = apply {
            this.noSpeechProb = noSpeechProb
        }

        /** Seek offset of the segment. */
        fun seek(seek: Long) = seek(JsonField.of(seek))

        /**
         * Sets [Builder.seek] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seek] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seek(seek: JsonField<Long>) = apply { this.seek = seek }

        /** Start time of the segment in seconds. */
        fun start(start: Float) = start(JsonField.of(start))

        /**
         * Sets [Builder.start] to an arbitrary JSON value.
         *
         * You should usually call [Builder.start] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun start(start: JsonField<Float>) = apply { this.start = start }

        /** Temperature parameter used for generating the segment. */
        fun temperature(temperature: Float) = temperature(JsonField.of(temperature))

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Float] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Float>) = apply { this.temperature = temperature }

        /** Text content of the segment. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Array of token IDs for the text content. */
        fun tokens(tokens: List<Long>) = tokens(JsonField.of(tokens))

        /**
         * Sets [Builder.tokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokens] with a well-typed `List<Long>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokens(tokens: JsonField<List<Long>>) = apply {
            this.tokens = tokens.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [tokens].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
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

        /**
         * Returns an immutable instance of [TranscriptionSegment].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
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
         *
         * @throws IllegalStateException if any required field is unset.
         */
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
                additionalProperties.toMutableMap(),
            )
    }

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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (avgLogprob.asKnown().isPresent) 1 else 0) +
            (if (compressionRatio.asKnown().isPresent) 1 else 0) +
            (if (end.asKnown().isPresent) 1 else 0) +
            (if (noSpeechProb.asKnown().isPresent) 1 else 0) +
            (if (seek.asKnown().isPresent) 1 else 0) +
            (if (start.asKnown().isPresent) 1 else 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (tokens.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionSegment &&
            id == other.id &&
            avgLogprob == other.avgLogprob &&
            compressionRatio == other.compressionRatio &&
            end == other.end &&
            noSpeechProb == other.noSpeechProb &&
            seek == other.seek &&
            start == other.start &&
            temperature == other.temperature &&
            text == other.text &&
            tokens == other.tokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            avgLogprob,
            compressionRatio,
            end,
            noSpeechProb,
            seek,
            start,
            temperature,
            text,
            tokens,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionSegment{id=$id, avgLogprob=$avgLogprob, compressionRatio=$compressionRatio, end=$end, noSpeechProb=$noSpeechProb, seek=$seek, start=$start, temperature=$temperature, text=$text, tokens=$tokens, additionalProperties=$additionalProperties}"
}
