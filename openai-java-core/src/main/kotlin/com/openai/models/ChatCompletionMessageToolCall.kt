// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

@JsonDeserialize(builder = ChatCompletionMessageToolCall.Builder::class)
@NoAutoDetect
class ChatCompletionMessageToolCall
private constructor(
    private val id: JsonField<String>,
    private val type: JsonField<Type>,
    private val function: JsonField<Function>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The ID of the tool call. */
    fun id(): String = id.getRequired("id")

    /** The type of the tool. Currently, only `function` is supported. */
    fun type(): Type = type.getRequired("type")

    /** The function that the model called. */
    fun function(): Function = function.getRequired("function")

    /** The ID of the tool call. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The type of the tool. Currently, only `function` is supported. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The function that the model called. */
    @JsonProperty("function") @ExcludeMissing fun _function() = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionMessageToolCall = apply {
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
        internal fun from(chatCompletionMessageToolCall: ChatCompletionMessageToolCall) = apply {
            this.id = chatCompletionMessageToolCall.id
            this.type = chatCompletionMessageToolCall.type
            this.function = chatCompletionMessageToolCall.function
            additionalProperties(chatCompletionMessageToolCall.additionalProperties)
        }

        /** The ID of the tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the tool call. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The type of the tool. Currently, only `function` is supported. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the tool. Currently, only `function` is supported. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The function that the model called. */
        fun function(function: Function) = function(JsonField.of(function))

        /** The function that the model called. */
        @JsonProperty("function")
        @ExcludeMissing
        fun function(function: JsonField<Function>) = apply { this.function = function }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionMessageToolCall =
            ChatCompletionMessageToolCall(
                id,
                type,
                function,
                additionalProperties.toImmutable(),
            )
    }

    /** The function that the model called. */
    @JsonDeserialize(builder = Function.Builder::class)
    @NoAutoDetect
    class Function
    private constructor(
        private val name: JsonField<String>,
        private val arguments: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** The name of the function to call. */
        fun name(): String = name.getRequired("name")

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /** The name of the function to call. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Function = apply {
            if (!validated) {
                name()
                arguments()
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
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                this.name = function.name
                this.arguments = function.arguments
                additionalProperties(function.additionalProperties)
            }

            /** The name of the function to call. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function to call. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            @JsonProperty("arguments")
            @ExcludeMissing
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Function =
                Function(
                    name,
                    arguments,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && name == other.name && arguments == other.arguments && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(name, arguments, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{name=$name, arguments=$arguments, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is ChatCompletionMessageToolCall && id == other.id && type == other.type && function == other.function && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, type, function, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionMessageToolCall{id=$id, type=$type, function=$function, additionalProperties=$additionalProperties}"
}
