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

/**
 * References an image [File](https://platform.openai.com/docs/api-reference/files) in the content
 * of a message.
 */
@JsonDeserialize(using = MessageContentPartParam.Deserializer::class)
@JsonSerialize(using = MessageContentPartParam.Serializer::class)
class MessageContentPartParam
private constructor(
    private val imageFile: ImageFileContentBlock? = null,
    private val imageUrl: ImageUrlContentBlock? = null,
    private val text: TextContentBlockParam? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun imageFile(): Optional<ImageFileContentBlock> = Optional.ofNullable(imageFile)

    /** References an image URL in the content of a message. */
    fun imageUrl(): Optional<ImageUrlContentBlock> = Optional.ofNullable(imageUrl)

    /** The text content that is part of a message. */
    fun text(): Optional<TextContentBlockParam> = Optional.ofNullable(text)

    fun isImageFile(): Boolean = imageFile != null

    fun isImageUrl(): Boolean = imageUrl != null

    fun isText(): Boolean = text != null

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun asImageFile(): ImageFileContentBlock = imageFile.getOrThrow("imageFile")

    /** References an image URL in the content of a message. */
    fun asImageUrl(): ImageUrlContentBlock = imageUrl.getOrThrow("imageUrl")

    /** The text content that is part of a message. */
    fun asText(): TextContentBlockParam = text.getOrThrow("text")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageFile != null -> visitor.visitImageFile(imageFile)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            text != null -> visitor.visitText(text)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): MessageContentPartParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitImageFile(imageFile: ImageFileContentBlock) {
                    imageFile.validate()
                }

                override fun visitImageUrl(imageUrl: ImageUrlContentBlock) {
                    imageUrl.validate()
                }

                override fun visitText(text: TextContentBlockParam) {
                    text.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageContentPartParam && imageFile == other.imageFile && imageUrl == other.imageUrl && text == other.text /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageFile, imageUrl, text) /* spotless:on */

    override fun toString(): String =
        when {
            imageFile != null -> "MessageContentPartParam{imageFile=$imageFile}"
            imageUrl != null -> "MessageContentPartParam{imageUrl=$imageUrl}"
            text != null -> "MessageContentPartParam{text=$text}"
            _json != null -> "MessageContentPartParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageContentPartParam")
        }

    companion object {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        @JvmStatic
        fun ofImageFile(imageFile: ImageFileContentBlock) =
            MessageContentPartParam(imageFile = imageFile)

        /** References an image URL in the content of a message. */
        @JvmStatic
        fun ofImageUrl(imageUrl: ImageUrlContentBlock) =
            MessageContentPartParam(imageUrl = imageUrl)

        /** The text content that is part of a message. */
        @JvmStatic fun ofText(text: TextContentBlockParam) = MessageContentPartParam(text = text)
    }

    /**
     * An interface that defines how to map each variant of [MessageContentPartParam] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        fun visitImageFile(imageFile: ImageFileContentBlock): T

        /** References an image URL in the content of a message. */
        fun visitImageUrl(imageUrl: ImageUrlContentBlock): T

        /** The text content that is part of a message. */
        fun visitText(text: TextContentBlockParam): T

        /**
         * Maps an unknown variant of [MessageContentPartParam] to a value of type [T].
         *
         * An instance of [MessageContentPartParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageContentPartParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<MessageContentPartParam>(MessageContentPartParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageContentPartParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_file" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageFileContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(imageFile = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageUrlContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(imageUrl = it, _json = json)
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<TextContentBlockParam>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(text = it, _json = json)
                        }
                }
            }

            return MessageContentPartParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<MessageContentPartParam>(MessageContentPartParam::class) {

        override fun serialize(
            value: MessageContentPartParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.imageFile != null -> generator.writeObject(value.imageFile)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.text != null -> generator.writeObject(value.text)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageContentPartParam")
            }
        }
    }
}
