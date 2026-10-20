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

/** An item associated with a session turn. */
@JsonDeserialize(using = AgentSessionItem.Deserializer::class)
@JsonSerialize(using = AgentSessionItem.Serializer::class)
class AgentSessionItem
private constructor(
    private val message: AgentSessionMessage? = null,
    private val reasoning: AgentReasoningItem? = null,
    private val functionCall: AgentFunctionCallItem? = null,
    private val functionCallOutput: FunctionCallOutput? = null,
    private val agentMessage: AgentMessage? = null,
    private val mcpCall: AgentMcpCallItem? = null,
    private val computerUseCall: ComputerUseCall? = null,
    private val computerUseApprovalRequest: ComputerUseApprovalRequest? = null,
    private val computerUseApprovalRequestResult: ComputerUseApprovalRequestResult? = null,
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

    /** A user or assistant message recorded in a session. */
    fun message(): Optional<AgentSessionMessage> = Optional.ofNullable(message)

    /** A reasoning item produced by the agent. */
    fun reasoning(): Optional<AgentReasoningItem> = Optional.ofNullable(reasoning)

    /** A function call produced by the agent. */
    fun functionCall(): Optional<AgentFunctionCallItem> = Optional.ofNullable(functionCall)

    /** The result supplied for a function call. */
    fun functionCallOutput(): Optional<FunctionCallOutput> = Optional.ofNullable(functionCallOutput)

    /** A message exchanged between agent threads. */
    fun agentMessage(): Optional<AgentMessage> = Optional.ofNullable(agentMessage)

    /** A call to a tool on an MCP server. */
    fun mcpCall(): Optional<AgentMcpCallItem> = Optional.ofNullable(mcpCall)

    /** One execution of the platform-provided computer-use capability. */
    fun computerUseCall(): Optional<ComputerUseCall> = Optional.ofNullable(computerUseCall)

    /** A credential-free history record of the emitted login request. */
    fun computerUseApprovalRequest(): Optional<ComputerUseApprovalRequest> =
        Optional.ofNullable(computerUseApprovalRequest)

    /** A credential-free record of an admitted response, not proof of completion. */
    fun computerUseApprovalRequestResult(): Optional<ComputerUseApprovalRequestResult> =
        Optional.ofNullable(computerUseApprovalRequestResult)

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

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun isAgentMessage(): Boolean = agentMessage != null

    fun isMcpCall(): Boolean = mcpCall != null

    fun isComputerUseCall(): Boolean = computerUseCall != null

    fun isComputerUseApprovalRequest(): Boolean = computerUseApprovalRequest != null

    fun isComputerUseApprovalRequestResult(): Boolean = computerUseApprovalRequestResult != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isCommandExecution(): Boolean = commandExecution != null

    fun isCreateSubagentCall(): Boolean = createSubagentCall != null

    fun isSendSubagentInputCall(): Boolean = sendSubagentInputCall != null

    fun isResumeSubagentCall(): Boolean = resumeSubagentCall != null

    fun isWaitForSubagentsCall(): Boolean = waitForSubagentsCall != null

    fun isInterruptSubagentCall(): Boolean = interruptSubagentCall != null

    fun isCloseSubagentCall(): Boolean = closeSubagentCall != null

    /** A user or assistant message recorded in a session. */
    fun asMessage(): AgentSessionMessage = message.getOrThrow("message")

    /** A reasoning item produced by the agent. */
    fun asReasoning(): AgentReasoningItem = reasoning.getOrThrow("reasoning")

    /** A function call produced by the agent. */
    fun asFunctionCall(): AgentFunctionCallItem = functionCall.getOrThrow("functionCall")

    /** The result supplied for a function call. */
    fun asFunctionCallOutput(): FunctionCallOutput =
        functionCallOutput.getOrThrow("functionCallOutput")

    /** A message exchanged between agent threads. */
    fun asAgentMessage(): AgentMessage = agentMessage.getOrThrow("agentMessage")

    /** A call to a tool on an MCP server. */
    fun asMcpCall(): AgentMcpCallItem = mcpCall.getOrThrow("mcpCall")

    /** One execution of the platform-provided computer-use capability. */
    fun asComputerUseCall(): ComputerUseCall = computerUseCall.getOrThrow("computerUseCall")

    /** A credential-free history record of the emitted login request. */
    fun asComputerUseApprovalRequest(): ComputerUseApprovalRequest =
        computerUseApprovalRequest.getOrThrow("computerUseApprovalRequest")

    /** A credential-free record of an admitted response, not proof of completion. */
    fun asComputerUseApprovalRequestResult(): ComputerUseApprovalRequestResult =
        computerUseApprovalRequestResult.getOrThrow("computerUseApprovalRequestResult")

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
     * Optional<String> result = agentSessionItem.accept(new AgentSessionItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitMessage(AgentSessionMessage message) {
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
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            agentMessage != null -> visitor.visitAgentMessage(agentMessage)
            mcpCall != null -> visitor.visitMcpCall(mcpCall)
            computerUseCall != null -> visitor.visitComputerUseCall(computerUseCall)
            computerUseApprovalRequest != null ->
                visitor.visitComputerUseApprovalRequest(computerUseApprovalRequest)
            computerUseApprovalRequestResult != null ->
                visitor.visitComputerUseApprovalRequestResult(computerUseApprovalRequestResult)
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
    fun validate(): AgentSessionItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMessage(message: AgentSessionMessage) {
                    message.validate()
                }

                override fun visitReasoning(reasoning: AgentReasoningItem) {
                    reasoning.validate()
                }

                override fun visitFunctionCall(functionCall: AgentFunctionCallItem) {
                    functionCall.validate()
                }

                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) {
                    functionCallOutput.validate()
                }

                override fun visitAgentMessage(agentMessage: AgentMessage) {
                    agentMessage.validate()
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

                override fun visitComputerUseApprovalRequestResult(
                    computerUseApprovalRequestResult: ComputerUseApprovalRequestResult
                ) {
                    computerUseApprovalRequestResult.validate()
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
                override fun visitMessage(message: AgentSessionMessage) = message.validity()

                override fun visitReasoning(reasoning: AgentReasoningItem) = reasoning.validity()

                override fun visitFunctionCall(functionCall: AgentFunctionCallItem) =
                    functionCall.validity()

                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                    functionCallOutput.validity()

                override fun visitAgentMessage(agentMessage: AgentMessage) = agentMessage.validity()

                override fun visitMcpCall(mcpCall: AgentMcpCallItem) = mcpCall.validity()

                override fun visitComputerUseCall(computerUseCall: ComputerUseCall) =
                    computerUseCall.validity()

                override fun visitComputerUseApprovalRequest(
                    computerUseApprovalRequest: ComputerUseApprovalRequest
                ) = computerUseApprovalRequest.validity()

                override fun visitComputerUseApprovalRequestResult(
                    computerUseApprovalRequestResult: ComputerUseApprovalRequestResult
                ) = computerUseApprovalRequestResult.validity()

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

        return other is AgentSessionItem &&
            message == other.message &&
            reasoning == other.reasoning &&
            functionCall == other.functionCall &&
            functionCallOutput == other.functionCallOutput &&
            agentMessage == other.agentMessage &&
            mcpCall == other.mcpCall &&
            computerUseCall == other.computerUseCall &&
            computerUseApprovalRequest == other.computerUseApprovalRequest &&
            computerUseApprovalRequestResult == other.computerUseApprovalRequestResult &&
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
            functionCallOutput,
            agentMessage,
            mcpCall,
            computerUseCall,
            computerUseApprovalRequest,
            computerUseApprovalRequestResult,
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
            message != null -> "AgentSessionItem{message=$message}"
            reasoning != null -> "AgentSessionItem{reasoning=$reasoning}"
            functionCall != null -> "AgentSessionItem{functionCall=$functionCall}"
            functionCallOutput != null -> "AgentSessionItem{functionCallOutput=$functionCallOutput}"
            agentMessage != null -> "AgentSessionItem{agentMessage=$agentMessage}"
            mcpCall != null -> "AgentSessionItem{mcpCall=$mcpCall}"
            computerUseCall != null -> "AgentSessionItem{computerUseCall=$computerUseCall}"
            computerUseApprovalRequest != null ->
                "AgentSessionItem{computerUseApprovalRequest=$computerUseApprovalRequest}"
            computerUseApprovalRequestResult != null ->
                "AgentSessionItem{computerUseApprovalRequestResult=$computerUseApprovalRequestResult}"
            webSearchCall != null -> "AgentSessionItem{webSearchCall=$webSearchCall}"
            commandExecution != null -> "AgentSessionItem{commandExecution=$commandExecution}"
            createSubagentCall != null -> "AgentSessionItem{createSubagentCall=$createSubagentCall}"
            sendSubagentInputCall != null ->
                "AgentSessionItem{sendSubagentInputCall=$sendSubagentInputCall}"
            resumeSubagentCall != null -> "AgentSessionItem{resumeSubagentCall=$resumeSubagentCall}"
            waitForSubagentsCall != null ->
                "AgentSessionItem{waitForSubagentsCall=$waitForSubagentsCall}"
            interruptSubagentCall != null ->
                "AgentSessionItem{interruptSubagentCall=$interruptSubagentCall}"
            closeSubagentCall != null -> "AgentSessionItem{closeSubagentCall=$closeSubagentCall}"
            _json != null -> "AgentSessionItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentSessionItem")
        }

    companion object {

        /** A user or assistant message recorded in a session. */
        @JvmStatic fun ofMessage(message: AgentSessionMessage) = AgentSessionItem(message = message)

        /** A reasoning item produced by the agent. */
        @JvmStatic
        fun ofReasoning(reasoning: AgentReasoningItem) = AgentSessionItem(reasoning = reasoning)

        /** A function call produced by the agent. */
        @JvmStatic
        fun ofFunctionCall(functionCall: AgentFunctionCallItem) =
            AgentSessionItem(functionCall = functionCall)

        /** The result supplied for a function call. */
        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
            AgentSessionItem(functionCallOutput = functionCallOutput)

        /** A message exchanged between agent threads. */
        @JvmStatic
        fun ofAgentMessage(agentMessage: AgentMessage) =
            AgentSessionItem(agentMessage = agentMessage)

        /** A call to a tool on an MCP server. */
        @JvmStatic fun ofMcpCall(mcpCall: AgentMcpCallItem) = AgentSessionItem(mcpCall = mcpCall)

        /** One execution of the platform-provided computer-use capability. */
        @JvmStatic
        fun ofComputerUseCall(computerUseCall: ComputerUseCall) =
            AgentSessionItem(computerUseCall = computerUseCall)

        /** A credential-free history record of the emitted login request. */
        @JvmStatic
        fun ofComputerUseApprovalRequest(computerUseApprovalRequest: ComputerUseApprovalRequest) =
            AgentSessionItem(computerUseApprovalRequest = computerUseApprovalRequest)

        /** A credential-free record of an admitted response, not proof of completion. */
        @JvmStatic
        fun ofComputerUseApprovalRequestResult(
            computerUseApprovalRequestResult: ComputerUseApprovalRequestResult
        ) = AgentSessionItem(computerUseApprovalRequestResult = computerUseApprovalRequestResult)

        /** A web search call produced by the agent. */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: AgentWebSearchCallItem) =
            AgentSessionItem(webSearchCall = webSearchCall)

        /** A command execution produced by the agent. */
        @JvmStatic
        fun ofCommandExecution(commandExecution: AgentCommandExecutionItem) =
            AgentSessionItem(commandExecution = commandExecution)

        /** A request to spawn a subagent. */
        @JvmStatic
        fun ofCreateSubagentCall(createSubagentCall: AgentCreateSubagentCallItem) =
            AgentSessionItem(createSubagentCall = createSubagentCall)

        /** A request to send input to another agent. */
        @JvmStatic
        fun ofSendSubagentInputCall(sendSubagentInputCall: AgentSendSubagentInputCallItem) =
            AgentSessionItem(sendSubagentInputCall = sendSubagentInputCall)

        /** A request to resume a subagent. */
        @JvmStatic
        fun ofResumeSubagentCall(resumeSubagentCall: AgentResumeSubagentCallItem) =
            AgentSessionItem(resumeSubagentCall = resumeSubagentCall)

        /** A request to wait for one or more subagents. */
        @JvmStatic
        fun ofWaitForSubagentsCall(waitForSubagentsCall: AgentWaitForSubagentsCallItem) =
            AgentSessionItem(waitForSubagentsCall = waitForSubagentsCall)

        /** A request to interrupt a subagent's current turn. The subagent remains available. */
        @JvmStatic
        fun ofInterruptSubagentCall(interruptSubagentCall: AgentInterruptSubagentCallItem) =
            AgentSessionItem(interruptSubagentCall = interruptSubagentCall)

        /** A request to close a subagent. */
        @JvmStatic
        fun ofCloseSubagentCall(closeSubagentCall: AgentCloseSubagentCallItem) =
            AgentSessionItem(closeSubagentCall = closeSubagentCall)
    }

    /**
     * An interface that defines how to map each variant of [AgentSessionItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A user or assistant message recorded in a session. */
        fun visitMessage(message: AgentSessionMessage): T

        /** A reasoning item produced by the agent. */
        fun visitReasoning(reasoning: AgentReasoningItem): T

        /** A function call produced by the agent. */
        fun visitFunctionCall(functionCall: AgentFunctionCallItem): T

        /** The result supplied for a function call. */
        fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T

        /** A message exchanged between agent threads. */
        fun visitAgentMessage(agentMessage: AgentMessage): T

        /** A call to a tool on an MCP server. */
        fun visitMcpCall(mcpCall: AgentMcpCallItem): T

        /** One execution of the platform-provided computer-use capability. */
        fun visitComputerUseCall(computerUseCall: ComputerUseCall): T

        /** A credential-free history record of the emitted login request. */
        fun visitComputerUseApprovalRequest(
            computerUseApprovalRequest: ComputerUseApprovalRequest
        ): T

        /** A credential-free record of an admitted response, not proof of completion. */
        fun visitComputerUseApprovalRequestResult(
            computerUseApprovalRequestResult: ComputerUseApprovalRequestResult
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
         * Maps an unknown variant of [AgentSessionItem] to a value of type [T].
         *
         * An instance of [AgentSessionItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentSessionItem")
        }
    }

    internal class Deserializer : BaseDeserializer<AgentSessionItem>(AgentSessionItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentSessionItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionMessage>())?.let {
                        AgentSessionItem(message = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "reasoning" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentReasoningItem>())?.let {
                        AgentSessionItem(reasoning = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentFunctionCallItem>())?.let {
                        AgentSessionItem(functionCall = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "function_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>())?.let {
                        AgentSessionItem(functionCallOutput = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "agent_message" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentMessage>())?.let {
                        AgentSessionItem(agentMessage = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "mcp_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentMcpCallItem>())?.let {
                        AgentSessionItem(mcpCall = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "computer_use_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerUseCall>())?.let {
                        AgentSessionItem(computerUseCall = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "computer_use_approval_request" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerUseApprovalRequest>())?.let {
                        AgentSessionItem(computerUseApprovalRequest = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "computer_use_approval_request_result" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerUseApprovalRequestResult>())
                        ?.let {
                            AgentSessionItem(computerUseApprovalRequestResult = it, _json = json)
                        } ?: AgentSessionItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentWebSearchCallItem>())?.let {
                        AgentSessionItem(webSearchCall = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "command_execution" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCommandExecutionItem>())?.let {
                        AgentSessionItem(commandExecution = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
                "create_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCreateSubagentCallItem>())
                        ?.let { AgentSessionItem(createSubagentCall = it, _json = json) }
                        ?: AgentSessionItem(_json = json)
                }
                "send_subagent_input_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSendSubagentInputCallItem>())
                        ?.let { AgentSessionItem(sendSubagentInputCall = it, _json = json) }
                        ?: AgentSessionItem(_json = json)
                }
                "resume_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentResumeSubagentCallItem>())
                        ?.let { AgentSessionItem(resumeSubagentCall = it, _json = json) }
                        ?: AgentSessionItem(_json = json)
                }
                "wait_for_subagents_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentWaitForSubagentsCallItem>())
                        ?.let { AgentSessionItem(waitForSubagentsCall = it, _json = json) }
                        ?: AgentSessionItem(_json = json)
                }
                "interrupt_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentInterruptSubagentCallItem>())
                        ?.let { AgentSessionItem(interruptSubagentCall = it, _json = json) }
                        ?: AgentSessionItem(_json = json)
                }
                "close_subagent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentCloseSubagentCallItem>())?.let {
                        AgentSessionItem(closeSubagentCall = it, _json = json)
                    } ?: AgentSessionItem(_json = json)
                }
            }

            return AgentSessionItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AgentSessionItem>(AgentSessionItem::class) {

        override fun serialize(
            value: AgentSessionItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.message != null -> generator.writeObject(value.message)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value.agentMessage != null -> generator.writeObject(value.agentMessage)
                value.mcpCall != null -> generator.writeObject(value.mcpCall)
                value.computerUseCall != null -> generator.writeObject(value.computerUseCall)
                value.computerUseApprovalRequest != null ->
                    generator.writeObject(value.computerUseApprovalRequest)
                value.computerUseApprovalRequestResult != null ->
                    generator.writeObject(value.computerUseApprovalRequestResult)
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
                else -> throw IllegalStateException("Invalid AgentSessionItem")
            }
        }
    }

    /** The result supplied for a function call. */
    class FunctionCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val callId: JsonField<String>,
        private val error: JsonField<String>,
        private val output: JsonField<AgentFunctionCallOutput>,
        private val status: JsonField<AgentFunctionCallStatus>,
        private val turnId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            output: JsonField<AgentFunctionCallOutput> = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, callId, error, output, status, turnId, type, mutableMapOf())

        /**
         * The ID of the function call output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The ID of the function call that produced this output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The error message, if the call failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * The function result, if the call succeeded.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<AgentFunctionCallOutput> = output.getOptional("output")

        /**
         * The status of the function call.
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
         * The item type. Always `function_call_output`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("function_call_output")
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
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output")
        @ExcludeMissing
        fun _output(): JsonField<AgentFunctionCallOutput> = output

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
             * Returns a mutable builder for constructing an instance of [FunctionCallOutput].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .error()
             * .output()
             * .status()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FunctionCallOutput]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var callId: JsonField<String>? = null
            private var error: JsonField<String>? = null
            private var output: JsonField<AgentFunctionCallOutput>? = null
            private var status: JsonField<AgentFunctionCallStatus>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("function_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCallOutput: FunctionCallOutput) = apply {
                id = functionCallOutput.id
                callId = functionCallOutput.callId
                error = functionCallOutput.error
                output = functionCallOutput.output
                status = functionCallOutput.status
                turnId = functionCallOutput.turnId
                type = functionCallOutput.type
                additionalProperties = functionCallOutput.additionalProperties.toMutableMap()
            }

            /** The ID of the function call output item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The ID of the function call that produced this output. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** The error message, if the call failed. */
            fun error(error: String?) = error(JsonField.ofNullable(error))

            /** Alias for calling [Builder.error] with `error.orElse(null)`. */
            fun error(error: Optional<String>) = error(error.getOrNull())

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            /** The function result, if the call succeeded. */
            fun output(output: AgentFunctionCallOutput?) = output(JsonField.ofNullable(output))

            /** Alias for calling [Builder.output] with `output.orElse(null)`. */
            fun output(output: Optional<AgentFunctionCallOutput>) = output(output.getOrNull())

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [AgentFunctionCallOutput]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun output(output: JsonField<AgentFunctionCallOutput>) = apply { this.output = output }

            /** Alias for calling [output] with `AgentFunctionCallOutput.ofString(string)`. */
            fun output(string: String) = output(AgentFunctionCallOutput.ofString(string))

            /**
             * Alias for calling [output] with
             * `AgentFunctionCallOutput.ofInputContents(inputContents)`.
             */
            fun outputOfInputContents(inputContents: List<InputContent>) =
                output(AgentFunctionCallOutput.ofInputContents(inputContents))

            /** The status of the function call. */
            fun status(status: AgentFunctionCallStatus) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [AgentFunctionCallStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun status(status: JsonField<AgentFunctionCallStatus>) = apply { this.status = status }

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
             * JsonValue.from("function_call_output")
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
             * Returns an immutable instance of [FunctionCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .error()
             * .output()
             * .status()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FunctionCallOutput =
                FunctionCallOutput(
                    checkRequired("id", id),
                    checkRequired("callId", callId),
                    checkRequired("error", error),
                    checkRequired("output", output),
                    checkRequired("status", status),
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
        fun validate(): FunctionCallOutput = apply {
            if (validated) {
                return@apply
            }

            id()
            callId()
            error()
            output().ifPresent { it.validate() }
            status().validate()
            turnId()
            _type().let {
                if (it != JsonValue.from("function_call_output")) {
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
                (if (callId.asKnown().isPresent) 1 else 0) +
                (if (error.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("function_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionCallOutput &&
                id == other.id &&
                callId == other.callId &&
                error == other.error &&
                output == other.output &&
                status == other.status &&
                turnId == other.turnId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, callId, error, output, status, turnId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FunctionCallOutput{id=$id, callId=$callId, error=$error, output=$output, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A message exchanged between agent threads. */
    class AgentMessage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val content: JsonField<List<AgentContent>>,
        private val recipientAgentId: JsonField<String>,
        private val senderAgentId: JsonField<String>,
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
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, content, recipientAgentId, senderAgentId, turnId, type, mutableMapOf())

        /**
         * The ID of the message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The content exchanged between the agents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): List<AgentContent> = content.getRequired("content")

        /**
         * The ID or name of the receiving agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipientAgentId(): String = recipientAgentId.getRequired("recipient_agent_id")

        /**
         * The ID or name of the sending agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun senderAgentId(): String = senderAgentId.getRequired("sender_agent_id")

        /**
         * The ID of the turn that contains this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun turnId(): String = turnId.getRequired("turn_id")

        /**
         * The item type. Always `agent_message`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent_message")
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
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content")
        @ExcludeMissing
        fun _content(): JsonField<List<AgentContent>> = content

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
         * Unlike [senderAgentId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sender_agent_id")
        @ExcludeMissing
        fun _senderAgentId(): JsonField<String> = senderAgentId

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
             * Returns a mutable builder for constructing an instance of [AgentMessage].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .content()
             * .recipientAgentId()
             * .senderAgentId()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AgentMessage]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var content: JsonField<MutableList<AgentContent>>? = null
            private var recipientAgentId: JsonField<String>? = null
            private var senderAgentId: JsonField<String>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("agent_message")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agentMessage: AgentMessage) = apply {
                id = agentMessage.id
                content = agentMessage.content.map { it.toMutableList() }
                recipientAgentId = agentMessage.recipientAgentId
                senderAgentId = agentMessage.senderAgentId
                turnId = agentMessage.turnId
                type = agentMessage.type
                additionalProperties = agentMessage.additionalProperties.toMutableMap()
            }

            /** The ID of the message. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The content exchanged between the agents. */
            fun content(content: List<AgentContent>) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed `List<AgentContent>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
            fun addContent(outputText: OutputText) =
                addContent(AgentContent.ofOutputText(outputText))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * OutputText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addOutputTextContent(text: String) =
                addContent(OutputText.builder().text(text).build())

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
                    AgentContent.EncryptedContent.builder()
                        .encryptedContent(encryptedContent)
                        .build()
                )

            /** The ID or name of the receiving agent. */
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

            /** The ID or name of the sending agent. */
            fun senderAgentId(senderAgentId: String) = senderAgentId(JsonField.of(senderAgentId))

            /**
             * Sets [Builder.senderAgentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.senderAgentId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun senderAgentId(senderAgentId: JsonField<String>) = apply {
                this.senderAgentId = senderAgentId
            }

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
             * JsonValue.from("agent_message")
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
             * Returns an immutable instance of [AgentMessage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .content()
             * .recipientAgentId()
             * .senderAgentId()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AgentMessage =
                AgentMessage(
                    checkRequired("id", id),
                    checkRequired("content", content).map { it.toImmutable() },
                    checkRequired("recipientAgentId", recipientAgentId),
                    checkRequired("senderAgentId", senderAgentId),
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
        fun validate(): AgentMessage = apply {
            if (validated) {
                return@apply
            }

            id()
            content().forEach { it.validate() }
            recipientAgentId()
            senderAgentId()
            turnId()
            _type().let {
                if (it != JsonValue.from("agent_message")) {
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
                (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (recipientAgentId.asKnown().isPresent) 1 else 0) +
                (if (senderAgentId.asKnown().isPresent) 1 else 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("agent_message")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentMessage &&
                id == other.id &&
                content == other.content &&
                recipientAgentId == other.recipientAgentId &&
                senderAgentId == other.senderAgentId &&
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
                turnId,
                type,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AgentMessage{id=$id, content=$content, recipientAgentId=$recipientAgentId, senderAgentId=$senderAgentId, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
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

    /** A credential-free record of an admitted response, not proof of completion. */
    class ComputerUseApprovalRequestResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val requestId: JsonField<String>,
        private val response: JsonField<Response>,
        private val turnId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, requestId, response, turnId, type, mutableMapOf())

        /**
         * The stable history item ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The registered request answered by this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestId(): String = requestId.getRequired("request_id")

        /**
         * The admitted response, without submitted credential values.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The ID of the turn that contains this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun turnId(): String = turnId.getRequired("turn_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("computer_use_approval_request_result")
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
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * [ComputerUseApprovalRequestResult].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .requestId()
             * .response()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComputerUseApprovalRequestResult]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var requestId: JsonField<String>? = null
            private var response: JsonField<Response>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("computer_use_approval_request_result")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(computerUseApprovalRequestResult: ComputerUseApprovalRequestResult) =
                apply {
                    id = computerUseApprovalRequestResult.id
                    requestId = computerUseApprovalRequestResult.requestId
                    response = computerUseApprovalRequestResult.response
                    turnId = computerUseApprovalRequestResult.turnId
                    type = computerUseApprovalRequestResult.type
                    additionalProperties =
                        computerUseApprovalRequestResult.additionalProperties.toMutableMap()
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

            /** The registered request answered by this item. */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** The admitted response, without submitted credential values. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /** Alias for calling [response] with `Response.ofSubmit(submit)`. */
            fun response(submit: Response.Submit) = response(Response.ofSubmit(submit))

            /**
             * Alias for calling [response] with the following:
             * ```java
             * Response.Submit.builder()
             *     .selectedOption(selectedOption)
             *     .build()
             * ```
             */
            fun submitResponse(selectedOption: String?) =
                response(Response.Submit.builder().selectedOption(selectedOption).build())

            /** Alias for calling [submitResponse] with `selectedOption.orElse(null)`. */
            fun submitResponse(selectedOption: Optional<String>) =
                submitResponse(selectedOption.getOrNull())

            /** Alias for calling [response] with `Response.ofCancel()`. */
            fun responseCancel() = response(Response.ofCancel())

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
             * JsonValue.from("computer_use_approval_request_result")
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
             * Returns an immutable instance of [ComputerUseApprovalRequestResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .requestId()
             * .response()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComputerUseApprovalRequestResult =
                ComputerUseApprovalRequestResult(
                    checkRequired("id", id),
                    checkRequired("requestId", requestId),
                    checkRequired("response", response),
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
        fun validate(): ComputerUseApprovalRequestResult = apply {
            if (validated) {
                return@apply
            }

            id()
            requestId()
            response().validate()
            turnId()
            _type().let {
                if (it != JsonValue.from("computer_use_approval_request_result")) {
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
                (if (requestId.asKnown().isPresent) 1 else 0) +
                (response.asKnown().getOrNull()?.validity() ?: 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let {
                    if (it == JsonValue.from("computer_use_approval_request_result")) 1 else 0
                }

        /** The admitted response, without submitted credential values. */
        @JsonDeserialize(using = Response.Deserializer::class)
        @JsonSerialize(using = Response.Serializer::class)
        class Response
        private constructor(
            private val submit: Submit? = null,
            private val cancel: JsonValue? = null,
            private val _json: JsonValue? = null,
        ) {

            fun submit(): Optional<Submit> = Optional.ofNullable(submit)

            fun cancel(): Optional<JsonValue> = Optional.ofNullable(cancel)

            fun isSubmit(): Boolean = submit != null

            fun isCancel(): Boolean = cancel != null

            fun asSubmit(): Submit = submit.getOrThrow("submit")

            fun asCancel(): JsonValue = cancel.getOrThrow("cancel")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = response.accept(new Response.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitSubmit(Submit submit) {
             *         return Optional.of(submit.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    submit != null -> visitor.visitSubmit(submit)
                    cancel != null -> visitor.visitCancel(cancel)
                    else -> visitor.unknown(_json)
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
            fun validate(): Response = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitSubmit(submit: Submit) {
                            submit.validate()
                        }

                        override fun visitCancel(cancel: JsonValue) {
                            cancel.let {
                                if (
                                    it !=
                                        JsonValue.from(
                                            mapOf(
                                                "action" to "cancel",
                                                "type" to "browser_authentication",
                                            )
                                        )
                                ) {
                                    throw OpenAIInvalidDataException(
                                        "'cancel' is invalid, received $it"
                                    )
                                }
                            }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitSubmit(submit: Submit) = submit.validity()

                        override fun visitCancel(cancel: JsonValue) =
                            cancel.let {
                                if (
                                    it ==
                                        JsonValue.from(
                                            mapOf(
                                                "action" to "cancel",
                                                "type" to "browser_authentication",
                                            )
                                        )
                                )
                                    1
                                else 0
                            }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Response && submit == other.submit && cancel == other.cancel
            }

            override fun hashCode(): Int = Objects.hash(submit, cancel)

            override fun toString(): String =
                when {
                    submit != null -> "Response{submit=$submit}"
                    cancel != null -> "Response{cancel=$cancel}"
                    _json != null -> "Response{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Response")
                }

            companion object {

                @JvmStatic fun ofSubmit(submit: Submit) = Response(submit = submit)

                @JvmStatic
                fun ofCancel() =
                    Response(
                        cancel =
                            JsonValue.from(
                                mapOf("action" to "cancel", "type" to "browser_authentication")
                            )
                    )
            }

            /**
             * An interface that defines how to map each variant of [Response] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitSubmit(submit: Submit): T

                fun visitCancel(cancel: JsonValue): T

                /**
                 * Maps an unknown variant of [Response] to a value of type [T].
                 *
                 * An instance of [Response] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Response")
                }
            }

            internal class Deserializer : BaseDeserializer<Response>(Response::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Response {
                    val json = JsonValue.fromJsonNode(node)
                    val action = json.asObject().getOrNull()?.get("action")?.asString()?.getOrNull()

                    when (action) {
                        "submit" -> {
                            return tryDeserialize(node, jacksonTypeRef<Submit>())?.let {
                                Response(submit = it, _json = json)
                            } ?: Response(_json = json)
                        }
                        "cancel" -> {
                            return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Response(cancel = it, _json = json) }
                                ?.takeIf { it.isValid() } ?: Response(_json = json)
                        }
                    }

                    return Response(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Response>(Response::class) {

                override fun serialize(
                    value: Response,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.submit != null -> generator.writeObject(value.submit)
                        value.cancel != null -> generator.writeObject(value.cancel)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Response")
                    }
                }
            }

            class Submit
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val action: JsonValue,
                private val selectedOption: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("action") @ExcludeMissing action: JsonValue = JsonMissing.of(),
                    @JsonProperty("selected_option")
                    @ExcludeMissing
                    selectedOption: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(action, selectedOption, type, mutableMapOf())

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("submit")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("action") @ExcludeMissing fun _action(): JsonValue = action

                /**
                 * The chosen sign-in method, or null when no options were offered.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun selectedOption(): Optional<String> =
                    selectedOption.getOptional("selected_option")

                /**
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
                 * Returns the raw JSON value of [selectedOption].
                 *
                 * Unlike [selectedOption], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("selected_option")
                @ExcludeMissing
                fun _selectedOption(): JsonField<String> = selectedOption

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
                     * Returns a mutable builder for constructing an instance of [Submit].
                     *
                     * The following fields are required:
                     * ```java
                     * .selectedOption()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Submit]. */
                class Builder internal constructor() {

                    private var action: JsonValue = JsonValue.from("submit")
                    private var selectedOption: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("browser_authentication")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(submit: Submit) = apply {
                        action = submit.action
                        selectedOption = submit.selectedOption
                        type = submit.type
                        additionalProperties = submit.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("submit")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun action(action: JsonValue) = apply { this.action = action }

                    /** The chosen sign-in method, or null when no options were offered. */
                    fun selectedOption(selectedOption: String?) =
                        selectedOption(JsonField.ofNullable(selectedOption))

                    /**
                     * Alias for calling [Builder.selectedOption] with
                     * `selectedOption.orElse(null)`.
                     */
                    fun selectedOption(selectedOption: Optional<String>) =
                        selectedOption(selectedOption.getOrNull())

                    /**
                     * Sets [Builder.selectedOption] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.selectedOption] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun selectedOption(selectedOption: JsonField<String>) = apply {
                        this.selectedOption = selectedOption
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
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
                     * Returns an immutable instance of [Submit].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .selectedOption()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Submit =
                        Submit(
                            action,
                            checkRequired("selectedOption", selectedOption),
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Submit = apply {
                    if (validated) {
                        return@apply
                    }

                    _action().let {
                        if (it != JsonValue.from("submit")) {
                            throw OpenAIInvalidDataException("'action' is invalid, received $it")
                        }
                    }
                    selectedOption()
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
                    action.let { if (it == JsonValue.from("submit")) 1 else 0 } +
                        (if (selectedOption.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("browser_authentication")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Submit &&
                        action == other.action &&
                        selectedOption == other.selectedOption &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(action, selectedOption, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Submit{action=$action, selectedOption=$selectedOption, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComputerUseApprovalRequestResult &&
                id == other.id &&
                requestId == other.requestId &&
                response == other.response &&
                turnId == other.turnId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, requestId, response, turnId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComputerUseApprovalRequestResult{id=$id, requestId=$requestId, response=$response, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
    }
}
