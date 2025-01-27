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
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class FunctionDefinition
@JsonCreator
private constructor(
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("description")
    @ExcludeMissing
    private val description: JsonField<String> = JsonMissing.of(),
    @JsonProperty("parameters")
    @ExcludeMissing
    private val parameters: JsonField<FunctionParameters> = JsonMissing.of(),
    @JsonProperty("strict")
    @ExcludeMissing
    private val strict: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
     * dashes, with a maximum length of 64.
     */
    fun name(): String = name.getRequired("name")

    /**
     * A description of what the function does, used by the model to choose when and how to call the
     * function.
     */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * The parameters the functions accepts, described as a JSON Schema object. See the
     * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
     * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for documentation
     * about the format.
     *
     * Omitting `parameters` defines a function with an empty parameter list.
     */
    fun parameters(): Optional<FunctionParameters> =
        Optional.ofNullable(parameters.getNullable("parameters"))

    /**
     * Whether to enable strict schema adherence when generating the function call. If set to true,
     * the model will follow the exact schema defined in the `parameters` field. Only a subset of
     * JSON Schema is supported when `strict` is `true`. Learn more about Structured Outputs in the
     * [function calling guide](docs/guides/function-calling).
     */
    fun strict(): Optional<Boolean> = Optional.ofNullable(strict.getNullable("strict"))

    /**
     * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
     * dashes, with a maximum length of 64.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * A description of what the function does, used by the model to choose when and how to call the
     * function.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * The parameters the functions accepts, described as a JSON Schema object. See the
     * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
     * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for documentation
     * about the format.
     *
     * Omitting `parameters` defines a function with an empty parameter list.
     */
    @JsonProperty("parameters")
    @ExcludeMissing
    fun _parameters(): JsonField<FunctionParameters> = parameters

    /**
     * Whether to enable strict schema adherence when generating the function call. If set to true,
     * the model will follow the exact schema defined in the `parameters` field. Only a subset of
     * JSON Schema is supported when `strict` is `true`. Learn more about Structured Outputs in the
     * [function calling guide](docs/guides/function-calling).
     */
    @JsonProperty("strict") @ExcludeMissing fun _strict(): JsonField<Boolean> = strict

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FunctionDefinition = apply {
        if (validated) {
            return@apply
        }

        name()
        description()
        parameters().ifPresent { it.validate() }
        strict()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FunctionDefinition]. */
    class Builder internal constructor() {

        private var name: JsonField<String>? = null
        private var description: JsonField<String> = JsonMissing.of()
        private var parameters: JsonField<FunctionParameters> = JsonMissing.of()
        private var strict: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionDefinition: FunctionDefinition) = apply {
            name = functionDefinition.name
            description = functionDefinition.description
            parameters = functionDefinition.parameters
            strict = functionDefinition.strict
            additionalProperties = functionDefinition.additionalProperties.toMutableMap()
        }

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * A description of what the function does, used by the model to choose when and how to call
         * the function.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         */
        fun parameters(parameters: FunctionParameters) = parameters(JsonField.of(parameters))

        /**
         * The parameters the functions accepts, described as a JSON Schema object. See the
         * [guide](https://platform.openai.com/docs/guides/function-calling) for examples, and the
         * [JSON Schema reference](https://json-schema.org/understanding-json-schema/) for
         * documentation about the format.
         *
         * Omitting `parameters` defines a function with an empty parameter list.
         */
        fun parameters(parameters: JsonField<FunctionParameters>) = apply {
            this.parameters = parameters
        }

        /**
         * Whether to enable strict schema adherence when generating the function call. If set to
         * true, the model will follow the exact schema defined in the `parameters` field. Only a
         * subset of JSON Schema is supported when `strict` is `true`. Learn more about Structured
         * Outputs in the [function calling guide](docs/guides/function-calling).
         */
        fun strict(strict: Boolean?) = strict(JsonField.ofNullable(strict))

        /**
         * Whether to enable strict schema adherence when generating the function call. If set to
         * true, the model will follow the exact schema defined in the `parameters` field. Only a
         * subset of JSON Schema is supported when `strict` is `true`. Learn more about Structured
         * Outputs in the [function calling guide](docs/guides/function-calling).
         */
        fun strict(strict: Boolean) = strict(strict as Boolean?)

        /**
         * Whether to enable strict schema adherence when generating the function call. If set to
         * true, the model will follow the exact schema defined in the `parameters` field. Only a
         * subset of JSON Schema is supported when `strict` is `true`. Learn more about Structured
         * Outputs in the [function calling guide](docs/guides/function-calling).
         */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun strict(strict: Optional<Boolean>) = strict(strict.orElse(null) as Boolean?)

        /**
         * Whether to enable strict schema adherence when generating the function call. If set to
         * true, the model will follow the exact schema defined in the `parameters` field. Only a
         * subset of JSON Schema is supported when `strict` is `true`. Learn more about Structured
         * Outputs in the [function calling guide](docs/guides/function-calling).
         */
        fun strict(strict: JsonField<Boolean>) = apply { this.strict = strict }

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

        fun build(): FunctionDefinition =
            FunctionDefinition(
                checkRequired("name", name),
                description,
                parameters,
                strict,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FunctionDefinition && name == other.name && description == other.description && parameters == other.parameters && strict == other.strict && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(name, description, parameters, strict, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FunctionDefinition{name=$name, description=$description, parameters=$parameters, strict=$strict, additionalProperties=$additionalProperties}"
}
