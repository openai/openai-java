package com.openai.models.responses

import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

/**
 * A wrapper for [ResponseOutputItem] that provides type-safe access to the [message] when using the
 * _Structured Outputs_ feature to deserialize a JSON response to an instance of an arbitrary class.
 * See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class to which the JSON data in the content will be deserialized when
 *   [message] is called.
 */
class StructuredResponseOutputItem<T : Any>(
    @get:JvmName("responseType") val responseType: Class<T>,
    @get:JvmName("rawOutputItem") val rawOutputItem: ResponseOutputItem,
) {
    private val message by lazy {
        rawOutputItem.message().map { StructuredResponseOutputMessage<T>(responseType, it) }
    }

    /** @see ResponseOutputItem.message */
    fun message(): Optional<StructuredResponseOutputMessage<T>> = message

    /** @see ResponseOutputItem.fileSearchCall */
    fun fileSearchCall(): Optional<ResponseFileSearchToolCall> = rawOutputItem.fileSearchCall()

    /** @see ResponseOutputItem.functionCall */
    fun functionCall(): Optional<ResponseFunctionToolCall> = rawOutputItem.functionCall()

    /** @see ResponseOutputItem.webSearchCall */
    fun webSearchCall(): Optional<ResponseFunctionWebSearch> = rawOutputItem.webSearchCall()

    /** @see ResponseOutputItem.computerCall */
    fun computerCall(): Optional<ResponseComputerToolCall> = rawOutputItem.computerCall()

    /** @see ResponseOutputItem.reasoning */
    fun reasoning(): Optional<ResponseReasoningItem> = rawOutputItem.reasoning()

    /** @see ResponseOutputItem.codeInterpreterCall */
    fun codeInterpreterCall(): Optional<ResponseCodeInterpreterToolCall> =
        rawOutputItem.codeInterpreterCall()

    /** @see ResponseOutputItem.imageGenerationCall */
    fun imageGenerationCall(): Optional<ResponseOutputItem.ImageGenerationCall> =
        rawOutputItem.imageGenerationCall()

    /** @see ResponseOutputItem.localShellCall */
    fun localShellCall(): Optional<ResponseOutputItem.LocalShellCall> =
        rawOutputItem.localShellCall()

    /** @see ResponseOutputItem.mcpApprovalRequest */
    fun mcpApprovalRequest(): Optional<ResponseOutputItem.McpApprovalRequest> =
        rawOutputItem.mcpApprovalRequest()

    /** @see ResponseOutputItem.mcpCall */
    fun mcpCall(): Optional<ResponseOutputItem.McpCall> = rawOutputItem.mcpCall()

    /** @see ResponseOutputItem.mcpListTools */
    fun mcpListTools(): Optional<ResponseOutputItem.McpListTools> = rawOutputItem.mcpListTools()

    /** @see ResponseOutputItem.isMessage */
    fun isMessage(): Boolean = message().isPresent

    /** @see ResponseOutputItem.isFileSearchCall */
    fun isFileSearchCall(): Boolean = rawOutputItem.isFileSearchCall()

    /** @see ResponseOutputItem.isFunctionCall */
    fun isFunctionCall(): Boolean = rawOutputItem.isFunctionCall()

    /** @see ResponseOutputItem.isWebSearchCall */
    fun isWebSearchCall(): Boolean = rawOutputItem.isWebSearchCall()

    /** @see ResponseOutputItem.isComputerCall */
    fun isComputerCall(): Boolean = rawOutputItem.isComputerCall()

    /** @see ResponseOutputItem.isReasoning */
    fun isReasoning(): Boolean = rawOutputItem.isReasoning()

    /** @see ResponseOutputItem.isCodeInterpreterCall */
    fun isCodeInterpreterCall(): Boolean = rawOutputItem.isCodeInterpreterCall()

    /** @see ResponseOutputItem.isImageGenerationCall */
    fun isImageGenerationCall(): Boolean = rawOutputItem.isImageGenerationCall()

    /** @see ResponseOutputItem.isLocalShellCall */
    fun isLocalShellCall(): Boolean = rawOutputItem.isLocalShellCall()

    /** @see ResponseOutputItem.isMcpApprovalRequest */
    fun isMcpApprovalRequest(): Boolean = rawOutputItem.isMcpApprovalRequest()

    /** @see ResponseOutputItem.isMcpCall */
    fun isMcpCall(): Boolean = rawOutputItem.isMcpCall()

    /** @see ResponseOutputItem.isMcpListTools */
    fun isMcpListTools(): Boolean = rawOutputItem.isMcpListTools()

    /** @see ResponseOutputItem.asMessage */
    fun asMessage(): StructuredResponseOutputMessage<T> =
        message.getOrElse {
            // Same behavior as `com.openai.core.getOrThrow` used by the delegate class.
            throw OpenAIInvalidDataException("`message` is not present")
        }

    /** @see ResponseOutputItem.asFileSearchCall */
    fun asFileSearchCall(): ResponseFileSearchToolCall = rawOutputItem.asFileSearchCall()

    /** @see ResponseOutputItem.asFunctionCall */
    fun asFunctionCall(): ResponseFunctionToolCall = rawOutputItem.asFunctionCall()

    /** @see ResponseOutputItem.asWebSearchCall */
    fun asWebSearchCall(): ResponseFunctionWebSearch = rawOutputItem.asWebSearchCall()

    /** @see ResponseOutputItem.asComputerCall */
    fun asComputerCall(): ResponseComputerToolCall = rawOutputItem.asComputerCall()

    /** @see ResponseOutputItem.asReasoning */
    fun asReasoning(): ResponseReasoningItem = rawOutputItem.asReasoning()

    /** @see ResponseOutputItem.asCodeInterpreterCall */
    fun asCodeInterpreterCall(): ResponseCodeInterpreterToolCall =
        rawOutputItem.asCodeInterpreterCall()

    /** @see ResponseOutputItem.asImageGenerationCall */
    fun asImageGenerationCall(): ResponseOutputItem.ImageGenerationCall =
        rawOutputItem.asImageGenerationCall()

    /** @see ResponseOutputItem.asLocalShellCall */
    fun asLocalShellCall(): ResponseOutputItem.LocalShellCall = rawOutputItem.asLocalShellCall()

    /** @see ResponseOutputItem.asMcpApprovalRequest */
    fun asMcpApprovalRequest(): ResponseOutputItem.McpApprovalRequest =
        rawOutputItem.asMcpApprovalRequest()

    /** @see ResponseOutputItem.asMcpCall */
    fun asMcpCall(): ResponseOutputItem.McpCall = rawOutputItem.asMcpCall()

    /** @see ResponseOutputItem.asMcpListTools */
    fun asMcpListTools(): ResponseOutputItem.McpListTools = rawOutputItem.asMcpListTools()

    /** @see ResponseOutputItem._json */
    fun _json(): Optional<JsonValue> = rawOutputItem._json()

    /** @see ResponseOutputItem.accept */
    fun <R> accept(visitor: Visitor<T, R>): R =
        when {
            isMessage() -> visitor.visitMessage(asMessage())
            isFileSearchCall() -> visitor.visitFileSearchCall(asFileSearchCall())
            isFunctionCall() -> visitor.visitFunctionCall(asFunctionCall())
            isWebSearchCall() -> visitor.visitWebSearchCall(asWebSearchCall())
            isComputerCall() -> visitor.visitComputerCall(asComputerCall())
            isReasoning() -> visitor.visitReasoning(asReasoning())
            isCodeInterpreterCall() -> visitor.visitCodeInterpreterCall(asCodeInterpreterCall())
            isImageGenerationCall() -> visitor.visitImageGenerationCall(asImageGenerationCall())
            isLocalShellCall() -> visitor.visitLocalShellCall(asLocalShellCall())
            isMcpApprovalRequest() -> visitor.visitMcpApprovalRequest(asMcpApprovalRequest())
            isMcpCall() -> visitor.visitMcpCall(asMcpCall())
            isMcpListTools() -> visitor.visitMcpListTools(asMcpListTools())
            else -> visitor.unknown(_json().getOrNull())
        }

    private var validated: Boolean = false

    /** @see ResponseOutputItem.validate */
    fun validate(): StructuredResponseOutputItem<T> = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<T, Unit> {
                override fun visitMessage(message: StructuredResponseOutputMessage<T>) {
                    message.validate()
                }

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) {
                    fileSearchCall.validate()
                }

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) {
                    functionCall.validate()
                }

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) {
                    webSearchCall.validate()
                }

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) {
                    computerCall.validate()
                }

                override fun visitReasoning(reasoning: ResponseReasoningItem) {
                    reasoning.validate()
                }

                override fun visitCodeInterpreterCall(
                    codeInterpreterCall: ResponseCodeInterpreterToolCall
                ) {
                    codeInterpreterCall.validate()
                }

                override fun visitImageGenerationCall(
                    imageGenerationCall: ResponseOutputItem.ImageGenerationCall
                ) {
                    imageGenerationCall.validate()
                }

                override fun visitLocalShellCall(
                    localShellCall: ResponseOutputItem.LocalShellCall
                ) {
                    localShellCall.validate()
                }

                override fun visitMcpApprovalRequest(
                    mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest
                ) {
                    mcpApprovalRequest.validate()
                }

                override fun visitMcpCall(mcpCall: ResponseOutputItem.McpCall) {
                    mcpCall.validate()
                }

                override fun visitMcpListTools(mcpListTools: ResponseOutputItem.McpListTools) {
                    mcpListTools.validate()
                }
            }
        )
        validated = true
    }

    /** @see ResponseOutputItem.isValid */
    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (_: OpenAIInvalidDataException) {
            false
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredResponseOutputItem<*> &&
            responseType == other.responseType &&
            rawOutputItem == other.rawOutputItem
    }

    override fun hashCode(): Int = Objects.hash(responseType, rawOutputItem)

    override fun toString(): String =
        "${javaClass.simpleName}{responseType=$responseType, rawOutputItem=$rawOutputItem}"

    /** @see ResponseOutputItem.Visitor */
    // In keeping with the delegate's `Visitor<T>`, `T` is used to refer to the return type of each
    // function. `R` (for "Response") is used to refer to the response type, which is otherwise
    // named `T` in the outer class, but confusion here is probably preferable to confusion there.
    interface Visitor<R : Any, out T> {
        /** @see ResponseOutputItem.Visitor.visitMessage */
        fun visitMessage(message: StructuredResponseOutputMessage<R>): T

        /** @see ResponseOutputItem.Visitor.visitFileSearchCall */
        fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

        /** @see ResponseOutputItem.Visitor.visitFunctionCall */
        fun visitFunctionCall(functionCall: ResponseFunctionToolCall): T

        /** @see ResponseOutputItem.Visitor.visitWebSearchCall */
        fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

        /** @see ResponseOutputItem.Visitor.visitComputerCall */
        fun visitComputerCall(computerCall: ResponseComputerToolCall): T

        /** @see ResponseOutputItem.Visitor.visitReasoning */
        fun visitReasoning(reasoning: ResponseReasoningItem): T

        /** @see ResponseOutputItem.Visitor.visitCodeInterpreterCall */
        fun visitCodeInterpreterCall(codeInterpreterCall: ResponseCodeInterpreterToolCall): T

        /** @see ResponseOutputItem.Visitor.visitImageGenerationCall */
        fun visitImageGenerationCall(imageGenerationCall: ResponseOutputItem.ImageGenerationCall): T

        /** @see ResponseOutputItem.Visitor.visitLocalShellCall */
        fun visitLocalShellCall(localShellCall: ResponseOutputItem.LocalShellCall): T

        /** @see ResponseOutputItem.Visitor.visitMcpApprovalRequest */
        fun visitMcpApprovalRequest(mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest): T

        /** @see ResponseOutputItem.Visitor.visitMcpCall */
        fun visitMcpCall(mcpCall: ResponseOutputItem.McpCall): T

        /** @see ResponseOutputItem.Visitor.visitMcpListTools */
        fun visitMcpListTools(mcpListTools: ResponseOutputItem.McpListTools): T

        /** @see ResponseOutputItem.Visitor.unknown */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseOutputItem: $json")
        }
    }
}
