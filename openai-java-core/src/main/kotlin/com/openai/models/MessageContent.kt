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
@JsonDeserialize(using = MessageContent.Deserializer::class)
@JsonSerialize(using = MessageContent.Serializer::class)
class MessageContent
private constructor(
    private val imageFile: ImageFileContentBlock? = null,
    private val imageUrl: ImageUrlContentBlock? = null,
    private val text: TextContentBlock? = null,
    private val refusal: RefusalContentBlock? = null,
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
    fun text(): Optional<TextContentBlock> = Optional.ofNullable(text)

    /** The refusal content generated by the assistant. */
    fun refusal(): Optional<RefusalContentBlock> = Optional.ofNullable(refusal)

    fun isImageFile(): Boolean = imageFile != null

    fun isImageUrl(): Boolean = imageUrl != null

    fun isText(): Boolean = text != null

    fun isRefusal(): Boolean = refusal != null

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun asImageFile(): ImageFileContentBlock = imageFile.getOrThrow("imageFile")

    /** References an image URL in the content of a message. */
    fun asImageUrl(): ImageUrlContentBlock = imageUrl.getOrThrow("imageUrl")

    /** The text content that is part of a message. */
    fun asText(): TextContentBlock = text.getOrThrow("text")

    /** The refusal content generated by the assistant. */
    fun asRefusal(): RefusalContentBlock = refusal.getOrThrow("refusal")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageFile != null -> visitor.visitImageFile(imageFile)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            text != null -> visitor.visitText(text)
            refusal != null -> visitor.visitRefusal(refusal)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): MessageContent = apply {
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

                override fun visitText(text: TextContentBlock) {
                    text.validate()
                }

                override fun visitRefusal(refusal: RefusalContentBlock) {
                    refusal.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageContent && imageFile == other.imageFile && imageUrl == other.imageUrl && text == other.text && refusal == other.refusal /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageFile, imageUrl, text, refusal) /* spotless:on */

    override fun toString(): String =
        when {
            imageFile != null -> "MessageContent{imageFile=$imageFile}"
            imageUrl != null -> "MessageContent{imageUrl=$imageUrl}"
            text != null -> "MessageContent{text=$text}"
            refusal != null -> "MessageContent{refusal=$refusal}"
            _json != null -> "MessageContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageContent")
        }

    companion object {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        @JvmStatic
        fun ofImageFile(imageFile: ImageFileContentBlock) = MessageContent(imageFile = imageFile)

        /** References an image URL in the content of a message. */
        @JvmStatic
        fun ofImageUrl(imageUrl: ImageUrlContentBlock) = MessageContent(imageUrl = imageUrl)

        /** The text content that is part of a message. */
        @JvmStatic fun ofText(text: TextContentBlock) = MessageContent(text = text)

        /** The refusal content generated by the assistant. */
        @JvmStatic fun ofRefusal(refusal: RefusalContentBlock) = MessageContent(refusal = refusal)
    }

    /**
     * An interface that defines how to map each variant of [MessageContent] to a value of type [T].
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
        fun visitText(text: TextContentBlock): T

        /** The refusal content generated by the assistant. */
        fun visitRefusal(refusal: RefusalContentBlock): T

        /**
         * Maps an unknown variant of [MessageContent] to a value of type [T].
         *
         * An instance of [MessageContent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown MessageContent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<MessageContent>(MessageContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): MessageContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_file" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageFileContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContent(imageFile = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageUrlContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContent(imageUrl = it, _json = json)
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<TextContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContent(text = it, _json = json)
                        }
                }
                "refusal" -> {
                    tryDeserialize(node, jacksonTypeRef<RefusalContentBlock>()) { it.validate() }
                        ?.let {
                            return MessageContent(refusal = it, _json = json)
                        }
                }
            }

            return MessageContent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<MessageContent>(MessageContent::class) {

        override fun serialize(
            value: MessageContent,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.imageFile != null -> generator.writeObject(value.imageFile)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.text != null -> generator.writeObject(value.text)
                value.refusal != null -> generator.writeObject(value.refusal)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageContent")
            }
        }
    }
}
