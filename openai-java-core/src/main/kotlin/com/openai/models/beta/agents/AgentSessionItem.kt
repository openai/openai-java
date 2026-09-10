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
            throw OpenAIInvalidDataException("Unknown AgentSessionItem: $json")
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
         * The text or model-input content supplied as a function result.
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

            /** The text or model-input content supplied as a function result. */
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
}
