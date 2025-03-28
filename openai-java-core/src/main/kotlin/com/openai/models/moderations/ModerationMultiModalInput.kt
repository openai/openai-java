// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

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

/** An object describing an image to classify. */
@JsonDeserialize(using = ModerationMultiModalInput.Deserializer::class)
@JsonSerialize(using = ModerationMultiModalInput.Serializer::class)
class ModerationMultiModalInput
private constructor(
    private val imageUrl: ModerationImageUrlInput? = null,
    private val text: ModerationTextInput? = null,
    private val _json: JsonValue? = null,
) {

    /** An object describing an image to classify. */
    fun imageUrl(): Optional<ModerationImageUrlInput> = Optional.ofNullable(imageUrl)

    /** An object describing text to classify. */
    fun text(): Optional<ModerationTextInput> = Optional.ofNullable(text)

    fun isImageUrl(): Boolean = imageUrl != null

    fun isText(): Boolean = text != null

    /** An object describing an image to classify. */
    fun asImageUrl(): ModerationImageUrlInput = imageUrl.getOrThrow("imageUrl")

    /** An object describing text to classify. */
    fun asText(): ModerationTextInput = text.getOrThrow("text")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            text != null -> visitor.visitText(text)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ModerationMultiModalInput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitImageUrl(imageUrl: ModerationImageUrlInput) {
                    imageUrl.validate()
                }

                override fun visitText(text: ModerationTextInput) {
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

        return /* spotless:off */ other is ModerationMultiModalInput && imageUrl == other.imageUrl && text == other.text /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(imageUrl, text) /* spotless:on */

    override fun toString(): String =
        when {
            imageUrl != null -> "ModerationMultiModalInput{imageUrl=$imageUrl}"
            text != null -> "ModerationMultiModalInput{text=$text}"
            _json != null -> "ModerationMultiModalInput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ModerationMultiModalInput")
        }

    companion object {

        /** An object describing an image to classify. */
        @JvmStatic
        fun ofImageUrl(imageUrl: ModerationImageUrlInput) =
            ModerationMultiModalInput(imageUrl = imageUrl)

        /** An object describing text to classify. */
        @JvmStatic fun ofText(text: ModerationTextInput) = ModerationMultiModalInput(text = text)
    }

    /**
     * An interface that defines how to map each variant of [ModerationMultiModalInput] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** An object describing an image to classify. */
        fun visitImageUrl(imageUrl: ModerationImageUrlInput): T

        /** An object describing text to classify. */
        fun visitText(text: ModerationTextInput): T

        /**
         * Maps an unknown variant of [ModerationMultiModalInput] to a value of type [T].
         *
         * An instance of [ModerationMultiModalInput] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ModerationMultiModalInput: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ModerationMultiModalInput>(ModerationMultiModalInput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ModerationMultiModalInput {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_url" -> {
                    return ModerationMultiModalInput(
                        imageUrl = deserialize(node, jacksonTypeRef<ModerationImageUrlInput>()),
                        _json = json,
                    )
                }
                "text" -> {
                    return ModerationMultiModalInput(
                        text = deserialize(node, jacksonTypeRef<ModerationTextInput>()),
                        _json = json,
                    )
                }
            }

            return ModerationMultiModalInput(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ModerationMultiModalInput>(ModerationMultiModalInput::class) {

        override fun serialize(
            value: ModerationMultiModalInput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.text != null -> generator.writeObject(value.text)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ModerationMultiModalInput")
            }
        }
    }
}
