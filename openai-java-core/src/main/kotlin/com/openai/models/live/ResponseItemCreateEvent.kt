// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseCodeInterpreterToolCall
import com.openai.models.responses.ResponseCompactionItemParam
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseConfigurationUpdateItemParam
import com.openai.models.responses.ResponseCustomToolCall
import com.openai.models.responses.ResponseCustomToolCallOutput
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionCallOutputItem
import com.openai.models.responses.ResponseFunctionToolCall
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseReasoningItem
import com.openai.models.responses.ResponseToolSearchOutputItemParam
import com.openai.models.responses.Tool
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Add an input item to the Live session’s Responses backend. Requires Responses delegation; use
 * `response.create` to request a response.
 */
class ResponseItemCreateEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<ResponseInputItem>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item") @ExcludeMissing item: JsonField<ResponseInputItem> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(item, type, eventId, mutableMapOf())

    /**
     * An input item to append to the Responses backend conversation, such as a user message or a
     * function tool result.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): ResponseInputItem = item.getRequired("item")

    /**
     * The Live client event type. Always `response.item.create`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.item.create")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client identifier for correlating this command with a server event's client_event_id
     * or error.client_event_id.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ResponseInputItem> = item

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
         * Returns a mutable builder for constructing an instance of [ResponseItemCreateEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseItemCreateEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<ResponseInputItem>? = null
        private var type: JsonValue = JsonValue.from("response.item.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseItemCreateEvent: ResponseItemCreateEvent) = apply {
            item = responseItemCreateEvent.item
            type = responseItemCreateEvent.type
            eventId = responseItemCreateEvent.eventId
            additionalProperties = responseItemCreateEvent.additionalProperties.toMutableMap()
        }

        /**
         * An input item to append to the Responses backend conversation, such as a user message or
         * a function tool result.
         */
        fun item(item: ResponseInputItem) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [ResponseInputItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun item(item: JsonField<ResponseInputItem>) = apply { this.item = item }

        /**
         * Alias for calling [item] with `ResponseInputItem.ofEasyInputMessage(easyInputMessage)`.
         */
        fun item(easyInputMessage: EasyInputMessage) =
            item(ResponseInputItem.ofEasyInputMessage(easyInputMessage))

        /** Alias for calling [item] with `ResponseInputItem.ofMessage(message)`. */
        fun item(message: ResponseInputItem.Message) = item(ResponseInputItem.ofMessage(message))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofResponseOutputMessage(responseOutputMessage)`.
         */
        fun item(responseOutputMessage: ResponseOutputMessage) =
            item(ResponseInputItem.ofResponseOutputMessage(responseOutputMessage))

        /** Alias for calling [item] with `ResponseInputItem.ofFileSearchCall(fileSearchCall)`. */
        fun item(fileSearchCall: ResponseFileSearchToolCall) =
            item(ResponseInputItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [item] with `ResponseInputItem.ofComputerCall(computerCall)`. */
        fun item(computerCall: ResponseComputerToolCall) =
            item(ResponseInputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun item(computerCallOutput: ResponseInputItem.ComputerCallOutput) =
            item(ResponseInputItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [item] with `ResponseInputItem.ofWebSearchCall(webSearchCall)`. */
        fun item(webSearchCall: ResponseFunctionWebSearch) =
            item(ResponseInputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [item] with `ResponseInputItem.ofFunctionCall(functionCall)`. */
        fun item(functionCall: ResponseFunctionToolCall) =
            item(ResponseInputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun item(functionCallOutput: ResponseInputItem.FunctionCallOutput) =
            item(ResponseInputItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [item] with the following:
         * ```java
         * ResponseInputItem.FunctionCallOutput.builder()
         *     .output(output)
         *     .build()
         * ```
         */
        fun functionCallOutputItem(output: ResponseInputItem.FunctionCallOutput.Output) =
            item(ResponseInputItem.FunctionCallOutput.builder().output(output).build())

        /**
         * Alias for calling [functionCallOutputItem] with
         * `ResponseInputItem.FunctionCallOutput.Output.ofString(string)`.
         */
        fun functionCallOutputItem(string: String) =
            functionCallOutputItem(ResponseInputItem.FunctionCallOutput.Output.ofString(string))

        /**
         * Alias for calling [functionCallOutputItem] with
         * `ResponseInputItem.FunctionCallOutput.Output.ofResponseFunctionCallOutputItemList(responseFunctionCallOutputItemList)`.
         */
        fun functionCallOutputItemOfResponseFunctionCallOutputItemList(
            responseFunctionCallOutputItemList: List<ResponseFunctionCallOutputItem>
        ) =
            functionCallOutputItem(
                ResponseInputItem.FunctionCallOutput.Output.ofResponseFunctionCallOutputItemList(
                    responseFunctionCallOutputItemList
                )
            )

        /** Alias for calling [item] with `ResponseInputItem.ofToolSearchCall(toolSearchCall)`. */
        fun item(toolSearchCall: ResponseInputItem.ToolSearchCall) =
            item(ResponseInputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [item] with the following:
         * ```java
         * ResponseInputItem.ToolSearchCall.builder()
         *     .arguments(arguments)
         *     .build()
         * ```
         */
        fun toolSearchCallItem(arguments: JsonValue) =
            item(ResponseInputItem.ToolSearchCall.builder().arguments(arguments).build())

        /**
         * Alias for calling [item] with `ResponseInputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun item(toolSearchOutput: ResponseToolSearchOutputItemParam) =
            item(ResponseInputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [item] with the following:
         * ```java
         * ResponseToolSearchOutputItemParam.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun toolSearchOutputItem(tools: List<Tool>) =
            item(ResponseToolSearchOutputItemParam.builder().tools(tools).build())

        /** Alias for calling [item] with `ResponseInputItem.ofAdditionalTools(additionalTools)`. */
        fun item(additionalTools: ResponseInputItem.AdditionalTools) =
            item(ResponseInputItem.ofAdditionalTools(additionalTools))

        /**
         * Alias for calling [item] with the following:
         * ```java
         * ResponseInputItem.AdditionalTools.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun additionalToolsItem(tools: List<Tool>) =
            item(ResponseInputItem.AdditionalTools.builder().tools(tools).build())

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofConfigurationUpdate(configurationUpdate)`.
         */
        fun item(configurationUpdate: ResponseConfigurationUpdateItemParam) =
            item(ResponseInputItem.ofConfigurationUpdate(configurationUpdate))

        /** Alias for calling [item] with `ResponseInputItem.ofReasoning(reasoning)`. */
        fun item(reasoning: ResponseReasoningItem) = item(ResponseInputItem.ofReasoning(reasoning))

        /** Alias for calling [item] with `ResponseInputItem.ofCompaction(compaction)`. */
        fun item(compaction: ResponseCompactionItemParam) =
            item(ResponseInputItem.ofCompaction(compaction))

        /**
         * Alias for calling [item] with the following:
         * ```java
         * ResponseCompactionItemParam.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun compactionItem(encryptedContent: String) =
            item(ResponseCompactionItemParam.builder().encryptedContent(encryptedContent).build())

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun item(imageGenerationCall: ResponseInputItem.ImageGenerationCall) =
            item(ResponseInputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun item(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            item(ResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /** Alias for calling [item] with `ResponseInputItem.ofLocalShellCall(localShellCall)`. */
        fun item(localShellCall: ResponseInputItem.LocalShellCall) =
            item(ResponseInputItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun item(localShellCallOutput: ResponseInputItem.LocalShellCallOutput) =
            item(ResponseInputItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [item] with `ResponseInputItem.ofShellCall(shellCall)`. */
        fun item(shellCall: ResponseInputItem.ShellCall) =
            item(ResponseInputItem.ofShellCall(shellCall))

        /** Alias for calling [item] with `ResponseInputItem.ofShellCallOutput(shellCallOutput)`. */
        fun item(shellCallOutput: ResponseInputItem.ShellCallOutput) =
            item(ResponseInputItem.ofShellCallOutput(shellCallOutput))

        /** Alias for calling [item] with `ResponseInputItem.ofApplyPatchCall(applyPatchCall)`. */
        fun item(applyPatchCall: ResponseInputItem.ApplyPatchCall) =
            item(ResponseInputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun item(applyPatchCallOutput: ResponseInputItem.ApplyPatchCallOutput) =
            item(ResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /** Alias for calling [item] with `ResponseInputItem.ofMcpListTools(mcpListTools)`. */
        fun item(mcpListTools: ResponseInputItem.McpListTools) =
            item(ResponseInputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun item(mcpApprovalRequest: ResponseInputItem.McpApprovalRequest) =
            item(ResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun item(mcpApprovalResponse: ResponseInputItem.McpApprovalResponse) =
            item(ResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [item] with `ResponseInputItem.ofMcpCall(mcpCall)`. */
        fun item(mcpCall: ResponseInputItem.McpCall) = item(ResponseInputItem.ofMcpCall(mcpCall))

        /**
         * Alias for calling [item] with
         * `ResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun item(customToolCallOutput: ResponseCustomToolCallOutput) =
            item(ResponseInputItem.ofCustomToolCallOutput(customToolCallOutput))

        /** Alias for calling [item] with `ResponseInputItem.ofCustomToolCall(customToolCall)`. */
        fun item(customToolCall: ResponseCustomToolCall) =
            item(ResponseInputItem.ofCustomToolCall(customToolCall))

        /** Alias for calling [item] with `ResponseInputItem.ofCompactionTrigger()`. */
        fun itemCompactionTrigger() = item(ResponseInputItem.ofCompactionTrigger())

        /** Alias for calling [item] with `ResponseInputItem.ofItemReference(itemReference)`. */
        fun item(itemReference: ResponseInputItem.ItemReference) =
            item(ResponseInputItem.ofItemReference(itemReference))

        /** Alias for calling [item] with `ResponseInputItem.ofProgram(program)`. */
        fun item(program: ResponseInputItem.Program) = item(ResponseInputItem.ofProgram(program))

        /** Alias for calling [item] with `ResponseInputItem.ofProgramOutput(programOutput)`. */
        fun item(programOutput: ResponseInputItem.ProgramOutput) =
            item(ResponseInputItem.ofProgramOutput(programOutput))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.item.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Optional client identifier for correlating this command with a server event's
         * client_event_id or error.client_event_id.
         */
        fun eventId(eventId: String?) = eventId(JsonField.ofNullable(eventId))

        /** Alias for calling [Builder.eventId] with `eventId.orElse(null)`. */
        fun eventId(eventId: Optional<String>) = eventId(eventId.getOrNull())

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

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
         * Returns an immutable instance of [ResponseItemCreateEvent].
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
        fun build(): ResponseItemCreateEvent =
            ResponseItemCreateEvent(
                checkRequired("item", item),
                type,
                eventId,
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
    fun validate(): ResponseItemCreateEvent = apply {
        if (validated) {
            return@apply
        }

        item().validate()
        _type().let {
            if (it != JsonValue.from("response.item.create")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
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
            type.let { if (it == JsonValue.from("response.item.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseItemCreateEvent &&
            item == other.item &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(item, type, eventId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseItemCreateEvent{item=$item, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
