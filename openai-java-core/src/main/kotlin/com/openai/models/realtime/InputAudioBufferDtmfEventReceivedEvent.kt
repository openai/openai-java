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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * **SIP Only:** Returned when an DTMF event is received. A DTMF event is a message that represents
 * a telephone keypad press (0–9, *, #, A–D). The `event` property is the keypad that the user
 * press. The `received_at` is the UTC Unix Timestamp that the server received the event.
 */
class InputAudioBufferDtmfEventReceivedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val event: JsonField<String>,
    private val receivedAt: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
        @JsonProperty("received_at") @ExcludeMissing receivedAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(event, receivedAt, type, mutableMapOf())

    /**
     * The telephone keypad that was pressed by the user.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun event(): String = event.getRequired("event")

    /**
     * UTC Unix Timestamp when DTMF Event was received by server.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun receivedAt(): Long = receivedAt.getRequired("received_at")

    /**
     * The event type, must be `input_audio_buffer.dtmf_event_received`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_audio_buffer.dtmf_event_received")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [event].
     *
     * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("received_at") @ExcludeMissing fun _receivedAt(): JsonField<Long> = receivedAt

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
         * [InputAudioBufferDtmfEventReceivedEvent].
         *
         * The following fields are required:
         * ```java
         * .event()
         * .receivedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputAudioBufferDtmfEventReceivedEvent]. */
    class Builder internal constructor() {

        private var event: JsonField<String>? = null
        private var receivedAt: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("input_audio_buffer.dtmf_event_received")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            inputAudioBufferDtmfEventReceivedEvent: InputAudioBufferDtmfEventReceivedEvent
        ) = apply {
            event = inputAudioBufferDtmfEventReceivedEvent.event
            receivedAt = inputAudioBufferDtmfEventReceivedEvent.receivedAt
            type = inputAudioBufferDtmfEventReceivedEvent.type
            additionalProperties =
                inputAudioBufferDtmfEventReceivedEvent.additionalProperties.toMutableMap()
        }

        /** The telephone keypad that was pressed by the user. */
        fun event(event: String) = event(JsonField.of(event))

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<String>) = apply { this.event = event }

        /** UTC Unix Timestamp when DTMF Event was received by server. */
        fun receivedAt(receivedAt: Long) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun receivedAt(receivedAt: JsonField<Long>) = apply { this.receivedAt = receivedAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_audio_buffer.dtmf_event_received")
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
         * Returns an immutable instance of [InputAudioBufferDtmfEventReceivedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .event()
         * .receivedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputAudioBufferDtmfEventReceivedEvent =
            InputAudioBufferDtmfEventReceivedEvent(
                checkRequired("event", event),
                checkRequired("receivedAt", receivedAt),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InputAudioBufferDtmfEventReceivedEvent = apply {
        if (validated) {
            return@apply
        }

        event()
        receivedAt()
        _type().let {
            if (it != JsonValue.from("input_audio_buffer.dtmf_event_received")) {
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
        (if (event.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("input_audio_buffer.dtmf_event_received")) 1 else 0
            }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputAudioBufferDtmfEventReceivedEvent &&
            event == other.event &&
            receivedAt == other.receivedAt &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(event, receivedAt, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputAudioBufferDtmfEventReceivedEvent{event=$event, receivedAt=$receivedAt, type=$type, additionalProperties=$additionalProperties}"
}
