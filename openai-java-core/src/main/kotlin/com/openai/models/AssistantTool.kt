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
    private val codeInterpreter: CodeInterpreterTool? = null,
    private val fileSearch: FileSearchTool? = null,
    private val function: FunctionTool? = null,
    private val _json: JsonValue? = null,
) {

    fun codeInterpreter(): Optional<CodeInterpreterTool> = Optional.ofNullable(codeInterpreter)

    fun fileSearch(): Optional<FileSearchTool> = Optional.ofNullable(fileSearch)

    fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

    fun isCodeInterpreter(): Boolean = codeInterpreter != null

    fun isFileSearch(): Boolean = fileSearch != null

    fun isFunction(): Boolean = function != null

    fun asCodeInterpreter(): CodeInterpreterTool = codeInterpreter.getOrThrow("codeInterpreter")

    fun asFileSearch(): FileSearchTool = fileSearch.getOrThrow("fileSearch")

    fun asFunction(): FunctionTool = function.getOrThrow("function")

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

    fun validate(): AssistantTool = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool) {
                    codeInterpreter.validate()
                }

                override fun visitFileSearch(fileSearch: FileSearchTool) {
                    fileSearch.validate()
                }

                override fun visitFunction(function: FunctionTool) {
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

        return /* spotless:off */ other is AssistantTool && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && function == other.function /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch, function) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreter != null -> "AssistantTool{codeInterpreter=$codeInterpreter}"
            fileSearch != null -> "AssistantTool{fileSearch=$fileSearch}"
            function != null -> "AssistantTool{function=$function}"
            _json != null -> "AssistantTool{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssistantTool")
        }

    companion object {

        @JvmStatic
        fun ofCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
            AssistantTool(codeInterpreter = codeInterpreter)

        @JvmStatic
        fun ofFileSearch(fileSearch: FileSearchTool) = AssistantTool(fileSearch = fileSearch)

        @JvmStatic fun ofFunction(function: FunctionTool) = AssistantTool(function = function)
    }

    interface Visitor<out T> {

        fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

        fun visitFileSearch(fileSearch: FileSearchTool): T

        fun visitFunction(function: FunctionTool): T

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
                            return AssistantTool(codeInterpreter = it, _json = json)
                        }
                }
                "file_search" -> {
                    tryDeserialize(node, jacksonTypeRef<FileSearchTool>()) { it.validate() }
                        ?.let {
                            return AssistantTool(fileSearch = it, _json = json)
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<FunctionTool>()) { it.validate() }
                        ?.let {
                            return AssistantTool(function = it, _json = json)
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
                value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                value.function != null -> generator.writeObject(value.function)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssistantTool")
            }
        }
    }
}
