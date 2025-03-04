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

/** Tool call objects */
@NoAutoDetect
class RequiredActionFunctionToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("function")
    @ExcludeMissing
    private val function: JsonField<Function> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The ID of the tool call. This ID must be referenced when you submit the tool outputs in using
     * the
     * [Submit tool outputs to run](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
     * endpoint.
     */
    fun id(): String = id.getRequired("id")

    /** The function definition. */
    fun function(): Function = function.getRequired("function")

    /** The type of tool call the output is required for. For now, this is always `function`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The ID of the tool call. This ID must be referenced when you submit the tool outputs in using
     * the
     * [Submit tool outputs to run](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
     * endpoint.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The function definition. */
    @JsonProperty("function") @ExcludeMissing fun _function(): JsonField<Function> = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RequiredActionFunctionToolCall = apply {
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

        /**
         * Returns a mutable builder for constructing an instance of
         * [RequiredActionFunctionToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .function()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RequiredActionFunctionToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var function: JsonField<Function>? = null
        private var type: JsonValue = JsonValue.from("function")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(requiredActionFunctionToolCall: RequiredActionFunctionToolCall) = apply {
            id = requiredActionFunctionToolCall.id
            function = requiredActionFunctionToolCall.function
            type = requiredActionFunctionToolCall.type
            additionalProperties =
                requiredActionFunctionToolCall.additionalProperties.toMutableMap()
        }

        /**
         * The ID of the tool call. This ID must be referenced when you submit the tool outputs in
         * using the
         * [Submit tool outputs to run](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
         * endpoint.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * The ID of the tool call. This ID must be referenced when you submit the tool outputs in
         * using the
         * [Submit tool outputs to run](https://platform.openai.com/docs/api-reference/runs/submitToolOutputs)
         * endpoint.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The function definition. */
        fun function(function: Function) = function(JsonField.of(function))

        /** The function definition. */
        fun function(function: JsonField<Function>) = apply { this.function = function }

        /** The type of tool call the output is required for. For now, this is always `function`. */
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

        fun build(): RequiredActionFunctionToolCall =
            RequiredActionFunctionToolCall(
                checkRequired("id", id),
                checkRequired("function", function),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** The function definition. */
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
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The arguments that the model expects you to pass to the function. */
        fun arguments(): String = arguments.getRequired("arguments")

        /** The name of the function. */
        fun name(): String = name.getRequired("name")

        /** The arguments that the model expects you to pass to the function. */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /** The name of the function. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Function].
             *
             * The following fields are required:
             * ```java
             * .arguments()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Function]. */
        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                arguments = function.arguments
                name = function.name
                additionalProperties = function.additionalProperties.toMutableMap()
            }

            /** The arguments that the model expects you to pass to the function. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /** The arguments that the model expects you to pass to the function. */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the function. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function. */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && arguments == other.arguments && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(arguments, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Function{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RequiredActionFunctionToolCall && id == other.id && function == other.function && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, function, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RequiredActionFunctionToolCall{id=$id, function=$function, type=$type, additionalProperties=$additionalProperties}"
}
