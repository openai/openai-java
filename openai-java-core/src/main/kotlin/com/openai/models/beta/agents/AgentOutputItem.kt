// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An output item produced by an agent. */
@JsonDeserialize(using = AgentOutputItem.Deserializer::class)
@JsonSerialize(using = AgentOutputItem.Serializer::class)
class AgentOutputItem
private constructor(
    private val message: AgentSessionAssistantMessage? = null,
    private val reasoning: AgentReasoningItem? = null,
    private val functionCall: AgentFunctionCallItem? = null,
    private val mcpCall: AgentMcpCallItem? = null,
    private val computerUseCall: ComputerUseCall? = null,
    private val computerUseApprovalRequest: ComputerUseApprovalRequest? = null,
    private val webSearchCall: AgentWebSearchCallItem? = null,
    private val commandExecution: AgentCommandExecutionItem? = null,
    private val createSubagentCall: AgentCreateSubagentCallItem? = null,
    private val sendSubagentInputCall: AgentSendSubagentInputCallItem? = null,
    private val resumeSubagentCall: AgentResumeSubagentCallItem? = null,
    private val waitForSubagentsCall: AgentWaitForSubagentsCallItem? = null,
    private val interruptSubagentCall: AgentInterruptSubagentCallItem? = null,
    private val closeSubagentCall: AgentCloseSubagentCallItem? = null,
    private val _json: JsonValue? = null,
) {

    /** An assistant message produced by the agent. */
    fun message(): Optional<AgentSessionAssistantMessage> = Optional.ofNullable(message)

    /** A reasoning item produced by the agent. */
    fun reasoning(): Optional<AgentReasoningItem> = Optional.ofNullable(reasoning)

    /** A function call produced by the agent. */
    fun functionCall(): Optional<AgentFunctionCallItem> = Optional.ofNullable(functionCall)

    /** A call to a tool on an MCP server. */
    fun mcpCall(): Optional<AgentMcpCallItem> = Optional.ofNullable(mcpCall)

    /** One execution of the platform-provided computer-use capability. */
    fun computerUseCall(): Optional<ComputerUseCall> = Optional.ofNullable(computerUseCall)

    /** A credential-free history record of the emitted login request. */
    fun computerUseApprovalRequest(): Optional<ComputerUseApprovalRequest> =
        Optional.ofNullable(computerUseApprovalRequest)

    /** A web search call produced by the agent. */
    fun webSearchCall(): Optional<AgentWebSearchCallItem> = Optional.ofNullable(webSearchCall)

    /** A command execution produced by the agent. */
    fun commandExecution(): Optional<AgentCommandExecutionItem> =
        Optional.ofNullable(commandExecution)

    /** A request to spawn a subagent. */
    fun createSubagentCall(): Optional<AgentCreateSubagentCallItem> =
        Optional.ofNullable(createSubagentCall)

    /** A request to send input to another agent. */
    fun sendSubagentInputCall(): Optional<AgentSendSubagentInputCallItem> =
        Optional.ofNullable(sendSubagentInputCall)

    /** A request to resume a subagent. */
    fun resumeSubagentCall(): Optional<AgentResumeSubagentCallItem> =
        Optional.ofNullable(resumeSubagentCall)

    /** A request to wait for one or more subagents. */
    fun waitForSubagentsCall(): Optional<AgentWaitForSubagentsCallItem> =
        Optional.ofNullable(waitForSubagentsCall)

    /** A request to interrupt a subagent's current turn. The subagent remains available. */
    fun interruptSubagentCall(): Optional<AgentInterruptSubagentCallItem> =
        Optional.ofNullable(interruptSubagentCall)

    /** A request to close a subagent. */
    fun closeSubagentCall(): Optional<AgentCloseSubagentCallItem> =
        Optional.ofNullable(closeSubagentCall)

    fun isMessage(): Boolean = message != null

    fun isReasoning(): Boolean = reasoning != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isMcpCall(): Boolean = mcpCall != null

    fun isComputerUseCall(): Boolean = computerUseCall != null

    fun isComputerUseApprovalRequest(): Boolean = computerUseApprovalRequest != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isCommandExecution(): Boolean = commandExecution != null

    fun isCreateSubagentCall(): Boolean = createSubagentCall != null

    fun isSendSubagentInputCall(): Boolean = sendSubagentInputCall != null

    fun isResumeSubagentCall(): Boolean = resumeSubagentCall != null

    fun isWaitForSubagentsCall(): Boolean = waitForSubagentsCall != null

    fun isInterruptSubagentCall(): Boolean = interruptSubagentCall != null

    fun isCloseSubagentCall(): Boolean = closeSubagentCall != null

    /** An assistant message produced by the agent. */
    fun asMessage(): AgentSessionAssistantMessage = message.getOrThrow("message")

    /** A reasoning item produced by the agent. */
    fun asReasoning(): AgentReasoningItem = reasoning.getOrThrow("reasoning")

    /** A function call produced by the agent. */
    fun asFunctionCall(): AgentFunctionCallItem = functionCall.getOrThrow("functionCall")

    /** A call to a tool on an MCP server. */
    fun asMcpCall(): AgentMcpCallItem = mcpCall.getOrThrow("mcpCall")

    /** One execution of the platform-provided computer-use capability. */
    fun asComputerUseCall(): ComputerUseCall = computerUseCall.getOrThrow("computerUseCall")

    /** A credential-free history record of the emitted login request. */
    fun asComputerUseApprovalRequest(): ComputerUseApprovalRequest =
        computerUseApprovalRequest.getOrThrow("computerUseApprovalRequest")

    /** A web search call produced by the agent. */
    fun asWebSearchCall(): AgentWebSearchCallItem = webSearchCall.getOrThrow("webSearchCall")

    /** A command execution produced by the agent. */
    fun asCommandExecution(): AgentCommandExecutionItem =
        commandExecution.getOrThrow("commandExecution")

    /** A request to spawn a subagent. */
    fun asCreateSubagentCall(): AgentCreateSubagentCallItem =
        createSubagentCall.getOrThrow("createSubagentCall")

    /** A request to send input to another agent. */
    fun asSendSubagentInputCall(): AgentSendSubagentInputCallItem =
        sendSubagentInputCall.getOrThrow("sendSubagentInputCall")

    /** A request to resume a subagent. */
    fun asResumeSubagentCall(): AgentResumeSubagentCallItem =
        resumeSubagentCall.getOrThrow("resumeSubagentCall")

    /** A request to wait for one or more subagents. */
    fun asWaitForSubagentsCall(): AgentWaitForSubagentsCallItem =
        waitForSubagentsCall.getOrThrow("waitForSubagentsCall")

    /** A request to interrupt a subagent's current turn. The subagent remains available. */
    fun asInterruptSubagentCall(): AgentInterruptSubagentCallItem =
        interruptSubagentCall.getOrThrow("interruptSubagentCall")

    /** A request to close a subagent. */
    fun asCloseSubagentCall(): AgentCloseSubagentCallItem =
        closeSubagentCall.getOrThrow("closeSubagentCall")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = agentOutputItem.accept(new AgentOutputItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitMessage(AgentSessionAssistantMessage message) {
     *         return Optional.of(message.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            message != null -> visitor.visitMessage(message)
            reasoning != null -> visitor.visitReasoning(reasoning)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            mcpCall != null -> visitor.visitMcpCall(mcpCall)
            computerUseCall != null -> visitor.visitComputerUseCall(computerUseCall)
            computerUseApprovalRequest != null ->
                visitor.visitComputerUseApprovalRequest(computerUseApprovalRequest)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            commandExecution != null -> visitor.visitCommandExecution(commandExecution)
            createSubagentCall != null -> visitor.visitCreateSubagentCall(createSubagentCall)
            sendSubagentInputCall != null ->
                visitor.visitSendSubagentInputCall(sendSubagentInputCall)
            resumeSubagentCall != null -> visitor.visitResumeSubagentCall(resumeSubagentCall)
            waitForSubagentsCall != null -> visitor.visitWaitForSubagentsCall(waitForSubagentsCall)
            interruptSubagentCall != null ->
                visitor.visitInterruptSubagentCall(interruptSubagentCall)
            closeSubagentCall != null -> visitor.visitCloseSubagentCall(closeSubagentCall)
            else -> visitor.unknown(_json)
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
    fun validate(): AgentOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMessage(message: AgentSessionAssistantMessage) {
                    message.validate()
                }

                override fun visitReasoning(reasoning: AgentReasoningItem) {
                    reasoning.validate()
                }

                override fun visitFunctionCall(functionCall: AgentFunctionCallItem) {
                    functionCall.validate()
                }

                override fun visitMcpCall(mcpCall: AgentMcpCallItem) {
                    mcpCall.validate()
                }

                override fun visitComputerUseCall(computerUseCall: ComputerUseCall) {
                    computerUseCall.validate()
                }

                override fun visitComputerUseApprovalRequest(
                    computerUseApprovalRequest: ComputerUseApprovalRequest
                ) {
                    computerUseApprovalRequest.validate()
                }

                override fun visitWebSearchCall(webSearchCall: AgentWebSearchCallItem) {
                    webSearchCall.validate()
                }

                override fun visitCommandExecution(commandExecution: AgentCommandExecutionItem) {
                    commandExecution.validate()
                }

                override fun visitCreateSubagentCall(
                    createSubagentCall: AgentCreateSubagentCallItem
                ) {
                    createSubagentCall.validate()
                }

                override fun visitSendSubagentInputCall(
                    sendSubagentInputCall: AgentSendSubagentInputCallItem
                ) {
                    sendSubagentInputCall.validate()
                }

                override fun visitResumeSubagentCall(
                    resumeSubagentCall: AgentResumeSubagentCallItem
                ) {
                    resumeSubagentCall.validate()
                }

                override fun visitWaitForSubagentsCall(
                    waitForSubagentsCall: AgentWaitForSubagentsCallItem
                ) {
                    waitForSubagentsCall.validate()
                }

                override fun visitInterruptSubagentCall(
                    interruptSubagentCall: AgentInterruptSubagentCallItem
                ) {
                    interruptSubagentCall.validate()
                }

                override fun visitCloseSubagentCall(closeSubagentCall: AgentCloseSubagentCallItem) {
                    closeSubagentCall.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitMessage(message: AgentSessionAssistantMessage) =
                    message.validity()

                override fun visitReasoning(reasoning: AgentReasoningItem) = reasoning.validity()

                override fun visitFunctionCall(functionCall: AgentFunctionCallItem) =
                    functionCall.validity()

                override fun visitMcpCall(mcpCall: AgentMcpCallItem) = mcpCall.validity()

                override fun visitComputerUseCall(computerUseCall: ComputerUseCall) =
                    computerUseCall.validity()

                override fun visitComputerUseApprovalRequest(
                    computerUseApprovalRequest: ComputerUseApprovalRequest
                ) = computerUseApprovalRequest.validity()

                override fun visitWebSearchCall(webSearchCall: AgentWebSearchCallItem) =
                    webSearchCall.validity()

                override fun visitCommandExecution(commandExecution: AgentCommandExecutionItem) =
                    commandExecution.validity()

                override fun visitCreateSubagentCall(
                    createSubagentCall: AgentCreateSubagentCallItem
                ) = createSubagentCall.validity()

                override fun visitSendSubagentInputCall(
                    sendSubagentInputCall: AgentSendSubagentInputCallItem
                ) = sendSubagentInputCall.validity()

                override fun visitResumeSubagentCall(
                    resumeSubagentCall: AgentResumeSubagentCallItem
                ) = resumeSubagentCall.validity()

                override fun visitWaitForSubagentsCall(
                    waitForSubagentsCall: AgentWaitForSubagentsCallItem
                ) = waitForSubagentsCall.validity()

                override fun visitInterruptSubagentCall(
                    interruptSubagentCall: AgentInterruptSubagentCallItem
                ) = interruptSubagentCall.validity()

                override fun visitCloseSubagentCall(closeSubagentCall: AgentCloseSubagentCallItem) =
                    closeSubagentCall.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentOutputItem &&
            message == other.message &&
            reasoning == other.reasoning &&
            functionCall == other.functionCall &&
            mcpCall == other.mcpCall &&
            computerUseCall == other.computerUseCall &&
            computerUseApprovalRequest == other.computerUseApprovalRequest &&
            webSearchCall == other.webSearchCall &&
            commandExecution == other.commandExecution &&
            createSubagentCall == other.createSubagentCall &&
            sendSubagentInputCall == other.sendSubagentInputCall &&
            resumeSubagentCall == other.resumeSubagentCall &&
            waitForSubagentsCall == other.waitForSubagentsCall &&
            interruptSubagentCall == other.interruptSubagentCall &&
            closeSubagentCall == other.closeSubagentCall
    }

    override fun hashCode(): Int =
        Objects.hash(
            message,
            reasoning,
            functionCall,
            mcpCall,
            computerUseCall,
            computerUseApprovalRequest,
            webSearchCall,
            commandExecution,
            createSubagentCall,
            sendSubagentInputCall,
            resumeSubagentCall,
            waitForSubagentsCall,
            interruptSubagentCall,
            closeSubagentCall,
        )

    override fun toString(): String =
        when {
            message != null -> "AgentOutputItem{message=$message}"
            reasoning != null -> "AgentOutputItem{reasoning=$reasoning}"
            functionCall != null -> "AgentOutputItem{functionCall=$functionCall}"
            mcpCall != null -> "AgentOutputItem{mcpCall=$mcpCall}"
            computerUseCall != null -> "AgentOutputItem{computerUseCall=$computerUseCall}"
            computerUseApprovalRequest != null ->
                "AgentOutputItem{computerUseApprovalRequest=$computerUseApprovalRequest}"
            webSearchCall != null -> "AgentOutputItem{webSearchCall=$webSearchCall}"
            commandExecution != null -> "AgentOutputItem{commandExecution=$commandExecution}"
            createSubagentCall != null -> "AgentOutputItem{createSubagentCall=$createSubagentCall}"
            sendSubagentInputCall != null ->
                "AgentOutputItem{sendSubagentInputCall=$sendSubagentInputCall}"
            resumeSubagentCall != null -> "AgentOutputItem{resumeSubagentCall=$resumeSubagentCall}"
            waitForSubagentsCall != null ->
                "AgentOutputItem{waitForSubagentsCall=$waitForSubagentsCall}"
            interruptSubagentCall != null ->
                "AgentOutputItem{interruptSubagentCall=$interruptSubagentCall}"
            closeSubagentCall != null -> "AgentOutputItem{closeSubagentCall=$closeSubagentCall}"
            _json != null -> "AgentOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentOutputItem")
        }

    companion object {

        /** An assistant message produced by the agent. */
        @JvmStatic
        fun ofMessage(message: AgentSessionAssistantMessage) = AgentOutputItem(message = message)

        /** A reasoning item produced by the agent. */
        @JvmStatic
        fun ofReasoning(reasoning: AgentReasoningItem) = AgentOutputItem(reasoning = reasoning)

        /** A function call produced by the agent. */
        @JvmStatic
        fun ofFunctionCall(functionCall: AgentFunctionCallItem) =
            AgentOutputItem(functionCall = functionCall)

        /** A call to a tool on an MCP server. */
        @JvmStatic fun ofMcpCall(mcpCall: AgentMcpCallItem) = AgentOutputItem(mcpCall = mcpCall)

        /** One execution of the platform-provided computer-use capability. */
        @JvmStatic
        fun ofComputerUseCall(computerUseCall: ComputerUseCall) =
            AgentOutputItem(computerUseCall = computerUseCall)

        /** A credential-free history record of the emitted login request. */
        @JvmStatic
        fun ofComputerUseApprovalRequest(computerUseApprovalRequest: ComputerUseApprovalRequest) =
            AgentOutputItem(computerUseApprovalRequest = computerUseApprovalRequest)

        /** A web search call produced by the agent. */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: AgentWebSearchCallItem) =
            AgentOutputItem(webSearchCall = webSearchCall)

        /** A command execution produced by the agent. */
        @JvmStatic
        fun ofCommandExecution(commandExecution: AgentCommandExecutionItem) =
            AgentOutputItem(commandExecution = commandExecution)

        /** A request to spawn a subagent. */
        @JvmStatic
        fun ofCreateSubagentCall(createSubagentCall: AgentCreateSubagentCallItem) =
            AgentOutputItem(createSubagentCall = createSubagentCall)

        /** A request to send input to another agent. */
        @JvmStatic
        fun ofSendSubagentInputCall(sendSubagentInputCall: AgentSendSubagentInputCallItem) =
            AgentOutputItem(sendSubagentInputCall = sendSubagentInputCall)

        /** A request to resume a subagent. */
        @JvmStatic
        fun ofResumeSubagentCall(resumeSubagentCall: AgentResumeSubagentCallItem) =
            AgentOutputItem(resumeSubagentCall = resumeSubagentCall)

        /** A request to wait for one or more subagents. */
        @JvmStatic
        fun ofWaitForSubagentsCall(waitForSubagentsCall: AgentWaitForSubagentsCallItem) =
            AgentOutputItem(waitForSubagentsCall = waitForSubagentsCall)

        /** A request to interrupt a subagent's current turn. The subagent remains available. */
        @JvmStatic
        fun ofInterruptSubagentCall(interruptSubagentCall: AgentInterruptSubagentCallItem) =
            AgentOutputItem(interruptSubagentCall = interruptSubagentCall)

        /** A request to close a subagent. */
        @JvmStatic
        fun ofCloseSubagentCall(closeSubagentCall: AgentCloseSubagentCallItem) =
            AgentOutputItem(closeSubagentCall = closeSubagentCall)
    }

    /**
     * An interface that defines how to map each variant of [AgentOutputItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** An assistant message produced by the agent. */
        fun visitMessage(message: AgentSessionAssistantMessage): T

        /** A reasoning item produced by the agent. */
        fun visitReasoning(reasoning: AgentReasoningItem): T

        /** A function call produced by the agent. */
        fun visitFunctionCall(functionCall: AgentFunctionCallItem): T

        /** A call to a tool on an MCP server. */
        fun visitMcpCall(mcpCall: AgentMcpCallItem): T

        /** One execution of the platform-provided computer-use capability. */
        fun visitComputerUseCall(computerUseCall: ComputerUseCall): T

        /** A credential-free history record of the emitted login request. */
        fun visitComputerUseApprovalRequest(
            computerUseApprovalRequest: ComputerUseApprovalRequest
        ): T

        /** A web search call produced by the agent. */
        fun visitWebSearchCall(webSearchCall: AgentWebSearchCallItem): T

        /** A command execution produced by the agent. */
        fun visitCommandExecution(commandExecution: AgentCommandExecutionItem): T

        /** A request to spawn a subagent. */
        fun visitCreateSubagentCall(createSubagentCall: AgentCreateSubagentCallItem): T

        /** A request to send input to another agent. */
        fun visitSendSubagentInputCall(sendSubagentInputCall: AgentSendSubagentInputCallItem): T

        /** A request to resume a subagent. */
        fun visitResumeSubagentCall(resumeSubagentCall: AgentResumeSubagentCallItem): T

        /** A request to wait for one or more subagents. */
        fun visitWaitForSubagentsCall(waitForSubagentsCall: AgentWaitForSubagentsCallItem): T

        /** A request to interrupt a subagent's current turn. The subagent remains available. */
        fun visitInterruptSubagentCall(interruptSubagentCall: AgentInterruptSubagentCallItem): T

        /** A request to close a subagent. */
        fun visitCloseSubagentCall(closeSubagentCall: AgentCloseSubagentCallItem): T

        /**
         * Maps an unknown variant of [AgentOutputItem] to a value of type [T].
         *
         * An instance of [AgentOutputItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentOutputItem")
        }
    }

    internal class Deserializer : BaseDeserializer<AgentOutputItem>(AgentOutputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionAssistantMessage>())
                        ?.let { AgentOutputItem(message = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "reasoning" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentReasoningItem>())?.let {
                        AgentOutputItem(reasoning = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentFunctionCallItem>())?.let {
                        AgentOutputItem(functionCall = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "mcp_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentMcpCallItem>())?.let {
                        AgentOutputItem(mcpCall = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "computer_use_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerUseCall>())?.let {
                        AgentOutputItem(computerUseCall = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "computer_use_approval_request" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerUseApprovalRequest>())?.let {
                        AgentOutputItem(computerUseApprovalRequest = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentWebSearchCallItem>())?.let {
                        AgentOutputItem(webSearchCall = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "command_execution" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCommandExecutionItem>())?.let {
                        AgentOutputItem(commandExecution = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
                "create_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCreateSubagentCallItem>())
                        ?.let { AgentOutputItem(createSubagentCall = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "send_subagent_input_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSendSubagentInputCallItem>())
                        ?.let { AgentOutputItem(sendSubagentInputCall = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "resume_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentResumeSubagentCallItem>())
                        ?.let { AgentOutputItem(resumeSubagentCall = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "wait_for_subagents_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentWaitForSubagentsCallItem>())
                        ?.let { AgentOutputItem(waitForSubagentsCall = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "interrupt_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentInterruptSubagentCallItem>())
                        ?.let { AgentOutputItem(interruptSubagentCall = it, _json = json) }
                        ?: AgentOutputItem(_json = json)
                }
                "close_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCloseSubagentCallItem>())?.let {
                        AgentOutputItem(closeSubagentCall = it, _json = json)
                    } ?: AgentOutputItem(_json = json)
                }
            }

            return AgentOutputItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AgentOutputItem>(AgentOutputItem::class) {

        override fun serialize(
            value: AgentOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.message != null -> generator.writeObject(value.message)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.mcpCall != null -> generator.writeObject(value.mcpCall)
                value.computerUseCall != null -> generator.writeObject(value.computerUseCall)
                value.computerUseApprovalRequest != null ->
                    generator.writeObject(value.computerUseApprovalRequest)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.commandExecution != null -> generator.writeObject(value.commandExecution)
                value.createSubagentCall != null -> generator.writeObject(value.createSubagentCall)
                value.sendSubagentInputCall != null ->
                    generator.writeObject(value.sendSubagentInputCall)
                value.resumeSubagentCall != null -> generator.writeObject(value.resumeSubagentCall)
                value.waitForSubagentsCall != null ->
                    generator.writeObject(value.waitForSubagentsCall)
                value.interruptSubagentCall != null ->
                    generator.writeObject(value.interruptSubagentCall)
                value.closeSubagentCall != null -> generator.writeObject(value.closeSubagentCall)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentOutputItem")
            }
        }
    }

    /** One execution of the platform-provided computer-use capability. */
    class ComputerUseCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val output: JsonField<Output>,
        private val status: JsonField<AgentFunctionCallStatus>,
        private val title: JsonField<String>,
        private val turnId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<Output> = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, output, status, title, turnId, type, mutableMapOf())

        /**
         * The ID of the activity item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The last screenshot emitted by the model. Null when screenshot inclusion is disabled or
         * the call emitted no screenshot.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<Output> = output.getOptional("output")

        /**
         * The execution status of the activity.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): AgentFunctionCallStatus = status.getRequired("status")

        /**
         * A model-generated description of the activity, when available.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * The ID of the turn that contains this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun turnId(): String = turnId.getRequired("turn_id")

        /**
         * The item type. Always `computer_use_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("computer_use_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun _status(): JsonField<AgentFunctionCallStatus> = status

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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
             * Returns a mutable builder for constructing an instance of [ComputerUseCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .output()
             * .status()
             * .title()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComputerUseCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var output: JsonField<Output>? = null
            private var status: JsonField<AgentFunctionCallStatus>? = null
            private var title: JsonField<String>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("computer_use_call")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(computerUseCall: ComputerUseCall) = apply {
                id = computerUseCall.id
                output = computerUseCall.output
                status = computerUseCall.status
                title = computerUseCall.title
                turnId = computerUseCall.turnId
                type = computerUseCall.type
                additionalProperties = computerUseCall.additionalProperties.toMutableMap()
            }

            /** The ID of the activity item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * The last screenshot emitted by the model. Null when screenshot inclusion is disabled
             * or the call emitted no screenshot.
             */
            fun output(output: Output?) = output(JsonField.ofNullable(output))

            /** Alias for calling [Builder.output] with `output.orElse(null)`. */
            fun output(output: Optional<Output>) = output(output.getOrNull())

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [Output] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<Output>) = apply { this.output = output }

            /** The execution status of the activity. */
            fun status(status: AgentFunctionCallStatus) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [AgentFunctionCallStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun status(status: JsonField<AgentFunctionCallStatus>) = apply { this.status = status }

            /** A model-generated description of the activity, when available. */
            fun title(title: String?) = title(JsonField.ofNullable(title))

            /** Alias for calling [Builder.title] with `title.orElse(null)`. */
            fun title(title: Optional<String>) = title(title.getOrNull())

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            /** The ID of the turn that contains this item. */
            fun turnId(turnId: String) = turnId(JsonField.of(turnId))

            /**
             * Sets [Builder.turnId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.turnId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("computer_use_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [ComputerUseCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .output()
             * .status()
             * .title()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComputerUseCall =
                ComputerUseCall(
                    checkRequired("id", id),
                    checkRequired("output", output),
                    checkRequired("status", status),
                    checkRequired("title", title),
                    checkRequired("turnId", turnId),
                    type,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): ComputerUseCall = apply {
            if (validated) {
                return@apply
            }

            id()
            output().ifPresent { it.validate() }
            status().validate()
            title()
            turnId()
            _type().let {
                if (it != JsonValue.from("computer_use_call")) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("computer_use_call")) 1 else 0 }

        /**
         * The last screenshot emitted by the model. Null when screenshot inclusion is disabled or
         * the call emitted no screenshot.
         */
        class Output
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val imageUrl: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("image_url")
                @ExcludeMissing
                imageUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(imageUrl, type, mutableMapOf())

            /**
             * The complete JPEG image as a base64 data URL.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun imageUrl(): String = imageUrl.getRequired("image_url")

            /**
             * The content type. Always `computer_screenshot`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("computer_screenshot")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [imageUrl].
             *
             * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

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
                 * Returns a mutable builder for constructing an instance of [Output].
                 *
                 * The following fields are required:
                 * ```java
                 * .imageUrl()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Output]. */
            class Builder internal constructor() {

                private var imageUrl: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("computer_screenshot")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(output: Output) = apply {
                    imageUrl = output.imageUrl
                    type = output.type
                    additionalProperties = output.additionalProperties.toMutableMap()
                }

                /** The complete JPEG image as a base64 data URL. */
                fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                /**
                 * Sets [Builder.imageUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.imageUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("computer_screenshot")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Output].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .imageUrl()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Output =
                    Output(
                        checkRequired("imageUrl", imageUrl),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Output = apply {
                if (validated) {
                    return@apply
                }

                imageUrl()
                _type().let {
                    if (it != JsonValue.from("computer_screenshot")) {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (imageUrl.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("computer_screenshot")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Output &&
                    imageUrl == other.imageUrl &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(imageUrl, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Output{imageUrl=$imageUrl, type=$type, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComputerUseCall &&
                id == other.id &&
                output == other.output &&
                status == other.status &&
                title == other.title &&
                turnId == other.turnId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, output, status, title, turnId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComputerUseCall{id=$id, output=$output, status=$status, title=$title, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A credential-free history record of the emitted login request. */
    class ComputerUseApprovalRequest
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val request: JsonField<Request>,
        private val requestId: JsonField<String>,
        private val turnId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, request, requestId, turnId, type, mutableMapOf())

        /**
         * The stable history item ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A registered form awaiting the application's response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun request(): Request = request.getRequired("request")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestId(): String = requestId.getRequired("request_id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun turnId(): String = turnId.getRequired("turn_id")

        /**
         * The item type. Always computer_use_approval_request.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("computer_use_approval_request")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [request].
         *
         * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

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
             * [ComputerUseApprovalRequest].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .request()
             * .requestId()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComputerUseApprovalRequest]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var request: JsonField<Request>? = null
            private var requestId: JsonField<String>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("computer_use_approval_request")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(computerUseApprovalRequest: ComputerUseApprovalRequest) = apply {
                id = computerUseApprovalRequest.id
                request = computerUseApprovalRequest.request
                requestId = computerUseApprovalRequest.requestId
                turnId = computerUseApprovalRequest.turnId
                type = computerUseApprovalRequest.type
                additionalProperties =
                    computerUseApprovalRequest.additionalProperties.toMutableMap()
            }

            /** The stable history item ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A registered form awaiting the application's response. */
            fun request(request: Request) = request(JsonField.of(request))

            /**
             * Sets [Builder.request] to an arbitrary JSON value.
             *
             * You should usually call [Builder.request] with a well-typed [Request] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun request(request: JsonField<Request>) = apply { this.request = request }

            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            fun turnId(turnId: String) = turnId(JsonField.of(turnId))

            /**
             * Sets [Builder.turnId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.turnId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("computer_use_approval_request")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [ComputerUseApprovalRequest].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .request()
             * .requestId()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComputerUseApprovalRequest =
                ComputerUseApprovalRequest(
                    checkRequired("id", id),
                    checkRequired("request", request),
                    checkRequired("requestId", requestId),
                    checkRequired("turnId", turnId),
                    type,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): ComputerUseApprovalRequest = apply {
            if (validated) {
                return@apply
            }

            id()
            request().validate()
            requestId()
            turnId()
            _type().let {
                if (it != JsonValue.from("computer_use_approval_request")) {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (request.asKnown().getOrNull()?.validity() ?: 0) +
                (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("computer_use_approval_request")) 1 else 0 }

        /** A registered form awaiting the application's response. */
        class Request
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val credentialOrigin: JsonField<String>,
            private val fields: JsonField<List<Field>>,
            private val options: JsonField<List<Option>>,
            private val reason: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("credential_origin")
                @ExcludeMissing
                credentialOrigin: JsonField<String> = JsonMissing.of(),
                @JsonProperty("fields")
                @ExcludeMissing
                fields: JsonField<List<Field>> = JsonMissing.of(),
                @JsonProperty("options")
                @ExcludeMissing
                options: JsonField<List<Option>> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(credentialOrigin, fields, options, reason, type, mutableMapOf())

            /**
             * The registered form or frame origin where values will be entered.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun credentialOrigin(): Optional<String> =
                credentialOrigin.getOptional("credential_origin")

            /**
             * Controls to render. All submitted values are sensitive.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fields(): List<Field> = fields.getRequired("fields")

            /**
             * Sign-in methods. Empty for a plain form.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun options(): List<Option> = options.getRequired("options")

            /**
             * Why the agent needs the user to sign in.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun reason(): Optional<String> = reason.getOptional("reason")

            /**
             * The type of the object. Always `browser_authentication`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("browser_authentication")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [credentialOrigin].
             *
             * Unlike [credentialOrigin], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("credential_origin")
            @ExcludeMissing
            fun _credentialOrigin(): JsonField<String> = credentialOrigin

            /**
             * Returns the raw JSON value of [fields].
             *
             * Unlike [fields], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("fields") @ExcludeMissing fun _fields(): JsonField<List<Field>> = fields

            /**
             * Returns the raw JSON value of [options].
             *
             * Unlike [options], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("options")
            @ExcludeMissing
            fun _options(): JsonField<List<Option>> = options

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
                 * Returns a mutable builder for constructing an instance of [Request].
                 *
                 * The following fields are required:
                 * ```java
                 * .credentialOrigin()
                 * .fields()
                 * .options()
                 * .reason()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Request]. */
            class Builder internal constructor() {

                private var credentialOrigin: JsonField<String>? = null
                private var fields: JsonField<MutableList<Field>>? = null
                private var options: JsonField<MutableList<Option>>? = null
                private var reason: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("browser_authentication")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(request: Request) = apply {
                    credentialOrigin = request.credentialOrigin
                    fields = request.fields.map { it.toMutableList() }
                    options = request.options.map { it.toMutableList() }
                    reason = request.reason
                    type = request.type
                    additionalProperties = request.additionalProperties.toMutableMap()
                }

                /** The registered form or frame origin where values will be entered. */
                fun credentialOrigin(credentialOrigin: String?) =
                    credentialOrigin(JsonField.ofNullable(credentialOrigin))

                /**
                 * Alias for calling [Builder.credentialOrigin] with
                 * `credentialOrigin.orElse(null)`.
                 */
                fun credentialOrigin(credentialOrigin: Optional<String>) =
                    credentialOrigin(credentialOrigin.getOrNull())

                /**
                 * Sets [Builder.credentialOrigin] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.credentialOrigin] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun credentialOrigin(credentialOrigin: JsonField<String>) = apply {
                    this.credentialOrigin = credentialOrigin
                }

                /** Controls to render. All submitted values are sensitive. */
                fun fields(fields: List<Field>) = fields(JsonField.of(fields))

                /**
                 * Sets [Builder.fields] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fields] with a well-typed `List<Field>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fields(fields: JsonField<List<Field>>) = apply {
                    this.fields = fields.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Field] to [fields].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addField(field: Field) = apply {
                    fields =
                        (fields ?: JsonField.of(mutableListOf())).also {
                            checkKnown("fields", it).add(field)
                        }
                }

                /** Sign-in methods. Empty for a plain form. */
                fun options(options: List<Option>) = options(JsonField.of(options))

                /**
                 * Sets [Builder.options] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.options] with a well-typed `List<Option>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun options(options: JsonField<List<Option>>) = apply {
                    this.options = options.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Option] to [options].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addOption(option: Option) = apply {
                    options =
                        (options ?: JsonField.of(mutableListOf())).also {
                            checkKnown("options", it).add(option)
                        }
                }

                /** Why the agent needs the user to sign in. */
                fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("browser_authentication")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Request].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .credentialOrigin()
                 * .fields()
                 * .options()
                 * .reason()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Request =
                    Request(
                        checkRequired("credentialOrigin", credentialOrigin),
                        checkRequired("fields", fields).map { it.toImmutable() },
                        checkRequired("options", options).map { it.toImmutable() },
                        checkRequired("reason", reason),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Request = apply {
                if (validated) {
                    return@apply
                }

                credentialOrigin()
                fields().forEach { it.validate() }
                options().forEach { it.validate() }
                reason()
                _type().let {
                    if (it != JsonValue.from("browser_authentication")) {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (credentialOrigin.asKnown().isPresent) 1 else 0) +
                    (fields.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (options.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (reason.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("browser_authentication")) 1 else 0 }

            /** A control in a registered browser-login form. */
            class Field
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val label: JsonField<String>,
                private val required: JsonField<Boolean>,
                private val type: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("label")
                    @ExcludeMissing
                    label: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("required")
                    @ExcludeMissing
                    required: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                ) : this(id, label, required, type, mutableMapOf())

                /**
                 * The field ID to submit as field_id in a fields entry.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun id(): String = id.getRequired("id")

                /**
                 * The label to display beside the control.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun label(): String = label.getRequired("label")

                /**
                 * Whether this control requires a nonempty value.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun required(): Boolean = required.getRequired("required")

                /**
                 * The rendering type, such as email, password, or text.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): String = type.getRequired("type")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [label].
                 *
                 * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

                /**
                 * Returns the raw JSON value of [required].
                 *
                 * Unlike [required], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("required")
                @ExcludeMissing
                fun _required(): JsonField<Boolean> = required

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                     * Returns a mutable builder for constructing an instance of [Field].
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * .label()
                     * .required()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Field]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var label: JsonField<String>? = null
                    private var required: JsonField<Boolean>? = null
                    private var type: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(field: Field) = apply {
                        id = field.id
                        label = field.label
                        required = field.required
                        type = field.type
                        additionalProperties = field.additionalProperties.toMutableMap()
                    }

                    /** The field ID to submit as field_id in a fields entry. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The label to display beside the control. */
                    fun label(label: String) = label(JsonField.of(label))

                    /**
                     * Sets [Builder.label] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.label] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun label(label: JsonField<String>) = apply { this.label = label }

                    /** Whether this control requires a nonempty value. */
                    fun required(required: Boolean) = required(JsonField.of(required))

                    /**
                     * Sets [Builder.required] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.required] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun required(required: JsonField<Boolean>) = apply { this.required = required }

                    /** The rendering type, such as email, password, or text. */
                    fun type(type: String) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Field].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * .label()
                     * .required()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Field =
                        Field(
                            checkRequired("id", id),
                            checkRequired("label", label),
                            checkRequired("required", required),
                            checkRequired("type", type),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Field = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    label()
                    required()
                    type()
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
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (id.asKnown().isPresent) 1 else 0) +
                        (if (label.asKnown().isPresent) 1 else 0) +
                        (if (required.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Field &&
                        id == other.id &&
                        label == other.label &&
                        required == other.required &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(id, label, required, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Field{id=$id, label=$label, required=$required, type=$type, additionalProperties=$additionalProperties}"
            }

            /** A sign-in method and the fields that belong to it. */
            class Option
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val fieldIds: JsonField<List<String>>,
                private val label: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("field_ids")
                    @ExcludeMissing
                    fieldIds: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("label")
                    @ExcludeMissing
                    label: JsonField<String> = JsonMissing.of(),
                ) : this(id, fieldIds, label, mutableMapOf())

                /**
                 * The option ID to submit as selected_option.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun id(): String = id.getRequired("id")

                /**
                 * IDs from the registered fields that this method accepts.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun fieldIds(): List<String> = fieldIds.getRequired("field_ids")

                /**
                 * The method label to display.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun label(): String = label.getRequired("label")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [fieldIds].
                 *
                 * Unlike [fieldIds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("field_ids")
                @ExcludeMissing
                fun _fieldIds(): JsonField<List<String>> = fieldIds

                /**
                 * Returns the raw JSON value of [label].
                 *
                 * Unlike [label], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

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
                     * Returns a mutable builder for constructing an instance of [Option].
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * .fieldIds()
                     * .label()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Option]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var fieldIds: JsonField<MutableList<String>>? = null
                    private var label: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(option: Option) = apply {
                        id = option.id
                        fieldIds = option.fieldIds.map { it.toMutableList() }
                        label = option.label
                        additionalProperties = option.additionalProperties.toMutableMap()
                    }

                    /** The option ID to submit as selected_option. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** IDs from the registered fields that this method accepts. */
                    fun fieldIds(fieldIds: List<String>) = fieldIds(JsonField.of(fieldIds))

                    /**
                     * Sets [Builder.fieldIds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fieldIds] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun fieldIds(fieldIds: JsonField<List<String>>) = apply {
                        this.fieldIds = fieldIds.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [fieldIds].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addFieldId(fieldId: String) = apply {
                        fieldIds =
                            (fieldIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("fieldIds", it).add(fieldId)
                            }
                    }

                    /** The method label to display. */
                    fun label(label: String) = label(JsonField.of(label))

                    /**
                     * Sets [Builder.label] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.label] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun label(label: JsonField<String>) = apply { this.label = label }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Option].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * .fieldIds()
                     * .label()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Option =
                        Option(
                            checkRequired("id", id),
                            checkRequired("fieldIds", fieldIds).map { it.toImmutable() },
                            checkRequired("label", label),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Option = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    fieldIds()
                    label()
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
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (id.asKnown().isPresent) 1 else 0) +
                        (fieldIds.asKnown().getOrNull()?.size ?: 0) +
                        (if (label.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Option &&
                        id == other.id &&
                        fieldIds == other.fieldIds &&
                        label == other.label &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(id, fieldIds, label, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Option{id=$id, fieldIds=$fieldIds, label=$label, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Request &&
                    credentialOrigin == other.credentialOrigin &&
                    fields == other.fields &&
                    options == other.options &&
                    reason == other.reason &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(credentialOrigin, fields, options, reason, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Request{credentialOrigin=$credentialOrigin, fields=$fields, options=$options, reason=$reason, type=$type, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComputerUseApprovalRequest &&
                id == other.id &&
                request == other.request &&
                requestId == other.requestId &&
                turnId == other.turnId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, request, requestId, turnId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComputerUseApprovalRequest{id=$id, request=$request, requestId=$requestId, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
    }
}
