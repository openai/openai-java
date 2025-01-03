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

@JsonDeserialize(using = AssistantTool.Deserializer::class)
@JsonSerialize(using = AssistantTool.Serializer::class)
class AssistantTool
private constructor(
    private val codeInterpreterTool: CodeInterpreterTool? = null,
    private val fileSearchTool: FileSearchTool? = null,
    private val functionTool: FunctionTool? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun codeInterpreterTool(): Optional<CodeInterpreterTool> =
        Optional.ofNullable(codeInterpreterTool)

    fun fileSearchTool(): Optional<FileSearchTool> = Optional.ofNullable(fileSearchTool)

    fun functionTool(): Optional<FunctionTool> = Optional.ofNullable(functionTool)

    fun isCodeInterpreterTool(): Boolean = codeInterpreterTool != null

    fun isFileSearchTool(): Boolean = fileSearchTool != null

    fun isFunctionTool(): Boolean = functionTool != null

    fun asCodeInterpreterTool(): CodeInterpreterTool =
        codeInterpreterTool.getOrThrow("codeInterpreterTool")

    fun asFileSearchTool(): FileSearchTool = fileSearchTool.getOrThrow("fileSearchTool")

    fun asFunctionTool(): FunctionTool = functionTool.getOrThrow("functionTool")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            codeInterpreterTool != null -> visitor.visitCodeInterpreterTool(codeInterpreterTool)
            fileSearchTool != null -> visitor.visitFileSearchTool(fileSearchTool)
            functionTool != null -> visitor.visitFunctionTool(functionTool)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): AssistantTool = apply {
        if (!validated) {
            if (codeInterpreterTool == null && fileSearchTool == null && functionTool == null) {
                throw OpenAIInvalidDataException("Unknown AssistantTool: $_json")
            }
            codeInterpreterTool?.validate()
            fileSearchTool?.validate()
            functionTool?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantTool && codeInterpreterTool == other.codeInterpreterTool && fileSearchTool == other.fileSearchTool && functionTool == other.functionTool /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterTool, fileSearchTool, functionTool) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreterTool != null -> "AssistantTool{codeInterpreterTool=$codeInterpreterTool}"
            fileSearchTool != null -> "AssistantTool{fileSearchTool=$fileSearchTool}"
            functionTool != null -> "AssistantTool{functionTool=$functionTool}"
            _json != null -> "AssistantTool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssistantTool")
        }

    companion object {

        @JvmStatic
        fun ofCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool) =
            AssistantTool(codeInterpreterTool = codeInterpreterTool)

        @JvmStatic
        fun ofFileSearchTool(fileSearchTool: FileSearchTool) =
            AssistantTool(fileSearchTool = fileSearchTool)

        @JvmStatic
        fun ofFunctionTool(functionTool: FunctionTool) = AssistantTool(functionTool = functionTool)
    }

    interface Visitor<out T> {

        fun visitCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool): T

        fun visitFileSearchTool(fileSearchTool: FileSearchTool): T

        fun visitFunctionTool(functionTool: FunctionTool): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantTool: $json")
        }
    }

    class Deserializer : BaseDeserializer<AssistantTool>(AssistantTool::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantTool {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) { it.validate() }
                        ?.let {
                            return AssistantTool(codeInterpreterTool = it, _json = json)
                        }
                }
                "file_search" -> {
                    tryDeserialize(node, jacksonTypeRef<FileSearchTool>()) { it.validate() }
                        ?.let {
                            return AssistantTool(fileSearchTool = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<FunctionTool>()) { it.validate() }
                        ?.let {
                            return AssistantTool(functionTool = it, _json = json)
                        }
                }
            }

            return AssistantTool(_json = json)
        }
    }

    class Serializer : BaseSerializer<AssistantTool>(AssistantTool::class) {

        override fun serialize(
            value: AssistantTool,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.codeInterpreterTool != null ->
                    generator.writeObject(value.codeInterpreterTool)
                value.fileSearchTool != null -> generator.writeObject(value.fileSearchTool)
                value.functionTool != null -> generator.writeObject(value.functionTool)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssistantTool")
            }
        }
    }
}
