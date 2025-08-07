// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.Enum
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

/** An output message from the model. */
@JsonDeserialize(using = ResponseOutputItem.Deserializer::class)
@JsonSerialize(using = ResponseOutputItem.Serializer::class)
class ResponseOutputItem
private constructor(
    private val message: ResponseOutputMessage? = null,
    private val fileSearchCall: ResponseFileSearchToolCall? = null,
    private val functionCall: ResponseFunctionToolCall? = null,
    private val webSearchCall: ResponseFunctionWebSearch? = null,
    private val computerCall: ResponseComputerToolCall? = null,
    private val reasoning: ResponseReasoningItem? = null,
    private val imageGenerationCall: ImageGenerationCall? = null,
    private val codeInterpreterCall: ResponseCodeInterpreterToolCall? = null,
    private val localShellCall: LocalShellCall? = null,
    private val mcpCall: McpCall? = null,
    private val mcpListTools: McpListTools? = null,
    private val mcpApprovalRequest: McpApprovalRequest? = null,
    private val customToolCall: ResponseCustomToolCall? = null,
    private val _json: JsonValue? = null,
) {

    /** An output message from the model. */
    fun message(): Optional<ResponseOutputMessage> = Optional.ofNullable(message)

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun fileSearchCall(): Optional<ResponseFileSearchToolCall> = Optional.ofNullable(fileSearchCall)

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun functionCall(): Optional<ResponseFunctionToolCall> = Optional.ofNullable(functionCall)

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun webSearchCall(): Optional<ResponseFunctionWebSearch> = Optional.ofNullable(webSearchCall)

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun computerCall(): Optional<ResponseComputerToolCall> = Optional.ofNullable(computerCall)

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun reasoning(): Optional<ResponseReasoningItem> = Optional.ofNullable(reasoning)

    /** An image generation request made by the model. */
    fun imageGenerationCall(): Optional<ImageGenerationCall> =
        Optional.ofNullable(imageGenerationCall)

    /** A tool call to run code. */
    fun codeInterpreterCall(): Optional<ResponseCodeInterpreterToolCall> =
        Optional.ofNullable(codeInterpreterCall)

    /** A tool call to run a command on the local shell. */
    fun localShellCall(): Optional<LocalShellCall> = Optional.ofNullable(localShellCall)

    /** An invocation of a tool on an MCP server. */
    fun mcpCall(): Optional<McpCall> = Optional.ofNullable(mcpCall)

    /** A list of tools available on an MCP server. */
    fun mcpListTools(): Optional<McpListTools> = Optional.ofNullable(mcpListTools)

    /** A request for human approval of a tool invocation. */
    fun mcpApprovalRequest(): Optional<McpApprovalRequest> = Optional.ofNullable(mcpApprovalRequest)

    /** A call to a custom tool created by the model. */
    fun customToolCall(): Optional<ResponseCustomToolCall> = Optional.ofNullable(customToolCall)

    fun isMessage(): Boolean = message != null

    fun isFileSearchCall(): Boolean = fileSearchCall != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isComputerCall(): Boolean = computerCall != null

    fun isReasoning(): Boolean = reasoning != null

    fun isImageGenerationCall(): Boolean = imageGenerationCall != null

    fun isCodeInterpreterCall(): Boolean = codeInterpreterCall != null

    fun isLocalShellCall(): Boolean = localShellCall != null

    fun isMcpCall(): Boolean = mcpCall != null

    fun isMcpListTools(): Boolean = mcpListTools != null

    fun isMcpApprovalRequest(): Boolean = mcpApprovalRequest != null

    fun isCustomToolCall(): Boolean = customToolCall != null

    /** An output message from the model. */
    fun asMessage(): ResponseOutputMessage = message.getOrThrow("message")

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun asFileSearchCall(): ResponseFileSearchToolCall = fileSearchCall.getOrThrow("fileSearchCall")

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun asFunctionCall(): ResponseFunctionToolCall = functionCall.getOrThrow("functionCall")

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun asWebSearchCall(): ResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun asComputerCall(): ResponseComputerToolCall = computerCall.getOrThrow("computerCall")

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun asReasoning(): ResponseReasoningItem = reasoning.getOrThrow("reasoning")

    /** An image generation request made by the model. */
    fun asImageGenerationCall(): ImageGenerationCall =
        imageGenerationCall.getOrThrow("imageGenerationCall")

    /** A tool call to run code. */
    fun asCodeInterpreterCall(): ResponseCodeInterpreterToolCall =
        codeInterpreterCall.getOrThrow("codeInterpreterCall")

    /** A tool call to run a command on the local shell. */
    fun asLocalShellCall(): LocalShellCall = localShellCall.getOrThrow("localShellCall")

    /** An invocation of a tool on an MCP server. */
    fun asMcpCall(): McpCall = mcpCall.getOrThrow("mcpCall")

    /** A list of tools available on an MCP server. */
    fun asMcpListTools(): McpListTools = mcpListTools.getOrThrow("mcpListTools")

    /** A request for human approval of a tool invocation. */
    fun asMcpApprovalRequest(): McpApprovalRequest =
        mcpApprovalRequest.getOrThrow("mcpApprovalRequest")

    /** A call to a custom tool created by the model. */
    fun asCustomToolCall(): ResponseCustomToolCall = customToolCall.getOrThrow("customToolCall")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            message != null -> visitor.visitMessage(message)
            fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            computerCall != null -> visitor.visitComputerCall(computerCall)
            reasoning != null -> visitor.visitReasoning(reasoning)
            imageGenerationCall != null -> visitor.visitImageGenerationCall(imageGenerationCall)
            codeInterpreterCall != null -> visitor.visitCodeInterpreterCall(codeInterpreterCall)
            localShellCall != null -> visitor.visitLocalShellCall(localShellCall)
            mcpCall != null -> visitor.visitMcpCall(mcpCall)
            mcpListTools != null -> visitor.visitMcpListTools(mcpListTools)
            mcpApprovalRequest != null -> visitor.visitMcpApprovalRequest(mcpApprovalRequest)
            customToolCall != null -> visitor.visitCustomToolCall(customToolCall)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMessage(message: ResponseOutputMessage) {
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

                override fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall) {
                    imageGenerationCall.validate()
                }

                override fun visitCodeInterpreterCall(
                    codeInterpreterCall: ResponseCodeInterpreterToolCall
                ) {
                    codeInterpreterCall.validate()
                }

                override fun visitLocalShellCall(localShellCall: LocalShellCall) {
                    localShellCall.validate()
                }

                override fun visitMcpCall(mcpCall: McpCall) {
                    mcpCall.validate()
                }

                override fun visitMcpListTools(mcpListTools: McpListTools) {
                    mcpListTools.validate()
                }

                override fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) {
                    mcpApprovalRequest.validate()
                }

                override fun visitCustomToolCall(customToolCall: ResponseCustomToolCall) {
                    customToolCall.validate()
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
                override fun visitMessage(message: ResponseOutputMessage) = message.validity()

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
                    fileSearchCall.validity()

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) =
                    functionCall.validity()

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
                    webSearchCall.validity()

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) =
                    computerCall.validity()

                override fun visitReasoning(reasoning: ResponseReasoningItem) = reasoning.validity()

                override fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall) =
                    imageGenerationCall.validity()

                override fun visitCodeInterpreterCall(
                    codeInterpreterCall: ResponseCodeInterpreterToolCall
                ) = codeInterpreterCall.validity()

                override fun visitLocalShellCall(localShellCall: LocalShellCall) =
                    localShellCall.validity()

                override fun visitMcpCall(mcpCall: McpCall) = mcpCall.validity()

                override fun visitMcpListTools(mcpListTools: McpListTools) = mcpListTools.validity()

                override fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) =
                    mcpApprovalRequest.validity()

                override fun visitCustomToolCall(customToolCall: ResponseCustomToolCall) =
                    customToolCall.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputItem && message == other.message && fileSearchCall == other.fileSearchCall && functionCall == other.functionCall && webSearchCall == other.webSearchCall && computerCall == other.computerCall && reasoning == other.reasoning && imageGenerationCall == other.imageGenerationCall && codeInterpreterCall == other.codeInterpreterCall && localShellCall == other.localShellCall && mcpCall == other.mcpCall && mcpListTools == other.mcpListTools && mcpApprovalRequest == other.mcpApprovalRequest && customToolCall == other.customToolCall /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(message, fileSearchCall, functionCall, webSearchCall, computerCall, reasoning, imageGenerationCall, codeInterpreterCall, localShellCall, mcpCall, mcpListTools, mcpApprovalRequest, customToolCall) /* spotless:on */

    override fun toString(): String =
        when {
            message != null -> "ResponseOutputItem{message=$message}"
            fileSearchCall != null -> "ResponseOutputItem{fileSearchCall=$fileSearchCall}"
            functionCall != null -> "ResponseOutputItem{functionCall=$functionCall}"
            webSearchCall != null -> "ResponseOutputItem{webSearchCall=$webSearchCall}"
            computerCall != null -> "ResponseOutputItem{computerCall=$computerCall}"
            reasoning != null -> "ResponseOutputItem{reasoning=$reasoning}"
            imageGenerationCall != null ->
                "ResponseOutputItem{imageGenerationCall=$imageGenerationCall}"
            codeInterpreterCall != null ->
                "ResponseOutputItem{codeInterpreterCall=$codeInterpreterCall}"
            localShellCall != null -> "ResponseOutputItem{localShellCall=$localShellCall}"
            mcpCall != null -> "ResponseOutputItem{mcpCall=$mcpCall}"
            mcpListTools != null -> "ResponseOutputItem{mcpListTools=$mcpListTools}"
            mcpApprovalRequest != null ->
                "ResponseOutputItem{mcpApprovalRequest=$mcpApprovalRequest}"
            customToolCall != null -> "ResponseOutputItem{customToolCall=$customToolCall}"
            _json != null -> "ResponseOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseOutputItem")
        }

    companion object {

        /** An output message from the model. */
        @JvmStatic
        fun ofMessage(message: ResponseOutputMessage) = ResponseOutputItem(message = message)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        @JvmStatic
        fun ofFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
            ResponseOutputItem(fileSearchCall = fileSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        @JvmStatic
        fun ofFunctionCall(functionCall: ResponseFunctionToolCall) =
            ResponseOutputItem(functionCall = functionCall)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
            ResponseOutputItem(webSearchCall = webSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        @JvmStatic
        fun ofComputerCall(computerCall: ResponseComputerToolCall) =
            ResponseOutputItem(computerCall = computerCall)

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        @JvmStatic
        fun ofReasoning(reasoning: ResponseReasoningItem) =
            ResponseOutputItem(reasoning = reasoning)

        /** An image generation request made by the model. */
        @JvmStatic
        fun ofImageGenerationCall(imageGenerationCall: ImageGenerationCall) =
            ResponseOutputItem(imageGenerationCall = imageGenerationCall)

        /** A tool call to run code. */
        @JvmStatic
        fun ofCodeInterpreterCall(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            ResponseOutputItem(codeInterpreterCall = codeInterpreterCall)

        /** A tool call to run a command on the local shell. */
        @JvmStatic
        fun ofLocalShellCall(localShellCall: LocalShellCall) =
            ResponseOutputItem(localShellCall = localShellCall)

        /** An invocation of a tool on an MCP server. */
        @JvmStatic fun ofMcpCall(mcpCall: McpCall) = ResponseOutputItem(mcpCall = mcpCall)

        /** A list of tools available on an MCP server. */
        @JvmStatic
        fun ofMcpListTools(mcpListTools: McpListTools) =
            ResponseOutputItem(mcpListTools = mcpListTools)

        /** A request for human approval of a tool invocation. */
        @JvmStatic
        fun ofMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) =
            ResponseOutputItem(mcpApprovalRequest = mcpApprovalRequest)

        /** A call to a custom tool created by the model. */
        @JvmStatic
        fun ofCustomToolCall(customToolCall: ResponseCustomToolCall) =
            ResponseOutputItem(customToolCall = customToolCall)
    }

    /**
     * An interface that defines how to map each variant of [ResponseOutputItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** An output message from the model. */
        fun visitMessage(message: ResponseOutputMessage): T

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun visitFunctionCall(functionCall: ResponseFunctionToolCall): T

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun visitComputerCall(computerCall: ResponseComputerToolCall): T

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun visitReasoning(reasoning: ResponseReasoningItem): T

        /** An image generation request made by the model. */
        fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall): T

        /** A tool call to run code. */
        fun visitCodeInterpreterCall(codeInterpreterCall: ResponseCodeInterpreterToolCall): T

        /** A tool call to run a command on the local shell. */
        fun visitLocalShellCall(localShellCall: LocalShellCall): T

        /** An invocation of a tool on an MCP server. */
        fun visitMcpCall(mcpCall: McpCall): T

        /** A list of tools available on an MCP server. */
        fun visitMcpListTools(mcpListTools: McpListTools): T

        /** A request for human approval of a tool invocation. */
        fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest): T

        /** A call to a custom tool created by the model. */
        fun visitCustomToolCall(customToolCall: ResponseCustomToolCall): T

        /**
         * Maps an unknown variant of [ResponseOutputItem] to a value of type [T].
         *
         * An instance of [ResponseOutputItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseOutputItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputMessage>())?.let {
                        ResponseOutputItem(message = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "file_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFileSearchToolCall>())?.let {
                        ResponseOutputItem(fileSearchCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionToolCall>())?.let {
                        ResponseOutputItem(functionCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionWebSearch>())?.let {
                        ResponseOutputItem(webSearchCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "computer_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseComputerToolCall>())?.let {
                        ResponseOutputItem(computerCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "reasoning" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningItem>())?.let {
                        ResponseOutputItem(reasoning = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "image_generation_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageGenerationCall>())?.let {
                        ResponseOutputItem(imageGenerationCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "code_interpreter_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCodeInterpreterToolCall>())
                        ?.let { ResponseOutputItem(codeInterpreterCall = it, _json = json) }
                        ?: ResponseOutputItem(_json = json)
                }
                "local_shell_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<LocalShellCall>())?.let {
                        ResponseOutputItem(localShellCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "mcp_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpCall>())?.let {
                        ResponseOutputItem(mcpCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "mcp_list_tools" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpListTools>())?.let {
                        ResponseOutputItem(mcpListTools = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "mcp_approval_request" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpApprovalRequest>())?.let {
                        ResponseOutputItem(mcpApprovalRequest = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "custom_tool_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCustomToolCall>())?.let {
                        ResponseOutputItem(customToolCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
            }

            return ResponseOutputItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun serialize(
            value: ResponseOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.message != null -> generator.writeObject(value.message)
                value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.computerCall != null -> generator.writeObject(value.computerCall)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value.imageGenerationCall != null ->
                    generator.writeObject(value.imageGenerationCall)
                value.codeInterpreterCall != null ->
                    generator.writeObject(value.codeInterpreterCall)
                value.localShellCall != null -> generator.writeObject(value.localShellCall)
                value.mcpCall != null -> generator.writeObject(value.mcpCall)
                value.mcpListTools != null -> generator.writeObject(value.mcpListTools)
                value.mcpApprovalRequest != null -> generator.writeObject(value.mcpApprovalRequest)
                value.customToolCall != null -> generator.writeObject(value.customToolCall)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseOutputItem")
            }
        }
    }

    /** An image generation request made by the model. */
    class ImageGenerationCall
    private constructor(
        private val id: JsonField<String>,
        private val result: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, result, status, type, mutableMapOf())

        /**
         * The unique ID of the image generation call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The generated image encoded in base64.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun result(): Optional<String> = result.getOptional("result")

        /**
         * The status of the image generation call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The type of the image generation call. Always `image_generation_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("image_generation_call")
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
         * Returns the raw JSON value of [result].
         *
         * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [ImageGenerationCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .result()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ImageGenerationCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var result: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var type: JsonValue = JsonValue.from("image_generation_call")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGenerationCall: ImageGenerationCall) = apply {
                id = imageGenerationCall.id
                result = imageGenerationCall.result
                status = imageGenerationCall.status
                type = imageGenerationCall.type
                additionalProperties = imageGenerationCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the image generation call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The generated image encoded in base64. */
            fun result(result: String?) = result(JsonField.ofNullable(result))

            /** Alias for calling [Builder.result] with `result.orElse(null)`. */
            fun result(result: Optional<String>) = result(result.getOrNull())

            /**
             * Sets [Builder.result] to an arbitrary JSON value.
             *
             * You should usually call [Builder.result] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun result(result: JsonField<String>) = apply { this.result = result }

            /** The status of the image generation call. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("image_generation_call")
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
             * Returns an immutable instance of [ImageGenerationCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .result()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ImageGenerationCall =
                ImageGenerationCall(
                    checkRequired("id", id),
                    checkRequired("result", result),
                    checkRequired("status", status),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ImageGenerationCall = apply {
            if (validated) {
                return@apply
            }

            id()
            result()
            status().validate()
            _type().let {
                if (it != JsonValue.from("image_generation_call")) {
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
                (if (result.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("image_generation_call")) 1 else 0 }

        /** The status of the image generation call. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val GENERATING = of("generating")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                GENERATING,
                FAILED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                GENERATING,
                FAILED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    GENERATING -> Value.GENERATING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    GENERATING -> Known.GENERATING
                    FAILED -> Known.FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Status && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ImageGenerationCall && id == other.id && result == other.result && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, result, status, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageGenerationCall{id=$id, result=$result, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A tool call to run a command on the local shell. */
    class LocalShellCall
    private constructor(
        private val id: JsonField<String>,
        private val action: JsonField<Action>,
        private val callId: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, action, callId, status, type, mutableMapOf())

        /**
         * The unique ID of the local shell call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Execute a shell command on the server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun action(): Action = action.getRequired("action")

        /**
         * The unique ID of the local shell tool call generated by the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The status of the local shell call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The type of the local shell call. Always `local_shell_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("local_shell_call")
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
         * Returns the raw JSON value of [action].
         *
         * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [LocalShellCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LocalShellCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var action: JsonField<Action>? = null
            private var callId: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var type: JsonValue = JsonValue.from("local_shell_call")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(localShellCall: LocalShellCall) = apply {
                id = localShellCall.id
                action = localShellCall.action
                callId = localShellCall.callId
                status = localShellCall.status
                type = localShellCall.type
                additionalProperties = localShellCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the local shell call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Execute a shell command on the server. */
            fun action(action: Action) = action(JsonField.of(action))

            /**
             * Sets [Builder.action] to an arbitrary JSON value.
             *
             * You should usually call [Builder.action] with a well-typed [Action] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun action(action: JsonField<Action>) = apply { this.action = action }

            /** The unique ID of the local shell tool call generated by the model. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** The status of the local shell call. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("local_shell_call")
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
             * Returns an immutable instance of [LocalShellCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LocalShellCall =
                LocalShellCall(
                    checkRequired("id", id),
                    checkRequired("action", action),
                    checkRequired("callId", callId),
                    checkRequired("status", status),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): LocalShellCall = apply {
            if (validated) {
                return@apply
            }

            id()
            action().validate()
            callId()
            status().validate()
            _type().let {
                if (it != JsonValue.from("local_shell_call")) {
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
                (action.asKnown().getOrNull()?.validity() ?: 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("local_shell_call")) 1 else 0 }

        /** Execute a shell command on the server. */
        class Action
        private constructor(
            private val command: JsonField<List<String>>,
            private val env: JsonField<Env>,
            private val type: JsonValue,
            private val timeoutMs: JsonField<Long>,
            private val user: JsonField<String>,
            private val workingDirectory: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("command")
                @ExcludeMissing
                command: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("env") @ExcludeMissing env: JsonField<Env> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("timeout_ms")
                @ExcludeMissing
                timeoutMs: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
                @JsonProperty("working_directory")
                @ExcludeMissing
                workingDirectory: JsonField<String> = JsonMissing.of(),
            ) : this(command, env, type, timeoutMs, user, workingDirectory, mutableMapOf())

            /**
             * The command to run.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun command(): List<String> = command.getRequired("command")

            /**
             * Environment variables to set for the command.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun env(): Env = env.getRequired("env")

            /**
             * The type of the local shell action. Always `exec`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("exec")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Optional timeout in milliseconds for the command.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timeoutMs(): Optional<Long> = timeoutMs.getOptional("timeout_ms")

            /**
             * Optional user to run the command as.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun user(): Optional<String> = user.getOptional("user")

            /**
             * Optional working directory to run the command in.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun workingDirectory(): Optional<String> =
                workingDirectory.getOptional("working_directory")

            /**
             * Returns the raw JSON value of [command].
             *
             * Unlike [command], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("command")
            @ExcludeMissing
            fun _command(): JsonField<List<String>> = command

            /**
             * Returns the raw JSON value of [env].
             *
             * Unlike [env], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("env") @ExcludeMissing fun _env(): JsonField<Env> = env

            /**
             * Returns the raw JSON value of [timeoutMs].
             *
             * Unlike [timeoutMs], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timeout_ms")
            @ExcludeMissing
            fun _timeoutMs(): JsonField<Long> = timeoutMs

            /**
             * Returns the raw JSON value of [user].
             *
             * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

            /**
             * Returns the raw JSON value of [workingDirectory].
             *
             * Unlike [workingDirectory], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("working_directory")
            @ExcludeMissing
            fun _workingDirectory(): JsonField<String> = workingDirectory

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
                 * Returns a mutable builder for constructing an instance of [Action].
                 *
                 * The following fields are required:
                 * ```java
                 * .command()
                 * .env()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Action]. */
            class Builder internal constructor() {

                private var command: JsonField<MutableList<String>>? = null
                private var env: JsonField<Env>? = null
                private var type: JsonValue = JsonValue.from("exec")
                private var timeoutMs: JsonField<Long> = JsonMissing.of()
                private var user: JsonField<String> = JsonMissing.of()
                private var workingDirectory: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(action: Action) = apply {
                    command = action.command.map { it.toMutableList() }
                    env = action.env
                    type = action.type
                    timeoutMs = action.timeoutMs
                    user = action.user
                    workingDirectory = action.workingDirectory
                    additionalProperties = action.additionalProperties.toMutableMap()
                }

                /** The command to run. */
                fun command(command: List<String>) = command(JsonField.of(command))

                /**
                 * Sets [Builder.command] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.command] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun command(command: JsonField<List<String>>) = apply {
                    this.command = command.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.command].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCommand(command: String) = apply {
                    this.command =
                        (this.command ?: JsonField.of(mutableListOf())).also {
                            checkKnown("command", it).add(command)
                        }
                }

                /** Environment variables to set for the command. */
                fun env(env: Env) = env(JsonField.of(env))

                /**
                 * Sets [Builder.env] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.env] with a well-typed [Env] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun env(env: JsonField<Env>) = apply { this.env = env }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("exec")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** Optional timeout in milliseconds for the command. */
                fun timeoutMs(timeoutMs: Long?) = timeoutMs(JsonField.ofNullable(timeoutMs))

                /**
                 * Alias for [Builder.timeoutMs].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun timeoutMs(timeoutMs: Long) = timeoutMs(timeoutMs as Long?)

                /** Alias for calling [Builder.timeoutMs] with `timeoutMs.orElse(null)`. */
                fun timeoutMs(timeoutMs: Optional<Long>) = timeoutMs(timeoutMs.getOrNull())

                /**
                 * Sets [Builder.timeoutMs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timeoutMs] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timeoutMs(timeoutMs: JsonField<Long>) = apply { this.timeoutMs = timeoutMs }

                /** Optional user to run the command as. */
                fun user(user: String?) = user(JsonField.ofNullable(user))

                /** Alias for calling [Builder.user] with `user.orElse(null)`. */
                fun user(user: Optional<String>) = user(user.getOrNull())

                /**
                 * Sets [Builder.user] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.user] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun user(user: JsonField<String>) = apply { this.user = user }

                /** Optional working directory to run the command in. */
                fun workingDirectory(workingDirectory: String?) =
                    workingDirectory(JsonField.ofNullable(workingDirectory))

                /**
                 * Alias for calling [Builder.workingDirectory] with
                 * `workingDirectory.orElse(null)`.
                 */
                fun workingDirectory(workingDirectory: Optional<String>) =
                    workingDirectory(workingDirectory.getOrNull())

                /**
                 * Sets [Builder.workingDirectory] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workingDirectory] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun workingDirectory(workingDirectory: JsonField<String>) = apply {
                    this.workingDirectory = workingDirectory
                }

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
                 * Returns an immutable instance of [Action].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .command()
                 * .env()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Action =
                    Action(
                        checkRequired("command", command).map { it.toImmutable() },
                        checkRequired("env", env),
                        type,
                        timeoutMs,
                        user,
                        workingDirectory,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Action = apply {
                if (validated) {
                    return@apply
                }

                command()
                env().validate()
                _type().let {
                    if (it != JsonValue.from("exec")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                timeoutMs()
                user()
                workingDirectory()
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
                (command.asKnown().getOrNull()?.size ?: 0) +
                    (env.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("exec")) 1 else 0 } +
                    (if (timeoutMs.asKnown().isPresent) 1 else 0) +
                    (if (user.asKnown().isPresent) 1 else 0) +
                    (if (workingDirectory.asKnown().isPresent) 1 else 0)

            /** Environment variables to set for the command. */
            class Env
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Env]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Env]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(env: Env) = apply {
                        additionalProperties = env.additionalProperties.toMutableMap()
                    }

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
                     * Returns an immutable instance of [Env].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Env = Env(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Env = apply {
                    if (validated) {
                        return@apply
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Env && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Env{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Action && command == other.command && env == other.env && type == other.type && timeoutMs == other.timeoutMs && user == other.user && workingDirectory == other.workingDirectory && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(command, env, type, timeoutMs, user, workingDirectory, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Action{command=$command, env=$env, type=$type, timeoutMs=$timeoutMs, user=$user, workingDirectory=$workingDirectory, additionalProperties=$additionalProperties}"
        }

        /** The status of the local shell call. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Status && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is LocalShellCall && id == other.id && action == other.action && callId == other.callId && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, action, callId, status, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LocalShellCall{id=$id, action=$action, callId=$callId, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }

    /** An invocation of a tool on an MCP server. */
    class McpCall
    private constructor(
        private val id: JsonField<String>,
        private val arguments: JsonField<String>,
        private val name: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val type: JsonValue,
        private val error: JsonField<String>,
        private val output: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
        ) : this(id, arguments, name, serverLabel, type, error, output, mutableMapOf())

        /**
         * The unique ID of the tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A JSON string of the arguments passed to the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The name of the tool that was run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The label of the MCP server running the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The type of the item. Always `mcp_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The error from the tool call, if any.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * The output from the tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<String> = output.getOptional("output")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

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
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

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
             * Returns a mutable builder for constructing an instance of [McpCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_call")
            private var error: JsonField<String> = JsonMissing.of()
            private var output: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpCall: McpCall) = apply {
                id = mcpCall.id
                arguments = mcpCall.arguments
                name = mcpCall.name
                serverLabel = mcpCall.serverLabel
                type = mcpCall.type
                error = mcpCall.error
                output = mcpCall.output
                additionalProperties = mcpCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the tool call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A JSON string of the arguments passed to the tool. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the tool that was run. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The label of the MCP server running the tool. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The error from the tool call, if any. */
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

            /** The output from the tool call. */
            fun output(output: String?) = output(JsonField.ofNullable(output))

            /** Alias for calling [Builder.output] with `output.orElse(null)`. */
            fun output(output: Optional<String>) = output(output.getOrNull())

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<String>) = apply { this.output = output }

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
             * Returns an immutable instance of [McpCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpCall =
                McpCall(
                    checkRequired("id", id),
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
                    checkRequired("serverLabel", serverLabel),
                    type,
                    error,
                    output,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): McpCall = apply {
            if (validated) {
                return@apply
            }

            id()
            arguments()
            name()
            serverLabel()
            _type().let {
                if (it != JsonValue.from("mcp_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            error()
            output()
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
                (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_call")) 1 else 0 } +
                (if (error.asKnown().isPresent) 1 else 0) +
                (if (output.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is McpCall && id == other.id && arguments == other.arguments && name == other.name && serverLabel == other.serverLabel && type == other.type && error == other.error && output == other.output && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, arguments, name, serverLabel, type, error, output, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpCall{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, error=$error, output=$output, additionalProperties=$additionalProperties}"
    }

    /** A list of tools available on an MCP server. */
    class McpListTools
    private constructor(
        private val id: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val tools: JsonField<List<Tool>>,
        private val type: JsonValue,
        private val error: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        ) : this(id, serverLabel, tools, type, error, mutableMapOf())

        /**
         * The unique ID of the list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The label of the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The tools available on the server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tools(): List<Tool> = tools.getRequired("tools")

        /**
         * The type of the item. Always `mcp_list_tools`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_list_tools")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Error message if the server could not list tools.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

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
             * Returns a mutable builder for constructing an instance of [McpListTools].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .serverLabel()
             * .tools()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpListTools]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var tools: JsonField<MutableList<Tool>>? = null
            private var type: JsonValue = JsonValue.from("mcp_list_tools")
            private var error: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpListTools: McpListTools) = apply {
                id = mcpListTools.id
                serverLabel = mcpListTools.serverLabel
                tools = mcpListTools.tools.map { it.toMutableList() }
                type = mcpListTools.type
                error = mcpListTools.error
                additionalProperties = mcpListTools.additionalProperties.toMutableMap()
            }

            /** The unique ID of the list. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The label of the MCP server. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /** The tools available on the server. */
            fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<Tool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [Tool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: Tool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_list_tools")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Error message if the server could not list tools. */
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
             * Returns an immutable instance of [McpListTools].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .serverLabel()
             * .tools()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpListTools =
                McpListTools(
                    checkRequired("id", id),
                    checkRequired("serverLabel", serverLabel),
                    checkRequired("tools", tools).map { it.toImmutable() },
                    type,
                    error,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): McpListTools = apply {
            if (validated) {
                return@apply
            }

            id()
            serverLabel()
            tools().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("mcp_list_tools")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            error()
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
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("mcp_list_tools")) 1 else 0 } +
                (if (error.asKnown().isPresent) 1 else 0)

        /** A tool available on an MCP server. */
        class Tool
        private constructor(
            private val inputSchema: JsonValue,
            private val name: JsonField<String>,
            private val annotations: JsonValue,
            private val description: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input_schema")
                @ExcludeMissing
                inputSchema: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("annotations")
                @ExcludeMissing
                annotations: JsonValue = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
            ) : this(inputSchema, name, annotations, description, mutableMapOf())

            /** The JSON schema describing the tool's input. */
            @JsonProperty("input_schema")
            @ExcludeMissing
            fun _inputSchema(): JsonValue = inputSchema

            /**
             * The name of the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /** Additional annotations about the tool. */
            @JsonProperty("annotations") @ExcludeMissing fun _annotations(): JsonValue = annotations

            /**
             * The description of the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

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
                 * Returns a mutable builder for constructing an instance of [Tool].
                 *
                 * The following fields are required:
                 * ```java
                 * .inputSchema()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tool]. */
            class Builder internal constructor() {

                private var inputSchema: JsonValue? = null
                private var name: JsonField<String>? = null
                private var annotations: JsonValue = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tool: Tool) = apply {
                    inputSchema = tool.inputSchema
                    name = tool.name
                    annotations = tool.annotations
                    description = tool.description
                    additionalProperties = tool.additionalProperties.toMutableMap()
                }

                /** The JSON schema describing the tool's input. */
                fun inputSchema(inputSchema: JsonValue) = apply { this.inputSchema = inputSchema }

                /** The name of the tool. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Additional annotations about the tool. */
                fun annotations(annotations: JsonValue) = apply { this.annotations = annotations }

                /** The description of the tool. */
                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

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
                 * Returns an immutable instance of [Tool].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .inputSchema()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Tool =
                    Tool(
                        checkRequired("inputSchema", inputSchema),
                        checkRequired("name", name),
                        annotations,
                        description,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Tool = apply {
                if (validated) {
                    return@apply
                }

                name()
                description()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Tool && inputSchema == other.inputSchema && name == other.name && annotations == other.annotations && description == other.description && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(inputSchema, name, annotations, description, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Tool{inputSchema=$inputSchema, name=$name, annotations=$annotations, description=$description, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is McpListTools && id == other.id && serverLabel == other.serverLabel && tools == other.tools && type == other.type && error == other.error && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, serverLabel, tools, type, error, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpListTools{id=$id, serverLabel=$serverLabel, tools=$tools, type=$type, error=$error, additionalProperties=$additionalProperties}"
    }

    /** A request for human approval of a tool invocation. */
    class McpApprovalRequest
    private constructor(
        private val id: JsonField<String>,
        private val arguments: JsonField<String>,
        private val name: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, arguments, name, serverLabel, type, mutableMapOf())

        /**
         * The unique ID of the approval request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A JSON string of arguments for the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The name of the tool to run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The label of the MCP server making the request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The type of the item. Always `mcp_approval_request`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_approval_request")
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
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

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
             * Returns a mutable builder for constructing an instance of [McpApprovalRequest].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpApprovalRequest]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_approval_request")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpApprovalRequest: McpApprovalRequest) = apply {
                id = mcpApprovalRequest.id
                arguments = mcpApprovalRequest.arguments
                name = mcpApprovalRequest.name
                serverLabel = mcpApprovalRequest.serverLabel
                type = mcpApprovalRequest.type
                additionalProperties = mcpApprovalRequest.additionalProperties.toMutableMap()
            }

            /** The unique ID of the approval request. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A JSON string of arguments for the tool. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the tool to run. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The label of the MCP server making the request. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_approval_request")
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
             * Returns an immutable instance of [McpApprovalRequest].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpApprovalRequest =
                McpApprovalRequest(
                    checkRequired("id", id),
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
                    checkRequired("serverLabel", serverLabel),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): McpApprovalRequest = apply {
            if (validated) {
                return@apply
            }

            id()
            arguments()
            name()
            serverLabel()
            _type().let {
                if (it != JsonValue.from("mcp_approval_request")) {
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
                (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_approval_request")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is McpApprovalRequest && id == other.id && arguments == other.arguments && name == other.name && serverLabel == other.serverLabel && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, arguments, name, serverLabel, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpApprovalRequest{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, additionalProperties=$additionalProperties}"
    }
}
