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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Details of the tool call. */
@NoAutoDetect
class ToolCallsStepDetails
@JsonCreator
private constructor(
    @JsonProperty("tool_calls")
    @ExcludeMissing
    private val toolCalls: JsonField<List<ToolCall>> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    fun toolCalls(): List<ToolCall> = toolCalls.getRequired("tool_calls")

    /** Always `tool_calls`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ToolCall>> = toolCalls

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ToolCallsStepDetails = apply {
        if (validated) {
            return@apply
        }

        toolCalls().forEach { it.validate() }
        _type().let {
            if (it != JsonValue.from("tool_calls")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ToolCallsStepDetails].
         *
         * The following fields are required:
         * ```java
         * .toolCalls()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ToolCallsStepDetails]. */
    class Builder internal constructor() {

        private var toolCalls: JsonField<MutableList<ToolCall>>? = null
        private var type: JsonValue = JsonValue.from("tool_calls")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolCallsStepDetails: ToolCallsStepDetails) = apply {
            toolCalls = toolCallsStepDetails.toolCalls.map { it.toMutableList() }
            type = toolCallsStepDetails.type
            additionalProperties = toolCallsStepDetails.additionalProperties.toMutableMap()
        }

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun toolCalls(toolCalls: List<ToolCall>) = toolCalls(JsonField.of(toolCalls))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun toolCalls(toolCalls: JsonField<List<ToolCall>>) = apply {
            this.toolCalls = toolCalls.map { it.toMutableList() }
        }

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(toolCall: ToolCall) = apply {
            toolCalls =
                (toolCalls ?: JsonField.of(mutableListOf())).also {
                    checkKnown("toolCalls", it).add(toolCall)
                }
        }

        /** Details of the Code Interpreter tool call the run step was involved in. */
        fun addToolCall(codeInterpreter: CodeInterpreterToolCall) =
            addToolCall(ToolCall.ofCodeInterpreter(codeInterpreter))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(fileSearch: FileSearchToolCall) =
            addToolCall(ToolCall.ofFileSearch(fileSearch))

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun addToolCall(function: FunctionToolCall) = addToolCall(ToolCall.ofFunction(function))

        /** Always `tool_calls`. */
        fun type(type: JsonValue) = apply { this.type = type }

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

        fun build(): ToolCallsStepDetails =
            ToolCallsStepDetails(
                checkRequired("toolCalls", toolCalls).map { it.toImmutable() },
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ToolCallsStepDetails && toolCalls == other.toolCalls && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(toolCalls, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ToolCallsStepDetails{toolCalls=$toolCalls, type=$type, additionalProperties=$additionalProperties}"
}
