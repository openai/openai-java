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
@JsonDeserialize(using = ToolCallDelta.Deserializer::class)
@JsonSerialize(using = ToolCallDelta.Serializer::class)
class ToolCallDelta
private constructor(
    private val codeInterpreterToolCallDelta: CodeInterpreterToolCallDelta? = null,
    private val fileSearchToolCallDelta: FileSearchToolCallDelta? = null,
    private val functionToolCallDelta: FunctionToolCallDelta? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun codeInterpreterToolCallDelta(): Optional<CodeInterpreterToolCallDelta> =
        Optional.ofNullable(codeInterpreterToolCallDelta)

    fun fileSearchToolCallDelta(): Optional<FileSearchToolCallDelta> =
        Optional.ofNullable(fileSearchToolCallDelta)

    fun functionToolCallDelta(): Optional<FunctionToolCallDelta> =
        Optional.ofNullable(functionToolCallDelta)

    fun isCodeInterpreterToolCallDelta(): Boolean = codeInterpreterToolCallDelta != null

    fun isFileSearchToolCallDelta(): Boolean = fileSearchToolCallDelta != null

    fun isFunctionToolCallDelta(): Boolean = functionToolCallDelta != null

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun asCodeInterpreterToolCallDelta(): CodeInterpreterToolCallDelta =
        codeInterpreterToolCallDelta.getOrThrow("codeInterpreterToolCallDelta")

    fun asFileSearchToolCallDelta(): FileSearchToolCallDelta =
        fileSearchToolCallDelta.getOrThrow("fileSearchToolCallDelta")

    fun asFunctionToolCallDelta(): FunctionToolCallDelta =
        functionToolCallDelta.getOrThrow("functionToolCallDelta")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            codeInterpreterToolCallDelta != null ->
                visitor.visitCodeInterpreterToolCallDelta(codeInterpreterToolCallDelta)
            fileSearchToolCallDelta != null ->
                visitor.visitFileSearchToolCallDelta(fileSearchToolCallDelta)
            functionToolCallDelta != null ->
                visitor.visitFunctionToolCallDelta(functionToolCallDelta)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ToolCallDelta = apply {
        if (!validated) {
            if (
                codeInterpreterToolCallDelta == null &&
                    fileSearchToolCallDelta == null &&
                    functionToolCallDelta == null
            ) {
                throw OpenAIInvalidDataException("Unknown ToolCallDelta: $_json")
            }
            codeInterpreterToolCallDelta?.validate()
            fileSearchToolCallDelta?.validate()
            functionToolCallDelta?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCallDelta && codeInterpreterToolCallDelta == other.codeInterpreterToolCallDelta && fileSearchToolCallDelta == other.fileSearchToolCallDelta && functionToolCallDelta == other.functionToolCallDelta /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterToolCallDelta, fileSearchToolCallDelta, functionToolCallDelta) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreterToolCallDelta != null ->
                "ToolCallDelta{codeInterpreterToolCallDelta=$codeInterpreterToolCallDelta}"
            fileSearchToolCallDelta != null ->
                "ToolCallDelta{fileSearchToolCallDelta=$fileSearchToolCallDelta}"
            functionToolCallDelta != null ->
                "ToolCallDelta{functionToolCallDelta=$functionToolCallDelta}"
            _json != null -> "ToolCallDelta{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ToolCallDelta")
        }

    companion object {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        @JvmStatic
        fun ofCodeInterpreterToolCallDelta(
            codeInterpreterToolCallDelta: CodeInterpreterToolCallDelta
        ) = ToolCallDelta(codeInterpreterToolCallDelta = codeInterpreterToolCallDelta)

        @JvmStatic
        fun ofFileSearchToolCallDelta(fileSearchToolCallDelta: FileSearchToolCallDelta) =
            ToolCallDelta(fileSearchToolCallDelta = fileSearchToolCallDelta)

        @JvmStatic
        fun ofFunctionToolCallDelta(functionToolCallDelta: FunctionToolCallDelta) =
            ToolCallDelta(functionToolCallDelta = functionToolCallDelta)
    }

    interface Visitor<out T> {

        fun visitCodeInterpreterToolCallDelta(
            codeInterpreterToolCallDelta: CodeInterpreterToolCallDelta
        ): T

        fun visitFileSearchToolCallDelta(fileSearchToolCallDelta: FileSearchToolCallDelta): T

        fun visitFunctionToolCallDelta(functionToolCallDelta: FunctionToolCallDelta): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ToolCallDelta: $json")
        }
    }

    class Deserializer : BaseDeserializer<ToolCallDelta>(ToolCallDelta::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ToolCallDelta {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    tryDeserialize(node, jacksonTypeRef<CodeInterpreterToolCallDelta>()) {
                            it.validate()
                        }
                        ?.let {
                            return ToolCallDelta(codeInterpreterToolCallDelta = it, _json = json)
                        }
                }
                "file_search" -> {
                    tryDeserialize(node, jacksonTypeRef<FileSearchToolCallDelta>()) {
                            it.validate()
                        }
                        ?.let {
                            return ToolCallDelta(fileSearchToolCallDelta = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<FunctionToolCallDelta>()) { it.validate() }
                        ?.let {
                            return ToolCallDelta(functionToolCallDelta = it, _json = json)
                        }
                }
            }

            return ToolCallDelta(_json = json)
        }
    }

    class Serializer : BaseSerializer<ToolCallDelta>(ToolCallDelta::class) {

        override fun serialize(
            value: ToolCallDelta,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.codeInterpreterToolCallDelta != null ->
                    generator.writeObject(value.codeInterpreterToolCallDelta)
                value.fileSearchToolCallDelta != null ->
                    generator.writeObject(value.fileSearchToolCallDelta)
                value.functionToolCallDelta != null ->
                    generator.writeObject(value.functionToolCallDelta)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ToolCallDelta")
            }
        }
    }
}
