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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A streaming Responses API event from a backend delegated to by the Live session. Use the outer
 * delegation_id to associate the nested stream with its Live delegation.
 */
class ResponseEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val event: JsonField<Event>,
    private val eventId: JsonField<String>,
    private val type: JsonValue,
    private val clientEventId: JsonField<String>,
    private val delegationId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event") @ExcludeMissing event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("delegation_id")
        @ExcludeMissing
        delegationId: JsonField<String> = JsonMissing.of(),
    ) : this(event, eventId, type, clientEventId, delegationId, mutableMapOf())

    /**
     * The nested Responses streaming event. Dispatch on its type field. Response lifecycle
     * snapshots omit input and clear instructions, tools, and output to keep messages small;
     * consume granular output events for the generated content.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun event(): Event = event.getRequired("event")

    /**
     * The unique ID of the Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The event type, always `response.event`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.event")
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
     * The Live delegation associated with the nested Responses event. May be null or omitted when
     * the event cannot be correlated with a delegation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegationId(): Optional<String> = delegationId.getOptional("delegation_id")

    /**
     * Returns the raw JSON value of [event].
     *
     * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<Event> = event

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [clientEventId].
     *
     * Unlike [clientEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_event_id")
    @ExcludeMissing
    fun _clientEventId(): JsonField<String> = clientEventId

    /**
     * Returns the raw JSON value of [delegationId].
     *
     * Unlike [delegationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation_id")
    @ExcludeMissing
    fun _delegationId(): JsonField<String> = delegationId

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
         * Returns a mutable builder for constructing an instance of [ResponseEvent].
         *
         * The following fields are required:
         * ```java
         * .event()
         * .eventId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseEvent]. */
    class Builder internal constructor() {

        private var event: JsonField<Event>? = null
        private var eventId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.event")
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var delegationId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseEvent: ResponseEvent) = apply {
            event = responseEvent.event
            eventId = responseEvent.eventId
            type = responseEvent.type
            clientEventId = responseEvent.clientEventId
            delegationId = responseEvent.delegationId
            additionalProperties = responseEvent.additionalProperties.toMutableMap()
        }

        /**
         * The nested Responses streaming event. Dispatch on its type field. Response lifecycle
         * snapshots omit input and clear instructions, tools, and output to keep messages small;
         * consume granular output events for the generated content.
         */
        fun event(event: Event) = event(JsonField.of(event))

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [Event] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<Event>) = apply { this.event = event }

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
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.event")
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

        /**
         * The Live delegation associated with the nested Responses event. May be null or omitted
         * when the event cannot be correlated with a delegation.
         */
        fun delegationId(delegationId: String?) = delegationId(JsonField.ofNullable(delegationId))

        /** Alias for calling [Builder.delegationId] with `delegationId.orElse(null)`. */
        fun delegationId(delegationId: Optional<String>) = delegationId(delegationId.getOrNull())

        /**
         * Sets [Builder.delegationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegationId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun delegationId(delegationId: JsonField<String>) = apply {
            this.delegationId = delegationId
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
         * Returns an immutable instance of [ResponseEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .event()
         * .eventId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseEvent =
            ResponseEvent(
                checkRequired("event", event),
                checkRequired("eventId", eventId),
                type,
                clientEventId,
                delegationId,
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
    fun validate(): ResponseEvent = apply {
        if (validated) {
            return@apply
        }

        event().validate()
        eventId()
        _type().let {
            if (it != JsonValue.from("response.event")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        clientEventId()
        delegationId()
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
        (event.asKnown().getOrNull()?.validity() ?: 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.event")) 1 else 0 } +
            (if (clientEventId.asKnown().isPresent) 1 else 0) +
            (if (delegationId.asKnown().isPresent) 1 else 0)

    /**
     * The nested Responses streaming event. Dispatch on its type field. Response lifecycle
     * snapshots omit input and clear instructions, tools, and output to keep messages small;
     * consume granular output events for the generated content.
     */
    class Event
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Event]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Event]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(event: Event) = apply {
                additionalProperties = event.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Event].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Event = Event(additionalProperties.toImmutable())
        }

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
        fun validate(): Event = apply {
            if (validated) {
                return@apply
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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Event && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Event{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseEvent &&
            event == other.event &&
            eventId == other.eventId &&
            type == other.type &&
            clientEventId == other.clientEventId &&
            delegationId == other.delegationId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(event, eventId, type, clientEventId, delegationId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseEvent{event=$event, eventId=$eventId, type=$type, clientEventId=$clientEventId, delegationId=$delegationId, additionalProperties=$additionalProperties}"
}
