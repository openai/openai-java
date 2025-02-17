// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
    private val auto: JsonValue? = null,
    private val responseFormatText: ResponseFormatText? = null,
    private val responseFormatJsonObject: ResponseFormatJsonObject? = null,
    private val responseFormatJsonSchema: ResponseFormatJsonSchema? = null,
    private val _json: JsonValue? = null,
) {

    /** `auto` is the default value */
    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

    fun responseFormatText(): Optional<ResponseFormatText> = Optional.ofNullable(responseFormatText)

    fun responseFormatJsonObject(): Optional<ResponseFormatJsonObject> =
        Optional.ofNullable(responseFormatJsonObject)

    fun responseFormatJsonSchema(): Optional<ResponseFormatJsonSchema> =
        Optional.ofNullable(responseFormatJsonSchema)

    fun isAuto(): Boolean = auto != null

    fun isResponseFormatText(): Boolean = responseFormatText != null

    fun isResponseFormatJsonObject(): Boolean = responseFormatJsonObject != null

    fun isResponseFormatJsonSchema(): Boolean = responseFormatJsonSchema != null

    /** `auto` is the default value */
    fun asAuto(): JsonValue = auto.getOrThrow("auto")

    fun asResponseFormatText(): ResponseFormatText =
        responseFormatText.getOrThrow("responseFormatText")

    fun asResponseFormatJsonObject(): ResponseFormatJsonObject =
        responseFormatJsonObject.getOrThrow("responseFormatJsonObject")

    fun asResponseFormatJsonSchema(): ResponseFormatJsonSchema =
        responseFormatJsonSchema.getOrThrow("responseFormatJsonSchema")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            auto != null -> visitor.visitAuto(auto)
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
                override fun visitAuto(auto: JsonValue) {
                    auto.let {
                        if (it != JsonValue.from("auto")) {
                            throw OpenAIInvalidDataException("'auto' is invalid, received $it")
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

        return /* spotless:off */ other is AssistantResponseFormatOption && auto == other.auto && responseFormatText == other.responseFormatText && responseFormatJsonObject == other.responseFormatJsonObject && responseFormatJsonSchema == other.responseFormatJsonSchema /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, responseFormatText, responseFormatJsonObject, responseFormatJsonSchema) /* spotless:on */

    override fun toString(): String =
        when {
            auto != null -> "AssistantResponseFormatOption{auto=$auto}"
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
        @JvmStatic fun ofAuto() = AssistantResponseFormatOption(auto = JsonValue.from("auto"))

        @JvmStatic
        fun ofResponseFormatText(responseFormatText: ResponseFormatText) =
            AssistantResponseFormatOption(responseFormatText = responseFormatText)

        @JvmStatic
        fun ofResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject) =
            AssistantResponseFormatOption(responseFormatJsonObject = responseFormatJsonObject)

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
        fun visitAuto(auto: JsonValue): T

        fun visitResponseFormatText(responseFormatText: ResponseFormatText): T

        fun visitResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject): T

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
                            throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                        }
                    }
                }
                ?.let {
                    return AssistantResponseFormatOption(auto = it, _json = json)
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
                value.auto != null -> generator.writeObject(value.auto)
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
