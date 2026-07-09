// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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

/**
 * Injects input items into an active response over a WebSocket connection. The items are validated
 * and committed atomically. Currently, the server accepts client-owned tool outputs that resume a
 * waiting agent.
 */
class BetaResponseInjectEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val input: JsonField<List<BetaResponseInputItem>>,
    private val responseId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<List<BetaResponseInputItem>> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(input, responseId, type, mutableMapOf())

    /**
     * Input items to inject into the active response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): List<BetaResponseInputItem> = input.getRequired("input")

    /**
     * The ID of the active response that should receive the input.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseId(): String = responseId.getRequired("response_id")

    /**
     * The event discriminator. Always `response.inject`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.inject")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input")
    @ExcludeMissing
    fun _input(): JsonField<List<BetaResponseInputItem>> = input

    /**
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

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
         * Returns a mutable builder for constructing an instance of [BetaResponseInjectEvent].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .responseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseInjectEvent]. */
    class Builder internal constructor() {

        private var input: JsonField<MutableList<BetaResponseInputItem>>? = null
        private var responseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.inject")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseInjectEvent: BetaResponseInjectEvent) = apply {
            input = betaResponseInjectEvent.input.map { it.toMutableList() }
            responseId = betaResponseInjectEvent.responseId
            type = betaResponseInjectEvent.type
            additionalProperties = betaResponseInjectEvent.additionalProperties.toMutableMap()
        }

        /** Input items to inject into the active response. */
        fun input(input: List<BetaResponseInputItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<BetaResponseInputItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun input(input: JsonField<List<BetaResponseInputItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaResponseInputItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: BetaResponseInputItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofBetaEasyInputMessage(betaEasyInputMessage)`.
         */
        fun addInput(betaEasyInputMessage: BetaEasyInputMessage) =
            addInput(BetaResponseInputItem.ofBetaEasyInputMessage(betaEasyInputMessage))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofMessage(message)`. */
        fun addInput(message: BetaResponseInputItem.Message) =
            addInput(BetaResponseInputItem.ofMessage(message))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofBetaResponseOutputMessage(betaResponseOutputMessage)`.
         */
        fun addInput(betaResponseOutputMessage: BetaResponseOutputMessage) =
            addInput(BetaResponseInputItem.ofBetaResponseOutputMessage(betaResponseOutputMessage))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addInput(fileSearchCall: BetaResponseFileSearchToolCall) =
            addInput(BetaResponseInputItem.ofFileSearchCall(fileSearchCall))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofComputerCall(computerCall)`.
         */
        fun addInput(computerCall: BetaResponseComputerToolCall) =
            addInput(BetaResponseInputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addInput(computerCallOutput: BetaResponseInputItem.ComputerCallOutput) =
            addInput(BetaResponseInputItem.ofComputerCallOutput(computerCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addInput(webSearchCall: BetaResponseFunctionWebSearch) =
            addInput(BetaResponseInputItem.ofWebSearchCall(webSearchCall))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofFunctionCall(functionCall)`.
         */
        fun addInput(functionCall: BetaResponseFunctionToolCall) =
            addInput(BetaResponseInputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addInput(functionCallOutput: BetaResponseInputItem.FunctionCallOutput) =
            addInput(BetaResponseInputItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofAgentMessage(agentMessage)`.
         */
        fun addInput(agentMessage: BetaResponseInputItem.AgentMessage) =
            addInput(BetaResponseInputItem.ofAgentMessage(agentMessage))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMultiAgentCall(multiAgentCall)`.
         */
        fun addInput(multiAgentCall: BetaResponseInputItem.MultiAgentCall) =
            addInput(BetaResponseInputItem.ofMultiAgentCall(multiAgentCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMultiAgentCallOutput(multiAgentCallOutput)`.
         */
        fun addInput(multiAgentCallOutput: BetaResponseInputItem.MultiAgentCallOutput) =
            addInput(BetaResponseInputItem.ofMultiAgentCallOutput(multiAgentCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofToolSearchCall(toolSearchCall)`.
         */
        fun addInput(toolSearchCall: BetaResponseInputItem.ToolSearchCall) =
            addInput(BetaResponseInputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.ToolSearchCall.builder()
         *     .arguments(arguments)
         *     .build()
         * ```
         */
        fun addToolSearchCallInput(arguments: JsonValue) =
            addInput(BetaResponseInputItem.ToolSearchCall.builder().arguments(arguments).build())

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addInput(toolSearchOutput: BetaResponseToolSearchOutputItemParam) =
            addInput(BetaResponseInputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseToolSearchOutputItemParam.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun addToolSearchOutputInput(tools: List<BetaTool>) =
            addInput(BetaResponseToolSearchOutputItemParam.builder().tools(tools).build())

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofAdditionalTools(additionalTools)`.
         */
        fun addInput(additionalTools: BetaResponseInputItem.AdditionalTools) =
            addInput(BetaResponseInputItem.ofAdditionalTools(additionalTools))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.AdditionalTools.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun addAdditionalToolsInput(tools: List<BetaTool>) =
            addInput(BetaResponseInputItem.AdditionalTools.builder().tools(tools).build())

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofReasoning(reasoning)`. */
        fun addInput(reasoning: BetaResponseReasoningItem) =
            addInput(BetaResponseInputItem.ofReasoning(reasoning))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofCompaction(compaction)`. */
        fun addInput(compaction: BetaResponseCompactionItemParam) =
            addInput(BetaResponseInputItem.ofCompaction(compaction))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseCompactionItemParam.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun addCompactionInput(encryptedContent: String) =
            addInput(
                BetaResponseCompactionItemParam.builder().encryptedContent(encryptedContent).build()
            )

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addInput(imageGenerationCall: BetaResponseInputItem.ImageGenerationCall) =
            addInput(BetaResponseInputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addInput(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            addInput(BetaResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addInput(localShellCall: BetaResponseInputItem.LocalShellCall) =
            addInput(BetaResponseInputItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addInput(localShellCallOutput: BetaResponseInputItem.LocalShellCallOutput) =
            addInput(BetaResponseInputItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofShellCall(shellCall)`. */
        fun addInput(shellCall: BetaResponseInputItem.ShellCall) =
            addInput(BetaResponseInputItem.ofShellCall(shellCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addInput(shellCallOutput: BetaResponseInputItem.ShellCallOutput) =
            addInput(BetaResponseInputItem.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun addInput(applyPatchCall: BetaResponseInputItem.ApplyPatchCall) =
            addInput(BetaResponseInputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addInput(applyPatchCallOutput: BetaResponseInputItem.ApplyPatchCallOutput) =
            addInput(BetaResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofMcpListTools(mcpListTools)`.
         */
        fun addInput(mcpListTools: BetaResponseInputItem.McpListTools) =
            addInput(BetaResponseInputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addInput(mcpApprovalRequest: BetaResponseInputItem.McpApprovalRequest) =
            addInput(BetaResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addInput(mcpApprovalResponse: BetaResponseInputItem.McpApprovalResponse) =
            addInput(BetaResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofMcpCall(mcpCall)`. */
        fun addInput(mcpCall: BetaResponseInputItem.McpCall) =
            addInput(BetaResponseInputItem.ofMcpCall(mcpCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addInput(customToolCallOutput: BetaResponseCustomToolCallOutput) =
            addInput(BetaResponseInputItem.ofCustomToolCallOutput(customToolCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addInput(customToolCall: BetaResponseCustomToolCall) =
            addInput(BetaResponseInputItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCompactionTrigger(compactionTrigger)`.
         */
        fun addInput(compactionTrigger: BetaResponseInputItem.CompactionTrigger) =
            addInput(BetaResponseInputItem.ofCompactionTrigger(compactionTrigger))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofItemReference(itemReference)`.
         */
        fun addInput(itemReference: BetaResponseInputItem.ItemReference) =
            addInput(BetaResponseInputItem.ofItemReference(itemReference))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.ItemReference.builder()
         *     .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
         *     .id(id)
         *     .build()
         * ```
         */
        fun addItemReferenceInput(id: String) =
            addInput(
                BetaResponseInputItem.ItemReference.builder()
                    .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
                    .id(id)
                    .build()
            )

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofProgram(program)`. */
        fun addInput(program: BetaResponseInputItem.Program) =
            addInput(BetaResponseInputItem.ofProgram(program))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofProgramOutput(programOutput)`.
         */
        fun addInput(programOutput: BetaResponseInputItem.ProgramOutput) =
            addInput(BetaResponseInputItem.ofProgramOutput(programOutput))

        /** The ID of the active response that should receive the input. */
        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.inject")
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
         * Returns an immutable instance of [BetaResponseInjectEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .responseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseInjectEvent =
            BetaResponseInjectEvent(
                checkRequired("input", input).map { it.toImmutable() },
                checkRequired("responseId", responseId),
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
    fun validate(): BetaResponseInjectEvent = apply {
        if (validated) {
            return@apply
        }

        input().forEach { it.validate() }
        responseId()
        _type().let {
            if (it != JsonValue.from("response.inject")) {
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
        (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.inject")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseInjectEvent &&
            input == other.input &&
            responseId == other.responseId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(input, responseId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseInjectEvent{input=$input, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
}
