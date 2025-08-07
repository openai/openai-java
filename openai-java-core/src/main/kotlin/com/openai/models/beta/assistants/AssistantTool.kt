// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

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

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            function != null -> visitor.visitFunction(function)
            else -> visitor.unknown(_json)
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
                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
                    codeInterpreter.validity()

                override fun visitFileSearch(fileSearch: FileSearchTool) = fileSearch.validity()

                override fun visitFunction(function: FunctionTool) = function.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

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

    /**
     * An interface that defines how to map each variant of [AssistantTool] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

        fun visitFileSearch(fileSearch: FileSearchTool): T

        fun visitFunction(function: FunctionTool): T

        /**
         * Maps an unknown variant of [AssistantTool] to a value of type [T].
         *
         * An instance of [AssistantTool] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantTool: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AssistantTool>(AssistantTool::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantTool {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    return tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>())?.let {
                        AssistantTool(codeInterpreter = it, _json = json)
                    } ?: AssistantTool(_json = json)
                }
                "file_search" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileSearchTool>())?.let {
                        AssistantTool(fileSearch = it, _json = json)
                    } ?: AssistantTool(_json = json)
                }
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionTool>())?.let {
                        AssistantTool(function = it, _json = json)
                    } ?: AssistantTool(_json = json)
                }
            }

            return AssistantTool(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AssistantTool>(AssistantTool::class) {

        override fun serialize(
            value: AssistantTool,
            generator: JsonGenerator,
            provider: SerializerProvider,
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
