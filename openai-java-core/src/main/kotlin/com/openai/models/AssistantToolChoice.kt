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
import com.openai.core.checkRequired
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
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("function")
    @ExcludeMissing
    fun _function(): JsonField<AssistantToolChoiceFunction> = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): AssistantToolChoice = apply {
        if (validated) {
            return@apply
        }

        type()
        function().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AssistantToolChoice]. */
    class Builder internal constructor() {

        private var type: JsonField<Type>? = null
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
                checkRequired("type", type),
                function,
                additionalProperties.toImmutable(),
            )
    }

    /** The type of the tool. If type is `function`, the function name must be set */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FUNCTION = of("function")

            @JvmField val CODE_INTERPRETER = of("code_interpreter")

            @JvmField val FILE_SEARCH = of("file_search")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FUNCTION,
            CODE_INTERPRETER,
            FILE_SEARCH,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FUNCTION,
            CODE_INTERPRETER,
            FILE_SEARCH,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FUNCTION -> Value.FUNCTION
                CODE_INTERPRETER -> Value.CODE_INTERPRETER
                FILE_SEARCH -> Value.FILE_SEARCH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
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
