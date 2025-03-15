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
 * JSON Schema response format. Used to generate structured JSON responses. Learn more about
 * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
 */
@NoAutoDetect
class ResponseFormatTextJsonSchemaConfig
@JsonCreator
private constructor(
    @JsonProperty("schema")
    @ExcludeMissing
    private val schema: JsonField<Schema> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("description")
    @ExcludeMissing
    private val description: JsonField<String> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("strict")
    @ExcludeMissing
    private val strict: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The schema for the response format, described as a JSON Schema object. Learn how to build
     * JSON schemas [here](https://json-schema.org/).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun schema(): Schema = schema.getRequired("schema")

    /**
     * The type of response format being defined. Always `json_schema`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("json_schema")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * A description of what the response format is for, used by the model to determine how to
     * respond in the format.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> =
        Optional.ofNullable(description.getNullable("description"))

    /**
     * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and dashes,
     * with a maximum length of 64.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /**
     * Whether to enable strict schema adherence when generating the output. If set to true, the
     * model will always follow the exact schema defined in the `schema` field. Only a subset of
     * JSON Schema is supported when `strict` is `true`. To learn more, read the
     * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun strict(): Optional<Boolean> = Optional.ofNullable(strict.getNullable("strict"))

    /**
     * Returns the raw JSON value of [schema].
     *
     * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [strict].
     *
     * Unlike [strict], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("strict") @ExcludeMissing fun _strict(): JsonField<Boolean> = strict

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFormatTextJsonSchemaConfig = apply {
        if (validated) {
            return@apply
        }

        schema().validate()
        _type().let {
            if (it != JsonValue.from("json_schema")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        description()
        name()
        strict()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseFormatTextJsonSchemaConfig].
         *
         * The following fields are required:
         * ```java
         * .schema()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFormatTextJsonSchemaConfig]. */
    class Builder internal constructor() {

        private var schema: JsonField<Schema>? = null
        private var type: JsonValue = JsonValue.from("json_schema")
        private var description: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var strict: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFormatTextJsonSchemaConfig: ResponseFormatTextJsonSchemaConfig) =
            apply {
                schema = responseFormatTextJsonSchemaConfig.schema
                type = responseFormatTextJsonSchemaConfig.type
                description = responseFormatTextJsonSchemaConfig.description
                name = responseFormatTextJsonSchemaConfig.name
                strict = responseFormatTextJsonSchemaConfig.strict
                additionalProperties =
                    responseFormatTextJsonSchemaConfig.additionalProperties.toMutableMap()
            }

        /**
         * The schema for the response format, described as a JSON Schema object. Learn how to build
         * JSON schemas [here](https://json-schema.org/).
         */
        fun schema(schema: Schema) = schema(JsonField.of(schema))

        /**
         * Sets [Builder.schema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schema] with a well-typed [Schema] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("json_schema")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * A description of what the response format is for, used by the model to determine how to
         * respond in the format.
         */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Whether to enable strict schema adherence when generating the output. If set to true, the
         * model will always follow the exact schema defined in the `schema` field. Only a subset of
         * JSON Schema is supported when `strict` is `true`. To learn more, read the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun strict(strict: Boolean?) = strict(JsonField.ofNullable(strict))

        /**
         * Alias for [Builder.strict].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun strict(strict: Boolean) = strict(strict as Boolean?)

        /** Alias for calling [Builder.strict] with `strict.orElse(null)`. */
        fun strict(strict: Optional<Boolean>) = strict(strict.getOrNull())

        /**
         * Sets [Builder.strict] to an arbitrary JSON value.
         *
         * You should usually call [Builder.strict] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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

        fun build(): ResponseFormatTextJsonSchemaConfig =
            ResponseFormatTextJsonSchemaConfig(
                checkRequired("schema", schema),
                type,
                description,
                name,
                strict,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The schema for the response format, described as a JSON Schema object. Learn how to build
     * JSON schemas [here](https://json-schema.org/).
     */
    @NoAutoDetect
    class Schema
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Schema = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Schema]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Schema]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(schema: Schema) = apply {
                additionalProperties = schema.additionalProperties.toMutableMap()
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

            fun build(): Schema = Schema(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Schema && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Schema{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFormatTextJsonSchemaConfig && schema == other.schema && type == other.type && description == other.description && name == other.name && strict == other.strict && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(schema, type, description, name, strict, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFormatTextJsonSchemaConfig{schema=$schema, type=$type, description=$description, name=$name, strict=$strict, additionalProperties=$additionalProperties}"
}
