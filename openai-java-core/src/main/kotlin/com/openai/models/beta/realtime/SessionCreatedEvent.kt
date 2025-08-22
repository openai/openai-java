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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.realtime.sessions.Session
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when a Session is created. Emitted automatically when a new connection is established as
 * the first server event. This event will contain the default Session configuration.
 */
class SessionCreatedEvent
private constructor(
    private val eventId: JsonField<String>,
    private val session: JsonField<Session>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, session, type, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * Realtime session object configuration.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): Session = session.getRequired("session")

    /**
     * The event type, must be `session.created`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.created")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

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
         * Returns a mutable builder for constructing an instance of [SessionCreatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionCreatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var session: JsonField<Session>? = null
        private var type: JsonValue = JsonValue.from("session.created")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionCreatedEvent: SessionCreatedEvent) = apply {
            eventId = sessionCreatedEvent.eventId
            session = sessionCreatedEvent.session
            type = sessionCreatedEvent.type
            additionalProperties = sessionCreatedEvent.additionalProperties.toMutableMap()
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

        /** Realtime session object configuration. */
        fun session(session: Session) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [Session] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun session(session: JsonField<Session>) = apply { this.session = session }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.created")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [SessionCreatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .session()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionCreatedEvent =
            SessionCreatedEvent(
                checkRequired("eventId", eventId),
                checkRequired("session", session),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SessionCreatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        session().validate()
        _type().let {
            if (it != JsonValue.from("session.created")) {
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (session.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("session.created")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionCreatedEvent &&
            eventId == other.eventId &&
            session == other.session &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(eventId, session, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionCreatedEvent{eventId=$eventId, session=$session, type=$type, additionalProperties=$additionalProperties}"
}
