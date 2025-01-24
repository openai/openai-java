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
    private val imageFile: ImageFileDeltaBlock? = null,
    private val text: TextDeltaBlock? = null,
    private val refusal: RefusalDeltaBlock? = null,
    private val imageUrl: ImageUrlDeltaBlock? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun imageFile(): Optional<ImageFileDeltaBlock> = Optional.ofNullable(imageFile)

    /** The text content that is part of a message. */
    fun text(): Optional<TextDeltaBlock> = Optional.ofNullable(text)

    /** The refusal content that is part of a message. */
    fun refusal(): Optional<RefusalDeltaBlock> = Optional.ofNullable(refusal)

    /** References an image URL in the content of a message. */
    fun imageUrl(): Optional<ImageUrlDeltaBlock> = Optional.ofNullable(imageUrl)

    fun isImageFile(): Boolean = imageFile != null

    fun isText(): Boolean = text != null

    fun isRefusal(): Boolean = refusal != null

    fun isImageUrl(): Boolean = imageUrl != null

    /**
     * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
     * content of a message.
     */
    fun asImageFile(): ImageFileDeltaBlock = imageFile.getOrThrow("imageFile")

    /** The text content that is part of a message. */
    fun asText(): TextDeltaBlock = text.getOrThrow("text")

    /** The refusal content that is part of a message. */
    fun asRefusal(): RefusalDeltaBlock = refusal.getOrThrow("refusal")

    /** References an image URL in the content of a message. */
    fun asImageUrl(): ImageUrlDeltaBlock = imageUrl.getOrThrow("imageUrl")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageFile != null -> visitor.visitImageFile(imageFile)
            text != null -> visitor.visitText(text)
            refusal != null -> visitor.visitRefusal(refusal)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
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
                override fun visitImageFile(imageFile: ImageFileDeltaBlock) {
                    imageFile.validate()
                }

                override fun visitText(text: TextDeltaBlock) {
                    text.validate()
                }

                override fun visitRefusal(refusal: RefusalDeltaBlock) {
                    refusal.validate()
                }

                override fun visitImageUrl(imageUrl: ImageUrlDeltaBlock) {
                    imageUrl.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageContentDelta && imageFile == other.imageFile && text == other.text && refusal == other.refusal && imageUrl == other.imageUrl /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageFile, text, refusal, imageUrl) /* spotless:on */

    override fun toString(): String =
        when {
            imageFile != null -> "MessageContentDelta{imageFile=$imageFile}"
            text != null -> "MessageContentDelta{text=$text}"
            refusal != null -> "MessageContentDelta{refusal=$refusal}"
            imageUrl != null -> "MessageContentDelta{imageUrl=$imageUrl}"
            _json != null -> "MessageContentDelta{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MessageContentDelta")
        }

    companion object {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        @JvmStatic
        fun ofImageFile(imageFile: ImageFileDeltaBlock) = MessageContentDelta(imageFile = imageFile)

        /** The text content that is part of a message. */
        @JvmStatic fun ofText(text: TextDeltaBlock) = MessageContentDelta(text = text)

        /** The refusal content that is part of a message. */
        @JvmStatic
        fun ofRefusal(refusal: RefusalDeltaBlock) = MessageContentDelta(refusal = refusal)

        /** References an image URL in the content of a message. */
        @JvmStatic
        fun ofImageUrl(imageUrl: ImageUrlDeltaBlock) = MessageContentDelta(imageUrl = imageUrl)
    }

    interface Visitor<out T> {

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        fun visitImageFile(imageFile: ImageFileDeltaBlock): T

        /** The text content that is part of a message. */
        fun visitText(text: TextDeltaBlock): T

        /** The refusal content that is part of a message. */
        fun visitRefusal(refusal: RefusalDeltaBlock): T

        /** References an image URL in the content of a message. */
        fun visitImageUrl(imageUrl: ImageUrlDeltaBlock): T

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
                            return MessageContentDelta(imageFile = it, _json = json)
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<TextDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(text = it, _json = json)
                        }
                }
                "refusal" -> {
                    tryDeserialize(node, jacksonTypeRef<RefusalDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(refusal = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ImageUrlDeltaBlock>()) { it.validate() }
                        ?.let {
                            return MessageContentDelta(imageUrl = it, _json = json)
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
                value.imageFile != null -> generator.writeObject(value.imageFile)
                value.text != null -> generator.writeObject(value.text)
                value.refusal != null -> generator.writeObject(value.refusal)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MessageContentDelta")
            }
        }
    }
}
