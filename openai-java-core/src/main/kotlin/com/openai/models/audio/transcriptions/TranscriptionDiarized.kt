// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a diarized transcription response returned by the model, including the combined
 * transcript and speaker-segment annotations.
 */
class TranscriptionDiarized
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val duration: JsonField<Double>,
    private val segments: JsonField<List<TranscriptionDiarizedSegment>>,
    private val task: JsonValue,
    private val text: JsonField<String>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("segments")
        @ExcludeMissing
        segments: JsonField<List<TranscriptionDiarizedSegment>> = JsonMissing.of(),
        @JsonProperty("task") @ExcludeMissing task: JsonValue = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
    ) : this(duration, segments, task, text, usage, mutableMapOf())

    /**
     * Duration of the input audio in seconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun duration(): Double = duration.getRequired("duration")

    /**
     * Segments of the transcript annotated with timestamps and speaker labels.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun segments(): List<TranscriptionDiarizedSegment> = segments.getRequired("segments")

    /**
     * The type of task that was run. Always `transcribe`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("transcribe")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("task") @ExcludeMissing fun _task(): JsonValue = task

    /**
     * The concatenated transcript text for the entire audio input.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Token or duration usage statistics for the request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<Usage> = usage.getOptional("usage")

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Double> = duration

    /**
     * Returns the raw JSON value of [segments].
     *
     * Unlike [segments], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("segments")
    @ExcludeMissing
    fun _segments(): JsonField<List<TranscriptionDiarizedSegment>> = segments

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
         * Returns a mutable builder for constructing an instance of [TranscriptionDiarized].
         *
         * The following fields are required:
         * ```java
         * .duration()
         * .segments()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TranscriptionDiarized]. */
    class Builder internal constructor() {

        private var duration: JsonField<Double>? = null
        private var segments: JsonField<MutableList<TranscriptionDiarizedSegment>>? = null
        private var task: JsonValue = JsonValue.from("transcribe")
        private var text: JsonField<String>? = null
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transcriptionDiarized: TranscriptionDiarized) = apply {
            duration = transcriptionDiarized.duration
            segments = transcriptionDiarized.segments.map { it.toMutableList() }
            task = transcriptionDiarized.task
            text = transcriptionDiarized.text
            usage = transcriptionDiarized.usage
            additionalProperties = transcriptionDiarized.additionalProperties.toMutableMap()
        }

        /** Duration of the input audio in seconds. */
        fun duration(duration: Double) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun duration(duration: JsonField<Double>) = apply { this.duration = duration }

        /** Segments of the transcript annotated with timestamps and speaker labels. */
        fun segments(segments: List<TranscriptionDiarizedSegment>) =
            segments(JsonField.of(segments))

        /**
         * Sets [Builder.segments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.segments] with a well-typed
         * `List<TranscriptionDiarizedSegment>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun segments(segments: JsonField<List<TranscriptionDiarizedSegment>>) = apply {
            this.segments = segments.map { it.toMutableList() }
        }

        /**
         * Adds a single [TranscriptionDiarizedSegment] to [segments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSegment(segment: TranscriptionDiarizedSegment) = apply {
            segments =
                (segments ?: JsonField.of(mutableListOf())).also {
                    checkKnown("segments", it).add(segment)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("transcribe")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun task(task: JsonValue) = apply { this.task = task }

        /** The concatenated transcript text for the entire audio input. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** Token or duration usage statistics for the request. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        /** Alias for calling [usage] with `Usage.ofTokens(tokens)`. */
        fun usage(tokens: Usage.Tokens) = usage(Usage.ofTokens(tokens))

        /** Alias for calling [usage] with `Usage.ofDuration(duration)`. */
        fun usage(duration: Usage.Duration) = usage(Usage.ofDuration(duration))

        /**
         * Alias for calling [usage] with the following:
         * ```java
         * Usage.Duration.builder()
         *     .seconds(seconds)
         *     .build()
         * ```
         */
        fun durationUsage(seconds: Double) =
            usage(Usage.Duration.builder().seconds(seconds).build())

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
         * Returns an immutable instance of [TranscriptionDiarized].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .duration()
         * .segments()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TranscriptionDiarized =
            TranscriptionDiarized(
                checkRequired("duration", duration),
                checkRequired("segments", segments).map { it.toImmutable() },
                task,
                checkRequired("text", text),
                usage,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TranscriptionDiarized = apply {
        if (validated) {
            return@apply
        }

        duration()
        segments().forEach { it.validate() }
        _task().let {
            if (it != JsonValue.from("transcribe")) {
                throw OpenAIInvalidDataException("'task' is invalid, received $it")
            }
        }
        text()
        usage().ifPresent { it.validate() }
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
            (segments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            task.let { if (it == JsonValue.from("transcribe")) 1 else 0 } +
            (if (text.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    /** Token or duration usage statistics for the request. */
    @JsonDeserialize(using = Usage.Deserializer::class)
    @JsonSerialize(using = Usage.Serializer::class)
    class Usage
    private constructor(
        private val tokens: Tokens? = null,
        private val duration: Duration? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Usage statistics for models billed by token usage. */
        fun tokens(): Optional<Tokens> = Optional.ofNullable(tokens)

        /** Usage statistics for models billed by audio input duration. */
        fun duration(): Optional<Duration> = Optional.ofNullable(duration)

        fun isTokens(): Boolean = tokens != null

        fun isDuration(): Boolean = duration != null

        /** Usage statistics for models billed by token usage. */
        fun asTokens(): Tokens = tokens.getOrThrow("tokens")

        /** Usage statistics for models billed by audio input duration. */
        fun asDuration(): Duration = duration.getOrThrow("duration")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                tokens != null -> visitor.visitTokens(tokens)
                duration != null -> visitor.visitDuration(duration)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTokens(tokens: Tokens) {
                        tokens.validate()
                    }

                    override fun visitDuration(duration: Duration) {
                        duration.validate()
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitTokens(tokens: Tokens) = tokens.validity()

                    override fun visitDuration(duration: Duration) = duration.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage && tokens == other.tokens && duration == other.duration
        }

        override fun hashCode(): Int = Objects.hash(tokens, duration)

        override fun toString(): String =
            when {
                tokens != null -> "Usage{tokens=$tokens}"
                duration != null -> "Usage{duration=$duration}"
                _json != null -> "Usage{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Usage")
            }

        companion object {

            /** Usage statistics for models billed by token usage. */
            @JvmStatic fun ofTokens(tokens: Tokens) = Usage(tokens = tokens)

            /** Usage statistics for models billed by audio input duration. */
            @JvmStatic fun ofDuration(duration: Duration) = Usage(duration = duration)
        }

        /** An interface that defines how to map each variant of [Usage] to a value of type [T]. */
        interface Visitor<out T> {

            /** Usage statistics for models billed by token usage. */
            fun visitTokens(tokens: Tokens): T

            /** Usage statistics for models billed by audio input duration. */
            fun visitDuration(duration: Duration): T

            /**
             * Maps an unknown variant of [Usage] to a value of type [T].
             *
             * An instance of [Usage] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Usage: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Usage>(Usage::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Usage {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "tokens" -> {
                        return tryDeserialize(node, jacksonTypeRef<Tokens>())?.let {
                            Usage(tokens = it, _json = json)
                        } ?: Usage(_json = json)
                    }
                    "duration" -> {
                        return tryDeserialize(node, jacksonTypeRef<Duration>())?.let {
                            Usage(duration = it, _json = json)
                        } ?: Usage(_json = json)
                    }
                }

                return Usage(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Usage>(Usage::class) {

            override fun serialize(
                value: Usage,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.tokens != null -> generator.writeObject(value.tokens)
                    value.duration != null -> generator.writeObject(value.duration)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Usage")
                }
            }
        }

        /** Usage statistics for models billed by token usage. */
        class Tokens
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val inputTokens: JsonField<Long>,
            private val outputTokens: JsonField<Long>,
            private val totalTokens: JsonField<Long>,
            private val type: JsonValue,
            private val inputTokenDetails: JsonField<InputTokenDetails>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input_tokens")
                @ExcludeMissing
                inputTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("output_tokens")
                @ExcludeMissing
                outputTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("total_tokens")
                @ExcludeMissing
                totalTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("input_token_details")
                @ExcludeMissing
                inputTokenDetails: JsonField<InputTokenDetails> = JsonMissing.of(),
            ) : this(
                inputTokens,
                outputTokens,
                totalTokens,
                type,
                inputTokenDetails,
                mutableMapOf(),
            )

            /**
             * Number of input tokens billed for this request.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

            /**
             * Number of output tokens generated.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

            /**
             * Total number of tokens used (input + output).
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

            /**
             * The type of the usage object. Always `tokens` for this variant.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("tokens")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Details about the input tokens billed for this request.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun inputTokenDetails(): Optional<InputTokenDetails> =
                inputTokenDetails.getOptional("input_token_details")

            /**
             * Returns the raw JSON value of [inputTokens].
             *
             * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("input_tokens")
            @ExcludeMissing
            fun _inputTokens(): JsonField<Long> = inputTokens

            /**
             * Returns the raw JSON value of [outputTokens].
             *
             * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("output_tokens")
            @ExcludeMissing
            fun _outputTokens(): JsonField<Long> = outputTokens

            /**
             * Returns the raw JSON value of [totalTokens].
             *
             * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun _totalTokens(): JsonField<Long> = totalTokens

            /**
             * Returns the raw JSON value of [inputTokenDetails].
             *
             * Unlike [inputTokenDetails], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("input_token_details")
            @ExcludeMissing
            fun _inputTokenDetails(): JsonField<InputTokenDetails> = inputTokenDetails

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
                 * Returns a mutable builder for constructing an instance of [Tokens].
                 *
                 * The following fields are required:
                 * ```java
                 * .inputTokens()
                 * .outputTokens()
                 * .totalTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tokens]. */
            class Builder internal constructor() {

                private var inputTokens: JsonField<Long>? = null
                private var outputTokens: JsonField<Long>? = null
                private var totalTokens: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("tokens")
                private var inputTokenDetails: JsonField<InputTokenDetails> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tokens: Tokens) = apply {
                    inputTokens = tokens.inputTokens
                    outputTokens = tokens.outputTokens
                    totalTokens = tokens.totalTokens
                    type = tokens.type
                    inputTokenDetails = tokens.inputTokenDetails
                    additionalProperties = tokens.additionalProperties.toMutableMap()
                }

                /** Number of input tokens billed for this request. */
                fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                /**
                 * Sets [Builder.inputTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inputTokens(inputTokens: JsonField<Long>) = apply {
                    this.inputTokens = inputTokens
                }

                /** Number of output tokens generated. */
                fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

                /**
                 * Sets [Builder.outputTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.outputTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun outputTokens(outputTokens: JsonField<Long>) = apply {
                    this.outputTokens = outputTokens
                }

                /** Total number of tokens used (input + output). */
                fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

                /**
                 * Sets [Builder.totalTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalTokens(totalTokens: JsonField<Long>) = apply {
                    this.totalTokens = totalTokens
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("tokens")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** Details about the input tokens billed for this request. */
                fun inputTokenDetails(inputTokenDetails: InputTokenDetails) =
                    inputTokenDetails(JsonField.of(inputTokenDetails))

                /**
                 * Sets [Builder.inputTokenDetails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inputTokenDetails] with a well-typed
                 * [InputTokenDetails] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun inputTokenDetails(inputTokenDetails: JsonField<InputTokenDetails>) = apply {
                    this.inputTokenDetails = inputTokenDetails
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
                 * Returns an immutable instance of [Tokens].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .inputTokens()
                 * .outputTokens()
                 * .totalTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Tokens =
                    Tokens(
                        checkRequired("inputTokens", inputTokens),
                        checkRequired("outputTokens", outputTokens),
                        checkRequired("totalTokens", totalTokens),
                        type,
                        inputTokenDetails,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Tokens = apply {
                if (validated) {
                    return@apply
                }

                inputTokens()
                outputTokens()
                totalTokens()
                _type().let {
                    if (it != JsonValue.from("tokens")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                inputTokenDetails().ifPresent { it.validate() }
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
                (if (inputTokens.asKnown().isPresent) 1 else 0) +
                    (if (outputTokens.asKnown().isPresent) 1 else 0) +
                    (if (totalTokens.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("tokens")) 1 else 0 } +
                    (inputTokenDetails.asKnown().getOrNull()?.validity() ?: 0)

            /** Details about the input tokens billed for this request. */
            class InputTokenDetails
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val audioTokens: JsonField<Long>,
                private val textTokens: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("audio_tokens")
                    @ExcludeMissing
                    audioTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("text_tokens")
                    @ExcludeMissing
                    textTokens: JsonField<Long> = JsonMissing.of(),
                ) : this(audioTokens, textTokens, mutableMapOf())

                /**
                 * Number of audio tokens billed for this request.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun audioTokens(): Optional<Long> = audioTokens.getOptional("audio_tokens")

                /**
                 * Number of text tokens billed for this request.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun textTokens(): Optional<Long> = textTokens.getOptional("text_tokens")

                /**
                 * Returns the raw JSON value of [audioTokens].
                 *
                 * Unlike [audioTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("audio_tokens")
                @ExcludeMissing
                fun _audioTokens(): JsonField<Long> = audioTokens

                /**
                 * Returns the raw JSON value of [textTokens].
                 *
                 * Unlike [textTokens], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("text_tokens")
                @ExcludeMissing
                fun _textTokens(): JsonField<Long> = textTokens

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
                     * Returns a mutable builder for constructing an instance of
                     * [InputTokenDetails].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [InputTokenDetails]. */
                class Builder internal constructor() {

                    private var audioTokens: JsonField<Long> = JsonMissing.of()
                    private var textTokens: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(inputTokenDetails: InputTokenDetails) = apply {
                        audioTokens = inputTokenDetails.audioTokens
                        textTokens = inputTokenDetails.textTokens
                        additionalProperties = inputTokenDetails.additionalProperties.toMutableMap()
                    }

                    /** Number of audio tokens billed for this request. */
                    fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

                    /**
                     * Sets [Builder.audioTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.audioTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun audioTokens(audioTokens: JsonField<Long>) = apply {
                        this.audioTokens = audioTokens
                    }

                    /** Number of text tokens billed for this request. */
                    fun textTokens(textTokens: Long) = textTokens(JsonField.of(textTokens))

                    /**
                     * Sets [Builder.textTokens] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.textTokens] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun textTokens(textTokens: JsonField<Long>) = apply {
                        this.textTokens = textTokens
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
                     * Returns an immutable instance of [InputTokenDetails].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): InputTokenDetails =
                        InputTokenDetails(
                            audioTokens,
                            textTokens,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): InputTokenDetails = apply {
                    if (validated) {
                        return@apply
                    }

                    audioTokens()
                    textTokens()
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
                    (if (audioTokens.asKnown().isPresent) 1 else 0) +
                        (if (textTokens.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is InputTokenDetails &&
                        audioTokens == other.audioTokens &&
                        textTokens == other.textTokens &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(audioTokens, textTokens, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "InputTokenDetails{audioTokens=$audioTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Tokens &&
                    inputTokens == other.inputTokens &&
                    outputTokens == other.outputTokens &&
                    totalTokens == other.totalTokens &&
                    type == other.type &&
                    inputTokenDetails == other.inputTokenDetails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    inputTokens,
                    outputTokens,
                    totalTokens,
                    type,
                    inputTokenDetails,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Tokens{inputTokens=$inputTokens, outputTokens=$outputTokens, totalTokens=$totalTokens, type=$type, inputTokenDetails=$inputTokenDetails, additionalProperties=$additionalProperties}"
        }

        /** Usage statistics for models billed by audio input duration. */
        class Duration
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val seconds: JsonField<Double>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("seconds")
                @ExcludeMissing
                seconds: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(seconds, type, mutableMapOf())

            /**
             * Duration of the input audio in seconds.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun seconds(): Double = seconds.getRequired("seconds")

            /**
             * The type of the usage object. Always `duration` for this variant.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("duration")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Duration].
                 *
                 * The following fields are required:
                 * ```java
                 * .seconds()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Duration]. */
            class Builder internal constructor() {

                private var seconds: JsonField<Double>? = null
                private var type: JsonValue = JsonValue.from("duration")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(duration: Duration) = apply {
                    seconds = duration.seconds
                    type = duration.type
                    additionalProperties = duration.additionalProperties.toMutableMap()
                }

                /** Duration of the input audio in seconds. */
                fun seconds(seconds: Double) = seconds(JsonField.of(seconds))

                /**
                 * Sets [Builder.seconds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.seconds] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
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
                 * Returns an immutable instance of [Duration].
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
                fun build(): Duration =
                    Duration(
                        checkRequired("seconds", seconds),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Duration = apply {
                if (validated) {
                    return@apply
                }

                seconds()
                _type().let {
                    if (it != JsonValue.from("duration")) {
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

                return other is Duration &&
                    seconds == other.seconds &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(seconds, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Duration{seconds=$seconds, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TranscriptionDiarized &&
            duration == other.duration &&
            segments == other.segments &&
            task == other.task &&
            text == other.text &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(duration, segments, task, text, usage, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TranscriptionDiarized{duration=$duration, segments=$segments, task=$task, text=$text, usage=$usage, additionalProperties=$additionalProperties}"
}
