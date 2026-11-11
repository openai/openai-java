// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when a reasoning summary part is complete. */
class AgentSessionTurnReasoningSummaryPartDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val part: JsonField<SummaryText>,
    private val sessionId: JsonField<String>,
    private val status: JsonField<Status>,
    private val summaryIndex: JsonField<Long>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("part") @ExcludeMissing part: JsonField<SummaryText> = JsonMissing.of(),
        @JsonProperty("session_id") @ExcludeMissing sessionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("summary_index")
        @ExcludeMissing
        summaryIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(
        eventId,
        itemId,
        outputIndex,
        part,
        sessionId,
        status,
        summaryIndex,
        turnId,
        type,
        mutableMapOf(),
    )

    /**
     * The unique ID of the event. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventId(): java.util.Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventIdOrThrow(): String = eventId.getRequired("event_id")

    /**
     * The ID of the reasoning item. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun itemId(): java.util.Optional<String> = itemId.getOptional("item_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun itemIdOrThrow(): String = itemId.getRequired("item_id")

    /**
     * The index of the item in the turn output. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun outputIndex(): java.util.Optional<Long> = outputIndex.getOptional("output_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun outputIndexOrThrow(): Long = outputIndex.getRequired("output_index")

    /**
     * The completed summary part. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun part(): java.util.Optional<SummaryText> = part.getOptional("part")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun partOrThrow(): SummaryText = part.getRequired("part")

    /**
     * The ID of the session associated with the event. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun sessionId(): java.util.Optional<String> = sessionId.getOptional("session_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun sessionIdOrThrow(): String = sessionId.getRequired("session_id")

    /**
     * Present as `incomplete` when summary generation was interrupted. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun status(): java.util.Optional<JsonValue> {
        val raw = JsonValue.from(status)
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("incomplete")) ->
                throw OpenAIInvalidDataException("`status` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun statusOrThrow(): JsonValue =
        status().orElseGet { JsonValue.from(status).getRequired("status") }

    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<JsonValue> = JsonValue.from(status)

    /**
     * The index of the summary part. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun summaryIndex(): java.util.Optional<Long> = summaryIndex.getOptional("summary_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun summaryIndexOrThrow(): Long = summaryIndex.getRequired("summary_index")

    /**
     * The ID of the turn associated with the event, when applicable. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun turnId(): java.util.Optional<String> = turnId.getOptional("turn_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun turnIdOrThrow(): String = turnId.getRequired("turn_id")

    /**
     * The type of the object. Always `agent.session.turn.reasoning_summary_part.done`. The schema
     * requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("agent.session.turn.reasoning_summary_part.done")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [part].
     *
     * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("part") @ExcludeMissing fun _part(): JsonField<SummaryText> = part

    /**
     * Returns the raw JSON value of [sessionId].
     *
     * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

    /**
     * Returns the raw JSON value of [summaryIndex].
     *
     * Unlike [summaryIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary_index")
    @ExcludeMissing
    fun _summaryIndex(): JsonField<Long> = summaryIndex

    /**
     * Returns the raw JSON value of [turnId].
     *
     * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "event_id" to this.eventId,
            "item_id" to this.itemId,
            "output_index" to this.outputIndex,
            "part" to this.part,
            "session_id" to this.sessionId,
            "status" to this.status,
            "summary_index" to this.summaryIndex,
            "turn_id" to this.turnId,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [AgentSessionTurnReasoningSummaryPartDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .part()
         * .sessionId()
         * .summaryIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSessionTurnReasoningSummaryPartDoneEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var part: JsonField<SummaryText>? = null
        private var sessionId: JsonField<String>? = null
        private var status: JsonField<Status>? = JsonNull.of()
        private var summaryIndex: JsonField<Long>? = null
        private var turnId: JsonField<String>? = JsonNull.of()
        private var type: JsonValue =
            JsonValue.from("agent.session.turn.reasoning_summary_part.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            agentSessionTurnReasoningSummaryPartDoneEvent:
                AgentSessionTurnReasoningSummaryPartDoneEvent
        ) = apply {
            eventId = agentSessionTurnReasoningSummaryPartDoneEvent.eventId
            itemId = agentSessionTurnReasoningSummaryPartDoneEvent.itemId
            outputIndex = agentSessionTurnReasoningSummaryPartDoneEvent.outputIndex
            part = agentSessionTurnReasoningSummaryPartDoneEvent.part
            sessionId = agentSessionTurnReasoningSummaryPartDoneEvent.sessionId
            status = agentSessionTurnReasoningSummaryPartDoneEvent.status
            summaryIndex = agentSessionTurnReasoningSummaryPartDoneEvent.summaryIndex
            turnId = agentSessionTurnReasoningSummaryPartDoneEvent.turnId
            type = agentSessionTurnReasoningSummaryPartDoneEvent.type
            additionalProperties =
                agentSessionTurnReasoningSummaryPartDoneEvent.additionalProperties.toMutableMap()
        }

        /** The unique ID of the event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the reasoning item. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the item in the turn output. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The completed summary part. */
        fun part(part: SummaryText) = part(JsonField.of(part))

        /**
         * Sets [Builder.part] to an arbitrary JSON value.
         *
         * You should usually call [Builder.part] with a well-typed [SummaryText] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun part(part: JsonField<SummaryText>) = apply { this.part = part }

        /** The ID of the session associated with the event. */
        fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

        /**
         * Sets [Builder.sessionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

        /** Present as `incomplete` when summary generation was interrupted. */
        fun status(status: Status?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The index of the summary part. */
        fun summaryIndex(summaryIndex: Long) = summaryIndex(JsonField.of(summaryIndex))

        /**
         * Sets [Builder.summaryIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summaryIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun summaryIndex(summaryIndex: JsonField<Long>) = apply { this.summaryIndex = summaryIndex }

        /** The ID of the turn associated with the event, when applicable. */
        fun turnId(turnId: String?) = turnId(JsonField.ofNullable(turnId))

        /** Alias for calling [Builder.turnId] with `turnId.orElse(null)`. */
        fun turnId(turnId: Optional<String>) = turnId(turnId.getOrNull())

        /**
         * Sets [Builder.turnId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.session.turn.reasoning_summary_part.done")
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
         * Returns an immutable instance of [AgentSessionTurnReasoningSummaryPartDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .part()
         * .sessionId()
         * .summaryIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSessionTurnReasoningSummaryPartDoneEvent =
            AgentSessionTurnReasoningSummaryPartDoneEvent(
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                checkRequired("sessionId", sessionId),
                checkRequired("status", status),
                checkRequired("summaryIndex", summaryIndex),
                checkRequired("turnId", turnId),
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
    fun validate(): AgentSessionTurnReasoningSummaryPartDoneEvent = apply {
        if (validated) {
            return@apply
        }

        eventIdOrThrow()
        itemIdOrThrow()
        outputIndexOrThrow()
        partOrThrow().validate()
        sessionIdOrThrow()
        status()
        summaryIndexOrThrow()
        turnId()
        typeOrThrow()
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
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (part.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sessionId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (summaryIndex.asKnown().isPresent) 1 else 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let {
                if (it == JsonValue.from("agent.session.turn.reasoning_summary_part.done")) 1 else 0
            }

    /** Present as `incomplete` when summary generation was interrupted. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            INCOMPLETE
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            INCOMPLETE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                INCOMPLETE -> Value.INCOMPLETE
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
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                INCOMPLETE -> Known.INCOMPLETE
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionTurnReasoningSummaryPartDoneEvent &&
            eventId == other.eventId &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            part == other.part &&
            sessionId == other.sessionId &&
            status == other.status &&
            summaryIndex == other.summaryIndex &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            eventId,
            itemId,
            outputIndex,
            part,
            sessionId,
            status,
            summaryIndex,
            turnId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSessionTurnReasoningSummaryPartDoneEvent{eventId=$eventId, itemId=$itemId, outputIndex=$outputIndex, part=$part, sessionId=$sessionId, status=$status, summaryIndex=$summaryIndex, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
