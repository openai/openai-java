// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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

/** Details of the Code Interpreter tool call the run step was involved in. */
@JsonDeserialize(using = ToolCall.Deserializer::class)
@JsonSerialize(using = ToolCall.Serializer::class)
class ToolCall
private constructor(
    private val codeInterpreter: CodeInterpreterToolCall? = null,
    private val fileSearch: FileSearchToolCall? = null,
    private val function: FunctionToolCall? = null,
    private val _json: JsonValue? = null,
) {

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun codeInterpreter(): Optional<CodeInterpreterToolCall> = Optional.ofNullable(codeInterpreter)

    fun fileSearch(): Optional<FileSearchToolCall> = Optional.ofNullable(fileSearch)

    fun function(): Optional<FunctionToolCall> = Optional.ofNullable(function)

    fun isCodeInterpreter(): Boolean = codeInterpreter != null

    fun isFileSearch(): Boolean = fileSearch != null

    fun isFunction(): Boolean = function != null

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun asCodeInterpreter(): CodeInterpreterToolCall = codeInterpreter.getOrThrow("codeInterpreter")

    fun asFileSearch(): FileSearchToolCall = fileSearch.getOrThrow("fileSearch")

    fun asFunction(): FunctionToolCall = function.getOrThrow("function")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            function != null -> visitor.visitFunction(function)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ToolCall = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterToolCall) {
                    codeInterpreter.validate()
                }

                override fun visitFileSearch(fileSearch: FileSearchToolCall) {
                    fileSearch.validate()
                }

                override fun visitFunction(function: FunctionToolCall) {
                    function.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCall && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && function == other.function /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch, function) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreter != null -> "ToolCall{codeInterpreter=$codeInterpreter}"
            fileSearch != null -> "ToolCall{fileSearch=$fileSearch}"
            function != null -> "ToolCall{function=$function}"
            _json != null -> "ToolCall{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ToolCall")
        }

    companion object {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        @JvmStatic
        fun ofCodeInterpreter(codeInterpreter: CodeInterpreterToolCall) =
            ToolCall(codeInterpreter = codeInterpreter)

        @JvmStatic
        fun ofFileSearch(fileSearch: FileSearchToolCall) = ToolCall(fileSearch = fileSearch)

        @JvmStatic fun ofFunction(function: FunctionToolCall) = ToolCall(function = function)
    }

    /** An interface that defines how to map each variant of [ToolCall] to a value of type [T]. */
    interface Visitor<out T> {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        fun visitCodeInterpreter(codeInterpreter: CodeInterpreterToolCall): T

        fun visitFileSearch(fileSearch: FileSearchToolCall): T

        fun visitFunction(function: FunctionToolCall): T

        /**
         * Maps an unknown variant of [ToolCall] to a value of type [T].
         *
         * An instance of [ToolCall] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ToolCall: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ToolCall>(ToolCall::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ToolCall {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    return ToolCall(
                        codeInterpreter =
                            deserialize(node, jacksonTypeRef<CodeInterpreterToolCall>()),
                        _json = json,
                    )
                }
                "file_search" -> {
                    return ToolCall(
                        fileSearch = deserialize(node, jacksonTypeRef<FileSearchToolCall>()),
                        _json = json,
                    )
                }
                "function" -> {
                    return ToolCall(
                        function = deserialize(node, jacksonTypeRef<FunctionToolCall>()),
                        _json = json,
                    )
                }
            }

            return ToolCall(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ToolCall>(ToolCall::class) {

        override fun serialize(
            value: ToolCall,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                value.function != null -> generator.writeObject(value.function)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ToolCall")
            }
        }
    }
}
