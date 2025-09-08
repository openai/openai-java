// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when the text value of an input audio transcription content part is updated with
 * incremental transcription results.
 */
class ConversationItemInputAudioTranscriptionDeltaEvent
private constructor(
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val type: JsonValue,
    private val contentIndex: JsonField<Long>,
    private val delta: JsonField<String>,
    private val logprobs: JsonField<List<LogProbProperties>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<LogProbProperties>> = JsonMissing.of(),
    ) : this(eventId, itemId, type, contentIndex, delta, logprobs, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The ID of the item containing the audio that is being transcribed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The event type, must be `conversation.item.input_audio_transcription.delta`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("conversation.item.input_audio_transcription.delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The index of the content part in the item's content array.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contentIndex(): Optional<Long> = contentIndex.getOptional("content_index")

    /**
     * The text delta.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delta(): Optional<String> = delta.getOptional("delta")

    /**
     * The log probabilities of the transcription. These can be enabled by configurating the session
     * with `"include": ["item.input_audio_transcription.logprobs"]`. Each entry in the array
     * corresponds a log probability of which token would be selected for this chunk of
     * transcription. This can help to identify if it was possible there were multiple valid options
     * for a given chunk of transcription.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<List<LogProbProperties>> = logprobs.getOptional("logprobs")

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
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs")
    @ExcludeMissing
    fun _logprobs(): JsonField<List<LogProbProperties>> = logprobs

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
         * [ConversationItemInputAudioTranscriptionDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemInputAudioTranscriptionDeltaEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var type: JsonValue =
            JsonValue.from("conversation.item.input_audio_transcription.delta")
        private var contentIndex: JsonField<Long> = JsonMissing.of()
        private var delta: JsonField<String> = JsonMissing.of()
        private var logprobs: JsonField<MutableList<LogProbProperties>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            conversationItemInputAudioTranscriptionDeltaEvent:
                ConversationItemInputAudioTranscriptionDeltaEvent
        ) = apply {
            eventId = conversationItemInputAudioTranscriptionDeltaEvent.eventId
            itemId = conversationItemInputAudioTranscriptionDeltaEvent.itemId
            type = conversationItemInputAudioTranscriptionDeltaEvent.type
            contentIndex = conversationItemInputAudioTranscriptionDeltaEvent.contentIndex
            delta = conversationItemInputAudioTranscriptionDeltaEvent.delta
            logprobs =
                conversationItemInputAudioTranscriptionDeltaEvent.logprobs.map {
                    it.toMutableList()
                }
            additionalProperties =
                conversationItemInputAudioTranscriptionDeltaEvent.additionalProperties
                    .toMutableMap()
        }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the item containing the audio that is being transcribed. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("conversation.item.input_audio_transcription.delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The index of the content part in the item's content array. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The text delta. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /**
         * The log probabilities of the transcription. These can be enabled by configurating the
         * session with `"include": ["item.input_audio_transcription.logprobs"]`. Each entry in the
         * array corresponds a log probability of which token would be selected for this chunk of
         * transcription. This can help to identify if it was possible there were multiple valid
         * options for a given chunk of transcription.
         */
        fun logprobs(logprobs: List<LogProbProperties>?) = logprobs(JsonField.ofNullable(logprobs))

        /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
        fun logprobs(logprobs: Optional<List<LogProbProperties>>) = logprobs(logprobs.getOrNull())

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed `List<LogProbProperties>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun logprobs(logprobs: JsonField<List<LogProbProperties>>) = apply {
            this.logprobs = logprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [LogProbProperties] to [logprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLogprob(logprob: LogProbProperties) = apply {
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
         * Returns an immutable instance of [ConversationItemInputAudioTranscriptionDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemInputAudioTranscriptionDeltaEvent =
            ConversationItemInputAudioTranscriptionDeltaEvent(
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                type,
                contentIndex,
                delta,
                (logprobs ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemInputAudioTranscriptionDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        itemId()
        _type().let {
            if (it != JsonValue.from("conversation.item.input_audio_transcription.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        contentIndex()
        delta()
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("conversation.item.input_audio_transcription.delta")) 1
                else 0
            } +
            (if (contentIndex.asKnown().isPresent) 1 else 0) +
            (if (delta.asKnown().isPresent) 1 else 0) +
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItemInputAudioTranscriptionDeltaEvent &&
            eventId == other.eventId &&
            itemId == other.itemId &&
            type == other.type &&
            contentIndex == other.contentIndex &&
            delta == other.delta &&
            logprobs == other.logprobs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, itemId, type, contentIndex, delta, logprobs, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemInputAudioTranscriptionDeltaEvent{eventId=$eventId, itemId=$itemId, type=$type, contentIndex=$contentIndex, delta=$delta, logprobs=$logprobs, additionalProperties=$additionalProperties}"
}
