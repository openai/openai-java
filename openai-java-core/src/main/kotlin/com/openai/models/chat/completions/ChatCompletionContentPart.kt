// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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

/** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
@JsonDeserialize(using = ChatCompletionContentPart.Deserializer::class)
@JsonSerialize(using = ChatCompletionContentPart.Serializer::class)
class ChatCompletionContentPart
private constructor(
    private val text: ChatCompletionContentPartText? = null,
    private val imageUrl: ChatCompletionContentPartImage? = null,
    private val inputAudio: ChatCompletionContentPartInputAudio? = null,
    private val _json: JsonValue? = null,
) {

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun text(): Optional<ChatCompletionContentPartText> = Optional.ofNullable(text)

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun imageUrl(): Optional<ChatCompletionContentPartImage> = Optional.ofNullable(imageUrl)

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun inputAudio(): Optional<ChatCompletionContentPartInputAudio> =
        Optional.ofNullable(inputAudio)

    fun isText(): Boolean = text != null

    fun isImageUrl(): Boolean = imageUrl != null

    fun isInputAudio(): Boolean = inputAudio != null

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun asText(): ChatCompletionContentPartText = text.getOrThrow("text")

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun asImageUrl(): ChatCompletionContentPartImage = imageUrl.getOrThrow("imageUrl")

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun asInputAudio(): ChatCompletionContentPartInputAudio = inputAudio.getOrThrow("inputAudio")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            text != null -> visitor.visitText(text)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            inputAudio != null -> visitor.visitInputAudio(inputAudio)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionContentPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: ChatCompletionContentPartText) {
                    text.validate()
                }

                override fun visitImageUrl(imageUrl: ChatCompletionContentPartImage) {
                    imageUrl.validate()
                }

                override fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio) {
                    inputAudio.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPart && text == other.text && imageUrl == other.imageUrl && inputAudio == other.inputAudio /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, imageUrl, inputAudio) /* spotless:on */

    override fun toString(): String =
        when {
            text != null -> "ChatCompletionContentPart{text=$text}"
            imageUrl != null -> "ChatCompletionContentPart{imageUrl=$imageUrl}"
            inputAudio != null -> "ChatCompletionContentPart{inputAudio=$inputAudio}"
            _json != null -> "ChatCompletionContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
        }

    companion object {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        @JvmStatic
        fun ofText(text: ChatCompletionContentPartText) = ChatCompletionContentPart(text = text)

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        @JvmStatic
        fun ofImageUrl(imageUrl: ChatCompletionContentPartImage) =
            ChatCompletionContentPart(imageUrl = imageUrl)

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        @JvmStatic
        fun ofInputAudio(inputAudio: ChatCompletionContentPartInputAudio) =
            ChatCompletionContentPart(inputAudio = inputAudio)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionContentPart] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        fun visitText(text: ChatCompletionContentPartText): T

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        fun visitImageUrl(imageUrl: ChatCompletionContentPartImage): T

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio): T

        /**
         * Maps an unknown variant of [ChatCompletionContentPart] to a value of type [T].
         *
         * An instance of [ChatCompletionContentPart] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $json")
        }
    }

    internal class Deserializer :
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
                            return ChatCompletionContentPart(text = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartImage>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(imageUrl = it, _json = json)
                        }
                }
                "input_audio" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartInputAudio>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(inputAudio = it, _json = json)
                        }
                }
            }

            return ChatCompletionContentPart(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun serialize(
            value: ChatCompletionContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.inputAudio != null -> generator.writeObject(value.inputAudio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
            }
        }
    }
}
