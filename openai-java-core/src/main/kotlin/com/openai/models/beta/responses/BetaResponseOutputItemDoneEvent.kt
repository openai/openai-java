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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when an output item is marked done. */
class BetaResponseOutputItemDoneEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<BetaResponseOutputItem>,
    private val outputIndex: JsonField<Long>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val agent: JsonField<Agent>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item")
        @ExcludeMissing
        item: JsonField<BetaResponseOutputItem> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
    ) : this(item, outputIndex, sequenceNumber, type, agent, mutableMapOf())

    /**
     * The output item that was marked done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): BetaResponseOutputItem = item.getRequired("item")

    /**
     * The index of the output item that was marked done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The sequence number of this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The type of the event. Always `response.output_item.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.output_item.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The agent that owns this multi-agent streaming event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agent(): Optional<Agent> = agent.getOptional("agent")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<BetaResponseOutputItem> = item

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

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
         * [BetaResponseOutputItemDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseOutputItemDoneEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<BetaResponseOutputItem>? = null
        private var outputIndex: JsonField<Long>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.output_item.done")
        private var agent: JsonField<Agent> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseOutputItemDoneEvent: BetaResponseOutputItemDoneEvent) =
            apply {
                item = betaResponseOutputItemDoneEvent.item
                outputIndex = betaResponseOutputItemDoneEvent.outputIndex
                sequenceNumber = betaResponseOutputItemDoneEvent.sequenceNumber
                type = betaResponseOutputItemDoneEvent.type
                agent = betaResponseOutputItemDoneEvent.agent
                additionalProperties =
                    betaResponseOutputItemDoneEvent.additionalProperties.toMutableMap()
            }

        /** The output item that was marked done. */
        fun item(item: BetaResponseOutputItem) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [BetaResponseOutputItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun item(item: JsonField<BetaResponseOutputItem>) = apply { this.item = item }

        /** Alias for calling [item] with `BetaResponseOutputItem.ofMessage(message)`. */
        fun item(message: BetaResponseOutputMessage) =
            item(BetaResponseOutputItem.ofMessage(message))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun item(fileSearchCall: BetaResponseFileSearchToolCall) =
            item(BetaResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofFunctionCall(functionCall)`. */
        fun item(functionCall: BetaResponseFunctionToolCall) =
            item(BetaResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun item(functionCallOutput: BetaResponseFunctionToolCallOutputItem) =
            item(BetaResponseOutputItem.ofFunctionCallOutput(functionCallOutput))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofAgentMessage(agentMessage)`. */
        fun item(agentMessage: BetaResponseOutputItem.AgentMessage) =
            item(BetaResponseOutputItem.ofAgentMessage(agentMessage))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofMultiAgentCall(multiAgentCall)`.
         */
        fun item(multiAgentCall: BetaResponseOutputItem.MultiAgentCall) =
            item(BetaResponseOutputItem.ofMultiAgentCall(multiAgentCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofMultiAgentCallOutput(multiAgentCallOutput)`.
         */
        fun item(multiAgentCallOutput: BetaResponseOutputItem.MultiAgentCallOutput) =
            item(BetaResponseOutputItem.ofMultiAgentCallOutput(multiAgentCallOutput))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun item(webSearchCall: BetaResponseFunctionWebSearch) =
            item(BetaResponseOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofComputerCall(computerCall)`. */
        fun item(computerCall: BetaResponseComputerToolCall) =
            item(BetaResponseOutputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun item(computerCallOutput: BetaResponseComputerToolCallOutputItem) =
            item(BetaResponseOutputItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofReasoning(reasoning)`. */
        fun item(reasoning: BetaResponseReasoningItem) =
            item(BetaResponseOutputItem.ofReasoning(reasoning))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofProgram(program)`. */
        fun item(program: BetaResponseOutputItem.Program) =
            item(BetaResponseOutputItem.ofProgram(program))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofProgramOutput(programOutput)`.
         */
        fun item(programOutput: BetaResponseOutputItem.ProgramOutput) =
            item(BetaResponseOutputItem.ofProgramOutput(programOutput))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofToolSearchCall(toolSearchCall)`.
         */
        fun item(toolSearchCall: BetaResponseToolSearchCall) =
            item(BetaResponseOutputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun item(toolSearchOutput: BetaResponseToolSearchOutputItem) =
            item(BetaResponseOutputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofAdditionalTools(additionalTools)`.
         */
        fun item(additionalTools: BetaResponseOutputItem.AdditionalTools) =
            item(BetaResponseOutputItem.ofAdditionalTools(additionalTools))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofCompaction(compaction)`. */
        fun item(compaction: BetaResponseCompactionItem) =
            item(BetaResponseOutputItem.ofCompaction(compaction))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun item(imageGenerationCall: BetaResponseOutputItem.ImageGenerationCall) =
            item(BetaResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun item(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            item(BetaResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofLocalShellCall(localShellCall)`.
         */
        fun item(localShellCall: BetaResponseOutputItem.LocalShellCall) =
            item(BetaResponseOutputItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun item(localShellCallOutput: BetaResponseOutputItem.LocalShellCallOutput) =
            item(BetaResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofShellCall(shellCall)`. */
        fun item(shellCall: BetaResponseFunctionShellToolCall) =
            item(BetaResponseOutputItem.ofShellCall(shellCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun item(shellCallOutput: BetaResponseFunctionShellToolCallOutput) =
            item(BetaResponseOutputItem.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun item(applyPatchCall: BetaResponseApplyPatchToolCall) =
            item(BetaResponseOutputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun item(applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput) =
            item(BetaResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofMcpCall(mcpCall)`. */
        fun item(mcpCall: BetaResponseOutputItem.McpCall) =
            item(BetaResponseOutputItem.ofMcpCall(mcpCall))

        /** Alias for calling [item] with `BetaResponseOutputItem.ofMcpListTools(mcpListTools)`. */
        fun item(mcpListTools: BetaResponseOutputItem.McpListTools) =
            item(BetaResponseOutputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun item(mcpApprovalRequest: BetaResponseOutputItem.McpApprovalRequest) =
            item(BetaResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun item(mcpApprovalResponse: BetaResponseOutputItem.McpApprovalResponse) =
            item(BetaResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /**
         * Alias for calling [item] with `BetaResponseOutputItem.ofCustomToolCall(customToolCall)`.
         */
        fun item(customToolCall: BetaResponseCustomToolCall) =
            item(BetaResponseOutputItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [item] with
         * `BetaResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun item(customToolCallOutput: BetaResponseCustomToolCallOutputItem) =
            item(BetaResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput))

        /** The index of the output item that was marked done. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The sequence number of this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.output_item.done")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The agent that owns this multi-agent streaming event. */
        fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

        /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
        fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

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
         * Returns an immutable instance of [BetaResponseOutputItemDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * .outputIndex()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseOutputItemDoneEvent =
            BetaResponseOutputItemDoneEvent(
                checkRequired("item", item),
                checkRequired("outputIndex", outputIndex),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                agent,
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
    fun validate(): BetaResponseOutputItemDoneEvent = apply {
        if (validated) {
            return@apply
        }

        item().validate()
        outputIndex()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.output_item.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        agent().ifPresent { it.validate() }
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
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.output_item.done")) 1 else 0 } +
            (agent.asKnown().getOrNull()?.validity() ?: 0)

    /** The agent that owns this multi-agent streaming event. */
    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val agentName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("agent_name")
            @ExcludeMissing
            agentName: JsonField<String> = JsonMissing.of()
        ) : this(agentName, mutableMapOf())

        /**
         * The canonical name of the agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun agentName(): String = agentName.getRequired("agent_name")

        /**
         * Returns the raw JSON value of [agentName].
         *
         * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_name") @ExcludeMissing fun _agentName(): JsonField<String> = agentName

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
             * Returns a mutable builder for constructing an instance of [Agent].
             *
             * The following fields are required:
             * ```java
             * .agentName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var agentName: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                agentName = agent.agentName
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /** The canonical name of the agent that produced this item. */
            fun agentName(agentName: String) = agentName(JsonField.of(agentName))

            /**
             * Sets [Builder.agentName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

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
             * Returns an immutable instance of [Agent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .agentName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Agent =
                Agent(checkRequired("agentName", agentName), additionalProperties.toMutableMap())
        }

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
        fun validate(): Agent = apply {
            if (validated) {
                return@apply
            }

            agentName()
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
        @JvmSynthetic internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Agent &&
                agentName == other.agentName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseOutputItemDoneEvent &&
            item == other.item &&
            outputIndex == other.outputIndex &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            agent == other.agent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(item, outputIndex, sequenceNumber, type, agent, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseOutputItemDoneEvent{item=$item, outputIndex=$outputIndex, sequenceNumber=$sequenceNumber, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
}
