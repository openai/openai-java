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
 * Add a new Item to the Conversation's context, including messages, function calls, and function
 * call responses. This event can be used both to populate a "history" of the conversation and to
 * add new items mid-stream, but has the current limitation that it cannot populate assistant audio
 * messages.
 *
 * If successful, the server will respond with a `conversation.item.created` event, otherwise an
 * `error` event will be sent.
 */
class ConversationItemCreateEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<ConversationItem>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val previousItemId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item") @ExcludeMissing item: JsonField<ConversationItem> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("previous_item_id")
        @ExcludeMissing
        previousItemId: JsonField<String> = JsonMissing.of(),
    ) : this(item, type, eventId, previousItemId, mutableMapOf())

    /**
     * A single item within a Realtime conversation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): ConversationItem = item.getRequired("item")

    /**
     * The event type, must be `conversation.item.create`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("conversation.item.create")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client-generated ID used to identify this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * The ID of the preceding item after which the new item will be inserted. If not set, the new
     * item will be appended to the end of the conversation.
     *
     * If set to `root`, the new item will be added to the beginning of the conversation.
     *
     * If set to an existing ID, it allows an item to be inserted mid-conversation. If the ID cannot
     * be found, an error will be returned and the item will not be added.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousItemId(): Optional<String> = previousItemId.getOptional("previous_item_id")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ConversationItem> = item

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
         * Returns a mutable builder for constructing an instance of [ConversationItemCreateEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemCreateEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<ConversationItem>? = null
        private var type: JsonValue = JsonValue.from("conversation.item.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var previousItemId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemCreateEvent: ConversationItemCreateEvent) = apply {
            item = conversationItemCreateEvent.item
            type = conversationItemCreateEvent.type
            eventId = conversationItemCreateEvent.eventId
            previousItemId = conversationItemCreateEvent.previousItemId
            additionalProperties = conversationItemCreateEvent.additionalProperties.toMutableMap()
        }

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

        /** Alias for calling [item] with `ConversationItem.ofMcpCall(mcpCall)`. */
        fun item(mcpCall: RealtimeMcpToolCall) = item(ConversationItem.ofMcpCall(mcpCall))

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
         * JsonValue.from("conversation.item.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional client-generated ID used to identify this event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /**
         * The ID of the preceding item after which the new item will be inserted. If not set, the
         * new item will be appended to the end of the conversation.
         *
         * If set to `root`, the new item will be added to the beginning of the conversation.
         *
         * If set to an existing ID, it allows an item to be inserted mid-conversation. If the ID
         * cannot be found, an error will be returned and the item will not be added.
         */
        fun previousItemId(previousItemId: String) = previousItemId(JsonField.of(previousItemId))

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
         * Returns an immutable instance of [ConversationItemCreateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemCreateEvent =
            ConversationItemCreateEvent(
                checkRequired("item", item),
                type,
                eventId,
                previousItemId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemCreateEvent = apply {
        if (validated) {
            return@apply
        }

        item().validate()
        _type().let {
            if (it != JsonValue.from("conversation.item.create")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
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
        (item.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("conversation.item.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (previousItemId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItemCreateEvent &&
            item == other.item &&
            type == other.type &&
            eventId == other.eventId &&
            previousItemId == other.previousItemId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(item, type, eventId, previousItemId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemCreateEvent{item=$item, type=$type, eventId=$eventId, previousItemId=$previousItemId, additionalProperties=$additionalProperties}"
}
