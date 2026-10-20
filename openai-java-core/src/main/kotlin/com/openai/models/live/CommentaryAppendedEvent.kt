// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import java.util.Optional

/**
 * Returned when a session.commentary.append command is accepted into the Live session timeline.
 * Acknowledges the added commentary without guaranteeing exact wording or completed audio playback.
 */
class CommentaryAppendedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val endMs: JsonField<Long>,
    private val eventId: JsonField<String>,
    private val startMs: JsonField<Long>,
    private val type: JsonValue,
    private val clientEventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("end_ms") @ExcludeMissing endMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("start_ms") @ExcludeMissing startMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
    ) : this(endMs, eventId, startMs, type, clientEventId, mutableMapOf())

    /**
     * The end of this event on the Live session timeline, in milliseconds from the beginning of the
     * session. For appended context, this can equal start_ms.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endMs(): Long = endMs.getRequired("end_ms")

    /**
     * The unique ID of the Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The start of this event on the Live session timeline, in milliseconds from the beginning of
     * the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun startMs(): Long = startMs.getRequired("start_ms")

    /**
     * The event type, always `session.commentary.appended`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.commentary.appended")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The event_id of the client command associated with this server event, when supplied.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientEventId(): Optional<String> = clientEventId.getOptional("client_event_id")

    /**
     * Returns the raw JSON value of [endMs].
     *
     * Unlike [endMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end_ms") @ExcludeMissing fun _endMs(): JsonField<Long> = endMs

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [startMs].
     *
     * Unlike [startMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start_ms") @ExcludeMissing fun _startMs(): JsonField<Long> = startMs

    /**
     * Returns the raw JSON value of [clientEventId].
     *
     * Unlike [clientEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_event_id")
    @ExcludeMissing
    fun _clientEventId(): JsonField<String> = clientEventId

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
         * Returns a mutable builder for constructing an instance of [CommentaryAppendedEvent].
         *
         * The following fields are required:
         * ```java
         * .endMs()
         * .eventId()
         * .startMs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommentaryAppendedEvent]. */
    class Builder internal constructor() {

        private var endMs: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var startMs: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("session.commentary.appended")
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(commentaryAppendedEvent: CommentaryAppendedEvent) = apply {
            endMs = commentaryAppendedEvent.endMs
            eventId = commentaryAppendedEvent.eventId
            startMs = commentaryAppendedEvent.startMs
            type = commentaryAppendedEvent.type
            clientEventId = commentaryAppendedEvent.clientEventId
            additionalProperties = commentaryAppendedEvent.additionalProperties.toMutableMap()
        }

        /**
         * The end of this event on the Live session timeline, in milliseconds from the beginning of
         * the session. For appended context, this can equal start_ms.
         */
        fun endMs(endMs: Long) = endMs(JsonField.of(endMs))

        /**
         * Sets [Builder.endMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun endMs(endMs: JsonField<Long>) = apply { this.endMs = endMs }

        /** The unique ID of the Live server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * The start of this event on the Live session timeline, in milliseconds from the beginning
         * of the session.
         */
        fun startMs(startMs: Long) = startMs(JsonField.of(startMs))

        /**
         * Sets [Builder.startMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun startMs(startMs: JsonField<Long>) = apply { this.startMs = startMs }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.commentary.appended")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The event_id of the client command associated with this server event, when supplied. */
        fun clientEventId(clientEventId: String) = clientEventId(JsonField.of(clientEventId))

        /**
         * Sets [Builder.clientEventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientEventId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientEventId(clientEventId: JsonField<String>) = apply {
            this.clientEventId = clientEventId
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
         * Returns an immutable instance of [CommentaryAppendedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .endMs()
         * .eventId()
         * .startMs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CommentaryAppendedEvent =
            CommentaryAppendedEvent(
                checkRequired("endMs", endMs),
                checkRequired("eventId", eventId),
                checkRequired("startMs", startMs),
                type,
                clientEventId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): CommentaryAppendedEvent = apply {
        if (validated) {
            return@apply
        }

        endMs()
        eventId()
        startMs()
        _type().let {
            if (it != JsonValue.from("session.commentary.appended")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        clientEventId()
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
        (if (endMs.asKnown().isPresent) 1 else 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (startMs.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.commentary.appended")) 1 else 0 } +
            (if (clientEventId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommentaryAppendedEvent &&
            endMs == other.endMs &&
            eventId == other.eventId &&
            startMs == other.startMs &&
            type == other.type &&
            clientEventId == other.clientEventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(endMs, eventId, startMs, type, clientEventId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CommentaryAppendedEvent{endMs=$endMs, eventId=$eventId, startMs=$startMs, type=$type, clientEventId=$clientEventId, additionalProperties=$additionalProperties}"
}
