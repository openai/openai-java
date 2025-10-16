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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/** A segment of diarized transcript text with speaker metadata. */
class TranscriptionDiarizedSegment
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val end: JsonField<Float>,
    private val speaker: JsonField<String>,
    private val start: JsonField<Float>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("end") @ExcludeMissing end: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("speaker") @ExcludeMissing speaker: JsonField<String> = JsonMissing.of(),
        @JsonProperty("start") @ExcludeMissing start: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, end, speaker, start, text, type, mutableMapOf())

    /**
     * Unique identifier for the segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * End timestamp of the segment in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun end(): Float = end.getRequired("end")

    /**
     * Speaker label for this segment. When known speakers are provided, the label matches
     * `known_speaker_names[]`. Otherwise speakers are labeled sequentially using capital letters
     * (`A`, `B`, ...).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun speaker(): String = speaker.getRequired("speaker")

    /**
     * Start timestamp of the segment in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun start(): Float = start.getRequired("start")

    /**
     * Transcript text for this segment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * The type of the segment. Always `transcript.text.segment`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcript.text.segment")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [end].
     *
     * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<Float> = end

    /**
     * Returns the raw JSON value of [speaker].
     *
     * Unlike [speaker], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("speaker") @ExcludeMissing fun _speaker(): JsonField<String> = speaker

    /**
     * Returns the raw JSON value of [start].
     *
     * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Float> = start

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [TranscriptionDiarizedSegment].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .end()
         * .speaker()
         * .start()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionDiarizedSegment]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var end: JsonField<Float>? = null
        private var speaker: JsonField<String>? = null
        private var start: JsonField<Float>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("transcript.text.segment")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionDiarizedSegment: TranscriptionDiarizedSegment) = apply {
            id = transcriptionDiarizedSegment.id
            end = transcriptionDiarizedSegment.end
            speaker = transcriptionDiarizedSegment.speaker
            start = transcriptionDiarizedSegment.start
            text = transcriptionDiarizedSegment.text
            type = transcriptionDiarizedSegment.type
            additionalProperties = transcriptionDiarizedSegment.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the segment. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** End timestamp of the segment in seconds. */
        fun end(end: Float) = end(JsonField.of(end))

        /**
         * Sets [Builder.end] to an arbitrary JSON value.
         *
         * You should usually call [Builder.end] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun end(end: JsonField<Float>) = apply { this.end = end }

        /**
         * Speaker label for this segment. When known speakers are provided, the label matches
         * `known_speaker_names[]`. Otherwise speakers are labeled sequentially using capital
         * letters (`A`, `B`, ...).
         */
        fun speaker(speaker: String) = speaker(JsonField.of(speaker))

        /**
         * Sets [Builder.speaker] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speaker] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun speaker(speaker: JsonField<String>) = apply { this.speaker = speaker }

        /** Start timestamp of the segment in seconds. */
        fun start(start: Float) = start(JsonField.of(start))

        /**
         * Sets [Builder.start] to an arbitrary JSON value.
         *
         * You should usually call [Builder.start] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun start(start: JsonField<Float>) = apply { this.start = start }

        /** Transcript text for this segment. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcript.text.segment")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [TranscriptionDiarizedSegment].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .end()
         * .speaker()
         * .start()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionDiarizedSegment =
            TranscriptionDiarizedSegment(
                checkRequired("id", id),
                checkRequired("end", end),
                checkRequired("speaker", speaker),
                checkRequired("start", start),
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionDiarizedSegment = apply {
        if (validated) {
            return@apply
        }

        id()
        end()
        speaker()
        start()
        text()
        _type().let {
            if (it != JsonValue.from("transcript.text.segment")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
            (if (end.asKnown().isPresent) 1 else 0) +
            (if (speaker.asKnown().isPresent) 1 else 0) +
            (if (start.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("transcript.text.segment")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionDiarizedSegment &&
            id == other.id &&
            end == other.end &&
            speaker == other.speaker &&
            start == other.start &&
            text == other.text &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, end, speaker, start, text, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionDiarizedSegment{id=$id, end=$end, speaker=$speaker, start=$start, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
