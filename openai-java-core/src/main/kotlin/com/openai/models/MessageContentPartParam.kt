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
    private val imageFileContentBlock: ImageFileContentBlock? = null,
    private val imageUrlContentBlock: ImageUrlContentBlock? = null,
    private val textContentBlockParam: TextContentBlockParam? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun imageFileContentBlock(): Optional<ImageFileContentBlock> =
        Optional.ofNullable(imageFileContentBlock)

    /** References an image URL in the content of a message. */
    fun imageUrlContentBlock(): Optional<ImageUrlContentBlock> =
        Optional.ofNullable(imageUrlContentBlock)

    /** The text content that is part of a message. */
    fun textContentBlockParam(): Optional<TextContentBlockParam> =
        Optional.ofNullable(textContentBlockParam)

    fun isImageFileContentBlock(): Boolean = imageFileContentBlock != null

    fun isImageUrlContentBlock(): Boolean = imageUrlContentBlock != null

    fun isTextContentBlockParam(): Boolean = textContentBlockParam != null

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun asImageFileContentBlock(): ImageFileContentBlock =
        imageFileContentBlock.getOrThrow("imageFileContentBlock")

    /** References an image URL in the content of a message. */
    fun asImageUrlContentBlock(): ImageUrlContentBlock =
        imageUrlContentBlock.getOrThrow("imageUrlContentBlock")

    /** The text content that is part of a message. */
    fun asTextContentBlockParam(): TextContentBlockParam =
        textContentBlockParam.getOrThrow("textContentBlockParam")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageFileContentBlock != null ->
                visitor.visitImageFileContentBlock(imageFileContentBlock)
            imageUrlContentBlock != null -> visitor.visitImageUrlContentBlock(imageUrlContentBlock)
            textContentBlockParam != null ->
                visitor.visitTextContentBlockParam(textContentBlockParam)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): MessageContentPartParam = apply {
        if (!validated) {
            if (
                imageFileContentBlock == null &&
                    imageUrlContentBlock == null &&
                    textContentBlockParam == null
            ) {
                throw OpenAIInvalidDataException("Unknown MessageContentPartParam: $_json")
            }
            imageFileContentBlock?.validate()
            imageUrlContentBlock?.validate()
            textContentBlockParam?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageContentPartParam && imageFileContentBlock == other.imageFileContentBlock && imageUrlContentBlock == other.imageUrlContentBlock && textContentBlockParam == other.textContentBlockParam /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageFileContentBlock, imageUrlContentBlock, textContentBlockParam) /* spotless:on */

    override fun toString(): String =
        when {
            imageFileContentBlock != null ->
                "MessageContentPartParam{imageFileContentBlock=$imageFileContentBlock}"
            imageUrlContentBlock != null ->
                "MessageContentPartParam{imageUrlContentBlock=$imageUrlContentBlock}"
            textContentBlockParam != null ->
                "MessageContentPartParam{textContentBlockParam=$textContentBlockParam}"
            _json != null -> "MessageContentPartParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageContentPartParam")
        }

    companion object {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        @JvmStatic
        fun ofImageFileContentBlock(imageFileContentBlock: ImageFileContentBlock) =
            MessageContentPartParam(imageFileContentBlock = imageFileContentBlock)

        /** References an image URL in the content of a message. */
        @JvmStatic
        fun ofImageUrlContentBlock(imageUrlContentBlock: ImageUrlContentBlock) =
            MessageContentPartParam(imageUrlContentBlock = imageUrlContentBlock)

        /** The text content that is part of a message. */
        @JvmStatic
        fun ofTextContentBlockParam(textContentBlockParam: TextContentBlockParam) =
            MessageContentPartParam(textContentBlockParam = textContentBlockParam)
    }

    interface Visitor<out T> {

        fun visitImageFileContentBlock(imageFileContentBlock: ImageFileContentBlock): T

        fun visitImageUrlContentBlock(imageUrlContentBlock: ImageUrlContentBlock): T

        fun visitTextContentBlockParam(textContentBlockParam: TextContentBlockParam): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageContentPartParam: $json")
        }
    }

    class Deserializer : BaseDeserializer<MessageContentPartParam>(MessageContentPartParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageContentPartParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_file" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageFileContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(imageFileContentBlock = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageUrlContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(imageUrlContentBlock = it, _json = json)
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<TextContentBlockParam>()) { it.validate() }
                        ?.let {
                            return MessageContentPartParam(textContentBlockParam = it, _json = json)
                        }
                }
            }

            return MessageContentPartParam(_json = json)
        }
    }

    class Serializer : BaseSerializer<MessageContentPartParam>(MessageContentPartParam::class) {

        override fun serialize(
            value: MessageContentPartParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.imageFileContentBlock != null ->
                    generator.writeObject(value.imageFileContentBlock)
                value.imageUrlContentBlock != null ->
                    generator.writeObject(value.imageUrlContentBlock)
                value.textContentBlockParam != null ->
                    generator.writeObject(value.textContentBlockParam)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageContentPartParam")
            }
        }
    }
}
