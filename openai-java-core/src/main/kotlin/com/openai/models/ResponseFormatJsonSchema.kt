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
class ResponseFormatJsonSchema
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("json_schema")
    @ExcludeMissing
    private val jsonSchema: JsonField<JsonSchema> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of response format being defined: `json_schema` */
    fun type(): Type = type.getRequired("type")

    fun jsonSchema(): JsonSchema = jsonSchema.getRequired("json_schema")

    /** The type of response format being defined: `json_schema` */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("json_schema") @ExcludeMissing fun _jsonSchema() = jsonSchema

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFormatJsonSchema = apply {
        if (!validated) {
            type()
            jsonSchema().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var jsonSchema: JsonField<JsonSchema> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFormatJsonSchema: ResponseFormatJsonSchema) = apply {
            type = responseFormatJsonSchema.type
            jsonSchema = responseFormatJsonSchema.jsonSchema
            additionalProperties = responseFormatJsonSchema.additionalProperties.toMutableMap()
        }

        /** The type of response format being defined: `json_schema` */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of response format being defined: `json_schema` */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun jsonSchema(jsonSchema: JsonSchema) = jsonSchema(JsonField.of(jsonSchema))

        fun jsonSchema(jsonSchema: JsonField<JsonSchema>) = apply { this.jsonSchema = jsonSchema }

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

        fun build(): ResponseFormatJsonSchema =
            ResponseFormatJsonSchema(
                type,
                jsonSchema,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class JsonSchema
    @JsonCreator
    private constructor(
        @JsonProperty("description")
        @ExcludeMissing
        private val description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("schema")
        @ExcludeMissing
        private val schema: JsonField<Schema> = JsonMissing.of(),
        @JsonProperty("strict")
        @ExcludeMissing
        private val strict: JsonField<Boolean> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A description of what the response format is for, used by the model to determine how to
         * respond in the format.
         */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        fun name(): String = name.getRequired("name")

        /** The schema for the response format, described as a JSON Schema object. */
        fun schema(): Optional<Schema> = Optional.ofNullable(schema.getNullable("schema"))

        /**
         * Whether to enable strict schema adherence when generating the output. If set to true, the
         * model will always follow the exact schema defined in the `schema` field. Only a subset of
         * JSON Schema is supported when `strict` is `true`. To learn more, read the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun strict(): Optional<Boolean> = Optional.ofNullable(strict.getNullable("strict"))

        /**
         * A description of what the response format is for, used by the model to determine how to
         * respond in the format.
         */
        @JsonProperty("description") @ExcludeMissing fun _description() = description

        /**
         * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and
         * dashes, with a maximum length of 64.
         */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        /** The schema for the response format, described as a JSON Schema object. */
        @JsonProperty("schema") @ExcludeMissing fun _schema() = schema

        /**
         * Whether to enable strict schema adherence when generating the output. If set to true, the
         * model will always follow the exact schema defined in the `schema` field. Only a subset of
         * JSON Schema is supported when `strict` is `true`. To learn more, read the
         * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
         */
        @JsonProperty("strict") @ExcludeMissing fun _strict() = strict

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): JsonSchema = apply {
            if (!validated) {
                description()
                name()
                schema().map { it.validate() }
                strict()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var description: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var schema: JsonField<Schema> = JsonMissing.of()
            private var strict: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(jsonSchema: JsonSchema) = apply {
                description = jsonSchema.description
                name = jsonSchema.name
                schema = jsonSchema.schema
                strict = jsonSchema.strict
                additionalProperties = jsonSchema.additionalProperties.toMutableMap()
            }

            /**
             * A description of what the response format is for, used by the model to determine how
             * to respond in the format.
             */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * A description of what the response format is for, used by the model to determine how
             * to respond in the format.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and
             * dashes, with a maximum length of 64.
             */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * The name of the response format. Must be a-z, A-Z, 0-9, or contain underscores and
             * dashes, with a maximum length of 64.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The schema for the response format, described as a JSON Schema object. */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /** The schema for the response format, described as a JSON Schema object. */
            fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

            /**
             * Whether to enable strict schema adherence when generating the output. If set to true,
             * the model will always follow the exact schema defined in the `schema` field. Only a
             * subset of JSON Schema is supported when `strict` is `true`. To learn more, read the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
             */
            fun strict(strict: Boolean) = strict(JsonField.of(strict))

            /**
             * Whether to enable strict schema adherence when generating the output. If set to true,
             * the model will always follow the exact schema defined in the `schema` field. Only a
             * subset of JSON Schema is supported when `strict` is `true`. To learn more, read the
             * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
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

            fun build(): JsonSchema =
                JsonSchema(
                    description,
                    name,
                    schema,
                    strict,
                    additionalProperties.toImmutable(),
                )
        }

        /** The schema for the response format, described as a JSON Schema object. */
        @NoAutoDetect
        class Schema
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Schema = apply {
                if (!validated) {
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

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

            return /* spotless:off */ other is JsonSchema && description == other.description && name == other.name && schema == other.schema && strict == other.strict && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, name, schema, strict, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "JsonSchema{description=$description, name=$name, schema=$schema, strict=$strict, additionalProperties=$additionalProperties}"
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val JSON_SCHEMA = of("json_schema")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            JSON_SCHEMA,
        }

        enum class Value {
            JSON_SCHEMA,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                JSON_SCHEMA -> Value.JSON_SCHEMA
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                JSON_SCHEMA -> Known.JSON_SCHEMA
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

        return /* spotless:off */ other is ResponseFormatJsonSchema && type == other.type && jsonSchema == other.jsonSchema && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, jsonSchema, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFormatJsonSchema{type=$type, jsonSchema=$jsonSchema, additionalProperties=$additionalProperties}"
}
