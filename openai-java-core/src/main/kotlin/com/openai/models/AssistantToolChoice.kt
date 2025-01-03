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

/** Specifies a tool the model should use. Use to force the model to call a specific tool. */
@NoAutoDetect
class AssistantToolChoice
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("function")
    @ExcludeMissing
    private val function: JsonField<AssistantToolChoiceFunction> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of the tool. If type is `function`, the function name must be set */
    fun type(): Type = type.getRequired("type")

    fun function(): Optional<AssistantToolChoiceFunction> =
        Optional.ofNullable(function.getNullable("function"))

    /** The type of the tool. If type is `function`, the function name must be set */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("function") @ExcludeMissing fun _function() = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): AssistantToolChoice = apply {
        if (!validated) {
            type()
            function().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var function: JsonField<AssistantToolChoiceFunction> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(assistantToolChoice: AssistantToolChoice) = apply {
            type = assistantToolChoice.type
            function = assistantToolChoice.function
            additionalProperties = assistantToolChoice.additionalProperties.toMutableMap()
        }

        /** The type of the tool. If type is `function`, the function name must be set */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the tool. If type is `function`, the function name must be set */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun function(function: AssistantToolChoiceFunction) = function(JsonField.of(function))

        fun function(function: JsonField<AssistantToolChoiceFunction>) = apply {
            this.function = function
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

        fun build(): AssistantToolChoice =
            AssistantToolChoice(
                type,
                function,
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

            @JvmField val FUNCTION = of("function")

            @JvmField val CODE_INTERPRETER = of("code_interpreter")

            @JvmField val FILE_SEARCH = of("file_search")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FUNCTION,
            CODE_INTERPRETER,
            FILE_SEARCH,
        }

        enum class Value {
            FUNCTION,
            CODE_INTERPRETER,
            FILE_SEARCH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FUNCTION -> Value.FUNCTION
                CODE_INTERPRETER -> Value.CODE_INTERPRETER
                FILE_SEARCH -> Value.FILE_SEARCH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FUNCTION -> Known.FUNCTION
                CODE_INTERPRETER -> Known.CODE_INTERPRETER
                FILE_SEARCH -> Known.FILE_SEARCH
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

        return /* spotless:off */ other is AssistantToolChoice && type == other.type && function == other.function && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, function, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AssistantToolChoice{type=$type, function=$function, additionalProperties=$additionalProperties}"
}
