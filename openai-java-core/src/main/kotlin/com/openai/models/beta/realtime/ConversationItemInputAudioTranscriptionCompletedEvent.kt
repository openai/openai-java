// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
import com.openai.core.allMaxBy
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
 * This event is the output of audio transcription for user audio written to the user audio buffer.
 * Transcription begins when the input audio buffer is committed by the client or server (in
 * `server_vad` mode). Transcription runs asynchronously with Response creation, so this event may
 * come before or after the Response events.
 *
 * Realtime API models accept audio natively, and thus input transcription is a separate process run
 * on a separate ASR (Automatic Speech Recognition) model. The transcript may diverge somewhat from
 * the model's interpretation, and should be treated as a rough guide.
 */
class ConversationItemInputAudioTranscriptionCompletedEvent
private constructor(
    private val contentIndex: JsonField<Long>,
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val transcript: JsonField<String>,
    private val type: JsonValue,
    private val usage: JsonField<Usage>,
    private val logprobs: JsonField<List<Logprob>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("transcript")
        @ExcludeMissing
        transcript: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<Logprob>> = JsonMissing.of(),
    ) : this(contentIndex, eventId, itemId, transcript, type, usage, logprobs, mutableMapOf())

    /**
     * The index of the content part containing the audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the user message item containing the audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The transcribed text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transcript(): String = transcript.getRequired("transcript")

    /**
     * The event type, must be `conversation.item.input_audio_transcription.completed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("conversation.item.input_audio_transcription.completed")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Usage statistics for the transcription.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): Usage = usage.getRequired("usage")

    /**
     * The log probabilities of the transcription.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<List<Logprob>> = logprobs.getOptional("logprobs")

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [transcript].
     *
     * Unlike [transcript], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transcript") @ExcludeMissing fun _transcript(): JsonField<String> = transcript

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<List<Logprob>> = logprobs

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
         * [ConversationItemInputAudioTranscriptionCompletedEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .eventId()
         * .itemId()
         * .transcript()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemInputAudioTranscriptionCompletedEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var transcript: JsonField<String>? = null
        private var type: JsonValue =
            JsonValue.from("conversation.item.input_audio_transcription.completed")
        private var usage: JsonField<Usage>? = null
        private var logprobs: JsonField<MutableList<Logprob>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            conversationItemInputAudioTranscriptionCompletedEvent:
                ConversationItemInputAudioTranscriptionCompletedEvent
        ) = apply {
            contentIndex = conversationItemInputAudioTranscriptionCompletedEvent.contentIndex
            eventId = conversationItemInputAudioTranscriptionCompletedEvent.eventId
            itemId = conversationItemInputAudioTranscriptionCompletedEvent.itemId
            transcript = conversationItemInputAudioTranscriptionCompletedEvent.transcript
            type = conversationItemInputAudioTranscriptionCompletedEvent.type
            usage = conversationItemInputAudioTranscriptionCompletedEvent.usage
            logprobs =
                conversationItemInputAudioTranscriptionCompletedEvent.logprobs.map {
                    it.toMutableList()
                }
            additionalProperties =
                conversationItemInputAudioTranscriptionCompletedEvent.additionalProperties
                    .toMutableMap()
        }

        /** The index of the content part containing the audio. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the user message item containing the audio. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The transcribed text. */
        fun transcript(transcript: String) = transcript(JsonField.of(transcript))

        /**
         * Sets [Builder.transcript] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcript] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun transcript(transcript: JsonField<String>) = apply { this.transcript = transcript }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("conversation.item.input_audio_transcription.completed")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Usage statistics for the transcription. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

        /**
         * Alias for calling [usage] with
         * `Usage.ofTranscriptTextUsageTokens(transcriptTextUsageTokens)`.
         */
        fun usage(transcriptTextUsageTokens: Usage.TranscriptTextUsageTokens) =
            usage(Usage.ofTranscriptTextUsageTokens(transcriptTextUsageTokens))

        /**
         * Alias for calling [usage] with
         * `Usage.ofTranscriptTextUsageDuration(transcriptTextUsageDuration)`.
         */
        fun usage(transcriptTextUsageDuration: Usage.TranscriptTextUsageDuration) =
            usage(Usage.ofTranscriptTextUsageDuration(transcriptTextUsageDuration))

        /** The log probabilities of the transcription. */
        fun logprobs(logprobs: List<Logprob>?) = logprobs(JsonField.ofNullable(logprobs))

        /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
        fun logprobs(logprobs: Optional<List<Logprob>>) = logprobs(logprobs.getOrNull())

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed `List<Logprob>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun logprobs(logprobs: JsonField<List<Logprob>>) = apply {
            this.logprobs = logprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [Logprob] to [logprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLogprob(logprob: Logprob) = apply {
            logprobs =
                (logprobs ?: JsonField.of(mutableListOf())).also {
                    checkKnown("logprobs", it).add(logprob)
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
         * Returns an immutable instance of [ConversationItemInputAudioTranscriptionCompletedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .eventId()
         * .itemId()
         * .transcript()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemInputAudioTranscriptionCompletedEvent =
            ConversationItemInputAudioTranscriptionCompletedEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                checkRequired("transcript", transcript),
                type,
                checkRequired("usage", usage),
                (logprobs ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemInputAudioTranscriptionCompletedEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        eventId()
        itemId()
        transcript()
        _type().let {
            if (it != JsonValue.from("conversation.item.input_audio_transcription.completed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        usage().validate()
        logprobs().ifPresent { it.forEach { it.validate() } }
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
        (if (contentIndex.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (transcript.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("conversation.item.input_audio_transcription.completed")) 1
                else 0
            } +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Usage statistics for the transcription. */
    @JsonDeserialize(using = Usage.Deserializer::class)
    @JsonSerialize(using = Usage.Serializer::class)
    class Usage
    private constructor(
        private val transcriptTextUsageTokens: TranscriptTextUsageTokens? = null,
        private val transcriptTextUsageDuration: TranscriptTextUsageDuration? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Usage statistics for models billed by token usage. */
        fun transcriptTextUsageTokens(): Optional<TranscriptTextUsageTokens> =
            Optional.ofNullable(transcriptTextUsageTokens)

        /** Usage statistics for models billed by audio input duration. */
        fun transcriptTextUsageDuration(): Optional<TranscriptTextUsageDuration> =
            Optional.ofNullable(transcriptTextUsageDuration)

        fun isTranscriptTextUsageTokens(): Boolean = transcriptTextUsageTokens != null

        fun isTranscriptTextUsageDuration(): Boolean = transcriptTextUsageDuration != null

        /** Usage statistics for models billed by token usage. */
        fun asTranscriptTextUsageTokens(): TranscriptTextUsageTokens =
            transcriptTextUsageTokens.getOrThrow("transcriptTextUsageTokens")

        /** Usage statistics for models billed by audio input duration. */
        fun asTranscriptTextUsageDuration(): TranscriptTextUsageDuration =
            transcriptTextUsageDuration.getOrThrow("transcriptTextUsageDuration")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                transcriptTextUsageTokens != null ->
                    visitor.visitTranscriptTextUsageTokens(transcriptTextUsageTokens)
                transcriptTextUsageDuration != null ->
                    visitor.visitTranscriptTextUsageDuration(transcriptTextUsageDuration)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTranscriptTextUsageTokens(
                        transcriptTextUsageTokens: TranscriptTextUsageTokens
                    ) {
                        transcriptTextUsageTokens.validate()
                    }

                    override fun visitTranscriptTextUsageDuration(
                        transcriptTextUsageDuration: TranscriptTextUsageDuration
                    ) {
                        transcriptTextUsageDuration.validate()
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
                    override fun visitTranscriptTextUsageTokens(
                        transcriptTextUsageTokens: TranscriptTextUsageTokens
                    ) = transcriptTextUsageTokens.validity()

                    override fun visitTranscriptTextUsageDuration(
                        transcriptTextUsageDuration: TranscriptTextUsageDuration
                    ) = transcriptTextUsageDuration.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Usage && transcriptTextUsageTokens == other.transcriptTextUsageTokens && transcriptTextUsageDuration == other.transcriptTextUsageDuration /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(transcriptTextUsageTokens, transcriptTextUsageDuration) /* spotless:on */

        override fun toString(): String =
            when {
                transcriptTextUsageTokens != null ->
                    "Usage{transcriptTextUsageTokens=$transcriptTextUsageTokens}"
                transcriptTextUsageDuration != null ->
                    "Usage{transcriptTextUsageDuration=$transcriptTextUsageDuration}"
                _json != null -> "Usage{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Usage")
            }

        companion object {

            /** Usage statistics for models billed by token usage. */
            @JvmStatic
            fun ofTranscriptTextUsageTokens(transcriptTextUsageTokens: TranscriptTextUsageTokens) =
                Usage(transcriptTextUsageTokens = transcriptTextUsageTokens)

            /** Usage statistics for models billed by audio input duration. */
            @JvmStatic
            fun ofTranscriptTextUsageDuration(
                transcriptTextUsageDuration: TranscriptTextUsageDuration
            ) = Usage(transcriptTextUsageDuration = transcriptTextUsageDuration)
        }

        /** An interface that defines how to map each variant of [Usage] to a value of type [T]. */
        interface Visitor<out T> {

            /** Usage statistics for models billed by token usage. */
            fun visitTranscriptTextUsageTokens(
                transcriptTextUsageTokens: TranscriptTextUsageTokens
            ): T

            /** Usage statistics for models billed by audio input duration. */
            fun visitTranscriptTextUsageDuration(
                transcriptTextUsageDuration: TranscriptTextUsageDuration
            ): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<TranscriptTextUsageTokens>())?.let {
                                Usage(transcriptTextUsageTokens = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<TranscriptTextUsageDuration>())
                                ?.let { Usage(transcriptTextUsageDuration = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Usage(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Usage>(Usage::class) {

            override fun serialize(
                value: Usage,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.transcriptTextUsageTokens != null ->
                        generator.writeObject(value.transcriptTextUsageTokens)
                    value.transcriptTextUsageDuration != null ->
                        generator.writeObject(value.transcriptTextUsageDuration)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Usage")
                }
            }
        }

        /** Usage statistics for models billed by token usage. */
        class TranscriptTextUsageTokens
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
                 * Returns a mutable builder for constructing an instance of
                 * [TranscriptTextUsageTokens].
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

            /** A builder for [TranscriptTextUsageTokens]. */
            class Builder internal constructor() {

                private var inputTokens: JsonField<Long>? = null
                private var outputTokens: JsonField<Long>? = null
                private var totalTokens: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("tokens")
                private var inputTokenDetails: JsonField<InputTokenDetails> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(transcriptTextUsageTokens: TranscriptTextUsageTokens) = apply {
                    inputTokens = transcriptTextUsageTokens.inputTokens
                    outputTokens = transcriptTextUsageTokens.outputTokens
                    totalTokens = transcriptTextUsageTokens.totalTokens
                    type = transcriptTextUsageTokens.type
                    inputTokenDetails = transcriptTextUsageTokens.inputTokenDetails
                    additionalProperties =
                        transcriptTextUsageTokens.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [TranscriptTextUsageTokens].
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
                fun build(): TranscriptTextUsageTokens =
                    TranscriptTextUsageTokens(
                        checkRequired("inputTokens", inputTokens),
                        checkRequired("outputTokens", outputTokens),
                        checkRequired("totalTokens", totalTokens),
                        type,
                        inputTokenDetails,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TranscriptTextUsageTokens = apply {
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

                    return /* spotless:off */ other is InputTokenDetails && audioTokens == other.audioTokens && textTokens == other.textTokens && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(audioTokens, textTokens, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "InputTokenDetails{audioTokens=$audioTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is TranscriptTextUsageTokens && inputTokens == other.inputTokens && outputTokens == other.outputTokens && totalTokens == other.totalTokens && type == other.type && inputTokenDetails == other.inputTokenDetails && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(inputTokens, outputTokens, totalTokens, type, inputTokenDetails, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TranscriptTextUsageTokens{inputTokens=$inputTokens, outputTokens=$outputTokens, totalTokens=$totalTokens, type=$type, inputTokenDetails=$inputTokenDetails, additionalProperties=$additionalProperties}"
        }

        /** Usage statistics for models billed by audio input duration. */
        class TranscriptTextUsageDuration
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
                 * Returns a mutable builder for constructing an instance of
                 * [TranscriptTextUsageDuration].
                 *
                 * The following fields are required:
                 * ```java
                 * .seconds()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TranscriptTextUsageDuration]. */
            class Builder internal constructor() {

                private var seconds: JsonField<Double>? = null
                private var type: JsonValue = JsonValue.from("duration")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(transcriptTextUsageDuration: TranscriptTextUsageDuration) =
                    apply {
                        seconds = transcriptTextUsageDuration.seconds
                        type = transcriptTextUsageDuration.type
                        additionalProperties =
                            transcriptTextUsageDuration.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [TranscriptTextUsageDuration].
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
                fun build(): TranscriptTextUsageDuration =
                    TranscriptTextUsageDuration(
                        checkRequired("seconds", seconds),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TranscriptTextUsageDuration = apply {
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

                return /* spotless:off */ other is TranscriptTextUsageDuration && seconds == other.seconds && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(seconds, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TranscriptTextUsageDuration{seconds=$seconds, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** A log probability object. */
    class Logprob
    private constructor(
        private val token: JsonField<String>,
        private val bytes: JsonField<List<Long>>,
        private val logprob: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bytes") @ExcludeMissing bytes: JsonField<List<Long>> = JsonMissing.of(),
            @JsonProperty("logprob") @ExcludeMissing logprob: JsonField<Double> = JsonMissing.of(),
        ) : this(token, bytes, logprob, mutableMapOf())

        /**
         * The token that was used to generate the log probability.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * The bytes that were used to generate the log probability.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bytes(): List<Long> = bytes.getRequired("bytes")

        /**
         * The log probability of the token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun logprob(): Double = logprob.getRequired("logprob")

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * Returns the raw JSON value of [bytes].
         *
         * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<List<Long>> = bytes

        /**
         * Returns the raw JSON value of [logprob].
         *
         * Unlike [logprob], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

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
             * Returns a mutable builder for constructing an instance of [Logprob].
             *
             * The following fields are required:
             * ```java
             * .token()
             * .bytes()
             * .logprob()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Logprob]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var bytes: JsonField<MutableList<Long>>? = null
            private var logprob: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprob: Logprob) = apply {
                token = logprob.token
                bytes = logprob.bytes.map { it.toMutableList() }
                this.logprob = logprob.logprob
                additionalProperties = logprob.additionalProperties.toMutableMap()
            }

            /** The token that was used to generate the log probability. */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /** The bytes that were used to generate the log probability. */
            fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

            /**
             * Sets [Builder.bytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bytes] with a well-typed `List<Long>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bytes(bytes: JsonField<List<Long>>) = apply {
                this.bytes = bytes.map { it.toMutableList() }
            }

            /**
             * Adds a single [Long] to [bytes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByte(byte_: Long) = apply {
                bytes =
                    (bytes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("bytes", it).add(byte_)
                    }
            }

            /** The log probability of the token. */
            fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

            /**
             * Sets [Builder.logprob] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprob] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

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
             * Returns an immutable instance of [Logprob].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .token()
             * .bytes()
             * .logprob()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Logprob =
                Logprob(
                    checkRequired("token", token),
                    checkRequired("bytes", bytes).map { it.toImmutable() },
                    checkRequired("logprob", logprob),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Logprob = apply {
            if (validated) {
                return@apply
            }

            token()
            bytes()
            logprob()
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
            (if (token.asKnown().isPresent) 1 else 0) +
                (bytes.asKnown().getOrNull()?.size ?: 0) +
                (if (logprob.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Logprob && token == other.token && bytes == other.bytes && logprob == other.logprob && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(token, bytes, logprob, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Logprob{token=$token, bytes=$bytes, logprob=$logprob, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ConversationItemInputAudioTranscriptionCompletedEvent && contentIndex == other.contentIndex && eventId == other.eventId && itemId == other.itemId && transcript == other.transcript && type == other.type && usage == other.usage && logprobs == other.logprobs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(contentIndex, eventId, itemId, transcript, type, usage, logprobs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemInputAudioTranscriptionCompletedEvent{contentIndex=$contentIndex, eventId=$eventId, itemId=$itemId, transcript=$transcript, type=$type, usage=$usage, logprobs=$logprobs, additionalProperties=$additionalProperties}"
}
