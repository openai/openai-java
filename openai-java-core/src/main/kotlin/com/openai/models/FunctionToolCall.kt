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
import com.openai.core.checkRequired
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
    @JsonProperty("function")
    @ExcludeMissing
    private val function: JsonField<Function> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the tool call object. */
    fun id(): String = id.getRequired("id")

    /** The definition of the function that was called. */
    fun function(): Function = function.getRequired("function")

    /** The type of tool call. This is always going to be `function` for this type of tool call. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The ID of the tool call object. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The definition of the function that was called. */
    @JsonProperty("function") @ExcludeMissing fun _function(): JsonField<Function> = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FunctionToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        function().validate()
        _type().let {
            if (it != JsonValue.from("function")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var function: JsonField<Function>? = null
        private var type: JsonValue = JsonValue.from("function")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionToolCall: FunctionToolCall) = apply {
            id = functionToolCall.id
            function = functionToolCall.function
            type = functionToolCall.type
            additionalProperties = functionToolCall.additionalProperties.toMutableMap()
        }

        /** The ID of the tool call object. */
        fun id(id: String) = id(JsonField.of(id))

        /** The ID of the tool call object. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The definition of the function that was called. */
        fun function(function: Function) = function(JsonField.of(function))

        /** The definition of the function that was called. */
        fun function(function: JsonField<Function>) = apply { this.function = function }

        /**
         * The type of tool call. This is always going to be `function` for this type of tool call.
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

        fun build(): FunctionToolCall =
            FunctionToolCall(
                checkRequired("id", id),
                checkRequired("function", function),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** The definition of the function that was called. */
    @NoAutoDetect
    class Function
    @JsonCreator
    private constructor(
        @JsonProperty("arguments")
        @ExcludeMissing
        private val arguments: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        private val output: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The arguments passed to the function. */
        fun arguments(): String = arguments.getRequired("arguments")

        /** The name of the function. */
        fun name(): String = name.getRequired("name")

        /**
         * The output of the function. This will be `null` if the outputs have not been
         * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs) yet.
         */
        fun output(): Optional<String> = Optional.ofNullable(output.getNullable("output"))

        /** The arguments passed to the function. */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /** The name of the function. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * The output of the function. This will be `null` if the outputs have not been
         * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs) yet.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Function = apply {
            if (validated) {
                return@apply
            }

            arguments()
            name()
            output()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var output: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                arguments = function.arguments
                name = function.name
                output = function.output
                additionalProperties = function.additionalProperties.toMutableMap()
            }

            /** The arguments passed to the function. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /** The arguments passed to the function. */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the function. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * The output of the function. This will be `null` if the outputs have not been
             * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
             * yet.
             */
            fun output(output: String?) = output(JsonField.ofNullable(output))

            /**
             * The output of the function. This will be `null` if the outputs have not been
             * [submitted](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
             * yet.
             */
            fun output(output: Optional<String>) = output(output.orElse(null))

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
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
                    checkRequired("output", output),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && arguments == other.arguments && name == other.name && output == other.output && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(arguments, name, output, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{arguments=$arguments, name=$name, output=$output, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FunctionToolCall && id == other.id && function == other.function && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, function, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FunctionToolCall{id=$id, function=$function, type=$type, additionalProperties=$additionalProperties}"
}
