// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

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

/** Emitted when a partial image is available during image editing streaming. */
@JsonDeserialize(using = ImageEditStreamEvent.Deserializer::class)
@JsonSerialize(using = ImageEditStreamEvent.Serializer::class)
class ImageEditStreamEvent
private constructor(
    private val partialImage: ImageEditPartialImageEvent? = null,
    private val completed: ImageEditCompletedEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when a partial image is available during image editing streaming. */
    fun partialImage(): Optional<ImageEditPartialImageEvent> = Optional.ofNullable(partialImage)

    /** Emitted when image editing has completed and the final image is available. */
    fun completed(): Optional<ImageEditCompletedEvent> = Optional.ofNullable(completed)

    fun isPartialImage(): Boolean = partialImage != null

    fun isCompleted(): Boolean = completed != null

    /** Emitted when a partial image is available during image editing streaming. */
    fun asPartialImage(): ImageEditPartialImageEvent = partialImage.getOrThrow("partialImage")

    /** Emitted when image editing has completed and the final image is available. */
    fun asCompleted(): ImageEditCompletedEvent = completed.getOrThrow("completed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            partialImage != null -> visitor.visitPartialImage(partialImage)
            completed != null -> visitor.visitCompleted(completed)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ImageEditStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPartialImage(partialImage: ImageEditPartialImageEvent) {
                    partialImage.validate()
                }

                override fun visitCompleted(completed: ImageEditCompletedEvent) {
                    completed.validate()
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
                override fun visitPartialImage(partialImage: ImageEditPartialImageEvent) =
                    partialImage.validity()

                override fun visitCompleted(completed: ImageEditCompletedEvent) =
                    completed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImageEditStreamEvent &&
            partialImage == other.partialImage &&
            completed == other.completed
    }

    override fun hashCode(): Int = Objects.hash(partialImage, completed)

    override fun toString(): String =
        when {
            partialImage != null -> "ImageEditStreamEvent{partialImage=$partialImage}"
            completed != null -> "ImageEditStreamEvent{completed=$completed}"
            _json != null -> "ImageEditStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ImageEditStreamEvent")
        }

    companion object {

        /** Emitted when a partial image is available during image editing streaming. */
        @JvmStatic
        fun ofPartialImage(partialImage: ImageEditPartialImageEvent) =
            ImageEditStreamEvent(partialImage = partialImage)

        /** Emitted when image editing has completed and the final image is available. */
        @JvmStatic
        fun ofCompleted(completed: ImageEditCompletedEvent) =
            ImageEditStreamEvent(completed = completed)
    }

    /**
     * An interface that defines how to map each variant of [ImageEditStreamEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Emitted when a partial image is available during image editing streaming. */
        fun visitPartialImage(partialImage: ImageEditPartialImageEvent): T

        /** Emitted when image editing has completed and the final image is available. */
        fun visitCompleted(completed: ImageEditCompletedEvent): T

        /**
         * Maps an unknown variant of [ImageEditStreamEvent] to a value of type [T].
         *
         * An instance of [ImageEditStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ImageEditStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ImageEditStreamEvent>(ImageEditStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ImageEditStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_edit.partial_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageEditPartialImageEvent>())?.let {
                        ImageEditStreamEvent(partialImage = it, _json = json)
                    } ?: ImageEditStreamEvent(_json = json)
                }
                "image_edit.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageEditCompletedEvent>())?.let {
                        ImageEditStreamEvent(completed = it, _json = json)
                    } ?: ImageEditStreamEvent(_json = json)
                }
            }

            return ImageEditStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ImageEditStreamEvent>(ImageEditStreamEvent::class) {

        override fun serialize(
            value: ImageEditStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.partialImage != null -> generator.writeObject(value.partialImage)
                value.completed != null -> generator.writeObject(value.completed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ImageEditStreamEvent")
            }
        }
    }
}
