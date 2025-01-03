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

@NoAutoDetect
class FunctionToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("function")
    @ExcludeMissing
    private val function: JsonField<Function> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the tool call object. */
    fun id(): String = id.getRequired("id")

    /** The type of tool call. This is always going to be `function` for this type of tool call. */
    fun type(): Type = type.getRequired("type")

    /** The definition of the function that was called. */
    fun function(): Function = function.getRequired("function")

    /** The ID of the tool call object. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The type of tool call. This is always going to be `function` for this type of tool call. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The definition of the function that was called. */
    @JsonProperty("function") @ExcludeMissing fun _function() = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FunctionToolCall = apply {
        if (!validated) {
            id()
            type()
            function().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var function: JsonField<Function> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionToolCall: FunctionToolCall) = apply {
            id = functionToolCall.id
            type = functionToolCall.type
            function = functionToolCall.function
            additionalProperties = functionToolCall.additionalProperties.toMutableMap()
        }

        /** The ID of the tool call object. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the tool call object. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The type of tool call. This is always going to be `function` for this type of tool call.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of tool call. This is always going to be `function` for this type of tool call.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The definition of the function that was called. */
        fun function(function: Function) = function(JsonField.of(function))

        /** The definition of the function that was called. */
        fun function(function: JsonField<Function>) = apply { this.function = function }

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

        fun build(): FunctionToolCall =
            FunctionToolCall(
                id,
                type,
                function,
                additionalProperties.toImmutable(),
            )
    }

    /** The definition of the function that was called. */
    @NoAutoDetect
    class Function
    @JsonCreator
    private constructor(
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("arguments")
        @ExcludeMissing
        private val arguments: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        private val output: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The name of the function. */
        fun name(): String = name.getRequired("name")

        /** The arguments passed to the function. */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The output of the function. This will be `null` if the outputs have not been
         * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs) yet.
         */
        fun output(): Optional<String> = Optional.ofNullable(output.getNullable("output"))

        /** The name of the function. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /** The arguments passed to the function. */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

        /**
         * The output of the function. This will be `null` if the outputs have not been
         * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs) yet.
         */
        @JsonProperty("output") @ExcludeMissing fun _output() = output

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Function = apply {
            if (!validated) {
                name()
                arguments()
                output()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: JsonField<String> = JsonMissing.of()
            private var arguments: JsonField<String> = JsonMissing.of()
            private var output: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                name = function.name
                arguments = function.arguments
                output = function.output
                additionalProperties = function.additionalProperties.toMutableMap()
            }

            /** The name of the function. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The arguments passed to the function. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /** The arguments passed to the function. */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /**
             * The output of the function. This will be `null` if the outputs have not been
             * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
             * yet.
             */
            fun output(output: String) = output(JsonField.of(output))

            /**
             * The output of the function. This will be `null` if the outputs have not been
             * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
             * yet.
             */
            fun output(output: JsonField<String>) = apply { this.output = output }

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

            fun build(): Function =
                Function(
                    name,
                    arguments,
                    output,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && name == other.name && arguments == other.arguments && output == other.output && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(name, arguments, output, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{name=$name, arguments=$arguments, output=$output, additionalProperties=$additionalProperties}"
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FUNCTION = of("function")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FUNCTION,
        }

        enum class Value {
            FUNCTION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FUNCTION -> Value.FUNCTION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FUNCTION -> Known.FUNCTION
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

        return /* spotless:off */ other is FunctionToolCall && id == other.id && type == other.type && function == other.function && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, type, function, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FunctionToolCall{id=$id, type=$type, function=$function, additionalProperties=$additionalProperties}"
}
