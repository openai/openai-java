// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

/**
 * Returned when a conversation item is created. There are several scenarios that produce this
 * event:
 * - The server is generating a Response, which if successful will produce either one or two Items,
 *   which will be of type `message` (role `assistant`) or type `function_call`.
 * - The input audio buffer has been committed, either by the client or the server (in `server_vad`
 *   mode). The server will take the content of the input audio buffer and add it to a new user
 *   message Item.
 * - The client has sent a `conversation.item.create` event to add a new Item to the Conversation.
 */
class ConversationItemCreatedEvent
private constructor(
    private val eventId: JsonField<String>,
    private val item: JsonField<ConversationItem>,
    private val type: JsonValue,
    private val previousItemId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item") @ExcludeMissing item: JsonField<ConversationItem> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("previous_item_id")
        @ExcludeMissing
        previousItemId: JsonField<String> = JsonMissing.of(),
    ) : this(eventId, item, type, previousItemId, mutableMapOf())

    /**
     * The unique ID of the server event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventId(): String = eventId.getRequired("event_id")

    /**
     * A single item within a Realtime conversation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): ConversationItem = item.getRequired("item")

    /**
     * The event type, must be `conversation.item.created`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("conversation.item.created")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The ID of the preceding item in the Conversation context, allows the client to understand the
     * order of the conversation. Can be `null` if the item has no predecessor.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousItemId(): Optional<String> = previousItemId.getOptional("previous_item_id")

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
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ConversationItem> = item

    /**
     * Returns the raw JSON value of [previousItemId].
     *
     * Unlike [previousItemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("previous_item_id")
    @ExcludeMissing
    fun _previousItemId(): JsonField<String> = previousItemId

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
         * Returns a mutable builder for constructing an instance of [ConversationItemCreatedEvent].
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemCreatedEvent]. */
    class Builder internal constructor() {

        private var eventId: JsonField<String>? = null
        private var item: JsonField<ConversationItem>? = null
        private var type: JsonValue = JsonValue.from("conversation.item.created")
        private var previousItemId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemCreatedEvent: ConversationItemCreatedEvent) = apply {
            eventId = conversationItemCreatedEvent.eventId
            item = conversationItemCreatedEvent.item
            type = conversationItemCreatedEvent.type
            previousItemId = conversationItemCreatedEvent.previousItemId
            additionalProperties = conversationItemCreatedEvent.additionalProperties.toMutableMap()
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

        /** A single item within a Realtime conversation. */
        fun item(item: ConversationItem) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [ConversationItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun item(item: JsonField<ConversationItem>) = apply { this.item = item }

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofRealtimeConversationItemSystemMessage(realtimeConversationItemSystemMessage)`.
         */
        fun item(realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage) =
            item(
                ConversationItem.ofRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage
                )
            )

        /**
         * Alias for calling [item] with the following:
         * ```java
         * RealtimeConversationItemSystemMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun realtimeConversationItemSystemMessageItem(
            content: List<RealtimeConversationItemSystemMessage.Content>
        ) = item(RealtimeConversationItemSystemMessage.builder().content(content).build())

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofRealtimeConversationItemUserMessage(realtimeConversationItemUserMessage)`.
         */
        fun item(realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage) =
            item(
                ConversationItem.ofRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage
                )
            )

        /**
         * Alias for calling [item] with the following:
         * ```java
         * RealtimeConversationItemUserMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun realtimeConversationItemUserMessageItem(
            content: List<RealtimeConversationItemUserMessage.Content>
        ) = item(RealtimeConversationItemUserMessage.builder().content(content).build())

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofRealtimeConversationItemAssistantMessage(realtimeConversationItemAssistantMessage)`.
         */
        fun item(
            realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
        ) =
            item(
                ConversationItem.ofRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage
                )
            )

        /**
         * Alias for calling [item] with the following:
         * ```java
         * RealtimeConversationItemAssistantMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun realtimeConversationItemAssistantMessageItem(
            content: List<RealtimeConversationItemAssistantMessage.Content>
        ) = item(RealtimeConversationItemAssistantMessage.builder().content(content).build())

        /** Alias for calling [item] with `ConversationItem.ofFunctionCall(functionCall)`. */
        fun item(functionCall: RealtimeConversationItemFunctionCall) =
            item(ConversationItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun item(functionCallOutput: RealtimeConversationItemFunctionCallOutput) =
            item(ConversationItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun item(mcpApprovalResponse: RealtimeMcpApprovalResponse) =
            item(ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [item] with `ConversationItem.ofMcpListTools(mcpListTools)`. */
        fun item(mcpListTools: RealtimeMcpListTools) =
            item(ConversationItem.ofMcpListTools(mcpListTools))

        /** Alias for calling [item] with `ConversationItem.ofMcpToolCall(mcpToolCall)`. */
        fun item(mcpToolCall: RealtimeMcpToolCall) =
            item(ConversationItem.ofMcpToolCall(mcpToolCall))

        /**
         * Alias for calling [item] with
         * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun item(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
            item(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("conversation.item.created")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The ID of the preceding item in the Conversation context, allows the client to understand
         * the order of the conversation. Can be `null` if the item has no predecessor.
         */
        fun previousItemId(previousItemId: String?) =
            previousItemId(JsonField.ofNullable(previousItemId))

        /** Alias for calling [Builder.previousItemId] with `previousItemId.orElse(null)`. */
        fun previousItemId(previousItemId: Optional<String>) =
            previousItemId(previousItemId.getOrNull())

        /**
         * Sets [Builder.previousItemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousItemId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousItemId(previousItemId: JsonField<String>) = apply {
            this.previousItemId = previousItemId
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
         * Returns an immutable instance of [ConversationItemCreatedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .eventId()
         * .item()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemCreatedEvent =
            ConversationItemCreatedEvent(
                checkRequired("eventId", eventId),
                checkRequired("item", item),
                type,
                previousItemId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemCreatedEvent = apply {
        if (validated) {
            return@apply
        }

        eventId()
        item().validate()
        _type().let {
            if (it != JsonValue.from("conversation.item.created")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        previousItemId()
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
            type.let { if (it == JsonValue.from("conversation.item.created")) 1 else 0 } +
            (if (previousItemId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItemCreatedEvent &&
            eventId == other.eventId &&
            item == other.item &&
            type == other.type &&
            previousItemId == other.previousItemId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(eventId, item, type, previousItemId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemCreatedEvent{eventId=$eventId, item=$item, type=$type, previousItemId=$previousItemId, additionalProperties=$additionalProperties}"
}
