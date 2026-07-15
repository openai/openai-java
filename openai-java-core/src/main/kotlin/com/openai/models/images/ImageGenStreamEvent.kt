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

/** Emitted when a partial image is available during image generation streaming. */
@JsonDeserialize(using = ImageGenStreamEvent.Deserializer::class)
@JsonSerialize(using = ImageGenStreamEvent.Serializer::class)
class ImageGenStreamEvent
private constructor(
    private val generationPartialImage: ImageGenPartialImageEvent? = null,
    private val generationCompleted: ImageGenCompletedEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Emitted when a partial image is available during image generation streaming. */
    fun generationPartialImage(): Optional<ImageGenPartialImageEvent> =
        Optional.ofNullable(generationPartialImage)

    /** Emitted when image generation has completed and the final image is available. */
    fun generationCompleted(): Optional<ImageGenCompletedEvent> =
        Optional.ofNullable(generationCompleted)

    fun isGenerationPartialImage(): Boolean = generationPartialImage != null

    fun isGenerationCompleted(): Boolean = generationCompleted != null

    /** Emitted when a partial image is available during image generation streaming. */
    fun asGenerationPartialImage(): ImageGenPartialImageEvent =
        generationPartialImage.getOrThrow("generationPartialImage")

    /** Emitted when image generation has completed and the final image is available. */
    fun asGenerationCompleted(): ImageGenCompletedEvent =
        generationCompleted.getOrThrow("generationCompleted")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = imageGenStreamEvent.accept(new ImageGenStreamEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitGenerationPartialImage(ImageGenPartialImageEvent generationPartialImage) {
     *         return Optional.of(generationPartialImage.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            generationPartialImage != null ->
                visitor.visitGenerationPartialImage(generationPartialImage)
            generationCompleted != null -> visitor.visitGenerationCompleted(generationCompleted)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ImageGenStreamEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitGenerationPartialImage(
                    generationPartialImage: ImageGenPartialImageEvent
                ) {
                    generationPartialImage.validate()
                }

                override fun visitGenerationCompleted(generationCompleted: ImageGenCompletedEvent) {
                    generationCompleted.validate()
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
                override fun visitGenerationPartialImage(
                    generationPartialImage: ImageGenPartialImageEvent
                ) = generationPartialImage.validity()

                override fun visitGenerationCompleted(generationCompleted: ImageGenCompletedEvent) =
                    generationCompleted.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImageGenStreamEvent &&
            generationPartialImage == other.generationPartialImage &&
            generationCompleted == other.generationCompleted
    }

    override fun hashCode(): Int = Objects.hash(generationPartialImage, generationCompleted)

    override fun toString(): String =
        when {
            generationPartialImage != null ->
                "ImageGenStreamEvent{generationPartialImage=$generationPartialImage}"
            generationCompleted != null ->
                "ImageGenStreamEvent{generationCompleted=$generationCompleted}"
            _json != null -> "ImageGenStreamEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ImageGenStreamEvent")
        }

    companion object {

        /** Emitted when a partial image is available during image generation streaming. */
        @JvmStatic
        fun ofGenerationPartialImage(generationPartialImage: ImageGenPartialImageEvent) =
            ImageGenStreamEvent(generationPartialImage = generationPartialImage)

        /** Emitted when image generation has completed and the final image is available. */
        @JvmStatic
        fun ofGenerationCompleted(generationCompleted: ImageGenCompletedEvent) =
            ImageGenStreamEvent(generationCompleted = generationCompleted)
    }

    /**
     * An interface that defines how to map each variant of [ImageGenStreamEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Emitted when a partial image is available during image generation streaming. */
        fun visitGenerationPartialImage(generationPartialImage: ImageGenPartialImageEvent): T

        /** Emitted when image generation has completed and the final image is available. */
        fun visitGenerationCompleted(generationCompleted: ImageGenCompletedEvent): T

        /**
         * Maps an unknown variant of [ImageGenStreamEvent] to a value of type [T].
         *
         * An instance of [ImageGenStreamEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ImageGenStreamEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ImageGenStreamEvent>(ImageGenStreamEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ImageGenStreamEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_generation.partial_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageGenPartialImageEvent>())?.let {
                        ImageGenStreamEvent(generationPartialImage = it, _json = json)
                    } ?: ImageGenStreamEvent(_json = json)
                }
                "image_generation.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageGenCompletedEvent>())?.let {
                        ImageGenStreamEvent(generationCompleted = it, _json = json)
                    } ?: ImageGenStreamEvent(_json = json)
                }
            }

            return ImageGenStreamEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ImageGenStreamEvent>(ImageGenStreamEvent::class) {

        override fun serialize(
            value: ImageGenStreamEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.generationPartialImage != null ->
                    generator.writeObject(value.generationPartialImage)
                value.generationCompleted != null ->
                    generator.writeObject(value.generationCompleted)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ImageGenStreamEvent")
            }
        }
    }
}
