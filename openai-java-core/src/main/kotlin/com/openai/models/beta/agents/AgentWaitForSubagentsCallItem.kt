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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A request to wait for one or more subagents. */
class AgentWaitForSubagentsCallItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val recipientAgentIds: JsonField<List<String>>,
    private val senderAgentId: JsonField<String>,
    private val status: JsonField<AgentFunctionCallStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipient_agent_ids")
        @ExcludeMissing
        recipientAgentIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("sender_agent_id")
        @ExcludeMissing
        senderAgentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, recipientAgentIds, senderAgentId, status, turnId, type, mutableMapOf())

    /**
     * The ID of the tool call item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The IDs of the agents to wait for.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAgentIds(): List<String> = recipientAgentIds.getRequired("recipient_agent_ids")

    /**
     * The ID of the agent waiting for results.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun senderAgentId(): String = senderAgentId.getRequired("sender_agent_id")

    /**
     * The status of the tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): AgentFunctionCallStatus = status.getRequired("status")

    /**
     * The ID of the turn that contains this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun turnId(): String = turnId.getRequired("turn_id")

    /**
     * The item type. Always `wait_for_subagents_call`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("wait_for_subagents_call")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [recipientAgentIds].
     *
     * Unlike [recipientAgentIds], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("recipient_agent_ids")
    @ExcludeMissing
    fun _recipientAgentIds(): JsonField<List<String>> = recipientAgentIds

    /**
     * Returns the raw JSON value of [senderAgentId].
     *
     * Unlike [senderAgentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_agent_id")
    @ExcludeMissing
    fun _senderAgentId(): JsonField<String> = senderAgentId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<AgentFunctionCallStatus> = status

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
         * [AgentWaitForSubagentsCallItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .recipientAgentIds()
         * .senderAgentId()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentWaitForSubagentsCallItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var recipientAgentIds: JsonField<MutableList<String>>? = null
        private var senderAgentId: JsonField<String>? = null
        private var status: JsonField<AgentFunctionCallStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("wait_for_subagents_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentWaitForSubagentsCallItem: AgentWaitForSubagentsCallItem) = apply {
            id = agentWaitForSubagentsCallItem.id
            recipientAgentIds =
                agentWaitForSubagentsCallItem.recipientAgentIds.map { it.toMutableList() }
            senderAgentId = agentWaitForSubagentsCallItem.senderAgentId
            status = agentWaitForSubagentsCallItem.status
            turnId = agentWaitForSubagentsCallItem.turnId
            type = agentWaitForSubagentsCallItem.type
            additionalProperties = agentWaitForSubagentsCallItem.additionalProperties.toMutableMap()
        }

        /** The ID of the tool call item. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The IDs of the agents to wait for. */
        fun recipientAgentIds(recipientAgentIds: List<String>) =
            recipientAgentIds(JsonField.of(recipientAgentIds))

        /**
         * Sets [Builder.recipientAgentIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAgentIds] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun recipientAgentIds(recipientAgentIds: JsonField<List<String>>) = apply {
            this.recipientAgentIds = recipientAgentIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [recipientAgentIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipientAgentId(recipientAgentId: String) = apply {
            recipientAgentIds =
                (recipientAgentIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("recipientAgentIds", it).add(recipientAgentId)
                }
        }

        /** The ID of the agent waiting for results. */
        fun senderAgentId(senderAgentId: String) = senderAgentId(JsonField.of(senderAgentId))

        /**
         * Sets [Builder.senderAgentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderAgentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderAgentId(senderAgentId: JsonField<String>) = apply {
            this.senderAgentId = senderAgentId
        }

        /** The status of the tool call. */
        fun status(status: AgentFunctionCallStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [AgentFunctionCallStatus]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun status(status: JsonField<AgentFunctionCallStatus>) = apply { this.status = status }

        /** The ID of the turn that contains this item. */
        fun turnId(turnId: String) = turnId(JsonField.of(turnId))

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
         * JsonValue.from("wait_for_subagents_call")
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
         * Returns an immutable instance of [AgentWaitForSubagentsCallItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .recipientAgentIds()
         * .senderAgentId()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentWaitForSubagentsCallItem =
            AgentWaitForSubagentsCallItem(
                checkRequired("id", id),
                checkRequired("recipientAgentIds", recipientAgentIds).map { it.toImmutable() },
                checkRequired("senderAgentId", senderAgentId),
                checkRequired("status", status),
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
    fun validate(): AgentWaitForSubagentsCallItem = apply {
        if (validated) {
            return@apply
        }

        id()
        recipientAgentIds()
        senderAgentId()
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("wait_for_subagents_call")) {
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (recipientAgentIds.asKnown().getOrNull()?.size ?: 0) +
            (if (senderAgentId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("wait_for_subagents_call")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentWaitForSubagentsCallItem &&
            id == other.id &&
            recipientAgentIds == other.recipientAgentIds &&
            senderAgentId == other.senderAgentId &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            recipientAgentIds,
            senderAgentId,
            status,
            turnId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentWaitForSubagentsCallItem{id=$id, recipientAgentIds=$recipientAgentIds, senderAgentId=$senderAgentId, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
