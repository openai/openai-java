// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
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
            throw OpenAIInvalidDataException("Unknown AgentOutputItem: $json")
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
}
