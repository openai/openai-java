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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Content item used to generate a response. */
@JsonDeserialize(using = ResponseItem.Deserializer::class)
@JsonSerialize(using = ResponseItem.Serializer::class)
class ResponseItem
private constructor(
    private val responseInputMessageItem: ResponseInputMessageItem? = null,
    private val responseOutputMessage: ResponseOutputMessage? = null,
    private val fileSearchCall: ResponseFileSearchToolCall? = null,
    private val computerCall: ResponseComputerToolCall? = null,
    private val computerCallOutput: ResponseComputerToolCallOutputItem? = null,
    private val webSearchCall: ResponseFunctionWebSearch? = null,
    private val functionCall: ResponseFunctionToolCallItem? = null,
    private val functionCallOutput: ResponseFunctionToolCallOutputItem? = null,
    private val _json: JsonValue? = null,
) {

    fun responseInputMessageItem(): Optional<ResponseInputMessageItem> =
        Optional.ofNullable(responseInputMessageItem)

    /** An output message from the model. */
    fun responseOutputMessage(): Optional<ResponseOutputMessage> =
        Optional.ofNullable(responseOutputMessage)

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun fileSearchCall(): Optional<ResponseFileSearchToolCall> = Optional.ofNullable(fileSearchCall)

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun computerCall(): Optional<ResponseComputerToolCall> = Optional.ofNullable(computerCall)

    fun computerCallOutput(): Optional<ResponseComputerToolCallOutputItem> =
        Optional.ofNullable(computerCallOutput)

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun webSearchCall(): Optional<ResponseFunctionWebSearch> = Optional.ofNullable(webSearchCall)

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun functionCall(): Optional<ResponseFunctionToolCallItem> = Optional.ofNullable(functionCall)

    fun functionCallOutput(): Optional<ResponseFunctionToolCallOutputItem> =
        Optional.ofNullable(functionCallOutput)

    fun isResponseInputMessageItem(): Boolean = responseInputMessageItem != null

    fun isResponseOutputMessage(): Boolean = responseOutputMessage != null

    fun isFileSearchCall(): Boolean = fileSearchCall != null

    fun isComputerCall(): Boolean = computerCall != null

    fun isComputerCallOutput(): Boolean = computerCallOutput != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun asResponseInputMessageItem(): ResponseInputMessageItem =
        responseInputMessageItem.getOrThrow("responseInputMessageItem")

    /** An output message from the model. */
    fun asResponseOutputMessage(): ResponseOutputMessage =
        responseOutputMessage.getOrThrow("responseOutputMessage")

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun asFileSearchCall(): ResponseFileSearchToolCall = fileSearchCall.getOrThrow("fileSearchCall")

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun asComputerCall(): ResponseComputerToolCall = computerCall.getOrThrow("computerCall")

    fun asComputerCallOutput(): ResponseComputerToolCallOutputItem =
        computerCallOutput.getOrThrow("computerCallOutput")

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun asWebSearchCall(): ResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun asFunctionCall(): ResponseFunctionToolCallItem = functionCall.getOrThrow("functionCall")

    fun asFunctionCallOutput(): ResponseFunctionToolCallOutputItem =
        functionCallOutput.getOrThrow("functionCallOutput")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            responseInputMessageItem != null ->
                visitor.visitResponseInputMessageItem(responseInputMessageItem)
            responseOutputMessage != null ->
                visitor.visitResponseOutputMessage(responseOutputMessage)
            fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
            computerCall != null -> visitor.visitComputerCall(computerCall)
            computerCallOutput != null -> visitor.visitComputerCallOutput(computerCallOutput)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitResponseInputMessageItem(
                    responseInputMessageItem: ResponseInputMessageItem
                ) {
                    responseInputMessageItem.validate()
                }

                override fun visitResponseOutputMessage(
                    responseOutputMessage: ResponseOutputMessage
                ) {
                    responseOutputMessage.validate()
                }

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) {
                    fileSearchCall.validate()
                }

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) {
                    computerCall.validate()
                }

                override fun visitComputerCallOutput(
                    computerCallOutput: ResponseComputerToolCallOutputItem
                ) {
                    computerCallOutput.validate()
                }

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) {
                    webSearchCall.validate()
                }

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCallItem) {
                    functionCall.validate()
                }

                override fun visitFunctionCallOutput(
                    functionCallOutput: ResponseFunctionToolCallOutputItem
                ) {
                    functionCallOutput.validate()
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
                override fun visitResponseInputMessageItem(
                    responseInputMessageItem: ResponseInputMessageItem
                ) = responseInputMessageItem.validity()

                override fun visitResponseOutputMessage(
                    responseOutputMessage: ResponseOutputMessage
                ) = responseOutputMessage.validity()

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
                    fileSearchCall.validity()

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) =
                    computerCall.validity()

                override fun visitComputerCallOutput(
                    computerCallOutput: ResponseComputerToolCallOutputItem
                ) = computerCallOutput.validity()

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
                    webSearchCall.validity()

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCallItem) =
                    functionCall.validity()

                override fun visitFunctionCallOutput(
                    functionCallOutput: ResponseFunctionToolCallOutputItem
                ) = functionCallOutput.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseItem && responseInputMessageItem == other.responseInputMessageItem && responseOutputMessage == other.responseOutputMessage && fileSearchCall == other.fileSearchCall && computerCall == other.computerCall && computerCallOutput == other.computerCallOutput && webSearchCall == other.webSearchCall && functionCall == other.functionCall && functionCallOutput == other.functionCallOutput /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(responseInputMessageItem, responseOutputMessage, fileSearchCall, computerCall, computerCallOutput, webSearchCall, functionCall, functionCallOutput) /* spotless:on */

    override fun toString(): String =
        when {
            responseInputMessageItem != null ->
                "ResponseItem{responseInputMessageItem=$responseInputMessageItem}"
            responseOutputMessage != null ->
                "ResponseItem{responseOutputMessage=$responseOutputMessage}"
            fileSearchCall != null -> "ResponseItem{fileSearchCall=$fileSearchCall}"
            computerCall != null -> "ResponseItem{computerCall=$computerCall}"
            computerCallOutput != null -> "ResponseItem{computerCallOutput=$computerCallOutput}"
            webSearchCall != null -> "ResponseItem{webSearchCall=$webSearchCall}"
            functionCall != null -> "ResponseItem{functionCall=$functionCall}"
            functionCallOutput != null -> "ResponseItem{functionCallOutput=$functionCallOutput}"
            _json != null -> "ResponseItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseItem")
        }

    companion object {

        @JvmStatic
        fun ofResponseInputMessageItem(responseInputMessageItem: ResponseInputMessageItem) =
            ResponseItem(responseInputMessageItem = responseInputMessageItem)

        /** An output message from the model. */
        @JvmStatic
        fun ofResponseOutputMessage(responseOutputMessage: ResponseOutputMessage) =
            ResponseItem(responseOutputMessage = responseOutputMessage)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        @JvmStatic
        fun ofFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
            ResponseItem(fileSearchCall = fileSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        @JvmStatic
        fun ofComputerCall(computerCall: ResponseComputerToolCall) =
            ResponseItem(computerCall = computerCall)

        @JvmStatic
        fun ofComputerCallOutput(computerCallOutput: ResponseComputerToolCallOutputItem) =
            ResponseItem(computerCallOutput = computerCallOutput)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
            ResponseItem(webSearchCall = webSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        @JvmStatic
        fun ofFunctionCall(functionCall: ResponseFunctionToolCallItem) =
            ResponseItem(functionCall = functionCall)

        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: ResponseFunctionToolCallOutputItem) =
            ResponseItem(functionCallOutput = functionCallOutput)
    }

    /**
     * An interface that defines how to map each variant of [ResponseItem] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitResponseInputMessageItem(responseInputMessageItem: ResponseInputMessageItem): T

        /** An output message from the model. */
        fun visitResponseOutputMessage(responseOutputMessage: ResponseOutputMessage): T

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun visitComputerCall(computerCall: ResponseComputerToolCall): T

        fun visitComputerCallOutput(computerCallOutput: ResponseComputerToolCallOutputItem): T

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun visitFunctionCall(functionCall: ResponseFunctionToolCallItem): T

        fun visitFunctionCallOutput(functionCallOutput: ResponseFunctionToolCallOutputItem): T

        /**
         * Maps an unknown variant of [ResponseItem] to a value of type [T].
         *
         * An instance of [ResponseItem] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseItem>(ResponseItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<ResponseInputMessageItem>())
                                    ?.let {
                                        ResponseItem(responseInputMessageItem = it, _json = json)
                                    },
                                tryDeserialize(node, jacksonTypeRef<ResponseOutputMessage>())?.let {
                                    ResponseItem(responseOutputMessage = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> ResponseItem(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
                "file_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFileSearchToolCall>())?.let {
                        ResponseItem(fileSearchCall = it, _json = json)
                    } ?: ResponseItem(_json = json)
                }
                "computer_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseComputerToolCall>())?.let {
                        ResponseItem(computerCall = it, _json = json)
                    } ?: ResponseItem(_json = json)
                }
                "computer_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseComputerToolCallOutputItem>(),
                        )
                        ?.let { ResponseItem(computerCallOutput = it, _json = json) }
                        ?: ResponseItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionWebSearch>())?.let {
                        ResponseItem(webSearchCall = it, _json = json)
                    } ?: ResponseItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionToolCallItem>())
                        ?.let { ResponseItem(functionCall = it, _json = json) }
                        ?: ResponseItem(_json = json)
                }
                "function_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionToolCallOutputItem>(),
                        )
                        ?.let { ResponseItem(functionCallOutput = it, _json = json) }
                        ?: ResponseItem(_json = json)
                }
            }

            return ResponseItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseItem>(ResponseItem::class) {

        override fun serialize(
            value: ResponseItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.responseInputMessageItem != null ->
                    generator.writeObject(value.responseInputMessageItem)
                value.responseOutputMessage != null ->
                    generator.writeObject(value.responseOutputMessage)
                value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                value.computerCall != null -> generator.writeObject(value.computerCall)
                value.computerCallOutput != null -> generator.writeObject(value.computerCallOutput)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseItem")
            }
        }
    }
}
