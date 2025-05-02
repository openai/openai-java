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

/** A tool that can be used to generate a response. */
@JsonDeserialize(using = Tool.Deserializer::class)
@JsonSerialize(using = Tool.Serializer::class)
class Tool
private constructor(
    private val fileSearch: FileSearchTool? = null,
    private val function: FunctionTool? = null,
    private val webSearch: WebSearchTool? = null,
    private val computerUsePreview: ComputerTool? = null,
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
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun webSearch(): Optional<WebSearchTool> = Optional.ofNullable(webSearch)

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun computerUsePreview(): Optional<ComputerTool> = Optional.ofNullable(computerUsePreview)

    fun isFileSearch(): Boolean = fileSearch != null

    fun isFunction(): Boolean = function != null

    fun isWebSearch(): Boolean = webSearch != null

    fun isComputerUsePreview(): Boolean = computerUsePreview != null

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
     * This tool searches the web for relevant results to use in a response. Learn more about the
     * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
     */
    fun asWebSearch(): WebSearchTool = webSearch.getOrThrow("webSearch")

    /**
     * A tool that controls a virtual computer. Learn more about the
     * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
     */
    fun asComputerUsePreview(): ComputerTool = computerUsePreview.getOrThrow("computerUsePreview")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            function != null -> visitor.visitFunction(function)
            webSearch != null -> visitor.visitWebSearch(webSearch)
            computerUsePreview != null -> visitor.visitComputerUsePreview(computerUsePreview)
            else -> visitor.unknown(_json)
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

                override fun visitWebSearch(webSearch: WebSearchTool) {
                    webSearch.validate()
                }

                override fun visitComputerUsePreview(computerUsePreview: ComputerTool) {
                    computerUsePreview.validate()
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
                override fun visitFileSearch(fileSearch: FileSearchTool) = fileSearch.validity()

                override fun visitFunction(function: FunctionTool) = function.validity()

                override fun visitWebSearch(webSearch: WebSearchTool) = webSearch.validity()

                override fun visitComputerUsePreview(computerUsePreview: ComputerTool) =
                    computerUsePreview.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Tool && fileSearch == other.fileSearch && function == other.function && webSearch == other.webSearch && computerUsePreview == other.computerUsePreview /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileSearch, function, webSearch, computerUsePreview) /* spotless:on */

    override fun toString(): String =
        when {
            fileSearch != null -> "Tool{fileSearch=$fileSearch}"
            function != null -> "Tool{function=$function}"
            webSearch != null -> "Tool{webSearch=$webSearch}"
            computerUsePreview != null -> "Tool{computerUsePreview=$computerUsePreview}"
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
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        @JvmStatic fun ofWebSearch(webSearch: WebSearchTool) = Tool(webSearch = webSearch)

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        @JvmStatic
        fun ofComputerUsePreview(computerUsePreview: ComputerTool) =
            Tool(computerUsePreview = computerUsePreview)
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
         * This tool searches the web for relevant results to use in a response. Learn more about
         * the [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
         */
        fun visitWebSearch(webSearch: WebSearchTool): T

        /**
         * A tool that controls a virtual computer. Learn more about the
         * [computer tool](https://platform.openai.com/docs/guides/tools-computer-use).
         */
        fun visitComputerUsePreview(computerUsePreview: ComputerTool): T

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
                    return tryDeserialize(node, jacksonTypeRef<FileSearchTool>())?.let {
                        Tool(fileSearch = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionTool>())?.let {
                        Tool(function = it, _json = json)
                    } ?: Tool(_json = json)
                }
                "computer_use_preview" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerTool>())?.let {
                        Tool(computerUsePreview = it, _json = json)
                    } ?: Tool(_json = json)
                }
            }

            return tryDeserialize(node, jacksonTypeRef<WebSearchTool>())?.let {
                Tool(webSearch = it, _json = json)
            } ?: Tool(_json = json)
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
                value.webSearch != null -> generator.writeObject(value.webSearch)
                value.computerUsePreview != null -> generator.writeObject(value.computerUsePreview)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Tool")
            }
        }
    }
}
