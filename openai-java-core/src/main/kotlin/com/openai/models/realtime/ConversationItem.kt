// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A single item within a Realtime conversation. */
@JsonDeserialize(using = ConversationItem.Deserializer::class)
@JsonSerialize(using = ConversationItem.Serializer::class)
class ConversationItem
private constructor(
    private val realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage? =
        null,
    private val realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage? = null,
    private val realtimeConversationItemAssistantMessage:
        RealtimeConversationItemAssistantMessage? =
        null,
    private val functionCall: RealtimeConversationItemFunctionCall? = null,
    private val functionCallOutput: RealtimeConversationItemFunctionCallOutput? = null,
    private val mcpApprovalResponse: RealtimeMcpApprovalResponse? = null,
    private val mcpListTools: RealtimeMcpListTools? = null,
    private val mcpToolCall: RealtimeMcpToolCall? = null,
    private val mcpApprovalRequest: RealtimeMcpApprovalRequest? = null,
    private val _json: JsonValue? = null,
) {

    /** A system message item in a Realtime conversation. */
    fun realtimeConversationItemSystemMessage(): Optional<RealtimeConversationItemSystemMessage> =
        Optional.ofNullable(realtimeConversationItemSystemMessage)

    /** A user message item in a Realtime conversation. */
    fun realtimeConversationItemUserMessage(): Optional<RealtimeConversationItemUserMessage> =
        Optional.ofNullable(realtimeConversationItemUserMessage)

    /** An assistant message item in a Realtime conversation. */
    fun realtimeConversationItemAssistantMessage():
        Optional<RealtimeConversationItemAssistantMessage> =
        Optional.ofNullable(realtimeConversationItemAssistantMessage)

    /** A function call item in a Realtime conversation. */
    fun functionCall(): Optional<RealtimeConversationItemFunctionCall> =
        Optional.ofNullable(functionCall)

    /** A function call output item in a Realtime conversation. */
    fun functionCallOutput(): Optional<RealtimeConversationItemFunctionCallOutput> =
        Optional.ofNullable(functionCallOutput)

    /** A Realtime item responding to an MCP approval request. */
    fun mcpApprovalResponse(): Optional<RealtimeMcpApprovalResponse> =
        Optional.ofNullable(mcpApprovalResponse)

    /** A Realtime item listing tools available on an MCP server. */
    fun mcpListTools(): Optional<RealtimeMcpListTools> = Optional.ofNullable(mcpListTools)

    /** A Realtime item representing an invocation of a tool on an MCP server. */
    fun mcpToolCall(): Optional<RealtimeMcpToolCall> = Optional.ofNullable(mcpToolCall)

    /** A Realtime item requesting human approval of a tool invocation. */
    fun mcpApprovalRequest(): Optional<RealtimeMcpApprovalRequest> =
        Optional.ofNullable(mcpApprovalRequest)

    fun isRealtimeConversationItemSystemMessage(): Boolean =
        realtimeConversationItemSystemMessage != null

    fun isRealtimeConversationItemUserMessage(): Boolean =
        realtimeConversationItemUserMessage != null

    fun isRealtimeConversationItemAssistantMessage(): Boolean =
        realtimeConversationItemAssistantMessage != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun isMcpApprovalResponse(): Boolean = mcpApprovalResponse != null

    fun isMcpListTools(): Boolean = mcpListTools != null

    fun isMcpToolCall(): Boolean = mcpToolCall != null

    fun isMcpApprovalRequest(): Boolean = mcpApprovalRequest != null

    /** A system message item in a Realtime conversation. */
    fun asRealtimeConversationItemSystemMessage(): RealtimeConversationItemSystemMessage =
        realtimeConversationItemSystemMessage.getOrThrow("realtimeConversationItemSystemMessage")

    /** A user message item in a Realtime conversation. */
    fun asRealtimeConversationItemUserMessage(): RealtimeConversationItemUserMessage =
        realtimeConversationItemUserMessage.getOrThrow("realtimeConversationItemUserMessage")

    /** An assistant message item in a Realtime conversation. */
    fun asRealtimeConversationItemAssistantMessage(): RealtimeConversationItemAssistantMessage =
        realtimeConversationItemAssistantMessage.getOrThrow(
            "realtimeConversationItemAssistantMessage"
        )

    /** A function call item in a Realtime conversation. */
    fun asFunctionCall(): RealtimeConversationItemFunctionCall =
        functionCall.getOrThrow("functionCall")

    /** A function call output item in a Realtime conversation. */
    fun asFunctionCallOutput(): RealtimeConversationItemFunctionCallOutput =
        functionCallOutput.getOrThrow("functionCallOutput")

    /** A Realtime item responding to an MCP approval request. */
    fun asMcpApprovalResponse(): RealtimeMcpApprovalResponse =
        mcpApprovalResponse.getOrThrow("mcpApprovalResponse")

    /** A Realtime item listing tools available on an MCP server. */
    fun asMcpListTools(): RealtimeMcpListTools = mcpListTools.getOrThrow("mcpListTools")

    /** A Realtime item representing an invocation of a tool on an MCP server. */
    fun asMcpToolCall(): RealtimeMcpToolCall = mcpToolCall.getOrThrow("mcpToolCall")

    /** A Realtime item requesting human approval of a tool invocation. */
    fun asMcpApprovalRequest(): RealtimeMcpApprovalRequest =
        mcpApprovalRequest.getOrThrow("mcpApprovalRequest")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            realtimeConversationItemSystemMessage != null ->
                visitor.visitRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage
                )
            realtimeConversationItemUserMessage != null ->
                visitor.visitRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage
                )
            realtimeConversationItemAssistantMessage != null ->
                visitor.visitRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage
                )
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            mcpApprovalResponse != null -> visitor.visitMcpApprovalResponse(mcpApprovalResponse)
            mcpListTools != null -> visitor.visitMcpListTools(mcpListTools)
            mcpToolCall != null -> visitor.visitMcpToolCall(mcpToolCall)
            mcpApprovalRequest != null -> visitor.visitMcpApprovalRequest(mcpApprovalRequest)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ConversationItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
                ) {
                    realtimeConversationItemSystemMessage.validate()
                }

                override fun visitRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage
                ) {
                    realtimeConversationItemUserMessage.validate()
                }

                override fun visitRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage:
                        RealtimeConversationItemAssistantMessage
                ) {
                    realtimeConversationItemAssistantMessage.validate()
                }

                override fun visitFunctionCall(functionCall: RealtimeConversationItemFunctionCall) {
                    functionCall.validate()
                }

                override fun visitFunctionCallOutput(
                    functionCallOutput: RealtimeConversationItemFunctionCallOutput
                ) {
                    functionCallOutput.validate()
                }

                override fun visitMcpApprovalResponse(
                    mcpApprovalResponse: RealtimeMcpApprovalResponse
                ) {
                    mcpApprovalResponse.validate()
                }

                override fun visitMcpListTools(mcpListTools: RealtimeMcpListTools) {
                    mcpListTools.validate()
                }

                override fun visitMcpToolCall(mcpToolCall: RealtimeMcpToolCall) {
                    mcpToolCall.validate()
                }

                override fun visitMcpApprovalRequest(
                    mcpApprovalRequest: RealtimeMcpApprovalRequest
                ) {
                    mcpApprovalRequest.validate()
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
                override fun visitRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
                ) = realtimeConversationItemSystemMessage.validity()

                override fun visitRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage
                ) = realtimeConversationItemUserMessage.validity()

                override fun visitRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage:
                        RealtimeConversationItemAssistantMessage
                ) = realtimeConversationItemAssistantMessage.validity()

                override fun visitFunctionCall(functionCall: RealtimeConversationItemFunctionCall) =
                    functionCall.validity()

                override fun visitFunctionCallOutput(
                    functionCallOutput: RealtimeConversationItemFunctionCallOutput
                ) = functionCallOutput.validity()

                override fun visitMcpApprovalResponse(
                    mcpApprovalResponse: RealtimeMcpApprovalResponse
                ) = mcpApprovalResponse.validity()

                override fun visitMcpListTools(mcpListTools: RealtimeMcpListTools) =
                    mcpListTools.validity()

                override fun visitMcpToolCall(mcpToolCall: RealtimeMcpToolCall) =
                    mcpToolCall.validity()

                override fun visitMcpApprovalRequest(
                    mcpApprovalRequest: RealtimeMcpApprovalRequest
                ) = mcpApprovalRequest.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationItem &&
            realtimeConversationItemSystemMessage == other.realtimeConversationItemSystemMessage &&
            realtimeConversationItemUserMessage == other.realtimeConversationItemUserMessage &&
            realtimeConversationItemAssistantMessage ==
                other.realtimeConversationItemAssistantMessage &&
            functionCall == other.functionCall &&
            functionCallOutput == other.functionCallOutput &&
            mcpApprovalResponse == other.mcpApprovalResponse &&
            mcpListTools == other.mcpListTools &&
            mcpToolCall == other.mcpToolCall &&
            mcpApprovalRequest == other.mcpApprovalRequest
    }

    override fun hashCode(): Int =
        Objects.hash(
            realtimeConversationItemSystemMessage,
            realtimeConversationItemUserMessage,
            realtimeConversationItemAssistantMessage,
            functionCall,
            functionCallOutput,
            mcpApprovalResponse,
            mcpListTools,
            mcpToolCall,
            mcpApprovalRequest,
        )

    override fun toString(): String =
        when {
            realtimeConversationItemSystemMessage != null ->
                "ConversationItem{realtimeConversationItemSystemMessage=$realtimeConversationItemSystemMessage}"
            realtimeConversationItemUserMessage != null ->
                "ConversationItem{realtimeConversationItemUserMessage=$realtimeConversationItemUserMessage}"
            realtimeConversationItemAssistantMessage != null ->
                "ConversationItem{realtimeConversationItemAssistantMessage=$realtimeConversationItemAssistantMessage}"
            functionCall != null -> "ConversationItem{functionCall=$functionCall}"
            functionCallOutput != null -> "ConversationItem{functionCallOutput=$functionCallOutput}"
            mcpApprovalResponse != null ->
                "ConversationItem{mcpApprovalResponse=$mcpApprovalResponse}"
            mcpListTools != null -> "ConversationItem{mcpListTools=$mcpListTools}"
            mcpToolCall != null -> "ConversationItem{mcpToolCall=$mcpToolCall}"
            mcpApprovalRequest != null -> "ConversationItem{mcpApprovalRequest=$mcpApprovalRequest}"
            _json != null -> "ConversationItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ConversationItem")
        }

    companion object {

        /** A system message item in a Realtime conversation. */
        @JvmStatic
        fun ofRealtimeConversationItemSystemMessage(
            realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
        ) =
            ConversationItem(
                realtimeConversationItemSystemMessage = realtimeConversationItemSystemMessage
            )

        /** A user message item in a Realtime conversation. */
        @JvmStatic
        fun ofRealtimeConversationItemUserMessage(
            realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage
        ) =
            ConversationItem(
                realtimeConversationItemUserMessage = realtimeConversationItemUserMessage
            )

        /** An assistant message item in a Realtime conversation. */
        @JvmStatic
        fun ofRealtimeConversationItemAssistantMessage(
            realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
        ) =
            ConversationItem(
                realtimeConversationItemAssistantMessage = realtimeConversationItemAssistantMessage
            )

        /** A function call item in a Realtime conversation. */
        @JvmStatic
        fun ofFunctionCall(functionCall: RealtimeConversationItemFunctionCall) =
            ConversationItem(functionCall = functionCall)

        /** A function call output item in a Realtime conversation. */
        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: RealtimeConversationItemFunctionCallOutput) =
            ConversationItem(functionCallOutput = functionCallOutput)

        /** A Realtime item responding to an MCP approval request. */
        @JvmStatic
        fun ofMcpApprovalResponse(mcpApprovalResponse: RealtimeMcpApprovalResponse) =
            ConversationItem(mcpApprovalResponse = mcpApprovalResponse)

        /** A Realtime item listing tools available on an MCP server. */
        @JvmStatic
        fun ofMcpListTools(mcpListTools: RealtimeMcpListTools) =
            ConversationItem(mcpListTools = mcpListTools)

        /** A Realtime item representing an invocation of a tool on an MCP server. */
        @JvmStatic
        fun ofMcpToolCall(mcpToolCall: RealtimeMcpToolCall) =
            ConversationItem(mcpToolCall = mcpToolCall)

        /** A Realtime item requesting human approval of a tool invocation. */
        @JvmStatic
        fun ofMcpApprovalRequest(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
            ConversationItem(mcpApprovalRequest = mcpApprovalRequest)
    }

    /**
     * An interface that defines how to map each variant of [ConversationItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A system message item in a Realtime conversation. */
        fun visitRealtimeConversationItemSystemMessage(
            realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
        ): T

        /** A user message item in a Realtime conversation. */
        fun visitRealtimeConversationItemUserMessage(
            realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage
        ): T

        /** An assistant message item in a Realtime conversation. */
        fun visitRealtimeConversationItemAssistantMessage(
            realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
        ): T

        /** A function call item in a Realtime conversation. */
        fun visitFunctionCall(functionCall: RealtimeConversationItemFunctionCall): T

        /** A function call output item in a Realtime conversation. */
        fun visitFunctionCallOutput(
            functionCallOutput: RealtimeConversationItemFunctionCallOutput
        ): T

        /** A Realtime item responding to an MCP approval request. */
        fun visitMcpApprovalResponse(mcpApprovalResponse: RealtimeMcpApprovalResponse): T

        /** A Realtime item listing tools available on an MCP server. */
        fun visitMcpListTools(mcpListTools: RealtimeMcpListTools): T

        /** A Realtime item representing an invocation of a tool on an MCP server. */
        fun visitMcpToolCall(mcpToolCall: RealtimeMcpToolCall): T

        /** A Realtime item requesting human approval of a tool invocation. */
        fun visitMcpApprovalRequest(mcpApprovalRequest: RealtimeMcpApprovalRequest): T

        /**
         * Maps an unknown variant of [ConversationItem] to a value of type [T].
         *
         * An instance of [ConversationItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ConversationItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ConversationItem>(ConversationItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ConversationItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<RealtimeConversationItemSystemMessage>(),
                                    )
                                    ?.let {
                                        ConversationItem(
                                            realtimeConversationItemSystemMessage = it,
                                            _json = json,
                                        )
                                    },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<RealtimeConversationItemUserMessage>(),
                                    )
                                    ?.let {
                                        ConversationItem(
                                            realtimeConversationItemUserMessage = it,
                                            _json = json,
                                        )
                                    },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<RealtimeConversationItemAssistantMessage>(),
                                    )
                                    ?.let {
                                        ConversationItem(
                                            realtimeConversationItemAssistantMessage = it,
                                            _json = json,
                                        )
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> ConversationItem(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
                "function_call" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeConversationItemFunctionCall>(),
                        )
                        ?.let { ConversationItem(functionCall = it, _json = json) }
                        ?: ConversationItem(_json = json)
                }
                "function_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<RealtimeConversationItemFunctionCallOutput>(),
                        )
                        ?.let { ConversationItem(functionCallOutput = it, _json = json) }
                        ?: ConversationItem(_json = json)
                }
                "mcp_approval_response" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeMcpApprovalResponse>())
                        ?.let { ConversationItem(mcpApprovalResponse = it, _json = json) }
                        ?: ConversationItem(_json = json)
                }
                "mcp_list_tools" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeMcpListTools>())?.let {
                        ConversationItem(mcpListTools = it, _json = json)
                    } ?: ConversationItem(_json = json)
                }
                "mcp_tool_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeMcpToolCall>())?.let {
                        ConversationItem(mcpToolCall = it, _json = json)
                    } ?: ConversationItem(_json = json)
                }
                "mcp_approval_request" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeMcpApprovalRequest>())?.let {
                        ConversationItem(mcpApprovalRequest = it, _json = json)
                    } ?: ConversationItem(_json = json)
                }
            }

            return ConversationItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ConversationItem>(ConversationItem::class) {

        override fun serialize(
            value: ConversationItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.realtimeConversationItemSystemMessage != null ->
                    generator.writeObject(value.realtimeConversationItemSystemMessage)
                value.realtimeConversationItemUserMessage != null ->
                    generator.writeObject(value.realtimeConversationItemUserMessage)
                value.realtimeConversationItemAssistantMessage != null ->
                    generator.writeObject(value.realtimeConversationItemAssistantMessage)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value.mcpApprovalResponse != null ->
                    generator.writeObject(value.mcpApprovalResponse)
                value.mcpListTools != null -> generator.writeObject(value.mcpListTools)
                value.mcpToolCall != null -> generator.writeObject(value.mcpToolCall)
                value.mcpApprovalRequest != null -> generator.writeObject(value.mcpApprovalRequest)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ConversationItem")
            }
        }
    }
}
