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

/** Messages sent by an end user, containing prompts or additional context information. */
@NoAutoDetect
class ChatCompletionUserMessageParam
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<Content> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The contents of the user message. */
    fun content(): Content = content.getRequired("content")

    /** The role of the messages author, in this case `user`. */
    fun role(): Role = role.getRequired("role")

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The contents of the user message. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

    /** The role of the messages author, in this case `user`. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionUserMessageParam = apply {
        if (!validated) {
            content()
            role()
            name()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content>? = null
        private var role: JsonField<Role>? = null
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionUserMessageParam: ChatCompletionUserMessageParam) = apply {
            content = chatCompletionUserMessageParam.content
            role = chatCompletionUserMessageParam.role
            name = chatCompletionUserMessageParam.name
            additionalProperties =
                chatCompletionUserMessageParam.additionalProperties.toMutableMap()
        }

        /** The contents of the user message. */
        fun content(content: Content) = content(JsonField.of(content))

        /** The contents of the user message. */
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** The text contents of the message. */
        fun content(textContent: String) = content(Content.ofTextContent(textContent))

        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text, image, or audio inputs.
         */
        fun contentOfArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPart>) =
            content(Content.ofArrayOfContentParts(arrayOfContentParts))

        /** The role of the messages author, in this case `user`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `user`. */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

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

        fun build(): ChatCompletionUserMessageParam =
            ChatCompletionUserMessageParam(
                checkNotNull(content) { "`content` is required but was not set" },
                checkNotNull(role) { "`role` is required but was not set" },
                name,
                additionalProperties.toImmutable(),
            )
    }

    /** The contents of the user message. */
    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val textContent: String? = null,
        private val arrayOfContentParts: List<ChatCompletionContentPart>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The text contents of the message. */
        fun textContent(): Optional<String> = Optional.ofNullable(textContent)
        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text, image, or audio inputs.
         */
        fun arrayOfContentParts(): Optional<List<ChatCompletionContentPart>> =
            Optional.ofNullable(arrayOfContentParts)

        fun isTextContent(): Boolean = textContent != null

        fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

        /** The text contents of the message. */
        fun asTextContent(): String = textContent.getOrThrow("textContent")
        /**
         * An array of content parts with a defined type. Supported options differ based on the
         * [model](https://platform.openai.com/docs/models) being used to generate the response. Can
         * contain text, image, or audio inputs.
         */
        fun asArrayOfContentParts(): List<ChatCompletionContentPart> =
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

            /** The text contents of the message. */
            @JvmStatic fun ofTextContent(textContent: String) = Content(textContent = textContent)

            /**
             * An array of content parts with a defined type. Supported options differ based on the
             * [model](https://platform.openai.com/docs/models) being used to generate the response.
             * Can contain text, image, or audio inputs.
             */
            @JvmStatic
            fun ofArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPart>) =
                Content(arrayOfContentParts = arrayOfContentParts)
        }

        interface Visitor<out T> {

            fun visitTextContent(textContent: String): T

            fun visitArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPart>): T

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
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPart>>())?.let {
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

            @JvmField val USER = of("user")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            USER,
        }

        enum class Value {
            USER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                USER -> Value.USER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                USER -> Known.USER
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

        return /* spotless:off */ other is ChatCompletionUserMessageParam && content == other.content && role == other.role && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, role, name, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionUserMessageParam{content=$content, role=$role, name=$name, additionalProperties=$additionalProperties}"
}
