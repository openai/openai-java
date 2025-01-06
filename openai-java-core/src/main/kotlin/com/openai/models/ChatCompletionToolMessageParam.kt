// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class ChatCompletionToolMessageParam
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<Content> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonProperty("tool_call_id")
    @ExcludeMissing
    private val toolCallId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The contents of the tool message. */
    fun content(): Content = content.getRequired("content")

    /** The role of the messages author, in this case `tool`. */
    fun role(): Role = role.getRequired("role")

    /** Tool call that this message is responding to. */
    fun toolCallId(): String = toolCallId.getRequired("tool_call_id")

    /** The contents of the tool message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The role of the messages author, in this case `tool`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** Tool call that this message is responding to. */
    @JsonProperty("tool_call_id") @ExcludeMissing fun _toolCallId() = toolCallId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionToolMessageParam = apply {
        if (!validated) {
            content()
            role()
            toolCallId()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content> = JsonMissing.of()
        private var role: JsonField<Role> = JsonMissing.of()
        private var toolCallId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionToolMessageParam: ChatCompletionToolMessageParam) = apply {
            content = chatCompletionToolMessageParam.content
            role = chatCompletionToolMessageParam.role
            toolCallId = chatCompletionToolMessageParam.toolCallId
            additionalProperties =
                chatCompletionToolMessageParam.additionalProperties.toMutableMap()
        }

        /** The contents of the tool message. */
        fun content(content: Content) = content(JsonField.of(content))

        /** The contents of the tool message. */
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** The role of the messages author, in this case `tool`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `tool`. */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** Tool call that this message is responding to. */
        fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

        /** Tool call that this message is responding to. */
        fun toolCallId(toolCallId: JsonField<String>) = apply { this.toolCallId = toolCallId }

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

        fun build(): ChatCompletionToolMessageParam =
            ChatCompletionToolMessageParam(
                content,
                role,
                toolCallId,
                additionalProperties.toImmutable(),
            )
    }

    /** The contents of the tool message. */
    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val textContent: String? = null,
        private val arrayOfContentParts: List<ChatCompletionContentPartText>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The contents of the tool message. */
        fun textContent(): Optional<String> = Optional.ofNullable(textContent)
        /**
         * An array of content parts with a defined type. For tool messages, only type `text` is
         * supported.
         */
        fun arrayOfContentParts(): Optional<List<ChatCompletionContentPartText>> =
            Optional.ofNullable(arrayOfContentParts)

        fun isTextContent(): Boolean = textContent != null

        fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

        /** The contents of the tool message. */
        fun asTextContent(): String = textContent.getOrThrow("textContent")
        /**
         * An array of content parts with a defined type. For tool messages, only type `text` is
         * supported.
         */
        fun asArrayOfContentParts(): List<ChatCompletionContentPartText> =
            arrayOfContentParts.getOrThrow("arrayOfContentParts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                textContent != null -> visitor.visitTextContent(textContent)
                arrayOfContentParts != null -> visitor.visitArrayOfContentParts(arrayOfContentParts)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Content = apply {
            if (!validated) {
                if (textContent == null && arrayOfContentParts == null) {
                    throw OpenAIInvalidDataException("Unknown Content: $_json")
                }
                arrayOfContentParts?.forEach { it.validate() }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && textContent == other.textContent && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(textContent, arrayOfContentParts) /* spotless:on */

        override fun toString(): String =
            when {
                textContent != null -> "Content{textContent=$textContent}"
                arrayOfContentParts != null -> "Content{arrayOfContentParts=$arrayOfContentParts}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }

        companion object {

            /** The contents of the tool message. */
            @JvmStatic fun ofTextContent(textContent: String) = Content(textContent = textContent)

            /**
             * An array of content parts with a defined type. For tool messages, only type `text` is
             * supported.
             */
            @JvmStatic
            fun ofArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPartText>) =
                Content(arrayOfContentParts = arrayOfContentParts)
        }

        interface Visitor<out T> {

            fun visitTextContent(textContent: String): T

            fun visitArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPartText>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(textContent = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPartText>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Content(arrayOfContentParts = it, _json = json)
                    }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.textContent != null -> generator.writeObject(value.textContent)
                    value.arrayOfContentParts != null ->
                        generator.writeObject(value.arrayOfContentParts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val TOOL = of("tool")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            TOOL,
        }

        enum class Value {
            TOOL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TOOL -> Value.TOOL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TOOL -> Known.TOOL
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionToolMessageParam && content == other.content && role == other.role && toolCallId == other.toolCallId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, role, toolCallId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionToolMessageParam{content=$content, role=$role, toolCallId=$toolCallId, additionalProperties=$additionalProperties}"
}
