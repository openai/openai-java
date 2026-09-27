// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned after the Live session finishes finalizing, with the close reason, final session
 * snapshot, and cumulative audio usage. A connection closing without this event does not confirm
 * successful finalization.
 */
class SessionClosedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val reason: JsonField<Reason>,
    private val session: JsonField<SessionResource>,
    private val type: JsonValue,
    private val usage: JsonField<SessionUsage>,
    private val clientEventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<Reason> = JsonMissing.of(),
        @JsonProperty("session")
        @ExcludeMissing
        session: JsonField<SessionResource> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<SessionUsage> = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
    ) : this(eventId, reason, session, type, usage, clientEventId, mutableMapOf())

    /**
     * The unique ID of the Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * Why the Live session ended: `close_requested` for an application close or hangup request,
     * `expired` for the session duration limit, `content` for a safety filter, `remote_hangup` for
     * a graceful remote disconnect, or `connection_lost` for an unexpected primary or upstream
     * disconnection.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reason(): Reason = reason.getRequired("reason")

    /**
     * The resolved Live session configuration and server-assigned session metadata.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun session(): SessionResource = session.getRequired("session")

    /**
     * The event type, always `session.closed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.closed")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The final cumulative Live audio usage after session finalization.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): SessionUsage = usage.getRequired("usage")

    /**
     * The event_id of the client command associated with this server event, when supplied.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientEventId(): Optional<String> = clientEventId.getOptional("client_event_id")

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

    /**
     * Returns the raw JSON value of [session].
     *
     * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<SessionResource> = session

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<SessionUsage> = usage

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
         * Returns a mutable builder for constructing an instance of [SessionClosedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .reason()
         * .session()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionClosedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var reason: JsonField<Reason>? = null
        private var session: JsonField<SessionResource>? = null
        private var type: JsonValue = JsonValue.from("session.closed")
        private var usage: JsonField<SessionUsage>? = null
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionClosedEvent: SessionClosedEvent) = apply {
            eventId = sessionClosedEvent.eventId
            reason = sessionClosedEvent.reason
            session = sessionClosedEvent.session
            type = sessionClosedEvent.type
            usage = sessionClosedEvent.usage
            clientEventId = sessionClosedEvent.clientEventId
            additionalProperties = sessionClosedEvent.additionalProperties.toMutableMap()
        }

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
         * Why the Live session ended: `close_requested` for an application close or hangup request,
         * `expired` for the session duration limit, `content` for a safety filter, `remote_hangup`
         * for a graceful remote disconnect, or `connection_lost` for an unexpected primary or
         * upstream disconnection.
         */
        fun reason(reason: Reason) = reason(JsonField.of(reason))

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [Reason] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

        /**
         * Sets [reason] to an arbitrary [String].
         *
         * You should usually call [reason] with a well-typed [Reason] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(value: String) = reason(Reason.of(value))

        /** The resolved Live session configuration and server-assigned session metadata. */
        fun session(session: SessionResource) = session(JsonField.of(session))

        /**
         * Sets [Builder.session] to an arbitrary JSON value.
         *
         * You should usually call [Builder.session] with a well-typed [SessionResource] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun session(session: JsonField<SessionResource>) = apply { this.session = session }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.closed")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The final cumulative Live audio usage after session finalization. */
        fun usage(usage: SessionUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [SessionUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<SessionUsage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [SessionClosedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .reason()
         * .session()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionClosedEvent =
            SessionClosedEvent(
                checkRequired("eventId", eventId),
                checkRequired("reason", reason),
                checkRequired("session", session),
                type,
                checkRequired("usage", usage),
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
    fun validate(): SessionClosedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        reason()
        session().validate()
        _type().let {
            if (it != JsonValue.from("session.closed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        usage().validate()
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
        (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (session.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("session.closed")) 1 else 0 } +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (if (clientEventId.asKnown().isPresent) 1 else 0)

    /**
     * Why the Live session ended: `close_requested` for an application close or hangup request,
     * `expired` for the session duration limit, `content` for a safety filter, `remote_hangup` for
     * a graceful remote disconnect, or `connection_lost` for an unexpected primary or upstream
     * disconnection.
     */
    class Reason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CLOSE_REQUESTED = of("close_requested")

            @JvmField val EXPIRED = of("expired")

            @JvmField val CONTENT = of("content")

            @JvmField val REMOTE_HANGUP = of("remote_hangup")

            @JvmField val CONNECTION_LOST = of("connection_lost")

            @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
        }

        /** An enum containing [Reason]'s known values. */
        enum class Known {
            CLOSE_REQUESTED,
            EXPIRED,
            CONTENT,
            REMOTE_HANGUP,
            CONNECTION_LOST,
        }

        /**
         * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Reason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CLOSE_REQUESTED,
            EXPIRED,
            CONTENT,
            REMOTE_HANGUP,
            CONNECTION_LOST,
            /** An enum member indicating that [Reason] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                CLOSE_REQUESTED -> Value.CLOSE_REQUESTED
                EXPIRED -> Value.EXPIRED
                CONTENT -> Value.CONTENT
                REMOTE_HANGUP -> Value.REMOTE_HANGUP
                CONNECTION_LOST -> Value.CONNECTION_LOST
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                CLOSE_REQUESTED -> Known.CLOSE_REQUESTED
                EXPIRED -> Known.EXPIRED
                CONTENT -> Known.CONTENT
                REMOTE_HANGUP -> Known.REMOTE_HANGUP
                CONNECTION_LOST -> Known.CONNECTION_LOST
                else -> throw OpenAIInvalidDataException("Unknown Reason: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Reason = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Reason && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionClosedEvent &&
            eventId == other.eventId &&
            reason == other.reason &&
            session == other.session &&
            type == other.type &&
            usage == other.usage &&
            clientEventId == other.clientEventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, reason, session, type, usage, clientEventId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionClosedEvent{eventId=$eventId, reason=$reason, session=$session, type=$type, usage=$usage, clientEventId=$clientEventId, additionalProperties=$additionalProperties}"
}
