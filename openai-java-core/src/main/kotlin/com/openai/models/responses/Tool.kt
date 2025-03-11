// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

/**
 * A tool that searches for relevant content from uploaded files. Learn more about the
 * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
 */
@JsonDeserialize(using = Tool.Deserializer::class)
@JsonSerialize(using = Tool.Serializer::class)
class Tool
private constructor(
    private val fileSearch: FileSearchTool? = null,
    private val function: FunctionTool? = null,
    private val computerPreview: ComputerTool? = null,
    private val webSearch: WebSearchTool? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * A tool that searches for relevant content from uploaded files. Learn more about the
     * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
     */
    fun fileSearch(): Optional<FileSearchTool> = Optional.ofNullable(fileSearch)

    /**
     * Defines a function in your own code the model can choose to call. Learn more about
     * [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun computerPreview(): Optional<ComputerTool> = Optional.ofNullable(computerPreview)

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun webSearch(): Optional<WebSearchTool> = Optional.ofNullable(webSearch)

    fun isFileSearch(): Boolean = fileSearch != null

    fun isFunction(): Boolean = function != null

    fun isComputerPreview(): Boolean = computerPreview != null

    fun isWebSearch(): Boolean = webSearch != null

    /**
     * A tool that searches for relevant content from uploaded files. Learn more about the
     * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
     */
    fun asFileSearch(): FileSearchTool = fileSearch.getOrThrow("fileSearch")

    /**
     * Defines a function in your own code the model can choose to call. Learn more about
     * [function calling](https://platform.openai.com/docs/guides/function-calling).
     */
    fun asFunction(): FunctionTool = function.getOrThrow("function")

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun asComputerPreview(): ComputerTool = computerPreview.getOrThrow("computerPreview")

    /**
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun asWebSearch(): WebSearchTool = webSearch.getOrThrow("webSearch")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            function != null -> visitor.visitFunction(function)
            computerPreview != null -> visitor.visitComputerPreview(computerPreview)
            webSearch != null -> visitor.visitWebSearch(webSearch)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): Tool = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileSearch(fileSearch: FileSearchTool) {
                    fileSearch.validate()
                }

                override fun visitFunction(function: FunctionTool) {
                    function.validate()
                }

                override fun visitComputerPreview(computerPreview: ComputerTool) {
                    computerPreview.validate()
                }

                override fun visitWebSearch(webSearch: WebSearchTool) {
                    webSearch.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Tool && fileSearch == other.fileSearch && function == other.function && computerPreview == other.computerPreview && webSearch == other.webSearch /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileSearch, function, computerPreview, webSearch) /* spotless:on */

    override fun toString(): String =
        when {
            fileSearch != null -> "Tool{fileSearch=$fileSearch}"
            function != null -> "Tool{function=$function}"
            computerPreview != null -> "Tool{computerPreview=$computerPreview}"
            webSearch != null -> "Tool{webSearch=$webSearch}"
            _json != null -> "Tool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Tool")
        }

    companion object {

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        @JvmStatic fun ofFileSearch(fileSearch: FileSearchTool) = Tool(fileSearch = fileSearch)

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        @JvmStatic fun ofFunction(function: FunctionTool) = Tool(function = function)

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        @JvmStatic
        fun ofComputerPreview(computerPreview: ComputerTool) =
            Tool(computerPreview = computerPreview)

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        @JvmStatic fun ofWebSearch(webSearch: WebSearchTool) = Tool(webSearch = webSearch)
    }

    /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
    interface Visitor<out T> {

        /**
         * A tool that searches for relevant content from uploaded files. Learn more about the
         * [file search tool](https://platform.openai.com/docs/guides/tools-file-search).
         */
        fun visitFileSearch(fileSearch: FileSearchTool): T

        /**
         * Defines a function in your own code the model can choose to call. Learn more about
         * [function calling](https://platform.openai.com/docs/guides/function-calling).
         */
        fun visitFunction(function: FunctionTool): T

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        fun visitComputerPreview(computerPreview: ComputerTool): T

        /**
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun visitWebSearch(webSearch: WebSearchTool): T

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
                "file_search" -> {
                    tryDeserialize(node, jacksonTypeRef<FileSearchTool>()) { it.validate() }
                        ?.let {
                            return Tool(fileSearch = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<FunctionTool>()) { it.validate() }
                        ?.let {
                            return Tool(function = it, _json = json)
                        }
                }
                "computer-preview" -> {
                    tryDeserialize(node, jacksonTypeRef<ComputerTool>()) { it.validate() }
                        ?.let {
                            return Tool(computerPreview = it, _json = json)
                        }
                }
            }

            tryDeserialize(node, jacksonTypeRef<WebSearchTool>()) { it.validate() }
                ?.let {
                    return Tool(webSearch = it, _json = json)
                }

            return Tool(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Tool>(Tool::class) {

        override fun serialize(
            value: Tool,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                value.function != null -> generator.writeObject(value.function)
                value.computerPreview != null -> generator.writeObject(value.computerPreview)
                value.webSearch != null -> generator.writeObject(value.webSearch)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Tool")
            }
        }
    }
}
