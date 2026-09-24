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

/** A request to send input to another agent. */
class AgentSendSubagentInputCallItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val content: JsonField<List<AgentContent>>,
    private val recipientAgentId: JsonField<String>,
    private val senderAgentId: JsonField<String>,
    private val status: JsonField<AgentFunctionCallStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        content: JsonField<List<AgentContent>> = JsonMissing.of(),
        @JsonProperty("recipient_agent_id")
        @ExcludeMissing
        recipientAgentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_agent_id")
        @ExcludeMissing
        senderAgentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, content, recipientAgentId, senderAgentId, status, turnId, type, mutableMapOf())

    /**
     * The ID of the tool call item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The input sent to the receiving agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun content(): List<AgentContent> = content.getRequired("content")

    /**
     * The ID of the agent receiving the input.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAgentId(): String = recipientAgentId.getRequired("recipient_agent_id")

    /**
     * The ID of the agent sending the input.
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
     * The item type. Always `send_subagent_input_call`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("send_subagent_input_call")
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
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<AgentContent>> = content

    /**
     * Returns the raw JSON value of [recipientAgentId].
     *
     * Unlike [recipientAgentId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("recipient_agent_id")
    @ExcludeMissing
    fun _recipientAgentId(): JsonField<String> = recipientAgentId

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
         * [AgentSendSubagentInputCallItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .recipientAgentId()
         * .senderAgentId()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSendSubagentInputCallItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var content: JsonField<MutableList<AgentContent>>? = null
        private var recipientAgentId: JsonField<String>? = null
        private var senderAgentId: JsonField<String>? = null
        private var status: JsonField<AgentFunctionCallStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("send_subagent_input_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentSendSubagentInputCallItem: AgentSendSubagentInputCallItem) = apply {
            id = agentSendSubagentInputCallItem.id
            content = agentSendSubagentInputCallItem.content.map { it.toMutableList() }
            recipientAgentId = agentSendSubagentInputCallItem.recipientAgentId
            senderAgentId = agentSendSubagentInputCallItem.senderAgentId
            status = agentSendSubagentInputCallItem.status
            turnId = agentSendSubagentInputCallItem.turnId
            type = agentSendSubagentInputCallItem.type
            additionalProperties =
                agentSendSubagentInputCallItem.additionalProperties.toMutableMap()
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

        /** The input sent to the receiving agent. */
        fun content(content: List<AgentContent>) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed `List<AgentContent>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun content(content: JsonField<List<AgentContent>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Adds a single [AgentContent] to [Builder.content].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: AgentContent) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** Alias for calling [addContent] with `AgentContent.ofOutputText(outputText)`. */
        fun addContent(outputText: OutputText) = addContent(AgentContent.ofOutputText(outputText))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * OutputText.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addOutputTextContent(text: String) = addContent(OutputText.builder().text(text).build())

        /** Alias for calling [addContent] with `AgentContent.ofEncrypted(encrypted)`. */
        fun addContent(encrypted: AgentContent.EncryptedContent) =
            addContent(AgentContent.ofEncrypted(encrypted))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * AgentContent.EncryptedContent.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun addEncryptedContent(encryptedContent: String) =
            addContent(
                AgentContent.EncryptedContent.builder().encryptedContent(encryptedContent).build()
            )

        /** The ID of the agent receiving the input. */
        fun recipientAgentId(recipientAgentId: String) =
            recipientAgentId(JsonField.of(recipientAgentId))

        /**
         * Sets [Builder.recipientAgentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAgentId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientAgentId(recipientAgentId: JsonField<String>) = apply {
            this.recipientAgentId = recipientAgentId
        }

        /** The ID of the agent sending the input. */
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
         * JsonValue.from("send_subagent_input_call")
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
         * Returns an immutable instance of [AgentSendSubagentInputCallItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .content()
         * .recipientAgentId()
         * .senderAgentId()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSendSubagentInputCallItem =
            AgentSendSubagentInputCallItem(
                checkRequired("id", id),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("recipientAgentId", recipientAgentId),
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
    fun validate(): AgentSendSubagentInputCallItem = apply {
        if (validated) {
            return@apply
        }

        id()
        content().forEach { it.validate() }
        recipientAgentId()
        senderAgentId()
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("send_subagent_input_call")) {
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (recipientAgentId.asKnown().isPresent) 1 else 0) +
            (if (senderAgentId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("send_subagent_input_call")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSendSubagentInputCallItem &&
            id == other.id &&
            content == other.content &&
            recipientAgentId == other.recipientAgentId &&
            senderAgentId == other.senderAgentId &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            content,
            recipientAgentId,
            senderAgentId,
            status,
            turnId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSendSubagentInputCallItem{id=$id, content=$content, recipientAgentId=$recipientAgentId, senderAgentId=$senderAgentId, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
