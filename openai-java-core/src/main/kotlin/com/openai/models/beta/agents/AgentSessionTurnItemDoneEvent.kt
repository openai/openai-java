// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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
import kotlin.jvm.optionals.getOrNull

/** Emitted when an output item is complete. */
class AgentSessionTurnItemDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val eventId: JsonField<String>,
    private val item: JsonField<AgentOutputItem>,
    private val outputIndex: JsonField<Long>,
    private val sessionId: JsonField<String>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item") @ExcludeMissing item: JsonField<AgentOutputItem> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("session_id") @ExcludeMissing sessionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(eventId, item, outputIndex, sessionId, turnId, type, mutableMapOf())

    /**
     * The unique ID of the event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * The completed output item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): AgentOutputItem = item.getRequired("item")

    /**
     * The index of the output item in the turn output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The ID of the session associated with the event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sessionId(): String = sessionId.getRequired("session_id")

    /**
     * The ID of the turn associated with the event, when applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun turnId(): Optional<String> = turnId.getOptional("turn_id")

    /**
     * The type of the object. Always `agent.session.turn.item.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("agent.session.turn.item.done")
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
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<AgentOutputItem> = item

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [sessionId].
     *
     * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [AgentSessionTurnItemDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * .outputIndex()
         * .sessionId()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSessionTurnItemDoneEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var item: JsonField<AgentOutputItem>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sessionId: JsonField<String>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("agent.session.turn.item.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentSessionTurnItemDoneEvent: AgentSessionTurnItemDoneEvent) = apply {
            eventId = agentSessionTurnItemDoneEvent.eventId
            item = agentSessionTurnItemDoneEvent.item
            outputIndex = agentSessionTurnItemDoneEvent.outputIndex
            sessionId = agentSessionTurnItemDoneEvent.sessionId
            turnId = agentSessionTurnItemDoneEvent.turnId
            type = agentSessionTurnItemDoneEvent.type
            additionalProperties = agentSessionTurnItemDoneEvent.additionalProperties.toMutableMap()
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

        /** The completed output item. */
        fun item(item: AgentOutputItem) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [AgentOutputItem] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun item(item: JsonField<AgentOutputItem>) = apply { this.item = item }

        /** Alias for calling [item] with `AgentOutputItem.ofMessage(message)`. */
        fun item(message: AgentSessionAssistantMessage) = item(AgentOutputItem.ofMessage(message))

        /** Alias for calling [item] with `AgentOutputItem.ofReasoning(reasoning)`. */
        fun item(reasoning: AgentReasoningItem) = item(AgentOutputItem.ofReasoning(reasoning))

        /** Alias for calling [item] with `AgentOutputItem.ofFunctionCall(functionCall)`. */
        fun item(functionCall: AgentFunctionCallItem) =
            item(AgentOutputItem.ofFunctionCall(functionCall))

        /** Alias for calling [item] with `AgentOutputItem.ofMcpCall(mcpCall)`. */
        fun item(mcpCall: AgentMcpCallItem) = item(AgentOutputItem.ofMcpCall(mcpCall))

        /** Alias for calling [item] with `AgentOutputItem.ofWebSearchCall(webSearchCall)`. */
        fun item(webSearchCall: AgentWebSearchCallItem) =
            item(AgentOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [item] with `AgentOutputItem.ofCommandExecution(commandExecution)`. */
        fun item(commandExecution: AgentCommandExecutionItem) =
            item(AgentOutputItem.ofCommandExecution(commandExecution))

        /**
         * Alias for calling [item] with `AgentOutputItem.ofCreateSubagentCall(createSubagentCall)`.
         */
        fun item(createSubagentCall: AgentCreateSubagentCallItem) =
            item(AgentOutputItem.ofCreateSubagentCall(createSubagentCall))

        /**
         * Alias for calling [item] with
         * `AgentOutputItem.ofSendSubagentInputCall(sendSubagentInputCall)`.
         */
        fun item(sendSubagentInputCall: AgentSendSubagentInputCallItem) =
            item(AgentOutputItem.ofSendSubagentInputCall(sendSubagentInputCall))

        /**
         * Alias for calling [item] with `AgentOutputItem.ofResumeSubagentCall(resumeSubagentCall)`.
         */
        fun item(resumeSubagentCall: AgentResumeSubagentCallItem) =
            item(AgentOutputItem.ofResumeSubagentCall(resumeSubagentCall))

        /**
         * Alias for calling [item] with
         * `AgentOutputItem.ofWaitForSubagentsCall(waitForSubagentsCall)`.
         */
        fun item(waitForSubagentsCall: AgentWaitForSubagentsCallItem) =
            item(AgentOutputItem.ofWaitForSubagentsCall(waitForSubagentsCall))

        /**
         * Alias for calling [item] with
         * `AgentOutputItem.ofInterruptSubagentCall(interruptSubagentCall)`.
         */
        fun item(interruptSubagentCall: AgentInterruptSubagentCallItem) =
            item(AgentOutputItem.ofInterruptSubagentCall(interruptSubagentCall))

        /**
         * Alias for calling [item] with `AgentOutputItem.ofCloseSubagentCall(closeSubagentCall)`.
         */
        fun item(closeSubagentCall: AgentCloseSubagentCallItem) =
            item(AgentOutputItem.ofCloseSubagentCall(closeSubagentCall))

        /** The index of the output item in the turn output. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

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
         * JsonValue.from("agent.session.turn.item.done")
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
         * Returns an immutable instance of [AgentSessionTurnItemDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * .outputIndex()
         * .sessionId()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSessionTurnItemDoneEvent =
            AgentSessionTurnItemDoneEvent(
                checkRequired("eventId", eventId),
                checkRequired("item", item),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sessionId", sessionId),
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
    fun validate(): AgentSessionTurnItemDoneEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        item().validate()
        outputIndex()
        sessionId()
        turnId()
        _type().let {
            if (it != JsonValue.from("agent.session.turn.item.done")) {
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
            (item.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sessionId.asKnown().isPresent) 1 else 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("agent.session.turn.item.done")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionTurnItemDoneEvent &&
            eventId == other.eventId &&
            item == other.item &&
            outputIndex == other.outputIndex &&
            sessionId == other.sessionId &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, item, outputIndex, sessionId, turnId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSessionTurnItemDoneEvent{eventId=$eventId, item=$item, outputIndex=$outputIndex, sessionId=$sessionId, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
