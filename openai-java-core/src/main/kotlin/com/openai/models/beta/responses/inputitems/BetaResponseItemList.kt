// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses.inputitems

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
import com.openai.models.beta.responses.BetaResponseApplyPatchToolCall
import com.openai.models.beta.responses.BetaResponseApplyPatchToolCallOutput
import com.openai.models.beta.responses.BetaResponseCodeInterpreterToolCall
import com.openai.models.beta.responses.BetaResponseCompactionItem
import com.openai.models.beta.responses.BetaResponseComputerToolCall
import com.openai.models.beta.responses.BetaResponseComputerToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseCustomToolCallItem
import com.openai.models.beta.responses.BetaResponseCustomToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseFileSearchToolCall
import com.openai.models.beta.responses.BetaResponseFunctionShellToolCall
import com.openai.models.beta.responses.BetaResponseFunctionShellToolCallOutput
import com.openai.models.beta.responses.BetaResponseFunctionToolCallItem
import com.openai.models.beta.responses.BetaResponseFunctionToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseFunctionWebSearch
import com.openai.models.beta.responses.BetaResponseInputMessageItem
import com.openai.models.beta.responses.BetaResponseItem
import com.openai.models.beta.responses.BetaResponseOutputMessage
import com.openai.models.beta.responses.BetaResponseReasoningItem
import com.openai.models.beta.responses.BetaResponseToolSearchCall
import com.openai.models.beta.responses.BetaResponseToolSearchOutputItem
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A list of Response items. */
class BetaResponseItemList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<BetaResponseItem>>,
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
        data: JsonField<List<BetaResponseItem>> = JsonMissing.of(),
        @JsonProperty("first_id") @ExcludeMissing firstId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_id") @ExcludeMissing lastId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(data, firstId, hasMore, lastId, object_, mutableMapOf())

    /**
     * A list of items used to generate this response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<BetaResponseItem> = data.getRequired("data")

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
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<BetaResponseItem>> = data

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
         * Returns a mutable builder for constructing an instance of [BetaResponseItemList].
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

    /** A builder for [BetaResponseItemList]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<BetaResponseItem>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("list")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseItemList: BetaResponseItemList) = apply {
            data = betaResponseItemList.data.map { it.toMutableList() }
            firstId = betaResponseItemList.firstId
            hasMore = betaResponseItemList.hasMore
            lastId = betaResponseItemList.lastId
            object_ = betaResponseItemList.object_
            additionalProperties = betaResponseItemList.additionalProperties.toMutableMap()
        }

        /** A list of items used to generate this response. */
        fun data(data: List<BetaResponseItem>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<BetaResponseItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun data(data: JsonField<List<BetaResponseItem>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaResponseItem] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: BetaResponseItem) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofBetaResponseInputMessageItem(betaResponseInputMessageItem)`.
         */
        fun addData(betaResponseInputMessageItem: BetaResponseInputMessageItem) =
            addData(BetaResponseItem.ofBetaResponseInputMessageItem(betaResponseInputMessageItem))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofBetaResponseOutputMessage(betaResponseOutputMessage)`.
         */
        fun addData(betaResponseOutputMessage: BetaResponseOutputMessage) =
            addData(BetaResponseItem.ofBetaResponseOutputMessage(betaResponseOutputMessage))

        /** Alias for calling [addData] with `BetaResponseItem.ofFileSearchCall(fileSearchCall)`. */
        fun addData(fileSearchCall: BetaResponseFileSearchToolCall) =
            addData(BetaResponseItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [addData] with `BetaResponseItem.ofComputerCall(computerCall)`. */
        fun addData(computerCall: BetaResponseComputerToolCall) =
            addData(BetaResponseItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addData(computerCallOutput: BetaResponseComputerToolCallOutputItem) =
            addData(BetaResponseItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofWebSearchCall(webSearchCall)`. */
        fun addData(webSearchCall: BetaResponseFunctionWebSearch) =
            addData(BetaResponseItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [addData] with `BetaResponseItem.ofFunctionCall(functionCall)`. */
        fun addData(functionCall: BetaResponseFunctionToolCallItem) =
            addData(BetaResponseItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addData(functionCallOutput: BetaResponseFunctionToolCallOutputItem) =
            addData(BetaResponseItem.ofFunctionCallOutput(functionCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofAgentMessage(agentMessage)`. */
        fun addData(agentMessage: BetaResponseItem.AgentMessage) =
            addData(BetaResponseItem.ofAgentMessage(agentMessage))

        /** Alias for calling [addData] with `BetaResponseItem.ofMultiAgentCall(multiAgentCall)`. */
        fun addData(multiAgentCall: BetaResponseItem.MultiAgentCall) =
            addData(BetaResponseItem.ofMultiAgentCall(multiAgentCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofMultiAgentCallOutput(multiAgentCallOutput)`.
         */
        fun addData(multiAgentCallOutput: BetaResponseItem.MultiAgentCallOutput) =
            addData(BetaResponseItem.ofMultiAgentCallOutput(multiAgentCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofToolSearchCall(toolSearchCall)`. */
        fun addData(toolSearchCall: BetaResponseToolSearchCall) =
            addData(BetaResponseItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [addData] with `BetaResponseItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addData(toolSearchOutput: BetaResponseToolSearchOutputItem) =
            addData(BetaResponseItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addData] with `BetaResponseItem.ofAdditionalTools(additionalTools)`.
         */
        fun addData(additionalTools: BetaResponseItem.AdditionalTools) =
            addData(BetaResponseItem.ofAdditionalTools(additionalTools))

        /** Alias for calling [addData] with `BetaResponseItem.ofReasoning(reasoning)`. */
        fun addData(reasoning: BetaResponseReasoningItem) =
            addData(BetaResponseItem.ofReasoning(reasoning))

        /** Alias for calling [addData] with `BetaResponseItem.ofProgram(program)`. */
        fun addData(program: BetaResponseItem.Program) =
            addData(BetaResponseItem.ofProgram(program))

        /** Alias for calling [addData] with `BetaResponseItem.ofProgramOutput(programOutput)`. */
        fun addData(programOutput: BetaResponseItem.ProgramOutput) =
            addData(BetaResponseItem.ofProgramOutput(programOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofCompaction(compaction)`. */
        fun addData(compaction: BetaResponseCompactionItem) =
            addData(BetaResponseItem.ofCompaction(compaction))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addData(imageGenerationCall: BetaResponseItem.ImageGenerationCall) =
            addData(BetaResponseItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addData(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            addData(BetaResponseItem.ofCodeInterpreterCall(codeInterpreterCall))

        /** Alias for calling [addData] with `BetaResponseItem.ofLocalShellCall(localShellCall)`. */
        fun addData(localShellCall: BetaResponseItem.LocalShellCall) =
            addData(BetaResponseItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addData(localShellCallOutput: BetaResponseItem.LocalShellCallOutput) =
            addData(BetaResponseItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofShellCall(shellCall)`. */
        fun addData(shellCall: BetaResponseFunctionShellToolCall) =
            addData(BetaResponseItem.ofShellCall(shellCall))

        /**
         * Alias for calling [addData] with `BetaResponseItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addData(shellCallOutput: BetaResponseFunctionShellToolCallOutput) =
            addData(BetaResponseItem.ofShellCallOutput(shellCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofApplyPatchCall(applyPatchCall)`. */
        fun addData(applyPatchCall: BetaResponseApplyPatchToolCall) =
            addData(BetaResponseItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addData(applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput) =
            addData(BetaResponseItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /** Alias for calling [addData] with `BetaResponseItem.ofMcpListTools(mcpListTools)`. */
        fun addData(mcpListTools: BetaResponseItem.McpListTools) =
            addData(BetaResponseItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addData(mcpApprovalRequest: BetaResponseItem.McpApprovalRequest) =
            addData(BetaResponseItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addData(mcpApprovalResponse: BetaResponseItem.McpApprovalResponse) =
            addData(BetaResponseItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addData] with `BetaResponseItem.ofMcpCall(mcpCall)`. */
        fun addData(mcpCall: BetaResponseItem.McpCall) =
            addData(BetaResponseItem.ofMcpCall(mcpCall))

        /** Alias for calling [addData] with `BetaResponseItem.ofCustomToolCall(customToolCall)`. */
        fun addData(customToolCall: BetaResponseCustomToolCallItem) =
            addData(BetaResponseItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addData] with
         * `BetaResponseItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addData(customToolCallOutput: BetaResponseCustomToolCallOutputItem) =
            addData(BetaResponseItem.ofCustomToolCallOutput(customToolCallOutput))

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
         * Returns an immutable instance of [BetaResponseItemList].
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
        fun build(): BetaResponseItemList =
            BetaResponseItemList(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                object_,
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
    fun validate(): BetaResponseItemList = apply {
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

        return other is BetaResponseItemList &&
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
        "BetaResponseItemList{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, object_=$object_, additionalProperties=$additionalProperties}"
}
