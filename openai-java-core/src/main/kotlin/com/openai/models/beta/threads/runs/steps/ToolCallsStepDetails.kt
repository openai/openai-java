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
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Details of the tool call. */
class ToolCallsStepDetails
private constructor(
    private val toolCalls: JsonField<List<ToolCall>>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tool_calls")
        @ExcludeMissing
        toolCalls: JsonField<List<ToolCall>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(toolCalls, type, mutableMapOf())

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolCalls(): List<ToolCall> = toolCalls.getRequired("tool_calls")

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
     * Returns the raw JSON value of [toolCalls].
     *
     * Unlike [toolCalls], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ToolCall>> = toolCalls

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
         * Sets [Builder.toolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolCalls] with a well-typed `List<ToolCall>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolCalls(toolCalls: JsonField<List<ToolCall>>) = apply {
            this.toolCalls = toolCalls.map { it.toMutableList() }
        }

        /**
         * Adds a single [ToolCall] to [toolCalls].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addToolCall(toolCall: ToolCall) = apply {
            toolCalls =
                (toolCalls ?: JsonField.of(mutableListOf())).also {
                    checkKnown("toolCalls", it).add(toolCall)
                }
        }

        /** Alias for calling [addToolCall] with `ToolCall.ofCodeInterpreter(codeInterpreter)`. */
        fun addToolCall(codeInterpreter: CodeInterpreterToolCall) =
            addToolCall(ToolCall.ofCodeInterpreter(codeInterpreter))

        /** Alias for calling [addToolCall] with `ToolCall.ofFileSearch(fileSearch)`. */
        fun addToolCall(fileSearch: FileSearchToolCall) =
            addToolCall(ToolCall.ofFileSearch(fileSearch))

        /** Alias for calling [addToolCall] with `ToolCall.ofFunction(function)`. */
        fun addToolCall(function: FunctionToolCall) = addToolCall(ToolCall.ofFunction(function))

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
         * Returns an immutable instance of [ToolCallsStepDetails].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .toolCalls()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ToolCallsStepDetails =
            ToolCallsStepDetails(
                checkRequired("toolCalls", toolCalls).map { it.toImmutable() },
                type,
                additionalProperties.toMutableMap(),
            )
    }

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
        (toolCalls.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            type.let { if (it == JsonValue.from("tool_calls")) 1 else 0 }

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
