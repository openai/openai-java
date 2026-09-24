// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The effective output format for generated text. */
@JsonDeserialize(using = TextFormat.Deserializer::class)
@JsonSerialize(using = TextFormat.Serializer::class)
class TextFormat
private constructor(
    private val text: JsonValue? = null,
    private val jsonSchema: JsonSchema? = null,
    private val _json: JsonValue? = null,
) {

    /** Generates ordinary text without a structured-output constraint. */
    fun text(): Optional<JsonValue> = Optional.ofNullable(text)

    /** Constrains generated text to a JSON Schema. */
    fun jsonSchema(): Optional<JsonSchema> = Optional.ofNullable(jsonSchema)

    fun isText(): Boolean = text != null

    fun isJsonSchema(): Boolean = jsonSchema != null

    /** Generates ordinary text without a structured-output constraint. */
    fun asText(): JsonValue = text.getOrThrow("text")

    /** Constrains generated text to a JSON Schema. */
    fun asJsonSchema(): JsonSchema = jsonSchema.getOrThrow("jsonSchema")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = textFormat.accept(new TextFormat.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitText(JsonValue text) {
     *         return Optional.of(text.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            text != null -> visitor.visitText(text)
            jsonSchema != null -> visitor.visitJsonSchema(jsonSchema)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): TextFormat = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: JsonValue) {
                    text.let {
                        if (it != JsonValue.from(mapOf("type" to "text"))) {
                            throw OpenAIInvalidDataException("'text' is invalid, received $it")
                        }
                    }
                }

                override fun visitJsonSchema(jsonSchema: JsonSchema) {
                    jsonSchema.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitText(text: JsonValue) =
                    text.let { if (it == JsonValue.from(mapOf("type" to "text"))) 1 else 0 }

                override fun visitJsonSchema(jsonSchema: JsonSchema) = jsonSchema.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TextFormat && text == other.text && jsonSchema == other.jsonSchema
    }

    override fun hashCode(): Int = Objects.hash(text, jsonSchema)

    override fun toString(): String =
        when {
            text != null -> "TextFormat{text=$text}"
            jsonSchema != null -> "TextFormat{jsonSchema=$jsonSchema}"
            _json != null -> "TextFormat{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid TextFormat")
        }

    companion object {

        /** Generates ordinary text without a structured-output constraint. */
        @JvmStatic fun ofText() = TextFormat(text = JsonValue.from(mapOf("type" to "text")))

        /** Constrains generated text to a JSON Schema. */
        @JvmStatic fun ofJsonSchema(jsonSchema: JsonSchema) = TextFormat(jsonSchema = jsonSchema)
    }

    /** An interface that defines how to map each variant of [TextFormat] to a value of type [T]. */
    interface Visitor<out T> {

        /** Generates ordinary text without a structured-output constraint. */
        fun visitText(text: JsonValue): T

        /** Constrains generated text to a JSON Schema. */
        fun visitJsonSchema(jsonSchema: JsonSchema): T

        /**
         * Maps an unknown variant of [TextFormat] to a value of type [T].
         *
         * An instance of [TextFormat] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown TextFormat: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<TextFormat>(TextFormat::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): TextFormat {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { TextFormat(text = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: TextFormat(_json = json)
                }
                "json_schema" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonSchema>())?.let {
                        TextFormat(jsonSchema = it, _json = json)
                    } ?: TextFormat(_json = json)
                }
            }

            return TextFormat(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<TextFormat>(TextFormat::class) {

        override fun serialize(
            value: TextFormat,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.jsonSchema != null -> generator.writeObject(value.jsonSchema)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid TextFormat")
            }
        }
    }

    /** Constrains generated text to a JSON Schema. */
    class JsonSchema
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val schema: JsonField<Schema>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(schema, type, mutableMapOf())

        /**
         * The JSON Schema that generated text must match.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun schema(): Schema = schema.getRequired("schema")

        /**
         * The type of the object. Always `json_schema`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("json_schema")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [schema].
         *
         * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [JsonSchema].
             *
             * The following fields are required:
             * ```java
             * .schema()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [JsonSchema]. */
        class Builder internal constructor() {

            private var schema: JsonField<Schema>? = null
            private var type: JsonValue = JsonValue.from("json_schema")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(jsonSchema: JsonSchema) = apply {
                schema = jsonSchema.schema
                type = jsonSchema.type
                additionalProperties = jsonSchema.additionalProperties.toMutableMap()
            }

            /** The JSON Schema that generated text must match. */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /**
             * Sets [Builder.schema] to an arbitrary JSON value.
             *
             * You should usually call [Builder.schema] with a well-typed [Schema] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [JsonSchema].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .schema()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): JsonSchema =
                JsonSchema(
                    checkRequired("schema", schema),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): JsonSchema = apply {
            if (validated) {
                return@apply
            }

            schema().validate()
            _type().let {
                if (it != JsonValue.from("json_schema")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (schema.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("json_schema")) 1 else 0 }

        /** The JSON Schema that generated text must match. */
        class Schema
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /**
                 * Returns an immutable instance of [Schema].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Schema = Schema(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Schema = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Schema && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Schema{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is JsonSchema &&
                schema == other.schema &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(schema, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "JsonSchema{schema=$schema, type=$type, additionalProperties=$additionalProperties}"
    }
}
