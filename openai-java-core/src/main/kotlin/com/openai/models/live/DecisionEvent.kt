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
import com.openai.models.decisions.Decision
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A Decision API event for a Live delegation or transcript trigger. For a trigger, source_event_id
 * identifies the transcript delta that caused this evaluation.
 */
class DecisionEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delegationId: JsonField<String>,
    private val event: JsonField<Event>,
    private val eventId: JsonField<String>,
    private val sourceEventId: JsonField<String>,
    private val sourceEventType: JsonField<SourceEventType>,
    private val triggerId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delegation_id")
        @ExcludeMissing
        delegationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing event: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source_event_id")
        @ExcludeMissing
        sourceEventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source_event_type")
        @ExcludeMissing
        sourceEventType: JsonField<SourceEventType> = JsonMissing.of(),
        @JsonProperty("trigger_id") @ExcludeMissing triggerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(
        delegationId,
        event,
        eventId,
        sourceEventId,
        sourceEventType,
        triggerId,
        type,
        mutableMapOf(),
    )

    /**
     * The Live delegation ID, or null for a transcript trigger.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegationId(): Optional<String> = delegationId.getOptional("delegation_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun event(): Event = event.getRequired("event")

    /**
     * The unique ID of this Live server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The event_id of the transcript delta that fired this trigger, or null for a delegation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceEventId(): Optional<String> = sourceEventId.getOptional("source_event_id")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceEventType(): Optional<SourceEventType> =
        sourceEventType.getOptional("source_event_type")

    /**
     * The Live-assigned ID of this trigger firing, or null for a delegation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun triggerId(): Optional<String> = triggerId.getOptional("trigger_id")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("decision.event")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [delegationId].
     *
     * Unlike [delegationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation_id")
    @ExcludeMissing
    fun _delegationId(): JsonField<String> = delegationId

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
     * Returns the raw JSON value of [sourceEventId].
     *
     * Unlike [sourceEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source_event_id")
    @ExcludeMissing
    fun _sourceEventId(): JsonField<String> = sourceEventId

    /**
     * Returns the raw JSON value of [sourceEventType].
     *
     * Unlike [sourceEventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source_event_type")
    @ExcludeMissing
    fun _sourceEventType(): JsonField<SourceEventType> = sourceEventType

    /**
     * Returns the raw JSON value of [triggerId].
     *
     * Unlike [triggerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trigger_id") @ExcludeMissing fun _triggerId(): JsonField<String> = triggerId

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
         * Returns a mutable builder for constructing an instance of [DecisionEvent].
         *
         * The following fields are required:
         * ```java
         * .delegationId()
         * .event()
         * .eventId()
         * .sourceEventId()
         * .sourceEventType()
         * .triggerId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionEvent]. */
    class Builder internal constructor() {

        private var delegationId: JsonField<String>? = null
        private var event: JsonField<Event>? = null
        private var eventId: JsonField<String>? = null
        private var sourceEventId: JsonField<String>? = null
        private var sourceEventType: JsonField<SourceEventType>? = null
        private var triggerId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("decision.event")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionEvent: DecisionEvent) = apply {
            delegationId = decisionEvent.delegationId
            event = decisionEvent.event
            eventId = decisionEvent.eventId
            sourceEventId = decisionEvent.sourceEventId
            sourceEventType = decisionEvent.sourceEventType
            triggerId = decisionEvent.triggerId
            type = decisionEvent.type
            additionalProperties = decisionEvent.additionalProperties.toMutableMap()
        }

        /** The Live delegation ID, or null for a transcript trigger. */
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

        fun event(event: Event) = event(JsonField.of(event))

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [Event] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<Event>) = apply { this.event = event }

        /** The unique ID of this Live server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * The event_id of the transcript delta that fired this trigger, or null for a delegation.
         */
        fun sourceEventId(sourceEventId: String?) =
            sourceEventId(JsonField.ofNullable(sourceEventId))

        /** Alias for calling [Builder.sourceEventId] with `sourceEventId.orElse(null)`. */
        fun sourceEventId(sourceEventId: Optional<String>) =
            sourceEventId(sourceEventId.getOrNull())

        /**
         * Sets [Builder.sourceEventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceEventId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceEventId(sourceEventId: JsonField<String>) = apply {
            this.sourceEventId = sourceEventId
        }

        fun sourceEventType(sourceEventType: SourceEventType?) =
            sourceEventType(JsonField.ofNullable(sourceEventType))

        /** Alias for calling [Builder.sourceEventType] with `sourceEventType.orElse(null)`. */
        fun sourceEventType(sourceEventType: Optional<SourceEventType>) =
            sourceEventType(sourceEventType.getOrNull())

        /**
         * Sets [Builder.sourceEventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceEventType] with a well-typed [SourceEventType]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sourceEventType(sourceEventType: JsonField<SourceEventType>) = apply {
            this.sourceEventType = sourceEventType
        }

        /**
         * Sets [sourceEventType] to an arbitrary [String].
         *
         * You should usually call [sourceEventType] with a well-typed [SourceEventType] constant
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceEventType(value: String) = sourceEventType(SourceEventType.of(value))

        /** The Live-assigned ID of this trigger firing, or null for a delegation. */
        fun triggerId(triggerId: String?) = triggerId(JsonField.ofNullable(triggerId))

        /** Alias for calling [Builder.triggerId] with `triggerId.orElse(null)`. */
        fun triggerId(triggerId: Optional<String>) = triggerId(triggerId.getOrNull())

        /**
         * Sets [Builder.triggerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.triggerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun triggerId(triggerId: JsonField<String>) = apply { this.triggerId = triggerId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("decision.event")
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
         * Returns an immutable instance of [DecisionEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delegationId()
         * .event()
         * .eventId()
         * .sourceEventId()
         * .sourceEventType()
         * .triggerId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionEvent =
            DecisionEvent(
                checkRequired("delegationId", delegationId),
                checkRequired("event", event),
                checkRequired("eventId", eventId),
                checkRequired("sourceEventId", sourceEventId),
                checkRequired("sourceEventType", sourceEventType),
                checkRequired("triggerId", triggerId),
                type,
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
    fun validate(): DecisionEvent = apply {
        if (validated) {
            return@apply
        }

        delegationId()
        event().validate()
        eventId()
        sourceEventId()
        sourceEventType()
        triggerId()
        _type().let {
            if (it != JsonValue.from("decision.event")) {
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
        (if (delegationId.asKnown().isPresent) 1 else 0) +
            (event.asKnown().getOrNull()?.validity() ?: 0) +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (sourceEventId.asKnown().isPresent) 1 else 0) +
            (if (sourceEventType.asKnown().isPresent) 1 else 0) +
            (if (triggerId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("decision.event")) 1 else 0 }

    class Event
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val decision: JsonField<Decision>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("decision")
            @ExcludeMissing
            decision: JsonField<Decision> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(decision, type, mutableMapOf())

        /**
         * The native Decision API response, including its model, ordered answers, and token usage.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun decision(): Decision = decision.getRequired("decision")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("decision.completed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [decision].
         *
         * Unlike [decision], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("decision") @ExcludeMissing fun _decision(): JsonField<Decision> = decision

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
             * Returns a mutable builder for constructing an instance of [Event].
             *
             * The following fields are required:
             * ```java
             * .decision()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Event]. */
        class Builder internal constructor() {

            private var decision: JsonField<Decision>? = null
            private var type: JsonValue = JsonValue.from("decision.completed")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(event: Event) = apply {
                decision = event.decision
                type = event.type
                additionalProperties = event.additionalProperties.toMutableMap()
            }

            /**
             * The native Decision API response, including its model, ordered answers, and token
             * usage.
             */
            fun decision(decision: Decision) = decision(JsonField.of(decision))

            /**
             * Sets [Builder.decision] to an arbitrary JSON value.
             *
             * You should usually call [Builder.decision] with a well-typed [Decision] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun decision(decision: JsonField<Decision>) = apply { this.decision = decision }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("decision.completed")
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
             *
             * The following fields are required:
             * ```java
             * .decision()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Event =
                Event(
                    checkRequired("decision", decision),
                    type,
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
        fun validate(): Event = apply {
            if (validated) {
                return@apply
            }

            decision().validate()
            _type().let {
                if (it != JsonValue.from("decision.completed")) {
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
            (decision.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("decision.completed")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Event &&
                decision == other.decision &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(decision, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Event{decision=$decision, type=$type, additionalProperties=$additionalProperties}"
    }

    class SourceEventType @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val SESSION_INPUT_TRANSCRIPT_DELTA = of("session.input_transcript.delta")

            @JvmField val SESSION_OUTPUT_TRANSCRIPT_DELTA = of("session.output_transcript.delta")

            @JvmStatic fun of(value: String) = SourceEventType(JsonField.of(value))
        }

        /** An enum containing [SourceEventType]'s known values. */
        enum class Known {
            SESSION_INPUT_TRANSCRIPT_DELTA,
            SESSION_OUTPUT_TRANSCRIPT_DELTA,
        }

        /**
         * An enum containing [SourceEventType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [SourceEventType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SESSION_INPUT_TRANSCRIPT_DELTA,
            SESSION_OUTPUT_TRANSCRIPT_DELTA,
            /**
             * An enum member indicating that [SourceEventType] was instantiated with an unknown
             * value.
             */
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
                SESSION_INPUT_TRANSCRIPT_DELTA -> Value.SESSION_INPUT_TRANSCRIPT_DELTA
                SESSION_OUTPUT_TRANSCRIPT_DELTA -> Value.SESSION_OUTPUT_TRANSCRIPT_DELTA
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
                SESSION_INPUT_TRANSCRIPT_DELTA -> Known.SESSION_INPUT_TRANSCRIPT_DELTA
                SESSION_OUTPUT_TRANSCRIPT_DELTA -> Known.SESSION_OUTPUT_TRANSCRIPT_DELTA
                else -> throw OpenAIInvalidDataException("Unknown SourceEventType: $value")
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
        fun validate(): SourceEventType = apply {
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

            return other is SourceEventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionEvent &&
            delegationId == other.delegationId &&
            event == other.event &&
            eventId == other.eventId &&
            sourceEventId == other.sourceEventId &&
            sourceEventType == other.sourceEventType &&
            triggerId == other.triggerId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            delegationId,
            event,
            eventId,
            sourceEventId,
            sourceEventType,
            triggerId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionEvent{delegationId=$delegationId, event=$event, eventId=$eventId, sourceEventId=$sourceEventId, sourceEventType=$sourceEventType, triggerId=$triggerId, type=$type, additionalProperties=$additionalProperties}"
}
