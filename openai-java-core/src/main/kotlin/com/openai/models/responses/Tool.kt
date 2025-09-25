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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tool that can be used to generate a response. */
@JsonDeserialize(using = Tool.Deserializer::class)
@JsonSerialize(using = Tool.Serializer::class)
class Tool
private constructor(
    private val function: FunctionTool? = null,
    private val fileSearch: FileSearchTool? = null,
    private val computerUsePreview: ComputerTool? = null,
    private val webSearch: WebSearchTool? = null,
    private val mcp: Mcp? = null,
    private val codeInterpreter: CodeInterpreter? = null,
    private val imageGeneration: ImageGeneration? = null,
    private val localShell: JsonValue? = null,
    private val custom: CustomTool? = null,
    private val webSearchPreview: WebSearchPreviewTool? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Defines a function in your own code the model can choose to call. Learn more about
     * [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

    /**
     * A tool that searches for relevant content from uploaded files. Learn more about the
     * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
     */
    fun fileSearch(): Optional<FileSearchTool> = Optional.ofNullable(fileSearch)

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun computerUsePreview(): Optional<ComputerTool> = Optional.ofNullable(computerUsePreview)

    /**
     * Search the Internet for sources related to the prompt. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun webSearch(): Optional<WebSearchTool> = Optional.ofNullable(webSearch)

    /**
     * Give the model access to additional tools via remote Model Context Protocol (MCP) servers.
     * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
     */
    fun mcp(): Optional<Mcp> = Optional.ofNullable(mcp)

    /** A tool that runs Python code to help generate a response to a prompt. */
    fun codeInterpreter(): Optional<CodeInterpreter> = Optional.ofNullable(codeInterpreter)

    /** A tool that generates images using a model like `gpt-image-1`. */
    fun imageGeneration(): Optional<ImageGeneration> = Optional.ofNullable(imageGeneration)

    /** A tool that allows the model to execute shell commands in a local environment. */
    fun localShell(): Optional<JsonValue> = Optional.ofNullable(localShell)

    /**
     * A custom tool that processes input using a specified format. Learn more about
     * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools).
     */
    fun custom(): Optional<CustomTool> = Optional.ofNullable(custom)

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun webSearchPreview(): Optional<WebSearchPreviewTool> = Optional.ofNullable(webSearchPreview)

    fun isFunction(): Boolean = function != null

    fun isFileSearch(): Boolean = fileSearch != null

    fun isComputerUsePreview(): Boolean = computerUsePreview != null

    fun isWebSearch(): Boolean = webSearch != null

    fun isMcp(): Boolean = mcp != null

    fun isCodeInterpreter(): Boolean = codeInterpreter != null

    fun isImageGeneration(): Boolean = imageGeneration != null

    fun isLocalShell(): Boolean = localShell != null

    fun isCustom(): Boolean = custom != null

    fun isWebSearchPreview(): Boolean = webSearchPreview != null

    /**
     * Defines a function in your own code the model can choose to call. Learn more about
     * [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    fun asFunction(): FunctionTool = function.getOrThrow("function")

    /**
     * A tool that searches for relevant content from uploaded files. Learn more about the
     * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
     */
    fun asFileSearch(): FileSearchTool = fileSearch.getOrThrow("fileSearch")

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun asComputerUsePreview(): ComputerTool = computerUsePreview.getOrThrow("computerUsePreview")

    /**
     * Search the Internet for sources related to the prompt. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun asWebSearch(): WebSearchTool = webSearch.getOrThrow("webSearch")

    /**
     * Give the model access to additional tools via remote Model Context Protocol (MCP) servers.
     * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
     */
    fun asMcp(): Mcp = mcp.getOrThrow("mcp")

    /** A tool that runs Python code to help generate a response to a prompt. */
    fun asCodeInterpreter(): CodeInterpreter = codeInterpreter.getOrThrow("codeInterpreter")

    /** A tool that generates images using a model like `gpt-image-1`. */
    fun asImageGeneration(): ImageGeneration = imageGeneration.getOrThrow("imageGeneration")

    /** A tool that allows the model to execute shell commands in a local environment. */
    fun asLocalShell(): JsonValue = localShell.getOrThrow("localShell")

    /**
     * A custom tool that processes input using a specified format. Learn more about
     * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools).
     */
    fun asCustom(): CustomTool = custom.getOrThrow("custom")

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun asWebSearchPreview(): WebSearchPreviewTool = webSearchPreview.getOrThrow("webSearchPreview")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            function != null -> visitor.visitFunction(function)
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            computerUsePreview != null -> visitor.visitComputerUsePreview(computerUsePreview)
            webSearch != null -> visitor.visitWebSearch(webSearch)
            mcp != null -> visitor.visitMcp(mcp)
            codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
            imageGeneration != null -> visitor.visitImageGeneration(imageGeneration)
            localShell != null -> visitor.visitLocalShell(localShell)
            custom != null -> visitor.visitCustom(custom)
            webSearchPreview != null -> visitor.visitWebSearchPreview(webSearchPreview)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Tool = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFunction(function: FunctionTool) {
                    function.validate()
                }

                override fun visitFileSearch(fileSearch: FileSearchTool) {
                    fileSearch.validate()
                }

                override fun visitComputerUsePreview(computerUsePreview: ComputerTool) {
                    computerUsePreview.validate()
                }

                override fun visitWebSearch(webSearch: WebSearchTool) {
                    webSearch.validate()
                }

                override fun visitMcp(mcp: Mcp) {
                    mcp.validate()
                }

                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreter) {
                    codeInterpreter.validate()
                }

                override fun visitImageGeneration(imageGeneration: ImageGeneration) {
                    imageGeneration.validate()
                }

                override fun visitLocalShell(localShell: JsonValue) {
                    localShell.let {
                        if (it != JsonValue.from(mapOf("type" to "local_shell"))) {
                            throw OpenAIInvalidDataException(
                                "'localShell' is invalid, received $it"
                            )
                        }
                    }
                }

                override fun visitCustom(custom: CustomTool) {
                    custom.validate()
                }

                override fun visitWebSearchPreview(webSearchPreview: WebSearchPreviewTool) {
                    webSearchPreview.validate()
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
                override fun visitFunction(function: FunctionTool) = function.validity()

                override fun visitFileSearch(fileSearch: FileSearchTool) = fileSearch.validity()

                override fun visitComputerUsePreview(computerUsePreview: ComputerTool) =
                    computerUsePreview.validity()

                override fun visitWebSearch(webSearch: WebSearchTool) = webSearch.validity()

                override fun visitMcp(mcp: Mcp) = mcp.validity()

                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreter) =
                    codeInterpreter.validity()

                override fun visitImageGeneration(imageGeneration: ImageGeneration) =
                    imageGeneration.validity()

                override fun visitLocalShell(localShell: JsonValue) =
                    localShell.let {
                        if (it == JsonValue.from(mapOf("type" to "local_shell"))) 1 else 0
                    }

                override fun visitCustom(custom: CustomTool) = custom.validity()

                override fun visitWebSearchPreview(webSearchPreview: WebSearchPreviewTool) =
                    webSearchPreview.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Tool &&
            function == other.function &&
            fileSearch == other.fileSearch &&
            computerUsePreview == other.computerUsePreview &&
            webSearch == other.webSearch &&
            mcp == other.mcp &&
            codeInterpreter == other.codeInterpreter &&
            imageGeneration == other.imageGeneration &&
            localShell == other.localShell &&
            custom == other.custom &&
            webSearchPreview == other.webSearchPreview
    }

    override fun hashCode(): Int =
        Objects.hash(
            function,
            fileSearch,
            computerUsePreview,
            webSearch,
            mcp,
            codeInterpreter,
            imageGeneration,
            localShell,
            custom,
            webSearchPreview,
        )

    override fun toString(): String =
        when {
            function != null -> "Tool{function=$function}"
            fileSearch != null -> "Tool{fileSearch=$fileSearch}"
            computerUsePreview != null -> "Tool{computerUsePreview=$computerUsePreview}"
            webSearch != null -> "Tool{webSearch=$webSearch}"
            mcp != null -> "Tool{mcp=$mcp}"
            codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
            imageGeneration != null -> "Tool{imageGeneration=$imageGeneration}"
            localShell != null -> "Tool{localShell=$localShell}"
            custom != null -> "Tool{custom=$custom}"
            webSearchPreview != null -> "Tool{webSearchPreview=$webSearchPreview}"
            _json != null -> "Tool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Tool")
        }

    companion object {

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        @JvmStatic fun ofFunction(function: FunctionTool) = Tool(function = function)

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        @JvmStatic fun ofFileSearch(fileSearch: FileSearchTool) = Tool(fileSearch = fileSearch)

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        @JvmStatic
        fun ofComputerUsePreview(computerUsePreview: ComputerTool) =
            Tool(computerUsePreview = computerUsePreview)

        /**
         * Search the Internet for sources related to the prompt. Learn more about the
         * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        @JvmStatic fun ofWebSearch(webSearch: WebSearchTool) = Tool(webSearch = webSearch)

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        @JvmStatic fun ofMcp(mcp: Mcp) = Tool(mcp = mcp)

        /** A tool that runs Python code to help generate a response to a prompt. */
        @JvmStatic
        fun ofCodeInterpreter(codeInterpreter: CodeInterpreter) =
            Tool(codeInterpreter = codeInterpreter)

        /** A tool that generates images using a model like `gpt-image-1`. */
        @JvmStatic
        fun ofImageGeneration(imageGeneration: ImageGeneration) =
            Tool(imageGeneration = imageGeneration)

        /** A tool that allows the model to execute shell commands in a local environment. */
        @JvmStatic
        fun ofLocalShell() = Tool(localShell = JsonValue.from(mapOf("type" to "local_shell")))

        /**
         * A custom tool that processes input using a specified format. Learn more about
         * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools).
         */
        @JvmStatic fun ofCustom(custom: CustomTool) = Tool(custom = custom)

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        @JvmStatic
        fun ofWebSearchPreview(webSearchPreview: WebSearchPreviewTool) =
            Tool(webSearchPreview = webSearchPreview)
    }

    /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
    interface Visitor<out T> {

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun visitFunction(function: FunctionTool): T

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun visitFileSearch(fileSearch: FileSearchTool): T

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        fun visitComputerUsePreview(computerUsePreview: ComputerTool): T

        /**
         * Search the Internet for sources related to the prompt. Learn more about the
         * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun visitWebSearch(webSearch: WebSearchTool): T

        /**
         * Give the model access to additional tools via remote Model Context Protocol (MCP)
         * servers.
         * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
         */
        fun visitMcp(mcp: Mcp): T

        /** A tool that runs Python code to help generate a response to a prompt. */
        fun visitCodeInterpreter(codeInterpreter: CodeInterpreter): T

        /** A tool that generates images using a model like `gpt-image-1`. */
        fun visitImageGeneration(imageGeneration: ImageGeneration): T

        /** A tool that allows the model to execute shell commands in a local environment. */
        fun visitLocalShell(localShell: JsonValue): T

        /**
         * A custom tool that processes input using a specified format. Learn more about
         * [custom tools](https://platform.openai.com/docs/guides/function-calling#custom-tools).
         */
        fun visitCustom(custom: CustomTool): T

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun visitWebSearchPreview(webSearchPreview: WebSearchPreviewTool): T

        /**
         * Maps an unknown variant of [Tool] to a value of type [T].
         *
         * An instance of [Tool] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown Tool: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Tool {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionTool>())?.let {
                        Tool(function = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "file_search" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileSearchTool>())?.let {
                        Tool(fileSearch = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "computer_use_preview" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerTool>())?.let {
                        Tool(computerUsePreview = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "mcp" -> {
                    return tryDeserialize(node, jacksonTypeRef<Mcp>())?.let {
                        Tool(mcp = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "code_interpreter" -> {
                    return tryDeserialize(node, jacksonTypeRef<CodeInterpreter>())?.let {
                        Tool(codeInterpreter = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "image_generation" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageGeneration>())?.let {
                        Tool(imageGeneration = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "local_shell" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { Tool(localShell = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: Tool(_json = json)
                }
                "custom" -> {
                    return tryDeserialize(node, jacksonTypeRef<CustomTool>())?.let {
                        Tool(custom = it, _json = json)
                    } ?: Tool(_json = json)
                }
            }

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<WebSearchTool>())?.let {
                            Tool(webSearch = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<WebSearchPreviewTool>())?.let {
                            Tool(webSearchPreview = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Tool(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Tool>(Tool::class) {

        override fun serialize(
            value: Tool,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.function != null -> generator.writeObject(value.function)
                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                value.computerUsePreview != null -> generator.writeObject(value.computerUsePreview)
                value.webSearch != null -> generator.writeObject(value.webSearch)
                value.mcp != null -> generator.writeObject(value.mcp)
                value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                value.imageGeneration != null -> generator.writeObject(value.imageGeneration)
                value.localShell != null -> generator.writeObject(value.localShell)
                value.custom != null -> generator.writeObject(value.custom)
                value.webSearchPreview != null -> generator.writeObject(value.webSearchPreview)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Tool")
            }
        }
    }

    /**
     * Give the model access to additional tools via remote Model Context Protocol (MCP) servers.
     * [Learn more about MCP](https://platform.openai.com/docs/guides/tools-remote-mcp).
     */
    class Mcp
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val serverLabel: JsonField<String>,
        private val type: JsonValue,
        private val allowedTools: JsonField<AllowedTools>,
        private val authorization: JsonField<String>,
        private val connectorId: JsonField<ConnectorId>,
        private val headers: JsonField<Headers>,
        private val requireApproval: JsonField<RequireApproval>,
        private val serverDescription: JsonField<String>,
        private val serverUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("allowed_tools")
            @ExcludeMissing
            allowedTools: JsonField<AllowedTools> = JsonMissing.of(),
            @JsonProperty("authorization")
            @ExcludeMissing
            authorization: JsonField<String> = JsonMissing.of(),
            @JsonProperty("connector_id")
            @ExcludeMissing
            connectorId: JsonField<ConnectorId> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("require_approval")
            @ExcludeMissing
            requireApproval: JsonField<RequireApproval> = JsonMissing.of(),
            @JsonProperty("server_description")
            @ExcludeMissing
            serverDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_url")
            @ExcludeMissing
            serverUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            serverLabel,
            type,
            allowedTools,
            authorization,
            connectorId,
            headers,
            requireApproval,
            serverDescription,
            serverUrl,
            mutableMapOf(),
        )

        /**
         * A label for this MCP server, used to identify it in tool calls.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The type of the MCP tool. Always `mcp`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * List of allowed tool names or a filter object.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedTools(): Optional<AllowedTools> = allowedTools.getOptional("allowed_tools")

        /**
         * An OAuth access token that can be used with a remote MCP server, either with a custom MCP
         * server URL or a service connector. Your application must handle the OAuth authorization
         * flow and provide the token here.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun authorization(): Optional<String> = authorization.getOptional("authorization")

        /**
         * Identifier for service connectors, like those available in ChatGPT. One of `server_url`
         * or `connector_id` must be provided. Learn more about service connectors
         * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
         *
         * Currently supported `connector_id` values are:
         * - Dropbox: `connector_dropbox`
         * - Gmail: `connector_gmail`
         * - Google Calendar: `connector_googlecalendar`
         * - Google Drive: `connector_googledrive`
         * - Microsoft Teams: `connector_microsoftteams`
         * - Outlook Calendar: `connector_outlookcalendar`
         * - Outlook Email: `connector_outlookemail`
         * - SharePoint: `connector_sharepoint`
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun connectorId(): Optional<ConnectorId> = connectorId.getOptional("connector_id")

        /**
         * Optional HTTP headers to send to the MCP server. Use for authentication or other
         * purposes.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * Specify which of the MCP server's tools require approval.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun requireApproval(): Optional<RequireApproval> =
            requireApproval.getOptional("require_approval")

        /**
         * Optional description of the MCP server, used to provide more context.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serverDescription(): Optional<String> =
            serverDescription.getOptional("server_description")

        /**
         * The URL for the MCP server. One of `server_url` or `connector_id` must be provided.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serverUrl(): Optional<String> = serverUrl.getOptional("server_url")

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [allowedTools].
         *
         * Unlike [allowedTools], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_tools")
        @ExcludeMissing
        fun _allowedTools(): JsonField<AllowedTools> = allowedTools

        /**
         * Returns the raw JSON value of [authorization].
         *
         * Unlike [authorization], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("authorization")
        @ExcludeMissing
        fun _authorization(): JsonField<String> = authorization

        /**
         * Returns the raw JSON value of [connectorId].
         *
         * Unlike [connectorId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("connector_id")
        @ExcludeMissing
        fun _connectorId(): JsonField<ConnectorId> = connectorId

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

        /**
         * Returns the raw JSON value of [requireApproval].
         *
         * Unlike [requireApproval], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("require_approval")
        @ExcludeMissing
        fun _requireApproval(): JsonField<RequireApproval> = requireApproval

        /**
         * Returns the raw JSON value of [serverDescription].
         *
         * Unlike [serverDescription], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("server_description")
        @ExcludeMissing
        fun _serverDescription(): JsonField<String> = serverDescription

        /**
         * Returns the raw JSON value of [serverUrl].
         *
         * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_url") @ExcludeMissing fun _serverUrl(): JsonField<String> = serverUrl

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
             * Returns a mutable builder for constructing an instance of [Mcp].
             *
             * The following fields are required:
             * ```java
             * .serverLabel()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Mcp]. */
        class Builder internal constructor() {

            private var serverLabel: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp")
            private var allowedTools: JsonField<AllowedTools> = JsonMissing.of()
            private var authorization: JsonField<String> = JsonMissing.of()
            private var connectorId: JsonField<ConnectorId> = JsonMissing.of()
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var requireApproval: JsonField<RequireApproval> = JsonMissing.of()
            private var serverDescription: JsonField<String> = JsonMissing.of()
            private var serverUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcp: Mcp) = apply {
                serverLabel = mcp.serverLabel
                type = mcp.type
                allowedTools = mcp.allowedTools
                authorization = mcp.authorization
                connectorId = mcp.connectorId
                headers = mcp.headers
                requireApproval = mcp.requireApproval
                serverDescription = mcp.serverDescription
                serverUrl = mcp.serverUrl
                additionalProperties = mcp.additionalProperties.toMutableMap()
            }

            /** A label for this MCP server, used to identify it in tool calls. */
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
             * JsonValue.from("mcp")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** List of allowed tool names or a filter object. */
            fun allowedTools(allowedTools: AllowedTools?) =
                allowedTools(JsonField.ofNullable(allowedTools))

            /** Alias for calling [Builder.allowedTools] with `allowedTools.orElse(null)`. */
            fun allowedTools(allowedTools: Optional<AllowedTools>) =
                allowedTools(allowedTools.getOrNull())

            /**
             * Sets [Builder.allowedTools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedTools] with a well-typed [AllowedTools] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedTools(allowedTools: JsonField<AllowedTools>) = apply {
                this.allowedTools = allowedTools
            }

            /** Alias for calling [allowedTools] with `AllowedTools.ofMcp(mcp)`. */
            fun allowedToolsOfMcp(mcp: List<String>) = allowedTools(AllowedTools.ofMcp(mcp))

            /**
             * Alias for calling [allowedTools] with `AllowedTools.ofMcpToolFilter(mcpToolFilter)`.
             */
            fun allowedTools(mcpToolFilter: AllowedTools.McpToolFilter) =
                allowedTools(AllowedTools.ofMcpToolFilter(mcpToolFilter))

            /**
             * An OAuth access token that can be used with a remote MCP server, either with a custom
             * MCP server URL or a service connector. Your application must handle the OAuth
             * authorization flow and provide the token here.
             */
            fun authorization(authorization: String) = authorization(JsonField.of(authorization))

            /**
             * Sets [Builder.authorization] to an arbitrary JSON value.
             *
             * You should usually call [Builder.authorization] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun authorization(authorization: JsonField<String>) = apply {
                this.authorization = authorization
            }

            /**
             * Identifier for service connectors, like those available in ChatGPT. One of
             * `server_url` or `connector_id` must be provided. Learn more about service connectors
             * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
             *
             * Currently supported `connector_id` values are:
             * - Dropbox: `connector_dropbox`
             * - Gmail: `connector_gmail`
             * - Google Calendar: `connector_googlecalendar`
             * - Google Drive: `connector_googledrive`
             * - Microsoft Teams: `connector_microsoftteams`
             * - Outlook Calendar: `connector_outlookcalendar`
             * - Outlook Email: `connector_outlookemail`
             * - SharePoint: `connector_sharepoint`
             */
            fun connectorId(connectorId: ConnectorId) = connectorId(JsonField.of(connectorId))

            /**
             * Sets [Builder.connectorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.connectorId] with a well-typed [ConnectorId] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun connectorId(connectorId: JsonField<ConnectorId>) = apply {
                this.connectorId = connectorId
            }

            /**
             * Optional HTTP headers to send to the MCP server. Use for authentication or other
             * purposes.
             */
            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** Specify which of the MCP server's tools require approval. */
            fun requireApproval(requireApproval: RequireApproval?) =
                requireApproval(JsonField.ofNullable(requireApproval))

            /** Alias for calling [Builder.requireApproval] with `requireApproval.orElse(null)`. */
            fun requireApproval(requireApproval: Optional<RequireApproval>) =
                requireApproval(requireApproval.getOrNull())

            /**
             * Sets [Builder.requireApproval] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requireApproval] with a well-typed [RequireApproval]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requireApproval(requireApproval: JsonField<RequireApproval>) = apply {
                this.requireApproval = requireApproval
            }

            /**
             * Alias for calling [requireApproval] with
             * `RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter)`.
             */
            fun requireApproval(mcpToolApprovalFilter: RequireApproval.McpToolApprovalFilter) =
                requireApproval(RequireApproval.ofMcpToolApprovalFilter(mcpToolApprovalFilter))

            /**
             * Alias for calling [requireApproval] with
             * `RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting)`.
             */
            fun requireApproval(mcpToolApprovalSetting: RequireApproval.McpToolApprovalSetting) =
                requireApproval(RequireApproval.ofMcpToolApprovalSetting(mcpToolApprovalSetting))

            /** Optional description of the MCP server, used to provide more context. */
            fun serverDescription(serverDescription: String) =
                serverDescription(JsonField.of(serverDescription))

            /**
             * Sets [Builder.serverDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverDescription] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverDescription(serverDescription: JsonField<String>) = apply {
                this.serverDescription = serverDescription
            }

            /**
             * The URL for the MCP server. One of `server_url` or `connector_id` must be provided.
             */
            fun serverUrl(serverUrl: String) = serverUrl(JsonField.of(serverUrl))

            /**
             * Sets [Builder.serverUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverUrl(serverUrl: JsonField<String>) = apply { this.serverUrl = serverUrl }

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
             * Returns an immutable instance of [Mcp].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .serverLabel()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Mcp =
                Mcp(
                    checkRequired("serverLabel", serverLabel),
                    type,
                    allowedTools,
                    authorization,
                    connectorId,
                    headers,
                    requireApproval,
                    serverDescription,
                    serverUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Mcp = apply {
            if (validated) {
                return@apply
            }

            serverLabel()
            _type().let {
                if (it != JsonValue.from("mcp")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            allowedTools().ifPresent { it.validate() }
            authorization()
            connectorId().ifPresent { it.validate() }
            headers().ifPresent { it.validate() }
            requireApproval().ifPresent { it.validate() }
            serverDescription()
            serverUrl()
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
            (if (serverLabel.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp")) 1 else 0 } +
                (allowedTools.asKnown().getOrNull()?.validity() ?: 0) +
                (if (authorization.asKnown().isPresent) 1 else 0) +
                (connectorId.asKnown().getOrNull()?.validity() ?: 0) +
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (requireApproval.asKnown().getOrNull()?.validity() ?: 0) +
                (if (serverDescription.asKnown().isPresent) 1 else 0) +
                (if (serverUrl.asKnown().isPresent) 1 else 0)

        /** List of allowed tool names or a filter object. */
        @JsonDeserialize(using = AllowedTools.Deserializer::class)
        @JsonSerialize(using = AllowedTools.Serializer::class)
        class AllowedTools
        private constructor(
            private val mcp: List<String>? = null,
            private val mcpToolFilter: McpToolFilter? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A string array of allowed tool names */
            fun mcp(): Optional<List<String>> = Optional.ofNullable(mcp)

            /** A filter object to specify which tools are allowed. */
            fun mcpToolFilter(): Optional<McpToolFilter> = Optional.ofNullable(mcpToolFilter)

            fun isMcp(): Boolean = mcp != null

            fun isMcpToolFilter(): Boolean = mcpToolFilter != null

            /** A string array of allowed tool names */
            fun asMcp(): List<String> = mcp.getOrThrow("mcp")

            /** A filter object to specify which tools are allowed. */
            fun asMcpToolFilter(): McpToolFilter = mcpToolFilter.getOrThrow("mcpToolFilter")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    mcp != null -> visitor.visitMcp(mcp)
                    mcpToolFilter != null -> visitor.visitMcpToolFilter(mcpToolFilter)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): AllowedTools = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitMcp(mcp: List<String>) {}

                        override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) {
                            mcpToolFilter.validate()
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
                        override fun visitMcp(mcp: List<String>) = mcp.size

                        override fun visitMcpToolFilter(mcpToolFilter: McpToolFilter) =
                            mcpToolFilter.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AllowedTools &&
                    mcp == other.mcp &&
                    mcpToolFilter == other.mcpToolFilter
            }

            override fun hashCode(): Int = Objects.hash(mcp, mcpToolFilter)

            override fun toString(): String =
                when {
                    mcp != null -> "AllowedTools{mcp=$mcp}"
                    mcpToolFilter != null -> "AllowedTools{mcpToolFilter=$mcpToolFilter}"
                    _json != null -> "AllowedTools{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid AllowedTools")
                }

            companion object {

                /** A string array of allowed tool names */
                @JvmStatic fun ofMcp(mcp: List<String>) = AllowedTools(mcp = mcp.toImmutable())

                /** A filter object to specify which tools are allowed. */
                @JvmStatic
                fun ofMcpToolFilter(mcpToolFilter: McpToolFilter) =
                    AllowedTools(mcpToolFilter = mcpToolFilter)
            }

            /**
             * An interface that defines how to map each variant of [AllowedTools] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                /** A string array of allowed tool names */
                fun visitMcp(mcp: List<String>): T

                /** A filter object to specify which tools are allowed. */
                fun visitMcpToolFilter(mcpToolFilter: McpToolFilter): T

                /**
                 * Maps an unknown variant of [AllowedTools] to a value of type [T].
                 *
                 * An instance of [AllowedTools] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown AllowedTools: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<AllowedTools>(AllowedTools::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): AllowedTools {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<McpToolFilter>())?.let {
                                    AllowedTools(mcpToolFilter = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    AllowedTools(mcp = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> AllowedTools(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<AllowedTools>(AllowedTools::class) {

                override fun serialize(
                    value: AllowedTools,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.mcp != null -> generator.writeObject(value.mcp)
                        value.mcpToolFilter != null -> generator.writeObject(value.mcpToolFilter)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid AllowedTools")
                    }
                }
            }

            /** A filter object to specify which tools are allowed. */
            class McpToolFilter
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val readOnly: JsonField<Boolean>,
                private val toolNames: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    readOnly: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    toolNames: JsonField<List<String>> = JsonMissing.of(),
                ) : this(readOnly, toolNames, mutableMapOf())

                /**
                 * Indicates whether or not a tool modifies data or is read-only. If an MCP server
                 * is
                 * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                 * it will match this filter.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                /**
                 * List of allowed tool names.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                /**
                 * Returns the raw JSON value of [readOnly].
                 *
                 * Unlike [readOnly], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("read_only")
                @ExcludeMissing
                fun _readOnly(): JsonField<Boolean> = readOnly

                /**
                 * Returns the raw JSON value of [toolNames].
                 *
                 * Unlike [toolNames], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tool_names")
                @ExcludeMissing
                fun _toolNames(): JsonField<List<String>> = toolNames

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
                     * Returns a mutable builder for constructing an instance of [McpToolFilter].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [McpToolFilter]. */
                class Builder internal constructor() {

                    private var readOnly: JsonField<Boolean> = JsonMissing.of()
                    private var toolNames: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(mcpToolFilter: McpToolFilter) = apply {
                        readOnly = mcpToolFilter.readOnly
                        toolNames = mcpToolFilter.toolNames.map { it.toMutableList() }
                        additionalProperties = mcpToolFilter.additionalProperties.toMutableMap()
                    }

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     */
                    fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                    /**
                     * Sets [Builder.readOnly] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.readOnly] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun readOnly(readOnly: JsonField<Boolean>) = apply { this.readOnly = readOnly }

                    /** List of allowed tool names. */
                    fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                    /**
                     * Sets [Builder.toolNames] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.toolNames] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun toolNames(toolNames: JsonField<List<String>>) = apply {
                        this.toolNames = toolNames.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [toolNames].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addToolName(toolName: String) = apply {
                        toolNames =
                            (toolNames ?: JsonField.of(mutableListOf())).also {
                                checkKnown("toolNames", it).add(toolName)
                            }
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
                     * Returns an immutable instance of [McpToolFilter].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): McpToolFilter =
                        McpToolFilter(
                            readOnly,
                            (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): McpToolFilter = apply {
                    if (validated) {
                        return@apply
                    }

                    readOnly()
                    toolNames()
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
                    (if (readOnly.asKnown().isPresent) 1 else 0) +
                        (toolNames.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is McpToolFilter &&
                        readOnly == other.readOnly &&
                        toolNames == other.toolNames &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(readOnly, toolNames, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "McpToolFilter{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
            }
        }

        /**
         * Identifier for service connectors, like those available in ChatGPT. One of `server_url`
         * or `connector_id` must be provided. Learn more about service connectors
         * [here](https://platform.openai.com/docs/guides/tools-remote-mcp#connectors).
         *
         * Currently supported `connector_id` values are:
         * - Dropbox: `connector_dropbox`
         * - Gmail: `connector_gmail`
         * - Google Calendar: `connector_googlecalendar`
         * - Google Drive: `connector_googledrive`
         * - Microsoft Teams: `connector_microsoftteams`
         * - Outlook Calendar: `connector_outlookcalendar`
         * - Outlook Email: `connector_outlookemail`
         * - SharePoint: `connector_sharepoint`
         */
        class ConnectorId @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val CONNECTOR_DROPBOX = of("connector_dropbox")

                @JvmField val CONNECTOR_GMAIL = of("connector_gmail")

                @JvmField val CONNECTOR_GOOGLECALENDAR = of("connector_googlecalendar")

                @JvmField val CONNECTOR_GOOGLEDRIVE = of("connector_googledrive")

                @JvmField val CONNECTOR_MICROSOFTTEAMS = of("connector_microsoftteams")

                @JvmField val CONNECTOR_OUTLOOKCALENDAR = of("connector_outlookcalendar")

                @JvmField val CONNECTOR_OUTLOOKEMAIL = of("connector_outlookemail")

                @JvmField val CONNECTOR_SHAREPOINT = of("connector_sharepoint")

                @JvmStatic fun of(value: String) = ConnectorId(JsonField.of(value))
            }

            /** An enum containing [ConnectorId]'s known values. */
            enum class Known {
                CONNECTOR_DROPBOX,
                CONNECTOR_GMAIL,
                CONNECTOR_GOOGLECALENDAR,
                CONNECTOR_GOOGLEDRIVE,
                CONNECTOR_MICROSOFTTEAMS,
                CONNECTOR_OUTLOOKCALENDAR,
                CONNECTOR_OUTLOOKEMAIL,
                CONNECTOR_SHAREPOINT,
            }

            /**
             * An enum containing [ConnectorId]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ConnectorId] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CONNECTOR_DROPBOX,
                CONNECTOR_GMAIL,
                CONNECTOR_GOOGLECALENDAR,
                CONNECTOR_GOOGLEDRIVE,
                CONNECTOR_MICROSOFTTEAMS,
                CONNECTOR_OUTLOOKCALENDAR,
                CONNECTOR_OUTLOOKEMAIL,
                CONNECTOR_SHAREPOINT,
                /**
                 * An enum member indicating that [ConnectorId] was instantiated with an unknown
                 * value.
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
                    CONNECTOR_DROPBOX -> Value.CONNECTOR_DROPBOX
                    CONNECTOR_GMAIL -> Value.CONNECTOR_GMAIL
                    CONNECTOR_GOOGLECALENDAR -> Value.CONNECTOR_GOOGLECALENDAR
                    CONNECTOR_GOOGLEDRIVE -> Value.CONNECTOR_GOOGLEDRIVE
                    CONNECTOR_MICROSOFTTEAMS -> Value.CONNECTOR_MICROSOFTTEAMS
                    CONNECTOR_OUTLOOKCALENDAR -> Value.CONNECTOR_OUTLOOKCALENDAR
                    CONNECTOR_OUTLOOKEMAIL -> Value.CONNECTOR_OUTLOOKEMAIL
                    CONNECTOR_SHAREPOINT -> Value.CONNECTOR_SHAREPOINT
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
                    CONNECTOR_DROPBOX -> Known.CONNECTOR_DROPBOX
                    CONNECTOR_GMAIL -> Known.CONNECTOR_GMAIL
                    CONNECTOR_GOOGLECALENDAR -> Known.CONNECTOR_GOOGLECALENDAR
                    CONNECTOR_GOOGLEDRIVE -> Known.CONNECTOR_GOOGLEDRIVE
                    CONNECTOR_MICROSOFTTEAMS -> Known.CONNECTOR_MICROSOFTTEAMS
                    CONNECTOR_OUTLOOKCALENDAR -> Known.CONNECTOR_OUTLOOKCALENDAR
                    CONNECTOR_OUTLOOKEMAIL -> Known.CONNECTOR_OUTLOOKEMAIL
                    CONNECTOR_SHAREPOINT -> Known.CONNECTOR_SHAREPOINT
                    else -> throw OpenAIInvalidDataException("Unknown ConnectorId: $value")
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

            fun validate(): ConnectorId = apply {
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

                return other is ConnectorId && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Optional HTTP headers to send to the MCP server. Use for authentication or other
         * purposes.
         */
        class Headers
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

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Headers = apply {
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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Headers && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
        }

        /** Specify which of the MCP server's tools require approval. */
        @JsonDeserialize(using = RequireApproval.Deserializer::class)
        @JsonSerialize(using = RequireApproval.Serializer::class)
        class RequireApproval
        private constructor(
            private val mcpToolApprovalFilter: McpToolApprovalFilter? = null,
            private val mcpToolApprovalSetting: McpToolApprovalSetting? = null,
            private val _json: JsonValue? = null,
        ) {

            /**
             * Specify which of the MCP server's tools require approval. Can be `always`, `never`,
             * or a filter object associated with tools that require approval.
             */
            fun mcpToolApprovalFilter(): Optional<McpToolApprovalFilter> =
                Optional.ofNullable(mcpToolApprovalFilter)

            /**
             * Specify a single approval policy for all tools. One of `always` or `never`. When set
             * to `always`, all tools will require approval. When set to `never`, all tools will not
             * require approval.
             */
            fun mcpToolApprovalSetting(): Optional<McpToolApprovalSetting> =
                Optional.ofNullable(mcpToolApprovalSetting)

            fun isMcpToolApprovalFilter(): Boolean = mcpToolApprovalFilter != null

            fun isMcpToolApprovalSetting(): Boolean = mcpToolApprovalSetting != null

            /**
             * Specify which of the MCP server's tools require approval. Can be `always`, `never`,
             * or a filter object associated with tools that require approval.
             */
            fun asMcpToolApprovalFilter(): McpToolApprovalFilter =
                mcpToolApprovalFilter.getOrThrow("mcpToolApprovalFilter")

            /**
             * Specify a single approval policy for all tools. One of `always` or `never`. When set
             * to `always`, all tools will require approval. When set to `never`, all tools will not
             * require approval.
             */
            fun asMcpToolApprovalSetting(): McpToolApprovalSetting =
                mcpToolApprovalSetting.getOrThrow("mcpToolApprovalSetting")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    mcpToolApprovalFilter != null ->
                        visitor.visitMcpToolApprovalFilter(mcpToolApprovalFilter)
                    mcpToolApprovalSetting != null ->
                        visitor.visitMcpToolApprovalSetting(mcpToolApprovalSetting)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): RequireApproval = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitMcpToolApprovalFilter(
                            mcpToolApprovalFilter: McpToolApprovalFilter
                        ) {
                            mcpToolApprovalFilter.validate()
                        }

                        override fun visitMcpToolApprovalSetting(
                            mcpToolApprovalSetting: McpToolApprovalSetting
                        ) {
                            mcpToolApprovalSetting.validate()
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
                        override fun visitMcpToolApprovalFilter(
                            mcpToolApprovalFilter: McpToolApprovalFilter
                        ) = mcpToolApprovalFilter.validity()

                        override fun visitMcpToolApprovalSetting(
                            mcpToolApprovalSetting: McpToolApprovalSetting
                        ) = mcpToolApprovalSetting.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RequireApproval &&
                    mcpToolApprovalFilter == other.mcpToolApprovalFilter &&
                    mcpToolApprovalSetting == other.mcpToolApprovalSetting
            }

            override fun hashCode(): Int =
                Objects.hash(mcpToolApprovalFilter, mcpToolApprovalSetting)

            override fun toString(): String =
                when {
                    mcpToolApprovalFilter != null ->
                        "RequireApproval{mcpToolApprovalFilter=$mcpToolApprovalFilter}"
                    mcpToolApprovalSetting != null ->
                        "RequireApproval{mcpToolApprovalSetting=$mcpToolApprovalSetting}"
                    _json != null -> "RequireApproval{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RequireApproval")
                }

            companion object {

                /**
                 * Specify which of the MCP server's tools require approval. Can be `always`,
                 * `never`, or a filter object associated with tools that require approval.
                 */
                @JvmStatic
                fun ofMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter) =
                    RequireApproval(mcpToolApprovalFilter = mcpToolApprovalFilter)

                /**
                 * Specify a single approval policy for all tools. One of `always` or `never`. When
                 * set to `always`, all tools will require approval. When set to `never`, all tools
                 * will not require approval.
                 */
                @JvmStatic
                fun ofMcpToolApprovalSetting(mcpToolApprovalSetting: McpToolApprovalSetting) =
                    RequireApproval(mcpToolApprovalSetting = mcpToolApprovalSetting)
            }

            /**
             * An interface that defines how to map each variant of [RequireApproval] to a value of
             * type [T].
             */
            interface Visitor<out T> {

                /**
                 * Specify which of the MCP server's tools require approval. Can be `always`,
                 * `never`, or a filter object associated with tools that require approval.
                 */
                fun visitMcpToolApprovalFilter(mcpToolApprovalFilter: McpToolApprovalFilter): T

                /**
                 * Specify a single approval policy for all tools. One of `always` or `never`. When
                 * set to `always`, all tools will require approval. When set to `never`, all tools
                 * will not require approval.
                 */
                fun visitMcpToolApprovalSetting(mcpToolApprovalSetting: McpToolApprovalSetting): T

                /**
                 * Maps an unknown variant of [RequireApproval] to a value of type [T].
                 *
                 * An instance of [RequireApproval] can contain an unknown variant if it was
                 * deserialized from data that doesn't match any known variant. For example, if the
                 * SDK is on an older version than the API, then the API may respond with new
                 * variants that the SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown RequireApproval: $json")
                }
            }

            internal class Deserializer :
                BaseDeserializer<RequireApproval>(RequireApproval::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RequireApproval {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<McpToolApprovalFilter>())?.let {
                                    RequireApproval(mcpToolApprovalFilter = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<McpToolApprovalSetting>())
                                    ?.let {
                                        RequireApproval(mcpToolApprovalSetting = it, _json = json)
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
                        0 -> RequireApproval(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<RequireApproval>(RequireApproval::class) {

                override fun serialize(
                    value: RequireApproval,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.mcpToolApprovalFilter != null ->
                            generator.writeObject(value.mcpToolApprovalFilter)
                        value.mcpToolApprovalSetting != null ->
                            generator.writeObject(value.mcpToolApprovalSetting)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RequireApproval")
                    }
                }
            }

            /**
             * Specify which of the MCP server's tools require approval. Can be `always`, `never`,
             * or a filter object associated with tools that require approval.
             */
            class McpToolApprovalFilter
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val always: JsonField<Always>,
                private val never: JsonField<Never>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("always")
                    @ExcludeMissing
                    always: JsonField<Always> = JsonMissing.of(),
                    @JsonProperty("never")
                    @ExcludeMissing
                    never: JsonField<Never> = JsonMissing.of(),
                ) : this(always, never, mutableMapOf())

                /**
                 * A filter object to specify which tools are allowed.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun always(): Optional<Always> = always.getOptional("always")

                /**
                 * A filter object to specify which tools are allowed.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun never(): Optional<Never> = never.getOptional("never")

                /**
                 * Returns the raw JSON value of [always].
                 *
                 * Unlike [always], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("always") @ExcludeMissing fun _always(): JsonField<Always> = always

                /**
                 * Returns the raw JSON value of [never].
                 *
                 * Unlike [never], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("never") @ExcludeMissing fun _never(): JsonField<Never> = never

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
                     * [McpToolApprovalFilter].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [McpToolApprovalFilter]. */
                class Builder internal constructor() {

                    private var always: JsonField<Always> = JsonMissing.of()
                    private var never: JsonField<Never> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(mcpToolApprovalFilter: McpToolApprovalFilter) = apply {
                        always = mcpToolApprovalFilter.always
                        never = mcpToolApprovalFilter.never
                        additionalProperties =
                            mcpToolApprovalFilter.additionalProperties.toMutableMap()
                    }

                    /** A filter object to specify which tools are allowed. */
                    fun always(always: Always) = always(JsonField.of(always))

                    /**
                     * Sets [Builder.always] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.always] with a well-typed [Always] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun always(always: JsonField<Always>) = apply { this.always = always }

                    /** A filter object to specify which tools are allowed. */
                    fun never(never: Never) = never(JsonField.of(never))

                    /**
                     * Sets [Builder.never] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.never] with a well-typed [Never] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun never(never: JsonField<Never>) = apply { this.never = never }

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
                     * Returns an immutable instance of [McpToolApprovalFilter].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): McpToolApprovalFilter =
                        McpToolApprovalFilter(always, never, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): McpToolApprovalFilter = apply {
                    if (validated) {
                        return@apply
                    }

                    always().ifPresent { it.validate() }
                    never().ifPresent { it.validate() }
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
                    (always.asKnown().getOrNull()?.validity() ?: 0) +
                        (never.asKnown().getOrNull()?.validity() ?: 0)

                /** A filter object to specify which tools are allowed. */
                class Always
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val readOnly: JsonField<Boolean>,
                    private val toolNames: JsonField<List<String>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("read_only")
                        @ExcludeMissing
                        readOnly: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("tool_names")
                        @ExcludeMissing
                        toolNames: JsonField<List<String>> = JsonMissing.of(),
                    ) : this(readOnly, toolNames, mutableMapOf())

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                    /**
                     * List of allowed tool names.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                    /**
                     * Returns the raw JSON value of [readOnly].
                     *
                     * Unlike [readOnly], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    fun _readOnly(): JsonField<Boolean> = readOnly

                    /**
                     * Returns the raw JSON value of [toolNames].
                     *
                     * Unlike [toolNames], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    fun _toolNames(): JsonField<List<String>> = toolNames

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

                        /** Returns a mutable builder for constructing an instance of [Always]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Always]. */
                    class Builder internal constructor() {

                        private var readOnly: JsonField<Boolean> = JsonMissing.of()
                        private var toolNames: JsonField<MutableList<String>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(always: Always) = apply {
                            readOnly = always.readOnly
                            toolNames = always.toolNames.map { it.toMutableList() }
                            additionalProperties = always.additionalProperties.toMutableMap()
                        }

                        /**
                         * Indicates whether or not a tool modifies data or is read-only. If an MCP
                         * server is
                         * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                         * it will match this filter.
                         */
                        fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                        /**
                         * Sets [Builder.readOnly] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.readOnly] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun readOnly(readOnly: JsonField<Boolean>) = apply {
                            this.readOnly = readOnly
                        }

                        /** List of allowed tool names. */
                        fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                        /**
                         * Sets [Builder.toolNames] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.toolNames] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun toolNames(toolNames: JsonField<List<String>>) = apply {
                            this.toolNames = toolNames.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [toolNames].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addToolName(toolName: String) = apply {
                            toolNames =
                                (toolNames ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("toolNames", it).add(toolName)
                                }
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Always].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Always =
                            Always(
                                readOnly,
                                (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Always = apply {
                        if (validated) {
                            return@apply
                        }

                        readOnly()
                        toolNames()
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
                        (if (readOnly.asKnown().isPresent) 1 else 0) +
                            (toolNames.asKnown().getOrNull()?.size ?: 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Always &&
                            readOnly == other.readOnly &&
                            toolNames == other.toolNames &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(readOnly, toolNames, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Always{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
                }

                /** A filter object to specify which tools are allowed. */
                class Never
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val readOnly: JsonField<Boolean>,
                    private val toolNames: JsonField<List<String>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("read_only")
                        @ExcludeMissing
                        readOnly: JsonField<Boolean> = JsonMissing.of(),
                        @JsonProperty("tool_names")
                        @ExcludeMissing
                        toolNames: JsonField<List<String>> = JsonMissing.of(),
                    ) : this(readOnly, toolNames, mutableMapOf())

                    /**
                     * Indicates whether or not a tool modifies data or is read-only. If an MCP
                     * server is
                     * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                     * it will match this filter.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun readOnly(): Optional<Boolean> = readOnly.getOptional("read_only")

                    /**
                     * List of allowed tool names.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun toolNames(): Optional<List<String>> = toolNames.getOptional("tool_names")

                    /**
                     * Returns the raw JSON value of [readOnly].
                     *
                     * Unlike [readOnly], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("read_only")
                    @ExcludeMissing
                    fun _readOnly(): JsonField<Boolean> = readOnly

                    /**
                     * Returns the raw JSON value of [toolNames].
                     *
                     * Unlike [toolNames], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("tool_names")
                    @ExcludeMissing
                    fun _toolNames(): JsonField<List<String>> = toolNames

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

                        /** Returns a mutable builder for constructing an instance of [Never]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Never]. */
                    class Builder internal constructor() {

                        private var readOnly: JsonField<Boolean> = JsonMissing.of()
                        private var toolNames: JsonField<MutableList<String>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(never: Never) = apply {
                            readOnly = never.readOnly
                            toolNames = never.toolNames.map { it.toMutableList() }
                            additionalProperties = never.additionalProperties.toMutableMap()
                        }

                        /**
                         * Indicates whether or not a tool modifies data or is read-only. If an MCP
                         * server is
                         * [annotated with `readOnlyHint`](https://modelcontextprotocol.io/specification/2025-06-18/schema#toolannotations-readonlyhint),
                         * it will match this filter.
                         */
                        fun readOnly(readOnly: Boolean) = readOnly(JsonField.of(readOnly))

                        /**
                         * Sets [Builder.readOnly] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.readOnly] with a well-typed [Boolean]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun readOnly(readOnly: JsonField<Boolean>) = apply {
                            this.readOnly = readOnly
                        }

                        /** List of allowed tool names. */
                        fun toolNames(toolNames: List<String>) = toolNames(JsonField.of(toolNames))

                        /**
                         * Sets [Builder.toolNames] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.toolNames] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun toolNames(toolNames: JsonField<List<String>>) = apply {
                            this.toolNames = toolNames.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [toolNames].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addToolName(toolName: String) = apply {
                            toolNames =
                                (toolNames ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("toolNames", it).add(toolName)
                                }
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Never].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Never =
                            Never(
                                readOnly,
                                (toolNames ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Never = apply {
                        if (validated) {
                            return@apply
                        }

                        readOnly()
                        toolNames()
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
                        (if (readOnly.asKnown().isPresent) 1 else 0) +
                            (toolNames.asKnown().getOrNull()?.size ?: 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Never &&
                            readOnly == other.readOnly &&
                            toolNames == other.toolNames &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(readOnly, toolNames, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Never{readOnly=$readOnly, toolNames=$toolNames, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is McpToolApprovalFilter &&
                        always == other.always &&
                        never == other.never &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(always, never, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "McpToolApprovalFilter{always=$always, never=$never, additionalProperties=$additionalProperties}"
            }

            /**
             * Specify a single approval policy for all tools. One of `always` or `never`. When set
             * to `always`, all tools will require approval. When set to `never`, all tools will not
             * require approval.
             */
            class McpToolApprovalSetting
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ALWAYS = of("always")

                    @JvmField val NEVER = of("never")

                    @JvmStatic fun of(value: String) = McpToolApprovalSetting(JsonField.of(value))
                }

                /** An enum containing [McpToolApprovalSetting]'s known values. */
                enum class Known {
                    ALWAYS,
                    NEVER,
                }

                /**
                 * An enum containing [McpToolApprovalSetting]'s known values, as well as an
                 * [_UNKNOWN] member.
                 *
                 * An instance of [McpToolApprovalSetting] can contain an unknown value in a couple
                 * of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ALWAYS,
                    NEVER,
                    /**
                     * An enum member indicating that [McpToolApprovalSetting] was instantiated with
                     * an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ALWAYS -> Value.ALWAYS
                        NEVER -> Value.NEVER
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        ALWAYS -> Known.ALWAYS
                        NEVER -> Known.NEVER
                        else ->
                            throw OpenAIInvalidDataException(
                                "Unknown McpToolApprovalSetting: $value"
                            )
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): McpToolApprovalSetting = apply {
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

                    return other is McpToolApprovalSetting && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Mcp &&
                serverLabel == other.serverLabel &&
                type == other.type &&
                allowedTools == other.allowedTools &&
                authorization == other.authorization &&
                connectorId == other.connectorId &&
                headers == other.headers &&
                requireApproval == other.requireApproval &&
                serverDescription == other.serverDescription &&
                serverUrl == other.serverUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                serverLabel,
                type,
                allowedTools,
                authorization,
                connectorId,
                headers,
                requireApproval,
                serverDescription,
                serverUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Mcp{serverLabel=$serverLabel, type=$type, allowedTools=$allowedTools, authorization=$authorization, connectorId=$connectorId, headers=$headers, requireApproval=$requireApproval, serverDescription=$serverDescription, serverUrl=$serverUrl, additionalProperties=$additionalProperties}"
    }

    /** A tool that runs Python code to help generate a response to a prompt. */
    class CodeInterpreter
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val container: JsonField<Container>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("container")
            @ExcludeMissing
            container: JsonField<Container> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(container, type, mutableMapOf())

        /**
         * The code interpreter container. Can be a container ID or an object that specifies
         * uploaded file IDs to make available to your code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun container(): Container = container.getRequired("container")

        /**
         * The type of the code interpreter tool. Always `code_interpreter`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("code_interpreter")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [container].
         *
         * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("container")
        @ExcludeMissing
        fun _container(): JsonField<Container> = container

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
             * Returns a mutable builder for constructing an instance of [CodeInterpreter].
             *
             * The following fields are required:
             * ```java
             * .container()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CodeInterpreter]. */
        class Builder internal constructor() {

            private var container: JsonField<Container>? = null
            private var type: JsonValue = JsonValue.from("code_interpreter")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(codeInterpreter: CodeInterpreter) = apply {
                container = codeInterpreter.container
                type = codeInterpreter.type
                additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
            }

            /**
             * The code interpreter container. Can be a container ID or an object that specifies
             * uploaded file IDs to make available to your code.
             */
            fun container(container: Container) = container(JsonField.of(container))

            /**
             * Sets [Builder.container] to an arbitrary JSON value.
             *
             * You should usually call [Builder.container] with a well-typed [Container] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun container(container: JsonField<Container>) = apply { this.container = container }

            /** Alias for calling [container] with `Container.ofString(string)`. */
            fun container(string: String) = container(Container.ofString(string))

            /**
             * Alias for calling [container] with
             * `Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
             */
            fun container(codeInterpreterToolAuto: Container.CodeInterpreterToolAuto) =
                container(Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("code_interpreter")
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
             * Returns an immutable instance of [CodeInterpreter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .container()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CodeInterpreter =
                CodeInterpreter(
                    checkRequired("container", container),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CodeInterpreter = apply {
            if (validated) {
                return@apply
            }

            container().validate()
            _type().let {
                if (it != JsonValue.from("code_interpreter")) {
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
            (container.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("code_interpreter")) 1 else 0 }

        /**
         * The code interpreter container. Can be a container ID or an object that specifies
         * uploaded file IDs to make available to your code.
         */
        @JsonDeserialize(using = Container.Deserializer::class)
        @JsonSerialize(using = Container.Serializer::class)
        class Container
        private constructor(
            private val string: String? = null,
            private val codeInterpreterToolAuto: CodeInterpreterToolAuto? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The container ID. */
            fun string(): Optional<String> = Optional.ofNullable(string)

            /**
             * Configuration for a code interpreter container. Optionally specify the IDs of the
             * files to run the code on.
             */
            fun codeInterpreterToolAuto(): Optional<CodeInterpreterToolAuto> =
                Optional.ofNullable(codeInterpreterToolAuto)

            fun isString(): Boolean = string != null

            fun isCodeInterpreterToolAuto(): Boolean = codeInterpreterToolAuto != null

            /** The container ID. */
            fun asString(): String = string.getOrThrow("string")

            /**
             * Configuration for a code interpreter container. Optionally specify the IDs of the
             * files to run the code on.
             */
            fun asCodeInterpreterToolAuto(): CodeInterpreterToolAuto =
                codeInterpreterToolAuto.getOrThrow("codeInterpreterToolAuto")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    codeInterpreterToolAuto != null ->
                        visitor.visitCodeInterpreterToolAuto(codeInterpreterToolAuto)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Container = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitCodeInterpreterToolAuto(
                            codeInterpreterToolAuto: CodeInterpreterToolAuto
                        ) {
                            codeInterpreterToolAuto.validate()
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
                        override fun visitString(string: String) = 1

                        override fun visitCodeInterpreterToolAuto(
                            codeInterpreterToolAuto: CodeInterpreterToolAuto
                        ) = codeInterpreterToolAuto.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Container &&
                    string == other.string &&
                    codeInterpreterToolAuto == other.codeInterpreterToolAuto
            }

            override fun hashCode(): Int = Objects.hash(string, codeInterpreterToolAuto)

            override fun toString(): String =
                when {
                    string != null -> "Container{string=$string}"
                    codeInterpreterToolAuto != null ->
                        "Container{codeInterpreterToolAuto=$codeInterpreterToolAuto}"
                    _json != null -> "Container{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Container")
                }

            companion object {

                /** The container ID. */
                @JvmStatic fun ofString(string: String) = Container(string = string)

                /**
                 * Configuration for a code interpreter container. Optionally specify the IDs of the
                 * files to run the code on.
                 */
                @JvmStatic
                fun ofCodeInterpreterToolAuto(codeInterpreterToolAuto: CodeInterpreterToolAuto) =
                    Container(codeInterpreterToolAuto = codeInterpreterToolAuto)
            }

            /**
             * An interface that defines how to map each variant of [Container] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** The container ID. */
                fun visitString(string: String): T

                /**
                 * Configuration for a code interpreter container. Optionally specify the IDs of the
                 * files to run the code on.
                 */
                fun visitCodeInterpreterToolAuto(
                    codeInterpreterToolAuto: CodeInterpreterToolAuto
                ): T

                /**
                 * Maps an unknown variant of [Container] to a value of type [T].
                 *
                 * An instance of [Container] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Container: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Container>(Container::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Container {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<CodeInterpreterToolAuto>())
                                    ?.let { Container(codeInterpreterToolAuto = it, _json = json) },
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Container(string = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
                        0 -> Container(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Container>(Container::class) {

                override fun serialize(
                    value: Container,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.codeInterpreterToolAuto != null ->
                            generator.writeObject(value.codeInterpreterToolAuto)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Container")
                    }
                }
            }

            /**
             * Configuration for a code interpreter container. Optionally specify the IDs of the
             * files to run the code on.
             */
            class CodeInterpreterToolAuto
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val type: JsonValue,
                private val fileIds: JsonField<List<String>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("file_ids")
                    @ExcludeMissing
                    fileIds: JsonField<List<String>> = JsonMissing.of(),
                ) : this(type, fileIds, mutableMapOf())

                /**
                 * Always `auto`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("auto")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * An optional list of uploaded files to make available to your code.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun fileIds(): Optional<List<String>> = fileIds.getOptional("file_ids")

                /**
                 * Returns the raw JSON value of [fileIds].
                 *
                 * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_ids")
                @ExcludeMissing
                fun _fileIds(): JsonField<List<String>> = fileIds

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
                     * [CodeInterpreterToolAuto].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [CodeInterpreterToolAuto]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("auto")
                    private var fileIds: JsonField<MutableList<String>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(codeInterpreterToolAuto: CodeInterpreterToolAuto) = apply {
                        type = codeInterpreterToolAuto.type
                        fileIds = codeInterpreterToolAuto.fileIds.map { it.toMutableList() }
                        additionalProperties =
                            codeInterpreterToolAuto.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("auto")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /** An optional list of uploaded files to make available to your code. */
                    fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                    /**
                     * Sets [Builder.fileIds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileIds] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun fileIds(fileIds: JsonField<List<String>>) = apply {
                        this.fileIds = fileIds.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [fileIds].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds =
                            (fileIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("fileIds", it).add(fileId)
                            }
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
                     * Returns an immutable instance of [CodeInterpreterToolAuto].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): CodeInterpreterToolAuto =
                        CodeInterpreterToolAuto(
                            type,
                            (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): CodeInterpreterToolAuto = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("auto")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    fileIds()
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
                    type.let { if (it == JsonValue.from("auto")) 1 else 0 } +
                        (fileIds.asKnown().getOrNull()?.size ?: 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is CodeInterpreterToolAuto &&
                        type == other.type &&
                        fileIds == other.fileIds &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(type, fileIds, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "CodeInterpreterToolAuto{type=$type, fileIds=$fileIds, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CodeInterpreter &&
                container == other.container &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(container, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CodeInterpreter{container=$container, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A tool that generates images using a model like `gpt-image-1`. */
    class ImageGeneration
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonValue,
        private val background: JsonField<Background>,
        private val inputFidelity: JsonField<InputFidelity>,
        private val inputImageMask: JsonField<InputImageMask>,
        private val model: JsonField<Model>,
        private val moderation: JsonField<Moderation>,
        private val outputCompression: JsonField<Long>,
        private val outputFormat: JsonField<OutputFormat>,
        private val partialImages: JsonField<Long>,
        private val quality: JsonField<Quality>,
        private val size: JsonField<Size>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("background")
            @ExcludeMissing
            background: JsonField<Background> = JsonMissing.of(),
            @JsonProperty("input_fidelity")
            @ExcludeMissing
            inputFidelity: JsonField<InputFidelity> = JsonMissing.of(),
            @JsonProperty("input_image_mask")
            @ExcludeMissing
            inputImageMask: JsonField<InputImageMask> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<Model> = JsonMissing.of(),
            @JsonProperty("moderation")
            @ExcludeMissing
            moderation: JsonField<Moderation> = JsonMissing.of(),
            @JsonProperty("output_compression")
            @ExcludeMissing
            outputCompression: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("output_format")
            @ExcludeMissing
            outputFormat: JsonField<OutputFormat> = JsonMissing.of(),
            @JsonProperty("partial_images")
            @ExcludeMissing
            partialImages: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quality") @ExcludeMissing quality: JsonField<Quality> = JsonMissing.of(),
            @JsonProperty("size") @ExcludeMissing size: JsonField<Size> = JsonMissing.of(),
        ) : this(
            type,
            background,
            inputFidelity,
            inputImageMask,
            model,
            moderation,
            outputCompression,
            outputFormat,
            partialImages,
            quality,
            size,
            mutableMapOf(),
        )

        /**
         * The type of the image generation tool. Always `image_generation`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("image_generation")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Background type for the generated image. One of `transparent`, `opaque`, or `auto`.
         * Default: `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun background(): Optional<Background> = background.getOptional("background")

        /**
         * Control how much effort the model will exert to match the style and features, especially
         * facial features, of input images. This parameter is only supported for `gpt-image-1`.
         * Supports `high` and `low`. Defaults to `low`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputFidelity(): Optional<InputFidelity> = inputFidelity.getOptional("input_fidelity")

        /**
         * Optional mask for inpainting. Contains `image_url` (string, optional) and `file_id`
         * (string, optional).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inputImageMask(): Optional<InputImageMask> =
            inputImageMask.getOptional("input_image_mask")

        /**
         * The image generation model to use. Default: `gpt-image-1`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<Model> = model.getOptional("model")

        /**
         * Moderation level for the generated image. Default: `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun moderation(): Optional<Moderation> = moderation.getOptional("moderation")

        /**
         * Compression level for the output image. Default: 100.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputCompression(): Optional<Long> =
            outputCompression.getOptional("output_compression")

        /**
         * The output format of the generated image. One of `png`, `webp`, or `jpeg`. Default:
         * `png`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun outputFormat(): Optional<OutputFormat> = outputFormat.getOptional("output_format")

        /**
         * Number of partial images to generate in streaming mode, from 0 (default value) to 3.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun partialImages(): Optional<Long> = partialImages.getOptional("partial_images")

        /**
         * The quality of the generated image. One of `low`, `medium`, `high`, or `auto`. Default:
         * `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun quality(): Optional<Quality> = quality.getOptional("quality")

        /**
         * The size of the generated image. One of `1024x1024`, `1024x1536`, `1536x1024`, or `auto`.
         * Default: `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun size(): Optional<Size> = size.getOptional("size")

        /**
         * Returns the raw JSON value of [background].
         *
         * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("background")
        @ExcludeMissing
        fun _background(): JsonField<Background> = background

        /**
         * Returns the raw JSON value of [inputFidelity].
         *
         * Unlike [inputFidelity], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("input_fidelity")
        @ExcludeMissing
        fun _inputFidelity(): JsonField<InputFidelity> = inputFidelity

        /**
         * Returns the raw JSON value of [inputImageMask].
         *
         * Unlike [inputImageMask], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("input_image_mask")
        @ExcludeMissing
        fun _inputImageMask(): JsonField<InputImageMask> = inputImageMask

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<Model> = model

        /**
         * Returns the raw JSON value of [moderation].
         *
         * Unlike [moderation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("moderation")
        @ExcludeMissing
        fun _moderation(): JsonField<Moderation> = moderation

        /**
         * Returns the raw JSON value of [outputCompression].
         *
         * Unlike [outputCompression], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_compression")
        @ExcludeMissing
        fun _outputCompression(): JsonField<Long> = outputCompression

        /**
         * Returns the raw JSON value of [outputFormat].
         *
         * Unlike [outputFormat], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_format")
        @ExcludeMissing
        fun _outputFormat(): JsonField<OutputFormat> = outputFormat

        /**
         * Returns the raw JSON value of [partialImages].
         *
         * Unlike [partialImages], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("partial_images")
        @ExcludeMissing
        fun _partialImages(): JsonField<Long> = partialImages

        /**
         * Returns the raw JSON value of [quality].
         *
         * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Quality> = quality

        /**
         * Returns the raw JSON value of [size].
         *
         * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Size> = size

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

            /** Returns a mutable builder for constructing an instance of [ImageGeneration]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ImageGeneration]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("image_generation")
            private var background: JsonField<Background> = JsonMissing.of()
            private var inputFidelity: JsonField<InputFidelity> = JsonMissing.of()
            private var inputImageMask: JsonField<InputImageMask> = JsonMissing.of()
            private var model: JsonField<Model> = JsonMissing.of()
            private var moderation: JsonField<Moderation> = JsonMissing.of()
            private var outputCompression: JsonField<Long> = JsonMissing.of()
            private var outputFormat: JsonField<OutputFormat> = JsonMissing.of()
            private var partialImages: JsonField<Long> = JsonMissing.of()
            private var quality: JsonField<Quality> = JsonMissing.of()
            private var size: JsonField<Size> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGeneration: ImageGeneration) = apply {
                type = imageGeneration.type
                background = imageGeneration.background
                inputFidelity = imageGeneration.inputFidelity
                inputImageMask = imageGeneration.inputImageMask
                model = imageGeneration.model
                moderation = imageGeneration.moderation
                outputCompression = imageGeneration.outputCompression
                outputFormat = imageGeneration.outputFormat
                partialImages = imageGeneration.partialImages
                quality = imageGeneration.quality
                size = imageGeneration.size
                additionalProperties = imageGeneration.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("image_generation")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * Background type for the generated image. One of `transparent`, `opaque`, or `auto`.
             * Default: `auto`.
             */
            fun background(background: Background) = background(JsonField.of(background))

            /**
             * Sets [Builder.background] to an arbitrary JSON value.
             *
             * You should usually call [Builder.background] with a well-typed [Background] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun background(background: JsonField<Background>) = apply {
                this.background = background
            }

            /**
             * Control how much effort the model will exert to match the style and features,
             * especially facial features, of input images. This parameter is only supported for
             * `gpt-image-1`. Supports `high` and `low`. Defaults to `low`.
             */
            fun inputFidelity(inputFidelity: InputFidelity?) =
                inputFidelity(JsonField.ofNullable(inputFidelity))

            /** Alias for calling [Builder.inputFidelity] with `inputFidelity.orElse(null)`. */
            fun inputFidelity(inputFidelity: Optional<InputFidelity>) =
                inputFidelity(inputFidelity.getOrNull())

            /**
             * Sets [Builder.inputFidelity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputFidelity] with a well-typed [InputFidelity]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun inputFidelity(inputFidelity: JsonField<InputFidelity>) = apply {
                this.inputFidelity = inputFidelity
            }

            /**
             * Optional mask for inpainting. Contains `image_url` (string, optional) and `file_id`
             * (string, optional).
             */
            fun inputImageMask(inputImageMask: InputImageMask) =
                inputImageMask(JsonField.of(inputImageMask))

            /**
             * Sets [Builder.inputImageMask] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputImageMask] with a well-typed [InputImageMask]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun inputImageMask(inputImageMask: JsonField<InputImageMask>) = apply {
                this.inputImageMask = inputImageMask
            }

            /** The image generation model to use. Default: `gpt-image-1`. */
            fun model(model: Model) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [Model] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun model(model: JsonField<Model>) = apply { this.model = model }

            /** Moderation level for the generated image. Default: `auto`. */
            fun moderation(moderation: Moderation) = moderation(JsonField.of(moderation))

            /**
             * Sets [Builder.moderation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.moderation] with a well-typed [Moderation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun moderation(moderation: JsonField<Moderation>) = apply {
                this.moderation = moderation
            }

            /** Compression level for the output image. Default: 100. */
            fun outputCompression(outputCompression: Long) =
                outputCompression(JsonField.of(outputCompression))

            /**
             * Sets [Builder.outputCompression] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputCompression] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputCompression(outputCompression: JsonField<Long>) = apply {
                this.outputCompression = outputCompression
            }

            /**
             * The output format of the generated image. One of `png`, `webp`, or `jpeg`. Default:
             * `png`.
             */
            fun outputFormat(outputFormat: OutputFormat) = outputFormat(JsonField.of(outputFormat))

            /**
             * Sets [Builder.outputFormat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputFormat] with a well-typed [OutputFormat] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputFormat(outputFormat: JsonField<OutputFormat>) = apply {
                this.outputFormat = outputFormat
            }

            /**
             * Number of partial images to generate in streaming mode, from 0 (default value) to 3.
             */
            fun partialImages(partialImages: Long) = partialImages(JsonField.of(partialImages))

            /**
             * Sets [Builder.partialImages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.partialImages] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun partialImages(partialImages: JsonField<Long>) = apply {
                this.partialImages = partialImages
            }

            /**
             * The quality of the generated image. One of `low`, `medium`, `high`, or `auto`.
             * Default: `auto`.
             */
            fun quality(quality: Quality) = quality(JsonField.of(quality))

            /**
             * Sets [Builder.quality] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quality] with a well-typed [Quality] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quality(quality: JsonField<Quality>) = apply { this.quality = quality }

            /**
             * The size of the generated image. One of `1024x1024`, `1024x1536`, `1536x1024`, or
             * `auto`. Default: `auto`.
             */
            fun size(size: Size) = size(JsonField.of(size))

            /**
             * Sets [Builder.size] to an arbitrary JSON value.
             *
             * You should usually call [Builder.size] with a well-typed [Size] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun size(size: JsonField<Size>) = apply { this.size = size }

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
             * Returns an immutable instance of [ImageGeneration].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ImageGeneration =
                ImageGeneration(
                    type,
                    background,
                    inputFidelity,
                    inputImageMask,
                    model,
                    moderation,
                    outputCompression,
                    outputFormat,
                    partialImages,
                    quality,
                    size,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ImageGeneration = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("image_generation")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            background().ifPresent { it.validate() }
            inputFidelity().ifPresent { it.validate() }
            inputImageMask().ifPresent { it.validate() }
            model().ifPresent { it.validate() }
            moderation().ifPresent { it.validate() }
            outputCompression()
            outputFormat().ifPresent { it.validate() }
            partialImages()
            quality().ifPresent { it.validate() }
            size().ifPresent { it.validate() }
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
            type.let { if (it == JsonValue.from("image_generation")) 1 else 0 } +
                (background.asKnown().getOrNull()?.validity() ?: 0) +
                (inputFidelity.asKnown().getOrNull()?.validity() ?: 0) +
                (inputImageMask.asKnown().getOrNull()?.validity() ?: 0) +
                (model.asKnown().getOrNull()?.validity() ?: 0) +
                (moderation.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputCompression.asKnown().isPresent) 1 else 0) +
                (outputFormat.asKnown().getOrNull()?.validity() ?: 0) +
                (if (partialImages.asKnown().isPresent) 1 else 0) +
                (quality.asKnown().getOrNull()?.validity() ?: 0) +
                (size.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Background type for the generated image. One of `transparent`, `opaque`, or `auto`.
         * Default: `auto`.
         */
        class Background @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val TRANSPARENT = of("transparent")

                @JvmField val OPAQUE = of("opaque")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = Background(JsonField.of(value))
            }

            /** An enum containing [Background]'s known values. */
            enum class Known {
                TRANSPARENT,
                OPAQUE,
                AUTO,
            }

            /**
             * An enum containing [Background]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Background] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TRANSPARENT,
                OPAQUE,
                AUTO,
                /**
                 * An enum member indicating that [Background] was instantiated with an unknown
                 * value.
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
                    TRANSPARENT -> Value.TRANSPARENT
                    OPAQUE -> Value.OPAQUE
                    AUTO -> Value.AUTO
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
                    TRANSPARENT -> Known.TRANSPARENT
                    OPAQUE -> Known.OPAQUE
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Background: $value")
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

            fun validate(): Background = apply {
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

                return other is Background && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Control how much effort the model will exert to match the style and features, especially
         * facial features, of input images. This parameter is only supported for `gpt-image-1`.
         * Supports `high` and `low`. Defaults to `low`.
         */
        class InputFidelity @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val HIGH = of("high")

                @JvmField val LOW = of("low")

                @JvmStatic fun of(value: String) = InputFidelity(JsonField.of(value))
            }

            /** An enum containing [InputFidelity]'s known values. */
            enum class Known {
                HIGH,
                LOW,
            }

            /**
             * An enum containing [InputFidelity]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [InputFidelity] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                HIGH,
                LOW,
                /**
                 * An enum member indicating that [InputFidelity] was instantiated with an unknown
                 * value.
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
                    HIGH -> Value.HIGH
                    LOW -> Value.LOW
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
                    HIGH -> Known.HIGH
                    LOW -> Known.LOW
                    else -> throw OpenAIInvalidDataException("Unknown InputFidelity: $value")
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

            fun validate(): InputFidelity = apply {
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

                return other is InputFidelity && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Optional mask for inpainting. Contains `image_url` (string, optional) and `file_id`
         * (string, optional).
         */
        class InputImageMask
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fileId: JsonField<String>,
            private val imageUrl: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("image_url")
                @ExcludeMissing
                imageUrl: JsonField<String> = JsonMissing.of(),
            ) : this(fileId, imageUrl, mutableMapOf())

            /**
             * File ID for the mask image.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileId(): Optional<String> = fileId.getOptional("file_id")

            /**
             * Base64-encoded mask image.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun imageUrl(): Optional<String> = imageUrl.getOptional("image_url")

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

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

                /** Returns a mutable builder for constructing an instance of [InputImageMask]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [InputImageMask]. */
            class Builder internal constructor() {

                private var fileId: JsonField<String> = JsonMissing.of()
                private var imageUrl: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(inputImageMask: InputImageMask) = apply {
                    fileId = inputImageMask.fileId
                    imageUrl = inputImageMask.imageUrl
                    additionalProperties = inputImageMask.additionalProperties.toMutableMap()
                }

                /** File ID for the mask image. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** Base64-encoded mask image. */
                fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                /**
                 * Sets [Builder.imageUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.imageUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

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
                 * Returns an immutable instance of [InputImageMask].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): InputImageMask =
                    InputImageMask(fileId, imageUrl, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): InputImageMask = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                imageUrl()
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
                (if (fileId.asKnown().isPresent) 1 else 0) +
                    (if (imageUrl.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is InputImageMask &&
                    fileId == other.fileId &&
                    imageUrl == other.imageUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fileId, imageUrl, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "InputImageMask{fileId=$fileId, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
        }

        /** The image generation model to use. Default: `gpt-image-1`. */
        class Model @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val GPT_IMAGE_1 = of("gpt-image-1")

                @JvmStatic fun of(value: String) = Model(JsonField.of(value))
            }

            /** An enum containing [Model]'s known values. */
            enum class Known {
                GPT_IMAGE_1
            }

            /**
             * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Model] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                GPT_IMAGE_1,
                /**
                 * An enum member indicating that [Model] was instantiated with an unknown value.
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
                    GPT_IMAGE_1 -> Value.GPT_IMAGE_1
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
                    GPT_IMAGE_1 -> Known.GPT_IMAGE_1
                    else -> throw OpenAIInvalidDataException("Unknown Model: $value")
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

            fun validate(): Model = apply {
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

                return other is Model && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Moderation level for the generated image. Default: `auto`. */
        class Moderation @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val AUTO = of("auto")

                @JvmField val LOW = of("low")

                @JvmStatic fun of(value: String) = Moderation(JsonField.of(value))
            }

            /** An enum containing [Moderation]'s known values. */
            enum class Known {
                AUTO,
                LOW,
            }

            /**
             * An enum containing [Moderation]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Moderation] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                LOW,
                /**
                 * An enum member indicating that [Moderation] was instantiated with an unknown
                 * value.
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
                    AUTO -> Value.AUTO
                    LOW -> Value.LOW
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
                    AUTO -> Known.AUTO
                    LOW -> Known.LOW
                    else -> throw OpenAIInvalidDataException("Unknown Moderation: $value")
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

            fun validate(): Moderation = apply {
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

                return other is Moderation && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The output format of the generated image. One of `png`, `webp`, or `jpeg`. Default:
         * `png`.
         */
        class OutputFormat @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val PNG = of("png")

                @JvmField val WEBP = of("webp")

                @JvmField val JPEG = of("jpeg")

                @JvmStatic fun of(value: String) = OutputFormat(JsonField.of(value))
            }

            /** An enum containing [OutputFormat]'s known values. */
            enum class Known {
                PNG,
                WEBP,
                JPEG,
            }

            /**
             * An enum containing [OutputFormat]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [OutputFormat] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PNG,
                WEBP,
                JPEG,
                /**
                 * An enum member indicating that [OutputFormat] was instantiated with an unknown
                 * value.
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
                    PNG -> Value.PNG
                    WEBP -> Value.WEBP
                    JPEG -> Value.JPEG
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
                    PNG -> Known.PNG
                    WEBP -> Known.WEBP
                    JPEG -> Known.JPEG
                    else -> throw OpenAIInvalidDataException("Unknown OutputFormat: $value")
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

            fun validate(): OutputFormat = apply {
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

                return other is OutputFormat && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The quality of the generated image. One of `low`, `medium`, `high`, or `auto`. Default:
         * `auto`.
         */
        class Quality @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
            }

            /** An enum containing [Quality]'s known values. */
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
                AUTO,
            }

            /**
             * An enum containing [Quality]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Quality] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                LOW,
                MEDIUM,
                HIGH,
                AUTO,
                /**
                 * An enum member indicating that [Quality] was instantiated with an unknown value.
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
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    AUTO -> Value.AUTO
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
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Quality: $value")
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

            fun validate(): Quality = apply {
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

                return other is Quality && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * The size of the generated image. One of `1024x1024`, `1024x1536`, `1536x1024`, or `auto`.
         * Default: `auto`.
         */
        class Size @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val _1024X1024 = of("1024x1024")

                @JvmField val _1024X1536 = of("1024x1536")

                @JvmField val _1536X1024 = of("1536x1024")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = Size(JsonField.of(value))
            }

            /** An enum containing [Size]'s known values. */
            enum class Known {
                _1024X1024,
                _1024X1536,
                _1536X1024,
                AUTO,
            }

            /**
             * An enum containing [Size]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Size] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _1024X1024,
                _1024X1536,
                _1536X1024,
                AUTO,
                /** An enum member indicating that [Size] was instantiated with an unknown value. */
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
                    _1024X1024 -> Value._1024X1024
                    _1024X1536 -> Value._1024X1536
                    _1536X1024 -> Value._1536X1024
                    AUTO -> Value.AUTO
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
                    _1024X1024 -> Known._1024X1024
                    _1024X1536 -> Known._1024X1536
                    _1536X1024 -> Known._1536X1024
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Size: $value")
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

            fun validate(): Size = apply {
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

                return other is Size && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ImageGeneration &&
                type == other.type &&
                background == other.background &&
                inputFidelity == other.inputFidelity &&
                inputImageMask == other.inputImageMask &&
                model == other.model &&
                moderation == other.moderation &&
                outputCompression == other.outputCompression &&
                outputFormat == other.outputFormat &&
                partialImages == other.partialImages &&
                quality == other.quality &&
                size == other.size &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                type,
                background,
                inputFidelity,
                inputImageMask,
                model,
                moderation,
                outputCompression,
                outputFormat,
                partialImages,
                quality,
                size,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageGeneration{type=$type, background=$background, inputFidelity=$inputFidelity, inputImageMask=$inputImageMask, model=$model, moderation=$moderation, outputCompression=$outputCompression, outputFormat=$outputFormat, partialImages=$partialImages, quality=$quality, size=$size, additionalProperties=$additionalProperties}"
    }
}
