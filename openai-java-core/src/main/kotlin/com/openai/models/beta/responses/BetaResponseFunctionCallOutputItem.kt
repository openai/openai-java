// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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

/** A piece of message content, such as text, an image, or a file. */
@JsonDeserialize(using = BetaResponseFunctionCallOutputItem.Deserializer::class)
@JsonSerialize(using = BetaResponseFunctionCallOutputItem.Serializer::class)
class BetaResponseFunctionCallOutputItem
private constructor(
    private val inputText: BetaResponseInputTextContent? = null,
    private val inputImage: BetaResponseInputImageContent? = null,
    private val inputFile: BetaResponseInputFileContent? = null,
    private val _json: JsonValue? = null,
) {

    /** A text input to the model. */
    fun inputText(): Optional<BetaResponseInputTextContent> = Optional.ofNullable(inputText)

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision)
     */
    fun inputImage(): Optional<BetaResponseInputImageContent> = Optional.ofNullable(inputImage)

    /** A file input to the model. */
    fun inputFile(): Optional<BetaResponseInputFileContent> = Optional.ofNullable(inputFile)

    fun isInputText(): Boolean = inputText != null

    fun isInputImage(): Boolean = inputImage != null

    fun isInputFile(): Boolean = inputFile != null

    /** A text input to the model. */
    fun asInputText(): BetaResponseInputTextContent = inputText.getOrThrow("inputText")

    /**
     * An image input to the model. Learn about
     * [image inputs](https://platform.openai.com/docs/guides/vision)
     */
    fun asInputImage(): BetaResponseInputImageContent = inputImage.getOrThrow("inputImage")

    /** A file input to the model. */
    fun asInputFile(): BetaResponseInputFileContent = inputFile.getOrThrow("inputFile")

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
     * Optional<String> result = betaResponseFunctionCallOutputItem.accept(new BetaResponseFunctionCallOutputItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitInputText(BetaResponseInputTextContent inputText) {
     *         return Optional.of(inputText.toString());
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
            inputText != null -> visitor.visitInputText(inputText)
            inputImage != null -> visitor.visitInputImage(inputImage)
            inputFile != null -> visitor.visitInputFile(inputFile)
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
    fun validate(): BetaResponseFunctionCallOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitInputText(inputText: BetaResponseInputTextContent) {
                    inputText.validate()
                }

                override fun visitInputImage(inputImage: BetaResponseInputImageContent) {
                    inputImage.validate()
                }

                override fun visitInputFile(inputFile: BetaResponseInputFileContent) {
                    inputFile.validate()
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
                override fun visitInputText(inputText: BetaResponseInputTextContent) =
                    inputText.validity()

                override fun visitInputImage(inputImage: BetaResponseInputImageContent) =
                    inputImage.validity()

                override fun visitInputFile(inputFile: BetaResponseInputFileContent) =
                    inputFile.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseFunctionCallOutputItem &&
            inputText == other.inputText &&
            inputImage == other.inputImage &&
            inputFile == other.inputFile
    }

    override fun hashCode(): Int = Objects.hash(inputText, inputImage, inputFile)

    override fun toString(): String =
        when {
            inputText != null -> "BetaResponseFunctionCallOutputItem{inputText=$inputText}"
            inputImage != null -> "BetaResponseFunctionCallOutputItem{inputImage=$inputImage}"
            inputFile != null -> "BetaResponseFunctionCallOutputItem{inputFile=$inputFile}"
            _json != null -> "BetaResponseFunctionCallOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponseFunctionCallOutputItem")
        }

    companion object {

        /** A text input to the model. */
        @JvmStatic
        fun ofInputText(inputText: BetaResponseInputTextContent) =
            BetaResponseFunctionCallOutputItem(inputText = inputText)

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision)
         */
        @JvmStatic
        fun ofInputImage(inputImage: BetaResponseInputImageContent) =
            BetaResponseFunctionCallOutputItem(inputImage = inputImage)

        /** A file input to the model. */
        @JvmStatic
        fun ofInputFile(inputFile: BetaResponseInputFileContent) =
            BetaResponseFunctionCallOutputItem(inputFile = inputFile)
    }

    /**
     * An interface that defines how to map each variant of [BetaResponseFunctionCallOutputItem] to
     * a value of type [T].
     */
    interface Visitor<out T> {

        /** A text input to the model. */
        fun visitInputText(inputText: BetaResponseInputTextContent): T

        /**
         * An image input to the model. Learn about
         * [image inputs](https://platform.openai.com/docs/guides/vision)
         */
        fun visitInputImage(inputImage: BetaResponseInputImageContent): T

        /** A file input to the model. */
        fun visitInputFile(inputFile: BetaResponseInputFileContent): T

        /**
         * Maps an unknown variant of [BetaResponseFunctionCallOutputItem] to a value of type [T].
         *
         * An instance of [BetaResponseFunctionCallOutputItem] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponseFunctionCallOutputItem: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<BetaResponseFunctionCallOutputItem>(
            BetaResponseFunctionCallOutputItem::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponseFunctionCallOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "input_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputTextContent>())
                        ?.let { BetaResponseFunctionCallOutputItem(inputText = it, _json = json) }
                        ?: BetaResponseFunctionCallOutputItem(_json = json)
                }
                "input_image" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputImageContent>())
                        ?.let { BetaResponseFunctionCallOutputItem(inputImage = it, _json = json) }
                        ?: BetaResponseFunctionCallOutputItem(_json = json)
                }
                "input_file" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseInputFileContent>())
                        ?.let { BetaResponseFunctionCallOutputItem(inputFile = it, _json = json) }
                        ?: BetaResponseFunctionCallOutputItem(_json = json)
                }
            }

            return BetaResponseFunctionCallOutputItem(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<BetaResponseFunctionCallOutputItem>(
            BetaResponseFunctionCallOutputItem::class
        ) {

        override fun serialize(
            value: BetaResponseFunctionCallOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.inputText != null -> generator.writeObject(value.inputText)
                value.inputImage != null -> generator.writeObject(value.inputImage)
                value.inputFile != null -> generator.writeObject(value.inputFile)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BetaResponseFunctionCallOutputItem")
            }
        }
    }
}
