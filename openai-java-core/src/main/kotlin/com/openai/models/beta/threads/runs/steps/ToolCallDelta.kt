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
@JsonDeserialize(using = ToolCallDelta.Deserializer::class)
@JsonSerialize(using = ToolCallDelta.Serializer::class)
class ToolCallDelta
private constructor(
    private val codeInterpreter: CodeInterpreterToolCallDelta? = null,
    private val fileSearch: FileSearchToolCallDelta? = null,
    private val function: FunctionToolCallDelta? = null,
    private val _json: JsonValue? = null,
) {

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun codeInterpreter(): Optional<CodeInterpreterToolCallDelta> =
        Optional.ofNullable(codeInterpreter)

    fun fileSearch(): Optional<FileSearchToolCallDelta> = Optional.ofNullable(fileSearch)

    fun function(): Optional<FunctionToolCallDelta> = Optional.ofNullable(function)

    fun isCodeInterpreter(): Boolean = codeInterpreter != null

    fun isFileSearch(): Boolean = fileSearch != null

    fun isFunction(): Boolean = function != null

    /** Details of the Code Interpreter tool call the run step was involved in. */
    fun asCodeInterpreter(): CodeInterpreterToolCallDelta =
        codeInterpreter.getOrThrow("codeInterpreter")

    fun asFileSearch(): FileSearchToolCallDelta = fileSearch.getOrThrow("fileSearch")

    fun asFunction(): FunctionToolCallDelta = function.getOrThrow("function")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
            fileSearch != null -> visitor.visitFileSearch(fileSearch)
            function != null -> visitor.visitFunction(function)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ToolCallDelta = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterToolCallDelta) {
                    codeInterpreter.validate()
                }

                override fun visitFileSearch(fileSearch: FileSearchToolCallDelta) {
                    fileSearch.validate()
                }

                override fun visitFunction(function: FunctionToolCallDelta) {
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
                override fun visitCodeInterpreter(codeInterpreter: CodeInterpreterToolCallDelta) =
                    codeInterpreter.validity()

                override fun visitFileSearch(fileSearch: FileSearchToolCallDelta) =
                    fileSearch.validity()

                override fun visitFunction(function: FunctionToolCallDelta) = function.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCallDelta && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && function == other.function /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch, function) /* spotless:on */

    override fun toString(): String =
        when {
            codeInterpreter != null -> "ToolCallDelta{codeInterpreter=$codeInterpreter}"
            fileSearch != null -> "ToolCallDelta{fileSearch=$fileSearch}"
            function != null -> "ToolCallDelta{function=$function}"
            _json != null -> "ToolCallDelta{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ToolCallDelta")
        }

    companion object {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        @JvmStatic
        fun ofCodeInterpreter(codeInterpreter: CodeInterpreterToolCallDelta) =
            ToolCallDelta(codeInterpreter = codeInterpreter)

        @JvmStatic
        fun ofFileSearch(fileSearch: FileSearchToolCallDelta) =
            ToolCallDelta(fileSearch = fileSearch)

        @JvmStatic
        fun ofFunction(function: FunctionToolCallDelta) = ToolCallDelta(function = function)
    }

    /**
     * An interface that defines how to map each variant of [ToolCallDelta] to a value of type [T].
     */
    interface Visitor<out T> {

        /** Details of the Code Interpreter tool call the run step was involved in. */
        fun visitCodeInterpreter(codeInterpreter: CodeInterpreterToolCallDelta): T

        fun visitFileSearch(fileSearch: FileSearchToolCallDelta): T

        fun visitFunction(function: FunctionToolCallDelta): T

        /**
         * Maps an unknown variant of [ToolCallDelta] to a value of type [T].
         *
         * An instance of [ToolCallDelta] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ToolCallDelta: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ToolCallDelta>(ToolCallDelta::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ToolCallDelta {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "code_interpreter" -> {
                    return tryDeserialize(node, jacksonTypeRef<CodeInterpreterToolCallDelta>())
                        ?.let { ToolCallDelta(codeInterpreter = it, _json = json) }
                        ?: ToolCallDelta(_json = json)
                }
                "file_search" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileSearchToolCallDelta>())?.let {
                        ToolCallDelta(fileSearch = it, _json = json)
                    } ?: ToolCallDelta(_json = json)
                }
                "function" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionToolCallDelta>())?.let {
                        ToolCallDelta(function = it, _json = json)
                    } ?: ToolCallDelta(_json = json)
                }
            }

            return ToolCallDelta(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ToolCallDelta>(ToolCallDelta::class) {

        override fun serialize(
            value: ToolCallDelta,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                value.fileSearch != null -> generator.writeObject(value.fileSearch)
                value.function != null -> generator.writeObject(value.function)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ToolCallDelta")
            }
        }
    }
}
