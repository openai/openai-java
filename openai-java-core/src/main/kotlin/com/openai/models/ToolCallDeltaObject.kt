// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("tool_calls")
    @ExcludeMissing
    private val toolCalls: JsonField<List<ToolCallDelta>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `tool_calls`. */
    fun type(): Type = type.getRequired("type")

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    fun toolCalls(): Optional<List<ToolCallDelta>> =
        Optional.ofNullable(toolCalls.getNullable("tool_calls"))

    /** Always `tool_calls`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /**
     * An array of tool calls the run step was involved in. These can be associated with one of
     * three types of tools: `code_interpreter`, `file_search`, or `function`.
     */
    @JsonProperty("tool_calls") @ExcludeMissing fun _toolCalls() = toolCalls

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ToolCallDeltaObject = apply {
        if (!validated) {
            type()
            toolCalls()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var toolCalls: JsonField<List<ToolCallDelta>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(toolCallDeltaObject: ToolCallDeltaObject) = apply {
            type = toolCallDeltaObject.type
            toolCalls = toolCallDeltaObject.toolCalls
            additionalProperties = toolCallDeltaObject.additionalProperties.toMutableMap()
        }

        /** Always `tool_calls`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `tool_calls`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
            this.toolCalls = toolCalls
        }

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
                toolCalls.map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TOOL_CALLS = of("tool_calls")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            TOOL_CALLS,
        }

        enum class Value {
            TOOL_CALLS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TOOL_CALLS -> Value.TOOL_CALLS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TOOL_CALLS -> Known.TOOL_CALLS
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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
