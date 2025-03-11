// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

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
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import java.util.Objects
import java.util.Optional

/**
 * Specifies the format that the model must output. Compatible with
 * [GPT-4o](https://platform.openai.com/docs/models#gpt-4o), [GPT-4
 * Turbo](https://platform.openai.com/docs/models#gpt-4-turbo-and-gpt-4), and all GPT-3.5 Turbo
 * models since `gpt-3.5-turbo-1106`.
 *
 * Setting to `{ "type": "json_schema", "json_schema": {...} }` enables Structured Outputs which
 * ensures the model will match your supplied JSON schema. Learn more in the
 * [Structured Outputs guide](https://platform.openai.com/docs/guides/structured-outputs).
 *
 * Setting to `{ "type": "json_object" }` enables JSON mode, which ensures the message the model
 * generates is valid JSON.
 *
 * **Important:** when using JSON mode, you **must** also instruct the model to produce JSON
 * yourself via a system or user message. Without this, the model may generate an unending stream of
 * whitespace until the generation reaches the token limit, resulting in a long-running and
 * seemingly "stuck" request. Also note that the message content may be partially cut off if
 * `finish_reason="length"`, which indicates the generation exceeded `max_tokens` or the
 * conversation exceeded the max context length.
 */
@JsonDeserialize(using = AssistantResponseFormatOption.Deserializer::class)
@JsonSerialize(using = AssistantResponseFormatOption.Serializer::class)
class AssistantResponseFormatOption
private constructor(
    private val jsonValue: JsonValue? = null,
    private val responseFormatText: ResponseFormatText? = null,
    private val responseFormatJsonObject: ResponseFormatJsonObject? = null,
    private val responseFormatJsonSchema: ResponseFormatJsonSchema? = null,
    private val _json: JsonValue? = null,
) {

    /** `auto` is the default value */
    fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

    /** Default response format. Used to generate text responses. */
    fun responseFormatText(): Optional<ResponseFormatText> = Optional.ofNullable(responseFormatText)

    /**
     * JSON object response format. An older method of generating JSON responses. Using
     * `json_schema` is recommended for models that support it. Note that the model will not
     * generate JSON without a system or user message instructing it to do so.
     */
    fun responseFormatJsonObject(): Optional<ResponseFormatJsonObject> =
        Optional.ofNullable(responseFormatJsonObject)

    /**
     * JSON Schema response format. Used to generate structured JSON responses. Learn more about
     * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
     */
    fun responseFormatJsonSchema(): Optional<ResponseFormatJsonSchema> =
        Optional.ofNullable(responseFormatJsonSchema)

    fun isJsonValue(): Boolean = jsonValue != null

    fun isResponseFormatText(): Boolean = responseFormatText != null

    fun isResponseFormatJsonObject(): Boolean = responseFormatJsonObject != null

    fun isResponseFormatJsonSchema(): Boolean = responseFormatJsonSchema != null

    /** `auto` is the default value */
    fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

    /** Default response format. Used to generate text responses. */
    fun asResponseFormatText(): ResponseFormatText =
        responseFormatText.getOrThrow("responseFormatText")

    /**
     * JSON object response format. An older method of generating JSON responses. Using
     * `json_schema` is recommended for models that support it. Note that the model will not
     * generate JSON without a system or user message instructing it to do so.
     */
    fun asResponseFormatJsonObject(): ResponseFormatJsonObject =
        responseFormatJsonObject.getOrThrow("responseFormatJsonObject")

    /**
     * JSON Schema response format. Used to generate structured JSON responses. Learn more about
     * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
     */
    fun asResponseFormatJsonSchema(): ResponseFormatJsonSchema =
        responseFormatJsonSchema.getOrThrow("responseFormatJsonSchema")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            jsonValue != null -> visitor.visitJsonValue(jsonValue)
            responseFormatText != null -> visitor.visitResponseFormatText(responseFormatText)
            responseFormatJsonObject != null ->
                visitor.visitResponseFormatJsonObject(responseFormatJsonObject)
            responseFormatJsonSchema != null ->
                visitor.visitResponseFormatJsonSchema(responseFormatJsonSchema)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AssistantResponseFormatOption = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitJsonValue(jsonValue: JsonValue) {
                    jsonValue.let {
                        if (it != JsonValue.from("auto")) {
                            throw OpenAIInvalidDataException("'jsonValue' is invalid, received $it")
                        }
                    }
                }

                override fun visitResponseFormatText(responseFormatText: ResponseFormatText) {
                    responseFormatText.validate()
                }

                override fun visitResponseFormatJsonObject(
                    responseFormatJsonObject: ResponseFormatJsonObject
                ) {
                    responseFormatJsonObject.validate()
                }

                override fun visitResponseFormatJsonSchema(
                    responseFormatJsonSchema: ResponseFormatJsonSchema
                ) {
                    responseFormatJsonSchema.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantResponseFormatOption && jsonValue == other.jsonValue && responseFormatText == other.responseFormatText && responseFormatJsonObject == other.responseFormatJsonObject && responseFormatJsonSchema == other.responseFormatJsonSchema /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jsonValue, responseFormatText, responseFormatJsonObject, responseFormatJsonSchema) /* spotless:on */

    override fun toString(): String =
        when {
            jsonValue != null -> "AssistantResponseFormatOption{jsonValue=$jsonValue}"
            responseFormatText != null ->
                "AssistantResponseFormatOption{responseFormatText=$responseFormatText}"
            responseFormatJsonObject != null ->
                "AssistantResponseFormatOption{responseFormatJsonObject=$responseFormatJsonObject}"
            responseFormatJsonSchema != null ->
                "AssistantResponseFormatOption{responseFormatJsonSchema=$responseFormatJsonSchema}"
            _json != null -> "AssistantResponseFormatOption{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssistantResponseFormatOption")
        }

    companion object {

        /** `auto` is the default value */
        @JvmStatic
        fun ofJsonValue() = AssistantResponseFormatOption(jsonValue = JsonValue.from("auto"))

        /** Default response format. Used to generate text responses. */
        @JvmStatic
        fun ofResponseFormatText(responseFormatText: ResponseFormatText) =
            AssistantResponseFormatOption(responseFormatText = responseFormatText)

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        @JvmStatic
        fun ofResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject) =
            AssistantResponseFormatOption(responseFormatJsonObject = responseFormatJsonObject)

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        @JvmStatic
        fun ofResponseFormatJsonSchema(responseFormatJsonSchema: ResponseFormatJsonSchema) =
            AssistantResponseFormatOption(responseFormatJsonSchema = responseFormatJsonSchema)
    }

    /**
     * An interface that defines how to map each variant of [AssistantResponseFormatOption] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** `auto` is the default value */
        fun visitJsonValue(jsonValue: JsonValue): T

        /** Default response format. Used to generate text responses. */
        fun visitResponseFormatText(responseFormatText: ResponseFormatText): T

        /**
         * JSON object response format. An older method of generating JSON responses. Using
         * `json_schema` is recommended for models that support it. Note that the model will not
         * generate JSON without a system or user message instructing it to do so.
         */
        fun visitResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject): T

        /**
         * JSON Schema response format. Used to generate structured JSON responses. Learn more about
         * [Structured Outputs](https://platform.openai.com/docs/guides/structured-outputs).
         */
        fun visitResponseFormatJsonSchema(responseFormatJsonSchema: ResponseFormatJsonSchema): T

        /**
         * Maps an unknown variant of [AssistantResponseFormatOption] to a value of type [T].
         *
         * An instance of [AssistantResponseFormatOption] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantResponseFormatOption: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AssistantResponseFormatOption>(AssistantResponseFormatOption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantResponseFormatOption {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                    it.let {
                        if (it != JsonValue.from("auto")) {
                            throw OpenAIInvalidDataException("'jsonValue' is invalid, received $it")
                        }
                    }
                }
                ?.let {
                    return AssistantResponseFormatOption(jsonValue = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatText>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(responseFormatText = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonObject>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(
                        responseFormatJsonObject = it,
                        _json = json,
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonSchema>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(
                        responseFormatJsonSchema = it,
                        _json = json,
                    )
                }

            return AssistantResponseFormatOption(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AssistantResponseFormatOption>(AssistantResponseFormatOption::class) {

        override fun serialize(
            value: AssistantResponseFormatOption,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.jsonValue != null -> generator.writeObject(value.jsonValue)
                value.responseFormatText != null -> generator.writeObject(value.responseFormatText)
                value.responseFormatJsonObject != null ->
                    generator.writeObject(value.responseFormatJsonObject)
                value.responseFormatJsonSchema != null ->
                    generator.writeObject(value.responseFormatJsonSchema)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssistantResponseFormatOption")
            }
        }
    }
}
