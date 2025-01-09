// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.JsonField
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
    private val behavior: Behavior? = null,
    private val responseFormatText: ResponseFormatText? = null,
    private val responseFormatJsonObject: ResponseFormatJsonObject? = null,
    private val responseFormatJsonSchema: ResponseFormatJsonSchema? = null,
    private val _json: JsonValue? = null,
) {

    /** `auto` is the default value */
    fun behavior(): Optional<Behavior> = Optional.ofNullable(behavior)

    fun responseFormatText(): Optional<ResponseFormatText> = Optional.ofNullable(responseFormatText)

    fun responseFormatJsonObject(): Optional<ResponseFormatJsonObject> =
        Optional.ofNullable(responseFormatJsonObject)

    fun responseFormatJsonSchema(): Optional<ResponseFormatJsonSchema> =
        Optional.ofNullable(responseFormatJsonSchema)

    fun isBehavior(): Boolean = behavior != null

    fun isResponseFormatText(): Boolean = responseFormatText != null

    fun isResponseFormatJsonObject(): Boolean = responseFormatJsonObject != null

    fun isResponseFormatJsonSchema(): Boolean = responseFormatJsonSchema != null

    /** `auto` is the default value */
    fun asBehavior(): Behavior = behavior.getOrThrow("behavior")

    fun asResponseFormatText(): ResponseFormatText =
        responseFormatText.getOrThrow("responseFormatText")

    fun asResponseFormatJsonObject(): ResponseFormatJsonObject =
        responseFormatJsonObject.getOrThrow("responseFormatJsonObject")

    fun asResponseFormatJsonSchema(): ResponseFormatJsonSchema =
        responseFormatJsonSchema.getOrThrow("responseFormatJsonSchema")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            behavior != null -> visitor.visitBehavior(behavior)
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
                override fun visitBehavior(behavior: Behavior) {}

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

        return /* spotless:off */ other is AssistantResponseFormatOption && behavior == other.behavior && responseFormatText == other.responseFormatText && responseFormatJsonObject == other.responseFormatJsonObject && responseFormatJsonSchema == other.responseFormatJsonSchema /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(behavior, responseFormatText, responseFormatJsonObject, responseFormatJsonSchema) /* spotless:on */

    override fun toString(): String =
        when {
            behavior != null -> "AssistantResponseFormatOption{behavior=$behavior}"
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
        fun ofBehavior(behavior: Behavior) = AssistantResponseFormatOption(behavior = behavior)

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

    interface Visitor<out T> {

        fun visitBehavior(behavior: Behavior): T

        fun visitResponseFormatText(responseFormatText: ResponseFormatText): T

        fun visitResponseFormatJsonObject(responseFormatJsonObject: ResponseFormatJsonObject): T

        fun visitResponseFormatJsonSchema(responseFormatJsonSchema: ResponseFormatJsonSchema): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantResponseFormatOption: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<AssistantResponseFormatOption>(AssistantResponseFormatOption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantResponseFormatOption {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Behavior>())?.let {
                return AssistantResponseFormatOption(behavior = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatText>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(responseFormatText = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonObject>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(
                        responseFormatJsonObject = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ResponseFormatJsonSchema>()) { it.validate() }
                ?.let {
                    return AssistantResponseFormatOption(
                        responseFormatJsonSchema = it,
                        _json = json
                    )
                }

            return AssistantResponseFormatOption(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<AssistantResponseFormatOption>(AssistantResponseFormatOption::class) {

        override fun serialize(
            value: AssistantResponseFormatOption,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.behavior != null -> generator.writeObject(value.behavior)
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

    class Behavior
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmStatic fun of(value: String) = Behavior(JsonField.of(value))
        }

        enum class Known {
            AUTO,
        }

        enum class Value {
            AUTO,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                else -> throw OpenAIInvalidDataException("Unknown Behavior: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Behavior && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
