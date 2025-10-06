// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

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

/** Represents either a file or image attachment. */
@JsonDeserialize(using = ChatKitUploadFileResponse.Deserializer::class)
@JsonSerialize(using = ChatKitUploadFileResponse.Serializer::class)
class ChatKitUploadFileResponse
private constructor(
    private val file: FilePart? = null,
    private val image: ImagePart? = null,
    private val _json: JsonValue? = null,
) {

    /** Metadata for a non-image file uploaded through ChatKit. */
    fun file(): Optional<FilePart> = Optional.ofNullable(file)

    /** Metadata for an image uploaded through ChatKit. */
    fun image(): Optional<ImagePart> = Optional.ofNullable(image)

    fun isFile(): Boolean = file != null

    fun isImage(): Boolean = image != null

    /** Metadata for a non-image file uploaded through ChatKit. */
    fun asFile(): FilePart = file.getOrThrow("file")

    /** Metadata for an image uploaded through ChatKit. */
    fun asImage(): ImagePart = image.getOrThrow("image")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            file != null -> visitor.visitFile(file)
            image != null -> visitor.visitImage(image)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ChatKitUploadFileResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFile(file: FilePart) {
                    file.validate()
                }

                override fun visitImage(image: ImagePart) {
                    image.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitFile(file: FilePart) = file.validity()

                override fun visitImage(image: ImagePart) = image.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatKitUploadFileResponse && file == other.file && image == other.image
    }

    override fun hashCode(): Int = Objects.hash(file, image)

    override fun toString(): String =
        when {
            file != null -> "ChatKitUploadFileResponse{file=$file}"
            image != null -> "ChatKitUploadFileResponse{image=$image}"
            _json != null -> "ChatKitUploadFileResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatKitUploadFileResponse")
        }

    companion object {

        /** Metadata for a non-image file uploaded through ChatKit. */
        @JvmStatic fun ofFile(file: FilePart) = ChatKitUploadFileResponse(file = file)

        /** Metadata for an image uploaded through ChatKit. */
        @JvmStatic fun ofImage(image: ImagePart) = ChatKitUploadFileResponse(image = image)
    }

    /**
     * An interface that defines how to map each variant of [ChatKitUploadFileResponse] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Metadata for a non-image file uploaded through ChatKit. */
        fun visitFile(file: FilePart): T

        /** Metadata for an image uploaded through ChatKit. */
        fun visitImage(image: ImagePart): T

        /**
         * Maps an unknown variant of [ChatKitUploadFileResponse] to a value of type [T].
         *
         * An instance of [ChatKitUploadFileResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatKitUploadFileResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ChatKitUploadFileResponse>(ChatKitUploadFileResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatKitUploadFileResponse {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file" -> {
                    return tryDeserialize(node, jacksonTypeRef<FilePart>())?.let {
                        ChatKitUploadFileResponse(file = it, _json = json)
                    } ?: ChatKitUploadFileResponse(_json = json)
                }
                "image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImagePart>())?.let {
                        ChatKitUploadFileResponse(image = it, _json = json)
                    } ?: ChatKitUploadFileResponse(_json = json)
                }
            }

            return ChatKitUploadFileResponse(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatKitUploadFileResponse>(ChatKitUploadFileResponse::class) {

        override fun serialize(
            value: ChatKitUploadFileResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.file != null -> generator.writeObject(value.file)
                value.image != null -> generator.writeObject(value.image)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatKitUploadFileResponse")
            }
        }
    }
}
