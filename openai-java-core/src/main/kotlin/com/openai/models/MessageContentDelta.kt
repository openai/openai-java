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
@JsonDeserialize(using = MessageContentDelta.Deserializer::class)
@JsonSerialize(using = MessageContentDelta.Serializer::class)
class MessageContentDelta
private constructor(
    private val imageFileDeltaBlock: ImageFileDeltaBlock? = null,
    private val textDeltaBlock: TextDeltaBlock? = null,
    private val refusalDeltaBlock: RefusalDeltaBlock? = null,
    private val imageUrlDeltaBlock: ImageUrlDeltaBlock? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun imageFileDeltaBlock(): Optional<ImageFileDeltaBlock> =
        Optional.ofNullable(imageFileDeltaBlock)

    /** The text content that is part of a message. */
    fun textDeltaBlock(): Optional<TextDeltaBlock> = Optional.ofNullable(textDeltaBlock)

    /** The refusal content that is part of a message. */
    fun refusalDeltaBlock(): Optional<RefusalDeltaBlock> = Optional.ofNullable(refusalDeltaBlock)

    /** References an image URL in the content of a message. */
    fun imageUrlDeltaBlock(): Optional<ImageUrlDeltaBlock> = Optional.ofNullable(imageUrlDeltaBlock)

    fun isImageFileDeltaBlock(): Boolean = imageFileDeltaBlock != null

    fun isTextDeltaBlock(): Boolean = textDeltaBlock != null

    fun isRefusalDeltaBlock(): Boolean = refusalDeltaBlock != null

    fun isImageUrlDeltaBlock(): Boolean = imageUrlDeltaBlock != null

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun asImageFileDeltaBlock(): ImageFileDeltaBlock =
        imageFileDeltaBlock.getOrThrow("imageFileDeltaBlock")

    /** The text content that is part of a message. */
    fun asTextDeltaBlock(): TextDeltaBlock = textDeltaBlock.getOrThrow("textDeltaBlock")

    /** The refusal content that is part of a message. */
    fun asRefusalDeltaBlock(): RefusalDeltaBlock = refusalDeltaBlock.getOrThrow("refusalDeltaBlock")

    /** References an image URL in the content of a message. */
    fun asImageUrlDeltaBlock(): ImageUrlDeltaBlock =
        imageUrlDeltaBlock.getOrThrow("imageUrlDeltaBlock")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageFileDeltaBlock != null -> visitor.visitImageFileDeltaBlock(imageFileDeltaBlock)
            textDeltaBlock != null -> visitor.visitTextDeltaBlock(textDeltaBlock)
            refusalDeltaBlock != null -> visitor.visitRefusalDeltaBlock(refusalDeltaBlock)
            imageUrlDeltaBlock != null -> visitor.visitImageUrlDeltaBlock(imageUrlDeltaBlock)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): MessageContentDelta = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitImageFileDeltaBlock(imageFileDeltaBlock: ImageFileDeltaBlock) {
                    imageFileDeltaBlock.validate()
                }

                override fun visitTextDeltaBlock(textDeltaBlock: TextDeltaBlock) {
                    textDeltaBlock.validate()
                }

                override fun visitRefusalDeltaBlock(refusalDeltaBlock: RefusalDeltaBlock) {
                    refusalDeltaBlock.validate()
                }

                override fun visitImageUrlDeltaBlock(imageUrlDeltaBlock: ImageUrlDeltaBlock) {
                    imageUrlDeltaBlock.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageContentDelta && imageFileDeltaBlock == other.imageFileDeltaBlock && textDeltaBlock == other.textDeltaBlock && refusalDeltaBlock == other.refusalDeltaBlock && imageUrlDeltaBlock == other.imageUrlDeltaBlock /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageFileDeltaBlock, textDeltaBlock, refusalDeltaBlock, imageUrlDeltaBlock) /* spotless:on */

    override fun toString(): String =
        when {
            imageFileDeltaBlock != null ->
                "MessageContentDelta{imageFileDeltaBlock=$imageFileDeltaBlock}"
            textDeltaBlock != null -> "MessageContentDelta{textDeltaBlock=$textDeltaBlock}"
            refusalDeltaBlock != null -> "MessageContentDelta{refusalDeltaBlock=$refusalDeltaBlock}"
            imageUrlDeltaBlock != null ->
                "MessageContentDelta{imageUrlDeltaBlock=$imageUrlDeltaBlock}"
            _json != null -> "MessageContentDelta{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageContentDelta")
        }

    companion object {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        @JvmStatic
        fun ofImageFileDeltaBlock(imageFileDeltaBlock: ImageFileDeltaBlock) =
            MessageContentDelta(imageFileDeltaBlock = imageFileDeltaBlock)

        /** The text content that is part of a message. */
        @JvmStatic
        fun ofTextDeltaBlock(textDeltaBlock: TextDeltaBlock) =
            MessageContentDelta(textDeltaBlock = textDeltaBlock)

        /** The refusal content that is part of a message. */
        @JvmStatic
        fun ofRefusalDeltaBlock(refusalDeltaBlock: RefusalDeltaBlock) =
            MessageContentDelta(refusalDeltaBlock = refusalDeltaBlock)

        /** References an image URL in the content of a message. */
        @JvmStatic
        fun ofImageUrlDeltaBlock(imageUrlDeltaBlock: ImageUrlDeltaBlock) =
            MessageContentDelta(imageUrlDeltaBlock = imageUrlDeltaBlock)
    }

    interface Visitor<out T> {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        fun visitImageFileDeltaBlock(imageFileDeltaBlock: ImageFileDeltaBlock): T

        /** The text content that is part of a message. */
        fun visitTextDeltaBlock(textDeltaBlock: TextDeltaBlock): T

        /** The refusal content that is part of a message. */
        fun visitRefusalDeltaBlock(refusalDeltaBlock: RefusalDeltaBlock): T

        /** References an image URL in the content of a message. */
        fun visitImageUrlDeltaBlock(imageUrlDeltaBlock: ImageUrlDeltaBlock): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageContentDelta: $json")
        }
    }

    class Deserializer : BaseDeserializer<MessageContentDelta>(MessageContentDelta::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageContentDelta {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_file" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageFileDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(imageFileDeltaBlock = it, _json = json)
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<TextDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(textDeltaBlock = it, _json = json)
                        }
                }
                "refusal" -> {
                    tryDeserialize(node, jacksonTypeRef<RefusalDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(refusalDeltaBlock = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageUrlDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(imageUrlDeltaBlock = it, _json = json)
                        }
                }
            }

            return MessageContentDelta(_json = json)
        }
    }

    class Serializer : BaseSerializer<MessageContentDelta>(MessageContentDelta::class) {

        override fun serialize(
            value: MessageContentDelta,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.imageFileDeltaBlock != null ->
                    generator.writeObject(value.imageFileDeltaBlock)
                value.textDeltaBlock != null -> generator.writeObject(value.textDeltaBlock)
                value.refusalDeltaBlock != null -> generator.writeObject(value.refusalDeltaBlock)
                value.imageUrlDeltaBlock != null -> generator.writeObject(value.imageUrlDeltaBlock)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageContentDelta")
            }
        }
    }
}
