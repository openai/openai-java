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
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = ChatCompletionContentPart.Deserializer::class)
@JsonSerialize(using = ChatCompletionContentPart.Serializer::class)
class ChatCompletionContentPart
private constructor(
    private val chatCompletionContentPartText: ChatCompletionContentPartText? = null,
    private val chatCompletionContentPartImage: ChatCompletionContentPartImage? = null,
    private val chatCompletionContentPartInputAudio: ChatCompletionContentPartInputAudio? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun chatCompletionContentPartText(): Optional<ChatCompletionContentPartText> =
        Optional.ofNullable(chatCompletionContentPartText)
    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun chatCompletionContentPartImage(): Optional<ChatCompletionContentPartImage> =
        Optional.ofNullable(chatCompletionContentPartImage)
    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun chatCompletionContentPartInputAudio(): Optional<ChatCompletionContentPartInputAudio> =
        Optional.ofNullable(chatCompletionContentPartInputAudio)

    fun isChatCompletionContentPartText(): Boolean = chatCompletionContentPartText != null

    fun isChatCompletionContentPartImage(): Boolean = chatCompletionContentPartImage != null

    fun isChatCompletionContentPartInputAudio(): Boolean =
        chatCompletionContentPartInputAudio != null

    fun asChatCompletionContentPartText(): ChatCompletionContentPartText =
        chatCompletionContentPartText.getOrThrow("chatCompletionContentPartText")

    fun asChatCompletionContentPartImage(): ChatCompletionContentPartImage =
        chatCompletionContentPartImage.getOrThrow("chatCompletionContentPartImage")

    fun asChatCompletionContentPartInputAudio(): ChatCompletionContentPartInputAudio =
        chatCompletionContentPartInputAudio.getOrThrow("chatCompletionContentPartInputAudio")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            chatCompletionContentPartText != null ->
                visitor.visitChatCompletionContentPartText(chatCompletionContentPartText)
            chatCompletionContentPartImage != null ->
                visitor.visitChatCompletionContentPartImage(chatCompletionContentPartImage)
            chatCompletionContentPartInputAudio != null ->
                visitor.visitChatCompletionContentPartInputAudio(
                    chatCompletionContentPartInputAudio
                )
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ChatCompletionContentPart = apply {
        if (!validated) {
            if (
                chatCompletionContentPartText == null &&
                    chatCompletionContentPartImage == null &&
                    chatCompletionContentPartInputAudio == null
            ) {
                throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $_json")
            }
            chatCompletionContentPartText?.validate()
            chatCompletionContentPartImage?.validate()
            chatCompletionContentPartInputAudio?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPart && chatCompletionContentPartText == other.chatCompletionContentPartText && chatCompletionContentPartImage == other.chatCompletionContentPartImage && chatCompletionContentPartInputAudio == other.chatCompletionContentPartInputAudio /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(chatCompletionContentPartText, chatCompletionContentPartImage, chatCompletionContentPartInputAudio) /* spotless:on */

    override fun toString(): String =
        when {
            chatCompletionContentPartText != null ->
                "ChatCompletionContentPart{chatCompletionContentPartText=$chatCompletionContentPartText}"
            chatCompletionContentPartImage != null ->
                "ChatCompletionContentPart{chatCompletionContentPartImage=$chatCompletionContentPartImage}"
            chatCompletionContentPartInputAudio != null ->
                "ChatCompletionContentPart{chatCompletionContentPartInputAudio=$chatCompletionContentPartInputAudio}"
            _json != null -> "ChatCompletionContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
        }

    companion object {

        @JvmStatic
        fun ofChatCompletionContentPartText(
            chatCompletionContentPartText: ChatCompletionContentPartText
        ) = ChatCompletionContentPart(chatCompletionContentPartText = chatCompletionContentPartText)

        @JvmStatic
        fun ofChatCompletionContentPartImage(
            chatCompletionContentPartImage: ChatCompletionContentPartImage
        ) =
            ChatCompletionContentPart(
                chatCompletionContentPartImage = chatCompletionContentPartImage
            )

        @JvmStatic
        fun ofChatCompletionContentPartInputAudio(
            chatCompletionContentPartInputAudio: ChatCompletionContentPartInputAudio
        ) =
            ChatCompletionContentPart(
                chatCompletionContentPartInputAudio = chatCompletionContentPartInputAudio
            )
    }

    interface Visitor<out T> {

        fun visitChatCompletionContentPartText(
            chatCompletionContentPartText: ChatCompletionContentPartText
        ): T

        fun visitChatCompletionContentPartImage(
            chatCompletionContentPartImage: ChatCompletionContentPartImage
        ): T

        fun visitChatCompletionContentPartInputAudio(
            chatCompletionContentPartInputAudio: ChatCompletionContentPartInputAudio
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionContentPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartText>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(
                                chatCompletionContentPartText = it,
                                _json = json
                            )
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartImage>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(
                                chatCompletionContentPartImage = it,
                                _json = json
                            )
                        }
                }
                "input_audio" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartInputAudio>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(
                                chatCompletionContentPartInputAudio = it,
                                _json = json
                            )
                        }
                }
            }

            return ChatCompletionContentPart(_json = json)
        }
    }

    class Serializer : BaseSerializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun serialize(
            value: ChatCompletionContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.chatCompletionContentPartText != null ->
                    generator.writeObject(value.chatCompletionContentPartText)
                value.chatCompletionContentPartImage != null ->
                    generator.writeObject(value.chatCompletionContentPartImage)
                value.chatCompletionContentPartInputAudio != null ->
                    generator.writeObject(value.chatCompletionContentPartInputAudio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
            }
        }
    }
}
