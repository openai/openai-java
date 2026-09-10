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
 * Returned when the Live model delegates work to your application or a Responses backend. Contains
 * delegation metadata and the position on the session timeline where the work was delegated.
 */
class DelegationCreatedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delegation: JsonField<Delegation>,
    private val eventId: JsonField<String>,
    private val offsetMs: JsonField<Long>,
    private val type: JsonValue,
    private val clientEventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delegation")
        @ExcludeMissing
        delegation: JsonField<Delegation> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("offset_ms") @ExcludeMissing offsetMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
    ) : this(delegation, eventId, offsetMs, type, clientEventId, mutableMapOf())

    /**
     * The delegated work identifier and destination. This object contains metadata, not the task
     * text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delegation(): Delegation = delegation.getRequired("delegation")

    /**
     * The unique ID of the Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The position on the Live session timeline where the delegation was created, in milliseconds
     * from the beginning of the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun offsetMs(): Long = offsetMs.getRequired("offset_ms")

    /**
     * The event type, always `session.delegation.created`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("session.delegation.created")
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
     * Returns the raw JSON value of [delegation].
     *
     * Unlike [delegation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation")
    @ExcludeMissing
    fun _delegation(): JsonField<Delegation> = delegation

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    /**
     * Returns the raw JSON value of [offsetMs].
     *
     * Unlike [offsetMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("offset_ms") @ExcludeMissing fun _offsetMs(): JsonField<Long> = offsetMs

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
         * Returns a mutable builder for constructing an instance of [DelegationCreatedEvent].
         *
         * The following fields are required:
         * ```java
         * .delegation()
         * .eventId()
         * .offsetMs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DelegationCreatedEvent]. */
    class Builder internal constructor() {

        private var delegation: JsonField<Delegation>? = null
        private var eventId: JsonField<String>? = null
        private var offsetMs: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("session.delegation.created")
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(delegationCreatedEvent: DelegationCreatedEvent) = apply {
            delegation = delegationCreatedEvent.delegation
            eventId = delegationCreatedEvent.eventId
            offsetMs = delegationCreatedEvent.offsetMs
            type = delegationCreatedEvent.type
            clientEventId = delegationCreatedEvent.clientEventId
            additionalProperties = delegationCreatedEvent.additionalProperties.toMutableMap()
        }

        /**
         * The delegated work identifier and destination. This object contains metadata, not the
         * task text.
         */
        fun delegation(delegation: Delegation) = delegation(JsonField.of(delegation))

        /**
         * Sets [Builder.delegation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegation] with a well-typed [Delegation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun delegation(delegation: JsonField<Delegation>) = apply { this.delegation = delegation }

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
         * The position on the Live session timeline where the delegation was created, in
         * milliseconds from the beginning of the session.
         */
        fun offsetMs(offsetMs: Long) = offsetMs(JsonField.of(offsetMs))

        /**
         * Sets [Builder.offsetMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.offsetMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun offsetMs(offsetMs: JsonField<Long>) = apply { this.offsetMs = offsetMs }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("session.delegation.created")
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
         * Returns an immutable instance of [DelegationCreatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delegation()
         * .eventId()
         * .offsetMs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DelegationCreatedEvent =
            DelegationCreatedEvent(
                checkRequired("delegation", delegation),
                checkRequired("eventId", eventId),
                checkRequired("offsetMs", offsetMs),
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
    fun validate(): DelegationCreatedEvent = apply {
        if (validated) {
            return@apply
        }

        delegation().validate()
        eventId()
        offsetMs()
        _type().let {
            if (it != JsonValue.from("session.delegation.created")) {
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
        (delegation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (offsetMs.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("session.delegation.created")) 1 else 0 } +
            (if (clientEventId.asKnown().isPresent) 1 else 0)

    /**
     * The delegated work identifier and destination. This object contains metadata, not the task
     * text.
     */
    class Delegation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val target: JsonField<Target>,
        private val type: JsonValue,
        private val responseId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("target") @ExcludeMissing target: JsonField<Target> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("response_id")
            @ExcludeMissing
            responseId: JsonField<String> = JsonMissing.of(),
        ) : this(id, target, type, responseId, mutableMapOf())

        /**
         * The unique ID of the delegation. Use this as delegation_id when replying to client-owned
         * work or correlating Responses events.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Where the Live model delegated the work: `client` for your application, or `responses`
         * for the configured Responses backend.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun target(): Target = target.getRequired("target")

        /**
         * The object type, always `delegation`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("delegation")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The ID of the Responses API response associated with a Responses delegation. Omitted for
         * client delegations.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responseId(): Optional<String> = responseId.getOptional("response_id")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [target].
         *
         * Unlike [target], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("target") @ExcludeMissing fun _target(): JsonField<Target> = target

        /**
         * Returns the raw JSON value of [responseId].
         *
         * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response_id")
        @ExcludeMissing
        fun _responseId(): JsonField<String> = responseId

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
             * Returns a mutable builder for constructing an instance of [Delegation].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .target()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Delegation]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var target: JsonField<Target>? = null
            private var type: JsonValue = JsonValue.from("delegation")
            private var responseId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delegation: Delegation) = apply {
                id = delegation.id
                target = delegation.target
                type = delegation.type
                responseId = delegation.responseId
                additionalProperties = delegation.additionalProperties.toMutableMap()
            }

            /**
             * The unique ID of the delegation. Use this as delegation_id when replying to
             * client-owned work or correlating Responses events.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Where the Live model delegated the work: `client` for your application, or
             * `responses` for the configured Responses backend.
             */
            fun target(target: Target) = target(JsonField.of(target))

            /**
             * Sets [Builder.target] to an arbitrary JSON value.
             *
             * You should usually call [Builder.target] with a well-typed [Target] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun target(target: JsonField<Target>) = apply { this.target = target }

            /**
             * Sets [target] to an arbitrary [String].
             *
             * You should usually call [target] with a well-typed [Target] constant instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun target(value: String) = target(Target.of(value))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("delegation")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The ID of the Responses API response associated with a Responses delegation. Omitted
             * for client delegations.
             */
            fun responseId(responseId: String) = responseId(JsonField.of(responseId))

            /**
             * Sets [Builder.responseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

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
             * Returns an immutable instance of [Delegation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .target()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Delegation =
                Delegation(
                    checkRequired("id", id),
                    checkRequired("target", target),
                    type,
                    responseId,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Delegation = apply {
            if (validated) {
                return@apply
            }

            id()
            target()
            _type().let {
                if (it != JsonValue.from("delegation")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            responseId()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (target.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("delegation")) 1 else 0 } +
                (if (responseId.asKnown().isPresent) 1 else 0)

        /**
         * Where the Live model delegated the work: `client` for your application, or `responses`
         * for the configured Responses backend.
         */
        class Target @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val CLIENT = of("client")

                @JvmField val RESPONSES = of("responses")

                @JvmStatic fun of(value: String) = Target(JsonField.of(value))
            }

            /** An enum containing [Target]'s known values. */
            enum class Known {
                CLIENT,
                RESPONSES,
            }

            /**
             * An enum containing [Target]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Target] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CLIENT,
                RESPONSES,
                /**
                 * An enum member indicating that [Target] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    CLIENT -> Value.CLIENT
                    RESPONSES -> Value.RESPONSES
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    CLIENT -> Known.CLIENT
                    RESPONSES -> Known.RESPONSES
                    else -> throw OpenAIInvalidDataException("Unknown Target: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Target = apply {
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

                return other is Target && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Delegation &&
                id == other.id &&
                target == other.target &&
                type == other.type &&
                responseId == other.responseId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, target, type, responseId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Delegation{id=$id, target=$target, type=$type, responseId=$responseId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DelegationCreatedEvent &&
            delegation == other.delegation &&
            eventId == other.eventId &&
            offsetMs == other.offsetMs &&
            type == other.type &&
            clientEventId == other.clientEventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(delegation, eventId, offsetMs, type, clientEventId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DelegationCreatedEvent{delegation=$delegation, eventId=$eventId, offsetMs=$offsetMs, type=$type, clientEventId=$clientEventId, additionalProperties=$additionalProperties}"
}
