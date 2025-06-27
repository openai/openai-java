// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<Logprob>> = JsonMissing.of(),
    ) : this(contentIndex, eventId, itemId, transcript, type, logprobs, mutableMapOf())

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
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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

        return /* spotless:off */ other is ConversationItemInputAudioTranscriptionCompletedEvent && contentIndex == other.contentIndex && eventId == other.eventId && itemId == other.itemId && transcript == other.transcript && type == other.type && logprobs == other.logprobs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(contentIndex, eventId, itemId, transcript, type, logprobs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemInputAudioTranscriptionCompletedEvent{contentIndex=$contentIndex, eventId=$eventId, itemId=$itemId, transcript=$transcript, type=$type, logprobs=$logprobs, additionalProperties=$additionalProperties}"
}
