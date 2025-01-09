// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
    private val codeInterpreterToolCall: CodeInterpreterToolCall? = null,
    private val fileSearchToolCall: FileSearchToolCall? = null,
    private val functionToolCall: FunctionToolCall? = null,
    private val _json: JsonValue? = null,
) {

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun codeInterpreterToolCall(): Optional<CodeInterpreterToolCall> =
        Optional.ofNullable(codeInterpreterToolCall)

    fun fileSearchToolCall(): Optional<FileSearchToolCall> = Optional.ofNullable(fileSearchToolCall)

    fun functionToolCall(): Optional<FunctionToolCall> = Optional.ofNullable(functionToolCall)

    fun isCodeInterpreterToolCall(): Boolean = codeInterpreterToolCall != null

    fun isFileSearchToolCall(): Boolean = fileSearchToolCall != null

    fun isFunctionToolCall(): Boolean = functionToolCall != null

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun asCodeInterpreterToolCall(): CodeInterpreterToolCall =
        codeInterpreterToolCall.getOrThrow("codeInterpreterToolCall")

    fun asFileSearchToolCall(): FileSearchToolCall =
        fileSearchToolCall.getOrThrow("fileSearchToolCall")

    fun asFunctionToolCall(): FunctionToolCall = functionToolCall.getOrThrow("functionToolCall")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            codeInterpreterToolCall != null ->
                visitor.visitCodeInterpreterToolCall(codeInterpreterToolCall)
            fileSearchToolCall != null -> visitor.visitFileSearchToolCall(fileSearchToolCall)
            functionToolCall != null -> visitor.visitFunctionToolCall(functionToolCall)
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
                override fun visitCodeInterpreterToolCall(
                    codeInterpreterToolCall: CodeInterpreterToolCall
                ) {
                    codeInterpreterToolCall.validate()
                }

                override fun visitFileSearchToolCall(fileSearchToolCall: FileSearchToolCall) {
                    fileSearchToolCall.validate()
                }

                override fun visitFunctionToolCall(functionToolCall: FunctionToolCall) {
                    functionToolCall.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCall && codeInterpreterToolCall == other.codeInterpreterToolCall && fileSearchToolCall == other.fileSearchToolCall && functionToolCall == other.functionToolCall /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterToolCall, fileSearchToolCall, functionToolCall) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreterToolCall != null ->
                "ToolCall{codeInterpreterToolCall=$codeInterpreterToolCall}"
            fileSearchToolCall != null -> "ToolCall{fileSearchToolCall=$fileSearchToolCall}"
            functionToolCall != null -> "ToolCall{functionToolCall=$functionToolCall}"
            _json != null -> "ToolCall{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ToolCall")
        }

    companion object {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        @JvmStatic
        fun ofCodeInterpreterToolCall(codeInterpreterToolCall: CodeInterpreterToolCall) =
            ToolCall(codeInterpreterToolCall = codeInterpreterToolCall)

        @JvmStatic
        fun ofFileSearchToolCall(fileSearchToolCall: FileSearchToolCall) =
            ToolCall(fileSearchToolCall = fileSearchToolCall)

        @JvmStatic
        fun ofFunctionToolCall(functionToolCall: FunctionToolCall) =
            ToolCall(functionToolCall = functionToolCall)
    }

    interface Visitor<out T> {

        fun visitCodeInterpreterToolCall(codeInterpreterToolCall: CodeInterpreterToolCall): T

        fun visitFileSearchToolCall(fileSearchToolCall: FileSearchToolCall): T

        fun visitFunctionToolCall(functionToolCall: FunctionToolCall): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ToolCall: $json")
        }
    }

    class Deserializer : BaseDeserializer<ToolCall>(ToolCall::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ToolCall {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    tryDeserialize(node, jacksonTypeRef<CodeInterpreterToolCall>()) {
                            it.validate()
                        }
                        ?.let {
                            return ToolCall(codeInterpreterToolCall = it, _json = json)
                        }
                }
                "file_search" -> {
                    tryDeserialize(node, jacksonTypeRef<FileSearchToolCall>()) { it.validate() }
                        ?.let {
                            return ToolCall(fileSearchToolCall = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<FunctionToolCall>()) { it.validate() }
                        ?.let {
                            return ToolCall(functionToolCall = it, _json = json)
                        }
                }
            }

            return ToolCall(_json = json)
        }
    }

    class Serializer : BaseSerializer<ToolCall>(ToolCall::class) {

        override fun serialize(
            value: ToolCall,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.codeInterpreterToolCall != null ->
                    generator.writeObject(value.codeInterpreterToolCall)
                value.fileSearchToolCall != null -> generator.writeObject(value.fileSearchToolCall)
                value.functionToolCall != null -> generator.writeObject(value.functionToolCall)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ToolCall")
            }
        }
    }
}
