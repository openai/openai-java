// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Details of the tool call. */
class ToolCallDeltaObject
private constructor(
    private val type: JsonValue,
    private val toolCalls: JsonField<List<ToolCallDelta>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("tool_calls")
        @ExcludeMissing
        toolCalls: JsonField<List<ToolCallDelta>> = JsonMissing.of(),
    ) : this(type, toolCalls, mutableMapOf())

    /**
     * Always `tool_calls`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("tool_calls")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolCalls(): Optional<List<ToolCallDelta>> = toolCalls.getOptional("tool_calls")

    /**
     * Returns the raw JSON value of [toolCalls].
     *
     * Unlike [toolCalls], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ToolCallDelta>> = toolCalls

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ToolCallDeltaObject]. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("tool_calls")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * An array of tool calls the run step was involved in. These can be associated with one of
         * three types of tools: `code_interpreter`, `file_search`, or `function`.
         */
        fun toolCalls(toolCalls: List<ToolCallDelta>) = toolCalls(JsonField.of(toolCalls))

        /**
         * Sets [Builder.toolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolCalls] with a well-typed `List<ToolCallDelta>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolCalls(toolCalls: JsonField<List<ToolCallDelta>>) = apply {
            this.toolCalls = toolCalls.map { it.toMutableList() }
        }

        /**
         * Adds a single [ToolCallDelta] to [toolCalls].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addToolCall(toolCall: ToolCallDelta) = apply {
            toolCalls =
                (toolCalls ?: JsonField.of(mutableListOf())).also {
                    checkKnown("toolCalls", it).add(toolCall)
                }
        }

        /**
         * Alias for calling [addToolCall] with `ToolCallDelta.ofCodeInterpreter(codeInterpreter)`.
         */
        fun addToolCall(codeInterpreter: CodeInterpreterToolCallDelta) =
            addToolCall(ToolCallDelta.ofCodeInterpreter(codeInterpreter))

        /**
         * Alias for calling [addToolCall] with the following:
         * ```java
         * CodeInterpreterToolCallDelta.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addCodeInterpreterToolCall(index: Long) =
            addToolCall(CodeInterpreterToolCallDelta.builder().index(index).build())

        /** Alias for calling [addToolCall] with `ToolCallDelta.ofFileSearch(fileSearch)`. */
        fun addToolCall(fileSearch: FileSearchToolCallDelta) =
            addToolCall(ToolCallDelta.ofFileSearch(fileSearch))

        /** Alias for calling [addToolCall] with `ToolCallDelta.ofFunction(function)`. */
        fun addToolCall(function: FunctionToolCallDelta) =
            addToolCall(ToolCallDelta.ofFunction(function))

        /**
         * Alias for calling [addToolCall] with the following:
         * ```java
         * FunctionToolCallDelta.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addFunctionToolCall(index: Long) =
            addToolCall(FunctionToolCallDelta.builder().index(index).build())

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

        /**
         * Returns an immutable instance of [ToolCallDeltaObject].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ToolCallDeltaObject =
            ToolCallDeltaObject(
                type,
                (toolCalls ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

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
        type.let { if (it == JsonValue.from("tool_calls")) 1 else 0 } +
            (toolCalls.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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
