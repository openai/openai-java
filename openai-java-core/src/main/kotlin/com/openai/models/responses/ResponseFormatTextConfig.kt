// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An object specifying the format that the model must output.
 *
 * Configuring `{ "type": "json_schema" }` enables Structured Outputs, which ensures the model will
 * match your supplied JSON schema. Learn more in the
 * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
 *
 * The default format is `{ "type": "text" }` with no additional options.
 *
 * **Not recommended for gpt-4o and newer models:**
 *
 * Setting to `{ "type": "json_object" }` enables the older JSON mode, which ensures the message the
 * model generates is valid JSON. Using `json_schema` is preferred for models that support it.
 */
@JsonDeserialize(using = ResponseFormatTextConfig.Deserializer::class)
@JsonSerialize(using = ResponseFormatTextConfig.Serializer::class)
class ResponseFormatTextConfig
private constructor(
    private val text: ResponseFormatText? = null,
    private val jsonSchema: ResponseFormatTextJsonSchemaConfig? = null,
    private val jsonObject: ResponseFormatJsonObject? = null,
    private val _json: JsonValue? = null,
) {

    /** Default response format. Used to generate text responses. */
    fun text(): Optional<ResponseFormatText> = Optional.ofNullable(text)

    /**
     * JSON Schema response format. Used to generate structured JSON responses. Learn more about
     * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
     */
    fun jsonSchema(): Optional<ResponseFormatTextJsonSchemaConfig> = Optional.ofNullable(jsonSchema)

    /**
     * JSON object response format. An older method of generating JSON responses. Using
     * `json_schema` is recommended for models that support it. Note that the model will not
     * generate JSON without a system or user message instructing it to do so.
     */
    fun jsonObject(): Optional<ResponseFormatJsonObject> = Optional.ofNullable(jsonObject)

    fun isText(): Boolean = text != null

    fun isJsonSchema(): Boolean = jsonSchema != null

    fun isJsonObject(): Boolean = jsonObject != null

    /** Default response format. Used to generate text responses. */
    fun asText(): ResponseFormatText = text.getOrThrow("text")

    /**
     * JSON Schema response format. Used to generate structured JSON responses. Learn more about
     * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
     */
    fun asJsonSchema(): ResponseFormatTextJsonSchemaConfig = jsonSchema.getOrThrow("jsonSchema")

    /**
     * JSON object response format. An older method of generating JSON responses. Using
     * `json_schema` is recommended for models that support it. Note that the model will not
     * generate JSON without a system or user message instructing it to do so.
     */
    fun asJsonObject(): ResponseFormatJsonObject = jsonObject.getOrThrow("jsonObject")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            text != null -> visitor.visitText(text)
            jsonSchema != null -> visitor.visitJsonSchema(jsonSchema)
            jsonObject != null -> visitor.visitJsonObject(jsonObject)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ResponseFormatTextConfig = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: ResponseFormatText) {
                    text.validate()
                }

                override fun visitJsonSchema(jsonSchema: ResponseFormatTextJsonSchemaConfig) {
                    jsonSchema.validate()
                }

                override fun visitJsonObject(jsonObject: ResponseFormatJsonObject) {
                    jsonObject.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFormatTextConfig && text == other.text && jsonSchema == other.jsonSchema && jsonObject == other.jsonObject /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, jsonSchema, jsonObject) /* spotless:on */

    override fun toString(): String =
        when {
            text != null -> "ResponseFormatTextConfig{text=$text}"
            jsonSchema != null -> "ResponseFormatTextConfig{jsonSchema=$jsonSchema}"
            jsonObject != null -> "ResponseFormatTextConfig{jsonObject=$jsonObject}"
            _json != null -> "ResponseFormatTextConfig{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseFormatTextConfig")
        }

    companion object {

        /** Default response format. Used to generate text responses. */
        @JvmStatic fun ofText(text: ResponseFormatText) = ResponseFormatTextConfig(text = text)

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        @JvmStatic
        fun ofJsonSchema(jsonSchema: ResponseFormatTextJsonSchemaConfig) =
            ResponseFormatTextConfig(jsonSchema = jsonSchema)

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        @JvmStatic
        fun ofJsonObject(jsonObject: ResponseFormatJsonObject) =
            ResponseFormatTextConfig(jsonObject = jsonObject)
    }

    /**
     * An interface that defines how to map each variant of [ResponseFormatTextConfig] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Default response format. Used to generate text responses. */
        fun visitText(text: ResponseFormatText): T

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun visitJsonSchema(jsonSchema: ResponseFormatTextJsonSchemaConfig): T

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        fun visitJsonObject(jsonObject: ResponseFormatJsonObject): T

        /**
         * Maps an unknown variant of [ResponseFormatTextConfig] to a value of type [T].
         *
         * An instance of [ResponseFormatTextConfig] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseFormatTextConfig: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponseFormatTextConfig>(ResponseFormatTextConfig::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseFormatTextConfig {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    return ResponseFormatTextConfig(
                        text = deserialize(node, jacksonTypeRef<ResponseFormatText>()),
                        _json = json,
                    )
                }
                "json_schema" -> {
                    return ResponseFormatTextConfig(
                        jsonSchema =
                            deserialize(node, jacksonTypeRef<ResponseFormatTextJsonSchemaConfig>()),
                        _json = json,
                    )
                }
                "json_object" -> {
                    return ResponseFormatTextConfig(
                        jsonObject = deserialize(node, jacksonTypeRef<ResponseFormatJsonObject>()),
                        _json = json,
                    )
                }
            }

            return ResponseFormatTextConfig(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ResponseFormatTextConfig>(ResponseFormatTextConfig::class) {

        override fun serialize(
            value: ResponseFormatTextConfig,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.jsonSchema != null -> generator.writeObject(value.jsonSchema)
                value.jsonObject != null -> generator.writeObject(value.jsonObject)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseFormatTextConfig")
            }
        }
    }
}
