// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Details of the tool call. */
@NoAutoDetect
class ToolCallDeltaObject
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("tool_calls")
    @ExcludeMissing
    private val toolCalls: JsonField<List<ToolCallDelta>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `tool_calls`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    fun toolCalls(): Optional<List<ToolCallDelta>> =
        Optional.ofNullable(toolCalls.getNullable("tool_calls"))

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ToolCallDelta>> = toolCalls

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ToolCallDeltaObject = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("tool_calls")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        toolCalls().ifPresent { it.forEach { it.validate() } }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ToolCallDeltaObject]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("tool_calls")
        private var toolCalls: JsonField<MutableList<ToolCallDelta>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolCallDeltaObject: ToolCallDeltaObject) = apply {
            type = toolCallDeltaObject.type
            toolCalls = toolCallDeltaObject.toolCalls.map { it.toMutableList() }
            additionalProperties = toolCallDeltaObject.additionalProperties.toMutableMap()
        }

        /** Always `tool_calls`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun toolCalls(toolCalls: List<ToolCallDelta>) = toolCalls(JsonField.of(toolCalls))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun toolCalls(toolCalls: JsonField<List<ToolCallDelta>>) = apply {
            this.toolCalls = toolCalls.map { it.toMutableList() }
        }

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(toolCall: ToolCallDelta) = apply {
            toolCalls =
                (toolCalls ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(toolCall)
                }
        }

        /** Details of the Code Interpreter tool call the run step was involved in. */
        fun addToolCall(codeInterpreter: CodeInterpreterToolCallDelta) =
            addToolCall(ToolCallDelta.ofCodeInterpreter(codeInterpreter))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(fileSearch: FileSearchToolCallDelta) =
            addToolCall(ToolCallDelta.ofFileSearch(fileSearch))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(function: FunctionToolCallDelta) =
            addToolCall(ToolCallDelta.ofFunction(function))

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): ToolCallDeltaObject =
            ToolCallDeltaObject(
                type,
                (toolCalls ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCallDeltaObject && type == other.type && toolCalls == other.toolCalls && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, toolCalls, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolCallDeltaObject{type=$type, toolCalls=$toolCalls, additionalProperties=$additionalProperties}"
}
