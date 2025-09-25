// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

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
import com.openai.models.conversations.Message
import com.openai.models.responses.ResponseCodeInterpreterToolCall
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseComputerToolCallOutputItem
import com.openai.models.responses.ResponseCustomToolCall
import com.openai.models.responses.ResponseCustomToolCallOutput
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCallItem
import com.openai.models.responses.ResponseFunctionToolCallOutputItem
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseReasoningItem
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A list of Conversation items. */
class ConversationItemList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<ConversationItem>>,
    private val firstId: JsonField<String>,
    private val hasMore: JsonField<Boolean>,
    private val lastId: JsonField<String>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        data: JsonField<List<ConversationItem>> = JsonMissing.of(),
        @JsonProperty("first_id") @ExcludeMissing firstId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_id") @ExcludeMissing lastId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(data, firstId, hasMore, lastId, object_, mutableMapOf())

    /**
     * A list of conversation items.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<ConversationItem> = data.getRequired("data")

    /**
     * The ID of the first item in the list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun firstId(): String = firstId.getRequired("first_id")

    /**
     * Whether there are more items available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * The ID of the last item in the list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastId(): String = lastId.getRequired("last_id")

    /**
     * The type of object returned, must be `list`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("list")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<ConversationItem>> = data

    /**
     * Returns the raw JSON value of [firstId].
     *
     * Unlike [firstId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_id") @ExcludeMissing fun _firstId(): JsonField<String> = firstId

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [lastId].
     *
     * Unlike [lastId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_id") @ExcludeMissing fun _lastId(): JsonField<String> = lastId

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
         * Returns a mutable builder for constructing an instance of [ConversationItemList].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemList]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<ConversationItem>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("list")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemList: ConversationItemList) = apply {
            data = conversationItemList.data.map { it.toMutableList() }
            firstId = conversationItemList.firstId
            hasMore = conversationItemList.hasMore
            lastId = conversationItemList.lastId
            object_ = conversationItemList.object_
            additionalProperties = conversationItemList.additionalProperties.toMutableMap()
        }

        /** A list of conversation items. */
        fun data(data: List<ConversationItem>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<ConversationItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun data(data: JsonField<List<ConversationItem>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [ConversationItem] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: ConversationItem) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** Alias for calling [addData] with `ConversationItem.ofMessage(message)`. */
        fun addData(message: Message) = addData(ConversationItem.ofMessage(message))

        /** Alias for calling [addData] with `ConversationItem.ofFunctionCall(functionCall)`. */
        fun addData(functionCall: ResponseFunctionToolCallItem) =
            addData(ConversationItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addData(functionCallOutput: ResponseFunctionToolCallOutputItem) =
            addData(ConversationItem.ofFunctionCallOutput(functionCallOutput))

        /** Alias for calling [addData] with `ConversationItem.ofFileSearchCall(fileSearchCall)`. */
        fun addData(fileSearchCall: ResponseFileSearchToolCall) =
            addData(ConversationItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [addData] with `ConversationItem.ofWebSearchCall(webSearchCall)`. */
        fun addData(webSearchCall: ResponseFunctionWebSearch) =
            addData(ConversationItem.ofWebSearchCall(webSearchCall))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addData(imageGenerationCall: ConversationItem.ImageGenerationCall) =
            addData(ConversationItem.ofImageGenerationCall(imageGenerationCall))

        /** Alias for calling [addData] with `ConversationItem.ofComputerCall(computerCall)`. */
        fun addData(computerCall: ResponseComputerToolCall) =
            addData(ConversationItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addData(computerCallOutput: ResponseComputerToolCallOutputItem) =
            addData(ConversationItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [addData] with `ConversationItem.ofReasoning(reasoning)`. */
        fun addData(reasoning: ResponseReasoningItem) =
            addData(ConversationItem.ofReasoning(reasoning))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addData(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            addData(ConversationItem.ofCodeInterpreterCall(codeInterpreterCall))

        /** Alias for calling [addData] with `ConversationItem.ofLocalShellCall(localShellCall)`. */
        fun addData(localShellCall: ConversationItem.LocalShellCall) =
            addData(ConversationItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addData(localShellCallOutput: ConversationItem.LocalShellCallOutput) =
            addData(ConversationItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [addData] with `ConversationItem.ofMcpListTools(mcpListTools)`. */
        fun addData(mcpListTools: ConversationItem.McpListTools) =
            addData(ConversationItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addData(mcpApprovalRequest: ConversationItem.McpApprovalRequest) =
            addData(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addData(mcpApprovalResponse: ConversationItem.McpApprovalResponse) =
            addData(ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addData] with `ConversationItem.ofMcpCall(mcpCall)`. */
        fun addData(mcpCall: ConversationItem.McpCall) =
            addData(ConversationItem.ofMcpCall(mcpCall))

        /** Alias for calling [addData] with `ConversationItem.ofCustomToolCall(customToolCall)`. */
        fun addData(customToolCall: ResponseCustomToolCall) =
            addData(ConversationItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addData] with
         * `ConversationItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addData(customToolCallOutput: ResponseCustomToolCallOutput) =
            addData(ConversationItem.ofCustomToolCallOutput(customToolCallOutput))

        /** The ID of the first item in the list. */
        fun firstId(firstId: String) = firstId(JsonField.of(firstId))

        /**
         * Sets [Builder.firstId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun firstId(firstId: JsonField<String>) = apply { this.firstId = firstId }

        /** Whether there are more items available. */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** The ID of the last item in the list. */
        fun lastId(lastId: String) = lastId(JsonField.of(lastId))

        /**
         * Sets [Builder.lastId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastId(lastId: JsonField<String>) = apply { this.lastId = lastId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("list")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [ConversationItemList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ConversationItemList =
            ConversationItemList(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                object_,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemList = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        firstId()
        hasMore()
        lastId()
        _object_().let {
            if (it != JsonValue.from("list")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
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
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (firstId.asKnown().isPresent) 1 else 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (lastId.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("list")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItemList &&
            data == other.data &&
            firstId == other.firstId &&
            hasMore == other.hasMore &&
            lastId == other.lastId &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, firstId, hasMore, lastId, object_, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemList{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, object_=$object_, additionalProperties=$additionalProperties}"
}
