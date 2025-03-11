// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import kotlin.jvm.optionals.getOrNull

/**
 * Defines a function in your own code the model can choose to call. Learn more about
 * [function calling](https://platform.openai.com/docs/guides/function-calling).
 */
@NoAutoDetect
class FunctionTool
@JsonCreator
private constructor(
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("parameters")
    @ExcludeMissing
    private val parameters: JsonField<Parameters> = JsonMissing.of(),
    @JsonProperty("strict")
    @ExcludeMissing
    private val strict: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("description")
    @ExcludeMissing
    private val description: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The name of the function to call. */
    fun name(): String = name.getRequired("name")

    /** A JSON schema object describing the parameters of the function. */
    fun parameters(): Parameters = parameters.getRequired("parameters")

    /** Whether to enforce strict parameter validation. Default `true`. */
    fun strict(): Boolean = strict.getRequired("strict")

    /** The type of the function tool. Always `function`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * A description of the function. Used by the model to determine whether or not to call the
     * function.
     */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /** The name of the function to call. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** A JSON schema object describing the parameters of the function. */
    @JsonProperty("parameters")
    @ExcludeMissing
    fun _parameters(): JsonField<Parameters> = parameters

    /** Whether to enforce strict parameter validation. Default `true`. */
    @JsonProperty("strict") @ExcludeMissing fun _strict(): JsonField<Boolean> = strict

    /**
     * A description of the function. Used by the model to determine whether or not to call the
     * function.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FunctionTool = apply {
        if (validated) {
            return@apply
        }

        name()
        parameters().validate()
        strict()
        _type().let {
            if (it != JsonValue.from("function")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        description()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FunctionTool].
         *
         * The following fields are required:
         * ```java
         * .name()
         * .parameters()
         * .strict()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FunctionTool]. */
    class Builder internal constructor() {

        private var name: JsonField<String>? = null
        private var parameters: JsonField<Parameters>? = null
        private var strict: JsonField<Boolean>? = null
        private var type: JsonValue = JsonValue.from("function")
        private var description: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionTool: FunctionTool) = apply {
            name = functionTool.name
            parameters = functionTool.parameters
            strict = functionTool.strict
            type = functionTool.type
            description = functionTool.description
            additionalProperties = functionTool.additionalProperties.toMutableMap()
        }

        /** The name of the function to call. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the function to call. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** A JSON schema object describing the parameters of the function. */
        fun parameters(parameters: Parameters) = parameters(JsonField.of(parameters))

        /** A JSON schema object describing the parameters of the function. */
        fun parameters(parameters: JsonField<Parameters>) = apply { this.parameters = parameters }

        /** Whether to enforce strict parameter validation. Default `true`. */
        fun strict(strict: Boolean) = strict(JsonField.of(strict))

        /** Whether to enforce strict parameter validation. Default `true`. */
        fun strict(strict: JsonField<Boolean>) = apply { this.strict = strict }

        /** The type of the function tool. Always `function`. */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * A description of the function. Used by the model to determine whether or not to call the
         * function.
         */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /**
         * A description of the function. Used by the model to determine whether or not to call the
         * function.
         */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * A description of the function. Used by the model to determine whether or not to call the
         * function.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

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

        fun build(): FunctionTool =
            FunctionTool(
                checkRequired("name", name),
                checkRequired("parameters", parameters),
                checkRequired("strict", strict),
                type,
                description,
                additionalProperties.toImmutable(),
            )
    }

    /** A JSON schema object describing the parameters of the function. */
    @NoAutoDetect
    class Parameters
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Parameters = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Parameters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Parameters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(parameters: Parameters) = apply {
                additionalProperties = parameters.additionalProperties.toMutableMap()
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

            fun build(): Parameters = Parameters(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Parameters && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Parameters{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FunctionTool && name == other.name && parameters == other.parameters && strict == other.strict && type == other.type && description == other.description && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(name, parameters, strict, type, description, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FunctionTool{name=$name, parameters=$parameters, strict=$strict, type=$type, description=$description, additionalProperties=$additionalProperties}"
}
